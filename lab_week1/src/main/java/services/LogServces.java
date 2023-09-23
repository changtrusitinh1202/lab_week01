package services;

import respositories.LogRespository;
import models.Log;
public class LogServces {
    private LogRespository logRespository;

    public LogServces(){
        this.logRespository = new LogRespository();
    }

    public boolean addLogService(Log log){
        return logRespository.addALog(log);
    }

    public boolean deleteLogService(String id){
        return logRespository.deleteLog(id);
    }

    public boolean updateAccountService(Log log){
        return logRespository.updateLog(log);
    }

    public Log getLogService(long id){
        return logRespository.getLog(id);
    }

}
