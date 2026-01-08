package com.salesianostriana.tribici;

import com.salesianostriana.tribici.model.User;
import com.salesianostriana.tribici.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final UserRepository userRepository;

    @PostConstruct
    public void run() {
        User user = User.builder()
                .name("")
                .numCard("")
                .pin("")
                .balance(new BigDecimal(0))
                .build();
        userRepository.save(user);
    }

}
