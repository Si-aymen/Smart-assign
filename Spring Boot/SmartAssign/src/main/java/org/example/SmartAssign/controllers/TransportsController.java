package org.example.SmartAssign.controllers;


import lombok.AllArgsConstructor;
import org.example.SmartAssign.models.Transports;
import org.example.SmartAssign.services.ITransportsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transports")
@AllArgsConstructor
@PreAuthorize("permitAll()")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowedHeaders = "*", allowCredentials = "true")

public class TransportsController {
    ITransportsService transportsService ;

    @GetMapping("/GetAll/transports")
    public List<Transports> getBlocs() {
        List<Transports> listTransports = transportsService.retrieveAllTransports();
        return listTransports;
    }


    @PostMapping("/add-Bloc")
    public Transports addBloc(@RequestBody Transports transports) {
        Transports transports1 = transportsService.addTransports(transports);
        return transports1;
    }
}
