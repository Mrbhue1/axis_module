package com.iserveu.utility;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResp {
    private String code;
    private String subStatusCode;
    private String message;
    private Object container;
    private boolean retriable;

    public GenericResp(String code, String subStatusCode, String message, Object container) {
        this.code = code;
        this.subStatusCode = subStatusCode;
        this.message = message;
        this.container = container;
    }
}
