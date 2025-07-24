package pomplatform.cardManage.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.cardManage.bean.BaseEmployeeCardManage;
import pomplatform.cardManage.bean.ConditionEmployeeCardManage;

public class QueryEmployeeCardManage extends AbstractQuery<BaseEmployeeCardManage, ConditionEmployeeCardManage>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeCardManage.class);

	public QueryEmployeeCardManage() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.employee_no");
	}

	@Override
	public BaseCollection<BaseEmployeeCardManage> executeQuery( KeyValuePair[] replacements, ConditionEmployeeCardManage condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEnabled(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseEmployeeCardManage generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeCardManage __base = new BaseEmployeeCardManage();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCardManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setObjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setObjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBankId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCardType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDefaultCard(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setEnabled(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setCurrencyType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCmbcCodeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTruePayment(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setBankName(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
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

	private final static String __SQLText = "select b.employee_no,b.employee_name,b.department_id,b.status,a.* from card_manages a LEFT JOIN employees b on a.object_id = b.employee_id where a.object_type = 1 and a.enabled = ? and b.employee_no like ? and b.employee_name like ? and b.department_id in (select child_id from department_ids where department_id = ?) ORDER BY b.department_id,b.employee_no" ;
	private final static String RESULTSETFIELDLIST = "employee_no,employee_name,department_id,status,card_manage_id,object_id,object_type,bank_id,bank_account,bank_address,card_type,default_card,enabled,currency_type,cmbc_code_id,true_payment,bank_name";
	private final static String[] fieldNames = { "enabled", "employee_no", "employee_name", "department_id"};
}
