package pomplatform.employee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employee.bean.BaseLastMarketingCommission;
import pomplatform.employee.bean.ConditionLastMarketingCommission;

public class QueryLastMarketingCommission extends AbstractQuery<BaseLastMarketingCommission, ConditionLastMarketingCommission>
{

	private static final Logger __logger = Logger.getLogger(QueryLastMarketingCommission.class);

	public QueryLastMarketingCommission() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("marketing_commission_id");
	}

	@Override
	public BaseCollection<BaseLastMarketingCommission> executeQuery( KeyValuePair[] replacements, ConditionLastMarketingCommission condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getSettlementIdentifier()
			);
	}

	@Override
	public BaseLastMarketingCommission generateBase(Object[] __data) throws java.sql.SQLException {
		BaseLastMarketingCommission __base = new BaseLastMarketingCommission();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setMarketingCommissionId(GenericBase.__getShort(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCommissions(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null)
		if((val = __data[count++]) != null) __base.setCumulativeRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDayRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSettlementIdentifier(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRealProgress(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRelativelyProgress(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalIncome(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIncome(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT marketing_commission_id, contract_id, project_id, commissions, commissions_rate, cumulative_revenue, day_revenue, plate_id, settlement_identifier, real_progress, relatively_progress, total_income, income FROM marketing_commissions WHERE project_id =? AND settlement_identifier =? ORDER BY commissions DESC" ;
	private final static String RESULTSETFIELDLIST = "marketing_commission_id,contract_id,project_id,commissions,commissions_rate,cumulative_revenue,day_revenue,plate_id,settlement_identifier,real_progress,relatively_progress,total_income,income";
	private final static String[] fieldNames = { "project_id", "settlement_identifier"};
}
