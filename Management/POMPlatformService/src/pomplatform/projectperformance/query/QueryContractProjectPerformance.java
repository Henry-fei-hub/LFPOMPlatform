package pomplatform.projectperformance.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectperformance.bean.BaseContractProjectPerformance;
import pomplatform.projectperformance.bean.ConditionContractProjectPerformance;

public class QueryContractProjectPerformance extends AbstractQuery<BaseContractProjectPerformance, ConditionContractProjectPerformance>
{

	private static final Logger __logger = Logger.getLogger(QueryContractProjectPerformance.class);

	public QueryContractProjectPerformance() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.contract_id");
	}

	@Override
	public BaseCollection<BaseContractProjectPerformance> executeQuery( KeyValuePair[] replacements, ConditionContractProjectPerformance condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getContractCode(), 
				condition.getContractId(), 
				condition.getProjectManageId(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseContractProjectPerformance generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractProjectPerformance __base = new BaseContractProjectPerformance();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSheetAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setGainMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeftMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinishPercent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectManageIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectManageSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDeductIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAwardIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSheetPerformanceAchieve(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSheetPerformancePay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeftIntegral(GenericBase.__getDecimal(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "select a.contract_id,a.contract_code,a.contract_name,c.project_id,a.signing_money_sum as contract_amount,b.project_level,cc.sheet_amount ,cc.total_integral, cc.project_integral,cc.project_cost,cc.total_revenue ,sum(d.borrow_money) as gain_money ,(a.signing_money_sum - sum(d.borrow_money)) as left_money ,(case when a.signing_money_sum > 0 then (case when cc.total_revenue > 0 then round(cc.total_revenue/a.signing_money_sum*100,2) else 0 end) else 0 end) ||'%' as finish_percent ,c.project_integral as project_manage_integral , ps.project_manage_sure_integral,ppp.deduct_integral,ppp.award_integral ,c.project_manage_id,ppp.sheet_performance_achieve,ppp.sheet_performance_pay ,((case when ppp.sheet_performance_achieve is null then 0 else ppp.sheet_performance_achieve end)-(case when ppp.sheet_performance_pay is null then 0 else ppp.sheet_performance_pay end)) as left_integral from contracts a left join main_projects b on a.info_code = b.info_code left join projects c on a.contract_id = c.contract_id and c.project_type = 16 LEFT JOIN (SELECT project_id,SUM(total_amount) AS project_manage_sure_integral FROM project_settlements WHERE settlement_status = 2 GROUP BY project_id) AS ps ON c.project_id = ps.project_id LEFT JOIN (select aa.contract_id,sum(aa.sheet_amount) as sheet_amount ,sum(aa.total_integral) as total_integral,sum(aa.project_integral) as project_integral ,SUM(pcc.project_cost) AS project_cost,SUM(pss.sure_integral) AS sure_integral ,SUM(round((case when aa.project_integral > 0 then (case when pss.sure_integral > 0 then pss.sure_integral/aa.project_integral else 0 end) else 0 end)*aa.sheet_amount,2)) as total_revenue FROM projects aa LEFT JOIN (SELECT project_id,SUM(amount) AS project_cost FROM project_cost GROUP BY project_id ) AS pcc ON aa.project_id = pcc.project_id LEFT JOIN (SELECT project_id,SUM(total_amount) AS sure_integral FROM project_settlements WHERE settlement_status =2 GROUP BY project_id ) AS pss ON aa.project_id = pss.project_id GROUP BY aa.contract_id ) AS cc ON a.contract_id = cc.contract_id LEFT JOIN capitals d on a.contract_id = d.contract_id and d.capital_type = 1 LEFT JOIN employees e on c.project_manage_id = e.employee_id LEFT JOIN (select contract_id ,SUM(CASE WHEN business_type = 1 AND performance_flag = 1 THEN performance_integral ELSE 0 END) AS deduct_integral ,SUM(CASE WHEN business_type = 1 AND performance_flag = 2 THEN performance_integral ELSE 0 END) AS award_integral ,SUM(CASE WHEN business_type = 2 AND performance_flag = 1 THEN performance_integral ELSE 0 END) AS sheet_performance_achieve ,SUM(CASE WHEN business_type = 2 AND performance_flag = 2 THEN performance_integral ELSE 0 END) AS sheet_performance_pay from project_performances where is_submit = true and record_date BETWEEN ? and ? GROUP BY contract_id,business_type,performance_flag) as ppp on a.contract_id = ppp.contract_id where c.project_manage_id > 0 and a.contract_code like ? and a.contract_id = ? and c.project_manage_id = ? and e.plate_id = ? GROUP BY a.contract_id ,a.contract_code,a.contract_name,contract_amount,b.project_level,cc.sheet_amount, cc.total_integral ,cc.project_integral,cc.project_cost,cc.total_revenue, c.project_manage_id, ps.project_manage_sure_integral,ppp.sheet_performance_achieve ,ppp.sheet_performance_pay,c.project_id,ppp.deduct_integral,ppp.award_integral ORDER BY a.contract_id" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_name,project_id,contract_amount,project_level,sheet_amount,total_integral,project_integral,project_cost,total_revenue,gain_money,left_money,finish_percent,project_manage_integral,project_manage_sure_integral,deduct_integral,award_integral,project_manage_id,sheet_performance_achieve,sheet_performance_pay,left_integral";
	private final static String[] fieldNames = { "start_date", "end_date", "contract_code", "contract_id", "project_manage_id", "plate_id"};
}
