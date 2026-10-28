// IncidentRepository.java
package com.group.iitsm.repository;

import com.group.iitsm.entity.Incident;
import com.group.iitsm.entity.IncidentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
    List<Incident> findByReporterId(Long reporterId);
    List<Incident> findByAssignedTechnicianId(Long technicianId);
    long countByAssignedTechnicianIdAndStatusNotIn(Long techId, List<IncidentStatus> terminal);
}