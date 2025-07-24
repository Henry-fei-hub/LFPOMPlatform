package pomplatform.reimbursement.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionK3VoucherList extends GenericCondition{

	public ConditionK3VoucherList(){
		setParameterCount(8);
	}

	public java.lang.String getReimbursementPackageCode() {
		return this.__reimbursement_package_code == null ? null : (this.__reimbursement_package_code.indexOf("%") >= 0 ? this.__reimbursement_package_code : "%"+this.__reimbursement_package_code+"%");
	}

	public void setReimbursementPackageCode( java.lang.String value ) {
		this.__reimbursement_package_code = value;
	}

	public java.lang.Boolean getLocked() {
		return this.__locked;
	}

	public void setLocked( java.lang.Boolean value ) {
		this.__locked = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.lang.Boolean getNeedToChange() {
		return this.__need_to_change;
	}

	public void setNeedToChange( java.lang.Boolean value ) {
		this.__need_to_change = value;
	}

	public java.lang.String getSecondaryCode() {
		return this.__secondary_code == null ? null : (this.__secondary_code.indexOf("%") >= 0 ? this.__secondary_code : "%"+this.__secondary_code+"%");
	}

	public void setSecondaryCode( java.lang.String value ) {
		this.__secondary_code = value;
	}

	public java.lang.String getCode() {
		return this.__code == null ? null : (this.__code.indexOf("%") >= 0 ? this.__code : "%"+this.__code+"%");
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
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
		if(getReimbursementPackageCode() != null) sb.append(__wrapString(1, "reimbursementPackageCode", getReimbursementPackageCode()));
		if(getLocked() != null) sb.append(__wrapBoolean(1, "locked", getLocked()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getNeedToChange() != null) sb.append(__wrapBoolean(1, "needToChange", getNeedToChange()));
		if(getSecondaryCode() != null) sb.append(__wrapString(1, "secondaryCode", getSecondaryCode()));
		if(getCode() != null) sb.append(__wrapString(1, "code", getCode()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("reimbursementPackageCode")) != null) setReimbursementPackageCode(__getString(val));
		if((val = values.get("locked")) != null) setLocked(__getBoolean(val));
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("needToChange")) != null) setNeedToChange(__getBoolean(val));
		if((val = values.get("secondaryCode")) != null) setSecondaryCode(__getString(val));
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
	}

	private java.lang.String __reimbursement_package_code = null;
	private java.lang.Boolean __locked = null;
	private java.util.Date __end_date = null;
	private java.util.Date __start_date = null;
	private java.lang.Boolean __need_to_change = null;
	private java.lang.String __secondary_code = null;
	private java.lang.String __code = null;
	private java.lang.Integer __company_id = null;
}

