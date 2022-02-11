package com.demico.customers.customers.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private LocalDateTime localDateTime;
    private Integer statusCode;
    private HttpStatus httpStatus;
    private String message;
    private List<?> data;
}
