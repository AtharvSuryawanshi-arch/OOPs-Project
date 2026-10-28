// AuditLogRepository.java
package com.group.iitsm.repository;

import com.group.iitsm.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    List<AuditLog> findByIncidentIdOrderByTimestampAsc(Long incidentId);
}