package org.example.SmartAssign.dto.responses;

import lombok.Data;
import org.example.SmartAssign.models.UserSecurity;

@Data
public class UserSecurityResponse {
    private boolean twoFactorAuthEnabled;
    private boolean enabled;
    private Boolean ban;

    public UserSecurityResponse(UserSecurity userSecurity) {
        this.twoFactorAuthEnabled = userSecurity.isTwoFactorAuthEnabled();
        this.enabled = userSecurity.isEnabled();
        this.ban = userSecurity.getBan();
    }
}
