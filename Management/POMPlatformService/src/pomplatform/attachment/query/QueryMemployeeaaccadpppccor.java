package pomplatform.attachment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.attachment.bean.BaseMemployeeaaccadpppccor;
import pomplatform.attachment.bean.ConditionMemployeeaaccadpppccor;

public class QueryMemployeeaaccadpppccor extends AbstractQuery<BaseMemployeeaaccadpppccor, ConditionMemployeeaaccadpppccor>
{

	private static final Logger __logger = Logger.getLogger(QueryMemployeeaaccadpppccor.class);

	public QueryMemployeeaaccadpppccor() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("am.attachment_manage_id");
	}

	@Override
	public BaseCollection<BaseMemployeeaaccadpppccor> executeQuery( KeyValuePair[] replacements, ConditionMemployeeaaccadpppccor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getAttachmentName(), 
				condition.getDeleteFlag(), 
				condition.getProjectManageId(), 
				condition.getProjectManageId(), 
				condition.getProjectManageId(), 
				condition.getContractName(), 
				condition.getContractCode()
			);
	}

	@Override
	public BaseMemployeeaaccadpppccor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMemployeeaaccadpppccor __base = new BaseMemployeeaaccadpppccor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setAttachmentManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAttachmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAttachmentAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPerfessionRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReturnAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPaymentSure(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setPaymentGradeDescription(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSerialNumber(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSuperProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHaveVoucher(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNameStr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFinanceRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCanReceivedPayment(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setResidualReceipts(GenericBase.__getDecimal(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
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

	private final static String __SQLText = "SELECT am.attachment_manage_id, am.contract_id, am.attachment_code, am.attachment_name, am.attachment_address, am.perfession_remark, am.amount, am.return_amount, am.payment_sure, am.payment_grade_description, am.serial_number, am.record_date, am.operate_employee_id, am.operate_time, am.remark, am.delete_flag, am.project_manage_id, am.department_id, am.super_project_manage_id, am.personnel_business_id, am.have_voucher, ct.contract_name, ct.contract_code, array_to_string(array(SELECT employee_name FROM employees WHERE employee_id in (SELECT ame.employee_id FROM attachment_manage_employee ame WHERE ame.attachment_manage_id = am.attachment_manage_id)), ',') AS employee_name_str,am.finance_remark,am.can_received_payment, CASE WHEN am.can_received_payment THEN COALESCE (am.amount, 0) - COALESCE (am.return_amount, 0) ELSE 0 END AS residual_receipts FROM attachment_manages am LEFT JOIN contracts ct ON ct.contract_id = am.contract_id WHERE am.contract_id = ? AND am.attachment_name like ? AND am.delete_flag = ? AND (am.project_manage_id = ? OR am.super_project_manage_id = ? OR ame.employee_id = ?) AND am.amount != am.return_amount AND ct.contract_name like ? AND ct.contract_code like ? ORDER BY am.record_date" ;
	private final static String RESULTSETFIELDLIST = "attachment_manage_id,contract_id,attachment_code,attachment_name,attachment_address,perfession_remark,amount,return_amount,payment_sure,payment_grade_description,serial_number,record_date,operate_employee_id,operate_time,remark,delete_flag,project_manage_id,department_id,super_project_manage_id,personnel_business_id,have_voucher,contract_name,contract_code,employee_name_str,finance_remark,can_received_payment,residual_receipts";
	private final static String[] fieldNames = { "contract_id", "attachment_name", "delete_flag", "project_manage_id", "project_manage_id", "project_manage_id", "contract_name", "contract_code"};
}
