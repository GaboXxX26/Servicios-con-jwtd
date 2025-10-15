package com.test.ecuservicies.system.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "systems")
public class EcuSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long system_id;

    private String name ;
    private String description;
    private String token;
    private LocalDateTime last_connection;

    @PreUpdate
    protected void onUpdate() {
        last_connection = LocalDateTime.now();
    }
    
    @ManyToMany(mappedBy = "systems")
    private java.util.Set<com.test.ecuservicies.user.model.User> users;
}
