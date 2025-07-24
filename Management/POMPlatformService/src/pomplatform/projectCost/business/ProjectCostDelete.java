package pomplatform.projectCost.business;

import com.pomplatform.db.bean.BaseProjectCost;
import com.pomplatform.db.dao.ProjectCost;
import delicacy.common.GenericProcessor;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 * 费用删除
 *
 * @author lxf
 */
public class ProjectCostDelete implements GenericProcessor {

    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        //删除费用数据
        BaseProjectCost bean = new BaseProjectCost();
        bean.setDataFromJSON(creteria);
        ProjectCost dao = new ProjectCost();
        //根据ID删除
        dao.setPrimaryKeyFromBase(bean);
        dao.delete();
        return bean.toOneLineJSON(0, null);
    }

}
