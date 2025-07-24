package pomplatform.common.business;

import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.dao.Project;
import delicacy.common.BaseCollection;
import delicacy.common.GenericProcessor;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import pomplatform.getprojectreserveintegral.bean.BaseGetProjectReserveIntegral;
import pomplatform.getprojectreserveintegral.bean.ConditionGetProjectReserveIntegral;
import pomplatform.getprojectreserveintegral.query.QueryGetProjectReserveIntegral;

/**
 * 根据项目ID检索项目的预留积分
 * @author lxf
 */
public class OnGetProjectReserveIntegral implements GenericProcessor {
    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        ConditionGetProjectReserveIntegral c = new ConditionGetProjectReserveIntegral();
        c.setDataFromJSON(creteria);
        QueryGetProjectReserveIntegral dao = new QueryGetProjectReserveIntegral();
        BaseCollection<BaseGetProjectReserveIntegral> result = dao.executeQuery( c.getKeyValues(), c) ;
        return result.toJSON(0, null);
    }

}
