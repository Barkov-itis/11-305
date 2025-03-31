package com.example.demo.dto;

import com.example.demo.models.Service;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class ServiceDto {
    private Long id;
    private String cost;
    private String name;
    private String date;

    public static ServiceDto of(Service service) {
        return ServiceDto.builder()
                .id(service.getServiceId())
                .name(service.getName())
                .cost(service.getCost())
                .date(service.getDate())
                .build();
    }

    public static List<ServiceDto> from(List<Service> services) {
        return services.stream()
                .map(ServiceDto::of)
                .collect(Collectors.toList());
    }
}
