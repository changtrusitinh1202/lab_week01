package respositories;
import db.Connection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import models.Role;

public class RoleRespository {
    private EntityManager em;

    public RoleRespository(){
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }

    public boolean addRole(Role role){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(role);
            tr.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

    public boolean deleteRole(String id){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            em.remove(em.find(Role.class, id));
            tr.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

    public boolean updateRole(Role role){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            em.merge(role);
            tr.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

    public Role getRole(String id){
        return em.find(Role.class, id);
    }


}
