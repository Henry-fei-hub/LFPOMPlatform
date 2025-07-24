package pomplatform.bonusPayment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.bonusPayment.bean.BaseBonusPaymentAuditOfWorkflow;
import pomplatform.bonusPayment.bean.ConditionBonusPaymentAuditOfWorkflow;

public class QueryBonusPaymentAuditOfWorkflow extends AbstractQuery<BaseBonusPaymentAuditOfWorkflow, ConditionBonusPaymentAuditOfWorkflow>
{

	private static final Logger __logger = Logger.getLogger(QueryBonusPaymentAuditOfWorkflow.class);

	public QueryBonusPaymentAuditOfWorkflow() throws java.sql.SQLException 
	{
		setParameterNumber(13);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spt.process_type_name");
	}

	@Override
	public BaseCollection<BaseBonusPaymentAuditOfWorkflow> executeQuery( KeyValuePair[] replacements, ConditionBonusPaymentAuditOfWorkflow condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getBonusPaymentRecordId(), 
				condition.getPlateId(), 
				condition.getPayDate(), 
				condition.getApplicant(), 
				condition.getState(), 
				condition.getAuditor()
			);
	}

	@Override
	public BaseBonusPaymentAuditOfWorkflow generateBase(Object[] __data) throws java.sql.SQLException {
		BaseBonusPaymentAuditOfWorkflow __base = new BaseBonusPaymentAuditOfWorkflow();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessTypeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessPooledTaskId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTypeFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNodeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNextActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
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
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
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

	private final static String __SQLText = "SELECT spt.process_type_name, sppt.process_pooled_task_id, CASE WHEN sppt.process_pooled_task_id > 0 THEN 2 ELSE 1 END AS type_flag, spia.process_instance_activity_id, spia.business_id, spia.business_name, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.node_type, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.instance_activity_create_time, spia.instance_activity_start_time, spia.operate_time, spia.process_comment, spia.status, spia.activity_type, spia.back_view_name, spia.process_type, bpr.bonus_payment_record_id, bpr.plate_id, bpr.pay_integral, bpr.pay_date, bpr.remark, bpr.applicant, bpr.apply_time, bpr.STATE, bpr.auditor, bpr.auditing_time, bpr.opinion, bpr.is_level_two FROM system_process_instance_activities AS spia LEFT JOIN system_process_pooled_tasks sppt ON spia.process_instance_id = sppt.process_instance_id AND spia.process_instance_activity_id = sppt.instance_activity_id LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id LEFT JOIN system_process_types spt ON spia.process_type = spt.process_type_id LEFT JOIN bonus_payment_records bpr ON spi.business_id = bpr.bonus_payment_record_id WHERE spia.activity_type IN ( 2, 3 ) AND spi.delete_flag = 0 AND spt.parent_process_type_id = 12 AND (( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =? AND spia.status =? ) OR ( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =? AND sppt.employee_id =? AND sppt.status =? ) OR ( spia.employee_id IS NULL AND sppt.employee_id =? AND sppt.status =? )) AND spia.process_type = 63 AND bpr.bonus_payment_record_id =? AND bpr.plate_id =? AND bpr.pay_date =? AND bpr.applicant =? AND bpr.STATE =? AND bpr.auditor =? ORDER BY spia.instance_activity_create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_type_name,process_pooled_task_id,type_flag,process_instance_activity_id,business_id,business_name,process_activity_id,process_id,process_instance_id,node_type,activity_id,next_activity_id,main_activity_id,instance_activity_create_time,instance_activity_start_time,operate_time,process_comment,status,activity_type,back_view_name,process_type,bonus_payment_record_id,plate_id,pay_integral,pay_date,remark,applicant,apply_time,state,auditor,auditing_time,opinion,is_level_two";
	private final static String[] fieldNames = { "employee_id", "status", "employee_id", "employee_id", "status", "employee_id", "status", "bonus_payment_record_id", "plate_id", "pay_date", "applicant", "STATE", "auditor"};
}
