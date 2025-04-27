package org.ms.lab9.dto.requestDto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
