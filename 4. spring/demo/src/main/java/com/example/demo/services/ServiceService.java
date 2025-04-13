package com.example.demo.services;

import com.example.demo.dto.ServiceDto;
import com.example.demo.dto.ServiceForm;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface ServiceService {
    ServiceDto addService(ServiceForm serviceForm);
    List<ServiceDto> search (Integer size, Integer page, String query, String sort, String direction);

    public Long countService();
}
