package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseBonusApplication;
import pomplatform.workflow.bean.ConditionBonusApplication;

public class QueryBonusApplication extends AbstractQuery<BaseBonusApplication, ConditionBonusApplication>
{

	private static final Logger __logger = Logger.getLogger(QueryBonusApplication.class);

	public QueryBonusApplication() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("bpr.bonus_payment_record_id");
	}

	@Override
	public BaseCollection<BaseBonusApplication> executeQuery( KeyValuePair[] replacements, ConditionBonusApplication condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getBonusPaymentRecordId(), 
				condition.getPlateId(), 
				condition.getApplicant(), 
				condition.getState(), 
				condition.getAuditor()
			);
	}

	@Override
	public BaseBonusApplication generateBase(Object[] __data) throws java.sql.SQLException {
		BaseBonusApplication __base = new BaseBonusApplication();
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
		if((val = __data[count++]) != null) __base.setAuditor(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAuditingTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOpinion(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsLevelTwo(GenericBase.__getBoolean(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
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

	private final static String __SQLText = "select bpr.bonus_payment_record_id, bpr.plate_id, bpr.pay_integral, bpr.pay_date, bpr.remark, bpr.applicant, bpr.apply_time, bpr.state, bpr.auditor, bpr.auditing_time, bpr.opinion, bpr.is_level_two from bonus_payment_records bpr where bpr.bonus_payment_record_id = ? and bpr.plate_id = ? and bpr.applicant = ? and bpr.state = ? and bpr.auditor = ?" ;
	private final static String RESULTSETFIELDLIST = "bonus_payment_record_id,plate_id,pay_integral,pay_date,remark,applicant,apply_time,state,auditor,auditing_time,opinion,is_level_two";
	private final static String[] fieldNames = { "bonus_payment_record_id", "plate_id", "applicant", "state", "auditor"};
}
