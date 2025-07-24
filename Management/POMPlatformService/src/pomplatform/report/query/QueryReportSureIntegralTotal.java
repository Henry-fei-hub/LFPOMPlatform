package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportSureIntegralTotal;
import pomplatform.report.bean.ConditionReportSureIntegralTotal;

public class QueryReportSureIntegralTotal extends AbstractQuery<BaseReportSureIntegralTotal, ConditionReportSureIntegralTotal>
{

	private static final Logger __logger = Logger.getLogger(QueryReportSureIntegralTotal.class);

	public QueryReportSureIntegralTotal() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aaa.*");
	}

	@Override
	public BaseCollection<BaseReportSureIntegralTotal> executeQuery( KeyValuePair[] replacements, ConditionReportSureIntegralTotal condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getYear()
			);
	}

	@Override
	public BaseReportSureIntegralTotal generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportSureIntegralTotal __base = new BaseReportSureIntegralTotal();
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

	private final static String __SQLText = " select aaa.*,bbb.plate_january_revenue,bbb.plate_february_revenue,bbb.plate_march_revenue,bbb.plate_april_revenue,bbb.plate_may_revenue,bbb.plate_june_revenue,bbb.plate_july_revenue,bbb.plate_august_revenue,bbb.plate_september_revenue,bbb.plate_october_revenue,bbb.plate_november_revenue,bbb.plate_december_revenue from (select aa.plate_id,aa.year,sum(one) as january_revenue,sum(two) as february_revenue ,sum(three) as march_revenue,sum(four) as april_revenue,sum(five) as may_revenue,sum(six) as june_revenue ,sum(seven) as july_revenue,sum(eight) as august_revenue ,sum(nine) as september_revenue,sum(ten) as october_revenue,sum(eleven) as november_revenue ,sum(twelf) as december_revenue from (select b.plate_id,EXTRACT(YEAR from a.settlement_date) as year,CASE WHEN EXTRACT(MONTH from a.settlement_date) = 1 then sum(a.total_amount) ELSE 0 END as one,CASE WHEN EXTRACT(MONTH from a.settlement_date) = 2 then sum(a.total_amount) ELSE 0 END as two,CASE WHEN EXTRACT(MONTH from a.settlement_date) = 3 then sum(a.total_amount) ELSE 0 END as three,CASE WHEN EXTRACT(MONTH from a.settlement_date) = 4 then sum(a.total_amount) ELSE 0 END as four,CASE WHEN EXTRACT(MONTH from a.settlement_date) = 5 then sum(a.total_amount) ELSE 0 END as five,CASE WHEN EXTRACT(MONTH from a.settlement_date) = 6 then sum(a.total_amount) ELSE 0 END as six,CASE WHEN EXTRACT(MONTH from a.settlement_date) = 7 then sum(a.total_amount) ELSE 0 END as seven,CASE WHEN EXTRACT(MONTH from a.settlement_date) = 8 then sum(a.total_amount) ELSE 0 END as eight,CASE WHEN EXTRACT(MONTH from a.settlement_date) = 9 then sum(a.total_amount) ELSE 0 END as nine,CASE WHEN EXTRACT(MONTH from a.settlement_date) = 10 then sum(a.total_amount) ELSE 0 END as ten,CASE WHEN EXTRACT(MONTH from a.settlement_date) = 11 then sum(a.total_amount) ELSE 0 END as eleven,CASE WHEN EXTRACT(MONTH from a.settlement_date) = 12 then sum(a.total_amount) ELSE 0 END as twelf from project_settlements a LEFT JOIN projects b on a.project_id = b.project_id WHERE a.settlement_status = 2 GROUP BY b.plate_id,EXTRACT(YEAR from a.settlement_date),EXTRACT(MONTH from a.settlement_date) ) as aa GROUP BY aa.plate_id,aa.year ORDER BY aa.plate_id,aa.year )as aaa LEFT JOIN (select bb.plate_id,bb.year,sum(one) as plate_january_revenue,sum(two) as plate_february_revenue ,sum(three) as plate_march_revenue,sum(four) as plate_april_revenue,sum(five) as plate_may_revenue,sum(six) as plate_june_revenue ,sum(seven) as plate_july_revenue,sum(eight) as plate_august_revenue ,sum(nine) as plate_september_revenue,sum(ten) as plate_october_revenue,sum(eleven) as plate_november_revenue ,sum(twelf) as plate_december_revenue from (select plate_id,EXTRACT(YEAR from account_date) as year,CASE WHEN EXTRACT(MONTH from account_date) = 1 then sum(account_integral) ELSE 0 END as one,CASE WHEN EXTRACT(MONTH from account_date) = 2 then sum(account_integral) ELSE 0 END as two,CASE WHEN EXTRACT(MONTH from account_date) = 3 then sum(account_integral) ELSE 0 END as three,CASE WHEN EXTRACT(MONTH from account_date) = 4 then sum(account_integral) ELSE 0 END as four,CASE WHEN EXTRACT(MONTH from account_date) = 5 then sum(account_integral) ELSE 0 END as five,CASE WHEN EXTRACT(MONTH from account_date) = 6 then sum(account_integral) ELSE 0 END as six,CASE WHEN EXTRACT(MONTH from account_date) = 7 then sum(account_integral) ELSE 0 END as seven,CASE WHEN EXTRACT(MONTH from account_date) = 8 then sum(account_integral) ELSE 0 END as eight,CASE WHEN EXTRACT(MONTH from account_date) = 9 then sum(account_integral) ELSE 0 END as nine,CASE WHEN EXTRACT(MONTH from account_date) = 10 then sum(account_integral) ELSE 0 END as ten,CASE WHEN EXTRACT(MONTH from account_date) = 11 then sum(account_integral) ELSE 0 END as eleven,CASE WHEN EXTRACT(MONTH from account_date) = 12 then sum(account_integral) ELSE 0 END as twelf from plate_project_account_records GROUP BY plate_id,EXTRACT(YEAR from account_date),EXTRACT(MONTH from account_date) ) as bb GROUP BY bb.plate_id,bb.year ) as bbb on aaa.plate_id=bbb.plate_id and aaa.year = bbb.year WHERE aaa.plate_id = ? and aaa.year = ?" ;
	private final static String RESULTSETFIELDLIST = "plate_id,year,january_revenue,february_revenue,march_revenue,april_revenue,may_revenue,june_revenue,july_revenue,august_revenue,september_revenue,october_revenue,november_revenue,december_revenue,plate_january_revenue,plate_february_revenue,plate_march_revenue,plate_april_revenue,plate_may_revenue,plate_june_revenue,plate_july_revenue,plate_august_revenue,plate_september_revenue,plate_october_revenue,plate_november_revenue,plate_december_revenue";
	private final static String[] fieldNames = { "plate_id", "year"};
}
