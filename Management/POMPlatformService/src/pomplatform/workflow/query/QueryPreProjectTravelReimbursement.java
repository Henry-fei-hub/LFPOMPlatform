package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BasePreProjectTravelReimbursement;
import pomplatform.workflow.bean.ConditionPreProjectTravelReimbursement;

public class QueryPreProjectTravelReimbursement extends AbstractQuery<BasePreProjectTravelReimbursement, ConditionPreProjectTravelReimbursement>
{

	private static final Logger __logger = Logger.getLogger(QueryPreProjectTravelReimbursement.class);

	public QueryPreProjectTravelReimbursement() throws java.sql.SQLException 
	{
		setParameterNumber(11);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("tr.travel_reimbursement_id");
	}

	@Override
	public BaseCollection<BasePreProjectTravelReimbursement> executeQuery( KeyValuePair[] replacements, ConditionPreProjectTravelReimbursement condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMinStartDate(), 
				condition.getMaxStartDate(), 
				condition.getMinEndDate(), 
				condition.getMaxEndDate(), 
				condition.getCode(), 
				condition.getTitle(), 
				condition.getRemark(), 
				condition.getProcessInstanceId(), 
				condition.getIsProject(), 
				condition.getDeleteFlag(),
				condition.getTravelReimbursementId()
			);
	}

	@Override
	public BasePreProjectTravelReimbursement generateBase(Object[] __data) throws java.sql.SQLException {
		BasePreProjectTravelReimbursement __base = new BasePreProjectTravelReimbursement();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setTravelReimbursementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTitle(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setApplicant(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDrafter(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReimbursementTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStrikeABalance(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setApplyTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setAttachment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAttachmentNumber(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsProject(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
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

	private final static String __SQLText = "select tr.travel_reimbursement_id, tr.code, tr.process_instance_id, tr.title, tr.applicant, tr.drafter, tr.department_id, tr.reimbursement_time, tr.start_date, tr.end_date, tr.amount, tr.strike_a_balance, tr.remark, tr.apply_time, tr.complete_time, tr.attachment, tr.attachment_number, tr.status, tr.company_id, tr.is_project, tr.delete_flag from travel_reimbursements tr where tr.start_date between ? and ? and tr.end_date between ? and ? and tr.code like ? and tr.title like ? and tr.remark like ? and tr.process_instance_id = ? and tr.is_project = ? and tr.delete_flag = ? AND tr.travel_reimbursement_id = ?" ;
	private final static String RESULTSETFIELDLIST = "travel_reimbursement_id,code,process_instance_id,title,applicant,drafter,department_id,reimbursement_time,start_date,end_date,amount,strike_a_balance,remark,apply_time,complete_time,attachment,attachment_number,status,company_id,is_project,delete_flag";
	private final static String[] fieldNames = { "min_start_date", "max_start_date", "min_end_date", "max_end_date", "code", "title", "remark", "process_instance_id", "is_project", "delete_flag", "travel_reimbursement_id"};
}
