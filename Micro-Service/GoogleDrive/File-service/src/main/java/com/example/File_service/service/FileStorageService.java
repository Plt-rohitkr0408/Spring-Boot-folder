package com.example.File_service.service;

import com.example.File_service.model.FileMetaData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FileStorageService {

    @Value("${file.storage.path}")
    private String storagePath;

    private Path rootLocation;
    private Path metaDataFiles;
    @Autowired
    private ObjectMapper objectMapper ;


    @PostConstruct
    public void init() throws IOException {
        rootLocation = Paths.get(storagePath);
        Files.createDirectories(rootLocation);
        metaDataFiles = rootLocation.resolve("meta.json");

        if(!Files.exists(metaDataFiles)){
            Files.createFile(metaDataFiles);
            Files.writeString(metaDataFiles, "[]");
        }
    }

    public FileMetaData store(MultipartFile file , String folderId) throws IOException {
        String id = UUID.randomUUID().toString();
        String name = file.getOriginalFilename();
        Path targetLocation = rootLocation.resolve(id+"_"+name);
        Files.copy(file.getInputStream(),targetLocation, StandardCopyOption.REPLACE_EXISTING);
        String contentType = file.getContentType();
        Long size = file.getSize();

        FileMetaData fileMetaData = new FileMetaData(
                id,
                name,
                targetLocation.toString(),
                folderId != null ? folderId : "root",
                size,
                contentType,
                System.currentTimeMillis(),
                System.currentTimeMillis()
        );

        SaveMetaData(fileMetaData);
        return fileMetaData;

    }


    private void SaveMetaData(FileMetaData fileMetaData) throws IOException {
        List<FileMetaData> allMetaData = new ArrayList<>(ListAllMetaData());
        allMetaData.add(fileMetaData);
        Files.writeString(metaDataFiles, new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(allMetaData));
    }

    private List<FileMetaData> ListAllMetaData() throws IOException {
        String content = Files.readString(metaDataFiles);
        return objectMapper.readValue(content, new TypeReference<List<FileMetaData>>() {
        });
    }


    public FileMetaData getMetaDataById(String id) throws IOException {
        FileMetaData fileMetaData = ListAllMetaData().stream()
                .filter(f-> f.getId().equals(id)).findFirst().orElse(null);
        return fileMetaData;
    }

    public Resource loadAsResource(String fileId) throws IOException{
        FileMetaData fileMetaData = getMetaDataById(fileId);
        if(fileMetaData == null){
            throw new IOException("File not found");
        }
        Path filePath = Path.of(fileMetaData.getPath());
        Resource resource = new UrlResource(filePath.toUri());
        if(resource.exists() &&  resource.isReadable()){
            return resource;
        }
        throw new IOException("Resource not found ");
    }

    public void deleteFilebyId(String id) throws IOException {
        FileMetaData fileMetaData =   getMetaDataById(id);
        if(fileMetaData == null){
            throw new IOException("File not found");
        }
        updateMetaData(id);
        Path filePath = Path.of(fileMetaData.getPath());
        Files.deleteIfExists(filePath);

    }

    public void updateMetaData(String id) throws IOException {
        List<FileMetaData> allMetaData = new ArrayList<>(ListAllMetaData());
        allMetaData.removeIf(f -> f.getId().equals(id));
        Files.writeString(metaDataFiles, new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(allMetaData));
    }



}
