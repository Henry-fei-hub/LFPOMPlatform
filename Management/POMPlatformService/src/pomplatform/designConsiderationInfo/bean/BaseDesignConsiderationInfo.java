package pomplatform.designConsiderationInfo.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseDesignConsiderationInfo extends GenericBase implements BaseFactory<BaseDesignConsiderationInfo>, Comparable<BaseDesignConsiderationInfo> 
{


	public static BaseDesignConsiderationInfo newInstance(){
		return new BaseDesignConsiderationInfo();
	}

	@Override
	public BaseDesignConsiderationInfo make(){
		BaseDesignConsiderationInfo b = new BaseDesignConsiderationInfo();
		return b;
	}

	public final static java.lang.String CS_DESIGN_CONSIDERATION_ID = "design_consideration_id" ;
	public final static java.lang.String CS_MAIN_DESIGN_AREA_NAME = "main_design_area_name" ;
	public final static java.lang.String CS_SUB_DESIGN_AREA_NAME = "sub_design_area_name" ;
	public final static java.lang.String CS_DECORATION_STATUS = "decoration_status" ;
	public final static java.lang.String CS_DESIGN_AREA = "design_area" ;
	public final static java.lang.String CS_DESIGN_UNIT_PRICE = "design_unit_price" ;
	public final static java.lang.String CS_MONEY_SUM = "money_sum" ;
	public final static java.lang.String CS_SUB_CONTRACT_ID = "sub_contract_id" ;

	public final static java.lang.String ALL_CAPTIONS = "设计要素编码,主设计区域,子设计区域,精简装状态,设计面积,设计单价,小计,子合同编码";

	public java.lang.Integer getDesignConsiderationId() {
		return this.__design_consideration_id;
	}

	public void setDesignConsiderationId( java.lang.Integer value ) {
		this.__design_consideration_id = value;
	}

	public java.lang.String getMainDesignAreaName() {
		return this.__main_design_area_name;
	}

	public void setMainDesignAreaName( java.lang.String value ) {
		this.__main_design_area_name = value;
	}

	public java.lang.String getSubDesignAreaName() {
		return this.__sub_design_area_name;
	}

	public void setSubDesignAreaName( java.lang.String value ) {
		this.__sub_design_area_name = value;
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

	public void cloneCopy(BaseDesignConsiderationInfo __bean){
		__bean.setDesignConsiderationId(getDesignConsiderationId());
		__bean.setMainDesignAreaName(getMainDesignAreaName());
		__bean.setSubDesignAreaName(getSubDesignAreaName());
		__bean.setDecorationStatus(getDecorationStatus());
		__bean.setDesignArea(getDesignArea());
		__bean.setDesignUnitPrice(getDesignUnitPrice());
		__bean.setMoneySum(getMoneySum());
		__bean.setSubContractId(getSubContractId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getDesignConsiderationId() == null ? "" : getDesignConsiderationId());
		sb.append(",");
		sb.append(getMainDesignAreaName() == null ? "" : getMainDesignAreaName());
		sb.append(",");
		sb.append(getSubDesignAreaName() == null ? "" : getSubDesignAreaName());
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
		return sb.toString();
	}

	@Override
	public int compareTo(BaseDesignConsiderationInfo o) {
		return __design_consideration_id == null ? -1 : __design_consideration_id.compareTo(o.getDesignConsiderationId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__design_consideration_id);
		hash = 97 * hash + Objects.hashCode(this.__main_design_area_name);
		hash = 97 * hash + Objects.hashCode(this.__sub_design_area_name);
		hash = 97 * hash + Objects.hashCode(this.__decoration_status);
		hash = 97 * hash + Objects.hashCode(this.__design_area);
		hash = 97 * hash + Objects.hashCode(this.__design_unit_price);
		hash = 97 * hash + Objects.hashCode(this.__money_sum);
		hash = 97 * hash + Objects.hashCode(this.__sub_contract_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseDesignConsiderationInfo o = (BaseDesignConsiderationInfo)obj;
		if(!Objects.equals(this.__design_consideration_id, o.getDesignConsiderationId())) return false;
		if(!Objects.equals(this.__main_design_area_name, o.getMainDesignAreaName())) return false;
		if(!Objects.equals(this.__sub_design_area_name, o.getSubDesignAreaName())) return false;
		if(!Objects.equals(this.__decoration_status, o.getDecorationStatus())) return false;
		if(!Objects.equals(this.__design_area, o.getDesignArea())) return false;
		if(!Objects.equals(this.__design_unit_price, o.getDesignUnitPrice())) return false;
		if(!Objects.equals(this.__money_sum, o.getMoneySum())) return false;
		if(!Objects.equals(this.__sub_contract_id, o.getSubContractId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDesignConsiderationId() != null) sb.append(__wrapNumber(count++, "designConsiderationId", getDesignConsiderationId()));
		if(getMainDesignAreaName() != null) sb.append(__wrapString(count++, "mainDesignAreaName", getMainDesignAreaName()));
		if(getSubDesignAreaName() != null) sb.append(__wrapString(count++, "subDesignAreaName", getSubDesignAreaName()));
		if(getDecorationStatus() != null) sb.append(__wrapNumber(count++, "decorationStatus", getDecorationStatus()));
		if(getDesignArea() != null) sb.append(__wrapDecimal(count++, "designArea", getDesignArea()));
		if(getDesignUnitPrice() != null) sb.append(__wrapDecimal(count++, "designUnitPrice", getDesignUnitPrice()));
		if(getMoneySum() != null) sb.append(__wrapDecimal(count++, "moneySum", getMoneySum()));
		if(getSubContractId() != null) sb.append(__wrapNumber(count++, "subContractId", getSubContractId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("designConsiderationId")) != null) setDesignConsiderationId(__getInt(val)); 
		if((val = values.get("mainDesignAreaName")) != null) setMainDesignAreaName(__getString(val));
		if((val = values.get("subDesignAreaName")) != null) setSubDesignAreaName(__getString(val));
		if((val = values.get("decorationStatus")) != null) setDecorationStatus(__getInt(val)); 
		if((val = values.get("designArea")) != null) setDesignArea(__getDecimal(val));  
		if((val = values.get("designUnitPrice")) != null) setDesignUnitPrice(__getDecimal(val));  
		if((val = values.get("moneySum")) != null) setMoneySum(__getDecimal(val));  
		if((val = values.get("subContractId")) != null) setSubContractId(__getInt(val)); 
	}

	protected java.lang.Integer  __design_consideration_id ;
	protected java.lang.String  __main_design_area_name ;
	protected java.lang.String  __sub_design_area_name ;
	protected java.lang.Integer  __decoration_status ;
	protected java.math.BigDecimal  __design_area ;
	protected java.math.BigDecimal  __design_unit_price ;
	protected java.math.BigDecimal  __money_sum ;
	protected java.lang.Integer  __sub_contract_id ;
}
