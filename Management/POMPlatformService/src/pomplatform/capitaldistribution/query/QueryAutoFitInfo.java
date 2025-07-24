package pomplatform.capitaldistribution.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.capitaldistribution.bean.BaseAutoFitInfo;
import pomplatform.capitaldistribution.bean.ConditionAutoFitInfo;

public class QueryAutoFitInfo extends AbstractQuery<BaseAutoFitInfo, ConditionAutoFitInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryAutoFitInfo.class);

	public QueryAutoFitInfo() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.project_id");
	}

	@Override
	public BaseCollection<BaseAutoFitInfo> executeQuery( KeyValuePair[] replacements, ConditionAutoFitInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseAutoFitInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAutoFitInfo __base = new BaseAutoFitInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDistributionAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSheetAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCalculationResult(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT a.*,COALESCE(sum(b.total_amount), 0) as sure_integral from (SELECT a.project_id, a.plate_id, a.contract_id, COALESCE(sum(c.distribution_amount), 0) as distribution_amount, COALESCE(a.project_integral, 0) as project_integral, COALESCE(a.sheet_amount, 0) as sheet_amount, 0.0 as calculation_result from projects a LEFT JOIN capital_distributions c on a.project_id = c.project_id and c.delete_flag = 0 where a.contract_id = ? group by a.project_id, a.plate_id, a.contract_id, a.project_integral, a.sheet_amount) a left join project_settlements b on a.project_id = b.project_id where b.settlement_date < ? group by a.project_id, a.plate_id, a.contract_id, a.project_integral, a.sheet_amount, a.distribution_amount, a.calculation_result" ;
	private final static String RESULTSETFIELDLIST = "project_id,plate_id,contract_id,distribution_amount,project_integral,sheet_amount,calculation_result,sure_integral";
	private final static String[] fieldNames = { "contract_id", "end_date"};
}
