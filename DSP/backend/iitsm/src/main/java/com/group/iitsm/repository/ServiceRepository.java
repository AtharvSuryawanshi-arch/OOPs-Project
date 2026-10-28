// ServiceRepository.java
package com.group.iitsm.repository;

import com.group.iitsm.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    Optional<Service> findByName(String name);
}