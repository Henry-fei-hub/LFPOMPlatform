package pomplatform.common.business;

import com.pomplatform.db.bean.BaseProjectIntegralChangeRecord;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectIntegralChangeRecord;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 * 项目积分调整(将项目的预留积分转移到项目积分)
 * @author lxf
 */
public class OnSetProjectIntegralChange implements GenericProcessor {
    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        ThreadConnection.beginTransaction();
        BaseProjectIntegralChangeRecord bean = new BaseProjectIntegralChangeRecord();
        bean.setDataFromJSON(creteria);
        bean.setTransferDate(new Date());
        ProjectIntegralChangeRecord dao = new ProjectIntegralChangeRecord();
        dao.setDataFromBase(bean);
        dao.save();
        //更像该项目的项目积分和预留积分
        Project daos = new Project();
        daos.setProjectId(BaseHelpUtils.getIntValue(bean.getProjectId()));
        daos.load();
        daos.setProjectIntegral(bean.getAfterProjectIntegral());
        daos.setReserveIntegral(bean.getAfterReserveIntegral());
        daos.update();
        ThreadConnection.commit();
        return dao.generateBase().toOneLineJSON(0,null);
    }

}
