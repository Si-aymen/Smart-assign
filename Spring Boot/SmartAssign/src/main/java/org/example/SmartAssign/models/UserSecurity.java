package org.example.SmartAssign.models;

import lombok.Data;

@Data
public class UserSecurity {
    private String twoFactorAuthKey;
    private boolean twoFactorAuthEnabled = false;
    private boolean enabled = false;
    private Boolean ban = false;
    private boolean rememberMe = false;
}
