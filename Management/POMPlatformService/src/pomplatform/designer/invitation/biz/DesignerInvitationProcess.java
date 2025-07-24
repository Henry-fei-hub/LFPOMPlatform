package pomplatform.designer.invitation.biz;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectEmployee;
import com.pomplatform.db.dao.ProjectLog;

import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.system.dao.Employee;
import pomplatform.designer.invitation.bean.BaseMprojectemployeepor;

/**
 *
 * @author guanxgun
 */
public class DesignerInvitationProcess implements GenericProcessor {

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        BaseMprojectemployeepor bean = new BaseMprojectemployeepor();
        bean.setDataFromJSON(creteria);
        ThreadConnection.beginTransaction();
        ProjectEmployee dao = new ProjectEmployee();
        dao.setProjectEmployeeId(bean.getProjectEmployeeId());
        if(dao.load()){
            dao.setStatus(1);
            dao.update();
            // 写入项目日志
            Employee e = new Employee();
            e.setEmployeeId(dao.getEmployeeId());
            e.load();
            String designerName = e.getEmployeeName();
           
            Project p = new Project();
            p.setProjectId(dao.getProjectId());
            p.load();
            e.setEmployeeId(p.getProjectManageId());
            e.load();
            ProjectLog pl = new ProjectLog();
            pl.setProjectId(dao.getProjectId());
            pl.setOperateId(dao.getEmployeeId());
            pl.setOperateTime(new Date());
            pl.setDepartmentId(p.getDepartmentId());
            pl.setManagerId(p.getProjectManageId());
            pl.setDesignPhase(p.getDesignPhase());
            pl.setLogContent(String.format("%1$s接受了%2$s %3$s的邀请", designerName, e.getEmployeeName(),p.getProjectName()));
            pl.save();
        }
        ThreadConnection.commit();
        return bean.toOneLineJSON(0, null);
    }
    
}
