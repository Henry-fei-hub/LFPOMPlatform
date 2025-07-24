
package com.pomplatform.db.handler;

import com.pomplatform.db.bean.BaseClient;
import com.pomplatform.db.bean.BaseMainProjectClient;
import com.pomplatform.db.dao.Client;
import com.pomplatform.db.dao.MainProjectClient;

import delicacy.connection.ThreadConnection;

public class SaveClientAndMainProjectClientHandler extends ContractHandler {

    @Override
    public String save(String json) throws Exception {
        ThreadConnection.beginTransaction();
        BaseClient baseClient = new BaseClient();
        baseClient.setDataFromJSON(json);
        Client clientDao = new Client();
        clientDao.setDataFromBase(baseClient);
        clientDao.save();
        BaseMainProjectClient base = new BaseMainProjectClient();
        base.setDataFromJSON(json);
        MainProjectClient dao = new MainProjectClient();
        dao.setDataFromBase(base);
        dao.setClientId(clientDao.getClientId());
        dao.save();
        ThreadConnection.commit();
        return json;
    }
    
}
