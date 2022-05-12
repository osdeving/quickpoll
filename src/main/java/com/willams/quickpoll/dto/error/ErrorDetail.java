package com.willams.quickpoll.dto.error;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ErrorDetail {
    private String title;
    private int status;
    private String detail;
    private long timestamp;
    private String developerMessage;
    private Map<String, List<ValidationError>> errors = new HashMap<>();
}
