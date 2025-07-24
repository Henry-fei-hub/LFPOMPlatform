package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportOfSumRevenueYearRecordDetail;
import pomplatform.report.bean.ConditionReportOfSumRevenueYearRecordDetail;

public class QueryReportOfSumRevenueYearRecordDetail extends AbstractQuery<BaseReportOfSumRevenueYearRecordDetail, ConditionReportOfSumRevenueYearRecordDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryReportOfSumRevenueYearRecordDetail.class);

	public QueryReportOfSumRevenueYearRecordDetail() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("p.revenue_plate_id");
	}

	@Override
	public BaseCollection<BaseReportOfSumRevenueYearRecordDetail> executeQuery( KeyValuePair[] replacements, ConditionReportOfSumRevenueYearRecordDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getContractCode(), 
				condition.getProjectName()
			);
	}

	@Override
	public BaseReportOfSumRevenueYearRecordDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportOfSumRevenueYearRecordDetail __base = new BaseReportOfSumRevenueYearRecordDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setRevenuePlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSheetAmount(GenericBase.__getDecimal(val));
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
		if((val = __data[count++]) != null) __base.setBeforeRevenue(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT p.revenue_plate_id,rysr.year,p.project_id,p.contract_code,p.project_name,p.sheet_amount, january_revenue,february_revenue,march_revenue,april_revenue,may_revenue, june_revenue,july_revenue,august_revenue,september_revenue,october_revenue,november_revenue,december_revenue, a.before_revenue,(january_revenue+february_revenue+march_revenue+april_revenue+may_revenue+ june_revenue+july_revenue+august_revenue+september_revenue+october_revenue+november_revenue+december_revenue) as total FROM revenue_year_statistical_records rysr LEFT JOIN projects p ON rysr.project_id = p.project_id LEFT JOIN (SELECT project_id,(sum(january_revenue)+sum(february_revenue)+sum(march_revenue)+sum(april_revenue)+sum(may_revenue)+sum(june_revenue)+ sum(july_revenue)+sum(august_revenue)+sum(september_revenue)+sum(october_revenue)+sum(november_revenue)+sum(december_revenue)) as before_revenue FROM revenue_year_statistical_records WHERE year < ? GROUP BY project_id) as a ON a.project_id = rysr.project_id WHERE rysr.year = ? AND p.revenue_plate_id = ? AND p.contract_code like ? AND p.project_name like ?" ;
	private final static String RESULTSETFIELDLIST = "revenue_plate_id,year,project_id,contract_code,project_name,sheet_amount,january_revenue,february_revenue,march_revenue,april_revenue,may_revenue,june_revenue,july_revenue,august_revenue,september_revenue,october_revenue,november_revenue,december_revenue,before_revenue,total";
	private final static String[] fieldNames = { "year", "year", "plate_id", "contract_code", "project_name"};
}
