package pomplatform.cwd.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionCompanyWorkplaceAndServerManage extends GenericCondition{

	public ConditionCompanyWorkplaceAndServerManage(){
		setParameterCount(6);
	}

	public java.lang.String getWorkplaceName() {
		return this.__workplace_name == null ? null : (this.__workplace_name.indexOf("%") >= 0 ? this.__workplace_name : "%"+this.__workplace_name+"%");
	}

	public void setWorkplaceName( java.lang.String value ) {
		this.__workplace_name = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getCountryId() {
		return this.__country_id;
	}

	public void setCountryId( java.lang.Integer value ) {
		this.__country_id = value;
	}

	public java.lang.Integer getProvinceId() {
		return this.__province_id;
	}

	public void setProvinceId( java.lang.Integer value ) {
		this.__province_id = value;
	}

	public java.lang.Integer getCityId() {
		return this.__city_id;
	}

	public void setCityId( java.lang.Integer value ) {
		this.__city_id = value;
	}

	public java.lang.Boolean getActive() {
		return this.__active;
	}

	public void setActive( java.lang.Boolean value ) {
		this.__active = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getWorkplaceName() != null) sb.append(__wrapString(1, "workplaceName", getWorkplaceName()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getCountryId() != null) sb.append(__wrapNumber(1, "countryId", getCountryId()));
		if(getProvinceId() != null) sb.append(__wrapNumber(1, "provinceId", getProvinceId()));
		if(getCityId() != null) sb.append(__wrapNumber(1, "cityId", getCityId()));
		if(getActive() != null) sb.append(__wrapBoolean(1, "active", getActive()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("workplaceName")) != null) setWorkplaceName(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("countryId")) != null) setCountryId(__getInt(val)); 
		if((val = values.get("provinceId")) != null) setProvinceId(__getInt(val)); 
		if((val = values.get("cityId")) != null) setCityId(__getInt(val)); 
		if((val = values.get("active")) != null) setActive(__getBoolean(val));
	}

	private java.lang.String __workplace_name = null;
	private java.lang.Integer __company_id = null;
	private java.lang.Integer __country_id = null;
	private java.lang.Integer __province_id = null;
	private java.lang.Integer __city_id = null;
	private java.lang.Boolean __active = null;
}

