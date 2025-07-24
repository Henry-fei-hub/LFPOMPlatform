package pomplatform.project.business;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectLog;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectLog;

import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.system.dao.Employee;

/**
 * 项目提交审核
 *
 * @author lxf
 */
public class ProjectSubmitAudit implements GenericProcessor {

    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        ThreadConnection.beginTransaction();
        //更新项目表审核状态及审核意见
        BaseProject bean = new BaseProject();
        bean.setDataFromJSON(creteria);
        Project dao = new Project();
        dao.setDataFromBase(bean);
        dao.update();
        dao.load();
        //获取项目名称
        String projectName = dao.getProjectName();
        int departmentManageId = dao.getDepartmentManagerId()==null?0:dao.getDepartmentManagerId();
        //获取项目经理姓名
        Employee e = new Employee();
        e.setEmployeeId(dao.getProjectManageId());
        e.load();
        String projectManageName = e.getEmployeeName();
        //插入项目日志
        BaseProjectLog bpl = new BaseProjectLog();
        bpl.setProjectId(dao.getProjectId());
        bpl.setManagerId(departmentManageId);
        bpl.setDesignPhase(dao.getDesignPhase());
        bpl.setOperateId(dao.getProjectManageId());
        bpl.setDepartmentId(dao.getDepartmentId());
        bpl.setOperateTime(new Date());
        bpl.setLogContent(String.format("%1$s 已提交 %2$s 的审核申请", projectManageName, projectName));
        bpl.setLogType(0);
        ProjectLog pl = new ProjectLog();
        pl.setDataFromBase(bpl);
        pl.save();
        ThreadConnection.commit();
        return bean.toOneLineJSON(0, null);
    }

}
