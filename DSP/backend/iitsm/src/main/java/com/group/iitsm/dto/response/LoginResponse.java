package com.group.iitsm.dto.response;

public record LoginResponse(
        String token,
        String role,
        Long userId,
        String username,
        String fullName
) {}