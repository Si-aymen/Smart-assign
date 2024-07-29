package org.example.SmartAssign.serviceImpls;

import lombok.extern.slf4j.Slf4j;
import org.example.SmartAssign.models.Transports;
import org.example.SmartAssign.repositories.TransportsRepository;
import org.example.SmartAssign.services.ITransportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TransportsService implements ITransportsService {

    @Autowired
    private TransportsRepository transportsRepository;
    @Override
    public List<Transports> retrieveAllTransports() {
        return transportsRepository.findAll() ;
    }

    @Override
    public Transports retrieveTransport(String BlocId) {
        return transportsRepository.findById(BlocId).get();
    }

    @Override
    public Transports addTransports(Transports c) {
        return transportsRepository.save(c);
    }

    @Override
    public void removeTransports(String BlocId) {
        transportsRepository.deleteById(BlocId);

    }

    @Override
    public Transports modifyTransports(Transports transports) {
        return null;
    }
}
