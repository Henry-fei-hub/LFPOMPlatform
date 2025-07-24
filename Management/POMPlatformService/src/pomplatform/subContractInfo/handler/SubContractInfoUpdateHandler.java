package pomplatform.subContractInfo.handler;

import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseSubContract;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.SubContract;
import com.pomplatform.db.handler.ContractHandler;
import delicacy.connection.ThreadConnection;

public class SubContractInfoUpdateHandler extends ContractHandler {

    @Override
    public String update(String json) throws Exception {
        BaseSubContract bean = new BaseSubContract();
        bean.setDataFromJSON(json);
//        SubContract dao = new SubContract();
//        dao.setPrimaryKeyFromBase(bean);
        int num = 0;
//        if (dao.load()) {
//            ThreadConnection.beginTransaction();
//            if (!dao.getProjectCode().equals(bean.getProjectCode())) {//如果修改了主合同的项目编号，则将其对应的子合同的项目编号也修改过来
//                SubContract subDao = new SubContract();
//                subDao.setConditionParentId("=", dao.getContractId());
//                subDao.setProjectCode(bean.getProjectCode());
//                subDao.conditionalUpdate();
//            }
//            dao.setDataFromBase(bean);
//            num = dao.update();
//            ThreadConnection.commit();
//        }
        return bean.toOneLineJSON(num, null);
    }
}
