package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportCapitalTotal;
import pomplatform.report.bean.ConditionReportCapitalTotal;

public class QueryReportCapitalTotal extends AbstractQuery<BaseReportCapitalTotal, ConditionReportCapitalTotal>
{

	private static final Logger __logger = Logger.getLogger(QueryReportCapitalTotal.class);

	public QueryReportCapitalTotal() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aaa.plate_id");
	}

	@Override
	public BaseCollection<BaseReportCapitalTotal> executeQuery( KeyValuePair[] replacements, ConditionReportCapitalTotal condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getYear()
			);
	}

	@Override
	public BaseReportCapitalTotal generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportCapitalTotal __base = new BaseReportCapitalTotal();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateJanuaryRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlateFebruaryRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlateMarchRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlateAprilRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlateMayRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlateJuneRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlateJulyRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlateAugustRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlateSeptemberRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlateOctoberRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlateNovemberRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlateDecemberRevenue(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select aaa.plate_id,aaa.year,sum(dep_one) as plate_january_revenue,sum(dep_two) as plate_february_revenue,sum(dep_three) as plate_march_revenue,sum(dep_four) as plate_april_revenue,sum(dep_five) as plate_may_revenue,sum(dep_six) as plate_june_revenue,sum(dep_seven) as plate_july_revenue,sum(dep_eight) as plate_august_revenue,sum(dep_nine) as plate_september_revenue,sum(dep_ten) as plate_october_revenue,sum(dep_eleven) as plate_november_revenue,sum(dep_twelf) as plate_december_revenue,sum(one) as january_revenue,sum(two) as february_revenue,sum(three) as march_revenue,sum(four) as april_revenue,sum(five) as may_revenue,sum(six) as june_revenue,sum(seven) as july_revenue,sum(eight) as august_revenue,sum(nine) as september_revenue,sum(ten) as october_revenue,sum(eleven) as november_revenue,sum(twelf) as december_revenue from (SELECT aa.plate_id,EXTRACT(YEAR from aa.happen_date) as year,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 1 then sum(aa.dep_money) ELSE 0 END as dep_one,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 2 then sum(aa.dep_money) ELSE 0 END as dep_two,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 3 then sum(aa.dep_money) ELSE 0 END as dep_three,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 4 then sum(aa.dep_money) ELSE 0 END as dep_four,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 5 then sum(aa.dep_money) ELSE 0 END as dep_five,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 6 then sum(aa.dep_money) ELSE 0 END as dep_six,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 7 then sum(aa.dep_money) ELSE 0 END as dep_seven,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 8 then sum(aa.dep_money) ELSE 0 END as dep_eight,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 9 then sum(aa.dep_money) ELSE 0 END as dep_nine,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 10 then sum(aa.dep_money) ELSE 0 END as dep_ten,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 11 then sum(aa.dep_money) ELSE 0 END as dep_eleven,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 12 then sum(aa.dep_money) ELSE 0 END as dep_twelf,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 1 then sum(aa.money) ELSE 0 END as one,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 2 then sum(aa.money) ELSE 0 END as two,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 3 then sum(aa.money) ELSE 0 END as three,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 4 then sum(aa.money) ELSE 0 END as four,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 5 then sum(aa.money) ELSE 0 END as five,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 6 then sum(aa.money) ELSE 0 END as six,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 7 then sum(aa.money) ELSE 0 END as seven,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 8 then sum(aa.money) ELSE 0 END as eight,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 9 then sum(aa.money) ELSE 0 END as nine,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 10 then sum(aa.money) ELSE 0 END as ten,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 11 then sum(aa.money) ELSE 0 END as eleven,CASE WHEN EXTRACT(MONTH from aa.happen_date) = 12 then sum(aa.money) ELSE 0 END as twelf from (select d.plate_id,0.0 as dep_money,c.money,a.happen_date from capitals a LEFT JOIN capital_distributions b ON a.capital_id = b.capital_id LEFT JOIN capital_distribution_link_sub_contracts c  on a.capital_id = c.capital_id or b.capital_distribution_id = c.capital_distribution_id LEFT JOIN projects d on c.sub_contract_id = d.project_id where d.plate_id > 0 UNION ALL select d.plate_id,c.money as dep_money,0.0 as money,a.happen_date from capitals a LEFT JOIN capital_distributions b ON a.capital_id = b.capital_id LEFT JOIN capital_distribution_link_departments c  on a.capital_id = c.capital_id or b.capital_distribution_id = c.capital_distribution_id LEFT JOIN departments d on c.department_id = d.department_id where d.plate_id > 0) as aa GROUP BY aa.plate_id,EXTRACT(YEAR from aa.happen_date),EXTRACT(MONTH from aa.happen_date)) as aaa where aaa.plate_id = ? and aaa.year = ? GROUP BY aaa.plate_id,aaa.year" ;
	private final static String RESULTSETFIELDLIST = "plate_id,year,plate_january_revenue,plate_february_revenue,plate_march_revenue,plate_april_revenue,plate_may_revenue,plate_june_revenue,plate_july_revenue,plate_august_revenue,plate_september_revenue,plate_october_revenue,plate_november_revenue,plate_december_revenue,january_revenue,february_revenue,march_revenue,april_revenue,may_revenue,june_revenue,july_revenue,august_revenue,september_revenue,october_revenue,november_revenue,december_revenue";
	private final static String[] fieldNames = { "plate_id", "year"};
}
