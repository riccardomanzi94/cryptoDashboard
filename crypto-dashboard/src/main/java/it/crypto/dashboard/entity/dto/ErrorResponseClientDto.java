package it.crypto.dashboard.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class ErrorResponseClientDto implements Serializable {

    private static final long serialVersionUID = 3266588068754540710L;

    private String message;
    private List<String> details;
}
