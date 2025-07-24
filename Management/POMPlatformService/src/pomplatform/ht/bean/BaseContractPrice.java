package pomplatform.ht.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseContractPrice extends GenericBase implements BaseFactory<BaseContractPrice>, Comparable<BaseContractPrice> 
{


	public static BaseContractPrice newInstance(){
		return new BaseContractPrice();
	}

	@Override
	public BaseContractPrice make(){
		BaseContractPrice b = new BaseContractPrice();
		return b;
	}

	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_MAIN_PROJECT_STAGE_ID = "main_project_stage_id" ;
	public final static java.lang.String CS_CUSTOMER_ID = "customer_id" ;
	public final static java.lang.String CS_PARENT_NAME = "parent_name" ;
	public final static java.lang.String CS_CLIENT_ID = "client_id" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_MAIN_DESIGN_AREA_NAME = "main_design_area_name" ;
	public final static java.lang.String CS_DESIGN_AREA = "design_area" ;
	public final static java.lang.String CS_DESIGN_UNIT_PRICE = "design_unit_price" ;
	public final static java.lang.String CS_MONEY_SUM = "money_sum" ;

	public final static String ALL_CAPTIONS = "项目编号,项目名称,立项类型,集团名称,客户名称,业务类别,面积,单价,总价";

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.Integer getMainProjectStageId() {
		return this.__main_project_stage_id;
	}

	public void setMainProjectStageId( java.lang.Integer value ) {
		this.__main_project_stage_id = value;
	}

	public java.lang.Integer getCustomerId() {
		return this.__customer_id;
	}

	public void setCustomerId( java.lang.Integer value ) {
		this.__customer_id = value;
	}

	public java.lang.String getParentName() {
		return this.__parent_name;
	}

	public void setParentName( java.lang.String value ) {
		this.__parent_name = value;
	}

	public java.lang.Integer getClientId() {
		return this.__client_id;
	}

	public void setClientId( java.lang.Integer value ) {
		this.__client_id = value;
	}

	public java.lang.String getCustomerName() {
		return this.__customer_name;
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
	}

	public java.lang.String getMainDesignAreaName() {
		return this.__main_design_area_name;
	}

	public void setMainDesignAreaName( java.lang.String value ) {
		this.__main_design_area_name = value;
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

	public void cloneCopy(BaseContractPrice __bean){
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setMainProjectStageId(getMainProjectStageId());
		__bean.setCustomerId(getCustomerId());
		__bean.setParentName(getParentName());
		__bean.setClientId(getClientId());
		__bean.setCustomerName(getCustomerName());
		__bean.setMainDesignAreaName(getMainDesignAreaName());
		__bean.setDesignArea(getDesignArea());
		__bean.setDesignUnitPrice(getDesignUnitPrice());
		__bean.setMoneySum(getMoneySum());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		String mainProjectStages = delicacy.system.executor.SelectValueCache.getSelectValue("main_project_stages", String.valueOf(getMainProjectStageId()));
		sb.append(mainProjectStages == null ? "" : mainProjectStages);
		sb.append(",");
//		sb.append(getClientId() == null ? "" : getClientId());
//		sb.append(",");
		sb.append(getParentName() == null ? "" : getParentName());
		sb.append(",");
		String CustomerName = delicacy.system.executor.SelectValueCache.getSelectValue("customers_name", String.valueOf(getCustomerName()));
		sb.append(getCustomerName() == null ? "" : getCustomerName());
		sb.append(",");
		sb.append(getMainDesignAreaName() == null ? "" : getMainDesignAreaName());
		sb.append(",");
		sb.append(getDesignArea() == null ? "" : getDesignArea());
		sb.append(",");
		sb.append(getDesignUnitPrice() == null ? "" : getDesignUnitPrice());
		sb.append(",");
		sb.append(getMoneySum() == null ? "" : getMoneySum());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractPrice o) {
		return __project_code == null ? -1 : __project_code.compareTo(o.getProjectCode());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__main_project_stage_id);
		hash = 97 * hash + Objects.hashCode(this.__customer_id);
		hash = 97 * hash + Objects.hashCode(this.__parent_name);
		hash = 97 * hash + Objects.hashCode(this.__client_id);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__main_design_area_name);
		hash = 97 * hash + Objects.hashCode(this.__design_area);
		hash = 97 * hash + Objects.hashCode(this.__design_unit_price);
		hash = 97 * hash + Objects.hashCode(this.__money_sum);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractPrice o = (BaseContractPrice)obj;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__main_project_stage_id, o.getMainProjectStageId())) return false;
		if(!Objects.equals(this.__customer_id, o.getCustomerId())) return false;
		if(!Objects.equals(this.__parent_name, o.getParentName())) return false;
		if(!Objects.equals(this.__client_id, o.getClientId())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__main_design_area_name, o.getMainDesignAreaName())) return false;
		if(!Objects.equals(this.__design_area, o.getDesignArea())) return false;
		if(!Objects.equals(this.__design_unit_price, o.getDesignUnitPrice())) return false;
		if(!Objects.equals(this.__money_sum, o.getMoneySum())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getMainProjectStageId() != null) sb.append(__wrapNumber(count++, "mainProjectStageId", getMainProjectStageId()));
		if(getCustomerId() != null) sb.append(__wrapNumber(count++, "customerId", getCustomerId()));
		if(getParentName() != null) sb.append(__wrapString(count++, "parentName", getParentName()));
		if(getClientId() != null) sb.append(__wrapNumber(count++, "clientId", getClientId()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getMainDesignAreaName() != null) sb.append(__wrapString(count++, "mainDesignAreaName", getMainDesignAreaName()));
		if(getDesignArea() != null) sb.append(__wrapDecimal(count++, "designArea", getDesignArea()));
		if(getDesignUnitPrice() != null) sb.append(__wrapDecimal(count++, "designUnitPrice", getDesignUnitPrice()));
		if(getMoneySum() != null) sb.append(__wrapDecimal(count++, "moneySum", getMoneySum()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProjectCode() != null) res.put("projectCode", getProjectCode());
		if(getProjectName() != null) res.put("projectName", getProjectName());
		if(getMainProjectStageId() != null) res.put("mainProjectStageId", getMainProjectStageId());
		if(getCustomerId() != null) res.put("customerId", getCustomerId());
		if(getParentName() != null) res.put("parentName", getParentName());
		if(getClientId() != null) res.put("clientId", getClientId());
		if(getCustomerName() != null) res.put("customerName", getCustomerName());
		if(getMainDesignAreaName() != null) res.put("mainDesignAreaName", getMainDesignAreaName());
		if(getDesignArea() != null) res.put("designArea", getDesignArea());
		if(getDesignUnitPrice() != null) res.put("designUnitPrice", getDesignUnitPrice());
		if(getMoneySum() != null) res.put("moneySum", getMoneySum());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("mainProjectStageId")) != null) setMainProjectStageId(__getInt(val)); 
		if((val = values.get("clientId")) != null) setClientId(__getInt(val)); 
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("mainDesignAreaName")) != null) setMainDesignAreaName(__getString(val));
		if((val = values.get("designArea")) != null) setDesignArea(__getDecimal(val));  
		if((val = values.get("designUnitPrice")) != null) setDesignUnitPrice(__getDecimal(val));  
		if((val = values.get("moneySum")) != null) setMoneySum(__getDecimal(val));  
	}

	protected java.lang.String  __project_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.Integer  __main_project_stage_id ;
	protected java.lang.Integer  __customer_id ;
	protected java.lang.String  __parent_name ;
	protected java.lang.Integer  __client_id ;
	protected java.lang.String  __customer_name ;
	protected java.lang.String  __main_design_area_name ;
	protected java.math.BigDecimal  __design_area ;
	protected java.math.BigDecimal  __design_unit_price ;
	protected java.math.BigDecimal  __money_sum ;
}
