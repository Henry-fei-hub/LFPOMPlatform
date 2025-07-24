package pomplatform.receiveunit.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.receiveunit.bean.BaseMreceiveunitmanagepsrbbor;
import pomplatform.receiveunit.bean.ConditionMreceiveunitmanagepsrbbor;

public class QueryMreceiveunitmanagepsrbbor extends AbstractQuery<BaseMreceiveunitmanagepsrbbor, ConditionMreceiveunitmanagepsrbbor>
{

	private static final Logger __logger = Logger.getLogger(QueryMreceiveunitmanagepsrbbor.class);

	public QueryMreceiveunitmanagepsrbbor() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT 	rum.receive_unit");
	}

	@Override
	public BaseCollection<BaseMreceiveunitmanagepsrbbor> executeQuery( KeyValuePair[] replacements, ConditionMreceiveunitmanagepsrbbor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getReceiveUnit(), 
				condition.getBankAccount(), 
				condition.getBankName()
			);
	}

	@Override
	public BaseMreceiveunitmanagepsrbbor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMreceiveunitmanagepsrbbor __base = new BaseMreceiveunitmanagepsrbbor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setReceiveUnit(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPayMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBalanceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInitialBalance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBalance(GenericBase.__getDecimal(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
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

	private final static String __SQLText = "SELECT DISTINCT rum.receive_unit, COALESCE (pbl.pay_money, 0) as pay_money, (COALESCE (pb.fee, 0) + COALESCE (pbl.balance_amount, 0)) as balance_amount, ru.initial_balance, (COALESCE(ru.initial_balance, 0) + COALESCE(pbl.pay_money, 0) - COALESCE(pbl.balance_amount, 0) - COALESCE (pb.fee, 0)) AS balance FROM receive_unit_manages rum LEFT JOIN ( SELECT pbl.payee_name, SUM(pbl.pay_money) AS pay_money, SUM(pbl.balance_amount) AS balance_amount FROM (SELECT process_type,business_id,payee_name,CASE WHEN process_type = 7 OR process_type = 6 THEN pay_money ELSE CASE WHEN pay_money > 0 THEN null ELSE	pay_money END END AS pay_money,balance_amount FROM process_bill_list WHERE pay_for = 2 AND ((process_type in (6,7)) OR (process_type not in (6,7) AND balance_amount > 0))) pbl LEFT JOIN system_process_instances spi ON spi.business_id = pbl.business_id AND spi.process_type = pbl.process_type WHERE spi.process_status = 3 GROUP BY pbl.payee_name ) pbl ON pbl.payee_name = rum.receive_unit LEFT JOIN (SELECT receive_unit_name,SUM(initial_balance) AS initial_balance FROM receive_unit_initial_balances GROUP BY receive_unit_name) ru ON ru.receive_unit_name = rum.receive_unit LEFT JOIN (SELECT pb.plan as receive_unit_name, SUM(fee) as fee FROM personnel_business pb LEFT JOIN system_process_instances spi ON spi.process_type = pb.process_type AND pb.personnel_business_id = spi.business_id AND spi.process_type = 41 WHERE pb.process_type = 41 AND spi.process_status = 3 AND pb.delete_flag = 0 AND spi.delete_flag = 0 GROUP BY pb.plan) pb ON pb.receive_unit_name = rum.receive_unit  WHERE rum.origin = 0 AND rum.receive_unit LIKE ? AND rum.bank_account LIKE ? AND rum.bank_name LIKE ? AND (pbl.pay_money NOTNULL OR pbl.balance_amount NOTNULL OR pbl.pay_money > 0 OR pbl.balance_amount > 0 OR pb.fee > 0) " ;
	private final static String RESULTSETFIELDLIST = "receive_unit,pay_money,balance_amount,initial_balance,balance";
	private final static String[] fieldNames = { "receive_unit", "bank_account", "bank_name"};
}
