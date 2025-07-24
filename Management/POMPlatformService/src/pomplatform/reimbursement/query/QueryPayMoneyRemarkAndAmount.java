package pomplatform.reimbursement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.reimbursement.bean.BasePayMoneyRemarkAndAmount;
import pomplatform.reimbursement.bean.ConditionPayMoneyRemarkAndAmount;

public class QueryPayMoneyRemarkAndAmount extends AbstractQuery<BasePayMoneyRemarkAndAmount, ConditionPayMoneyRemarkAndAmount>
{

	private static final Logger __logger = Logger.getLogger(QueryPayMoneyRemarkAndAmount.class);

	public QueryPayMoneyRemarkAndAmount() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.pay_money");
	}

	@Override
	public BaseCollection<BasePayMoneyRemarkAndAmount> executeQuery( KeyValuePair[] replacements, ConditionPayMoneyRemarkAndAmount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getBusinessId()
			);
	}

	@Override
	public BasePayMoneyRemarkAndAmount generateBase(Object[] __data) throws java.sql.SQLException {
		BasePayMoneyRemarkAndAmount __base = new BasePayMoneyRemarkAndAmount();
		int count = 0;
		Object val;
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

	private final static String __SQLText = "SELECT b.pay_money , concat(a.code, case when a.code is null then '' else '-' end, d.department_name, case when d.department_name is null then '' else '-' end, c.employee_name, case when c.employee_name is null then '' else '-' end, a.reason) as remark from pay_money_manages a LEFT JOIN process_bill_list b on a.pay_money_manage_id = b.business_id and b.process_type =7 LEFT JOIN employees c on a.operate_employee_id = c.employee_id LEFT JOIN departments d on a.department_id = d.department_id where a.pay_money_manage_id = ?" ;
	private final static String RESULTSETFIELDLIST = "pay_money,remark";
	private final static String[] fieldNames = { "business_id"};
}
