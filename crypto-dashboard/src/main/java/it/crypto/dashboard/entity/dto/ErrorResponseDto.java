package it.crypto.dashboard.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ErrorResponseDto implements Serializable {

    private static final long serialVersionUID = 4755783225334059412L;

    private Integer code;
    private String message;
}
