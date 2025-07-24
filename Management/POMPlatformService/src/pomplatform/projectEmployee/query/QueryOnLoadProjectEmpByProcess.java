package pomplatform.projectEmployee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectEmployee.bean.BaseOnLoadProjectEmpByProcess;
import pomplatform.projectEmployee.bean.ConditionOnLoadProjectEmpByProcess;

public class QueryOnLoadProjectEmpByProcess extends AbstractQuery<BaseOnLoadProjectEmpByProcess, ConditionOnLoadProjectEmpByProcess>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadProjectEmpByProcess.class);

	public QueryOnLoadProjectEmpByProcess() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("C .project_employee_id");
	}

	@Override
	public BaseCollection<BaseOnLoadProjectEmpByProcess> executeQuery( KeyValuePair[] replacements, ConditionOnLoadProjectEmpByProcess condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getBusinessId(), 
				condition.getProjectId(), 
				condition.getProcessStatus(), 
				condition.getStatus()
			);
	}

	public BaseCollection<BaseOnLoadProjectEmpByProcess> runQuery( KeyValuePair[] replacements, ConditionOnLoadProjectEmpByProcess condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getBusinessId(), 
				condition.getProjectId(), 
				condition.getProcessStatus(), 
				condition.getStatus()
			);
	}

	public BaseCollection<BaseOnLoadProjectEmpByProcess> execute( KeyValuePair[] replacements, ConditionOnLoadProjectEmpByProcess condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getBusinessId(), 
				condition.getProjectId(), 
				condition.getProcessStatus(), 
				condition.getStatus()
			);
	}

	@Override
	public BaseOnLoadProjectEmpByProcess generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadProjectEmpByProcess __base = new BaseOnLoadProjectEmpByProcess();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignPhase(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlanWorkHours(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRealWorkHours(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlanIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRealIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlanStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPlanEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setWorkContent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlternateField1(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlternateField2(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlternateField3(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSettlement(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEmployeeAchieveIntegralReturn(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRoleId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setGradeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeePassword(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMobile(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setQq(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmail(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOnboardDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setResignationDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUsableStatus(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsDepartment(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setPhoto(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setGender(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAutograph(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAge(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBirth(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCard(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLocked(GenericBase.__getBoolean(val));
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
		if(args[0] != null) __statement.setInt(count++, GenericBase.__getInt(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "SELECT C .project_employee_id, C.project_id, C.employee_id, C.design_phase, C.plan_work_hours, C.real_work_hours, C.plan_integral, C.real_integral, C.plan_start_date, C.plan_end_date, C.start_date, C.end_date, C.work_content, C.alternate_field1, C.alternate_field2, C.alternate_field3, C.COST, C.settlement, C.employee_achieve_integral_return, C.stage_id, C.FLAG, C.business_id, e.employee_no, e.employee_name, e.department_id, e.role_id, e.grade_id, e.employee_password, e.mobile, e.phone, e.qq, e.email, e.onboard_date, e.resignation_date, e.status, e.usable_status, e.is_department, e.photo, e.gender, e.autograph, e.age, e.birth, e.card, e.address, e.locked FROM system_process_instances AS A LEFT JOIN personnel_business AS b ON A.process_type = b.process_type AND A.business_id = b.personnel_business_id LEFT JOIN project_employees AS C ON C.business_id = b.personnel_business_id AND C.project_id = b.project_id LEFT JOIN employees AS e ON C.employee_id = e.employee_id WHERE A.business_id > 0 and A.business_id = ? and b.project_id = ? and A.process_type = 79 and A.process_status = ? and C.status = ?" ;
	private final static String __originalSQL = "SELECT C .project_employee_id, C.project_id, C.employee_id, C.design_phase, C.plan_work_hours, C.real_work_hours, C.plan_integral, C.real_integral, C.plan_start_date, C.plan_end_date, C.start_date, C.end_date, C.work_content, C.alternate_field1, C.alternate_field2, C.alternate_field3, C.COST, C.settlement, C.employee_achieve_integral_return, C.stage_id, C.FLAG, C.business_id, e.employee_no, e.employee_name, e.department_id, e.role_id, e.grade_id, e.employee_password, e.mobile, e.phone, e.qq, e.email, e.onboard_date, e.resignation_date, e.status, e.usable_status, e.is_department, e.photo, e.gender, e.autograph, e.age, e.birth, e.card, e.address, e.locked FROM system_process_instances AS A LEFT JOIN personnel_business AS b ON A.process_type = b.process_type AND A.business_id = b.personnel_business_id LEFT JOIN project_employees AS C ON C.business_id = b.personnel_business_id AND C.project_id = b.project_id LEFT JOIN employees AS e ON C.employee_id = e.employee_id WHERE A.business_id > 0 AND A.business_id =:business_id AND b.project_id =:project_id AND A.process_type = 79 AND A.process_status =:process_status AND C.status =:status";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"A.business_id > 0 AND A.business_id =:business_id AND b.project_id =:project_id AND A.process_type = 79 AND A.process_status =:process_status AND C.status =:status\",\"startIndex\": 982,\"stopIndex\":1144,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"A.business_id > 0\",\"startIndex\": 982,\"stopIndex\":998,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.business_id =:business_id\",\"fullFieldName\":\"A.business_id\",\"operationName\":\"=\",\"variableName\":\"businessId\",\"startIndex\": 1004,\"stopIndex\":1030,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.project_id =:project_id\",\"fullFieldName\":\"b.project_id\",\"operationName\":\"=\",\"variableName\":\"projectId\",\"startIndex\": 1036,\"stopIndex\":1060,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.process_type = 79\",\"startIndex\": 1066,\"stopIndex\":1084,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.process_status =:process_status\",\"fullFieldName\":\"A.process_status\",\"operationName\":\"=\",\"variableName\":\"processStatus\",\"startIndex\": 1090,\"stopIndex\":1122,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"C.status =:status\",\"fullFieldName\":\"C.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"startIndex\": 1128,\"stopIndex\":1144,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "project_employee_id,project_id,employee_id,design_phase,plan_work_hours,real_work_hours,plan_integral,real_integral,plan_start_date,plan_end_date,start_date,end_date,work_content,alternate_field1,alternate_field2,alternate_field3,cost,settlement,employee_achieve_integral_return,stage_id,flag,business_id,employee_no,employee_name,department_id,role_id,grade_id,employee_password,mobile,phone,qq,email,onboard_date,resignation_date,status,usable_status,is_department,photo,gender,autograph,age,birth,card,address,locked";
	private final static String[] fieldNames = { "business_id", "project_id", "process_status", "status"};
}
