package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BasePreProjectNormalReimbursement;
import pomplatform.workflow.bean.ConditionPreProjectNormalReimbursement;

public class QueryPreProjectNormalReimbursement extends AbstractQuery<BasePreProjectNormalReimbursement, ConditionPreProjectNormalReimbursement>
{

	private static final Logger __logger = Logger.getLogger(QueryPreProjectNormalReimbursement.class);

	public QueryPreProjectNormalReimbursement() throws java.sql.SQLException 
	{
		setParameterNumber(10);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pnr.project_normal_reimbursement_id");
	}

	@Override
	public BaseCollection<BasePreProjectNormalReimbursement> executeQuery( KeyValuePair[] replacements, ConditionPreProjectNormalReimbursement condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessInstanceId(), 
				condition.getApplyEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getDepartmentId(), 
				condition.getReimbursementName(), 
				condition.getStatus(), 
				condition.getAmount(), 
				condition.getRemark(), 
				condition.getCode(),
				condition.getProjectNormalReimbursementId()
			);
	}

	@Override
	public BasePreProjectNormalReimbursement generateBase(Object[] __data) throws java.sql.SQLException {
		BasePreProjectNormalReimbursement __base = new BasePreProjectNormalReimbursement();
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
		if(args[0] != null) __statement.setInt(count++, GenericBase.__getInt(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
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

	private final static String __SQLText = "select pnr.project_normal_reimbursement_id, pnr.code, pnr.process_instance_id, pnr.apply_employee_id, pnr.employee_id, pnr.department_id, pnr.reimbursement_name, pnr.reimbursement_time, pnr.status, pnr.amount, pnr.apply_time, pnr.complete_time, pnr.remark, pnr.strike_a_balance, pnr.attachment, pnr.attachment_number, pnr.company_id, pnr.is_project, pnr.delete_flag from project_normal_reimbursements pnr where pnr.process_instance_id = ? and pnr.apply_employee_id = ? and pnr.employee_id = ? and pnr.department_id = ? and pnr.reimbursement_name = ? and pnr.status = ? and pnr.amount = ? and pnr.remark = ? and pnr.code like ? AND pnr.project_normal_reimbursement_id = ?" ;
	private final static String RESULTSETFIELDLIST = "project_normal_reimbursement_id,code,process_instance_id,apply_employee_id,employee_id,department_id,reimbursement_name,reimbursement_time,status,amount,apply_time,complete_time,remark,strike_a_balance,attachment,attachment_number,company_id,is_project,delete_flag";
	private final static String[] fieldNames = { "process_instance_id", "apply_employee_id", "employee_id", "department_id", "reimbursement_name", "status", "amount", "remark", "code", "project_normal_reimbursement_id"};
}
