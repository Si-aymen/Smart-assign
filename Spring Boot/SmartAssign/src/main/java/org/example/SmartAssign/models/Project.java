package org.example.SmartAssign.models;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
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

    @DBRef
    private List<Task> tasks =new ArrayList<Task>();

}
