package pomplatform.specialDeduction.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.specialDeduction.bean.BaseOnCheckSpecialCountByYear;
import pomplatform.specialDeduction.bean.ConditionOnCheckSpecialCountByYear;

public class QueryOnCheckSpecialCountByYear extends AbstractQuery<BaseOnCheckSpecialCountByYear, ConditionOnCheckSpecialCountByYear>
{

	private static final Logger __logger = Logger.getLogger(QueryOnCheckSpecialCountByYear.class);

	public QueryOnCheckSpecialCountByYear() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("* from ( SELECT spi.employee_id");
	}

	@Override
	public BaseCollection<BaseOnCheckSpecialCountByYear> executeQuery( KeyValuePair[] replacements, ConditionOnCheckSpecialCountByYear condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getYear(), 
				condition.getSpecialDeductionTypeId()
			);
	}

	public BaseCollection<BaseOnCheckSpecialCountByYear> execute( KeyValuePair[] replacements, ConditionOnCheckSpecialCountByYear condition ) throws java.sql.SQLException {
		return execute(condition, replacements, 
				condition.getEmployeeId(), 
				condition.getYear(), 
				condition.getSpecialDeductionTypeId()
			);
	}

	@Override
	public BaseOnCheckSpecialCountByYear generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnCheckSpecialCountByYear __base = new BaseOnCheckSpecialCountByYear();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSpecialDeductionTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCount(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		return count;
	}

	@Override
	public String getSQLText() {
		__logger.info(__SQLText);
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

	private final static String __SQLText = " select * from ( SELECT spi.employee_id, sdd.special_deduction_type_id, COUNT ( 1 ) FROM system_process_instances spi LEFT JOIN special_deduction_records sdr ON sdr.special_deduction_record_id = spi.business_id LEFT JOIN special_deduction_details sdd ON sdd.parent_id = sdr.special_deduction_record_id WHERE spi.process_type = 58 AND spi.delete_flag = 0 AND spi.process_status = 3 AND spi.employee_id =? AND sdr.employee_name =? AND sdd.special_deduction_type_id=? GROUP BY spi.employee_id, sdd.special_deduction_type_id )as A where A.count>=2" ;
	private final static String __originalSQL = "  select * from ( SELECT spi.employee_id, sdd.special_deduction_type_id, COUNT ( 1 ) FROM system_process_instances spi LEFT JOIN special_deduction_records sdr ON sdr.special_deduction_record_id = spi.business_id LEFT JOIN special_deduction_details sdd ON sdd.parent_id = sdr.special_deduction_record_id WHERE spi.process_type = 58 AND spi.delete_flag = 0 AND spi.process_status = 3 AND spi.employee_id =:employee_id AND sdr.employee_name =:year AND 	sdd.special_deduction_type_id=:special_deduction_type_id GROUP BY spi.employee_id, sdd.special_deduction_type_id )as A where A.count>=2  ";
	private final static String[] __queryConditions = {
		"{\"fullCondition\": \"spi.process_type = 58 AND spi.delete_flag = 0 AND spi.process_status = 3 AND spi.employee_id =@employee_id AND sdr.employee_name =@year AND 	sdd.special_deduction_type_id=@special_deduction_type_id\",\"startIndex\": 309,\"stopIndex\":505,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spi.process_type = 58 AND spi.delete_flag = 0 AND spi.process_status = 3 AND spi.employee_id =@employee_id AND sdr.employee_name =@year\",\"startIndex\": 309,\"stopIndex\":443,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"spi.process_type = 58 AND spi.delete_flag = 0 AND spi.process_status = 3 AND spi.employee_id =@employee_id\",\"startIndex\": 309,\"stopIndex\":414,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"spi.process_type = 58 AND spi.delete_flag = 0 AND spi.process_status = 3\",\"startIndex\": 309,\"stopIndex\":380,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"spi.process_type = 58 AND spi.delete_flag = 0\",\"startIndex\": 309,\"stopIndex\":353,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"spi.process_type = 58\",\"startIndex\": 309,\"stopIndex\":329,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.delete_flag = 0\",\"startIndex\": 335,\"stopIndex\":353,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"spi.process_status = 3\",\"startIndex\": 359,\"stopIndex\":380,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"spi.employee_id =@employee_id\",\"fullFieldName\":\"spi.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"startIndex\": 386,\"stopIndex\":414,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"sdr.employee_name =@year\",\"fullFieldName\":\"sdr.employee_name\",\"operationName\":\"=\",\"variableName\":\"year\",\"startIndex\": 420,\"stopIndex\":443,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"sdd.special_deduction_type_id=@special_deduction_type_id\",\"fullFieldName\":\"sdd.special_deduction_type_id\",\"operationName\":\"=\",\"variableName\":\"specialDeductionTypeId\",\"startIndex\": 450,\"stopIndex\":505,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}"
	};
	private final static String RESULTSETFIELDLIST = "employee_id,special_deduction_type_id,count";
	private final static String[] fieldNames = { "employee_id", "year", "special_deduction_type_id"};
}
