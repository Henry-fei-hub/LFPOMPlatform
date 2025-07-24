package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseSprojectpricechangedrecordgroupor;
import pomplatform.project.bean.ConditionSprojectpricechangedrecordgroupor;

public class QuerySprojectpricechangedrecordgroupor extends AbstractQuery<BaseSprojectpricechangedrecordgroupor, ConditionSprojectpricechangedrecordgroupor>
{

	private static final Logger __logger = Logger.getLogger(QuerySprojectpricechangedrecordgroupor.class);

	public QuerySprojectpricechangedrecordgroupor() throws java.sql.SQLException 
	{
		setParameterNumber(0);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("project_id");
	}

	@Override
	public BaseCollection<BaseSprojectpricechangedrecordgroupor> executeQuery( KeyValuePair[] replacements, ConditionSprojectpricechangedrecordgroupor condition ) throws java.sql.SQLException {
		return executeQuery(replacements
			);
	}

	@Override
	public BaseSprojectpricechangedrecordgroupor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojectpricechangedrecordgroupor __base = new BaseSprojectpricechangedrecordgroupor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select project_id from project_price_changed_records GROUP BY project_id" ;
	private final static String RESULTSETFIELDLIST = "project_id";
	private final static String[] fieldNames = { };
}
