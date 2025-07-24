package pomplatform.sealKeepers.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.sealKeepers.bean.BasesealKeepersWorkflow;
import pomplatform.sealKeepers.bean.ConditionsealKeepersWorkflow;

public class QuerysealKeepersWorkflow extends AbstractQuery<BasesealKeepersWorkflow, ConditionsealKeepersWorkflow>
{

	private static final Logger __logger = Logger.getLogger(QuerysealKeepersWorkflow.class);

	public QuerysealKeepersWorkflow() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("*");
	}

	@Override
	public BaseCollection<BasesealKeepersWorkflow> executeQuery( KeyValuePair[] replacements, ConditionsealKeepersWorkflow condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyId(), 
				condition.getSealName(), 
				condition.getEmployeeId()
			);
	}

	public BaseCollection<BasesealKeepersWorkflow> execute( KeyValuePair[] replacements, ConditionsealKeepersWorkflow condition ) throws java.sql.SQLException {
		return execute(condition, replacements, 
				condition.getCompanyId(), 
				condition.getSealName(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BasesealKeepersWorkflow generateBase(Object[] __data) throws java.sql.SQLException {
		BasesealKeepersWorkflow __base = new BasesealKeepersWorkflow();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSealKeeperId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSealName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreatTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNumber(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSealType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemarks(GenericBase.__getString(val));
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

	private final static String __SQLText = "select * from seal_keepers where delete_flag =0 and company_id=? and seal_name = ? and employee_id=?" ;
	private final static String __originalSQL = "select *  from seal_keepers where delete_flag =0 and company_id=:company_id and seal_name = :seal_name and employee_id=:employee_id ";
	private final static String[] __queryConditions = {
		"{\"fullCondition\": \"delete_flag =0 and company_id=@company_id and seal_name = @seal_name and employee_id=@employee_id\",\"startIndex\": 34,\"stopIndex\":130,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"delete_flag =0 and company_id=@company_id and seal_name = @seal_name\",\"startIndex\": 34,\"stopIndex\":101,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"delete_flag =0 and company_id=@company_id\",\"startIndex\": 34,\"stopIndex\":74,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"delete_flag =0\",\"startIndex\": 34,\"stopIndex\":47,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"company_id=@company_id\",\"fullFieldName\":\"company_id\",\"operationName\":\"=\",\"variableName\":\"companyId\",\"startIndex\": 53,\"stopIndex\":74,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"seal_name = @seal_name\",\"fullFieldName\":\"seal_name\",\"operationName\":\"=\",\"variableName\":\"sealName\",\"startIndex\": 80,\"stopIndex\":101,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"employee_id=@employee_id\",\"fullFieldName\":\"employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"startIndex\": 107,\"stopIndex\":130,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}"
	};
	private final static String RESULTSETFIELDLIST = "seal_keeper_id,seal_name,employee_id,creat_time,operator_id,delete_flag,company_id,number,seal_type,remarks";
	private final static String[] fieldNames = { "company_id", "seal_name", "employee_id"};
}
