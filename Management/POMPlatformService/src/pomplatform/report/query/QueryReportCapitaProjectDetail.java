package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportCapitaProjectDetail;
import pomplatform.report.bean.ConditionReportCapitaProjectDetail;

public class QueryReportCapitaProjectDetail extends AbstractQuery<BaseReportCapitaProjectDetail, ConditionReportCapitaProjectDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryReportCapitaProjectDetail.class);

	public QueryReportCapitaProjectDetail() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aa.plate_id");
	}

	@Override
	public BaseCollection<BaseReportCapitaProjectDetail> executeQuery( KeyValuePair[] replacements, ConditionReportCapitaProjectDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getSheetCode(), 
				condition.getProjectName()
			);
	}

	@Override
	public BaseReportCapitaProjectDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportCapitaProjectDetail __base = new BaseReportCapitaProjectDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSheetCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSheetAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBeforeMoney(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select aa.plate_id,aa.project_id,aa.sheet_code,aa.project_name,aa.sheet_amount,aa.year ,(select sum(c.money) from capitals a LEFT JOIN capital_distributions b ON a.capital_id = b.capital_id LEFT JOIN capital_distribution_link_sub_contracts c  on a.capital_id = c.capital_id or b.capital_distribution_id = c.capital_distribution_id where c.sub_contract_id = aa.project_id and EXTRACT(YEAR from a.happen_date) < ?) as before_money,sum(one) as january_revenue,sum(two) as february_revenue,sum(three) as march_revenue,sum(four) as april_revenue,sum(five) as may_revenue,sum(six) as june_revenue,sum(seven) as july_revenue,sum(eight) as august_revenue,sum(nine) as september_revenue,sum(ten) as october_revenue,sum(eleven) as november_revenue,sum(twelf) as december_revenue from (select d.plate_id,d.project_id,d.contract_code as sheet_code,d.project_name,d.sheet_amount,EXTRACT(YEAR from a.happen_date) as year,CASE WHEN EXTRACT(MONTH from a.happen_date) = 1 then sum(c.money) ELSE 0 END as one,CASE WHEN EXTRACT(MONTH from a.happen_date) = 2 then sum(c.money) ELSE 0 END as two,CASE WHEN EXTRACT(MONTH from a.happen_date) = 3 then sum(c.money) ELSE 0 END as three,CASE WHEN EXTRACT(MONTH from a.happen_date) = 4 then sum(c.money) ELSE 0 END as four,CASE WHEN EXTRACT(MONTH from a.happen_date) = 5 then sum(c.money) ELSE 0 END as five,CASE WHEN EXTRACT(MONTH from a.happen_date) = 6 then sum(c.money) ELSE 0 END as six,CASE WHEN EXTRACT(MONTH from a.happen_date) = 7 then sum(c.money) ELSE 0 END as seven,CASE WHEN EXTRACT(MONTH from a.happen_date) = 8 then sum(c.money) ELSE 0 END as eight,CASE WHEN EXTRACT(MONTH from a.happen_date) = 9 then sum(c.money) ELSE 0 END as nine,CASE WHEN EXTRACT(MONTH from a.happen_date) = 10 then sum(c.money) ELSE 0 END as ten,CASE WHEN EXTRACT(MONTH from a.happen_date) = 11 then sum(c.money) ELSE 0 END as eleven,CASE WHEN EXTRACT(MONTH from a.happen_date) = 12 then sum(c.money) ELSE 0 END as twelf from capitals a LEFT JOIN capital_distributions b ON a.capital_id = b.capital_id LEFT JOIN capital_distribution_link_sub_contracts c on a.capital_id = c.capital_id or b.capital_distribution_id = c.capital_distribution_id LEFT JOIN projects d on c.sub_contract_id = d.project_id where d.plate_id > 0 GROUP BY d.plate_id,d.project_id,d.contract_code,d.project_name,d.sheet_amount,EXTRACT(YEAR from a.happen_date),EXTRACT(MONTH from a.happen_date) ORDER BY d.plate_id,d.project_id ) as aa where aa.plate_id = ? and aa.year = ? and aa.sheet_code like ? and aa.project_name like ? GROUP BY aa.plate_id,aa.project_id,aa.sheet_code,aa.project_name,aa.sheet_amount,aa.year" ;
	private final static String RESULTSETFIELDLIST = "plate_id,project_id,sheet_code,project_name,sheet_amount,year,before_money,january_revenue,february_revenue,march_revenue,april_revenue,may_revenue,june_revenue,july_revenue,august_revenue,september_revenue,october_revenue,november_revenue,december_revenue";
	private final static String[] fieldNames = { "year", "plate_id", "year", "sheet_code", "project_name"};
}
