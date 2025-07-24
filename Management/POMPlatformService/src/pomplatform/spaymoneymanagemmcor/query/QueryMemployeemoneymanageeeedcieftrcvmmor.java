package pomplatform.spaymoneymanagemmcor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.spaymoneymanagemmcor.bean.BaseMemployeemoneymanageeeedcieftrcvmmor;
import pomplatform.spaymoneymanagemmcor.bean.ConditionMemployeemoneymanageeeedcieftrcvmmor;

public class QueryMemployeemoneymanageeeedcieftrcvmmor extends AbstractQuery<BaseMemployeemoneymanageeeedcieftrcvmmor, ConditionMemployeemoneymanageeeedcieftrcvmmor>
{

	private static final Logger __logger = Logger.getLogger(QueryMemployeemoneymanageeeedcieftrcvmmor.class);

	public QueryMemployeemoneymanageeeedcieftrcvmmor() throws java.sql.SQLException 
	{
		setParameterNumber(13);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("emm.employee_money_manage_id");
	}

	@Override
	public BaseCollection<BaseMemployeemoneymanageeeedcieftrcvmmor> executeQuery( KeyValuePair[] replacements, ConditionMemployeemoneymanageeeedcieftrcvmmor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeNo(), 
				condition.getEmployeeId(), 
				condition.getDepartmentId(), 
				condition.getCode(), 
				condition.getIsCompleted(), 
				condition.getEmployeeName(), 
				condition.getFalg(), 
				condition.getTitleName(), 
				condition.getReason(), 
				condition.getCompanyId(), 
				condition.getVoucherNo(), 
				condition.getMinOperateTime(), 
				condition.getMaxOperateTime()
			);
	}

	@Override
	public BaseMemployeemoneymanageeeedcieftrcvmmor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMemployeemoneymanageeeedcieftrcvmmor __base = new BaseMemployeemoneymanageeeedcieftrcvmmor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeMoneyManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReturnMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBorrowDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setAnticipatedDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setReturnDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setTitleName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFalg(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[11]));
		if(args[12] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[12]));
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

	private final static String __SQLText = "SELECT emm.employee_money_manage_id, emm.employee_id, emm.department_id, emm.borrow_money, emm.return_money, emm.borrow_date, emm.anticipated_date, emm.return_date, emm.title_name, emm.reason, emm.falg, emm.operate_employee_id, emm.operate_time, emm.company_id, emm.code, emm.delete_flag, emm.is_completed, emm.be_packed, emm.voucher_no, emm.posting_date FROM employee_money_manages emm LEFT JOIN employees e ON e.employee_id = emm.employee_id LEFT JOIN system_process_instances spi on emm.employee_money_manage_id = spi.business_id and spi.process_type = 6 WHERE spi.process_status in (0,1,3) and e.employee_no LIKE ? AND emm.employee_id = ? AND emm.department_id = ? AND emm.code LIKE ? AND emm.delete_flag = 0 AND emm.is_completed = ? AND e.employee_name LIKE ? AND emm.falg = ? AND emm.title_name LIKE ? AND emm.reason LIKE ? AND emm.company_id = ? AND emm.voucher_no LIKE ? AND emm.operate_time BETWEEN ? AND ?" ;
	private final static String RESULTSETFIELDLIST = "employee_money_manage_id,employee_id,department_id,borrow_money,return_money,borrow_date,anticipated_date,return_date,title_name,reason,falg,operate_employee_id,operate_time,company_id,code,delete_flag,is_completed,be_packed,voucher_no,posting_date";
	private final static String[] fieldNames = { "employee_no", "employee_id", "department_id", "code", "is_completed", "employee_name", "falg", "title_name", "reason", "company_id", "voucher_no", "min_operate_time", "max_operate_time"};
}
