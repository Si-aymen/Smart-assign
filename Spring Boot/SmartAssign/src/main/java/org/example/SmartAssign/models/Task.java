package org.example.SmartAssign.models;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tasks")
public class Task {

    private String id;
    private String name;
    private String description;
    private Status status  ;
    private Date finishDate;
    private String projectID ;
}
