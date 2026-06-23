package com.example.JobPortalProject.dto;

import com.example.JobPortalProject.enums.Role;
import lombok.Data;

@Data
public class RegisteRequest {
    private String username;
    private String email;
    private String password;
    private Role role;


}
