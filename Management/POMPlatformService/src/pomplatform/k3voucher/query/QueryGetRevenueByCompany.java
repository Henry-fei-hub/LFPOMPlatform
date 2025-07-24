package pomplatform.k3voucher.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.k3voucher.bean.BaseGetRevenueByCompany;
import pomplatform.k3voucher.bean.ConditionGetRevenueByCompany;

public class QueryGetRevenueByCompany extends AbstractQuery<BaseGetRevenueByCompany, ConditionGetRevenueByCompany>
{

	private static final Logger __logger = Logger.getLogger(QueryGetRevenueByCompany.class);

	public QueryGetRevenueByCompany() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.*");
	}

	@Override
	public BaseCollection<BaseGetRevenueByCompany> executeQuery( KeyValuePair[] replacements, ConditionGetRevenueByCompany condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getCompanyId()
			);
	}

	@Override
	public BaseGetRevenueByCompany generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetRevenueByCompany __base = new BaseGetRevenueByCompany();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCurrentRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select a.*, c.contract_id, c.customer_id from (select project_id, sum(current_revenue) as current_revenue from revenue_statistical_records where year = ? and month = ? and current_revenue > 0 group by project_id) a LEFT JOIN projects b on a.project_id = b.project_id LEFT JOIN contracts c on b.contract_id = c.contract_id where c.signing_company_name = ?" ;
	private final static String RESULTSETFIELDLIST = "project_id,current_revenue,contract_id,customer_id";
	private final static String[] fieldNames = { "year", "month", "company_id"};
}
