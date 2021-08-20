package com.cedricmube.usermanagement.repository;

import com.cedricmube.usermanagement.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
