package com.sangvaleap.lab8.model.api;

import lombok.Data;

@Data
public class AuthRequest {

    private String email;
    private String password;
}
