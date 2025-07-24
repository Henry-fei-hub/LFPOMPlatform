package pomplatform.employeemoneymanagespeemmepemmor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employeemoneymanagespeemmepemmor.bean.BaseMcapitaldistributionlinksubcontractpcor;
import pomplatform.employeemoneymanagespeemmepemmor.bean.ConditionMcapitaldistributionlinksubcontractpcor;

public class QueryMcapitaldistributionlinksubcontractpcor extends AbstractQuery<BaseMcapitaldistributionlinksubcontractpcor, ConditionMcapitaldistributionlinksubcontractpcor>
{

	private static final Logger __logger = Logger.getLogger(QueryMcapitaldistributionlinksubcontractpcor.class);

	public QueryMcapitaldistributionlinksubcontractpcor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cdp.capital_distribution_link_sub_contract_id");
	}

	@Override
	public BaseCollection<BaseMcapitaldistributionlinksubcontractpcor> executeQuery( KeyValuePair[] replacements, ConditionMcapitaldistributionlinksubcontractpcor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCapitalId()
			);
	}

	@Override
	public BaseMcapitaldistributionlinksubcontractpcor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMcapitaldistributionlinksubcontractpcor __base = new BaseMcapitaldistributionlinksubcontractpcor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCapitalDistributionLinkSubContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCapitalDistributionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSubContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "SELECT cdp.capital_distribution_link_sub_contract_id, cdp.capital_distribution_id, cdp.sub_contract_id, cdp.money, pj.contract_code, pj.project_name, cdp.capital_id, cdp.create_time FROM capital_distribution_link_sub_contracts cdp LEFT JOIN projects pj ON cdp.sub_contract_id = pj.project_id WHERE cdp.capital_id = ?" ;
	private final static String RESULTSETFIELDLIST = "capital_distribution_link_sub_contract_id,capital_distribution_id,sub_contract_id,money,contract_code,project_name,capital_id,create_time";
	private final static String[] fieldNames = { "capital_id"};
}
