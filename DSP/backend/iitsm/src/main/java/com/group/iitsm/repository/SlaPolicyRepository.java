// SlaPolicyRepository.java
package com.group.iitsm.repository;

import com.group.iitsm.entity.SlaPolicy;
import com.group.iitsm.entity.Priority;
import com.group.iitsm.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SlaPolicyRepository extends JpaRepository<SlaPolicy, Long> {
    Optional<SlaPolicy> findByServiceAndPriority(Service service, Priority priority);
}