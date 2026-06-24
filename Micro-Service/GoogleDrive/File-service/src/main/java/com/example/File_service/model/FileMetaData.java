package com.example.File_service.model;

public class FileMetaData {
    private String id;
    private String name;
    private String path;
    private String folderId;
    private Long size;
    private String contentType;
    private Long createAt;
    private Long updateAt;

    public FileMetaData() {
    }

    public FileMetaData(String id, String name, String path, String folderId, Long size, String contentType, Long createAt, Long updateAt) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.folderId = folderId;
        this.size = size;
        this.contentType = contentType;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }
}
