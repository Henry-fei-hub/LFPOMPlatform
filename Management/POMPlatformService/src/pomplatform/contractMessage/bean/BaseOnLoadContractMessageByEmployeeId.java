package pomplatform.contractMessage.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadContractMessageByEmployeeId extends GenericBase implements BaseFactory<BaseOnLoadContractMessageByEmployeeId>, Comparable<BaseOnLoadContractMessageByEmployeeId> 
{


	public static BaseOnLoadContractMessageByEmployeeId newInstance(){
		return new BaseOnLoadContractMessageByEmployeeId();
	}

	@Override
	public BaseOnLoadContractMessageByEmployeeId make(){
		BaseOnLoadContractMessageByEmployeeId b = new BaseOnLoadContractMessageByEmployeeId();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_STRING_AGG = "string_agg" ;

	public final static java.lang.String ALL_CAPTIONS = "员工编码,合同编号名称";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getStringAgg() {
		return this.__string_agg;
	}

	public void setStringAgg( java.lang.String value ) {
		this.__string_agg = value;
	}

	public void cloneCopy(BaseOnLoadContractMessageByEmployeeId __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setStringAgg(getStringAgg());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getStringAgg() == null ? "" : getStringAgg());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadContractMessageByEmployeeId o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__string_agg);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadContractMessageByEmployeeId o = (BaseOnLoadContractMessageByEmployeeId)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__string_agg, o.getStringAgg())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getStringAgg() != null) sb.append(__wrapString(count++, "stringAgg", getStringAgg()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getStringAgg() != null) res.put("stringAgg", getStringAgg());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("stringAgg")) != null) setStringAgg(__getString(val));
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __string_agg ;
}
