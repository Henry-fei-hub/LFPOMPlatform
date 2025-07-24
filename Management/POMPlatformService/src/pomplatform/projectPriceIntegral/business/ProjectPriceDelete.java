package pomplatform.projectPriceIntegral.business;

import com.pomplatform.db.bean.BaseProjectUnitPrice;
import com.pomplatform.db.dao.ProjectUnitPrice;
import delicacy.common.GenericProcessor;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 * 项目价格表删除
 *
 * @author lxf
 */
public class ProjectPriceDelete implements GenericProcessor {

    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        BaseProjectUnitPrice bean = new BaseProjectUnitPrice();
        bean.setDataFromJSON(creteria);
        ProjectUnitPrice dao = new ProjectUnitPrice();
        dao.setPrimaryKeyFromBase(bean);
        dao.delete();
        return bean.toOneLineJSON(0, null);
    }

}
