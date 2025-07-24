package pomplatform.groupOutdesignconsiderationior.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.groupOutdesignconsiderationior.bean.BaseGroupOutdesignconsiderationior;
import pomplatform.groupOutdesignconsiderationior.bean.ConditionGroupOutdesignconsiderationior;

public class QueryGroupOutdesignconsiderationior extends AbstractQuery<BaseGroupOutdesignconsiderationior, ConditionGroupOutdesignconsiderationior>
{

	private static final Logger __logger = Logger.getLogger(QueryGroupOutdesignconsiderationior.class);

	public QueryGroupOutdesignconsiderationior() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("finalized_money");
	}

	@Override
	public BaseCollection<BaseGroupOutdesignconsiderationior> executeQuery( KeyValuePair[] replacements, ConditionGroupOutdesignconsiderationior condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getInfoCode(), 
				condition.getQuotationStatus(),
				condition.getProjectCode()
			);
	}

	@Override
	public BaseGroupOutdesignconsiderationior generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGroupOutdesignconsiderationior __base = new BaseGroupOutdesignconsiderationior();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setFinalizedMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInteriorMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setNewCreateQuotationName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOutQuotationId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setQuotationStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
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

	private final static String __SQLText = "select finalized_money,SUM (o.interior_money_sum) AS interior_money_sum,SUM (o.money_sum) AS money_sum, o.info_code,o.new_create_quotation_name,o.out_quotation_id,ou.quotation_status ,ou.project_code,ou.contract_id from out_design_considerations o left join out_quotations ou on o.out_quotation_id=ou.out_quotation_id where o.info_code=? and ou.quotation_status=? and ou.project_code = ? GROUP BY o.out_quotation_id,o.business_type,o.info_code,o.out_templet_id,o.new_create_quotation_name,o.finalized_money,ou.quotation_status,ou.project_code,ou.contract_id" ;
	private final static String RESULTSETFIELDLIST = "finalized_money,interior_money_sum,money_sum,info_code,new_create_quotation_name,out_quotation_id,quotation_status,project_code,contract_id";
	private final static String[] fieldNames = { "info_code", "quotation_status","project_code"};
}
