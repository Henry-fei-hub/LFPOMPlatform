package delicacy.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import delicacy.common.BaseHelpUtils;
import delicacy.system.bean.BaseDepartmentRole;
import delicacy.system.bean.BaseDepartmentRoleFunction;
import delicacy.system.bean.BaseRoleFunction;
import delicacy.system.dao.DepartmentRole;
import delicacy.system.dao.DepartmentRoleFunction;
import delicacy.system.dao.EmployeeRole;
import delicacy.system.dao.RoleFunction;

public class FunctionManagement {
	public static void main(String[] args) throws SQLException {
	
			RoleFunction roleFunctionDao = new RoleFunction();
			roleFunctionDao.unsetSelectFlags();
			roleFunctionDao.setSelectRoleId(true);
			roleFunctionDao.setSelectDepartmentId(true);
			roleFunctionDao.setConditionDepartmentId(">", 0);
			// 1、获取部门角色信息
			List<BaseRoleFunction> roleFunctionList = roleFunctionDao.conditionalLoad();
			HashSet set = new HashSet(roleFunctionList);
			roleFunctionList.clear();
			roleFunctionList.addAll(set);
			System.out.println("部门角色个数：" + roleFunctionList.size());

			// 2.将部门角色信息插入到部门角色信息表中
			DepartmentRole departmentRoleDao = new DepartmentRole();
			BaseDepartmentRole departmentRoleBean = null;
			List<BaseDepartmentRole> departmentRoleList = new ArrayList<>();
			for (BaseRoleFunction baseRoleFunction : roleFunctionList) {
				departmentRoleBean = new BaseDepartmentRole();
				departmentRoleBean.setRoleId(baseRoleFunction.getRoleId());
				departmentRoleBean.setDepartmentId(baseRoleFunction.getDepartmentId());
				if (!BaseHelpUtils.isNullOrEmpty(departmentRoleBean)) {
					departmentRoleList.add(departmentRoleBean);
				}
			}
			if (!BaseHelpUtils.isNullOrEmpty(departmentRoleList)) {
				departmentRoleDao.save(departmentRoleList);
			}
			System.out.println("插入部门角色个数为："+departmentRoleList.size());

			// 3、获取部门角色功能信息
			RoleFunction roleFunctionDao1 = new RoleFunction();
			roleFunctionDao1.setConditionDepartmentId(">", 0);
			List<BaseRoleFunction> RoleFunList = roleFunctionDao1.conditionalLoad();
			System.out.println("部门角色功能总个数:" + RoleFunList.size());
			
			//获取所有的部门角色信息
			departmentRoleDao.clear();
			List<BaseDepartmentRole> deRoleList = departmentRoleDao.conditionalLoad();
			
			//4、将部门角色功能信息全部插入到部门角色信息功能信息表中
			DepartmentRoleFunction deRoleFunDao = new DepartmentRoleFunction();
			List<BaseDepartmentRoleFunction> deRoleFunList = new ArrayList<>();
			BaseDepartmentRoleFunction deRoleFunBean = null;
			for (BaseRoleFunction baseRoleFunction : RoleFunList) {
				deRoleFunBean = new BaseDepartmentRoleFunction();
				deRoleFunBean.setRoleId(baseRoleFunction.getRoleId());
				deRoleFunBean.setDepartmentId(baseRoleFunction.getDepartmentId());
				deRoleFunBean.setFunctionId(baseRoleFunction.getFunctionId());
				deRoleFunBean.setApplicationId(baseRoleFunction.getApplicationId());
				if (!BaseHelpUtils.isNullOrEmpty(deRoleFunBean)) {
					deRoleFunList.add(deRoleFunBean);
				}
			}
			if (!BaseHelpUtils.isNullOrEmpty(deRoleFunList)) {
				deRoleFunDao.save(deRoleFunList);
			}
			System.out.println("插入部门角色功能信息总个数为："+deRoleFunList.size());

			// 5、人员角色表清除 department_id = 0的数据
			EmployeeRole emRoleDao = new EmployeeRole();
			emRoleDao.setConditionDepartmentId("=", 0);
			emRoleDao.setConditionRoleId("!=", 0);
			emRoleDao.conditionalDelete();
			
			//6、角色功能信息表(只留role_id = 0 and department_id = 0的数据)
			RoleFunction roleFunctionDao2 = new RoleFunction();
			roleFunctionDao2.setConditionRoleId("<>", 0);
			roleFunctionDao2.conditionalDelete();
		
		
	}
	
}
