package com.example.hakaton.Repository;

import com.example.hakaton.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findById(Long id);
    Optional<User> findByCelular(String celular);

    Optional<User> findByCorreo(String correo);


    boolean existsById(Long id);

    void deleteById(Long id);

    Optional<User> findByCedulaAndTipoCedula(String cedula, String tipoCedula);
}