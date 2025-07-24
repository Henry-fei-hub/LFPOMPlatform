package pomplatform.bonusPayment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.bonusPayment.bean.BaseBonusPaymentRecord;
import pomplatform.bonusPayment.bean.ConditionBonusPaymentRecord;

public class QueryBonusPaymentRecord extends AbstractQuery<BaseBonusPaymentRecord, ConditionBonusPaymentRecord>
{

	private static final Logger __logger = Logger.getLogger(QueryBonusPaymentRecord.class);

	public QueryBonusPaymentRecord() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.bonus_payment_record_id");
	}

	@Override
	public BaseCollection<BaseBonusPaymentRecord> executeQuery( KeyValuePair[] replacements, ConditionBonusPaymentRecord condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getState(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseBonusPaymentRecord generateBase(Object[] __data) throws java.sql.SQLException {
		BaseBonusPaymentRecord __base = new BaseBonusPaymentRecord();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setBonusPaymentRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPayDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setApplicant(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setApplyTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setState(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOpinion(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAuditor(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAuditingTime(GenericBase.__getDateFromSQL(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
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

	private final static String __SQLText = "SELECT a.bonus_payment_record_id, a.plate_id, a.pay_integral, a.pay_date, a.remark, a.applicant,a.apply_time, a.state, a.opinion, a.auditor, a.auditing_time FROM bonus_payment_records a WHERE a.plate_id = ? AND a.pay_date >= ? AND a.pay_date <= ? AND a.state = ? and CASE WHEN a.applicant = ? THEN 1 = 1 ELSE a.is_level_two = false END ORDER BY a.apply_time DESC, a.plate_id" ;
	private final static String RESULTSETFIELDLIST = "bonus_payment_record_id,plate_id,pay_integral,pay_date,remark,applicant,apply_time,state,opinion,auditor,auditing_time";
	private final static String[] fieldNames = { "plate_id", "start_date", "end_date", "state","employee_id"};
}
