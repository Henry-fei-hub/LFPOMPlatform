package pomplatform.projectappendintegralrecordpor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectappendintegralrecordpor.bean.BaseSprojectappendintegralrecordpor;
import pomplatform.projectappendintegralrecordpor.bean.ConditionSprojectappendintegralrecordpor;

public class QuerySprojectappendintegralrecordpor extends AbstractQuery<BaseSprojectappendintegralrecordpor, ConditionSprojectappendintegralrecordpor>
{

	private static final Logger __logger = Logger.getLogger(QuerySprojectappendintegralrecordpor.class);

	public QuerySprojectappendintegralrecordpor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pair.project_append_integral_record_id");
	}

	@Override
	public BaseCollection<BaseSprojectappendintegralrecordpor> executeQuery( KeyValuePair[] replacements, ConditionSprojectappendintegralrecordpor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseSprojectappendintegralrecordpor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojectappendintegralrecordpor __base = new BaseSprojectappendintegralrecordpor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectAppendIntegralRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAppendIntegral(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAppendTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setInt(count++, (java.lang.Integer)args[0]);
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

	private final static String __SQLText = "select pair.project_append_integral_record_id, pair.project_id, pair.append_integral, pair.percentage, pair.append_time, pair.remark from project_append_integral_records pair where pair.project_id = ? order by pair.append_time desc" ;
	private final static String RESULTSETFIELDLIST = "project_append_integral_record_id,project_id,append_integral,percentage,append_time,remark";
	private final static String[] fieldNames = { "project_id"};
}
