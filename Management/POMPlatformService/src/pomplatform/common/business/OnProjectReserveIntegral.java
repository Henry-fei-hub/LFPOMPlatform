package pomplatform.common.business;

import com.pomplatform.db.bean.BaseProjectIntegralTransferRecord;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectIntegralTransferRecord;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 * 积分转移处理
 * @author lxf
 */
public class OnProjectReserveIntegral implements GenericProcessor {
    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        ThreadConnection.beginTransaction();
        BaseProjectIntegralTransferRecord bean = new BaseProjectIntegralTransferRecord();
        bean.setDataFromJSON(creteria);
        bean.setTransferDate(new Date());
        ProjectIntegralTransferRecord dao = new ProjectIntegralTransferRecord();
        dao.setDataFromBase(bean);
        dao.save();
        //修改目标项目的预留积分
        Project daos = new Project();
        daos.setProjectId(BaseHelpUtils.getIntValue(bean.getFromProjectId()));
        daos.load();
        daos.setReserveIntegral(daos.getReserveIntegral().subtract(bean.getTransferIntegral()));
        daos.update();
        //修改归属项目的预留积分
        daos.clear();
        daos.setProjectId(BaseHelpUtils.getIntValue(bean.getToProjectId()));
        daos.load();
        daos.setReserveIntegral(daos.getReserveIntegral().add(bean.getTransferIntegral()));
        daos.update();
        ThreadConnection.commit();
        return dao.generateBase().toOneLineJSON(0,null);
    }

}
