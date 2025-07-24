package pomplatform.selectGridEmployeeValue.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.selectGridEmployeeValue.bean.BaseSelectGridEmployeeValue;
import pomplatform.selectGridEmployeeValue.bean.ConditionSelectGridEmployeeValue;

public class QuerySelectGridEmployeeValue extends AbstractQuery<BaseSelectGridEmployeeValue, ConditionSelectGridEmployeeValue>
{

	private static final Logger __logger = Logger.getLogger(QuerySelectGridEmployeeValue.class);

	public QuerySelectGridEmployeeValue() throws java.sql.SQLException
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_id");
	}

	@Override
	public BaseCollection<BaseSelectGridEmployeeValue> executeQuery( KeyValuePair[] replacements, ConditionSelectGridEmployeeValue condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements,
				condition.getStatus(),
				condition.getEmployeeId(),
				condition.getEmployeeNo(),
				condition.getRoleId(),
				condition.getEmployeeName(),
				condition.getEmployeeNameEn()
		);
	}

	public BaseCollection<BaseSelectGridEmployeeValue> runQuery( KeyValuePair[] replacements, ConditionSelectGridEmployeeValue condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements,
				condition.getStatus(),
				condition.getEmployeeId(),
				condition.getEmployeeNo(),
				condition.getRoleId(),
				condition.getEmployeeName(),
				condition.getEmployeeNameEn()
		);
	}

	public BaseCollection<BaseSelectGridEmployeeValue> execute( KeyValuePair[] replacements, ConditionSelectGridEmployeeValue condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements,
				condition.getStatus(),
				condition.getEmployeeId(),
				condition.getEmployeeNo(),
				condition.getRoleId(),
				condition.getEmployeeName(),
				condition.getEmployeeNameEn()
		);
	}

	@Override
	public BaseSelectGridEmployeeValue generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSelectGridEmployeeValue __base = new BaseSelectGridEmployeeValue();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRoleId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMobile(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setQq(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmail(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPhoto(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCard(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setUserAcct(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNameEn(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWorkAddress(GenericBase.__getString(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
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

	private final static String __SQLText = "SELECT employee_id, employee_no, employee_name, department_id, role_id, mobile, phone, qq, email, photo, card, user_acct, employee_name_en, work_address FROM employees WHERE status = ? and employee_id = ? and employee_no like ? and role_id = ? and employee_name like ? and employee_name_en like ? and employee_id > 0" ;
	private final static String __originalSQL = "SELECT employee_id, employee_no, employee_name, department_id, role_id, mobile, phone, qq, email, photo, card, user_acct, employee_name_en, work_address FROM employees WHERE status = :status AND employee_id = :employee_id AND employee_no LIKE :employee_no AND role_id = :role_id AND employee_name LIKE :employee_name AND employee_name_en LIKE :employee_name_en AND employee_id > 0";
	private final static String[] __queryConditions = {
			"[{\"fullCondition\": \"status = :status AND employee_id = :employee_id AND employee_no LIKE :employee_no AND role_id = :role_id AND employee_name LIKE :employee_name AND employee_name_en LIKE :employee_name_en AND employee_id > 0\",\"startIndex\": 174,\"stopIndex\":379,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"status = :status\",\"fullFieldName\":\"status\",\"operationName\":\"=\",\"variableName\":\"status\",\"nextToken\":\"and\",\"startIndex\": 174,\"stopIndex\":189,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"employee_id = :employee_id\",\"fullFieldName\":\"employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 195,\"stopIndex\":220,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"employee_no LIKE :employee_no\",\"fullFieldName\":\"employee_no\",\"operationName\":\"like\",\"variableName\":\"employeeNo\",\"nextToken\":\"and\",\"startIndex\": 226,\"stopIndex\":254,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"role_id = :role_id\",\"fullFieldName\":\"role_id\",\"operationName\":\"=\",\"variableName\":\"roleId\",\"nextToken\":\"and\",\"startIndex\": 260,\"stopIndex\":277,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"employee_name LIKE :employee_name\",\"fullFieldName\":\"employee_name\",\"operationName\":\"like\",\"variableName\":\"employeeName\",\"nextToken\":\"and\",\"startIndex\": 283,\"stopIndex\":315,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"employee_name_en LIKE :employee_name_en\",\"fullFieldName\":\"employee_name_en\",\"operationName\":\"like\",\"variableName\":\"employeeNameEn\",\"nextToken\":\"and\",\"startIndex\": 321,\"stopIndex\":359,\"variableNum\": 5,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"employee_id > 0\",\"startIndex\": 365,\"stopIndex\":379,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,department_id,role_id,mobile,phone,qq,email,photo,card,user_acct,employee_name_en,work_address";
	private final static String[] fieldNames = { "status", "employee_id", "employee_no", "role_id", "employee_name", "employee_name_en"};
}
