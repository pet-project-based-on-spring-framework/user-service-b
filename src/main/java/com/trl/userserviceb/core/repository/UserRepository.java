package com.trl.userserviceb.core.repository;

import com.trl.userserviceb.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
