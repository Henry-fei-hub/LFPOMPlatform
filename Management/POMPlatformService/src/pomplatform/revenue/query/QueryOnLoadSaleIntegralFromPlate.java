package pomplatform.revenue.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.revenue.bean.BaseOnLoadSaleIntegralFromPlate;
import pomplatform.revenue.bean.ConditionOnLoadSaleIntegralFromPlate;

public class QueryOnLoadSaleIntegralFromPlate extends AbstractQuery<BaseOnLoadSaleIntegralFromPlate, ConditionOnLoadSaleIntegralFromPlate>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadSaleIntegralFromPlate.class);

	public QueryOnLoadSaleIntegralFromPlate() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aa.business_name");
	}

	@Override
	public BaseCollection<BaseOnLoadSaleIntegralFromPlate> executeQuery( KeyValuePair[] replacements, ConditionOnLoadSaleIntegralFromPlate condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseOnLoadSaleIntegralFromPlate generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadSaleIntegralFromPlate __base = new BaseOnLoadSaleIntegralFromPlate();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCurrentRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSaleIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT aa.business_name, aa.YEAR, aa.MONTH, aa.current_revenue, aa.percent, round( aa.current_revenue * aa.percent, 2 ) AS sale_integral FROM ( SELECT '商业' AS business_name, A.YEAR, A.MONTH, SUM ( A.current_revenue ) AS current_revenue, 0.041 AS percent FROM revenue_statistical_records A LEFT JOIN projects b ON A.project_id = b.project_id WHERE b.business_type = 1 AND b.revenue_plate_id NOT IN ( 5, 7, 11,65,66,17) AND b.project_type NOT IN ( 8, 9 ) GROUP BY A.YEAR, A.MONTH UNION SELECT '酒店' AS business_name, A.YEAR, A.MONTH, SUM ( A.current_revenue ) AS current_revenue, 0.041 AS percent FROM revenue_statistical_records A LEFT JOIN projects b ON A.project_id = b.project_id WHERE b.business_type IN ( 2, 8 ) AND b.revenue_plate_id NOT IN ( 5, 7, 11,65,66,17) AND b.project_type NOT IN ( 8, 9 ) GROUP BY A.YEAR, A.MONTH UNION SELECT '办公' AS business_name, A.YEAR, A.MONTH, SUM ( A.current_revenue ) AS current_revenue, 0.041 AS percent FROM revenue_statistical_records A LEFT JOIN projects b ON A.project_id = b.project_id WHERE b.business_type IN ( 3, 6 ) AND b.revenue_plate_id NOT IN ( 5, 7, 11,65,66,17) AND b.project_type NOT IN ( 8, 9 ) GROUP BY A.YEAR, A.MONTH UNION SELECT '轨交' AS business_name, A.YEAR, A.MONTH, SUM ( A.current_revenue ) AS current_revenue, 0.041 AS percent FROM revenue_statistical_records A LEFT JOIN projects b ON A.project_id = b.project_id WHERE b.business_type IN (4) AND b.revenue_plate_id NOT IN ( 5, 7, 11,65,66,17) AND b.project_type NOT IN ( 8, 9 ) GROUP BY A.YEAR, A.MONTH UNION SELECT CASE WHEN b.revenue_plate_id = 7 THEN '平面' ELSE'杰拓' END AS business_name, A.YEAR, A.MONTH, SUM ( A.current_revenue ) AS current_revenue, 0.041 AS percent FROM revenue_statistical_records A LEFT JOIN projects b ON A.project_id = b.project_id WHERE b.revenue_plate_id IN ( 7, 11) GROUP BY b.revenue_plate_id, A.YEAR, A.MONTH UNION SELECT '机电' AS business_name, A.YEAR, A.MONTH, SUM ( A.current_revenue ) AS current_revenue, 0.041 AS percent FROM revenue_statistical_records A LEFT JOIN projects b ON A.project_id = b.project_id WHERE b.revenue_plate_id IN ( 5,65,66) GROUP BY A.YEAR, A.MONTH UNION SELECT '软装' AS business_name, A.YEAR, A.MONTH, SUM ( A.current_revenue ) AS current_revenue, 0.041 AS percent FROM revenue_statistical_records A LEFT JOIN projects b ON A.project_id = b.project_id WHERE b.project_type IN ( 8, 9 ) AND b.revenue_plate_id not in(11,17) GROUP BY A.YEAR, A.MONTH UNION SELECT '医养' AS business_name, A.YEAR, A.MONTH, SUM ( A.current_revenue ) AS current_revenue, 0.041 AS percent FROM revenue_statistical_records A LEFT JOIN projects b ON A.project_id = b.project_id WHERE b.business_type = 5 AND b.revenue_plate_id NOT IN ( 5, 7, 11,65,66,17) AND b.project_type NOT IN ( 8, 9 ) GROUP BY A.YEAR, A.MONTH ) AS aa WHERE aa.YEAR = ? AND aa.MONTH = ? ORDER BY aa.business_name" ;
	private final static String RESULTSETFIELDLIST = "business_name,year,month,current_revenue,percent,sale_integral";
	private final static String[] fieldNames = { "year", "month"};
}
