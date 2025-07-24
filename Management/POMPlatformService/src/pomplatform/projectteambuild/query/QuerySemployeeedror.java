package pomplatform.projectteambuild.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectteambuild.bean.BaseSemployeeedror;
import pomplatform.projectteambuild.bean.ConditionSemployeeedror;

public class QuerySemployeeedror extends AbstractQuery<BaseSemployeeedror, ConditionSemployeeedror>
{

	private static final Logger __logger = Logger.getLogger(QuerySemployeeedror.class);

	public QuerySemployeeedror() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.employee_id");
	}

	@Override
	public BaseCollection<BaseSemployeeedror> executeQuery( KeyValuePair[] replacements, ConditionSemployeeedror condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getEmployeeName(), 
				condition.getDepartmentId(), 
				condition.getRoleId(), 
				condition.getGradeId(), 
				condition.getPlateId()
			);
	}

	public BaseCollection<BaseSemployeeedror> runQuery( KeyValuePair[] replacements, ConditionSemployeeedror condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getEmployeeName(), 
				condition.getDepartmentId(), 
				condition.getRoleId(), 
				condition.getGradeId(), 
				condition.getPlateId()
			);
	}

	public BaseCollection<BaseSemployeeedror> execute( KeyValuePair[] replacements, ConditionSemployeeedror condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getEmployeeName(), 
				condition.getDepartmentId(), 
				condition.getRoleId(), 
				condition.getGradeId(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseSemployeeedror generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSemployeeedror __base = new BaseSemployeeedror();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
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
	public int setStatementParameters(int count, Object ... args) throws java.sql.SQLException {

		int index = 0;
		for(int ii = 0; ii < args.length; ii++){
			if(args[ii] == null) continue;
			index++;
			__logger.info(String.format("%1$s = [%2$s]", fieldNames[ii], args[ii]));
		}
		if( index > 0 ) __logger.info("=================================================");
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
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

	private final static String __SQLText = "SELECT e.employee_id, e.employee_no, e.employee_name, e.department_id, e.role_id, e.grade_id, e.employee_password, e.mobile, e.phone, e.qq, e.email, e.onboard_date, e.resignation_date, e.status, e.usable_status, e.is_department, e.photo, e.gender, e.autograph, e.age, e.birth, e.card, e.address, e.locked FROM employees e WHERE e.employee_id > 0 and e.status = 0 and e.employee_name like ? and e.department_id IN ( SELECT child_id FROM department_ids WHERE department_id = ? ) and e.role_id = ? and e.grade_id = ? and e.plate_id = ? and e.plate_id <> 0 ORDER BY e.grade_id" ;
	private final static String __originalSQL = "SELECT e.employee_id, e.employee_no, e.employee_name, e.department_id, e.role_id, e.grade_id, e.employee_password, e.mobile, e.phone, e.qq, e.email, e.onboard_date, e.resignation_date, e.status, e.usable_status, e.is_department, e.photo, e.gender, e.autograph, e.age, e.birth, e.card, e.address, e.locked FROM employees e WHERE e.employee_id > 0 AND e.status = 0 AND e.employee_name LIKE :employee_name AND e.department_id IN ( SELECT child_id FROM department_ids WHERE department_id = :department_id ) AND e.role_id = :role_id AND e.grade_id = :grade_id AND e.plate_id = :plate_id AND e.plate_id <> 0 ORDER BY e.grade_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"e.employee_id > 0 AND e.status = 0 AND e.employee_name LIKE :employee_name AND e.department_id IN ( SELECT child_id FROM department_ids WHERE department_id = :department_id ) AND e.role_id = :role_id AND e.grade_id = :grade_id AND e.plate_id = :plate_id AND e.plate_id <> 0\",\"startIndex\": 328,\"stopIndex\":600,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"e.employee_id > 0\",\"nextToken\":\"and\",\"startIndex\": 328,\"stopIndex\":344,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"e.status = 0\",\"nextToken\":\"and\",\"startIndex\": 350,\"stopIndex\":361,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"e.employee_name LIKE :employee_name\",\"fullFieldName\":\"e.employee_name\",\"operationName\":\"like\",\"variableName\":\"employeeName\",\"nextToken\":\"and\",\"startIndex\": 367,\"stopIndex\":401,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"e.department_id IN ( SELECT child_id FROM department_ids WHERE department_id = :department_id )\",\"nextToken\":\"and\",\"startIndex\": 407,\"stopIndex\":501,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"department_id = :department_id\",\"startIndex\": 470,\"stopIndex\":499,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"department_id = :department_id\",\"fullFieldName\":\"department_id\",\"operationName\":\"=\",\"variableName\":\"departmentId\",\"startIndex\": 470,\"stopIndex\":499,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]},{\"fullCondition\": \"e.role_id = :role_id\",\"fullFieldName\":\"e.role_id\",\"operationName\":\"=\",\"variableName\":\"roleId\",\"nextToken\":\"and\",\"startIndex\": 507,\"stopIndex\":526,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"e.grade_id = :grade_id\",\"fullFieldName\":\"e.grade_id\",\"operationName\":\"=\",\"variableName\":\"gradeId\",\"nextToken\":\"and\",\"startIndex\": 532,\"stopIndex\":553,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"e.plate_id = :plate_id\",\"fullFieldName\":\"e.plate_id\",\"operationName\":\"=\",\"variableName\":\"plateId\",\"nextToken\":\"and\",\"startIndex\": 559,\"stopIndex\":580,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"e.plate_id <> 0\",\"startIndex\": 586,\"stopIndex\":600,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,department_id,role_id,grade_id,employee_password,mobile,phone,qq,email,onboard_date,resignation_date,status,usable_status,is_department,photo,gender,autograph,age,birth,card,address,locked";
	private final static String[] fieldNames = { "employee_name", "department_id", "role_id", "grade_id", "plate_id"};
}
