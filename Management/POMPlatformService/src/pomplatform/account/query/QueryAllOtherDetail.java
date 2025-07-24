package pomplatform.account.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseAllOtherDetail;
import pomplatform.account.bean.ConditionAllOtherDetail;

public class QueryAllOtherDetail extends AbstractQuery<BaseAllOtherDetail, ConditionAllOtherDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryAllOtherDetail.class);

	public QueryAllOtherDetail() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A.employee_id");
	}

	@Override
	public BaseCollection<BaseAllOtherDetail> executeQuery( KeyValuePair[] replacements, ConditionAllOtherDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getPlateId(), 
				condition.getEmployeeId(), 
				condition.getBusinessTypeId()
			);
	}

	@Override
	public BaseAllOtherDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAllOtherDetail __base = new BaseAllOtherDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT A.employee_id, b.employee_no, b.employee_name, A.integral, a.record_date, a.operate_time, a.operate_employee_id, A.remark FROM employee_account_records A LEFT JOIN employees b ON A.employee_id = b.employee_id LEFT JOIN employee_day_plate_records C ON A.employee_id = C.employee_id AND A.record_date = C.record_date WHERE EXTRACT ( YEAR FROM A.record_date ) = ? AND EXTRACT ( MONTH FROM A.record_date )= ? AND C.plate_id = ? AND A.employee_id =? AND A.business_type_id = ? ORDER BY A.record_date DESC" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,integral,record_date,operate_time,operate_employee_id,remark";
	private final static String[] fieldNames = { "year", "month", "plate_id", "employee_id", "business_type_id"};
}
