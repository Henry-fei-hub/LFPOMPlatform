package pomplatform.department.handler;

import com.pomplatform.db.bean.BaseDepartment;
import com.pomplatform.db.dao.Department;
import delicacy.system.dao.DepartmentId;
import org.apache.log4j.Logger;
import com.pomplatform.db.handler.DepartmentHandler;
import delicacy.connection.ThreadConnection;

public class CustomDepartmentHandler extends DepartmentHandler {
    private static final Logger __logger = Logger.getLogger(CustomDepartmentHandler.class);

    @Override
    public String save(String json) throws Exception {
        ThreadConnection.beginTransaction();
        BaseDepartment bean = new BaseDepartment();
        bean.setDataFromJSON(json);
        Department dao = new Department();
        dao.setDataFromBase(bean);
        int num = dao.save();
        //往departmentIds表插入数据
        DepartmentId ddao = new DepartmentId();
        ddao.setDepartmentId(dao.getParentId());
        ddao.setChildId(dao.getDepartmentId());
        ddao.save();
        //将当前部门作为自己部门的父级部门
        ddao.clear();
        ddao.setDepartmentId(dao.getDepartmentId());
        ddao.setChildId(dao.getDepartmentId());
        ddao.save();
        dao.setDataToBase(bean);
        ThreadConnection.commit();
        return bean.toOneLineJSON(num, null);
    }

    @Override
    public String update(String json) throws Exception {
        ThreadConnection.beginTransaction();
        BaseDepartment bean = new BaseDepartment();
        bean.setDataFromJSON(json);
        Department dao = new Department();
        dao.setPrimaryKeyFromBase(bean);
        int num=0;
        if(dao.load()){
            dao.setDataFromBase(bean); 
            num = dao.update(); 
            //更新departmentId表数据
            DepartmentId ddao = new DepartmentId();
            ddao.setConditionChildId("=",dao.getDepartmentId());
            ddao.setDepartmentId(dao.getParentId());
            ddao.conditionalUpdate();
        }
        ThreadConnection.commit();
        return bean.toOneLineJSON(num, null);
    }
    
}
