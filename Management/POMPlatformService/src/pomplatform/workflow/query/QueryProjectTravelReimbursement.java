package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseProjectTravelReimbursement;
import pomplatform.workflow.bean.ConditionProjectTravelReimbursement;

public class QueryProjectTravelReimbursement extends AbstractQuery<BaseProjectTravelReimbursement, ConditionProjectTravelReimbursement>
{

	private static final Logger __logger = Logger.getLogger(QueryProjectTravelReimbursement.class);

	public QueryProjectTravelReimbursement() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("tr.travel_reimbursement_id");
	}

	@Override
	public BaseCollection<BaseProjectTravelReimbursement> executeQuery( KeyValuePair[] replacements, ConditionProjectTravelReimbursement condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getTravelReimbursementId()
			);
	}

	@Override
	public BaseProjectTravelReimbursement generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProjectTravelReimbursement __base = new BaseProjectTravelReimbursement();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setTravelReimbursementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTravelReimbursementNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTitle(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setApplicant(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDrafter(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select tr.travel_reimbursement_id, tr.travel_reimbursement_no, tr.process_instance_id, tr.title, tr.applicant, tr.drafter, tr.department_id, tr.project_id, tr.reimbursement_time, tr.start_date, tr.end_date, tr.amount, tr.strike_a_balance, tr.remark, tr.apply_time, tr.complete_time, tr.attachment, tr.attachment_number, tr.status from travel_reimbursements tr where tr.travel_reimbursement_id = ?" ;
	private final static String RESULTSETFIELDLIST = "travel_reimbursement_id,travel_reimbursement_no,process_instance_id,title,applicant,drafter,department_id,project_id,reimbursement_time,start_date,end_date,amount,strike_a_balance,remark,apply_time,complete_time,attachment,attachment_number,status";
	private final static String[] fieldNames = { "travel_reimbursement_id"};
}
