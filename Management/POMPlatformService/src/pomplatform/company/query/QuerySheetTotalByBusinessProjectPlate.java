package pomplatform.company.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.company.bean.BaseSheetTotalByBusinessProjectPlate;
import pomplatform.company.bean.ConditionSheetTotalByBusinessProjectPlate;

public class QuerySheetTotalByBusinessProjectPlate extends AbstractQuery<BaseSheetTotalByBusinessProjectPlate, ConditionSheetTotalByBusinessProjectPlate>
{

	private static final Logger __logger = Logger.getLogger(QuerySheetTotalByBusinessProjectPlate.class);

	public QuerySheetTotalByBusinessProjectPlate() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("business_type");
	}

	@Override
	public BaseCollection<BaseSheetTotalByBusinessProjectPlate> executeQuery( KeyValuePair[] replacements, ConditionSheetTotalByBusinessProjectPlate condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getBusinessType(), 
				condition.getProjectType(), 
				condition.getDepartmentId(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseSheetTotalByBusinessProjectPlate generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSheetTotalByBusinessProjectPlate __base = new BaseSheetTotalByBusinessProjectPlate();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSheetTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setComplaintIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSheetIntegral(GenericBase.__getDecimal(val));
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
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
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

	private final static String __SQLText = "SELECT business_type,project_type,department_id,sum(sheet_total_integral) as sheet_total_integral,sum(complaint_integral) as complaint_integral,sum(sheet_integral) as sheet_integral FROM sub_contracts where business_type = ? and project_type = ? and department_id = ? and agree_date >= ? and agree_date < ? group by business_type,project_type,department_id ORDER BY sheet_total_integral desc" ;
	private final static String RESULTSETFIELDLIST = "business_type,project_type,department_id,sheet_total_integral,complaint_integral,sheet_integral";
	private final static String[] fieldNames = { "business_type", "project_type", "department_id", "start_date", "end_date"};
}
