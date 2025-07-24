package pomplatform.workflow.personnelbusiness.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseGetResignationIntegral extends GenericBase implements BaseFactory<BaseGetResignationIntegral>, Comparable<BaseGetResignationIntegral> 
{


	public static BaseGetResignationIntegral newInstance(){
		return new BaseGetResignationIntegral();
	}

	@Override
	public BaseGetResignationIntegral make(){
		BaseGetResignationIntegral b = new BaseGetResignationIntegral();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_FEE = "fee" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String ALL_CAPTIONS = "申请人,预计费用,离职时间";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getFee() {
		return this.__fee;
	}

	public void setFee( java.math.BigDecimal value ) {
		this.__fee = value;
	}

	public java.util.Date getEndDate() {
		return __end_date;
	}

	public void setEndDate(java.util.Date __end_date) {
		this.__end_date = __end_date;
	}

	public void cloneCopy(BaseGetResignationIntegral __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEndDate(getEndDate());
		__bean.setFee(getFee());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getFee() == null ? "" : getFee());
		sb.append(",");
		sb.append(getEndDate() == null ? "" : DATE_SDF.format(getEndDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetResignationIntegral o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__fee);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetResignationIntegral o = (BaseGetResignationIntegral)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__fee, o.getFee())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getFee() != null) sb.append(__wrapDecimal(count++, "fee", getFee()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("fee")) != null) setFee(__getDecimal(val));  
	}

	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __fee ;
	protected java.util.Date __end_date;
}
