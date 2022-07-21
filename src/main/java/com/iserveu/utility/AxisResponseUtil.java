package com.iserveu.utility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AxisResponseUtil {

    private String code;
    private String subStatusCode;
    private String message;
    private Object container;
    private boolean retriable;
}
