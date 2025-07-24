package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseEmployeeBorrowMoneyByWorkflow;
import pomplatform.workflow.bean.ConditionEmployeeBorrowMoneyByWorkflow;

public class QueryEmployeeBorrowMoneyByWorkflow extends AbstractQuery<BaseEmployeeBorrowMoneyByWorkflow, ConditionEmployeeBorrowMoneyByWorkflow>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeBorrowMoneyByWorkflow.class);

	public QueryEmployeeBorrowMoneyByWorkflow() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_money_manage_id");
	}

	@Override
	public BaseCollection<BaseEmployeeBorrowMoneyByWorkflow> executeQuery( KeyValuePair[] replacements, ConditionEmployeeBorrowMoneyByWorkflow condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getEmployeeId(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseEmployeeBorrowMoneyByWorkflow generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeBorrowMoneyByWorkflow __base = new BaseEmployeeBorrowMoneyByWorkflow();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeMoneyManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBorrowDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setAnticipatedDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setTitleName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "select a.employee_money_manage_id,b.employee_no,b.employee_name,b.status ,a.employee_id,a.department_id,a.borrow_money,borrow_date ,a.anticipated_date,a.title_name,a.reason,a.operate_employee_id,a.operate_time,a.code,a.company_id from employee_money_manages a left join employees b on a.employee_id = b.employee_id where b.employee_no like ? and b.employee_name like ? and a.employee_id = ? and a.department_id in (select child_id from department_ids where department_id = ?) ORDER BY a.department_id,b.employee_no" ;
	private final static String RESULTSETFIELDLIST = "employee_money_manage_id,employee_no,employee_name,status,employee_id,department_id,borrow_money,borrow_date,anticipated_date,title_name,reason,operate_employee_id,operate_time,code,company_id";
	private final static String[] fieldNames = { "employee_no", "employee_name", "employee_id", "department_id"};
}
