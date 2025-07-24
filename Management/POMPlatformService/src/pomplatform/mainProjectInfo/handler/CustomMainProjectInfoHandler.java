package pomplatform.mainProjectInfo.handler;

import com.pomplatform.db.bean.BaseClient;
import com.pomplatform.db.bean.BaseMainProject;
import com.pomplatform.db.dao.Client;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.SubContract;
import com.pomplatform.db.handler.MainProjectHandler;
import delicacy.common.BaseHelpUtils;
import delicacy.connection.ThreadConnection;
import org.apache.log4j.Logger;

public class CustomMainProjectInfoHandler extends MainProjectHandler{

	private static final Logger __logger = Logger.getLogger(CustomMainProjectInfoHandler.class);

    @Override
    public String update(String json) throws Exception {
        BaseMainProject bean = new BaseMainProject();
        bean.setDataFromJSON(json);
        MainProject dao = new MainProject();
        dao.setPrimaryKeyFromBase(bean);
        int num = 0;
        ThreadConnection.beginTransaction();
        if (dao.load()) {
            String oldProjectCode = dao.getProjectCode();
            String newProjectCode = bean.getProjectCode();
            if (!BaseHelpUtils.isNullOrEmpty(oldProjectCode) && !BaseHelpUtils.isNullOrEmpty(newProjectCode) && !oldProjectCode.equals(newProjectCode)) {
                //因为项目编号是唯一的，所以修改了项目编号，则相关联的合同、子合同、小项目中的项目编号都要改变
                Contract conDao = new Contract();
                conDao.setConditionProjectCode("=", oldProjectCode);
                conDao.setProjectCode(newProjectCode);
                conDao.conditionalUpdate();
                SubContract subDao = new SubContract();
                subDao.setConditionProjectCode("=", oldProjectCode);
                subDao.setProjectCode(newProjectCode);
                subDao.conditionalUpdate();
                Project proDao = new Project();
                proDao.setConditionProjectCode("=", oldProjectCode);
                proDao.setProjectCode(newProjectCode);
                proDao.conditionalUpdate();
            }
            dao.setDataFromBase(bean);
            num = dao.update();
            Client cDao = new Client();
            BaseClient cBean = new BaseClient();
            cBean.setDataFromJSON(json);
            cDao.setPrimaryKeyFromBase(cBean);
            if(cDao.load()){
                BaseClient sd = cDao.generateBase();
                cDao.setDataFromBase(cBean);
                cDao.update();
            }
        }
        ThreadConnection.commit();
        return bean.toOneLineJSON(num, null);
    }
}


