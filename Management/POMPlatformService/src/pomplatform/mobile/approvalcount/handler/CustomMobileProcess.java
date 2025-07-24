package pomplatform.mobile.approvalcount.handler;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.dao.PersonnelBusines;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.dao.Employee;

public class CustomMobileProcess implements GenericProcessor{
	
	private final static String GET_SALARY_REPORT_REMARK = "getSalaryReportRemark";//获取奖金发放到部门的金额

	
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
			case GET_SALARY_REPORT_REMARK:
				return getSalaryReportRemark(result);
			}
		}
		return null;
	}
	
	public static String getSalaryReportRemark(Map<String, Object> params) throws SQLException{
		StringBuilder sbRemark = new StringBuilder("");
		int year = BaseHelpUtils.getIntValue(params, "year");
		int month = BaseHelpUtils.getIntValue(params, "month");
		Integer plateId = null;
		if(null != params.get("plateId")){
			plateId = BaseHelpUtils.getIntValue(params, "plateId");
		}
		String plateIds = null;
		if(!BaseHelpUtils.isNullOrEmpty(BaseHelpUtils.getStringValue(params, "plateIds"))){
			plateIds = BaseHelpUtils.getStringValue(params, "plateIds");
		}
		StringBuilder sql = new StringBuilder("");
		sql.append(" ((EXTRACT (YEAR FROM end_date) =").append(year)
			.append(" AND EXTRACT (MONTH FROM end_date) =").append(month).append(")")
			.append(" OR (EXTRACT (YEAR FROM start_date) =").append(year)
			.append(" AND EXTRACT (MONTH FROM start_date) =").append(month).append("))");
		if(null != plateId){
			sql.append(" AND (department_id in (select department_id from departments where plate_id = ").append(plateId).append(")")
				.append(" OR parent_id in (select department_id from departments where plate_id = ").append(plateId).append("))");
		}else{
			if(!BaseHelpUtils.isNullOrEmpty(plateIds)){
				sql.append(" AND (department_id in (select department_id from departments where plate_id in (").append(plateIds).append(") )")
					.append(" OR parent_id in (select department_id from departments where plate_id in (").append(plateIds).append(") ))");
			}
		}
		//转岗人员
		PersonnelBusines pbDao = new PersonnelBusines();
		pbDao.setConditionIsCompleted("=", true);
		pbDao.setConditionDeleteFlag("=", 0);
		pbDao.setConditionProcessType("=", 26);
		int transCount = pbDao.countRows(sql.toString());
		
		//离职
		pbDao.clear();
		StringBuilder sql1 = new StringBuilder("");
		sql1.append(" (EXTRACT (YEAR FROM end_date) =").append(year)
		.append(" AND EXTRACT (MONTH FROM end_date) =").append(month).append(")");
		if(null != plateId){
			sql1.append(" AND department_id in (select department_id from departments where plate_id = ").append(plateId).append(")");
		}else{
			if(!BaseHelpUtils.isNullOrEmpty(plateIds)){
				sql1.append(" AND department_id in (select department_id from departments where plate_id in (").append(plateIds).append("))");
			}
		}
		pbDao.setConditionIsCompleted("=", true);
		pbDao.setConditionDeleteFlag("=", 0);
		pbDao.setConditionProcessType("=", 25);
		int leaveCount = pbDao.countRows(sql1.toString());
		//入职
		Employee eDao = new Employee();
		StringBuilder sql2 = new StringBuilder("");
		sql2.append(" (EXTRACT (YEAR FROM onboard_date) =").append(year)
		.append(" AND EXTRACT (MONTH FROM onboard_date) =").append(month).append(")");
		if(null != plateId){
			sql2.append(" AND department_id in (select department_id from departments where plate_id = ").append(plateId).append(")");
		}else{
			if(!BaseHelpUtils.isNullOrEmpty(plateIds)){
				sql2.append(" AND department_id in (select department_id from departments where plate_id in (").append(plateIds).append("))");
			}
		}
		int onboardCount = eDao.countRows(sql2.toString());
		
		if(transCount > 0 || leaveCount > 0 || onboardCount > 0){
			sbRemark.append(month)
					.append("月");
			if(onboardCount > 0){
				sbRemark.append("入职:").append(onboardCount).append("人; ");
			}
			if(transCount > 0){
				sbRemark.append("转岗:").append(transCount).append("人; ");
			}
			if(leaveCount > 0){
				sbRemark.append("离职:").append(leaveCount).append("人; ");
			}
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(1, sbRemark.toString());
	}
	
	public static void main(String[] args) throws SQLException {
		Map<String, Object> params = new HashMap<>();
		params.put("year", 2017);
		params.put("month", 6);
//		params.put("plateId", "1");
		System.out.println(getSalaryReportRemark(params));
	}
}
