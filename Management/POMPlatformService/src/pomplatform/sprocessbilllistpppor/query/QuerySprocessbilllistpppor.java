package pomplatform.sprocessbilllistpppor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.sprocessbilllistpppor.bean.BaseSprocessbilllistpppor;
import pomplatform.sprocessbilllistpppor.bean.ConditionSprocessbilllistpppor;

public class QuerySprocessbilllistpppor extends AbstractQuery<BaseSprocessbilllistpppor, ConditionSprocessbilllistpppor>
{

	private static final Logger __logger = Logger.getLogger(QuerySprocessbilllistpppor.class);

	public QuerySprocessbilllistpppor() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pbl.process_bill_list_id");
	}

	@Override
	public BaseCollection<BaseSprocessbilllistpppor> executeQuery( KeyValuePair[] replacements, ConditionSprocessbilllistpppor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessBillListId(), 
				condition.getProcessInstanceId(), 
				condition.getProcessType(), 
				condition.getBusinessId(), 
				condition.getPayFor(), 
				condition.getEmployeeOrCompanyId()
			);
	}

	@Override
	public BaseSprocessbilllistpppor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprocessbilllistpppor __base = new BaseSprocessbilllistpppor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessBillListId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayFor(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeOrCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMoneyAttribute(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayeeName(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSelfBankName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSelfBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherBankName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPayMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBalanceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIsComplete(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select pbl.process_bill_list_id, pbl.process_instance_id, pbl.process_type, pbl.business_id, pbl.pay_for, pbl.employee_or_company_id, pbl.money_attribute, pbl.payee_name, pbl.self_bank_name, pbl.self_bank_account, pbl.other_name, pbl.other_bank_name, pbl.other_bank_account, pbl.pay_money, pbl.balance_amount, pbl.is_complete, pbl.remark, pbl.create_time, pbl.operator from process_bill_list pbl where pbl.process_bill_list_id = ? and pbl.process_instance_id = ? and pbl.process_type = ? and pbl.business_id = ? and pbl.pay_for = ? and pbl.employee_or_company_id = ?" ;
	private final static String RESULTSETFIELDLIST = "process_bill_list_id,process_instance_id,process_type,business_id,pay_for,employee_or_company_id,money_attribute,payee_name,self_bank_name,self_bank_account,other_name,other_bank_name,other_bank_account,pay_money,balance_amount,is_complete,remark,create_time,operator";
	private final static String[] fieldNames = { "process_bill_list_id", "process_instance_id", "process_type", "business_id", "pay_for", "employee_or_company_id"};
}
