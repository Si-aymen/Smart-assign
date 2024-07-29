package org.example.SmartAssign.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "transports")
public class Transports {
    @MongoId
    private String id;
    private String departure;
    private String destination;
    private String time;


}
