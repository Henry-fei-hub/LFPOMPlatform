package pomplatform.minvocieapplydedaocor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.minvocieapplydedaocor.bean.BaseMinvocieapplydedaocor;
import pomplatform.minvocieapplydedaocor.bean.ConditionMinvocieapplydedaocor;

public class QueryMinvocieapplydedaocor extends AbstractQuery<BaseMinvocieapplydedaocor, ConditionMinvocieapplydedaocor>
{

	private static final Logger __logger = Logger.getLogger(QueryMinvocieapplydedaocor.class);

	public QueryMinvocieapplydedaocor() throws java.sql.SQLException 
	{
		setParameterNumber(22);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ia.invoice_apply_id");
	}

	@Override
	public BaseCollection<BaseMinvocieapplydedaocor> executeQuery( KeyValuePair[] replacements, ConditionMinvocieapplydedaocor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMinOperatorTime(), 
				condition.getMaxOperatorTime(), 
				condition.getMinApplyTime(), 
				condition.getMaxApplyTime(), 
				condition.getInvoiceApplyId(), 
				condition.getApplicantDeparmentId(), 
				condition.getApplicantName(), 
				condition.getOperatorName(), 
				condition.getApplicantId(), 
				condition.getOperatorId(), 
				condition.getDepartmentName(), 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getContractId(), 
				condition.getBankName(), 
				condition.getBankAccount(), 
				condition.getInvoiceType(), 
				condition.getInvoiceApplyStatus(), 
				condition.getDutyParagraph(), 
				condition.getApplyRemark(), 
				condition.getOperatorRemark(), 
				condition.getCompanyName()
			);
	}

	@Override
	public BaseMinvocieapplydedaocor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMinvocieapplydedaocor __base = new BaseMinvocieapplydedaocor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setInvoiceApplyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setApplicantId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setApplicantName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setApplicantDeparmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDutyParagraph(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInvoiceType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRegisteredAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setApplyTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setApplySumMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setApplyRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperatorRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperatorName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInvoiceApplyStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperatorTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setQq(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmail(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLandline(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFax(GenericBase.__getString(val));

		
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
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setString(count++, GenericBase.__getString(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setInt(count++, GenericBase.__getInt(args[13]));
		if(args[14] != null) __statement.setString(count++, GenericBase.__getString(args[14]));
		if(args[15] != null) __statement.setString(count++, GenericBase.__getString(args[15]));
		if(args[16] != null) __statement.setInt(count++, GenericBase.__getInt(args[16]));
		if(args[17] != null) __statement.setInt(count++, GenericBase.__getInt(args[17]));
		if(args[18] != null) __statement.setString(count++, GenericBase.__getString(args[18]));
		if(args[19] != null) __statement.setString(count++, GenericBase.__getString(args[19]));
		if(args[20] != null) __statement.setString(count++, GenericBase.__getString(args[20]));
		if(args[21] != null) __statement.setString(count++, GenericBase.__getString(args[21]));
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

	private final static String __SQLText = "SELECT ia.invoice_apply_id, ia.applicant_id, ep.employee_name AS applicant_name, ia.applicant_deparment_id, dp.department_name, ia.contract_id, ct.contract_name, ct.contract_code, ia.company_name, ia.duty_paragraph,ia.invoice_type, ia.customer_name, ia.customer_phone, ia.registered_address, ia.bank_name, ia.bank_account, ia.apply_time, ia.apply_sum_money, ia.apply_remark, ia.operator_id, ia.operator_remark, ep_1.employee_name AS operator_name, ia.invoice_apply_status,ia.operator_time, ia.create_time, ia.update_time, ia.qq, ia.email, ia.landline, ia.fax FROM invoice_apply ia LEFT JOIN departments dp ON ia.applicant_deparment_id = dp.department_id LEFT JOIN employees ep ON ia.applicant_id = ep.employee_id LEFT JOIN employees ep_1 ON ia.operator_id = ep_1.employee_id LEFT JOIN contracts ct ON ct.contract_id = ia.contract_id WHERE ia.operator_time between ? and ? and ia.apply_time between ? and ? and ia.invoice_apply_id = ? AND ia.applicant_deparment_id = ? AND ep.employee_name LIKE ? AND ep_1.employee_name LIKE ? AND ia.applicant_id = ? AND ia.operator_id = ? AND dp.department_name LIKE ? AND ct.contract_code LIKE ? AND ct.contract_name LIKE ? AND ct.contract_id = ? AND ia.bank_name LIKE ? AND ia.bank_account LIKE ? AND ia.invoice_type = ? AND ia.invoice_apply_status = ? AND ia.duty_paragraph LIKE ? AND ia.apply_remark LIKE ? AND ia.operator_remark LIKE ? AND ia.company_name LIKE ? and ia.delete_flag = 0" ;
	private final static String RESULTSETFIELDLIST = "invoice_apply_id,applicant_id,applicant_name,applicant_deparment_id,department_name,contract_id,contract_name,contract_code,company_name,duty_paragraph,invoice_type,customer_name,customer_phone,registered_address,bank_name,bank_account,apply_time,apply_sum_money,apply_remark,operator_id,operator_remark,operator_name,invoice_apply_status,operator_time,create_time,update_time,qq,email,landline,fax";
	private final static String[] fieldNames = { "min_operator_time", "max_operator_time", "min_apply_time", "max_apply_time", "invoice_apply_id", "applicant_deparment_id", "applicant_name", "operator_name", "applicant_id", "operator_id", "department_name", "contract_code", "contract_name", "contract_id", "bank_name", "bank_account", "invoice_type", "invoice_apply_status", "duty_paragraph", "apply_remark", "operator_remark", "company_name"};
}
