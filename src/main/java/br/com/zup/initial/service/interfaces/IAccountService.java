package br.com.zup.initial.service.interfaces;

import br.com.zup.initial.domain.entity.Account;
import br.com.zup.initial.service.ICrudDefault;

public interface IAccountService extends ICrudDefault<Account> {

    void upgradeAccount(Integer age);

}
