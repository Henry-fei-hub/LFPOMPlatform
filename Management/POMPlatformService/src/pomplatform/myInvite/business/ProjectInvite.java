package pomplatform.myInvite.business;

import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.dao.ProjectEmployee;
import delicacy.common.GenericProcessor;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 * 我的邀请审核
 *
 * @author lxf
 */
public class ProjectInvite implements GenericProcessor {

    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        //更新我的邀请是否同意状态
        BaseProjectEmployee bean = new BaseProjectEmployee();
        bean.setDataFromJSON(creteria);
        ProjectEmployee dao = new ProjectEmployee();
        dao.setDataFromBase(bean);
        
        dao.update();
        return bean.toOneLineJSON(0, null);
    }

}
