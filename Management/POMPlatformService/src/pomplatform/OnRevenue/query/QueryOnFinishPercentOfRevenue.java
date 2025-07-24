package pomplatform.OnRevenue.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.OnRevenue.bean.BaseOnFinishPercentOfRevenue;
import pomplatform.OnRevenue.bean.ConditionOnFinishPercentOfRevenue;

public class QueryOnFinishPercentOfRevenue extends AbstractQuery<BaseOnFinishPercentOfRevenue, ConditionOnFinishPercentOfRevenue>
{

	private static final Logger __logger = Logger.getLogger(QueryOnFinishPercentOfRevenue.class);

	public QueryOnFinishPercentOfRevenue() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("abc.*");
	}

	@Override
	public BaseCollection<BaseOnFinishPercentOfRevenue> executeQuery( KeyValuePair[] replacements, ConditionOnFinishPercentOfRevenue condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractCode()
			);
	}

	@Override
	public BaseOnFinishPercentOfRevenue generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnFinishPercentOfRevenue __base = new BaseOnFinishPercentOfRevenue();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSheetCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFinishPercent(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select abc.*,case when (abc.project_integral = 0 or abc.project_integral is null)then 0 else round(abc.sure_integral/abc.project_integral,4) end as finish_percent from ( select a.project_id,sum(a.total_amount )as sure_integral,b.project_integral,b.contract_code as sheet_code,b.project_name ,substr(b.contract_code,1,strpos(b.contract_code,'-')-4) as contract_code from project_settlements a left join projects b on a.project_id = b.project_id where b.contract_code is not null GROUP BY a.project_id,b.project_integral,b.contract_code, b.project_name ) abc where abc.contract_code = ? ORDER BY abc.project_id" ;
	private final static String RESULTSETFIELDLIST = "project_id,sure_integral,project_integral,sheet_code,project_name,contract_code,finish_percent";
	private final static String[] fieldNames = { "contract_code"};
}
