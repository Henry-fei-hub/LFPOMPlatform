package pomplatform.plateproductionvalue.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.plateproductionvalue.bean.BaseProductionValueCoefficient;
import pomplatform.plateproductionvalue.bean.ConditionProductionValueCoefficient;

public class QueryProductionValueCoefficient extends AbstractQuery<BaseProductionValueCoefficient, ConditionProductionValueCoefficient>
{

	private static final Logger __logger = Logger.getLogger(QueryProductionValueCoefficient.class);

	public QueryProductionValueCoefficient() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pvc.production_value_coefficient_id");
	}

	@Override
	public BaseCollection<BaseProductionValueCoefficient> executeQuery( KeyValuePair[] replacements, ConditionProductionValueCoefficient condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getProductionValueCoefficientTypeId()
			);
	}

	public BaseCollection<BaseProductionValueCoefficient> runQuery( KeyValuePair[] replacements, ConditionProductionValueCoefficient condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getProductionValueCoefficientTypeId()
			);
	}

	public BaseCollection<BaseProductionValueCoefficient> execute( KeyValuePair[] replacements, ConditionProductionValueCoefficient condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getProductionValueCoefficientTypeId()
			);
	}

	@Override
	public BaseProductionValueCoefficient generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProductionValueCoefficient __base = new BaseProductionValueCoefficient();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProductionValueCoefficientId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProductionValueCoefficientTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProductionMin(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProductionMax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIntervalLines(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIntervalRange(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCoefficient(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperationTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "SELECT pvc.production_value_coefficient_id, pvc.production_value_coefficient_type_id, pvc.production_min, pvc.production_max, pvc.interval_lines, pvc.interval_range, pvc.coefficient, pvc.employee_id, pvc.operation_time, pvc.create_time FROM production_value_coefficients AS pvc WHERE pvc.production_value_coefficient_type_id = ? ORDER BY pvc.create_time DESC" ;
	private final static String __originalSQL = "SELECT pvc.production_value_coefficient_id, pvc.production_value_coefficient_type_id, pvc.production_min, pvc.production_max, pvc.interval_lines, pvc.interval_range, pvc.coefficient, pvc.employee_id, pvc.operation_time, pvc.create_time FROM production_value_coefficients AS pvc WHERE pvc.production_value_coefficient_type_id = :production_value_coefficient_type_id ORDER BY pvc.create_time DESC";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"pvc.production_value_coefficient_type_id = :production_value_coefficient_type_id\",\"startIndex\": 284,\"stopIndex\":363,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"pvc.production_value_coefficient_type_id = :production_value_coefficient_type_id\",\"fullFieldName\":\"pvc.production_value_coefficient_type_id\",\"operationName\":\"=\",\"variableName\":\"productionValueCoefficientTypeId\",\"startIndex\": 284,\"stopIndex\":363,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "production_value_coefficient_id,production_value_coefficient_type_id,production_min,production_max,interval_lines,interval_range,coefficient,employee_id,operation_time,create_time";
	private final static String[] fieldNames = { "production_value_coefficient_type_id"};
}
