package pomplatform.revenuecapitalsinfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.revenuecapitalsinfo.bean.BaseRevenueCapitalsInfo;
import pomplatform.revenuecapitalsinfo.bean.ConditionRevenueCapitalsInfo;

public class QueryRevenueCapitalsInfo extends AbstractQuery<BaseRevenueCapitalsInfo, ConditionRevenueCapitalsInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryRevenueCapitalsInfo.class);

	public QueryRevenueCapitalsInfo() throws java.sql.SQLException 
	{
		setParameterNumber(18);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A.year");
	}

	@Override
	public BaseCollection<BaseRevenueCapitalsInfo> executeQuery( KeyValuePair[] replacements, ConditionRevenueCapitalsInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYears(), 
				condition.getYears(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getCustomerName()
			);
	}

	@Override
	public BaseRevenueCapitalsInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseRevenueCapitalsInfo __base = new BaseRevenueCapitalsInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRevenueAmountStart(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCapitalAmountStart(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRevenueAmountEnd(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCapitalAmountEnd(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRevenueOneQuarter(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRevenueTwoQuarter(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRevenueTreeQuarter(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRevenueFourQuarter(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCapitalOneQuarter(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCapitalTwoQuarter(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCapitalTreeQuarter(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCapitalFourQuarter(GenericBase.__getDecimal(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		if(args[13] != null) __statement.setInt(count++, GenericBase.__getInt(args[13]));
		if(args[14] != null) __statement.setInt(count++, GenericBase.__getInt(args[14]));
		if(args[15] != null) __statement.setString(count++, GenericBase.__getString(args[15]));
		if(args[16] != null) __statement.setString(count++, GenericBase.__getString(args[16]));
		if(args[17] != null) __statement.setString(count++, GenericBase.__getString(args[17]));
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

	private final static String __SQLText = "SELECT A.year, A.contract_id, CT.contract_code, CT.contract_name, CT.customer_name, revenue_amount_START, capital_amount_START, revenue_amount_end, capital_amount_end, revenue_one_quarter, revenue_two_quarter, revenue_tree_quarter, revenue_four_quarter, capital_one_quarter, capital_two_quarter, capital_tree_quarter, capital_four_quarter FROM revenue_capitals A LEFT JOIN ( SELECT rc.contract_id, SUM(CASE WHEN rc.year<=? AND rc.month<=12 then revenue_amount else 0.0 end) AS revenue_amount_START, SUM(CASE WHEN rc.year<=? AND rc.month<=12 then capital_amount else 0.0 end) AS capital_amount_START, SUM(CASE WHEN rc.year<=? then revenue_amount else 0.0 end) as revenue_amount_end, SUM(CASE WHEN rc.year<=? then capital_amount else 0.0 end) as capital_amount_end, SUM(CASE WHEN rc.year=? AND rc.month<=3 then revenue_amount else 0.0 end )as revenue_one_quarter, SUM(CASE WHEN rc.year=? AND rc.month>4 AND rc.month<=6 then revenue_amount else 0.0 end )as revenue_two_quarter, SUM(CASE WHEN rc.year=? AND rc.month>6 AND rc.month<=9 then revenue_amount else 0.0 end )as revenue_tree_quarter, SUM(CASE WHEN rc.year=? AND rc.month>9 AND rc.month<=12 then revenue_amount else 0.0 end )as revenue_four_quarter, SUM(CASE WHEN rc.year=? AND rc.month<=3 then capital_amount else 0.0 end )as capital_one_quarter, SUM(CASE WHEN rc.year=? AND rc.month>4 AND rc.month<=6 then capital_amount else 0.0 end )as capital_two_quarter, SUM(CASE WHEN rc.year=? AND rc.month>6 AND rc.month<=9 then capital_amount else 0.0 end )as capital_tree_quarter, SUM(CASE WHEN rc.year=? AND rc.month>9 AND rc.month<=12 then capital_amount else 0.0 end )as capital_four_quarter FROM revenue_capitals rc WHERE rc.year >=2015 AND rc.year<=? GROUP BY rc.contract_id )B ON A.contract_id=B.contract_id LEFT JOIN contracts CT ON B.contract_id=CT.contract_id WHERE A.year=? and A.contract_id=? and CT.contract_code like ? and CT.contract_name like ? and CT.customer_name like ? GROUP BY A.year, A.contract_id, CT.contract_code, CT.contract_name, CT.customer_name, revenue_amount_START, capital_amount_START, revenue_amount_end, capital_amount_end, revenue_one_quarter, revenue_two_quarter, revenue_tree_quarter, revenue_four_quarter, capital_one_quarter, capital_two_quarter, capital_tree_quarter, capital_four_quarter" ;
	private final static String RESULTSETFIELDLIST = "year,contract_id,contract_code,contract_name,customer_name,revenue_amount_start,capital_amount_start,revenue_amount_end,capital_amount_end,revenue_one_quarter,revenue_two_quarter,revenue_tree_quarter,revenue_four_quarter,capital_one_quarter,capital_two_quarter,capital_tree_quarter,capital_four_quarter";
	private final static String[] fieldNames = { "years", "years", "year", "year", "year", "year", "year", "year", "year", "year", "year", "year", "year", "year", "contract_id", "contract_code", "contract_name", "customer_name"};
}
