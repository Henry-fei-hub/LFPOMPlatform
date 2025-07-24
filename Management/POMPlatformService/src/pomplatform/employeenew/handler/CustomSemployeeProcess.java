package pomplatform.employeenew.handler;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.dao.PlateRecord;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.otheraccount.UserAccountUtils;
import delicacy.system.bean.BaseEmployee;
import pomplatform.common.utils.StaticUtils;

/**
 * 
 * @author CL
 *
 */
public class CustomSemployeeProcess implements GenericProcessor{
	
	private final static String UPDATE_EEMPLOYEE_TEL = "updateEemployeeTel";//修改员工座机号码同步至企业微信与企业邮箱
	
	private final static String GET_PLATE_BY_ROLE = "getPlateByRole";//根据角色获取相关的业务部门

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String optType = BaseHelpUtils.getStringValue(result, "opt_type");
		if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)) {
			switch (optType) {
			case UPDATE_EEMPLOYEE_TEL:
				return updateEemployeeTel(result);
			case GET_PLATE_BY_ROLE:
				return getPlateByRole(result);
			}
		}
		return null;
	}
	
	/**
	 * 根据员工角色获取出管理的相关的板块(业务部门)信息 	默认查询部门分管领导下管理的业务部门
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	private String getPlateByRole(Map<String, Object> params) throws SQLException{
		int status = 1;
		String errorMsg = null;
		int roleId = BaseHelpUtils.getIntValue(params, "roleId");
		if(roleId == 0){
			roleId = StaticUtils.ROLE_DEPARTMENT_CHARGE_LEADER;
		}
		int employeeId = BaseHelpUtils.getIntValue(params, "employeeId");
		PlateRecord prDao = new PlateRecord();
		BaseCollection<BasePlateRecord> bc = new BaseCollection<>();
		if(employeeId > 0 && roleId > 0){
			String sql = BasePlateRecord.CS_PLATE_ID + " in (SELECT plate_id from departments WHERE department_id IN (SELECT department_id FROM employee_roles "
					+ "WHERE employee_id = " + employeeId + " AND role_id = " + roleId + "))";
			List<BasePlateRecord> prList = prDao.conditionalLoad(sql);
			if(prList.size() > 0){
				errorMsg = "";
				for (int i = 0; i < prList.size(); i++) {
					if(i != 0){
						errorMsg += ",";
					}
					errorMsg += prList.get(i).getPlateId();
				}
				bc.setCollections(prList);
			}else{
				status = -1;
			}
		}else{
			status = -1;
		}
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 修改员工座机号码同步至企业微信与企业邮箱
	 * 修改员工英文名称同步至企业微信
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	private String updateEemployeeTel(Map<String, Object> params) throws SQLException{
		int status = 1;
		String errorMsg = null;
		BaseEmployee bean = new BaseEmployee();
		bean.setDataFromMap(params);
		if(null != bean.getEmployeeId()){
			UserAccountUtils.updateEmployeeTelephone(bean.getEmployeeId());
			//修改英文名称
			UserAccountUtils.updateEmployeeEnglishName(bean.getEmployeeId());
		}else{
			status = -1;
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(status, errorMsg);
	}
}
