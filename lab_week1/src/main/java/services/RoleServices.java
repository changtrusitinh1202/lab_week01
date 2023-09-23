package services;

import models.Role;
import respositories.RoleRespository;

import java.util.List;

public class RoleServices {
    private RoleRespository roleRespository;

    public RoleServices(){
        this.roleRespository = new RoleRespository();
    }

    public boolean addRoleService(Role role){
        return roleRespository.addRole(role);
    }

    public boolean deleteRoleService(String id){
        return roleRespository.deleteRole(id);
    }

    public boolean updateRoleService(Role role){
        return roleRespository.updateRole(role);
    }

}
