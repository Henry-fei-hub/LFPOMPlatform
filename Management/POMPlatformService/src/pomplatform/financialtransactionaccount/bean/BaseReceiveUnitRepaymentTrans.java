package pomplatform.financialtransactionaccount.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;
import delicacy.system.executor.SelectValueCache;

public class BaseReceiveUnitRepaymentTrans extends GenericBase implements BaseFactory<BaseReceiveUnitRepaymentTrans>, Comparable<BaseReceiveUnitRepaymentTrans> 
{


	public static BaseReceiveUnitRepaymentTrans newInstance(){
		return new BaseReceiveUnitRepaymentTrans();
	}

	@Override
	public BaseReceiveUnitRepaymentTrans make(){
		BaseReceiveUnitRepaymentTrans b = new BaseReceiveUnitRepaymentTrans();
		return b;
	}

	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;
	public final static java.lang.String CS_COMPLETE_TIME = "complete_time" ;
	public final static java.lang.String CS_DRAFTER = "drafter" ;
	public final static java.lang.String CS_CURRENCY_TYPE = "currency_type" ;
	public final static java.lang.String CS_SUMMARY = "summary" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_ORIGINAL_CREDIT = "original_credit" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,流程类型,业务编码,申请日期,流程状态,完成时间,起草人,货币类型,摘要备注,还款的收款单位,原币贷,归属公司";

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
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

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.util.Date getCompleteTime() {
		return this.__complete_time;
	}

	public void setCompleteTime( java.util.Date value ) {
		this.__complete_time = value;
	}

	public java.lang.Integer getDrafter() {
		return this.__drafter;
	}

	public void setDrafter( java.lang.Integer value ) {
		this.__drafter = value;
	}

	public java.lang.Integer getCurrencyType() {
		return this.__currency_type;
	}

	public void setCurrencyType( java.lang.Integer value ) {
		this.__currency_type = value;
	}

	public java.lang.String getSummary() {
		return this.__summary;
	}

	public void setSummary( java.lang.String value ) {
		this.__summary = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.math.BigDecimal getOriginalCredit() {
		return this.__original_credit;
	}

	public void setOriginalCredit( java.math.BigDecimal value ) {
		this.__original_credit = value;
	}

	public java.lang.Integer getCompanyId() {
		return __company_id;
	}

	public void setCompanyId(java.lang.Integer value) {
		this.__company_id = value;
	}
	
	public void cloneCopy(BaseReceiveUnitRepaymentTrans __bean){
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setProcessType(getProcessType());
		__bean.setBusinessId(getBusinessId());
		__bean.setRecordDate(getRecordDate());
		__bean.setProcessStatus(getProcessStatus());
		__bean.setCompleteTime(getCompleteTime());
		__bean.setDrafter(getDrafter());
		__bean.setCurrencyType(getCurrencyType());
		__bean.setSummary(getSummary());
		__bean.setParentId(getParentId());
		__bean.setOriginalCredit(getOriginalCredit());
		__bean.setCompanyId(getCompanyId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		String strProcessType = delicacy.system.executor.SelectValueCache.getSelectValue("system_process_types", String.valueOf(getProcessType()));
		sb.append(strProcessType == null ? "" : strProcessType);
		sb.append(",");
		String strBusinessId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getBusinessId()));
		sb.append(strBusinessId == null ? "" : strBusinessId);
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		String strProcessStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_120", String.valueOf(getProcessStatus()));
		sb.append(strProcessStatus == null ? "" : strProcessStatus);
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : sdf.format(getCompleteTime()));
		sb.append(",");
		String strDrafter = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getDrafter()));
		sb.append(strDrafter == null ? "" : strDrafter);
		sb.append(",");
		sb.append(getCurrencyType() == null ? "" : getCurrencyType());
		sb.append(",");
		sb.append(getSummary() == null ? "" : getSummary());
		sb.append(",");
		String strParentId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts_1", String.valueOf(getParentId()));
		sb.append(strParentId == null ? "" : strParentId);
		sb.append(",");
		sb.append(getOriginalCredit() == null ? "" : getOriginalCredit());
		sb.append(",");
		String companyStr = SelectValueCache.getSelectValue("company_records", String.valueOf(getCompanyId()));
		sb.append(companyStr == null ? "" : companyStr);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReceiveUnitRepaymentTrans o) {
		return __process_instance_id == null ? -1 : __process_instance_id.compareTo(o.getProcessInstanceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
		hash = 97 * hash + Objects.hashCode(this.__drafter);
		hash = 97 * hash + Objects.hashCode(this.__currency_type);
		hash = 97 * hash + Objects.hashCode(this.__summary);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__original_credit);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReceiveUnitRepaymentTrans o = (BaseReceiveUnitRepaymentTrans)obj;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		if(!Objects.equals(this.__drafter, o.getDrafter())) return false;
		if(!Objects.equals(this.__currency_type, o.getCurrencyType())) return false;
		if(!Objects.equals(this.__summary, o.getSummary())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__original_credit, o.getOriginalCredit())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		if(getDrafter() != null) sb.append(__wrapNumber(count++, "drafter", getDrafter()));
		if(getCurrencyType() != null) sb.append(__wrapNumber(count++, "currencyType", getCurrencyType()));
		if(getSummary() != null) sb.append(__wrapString(count++, "summary", getSummary()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getOriginalCredit() != null) sb.append(__wrapDecimal(count++, "originalCredit", getOriginalCredit()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProcessInstanceId() != null) res.put("processInstanceId", getProcessInstanceId());
		if(getProcessType() != null) res.put("processType", getProcessType());
		if(getBusinessId() != null) res.put("businessId", getBusinessId());
		if(getRecordDate() != null) res.put("recordDate", getRecordDate());
		if(getProcessStatus() != null) res.put("processStatus", getProcessStatus());
		if(getCompleteTime() != null) res.put("completeTime", getCompleteTime());
		if(getDrafter() != null) res.put("drafter", getDrafter());
		if(getCurrencyType() != null) res.put("currencyType", getCurrencyType());
		if(getSummary() != null) res.put("summary", getSummary());
		if(getParentId() != null) res.put("parentId", getParentId());
		if(getOriginalCredit() != null) res.put("originalCredit", getOriginalCredit());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("completeTime")) != null) setCompleteTime(__getDate(val)); 
		if((val = values.get("drafter")) != null) setDrafter(__getInt(val)); 
		if((val = values.get("currencyType")) != null) setCurrencyType(__getInt(val)); 
		if((val = values.get("summary")) != null) setSummary(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("originalCredit")) != null) setOriginalCredit(__getDecimal(val));  
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val));
	}

	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __business_id ;
	protected java.util.Date  __record_date ;
	protected java.lang.Integer  __process_status ;
	protected java.util.Date  __complete_time ;
	protected java.lang.Integer  __drafter ;
	protected java.lang.Integer  __currency_type ;
	protected java.lang.String  __summary ;
	protected java.lang.Integer  __parent_id ;
	protected java.math.BigDecimal  __original_credit ;
	protected java.lang.Integer  __company_id ;
}
