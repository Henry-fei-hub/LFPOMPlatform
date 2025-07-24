package pomplatform.itemCollection.custom.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.itemCollection.custom.bean.BaseonLoadCapitalAmountOfContract;
import pomplatform.itemCollection.custom.bean.ConditiononLoadCapitalAmountOfContract;

public class QueryonLoadCapitalAmountOfContract extends AbstractQuery<BaseonLoadCapitalAmountOfContract, ConditiononLoadCapitalAmountOfContract>
{

	private static final Logger __logger = Logger.getLogger(QueryonLoadCapitalAmountOfContract.class);

	public QueryonLoadCapitalAmountOfContract() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("p.contract_id");
	}

	@Override
	public BaseCollection<BaseonLoadCapitalAmountOfContract> executeQuery( KeyValuePair[] replacements, ConditiononLoadCapitalAmountOfContract condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getProjectId()
			);
	}

	@Override
	public BaseonLoadCapitalAmountOfContract generateBase(Object[] __data) throws java.sql.SQLException {
		BaseonLoadCapitalAmountOfContract __base = new BaseonLoadCapitalAmountOfContract();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSheetAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRevenueAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCapitalAmount(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT p.contract_id,p.project_id,p.plate_id,p.sheet_amount,p.project_integral,ps.sure_integral ,round(ps.sure_integral/p.project_integral*p.sheet_amount,2) AS revenue_amount,d.capital_amount FROM projects p LEFT JOIN (SELECT project_id,SUM(total_amount) as sure_integral FROM project_settlements WHERE settlement_status = 2 GROUP BY project_id) AS ps ON p.project_id = ps.project_id LEFT JOIN (SELECT project_id,SUM(distribution_amount) AS capital_amount FROM capital_distributions WHERE delete_flag = 0 GROUP BY project_id ) AS d ON p.project_id = d.project_id WHERE p.sheet_amount > 0 AND p.project_integral > 0 AND p.contract_id = ? AND p.project_id = ? ORDER BY p.contract_id,p.project_id" ;
	private final static String RESULTSETFIELDLIST = "contract_id,project_id,plate_id,sheet_amount,project_integral,sure_integral,revenue_amount,capital_amount";
	private final static String[] fieldNames = { "contract_id", "project_id"};
}
