package pomplatform.workinghour.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workinghour.bean.BaseWorkingHourManage;
import pomplatform.workinghour.bean.ConditionWorkingHourManage;

public class QueryWorkingHourManage extends AbstractQuery<BaseWorkingHourManage, ConditionWorkingHourManage>
{

	private static final Logger __logger = Logger.getLogger(QueryWorkingHourManage.class);

	public QueryWorkingHourManage() throws java.sql.SQLException 
	{
		setParameterNumber(10);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("working_hour_id");
	}

	@Override
	public BaseCollection<BaseWorkingHourManage> executeQuery( KeyValuePair[] replacements, ConditionWorkingHourManage condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getEmployeeId(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getDepartmentId(), 
				condition.getPlateId(), 
				condition.getCompanyId(), 
				condition.getStartWorkDate(), 
				condition.getEndWorkDate()
			);
	}

	public BaseCollection<BaseWorkingHourManage> runQuery( KeyValuePair[] replacements, ConditionWorkingHourManage condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getEmployeeId(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getDepartmentId(), 
				condition.getPlateId(), 
				condition.getCompanyId(), 
				condition.getStartWorkDate(), 
				condition.getEndWorkDate()
			);
	}

	public BaseCollection<BaseWorkingHourManage> execute( KeyValuePair[] replacements, ConditionWorkingHourManage condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getEmployeeId(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getDepartmentId(), 
				condition.getPlateId(), 
				condition.getCompanyId(), 
				condition.getStartWorkDate(), 
				condition.getEndWorkDate()
			);
	}

	@Override
	public BaseWorkingHourManage generateBase(Object[] __data) throws java.sql.SQLException {
		BaseWorkingHourManage __base = new BaseWorkingHourManage();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setWorkingHourId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWorkHour(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setWorkDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setIsLock(GenericBase.__getBoolean(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[8]));
		if(args[9] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[9]));
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

	private final static String __SQLText = "select working_hour_id, project_id, project_code, project_name, employee_id, employee_no, employee_name, department_id, plate_id, company_id, work_hour, work_date, remark, create_time, is_lock from working_hours where project_code like ? and project_name like ? and employee_id = ? and employee_no like ? and employee_name like ? and department_id = ? and plate_id = ? and company_id = ? and work_date between ? and ? ORDER BY create_time desc" ;
	private final static String __originalSQL = "select working_hour_id, project_id, project_code, project_name, employee_id, employee_no, employee_name, department_id, plate_id, company_id, work_hour, work_date, remark, create_time, is_lock from working_hours where project_code like :project_code and project_name like :project_name and employee_id = :employee_id and employee_no like :employee_no and employee_name like :employee_name and department_id = :department_id and plate_id = :plate_id and company_id = :company_id and work_date between :start_work_date and :end_work_date ORDER BY create_time desc";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"project_code like :project_code and project_name like :project_name and employee_id = :employee_id and employee_no like :employee_no and employee_name like :employee_name and department_id = :department_id and plate_id = :plate_id and company_id = :company_id and work_date between :start_work_date and :end_work_date\",\"startIndex\": 218,\"stopIndex\":534,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"project_code like :project_code\",\"fullFieldName\":\"project_code\",\"operationName\":\"like\",\"variableName\":\"projectCode\",\"nextToken\":\"and\",\"startIndex\": 218,\"stopIndex\":248,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"project_name like :project_name\",\"fullFieldName\":\"project_name\",\"operationName\":\"like\",\"variableName\":\"projectName\",\"nextToken\":\"and\",\"startIndex\": 254,\"stopIndex\":284,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"employee_id = :employee_id\",\"fullFieldName\":\"employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 290,\"stopIndex\":315,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"employee_no like :employee_no\",\"fullFieldName\":\"employee_no\",\"operationName\":\"like\",\"variableName\":\"employeeNo\",\"nextToken\":\"and\",\"startIndex\": 321,\"stopIndex\":349,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"employee_name like :employee_name\",\"fullFieldName\":\"employee_name\",\"operationName\":\"like\",\"variableName\":\"employeeName\",\"nextToken\":\"and\",\"startIndex\": 355,\"stopIndex\":387,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"department_id = :department_id\",\"fullFieldName\":\"department_id\",\"operationName\":\"=\",\"variableName\":\"departmentId\",\"nextToken\":\"and\",\"startIndex\": 393,\"stopIndex\":422,\"variableNum\": 5,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"plate_id = :plate_id\",\"fullFieldName\":\"plate_id\",\"operationName\":\"=\",\"variableName\":\"plateId\",\"nextToken\":\"and\",\"startIndex\": 428,\"stopIndex\":447,\"variableNum\": 6,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"company_id = :company_id\",\"fullFieldName\":\"company_id\",\"operationName\":\"=\",\"variableName\":\"companyId\",\"nextToken\":\"and\",\"startIndex\": 453,\"stopIndex\":476,\"variableNum\": 7,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"work_date between :start_work_date and :end_work_date\",\"fullFieldName\":\"work_date\",\"operationName\":\"between\",\"variableName\":\"startWorkDate\",\"secondName\":\"endWorkDate\",\"startIndex\": 482,\"stopIndex\":534,\"variableNum\": 8,\"variableCount\": 2,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "working_hour_id,project_id,project_code,project_name,employee_id,employee_no,employee_name,department_id,plate_id,company_id,work_hour,work_date,remark,create_time,is_lock";
	private final static String[] fieldNames = { "project_code", "project_name", "employee_id", "employee_no", "employee_name", "department_id", "plate_id", "company_id", "start_work_date", "end_work_date"};
}
