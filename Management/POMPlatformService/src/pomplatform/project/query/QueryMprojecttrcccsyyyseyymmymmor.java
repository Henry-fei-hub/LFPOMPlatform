package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseMprojecttrcccsyyyseyymmymmor;
import pomplatform.project.bean.ConditionMprojecttrcccsyyyseyymmymmor;

public class QueryMprojecttrcccsyyyseyymmymmor extends AbstractQuery<BaseMprojecttrcccsyyyseyymmymmor, ConditionMprojecttrcccsyyyseyymmymmor>
{

	private static final Logger __logger = Logger.getLogger(QueryMprojecttrcccsyyyseyymmymmor.class);

	public QueryMprojecttrcccsyyyseyymmymmor() throws java.sql.SQLException 
	{
		setParameterNumber(12);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A.business_line");
	}

	@Override
	public BaseCollection<BaseMprojecttrcccsyyyseyymmymmor> executeQuery( KeyValuePair[] replacements, ConditionMprojecttrcccsyyyseyymmymmor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getStartMonth(), 
				condition.getEndMonth(), 
				condition.getYear(), 
				condition.getYearStr(), 
				condition.getMonthStartStr(), 
				condition.getMonthEndStr(), 
				condition.getYearStr(), 
				condition.getMonthStartStr(), 
				condition.getMonthEndStr()
			);
	}

	@Override
	public BaseMprojecttrcccsyyyseyymmymmor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMprojecttrcccsyyyseyymmymmor __base = new BaseMprojecttrcccsyyyseyymmymmor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setBusinessLine(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSumSheetAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSumCurrentRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSumCurrentRevenueProportion(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTargetType1(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTargetStrType1(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTargetType1Proportion(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRank1(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPercentageComplete1(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSumDistributionAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTargetType2(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTargetStrType2(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRank2(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPercentageComplete2(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBack1(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBack2(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBack3(GenericBase.__getString(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setString(count++, GenericBase.__getString(args[11]));
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

	private final static String __SQLText = "select A.business_line, CASE WHEN C.sum_sheet_amount  ISNULL THEN 0 ELSE C.sum_sheet_amount END, CASE WHEN A.sum_current_revenue  ISNULL THEN 0 ELSE  A.sum_current_revenue END, '0' as sum_current_revenue_proportion, A.target as target_type_1, A.target_str as target_str_type_1, '0' as target_type_1_proportion, 0 as rank_1, '0' as percentage_complete_1, CASE WHEN B.sum_distribution_amount  ISNULL THEN 0 ELSE B.sum_distribution_amount END, B.target as target_type_2, B.target_str as target_str_type_2, 0 as rank_2, '0' as percentage_complete_2, '0' as back_1, '0' as back_2, '0' as back_3 from ( select AA.business_line AS business_line, sum(AA.sum_current_revenue) AS sum_current_revenue, AA.target, AA.target_str from ( select ps.business_line, A.sum_current_revenue, tr.target, tr.target_str from projects ps left join target_records tr on year =? and ps.business_line = tr.business_line and year =? and type =1 left join ( SELECT b.business_line, SUM (rsr.current_revenue) AS sum_current_revenue FROM revenue_statistical_records rsr LEFT JOIN projects b ON rsr.project_id = b.project_id  where rsr.year = ? and rsr.month >=? and rsr.month <=? group by b.business_line ) as A on ps.business_line = A.business_line  where ps.business_line>0 GROUP BY ps.business_line, A.sum_current_revenue,tr.target, tr.target_str order by ps.business_line ) as AA GROUP BY AA.business_line,AA.target, AA.target_str order by AA.business_line ) as A LEFT JOIN ( select ps.business_line AS business_line, sum(AA.sum_distribution_amount) AS sum_distribution_amount, tr.target, tr.target_str from projects ps left join target_records tr on tr.year =? and ps.business_line = tr.business_line and type =2 left join ( select A.project_id, sum(A.distribution_amount) as sum_distribution_amount from capital_distributions A LEFT JOIN contracts b ON A.contract_id = b.contract_id AND A.project_id IS NOT NULL LEFT JOIN capitals C ON A.capital_id = C.capital_id LEFT JOIN projects d ON A.project_id = d.project_id where A.delete_flag = 0 and to_char(C.happen_date,'YYYY') =? and to_char(C.happen_date,'MM') >=? and to_char(C.happen_date,'MM') <=? group by A.project_id ) as AA on AA.project_id =ps.project_id where ps.business_line>0 group by ps.business_line,tr.target, tr.target_str order by ps.business_line ) as B on A.business_line = B.business_line LEFT JOIN (select A.business_line AS business_line,sum(A.sheet_amount) AS sum_sheet_amount from (select ps.project_id,cs.contract_id,ps.business_line,ps.sheet_amount FROM contracts cs LEFT JOIN projects ps ON cs.contract_id = ps.contract_id WHERE to_char( cs.contract_date, 'YYYY' ) =? AND to_char( cs.contract_date, 'MM' ) >=? AND to_char( cs.contract_date, 'MM' ) <=? AND ps.business_line > 0 and cs.contract_date IS NOT NULL order by cs.contract_id)	 as A LEFT JOIN system_dictionary sd ON sd.dic_type_value_id = A.business_line  and sd.dic_type_id =205 where  A.business_line > 0 AND sd.dic_is_enable = TRUE GROUP BY A.business_line ORDER BY A.business_line) AS C ON C.business_line =A.business_line" ;
	private final static String RESULTSETFIELDLIST = "business_line,sum_sheet_amount,sum_current_revenue,sum_current_revenue_proportion,target_type_1,target_str_type_1,target_type_1_proportion,rank_1,percentage_complete_1,sum_distribution_amount,target_type_2,target_str_type_2,rank_2,percentage_complete_2,back_1,back_2,back_3";
	private final static String[] fieldNames = { "year", "year", "year", "start_month", "end_month", "year", "year_str", "month_start_str", "month_end_str", "year_str", "month_start_str", "month_end_str"};
}
