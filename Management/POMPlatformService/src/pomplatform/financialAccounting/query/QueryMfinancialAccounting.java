package pomplatform.financialAccounting.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.financialAccounting.bean.BaseMfinancialAccounting;
import pomplatform.financialAccounting.bean.ConditionMfinancialAccounting;

public class QueryMfinancialAccounting extends AbstractQuery<BaseMfinancialAccounting, ConditionMfinancialAccounting>
{

	private static final Logger __logger = Logger.getLogger(QueryMfinancialAccounting.class);

	public QueryMfinancialAccounting() throws java.sql.SQLException 
	{
		setParameterNumber(56);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseMfinancialAccounting> executeQuery( KeyValuePair[] replacements, ConditionMfinancialAccounting condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessStatus(), 
				condition.getProcessType(), 
				condition.getCompanyId(), 
				condition.getDepartmentId(), 
				condition.getEmployeeId(), 
				condition.getCode(), 
				condition.getVoucherNo(), 
				condition.getPostingDateBegin(), 
				condition.getPostingDateEnd(), 
				condition.getCompleteTimeBegin(), 
				condition.getCompleteTimeEnd(), 
				condition.getApplyTimeBegin(), 
				condition.getApplyTimeEnd(), 
				condition.getBePacked(), 
				condition.getProcessStatus(), 
				condition.getProcessType(), 
				condition.getCompanyId(), 
				condition.getDepartmentId(), 
				condition.getEmployeeId(), 
				condition.getCode(), 
				condition.getVoucherNo(), 
				condition.getPostingDateBegin(), 
				condition.getPostingDateEnd(), 
				condition.getCompleteTimeBegin(), 
				condition.getCompleteTimeEnd(), 
				condition.getApplyTimeBegin(), 
				condition.getApplyTimeEnd(), 
				condition.getBePacked(), 
				condition.getProcessStatus(), 
				condition.getProcessType(), 
				condition.getCompanyId(), 
				condition.getDepartmentId(), 
				condition.getEmployeeId(), 
				condition.getCode(), 
				condition.getVoucherNo(), 
				condition.getPostingDateBegin(), 
				condition.getPostingDateEnd(), 
				condition.getCompleteTimeBegin(), 
				condition.getCompleteTimeEnd(), 
				condition.getApplyTimeBegin(), 
				condition.getApplyTimeEnd(), 
				condition.getBePacked(), 
				condition.getProcessStatus(), 
				condition.getProcessType(), 
				condition.getCompanyId(), 
				condition.getDepartmentId(), 
				condition.getEmployeeId(), 
				condition.getCode(), 
				condition.getVoucherNo(), 
				condition.getPostingDateBegin(), 
				condition.getPostingDateEnd(), 
				condition.getCompleteTimeBegin(), 
				condition.getCompleteTimeEnd(), 
				condition.getApplyTimeBegin(), 
				condition.getApplyTimeEnd(), 
				condition.getBePacked()
			);
	}

