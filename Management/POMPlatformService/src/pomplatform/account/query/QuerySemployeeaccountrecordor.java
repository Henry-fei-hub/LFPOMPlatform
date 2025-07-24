package pomplatform.account.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseSemployeeaccountrecordor;
import pomplatform.account.bean.ConditionSemployeeaccountrecordor;

public class QuerySemployeeaccountrecordor extends AbstractQuery<BaseSemployeeaccountrecordor, ConditionSemployeeaccountrecordor>
{

	private static final Logger __logger = Logger.getLogger(QuerySemployeeaccountrecordor.class);

	public QuerySemployeeaccountrecordor() throws java.sql.SQLException 
	{
		setParameterNumber(0);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_id");
	}

	@Override
	public BaseCollection<BaseSemployeeaccountrecordor> executeQuery( KeyValuePair[] replacements, ConditionSemployeeaccountrecordor condition ) throws java.sql.SQLException {
		return executeQuery(replacements
			);
	}

	@Override
	public BaseSemployeeaccountrecordor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSemployeeaccountrecordor __base = new BaseSemployeeaccountrecordor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setBusinessTypeId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT employee_id, plate_id, record_date, business_type_id FROM employee_account_records WHERE business_type_id =1" ;
	private final static String RESULTSETFIELDLIST = "employee_id,plate_id,record_date,business_type_id";
	private final static String[] fieldNames = { };
}
