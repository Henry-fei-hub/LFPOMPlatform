package pomplatform.designConsiderationInfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.designConsiderationInfo.bean.BaseDesignConsiderationInfo;
import pomplatform.designConsiderationInfo.bean.ConditionDesignConsiderationInfo;

public class QueryDesignConsiderationInfo extends AbstractQuery<BaseDesignConsiderationInfo, ConditionDesignConsiderationInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryDesignConsiderationInfo.class);

	public QueryDesignConsiderationInfo() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("dc.design_consideration_id");
	}

	@Override
	public BaseCollection<BaseDesignConsiderationInfo> executeQuery( KeyValuePair[] replacements, ConditionDesignConsiderationInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getSubContractId()
			);
	}

	@Override
	public BaseDesignConsiderationInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseDesignConsiderationInfo __base = new BaseDesignConsiderationInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDesignConsiderationId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainDesignAreaName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSubDesignAreaName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDecorationStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDesignUnitPrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSubContractId(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setInt(count++, (java.lang.Integer)args[0]);
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

	private final static String __SQLText = "select dc.design_consideration_id, dc.main_design_area_name, dc.sub_design_area_name, dc.decoration_status, dc.design_area, dc.design_unit_price, dc.money_sum, dc.sub_contract_id from design_considerations dc where dc.sub_contract_id = ?" ;
	private final static String RESULTSETFIELDLIST = "design_consideration_id,main_design_area_name,sub_design_area_name,decoration_status,design_area,design_unit_price,money_sum,sub_contract_id";
	private final static String[] fieldNames = { "sub_contract_id"};
}
