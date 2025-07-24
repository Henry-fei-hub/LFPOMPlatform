package pomplatform.workflow.personnelbusiness.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.personnelbusiness.bean.BaseMakeFileNumber;
import pomplatform.workflow.personnelbusiness.bean.ConditionMakeFileNumber;

public class QueryMakeFileNumber extends AbstractQuery<BaseMakeFileNumber, ConditionMakeFileNumber>
{

	private static final Logger __logger = Logger.getLogger(QueryMakeFileNumber.class);

	public QueryMakeFileNumber() throws java.sql.SQLException 
	{
		setParameterNumber(0);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("MAX(file_number) AS file_number_max");
	}

	@Override
	public BaseCollection<BaseMakeFileNumber> executeQuery( KeyValuePair[] replacements, ConditionMakeFileNumber condition ) throws java.sql.SQLException {
		return executeQuery(replacements
			);
	}

	@Override
	public BaseMakeFileNumber generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMakeFileNumber __base = new BaseMakeFileNumber();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setFileNumberMax(GenericBase.__getString(val));
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

	private final static String __SQLText = "select CAST((file_number) AS INTEGER)+1 AS file_number_max from employees where employee_id = (select max(employee_id) from employees)" ;
	private final static String RESULTSETFIELDLIST = "file_number_max";
	private final static String[] fieldNames = { };
}
