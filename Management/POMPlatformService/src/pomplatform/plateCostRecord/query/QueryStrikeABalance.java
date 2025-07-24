package pomplatform.plateCostRecord.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.plateCostRecord.bean.BaseStrikeABalance;
import pomplatform.plateCostRecord.bean.ConditionStrikeABalance;

public class QueryStrikeABalance extends AbstractQuery<BaseStrikeABalance, ConditionStrikeABalance>
{

	private static final Logger __logger = Logger.getLogger(QueryStrikeABalance.class);

	public QueryStrikeABalance() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("* from (SELECT a.process_type");
	}

	@Override
	public BaseCollection<BaseStrikeABalance> executeQuery( KeyValuePair[] replacements, ConditionStrikeABalance condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getBusinessId()
			);
	}

	@Override
	public BaseStrikeABalance generateBase(Object[] __data) throws java.sql.SQLException {
		BaseStrikeABalance __base = new BaseStrikeABalance();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReturnDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setTitleName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReturnMoney(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT * from (SELECT a.process_type, a.business_id, c.employee_or_company_id as employee_id, a.complete_time as return_date, a.business_name as title_name, b.department_id, sum( case when c.balance_amount is null then 0 else c.balance_amount end) as return_money from system_process_instances a LEFT JOIN process_bill_list c on a.business_id = c.business_id and a.process_type = c.process_type LEFT JOIN employees b on c.employee_or_company_id = b.employee_id where a.process_type = ? and a.business_id = ? and c.pay_for = 1 GROUP BY a.process_type, a.business_id, c.employee_or_company_id ,return_date, title_name, b.department_id) d where d.return_money != 0" ;
	private final static String RESULTSETFIELDLIST = "process_type,business_id,employee_id,return_date,title_name,department_id,return_money";
	private final static String[] fieldNames = { "process_type", "business_id"};
}
