package pomplatform.bonusPayment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.bonusPayment.bean.BaseLoadEmployeeForSendBonus;
import pomplatform.bonusPayment.bean.ConditionLoadEmployeeForSendBonus;

public class QueryLoadEmployeeForSendBonus extends AbstractQuery<BaseLoadEmployeeForSendBonus, ConditionLoadEmployeeForSendBonus>
{

	private static final Logger __logger = Logger.getLogger(QueryLoadEmployeeForSendBonus.class);

	public QueryLoadEmployeeForSendBonus() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_id");
	}

	@Override
	public BaseCollection<BaseLoadEmployeeForSendBonus> executeQuery( KeyValuePair[] replacements, ConditionLoadEmployeeForSendBonus condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getPlateId(), 
				condition.getStartDate()
			);
	}

	@Override
	public BaseLoadEmployeeForSendBonus generateBase(Object[] __data) throws java.sql.SQLException {
		BaseLoadEmployeeForSendBonus __base = new BaseLoadEmployeeForSendBonus();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
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

	private final static String __SQLText = "SELECT employee_id,employee_no,employee_name,? as plate_id,0 as integral,status FROM employees WHERE department_id in (SELECT department_id FROM departments WHERE plate_id = ?) AND (status = 0 or (status = 1 AND resignation_date >= ?))" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,plate_id,integral,status";
	private final static String[] fieldNames = { "plate_id","plate_id", "start_date"};
}
