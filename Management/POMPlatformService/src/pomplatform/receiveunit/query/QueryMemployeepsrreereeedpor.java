package pomplatform.receiveunit.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.receiveunit.bean.BaseMemployeepsrreereeedpor;
import pomplatform.receiveunit.bean.ConditionMemployeepsrreereeedpor;

public class QueryMemployeepsrreereeedpor extends AbstractQuery<BaseMemployeepsrreereeedpor, ConditionMemployeepsrreereeedpor>
{

	private static final Logger __logger = Logger.getLogger(QueryMemployeepsrreereeedpor.class);

	public QueryMemployeepsrreereeedpor() throws java.sql.SQLException 
	{
		setParameterNumber(10);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ep.employee_id");
	}

	@Override
	public BaseCollection<BaseMemployeepsrreereeedpor> executeQuery( KeyValuePair[] replacements, ConditionMemployeepsrreereeedpor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getReceiveUnitName(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getReceiveUnitName(), 
				condition.getReceiveUnitName(), 
				condition.getEmployeeId(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getDepartmentId(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseMemployeepsrreereeedpor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMemployeepsrreereeedpor __base = new BaseMemployeepsrreereeedpor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInitialBalance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPayMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBalanceAmount(GenericBase.__getDecimal(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
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

	private final static String __SQLText = "SELECT ep.employee_id, ep.employee_name, ep.department_id, ep.employee_no, ep.plate_id, ep.status, COALESCE (ru.initial_balance, 0) as initial_balance, COALESCE (pbl.pay_money, 0) as pay_money, (COALESCE (pb.fee, 0) + COALESCE (pbl.balance_amount, 0)) as balance_amount, ( COALESCE (ru.initial_balance, 0) + COALESCE (pbl.pay_money, 0) - COALESCE (pbl.balance_amount, 0) - COALESCE (pb.fee, 0)) AS balance FROM employees ep LEFT JOIN ( SELECT spi.employee_id, SUM (pbl.pay_money) AS pay_money, SUM (pbl.balance_amount) AS balance_amount FROM ( SELECT process_type, business_id, CASE WHEN process_type = 7 OR process_type = 6 THEN pay_money ELSE CASE WHEN pay_money > 0 THEN NULL ELSE pay_money END END AS pay_money, balance_amount FROM process_bill_list WHERE pay_for = 2 AND payee_name = ? AND ( (process_type in (6,7)) OR ( process_type not in (6,7) AND balance_amount > 0 ) ) ) pbl LEFT JOIN system_process_instances spi ON spi.process_type = pbl.process_type AND spi.business_id = pbl.business_id WHERE spi.process_status = 3 AND spi.delete_flag = 0 AND spi.employee_id = ? GROUP BY spi.employee_id ) pbl ON pbl.employee_id = ep.employee_id LEFT JOIN ( SELECT ru.employee_id, SUM (ru.initial_balance) AS initial_balance FROM receive_unit_initial_balances ru WHERE ru.employee_id = ? AND ru.receive_unit_name = ? GROUP BY ru.employee_id ) ru ON ru.employee_id = ep.employee_id LEFT JOIN (SELECT pb.employee_id,SUM (fee) AS fee FROM personnel_business pb LEFT JOIN system_process_instances spi ON spi.process_type = pb.process_type AND pb.personnel_business_id = spi.business_id AND spi.process_type = 41 WHERE pb.process_type = 41 AND spi.process_status = 3 AND pb.delete_flag = 0 AND spi.delete_flag = 0 AND pb.plan = ? GROUP BY pb.employee_id ) pb ON pb.employee_id = ep.employee_id WHERE ( ( ru.initial_balance NOTNULL AND ru.initial_balance > 0 ) OR ( pbl.pay_money NOTNULL AND pbl.pay_money > 0 ) OR ( pbl.balance_amount NOTNULL AND pbl.balance_amount > 0 ) OR pb.fee > 0) AND ep.employee_id = ? AND ep.employee_name = ? and ep.employee_no = ? AND ep.department_id = ? AND ep.plate_id = ?" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_name,department_id,employee_no,plate_id,status,initial_balance,pay_money,balance_amount,balance";
	private final static String[] fieldNames = { "receive_unit_name", "employee_id", "employee_id", "receive_unit_name", "receive_unit_name", "employee_id", "employee_name", "employee_no", "department_id", "plate_id"};
}
