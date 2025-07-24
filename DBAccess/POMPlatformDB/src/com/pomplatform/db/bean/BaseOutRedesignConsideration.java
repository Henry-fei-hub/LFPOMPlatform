package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseOutRedesignConsideration extends GenericBase implements BaseFactory<BaseOutRedesignConsideration>, Comparable<BaseOutRedesignConsideration> 
{


	public static BaseOutRedesignConsideration newInstance(){
		return new BaseOutRedesignConsideration();
	}

	@Override
	public BaseOutRedesignConsideration make(){
		BaseOutRedesignConsideration b = new BaseOutRedesignConsideration();
		return b;
	}

	public final static java.lang.String CS_OUT_REDESIGN_CONSIDERATION_ID = "out_redesign_consideration_id" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_MAIN_DESIGN_AREA_NAME = "main_design_area_name" ;
	public final static java.lang.String CS_DECORATION_STATUS = "decoration_status" ;
	public final static java.lang.String CS_DESIGN_AREA = "design_area" ;
	public final static java.lang.String CS_DESIGN_UNIT_PRICE = "design_unit_price" ;
	public final static java.lang.String CS_MONEY_SUM = "money_sum" ;
	public final static java.lang.String CS_SUB_CONTRACT_ID = "sub_contract_id" ;
	public final static java.lang.String CS_JOB_MIX = "job_mix" ;
	public final static java.lang.String CS_SERVICE_AREA = "service_area" ;
	public final static java.lang.String CS_WITH_THE_AMOUNT = "with_the_amount" ;
	public final static java.lang.String CS_ON_SITE_TIME = "on_site_time" ;
	public final static java.lang.String CS_ON_SITE_PRICE = "on_site_price" ;
	public final static java.lang.String CS_ON_SITE_TOTAL_MONEY = "on_site_total_money" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;
	public final static java.lang.String CS_ORDER_NO = "order_no" ;
	public final static java.lang.String CS_DISABLE_TYPE = "disable_type" ;
	public final static java.lang.String CS_OUT_QUOTATION_ID = "out_quotation_id" ;
	public final static java.lang.String CS_INTERIOR_PRICE = "interior_price" ;
	public final static java.lang.String CS_INTERIOR_MONEY_SUM = "interior_money_sum" ;
	public final static java.lang.String CS_OPTION_TYPE = "option_type" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "报价单子项编码,信息编号,项目编号,业务类型,项目类型,区域,精简装状态   0精装    1简装,设计面积,设计单价,小计 设计面积总金额,子合同编码,现场配合,服务面积,配合金额,驻场时间(月),驻场价格(元/月),驻场总金额(元),创建时间,修改时间,标记补充协议字段；除0之外，其他都表示第n个补充协议,可操作状态 0可操作,1禁止操作,报价单表编码,内部单价,内部设计面积总金额,专项标示为1,子项标示2,备注";

	public java.lang.Integer getOutRedesignConsiderationId() {
		return this.__out_redesign_consideration_id;
	}

	public void setOutRedesignConsiderationId( java.lang.Integer value ) {
		this.__out_redesign_consideration_id = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
	}

	public java.lang.String getMainDesignAreaName() {
		return this.__main_design_area_name;
	}

	public void setMainDesignAreaName( java.lang.String value ) {
		this.__main_design_area_name = value;
	}

	public java.lang.Integer getDecorationStatus() {
		return this.__decoration_status;
	}

	public void setDecorationStatus( java.lang.Integer value ) {
		this.__decoration_status = value;
	}

	public java.math.BigDecimal getDesignArea() {
		return this.__design_area;
	}

	public void setDesignArea( java.math.BigDecimal value ) {
		this.__design_area = value;
	}

	public java.math.BigDecimal getDesignUnitPrice() {
		return this.__design_unit_price;
	}

	public void setDesignUnitPrice( java.math.BigDecimal value ) {
		this.__design_unit_price = value;
	}

	public java.math.BigDecimal getMoneySum() {
		return this.__money_sum;
	}

	public void setMoneySum( java.math.BigDecimal value ) {
		this.__money_sum = value;
	}

	public java.lang.Integer getSubContractId() {
		return this.__sub_contract_id;
	}

	public void setSubContractId( java.lang.Integer value ) {
		this.__sub_contract_id = value;
	}

	public java.lang.Integer getJobMix() {
		return this.__job_mix;
	}

	public void setJobMix( java.lang.Integer value ) {
		this.__job_mix = value;
	}

	public java.math.BigDecimal getServiceArea() {
		return this.__service_area;
	}

	public void setServiceArea( java.math.BigDecimal value ) {
		this.__service_area = value;
	}

	public java.math.BigDecimal getWithTheAmount() {
		return this.__with_the_amount;
	}

	public void setWithTheAmount( java.math.BigDecimal value ) {
		this.__with_the_amount = value;
	}

	public java.lang.Integer getOnSiteTime() {
		return this.__on_site_time;
	}

	public void setOnSiteTime( java.lang.Integer value ) {
		this.__on_site_time = value;
	}

	public java.math.BigDecimal getOnSitePrice() {
		return this.__on_site_price;
	}

	public void setOnSitePrice( java.math.BigDecimal value ) {
		this.__on_site_price = value;
	}

	public java.math.BigDecimal getOnSiteTotalMoney() {
		return this.__on_site_total_money;
	}

	public void setOnSiteTotalMoney( java.math.BigDecimal value ) {
		this.__on_site_total_money = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getUpdateTime() {
		return this.__update_time;
	}

	public void setUpdateTime( java.util.Date value ) {
		this.__update_time = value;
	}

	public java.lang.Integer getOrderNo() {
		return this.__order_no;
	}

	public void setOrderNo( java.lang.Integer value ) {
		this.__order_no = value;
	}

	public java.lang.Integer getDisableType() {
		return this.__disable_type;
	}

	public void setDisableType( java.lang.Integer value ) {
		this.__disable_type = value;
	}

	public java.lang.Integer getOutQuotationId() {
		return this.__out_quotation_id;
	}

	public void setOutQuotationId( java.lang.Integer value ) {
		this.__out_quotation_id = value;
	}

	public java.math.BigDecimal getInteriorPrice() {
		return this.__interior_price;
	}

	public void setInteriorPrice( java.math.BigDecimal value ) {
		this.__interior_price = value;
	}

	public java.math.BigDecimal getInteriorMoneySum() {
		return this.__interior_money_sum;
	}

	public void setInteriorMoneySum( java.math.BigDecimal value ) {
		this.__interior_money_sum = value;
	}

	public java.lang.Integer getOptionType() {
		return this.__option_type;
	}

	public void setOptionType( java.lang.Integer value ) {
		this.__option_type = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseOutRedesignConsideration __bean){
		__bean.setOutRedesignConsiderationId(getOutRedesignConsiderationId());
		__bean.setInfoCode(getInfoCode());
		__bean.setProjectCode(getProjectCode());
		__bean.setBusinessType(getBusinessType());
		__bean.setProjectType(getProjectType());
		__bean.setMainDesignAreaName(getMainDesignAreaName());
		__bean.setDecorationStatus(getDecorationStatus());
		__bean.setDesignArea(getDesignArea());
		__bean.setDesignUnitPrice(getDesignUnitPrice());
		__bean.setMoneySum(getMoneySum());
		__bean.setSubContractId(getSubContractId());
		__bean.setJobMix(getJobMix());
		__bean.setServiceArea(getServiceArea());
		__bean.setWithTheAmount(getWithTheAmount());
		__bean.setOnSiteTime(getOnSiteTime());
		__bean.setOnSitePrice(getOnSitePrice());
		__bean.setOnSiteTotalMoney(getOnSiteTotalMoney());
		__bean.setCreateTime(getCreateTime());
		__bean.setUpdateTime(getUpdateTime());
		__bean.setOrderNo(getOrderNo());
		__bean.setDisableType(getDisableType());
		__bean.setOutQuotationId(getOutQuotationId());
		__bean.setInteriorPrice(getInteriorPrice());
		__bean.setInteriorMoneySum(getInteriorMoneySum());
		__bean.setOptionType(getOptionType());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getOutRedesignConsiderationId() == null ? "" : getOutRedesignConsiderationId());
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		String strBusinessType = delicacy.system.executor.SelectValueCache.getSelectValue("production_value_coefficient_type", String.valueOf(getBusinessType()));
		sb.append(strBusinessType == null ? "" : strBusinessType);
		sb.append(",");
		String strProjectType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_32", String.valueOf(getProjectType()));
		sb.append(strProjectType == null ? "" : strProjectType);
		sb.append(",");
		sb.append(getMainDesignAreaName() == null ? "" : getMainDesignAreaName());
		sb.append(",");
		String strDecorationStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_30", String.valueOf(getDecorationStatus()));
		sb.append(strDecorationStatus == null ? "" : strDecorationStatus);
		sb.append(",");
		sb.append(getDesignArea() == null ? "" : getDesignArea());
		sb.append(",");
		sb.append(getDesignUnitPrice() == null ? "" : getDesignUnitPrice());
		sb.append(",");
		sb.append(getMoneySum() == null ? "" : getMoneySum());
		sb.append(",");
		sb.append(getSubContractId() == null ? "" : getSubContractId());
		sb.append(",");
		sb.append(getJobMix() == null ? "" : getJobMix());
		sb.append(",");
		sb.append(getServiceArea() == null ? "" : getServiceArea());
		sb.append(",");
		sb.append(getWithTheAmount() == null ? "" : getWithTheAmount());
		sb.append(",");
		sb.append(getOnSiteTime() == null ? "" : getOnSiteTime());
		sb.append(",");
		sb.append(getOnSitePrice() == null ? "" : getOnSitePrice());
		sb.append(",");
		sb.append(getOnSiteTotalMoney() == null ? "" : getOnSiteTotalMoney());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		sb.append(",");
		sb.append(getOrderNo() == null ? "" : getOrderNo());
		sb.append(",");
		String strDisableType = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getDisableType()));
		sb.append(strDisableType == null ? "" : strDisableType);
		sb.append(",");
		sb.append(getOutQuotationId() == null ? "" : getOutQuotationId());
		sb.append(",");
		sb.append(getInteriorPrice() == null ? "" : getInteriorPrice());
		sb.append(",");
		sb.append(getInteriorMoneySum() == null ? "" : getInteriorMoneySum());
		sb.append(",");
		sb.append(getOptionType() == null ? "" : getOptionType());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOutRedesignConsideration o) {
		return __out_redesign_consideration_id == null ? -1 : __out_redesign_consideration_id.compareTo(o.getOutRedesignConsiderationId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__out_redesign_consideration_id);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__main_design_area_name);
		hash = 97 * hash + Objects.hashCode(this.__decoration_status);
		hash = 97 * hash + Objects.hashCode(this.__design_area);
		hash = 97 * hash + Objects.hashCode(this.__design_unit_price);
		hash = 97 * hash + Objects.hashCode(this.__money_sum);
		hash = 97 * hash + Objects.hashCode(this.__sub_contract_id);
		hash = 97 * hash + Objects.hashCode(this.__job_mix);
		hash = 97 * hash + Objects.hashCode(this.__service_area);
		hash = 97 * hash + Objects.hashCode(this.__with_the_amount);
		hash = 97 * hash + Objects.hashCode(this.__on_site_time);
		hash = 97 * hash + Objects.hashCode(this.__on_site_price);
		hash = 97 * hash + Objects.hashCode(this.__on_site_total_money);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		hash = 97 * hash + Objects.hashCode(this.__order_no);
		hash = 97 * hash + Objects.hashCode(this.__disable_type);
		hash = 97 * hash + Objects.hashCode(this.__out_quotation_id);
		hash = 97 * hash + Objects.hashCode(this.__interior_price);
		hash = 97 * hash + Objects.hashCode(this.__interior_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__option_type);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOutRedesignConsideration o = (BaseOutRedesignConsideration)obj;
		if(!Objects.equals(this.__out_redesign_consideration_id, o.getOutRedesignConsiderationId())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__main_design_area_name, o.getMainDesignAreaName())) return false;
		if(!Objects.equals(this.__decoration_status, o.getDecorationStatus())) return false;
		if(!Objects.equals(this.__design_area, o.getDesignArea())) return false;
		if(!Objects.equals(this.__design_unit_price, o.getDesignUnitPrice())) return false;
		if(!Objects.equals(this.__money_sum, o.getMoneySum())) return false;
		if(!Objects.equals(this.__sub_contract_id, o.getSubContractId())) return false;
		if(!Objects.equals(this.__job_mix, o.getJobMix())) return false;
		if(!Objects.equals(this.__service_area, o.getServiceArea())) return false;
		if(!Objects.equals(this.__with_the_amount, o.getWithTheAmount())) return false;
		if(!Objects.equals(this.__on_site_time, o.getOnSiteTime())) return false;
		if(!Objects.equals(this.__on_site_price, o.getOnSitePrice())) return false;
		if(!Objects.equals(this.__on_site_total_money, o.getOnSiteTotalMoney())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		if(!Objects.equals(this.__order_no, o.getOrderNo())) return false;
		if(!Objects.equals(this.__disable_type, o.getDisableType())) return false;
		if(!Objects.equals(this.__out_quotation_id, o.getOutQuotationId())) return false;
		if(!Objects.equals(this.__interior_price, o.getInteriorPrice())) return false;
		if(!Objects.equals(this.__interior_money_sum, o.getInteriorMoneySum())) return false;
		if(!Objects.equals(this.__option_type, o.getOptionType())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getOutRedesignConsiderationId() != null) sb.append(__wrapNumber(count++, "outRedesignConsiderationId", getOutRedesignConsiderationId()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getBusinessType() != null) sb.append(__wrapNumber(count++, "businessType", getBusinessType()));
		if(getProjectType() != null) sb.append(__wrapNumber(count++, "projectType", getProjectType()));
		if(getMainDesignAreaName() != null) sb.append(__wrapString(count++, "mainDesignAreaName", getMainDesignAreaName()));
		if(getDecorationStatus() != null) sb.append(__wrapNumber(count++, "decorationStatus", getDecorationStatus()));
		if(getDesignArea() != null) sb.append(__wrapDecimal(count++, "designArea", getDesignArea()));
		if(getDesignUnitPrice() != null) sb.append(__wrapDecimal(count++, "designUnitPrice", getDesignUnitPrice()));
		if(getMoneySum() != null) sb.append(__wrapDecimal(count++, "moneySum", getMoneySum()));
		if(getSubContractId() != null) sb.append(__wrapNumber(count++, "subContractId", getSubContractId()));
		if(getJobMix() != null) sb.append(__wrapNumber(count++, "jobMix", getJobMix()));
		if(getServiceArea() != null) sb.append(__wrapDecimal(count++, "serviceArea", getServiceArea()));
		if(getWithTheAmount() != null) sb.append(__wrapDecimal(count++, "withTheAmount", getWithTheAmount()));
		if(getOnSiteTime() != null) sb.append(__wrapNumber(count++, "onSiteTime", getOnSiteTime()));
		if(getOnSitePrice() != null) sb.append(__wrapDecimal(count++, "onSitePrice", getOnSitePrice()));
		if(getOnSiteTotalMoney() != null) sb.append(__wrapDecimal(count++, "onSiteTotalMoney", getOnSiteTotalMoney()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		if(getOrderNo() != null) sb.append(__wrapNumber(count++, "orderNo", getOrderNo()));
		if(getDisableType() != null) sb.append(__wrapNumber(count++, "disableType", getDisableType()));
		if(getOutQuotationId() != null) sb.append(__wrapNumber(count++, "outQuotationId", getOutQuotationId()));
		if(getInteriorPrice() != null) sb.append(__wrapDecimal(count++, "interiorPrice", getInteriorPrice()));
		if(getInteriorMoneySum() != null) sb.append(__wrapDecimal(count++, "interiorMoneySum", getInteriorMoneySum()));
		if(getOptionType() != null) sb.append(__wrapNumber(count++, "optionType", getOptionType()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("outRedesignConsiderationId")) != null) setOutRedesignConsiderationId(__getInt(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("mainDesignAreaName")) != null) setMainDesignAreaName(__getString(val));
		if((val = values.get("decorationStatus")) != null) setDecorationStatus(__getInt(val)); 
		if((val = values.get("designArea")) != null) setDesignArea(__getDecimal(val));  
		if((val = values.get("designUnitPrice")) != null) setDesignUnitPrice(__getDecimal(val));  
		if((val = values.get("moneySum")) != null) setMoneySum(__getDecimal(val));  
		if((val = values.get("subContractId")) != null) setSubContractId(__getInt(val)); 
		if((val = values.get("jobMix")) != null) setJobMix(__getInt(val)); 
		if((val = values.get("serviceArea")) != null) setServiceArea(__getDecimal(val));  
		if((val = values.get("withTheAmount")) != null) setWithTheAmount(__getDecimal(val));  
		if((val = values.get("onSiteTime")) != null) setOnSiteTime(__getInt(val)); 
		if((val = values.get("onSitePrice")) != null) setOnSitePrice(__getDecimal(val));  
		if((val = values.get("onSiteTotalMoney")) != null) setOnSiteTotalMoney(__getDecimal(val));  
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
		if((val = values.get("orderNo")) != null) setOrderNo(__getInt(val)); 
		if((val = values.get("disableType")) != null) setDisableType(__getInt(val)); 
		if((val = values.get("outQuotationId")) != null) setOutQuotationId(__getInt(val)); 
		if((val = values.get("interiorPrice")) != null) setInteriorPrice(__getDecimal(val));  
		if((val = values.get("interiorMoneySum")) != null) setInteriorMoneySum(__getDecimal(val));  
		if((val = values.get("optionType")) != null) setOptionType(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __out_redesign_consideration_id ;
	protected java.lang.String  __info_code ;
	protected java.lang.String  __project_code ;
	protected java.lang.Integer  __business_type ;
	protected java.lang.Integer  __project_type ;
	protected java.lang.String  __main_design_area_name ;
	protected java.lang.Integer  __decoration_status ;
	protected java.math.BigDecimal  __design_area ;
	protected java.math.BigDecimal  __design_unit_price ;
	protected java.math.BigDecimal  __money_sum ;
	protected java.lang.Integer  __sub_contract_id ;
	protected java.lang.Integer  __job_mix ;
	protected java.math.BigDecimal  __service_area ;
	protected java.math.BigDecimal  __with_the_amount ;
	protected java.lang.Integer  __on_site_time ;
	protected java.math.BigDecimal  __on_site_price ;
	protected java.math.BigDecimal  __on_site_total_money ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __update_time ;
	protected java.lang.Integer  __order_no ;
	protected java.lang.Integer  __disable_type ;
	protected java.lang.Integer  __out_quotation_id ;
	protected java.math.BigDecimal  __interior_price ;
	protected java.math.BigDecimal  __interior_money_sum ;
	protected java.lang.Integer  __option_type ;
	protected java.lang.String  __remark ;
}
