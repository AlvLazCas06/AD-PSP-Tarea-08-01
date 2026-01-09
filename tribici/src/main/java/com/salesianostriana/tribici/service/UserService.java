package com.salesianostriana.tribici.service;

import com.salesianostriana.tribici.model.User;
import com.salesianostriana.tribici.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> autenticate(String numCard, String pin) {
        return userRepository.findByNumCardAndPin(numCard, pin);
    }

    public void updateBalance(User user, double cuantityDecrease) {
        user.setBalance(new BigDecimal(user.getBalance().doubleValue() - cuantityDecrease));
        userRepository.save(user);
    }

}
