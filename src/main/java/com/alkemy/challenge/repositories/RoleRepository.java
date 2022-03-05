package com.alkemy.challenge.repositories;

import java.util.Optional;

import com.alkemy.challenge.models.User.ERole;
import com.alkemy.challenge.models.User.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
