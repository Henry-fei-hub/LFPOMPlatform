package pomplatform.k3code.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.k3code.bean.BaseCustomerK3Code;
import pomplatform.k3code.bean.ConditionCustomerK3Code;

public class QueryCustomerK3Code extends AbstractQuery<BaseCustomerK3Code, ConditionCustomerK3Code>
{

	private static final Logger __logger = Logger.getLogger(QueryCustomerK3Code.class);

	public QueryCustomerK3Code() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("kc.k3_code_id");
	}

	@Override
	public BaseCollection<BaseCustomerK3Code> executeQuery( KeyValuePair[] replacements, ConditionCustomerK3Code condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getBusinessId(), 
				condition.getK3Code()
			);
	}

	@Override
	public BaseCustomerK3Code generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCustomerK3Code __base = new BaseCustomerK3Code();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setK3CodeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setK3Code(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setK3Name(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentType(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select kc.k3_code_id, kc.type, kc.business_id, kc.k3_code, kc.k3_name, kc.department_type from k3_codes kc where kc.business_id = ? and kc.k3_code like ? and kc.type = 9" ;
	private final static String RESULTSETFIELDLIST = "k3_code_id,type,business_id,k3_code,k3_name,department_type";
	private final static String[] fieldNames = { "business_id", "k3_code"};
}
