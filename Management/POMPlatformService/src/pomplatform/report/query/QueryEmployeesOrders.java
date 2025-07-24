package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseEmployeesOrders;
import pomplatform.report.bean.ConditionEmployeesOrders;

public class QueryEmployeesOrders extends AbstractQuery<BaseEmployeesOrders, ConditionEmployeesOrders>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeesOrders.class);

	public QueryEmployeesOrders() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT e.employee_no");
	}

	@Override
	public BaseCollection<BaseEmployeesOrders> executeQuery( KeyValuePair[] replacements, ConditionEmployeesOrders condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getDepartmentId(), 
				condition.getEmployeeName(), 
				condition.getContractCode(), 
				condition.getProjectName(), 
				condition.getPstatus()
			);
	}

	public BaseCollection<BaseEmployeesOrders> runQuery( KeyValuePair[] replacements, ConditionEmployeesOrders condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getDepartmentId(), 
				condition.getEmployeeName(), 
				condition.getContractCode(), 
				condition.getProjectName(), 
				condition.getPstatus()
			);
	}

	public BaseCollection<BaseEmployeesOrders> execute( KeyValuePair[] replacements, ConditionEmployeesOrders condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getDepartmentId(), 
				condition.getEmployeeName(), 
				condition.getContractCode(), 
				condition.getProjectName(), 
				condition.getPstatus()
			);
	}

	@Override
	public BaseEmployeesOrders generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeesOrders __base = new BaseEmployeesOrders();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEstatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPstatus(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setInt(count++, GenericBase.__getInt(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
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

	private final static String __SQLText = "SELECT DISTINCT e.employee_no, e.employee_name, e.department_id, e.status AS estatus, P.contract_code, P.project_name, P.status AS pstatus FROM project_employees pe LEFT JOIN employees e ON e.employee_id = pe.employee_id LEFT JOIN personnel_business pb ON pe.business_id = pb.personnel_business_id LEFT JOIN projects P ON P.project_id = pe.project_id WHERE 1 = 1 and ((is_completed = TRUE AND pe.status = 2 ) or (P.project_name LIKE '%项目管理%')) and e.department_id = ? and e.employee_name like ? and P.contract_code like ? and P.project_name like ? and P.status = ?" ;
	private final static String __originalSQL = "SELECT DISTINCT e.employee_no, e.employee_name, e.department_id, e.status AS estatus, P.contract_code, P.project_name, P.status AS pstatus FROM project_employees pe LEFT JOIN employees e ON e.employee_id = pe.employee_id LEFT JOIN personnel_business pb ON pe.business_id = pb.personnel_business_id LEFT JOIN projects P ON P.project_id = pe.project_id WHERE 1 = 1 AND ((is_completed = TRUE AND pe.status = 2 ) or (P.project_name LIKE '%项目管理%')) AND e.department_id =:department_id AND e.employee_name LIKE :employee_name AND P.contract_code LIKE :contract_code AND P.project_name LIKE :project_name AND P.status =:pstatus";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"1 = 1 AND ((is_completed = TRUE AND pe.status = 2 ) or (P.project_name LIKE '%项目管理%')) AND e.department_id =:department_id AND e.employee_name LIKE :employee_name AND P.contract_code LIKE :contract_code AND P.project_name LIKE :project_name AND P.status =:pstatus\",\"startIndex\": 357,\"stopIndex\":619,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"1 = 1\",\"nextToken\":\"and\",\"startIndex\": 357,\"stopIndex\":361,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"((is_completed = TRUE AND pe.status = 2 ) or (P.project_name LIKE '%项目管理%'))\",\"nextToken\":\"and\",\"startIndex\": 367,\"stopIndex\":442,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"e.department_id =:department_id\",\"fullFieldName\":\"e.department_id\",\"operationName\":\"=\",\"variableName\":\"departmentId\",\"nextToken\":\"and\",\"startIndex\": 448,\"stopIndex\":478,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"e.employee_name LIKE :employee_name\",\"fullFieldName\":\"e.employee_name\",\"operationName\":\"like\",\"variableName\":\"employeeName\",\"nextToken\":\"and\",\"startIndex\": 484,\"stopIndex\":518,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"P.contract_code LIKE :contract_code\",\"fullFieldName\":\"P.contract_code\",\"operationName\":\"like\",\"variableName\":\"contractCode\",\"nextToken\":\"and\",\"startIndex\": 524,\"stopIndex\":558,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"P.project_name LIKE :project_name\",\"fullFieldName\":\"P.project_name\",\"operationName\":\"like\",\"variableName\":\"projectName\",\"nextToken\":\"and\",\"startIndex\": 564,\"stopIndex\":596,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"P.status =:pstatus\",\"fullFieldName\":\"P.status\",\"operationName\":\"=\",\"variableName\":\"pstatus\",\"startIndex\": 602,\"stopIndex\":619,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "employee_no,employee_name,department_id,estatus,contract_code,project_name,pstatus";
	private final static String[] fieldNames = { "department_id", "employee_name", "contract_code", "project_name", "pstatus"};
}
