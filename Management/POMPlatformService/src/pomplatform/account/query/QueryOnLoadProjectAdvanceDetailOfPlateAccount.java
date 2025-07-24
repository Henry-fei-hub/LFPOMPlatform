package pomplatform.account.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseOnLoadProjectAdvanceDetailOfPlateAccount;
import pomplatform.account.bean.ConditionOnLoadProjectAdvanceDetailOfPlateAccount;

public class QueryOnLoadProjectAdvanceDetailOfPlateAccount extends AbstractQuery<BaseOnLoadProjectAdvanceDetailOfPlateAccount, ConditionOnLoadProjectAdvanceDetailOfPlateAccount>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadProjectAdvanceDetailOfPlateAccount.class);

	public QueryOnLoadProjectAdvanceDetailOfPlateAccount() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.plate_id");
	}

	@Override
	public BaseCollection<BaseOnLoadProjectAdvanceDetailOfPlateAccount> executeQuery( KeyValuePair[] replacements, ConditionOnLoadProjectAdvanceDetailOfPlateAccount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getBusinessTypeId(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getSheetCode(), 
				condition.getSheetName(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseOnLoadProjectAdvanceDetailOfPlateAccount generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadProjectAdvanceDetailOfPlateAccount __base = new BaseOnLoadProjectAdvanceDetailOfPlateAccount();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSheetCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSheetName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setGradeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
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

	private final static String __SQLText = "select a.plate_id,b.project_id,d.contract_code as sheet_code,d.project_name as sheet_name,c.employee_no,c.employee_name,c.status,c.grade_id,a.integral,a.record_date,a.remark from plate_account_records a left join project_employee_advance_records b on a.business_id = b.project_employee_advance_record_id left join employees c on b.employee_id = c.employee_id left join projects d on b.project_id = d.project_id where a.plate_id = ? and a.business_type_id = ? and c.employee_no like ? and c.employee_name like ? and d.contract_code like ? and d.project_name like ? and EXTRACT(YEAR from a.record_date) =? and EXTRACT(MONTH from a.record_date) =? ORDER BY b.project_id,b.employee_id,a.record_date,a.integral desc" ;
	private final static String RESULTSETFIELDLIST = "plate_id,project_id,sheet_code,sheet_name,employee_no,employee_name,status,grade_id,integral,record_date,remark";
	private final static String[] fieldNames = { "plate_id", "business_type_id", "employee_no", "employee_name", "sheet_code", "sheet_name", "year", "month"};
}
