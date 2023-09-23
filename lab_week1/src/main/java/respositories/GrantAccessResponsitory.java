package respositories;

import db.Connection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import models.Account;
import models.GrantAccess;

import java.util.List;

public class GrantAccessResponsitory {
    private EntityManager em;

    public  GrantAccessResponsitory(){
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }

    public boolean addGrantAccess(GrantAccess grantAccess){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(grantAccess);
            tr.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

    public GrantAccess searchGrantAccessByAccountId(String id){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            String sql = "SELECT  * FROM grant_access WHERE account_id=\""+id+"\"";
            List<GrantAccess> grantAccesses=em.createNativeQuery(sql, GrantAccess.class).getResultList();
            tr.commit();
            return grantAccesses.get(0);
        } catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return null;
    }

}
