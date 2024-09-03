package org.example.SmartAssign.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
    private String name;
    private String lastname;
    private String profileImage;
    private String gender;
    private String country;
    private Date birthDate;
    private String title;
    private String bio;
    private float score ;

    private List<String> skills = new ArrayList<>();
}
