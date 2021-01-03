package br.com.zup.initial.controller;

import br.com.zup.initial.domain.entity.Account;
import br.com.zup.initial.service.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("account")
public class AccountController {

    @Autowired
    private IAccountService iAccountService;

    @PostMapping("save")
    public ResponseEntity<Account> save(@Valid @RequestBody Account account) {
        return new ResponseEntity<>(iAccountService.save(account), HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<Account> update(@Valid @RequestBody Account account) {
        return new ResponseEntity<>(iAccountService.update(account), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        iAccountService.deleteById(id);
    }

    @GetMapping("find-one/{id}")
    public ResponseEntity<Optional<Account>> findOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(iAccountService.findById(id), HttpStatus.OK);
    }

    @GetMapping("find-all")
    public ResponseEntity<List<Account>> findAll() {
        return new ResponseEntity<>(iAccountService.findAll(), HttpStatus.OK);
    }

    @GetMapping("upgrade-per-age")
    public void upgradePerAge(@RequestParam("age") Integer age) {
        iAccountService.upgradeAccount(age);
    }

}
