package pomplatform.equipment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.equipment.bean.BaseMequipmentrecordedeor;
import pomplatform.equipment.bean.ConditionMequipmentrecordedeor;

public class QueryMequipmentrecordedeor extends AbstractQuery<BaseMequipmentrecordedeor, ConditionMequipmentrecordedeor>
{

	private static final Logger __logger = Logger.getLogger(QueryMequipmentrecordedeor.class);

	public QueryMequipmentrecordedeor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("equipment_records.operation_type");
	}

	@Override
	public BaseCollection<BaseMequipmentrecordedeor> executeQuery( KeyValuePair[] replacements, ConditionMequipmentrecordedeor condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getEquipmentId()
			);
	}

	public BaseCollection<BaseMequipmentrecordedeor> runQuery( KeyValuePair[] replacements, ConditionMequipmentrecordedeor condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getEquipmentId()
			);
	}

	public BaseCollection<BaseMequipmentrecordedeor> execute( KeyValuePair[] replacements, ConditionMequipmentrecordedeor condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getEquipmentId()
			);
	}

	@Override
	public BaseMequipmentrecordedeor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMequipmentrecordedeor __base = new BaseMequipmentrecordedeor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setOperationType(GenericBase.__getShort(val));
		if((val = __data[count++]) != null) __base.setCount(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFollowStatus(GenericBase.__getShort(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentName(GenericBase.__getString(val));
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

	private final static String __SQLText = "select equipment_records.operation_type, equipment_records.count, equipment_records.follow_status, employees.employee_name , departments.department_name , equipment_records.operation_time from equipment_records left JOIN employees on equipment_records.operation_person = employees.employee_id left join departments on departments.department_id = employees.department_id where equipment_records.equipment_id = ? order by equipment_records.operation_time desc , follow_id desc" ;
	private final static String __originalSQL = "select equipment_records.operation_type, equipment_records.count, equipment_records.follow_status, employees.employee_name , departments.department_name , equipment_records.operation_time from equipment_records left JOIN employees on equipment_records.operation_person = employees.employee_id left join departments on departments.department_id = employees.department_id where equipment_records.equipment_id = :equipment_id order by equipment_records.operation_time desc , follow_id desc";
	private final static String[] __queryConditions = {
			"[{\"fullCondition\": \"equipment_records.equipment_id = :equipment_id\",\"startIndex\": 376,\"stopIndex\":421,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"equipment_records.equipment_id = :equipment_id\",\"fullFieldName\":\"equipment_records.equipment_id\",\"operationName\":\"=\",\"variableName\":\"equipmentId\",\"startIndex\": 376,\"stopIndex\":421,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "operation_type,count,follow_status,employee_name,department_name,operation_time";
	private final static String[] fieldNames = { "equipment_id"};
}
