package pomplatform.project.business;

import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectAttachment;
import com.pomplatform.db.dao.ProjectCost;
import com.pomplatform.db.dao.ProjectEmployee;
import com.pomplatform.db.dao.ProjectIntegralChangeRecord;
import com.pomplatform.db.dao.ProjectLog;
import com.pomplatform.db.dao.ProjectProgres;
import com.pomplatform.db.dao.ProjectSettlement;
import com.pomplatform.db.dao.ProjectSettlementDetail;
import com.pomplatform.db.dao.ProjectStage;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 * 项目删除
 * @author lxf
 */
public class ProjectDelete implements GenericProcessor {

    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        //删除项目表数据
        ThreadConnection.beginTransaction();
        BaseProject bean = new BaseProject();
        bean.setDataFromJSON(creteria);
        Project dao = new Project();
        //根据项目ID删除
        dao.setPrimaryKeyFromBase(bean);
        dao.delete();
        int projectId = BaseHelpUtils.getIntValue(dao.getProjectId());
        //删除项目成员
        ProjectEmployee pe = new ProjectEmployee();
        pe.setConditionProjectId("=", projectId);
        pe.conditionalDelete();
        //删除项目成本
        ProjectCost pc = new ProjectCost();
        pc.setConditionProjectId("=", projectId);
        pc.conditionalDelete();
        //删除项目日志
        ProjectLog pl = new ProjectLog();
        pl.setConditionProjectId("=", projectId);
        pl.conditionalDelete();
        //删除项目的项目附件
        ProjectAttachment pa = new ProjectAttachment();
        pa.setConditionProjectId("=", projectId);
        pa.conditionalDelete();
        //删除项目的积分调整记录
        ProjectIntegralChangeRecord picr = new ProjectIntegralChangeRecord();
        picr.setConditionProjectId("=", projectId);
        picr.conditionalDelete();
        //删除项目的进度表
        ProjectProgres pp = new ProjectProgres();
        pp.setConditionProjectId("=", projectId);
        pp.conditionalDelete();
        //删除项目结算明细表
        ProjectSettlementDetail psd = new ProjectSettlementDetail();
        psd.setConditionProjectId("=", projectId);
        psd.conditionalDelete();
        //删除项目结算记录表
        ProjectSettlement ps = new ProjectSettlement();
        ps.setConditionProjectId("=", projectId);
        ps.conditionalDelete();
        //删除项目阶段表
        ProjectStage psg = new ProjectStage();
        psg.setConditionProjectId("=", projectId);
        psg.conditionalDelete();
        ThreadConnection.commit();
        return bean.toOneLineJSON(0, null);
    }

}
