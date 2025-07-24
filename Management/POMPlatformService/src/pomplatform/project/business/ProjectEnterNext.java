package pomplatform.project.business;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectLog;
import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectLog;
import com.pomplatform.db.dao.SystemDictionary;

import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.system.dao.Employee;

/**
 * 进入项目下一设计阶段
 *
 * @author lxf
 */
public class ProjectEnterNext implements GenericProcessor {

    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        ThreadConnection.beginTransaction();
        BaseProject bean = new BaseProject();
        bean.setDataFromJSON(creteria);
        int designPhase = bean.getDesignPhase();
        //更新项目进入下一设计阶段
        bean.setDesignPhase(designPhase + 1);
        Project dao = new Project();
        dao.setDataFromBase(bean);
        dao.update();

        Employee e = new Employee();
        e.setEmployeeId(bean.getProjectManageId());
        e.load();
        String projectManageName = e.getEmployeeName();//获取项目经理姓名
        dao.load();
        String projectName = dao.getProjectName();//获取项目名称
        int departmentManageId = dao.getDepartmentManagerId()==null?0:dao.getDepartmentManagerId();
        //获取项目设计阶段名称
        BaseSystemDictionary bsd;
        SystemDictionary sd = new SystemDictionary();
        sd.setConditionDicTypeId("=", 7);
        sd.setConditionDicTypeValueId("=", bean.getDesignPhase());
        bsd = sd.executeQueryOneRow();
        String designPhaseName = bsd.getDicTypeValue();
        //向项目日志表中添加日志数据
        BaseProjectLog bpl = new BaseProjectLog();
        bpl.setProjectId(bean.getProjectId());
        bpl.setManagerId(departmentManageId);
        bpl.setDesignPhase(bean.getDesignPhase());
        bpl.setOperateId(bean.getProjectManageId());
        bpl.setDepartmentId(bean.getDepartmentId());
        bpl.setOperateTime(new Date());
        bpl.setLogContent(String.format("%1$s 已完成 %2$s 的 %3$s", projectManageName, projectName, designPhaseName));
        bpl.setLogType(0);
        ProjectLog pl = new ProjectLog();
        pl.setDataFromBase(bpl);
        pl.save();
        ThreadConnection.commit();
        return bean.toOneLineJSON(0, null);
    }

}
