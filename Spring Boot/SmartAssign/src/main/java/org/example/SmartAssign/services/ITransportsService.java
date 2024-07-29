package org.example.SmartAssign.services;

import org.example.SmartAssign.models.Transports;

import java.util.List;

public interface ITransportsService {

    public List<Transports> retrieveAllTransports();

    public Transports retrieveTransport(String TransportsId);

    public Transports addTransports(Transports transports);

    public void removeTransports(String tansportsId);

    public Transports modifyTransports(Transports transports);
}
