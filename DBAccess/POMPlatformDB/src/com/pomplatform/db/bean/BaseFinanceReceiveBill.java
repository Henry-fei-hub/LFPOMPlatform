package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseFinanceReceiveBill extends GenericBase implements BaseFactory<BaseFinanceReceiveBill>, Comparable<BaseFinanceReceiveBill> 
{


	public static BaseFinanceReceiveBill newInstance(){
		return new BaseFinanceReceiveBill();
	}

	@Override
	public BaseFinanceReceiveBill make(){
		BaseFinanceReceiveBill b = new BaseFinanceReceiveBill();
		return b;
	}

	public final static java.lang.String CS_FINANCE_RECEIVE_BILL_ID = "finance_receive_bill_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_APPLICANT = "applicant" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_SENDEE = "sendee" ;
	public final static java.lang.String CS_HANDLE_PERSON = "handle_person" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_DETAIL_REMARK = "detail_remark" ;
	public final static java.lang.String CS_RECEIVE_STATUS = "receive_status" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,归属公司,部门,申请人,报销编号,报销类型,业务主键,金额,接收人,处理人,备注,流程明细,收单状态 1已收 2 退回 3转交 4待补正资料,创建日期,修改日期";

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

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getApplicant() {
		return this.__applicant;
	}

	public void setApplicant( java.lang.Integer value ) {
		this.__applicant = value;
	}

	public java.lang.String getCode() {
		return this.__code;
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
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getDetailRemark() {
		return this.__detail_remark;
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

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getUpdateTime() {
		return this.__update_time;
	}

	public void setUpdateTime( java.util.Date value ) {
		this.__update_time = value;
	}

	public void cloneCopy(BaseFinanceReceiveBill __bean){
		__bean.setFinanceReceiveBillId(getFinanceReceiveBillId());
		__bean.setCompanyId(getCompanyId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setApplicant(getApplicant());
		__bean.setCode(getCode());
		__bean.setProcessType(getProcessType());
		__bean.setBusinessId(getBusinessId());
		__bean.setAmount(getAmount());
		__bean.setSendee(getSendee());
		__bean.setHandlePerson(getHandlePerson());
		__bean.setRemark(getRemark());
		__bean.setDetailRemark(getDetailRemark());
		__bean.setReceiveStatus(getReceiveStatus());
		__bean.setCreateTime(getCreateTime());
		__bean.setUpdateTime(getUpdateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFinanceReceiveBillId() == null ? "" : getFinanceReceiveBillId());
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getApplicant() == null ? "" : getApplicant());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getSendee() == null ? "" : getSendee());
		sb.append(",");
		sb.append(getHandlePerson() == null ? "" : getHandlePerson());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getDetailRemark() == null ? "" : getDetailRemark());
		sb.append(",");
		sb.append(getReceiveStatus() == null ? "" : getReceiveStatus());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFinanceReceiveBill o) {
		return __finance_receive_bill_id == null ? -1 : __finance_receive_bill_id.compareTo(o.getFinanceReceiveBillId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__finance_receive_bill_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__applicant);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__sendee);
		hash = 97 * hash + Objects.hashCode(this.__handle_person);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__detail_remark);
		hash = 97 * hash + Objects.hashCode(this.__receive_status);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFinanceReceiveBill o = (BaseFinanceReceiveBill)obj;
		if(!Objects.equals(this.__finance_receive_bill_id, o.getFinanceReceiveBillId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__applicant, o.getApplicant())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__sendee, o.getSendee())) return false;
		if(!Objects.equals(this.__handle_person, o.getHandlePerson())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__detail_remark, o.getDetailRemark())) return false;
		if(!Objects.equals(this.__receive_status, o.getReceiveStatus())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFinanceReceiveBillId() != null) sb.append(__wrapNumber(count++, "financeReceiveBillId", getFinanceReceiveBillId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getApplicant() != null) sb.append(__wrapNumber(count++, "applicant", getApplicant()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getSendee() != null) sb.append(__wrapNumber(count++, "sendee", getSendee()));
		if(getHandlePerson() != null) sb.append(__wrapNumber(count++, "handlePerson", getHandlePerson()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getDetailRemark() != null) sb.append(__wrapString(count++, "detailRemark", getDetailRemark()));
		if(getReceiveStatus() != null) sb.append(__wrapNumber(count++, "receiveStatus", getReceiveStatus()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("financeReceiveBillId")) != null) setFinanceReceiveBillId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
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
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __finance_receive_bill_id ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __applicant ;
	protected java.lang.String  __code ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __business_id ;
	protected java.math.BigDecimal  __amount ;
	protected java.lang.Integer  __sendee ;
	protected java.lang.Integer  __handle_person ;
	protected java.lang.String  __remark ;
	protected java.lang.String  __detail_remark ;
	protected java.lang.Integer  __receive_status ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __update_time ;
}
