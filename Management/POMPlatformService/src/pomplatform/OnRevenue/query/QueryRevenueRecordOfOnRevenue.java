package pomplatform.OnRevenue.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.OnRevenue.bean.BaseRevenueRecordOfOnRevenue;
import pomplatform.OnRevenue.bean.ConditionRevenueRecordOfOnRevenue;

public class QueryRevenueRecordOfOnRevenue extends AbstractQuery<BaseRevenueRecordOfOnRevenue, ConditionRevenueRecordOfOnRevenue>
{

	private static final Logger __logger = Logger.getLogger(QueryRevenueRecordOfOnRevenue.class);

	public QueryRevenueRecordOfOnRevenue() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("* from revenue_records where signing_company = :signing_company and name like :name ORDER BY code");
	}

	@Override
	public BaseCollection<BaseRevenueRecordOfOnRevenue> executeQuery( KeyValuePair[] replacements, ConditionRevenueRecordOfOnRevenue condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getSigningCompany(), 
				condition.getName()
			);
	}

	@Override
	public BaseRevenueRecordOfOnRevenue generateBase(Object[] __data) throws java.sql.SQLException {
		BaseRevenueRecordOfOnRevenue __base = new BaseRevenueRecordOfOnRevenue();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setRevenueRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinishPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinishPercentView(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRevenueMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSigningCompany(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsFinish(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setAccountDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setFinishPercentDetail(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinishPercentDetailView(GenericBase.__getString(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
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

	private final static String __SQLText = "select * from revenue_records where signing_company = ? and name like ? ORDER BY code,operate_time desc" ;
	private final static String RESULTSETFIELDLIST = "revenue_record_id,contract_id,code,name,money,finish_percent,finish_percent_view,revenue_money,invoice_amount,borrow_money,parent_id,signing_company,is_finish,account_date,month,flag,operate_employee_id,operate_time,finish_percent_detail,finish_percent_detail_view";
	private final static String[] fieldNames = { "signing_company", "name"};
}
