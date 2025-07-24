/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomplatform.department.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseDepartment;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.system.bean.BaseDepartmentRole;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.bean.BaseEmployeeRole;
import delicacy.system.bean.BaseRole;
import delicacy.system.dao.Department;
import delicacy.system.dao.Employee;
import delicacy.system.dao.EmployeeRole;
import delicacy.system.dao.Role;

/**
 *
 * @author lsf
 */
public class DepartmentRoleEmployee implements GenericProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		Employee edao = new Employee();
		edao.setConditionStatus("=", 0);// 在职
		edao.unsetSelectFlags();
		edao.setSelectEmployeeName(true);// 姓名
		edao.setSelectEmployeeNo(true);// 工号
		edao.setSelectDepartmentId(true);// 部门ID
		edao.setSelectEmployeeId(true);// empId
		List<BaseEmployee> bes = edao.conditionalLoad();

		// 部门信息
		Department departmentDao = new Department();
		departmentDao.unsetSelectFlags();
		departmentDao.setSelectDepartmentId(true);
		departmentDao.setSelectDepartmentName(true);
		List<delicacy.system.bean.BaseDepartment> baseDepartmentList = departmentDao.conditionalLoad();
		
		// 部门角色
		delicacy.system.dao.DepartmentRole drDao = new delicacy.system.dao.DepartmentRole();
		List<BaseDepartmentRole> departmentRoleList = drDao.conditionalLoad();

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

		EmployeeRole empRole = new EmployeeRole();
		empRole.setConditionDepartmentId("!=", 0);
		List<BaseEmployeeRole> baseEmpRole = empRole.conditionalLoad();
		int idx = 100000;

		// 从角色中间表中找出改角色对应的 职员id
		Map<Integer, List<Integer>> empIdMap = new HashMap<>();
		for (BaseDepartmentRole baseDepartmentRole : departmentRoleList) {
			List<Integer> empIdList = new ArrayList<>();
			for (BaseEmployeeRole bempRole : baseEmpRole) {
				if (BaseHelpUtils.getIntValue(baseDepartmentRole.getRoleId()) > 0
						&& BaseHelpUtils.getIntValue(bempRole.getRoleId()) > 0) {
					if (Objects.equals(baseDepartmentRole.getRoleId(), bempRole.getRoleId())
							&& Objects.equals(baseDepartmentRole.getDepartmentId(), bempRole.getDepartmentId())) {
						empIdList.add(bempRole.getEmployeeId());
					}
				}
			}
			empIdMap.put(baseDepartmentRole.getDepartmentRoleId(), empIdList);
		}

		List<BaseDepartment> nds = new ArrayList<>();
		if (empIdMap.size() > 0) {
			for (Map.Entry<Integer, List<Integer>> entry : empIdMap.entrySet()) {
				Integer roleId = entry.getKey();
				List<Integer> list = entry.getValue();
				if (list.size() > 0) {
					for (Integer empId : list) {
						if (bes.size() > 0) {
							for (BaseEmployee emp : bes) {
								if (Objects.equals(emp.getEmployeeId(), empId)) {
									BaseDepartment d = new BaseDepartment();
									d.setDepartmentName(emp.getEmployeeNo() + " - " + emp.getEmployeeName());
									d.setParentId(roleId);
									d.setDepartmentId(idx++);
									nds.add(d);
								}
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
		new DepartmentRoleEmployee().execute(null, null);
	}

}
