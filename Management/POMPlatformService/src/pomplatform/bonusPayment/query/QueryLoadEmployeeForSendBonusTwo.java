package pomplatform.bonusPayment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.bonusPayment.bean.BaseLoadEmployeeForSendBonusTwo;
import pomplatform.bonusPayment.bean.ConditionLoadEmployeeForSendBonusTwo;

public class QueryLoadEmployeeForSendBonusTwo extends AbstractQuery<BaseLoadEmployeeForSendBonusTwo, ConditionLoadEmployeeForSendBonusTwo>
{

	private static final Logger __logger = Logger.getLogger(QueryLoadEmployeeForSendBonusTwo.class);

	public QueryLoadEmployeeForSendBonusTwo() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.bonus_payment_record_id");
	}

	@Override
	public BaseCollection<BaseLoadEmployeeForSendBonusTwo> executeQuery( KeyValuePair[] replacements, ConditionLoadEmployeeForSendBonusTwo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getPayDate(), 
				condition.getState()
			);
	}

	@Override
	public BaseLoadEmployeeForSendBonusTwo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseLoadEmployeeForSendBonusTwo __base = new BaseLoadEmployeeForSendBonusTwo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setBonusPaymentRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBonusPaymentDetailId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPayIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateType(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
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

	private final static String __SQLText = "SELECT b.bonus_payment_record_id,c.bonus_payment_detail_id,c.employee_id,c.employee_no,c.employee_name,c.pay_integral,c.plate_id,e.status ,a.plate_type FROM plate_records a LEFT JOIN bonus_payment_records b ON a.plate_id = b.plate_id LEFT JOIN bonus_payment_details c ON b.bonus_payment_record_id = c.bonus_payment_record_id LEFT JOIN employees e ON c.employee_id = e.employee_id WHERE a.parent_id = ? AND b.pay_date = ? AND b.state = ? AND b.is_level_two = true AND c.is_level_two = true AND a.plate_type = 3 ORDER BY c.plate_id,employee_id" ;
	private final static String RESULTSETFIELDLIST = "bonus_payment_record_id,bonus_payment_detail_id,employee_id,employee_no,employee_name,pay_integral,plate_id,status,plate_type";
	private final static String[] fieldNames = { "plate_id", "pay_date", "state"};
}
