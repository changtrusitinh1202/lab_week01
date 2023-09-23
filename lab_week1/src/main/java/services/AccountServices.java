package services;

import models.Account;
import respositories.AccountRespository;

import java.util.List;

public class AccountServices {
    private AccountRespository accountRespository;

    public AccountServices(){
        this.accountRespository = new AccountRespository();
    }
    public List<Account> getAccountsService(){
        return accountRespository.getAccounts();
    }

    public boolean addAccountService(Account account){
        return accountRespository.addAccount(account);
    }

    public boolean deleteAccountService(String id){
        return accountRespository.deleteAccount(id);
    }

    public boolean updateAccountService(Account account){
        return accountRespository.updateAccount(account);
    }

    public Account getAccountService(String id){
        return accountRespository.getAccount(id);
    }

    public Account checkLogInService(String email, String password){
        return accountRespository.checkLogIn(email,password);
    }

}
