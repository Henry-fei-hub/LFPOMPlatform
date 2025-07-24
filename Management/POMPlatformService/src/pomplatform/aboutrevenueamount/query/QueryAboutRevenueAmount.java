package pomplatform.aboutrevenueamount.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.aboutrevenueamount.bean.BaseAboutRevenueAmount;
import pomplatform.aboutrevenueamount.bean.ConditionAboutRevenueAmount;

public class QueryAboutRevenueAmount extends AbstractQuery<BaseAboutRevenueAmount, ConditionAboutRevenueAmount>
{

	private static final Logger __logger = Logger.getLogger(QueryAboutRevenueAmount.class);

	public QueryAboutRevenueAmount() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("r.revenue_capitals_id");
	}

	@Override
	public BaseCollection<BaseAboutRevenueAmount> executeQuery( KeyValuePair[] replacements, ConditionAboutRevenueAmount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseAboutRevenueAmount generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAboutRevenueAmount __base = new BaseAboutRevenueAmount();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setRevenueCapitalsId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCapitalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRevenueAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIsTrue(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT r.revenue_capitals_id, r.year, r.month, r.contract_id, capital_amount, revenue_amount, is_true, operate_employee_id, operate_time, c.contract_code, c.contract_name, c.customer_name FROM revenue_capitals r LEFT JOIN contracts c ON r.contract_id=c.contract_id WHERE r.contract_id=? and r.year=? and r.month=? ORDER BY r.year desc, r.month desc" ;
	private final static String RESULTSETFIELDLIST = "revenue_capitals_id,year,month,contract_id,capital_amount,revenue_amount,is_true,operate_employee_id,operate_time,contract_code,contract_name,customer_name";
	private final static String[] fieldNames = { "contract_id", "year", "month"};
}
