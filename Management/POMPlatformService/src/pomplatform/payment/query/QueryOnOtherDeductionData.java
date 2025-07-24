package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnOtherDeductionData;
import pomplatform.payment.bean.ConditionOnOtherDeductionData;

public class QueryOnOtherDeductionData extends AbstractQuery<BaseOnOtherDeductionData, ConditionOnOtherDeductionData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnOtherDeductionData.class);

	public QueryOnOtherDeductionData() throws java.sql.SQLException 
	{
		setParameterNumber(10);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A.other_deduction_id");
	}

	@Override
	public BaseCollection<BaseOnOtherDeductionData> executeQuery( KeyValuePair[] replacements, ConditionOnOtherDeductionData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getCompanyId(), 
				condition.getDepartmentId(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getIsSended()
			);
	}

	@Override
	public BaseOnOtherDeductionData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnOtherDeductionData __base = new BaseOnOtherDeductionData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setOtherDeductionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOtherDeduction(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsSended(GenericBase.__getBoolean(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[9]));
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

	private final static String __SQLText = "SELECT A.other_deduction_id, A.employee_id, b.employee_no, b.employee_name, b.company_id, b.plate_id, b.department_id, A.record_date, convert_from( decrypt ( CAST ( A.other_deduction AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS other_deduction, A.is_sended FROM other_deductions A LEFT JOIN employees b ON A.employee_id = b.employee_id WHERE A.employee_id =? AND b.employee_no LIKE ? AND b.employee_name LIKE ? AND b.company_id =? AND b.department_id IN ( SELECT child_id FROM department_ids WHERE department_id =? ) AND A.record_date BETWEEN ? AND ? AND A.YEAR =? AND A.MONTH =? AND A.is_sended =?" ;
	private final static String RESULTSETFIELDLIST = "other_deduction_id,employee_id,employee_no,employee_name,company_id,plate_id,department_id,record_date,other_deduction,is_sended";
	private final static String[] fieldNames = { "employee_id", "employee_no", "employee_name", "company_id", "department_id", "start_date", "end_date", "year", "month", "is_sended"};
}
