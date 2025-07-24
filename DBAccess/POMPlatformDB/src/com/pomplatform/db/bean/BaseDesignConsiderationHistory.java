package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseDesignConsiderationHistory extends GenericBase implements BaseFactory<BaseDesignConsiderationHistory>, Comparable<BaseDesignConsiderationHistory> 
{


	public static BaseDesignConsiderationHistory newInstance(){
		return new BaseDesignConsiderationHistory();
	}

	@Override
	public BaseDesignConsiderationHistory make(){
		BaseDesignConsiderationHistory b = new BaseDesignConsiderationHistory();
		return b;
	}

	public final static java.lang.String CS_DESIGN_CONSIDERATION_HISTORY_ID = "design_consideration_history_id" ;
	public final static java.lang.String CS_HISTORY_STATUS = "history_status" ;
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
	public final static java.lang.String CS_MOVE_TIME = "move_time" ;
	public final static java.lang.String CS_ORDER_NO = "order_no" ;
	public final static java.lang.String CS_HISTORY_VERSION = "history_version" ;

	public final static java.lang.String ALL_CAPTIONS = "设计要素编码,0 以往版本,信息编号,项目编号,业务类型,项目类型,区域,精简装状态   0精装    1简装,设计面积,设计单价,小计 设计面积总金额,子订单编码,现场配合,服务面积,配合金额,驻场时间(月),驻场价格(元/月),驻场总金额(元),创建时间,提交时间,标记补充协议字段；除0之外，其他都表示第n个补充协议,提交报价单的版本号";

	public java.lang.Integer getDesignConsiderationHistoryId() {
		return this.__design_consideration_history_id;
	}

	public void setDesignConsiderationHistoryId( java.lang.Integer value ) {
		this.__design_consideration_history_id = value;
	}

	public java.lang.Integer getHistoryStatus() {
		return this.__history_status;
	}

	public void setHistoryStatus( java.lang.Integer value ) {
		this.__history_status = value;
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

	public java.util.Date getMoveTime() {
		return this.__move_time;
	}

	public void setMoveTime( java.util.Date value ) {
		this.__move_time = value;
	}

	public java.lang.Integer getOrderNo() {
		return this.__order_no;
	}

	public void setOrderNo( java.lang.Integer value ) {
		this.__order_no = value;
	}

	public java.lang.Integer getHistoryVersion() {
		return this.__history_version;
	}

	public void setHistoryVersion( java.lang.Integer value ) {
		this.__history_version = value;
	}

	public void cloneCopy(BaseDesignConsiderationHistory __bean){
		__bean.setDesignConsiderationHistoryId(getDesignConsiderationHistoryId());
		__bean.setHistoryStatus(getHistoryStatus());
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
		__bean.setMoveTime(getMoveTime());
		__bean.setOrderNo(getOrderNo());
		__bean.setHistoryVersion(getHistoryVersion());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getDesignConsiderationHistoryId() == null ? "" : getDesignConsiderationHistoryId());
		sb.append(",");
		sb.append(getHistoryStatus() == null ? "" : getHistoryStatus());
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
		sb.append(getMoveTime() == null ? "" : sdf.format(getMoveTime()));
		sb.append(",");
		sb.append(getOrderNo() == null ? "" : getOrderNo());
		sb.append(",");
		sb.append(getHistoryVersion() == null ? "" : getHistoryVersion());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseDesignConsiderationHistory o) {
		return __design_consideration_history_id == null ? -1 : __design_consideration_history_id.compareTo(o.getDesignConsiderationHistoryId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__design_consideration_history_id);
		hash = 97 * hash + Objects.hashCode(this.__history_status);
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
		hash = 97 * hash + Objects.hashCode(this.__move_time);
		hash = 97 * hash + Objects.hashCode(this.__order_no);
		hash = 97 * hash + Objects.hashCode(this.__history_version);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseDesignConsiderationHistory o = (BaseDesignConsiderationHistory)obj;
		if(!Objects.equals(this.__design_consideration_history_id, o.getDesignConsiderationHistoryId())) return false;
		if(!Objects.equals(this.__history_status, o.getHistoryStatus())) return false;
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
		if(!Objects.equals(this.__move_time, o.getMoveTime())) return false;
		if(!Objects.equals(this.__order_no, o.getOrderNo())) return false;
		if(!Objects.equals(this.__history_version, o.getHistoryVersion())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDesignConsiderationHistoryId() != null) sb.append(__wrapNumber(count++, "designConsiderationHistoryId", getDesignConsiderationHistoryId()));
		if(getHistoryStatus() != null) sb.append(__wrapNumber(count++, "historyStatus", getHistoryStatus()));
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
		if(getMoveTime() != null) sb.append(__wrapDate(count++, "moveTime", getMoveTime()));
		if(getOrderNo() != null) sb.append(__wrapNumber(count++, "orderNo", getOrderNo()));
		if(getHistoryVersion() != null) sb.append(__wrapNumber(count++, "historyVersion", getHistoryVersion()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("designConsiderationHistoryId")) != null) setDesignConsiderationHistoryId(__getInt(val)); 
		if((val = values.get("historyStatus")) != null) setHistoryStatus(__getInt(val)); 
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
		if((val = values.get("moveTime")) != null) setMoveTime(__getDate(val)); 
		if((val = values.get("orderNo")) != null) setOrderNo(__getInt(val)); 
		if((val = values.get("historyVersion")) != null) setHistoryVersion(__getInt(val)); 
	}

	protected java.lang.Integer  __design_consideration_history_id ;
	protected java.lang.Integer  __history_status ;
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
	protected java.util.Date  __move_time ;
	protected java.lang.Integer  __order_no ;
	protected java.lang.Integer  __history_version ;
}
