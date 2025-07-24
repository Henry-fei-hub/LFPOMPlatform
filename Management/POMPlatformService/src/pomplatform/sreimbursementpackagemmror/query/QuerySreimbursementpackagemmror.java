package pomplatform.sreimbursementpackagemmror.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.sreimbursementpackagemmror.bean.BaseSreimbursementpackagemmror;
import pomplatform.sreimbursementpackagemmror.bean.ConditionSreimbursementpackagemmror;

public class QuerySreimbursementpackagemmror extends AbstractQuery<BaseSreimbursementpackagemmror, ConditionSreimbursementpackagemmror>
{

	private static final Logger __logger = Logger.getLogger(QuerySreimbursementpackagemmror.class);

	public QuerySreimbursementpackagemmror() throws java.sql.SQLException 
	{
		setParameterNumber(16);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("rp.reimbursement_package_id");
	}

	@Override
	public BaseCollection<BaseSreimbursementpackagemmror> executeQuery( KeyValuePair[] replacements, ConditionSreimbursementpackagemmror condition ) throws java.sql.SQLException {
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
				condition.getIsOnlinePay(),
				condition.getPayStatus(),
				condition.getAmount(),
				condition.getPaymentAmount(),
				condition.getStrikeABalanceAmount()
			);
	}

	@Override
	public BaseSreimbursementpackagemmror generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSreimbursementpackagemmror __base = new BaseSreimbursementpackagemmror();
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
		if((val = __data[count++]) != null) __base.setPackageSize(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsOnlinePay(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setPayStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMakeBillTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPayTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setZeronum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOnenum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTwonum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setThreenum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFournum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAllnum(GenericBase.__getInt(val));
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
		if(args[11] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		if(args[13] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[13]));
		if(args[14] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[14]));
		if(args[15] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[15]));
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

	private final static String __SQLText = "select rp.reimbursement_package_id, rp.company_id, rp.amount, rp.payment_amount, rp.strike_a_balance_amount, rp.is_completed, rp.remark, rp.employee_id, rp.role_id, rp.operator_id, rp.code, rp.create_time, rp.update_time, rp.package_size, rp.is_online_pay,rp.pay_status,rp.make_bill_time,rp.pay_time,aa.zeronum,aa.onenum,aa.twonum,aa.threenum,aa.fournum,aa.allnum from reimbursement_packages rp left join (SELECT cma.reimbursement_package_id, COALESCE(sum(case WHEN cma.pay_result = 0 THEN cma.num END), 0) as zeronum, COALESCE(sum(case WHEN cma.pay_result = 1 THEN cma.num END), 0) as onenum, COALESCE(sum(case WHEN cma.pay_result = 2 THEN cma.num END), 0) as twonum, COALESCE(sum(case WHEN cma.pay_result = 3 THEN cma.num END), 0) as threenum, COALESCE(sum(case WHEN cma.pay_result = 4 THEN cma.num END), 0) as fournum, sum(num) allnum from (SELECT reimbursement_package_id, pay_result, COUNT(1) AS num FROM cmbc_payments GROUP BY reimbursement_package_id, pay_result) cma GROUP BY cma.reimbursement_package_id) aa on aa.reimbursement_package_id = rp.reimbursement_package_id where rp.create_time between ? and ? and rp.reimbursement_package_id = ? and rp.company_id = ? and rp.is_completed = ? and rp.remark = ? and rp.employee_id = ? and rp.role_id = ? and rp.operator_id = ? and rp.code like ? and rp.reimbursement_package_id in ( select distinct r.reimbursement_package_id from reimbursement_package_details r where r.code like ? ) AND rp.is_online_pay = ? AND rp.pay_status = ? AND rp.amount = ? AND rp.payment_amount = ? AND rp.strike_a_balance_amount = ? order by create_time desc" ;
	private final static String RESULTSETFIELDLIST = "reimbursement_package_id,company_id,amount,payment_amount,strike_a_balance_amount,is_completed,remark,employee_id,role_id,operator_id,code,create_time,update_time,package_size,is_online_pay,pay_status,make_bill_time,pay_time,zeronum,onenum,twonum,threenum,fournum,allnum";
	private final static String[] fieldNames = { "min_create_time", "max_create_time", "reimbursement_package_id", "company_id", "is_completed", "remark", "employee_id", "role_id", "operator_id", "code", "order_code", "is_online_pay", "pay_status", "amount", "payment_amount", "strike_a_balance_amount"};
}
