package pomplatform.employee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employee.bean.BaseDictionartManagenment;
import pomplatform.employee.bean.ConditionDictionartManagenment;

public class QueryDictionartManagenment extends AbstractQuery<BaseDictionartManagenment, ConditionDictionartManagenment>
{

	private static final Logger __logger = Logger.getLogger(QueryDictionartManagenment.class);

	public QueryDictionartManagenment() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("dic_type_id");
	}

	@Override
	public BaseCollection<BaseDictionartManagenment> executeQuery( KeyValuePair[] replacements, ConditionDictionartManagenment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getDicTypeName()
			);
	}

	@Override
	public BaseDictionartManagenment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseDictionartManagenment __base = new BaseDictionartManagenment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDicTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDicTypeName(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
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

	private final static String __SQLText = "SELECT dic_type_id , dic_type_name FROM system_dictionary where management_type = 2 and dic_type_name like ? GROUP BY dic_type_id , dic_type_name ORDER BY dic_type_id" ;
	private final static String RESULTSETFIELDLIST = "dic_type_id,dic_type_name";
	private final static String[] fieldNames = { "dic_type_name"};
}
