package pomplatform.newOutdesignconsiderationor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.newOutdesignconsiderationor.bean.BaseSoutdesignconsiderationor;
import pomplatform.newOutdesignconsiderationor.bean.ConditionSoutdesignconsiderationor;

public class QuerySoutdesignconsiderationor extends AbstractQuery<BaseSoutdesignconsiderationor, ConditionSoutdesignconsiderationor>
{

	private static final Logger __logger = Logger.getLogger(QuerySoutdesignconsiderationor.class);

	public QuerySoutdesignconsiderationor() throws java.sql.SQLException 
	{
		setParameterNumber(0);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("out_quotation_id");
	}

	@Override
	public BaseCollection<BaseSoutdesignconsiderationor> executeQuery( KeyValuePair[] replacements, ConditionSoutdesignconsiderationor condition ) throws java.sql.SQLException {
		return executeQuery(replacements
			);
	}

	@Override
	public BaseSoutdesignconsiderationor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSoutdesignconsiderationor __base = new BaseSoutdesignconsiderationor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setOutQuotationId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInteriorMoneySum(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select out_quotation_id,sum(money_sum) as money_sum,sum(interior_money_sum) as interior_money_sum from out_design_considerations group by out_quotation_id" ;
	private final static String RESULTSETFIELDLIST = "out_quotation_id,money_sum,interior_money_sum";
	private final static String[] fieldNames = { };
}
