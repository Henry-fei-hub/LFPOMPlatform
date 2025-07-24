package pomplatform.receiveunit.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMemployeepsrreereeedpor extends GenericBase implements BaseFactory<BaseMemployeepsrreereeedpor>, Comparable<BaseMemployeepsrreereeedpor> 
{


	public static BaseMemployeepsrreereeedpor newInstance(){
		return new BaseMemployeepsrreereeedpor();
	}

	@Override
	public BaseMemployeepsrreereeedpor make(){
		BaseMemployeepsrreereeedpor b = new BaseMemployeepsrreereeedpor();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_INITIAL_BALANCE = "initial_balance" ;
	public final static java.lang.String CS_PAY_MONEY = "pay_money" ;
	public final static java.lang.String CS_BALANCE_AMOUNT = "balance_amount" ;
	public final static java.lang.String CS_BALANCE = "balance" ;

	public final static java.lang.String ALL_CAPTIONS = "员工编码,员工姓名,部门,员工编号,板块,在职状态,期初余额,付款金额,差额金额,余额";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.math.BigDecimal getInitialBalance() {
		return this.__initial_balance;
	}

	public void setInitialBalance( java.math.BigDecimal value ) {
		this.__initial_balance = value;
	}

	public java.math.BigDecimal getPayMoney() {
		return this.__pay_money;
	}

	public void setPayMoney( java.math.BigDecimal value ) {
		this.__pay_money = value;
	}

	public java.math.BigDecimal getBalanceAmount() {
		return this.__balance_amount;
	}

	public void setBalanceAmount( java.math.BigDecimal value ) {
		this.__balance_amount = value;
	}

	public java.math.BigDecimal getBalance() {
		return this.__balance;
	}

	public void setBalance( java.math.BigDecimal value ) {
		this.__balance = value;
	}

	public void cloneCopy(BaseMemployeepsrreereeedpor __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setPlateId(getPlateId());
		__bean.setStatus(getStatus());
		__bean.setInitialBalance(getInitialBalance());
		__bean.setPayMoney(getPayMoney());
		__bean.setBalanceAmount(getBalanceAmount());
		__bean.setBalance(getBalance());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_39", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(getInitialBalance() == null ? "" : getInitialBalance());
		sb.append(",");
		sb.append(getPayMoney() == null ? "" : getPayMoney());
		sb.append(",");
		sb.append(getBalanceAmount() == null ? "" : getBalanceAmount());
		sb.append(",");
		sb.append(getBalance() == null ? "" : getBalance());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMemployeepsrreereeedpor o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__initial_balance);
		hash = 97 * hash + Objects.hashCode(this.__pay_money);
		hash = 97 * hash + Objects.hashCode(this.__balance_amount);
		hash = 97 * hash + Objects.hashCode(this.__balance);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMemployeepsrreereeedpor o = (BaseMemployeepsrreereeedpor)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__initial_balance, o.getInitialBalance())) return false;
		if(!Objects.equals(this.__pay_money, o.getPayMoney())) return false;
		if(!Objects.equals(this.__balance_amount, o.getBalanceAmount())) return false;
		if(!Objects.equals(this.__balance, o.getBalance())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getInitialBalance() != null) sb.append(__wrapDecimal(count++, "initialBalance", getInitialBalance()));
		if(getPayMoney() != null) sb.append(__wrapDecimal(count++, "payMoney", getPayMoney()));
		if(getBalanceAmount() != null) sb.append(__wrapDecimal(count++, "balanceAmount", getBalanceAmount()));
		if(getBalance() != null) sb.append(__wrapDecimal(count++, "balance", getBalance()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("initialBalance")) != null) setInitialBalance(__getDecimal(val));  
		if((val = values.get("payMoney")) != null) setPayMoney(__getDecimal(val));  
		if((val = values.get("balanceAmount")) != null) setBalanceAmount(__getDecimal(val));  
		if((val = values.get("balance")) != null) setBalance(__getDecimal(val));  
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __status ;
	protected java.math.BigDecimal  __initial_balance ;
	protected java.math.BigDecimal  __pay_money ;
	protected java.math.BigDecimal  __balance_amount ;
	protected java.math.BigDecimal  __balance ;
}
