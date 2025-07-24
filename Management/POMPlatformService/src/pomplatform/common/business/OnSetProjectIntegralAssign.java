package pomplatform.common.business;

import com.pomplatform.db.bean.BaseProjectIntegralAssignRecord;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectIntegralAssignRecord;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 * 项目积分发放(将项目的预留积分转移指定的板块总监)
 * @author lxf
 */
public class OnSetProjectIntegralAssign implements GenericProcessor {
    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        ThreadConnection.beginTransaction();
        BaseProjectIntegralAssignRecord bean = new BaseProjectIntegralAssignRecord();
        bean.setDataFromJSON(creteria);
        bean.setAssignDate(new Date());
        ProjectIntegralAssignRecord dao = new ProjectIntegralAssignRecord();
        dao.setDataFromBase(bean);
        //更新该项目的预留积分
        Project projectDao = new Project();
        projectDao.setProjectId(BaseHelpUtils.getIntValue(bean.getProjectId()));
        projectDao.load();
        dao.setBeforeReserveIntegral(projectDao.getReserveIntegral());//发放前的预留积分总数
        dao.setAfterReserveIntegral(projectDao.getReserveIntegral().subtract(dao.getAssignIntegral()));//发放后的预留积分总数
        dao.save();
        projectDao.setReserveIntegral(dao.getAfterReserveIntegral());
        projectDao.update();
        ThreadConnection.commit();
        return dao.generateBase().toOneLineJSON(0,null);
    }

}
