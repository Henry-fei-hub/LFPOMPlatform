package pomplatform.plateproductionvalue.query;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import org.apache.log4j.Logger;
import pomplatform.plateproductionvalue.bean.BaseSproductionvaluecoefficienttypepcor;
import pomplatform.plateproductionvalue.bean.ConditionSproductionvaluecoefficienttypepcor;

public class QuerySproductionvaluecoefficienttypepcor extends AbstractQuery<BaseSproductionvaluecoefficienttypepcor, ConditionSproductionvaluecoefficienttypepcor>
{

	private static final Logger __logger = Logger.getLogger(QuerySproductionvaluecoefficienttypepcor.class);

	public QuerySproductionvaluecoefficienttypepcor() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("production_value_coefficient_type_id");
	}

	@Override
	public BaseCollection<BaseSproductionvaluecoefficienttypepcor> executeQuery( KeyValuePair[] replacements, ConditionSproductionvaluecoefficienttypepcor condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getProductionValueCoefficientTypeId(), 
				condition.getCoefficientType()
			);
	}

	public BaseCollection<BaseSproductionvaluecoefficienttypepcor> runQuery( KeyValuePair[] replacements, ConditionSproductionvaluecoefficienttypepcor condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getProductionValueCoefficientTypeId(), 
				condition.getCoefficientType()
			);
	}

	public BaseCollection<BaseSproductionvaluecoefficienttypepcor> execute( KeyValuePair[] replacements, ConditionSproductionvaluecoefficienttypepcor condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getProductionValueCoefficientTypeId(), 
				condition.getCoefficientType()
			);
	}

	@Override
	public BaseSproductionvaluecoefficienttypepcor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSproductionvaluecoefficienttypepcor __base = new BaseSproductionvaluecoefficienttypepcor();
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
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

	private final static String __SQLText = "SELECT production_value_coefficient_type_id, coefficient_type FROM production_value_coefficient_type WHERE production_value_coefficient_type_id = ? and coefficient_type = ?" ;
	private final static String __originalSQL = "SELECT production_value_coefficient_type_id, coefficient_type FROM production_value_coefficient_type WHERE production_value_coefficient_type_id = :production_value_coefficient_type_id AND coefficient_type = :coefficient_type";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"production_value_coefficient_type_id = :production_value_coefficient_type_id AND coefficient_type = :coefficient_type\",\"startIndex\": 107,\"stopIndex\":223,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"production_value_coefficient_type_id = :production_value_coefficient_type_id\",\"fullFieldName\":\"production_value_coefficient_type_id\",\"operationName\":\"=\",\"variableName\":\"productionValueCoefficientTypeId\",\"startIndex\": 107,\"stopIndex\":182,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"coefficient_type = :coefficient_type\",\"fullFieldName\":\"coefficient_type\",\"operationName\":\"=\",\"variableName\":\"coefficientType\",\"startIndex\": 188,\"stopIndex\":223,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "production_value_coefficient_type_id,coefficient_type";
	private final static String[] fieldNames = { "production_value_coefficient_type_id", "coefficient_type"};
}
