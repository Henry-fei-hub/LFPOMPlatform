package pomplatform.financereceivebills.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMfinancereceivebillspor extends GenericCondition{

	public ConditionMfinancereceivebillspor(){
		setParameterCount(17);
	}

	public java.lang.Integer getFinanceReceiveBillId() {
		return this.__finance_receive_bill_id;
	}

	public void setFinanceReceiveBillId( java.lang.Integer value ) {
		this.__finance_receive_bill_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getApplicant() {
		return this.__applicant;
	}

	public void setApplicant( java.lang.Integer value ) {
		this.__applicant = value;
	}

	public java.lang.String getCode() {
		return this.__code == null ? null : (this.__code.indexOf("%") >= 0 ? this.__code : "%"+this.__code+"%");
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.lang.Integer getSendee() {
		return this.__sendee;
	}

	public void setSendee( java.lang.Integer value ) {
		this.__sendee = value;
	}

	public java.lang.Integer getHandlePerson() {
		return this.__handle_person;
	}

	public void setHandlePerson( java.lang.Integer value ) {
		this.__handle_person = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getDetailRemark() {
		return this.__detail_remark == null ? null : (this.__detail_remark.indexOf("%") >= 0 ? this.__detail_remark : "%"+this.__detail_remark+"%");
	}

	public void setDetailRemark( java.lang.String value ) {
		this.__detail_remark = value;
	}

	public java.lang.Integer getReceiveStatus() {
		return this.__receive_status;
	}

	public void setReceiveStatus( java.lang.Integer value ) {
		this.__receive_status = value;
	}

	public java.util.Date getMinCreateTime() {
		return this.__min_create_time;
	}

	public void setMinCreateTime( java.util.Date value ) {
		this.__min_create_time = value;
	}

	public java.util.Date getMaxCreateTime() {
		return this.__max_create_time;
	}

	public void setMaxCreateTime( java.util.Date value ) {
		this.__max_create_time = value;
	}

	public java.util.Date getMinUpdateTime() {
		return this.__min_update_time;
	}

	public void setMinUpdateTime( java.util.Date value ) {
		this.__min_update_time = value;
	}

	public java.util.Date getMaxUpdateTime() {
		return this.__max_update_time;
	}

	public void setMaxUpdateTime( java.util.Date value ) {
		this.__max_update_time = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getFinanceReceiveBillId() != null) sb.append(__wrapNumber(1, "financeReceiveBillId", getFinanceReceiveBillId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getApplicant() != null) sb.append(__wrapNumber(1, "applicant", getApplicant()));
		if(getCode() != null) sb.append(__wrapString(1, "code", getCode()));
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		if(getBusinessId() != null) sb.append(__wrapNumber(1, "businessId", getBusinessId()));
		if(getAmount() != null) sb.append(__wrapNumber(1, "amount", getAmount()));
		if(getSendee() != null) sb.append(__wrapNumber(1, "sendee", getSendee()));
		if(getHandlePerson() != null) sb.append(__wrapNumber(1, "handlePerson", getHandlePerson()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getDetailRemark() != null) sb.append(__wrapString(1, "detailRemark", getDetailRemark()));
		if(getReceiveStatus() != null) sb.append(__wrapNumber(1, "receiveStatus", getReceiveStatus()));
		if(getMinCreateTime() != null) sb.append(__wrapDate(1, "minCreateTime", getMinCreateTime()));
		if(getMaxCreateTime() != null) sb.append(__wrapDate(1, "maxCreateTime", getMaxCreateTime()));
		if(getMinUpdateTime() != null) sb.append(__wrapDate(1, "minUpdateTime", getMinUpdateTime()));
		if(getMaxUpdateTime() != null) sb.append(__wrapDate(1, "maxUpdateTime", getMaxUpdateTime()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(1, "processStatus", getProcessStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("financeReceiveBillId")) != null) setFinanceReceiveBillId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("applicant")) != null) setApplicant(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("sendee")) != null) setSendee(__getInt(val)); 
		if((val = values.get("handlePerson")) != null) setHandlePerson(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("detailRemark")) != null) setDetailRemark(__getString(val));
		if((val = values.get("receiveStatus")) != null) setReceiveStatus(__getInt(val)); 
		if((val = values.get("minCreateTime")) != null) setMinCreateTime(__getDate(val)); 
		if((val = values.get("maxCreateTime")) != null) setMaxCreateTime(__getDate(val)); 
		if((val = values.get("minUpdateTime")) != null) setMinUpdateTime(__getDate(val)); 
		if((val = values.get("maxUpdateTime")) != null) setMaxUpdateTime(__getDate(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
	}

	private java.lang.Integer __finance_receive_bill_id = null;
	private java.lang.Integer __company_id = null;
	private java.lang.Integer __applicant = null;
	private java.lang.String __code = null;
	private java.lang.Integer __process_type = null;
	private java.lang.Integer __business_id = null;
	private java.math.BigDecimal __amount = null;
	private java.lang.Integer __sendee = null;
	private java.lang.Integer __handle_person = null;
	private java.lang.String __remark = null;
	private java.lang.String __detail_remark = null;
	private java.lang.Integer __receive_status = null;
	private java.util.Date __min_create_time = null;
	private java.util.Date __max_create_time = null;
	private java.util.Date __min_update_time = null;
	private java.util.Date __max_update_time = null;
	private java.lang.Integer __process_status = null;
}

