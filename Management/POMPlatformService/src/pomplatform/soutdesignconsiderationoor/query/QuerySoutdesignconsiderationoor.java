package pomplatform.soutdesignconsiderationoor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.soutdesignconsiderationoor.bean.BaseSoutdesignconsiderationoor;
import pomplatform.soutdesignconsiderationoor.bean.ConditionSoutdesignconsiderationoor;

public class QuerySoutdesignconsiderationoor extends AbstractQuery<BaseSoutdesignconsiderationoor, ConditionSoutdesignconsiderationoor>
{

	private static final Logger __logger = Logger.getLogger(QuerySoutdesignconsiderationoor.class);

	public QuerySoutdesignconsiderationoor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("info_code");
	}

	@Override
	public BaseCollection<BaseSoutdesignconsiderationoor> executeQuery( KeyValuePair[] replacements, ConditionSoutdesignconsiderationoor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getOutQuotationId()
			);
	}

	@Override
	public BaseSoutdesignconsiderationoor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSoutdesignconsiderationoor __base = new BaseSoutdesignconsiderationoor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOutQuotationId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDataCount(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setDesignArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInteriorMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOutTempletId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNewCreateQuotationName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFinalizedMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT info_code,project_code, out_quotation_id, business_type, COUNT (1) AS data_count, SUM (design_area) AS design_area, SUM (money_sum) AS money_sum, SUM (interior_money_sum) AS interior_money_sum,out_templet_id,new_create_quotation_name,max(finalized_money) as finalized_money,type FROM out_design_considerations WHERE out_quotation_id =? GROUP BY project_code,out_quotation_id,business_type,info_code,out_templet_id,new_create_quotation_name,type ORDER BY business_type, out_templet_id DESC" ;
	private final static String RESULTSETFIELDLIST = "info_code,project_code,out_quotation_id,business_type,data_count,design_area,money_sum,interior_money_sum,out_templet_id,new_create_quotation_name";
	private final static String[] fieldNames = { "out_quotation_id"};
}
