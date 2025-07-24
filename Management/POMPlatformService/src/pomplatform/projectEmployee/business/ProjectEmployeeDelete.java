package pomplatform.projectEmployee.business;

import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.dao.ProjectEmployee;
import delicacy.common.GenericProcessor;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 * 团队删除
 *
 * @author lxf
 */
public class ProjectEmployeeDelete implements GenericProcessor {

    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        //删除团队职员数据
        BaseProjectEmployee bean = new BaseProjectEmployee();
        bean.setDataFromJSON(creteria);
        ProjectEmployee dao = new ProjectEmployee();
        //根据ID删除
        dao.setPrimaryKeyFromBase(bean);
        dao.delete();
        return bean.toOneLineJSON(0, null);
    }

}
