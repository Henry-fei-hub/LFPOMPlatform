package pomplatform.reimbursement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.reimbursement.bean.BaseBorrowMoneyRemarkAndAmount;
import pomplatform.reimbursement.bean.ConditionBorrowMoneyRemarkAndAmount;

public class QueryBorrowMoneyRemarkAndAmount extends AbstractQuery<BaseBorrowMoneyRemarkAndAmount, ConditionBorrowMoneyRemarkAndAmount>
{

	private static final Logger __logger = Logger.getLogger(QueryBorrowMoneyRemarkAndAmount.class);

	public QueryBorrowMoneyRemarkAndAmount() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.pay_money");
	}

	@Override
	public BaseCollection<BaseBorrowMoneyRemarkAndAmount> executeQuery( KeyValuePair[] replacements, ConditionBorrowMoneyRemarkAndAmount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getBusinessId()
			);
	}

	@Override
	public BaseBorrowMoneyRemarkAndAmount generateBase(Object[] __data) throws java.sql.SQLException {
		BaseBorrowMoneyRemarkAndAmount __base = new BaseBorrowMoneyRemarkAndAmount();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeOrCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT b.employee_or_company_id, b.pay_money , concat(a.code, case when a.code is null then '' else '-' end, d.department_name, case when d.department_name is null then '' else '-' end, c.employee_name, case when c.employee_name is null then '' else '-' end, a.reason) as remark from employee_money_manages a LEFT JOIN process_bill_list b on a.employee_money_manage_id = b.business_id and b.process_type = 6 LEFT JOIN employees c on a.employee_id = c.employee_id LEFT JOIN departments d on a.department_id = d.department_id where a.employee_money_manage_id = ?" ;
	private final static String RESULTSETFIELDLIST = "employee_or_company_id, pay_money,remark";
	private final static String[] fieldNames = { "business_id"};
}
