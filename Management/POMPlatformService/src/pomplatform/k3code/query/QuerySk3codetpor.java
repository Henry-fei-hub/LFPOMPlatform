package pomplatform.k3code.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.k3code.bean.BaseSk3codetpor;
import pomplatform.k3code.bean.ConditionSk3codetpor;

public class QuerySk3codetpor extends AbstractQuery<BaseSk3codetpor, ConditionSk3codetpor>
{

	private static final Logger __logger = Logger.getLogger(QuerySk3codetpor.class);

	public QuerySk3codetpor() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("kc.k3_code_id");
	}

	@Override
	public BaseCollection<BaseSk3codetpor> executeQuery( KeyValuePair[] replacements, ConditionSk3codetpor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getType(), 
				condition.getDepartmentType()
			);
	}

	@Override
	public BaseSk3codetpor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSk3codetpor __base = new BaseSk3codetpor();
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
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

	private final static String __SQLText = "select kc.k3_code_id, kc.type, kc.business_id, kc.k3_code, kc.k3_name, kc.department_type from k3_codes kc where kc.type = ? and kc.department_type = ?" ;
	private final static String RESULTSETFIELDLIST = "k3_code_id,type,business_id,k3_code,k3_name,department_type";
	private final static String[] fieldNames = { "type", "department_type"};
}
