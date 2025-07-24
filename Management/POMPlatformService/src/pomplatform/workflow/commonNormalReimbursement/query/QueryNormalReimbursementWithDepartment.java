package pomplatform.workflow.commonNormalReimbursement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.commonNormalReimbursement.bean.BaseNormalReimbursementWithDepartment;
import pomplatform.workflow.commonNormalReimbursement.bean.ConditionNormalReimbursementWithDepartment;

public class QueryNormalReimbursementWithDepartment extends AbstractQuery<BaseNormalReimbursementWithDepartment, ConditionNormalReimbursementWithDepartment>
{

	private static final Logger __logger = Logger.getLogger(QueryNormalReimbursementWithDepartment.class);

	public QueryNormalReimbursementWithDepartment() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pnr.project_normal_reimbursement_id");
	}

	@Override
	public BaseCollection<BaseNormalReimbursementWithDepartment> executeQuery( KeyValuePair[] replacements, ConditionNormalReimbursementWithDepartment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectNormalReimbursementId()
			);
	}

	@Override
	public BaseNormalReimbursementWithDepartment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseNormalReimbursementWithDepartment __base = new BaseNormalReimbursementWithDepartment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectNormalReimbursementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReimbursementName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReimbursementTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setApplyTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStrikeABalance(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setAttachment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAttachmentNumber(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsProject(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setCurrency(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFeeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReimbursementType(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select pnr.project_normal_reimbursement_id, pnr.code, pnr.process_instance_id, pnr.apply_employee_id, pnr.employee_id, pnr.department_id, pnr.reimbursement_name, pnr.reimbursement_time, pnr.status, pnr.amount, pnr.apply_time, pnr.complete_time, pnr.remark, pnr.strike_a_balance, fm.file_url as attachment, pnr.attachment_number, pnr.company_id, pnr.is_project, pnr.currency, pnr.fee_type, pnr.reimbursement_type from project_normal_reimbursements pnr left join file_manages fm on pnr.attachment_id = fm.file_id where pnr.project_normal_reimbursement_id = ?" ;
	private final static String RESULTSETFIELDLIST = "project_normal_reimbursement_id,code,process_instance_id,apply_employee_id,employee_id,department_id,reimbursement_name,reimbursement_time,status,amount,apply_time,complete_time,remark,strike_a_balance,attachment,attachment_number,company_id,is_project,currency,fee_type,reimbursement_type";
	private final static String[] fieldNames = { "project_normal_reimbursement_id"};
}
