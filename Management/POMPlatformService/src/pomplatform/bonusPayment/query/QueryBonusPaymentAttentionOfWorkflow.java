package pomplatform.bonusPayment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.bonusPayment.bean.BaseBonusPaymentAttentionOfWorkflow;
import pomplatform.bonusPayment.bean.ConditionBonusPaymentAttentionOfWorkflow;

public class QueryBonusPaymentAttentionOfWorkflow extends AbstractQuery<BaseBonusPaymentAttentionOfWorkflow, ConditionBonusPaymentAttentionOfWorkflow>
{

	private static final Logger __logger = Logger.getLogger(QueryBonusPaymentAttentionOfWorkflow.class);

	public QueryBonusPaymentAttentionOfWorkflow() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spa.system_process_attention_id");
	}

	@Override
	public BaseCollection<BaseBonusPaymentAttentionOfWorkflow> executeQuery( KeyValuePair[] replacements, ConditionBonusPaymentAttentionOfWorkflow condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getBonusPaymentRecordId(), 
				condition.getPlateId(), 
				condition.getPayDate(), 
				condition.getApplicant(), 
				condition.getState(), 
				condition.getAuditor()
			);
	}

	@Override
	public BaseBonusPaymentAttentionOfWorkflow generateBase(Object[] __data) throws java.sql.SQLException {
		BaseBonusPaymentAttentionOfWorkflow __base = new BaseBonusPaymentAttentionOfWorkflow();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSystemProcessAttentionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
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
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
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

	private final static String __SQLText = "SELECT spa.system_process_attention_id, spa.business_id, spa.business_name, spa.process_activity_id, spa.process_id, spa.process_instance_id, spa.back_view_name, spa.instance_activity_id, spa.instance_activity_create_time, spa.instance_activity_start_time, spa.status, spa.process_type, spa.operate_time, spa.process_comment, bpr.bonus_payment_record_id, bpr.plate_id, bpr.pay_integral, bpr.pay_date, bpr.remark, bpr.applicant, bpr.apply_time, bpr.STATE, bpr.auditor, bpr.auditing_time, bpr.opinion, bpr.is_level_two FROM system_process_attentions spa LEFT JOIN bonus_payment_records bpr ON spa.business_id = bpr.bonus_payment_record_id WHERE spa.status =? AND spa.process_type = 63 AND spa.employee_id =? AND spa.delete_flag = 0 AND bpr.bonus_payment_record_id =? AND bpr.plate_id =? AND bpr.pay_date =? AND bpr.applicant =? AND bpr.STATE =? AND bpr.auditor =? ORDER BY spa.instance_activity_create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "system_process_attention_id,business_id,business_name,process_activity_id,process_id,process_instance_id,back_view_name,instance_activity_id,instance_activity_create_time,instance_activity_start_time,status,process_type,operate_time,process_comment,bonus_payment_record_id,plate_id,pay_integral,pay_date,remark,applicant,apply_time,state,auditor,auditing_time,opinion,is_level_two";
	private final static String[] fieldNames = { "status", "employee_id", "bonus_payment_record_id", "plate_id", "pay_date", "applicant", "STATE", "auditor"};
}
