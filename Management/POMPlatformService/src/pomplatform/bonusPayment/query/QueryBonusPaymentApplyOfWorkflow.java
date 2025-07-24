package pomplatform.bonusPayment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.bonusPayment.bean.BaseBonusPaymentApplyOfWorkflow;
import pomplatform.bonusPayment.bean.ConditionBonusPaymentApplyOfWorkflow;

public class QueryBonusPaymentApplyOfWorkflow extends AbstractQuery<BaseBonusPaymentApplyOfWorkflow, ConditionBonusPaymentApplyOfWorkflow>
{

	private static final Logger __logger = Logger.getLogger(QueryBonusPaymentApplyOfWorkflow.class);

	public QueryBonusPaymentApplyOfWorkflow() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseBonusPaymentApplyOfWorkflow> executeQuery( KeyValuePair[] replacements, ConditionBonusPaymentApplyOfWorkflow condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getBonusPaymentRecordId(), 
				condition.getPlateId(), 
				condition.getPayDate(), 
				condition.getEmployeId(), 
				condition.getState(), 
				condition.getAuditor()
			);
	}

	@Override
	public BaseBonusPaymentApplyOfWorkflow generateBase(Object[] __data) throws java.sql.SQLException {
		BaseBonusPaymentApplyOfWorkflow __base = new BaseBonusPaymentApplyOfWorkflow();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.process_type, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, bpr.bonus_payment_record_id, bpr.plate_id, bpr.pay_integral, bpr.pay_date, bpr.remark, bpr.applicant, bpr.apply_time, bpr.STATE, bpr.auditor, bpr.auditing_time, bpr.opinion, bpr.is_level_two FROM system_process_instances spi LEFT JOIN bonus_payment_records bpr ON spi.business_id = bpr.bonus_payment_record_id WHERE spi.process_type = 63 AND spi.process_status IN ( 0, 1 ) AND spi.delete_flag = 0 AND bpr.bonus_payment_record_id =? AND bpr.plate_id =? AND bpr.pay_date =? AND bpr.applicant =? AND bpr.STATE =? AND bpr.auditor =? ORDER BY spi.create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,process_type,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time,bonus_payment_record_id,plate_id,pay_integral,pay_date,remark,applicant,apply_time,state,auditor,auditing_time,opinion,is_level_two";
	private final static String[] fieldNames = { "bonus_payment_record_id", "plate_id", "pay_date", "employe_id", "STATE", "auditor"};
}
