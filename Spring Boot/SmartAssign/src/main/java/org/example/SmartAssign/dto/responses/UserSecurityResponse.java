package org.example.SmartAssign.dto.responses;

import lombok.Data;
import org.example.SmartAssign.models.UserSecurity;

@Data
public class UserSecurityResponse {
    private boolean twoFactorAuthEnabled;

    public UserSecurityResponse(UserSecurity userSecurity) {
        this.twoFactorAuthEnabled = userSecurity.isTwoFactorAuthEnabled();
    }
}
