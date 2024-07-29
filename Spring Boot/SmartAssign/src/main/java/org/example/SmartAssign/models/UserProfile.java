package org.example.SmartAssign.models;

import lombok.Data;

import java.util.Date;

@Data
public class UserProfile {
    private String name;
    private String lastname;
    private String profileImage;
    private Date birthDate;
    private String title;
    private String bio;
}
