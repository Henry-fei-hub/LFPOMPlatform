package pomplatform.project.business;

import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectEmployee;
import delicacy.common.GenericProcessor;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 * 项目经理项目立项的同时，默认把自己分配在该项目的团队中去
 *
 * @author lxf
 */
public class SetProjectEmployee implements GenericProcessor {

    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        BaseProjectEmployee bean = new BaseProjectEmployee();
        bean.setDataFromJSON(creteria);
        bean.setStatus(1);//项目经理默认接受项目邀请
        Project p = new Project();
        p.setProjectId(bean.getProjectId());
        if(!p.load()){
            throw new SQLException(String.format("没有这个项目: %1$d", bean.getProjectId()));
        }
        bean.setPlanStartDate(p.getPlanStartDate());
        bean.setPlanEndDate(p.getPlanEndDate());
        bean.setWorkContent("管理整个项目的进度，人员，风险");
        ProjectEmployee dao = new ProjectEmployee();
        dao.setDataFromBase(bean);
        dao.save();
        return bean.toOneLineJSON(0, null);
    }

}