	@Override
	public BaseMfinancialAccounting generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMfinancialAccounting __base = new BaseMfinancialAccounting();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPayMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBalanceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTitle(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setVoucherNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPostingDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setBePacked(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
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
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[7]));
		if(args[8] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[8]));
		if(args[9] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[9]));
		if(args[10] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[10]));
		if(args[11] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[11]));
		if(args[12] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[12]));
		if(args[13] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[13]));
		if(args[14] != null) __statement.setInt(count++, GenericBase.__getInt(args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setInt(count++, GenericBase.__getInt(args[16]));
		if(args[17] != null) __statement.setInt(count++, GenericBase.__getInt(args[17]));
		if(args[18] != null) __statement.setInt(count++, GenericBase.__getInt(args[18]));
		if(args[19] != null) __statement.setString(count++, GenericBase.__getString(args[19]));
		if(args[20] != null) __statement.setString(count++, GenericBase.__getString(args[20]));
		if(args[21] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[21]));
		if(args[22] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[22]));
		if(args[23] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[23]));
		if(args[24] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[24]));
		if(args[25] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[25]));
		if(args[26] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[26]));
		if(args[27] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[27]));
		if(args[28] != null) __statement.setInt(count++, GenericBase.__getInt(args[28]));
		if(args[29] != null) __statement.setInt(count++, GenericBase.__getInt(args[29]));
		if(args[30] != null) __statement.setInt(count++, GenericBase.__getInt(args[30]));
		if(args[31] != null) __statement.setInt(count++, GenericBase.__getInt(args[31]));
		if(args[32] != null) __statement.setInt(count++, GenericBase.__getInt(args[32]));
		if(args[33] != null) __statement.setString(count++, GenericBase.__getString(args[33]));
		if(args[34] != null) __statement.setString(count++, GenericBase.__getString(args[34]));
		if(args[35] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[35]));
		if(args[36] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[36]));
		if(args[37] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[37]));
		if(args[38] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[38]));
		if(args[39] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[39]));
		if(args[40] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[40]));
		if(args[41] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[41]));
		if(args[42] != null) __statement.setInt(count++, GenericBase.__getInt(args[42]));
		if(args[43] != null) __statement.setInt(count++, GenericBase.__getInt(args[43]));
		if(args[44] != null) __statement.setInt(count++, GenericBase.__getInt(args[44]));
		if(args[45] != null) __statement.setInt(count++, GenericBase.__getInt(args[45]));
		if(args[46] != null) __statement.setInt(count++, GenericBase.__getInt(args[46]));
		if(args[47] != null) __statement.setString(count++, GenericBase.__getString(args[47]));
		if(args[48] != null) __statement.setString(count++, GenericBase.__getString(args[48]));
		if(args[49] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[49]));
		if(args[50] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[50]));
		if(args[51] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[51]));
		if(args[52] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[52]));
		if(args[53] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[53]));
		if(args[54] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[54]));
		if(args[55] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[55]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.business_id, spi.process_type, pnr.apply_time AS create_time, spi.complete_time, pnr.apply_employee_id AS employee_id, pnr.code, pnr.amount, pbl.pay_money, pbl.balance_amount, pnr.department_id, pnr.company_id, pnr.remark, pnr.reimbursement_name AS title, pnr.voucher_no, pnr.posting_date, pnr.be_packed, spi.process_id FROM system_process_instances spi LEFT JOIN project_normal_reimbursements pnr ON pnr.project_normal_reimbursement_id = spi.business_id LEFT JOIN ( SELECT business_id, SUM (pay_money) AS pay_money, SUM (balance_amount) AS balance_amount FROM process_bill_list WHERE process_type IN (2, 3, 8, 10) GROUP BY business_id ) pbl ON pbl.business_id = pnr.project_normal_reimbursement_id WHERE spi.process_status = ? AND spi.process_type IN (2, 3, 8, 10) AND spi.process_type = ? AND spi.delete_flag = 0 AND pnr.delete_flag = 0 AND pnr.company_id = ? AND pnr.department_id = ? AND pnr.apply_employee_id = ? AND pnr.code LIKE ? AND pnr.voucher_no LIKE ? AND pnr.posting_date BETWEEN ? AND ? AND spi.complete_time BETWEEN ? AND ? AND pnr.apply_time BETWEEN ? AND ? AND pnr.be_packed = ? UNION ALL SELECT spi.process_instance_id, spi.business_id, spi.process_type, tr.apply_time AS create_time, spi.complete_time, tr.drafter AS employee_id, tr.code, tr.amount, pbl.pay_money, pbl.balance_amount, tr.department_id, tr.company_id, tr.remark, tr.title, tr.voucher_no, tr.posting_date, tr.be_packed, spi.process_id FROM system_process_instances spi LEFT JOIN travel_reimbursements tr ON tr.travel_reimbursement_id = spi.business_id LEFT JOIN ( SELECT business_id, SUM (pay_money) AS pay_money, SUM (balance_amount) AS balance_amount FROM process_bill_list WHERE process_type IN (4, 5, 9) GROUP BY business_id ) pbl ON pbl.business_id = tr.travel_reimbursement_id WHERE spi.process_status = ? AND spi.process_type IN (4, 5, 9) AND spi.process_type = ? AND spi.delete_flag = 0 AND tr.delete_flag = 0 AND tr.company_id = ? AND tr.department_id = ? AND tr.drafter = ? AND tr.code LIKE ? AND tr.voucher_no LIKE ? AND tr.posting_date BETWEEN ? AND ? AND spi.complete_time BETWEEN ? AND ? AND tr.apply_time BETWEEN ? AND ? AND tr.be_packed = ? UNION ALL SELECT spi.process_instance_id, spi.business_id, spi.process_type, pmm.operate_time AS create_time, spi.complete_time, pmm.operate_employee_id AS employee_id, pmm.code, pmm.pay_amount AS amount, pbl.pay_money, pbl.balance_amount, pmm.department_id, pmm.company_id, pmm.reason AS remark, pmm.title_name AS title, pmm.voucher_no, pmm.posting_date, pmm.be_packed, spi.process_id FROM system_process_instances spi LEFT JOIN pay_money_manages pmm ON pmm.pay_money_manage_id = spi.business_id LEFT JOIN ( SELECT business_id, SUM (pay_money) AS pay_money, SUM (balance_amount) AS balance_amount FROM process_bill_list WHERE process_type = 7 GROUP BY business_id ) pbl ON pbl.business_id = pmm.pay_money_manage_id WHERE spi.process_status = ? AND spi.process_type = 7 AND spi.process_type = ? AND spi.delete_flag = 0 AND pmm.delete_flag = 0 AND pmm.company_id = ? AND pmm.department_id = ? AND pmm.operate_employee_id = ? AND pmm.code LIKE ? AND pmm.voucher_no LIKE ? AND pmm.posting_date BETWEEN ? AND ? AND spi.complete_time BETWEEN ? AND ? AND pmm.operate_time BETWEEN ? AND ? AND pmm.be_packed =? UNION ALL SELECT spi.process_instance_id, spi.business_id, spi.process_type, emm.operate_time AS create_time, spi.complete_time, emm.operate_employee_id AS employee_id, emm.code, emm.borrow_money AS amount, pbl.pay_money, pbl.balance_amount, emm.department_id, emm.company_id, emm.reason AS remark, emm.title_name AS title, emm.voucher_no, emm.posting_date, emm.be_packed, spi.process_id FROM system_process_instances spi LEFT JOIN employee_money_manages emm ON emm.employee_money_manage_id = spi.business_id LEFT JOIN ( SELECT business_id, SUM (pay_money) AS pay_money, SUM (balance_amount) AS balance_amount FROM process_bill_list WHERE process_type = 6 GROUP BY business_id ) pbl ON pbl.business_id = emm.employee_money_manage_id WHERE spi.process_status = ? AND spi.process_type = 6 AND spi.process_type = ? AND spi.delete_flag = 0 AND emm.delete_flag = 0 AND emm.company_id = ? AND emm.department_id = ? AND emm.operate_employee_id = ? AND emm.code LIKE ? AND emm.voucher_no LIKE ? AND emm.posting_date BETWEEN ? AND ? AND spi.complete_time BETWEEN ? AND ? AND emm.operate_time BETWEEN ? AND ? AND emm.be_packed =?" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,business_id,process_type,create_time,complete_time,employee_id,code,amount,pay_money,balance_amount,department_id,company_id,remark,title,voucher_no,posting_date,be_packed,process_id";
	private final static String[] fieldNames = { "process_status", "process_type", "company_id", "department_id", "employee_id", "code", "voucher_no", "posting_date_begin", "posting_date_end", "complete_time_begin", "complete_time_end", "apply_time_begin", "apply_time_end", "be_packed", "process_status", "process_type", "company_id", "department_id", "employee_id", "code", "voucher_no", "posting_date_begin", "posting_date_end", "complete_time_begin", "complete_time_end", "apply_time_begin", "apply_time_end", "be_packed", "process_status", "process_type", "company_id", "department_id", "employee_id", "code", "voucher_no", "posting_date_begin", "posting_date_end", "complete_time_begin", "complete_time_end", "apply_time_begin", "apply_time_end", "be_packed", "process_status", "process_type", "company_id", "department_id", "employee_id", "code", "voucher_no", "posting_date_begin", "posting_date_end", "complete_time_begin", "complete_time_end", "apply_time_begin", "apply_time_end", "be_packed"};
}
