package pomplatform.reimbursementpackage.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.reimbursementpackage.bean.BaseMreimbursementpackagesummarycrtppor;
import pomplatform.reimbursementpackage.bean.ConditionMreimbursementpackagesummarycrtppor;

public class QueryMreimbursementpackagesummarycrtppor extends AbstractQuery<BaseMreimbursementpackagesummarycrtppor, ConditionMreimbursementpackagesummarycrtppor>
{

	private static final Logger __logger = Logger.getLogger(QueryMreimbursementpackagesummarycrtppor.class);

	public QueryMreimbursementpackagesummarycrtppor() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("rps.reimbursement_package_summary_id");
	}

	@Override
	public BaseCollection<BaseMreimbursementpackagesummarycrtppor> executeQuery( KeyValuePair[] replacements, ConditionMreimbursementpackagesummarycrtppor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getReimbursementPackageId(), 
				condition.getType(), 
				condition.getPayResult(), 
				condition.getPayStatus()
			);
	}

	@Override
	public BaseMreimbursementpackagesummarycrtppor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMreimbursementpackagesummarycrtppor __base = new BaseMreimbursementpackagesummarycrtppor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setReimbursementPackageSummaryId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReimbursementPackageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMoneyAttribute(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayFor(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeOrCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSelfBankName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSelfBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherName(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOtherBankName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPaymentAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStrikeABalanceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setIsCompleted(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCmbcPaymentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYurref(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayResult(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setErrorMsg(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEpttim(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSuccessTotalAmount(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setSuccessTotalNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOprdat(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "SELECT rps.reimbursement_package_summary_id, rps.reimbursement_package_id, rps.money_attribute, rps.pay_for, rps.employee_or_company_id, rps.payee_name, rps.self_bank_name, rps.self_bank_account, rps.other_name, rps.other_bank_name, rps.other_bank_account, rps.amount, rps.payment_amount, rps.strike_a_balance_amount, rps.create_time, rps.update_time, rps.is_completed, rps.company_id, rps.year, rps.month, rps.pay_type, rps.cmbc_payment_id , cp.type, cp.yurref, cp.total_amount, cp.total_num, cp.pay_status, cp.pay_result, cp.error_msg, cp.epttim, cp.success_total_amount, cp.success_total_num, cp.oprdat FROM reimbursement_package_summarys rps LEFT JOIN cmbc_payments cp ON rps.cmbc_payment_id = cp.cmbc_payment_id WHERE rps.reimbursement_package_id = ? AND rps.cmbc_payment_id NOTNULL AND cp.type =? AND cp.pay_result = ? AND cp.pay_status = ?" ;
	private final static String RESULTSETFIELDLIST = "reimbursement_package_summary_id,reimbursement_package_id,money_attribute,pay_for,employee_or_company_id,payee_name,self_bank_name,self_bank_account,other_name,other_bank_name,other_bank_account,amount,payment_amount,strike_a_balance_amount,create_time,update_time,is_completed,company_id,year,month,pay_type,cmbc_payment_id,type,yurref,total_amount,total_num,pay_status,pay_result,error_msg,epttim,success_total_amount,success_total_num,oprdat";
	private final static String[] fieldNames = { "reimbursement_package_id", "type", "pay_result", "pay_status"};
}
