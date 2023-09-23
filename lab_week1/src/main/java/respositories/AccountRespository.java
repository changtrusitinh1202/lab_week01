package respositories;

import db.Connection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import models.Account;

import java.util.List;

public class AccountRespository {
    private EntityManager em;

    public AccountRespository(){
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }

    public boolean addAccount(Account account){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(account);
            tr.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

    public boolean deleteAccount(String id){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            em.remove(em.find(Account.class, id));
            tr.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

    public boolean updateAccount(Account account){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            em.merge(account);
            tr.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

    public Account getAccount(String id){
        return em.find(Account.class, id);
    }

    public List<Account> getAccounts(){
        return em.createQuery("SELECT a FROM Account a").getResultList();
    }


    public Account checkLogIn(String email, String password){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            String sql = "select a from Account a where email = ?1 and password =?2";
            Account account = em.createQuery(sql, Account.class).setParameter(1, email).setParameter(2, password).getSingleResult();
            tr.commit();
            return account;
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return null;
    }

}
