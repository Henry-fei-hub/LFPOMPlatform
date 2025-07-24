package pomplatform.receiveunit.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.receiveunit.bean.BaseMprocessbilllistsmmeor;
import pomplatform.receiveunit.bean.ConditionMprocessbilllistsmmeor;

public class QueryMprocessbilllistsmmeor extends AbstractQuery<BaseMprocessbilllistsmmeor, ConditionMprocessbilllistsmmeor>
{

	private static final Logger __logger = Logger.getLogger(QueryMprocessbilllistsmmeor.class);

	public QueryMprocessbilllistsmmeor() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pbl.process_bill_list_id");
	}

	@Override
	public BaseCollection<BaseMprocessbilllistsmmeor> executeQuery( KeyValuePair[] replacements, ConditionMprocessbilllistsmmeor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPayeeName(), 
				condition.getMinCompleteTime(), 
				condition.getMaxCompleteTime(), 
				condition.getEmployeeId(),
				condition.getPayeeName(),
				condition.getEmployeeId(),
				condition.getPayeeName(),
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseMprocessbilllistsmmeor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMprocessbilllistsmmeor __base = new BaseMprocessbilllistsmmeor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessBillListId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayFor(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeOrCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMoneyAttribute(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSelfBankName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSelfBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherName(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOtherBankName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPayMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBalanceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIsComplete(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEquivalentNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
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

//	private final static String __SQLText = "SELECT process_bill_list_id,process_instance_id,process_type,business_id,pay_for,employee_or_company_id,money_attribute,payee_name,self_bank_name,self_bank_account,other_name,other_bank_name,other_bank_account,pay_money,balance_amount,is_complete,remark,create_time,operator,equivalent_number,complete_time,employee_id FROM( SELECT pbl.process_bill_list_id, pbl.process_instance_id, pbl.process_type, pbl.business_id, pbl.pay_for, pbl.employee_or_company_id, pbl.money_attribute, pbl.payee_name, pbl.self_bank_name, pbl.self_bank_account, pbl.other_name, pbl.other_bank_name, pbl.other_bank_account, pbl.pay_money, pbl.balance_amount, pbl.is_complete, pbl.remark, pbl.create_time, pbl.operator, pbl.equivalent_number, spi.complete_time, spi.employee_id FROM process_bill_list pbl LEFT JOIN system_process_instances spi ON spi.business_id = pbl.business_id AND spi.process_type = pbl.process_type WHERE pbl.payee_name = ? and spi.complete_time between ? and ? and pbl.pay_for = 2 AND spi.process_status = 3 AND spi.employee_id = ? AND ((pbl.balance_amount NOTNULL AND pbl.balance_amount >0 AND spi.process_type != 7) or (spi.process_type = 7)) UNION ALL SELECT null AS process_bill_list_id,null AS process_instance_id,null AS process_type,null AS business_id,2 AS pay_for,null AS employee_or_company_id,null AS money_attribute,receive_unit_name AS payee_name,null AS self_bank_name,null AS self_bank_account,null AS other_name,null AS other_bank_name,null AS other_bank_account,initial_balance AS pay_money,null AS balance_amount,true AS is_complete,null AS remark,NULL AS create_time,operator,NULL AS equivalent_number,happen_date AS complete_time,employee_id FROM receive_unit_initial_balances WHERE receive_unit_name = ? AND employee_id = ? ) aa ORDER BY aa.complete_time ASC" ;

	private final static String __SQLText = "SELECT process_bill_list_id,process_instance_id,process_type,business_id,pay_for,employee_or_company_id,money_attribute,payee_name,self_bank_name,self_bank_account,other_name,other_bank_name,other_bank_account,pay_money,balance_amount,is_complete,remark,create_time,operator,equivalent_number,complete_time,employee_id FROM( SELECT pbl.process_bill_list_id, pbl.process_instance_id, pbl.process_type, pbl.business_id, pbl.pay_for, pbl.employee_or_company_id, pbl.money_attribute, pbl.payee_name, pbl.self_bank_name, pbl.self_bank_account, pbl.other_name, pbl.other_bank_name, pbl.other_bank_account, pbl.pay_money, pbl.balance_amount, pbl.is_complete, pbl.remark, pbl.create_time, pbl.operator, pbl.equivalent_number, spi.complete_time, spi.employee_id FROM process_bill_list pbl LEFT JOIN system_process_instances spi ON spi.business_id = pbl.business_id AND spi.process_type = pbl.process_type WHERE pbl.payee_name = ? and spi.complete_time between ? and ? and pbl.pay_for = 2 AND spi.process_status = 3 AND spi.employee_id = ? UNION ALL SELECT null AS process_bill_list_id,null AS process_instance_id,null AS process_type,null AS business_id,2 AS pay_for,null AS employee_or_company_id,null AS money_attribute,receive_unit_name AS payee_name,null AS self_bank_name,null AS self_bank_account,null AS other_name,null AS other_bank_name,null AS other_bank_account,initial_balance AS pay_money,null AS balance_amount,true AS is_complete,null AS remark,NULL AS create_time,operator,NULL AS equivalent_number,happen_date AS complete_time,employee_id FROM receive_unit_initial_balances WHERE receive_unit_name = ? AND employee_id = ? UNION ALL	SELECT NULL AS process_bill_list_id, spi.process_instance_id,spi.process_type,spi.business_id,2 AS pay_for,NULL AS employee_or_company_id,NULL AS money_attribute,plan AS payee_name, NULL AS self_bank_name,NULL AS self_bank_account,NULL AS other_name,NULL AS other_bank_name,NULL AS other_bank_account,null AS pay_money,fee AS  balance_amount,true AS is_complete,NULL AS remark,NULL AS create_time,pb.employee_id as operator,NULL AS equivalent_number, pb.start_date AS complete_time, pb.employee_id FROM personnel_business pb LEFT JOIN system_process_instances spi ON spi.process_type = pb.process_type AND spi.business_id = pb.personnel_business_id AND spi.process_type = 41 WHERE spi.process_status = 3 AND spi.delete_flag = 0 AND pb.delete_flag = 0 AND pb.plan = ? AND pb.employee_id = ?) aa ORDER BY aa.complete_time ASC" ;
	private final static String RESULTSETFIELDLIST = "process_bill_list_id,process_instance_id,process_type,business_id,pay_for,employee_or_company_id,money_attribute,payee_name,self_bank_name,self_bank_account,other_name,other_bank_name,other_bank_account,pay_money,balance_amount,is_complete,remark,create_time,operator,equivalent_number,complete_time,employee_id";
	private final static String[] fieldNames = { "payee_name", "min_complete_time", "max_complete_time", "employee_id", "payee_name", "employee_id", "payee_name", "employee_id" };
}
