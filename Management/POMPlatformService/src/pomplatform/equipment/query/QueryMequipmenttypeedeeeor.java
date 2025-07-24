package pomplatform.equipment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.equipment.bean.BaseMequipmenttypeedeeeor;
import pomplatform.equipment.bean.ConditionMequipmenttypeedeeeor;

public class QueryMequipmenttypeedeeeor extends AbstractQuery<BaseMequipmenttypeedeeeor, ConditionMequipmenttypeedeeeor>
{

	private static final Logger __logger = Logger.getLogger(QueryMequipmenttypeedeeeor.class);

	public QueryMequipmenttypeedeeeor() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("equipment_types.equipment_type_id");
	}

	@Override
	public BaseCollection<BaseMequipmenttypeedeeeor> executeQuery( KeyValuePair[] replacements, ConditionMequipmenttypeedeeeor condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getName(), 
				condition.getType(), 
				condition.getEnabled()
			);
	}

	public BaseCollection<BaseMequipmenttypeedeeeor> runQuery( KeyValuePair[] replacements, ConditionMequipmenttypeedeeeor condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getName(), 
				condition.getType(), 
				condition.getEnabled()
			);
	}

	public BaseCollection<BaseMequipmenttypeedeeeor> execute( KeyValuePair[] replacements, ConditionMequipmenttypeedeeeor condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getName(), 
				condition.getType(), 
				condition.getEnabled()
			);
	}

	@Override
	public BaseMequipmenttypeedeeeor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMequipmenttypeedeeeor __base = new BaseMequipmenttypeedeeeor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEquipmentTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCount(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFlag(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUpdatePerson(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentName(GenericBase.__getString(val));
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
		if(args[2] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[2]));
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

	private final static String __SQLText = "SELECT equipment_types.equipment_type_id,equipment_types.name, equipment_types.type, equipment_types.price, equipment_types.count, equipment_types.enabled AS flag, equipment_types.update_time, equipment_types.update_person, employees.employee_name, departments.department_name FROM equipment_types LEFT JOIN employees ON equipment_types.update_person = employees.employee_id LEFT JOIN departments ON departments.department_id = employees.department_id WHERE is_delete = FALSE and equipment_types.equipment_type_id = ? and equipment_types.type = ? and equipment_types.enabled = ? order by equipment_types.equipment_type_id" ;
	private final static String __originalSQL = "SELECT equipment_types.equipment_type_id,equipment_types.name, equipment_types.type, equipment_types.price, equipment_types.count, equipment_types.enabled AS flag, equipment_types.update_time, equipment_types.update_person, employees.employee_name, departments.department_name FROM equipment_types LEFT JOIN employees ON equipment_types.update_person = employees.employee_id LEFT JOIN departments ON departments.department_id = employees.department_id WHERE is_delete = FALSE and equipment_types.equipment_type_id= :name and equipment_types.type = :type and equipment_types.enabled = :enabled order by equipment_types.equipment_type_id";
	private final static String[] __queryConditions = {
			"[{\"fullCondition\": \"is_delete = FALSE and equipment_types.equipment_type_id= :name and equipment_types.type = :type and equipment_types.enabled = :enabled\",\"startIndex\": 458,\"stopIndex\":591,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"is_delete = FALSE\",\"nextToken\":\"and\",\"startIndex\": 458,\"stopIndex\":474,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"equipment_types.equipment_type_id= :name\",\"fullFieldName\":\"equipment_types.equipment_type_id\",\"operationName\":\"=\",\"variableName\":\"name\",\"nextToken\":\"and\",\"startIndex\": 480,\"stopIndex\":519,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"equipment_types.type = :type\",\"fullFieldName\":\"equipment_types.type\",\"operationName\":\"=\",\"variableName\":\"type\",\"nextToken\":\"and\",\"startIndex\": 525,\"stopIndex\":552,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"equipment_types.enabled = :enabled\",\"fullFieldName\":\"equipment_types.enabled\",\"operationName\":\"=\",\"variableName\":\"enabled\",\"startIndex\": 558,\"stopIndex\":591,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "equipment_type_id,name,type,price,count,flag,update_time,update_person,employee_name,department_name";
	private final static String[] fieldNames = { "name", "type", "enabled"};
}
