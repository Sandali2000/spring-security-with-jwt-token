package com.trash2cashbackend.trash2cashbackend.utill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardResponse {

    private int code;
    private String message;
    private Object data;
}
