package pomplatform.employeemoneymanagespeemmepemmor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employeemoneymanagespeemmepemmor.bean.BaseMemployeemoneymanagespeemmepemmor;
import pomplatform.employeemoneymanagespeemmepemmor.bean.ConditionMemployeemoneymanagespeemmepemmor;

public class QueryMemployeemoneymanagespeemmepemmor extends AbstractQuery<BaseMemployeemoneymanagespeemmepemmor, ConditionMemployeemoneymanagespeemmepemmor>
{

	private static final Logger __logger = Logger.getLogger(QueryMemployeemoneymanagespeemmepemmor.class);

	public QueryMemployeemoneymanagespeemmepemmor() throws java.sql.SQLException 
	{
		setParameterNumber(18);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ep.employee_id");
	}

	@Override
	public BaseCollection<BaseMemployeemoneymanagespeemmepemmor> executeQuery( KeyValuePair[] replacements, ConditionMemployeemoneymanagespeemmepemmor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getProcessStatus(), 
				condition.getEquivalentNumber(), 
				condition.getMinCompleteTime(), 
				condition.getMaxCompleteTime(), 
				condition.getEmployeeId(), 
				condition.getProcessStatus(), 
				condition.getEquivalentNumber(), 
				condition.getMinCompleteTime(), 
				condition.getMaxCompleteTime(),
				condition.getEmployeeId(), 
				condition.getProcessStatus(), 
				condition.getEquivalentNumber(), 
				condition.getMinCompleteTime(), 
				condition.getMaxCompleteTime(),
				condition.getEmployeeId(),
				condition.getMinCompleteTime(), 
				condition.getMaxCompleteTime()
			);
	}

	@Override
	public BaseMemployeemoneymanagespeemmepemmor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMemployeemoneymanagespeemmepemmor __base = new BaseMemployeemoneymanagespeemmepemmor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReturnMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEquivalentNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[8]));
		if(args[9] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[13]));
		if(args[14] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[16]));
		if(args[17] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[17]));
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

	private final static String __SQLText = "SELECT ep.employee_id, ep.money, ep.return_money, ep.business_id, ep.business_name, ep.complete_time, ep.equivalent_number, ep.m_type, ep.process_id, ep.process_instance_id, ep.process_type FROM(	SELECT pbl.employee_or_company_id as employee_id, pbl.pay_money AS money, em.return_money, spi.process_type, spi.process_id, spi.process_instance_id, spi.business_id, spi.complete_time, spi.business_name, 1 AS m_type, em.equivalent_number FROM employee_money_manages em LEFT JOIN system_process_instances spi ON spi.business_id = em.employee_money_manage_id AND spi.process_type = 6 LEFT JOIN process_bill_list pbl ON spi.business_id = pbl.business_id and spi.process_type = pbl.process_type and pbl.pay_for = 1 WHERE pbl.employee_or_company_id = ? AND spi.process_status = ? AND em.equivalent_number =? AND spi.complete_time BETWEEN ? AND ? AND spi.delete_flag = 0 UNION ALL SELECT pbl.employee_or_company_id AS employee_id, (0 - COALESCE(pbl.balance_amount, 0)) AS money, pbl.balance_amount AS return_money, spi.process_type, spi.process_id, spi.process_instance_id, spi.business_id, spi.complete_time, spi.business_name, 2 AS m_type, pbl.equivalent_number FROM process_bill_list pbl LEFT JOIN system_process_instances spi ON spi.business_id = pbl.business_id AND spi.process_type = pbl.process_type AND pbl.pay_for = 1 WHERE pbl.employee_or_company_id = ? AND spi.process_status = ? AND pbl.balance_amount > 0 AND pbl.equivalent_number =? AND spi.complete_time BETWEEN ? AND ? AND spi.delete_flag = 0 UNION ALL SELECT pb.parent_id AS employee_id, (0 - COALESCE(pb.fee, 0)) AS money, pb.fee AS return_money, spi.process_type,spi.process_id,spi.process_instance_id,spi.business_id, pb.start_date AS complete_time,spi.business_name,3 AS m_type,pb.equivalent_number FROM personnel_business pb LEFT JOIN system_process_instances spi ON spi.business_id = pb.personnel_business_id AND spi.process_type = 28 	WHERE pb.parent_id = ? AND spi.process_status = ? AND pb.equivalent_number = ? AND pb.start_date BETWEEN ? AND ? AND pb.process_type = 28 AND spi.delete_flag = 0 UNION ALL SELECT eib.employee_id,eib.initial_balance AS money,eib.initial_balance AS return_money,0 AS process_type, 0 AS process_id,0 AS process_instance_id, 0 AS business_id, eib.happen_date AS complete_time,NULL AS business_name,4 AS m_type,null AS equivalent_number FROM employee_initial_balances eib WHERE eib.employee_id = ? AND eib.happen_date BETWEEN ? AND ?) ep WHERE ep.equivalent_number ISNULL OR ep.equivalent_number = '' ORDER BY ep.complete_time" ;
	private final static String RESULTSETFIELDLIST = "employee_id,money,return_money,business_id,business_name,complete_time,equivalent_number,m_type,process_id,process_instance_id,process_type";
	private final static String[] fieldNames = { "employee_id", "process_status", "equivalent_number", "min_complete_time", "max_complete_time", "employee_id", "process_status", "equivalent_number", "min_complete_time", "max_complete_time", "employee_id", "process_status", "equivalent_number", "min_complete_time", "max_complete_time", "employee_id", "min_complete_time", "max_complete_time"};
}
