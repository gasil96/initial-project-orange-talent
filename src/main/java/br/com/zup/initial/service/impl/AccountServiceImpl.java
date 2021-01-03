package br.com.zup.initial.service.impl;

import br.com.zup.initial.domain.entity.Account;
import br.com.zup.initial.repository.AccountRepository;
import br.com.zup.initial.service.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account save(Account genericClass) {
        return accountRepository.save(genericClass);
    }

    @Override
    public Account update(Account genericClass) {
        return accountRepository.save(genericClass);
    }

    @Override
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public void closeAccount() {

    }
}
