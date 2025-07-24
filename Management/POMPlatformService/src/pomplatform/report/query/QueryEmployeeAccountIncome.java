package pomplatform.report.query;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseEmployeeAccountIncome;
import pomplatform.report.bean.ConditionEmployeeAccountIncome;

public class QueryEmployeeAccountIncome extends AbstractQuery<BaseEmployeeAccountIncome, ConditionEmployeeAccountIncome>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeAccountIncome.class);

	public QueryEmployeeAccountIncome() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("EXTRACT ( YEAR FROM record_date ) as year");
	}

	@Override
	public BaseCollection<BaseEmployeeAccountIncome> executeQuery(KeyValuePair[] replacements, ConditionEmployeeAccountIncome condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseEmployeeAccountIncome generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeAccountIncome __base = new BaseEmployeeAccountIncome();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getDouble(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getDouble(val));
		if((val = __data[count++]) != null) __base.setBusinessTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, Object ... args) throws java.sql.SQLException {

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

	private final static String __SQLText = "SELECT EXTRACT ( YEAR FROM record_date ) as year, EXTRACT ( MONTH FROM record_date ) as month, ear.business_type_id, SUM ( integral ) AS integral FROM employee_account_records ear LEFT JOIN project_settlement_details ps on ps.settlement_detail_id = ear.business_id LEFT JOIN projects p on p.project_id = ps.project_id WHERE ear.employee_id IN ( SELECT DISTINCT ( employee_id ) FROM employee_day_plate_records ed LEFT JOIN plate_records pr ON pr.plate_id = ed.plate_id WHERE pr.plate_id =? AND ed.YEAR =? AND ed.MONTH =? ) AND EXTRACT ( YEAR FROM record_date ) =? AND EXTRACT ( MONTH FROM record_date ) =? AND ear.business_type_id = 1 and project_flag in (1,4) GROUP BY EXTRACT ( YEAR FROM ear.record_date ), EXTRACT ( MONTH FROM ear.record_date ), ear.business_type_id" ;
	private final static String RESULTSETFIELDLIST = "year,month,business_type_id,integral";
	private final static String[] fieldNames = { "plate_id", "year", "month", "year", "month"};
}
