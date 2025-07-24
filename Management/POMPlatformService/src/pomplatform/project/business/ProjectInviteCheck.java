package pomplatform.project.business;

import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.dao.ProjectEmployee;
import delicacy.common.BaseCollection;
import delicacy.common.GenericProcessor;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 * 检索项目成员是否都通过了邀请
 *
 * @author lxf
 */
public class ProjectInviteCheck implements GenericProcessor {

    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        int result = 0;
        BaseProjectEmployee bean = new BaseProjectEmployee();
        bean.setDataFromJSON(creteria);
        ProjectEmployee dao = new ProjectEmployee();
        dao.setConditionProjectId("=", bean.getProjectId());
        List<BaseProjectEmployee> resultList = dao.conditionalLoad();
        if (resultList != null && resultList.size() > 0) {
            for (BaseProjectEmployee e : resultList) {
                switch (e.getStatus()) {
                    case 0:
                        result = 1;//表示有未接受邀请的成员
                        break;
                    case -1:
                        result = 2;//表示有拒绝邀请的成员
                        break;
                    default:
                        break;
                }
            }
        }
        BaseCollection bc = new BaseCollection();
        return bc.toJSON(result,null);
    }

}
