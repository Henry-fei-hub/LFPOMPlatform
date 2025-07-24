package pomplatform.cwd.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionWorkplacePublicIPManage extends GenericCondition{

	public ConditionWorkplacePublicIPManage(){
		setParameterCount(3);
	}

	public java.lang.Boolean getActive() {
		return this.__active;
	}

	public void setActive( java.lang.Boolean value ) {
		this.__active = value;
	}

	public java.lang.Integer getCompanyWorkplaceId() {
		return this.__company_workplace_id;
	}

	public void setCompanyWorkplaceId( java.lang.Integer value ) {
		this.__company_workplace_id = value;
	}

	public java.lang.String getIpAddress() {
		return this.__ip_address == null ? null : (this.__ip_address.indexOf("%") >= 0 ? this.__ip_address : "%"+this.__ip_address+"%");
	}

	public void setIpAddress( java.lang.String value ) {
		this.__ip_address = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getActive() != null) sb.append(__wrapBoolean(1, "active", getActive()));
		if(getCompanyWorkplaceId() != null) sb.append(__wrapNumber(1, "companyWorkplaceId", getCompanyWorkplaceId()));
		if(getIpAddress() != null) sb.append(__wrapString(1, "ipAddress", getIpAddress()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("active")) != null) setActive(__getBoolean(val));
		if((val = values.get("companyWorkplaceId")) != null) setCompanyWorkplaceId(__getInt(val)); 
		if((val = values.get("ipAddress")) != null) setIpAddress(__getString(val));
	}

	private java.lang.Boolean __active = null;
	private java.lang.Integer __company_workplace_id = null;
	private java.lang.String __ip_address = null;
}

