package br.com.zup.initial.service.impl;

import br.com.zup.initial.domain.entity.Account;
import br.com.zup.initial.repository.AccountRepository;
import br.com.zup.initial.service.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account save(Account genericClass) {
        genericClass.setPremiumAccount(false);
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
    public void upgradeAccount(Integer age) {
        this.upgradeAllAccounts(this.findAll().stream()
                .filter(x -> LocalDate.now().getYear() - x.getDataNascimento().getYear() == age)
                .collect(Collectors.toList()));
    }

    public void upgradeAllAccounts(List<Account> accounts) {
        for (Account account : accounts) {
            this.findById(account.getId()).ifPresent(
                    acc -> {
                        acc.setPremiumAccount(true);
                        this.update(acc);
                    }
            );
        }
    }


}
