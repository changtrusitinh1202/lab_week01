package services;

import models.GrantAccess;
import respositories.GrantAccessResponsitory;

public class GrantAccessServices {
    private GrantAccessResponsitory grantAccessResponsitory;

    public GrantAccessServices(){
        this.grantAccessResponsitory = new GrantAccessResponsitory();
    }

    public boolean addGrantAccessService(GrantAccess grantAccess){
        return grantAccessResponsitory.addGrantAccess(grantAccess);
    }


    public GrantAccess searchGrantAccessByAccountIdService(String id){
        return grantAccessResponsitory.searchGrantAccessByAccountId(id);
    }
}
