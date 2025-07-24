package pomplatform.reimbursement.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.reimbursement.bean.BaseReimbursementpackagemmror;
import pomplatform.reimbursement.bean.ConditionReimbursementpackagemmror;

public class QueryReimbursementpackagemmror extends AbstractQuery<BaseReimbursementpackagemmror, ConditionReimbursementpackagemmror>
{

	private static final Logger __logger = Logger.getLogger(QueryReimbursementpackagemmror.class);

	public QueryReimbursementpackagemmror() throws java.sql.SQLException 
	{
		setParameterNumber(12);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("rp.reimbursement_package_id");
	}

	@Override
	public BaseCollection<BaseReimbursementpackagemmror> executeQuery( KeyValuePair[] replacements, ConditionReimbursementpackagemmror condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMinCreateTime(), 
				condition.getMaxCreateTime(), 
				condition.getReimbursementPackageId(), 
				condition.getCompanyId(), 
				condition.getIsCompleted(), 
				condition.getRemark(), 
				condition.getEmployeeId(), 
				condition.getRoleId(), 
				condition.getOperatorId(), 
				condition.getCode(), 
				condition.getOrderCode(),
				condition.getPayStatus()
			);
	}

	@Override
	public BaseReimbursementpackagemmror generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReimbursementpackagemmror __base = new BaseReimbursementpackagemmror();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setReimbursementPackageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPaymentAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStrikeABalanceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIsCompleted(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRoleId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
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

	private final static String __SQLText = "select a.reimbursement_package_id, a.company_id, a.amount, a.payment_amount, a.strike_a_balance_amount, a.is_completed, a.remark, a.employee_id, a.role_id, a.operator_id, a.code, a.create_time, a.update_time from (select rp.reimbursement_package_id, rp.company_id, rp.amount, rp.payment_amount, rp.strike_a_balance_amount, rp.is_completed, rp.remark, rp.employee_id, rp.role_id, rp.operator_id, rp.code, rp.create_time, rp.update_time, count(v.k3_voucher_id) as voucher_number from reimbursement_packages rp LEFT JOIN k3_vouchers v on rp.code = v.reimbursement_package_code where rp.create_time between ? and ? and rp.reimbursement_package_id = ? and rp.company_id = ? and rp.is_completed = ? and rp.remark = ? and rp.employee_id = ? and rp.role_id = ? and rp.operator_id = ? and rp.code like ? and rp.reimbursement_package_id in ( select distinct r.reimbursement_package_id from reimbursement_package_details r where r.code like ? ) and rp.pay_status = ? and ((rp.is_online_pay = false and rp.is_completed = true) or (rp.is_online_pay = true and rp.pay_time is not null)) GROUP BY rp.reimbursement_package_id, rp.company_id, rp.amount, rp.payment_amount, rp.strike_a_balance_amount, rp.is_completed, rp.remark, rp.employee_id, rp.role_id, rp.operator_id, rp.code, rp.create_time, rp.update_time ) a where a.voucher_number = 0 order by a.create_time desc " ;
	private final static String RESULTSETFIELDLIST = "reimbursement_package_id,company_id,amount,payment_amount,strike_a_balance_amount,is_completed,remark,employee_id,role_id,operator_id,code,create_time,update_time";
	private final static String[] fieldNames = { "min_create_time", "max_create_time", "reimbursement_package_id", "company_id", "is_completed", "remark", "employee_id", "role_id", "operator_id", "code", "order_code", "pay_status"};
}
