package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseOnLoadOutAchieveSure;
import pomplatform.project.bean.ConditionOnLoadOutAchieveSure;

public class QueryOnLoadOutAchieveSure extends AbstractQuery<BaseOnLoadOutAchieveSure, ConditionOnLoadOutAchieveSure>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadOutAchieveSure.class);

	public QueryOnLoadOutAchieveSure() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("abc.financial_contract_code");
	}

	@Override
	public BaseCollection<BaseOnLoadOutAchieveSure> executeQuery( KeyValuePair[] replacements, ConditionOnLoadOutAchieveSure condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getContractCode(), 
				condition.getContractName()
			);
	}

	@Override
	public BaseOnLoadOutAchieveSure generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadOutAchieveSure __base = new BaseOnLoadOutAchieveSure();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setFinancialContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLastTotalRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentRevenue(GenericBase.__getDecimal(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
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

	private final static String __SQLText = "select abc.financial_contract_code,abc.contract_code,abc.contract_name ,sum(abc.total_revenue) as total_revenue,sum(abc.last_total_revenue) as last_total_revenue,sum(abc.current_revenue) as current_revenue from ( select b.contract_id, c.financial_contract_code,c.contract_code,c.contract_name ,a.total_revenue,a.current_revenue ,(a.total_revenue-a.current_revenue) as last_total_revenue from revenue_statistical_records a left join projects b on a.project_id = b.project_id left join contracts c on b.contract_id = c.contract_id where b.contract_id = ? and a.year = ? and month = ? and c.contract_code like ? and c.contract_name like ? ) as abc GROUP BY abc.contract_id,abc.financial_contract_code,abc.contract_code,abc.contract_name ORDER BY abc.contract_id" ;
	private final static String RESULTSETFIELDLIST = "financial_contract_code,contract_code,contract_name,total_revenue,last_total_revenue,current_revenue";
	private final static String[] fieldNames = {"contract_id", "year", "month", "contract_code", "contract_name"};
}
