package pomplatform.account.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseOnloadPlateSalaryAdvanceInfo;
import pomplatform.account.bean.ConditionOnloadPlateSalaryAdvanceInfo;

public class QueryOnloadPlateSalaryAdvanceInfo extends AbstractQuery<BaseOnloadPlateSalaryAdvanceInfo, ConditionOnloadPlateSalaryAdvanceInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryOnloadPlateSalaryAdvanceInfo.class);

	public QueryOnloadPlateSalaryAdvanceInfo() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.plate_id");
	}

	@Override
	public BaseCollection<BaseOnloadPlateSalaryAdvanceInfo> executeQuery( KeyValuePair[] replacements, ConditionOnloadPlateSalaryAdvanceInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId()
			);
	}

	@Override
	public BaseOnloadPlateSalaryAdvanceInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnloadPlateSalaryAdvanceInfo __base = new BaseOnloadPlateSalaryAdvanceInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBusinessTypeId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select a.plate_id,a.employee_id,b.employee_no,sum(a.integral) as integral,a.business_type_id from employee_account_records a left join employees b on a.employee_id = b.employee_id where a.plate_id = ? GROUP BY a.plate_id,a.employee_id,b.employee_no,a.business_type_id ORDER BY a.employee_id,a.business_type_id" ;
	private final static String RESULTSETFIELDLIST = "plate_id,employee_id,employee_no,integral,business_type_id";
	private final static String[] fieldNames = { "plate_id"};
}
