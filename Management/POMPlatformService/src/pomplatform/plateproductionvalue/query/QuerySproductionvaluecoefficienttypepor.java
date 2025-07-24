package pomplatform.plateproductionvalue.query;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import org.apache.log4j.Logger;
import pomplatform.plateproductionvalue.bean.BaseSproductionvaluecoefficienttypepor;
import pomplatform.plateproductionvalue.bean.ConditionSproductionvaluecoefficienttypepor;

public class QuerySproductionvaluecoefficienttypepor extends AbstractQuery<BaseSproductionvaluecoefficienttypepor, ConditionSproductionvaluecoefficienttypepor>
{

	private static final Logger __logger = Logger.getLogger(QuerySproductionvaluecoefficienttypepor.class);

	public QuerySproductionvaluecoefficienttypepor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("production_value_coefficient_type_id");
	}

	@Override
	public BaseCollection<BaseSproductionvaluecoefficienttypepor> executeQuery( KeyValuePair[] replacements, ConditionSproductionvaluecoefficienttypepor condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getProductionValueCoefficientTypeId()
			);
	}

	public BaseCollection<BaseSproductionvaluecoefficienttypepor> runQuery( KeyValuePair[] replacements, ConditionSproductionvaluecoefficienttypepor condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getProductionValueCoefficientTypeId()
			);
	}

	public BaseCollection<BaseSproductionvaluecoefficienttypepor> execute( KeyValuePair[] replacements, ConditionSproductionvaluecoefficienttypepor condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getProductionValueCoefficientTypeId()
			);
	}

	@Override
	public BaseSproductionvaluecoefficienttypepor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSproductionvaluecoefficienttypepor __base = new BaseSproductionvaluecoefficienttypepor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProductionValueCoefficientTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCoefficientType(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT production_value_coefficient_type_id, coefficient_type FROM production_value_coefficient_type where production_value_coefficient_type_id = ?" ;
	private final static String __originalSQL = "SELECT production_value_coefficient_type_id, coefficient_type FROM production_value_coefficient_type where production_value_coefficient_type_id = :production_value_coefficient_type_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"production_value_coefficient_type_id = :production_value_coefficient_type_id\",\"startIndex\": 107,\"stopIndex\":182,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"production_value_coefficient_type_id = :production_value_coefficient_type_id\",\"fullFieldName\":\"production_value_coefficient_type_id\",\"operationName\":\"=\",\"variableName\":\"productionValueCoefficientTypeId\",\"startIndex\": 107,\"stopIndex\":182,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "production_value_coefficient_type_id,coefficient_type";
	private final static String[] fieldNames = { "production_value_coefficient_type_id"};
}
