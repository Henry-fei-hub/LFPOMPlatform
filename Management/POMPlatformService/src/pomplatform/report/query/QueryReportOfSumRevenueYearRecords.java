package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportOfSumRevenueYearRecords;
import pomplatform.report.bean.ConditionReportOfSumRevenueYearRecords;

public class QueryReportOfSumRevenueYearRecords extends AbstractQuery<BaseReportOfSumRevenueYearRecords, ConditionReportOfSumRevenueYearRecords>
{

	private static final Logger __logger = Logger.getLogger(QueryReportOfSumRevenueYearRecords.class);

	public QueryReportOfSumRevenueYearRecords() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("p.plate_id");
	}

	@Override
	public BaseCollection<BaseReportOfSumRevenueYearRecords> executeQuery( KeyValuePair[] replacements, ConditionReportOfSumRevenueYearRecords condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getYear()
			);
	}

	@Override
	public BaseReportOfSumRevenueYearRecords generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportOfSumRevenueYearRecords __base = new BaseReportOfSumRevenueYearRecords();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
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
		if((val = __data[count++]) != null) __base.setTotal(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT p.revenue_plate_id as plate_id,rysr.year, sum(january_revenue) as january_revenue,sum(february_revenue) as february_revenue,sum(march_revenue) as march_revenue, sum(april_revenue) as april_revenue,sum(may_revenue) as may_revenue,sum(june_revenue) as june_revenue,sum(july_revenue) as july_revenue ,sum(august_revenue) as august_revenue,sum(september_revenue) as september_revenue,sum(october_revenue) as october_revenue, sum(november_revenue) as november_revenue,sum(december_revenue) as december_revenue, (sum(january_revenue)+sum(february_revenue)+sum(march_revenue)+sum(april_revenue)+sum(may_revenue)+sum(june_revenue)+sum(july_revenue)+sum(august_revenue)+sum(september_revenue)+sum(october_revenue)+sum(november_revenue)+sum(december_revenue)) as total FROM revenue_year_statistical_records rysr LEFT JOIN projects p ON rysr.project_id = p.project_id WHERE p.revenue_plate_id > 0 and p.revenue_plate_id = ? AND rysr.year = ? GROUP BY p.revenue_plate_id,rysr.year ORDER BY p.revenue_plate_id" ;
	private final static String RESULTSETFIELDLIST = "plate_id,year,january_revenue,february_revenue,march_revenue,april_revenue,may_revenue,june_revenue,july_revenue,august_revenue,september_revenue,october_revenue,november_revenue,december_revenue,total";
	private final static String[] fieldNames = { "plate_id", "year"};
}
