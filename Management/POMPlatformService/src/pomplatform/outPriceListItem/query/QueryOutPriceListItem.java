package pomplatform.outPriceListItem.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.outPriceListItem.bean.BaseOutPriceListItem;
import pomplatform.outPriceListItem.bean.ConditionOutPriceListItem;

public class QueryOutPriceListItem extends AbstractQuery<BaseOutPriceListItem, ConditionOutPriceListItem>
{

	private static final Logger __logger = Logger.getLogger(QueryOutPriceListItem.class);

	public QueryOutPriceListItem() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("odc.out_design_consideration_id");
	}

	@Override
	public BaseCollection<BaseOutPriceListItem> executeQuery( KeyValuePair[] replacements, ConditionOutPriceListItem condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getInfoCode(), 
				condition.getOutQuotationId()
			);
	}

	@Override
	public BaseOutPriceListItem generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOutPriceListItem __base = new BaseOutPriceListItem();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setOutDesignConsiderationId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainDesignAreaName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDecorationStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDesignUnitPrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSubContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setJobMix(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setServiceArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setWithTheAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOnSiteTime(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOnSitePrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOnSiteTotalMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOrderNo(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDisableType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOutQuotationId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInteriorPrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInteriorMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOptionType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOrderNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOutTempletId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNewCreateQuotationName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFinalizedMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIsHas(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
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

	private final static String __SQLText = "select DISTINCT odc.out_design_consideration_id, odc.info_code, odc.project_code, odc.business_type, odc.project_type, odc.main_design_area_name, odc.decoration_status, odc.design_area, odc.design_unit_price, odc.money_sum, odc.sub_contract_id, odc.job_mix, odc.service_area, odc.with_the_amount, odc.on_site_time, odc.on_site_price, odc.on_site_total_money, odc.create_time, odc.update_time, odc.order_no, odc.disable_type, odc.out_quotation_id, odc.remark, odc.interior_price, odc.interior_money_sum, odc.option_type, odc.employee_id, odc.order_num, odc.out_templet_id, odc.new_create_quotation_name, odc.finalized_money,d.out_design_consideration_id as is_has,odc.type from out_design_considerations odc left join design_considerations d on odc.out_design_consideration_id=d.out_design_consideration_id where odc.info_code=? and odc.out_quotation_id=? order by odc.business_type,odc.option_type " ;
	private final static String RESULTSETFIELDLIST = "out_design_consideration_id,info_code,project_code,business_type,project_type,main_design_area_name,decoration_status,design_area,design_unit_price,money_sum,sub_contract_id,job_mix,service_area,with_the_amount,on_site_time,on_site_price,on_site_total_money,create_time,update_time,order_no,disable_type,out_quotation_id,remark,interior_price,interior_money_sum,option_type,employee_id,order_num,out_templet_id,new_create_quotation_name,finalized_money,is_has";
	private final static String[] fieldNames = { "info_code", "out_quotation_id"};
}
