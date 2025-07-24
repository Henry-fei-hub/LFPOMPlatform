package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseFileManages;
import pomplatform.workflow.bean.ConditionFileManages;


public class QueryFileManages extends AbstractQuery<BaseFileManages, ConditionFileManages>
{

	private static final Logger __logger = Logger.getLogger(QueryFileManages.class);



	public QueryFileManages() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("file_url");
	}

	@Override
	public BaseCollection<BaseFileManages> executeQuery( KeyValuePair[] replacements, ConditionFileManages condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getFileId()
			);
	}

	@Override
	public BaseFileManages generateBase(Object[] __data) throws java.sql.SQLException {
		BaseFileManages __base = new BaseFileManages();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setFileUrl(GenericBase.__getString(val));
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

	private final static String __SQLText = "select file_url from file_manages where file_id =?" ;
	private final static String RESULTSETFIELDLIST = "file_url";
	private final static String[] fieldNames = { "file_id"};
}
