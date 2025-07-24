package pomplatform.spaymoneymanagemmcor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.spaymoneymanagemmcor.bean.BaseSpaymoneymanagemmcor;
import pomplatform.spaymoneymanagemmcor.bean.ConditionSpaymoneymanagemmcor;

public class QuerySpaymoneymanagemmcor extends AbstractQuery<BaseSpaymoneymanagemmcor, ConditionSpaymoneymanagemmcor>
{

	private static final Logger __logger = Logger.getLogger(QuerySpaymoneymanagemmcor.class);

	public QuerySpaymoneymanagemmcor() throws java.sql.SQLException 
	{
		setParameterNumber(12);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pmm.pay_money_manage_id");
	}

	@Override
	public BaseCollection<BaseSpaymoneymanagemmcor> executeQuery( KeyValuePair[] replacements, ConditionSpaymoneymanagemmcor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMinOperateTime(), 
				condition.getMaxOperateTime(), 
				condition.getCode(), 
				condition.getVoucherNo(), 
				condition.getEmployeeId(), 
				condition.getDepartmentId(), 
				condition.getOperateEmployeeId(), 
				condition.getReason(), 
				condition.getReceiveUnit(), 
				condition.getBankAccount(), 
				condition.getBankName(), 
				condition.getTitleName()
			);
	}

	@Override
	public BaseSpaymoneymanagemmcor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSpaymoneymanagemmcor __base = new BaseSpaymoneymanagemmcor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPayMoneyManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReceiveUnit(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTitleName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPayAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentFile(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsCompleted(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setBePacked(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setVoucherNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPostingDate(GenericBase.__getDateFromSQL(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setString(count++, GenericBase.__getString(args[11]));
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

	private final static String __SQLText = "select pmm.pay_money_manage_id, pmm.receive_unit, pmm.bank_account, pmm.bank_name, pmm.title_name, pmm.pay_amount, pmm.employee_id, pmm.department_id, pmm.attachment_file, pmm.reason, pmm.operate_employee_id, pmm.operate_time, pmm.company_id, pmm.code, pmm.delete_flag, pmm.is_completed, pmm.be_packed, pmm.voucher_no, pmm.posting_date from pay_money_manages pmm LEFT JOIN system_process_instances spi on pmm.pay_money_manage_id = spi.business_id and spi.process_type = 7 where spi.process_status in (0,1,3) and pmm.operate_time between ? and ? and pmm.delete_flag = 0 and pmm.code like ? and pmm.voucher_no like ? and pmm.employee_id = ? and pmm.department_id = ? and pmm.operate_employee_id = ? and pmm.reason like ? and pmm.receive_unit like ? and pmm.bank_account like ? and pmm.bank_name like ? and pmm.title_name like ?" ;
	private final static String RESULTSETFIELDLIST = "pay_money_manage_id,receive_unit,bank_account,bank_name,title_name,pay_amount,employee_id,department_id,attachment_file,reason,operate_employee_id,operate_time,company_id,code,delete_flag,is_completed,be_packed,voucher_no,posting_date";
	private final static String[] fieldNames = { "min_operate_time", "max_operate_time", "code", "voucher_no", "employee_id", "department_id", "operate_employee_id", "reason", "receive_unit", "bank_account", "bank_name", "title_name"};
}
