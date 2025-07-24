package pomplatform.attachmentManageMeeting.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.attachmentManageMeeting.bean.BaseAttachmentManageMeetingTor;
import pomplatform.attachmentManageMeeting.bean.ConditionAttachmentManageMeetingTor;

public class QueryAttachmentManageMeetingTor extends AbstractQuery<BaseAttachmentManageMeetingTor, ConditionAttachmentManageMeetingTor>
{

	private static final Logger __logger = Logger.getLogger(QueryAttachmentManageMeetingTor.class);

	public QueryAttachmentManageMeetingTor() throws java.sql.SQLException 
	{
		setParameterNumber(12);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("amm.attachment_manage_meeting_id");
	}

	@Override
	public BaseCollection<BaseAttachmentManageMeetingTor> executeQuery( KeyValuePair[] replacements, ConditionAttachmentManageMeetingTor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectManageId(), 
				condition.getContractId(), 
				condition.getAttachmentName(), 
				condition.getProjectManageId(), 
				condition.getContractName(), 
				condition.getContractCode(), 
				condition.getRemark(), 
				condition.getMettingStatus(), 
				condition.getOperatorStatus(), 
				condition.getYear(), 
				condition.getWorkNum(), 
				condition.getAttachmentManageId()
			);
	}

	@Override
	public BaseAttachmentManageMeetingTor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAttachmentManageMeetingTor __base = new BaseAttachmentManageMeetingTor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setAttachmentManageMeetingId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setExpectReturnDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setNeedReturnAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPublishDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSubmitDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setMettingStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperatorStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWorkNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setAttachmentManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
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
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSuperProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHaveVoucher(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEmployeeNameStr(GenericBase.__getString(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
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

	private final static String __SQLText = "SELECT amm.attachment_manage_meeting_id, amm.contract_id, amm.expect_return_date, amm.need_return_amount, amm.remark, amm.publish_date, amm.submit_date, amm.end_date, amm.metting_status, amm.operator_status, amm. YEAR, amm.work_num, amm. OPERATOR, amm.create_time, amm.attachment_manage_id, amm.project_manage_id, amm.start_date, ct.contract_name, ct.contract_code, am.attachment_code, am.attachment_name, am.attachment_address, am.perfession_remark, am.amount, am.return_amount, am.payment_sure, am.payment_grade_description, am.serial_number, am.record_date, am.operate_employee_id, am.operate_time, am.delete_flag, am.department_id, am.super_project_manage_id, am.personnel_business_id, am.have_voucher, COALESCE (C .invoice_amount, 0) AS invoice_amount, array_to_string( ARRAY ( SELECT employee_name FROM employees WHERE employee_id IN ( SELECT ame.employee_id FROM attachment_manage_employee ame WHERE ame.attachment_manage_id = amm.attachment_manage_id ) ), ',' ) AS employee_name_str FROM attachment_manage_meeting amm LEFT JOIN contracts ct ON ct.contract_id = amm.contract_id LEFT JOIN attachment_manages am ON am.attachment_manage_id = amm.attachment_manage_id LEFT JOIN ( SELECT aa.attachment_manage_id, SUM (aa.invoice_amount) AS invoice_amount FROM ( SELECT ali.attachment_manage_id, i.invoice_amount FROM attachment_link_invoices ali LEFT JOIN invoices i ON i.invoice_id = ali.invoice_id ) aa GROUP BY aa.attachment_manage_id ) C ON C .attachment_manage_id = am.attachment_manage_id WHERE amm.project_manage_id = ? AND amm.contract_id = ? AND am.attachment_name LIKE ? AND am.project_manage_id = ? AND ct.contract_name LIKE ? AND ct.contract_code LIKE ? AND amm.remark LIKE ? AND amm.metting_status = ? AND amm.operator_status = ? AND amm.year = ? AND amm.work_num = ? AND am.attachment_manage_id = ?" ;
	private final static String RESULTSETFIELDLIST = "attachment_manage_meeting_id,contract_id,expect_return_date,need_return_amount,remark,publish_date,submit_date,end_date,metting_status,operator_status,year,work_num,operator,create_time,attachment_manage_id,project_manage_id,start_date,contract_name,contract_code,attachment_code,attachment_name,attachment_address,perfession_remark,amount,return_amount,payment_sure,payment_grade_description,serial_number,record_date,operate_employee_id,operate_time,delete_flag,department_id,super_project_manage_id,personnel_business_id,have_voucher,invoice_amount,employee_name_str";
	private final static String[] fieldNames = { "project_manage_id", "contract_id", "attachment_name", "project_manage_id", "contract_name", "contract_code", "remark", "metting_status", "operator_status", "year", "work_num", "attachment_manage_id"};
}
