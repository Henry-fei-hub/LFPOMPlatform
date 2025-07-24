package pomplatform.project.business;

import java.io.StringReader;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectLog;
import com.pomplatform.db.bean.BaseSystemLog;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectLog;
import com.pomplatform.db.dao.SystemLog;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.dao.Employee;
import pomplatform.common.utils.StaticUtils;

/**
 * 项目状态操作
 *
 * @author lxf
 */
public class ProjectStatus implements GenericProcessor {

    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        ThreadConnection.beginTransaction();
        
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        
        //更新项目表审核状态及审核意见
        BaseProject bean = new BaseProject();
        bean.setDataFromJSON(creteria);
        Project dao = new Project();
        dao.setDataFromBase(bean);
        dao.update();
        int status = bean.getStatus();
        dao.load();
        //获取项目经理姓名
        Employee e = new Employee();
        e.setEmployeeId(dao.getProjectManageId());
        e.load();
        String projectManageName = e.getEmployeeName();
        //获取项目名称
        String projectName = dao.getProjectName();
        String projectCode = dao.getProjectCode();
        int departmentManageId = dao.getDepartmentManagerId()==null?0:dao.getDepartmentManagerId();
        //向项目日志表中添加日志数据
        BaseProjectLog bpl = new BaseProjectLog();
        bpl.setProjectId(dao.getProjectId());
        bpl.setManagerId(departmentManageId);
        bpl.setDesignPhase(dao.getDesignPhase());
        bpl.setOperateId(dao.getProjectManageId());
        bpl.setDepartmentId(dao.getDepartmentId());
        bpl.setOperateTime(new Date());
        switch(status){
            case 3:
                bpl.setLogContent(String.format("%1$s 已暂缓了 %2$s ", projectManageName, projectName));
                break;
            case 10:
                bpl.setLogContent(String.format("%1$s 已暂停了 %2$s ", projectManageName, projectName));
                break;
            case 2:
                bpl.setLogContent(String.format("%1$s 已恢复了 %2$s ", projectManageName, projectName));
                break;
            case 11:
                bpl.setLogContent(String.format("%1$s 已完成了 %2$s ", projectManageName, projectName));
                break;
            case 12:
                bpl.setLogContent(String.format("%1$s 已取消了 %2$s ", projectManageName, projectName));
                break;
            default:
                break;
        }
        bpl.setLogType(0);
        ProjectLog pl = new ProjectLog();
        pl.setDataFromBase(bpl);
        pl.save();
        
        
        //项目无进度：项目名称（项目编号）
        //获取项目经理姓名
        Employee e2 = new Employee();
        e2.setEmployeeId(BaseHelpUtils.getIntValue(param.get("operateEmployeeId")));
        e2.load();
        
        BaseSystemLog baseSystemLog =new BaseSystemLog();
        baseSystemLog.setOperator(BaseHelpUtils.getIntValue(param.get("operateEmployeeId")));
        baseSystemLog.setOperatorName(e2.getEmployeeName());
        baseSystemLog.setLogContent(String.format("项目无进度：%1$s(%2$s) ", projectName, projectCode));
        baseSystemLog.setLogType(StaticUtils.PROJECT_NO_PROGRESS);
        baseSystemLog.setLogTime(new Date());
        
        SystemLog systemLog =new SystemLog();
        systemLog.setDataFromBase(baseSystemLog);
        systemLog.save();
        
        ThreadConnection.commit();
        return bean.toOneLineJSON(0, null);
    }

}
