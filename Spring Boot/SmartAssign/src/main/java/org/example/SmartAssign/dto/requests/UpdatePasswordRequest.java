package org.example.SmartAssign.dto.requests;

import lombok.Data;

@Data
public class UpdatePasswordRequest {
    private String password;
    private String newPassword;
}
