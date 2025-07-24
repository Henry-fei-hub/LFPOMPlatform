package pomplatform.reimbursementinfo.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseReimbursementInfo extends GenericBase implements BaseFactory<BaseReimbursementInfo>, Comparable<BaseReimbursementInfo> 
{


	public static BaseReimbursementInfo newInstance(){
		return new BaseReimbursementInfo();
	}

	@Override
	public BaseReimbursementInfo make(){
		BaseReimbursementInfo b = new BaseReimbursementInfo();
		return b;
	}

	public final static java.lang.String CS_PROCESS_TYPE_ID = "process_type_id" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_DRAFTER_ID = "drafter_id" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_TITLE = "title" ;

	public final static java.lang.String ALL_CAPTIONS = "流程类型,业务ID,编号,起草人,金额,主题";

	public java.lang.Integer getProcessTypeId() {
		return this.__process_type_id;
	}

	public void setProcessTypeId( java.lang.Integer value ) {
		this.__process_type_id = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public java.lang.Integer getDrafterId() {
		return this.__drafter_id;
	}

	public void setDrafterId( java.lang.Integer value ) {
		this.__drafter_id = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}
	
	public java.lang.String getTitle() {
		return this.__title;
	}

	public void setTitle( java.lang.String value ) {
		this.__title = value;
	}


	public void cloneCopy(BaseReimbursementInfo __bean){
		__bean.setProcessTypeId(getProcessTypeId());
		__bean.setBusinessId(getBusinessId());
		__bean.setCode(getCode());
		__bean.setDrafterId(getDrafterId());
		__bean.setAmount(getAmount());
		__bean.setTitle(getTitle());
	}

	public java.lang.String toCSVString() {

		StringBuilder sb = new StringBuilder();
		String processTypeStr = delicacy.system.executor.SelectValueCache.getSelectValue("system_process_types",
				String.valueOf(getProcessTypeId()));
		sb.append(processTypeStr == null ? "" : processTypeStr);
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		String employeeName = delicacy.system.executor.SelectValueCache.getSelectValue("employees",
				String.valueOf(getDrafterId()));
		sb.append(employeeName == null ? "" : employeeName);
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getTitle() == null ? "" : getTitle());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReimbursementInfo o) {
		return -1;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_type_id);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__drafter_id);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__title);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReimbursementInfo o = (BaseReimbursementInfo)obj;
		if(!Objects.equals(this.__process_type_id, o.getProcessTypeId())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__drafter_id, o.getDrafterId())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__title, o.getTitle())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessTypeId() != null) sb.append(__wrapNumber(count++, "processTypeId", getProcessTypeId()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getDrafterId() != null) sb.append(__wrapNumber(count++, "drafterId", getDrafterId()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getTitle() != null) sb.append(__wrapString(count++, "title", getTitle()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processTypeId")) != null) setProcessTypeId(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("drafterId")) != null) setDrafterId(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("title")) != null) setTitle(__getString(val));
	}

	protected java.lang.Integer  __process_type_id ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.String  __code ;
	protected java.lang.Integer  __drafter_id ;
	protected java.math.BigDecimal  __amount ;
	protected java.lang.String  __title ;
}
