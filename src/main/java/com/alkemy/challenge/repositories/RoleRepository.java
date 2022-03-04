package com.alkemy.challenge.repositories;

import java.util.Optional;

import com.alkemy.challenge.models.ERole;
import com.alkemy.challenge.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
