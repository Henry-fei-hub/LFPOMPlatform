package pomplatform.equipment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.equipment.bean.BaseEquipmentDetail;
import pomplatform.equipment.bean.ConditionEquipmentDetail;

public class QueryEquipmentDetail extends AbstractQuery<BaseEquipmentDetail, ConditionEquipmentDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryEquipmentDetail.class);

	public QueryEquipmentDetail() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("equipment_records.operation_type");
	}

	@Override
	public BaseCollection<BaseEquipmentDetail> executeQuery( KeyValuePair[] replacements, ConditionEquipmentDetail condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getDepartmentId(), 
				condition.getEmployeeId(), 
				condition.getNextAuditor(), 
				condition.getEquipmentName(), 
				condition.getOperationType(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	public BaseCollection<BaseEquipmentDetail> runQuery( KeyValuePair[] replacements, ConditionEquipmentDetail condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getDepartmentId(), 
				condition.getEmployeeId(), 
				condition.getNextAuditor(), 
				condition.getEquipmentName(), 
				condition.getOperationType(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	public BaseCollection<BaseEquipmentDetail> execute( KeyValuePair[] replacements, ConditionEquipmentDetail condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getDepartmentId(), 
				condition.getEmployeeId(), 
				condition.getNextAuditor(), 
				condition.getEquipmentName(), 
				condition.getOperationType(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseEquipmentDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEquipmentDetail __base = new BaseEquipmentDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setOperationType(GenericBase.__getShort(val));
		if((val = __data[count++]) != null) __base.setName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCount(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFollowStatus(GenericBase.__getShort(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setNextAuditor(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperationTime(GenericBase.__getDateFromSQL(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setShort(count++, GenericBase.__getShort(args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[6]));
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

	private final static String __SQLText = "SELECT equipment_records.operation_type, equipment_types.NAME, equipment_records.COUNT, equipment_records.follow_status, employees.employee_no, employees.employee_name, departments.department_name, Personnel_Business.next_auditor, equipment_records.operation_time FROM equipment_records LEFT JOIN equipment_types ON equipment_types.equipment_type_id = equipment_records.equipment_id LEFT JOIN employees ON equipment_records.operation_person = employees.employee_id LEFT JOIN departments ON departments.department_id = employees.department_id LEFT JOIN Personnel_Business ON equipment_records.follow_id = Personnel_Business.personnel_business_id WHERE equipment_records.follow_status = 3 and equipment_records.operation_type IN ( 0, 5 ) and departments.department_id = ? and employees.employee_id = ? and Personnel_Business.next_auditor = ? and equipment_types.NAME like ? and equipment_records.operation_type = ? and equipment_records.operation_time between ? and ? ORDER BY equipment_records.operation_time DESC, follow_id DESC" ;
	private final static String __originalSQL = "SELECT equipment_records.operation_type, equipment_types.NAME, equipment_records.COUNT, equipment_records.follow_status, employees.employee_no, employees.employee_name, departments.department_name, Personnel_Business.next_auditor, equipment_records.operation_time FROM equipment_records LEFT JOIN equipment_types ON equipment_types.equipment_type_id = equipment_records.equipment_id LEFT JOIN employees ON equipment_records.operation_person = employees.employee_id LEFT JOIN departments ON departments.department_id = employees.department_id LEFT JOIN Personnel_Business ON equipment_records.follow_id = Personnel_Business.personnel_business_id WHERE equipment_records.follow_status = 3 AND equipment_records.operation_type IN ( 0, 5 ) AND departments.department_id = :department_id AND employees.employee_id = :employee_id AND Personnel_Business.next_auditor = :next_auditor AND equipment_types.NAME LIKE :equipment_name AND equipment_records.operation_type = :operation_type AND equipment_records.operation_time BETWEEN :start_date AND :end_date ORDER BY equipment_records.operation_time DESC, follow_id DESC";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"equipment_records.follow_status = 3 AND equipment_records.operation_type IN ( 0, 5 ) AND departments.department_id = :department_id AND employees.employee_id = :employee_id AND Personnel_Business.next_auditor = :next_auditor AND equipment_types.NAME LIKE :equipment_name AND equipment_records.operation_type = :operation_type AND equipment_records.operation_time BETWEEN :start_date AND :end_date\",\"startIndex\": 651,\"stopIndex\":1046,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"equipment_records.follow_status = 3\",\"nextToken\":\"and\",\"startIndex\": 651,\"stopIndex\":685,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"equipment_records.operation_type IN ( 0, 5 )\",\"nextToken\":\"and\",\"startIndex\": 691,\"stopIndex\":734,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"departments.department_id = :department_id\",\"fullFieldName\":\"departments.department_id\",\"operationName\":\"=\",\"variableName\":\"departmentId\",\"nextToken\":\"and\",\"startIndex\": 740,\"stopIndex\":781,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"employees.employee_id = :employee_id\",\"fullFieldName\":\"employees.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 787,\"stopIndex\":822,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"Personnel_Business.next_auditor = :next_auditor\",\"fullFieldName\":\"Personnel_Business.next_auditor\",\"operationName\":\"=\",\"variableName\":\"nextAuditor\",\"nextToken\":\"and\",\"startIndex\": 828,\"stopIndex\":874,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"equipment_types.NAME LIKE :equipment_name\",\"fullFieldName\":\"equipment_types.NAME\",\"operationName\":\"like\",\"variableName\":\"equipmentName\",\"nextToken\":\"and\",\"startIndex\": 880,\"stopIndex\":920,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"equipment_records.operation_type = :operation_type\",\"fullFieldName\":\"equipment_records.operation_type\",\"operationName\":\"=\",\"variableName\":\"operationType\",\"nextToken\":\"and\",\"startIndex\": 926,\"stopIndex\":975,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"equipment_records.operation_time BETWEEN :start_date AND :end_date\",\"fullFieldName\":\"equipment_records.operation_time\",\"operationName\":\"between\",\"variableName\":\"startDate\",\"secondName\":\"endDate\",\"startIndex\": 981,\"stopIndex\":1046,\"variableNum\": 5,\"variableCount\": 2,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "operation_type,name,count,follow_status,employee_no,employee_name,department_name,next_auditor,operation_time";
	private final static String[] fieldNames = { "department_id", "employee_id", "next_auditor", "equipment_name", "operation_type", "start_date", "end_date"};
}
