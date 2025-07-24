package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseSprojectccpor;
import pomplatform.project.bean.ConditionSprojectccpor;

public class QuerySprojectccpor extends AbstractQuery<BaseSprojectccpor, ConditionSprojectccpor>
{

	private static final Logger __logger = Logger.getLogger(QuerySprojectccpor.class);

	public QuerySprojectccpor() throws java.sql.SQLException 
	{
		setParameterNumber(18);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("p.logistics_area");
	}

	@Override
	public BaseCollection<BaseSprojectccpor> executeQuery( KeyValuePair[] replacements, ConditionSprojectccpor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getTheStartDate(), 
				condition.getTheEndDate(), 
				condition.getTheStartDate(), 
				condition.getTheEndDate(), 
				condition.getTheStartDate(), 
				condition.getTheEndDate(), 
				condition.getProjectId(), 
				condition.getDesignPhase(), 
				condition.getProjectName(), 
				condition.getContractCode(), 
				condition.getDepartmentId(), 
				condition.getProjectType(), 
				condition.getProjectCode(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getStatus(), 
				condition.getProjectLevel(), 
				condition.getProjectManageId()
			);
	}

	@Override
	public BaseSprojectccpor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojectccpor __base = new BaseSprojectccpor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setLogisticsArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCommonArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWorkHours(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignPhase(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlanStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPlanEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectProgress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectSize(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectDescription(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBudget(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAuditReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDesignType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOldProjectDiscount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDepartmentManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectFinishPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTotalFinishPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlateManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectGradeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLastPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsEcmcProject(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIsLock(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setProjectPerformanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeftSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProgressPercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectFinishPercentHavetime(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlateSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeftPlateSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMsgCount(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMsgStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNameTostring(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPercentSum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPreProjectType(GenericBase.__getInt(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, java.lang.Object ... args) throws java.sql.SQLException {

		int index = 0;
		for(int ii = 0; ii < args.length; ii++){
			if(args[ii] == null) continue;
			index++;
			__logger.info(String.format("%1$s = [%2$s]", fieldNames[ii], args[ii]));
		}
		if( index > 0 ) __logger.info("=================================================");
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[13]));
		if(args[14] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setInt(count++, GenericBase.__getInt(args[16]));
		if(args[17] != null) __statement.setInt(count++, GenericBase.__getInt(args[17]));

		return count;
	}

	@Override
	public String getSQLText() {
		__logger.info(__SQLText);
		return __SQLText;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	private final static String __SQLText = "SELECT P .logistics_area, P.common_area, P.percentage, P.total_integral, P.reserve_integral, P.project_id, P.contract_code, P.work_hours, P.department_id, P.design_phase, P.project_type, P.project_code, P.project_name, P.plan_start_date, P.plan_end_date, P.start_date, P.end_date, P.status, P.project_progress, P.project_manage_id, P.project_size, P.project_integral, P.project_description, P.budget, P.audit_reason, P.design_type, P.total_amount, P.project_level, P.old_project_discount, P.department_manager_id, P.contract_id, P.plate_id, P.project_finish_percent, P.parent_id, P.total_finish_percent, P.plate_manager_id, P.project_grade_type, P.last_percent, P.project_flag, P.is_ecmc_project, P.sheet_amount AS money_sum, P.is_lock, CASE WHEN P.complaint_integral > 0 THEN 0 ELSE COALESCE (( SELECT MIN ( project_performance_id ) FROM project_performances WHERE business_type = 2 AND is_settlement = FALSE AND project_id = P.project_id ), 0 ) END AS project_performance_id, ( SELECT SUM ( total_amount ) FROM project_settlements WHERE settlement_status = 2 and project_id = P.project_id and settlement_date between ? and ? ) AS sure_integral, ( P.project_integral - ( COALESCE (( SELECT SUM ( total_amount ) FROM project_settlements WHERE settlement_status = 2 AND project_id = P.project_id ), 0 ))) AS left_sure_integral, CASE WHEN P.project_integral > 0 THEN round(( COALESCE (( SELECT SUM ( total_amount ) FROM project_settlements WHERE settlement_status = 2 AND project_id = P.project_id ), 0 ) * 100 / P.project_integral ), 2 ) ELSE 0 END AS progress_percentage, CASE WHEN P.project_integral > 0 THEN round(( COALESCE (( SELECT SUM ( total_amount ) FROM project_settlements WHERE settlement_status = 2 and project_id = P.project_id and settlement_date between ? and ? ), 0 ) * 100 / P.project_integral ), 2 ) ELSE 0 END AS project_finish_percent_havetime, COALESCE (( SELECT SUM ( account_integral ) FROM plate_project_account_records WHERE project_id = P.project_id and account_date between ? and ? ), 0 ) AS plate_sure_integral, ( P.reserve_integral - COALESCE (( SELECT SUM ( account_integral ) FROM plate_project_account_records WHERE project_id = P.project_id ), 0 )) AS left_plate_sure_integral, CASE WHEN A.msg_count ISNULL THEN 0 ELSE A.msg_count END AS msg_count, CASE WHEN A.msg_status ISNULL THEN 0 ELSE A.msg_status END AS msg_status, AAA.employee_name_toString,BBB.percent_sum,pps.project_type AS pre_project_type  FROM projects P LEFT JOIN sub_contracts C ON P.contract_code = C.sub_contract_code LEFT JOIN ( SELECT * FROM contract_messages cm WHERE cm.create_time IN ( SELECT MAX ( b.create_time ) FROM contract_messages b WHERE b.msg_status = 1 GROUP BY b.contract_id )) AS A ON A.contract_id = P.contract_id LEFT JOIN ( SELECT A.project_code, array_to_string( ARRAY_AGG ( A.employee_name ), ',' ) AS employee_name_toString FROM ( SELECT mp.project_code,e.employee_name from main_projects mp LEFT JOIN main_project_employees mpe ON mp.main_project_id = mpe.main_project_id and relation=3 LEFT JOIN employees e on mpe.employee_id=e.employee_id ) A GROUP BY A.project_code ) AS AAA on AAA.project_code=P.project_code LEFT JOIN ( SELECT contract_id, SUM ( CASE WHEN percent ISNULL THEN 0 ELSE percent END ) AS percent_sum FROM project_stages WHERE status = 2 and contract_id >0 GROUP BY contract_id ) AS BBB ON P.contract_id = BBB.contract_id LEFT JOIN main_projects AS pps ON pps.project_code = P.project_code and pps.process_status = 2  WHERE P.project_id = ? and P.design_phase = ? and P.project_name like ? and P.contract_code = ? and P.department_id = ? and P.plate_id = ? and P.project_code = ? and P.start_date = ? and P.end_date = ? and P.status = ? and P.project_level = ? and P.project_manage_id = ? and P.status >= 0 ORDER BY P.project_id DESC" ;
	private final static String RESULTSETFIELDLIST = "logistics_area,common_area,percentage,total_integral,reserve_integral,project_id,contract_code,work_hours,department_id,design_phase,project_type,project_code,project_name,plan_start_date,plan_end_date,start_date,end_date,status,project_progress,project_manage_id,project_size,project_integral,project_description,budget,audit_reason,design_type,total_amount,project_level,old_project_discount,department_manager_id,contract_id,plate_id,project_finish_percent,parent_id,total_finish_percent,plate_manager_id,project_grade_type,last_percent,project_flag,is_ecmc_project,money_sum,is_lock,project_performance_id,sure_integral,left_sure_integral,progress_percentage,project_finish_percent_havetime,plate_sure_integral,left_plate_sure_integral,msg_count,msg_status,employee_name_tostring,percent_sum,pre_project_type";
	private final static String[] fieldNames = { "the_start_date", "the_end_date", "the_start_date", "the_end_date", "the_start_date", "the_end_date", "project_id", "design_phase", "project_name", "contract_code", "department_id", "project_type", "project_code", "start_date", "end_date", "status", "project_level", "project_manage_id"};
}
