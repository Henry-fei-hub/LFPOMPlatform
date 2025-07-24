package pomplatform.department.business;

import com.pomplatform.db.bean.BaseDepartment;
import com.pomplatform.db.dao.Department;
import delicacy.system.dao.DepartmentId;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 * 部门删除
 *
 * @author lxf
 */
public class DepartmentDelete implements GenericProcessor {

    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        ThreadConnection.beginTransaction();
        //先检索这个部门下是否有成员，如果有成员则不能进行删除，需将人员进行转移方可
        //删除部门表数据
        BaseDepartment bean = new BaseDepartment();
        bean.setDataFromJSON(creteria);
        Department dao = new Department();
        //根据部门ID删除
        dao.setPrimaryKeyFromBase(bean);
        dao.delete();
        //删除deparmentid表数据
        DepartmentId ddao = new DepartmentId();
        ddao.setConditionChildId("=",dao.getDepartmentId());
        ddao.conditionalDelete();
        ThreadConnection.commit();
        return bean.toOneLineJSON(0, null);
    }

}
