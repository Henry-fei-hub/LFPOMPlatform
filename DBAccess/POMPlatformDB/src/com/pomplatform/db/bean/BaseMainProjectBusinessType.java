package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMainProjectBusinessType extends GenericBase implements BaseFactory<BaseMainProjectBusinessType>, Comparable<BaseMainProjectBusinessType> 
{


	public static BaseMainProjectBusinessType newInstance(){
		return new BaseMainProjectBusinessType();
	}

	@Override
	public BaseMainProjectBusinessType make(){
		BaseMainProjectBusinessType b = new BaseMainProjectBusinessType();
		return b;
	}

	public final static java.lang.String CS_MAIN_PROJECT_BUSINESS_TYPE_ID = "main_project_business_type_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_PRE_PROJECT_ID = "pre_project_id" ;
	public final static java.lang.String CS_AREA = "area" ;
	public final static java.lang.String CS_OUTPUT_VALUE = "output_value" ;
	public final static java.lang.String CS_OUT_QUOTATION_ID = "out_quotation_id" ;
	public final static java.lang.String CS_STATUS = "status" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,前期项目id,业务类别,前期项目id,面积,产值,报价单id,状态  0普通状态  1报价单审批中  2报价单审批成功";

	public java.lang.Integer getMainProjectBusinessTypeId() {
		return this.__main_project_business_type_id;
	}

	public void setMainProjectBusinessTypeId( java.lang.Integer value ) {
		this.__main_project_business_type_id = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	public java.lang.Integer getPreProjectId() {
		return this.__pre_project_id;
	}

	public void setPreProjectId( java.lang.Integer value ) {
		this.__pre_project_id = value;
	}

	public java.math.BigDecimal getArea() {
		return this.__area;
	}

	public void setArea( java.math.BigDecimal value ) {
		this.__area = value;
	}

	public java.math.BigDecimal getOutputValue() {
		return this.__output_value;
	}

	public void setOutputValue( java.math.BigDecimal value ) {
		this.__output_value = value;
	}

	public java.lang.Integer getOutQuotationId() {
		return this.__out_quotation_id;
	}

	public void setOutQuotationId( java.lang.Integer value ) {
		this.__out_quotation_id = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public void cloneCopy(BaseMainProjectBusinessType __bean){
		__bean.setMainProjectBusinessTypeId(getMainProjectBusinessTypeId());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setBusinessType(getBusinessType());
		__bean.setPreProjectId(getPreProjectId());
		__bean.setArea(getArea());
		__bean.setOutputValue(getOutputValue());
		__bean.setOutQuotationId(getOutQuotationId());
		__bean.setStatus(getStatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMainProjectBusinessTypeId() == null ? "" : getMainProjectBusinessTypeId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType());
		sb.append(",");
		sb.append(getPreProjectId() == null ? "" : getPreProjectId());
		sb.append(",");
		sb.append(getArea() == null ? "" : getArea());
		sb.append(",");
		sb.append(getOutputValue() == null ? "" : getOutputValue());
		sb.append(",");
		sb.append(getOutQuotationId() == null ? "" : getOutQuotationId());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMainProjectBusinessType o) {
		return __main_project_business_type_id == null ? -1 : __main_project_business_type_id.compareTo(o.getMainProjectBusinessTypeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__main_project_business_type_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__pre_project_id);
		hash = 97 * hash + Objects.hashCode(this.__area);
		hash = 97 * hash + Objects.hashCode(this.__output_value);
		hash = 97 * hash + Objects.hashCode(this.__out_quotation_id);
		hash = 97 * hash + Objects.hashCode(this.__status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMainProjectBusinessType o = (BaseMainProjectBusinessType)obj;
		if(!Objects.equals(this.__main_project_business_type_id, o.getMainProjectBusinessTypeId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__pre_project_id, o.getPreProjectId())) return false;
		if(!Objects.equals(this.__area, o.getArea())) return false;
		if(!Objects.equals(this.__output_value, o.getOutputValue())) return false;
		if(!Objects.equals(this.__out_quotation_id, o.getOutQuotationId())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMainProjectBusinessTypeId() != null) sb.append(__wrapNumber(count++, "mainProjectBusinessTypeId", getMainProjectBusinessTypeId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getBusinessType() != null) sb.append(__wrapNumber(count++, "businessType", getBusinessType()));
		if(getPreProjectId() != null) sb.append(__wrapNumber(count++, "preProjectId", getPreProjectId()));
		if(getArea() != null) sb.append(__wrapDecimal(count++, "area", getArea()));
		if(getOutputValue() != null) sb.append(__wrapDecimal(count++, "outputValue", getOutputValue()));
		if(getOutQuotationId() != null) sb.append(__wrapNumber(count++, "outQuotationId", getOutQuotationId()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMainProjectBusinessTypeId() != null) res.put("mainProjectBusinessTypeId", getMainProjectBusinessTypeId());
		if(getMainProjectId() != null) res.put("mainProjectId", getMainProjectId());
		if(getBusinessType() != null) res.put("businessType", getBusinessType());
		if(getPreProjectId() != null) res.put("preProjectId", getPreProjectId());
		if(getArea() != null) res.put("area", getArea());
		if(getOutputValue() != null) res.put("outputValue", getOutputValue());
		if(getOutQuotationId() != null) res.put("outQuotationId", getOutQuotationId());
		if(getStatus() != null) res.put("status", getStatus());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("mainProjectBusinessTypeId")) != null) setMainProjectBusinessTypeId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("preProjectId")) != null) setPreProjectId(__getInt(val)); 
		if((val = values.get("area")) != null) setArea(__getDecimal(val));  
		if((val = values.get("outputValue")) != null) setOutputValue(__getDecimal(val));  
		if((val = values.get("outQuotationId")) != null) setOutQuotationId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
	}

	protected java.lang.Integer  __main_project_business_type_id ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Integer  __business_type ;
	protected java.lang.Integer  __pre_project_id ;
	protected java.math.BigDecimal  __area ;
	protected java.math.BigDecimal  __output_value ;
	protected java.lang.Integer  __out_quotation_id ;
	protected java.lang.Integer  __status ;
}
