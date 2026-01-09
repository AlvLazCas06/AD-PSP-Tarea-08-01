package com.salesianostriana.tribici.repository;

import com.salesianostriana.tribici.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository
        extends JpaRepository<User, Long> {

    Optional<User> findByNumCardAndPin(String numCard, String pin);

}
