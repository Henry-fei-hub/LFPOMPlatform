package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseEmployeeRealAmount;
import pomplatform.project.bean.ConditionEmployeeRealAmount;

public class QueryEmployeeRealAmount extends AbstractQuery<BaseEmployeeRealAmount, ConditionEmployeeRealAmount>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeRealAmount.class);

	public QueryEmployeeRealAmount() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sum(COALESCE(pe.real_integral");
	}

	@Override
	public BaseCollection<BaseEmployeeRealAmount> executeQuery( KeyValuePair[] replacements, ConditionEmployeeRealAmount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseEmployeeRealAmount generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeRealAmount __base = new BaseEmployeeRealAmount();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select sum(COALESCE(pe.real_integral,0)) as amount from project_employees pe where status >= 1 and pe.project_id = ?" ;
	private final static String RESULTSETFIELDLIST = "amount";
	private final static String[] fieldNames = { "project_id"};
}
