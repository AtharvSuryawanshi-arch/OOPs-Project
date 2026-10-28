package com.group.iitsm.config;

import com.group.iitsm.entity.Role;
import com.group.iitsm.entity.User;
import com.group.iitsm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (userRepository.count() > 0) return;

        userRepository.save(User.builder()
                .username("admin")
                .email("admin@iitsm.local")
                .password(passwordEncoder.encode("admin123"))
                .fullName("System Administrator")
                .role(Role.ADMIN)
                .enabled(true)
                .build());

        userRepository.save(User.builder()
                .username("tech1")
                .email("tech1@iitsm.local")
                .password(passwordEncoder.encode("tech123"))
                .fullName("Alice Technician")
                .role(Role.TECHNICIAN)
                .enabled(true)
                .skills(Set.of("NETWORK", "DATABASE", "CLOUD"))
                .build());

        userRepository.save(User.builder()
                .username("employee1")
                .email("employee1@iitsm.local")
                .password(passwordEncoder.encode("emp123"))
                .fullName("Bob Employee")
                .role(Role.EMPLOYEE)
                .enabled(true)
                .build());

        System.out.println(">> Seeded users: admin/admin123, tech1/tech123, employee1/emp123");
    }
}       