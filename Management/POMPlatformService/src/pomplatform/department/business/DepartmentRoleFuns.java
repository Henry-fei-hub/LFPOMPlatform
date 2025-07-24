/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomplatform.department.business;

import com.pomplatform.db.bean.BaseDepartment;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.system.bean.BaseDepartmentRole;
import delicacy.system.bean.BaseDepartmentRoleFunction;
import delicacy.system.bean.BaseEmployeeRole;
import delicacy.system.bean.BaseFunction;
import delicacy.system.bean.BaseRole;
import delicacy.system.bean.BaseRoleFunction;
import delicacy.system.dao.Department;
import delicacy.system.dao.DepartmentRoleFunction;
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
 * @author lsf
 */
public class DepartmentRoleFuns implements GenericProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		Function fn = new Function();
		fn.setConditionEnabled("=", Boolean.TRUE);
		List<BaseFunction> fnList = fn.conditionalLoad();

		DepartmentRoleFunction drfDao = new DepartmentRoleFunction();
		List<BaseDepartmentRoleFunction> drfList = drfDao.conditionalLoad();

		// 部门信息
		Department departmentDao = new Department();
		departmentDao.unsetSelectFlags();
		departmentDao.setSelectDepartmentId(true);
		departmentDao.setSelectDepartmentName(true);
		List<delicacy.system.bean.BaseDepartment> baseDepartmentList = departmentDao.conditionalLoad();

		// 部门角色
		delicacy.system.dao.DepartmentRole drDao = new delicacy.system.dao.DepartmentRole();
		List<BaseDepartmentRole> departmentRoleList = drDao.conditionalLoad();

		if (BaseHelpUtils.isNullOrEmpty(departmentRoleList)) {
			return null;
		}

		Role role = new Role();
		List<BaseRole> baseRole = role.conditionalLoad();

		List<BaseDepartment> ds = new ArrayList<>();// 模拟前端显示，将role数据封装进去

		for (BaseDepartmentRole baseDepartmentRole : departmentRoleList) {
			for (BaseRole brole : baseRole) {
				if (Objects.equals(baseDepartmentRole.getRoleId(), brole.getRoleId())) {
					for (delicacy.system.bean.BaseDepartment baseDepartment : baseDepartmentList) {
						if (Objects.equals(baseDepartmentRole.getDepartmentId(), baseDepartment.getDepartmentId())) {
							BaseDepartment b = new BaseDepartment();
							b.setDepartmentId(baseDepartmentRole.getDepartmentRoleId());
							b.setDepartmentName(baseDepartment.getDepartmentName() + "-" + brole.getRoleName());
							ds.add(b);
						}

					}

				}

			}
		}
		int idx = 1000000;
		List<BaseDepartment> nds = new ArrayList<>();
		Map<Integer, List<Integer>> roleMap = new HashMap<>();

		for (BaseDepartmentRole baseDepartmentRole : departmentRoleList) {
			List<Integer> empIdList = new ArrayList<>();
			for (BaseDepartmentRoleFunction bean : drfList) {
				if (baseDepartmentRole.getRoleId().equals(bean.getRoleId()) && baseDepartmentRole.getDepartmentId().equals(bean.getDepartmentId())) {
					empIdList.add(bean.getFunctionId());
				}
			}
			roleMap.put(baseDepartmentRole.getDepartmentRoleId(), empIdList);
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
	
	public static void main(String[] args) throws Exception {
		new DepartmentRoleFuns().execute(null, null);
	}

}
