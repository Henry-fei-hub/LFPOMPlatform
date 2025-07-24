package pomplatform.rmimburseementinvoice.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMreimbursementinvoiceinformationrsrmmpror extends GenericCondition{

	public ConditionMreimbursementinvoiceinformationrsrmmpror(){
		setParameterCount(5);
	}

	public java.util.Date getMinCompleteTime() {
		return this.__min_complete_time;
	}

	public void setMinCompleteTime( java.util.Date value ) {
		this.__min_complete_time = value;
	}

	public java.util.Date getMaxCompleteTime() {
		return this.__max_complete_time;
	}

	public void setMaxCompleteTime( java.util.Date value ) {
		this.__max_complete_time = value;
	}

	public java.lang.String getPackageCode() {
		return this.__package_code == null ? null : (this.__package_code.indexOf("%") >= 0 ? this.__package_code : "%"+this.__package_code+"%");
	}

	public void setPackageCode( java.lang.String value ) {
		this.__package_code = value;
	}

	public java.lang.String getRmiCode() {
		return this.__rmi_code == null ? null : (this.__rmi_code.indexOf("%") >= 0 ? this.__rmi_code : "%"+this.__rmi_code+"%");
	}

	public void setRmiCode( java.lang.String value ) {
		this.__rmi_code = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMinCompleteTime() != null) sb.append(__wrapDate(1, "minCompleteTime", getMinCompleteTime()));
		if(getMaxCompleteTime() != null) sb.append(__wrapDate(1, "maxCompleteTime", getMaxCompleteTime()));
		if(getPackageCode() != null) sb.append(__wrapString(1, "packageCode", getPackageCode()));
		if(getRmiCode() != null) sb.append(__wrapString(1, "rmiCode", getRmiCode()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("minCompleteTime")) != null) setMinCompleteTime(__getDate(val)); 
		if((val = values.get("maxCompleteTime")) != null) setMaxCompleteTime(__getDate(val)); 
		if((val = values.get("packageCode")) != null) setPackageCode(__getString(val));
		if((val = values.get("rmiCode")) != null) setRmiCode(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
	}

	private java.util.Date __min_complete_time = null;
	private java.util.Date __max_complete_time = null;
	private java.lang.String __package_code = null;
	private java.lang.String __rmi_code = null;
	private java.lang.Integer __company_id = null;
}

