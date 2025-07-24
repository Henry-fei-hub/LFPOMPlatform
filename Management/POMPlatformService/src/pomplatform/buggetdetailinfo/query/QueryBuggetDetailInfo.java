package pomplatform.buggetdetailinfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.buggetdetailinfo.bean.BaseBuggetDetailInfo;
import pomplatform.buggetdetailinfo.bean.ConditionBuggetDetailInfo;

public class QueryBuggetDetailInfo extends AbstractQuery<BaseBuggetDetailInfo, ConditionBuggetDetailInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryBuggetDetailInfo.class);

	public QueryBuggetDetailInfo() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("bm.budget_management_id");
	}

	@Override
	public BaseCollection<BaseBuggetDetailInfo> executeQuery( KeyValuePair[] replacements, ConditionBuggetDetailInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getBudgetManagementId(), 
				condition.getBudgetManagementId()
			);
	}

	@Override
	public BaseBuggetDetailInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseBuggetDetailInfo __base = new BaseBuggetDetailInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setBudgetManagementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBddType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBddAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBddAmountPercent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBudgetContractAmountUse(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUsePercent(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT bm.budget_management_id, bm.bdd_type, bm.bdd_amount, case when bm.bdd_amount >0 and A.total_amout >0 THEN CAST ( round( bm.bdd_amount :: NUMERIC / A.total_amout :: NUMERIC * 100, 2 ) AS VARCHAR ) || '%' ELSE '0' end AS bdd_amount_percent, COALESCE ( b.budget_contract_amount_use, 0 ) AS budget_contract_amount_use, case WHEN b.budget_contract_amount_use >0 and C.total_use_amount>0 then CAST ( round( b.budget_contract_amount_use :: NUMERIC / C.total_use_amount :: NUMERIC * 100, 2 ) AS VARCHAR ) || '%' ELSE '0' END as use_percent FROM budget_management_detail bm LEFT JOIN ( SELECT bmd.budget_management_id,sum(bmd.bdd_amount) as total_amout FROM budget_management_detail bmd GROUP BY bmd.budget_management_id ) A on a.budget_management_id=bm.budget_management_id LEFT JOIN ( SELECT ba.bdd_type,sum(ba.budget_contract_amount_use) as budget_contract_amount_use from budget_attachment ba WHERE ba.budget_management_id=? GROUP BY ba.bdd_type ) B on b.bdd_type=bm.bdd_type LEFT JOIN ( SELECT budget_management_id,sum(budget_contract_amount_use) as total_use_amount FROM budget_attachment GROUP BY budget_management_id ) c on c.budget_management_id=bm.budget_management_id WHERE bm.budget_management_id=?" ;
	private final static String RESULTSETFIELDLIST = "budget_management_id,bdd_type,bdd_amount,bdd_amount_percent,budget_contract_amount_use,use_percent";
	private final static String[] fieldNames = { "budget_management_id", "budget_management_id"};
}
