package pomplatform.mcecscreeor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.mcecscreeor.bean.BaseMcecscreeor;
import pomplatform.mcecscreeor.bean.ConditionMcecscreeor;

public class QueryMcecscreeor extends AbstractQuery<BaseMcecscreeor, ConditionMcecscreeor>
{

	private static final Logger __logger = Logger.getLogger(QueryMcecscreeor.class);

	public QueryMcecscreeor() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cc.contract_code_id");
	}

	@Override
	public BaseCollection<BaseMcecscreeor> executeQuery( KeyValuePair[] replacements, ConditionMcecscreeor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMinCreateTime(), 
				condition.getMaxCreateTime(), 
				condition.getContractCodeId(), 
				condition.getSignCompany(), 
				condition.getContractCode(), 
				condition.getRemark(), 
				condition.getEmployeeId(), 
				condition.getEmployeeName()
			);
	}

	@Override
	public BaseMcecscreeor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMcecscreeor __base = new BaseMcecscreeor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractCodeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSignCompany(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		return count;
	}

	@Override
	public String getSQLText() {
		__logger.info(__SQLText);
		return __SQLText;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	private final static String __SQLText = "SELECT cc.contract_code_id, cc.sign_company, cc.contract_code, cc.remark, cc.employee_id, cc.create_time, e.employee_name FROM contract_code cc LEFT JOIN employees e ON CC.employee_id = e.employee_id WHERE cc.create_time between ? and ? and cc.contract_code_id = ? AND cc.sign_company = ? AND cc.contract_code LIKE ? AND cc.remark LIKE ? AND cc.employee_id = ? AND e.employee_name LIKE ?" ;
	private final static String RESULTSETFIELDLIST = "contract_code_id,sign_company,contract_code,remark,employee_id,create_time,employee_name";
	private final static String[] fieldNames = { "min_create_time", "max_create_time", "contract_code_id", "sign_company", "contract_code", "remark", "employee_id", "employee_name"};
}
