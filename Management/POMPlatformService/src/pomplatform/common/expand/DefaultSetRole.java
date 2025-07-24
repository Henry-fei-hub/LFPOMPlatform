/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomplatform.common.expand;

import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.system.bean.BaseEmployeeRole;
import delicacy.system.dao.EmployeeRole;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 *
 * @author wull
 */
public class DefaultSetRole implements GenericProcessor {

    private static final Logger __logger = Logger.getLogger("DefaultSetRole");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        ThreadConnection.beginTransaction();
        System.out.println("params start========");
        System.out.println("= " + creteria);
        System.out.println("params end========");
        BaseEmployeeRole bean = new BaseEmployeeRole();
        bean.setDataFromJSON(creteria);
        EmployeeRole dao = new EmployeeRole();
        dao.setDataFromBase(bean);
        boolean paramIsDefault = dao.getIsDefault();
        int employeeId = dao.getEmployeeId();
        int employeeRoleId = dao.getEmployeeRoleId();
        int departmentId = dao.getDepartmentId();
        boolean isLoad = dao.load();
        if (employeeRoleId > 0 && isLoad) {
            setDefaultRole(dao.getEmployeeId(), paramIsDefault, employeeRoleId,departmentId);
        } else {
            if (employeeId > 0) {
                //新增角色
                dao.save();

                System.out.println("新增角色" + creteria);
                System.out.println("new id =" + dao.getEmployeeRoleId());
                setDefaultRole(dao.getEmployeeId(), paramIsDefault, dao.getEmployeeRoleId(),departmentId);
            }
        }
        ThreadConnection.commit();
        return dao.generateBase().toOneLineJSON(0, null);
    }

    public void setDefaultRole(int employeeId, boolean paramIsDefault, int employeeRoleId,int departmentId) throws SQLException {
        //将其他的设置为非默认的
        EmployeeRole e = new EmployeeRole();
        e.setConditionEmployeeId("=", employeeId);
        List<BaseEmployeeRole> bList = e.conditionalLoad();
        for (BaseEmployeeRole baseEmployeeRole : bList) {
            EmployeeRole empDAO = new EmployeeRole();
            baseEmployeeRole.setIsDefault(Boolean.FALSE);
            if(departmentId>0){
            baseEmployeeRole.setDepartmentId(departmentId);
            }
            empDAO.setDataFromBase(baseEmployeeRole);
            empDAO.update();
        }
        //设置默认
        if (paramIsDefault) {
            EmployeeRole empDAO = new EmployeeRole();
            empDAO.setEmployeeRoleId(employeeRoleId);
            if (empDAO.load()) {
                empDAO.setIsDefault(Boolean.TRUE);
                empDAO.update();
            }
        }
    }
}
