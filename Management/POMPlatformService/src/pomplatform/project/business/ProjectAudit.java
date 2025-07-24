package pomplatform.project.business;

import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectLog;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectLog;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.common.HttpRequestUtils;
import delicacy.connection.ThreadConnection;
import delicacy.system.dao.Employee;

/**
 * 项目审核
 *
 * @author lxf
 */
public class ProjectAudit implements GenericProcessor {

    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        ThreadConnection.beginTransaction();
        //更新项目表审核状态及审核意见
        String semployeeId = HttpRequestUtils.getUserId(request);
        if(semployeeId == null) throw new SQLException("There are no user login in");
        int employeeId = BaseHelpUtils.getIntValue(semployeeId);
        BaseProject bean = new BaseProject();
        bean.setDataFromJSON(creteria);
        Project dao = new Project();
        dao.setDataFromBase(bean);
        dao.setDepartmentManagerId(employeeId);
        dao.update();
        dao.load();
        int status = bean.getStatus();
        String auditReason = bean.getAuditReason();
        //获取项目名称
        String projectName = dao.getProjectName();
        //获取板块运营负责人姓名
        Employee e = new Employee();
        e.setEmployeeId(employeeId);
        e.load();
        String projectManageName = e.getEmployeeName();
        // 写入项目日志，加上事物
        BaseProjectLog bpl = new BaseProjectLog();
        bpl.setProjectId(dao.getProjectId());
        bpl.setManagerId(employeeId);
        bpl.setDesignPhase(dao.getDesignPhase());
        bpl.setOperateId(employeeId);
        bpl.setDepartmentId(dao.getDepartmentId());
        bpl.setOperateTime(new Date());
        switch(status){
            case 2:
                bpl.setLogContent(String.format("%1$s 已审核通过了 %2$s ,审核原因：%3$s", projectManageName, projectName,auditReason));  
                break;
            case 0:
                bpl.setLogContent(String.format("%1$s 已驳回了 %2$s ,驳回原因：%3$s", projectManageName, projectName,auditReason));
                break;
            default:
                break;
        }
        bpl.setLogType(0);
        ProjectLog pl = new ProjectLog();
        pl.setDataFromBase(bpl);
        pl.save();
        ThreadConnection.commit();
        return bean.toOneLineJSON(0, null);
    }

}
