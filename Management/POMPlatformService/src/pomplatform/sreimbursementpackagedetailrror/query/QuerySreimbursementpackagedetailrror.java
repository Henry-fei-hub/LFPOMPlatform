package pomplatform.sreimbursementpackagedetailrror.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.sreimbursementpackagedetailrror.bean.BaseSreimbursementpackagedetailrror;
import pomplatform.sreimbursementpackagedetailrror.bean.ConditionSreimbursementpackagedetailrror;

public class QuerySreimbursementpackagedetailrror extends AbstractQuery<BaseSreimbursementpackagedetailrror, ConditionSreimbursementpackagedetailrror>
{

	private static final Logger __logger = Logger.getLogger(QuerySreimbursementpackagedetailrror.class);

	public QuerySreimbursementpackagedetailrror() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("rpd.reimbursement_package_detail_id");
	}

	@Override
	public BaseCollection<BaseSreimbursementpackagedetailrror> executeQuery( KeyValuePair[] replacements, ConditionSreimbursementpackagedetailrror condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getReimbursementPackageDetailId(), 
				condition.getReimbursementPackageId()
			);
	}

	@Override
	public BaseSreimbursementpackagedetailrror generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSreimbursementpackagedetailrror __base = new BaseSreimbursementpackagedetailrror();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setReimbursementPackageDetailId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReimbursementPackageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDrafter(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayFor(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeOrCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSelfBankName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSelfBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPaymentAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStrikeABalanceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProcessBillListId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "select rpd.reimbursement_package_detail_id, rpd.reimbursement_package_id, rpd.process_type_id, rpd.process_id, rpd.business_id, rpd.process_instance_id, rpd.code, rpd.drafter, rpd.pay_for, rpd.employee_or_company_id, rpd.payee_name, rpd.self_bank_name, rpd.self_bank_account, rpd.amount, rpd.payment_amount, rpd.strike_a_balance_amount, rpd.process_bill_list_id, rpd.create_time, rpd.update_time from reimbursement_package_details rpd where rpd.reimbursement_package_detail_id = ? and rpd.reimbursement_package_id = ?" ;
	private final static String RESULTSETFIELDLIST = "reimbursement_package_detail_id,reimbursement_package_id,process_type_id,process_id,business_id,process_instance_id,code,drafter,pay_for,employee_or_company_id,payee_name,self_bank_name,self_bank_account,amount,payment_amount,strike_a_balance_amount,process_bill_list_id,create_time,update_time";
	private final static String[] fieldNames = { "reimbursement_package_detail_id", "reimbursement_package_id"};
}
