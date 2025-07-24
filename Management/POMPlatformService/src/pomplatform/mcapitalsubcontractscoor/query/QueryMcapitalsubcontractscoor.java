package pomplatform.mcapitalsubcontractscoor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.mcapitalsubcontractscoor.bean.BaseMcapitalsubcontractscoor;
import pomplatform.mcapitalsubcontractscoor.bean.ConditionMcapitalsubcontractscoor;

public class QueryMcapitalsubcontractscoor extends AbstractQuery<BaseMcapitalsubcontractscoor, ConditionMcapitalsubcontractscoor>
{

	private static final Logger __logger = Logger.getLogger(QueryMcapitalsubcontractscoor.class);

	public QueryMcapitalsubcontractscoor() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sc.sub_contract_id");
	}

	@Override
	public BaseCollection<BaseMcapitalsubcontractscoor> executeQuery( KeyValuePair[] replacements, ConditionMcapitalsubcontractscoor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCapitalId(), 
				condition.getOperatorId()
			);
	}

	@Override
	public BaseMcapitalsubcontractscoor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMcapitalsubcontractscoor __base = new BaseMcapitalsubcontractscoor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSubContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSubContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSubContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCapitalSubContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCreatTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOperatorId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT sc.sub_contract_id, sc.sub_contract_code, sc.project_code, sc.sub_contract_name, csc.capital_id, csc.capital_sub_contract_id, csc.money, csc.creat_time, csc.operator_id FROM capital_sub_contracts csc LEFT JOIN sub_contracts sc ON csc.sub_contract_id = sc.sub_contract_id WHERE csc.capital_id = ? AND csc.operator_id = ?" ;
	private final static String RESULTSETFIELDLIST = "sub_contract_id,sub_contract_code,project_code,sub_contract_name,capital_id,capital_sub_contract_id,money,creat_time,operator_id";
	private final static String[] fieldNames = { "capital_id", "operator_id"};
}
