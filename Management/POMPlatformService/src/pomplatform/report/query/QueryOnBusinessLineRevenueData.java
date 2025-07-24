package pomplatform.report.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseOnBusinessLineRevenueData;
import pomplatform.report.bean.ConditionOnBusinessLineRevenueData;

public class QueryOnBusinessLineRevenueData extends AbstractQuery<BaseOnBusinessLineRevenueData, ConditionOnBusinessLineRevenueData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnBusinessLineRevenueData.class);

	public QueryOnBusinessLineRevenueData() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pr.parent_id");
	}

	@Override
	public BaseCollection<BaseOnBusinessLineRevenueData> executeQuery( KeyValuePair[] replacements, ConditionOnBusinessLineRevenueData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseOnBusinessLineRevenueData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnBusinessLineRevenueData __base = new BaseOnBusinessLineRevenueData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCurrentRevenueOne(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentRevenueTwo(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentRevenueThree(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentRevenueFour(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentRevenueFive(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentRevenueSix(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentRevenueSeven(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentRevenueEight(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentRevenueNine(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentRevenueTen(GenericBase.__getDecimal(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
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

	private final static String __SQLText = "select bbb.* from (SELECT pr.parent_id,aaa.plate_id,pr.plate_name,CASE WHEN ps.plate_name IS NULL THEN pr.plate_name ELSE ps.plate_name END as parent_name ,SUM(aaa.current_revenue_one) as current_revenue_one,SUM(aaa.current_revenue_two) as current_revenue_two ,SUM(aaa.current_revenue_three) as current_revenue_three,SUM(aaa.current_revenue_four) as current_revenue_four ,SUM(aaa.current_revenue_five) as current_revenue_five,SUM(aaa.current_revenue_six) as current_revenue_six ,SUM(aaa.current_revenue_seven) as current_revenue_seven,SUM(aaa.current_revenue_eight) as current_revenue_eight ,SUM(aaa.current_revenue_nine) as current_revenue_nine,SUM(aaa.current_revenue_ten) as current_revenue_ten from (SELECT aa.plate_id,CASE WHEN aa.business_line = 1 THEN sum(current_revenue) ELSE 0 END as current_revenue_one ,CASE WHEN aa.business_line = 2 THEN SUM(current_revenue) ELSE 0 END as current_revenue_two ,CASE WHEN aa.business_line = 3 THEN SUM(current_revenue) ELSE 0 END as current_revenue_three ,CASE WHEN aa.business_line = 4 THEN SUM(current_revenue) ELSE 0 END as current_revenue_four ,CASE WHEN aa.business_line = 5 THEN SUM(current_revenue) ELSE 0 END as current_revenue_five ,CASE WHEN aa.business_line = 9 THEN SUM(current_revenue) ELSE 0 END as current_revenue_six ,CASE WHEN aa.business_line = 10 THEN SUM(current_revenue) ELSE 0 END as current_revenue_seven ,CASE WHEN aa.business_line = 8 THEN SUM(current_revenue) ELSE 0 END as current_revenue_eight ,CASE WHEN aa.business_line = 91 THEN SUM(current_revenue) ELSE 0 END as current_revenue_nine ,CASE WHEN aa.business_line = 99 THEN SUM(current_revenue) ELSE 0 END as current_revenue_ten from (SELECT b.revenue_plate_id as plate_id,a.project_id,a.current_revenue,a.year,a.month,b.contract_code,b.project_name,b.business_line ,to_date((cast(a.year as VARCHAR))||'-'||CAST(a.month as VARCHAR)||'-01','yyyy-MM-dd') as record_date from revenue_statistical_records a LEFT JOIN projects b on a.project_id = b.project_id) as aa WHERE aa.record_date BETWEEN ? AND ? and aa.plate_id > 0 and aa.business_line > 0 GROUP BY aa.plate_id,aa.business_line ORDER BY aa.plate_id,aa.business_line ) as aaa LEFT JOIN plate_records pr ON aaa.plate_id = pr.plate_id LEFT JOIN plate_records ps on pr.parent_id = ps.plate_id WHERE pr.plate_id = ? GROUP BY pr.parent_id,aaa.plate_id,pr.plate_name,ps.plate_name ) as bbb ORDER BY bbb.parent_name" ;
	private final static String RESULTSETFIELDLIST = "parent_id,plate_id,plate_name,parent_name,current_revenue_one,current_revenue_two,current_revenue_three,current_revenue_four,current_revenue_five,current_revenue_six,current_revenue_seven,current_revenue_eight,current_revenue_nine,current_revenue_ten";
	private final static String[] fieldNames = { "start_date", "end_date", "plate_id"};
}
