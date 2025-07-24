package pomplatform.project.business;

import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.dao.Project;
import delicacy.common.GenericProcessor;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 * 项目审核
 *
 * @author lxf
 */
public class ProjectTransfer implements GenericProcessor {

    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        //更新项目表审核状态及审核意见
        BaseProject bean = new BaseProject();
        bean.setDataFromJSON(creteria);
        Project dao = new Project();
        dao.setDataFromBase(bean);
        dao.update();
        return bean.toOneLineJSON(0, null);
    }

}
