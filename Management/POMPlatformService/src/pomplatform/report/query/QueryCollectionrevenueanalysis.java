package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseCollectionrevenueanalysis;
import pomplatform.report.bean.ConditionCollectionrevenueanalysis;

public class QueryCollectionrevenueanalysis extends AbstractQuery<BaseCollectionrevenueanalysis, ConditionCollectionrevenueanalysis>
{

	private static final Logger __logger = Logger.getLogger(QueryCollectionrevenueanalysis.class);

	public QueryCollectionrevenueanalysis() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A.*");
	}

	@Override
	public BaseCollection<BaseCollectionrevenueanalysis> executeQuery( KeyValuePair[] replacements, ConditionCollectionrevenueanalysis condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYearStr()
			);
	}

	@Override
	public BaseCollectionrevenueanalysis generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCollectionrevenueanalysis __base = new BaseCollectionrevenueanalysis();
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
		if((val = __data[count++]) != null) __base.setJanuaryAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFebruaryAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMarchAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAprilAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMayAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJuneAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJulyAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAugustAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSeptemberAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOctoberAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNovemberAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDecemberAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJanuaryLeft(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFebruaryLeft(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMarchLeft(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAprilLeft(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMayLeft(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJuneLeft(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJulyLeft(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAugustLeft(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSeptemberLeft(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOctoberLeft(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNovemberLeft(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDecemberLeft(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalLeft(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStr1(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStr2(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStr3(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStr4(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStr5(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStr6(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStr7(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStr8(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStr9(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStr10(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStr11(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStr12(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStr(GenericBase.__getString(val));
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

	private final static String __SQLText = "select A.*, B.january_amount, B.february_amount, B.march_amount, B.april_amount, B.may_amount, B.june_amount, B.july_amount, B.august_amount, B.september_amount, B.october_amount, B.november_amount, B.december_amount, B.total_amount, (CASE A.january_revenue WHEN 0 THEN 0 ELSE ((B.january_amount/A.january_revenue)*100) END ) as january_left, (CASE A.february_revenue WHEN 0 THEN 0 ELSE (( B.february_amount/A.february_revenue)*100) END) as february_left, (CASE A.march_revenue WHEN 0 THEN 0 ELSE ( (B.march_amount/ A.march_revenue)*100) END )as march_left, (CASE A.april_revenue WHEN 0 THEN 0 ELSE (( B.april_amount/A.april_revenue)*100) END ) as april_left, (CASE A.may_revenue WHEN 0 THEN 0 ELSE ( (B.may_amount /A.may_revenue)*100) END )as may_left , (CASE A.june_revenue WHEN 0 THEN 0 ELSE (( B.june_amount/A.june_revenue)*100) END )as june_left , (CASE A.july_revenue WHEN 0 THEN 0 ELSE ( (B.july_amount /A.july_revenue)*100) END )as july_left, (CASE A.august_revenue WHEN 0 THEN 0 ELSE ( (B.august_amount /A.august_revenue)*100) END )as august_left , (CASE A.september_revenue WHEN 0 THEN 0 ELSE (( B.september_amount/A.september_revenue)*100) END )as september_left , (CASE A.october_revenue WHEN 0 THEN 0 ELSE (( B.october_amount/A.october_revenue)*100) END) as october_left, (CASE A.november_revenue WHEN 0 THEN 0 ELSE ( (B.november_amount/A.november_revenue)*100) END) as november_left , (CASE A.december_revenue WHEN 0 THEN 0 ELSE (( B.december_amount/A.december_revenue)*100) END )as december_left, (CASE A.total WHEN 0 THEN 0 ELSE (( B.total_amount/A.total)*100) END )as total_left, '' as str1, '' as str2, '' as str3, '' as str4, '' as str5, '' as str6, '' as str7, '' as str8, '' as str9, '' as str10, '' as str11, '' as str12, '' as str from (SELECT P.revenue_plate_id AS plate_id, rysr.YEAR, SUM ( january_revenue ) AS january_revenue, SUM ( february_revenue ) AS february_revenue, SUM ( march_revenue ) AS march_revenue, SUM ( april_revenue ) AS april_revenue, SUM ( may_revenue ) AS may_revenue, SUM ( june_revenue ) AS june_revenue, SUM ( july_revenue ) AS july_revenue, SUM ( august_revenue ) AS august_revenue, SUM ( september_revenue ) AS september_revenue, SUM ( october_revenue ) AS october_revenue, SUM ( november_revenue ) AS november_revenue, SUM ( december_revenue ) AS december_revenue, ( SUM ( january_revenue ) + SUM ( february_revenue ) + SUM ( march_revenue ) + SUM ( april_revenue ) + SUM ( may_revenue ) + SUM ( june_revenue ) + SUM ( july_revenue ) + SUM ( august_revenue ) + SUM ( september_revenue ) + SUM ( october_revenue ) + SUM ( november_revenue ) + SUM ( december_revenue )) AS total FROM revenue_year_statistical_records rysr LEFT JOIN projects P ON rysr.project_id = P.project_id WHERE P.revenue_plate_id > 0 AND P.revenue_plate_id =? AND rysr.YEAR =? GROUP BY P.revenue_plate_id, rysr.YEAR ORDER BY P.revenue_plate_id) as A left join ( select AAA.plate_id, sum(CASE AAA.month WHEN '01' THEN AAA.distribution_amount ELSE 0 END ) AS january_amount, sum(CASE AAA.month WHEN '02' THEN AAA.distribution_amount ELSE 0 END ) AS february_amount, sum(CASE AAA.month WHEN '03' THEN AAA.distribution_amount ELSE 0 END ) AS march_amount, sum(CASE AAA.month WHEN '04' THEN AAA.distribution_amount ELSE 0 END ) AS april_amount, sum(CASE AAA.month WHEN '05' THEN AAA.distribution_amount ELSE 0 END ) AS may_amount, sum(CASE AAA.month WHEN '06' THEN AAA.distribution_amount ELSE 0 END ) AS june_amount, sum(CASE AAA.month WHEN '07' THEN AAA.distribution_amount ELSE 0 END ) AS july_amount, sum(CASE AAA.month WHEN '08' THEN AAA.distribution_amount ELSE 0 END ) AS august_amount, sum(CASE AAA.month WHEN '09' THEN AAA.distribution_amount ELSE 0 END ) AS september_amount, sum(CASE AAA.month WHEN '10' THEN AAA.distribution_amount ELSE 0 END ) AS october_amount, sum(CASE AAA.month WHEN '11' THEN AAA.distribution_amount ELSE 0 END ) AS november_amount, sum(CASE AAA.month WHEN '12' THEN AAA.distribution_amount ELSE 0 END ) AS december_amount, sum(AAA.distribution_amount) AS total_amount FROM (select sum(AA.distribution_amount) as distribution_amount, AA.plate_id, AA.year, AA.month from ( SELECT cd.capital_distribution_id, cd.TYPE, cd.contract_id, cd.capital_id, cd.project_id, cd.total_amount, cd.distribution_amount, cd.OPERATOR, cd.create_time, cd.locked, cd.delete_flag, cd.plate_id, to_char( cs.happen_date, 'yyyy' ) as year, to_char( cs.happen_date, 'mm' ) as month FROM capital_distributions cd LEFT JOIN capitals cs on cs.capital_id = cd.capital_id LEFT JOIN plate_records pr ON pr.plate_id = cd.plate_id WHERE cd.delete_flag = 0 AND cd.plate_id > 0 AND cd.plate_id =? ) as AA where AA.year=? GROUP BY AA.plate_id , AA.year, AA.month ORDER BY AA.plate_id , AA.year, AA.month ) AS AAA GROUP BY AAA.plate_id ) as B on A.plate_id =B.plate_id order by A.plate_id" ;
//	private final static String __SQLText = "select A.*, B.january_amount, B.february_amount, B.march_amount, B.april_amount, B.may_amount, B.june_amount, B.july_amount, B.august_amount, B.september_amount, B.october_amount, B.november_amount, B.december_amount, B.total_amount, (CASE A.january_revenue WHEN 0 THEN 0 ELSE ((B.january_amount/A.january_revenue)*100) END ) as january_left, (CASE A.february_revenue WHEN 0 THEN 0 ELSE (( B.february_amount/A.february_revenue)*100) END) as february_left, (CASE A.march_revenue WHEN 0 THEN 0 ELSE ( (B.march_amount/ A.march_revenue)*100) END )as march_left, (CASE A.april_revenue WHEN 0 THEN 0 ELSE (( B.april_amount/A.april_revenue)*100) END ) as april_left, (CASE A.may_revenue WHEN 0 THEN 0 ELSE ( (B.may_amount /A.may_revenue)*100) END )as may_left , (CASE A.june_revenue WHEN 0 THEN 0 ELSE (( B.june_amount/A.june_revenue)*100) END )as june_left , (CASE A.july_revenue WHEN 0 THEN 0 ELSE ( (B.july_amount /A.july_revenue)*100) END )as july_left, (CASE A.august_revenue WHEN 0 THEN 0 ELSE ( (B.august_amount /A.august_revenue)*100) END )as august_left , (CASE A.september_revenue WHEN 0 THEN 0 ELSE (( B.september_amount/A.september_revenue)*100) END )as september_left , (CASE A.october_revenue WHEN 0 THEN 0 ELSE (( B.october_amount/A.october_revenue)*100) END) as october_left, (CASE A.november_revenue WHEN 0 THEN 0 ELSE ( (B.november_amount/A.november_revenue)*100) END) as november_left , (CASE A.december_revenue WHEN 0 THEN 0 ELSE (( B.december_amount/A.december_revenue)*100) END )as december_left, (CASE A.total WHEN 0 THEN 0 ELSE (( B.total_amount/A.total)*100) END )as total_left, '' as str1, '' as str2, '' as str3, '' as str4, '' as str5, '' as str6, '' as str7, '' as str8, '' as str9, '' as str10, '' as str11, '' as str12, '' as str from (SELECT P.revenue_plate_id AS plate_id, rysr.YEAR, SUM ( january_revenue ) AS january_revenue, SUM ( february_revenue ) AS february_revenue, SUM ( march_revenue ) AS march_revenue, SUM ( april_revenue ) AS april_revenue, SUM ( may_revenue ) AS may_revenue, SUM ( june_revenue ) AS june_revenue, SUM ( july_revenue ) AS july_revenue, SUM ( august_revenue ) AS august_revenue, SUM ( september_revenue ) AS september_revenue, SUM ( october_revenue ) AS october_revenue, SUM ( november_revenue ) AS november_revenue, SUM ( december_revenue ) AS december_revenue, ( SUM ( january_revenue ) + SUM ( february_revenue ) + SUM ( march_revenue ) + SUM ( april_revenue ) + SUM ( may_revenue ) + SUM ( june_revenue ) + SUM ( july_revenue ) + SUM ( august_revenue ) + SUM ( september_revenue ) + SUM ( october_revenue ) + SUM ( november_revenue ) + SUM ( december_revenue )) AS total FROM revenue_year_statistical_records rysr LEFT JOIN projects P ON rysr.project_id = P.project_id WHERE P.revenue_plate_id > 0 AND P.revenue_plate_id =? AND rysr.YEAR =? GROUP BY P.revenue_plate_id, rysr.YEAR ORDER BY P.revenue_plate_id) as A left join ( select AAA.plate_id, sum(CASE AAA.month WHEN '01' THEN AAA.distribution_amount ELSE 0 END ) AS january_amount, sum(CASE AAA.month WHEN '02' THEN AAA.distribution_amount ELSE 0 END ) AS february_amount, sum(CASE AAA.month WHEN '03' THEN AAA.distribution_amount ELSE 0 END ) AS march_amount, sum(CASE AAA.month WHEN '04' THEN AAA.distribution_amount ELSE 0 END ) AS april_amount, sum(CASE AAA.month WHEN '05' THEN AAA.distribution_amount ELSE 0 END ) AS may_amount, sum(CASE AAA.month WHEN '06' THEN AAA.distribution_amount ELSE 0 END ) AS june_amount, sum(CASE AAA.month WHEN '07' THEN AAA.distribution_amount ELSE 0 END ) AS july_amount, sum(CASE AAA.month WHEN '08' THEN AAA.distribution_amount ELSE 0 END ) AS august_amount, sum(CASE AAA.month WHEN '09' THEN AAA.distribution_amount ELSE 0 END ) AS september_amount, sum(CASE AAA.month WHEN '10' THEN AAA.distribution_amount ELSE 0 END ) AS october_amount, sum(CASE AAA.month WHEN '11' THEN AAA.distribution_amount ELSE 0 END ) AS november_amount, sum(CASE AAA.month WHEN '12' THEN AAA.distribution_amount ELSE 0 END ) AS december_amount, sum(AAA.distribution_amount) AS total_amount FROM (select sum(AA.distribution_amount) as distribution_amount, AA.plate_id, AA.year, AA.month from ( SELECT cd.capital_distribution_id, cd.TYPE, cd.contract_id, cd.capital_id, cd.project_id, cd.total_amount, cd.distribution_amount, cd.OPERATOR, cd.create_time, cd.locked, cd.delete_flag, cd.plate_id, to_char( cs.happen_date, 'yyyy' ) as year, to_char( cs.happen_date, 'mm' ) as month FROM capital_distributions cd LEFT JOIN capitals cs on cs.capital_id = cd.capital_id LEFT JOIN plate_records pr ON pr.plate_id = cd.plate_id WHERE cd.delete_flag = 0 AND cd.plate_id > 0 AND cs.process_status = 2 AND cs.capital_type =1 AND cd.plate_id =? ) as AA where AA.year=? GROUP BY AA.plate_id , AA.year, AA.month ORDER BY AA.plate_id , AA.year, AA.month ) AS AAA GROUP BY AAA.plate_id ) as B on A.plate_id =B.plate_id order by A.plate_id" ;
	private final static String RESULTSETFIELDLIST = "plate_id,year,january_revenue,february_revenue,march_revenue,april_revenue,may_revenue,june_revenue,july_revenue,august_revenue,september_revenue,october_revenue,november_revenue,december_revenue,total,january_amount,february_amount,march_amount,april_amount,may_amount,june_amount,july_amount,august_amount,september_amount,october_amount,november_amount,december_amount,total_amount,january_left,february_left,march_left,april_left,may_left,june_left,july_left,august_left,september_left,october_left,november_left,december_left,total_left,str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,str12,str";
	private final static String[] fieldNames = { "plate_id", "year", "plate_id", "year_str"};
}
