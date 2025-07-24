package pomplatform.report.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportNewContractTotal;
import pomplatform.report.bean.ConditionReportNewContractTotal;

public class QueryReportNewContractTotal extends AbstractQuery<BaseReportNewContractTotal, ConditionReportNewContractTotal>
{

	private static final Logger __logger = Logger.getLogger(QueryReportNewContractTotal.class);

	public QueryReportNewContractTotal() throws java.sql.SQLException
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aa.plate_id");
	}

	@Override
	public BaseCollection<BaseReportNewContractTotal> executeQuery( KeyValuePair[] replacements, ConditionReportNewContractTotal condition ) throws java.sql.SQLException {
		return executeQuery(replacements,
				condition.getPlateId(),
				condition.getYear()
		);
	}

	@Override
	public BaseReportNewContractTotal generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportNewContractTotal __base = new BaseReportNewContractTotal();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getDouble(val));
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

	private final static String __SQLText = "select aa.plate_id,aa.YEAR,aa.january_revenue,aa.february_revenue,aa.march_revenue,aa.april_revenue,aa.may_revenue,aa.june_revenue,aa.july_revenue,aa.august_revenue,aa.september_revenue,aa.october_revenue,aa.november_revenue,aa.december_revenue,aa.january_revenue+aa.february_revenue+aa.march_revenue+aa.april_revenue+aa.may_revenue+aa.june_revenue+aa.august_revenue+aa.september_revenue+aa.october_revenue+aa.november_revenue+aa.december_revenue as total from (SELECT abc.plate_id, abc.YEAR, SUM ( one ) AS january_revenue, SUM ( two ) AS february_revenue, SUM ( three ) AS march_revenue, SUM ( four ) AS april_revenue, SUM ( five ) AS may_revenue, SUM ( six ) AS june_revenue, SUM ( seven ) AS july_revenue, SUM ( eight ) AS august_revenue, SUM ( nine ) AS september_revenue, SUM ( ten ) AS october_revenue, SUM ( eleven ) AS november_revenue, SUM ( twelf ) AS december_revenue FROM ( SELECT A .plate_id, EXTRACT ( YEAR FROM b.contract_date ) AS YEAR, EXTRACT ( MONTH FROM b.contract_date ) AS MONTH, CASE WHEN EXTRACT ( MONTH FROM b.contract_date ) = 1 THEN SUM ( A.sheet_amount ) ELSE 0 END AS one, CASE WHEN EXTRACT ( MONTH FROM b.contract_date ) = 2 THEN SUM ( A.sheet_amount ) ELSE 0 END AS two, CASE WHEN EXTRACT ( MONTH FROM b.contract_date ) = 3 THEN SUM ( A.sheet_amount ) ELSE 0 END AS three, CASE WHEN EXTRACT ( MONTH FROM b.contract_date ) = 4 THEN SUM ( A.sheet_amount ) ELSE 0 END AS four, CASE WHEN EXTRACT ( MONTH FROM b.contract_date ) = 5 THEN SUM ( A.sheet_amount ) ELSE 0 END AS five, CASE WHEN EXTRACT ( MONTH FROM b.contract_date ) = 6 THEN SUM ( A.sheet_amount ) ELSE 0 END AS six, CASE WHEN EXTRACT ( MONTH FROM b.contract_date ) = 7 THEN SUM ( A.sheet_amount ) ELSE 0 END AS seven, CASE WHEN EXTRACT ( MONTH FROM b.contract_date ) = 8 THEN SUM ( A.sheet_amount ) ELSE 0 END AS eight, CASE WHEN EXTRACT ( MONTH FROM b.contract_date ) = 9 THEN SUM ( A.sheet_amount ) ELSE 0 END AS nine, CASE WHEN EXTRACT ( MONTH FROM b.contract_date ) = 10 THEN SUM ( A.sheet_amount ) ELSE 0 END AS ten, CASE WHEN EXTRACT ( MONTH FROM b.contract_date ) = 11 THEN SUM ( A.sheet_amount ) ELSE 0 END AS eleven, CASE WHEN EXTRACT ( MONTH FROM b.contract_date ) = 12 THEN SUM ( A.sheet_amount ) ELSE 0 END AS twelf FROM projects A LEFT JOIN contracts b ON A.contract_id = b.contract_id WHERE b.contract_date IS NOT NULL AND A.plate_id > 0 GROUP BY A.plate_id, EXTRACT ( YEAR FROM b.contract_date ), EXTRACT ( MONTH FROM b.contract_date )) AS abc WHERE abc.plate_id = ? and abc.YEAR = ? GROUP BY abc.plate_id, abc.YEAR) aa" ;
	private final static String RESULTSETFIELDLIST = "plate_id,year,january_revenue,february_revenue,march_revenue,april_revenue,may_revenue,june_revenue,july_revenue,august_revenue,september_revenue,october_revenue,november_revenue,december_revenue,total";
	private final static String[] fieldNames = { "plate_id", "year"};
}
