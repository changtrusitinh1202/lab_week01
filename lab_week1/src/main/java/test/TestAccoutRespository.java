package test;

import models.Account;
import respositories.AccountRespository;
import services.AccountServices;

import java.util.List;

public class TestAccoutRespository {
    public static void main(String[] args) {
        AccountServices services = new AccountServices();
            //Account acc = new Account("meomeo");
      //  Account account = services.getAccount("huy");
        //System.out.println(services.getAccount("huy"));
//        List<Account> list = services.getAccountsService();
//        System.out.println(list.size());
//        for (Account account1 : list) {
           System.out.println(services.checkLogInService("huy@gmail.com","123"));
//        }

   }
}
