package pomplatform.employeemoneymanagespeemmepemmor.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMemployeemoneymanagespeemmepemmor extends GenericBase implements BaseFactory<BaseMemployeemoneymanagespeemmepemmor>, Comparable<BaseMemployeemoneymanagespeemmepemmor> 
{


	public static BaseMemployeemoneymanagespeemmepemmor newInstance(){
		return new BaseMemployeemoneymanagespeemmepemmor();
	}

	@Override
	public BaseMemployeemoneymanagespeemmepemmor make(){
		BaseMemployeemoneymanagespeemmepemmor b = new BaseMemployeemoneymanagespeemmepemmor();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_MONEY = "money" ;
	public final static java.lang.String CS_RETURN_MONEY = "return_money" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_BUSINESS_NAME = "business_name" ;
	public final static java.lang.String CS_COMPLETE_TIME = "complete_time" ;
	public final static java.lang.String CS_EQUIVALENT_NUMBER = "equivalent_number" ;
	public final static java.lang.String CS_M_TYPE = "m_type" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;

	public final static java.lang.String ALL_CAPTIONS = "职员编码,借款金额,还款金额,业务编码,业务名称,完成时间,对等号  与  冲账结合实现 借款与冲账,款项类型,流程编码,主键编码,流程类型";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getMoney() {
		return this.__money;
	}

	public void setMoney( java.math.BigDecimal value ) {
		this.__money = value;
	}

	public java.math.BigDecimal getReturnMoney() {
		return this.__return_money;
	}

	public void setReturnMoney( java.math.BigDecimal value ) {
		this.__return_money = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public java.lang.String getBusinessName() {
		return this.__business_name;
	}

	public void setBusinessName( java.lang.String value ) {
		this.__business_name = value;
	}

	public java.util.Date getCompleteTime() {
		return this.__complete_time;
	}

	public void setCompleteTime( java.util.Date value ) {
		this.__complete_time = value;
	}

	public java.lang.String getEquivalentNumber() {
		return this.__equivalent_number;
	}

	public void setEquivalentNumber( java.lang.String value ) {
		this.__equivalent_number = value;
	}

	public java.lang.Integer getMType() {
		return this.__m_type;
	}

	public void setMType( java.lang.Integer value ) {
		this.__m_type = value;
	}

	public java.lang.Integer getProcessId() {
		return this.__process_id;
	}

	public void setProcessId( java.lang.Integer value ) {
		this.__process_id = value;
	}

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

	public void cloneCopy(BaseMemployeemoneymanagespeemmepemmor __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setMoney(getMoney());
		__bean.setReturnMoney(getReturnMoney());
		__bean.setBusinessId(getBusinessId());
		__bean.setBusinessName(getBusinessName());
		__bean.setCompleteTime(getCompleteTime());
		__bean.setEquivalentNumber(getEquivalentNumber());
		__bean.setMType(getMType());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setProcessType(getProcessType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getMoney() == null ? "" : getMoney());
		sb.append(",");
		sb.append(getReturnMoney() == null ? "" : getReturnMoney());
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getBusinessName() == null ? "" : getBusinessName());
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : sdf.format(getCompleteTime()));
		sb.append(",");
		sb.append(getEquivalentNumber() == null ? "" : getEquivalentNumber());
		sb.append(",");
		String strMType = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getMType()));
		sb.append(strMType == null ? "" : strMType);
		sb.append(",");
		sb.append(getProcessId() == null ? "" : getProcessId());
		sb.append(",");
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		sb.append(getProcessType() == null ? "" : getProcessType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMemployeemoneymanagespeemmepemmor o) {
		return __process_instance_id == null ? -1 : __process_instance_id.compareTo(o.getProcessInstanceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__money);
		hash = 97 * hash + Objects.hashCode(this.__return_money);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
		hash = 97 * hash + Objects.hashCode(this.__equivalent_number);
		hash = 97 * hash + Objects.hashCode(this.__m_type);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMemployeemoneymanagespeemmepemmor o = (BaseMemployeemoneymanagespeemmepemmor)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__money, o.getMoney())) return false;
		if(!Objects.equals(this.__return_money, o.getReturnMoney())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		if(!Objects.equals(this.__equivalent_number, o.getEquivalentNumber())) return false;
		if(!Objects.equals(this.__m_type, o.getMType())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getMoney() != null) sb.append(__wrapDecimal(count++, "money", getMoney()));
		if(getReturnMoney() != null) sb.append(__wrapDecimal(count++, "returnMoney", getReturnMoney()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		if(getEquivalentNumber() != null) sb.append(__wrapString(count++, "equivalentNumber", getEquivalentNumber()));
		if(getMType() != null) sb.append(__wrapNumber(count++, "mType", getMType()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("money")) != null) setMoney(__getDecimal(val));  
		if((val = values.get("returnMoney")) != null) setReturnMoney(__getDecimal(val));  
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
		if((val = values.get("completeTime")) != null) setCompleteTime(__getDate(val)); 
		if((val = values.get("equivalentNumber")) != null) setEquivalentNumber(__getString(val));
		if((val = values.get("mType")) != null) setMType(__getInt(val)); 
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __money ;
	protected java.math.BigDecimal  __return_money ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.String  __business_name ;
	protected java.util.Date  __complete_time ;
	protected java.lang.String  __equivalent_number ;
	protected java.lang.Integer  __m_type ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __process_type ;
}
