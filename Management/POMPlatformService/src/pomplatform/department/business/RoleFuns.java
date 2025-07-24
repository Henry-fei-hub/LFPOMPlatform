/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomplatform.department.business;
import com.pomplatform.db.bean.BaseDepartment;
import delicacy.common.BaseCollection;
import delicacy.common.GenericProcessor;
import delicacy.system.bean.BaseFunction;
import delicacy.system.bean.BaseRole;
import delicacy.system.bean.BaseRoleFunction;
import delicacy.system.dao.Function;
import delicacy.system.dao.Role;
import delicacy.system.dao.RoleFunction;
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
public class RoleFuns implements GenericProcessor {

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        Function fn = new Function();
        fn.setConditionEnabled("=", Boolean.TRUE);
        List<BaseFunction> fnList = fn.conditionalLoad();

        RoleFunction rfunction = new RoleFunction();
        rfunction.setConditionDepartmentId("=", 0);
        List<BaseRoleFunction> baseRoleFun = rfunction.conditionalLoad();

        Role role = new Role();
        role.setConditionRoleId("!=", 0);;
        List<BaseRole> baseRole = role.conditionalLoad();
        List<BaseDepartment> ds = new ArrayList<>();//模拟前端显示，将role数据封装进去

        for (BaseRole brole : baseRole) {
            BaseDepartment b = new BaseDepartment();
            b.setDepartmentId(brole.getRoleId());
            b.setDepartmentName(brole.getRoleName());
            ds.add(b);
        }
        int idx = 1000000;
        List<BaseDepartment> nds = new ArrayList<>();

        Map<Integer, List<Integer>> roleMap = new HashMap<>();
        if (baseRole.size() > 0) {
            for (BaseRole br : baseRole) {
                List<Integer> l = new ArrayList<>();
                if (baseRoleFun.size() > 0) {
                    for (BaseRoleFunction roleFunc : baseRoleFun) {
                        if (Objects.equals(roleFunc.getRoleId(), br.getRoleId())) {
                            l.add(roleFunc.getFunctionId());
                        }
                    }
                }
                roleMap.put(br.getRoleId(), l);
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : roleMap.entrySet()) {
            Integer roleId = entry.getKey();
            List<Integer> list = entry.getValue();

            if (list.size() > 0) {
                for (Integer funId : list) {
                    if (fnList.size() > 0) {
                        for (BaseFunction bfn : fnList) {
                            if (Objects.equals(bfn.getFunctionId(), funId)) {
                                BaseDepartment d = new BaseDepartment();
                                d.setDepartmentName(bfn.getFunctionName());
                                d.setParentId(roleId);
                                d.setDepartmentId(idx++);
                                nds.add(d);
                            }
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

}
