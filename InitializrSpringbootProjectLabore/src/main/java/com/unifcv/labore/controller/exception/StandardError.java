package com.unifcv.labore.controller.exception;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StandardError {

    private LocalDateTime timesstamp;

    private Integer status;

    private String error;

    private String path;
}
