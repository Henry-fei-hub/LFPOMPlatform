package pomplatform.borrowMoneyManage.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.borrowMoneyManage.bean.BaseBorrowMoneyManage;
import pomplatform.borrowMoneyManage.bean.ConditionBorrowMoneyManage;

public class QueryBorrowMoneyManage extends AbstractQuery<BaseBorrowMoneyManage, ConditionBorrowMoneyManage>
{

	private static final Logger __logger = Logger.getLogger(QueryBorrowMoneyManage.class);

	public QueryBorrowMoneyManage() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.employee_no");
	}

	@Override
	public BaseCollection<BaseBorrowMoneyManage> executeQuery( KeyValuePair[] replacements, ConditionBorrowMoneyManage condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseBorrowMoneyManage generateBase(Object[] __data) throws java.sql.SQLException {
		BaseBorrowMoneyManage __base = new BaseBorrowMoneyManage();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBorrowLimitManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBorrowLimitMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUpdateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUpdateDate(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "select b.employee_no,b.employee_name,b.department_id,b.status,a.* from borrow_limit_manages a LEFT JOIN employees b on a.employee_id = b.employee_id where b.employee_no like ? and b.employee_name like ? and b.department_id in (select child_id from department_ids where department_id = ?) ORDER BY b.department_id,b.employee_no" ;
	private final static String RESULTSETFIELDLIST = "employee_no,employee_name,department_id,status,borrow_limit_manage_id,employee_id,borrow_limit_money,create_employee_id,create_date,update_employee_id,update_date";
	private final static String[] fieldNames = { "employee_no", "employee_name", "department_id"};
}
