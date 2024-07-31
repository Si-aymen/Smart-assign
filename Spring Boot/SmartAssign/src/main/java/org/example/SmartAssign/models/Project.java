package org.example.SmartAssign.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "projects")
public class Project {
    private String id;
    private String name;
    private String description;
    private Domain domain ;
    private Status status  ;
    private Date startDate;
    private Date endDate;

}
