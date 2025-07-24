/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomplatform.department.business;

import com.pomplatform.db.bean.BaseDepartment;
import com.pomplatform.db.dao.Department;
import delicacy.common.BaseCollection;
import delicacy.common.GenericProcessor;
import delicacy.system.bean.BaseDepartmentRole;
import delicacy.system.bean.BaseEmployeeRole;
import delicacy.system.bean.BaseRole;
import delicacy.system.dao.EmployeeRole;
import delicacy.system.dao.Role;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author wll
 */
public class DepartmentRole implements GenericProcessor {

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        Department dao = new Department();
        dao.setConditionEnabled("=", Boolean.TRUE);//启用
        List<BaseDepartment> ds = dao.conditionalLoad();

        Role role = new Role();
        List<BaseRole> baseRole = role.conditionalLoad();

    /*    EmployeeRole empRole = new EmployeeRole();
        List<BaseEmployeeRole> baseEmpRole = empRole.conditionalLoad();*/
        
        delicacy.system.dao.DepartmentRole  drDao = new delicacy.system.dao.DepartmentRole();
        List<BaseDepartmentRole> departmentRoleList = drDao.conditionalLoad();
        
        int idx = 100000;

        Map<Integer, List<Integer>> deptIdMap = new HashMap<>();

        if (ds.size() > 0) {
            for (BaseDepartment dept : ds) {
                List<Integer> l = new ArrayList<>();
                if (departmentRoleList.size() > 0) {
                    for (BaseDepartmentRole erole : departmentRoleList) {
                        if (Objects.equals(dept.getDepartmentId(), erole.getDepartmentId())) {
                            l.add(erole.getRoleId());
                        }
                    }
                }
                deptIdMap.put(dept.getDepartmentId(), l);
            }
        }
        List<BaseDepartment> nds = new ArrayList<>();
        if (deptIdMap.size() > 0) {
            for (Map.Entry<Integer, List<Integer>> entry : deptIdMap.entrySet()) {
                Integer deptId = entry.getKey();
                List<Integer> list = entry.getValue();

                for (Integer roleId : list) {
                    for (BaseRole robj : baseRole) {
                        if (Objects.equals(roleId, robj.getRoleId())) {
                            BaseDepartment d = new BaseDepartment();
                            d.setDepartmentName("角色 - "+robj.getRoleName());
                            d.setParentId(deptId);
                            d.setDepartmentId(idx++);
                            nds.add(d);
                        }
                    }
                }
            }
        }
        ds.addAll(nds);
        BaseCollection<BaseDepartment> bc = new BaseCollection<>();
        bc.setCollections(ds);
        return bc.toJSON();
    }
  public static void main(String[] args) throws Exception {
	new DepartmentRole().execute(null, null);
}
}
