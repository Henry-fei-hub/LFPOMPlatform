package pomplatform.contract.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contract.bean.BaseShowOldProjectRevenue;
import pomplatform.contract.bean.ConditionShowOldProjectRevenue;

public class QueryShowOldProjectRevenue extends AbstractQuery<BaseShowOldProjectRevenue, ConditionShowOldProjectRevenue>
{

	private static final Logger __logger = Logger.getLogger(QueryShowOldProjectRevenue.class);

	public QueryShowOldProjectRevenue() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("opr.contract_code");
	}

	@Override
	public BaseCollection<BaseShowOldProjectRevenue> executeQuery( KeyValuePair[] replacements, ConditionShowOldProjectRevenue condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getPalteId()
			);
	}

	@Override
	public BaseShowOldProjectRevenue generateBase(Object[] __data) throws java.sql.SQLException {
		BaseShowOldProjectRevenue __base = new BaseShowOldProjectRevenue();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPalteId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsFinish(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
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

	private final static String __SQLText = "SELECT opr.contract_code, opr.project_code, opr.project_name, opr.amount, opr.palte_id, opr.is_finish FROM old_project_revenues opr where opr.project_code = ? and opr.project_name like ? and opr.palte_id = ?" ;
	private final static String RESULTSETFIELDLIST = "contract_code,project_code,project_name,amount,palte_id,is_finish";
	private final static String[] fieldNames = { "project_code", "project_name", "palte_id"};
}
