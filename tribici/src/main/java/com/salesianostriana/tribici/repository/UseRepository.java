package com.salesianostriana.tribici.repository;

import com.salesianostriana.tribici.model.Use;
import com.salesianostriana.tribici.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UseRepository
        extends JpaRepository<Use, Long> {

    /*@Query("""
            select u
            from Use u
            where u
            """)*/
    Optional<Use> findFirstByUserOrderByStartDateDesc(User user);

    Page<Use> findByUserId(Long id, Pageable pageable);

}
