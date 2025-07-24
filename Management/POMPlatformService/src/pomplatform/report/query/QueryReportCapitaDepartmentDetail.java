package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportCapitaDepartmentDetail;
import pomplatform.report.bean.ConditionReportCapitaDepartmentDetail;

public class QueryReportCapitaDepartmentDetail extends AbstractQuery<BaseReportCapitaDepartmentDetail, ConditionReportCapitaDepartmentDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryReportCapitaDepartmentDetail.class);

	public QueryReportCapitaDepartmentDetail() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aa.plate_id");
	}

	@Override
	public BaseCollection<BaseReportCapitaDepartmentDetail> executeQuery( KeyValuePair[] replacements, ConditionReportCapitaDepartmentDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseReportCapitaDepartmentDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportCapitaDepartmentDetail __base = new BaseReportCapitaDepartmentDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select aa.plate_id,aa.department_id,aa.year,sum(one) as january_revenue,sum(two) as february_revenue,sum(three) as march_revenue,sum(four) as april_revenue,sum(five) as may_revenue,sum(six) as june_revenue,sum(seven) as july_revenue,sum(eight) as august_revenue,sum(nine) as september_revenue,sum(ten) as october_revenue,sum(eleven) as november_revenue,sum(twelf) as december_revenue from (select d.plate_id,d.department_id,EXTRACT(YEAR from a.happen_date) as year,CASE WHEN EXTRACT(MONTH from a.happen_date) = 1 then sum(c.money) ELSE 0 END as one,CASE WHEN EXTRACT(MONTH from a.happen_date) = 2 then sum(c.money) ELSE 0 END as two,CASE WHEN EXTRACT(MONTH from a.happen_date) = 3 then sum(c.money) ELSE 0 END as three,CASE WHEN EXTRACT(MONTH from a.happen_date) = 4 then sum(c.money) ELSE 0 END as four,CASE WHEN EXTRACT(MONTH from a.happen_date) = 5 then sum(c.money) ELSE 0 END as five,CASE WHEN EXTRACT(MONTH from a.happen_date) = 6 then sum(c.money) ELSE 0 END as six,CASE WHEN EXTRACT(MONTH from a.happen_date) = 7 then sum(c.money) ELSE 0 END as seven,CASE WHEN EXTRACT(MONTH from a.happen_date) = 8 then sum(c.money) ELSE 0 END as eight,CASE WHEN EXTRACT(MONTH from a.happen_date) = 9 then sum(c.money) ELSE 0 END as nine,CASE WHEN EXTRACT(MONTH from a.happen_date) = 10 then sum(c.money) ELSE 0 END as ten,CASE WHEN EXTRACT(MONTH from a.happen_date) = 11 then sum(c.money) ELSE 0 END as eleven,CASE WHEN EXTRACT(MONTH from a.happen_date) = 12 then sum(c.money) ELSE 0 END as twelf from capitals a LEFT JOIN capital_distributions b ON a.capital_id = b.capital_id LEFT JOIN capital_distribution_link_departments c on a.capital_id = c.capital_id or b.capital_distribution_id = c.capital_distribution_id LEFT JOIN departments d on c.department_id = d.department_id where d.plate_id > 0 GROUP BY d.plate_id,d.department_id,EXTRACT(YEAR from a.happen_date),EXTRACT(MONTH from a.happen_date)) as aa where aa.plate_id = ? and aa.year = ? and aa.department_id = ? GROUP BY aa.plate_id,aa.department_id,aa.year" ;
	private final static String RESULTSETFIELDLIST = "plate_id,department_id,year,january_revenue,february_revenue,march_revenue,april_revenue,may_revenue,june_revenue,july_revenue,august_revenue,september_revenue,october_revenue,november_revenue,december_revenue";
	private final static String[] fieldNames = { "plate_id", "year", "department_id"};
}
