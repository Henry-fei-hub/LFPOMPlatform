package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseOnBusinessLineRevenueDetailData;
import pomplatform.report.bean.ConditionOnBusinessLineRevenueDetailData;

public class QueryOnBusinessLineRevenueDetailData extends AbstractQuery<BaseOnBusinessLineRevenueDetailData, ConditionOnBusinessLineRevenueDetailData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnBusinessLineRevenueDetailData.class);

	public QueryOnBusinessLineRevenueDetailData() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.project_id");
	}

	@Override
	public BaseCollection<BaseOnBusinessLineRevenueDetailData> executeQuery( KeyValuePair[] replacements, ConditionOnBusinessLineRevenueDetailData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getBusinessLine(), 
				condition.getSheetCode(), 
				condition.getProjectName()
			);
	}

	@Override
	public BaseOnBusinessLineRevenueDetailData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnBusinessLineRevenueDetailData __base = new BaseOnBusinessLineRevenueDetailData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSheetCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessLine(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSheetAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setJanuaryRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFebruaryRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMarchRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAprilRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMayRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJuneRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJulyRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAugustRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSeptemberRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOctoberRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNovemberRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDecemberRevenue(GenericBase.__getDecimal(val));
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
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
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

	private final static String __SQLText = "select a.project_id,a.revenue_plate_id as plate_id,a.contract_code as sheet_code ,a.project_name,a.business_line,a.sheet_amount,b.year ,b.january_revenue,b.february_revenue,b.march_revenue,b.april_revenue,b.may_revenue,b.june_revenue ,b.july_revenue,b.august_revenue,b.september_revenue,b.october_revenue,b.november_revenue,b.december_revenue from projects a LEFT JOIN revenue_year_statistical_records b ON a.project_id = b.project_id where a.project_flag in(1,4) AND b.year = ? AND a.revenue_plate_id = ? AND a.business_line = ? AND a.contract_code like ? AND a.project_name like ? ORDER BY a.revenue_plate_id,a.project_id" ;
	private final static String RESULTSETFIELDLIST = "project_id,plate_id,sheet_code,project_name,business_line,sheet_amount,year,january_revenue,february_revenue,march_revenue,april_revenue,may_revenue,june_revenue,july_revenue,august_revenue,september_revenue,october_revenue,november_revenue,december_revenue";
	private final static String[] fieldNames = { "year", "plate_id", "business_line", "sheet_code", "project_name"};
}
