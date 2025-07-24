package pomplatform.ht.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSsubcontractor extends GenericBase implements BaseFactory<BaseSsubcontractor>, Comparable<BaseSsubcontractor> 
{


	public static BaseSsubcontractor newInstance(){
		return new BaseSsubcontractor();
	}

	@Override
	public BaseSsubcontractor make(){
		BaseSsubcontractor b = new BaseSsubcontractor();
		return b;
	}

	public final static java.lang.String CS_SUB_CONTRACT_ID = "sub_contract_id" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_SUB_CONTRACT_CODE = "sub_contract_code" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_COMMON_AREA = "common_area" ;
	public final static java.lang.String CS_LOGISTICS_AREA = "logistics_area" ;
	public final static java.lang.String CS_MONEY_SUM = "money_sum" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_SUB_CONTRACT_NAME = "sub_contract_name" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;
	public final static java.lang.String CS_DESIGN_AREA = "design_area" ;
	public final static java.lang.String CS_DESIGN_AREA_PRICE = "design_area_price" ;
	public final static java.lang.String CS_JOB_MIX = "job_mix" ;
	public final static java.lang.String CS_SERVICE_AREA = "service_area" ;
	public final static java.lang.String CS_WITH_THE_AMOUNT = "with_the_amount" ;
	public final static java.lang.String CS_ON_SITE_TIME = "on_site_time" ;
	public final static java.lang.String CS_ON_SITE_PRICE = "on_site_price" ;
	public final static java.lang.String CS_ON_SITE_TOTAL_MONEY = "on_site_total_money" ;
	public final static java.lang.String CS_SUBMIT_DATE = "submit_date" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_ORDER_NO = "order_no" ;

	public final static java.lang.String ALL_CAPTIONS = "子合同编码,主订单编码,子订单编号,项目编号,业务类型,项目类型,承接部门,公区面积,后勤面积,总价,创建时间,区域,修改时间,设计面积,设计单价,现场配合,服务面积,配合金额,驻场时间(月),驻场价格 (元/月),驻场总金额 (元),报价单提交时间,信息编号,标记补充协议字段；除0之外，其他都表示第n个补充协议";

	public java.lang.Integer getSubContractId() {
		return this.__sub_contract_id;
	}

	public void setSubContractId( java.lang.Integer value ) {
		this.__sub_contract_id = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.String getSubContractCode() {
		return this.__sub_contract_code;
	}

	public void setSubContractCode( java.lang.String value ) {
		this.__sub_contract_code = value;
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

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.math.BigDecimal getCommonArea() {
		return this.__common_area;
	}

	public void setCommonArea( java.math.BigDecimal value ) {
		this.__common_area = value;
	}

	public java.math.BigDecimal getLogisticsArea() {
		return this.__logistics_area;
	}

	public void setLogisticsArea( java.math.BigDecimal value ) {
		this.__logistics_area = value;
	}

	public java.math.BigDecimal getMoneySum() {
		return this.__money_sum;
	}

	public void setMoneySum( java.math.BigDecimal value ) {
		this.__money_sum = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.String getSubContractName() {
		return this.__sub_contract_name;
	}

	public void setSubContractName( java.lang.String value ) {
		this.__sub_contract_name = value;
	}

	public java.util.Date getUpdateTime() {
		return this.__update_time;
	}

	public void setUpdateTime( java.util.Date value ) {
		this.__update_time = value;
	}

	public java.math.BigDecimal getDesignArea() {
		return this.__design_area;
	}

	public void setDesignArea( java.math.BigDecimal value ) {
		this.__design_area = value;
	}

	public java.math.BigDecimal getDesignAreaPrice() {
		return this.__design_area_price;
	}

	public void setDesignAreaPrice( java.math.BigDecimal value ) {
		this.__design_area_price = value;
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

	public java.util.Date getSubmitDate() {
		return this.__submit_date;
	}

	public void setSubmitDate( java.util.Date value ) {
		this.__submit_date = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.Integer getOrderNo() {
		return this.__order_no;
	}

	public void setOrderNo( java.lang.Integer value ) {
		this.__order_no = value;
	}

	public void cloneCopy(BaseSsubcontractor __bean){
		__bean.setSubContractId(getSubContractId());
		__bean.setParentId(getParentId());
		__bean.setSubContractCode(getSubContractCode());
		__bean.setProjectCode(getProjectCode());
		__bean.setBusinessType(getBusinessType());
		__bean.setProjectType(getProjectType());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setCommonArea(getCommonArea());
		__bean.setLogisticsArea(getLogisticsArea());
		__bean.setMoneySum(getMoneySum());
		__bean.setCreateTime(getCreateTime());
		__bean.setSubContractName(getSubContractName());
		__bean.setUpdateTime(getUpdateTime());
		__bean.setDesignArea(getDesignArea());
		__bean.setDesignAreaPrice(getDesignAreaPrice());
		__bean.setJobMix(getJobMix());
		__bean.setServiceArea(getServiceArea());
		__bean.setWithTheAmount(getWithTheAmount());
		__bean.setOnSiteTime(getOnSiteTime());
		__bean.setOnSitePrice(getOnSitePrice());
		__bean.setOnSiteTotalMoney(getOnSiteTotalMoney());
		__bean.setSubmitDate(getSubmitDate());
		__bean.setInfoCode(getInfoCode());
		__bean.setOrderNo(getOrderNo());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSubContractId() == null ? "" : getSubContractId());
		sb.append(",");
		String strParentId = delicacy.system.executor.SelectValueCache.getSelectValue("project_types", String.valueOf(getParentId()));
		sb.append(strParentId == null ? "" : strParentId);
		sb.append(",");
		sb.append(getSubContractCode() == null ? "" : getSubContractCode());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		String strBusinessType = delicacy.system.executor.SelectValueCache.getSelectValue("production_value_coefficient_type", String.valueOf(getBusinessType()));
		sb.append(strBusinessType == null ? "" : strBusinessType);
		sb.append(",");
		String strProjectType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_32", String.valueOf(getProjectType()));
		sb.append(strProjectType == null ? "" : strProjectType);
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getCommonArea() == null ? "" : getCommonArea());
		sb.append(",");
		sb.append(getLogisticsArea() == null ? "" : getLogisticsArea());
		sb.append(",");
		sb.append(getMoneySum() == null ? "" : getMoneySum());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getSubContractName() == null ? "" : getSubContractName());
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		sb.append(",");
		sb.append(getDesignArea() == null ? "" : getDesignArea());
		sb.append(",");
		sb.append(getDesignAreaPrice() == null ? "" : getDesignAreaPrice());
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
		sb.append(getSubmitDate() == null ? "" : sdf.format(getSubmitDate()));
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getOrderNo() == null ? "" : getOrderNo());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSsubcontractor o) {
		return __sub_contract_id == null ? -1 : __sub_contract_id.compareTo(o.getSubContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__sub_contract_id);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__sub_contract_code);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__common_area);
		hash = 97 * hash + Objects.hashCode(this.__logistics_area);
		hash = 97 * hash + Objects.hashCode(this.__money_sum);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__sub_contract_name);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		hash = 97 * hash + Objects.hashCode(this.__design_area);
		hash = 97 * hash + Objects.hashCode(this.__design_area_price);
		hash = 97 * hash + Objects.hashCode(this.__job_mix);
		hash = 97 * hash + Objects.hashCode(this.__service_area);
		hash = 97 * hash + Objects.hashCode(this.__with_the_amount);
		hash = 97 * hash + Objects.hashCode(this.__on_site_time);
		hash = 97 * hash + Objects.hashCode(this.__on_site_price);
		hash = 97 * hash + Objects.hashCode(this.__on_site_total_money);
		hash = 97 * hash + Objects.hashCode(this.__submit_date);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__order_no);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSsubcontractor o = (BaseSsubcontractor)obj;
		if(!Objects.equals(this.__sub_contract_id, o.getSubContractId())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__sub_contract_code, o.getSubContractCode())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__common_area, o.getCommonArea())) return false;
		if(!Objects.equals(this.__logistics_area, o.getLogisticsArea())) return false;
		if(!Objects.equals(this.__money_sum, o.getMoneySum())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__sub_contract_name, o.getSubContractName())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		if(!Objects.equals(this.__design_area, o.getDesignArea())) return false;
		if(!Objects.equals(this.__design_area_price, o.getDesignAreaPrice())) return false;
		if(!Objects.equals(this.__job_mix, o.getJobMix())) return false;
		if(!Objects.equals(this.__service_area, o.getServiceArea())) return false;
		if(!Objects.equals(this.__with_the_amount, o.getWithTheAmount())) return false;
		if(!Objects.equals(this.__on_site_time, o.getOnSiteTime())) return false;
		if(!Objects.equals(this.__on_site_price, o.getOnSitePrice())) return false;
		if(!Objects.equals(this.__on_site_total_money, o.getOnSiteTotalMoney())) return false;
		if(!Objects.equals(this.__submit_date, o.getSubmitDate())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__order_no, o.getOrderNo())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSubContractId() != null) sb.append(__wrapNumber(count++, "subContractId", getSubContractId()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getSubContractCode() != null) sb.append(__wrapString(count++, "subContractCode", getSubContractCode()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getBusinessType() != null) sb.append(__wrapNumber(count++, "businessType", getBusinessType()));
		if(getProjectType() != null) sb.append(__wrapNumber(count++, "projectType", getProjectType()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getCommonArea() != null) sb.append(__wrapDecimal(count++, "commonArea", getCommonArea()));
		if(getLogisticsArea() != null) sb.append(__wrapDecimal(count++, "logisticsArea", getLogisticsArea()));
		if(getMoneySum() != null) sb.append(__wrapDecimal(count++, "moneySum", getMoneySum()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getSubContractName() != null) sb.append(__wrapString(count++, "subContractName", getSubContractName()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		if(getDesignArea() != null) sb.append(__wrapDecimal(count++, "designArea", getDesignArea()));
		if(getDesignAreaPrice() != null) sb.append(__wrapDecimal(count++, "designAreaPrice", getDesignAreaPrice()));
		if(getJobMix() != null) sb.append(__wrapNumber(count++, "jobMix", getJobMix()));
		if(getServiceArea() != null) sb.append(__wrapDecimal(count++, "serviceArea", getServiceArea()));
		if(getWithTheAmount() != null) sb.append(__wrapDecimal(count++, "withTheAmount", getWithTheAmount()));
		if(getOnSiteTime() != null) sb.append(__wrapNumber(count++, "onSiteTime", getOnSiteTime()));
		if(getOnSitePrice() != null) sb.append(__wrapDecimal(count++, "onSitePrice", getOnSitePrice()));
		if(getOnSiteTotalMoney() != null) sb.append(__wrapDecimal(count++, "onSiteTotalMoney", getOnSiteTotalMoney()));
		if(getSubmitDate() != null) sb.append(__wrapDate(count++, "submitDate", getSubmitDate()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getOrderNo() != null) sb.append(__wrapNumber(count++, "orderNo", getOrderNo()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("subContractId")) != null) setSubContractId(__getInt(val)); 
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("subContractCode")) != null) setSubContractCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("commonArea")) != null) setCommonArea(__getDecimal(val));  
		if((val = values.get("logisticsArea")) != null) setLogisticsArea(__getDecimal(val));  
		if((val = values.get("moneySum")) != null) setMoneySum(__getDecimal(val));  
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("subContractName")) != null) setSubContractName(__getString(val));
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
		if((val = values.get("designArea")) != null) setDesignArea(__getDecimal(val));  
		if((val = values.get("designAreaPrice")) != null) setDesignAreaPrice(__getDecimal(val));  
		if((val = values.get("jobMix")) != null) setJobMix(__getInt(val)); 
		if((val = values.get("serviceArea")) != null) setServiceArea(__getDecimal(val));  
		if((val = values.get("withTheAmount")) != null) setWithTheAmount(__getDecimal(val));  
		if((val = values.get("onSiteTime")) != null) setOnSiteTime(__getInt(val)); 
		if((val = values.get("onSitePrice")) != null) setOnSitePrice(__getDecimal(val));  
		if((val = values.get("onSiteTotalMoney")) != null) setOnSiteTotalMoney(__getDecimal(val));  
		if((val = values.get("submitDate")) != null) setSubmitDate(__getDate(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("orderNo")) != null) setOrderNo(__getInt(val)); 
	}

	protected java.lang.Integer  __sub_contract_id ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.String  __sub_contract_code ;
	protected java.lang.String  __project_code ;
	protected java.lang.Integer  __business_type ;
	protected java.lang.Integer  __project_type ;
	protected java.lang.Integer  __department_id ;
	protected java.math.BigDecimal  __common_area ;
	protected java.math.BigDecimal  __logistics_area ;
	protected java.math.BigDecimal  __money_sum ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __sub_contract_name ;
	protected java.util.Date  __update_time ;
	protected java.math.BigDecimal  __design_area ;
	protected java.math.BigDecimal  __design_area_price ;
	protected java.lang.Integer  __job_mix ;
	protected java.math.BigDecimal  __service_area ;
	protected java.math.BigDecimal  __with_the_amount ;
	protected java.lang.Integer  __on_site_time ;
	protected java.math.BigDecimal  __on_site_price ;
	protected java.math.BigDecimal  __on_site_total_money ;
	protected java.util.Date  __submit_date ;
	protected java.lang.String  __info_code ;
	protected java.lang.Integer  __order_no ;
}
