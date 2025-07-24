package pomplatform.employeenew.handler;

import delicacy.common.BaseCollection;
import delicacy.common.GenericQuery;
import pomplatform.employeenew.bean.BaseSemployeeNew;
import pomplatform.employeenew.bean.ConditionSemployeeNew;
import static pomplatform.employeenew.handler.SemployeeNewHandler.executeQuerySemployeeNew;

/**
 *
 * @author guangxun
 */
public class SemployeeNewBiz implements GenericQuery {

    @Override
    public String find(String creteria) throws Exception {
        ConditionSemployeeNew c = new ConditionSemployeeNew();
        c.setDataFromJSON(creteria);
        BaseCollection<BaseSemployeeNew> result = executeQuerySemployeeNew(c, c.getKeyValues());
//        result.getCollections().stream().forEach((BaseSemployeeNew bmp) -> {
//            int idx = -1;
//            if ((idx = bmp.getPhoto().lastIndexOf("/images/photos")) >= 0) {
//                bmp.setPhoto(bmp.getPhoto().substring(idx));
//            } else {
//                bmp.setPhoto("/images/photos/".concat(bmp.getPhoto()));
//            }
//        });
        return result.toJSON(null);
    }

}
