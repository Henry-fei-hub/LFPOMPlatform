package pomplatform.operation.query;

import org.apache.log4j.Logger;
import java.util.Map;
import java.util.List;
import delicacy.common.CommonUtils;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.operation.bean.BaseProjectManager;
import pomplatform.operation.bean.ConditionProjectManager;

public class QueryProjectManager extends AbstractQuery<BaseProjectManager, ConditionProjectManager>
{

	private static final Logger __logger = Logger.getLogger(QueryProjectManager.class);

	public QueryProjectManager() throws java.sql.SQLException 
	{
		setParameterNumber(13);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sub_contract_name");
	}

	public static BaseCollection<BaseProjectManager> select(Map params) throws java.sql.SQLException {

		return select(params, null);
	}


	public static BaseCollection<BaseProjectManager> select(Map params, Map replaces) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionProjectManager c = new ConditionProjectManager();
		c.setDataFromMap(CommonUtils.preprocess(params));
		QueryProjectManager dao = new QueryProjectManager();
		return dao.runQuery(replacements, c);
	}


	public static List<BaseProjectManager> query(Map params) throws java.sql.SQLException {

		return query(params, null);
	}


	public static List<BaseProjectManager> query(Map params, Map replaces) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionProjectManager c = new ConditionProjectManager();
		c.setDataFromMap(CommonUtils.preprocess(params));
		QueryProjectManager dao = new QueryProjectManager();
		return dao.runQuery(replacements, c).getCollections();
	}


	@Override
	public BaseCollection<BaseProjectManager> executeQuery( KeyValuePair[] replacements, ConditionProjectManager condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId(), 
				condition.getPlateId(), 
				condition.getDepartmentManagerId(), 
				condition.getContractCode(), 
				condition.getDesignType(), 
				condition.getProjectLevel(), 
				condition.getStatus(), 
				condition.getProjectName(), 
				condition.getProjectFlag()
			);
	}

	public BaseCollection<BaseProjectManager> runQuery( KeyValuePair[] replacements, ConditionProjectManager condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId(), 
				condition.getPlateId(), 
				condition.getDepartmentManagerId(), 
				condition.getContractCode(), 
				condition.getDesignType(), 
				condition.getProjectLevel(), 
				condition.getStatus(), 
				condition.getProjectName(), 
				condition.getProjectFlag()
			);
	}

	public BaseCollection<BaseProjectManager> execute( KeyValuePair[] replacements, ConditionProjectManager condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId(), 
				condition.getPlateId(), 
				condition.getDepartmentManagerId(), 
				condition.getContractCode(), 
				condition.getDesignType(), 
				condition.getProjectLevel(), 
				condition.getStatus(), 
				condition.getProjectName(), 
				condition.getProjectFlag()
			);
	}

	@Override
	public BaseProjectManager generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProjectManager __base = new BaseProjectManager();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSubContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNameTostring3(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCommonArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLogisticsArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBimArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCadArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOldProjectDiscount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDesignPhase(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWorkHours(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlanStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPlanEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setBudget(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectProgress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectSize(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectDescription(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAuditReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAppendTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAppendIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectFinishPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTotalFinishPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlateManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectGradeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLastPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHumanAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setComplaintIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setComplaintPercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLeftSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlateSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeftPlateSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProgressPercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIsAuto(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setTimeCycle(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setMsgCount(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMsgStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNameTostring5(GenericBase.__getString(val));
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
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setString(count++, GenericBase.__getString(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		return count;
	}

	@Override
	public String getSQLText() {
		return __SQLText;
	}

	@Override
	public String getOriginalSQLText() {
		return __originalSQL;
	}

	@Override
	public String[] getQueryStringArray()  {
		return __queryConditions;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	@Override
	public String[] getConditionNames(){
		return fieldNames;
	}

	private final static String __SQLText = "SELECT sc.sub_contract_name, P.department_id, P.department_manager_id, AAA.employee_name_toString_3, P.project_name, P.project_id, P.plate_id, P.project_type, P.design_type, P.project_level, P.project_manage_id, P.common_area, P.logistics_area, P.total_integral, P.reserve_integral, P.project_integral, P.bim_area, P.cad_area, P.total_amount, P.percentage, P.old_project_discount, P.status, P.contract_code, P.project_code, P.design_phase, P.work_hours, P.plan_start_date, P.plan_end_date, P.start_date, P.end_date, P.budget, P.project_progress, P.project_size, P.project_description, P.audit_reason, P.append_total_integral, P.append_integral, P.remark, CASE WHEN P.project_integral > 0 THEN round( ( COALESCE ( ps.sure_integral, 0 ) * 100 / P.project_integral ), 2 ) ELSE 0 END AS project_finish_percent, P.parent_id, P.total_finish_percent, P.plate_manager_id, P.project_grade_type, P.last_percent, P.human_amount, ps.sure_integral, P.complaint_integral, P.complaint_percentage, P.project_flag, P.project_integral - ps.sure_integral AS left_sure_integral, pp.plate_sure_integral, P.reserve_integral - pp.plate_sure_integral AS left_plate_sure_integral, CASE WHEN P.project_integral > 0 THEN round( ( COALESCE ( ps.sure_integral, 0 ) * 100 / P.project_integral ), 2 ) ELSE 0 END AS progress_percentage, P.is_auto, P.time_cycle, P.create_time, CASE WHEN A.msg_count ISNULL THEN 0 ELSE A.msg_count END AS msg_count, CASE WHEN A.msg_status ISNULL THEN 0 ELSE A.msg_status END AS msg_status, AAA.employee_name_toString_5, BBB.percent_sum, pps.project_type AS pre_project_type FROM projects P LEFT JOIN ( SELECT project_id, SUM ( total_amount ) AS sure_integral FROM project_settlements WHERE settlement_status = 2 and settlement_date between ? and ? GROUP BY project_id ) AS ps ON P.project_id = ps.project_id LEFT JOIN ( SELECT project_id, SUM ( account_integral ) AS plate_sure_integral FROM plate_project_account_records WHERE account_date between ? and ? GROUP BY project_id ) AS pp ON P.project_id = pp.project_id LEFT JOIN sub_contracts sc ON P.contract_code = sc.sub_contract_code LEFT JOIN ( SELECT * FROM contract_messages cm WHERE cm.create_time IN ( SELECT MAX ( b.create_time ) FROM contract_messages b WHERE b.msg_status = 1 GROUP BY b.contract_id ) ) AS A ON A.contract_id = P.contract_id LEFT JOIN ( SELECT mp.project_code, B.employee_name_toString_3, C.employee_name_toString_5 FROM main_projects mp LEFT JOIN ( SELECT main_project_id, array_to_string( ARRAY_AGG ( e.employee_name ), ',' ) AS employee_name_toString_3 FROM main_project_employees mpe LEFT JOIN employees e ON mpe.employee_id = e.employee_id WHERE mpe.relation = 3 AND mpe.employee_id > 0 AND mpe.main_project_id > 0 GROUP BY mpe.main_project_id ) AS B ON mp.main_project_id = B.main_project_id LEFT JOIN ( SELECT main_project_id, array_to_string( ARRAY_AGG ( e.employee_name ), ',' ) AS employee_name_toString_5 FROM main_project_employees mpe LEFT JOIN employees e ON mpe.employee_id = e.employee_id WHERE mpe.relation = 5 AND mpe.employee_id > 0 AND mpe.main_project_id > 0 GROUP BY mpe.main_project_id ) AS C ON mp.main_project_id = C.main_project_id ) AS AAA ON AAA.project_code = P.project_code LEFT JOIN ( SELECT contract_id, SUM ( CASE WHEN percent ISNULL THEN 0 ELSE percent END ) AS percent_sum FROM project_stages WHERE status = 2 AND contract_id > 0 GROUP BY contract_id ) AS BBB ON P.contract_id = BBB.contract_id LEFT JOIN main_projects AS pps ON pps.project_code = P.project_code AND pps.process_status = 2 WHERE P.department_id IN ( SELECT department_id FROM employee_roles WHERE role_id = 3 and employee_id = ? ) and P.plate_id = ? and P.department_manager_id = ? and P.contract_code LIKE ? and P.design_type = ? and P.project_level = ? and P.status = ? and P.project_name LIKE ? and P.project_flag = ? and 2 = 2 ORDER BY P.project_id DESC" ;
	private final static String __originalSQL = "SELECT sc.sub_contract_name, P.department_id, P.department_manager_id, AAA.employee_name_toString_3, P.project_name, P.project_id, P.plate_id, P.project_type, P.design_type, P.project_level, P.project_manage_id, P.common_area, P.logistics_area, P.total_integral, P.reserve_integral, P.project_integral, P.bim_area, P.cad_area, P.total_amount, P.percentage, P.old_project_discount, P.status, P.contract_code, P.project_code, P.design_phase, P.work_hours, P.plan_start_date, P.plan_end_date, P.start_date, P.end_date, P.budget, P.project_progress, P.project_size, P.project_description, P.audit_reason, P.append_total_integral, P.append_integral, P.remark, CASE WHEN P.project_integral > 0 THEN round( ( COALESCE ( ps.sure_integral, 0 ) * 100 / P.project_integral ), 2 ) ELSE 0 END AS project_finish_percent, P.parent_id, P.total_finish_percent, P.plate_manager_id, P.project_grade_type, P.last_percent, P.human_amount, ps.sure_integral, P.complaint_integral, P.complaint_percentage, P.project_flag, P.project_integral - ps.sure_integral AS left_sure_integral, pp.plate_sure_integral, P.reserve_integral - pp.plate_sure_integral AS left_plate_sure_integral, CASE WHEN P.project_integral > 0 THEN round( ( COALESCE ( ps.sure_integral, 0 ) * 100 / P.project_integral ), 2 ) ELSE 0 END AS progress_percentage, P.is_auto, P.time_cycle, P.create_time, CASE WHEN A.msg_count ISNULL THEN 0 ELSE A.msg_count END AS msg_count, CASE WHEN A.msg_status ISNULL THEN 0 ELSE A.msg_status END AS msg_status, AAA.employee_name_toString_5, BBB.percent_sum, pps.project_type AS pre_project_type FROM projects P LEFT JOIN ( SELECT project_id, SUM ( total_amount ) AS sure_integral FROM project_settlements WHERE settlement_status = 2 AND settlement_date BETWEEN :start_date AND :end_date GROUP BY project_id ) AS ps ON P.project_id = ps.project_id LEFT JOIN ( SELECT project_id, SUM ( account_integral ) AS plate_sure_integral FROM plate_project_account_records WHERE account_date BETWEEN :start_date AND :end_date GROUP BY project_id ) AS pp ON P.project_id = pp.project_id LEFT JOIN sub_contracts sc ON P.contract_code = sc.sub_contract_code LEFT JOIN ( SELECT * FROM contract_messages cm WHERE cm.create_time IN ( SELECT MAX ( b.create_time ) FROM contract_messages b WHERE b.msg_status = 1 GROUP BY b.contract_id ) ) AS A ON A.contract_id = P.contract_id LEFT JOIN ( SELECT mp.project_code, B.employee_name_toString_3, C.employee_name_toString_5 FROM main_projects mp LEFT JOIN ( SELECT main_project_id, array_to_string( ARRAY_AGG ( e.employee_name ), ',' ) AS employee_name_toString_3 FROM main_project_employees mpe LEFT JOIN employees e ON mpe.employee_id = e.employee_id WHERE mpe.relation = 3 AND mpe.employee_id > 0 AND mpe.main_project_id > 0 GROUP BY mpe.main_project_id ) AS B ON mp.main_project_id = B.main_project_id LEFT JOIN ( SELECT main_project_id, array_to_string( ARRAY_AGG ( e.employee_name ), ',' ) AS employee_name_toString_5 FROM main_project_employees mpe LEFT JOIN employees e ON mpe.employee_id = e.employee_id WHERE mpe.relation = 5 AND mpe.employee_id > 0 AND mpe.main_project_id > 0 GROUP BY mpe.main_project_id ) AS C ON mp.main_project_id = C.main_project_id ) AS AAA ON AAA.project_code = P.project_code LEFT JOIN ( SELECT contract_id, SUM ( CASE WHEN percent ISNULL THEN 0 ELSE percent END ) AS percent_sum FROM project_stages WHERE status = 2 AND contract_id > 0 GROUP BY contract_id ) AS BBB ON P.contract_id = BBB.contract_id LEFT JOIN main_projects AS pps ON pps.project_code = P.project_code AND pps.process_status = 2 WHERE P.department_id IN ( SELECT department_id FROM employee_roles WHERE role_id = 3 AND employee_id = :employee_id ) AND P.plate_id = :plate_id AND P.department_manager_id = :department_manager_id AND P.contract_code LIKE :contract_code AND P.design_type = :design_type AND P.project_level = :project_level AND P.status = :status AND P.project_name LIKE :project_name AND P.project_flag = :project_flag AND 2 = 2 ORDER BY P.project_id DESC";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"settlement_status = 2 AND settlement_date BETWEEN :start_date AND :end_date\",\"nextToken\":\"GROUP\",\"previousToken\":{\"tokenName\":\"WHERE\",\"startIndex\":1684,\"endIndex\":1688},\"startIndex\": 1690,\"stopIndex\":1764,\"variableNum\": 0,\"includeStaticCondition\": True,\"conditionNames\": startDate,endDate,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"settlement_status = 2\",\"nextToken\":\"AND\",\"previousToken\":{\"tokenName\":\"WHERE\",\"startIndex\":1684,\"endIndex\":1688},\"startIndex\": 1690,\"stopIndex\":1710,\"variableNum\": 0,\"includeStaticCondition\": True,\"conditionNames\": ,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"settlement_date BETWEEN :start_date AND :end_date\",\"fullFieldName\":\"settlement_date\",\"operationName\":\"between\",\"variableName\":\"startDate\",\"secondName\":\"endDate\",\"nextToken\":\"GROUP\",\"previousToken\":{\"tokenName\":\"AND\",\"startIndex\":1712,\"endIndex\":1714},\"startIndex\": 1716,\"stopIndex\":1764,\"variableNum\": 0,\"includeStaticCondition\": False,\"conditionNames\": startDate,endDate,\"variableCount\": 2,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"account_date BETWEEN :start_date AND :end_date\",\"nextToken\":\"GROUP\",\"previousToken\":{\"tokenName\":\"WHERE\",\"startIndex\":1940,\"endIndex\":1944},\"startIndex\": 1946,\"stopIndex\":1991,\"variableNum\": 0,\"includeStaticCondition\": False,\"conditionNames\": startDate,endDate,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"account_date BETWEEN :start_date AND :end_date\",\"fullFieldName\":\"account_date\",\"operationName\":\"between\",\"variableName\":\"startDate\",\"secondName\":\"endDate\",\"nextToken\":\"GROUP\",\"previousToken\":{\"tokenName\":\"WHERE\",\"startIndex\":1940,\"endIndex\":1944},\"startIndex\": 1946,\"stopIndex\":1991,\"variableNum\": 2,\"includeStaticCondition\": False,\"conditionNames\": startDate,endDate,\"variableCount\": 2,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"P.department_id IN ( SELECT department_id FROM employee_roles WHERE role_id = 3 AND employee_id = :employee_id ) AND P.plate_id = :plate_id AND P.department_manager_id = :department_manager_id AND P.contract_code LIKE :contract_code AND P.design_type = :design_type AND P.project_level = :project_level AND P.status = :status AND P.project_name LIKE :project_name AND P.project_flag = :project_flag AND 2 = 2\",\"nextToken\":\"ORDER\",\"previousToken\":{\"tokenName\":\"WHERE\",\"startIndex\":3537,\"endIndex\":3541},\"startIndex\": 3543,\"stopIndex\":3950,\"variableNum\": 0,\"includeStaticCondition\": True,\"conditionNames\": plateId,departmentManagerId,contractCode,designType,projectLevel,status,projectName,projectFlag,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"P.department_id IN ( SELECT department_id FROM employee_roles WHERE role_id = 3 AND employee_id = :employee_id )\",\"nextToken\":\"AND\",\"previousToken\":{\"tokenName\":\"WHERE\",\"startIndex\":3537,\"endIndex\":3541},\"startIndex\": 3543,\"stopIndex\":3654,\"variableNum\": 0,\"includeStaticCondition\": True,\"conditionNames\": ,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"role_id = 3 AND employee_id = :employee_id\",\"nextToken\":\")\",\"previousToken\":{\"tokenName\":\"WHERE\",\"startIndex\":3605,\"endIndex\":3609},\"startIndex\": 3611,\"stopIndex\":3652,\"variableNum\": 0,\"includeStaticCondition\": True,\"conditionNames\": employeeId,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"role_id = 3\",\"nextToken\":\"AND\",\"previousToken\":{\"tokenName\":\"WHERE\",\"startIndex\":3605,\"endIndex\":3609},\"startIndex\": 3611,\"stopIndex\":3621,\"variableNum\": 0,\"includeStaticCondition\": True,\"conditionNames\": ,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"employee_id = :employee_id\",\"fullFieldName\":\"employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\")\",\"previousToken\":{\"tokenName\":\"AND\",\"startIndex\":3623,\"endIndex\":3625},\"startIndex\": 3627,\"stopIndex\":3652,\"variableNum\": 4,\"includeStaticCondition\": False,\"conditionNames\": employeeId,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]},{\"fullCondition\": \"P.plate_id = :plate_id\",\"fullFieldName\":\"P.plate_id\",\"operationName\":\"=\",\"variableName\":\"plateId\",\"nextToken\":\"AND\",\"previousToken\":{\"tokenName\":\"AND\",\"startIndex\":3656,\"endIndex\":3658},\"startIndex\": 3660,\"stopIndex\":3681,\"variableNum\": 5,\"includeStaticCondition\": False,\"conditionNames\": plateId,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"P.department_manager_id = :department_manager_id\",\"fullFieldName\":\"P.department_manager_id\",\"operationName\":\"=\",\"variableName\":\"departmentManagerId\",\"nextToken\":\"AND\",\"previousToken\":{\"tokenName\":\"AND\",\"startIndex\":3683,\"endIndex\":3685},\"startIndex\": 3687,\"stopIndex\":3734,\"variableNum\": 6,\"includeStaticCondition\": False,\"conditionNames\": departmentManagerId,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"P.contract_code LIKE :contract_code\",\"fullFieldName\":\"P.contract_code\",\"operationName\":\"LIKE\",\"variableName\":\"contractCode\",\"nextToken\":\"AND\",\"previousToken\":{\"tokenName\":\"AND\",\"startIndex\":3736,\"endIndex\":3738},\"startIndex\": 3740,\"stopIndex\":3774,\"variableNum\": 7,\"includeStaticCondition\": False,\"conditionNames\": contractCode,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"P.design_type = :design_type\",\"fullFieldName\":\"P.design_type\",\"operationName\":\"=\",\"variableName\":\"designType\",\"nextToken\":\"AND\",\"previousToken\":{\"tokenName\":\"AND\",\"startIndex\":3776,\"endIndex\":3778},\"startIndex\": 3780,\"stopIndex\":3807,\"variableNum\": 8,\"includeStaticCondition\": False,\"conditionNames\": designType,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"P.project_level = :project_level\",\"fullFieldName\":\"P.project_level\",\"operationName\":\"=\",\"variableName\":\"projectLevel\",\"nextToken\":\"AND\",\"previousToken\":{\"tokenName\":\"AND\",\"startIndex\":3809,\"endIndex\":3811},\"startIndex\": 3813,\"stopIndex\":3844,\"variableNum\": 9,\"includeStaticCondition\": False,\"conditionNames\": projectLevel,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"P.status = :status\",\"fullFieldName\":\"P.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"nextToken\":\"AND\",\"previousToken\":{\"tokenName\":\"AND\",\"startIndex\":3846,\"endIndex\":3848},\"startIndex\": 3850,\"stopIndex\":3867,\"variableNum\": 10,\"includeStaticCondition\": False,\"conditionNames\": status,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"P.project_name LIKE :project_name\",\"fullFieldName\":\"P.project_name\",\"operationName\":\"LIKE\",\"variableName\":\"projectName\",\"nextToken\":\"AND\",\"previousToken\":{\"tokenName\":\"AND\",\"startIndex\":3869,\"endIndex\":3871},\"startIndex\": 3873,\"stopIndex\":3905,\"variableNum\": 11,\"includeStaticCondition\": False,\"conditionNames\": projectName,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"P.project_flag = :project_flag\",\"fullFieldName\":\"P.project_flag\",\"operationName\":\"=\",\"variableName\":\"projectFlag\",\"nextToken\":\"AND\",\"previousToken\":{\"tokenName\":\"AND\",\"startIndex\":3907,\"endIndex\":3909},\"startIndex\": 3911,\"stopIndex\":3940,\"variableNum\": 12,\"includeStaticCondition\": False,\"conditionNames\": projectFlag,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"2 = 2\",\"nextToken\":\"ORDER\",\"previousToken\":{\"tokenName\":\"AND\",\"startIndex\":3942,\"endIndex\":3944},\"startIndex\": 3946,\"stopIndex\":3950,\"variableNum\": 0,\"includeStaticCondition\": True,\"conditionNames\": ,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "sub_contract_name,department_id,department_manager_id,employee_name_tostring_3,project_name,project_id,plate_id,project_type,design_type,project_level,project_manage_id,common_area,logistics_area,total_integral,reserve_integral,project_integral,bim_area,cad_area,total_amount,percentage,old_project_discount,status,contract_code,project_code,design_phase,work_hours,plan_start_date,plan_end_date,start_date,end_date,budget,project_progress,project_size,project_description,audit_reason,append_total_integral,append_integral,remark,project_finish_percent,parent_id,total_finish_percent,plate_manager_id,project_grade_type,last_percent,human_amount,sure_integral,complaint_integral,complaint_percentage,project_flag,left_sure_integral,plate_sure_integral,left_plate_sure_integral,progress_percentage,is_auto,time_cycle,create_time,msg_count,msg_status,employee_name_tostring_5,percent_sum,pre_project_type";
	private final static String[] fieldNames = { "start_date", "end_date", "start_date", "end_date", "employee_id", "plate_id", "department_manager_id", "contract_code", "design_type", "project_level", "status", "project_name", "project_flag"};
}
