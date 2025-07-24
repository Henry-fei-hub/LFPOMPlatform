package pomplatform.attachment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.attachment.bean.BaseMprojectccpor;
import pomplatform.attachment.bean.ConditionMprojectccpor;

public class QueryMprojectccpor extends AbstractQuery<BaseMprojectccpor, ConditionMprojectccpor>
{

	private static final Logger __logger = Logger.getLogger(QueryMprojectccpor.class);

	public QueryMprojectccpor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pj.project_id");
	}

	@Override
	public BaseCollection<BaseMprojectccpor> executeQuery( KeyValuePair[] replacements, ConditionMprojectccpor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseMprojectccpor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMprojectccpor __base = new BaseMprojectccpor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSheetAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setConfirmProjectIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT pj.project_id, pj.project_integral, pjd.money, pj.sheet_amount, CASE WHEN pj.project_integral ISNULL OR pjd.money ISNULL OR pj.sheet_amount ISNULL OR pj.project_integral = 0 OR pjd.money =0 OR pj.sheet_amount = 0 THEN 0 ELSE CASE WHEN pjd.money / pj.sheet_amount > 1 THEN pj.project_integral ELSE round(pj.project_integral * (pjd.money / pj.sheet_amount), 2) END END AS confirm_project_integral FROM projects pj LEFT JOIN ( SELECT cd.sub_contract_id, SUM (money) AS money FROM capital_distribution_link_sub_contracts cd LEFT JOIN capital_distributions cp ON cp.capital_distribution_id = cd.capital_distribution_id WHERE ( cp.is_completed = TRUE OR cd.capital_id > 0 ) AND cd.money > 0 GROUP BY cd.sub_contract_id )pjd ON pj.project_id = pjd.sub_contract_id WHERE pj.project_id = ?" ;
	private final static String RESULTSETFIELDLIST = "project_id,project_integral,money,sheet_amount,confirm_project_integral";
	private final static String[] fieldNames = { "project_id"};
}
