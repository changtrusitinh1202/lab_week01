package respositories;

import db.Connection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import models.Log;

public class LogRespository {
    private EntityManager em;

    public LogRespository(){
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }

    public boolean addALog(Log log){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(log);
            tr.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

    public boolean deleteLog(String id){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            em.remove(em.find(Log.class, id));
            tr.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

    public boolean updateLog(Log log){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            em.merge(log);
            tr.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

    public Log getLog(long id){
         return em.find(Log.class, id);
    }

}
