package pomplatform.employee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employee.bean.BaseContractDistributionChild;
import pomplatform.employee.bean.ConditionContractDistributionChild;

public class QueryContractDistributionChild extends AbstractQuery<BaseContractDistributionChild, ConditionContractDistributionChild>
{

	private static final Logger __logger = Logger.getLogger(QueryContractDistributionChild.class);

	public QueryContractDistributionChild() throws java.sql.SQLException 
	{
		setParameterNumber(10);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("AA.project_id");
	}

	@Override
	public BaseCollection<BaseContractDistributionChild> executeQuery( KeyValuePair[] replacements, ConditionContractDistributionChild condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getBusinessType(), 
				condition.getPlateId(), 
				condition.getContractId(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getBusinessType(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseContractDistributionChild generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractDistributionChild __base = new BaseContractDistributionChild();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCommissionsRate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRevenueIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRelativelyProgress(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
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
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[6]));
		if(args[7] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
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

	private final static String __SQLText = "select AA.project_id, AA.contract_code, AA.contract_id, AA.project_name, AA.business_type, AA.project_amount, BB.commissions_rate, AA.revenue_integral, AA.relatively_progress, AA.amount from (SELECT mc.project_id, P.contract_code, P.contract_id, P.project_name, P.business_type, AVG ( mc.project_amount ) AS project_amount, round( SUM ( mc.income ) / AVG ( mc.project_amount / 1.06 ) * 100, 2 ) AS relatively_progress, AA.revenue_integral, SUM ( day_revenue ) AS amount FROM marketing_commissions mc LEFT JOIN ( SELECT A .project_id, CASE WHEN A.project_integral > 0 THEN round( COALESCE ( b.sure_integral, 0 ) / A.project_integral * 100, 2 ) ELSE 0 END AS revenue_integral FROM projects A LEFT JOIN ( SELECT project_id, SUM ( total_amount ) AS sure_integral FROM project_settlements GROUP BY project_id ) AS b ON A.project_id = b.project_id ORDER BY project_id ) AA ON AA.project_id = mc.project_id LEFT JOIN projects P ON P.project_id = mc.project_id WHERE mc.contract_id =? AND mc.commissions >? AND mc.commissions <=? AND mc.business_type =? AND mc.plate_id =? GROUP BY mc.project_id, AA.revenue_integral, P.contract_code, P.contract_id, P.project_name, P.business_type ) AS AA LEFT JOIN( select a.project_id, a.commissions_rate from ( select project_id, max(marketing_commission_id) as marketing_commission_id from marketing_commissions mmc where mmc.contract_id =? AND mmc.commissions >? AND mmc.commissions <=? AND mmc.business_type =? AND mmc.plate_id =? group by project_id) b LEFT JOIN marketing_commissions a on b.marketing_commission_id = a.marketing_commission_id ) AS BB on AA.project_id = BB.project_id order by AA.project_id" ;
	private final static String RESULTSETFIELDLIST = "project_id,contract_code,contract_id,project_name,business_type,project_amount,commissions_rate,revenue_integral,relatively_progress,amount";
	private final static String[] fieldNames = { "contract_id", "start_date", "end_date", "business_type", "plate_id", "contract_id", "start_date", "end_date", "business_type", "plate_id"};
}
