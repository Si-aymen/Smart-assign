package org.example.SmartAssign.controllers;

import lombok.AllArgsConstructor;

import org.example.SmartAssign.dto.responses.PaginatedUsersResponse;
import org.example.SmartAssign.dto.responses.StatusMessageResponse;
import org.example.SmartAssign.services.ISuperAdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/super-admin")
@AllArgsConstructor
@PreAuthorize("hasRole('SUPERADMIN')")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowedHeaders = "*", allowCredentials = "true")
public class SuperAdminController {
    private final ISuperAdminService superAdminService;
    @GetMapping("/users")
    public ResponseEntity<PaginatedUsersResponse> getUsersPaginated(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "keyword", required = false) String keyword)
    {
        return superAdminService.getAllUsers(page, size,keyword);
    }
    @GetMapping("/toggle-user-ban")
    public ResponseEntity<StatusMessageResponse> toggleUserBanStatus(@RequestParam String email) {
        return superAdminService.toggleUserBanStatus(email);
    }
    @GetMapping("/toggle-user-enabled")
    public ResponseEntity<StatusMessageResponse> toggleUserEnabledStatus(@RequestParam String email) {
        return superAdminService.toggleUserEnabledStatus(email);
    }
    @GetMapping("/add-role")
    public ResponseEntity<StatusMessageResponse> addRoleToUser(@RequestParam String email, @RequestParam String role) {
        return superAdminService.addRoleToUser(email, role);
    }
    @GetMapping("/remove-role")
    public ResponseEntity<StatusMessageResponse> removeRoleFromUser(@RequestParam String email, @RequestParam String role) {
        return superAdminService.removeRoleFromUser(email, role);
    }

    @GetMapping("/count/users")
    public Long GetNumberOfUsers() {
        return superAdminService.GetNumberOfusers();
    }
    @GetMapping("/count/Developers")
    public Long GetNumberOfDevelopers() {
        return superAdminService.GetNumberOfDevelopers();
    }
    @GetMapping("/count/Project_Manager")
    public Long GetNumberOfProjectManager() {
        return superAdminService.GetNumberOfPROJECT_MANAGERS();
    }
    @GetMapping("/count/Super_admin")
    public Long GetNumberOfSuperAdmin() {
        return superAdminService.GetNumberOfSuper_admin();
    }

}
