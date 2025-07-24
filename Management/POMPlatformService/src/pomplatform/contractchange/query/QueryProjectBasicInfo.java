package pomplatform.contractchange.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contractchange.bean.BaseProjectBasicInfo;
import pomplatform.contractchange.bean.ConditionProjectBasicInfo;

public class QueryProjectBasicInfo extends AbstractQuery<BaseProjectBasicInfo, ConditionProjectBasicInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryProjectBasicInfo.class);

	public QueryProjectBasicInfo() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.project_id");
	}

	@Override
	public BaseCollection<BaseProjectBasicInfo> executeQuery( KeyValuePair[] replacements, ConditionProjectBasicInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId()
			);
	}

	@Override
	public BaseProjectBasicInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProjectBasicInfo __base = new BaseProjectBasicInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSheetAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCommonArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLogisticsArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCadArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getBoolean(val));
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

	private final static String __SQLText = "SELECT a.project_id, a.contract_code, a.project_code, a.project_name, a.sheet_amount, a.total_integral, a.common_area, a.logistics_area, a.cad_area, case when (sum(b.total_amount) = a.project_integral) then true else false end as status from projects a LEFT JOIN project_settlements b on a.project_id = b.project_id where a.contract_id = ? GROUP BY a.project_id, a.contract_code, a.project_code, a.project_name, a.sheet_amount, a.total_integral, a.common_area, a.logistics_area, a.cad_area" ;
	private final static String RESULTSETFIELDLIST = "project_id,contract_code,project_code,project_name,sheet_amount,total_integral,common_area,logistics_area,cad_area,status";
	private final static String[] fieldNames = { "contract_id"};
}
