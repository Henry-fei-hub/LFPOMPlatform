package pomplatform.ht.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.ht.bean.BaseSsubcontractor;
import pomplatform.ht.bean.ConditionSsubcontractor;

public class QuerySsubcontractor extends AbstractQuery<BaseSsubcontractor, ConditionSsubcontractor>
{

	private static final Logger __logger = Logger.getLogger(QuerySsubcontractor.class);

	public QuerySsubcontractor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sc.sub_contract_id");
	}

	@Override
	public BaseCollection<BaseSsubcontractor> executeQuery( KeyValuePair[] replacements, ConditionSsubcontractor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getInfoCode()
			);
	}

	@Override
	public BaseSsubcontractor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSsubcontractor __base = new BaseSsubcontractor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSubContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSubContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCommonArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLogisticsArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSubContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDesignArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDesignAreaPrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJobMix(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setServiceArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setWithTheAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOnSiteTime(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOnSitePrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOnSiteTotalMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSubmitDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOrderNo(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select sc.sub_contract_id, sc.parent_id, sc.sub_contract_code, sc.project_code, sc.business_type, sc.project_type, sc.department_id, sc.common_area, sc.logistics_area, sc.money_sum, sc.create_time, sc.sub_contract_name, sc.update_time, sc.design_area, sc.design_area_price, sc.job_mix, sc.service_area, sc.with_the_amount, sc.on_site_time, sc.on_site_price, sc.on_site_total_money, sc.submit_date, sc.info_code, sc.order_no from sub_contracts sc where sc.info_code = ?" ;
	private final static String RESULTSETFIELDLIST = "sub_contract_id,parent_id,sub_contract_code,project_code,business_type,project_type,department_id,common_area,logistics_area,money_sum,create_time,sub_contract_name,update_time,design_area,design_area_price,job_mix,service_area,with_the_amount,on_site_time,on_site_price,on_site_total_money,submit_date,info_code,order_no";
	private final static String[] fieldNames = { "info_code"};
}
