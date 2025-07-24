package pomplatform.clientctractor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMclientctractor extends GenericCondition{

	public ConditionMclientctractor(){
		setParameterCount(9);
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getClientName() {
		return this.__client_name == null ? null : (this.__client_name.indexOf("%") >= 0 ? this.__client_name : "%"+this.__client_name+"%");
	}

	public void setClientName( java.lang.String value ) {
		this.__client_name = value;
	}

	public java.lang.String getClientPhone() {
		return this.__client_phone == null ? null : (this.__client_phone.indexOf("%") >= 0 ? this.__client_phone : "%"+this.__client_phone+"%");
	}

	public void setClientPhone( java.lang.String value ) {
		this.__client_phone = value;
	}

	public java.lang.String getClientCompany() {
		return this.__client_company == null ? null : (this.__client_company.indexOf("%") >= 0 ? this.__client_company : "%"+this.__client_company+"%");
	}

	public void setClientCompany( java.lang.String value ) {
		this.__client_company = value;
	}

	public java.lang.String getClientJob() {
		return this.__client_job == null ? null : (this.__client_job.indexOf("%") >= 0 ? this.__client_job : "%"+this.__client_job+"%");
	}

	public void setClientJob( java.lang.String value ) {
		this.__client_job = value;
	}

	public java.lang.String getClientWeixin() {
		return this.__client_weixin == null ? null : (this.__client_weixin.indexOf("%") >= 0 ? this.__client_weixin : "%"+this.__client_weixin+"%");
	}

	public void setClientWeixin( java.lang.String value ) {
		this.__client_weixin = value;
	}

	public java.lang.String getClientQq() {
		return this.__client_qq == null ? null : (this.__client_qq.indexOf("%") >= 0 ? this.__client_qq : "%"+this.__client_qq+"%");
	}

	public void setClientQq( java.lang.String value ) {
		this.__client_qq = value;
	}

	public java.lang.String getClientEmail() {
		return this.__client_email == null ? null : (this.__client_email.indexOf("%") >= 0 ? this.__client_email : "%"+this.__client_email+"%");
	}

	public void setClientEmail( java.lang.String value ) {
		this.__client_email = value;
	}

	public java.lang.Integer getClientRole() {
		return this.__client_role;
	}

	public void setClientRole( java.lang.Integer value ) {
		this.__client_role = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getClientName() != null) sb.append(__wrapString(1, "clientName", getClientName()));
		if(getClientPhone() != null) sb.append(__wrapString(1, "clientPhone", getClientPhone()));
		if(getClientCompany() != null) sb.append(__wrapString(1, "clientCompany", getClientCompany()));
		if(getClientJob() != null) sb.append(__wrapString(1, "clientJob", getClientJob()));
		if(getClientWeixin() != null) sb.append(__wrapString(1, "clientWeixin", getClientWeixin()));
		if(getClientQq() != null) sb.append(__wrapString(1, "clientQq", getClientQq()));
		if(getClientEmail() != null) sb.append(__wrapString(1, "clientEmail", getClientEmail()));
		if(getClientRole() != null) sb.append(__wrapNumber(1, "clientRole", getClientRole()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("clientName")) != null) setClientName(__getString(val));
		if((val = values.get("clientPhone")) != null) setClientPhone(__getString(val));
		if((val = values.get("clientCompany")) != null) setClientCompany(__getString(val));
		if((val = values.get("clientJob")) != null) setClientJob(__getString(val));
		if((val = values.get("clientWeixin")) != null) setClientWeixin(__getString(val));
		if((val = values.get("clientQq")) != null) setClientQq(__getString(val));
		if((val = values.get("clientEmail")) != null) setClientEmail(__getString(val));
		if((val = values.get("clientRole")) != null) setClientRole(__getInt(val)); 
	}

	private java.lang.Integer __contract_id = null;
	private java.lang.String __client_name = null;
	private java.lang.String __client_phone = null;
	private java.lang.String __client_company = null;
	private java.lang.String __client_job = null;
	private java.lang.String __client_weixin = null;
	private java.lang.String __client_qq = null;
	private java.lang.String __client_email = null;
	private java.lang.Integer __client_role = null;
}

