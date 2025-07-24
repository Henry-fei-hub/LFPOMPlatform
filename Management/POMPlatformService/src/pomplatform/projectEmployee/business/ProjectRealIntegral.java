package pomplatform.projectEmployee.business;

import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectEmployee;
import com.pomplatform.db.dao.ProjectLog;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.common.HttpRequestUtils;
import delicacy.connection.ThreadConnection;
import delicacy.system.dao.Employee;

/**
 * 分配积分
 *
 * @author lxf
 */
public class ProjectRealIntegral implements GenericProcessor {

    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        ThreadConnection.beginTransaction();
        //更新团队职员数据
        BaseProjectEmployee bean = new BaseProjectEmployee();
        bean.setDataFromJSON(creteria);
        bean.setStatus(2);//释放成员状态
        ProjectEmployee dao = new ProjectEmployee();
        dao.setPrimaryKeyFromBase(bean);
        if(dao.load()) {
            dao.setDataFromBase(bean);
            dao.update();
        }
        else throw new SQLException("没有找到该人员信息");
        
        //获取项目名称
        Project p = new Project();
        p.setProjectId(dao.getProjectId());
        p.load();
        String projectName = p.getProjectName();
        //获取当前登录项目负责人id
        String loginEmployeeId = HttpRequestUtils.getUserId(request);
        if (loginEmployeeId == null) {
            throw new SQLException("There are no user login in");
        }
        int loginId = BaseHelpUtils.getIntValue(loginEmployeeId);
        Employee e = new Employee();
        e.setEmployeeId(loginId);
        e.load();
        String loginName = e.getEmployeeName();
        //获取设计师姓名
        e.setEmployeeId(dao.getEmployeeId());
        e.load();
        String designName = e.getEmployeeName();
        //插入项目日志
        ProjectLog pl = new ProjectLog();
        pl.setProjectId(dao.getProjectId());
        pl.setOperateId(loginId);
        pl.setOperateTime(new Date());
        pl.setDepartmentId(p.getDepartmentId());
        pl.setManagerId(p.getProjectManageId());
        pl.setDesignPhase(p.getDesignPhase());
        pl.setLogContent(String.format("%1$s 已释放了 %2$s 的成员 %3$s", loginName, projectName, designName));
        pl.save();
        ThreadConnection.commit();
        return bean.toOneLineJSON(0, null);
    }

}
