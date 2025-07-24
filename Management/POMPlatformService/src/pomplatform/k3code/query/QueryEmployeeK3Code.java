package pomplatform.k3code.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.k3code.bean.BaseEmployeeK3Code;
import pomplatform.k3code.bean.ConditionEmployeeK3Code;

public class QueryEmployeeK3Code extends AbstractQuery<BaseEmployeeK3Code, ConditionEmployeeK3Code>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeK3Code.class);

	public QueryEmployeeK3Code() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.employee_no");
	}

	@Override
	public BaseCollection<BaseEmployeeK3Code> executeQuery( KeyValuePair[] replacements, ConditionEmployeeK3Code condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getBusinessId(), 
				condition.getK3Code()
			);
	}

	@Override
	public BaseEmployeeK3Code generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeK3Code __base = new BaseEmployeeK3Code();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setK3CodeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setK3Code(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setK3Name(GenericBase.__getString(val));
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

	private final static String __SQLText = "select e.employee_no, kc.k3_code_id, kc.type, kc.business_id, kc.k3_code, kc.k3_name from k3_codes kc left join employees e on kc.business_id = e.employee_id where kc.business_id = ? and kc.k3_code like ? and kc.type = 1" ;
	private final static String RESULTSETFIELDLIST = "employee_no,k3_code_id,type,business_id,k3_code,k3_name";
	private final static String[] fieldNames = { "business_id", "k3_code"};
}
