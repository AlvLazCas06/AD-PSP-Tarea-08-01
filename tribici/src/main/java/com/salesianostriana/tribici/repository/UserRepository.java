package com.salesianostriana.tribici.repository;

import com.salesianostriana.tribici.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User, Long> {
}
