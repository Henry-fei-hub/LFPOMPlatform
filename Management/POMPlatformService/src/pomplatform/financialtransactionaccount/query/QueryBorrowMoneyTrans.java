package pomplatform.financialtransactionaccount.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.financialtransactionaccount.bean.BaseBorrowMoneyTrans;
import pomplatform.financialtransactionaccount.bean.ConditionBorrowMoneyTrans;

public class QueryBorrowMoneyTrans extends AbstractQuery<BaseBorrowMoneyTrans, ConditionBorrowMoneyTrans>
{

	private static final Logger __logger = Logger.getLogger(QueryBorrowMoneyTrans.class);

	public QueryBorrowMoneyTrans() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.process_instance_id");
	}

	@Override
	public BaseCollection<BaseBorrowMoneyTrans> executeQuery( KeyValuePair[] replacements, ConditionBorrowMoneyTrans condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessInstanceId(), 
				condition.getProcessType(), 
				condition.getBusinessId(), 
				condition.getProcessStatus(), 
				condition.getDeleteFlag()
			);
	}

	@Override
	public BaseBorrowMoneyTrans generateBase(Object[] __data) throws java.sql.SQLException {
		BaseBorrowMoneyTrans __base = new BaseBorrowMoneyTrans();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDrafter(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCurrencyType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSummary(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessBillListId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayFor(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeOrCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBalanceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select a.process_instance_id, a.process_type, a.business_id, a.create_time as record_date, a.process_status, a.complete_time, b.employee_id as drafter, b.currency as currency_type, concat(b.code, case when b.code is null then '' else '-' end, c.department_name, case when c.department_name is null then '' else '-' end, d.employee_name, case when d.employee_name is null then '' else '-' end, b.reason) as summary, e.process_bill_list_id, e.pay_for, e.employee_or_company_id, e.pay_money, e.balance_amount, b.company_id from system_process_instances a LEFT JOIN employee_money_manages b on a.business_id = b.employee_money_manage_id LEFT JOIN departments c on b.department_id = c.department_id LEFT JOIN employees d on b.employee_id = d.employee_id LEFT JOIN process_bill_list e on a.process_type = e.process_type and a.business_id = e.business_id where a.process_instance_id = ? and a.process_type = ? and a.business_id = ? and a.process_status = ? and a.delete_flag = ?" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,process_type,business_id,record_date,process_status,complete_time,drafter,currency_type,summary,process_bill_list_id,pay_for,employee_or_company_id,pay_money,balance_amount,company_id";
	private final static String[] fieldNames = { "process_instance_id", "process_type", "business_id", "process_status", "delete_flag"};
}
