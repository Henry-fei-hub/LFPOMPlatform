package pomplatform.contractInfo.handler;

import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseSubContract;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.SubContract;
import com.pomplatform.db.handler.ContractHandler;
import delicacy.common.BaseHelpUtils;
import delicacy.connection.ThreadConnection;
import java.util.List;

public class ContractInfoUpdateHandler extends ContractHandler {

    @Override
    public String update(String json) throws Exception {
        BaseContract bean = new BaseContract();
        bean.setDataFromJSON(json);
        Contract dao = new Contract();
        dao.setPrimaryKeyFromBase(bean);
        int num = 0;
        if (dao.load()) {
            ThreadConnection.beginTransaction();
            String oldProjectCode = dao.getProjectCode();
            String newProjectCode = bean.getProjectCode();
            SubContract subDao = new SubContract();
            subDao.setConditionParentId("=", dao.getContractId());
            List<BaseSubContract> list = subDao.conditionalLoad();
            if (!BaseHelpUtils.isNullOrEmpty(list)) {
                for (BaseSubContract sub : list) {
                    subDao.clear();
                    subDao.setPrimaryKeyFromBase(sub);
                    if ((!BaseHelpUtils.isNullOrEmpty(dao.getProjectCode()) && !BaseHelpUtils.isNullOrEmpty(bean.getProjectCode()) && !dao.getProjectCode().equals(bean.getProjectCode()))) {
                        subDao.setProjectCode(bean.getProjectCode());
                    }
                    if (!BaseHelpUtils.isNullOrEmpty(dao.getContractCode()) && !BaseHelpUtils.isNullOrEmpty(bean.getContractCode()) && !dao.getContractCode().equals(bean.getContractCode())) {
                        subDao.setSubContractCode(bean.getContractCode() + sub.getSubContractCode().substring(sub.getSubContractCode().indexOf("-")));
                    }
                    subDao.update();
                }
            }
            if (!BaseHelpUtils.isNullOrEmpty(oldProjectCode) && !BaseHelpUtils.isNullOrEmpty(newProjectCode) && !oldProjectCode.equals(newProjectCode)) {
                MainProject mainDao = new MainProject();
                mainDao.setConditionProjectCode("=", newProjectCode);
                mainDao.setHasContract(true);
                mainDao.conditionalUpdate();
                Contract conDao = new Contract();
                conDao.setConditionProjectCode("=", oldProjectCode);
                conDao.setConditionContractId("<>", dao.getContractId());
                mainDao.clear();
                if (!BaseHelpUtils.isNullOrEmpty(conDao.conditionalLoad())) {
                    mainDao.setConditionProjectCode("=", oldProjectCode);
                    mainDao.setHasContract(true);
                    mainDao.conditionalUpdate();
                } else {
                    mainDao.setConditionProjectCode("=", oldProjectCode);
                    mainDao.setHasContract(false);
                    mainDao.conditionalUpdate();
                }
            }
            dao.setDataFromBase(bean);
            num = dao.update();
            ThreadConnection.commit();
        }
        return bean.toOneLineJSON(num, null);
    }
}
