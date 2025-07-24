package pomplatform.soutdesignconsiderationoor.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSoutdesignconsiderationoor extends GenericBase implements BaseFactory<BaseSoutdesignconsiderationoor>, Comparable<BaseSoutdesignconsiderationoor> 
{


	public static BaseSoutdesignconsiderationoor newInstance(){
		return new BaseSoutdesignconsiderationoor();
	}

	@Override
	public BaseSoutdesignconsiderationoor make(){
		BaseSoutdesignconsiderationoor b = new BaseSoutdesignconsiderationoor();
		return b;
	}

	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code," ;
	public final static java.lang.String CS_OUT_QUOTATION_ID = "out_quotation_id" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_DATA_COUNT = "data_count" ;
	public final static java.lang.String CS_DESIGN_AREA = "design_area" ;
	public final static java.lang.String CS_MONEY_SUM = "money_sum" ;
	public final static java.lang.String CS_INTERIOR_MONEY_SUM = "interior_money_sum" ;
	public final static java.lang.String CS_OUT_TEMPLET_ID = "out_templet_id" ;
	public final static java.lang.String CS_NEW_CREATE_QUOTATION_NAME = "new_create_quotation_name" ;
	public final static java.lang.String CS_FINALIZED_MONEY = "finalized_money" ;
	public final static java.lang.String CS_TYPE = "type" ;
	
	public final static java.lang.String ALL_CAPTIONS = "信息编号,报价单表编码,业务类型,报价单子项数量,设计面积(汇总),总价(设计面积*单价),内部设计面积总金额,模板,报价单标题,最终报价,类型";
	
	public java.lang.String getProjectCode() {
		return this.__project_code;
	}
	
	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.Integer getOutQuotationId() {
		return this.__out_quotation_id;
	}

	public void setOutQuotationId( java.lang.Integer value ) {
		this.__out_quotation_id = value;
	}

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	public java.lang.Long getDataCount() {
		return this.__data_count;
	}

	public void setDataCount( java.lang.Long value ) {
		this.__data_count = value;
	}

	public java.math.BigDecimal getDesignArea() {
		return this.__design_area;
	}

	public void setDesignArea( java.math.BigDecimal value ) {
		this.__design_area = value;
	}

	public java.math.BigDecimal getMoneySum() {
		return this.__money_sum;
	}

	public void setMoneySum( java.math.BigDecimal value ) {
		this.__money_sum = value;
	}

	public java.math.BigDecimal getInteriorMoneySum() {
		return this.__interior_money_sum;
	}

	public void setInteriorMoneySum( java.math.BigDecimal value ) {
		this.__interior_money_sum = value;
	}
	public java.lang.Integer getOutTempletId() {
		return this.__out_templet_id;
	}

	public void setOutTempletId( java.lang.Integer value ) {
		this.__out_templet_id = value;
	}
	
	
	public java.lang.String getNewCreateQuotationName() {
		return __new_create_quotation_name;
	}

	public void setNewCreateQuotationName(java.lang.String __new_create_quotation_name) {
		this.__new_create_quotation_name = __new_create_quotation_name;
	}

	public java.math.BigDecimal getFinalizedMoney(){
		return this.__finalized_money;
	}

	public void setFinalizedMoney( java.math.BigDecimal value ) {
		this.__finalized_money = value;
	}
	
	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}
	public void cloneCopy(BaseSoutdesignconsiderationoor __bean){
		__bean.setInfoCode(getInfoCode());
		__bean.setProjectCode(getProjectCode());
		__bean.setOutQuotationId(getOutQuotationId());
		__bean.setBusinessType(getBusinessType());
		__bean.setDataCount(getDataCount());
		__bean.setDesignArea(getDesignArea());
		__bean.setMoneySum(getMoneySum());
		__bean.setInteriorMoneySum(getInteriorMoneySum());
		__bean.setOutTempletId(getOutTempletId());
		__bean.setNewCreateQuotationName(getNewCreateQuotationName());
		__bean.setFinalizedMoney(getFinalizedMoney());
		__bean.setType(getType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getOutQuotationId() == null ? "" : getOutQuotationId());
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType());
		sb.append(",");
		sb.append(getDataCount() == null ? "" : getDataCount());
		sb.append(",");
		sb.append(getDesignArea() == null ? "" : getDesignArea());
		sb.append(",");
		sb.append(getMoneySum() == null ? "" : getMoneySum());
		sb.append(",");
		sb.append(getInteriorMoneySum() == null ? "" : getInteriorMoneySum());
		sb.append(",");
		sb.append(getOutTempletId() == null ? "" : getOutTempletId());
		sb.append(",");
		sb.append(getNewCreateQuotationName() == null ? "" : getNewCreateQuotationName());
		sb.append(",");
		sb.append(getFinalizedMoney() == null ? "" : getFinalizedMoney());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSoutdesignconsiderationoor o) {
		return __info_code == null ? -1 : __info_code.compareTo(o.getInfoCode());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__out_quotation_id);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__data_count);
		hash = 97 * hash + Objects.hashCode(this.__design_area);
		hash = 97 * hash + Objects.hashCode(this.__money_sum);
		hash = 97 * hash + Objects.hashCode(this.__interior_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__out_templet_id);
		hash = 97 * hash + Objects.hashCode(this.__new_create_quotation_name);
		hash = 97 * hash + Objects.hashCode(this.__finalized_money);
		hash = 97 * hash + Objects.hashCode(this.__type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSoutdesignconsiderationoor o = (BaseSoutdesignconsiderationoor)obj;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__out_quotation_id, o.getOutQuotationId())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__data_count, o.getDataCount())) return false;
		if(!Objects.equals(this.__design_area, o.getDesignArea())) return false;
		if(!Objects.equals(this.__money_sum, o.getMoneySum())) return false;
		if(!Objects.equals(this.__interior_money_sum, o.getInteriorMoneySum())) return false;
		if(!Objects.equals(this.__out_templet_id, o.getOutTempletId())) return false;
		if(!Objects.equals(this.__new_create_quotation_name, o.getNewCreateQuotationName())) return false;
		if(!Objects.equals(this.__finalized_money, o.getFinalizedMoney())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getOutQuotationId() != null) sb.append(__wrapNumber(count++, "outQuotationId", getOutQuotationId()));
		if(getBusinessType() != null) sb.append(__wrapNumber(count++, "businessType", getBusinessType()));
		if(getDataCount() != null) sb.append(__wrapNumber(count++, "dataCount", getDataCount()));
		if(getDesignArea() != null) sb.append(__wrapDecimal(count++, "designArea", getDesignArea()));
		if(getMoneySum() != null) sb.append(__wrapDecimal(count++, "moneySum", getMoneySum()));
		if(getInteriorMoneySum() != null) sb.append(__wrapDecimal(count++, "interiorMoneySum", getInteriorMoneySum()));
		if(getOutTempletId() != null) sb.append(__wrapNumber(count++, "outTempletId", getOutTempletId()));
		if(getNewCreateQuotationName() != null) sb.append(__wrapString(count++, "newCreateQuotationName", getNewCreateQuotationName()));
		if(getFinalizedMoney() != null) sb.append(__wrapDecimal(count++, "finalizedMoney", getFinalizedMoney()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("outQuotationId")) != null) setOutQuotationId(__getInt(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("dataCount")) != null) setDataCount(__getLong(val)); 
		if((val = values.get("designArea")) != null) setDesignArea(__getDecimal(val));  
		if((val = values.get("moneySum")) != null) setMoneySum(__getDecimal(val));  
		if((val = values.get("interiorMoneySum")) != null) setInteriorMoneySum(__getDecimal(val));  
		if((val = values.get("outTempletId")) != null) setOutTempletId(__getInt(val));  
		if((val = values.get("newCreateQuotationName")) != null) setNewCreateQuotationName(__getString(val));
		if((val = values.get("finalizedMoney")) != null) setFinalizedMoney(__getDecimal(val));  
		if((val = values.get("type")) != null) setType(__getInt(val));  
	}

	protected java.lang.String  __info_code ;
	protected java.lang.String  __project_code ;
	protected java.lang.Integer  __out_quotation_id ;
	protected java.lang.Integer  __business_type ;
	protected java.lang.Long  __data_count ;
	protected java.math.BigDecimal  __design_area ;
	protected java.math.BigDecimal  __money_sum ;
	protected java.math.BigDecimal  __interior_money_sum ;
	protected java.lang.Integer  __out_templet_id ;
	protected java.lang.String __new_create_quotation_name;
	protected java.math.BigDecimal __finalized_money;
	protected java.lang.Integer  __type ;
	
}
