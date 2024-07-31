package org.example.SmartAssign.services;


import org.example.SmartAssign.dto.responses.PaginatedUsersResponse;
import org.example.SmartAssign.dto.responses.StatusMessageResponse;
import org.springframework.http.ResponseEntity;

public interface ISuperAdminService {
   ResponseEntity<PaginatedUsersResponse> getAllUsers(int page, int size, String keyword);
   ResponseEntity<StatusMessageResponse> toggleUserBanStatus(String email);
   ResponseEntity<StatusMessageResponse> toggleUserEnabledStatus(String email);
   ResponseEntity<StatusMessageResponse> addRoleToUser(String email, String role);
    ResponseEntity<StatusMessageResponse> removeRoleFromUser(String email, String role);
}
