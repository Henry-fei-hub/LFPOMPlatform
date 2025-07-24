/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomplatform.hr.handler;

import delicacy.common.BaseCollection;
import delicacy.common.GenericQuery;
import pomplatform.employeenew.bean.BaseSemployeeNew;
import pomplatform.hr.bean.BaseSemployeeForHR;
import pomplatform.hr.bean.ConditionSemployeeForHR;
import static pomplatform.hr.handler.SemployeeForHRHandler.executeQuerySemployeeForHR;

/**
 *
 * @author guanxgun
 */
public class SemployeeForHRBiz implements GenericQuery {

    @Override
    public String find(String creteria) throws Exception {
        ConditionSemployeeForHR c = new ConditionSemployeeForHR();
        c.setDataFromJSON(creteria);
        BaseCollection<BaseSemployeeForHR> result = executeQuerySemployeeForHR(c, c.getKeyValues());
        result.getCollections().stream().forEach((BaseSemployeeForHR bmp) -> {
            int idx = -1;
            if ((idx = bmp.getPhoto().lastIndexOf("/images/photos")) >= 0) {
                bmp.setPhoto(bmp.getPhoto().substring(idx));
            } else {
                bmp.setPhoto("/images/photos/".concat(bmp.getPhoto()));
            }
        });
        return result.toJSON(null);
    }

}
