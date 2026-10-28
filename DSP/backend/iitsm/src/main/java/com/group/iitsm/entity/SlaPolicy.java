package com.group.iitsm.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sla_policies")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SlaPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 5)
    private Priority priority;

    /** Response time target in minutes. */
    @Column(nullable = false)
    private int responseTargetMinutes;

    /** Resolution time target in minutes. */
    @Column(nullable = false)
    private int resolutionTargetMinutes;
}