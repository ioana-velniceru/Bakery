package com.awbd.bakery.repositories.security;

import com.awbd.bakery.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}