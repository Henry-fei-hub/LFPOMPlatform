package pomplatform.capitaldistribution.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.capitaldistribution.bean.BaseGetProjectSureAndLeftInteger;
import pomplatform.capitaldistribution.bean.ConditionGetProjectSureAndLeftInteger;

public class QueryGetProjectSureAndLeftInteger extends AbstractQuery<BaseGetProjectSureAndLeftInteger, ConditionGetProjectSureAndLeftInteger>
{

	private static final Logger __logger = Logger.getLogger(QueryGetProjectSureAndLeftInteger.class);

	public QueryGetProjectSureAndLeftInteger() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.project_id");
	}

	@Override
	public BaseCollection<BaseGetProjectSureAndLeftInteger> executeQuery( KeyValuePair[] replacements, ConditionGetProjectSureAndLeftInteger condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getContractId(), 
				condition.getContractId()
			);
	}

	@Override
	public BaseGetProjectSureAndLeftInteger generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetProjectSureAndLeftInteger __base = new BaseGetProjectSureAndLeftInteger();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
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
		if(args[0] != null) __statement.setInt(count++, GenericBase.__getInt(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
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

	private final static String __SQLText = "SELECT a.project_id, case when sum(b.sure_integral) is null then 0 else sum(b.sure_integral) end as sure_integral, (a.total_integral - (case when sum(b.sure_integral) is null then 0 else sum(b.sure_integral) end)) as left_integral from projects a LEFT JOIN ( (SELECT a.project_id, sum(a.total_amount) as sure_integral from project_settlements a LEFT JOIN projects b on a.project_id = b.project_id where b.contract_id = ? GROUP BY a.project_id ) union all ( SELECT a.project_id, sum(a.account_integral) as sure_integral from plate_project_account_records a LEFT JOIN projects b on a.project_id = b.project_id where b.contract_id = ? GROUP BY a.project_id) ) b on a.project_id = b.project_id where a.contract_id = ? GROUP BY a.project_id, a.total_integral" ;
	private final static String RESULTSETFIELDLIST = "project_id,sure_integral,left_integral";
	private final static String[] fieldNames = { "contract_id", "contract_id", "contract_id"};
}
