package com.yourteam.iitsm;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PingController {

    private final JdbcTemplate jdbc;

    public PingController(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @GetMapping("/ping")
    public Map<String, String> ping() {
        String dbVersion = jdbc.queryForObject("SELECT version()", String.class);
        return Map.of("status", "ok", "database", dbVersion);
    }
}
