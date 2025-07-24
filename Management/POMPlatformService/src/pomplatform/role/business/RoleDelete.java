package pomplatform.role.business;

import com.pomplatform.db.bean.BaseRole;
import com.pomplatform.db.dao.Role;
import com.pomplatform.db.dao.RoleFunction;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 * 角色删除
 *
 * @author lxf
 */
public class RoleDelete implements GenericProcessor {

    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        ThreadConnection.beginTransaction();
        //删除角色表数据
        BaseRole bean = new BaseRole();
        bean.setDataFromJSON(creteria);
        Role dao = new Role();
        //根据角色ID删除
        dao.setPrimaryKeyFromBase(bean);
        dao.delete();
        //删除角色功能关联表数据
        RoleFunction rfDao = new RoleFunction();
        rfDao.setConditionRoleId("=", bean.getRoleId());
        rfDao.conditionalDelete();
        ThreadConnection.commit();
        return bean.toOneLineJSON(0, null);
    }

}
