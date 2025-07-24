package pomplatform.EmployeeDetail.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.EmployeeDetail.bean.BaseSureIntegralDetail;
import pomplatform.EmployeeDetail.bean.ConditionSureIntegralDetail;

public class QuerySureIntegralDetail extends AbstractQuery<BaseSureIntegralDetail, ConditionSureIntegralDetail>
{

	private static final Logger __logger = Logger.getLogger(QuerySureIntegralDetail.class);

	public QuerySureIntegralDetail() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseSureIntegralDetail> executeQuery( KeyValuePair[] replacements, ConditionSureIntegralDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getSettlementYear(), 
				condition.getSettlementMonth(),
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseSureIntegralDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSureIntegralDetail __base = new BaseSureIntegralDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRealAmount(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select a.employee_id,b.employee_no,a.real_amount,a.project_id from project_settlement_details a left join employees b on a.employee_id = b.employee_id where a.real_amount <> 0 and extract(year from a.settlement_date) = ? and extract(month from a.settlement_date) = ? and a.employee_id = ?" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,real_amount,project_id";
	private final static String[] fieldNames = { "settlement_year", "settlement_month", "employee_id"};
}
