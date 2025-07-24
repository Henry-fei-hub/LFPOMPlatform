package pomplatform.financialtransactionaccount.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseProcessInstWithoutTransDetails extends GenericBase implements BaseFactory<BaseProcessInstWithoutTransDetails>, Comparable<BaseProcessInstWithoutTransDetails> 
{


	public static BaseProcessInstWithoutTransDetails newInstance(){
		return new BaseProcessInstWithoutTransDetails();
	}

	@Override
	public BaseProcessInstWithoutTransDetails make(){
		BaseProcessInstWithoutTransDetails b = new BaseProcessInstWithoutTransDetails();
		return b;
	}

	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;

	public final static java.lang.String ALL_CAPTIONS = "流程类型,业务编码";

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

	public void cloneCopy(BaseProcessInstWithoutTransDetails __bean){
		__bean.setProcessType(getProcessType());
		__bean.setBusinessId(getBusinessId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strProcessType = delicacy.system.executor.SelectValueCache.getSelectValue("system_process_types", String.valueOf(getProcessType()));
		sb.append(strProcessType == null ? "" : strProcessType);
		sb.append(",");
		String strBusinessId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getBusinessId()));
		sb.append(strBusinessId == null ? "" : strBusinessId);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProcessInstWithoutTransDetails o) {
		return __process_type == null ? -1 : __process_type.compareTo(o.getProcessType());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProcessInstWithoutTransDetails o = (BaseProcessInstWithoutTransDetails)obj;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProcessType() != null) res.put("processType", getProcessType());
		if(getBusinessId() != null) res.put("businessId", getBusinessId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
	}

	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __business_id ;
}
