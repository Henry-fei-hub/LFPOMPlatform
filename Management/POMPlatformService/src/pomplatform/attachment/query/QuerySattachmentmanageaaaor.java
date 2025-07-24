package pomplatform.attachment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.attachment.bean.BaseSattachmentmanageaaaor;
import pomplatform.attachment.bean.ConditionSattachmentmanageaaaor;

public class QuerySattachmentmanageaaaor extends AbstractQuery<BaseSattachmentmanageaaaor, ConditionSattachmentmanageaaaor>
{

	private static final Logger __logger = Logger.getLogger(QuerySattachmentmanageaaaor.class);

	public QuerySattachmentmanageaaaor() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("am.attachment_manage_id");
	}

	@Override
	public BaseCollection<BaseSattachmentmanageaaaor> executeQuery( KeyValuePair[] replacements, ConditionSattachmentmanageaaaor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getAttachmentCode(), 
				condition.getAttachmentName(), 
				condition.getAttachmentAddress(), 
				condition.getPerfessionRemark(), 
				condition.getAttachmentManageId(), 
				condition.getContractId(), 
				condition.getSerialNumber()
			);
	}

	@Override
	public BaseSattachmentmanageaaaor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSattachmentmanageaaaor __base = new BaseSattachmentmanageaaaor();
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
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSuperProjectManageId(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
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

	private final static String __SQLText = "select am.attachment_manage_id, am.contract_id, am.attachment_code, am.attachment_name, am.attachment_address, am.perfession_remark, am.amount, am.return_amount, am.payment_sure, am.payment_grade_description, am.serial_number, am.record_date, am.operate_employee_id, am.operate_time, am.remark, am.project_manage_id, am.department_id, am.super_project_manage_id from attachment_manages am where am.attachment_code like ? and am.attachment_name like ? and am.attachment_address like ? and am.perfession_remark like ? and am.attachment_manage_id = ? and am.contract_id = ? and am.serial_number = ? and am.delete_flag = 0 order by am.record_date asc" ;
	private final static String RESULTSETFIELDLIST = "attachment_manage_id,contract_id,attachment_code,attachment_name,attachment_address,perfession_remark,amount,return_amount,payment_sure,payment_grade_description,serial_number,record_date,operate_employee_id,operate_time,remark,project_manage_id,department_id,super_project_manage_id";
	private final static String[] fieldNames = { "attachment_code", "attachment_name", "attachment_address", "perfession_remark", "attachment_manage_id", "contract_id", "serial_number"};
}
