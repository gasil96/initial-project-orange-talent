package br.com.zup.initial.service;

import java.util.List;
import java.util.Optional;

public interface ICrudDefault<Z> {

    Z save(Z genericClass);

    Z update(Z genericClass);

    void deleteById(Long id);

    Optional<Z> findById(Long id);

    List<Z> findAll();
}
