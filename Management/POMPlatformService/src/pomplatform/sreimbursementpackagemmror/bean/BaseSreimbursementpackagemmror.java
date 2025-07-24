package pomplatform.sreimbursementpackagemmror.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSreimbursementpackagemmror extends GenericBase implements BaseFactory<BaseSreimbursementpackagemmror>, Comparable<BaseSreimbursementpackagemmror> 
{


	public static BaseSreimbursementpackagemmror newInstance(){
		return new BaseSreimbursementpackagemmror();
	}

	@Override
	public BaseSreimbursementpackagemmror make(){
		BaseSreimbursementpackagemmror b = new BaseSreimbursementpackagemmror();
		return b;
	}

	public final static java.lang.String CS_REIMBURSEMENT_PACKAGE_ID = "reimbursement_package_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_PAYMENT_AMOUNT = "payment_amount" ;
	public final static java.lang.String CS_STRIKE_A_BALANCE_AMOUNT = "strike_a_balance_amount" ;
	public final static java.lang.String CS_IS_COMPLETED = "is_completed" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_ROLE_ID = "role_id" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;
	public final static java.lang.String CS_PACKAGE_SIZE = "package_size" ;
	public final static java.lang.String CS_IS_ONLINE_PAY = "is_online_pay" ;
	public final static java.lang.String CS_PAY_STATUS = "pay_status" ;
	public final static java.lang.String CS_MAKE_BILL_TIME = "make_bill_time" ;
	public final static java.lang.String CS_PAY_TIME = "pay_time" ;
	public final static java.lang.String CS_ZERONUM = "zeronum" ;
	public final static java.lang.String CS_ONENUM = "onenum" ;
	public final static java.lang.String CS_TWONUM = "twonum" ;
	public final static java.lang.String CS_THREENUM = "threenum" ;
	public final static java.lang.String CS_FOURNUM = "fournum" ;
	public final static java.lang.String CS_ALLNUM = "allnum" ;
	

	public final static java.lang.String ALL_CAPTIONS = "报销打包表编码,归属公司,总金额,付款金额,冲账金额,是否通过审批,备注,可操作人编码,可操作角色编码,操作人Id,创建时间,修改时间";

	public java.lang.Integer getReimbursementPackageId() {
		return this.__reimbursement_package_id;
	}

	public void setReimbursementPackageId( java.lang.Integer value ) {
		this.__reimbursement_package_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.math.BigDecimal getPaymentAmount() {
		return this.__payment_amount;
	}

	public void setPaymentAmount( java.math.BigDecimal value ) {
		this.__payment_amount = value;
	}

	public java.math.BigDecimal getStrikeABalanceAmount() {
		return this.__strike_a_balance_amount;
	}

	public void setStrikeABalanceAmount( java.math.BigDecimal value ) {
		this.__strike_a_balance_amount = value;
	}

	public java.lang.Boolean getIsCompleted() {
		return this.__is_completed;
	}

	public void setIsCompleted( java.lang.Boolean value ) {
		this.__is_completed = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getRoleId() {
		return this.__role_id;
	}

	public void setRoleId( java.lang.Integer value ) {
		this.__role_id = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}
	
	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
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

	public java.lang.Integer getPackageSize() {
		return __package_size;
	}

	public void setPackageSize(java.lang.Integer value ) {
		this.__package_size = value;
	}

	public java.lang.Boolean getIsOnlinePay() {
		return __is_online_pay;
	}

	public void setIsOnlinePay(java.lang.Boolean value) {
		this.__is_online_pay = value;
	}

	public java.lang.Integer getPayStatus() {
		return __pay_status;
	}

	public void setPayStatus(java.lang.Integer value) {
		this.__pay_status = value;
	}

	public java.util.Date getMakeBillTime() {
		return __make_bill_time;
	}

	public void setMakeBillTime(java.util.Date value) {
		this.__make_bill_time = value;
	}

	public java.util.Date getPayTime() {
		return __pay_time;
	}

	public void setPayTime(java.util.Date value) {
		this.__pay_time = value;
	}

	public java.lang.Integer getZeronum() {
		return __zeronum;
	}

	public void setZeronum(java.lang.Integer value) {
		this.__zeronum = value;
	}

	public java.lang.Integer getOnenum() {
		return __onenum;
	}

	public void setOnenum(java.lang.Integer value) {
		this.__onenum = value;
	}

	public java.lang.Integer getTwonum() {
		return __twonum;
	}

	public void setTwonum(java.lang.Integer value) {
		this.__twonum = value;
	}

	public java.lang.Integer getThreenum() {
		return __threenum;
	}

	public void setThreenum(java.lang.Integer value) {
		this.__threenum = value;
	}

	public java.lang.Integer getFournum() {
		return __fournum;
	}

	public void setFournum(java.lang.Integer value) {
		this.__fournum = value;
	}

	public java.lang.Integer getAllnum() {
		return __allnum;
	}

	public void setAllnum(java.lang.Integer value) {
		this.__allnum = value;
	}

	public void cloneCopy(BaseSreimbursementpackagemmror __bean){
		__bean.setReimbursementPackageId(getReimbursementPackageId());
		__bean.setCompanyId(getCompanyId());
		__bean.setAmount(getAmount());
		__bean.setPaymentAmount(getPaymentAmount());
		__bean.setStrikeABalanceAmount(getStrikeABalanceAmount());
		__bean.setIsCompleted(getIsCompleted());
		__bean.setRemark(getRemark());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setRoleId(getRoleId());
		__bean.setOperatorId(getOperatorId());
		__bean.setCode(getCode());
		__bean.setCreateTime(getCreateTime());
		__bean.setUpdateTime(getUpdateTime());
		__bean.setPackageSize(getPackageSize());
		__bean.setIsOnlinePay(getIsOnlinePay());
		__bean.setPayStatus(getPayStatus());
		__bean.setMakeBillTime(getMakeBillTime());
		__bean.setPayTime(getPayTime());
		__bean.setZeronum(getZeronum());
		__bean.setOnenum(getOnenum());
		__bean.setTwonum(getTwonum());
		__bean.setThreenum(getThreenum());
		__bean.setFournum(getFournum());
		__bean.setAllnum(getAllnum());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getReimbursementPackageId() == null ? "" : getReimbursementPackageId());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getPaymentAmount() == null ? "" : getPaymentAmount());
		sb.append(",");
		sb.append(getStrikeABalanceAmount() == null ? "" : getStrikeABalanceAmount());
		sb.append(",");
		sb.append(getIsCompleted() == null ? "" : getIsCompleted());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getRoleId() == null ? "" : getRoleId());
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSreimbursementpackagemmror o) {
		return __reimbursement_package_id == null ? -1 : __reimbursement_package_id.compareTo(o.getReimbursementPackageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_package_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__payment_amount);
		hash = 97 * hash + Objects.hashCode(this.__strike_a_balance_amount);
		hash = 97 * hash + Objects.hashCode(this.__is_completed);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__role_id);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		hash = 97 * hash + Objects.hashCode(this.__package_size);
		hash = 97 * hash + Objects.hashCode(this.__is_online_pay);
		hash = 97 * hash + Objects.hashCode(this.__pay_status);
		hash = 97 * hash + Objects.hashCode(this.__make_bill_time);
		hash = 97 * hash + Objects.hashCode(this.__pay_time);
		hash = 97 * hash + Objects.hashCode(this.__zeronum);
		hash = 97 * hash + Objects.hashCode(this.__onenum);
		hash = 97 * hash + Objects.hashCode(this.__twonum);
		hash = 97 * hash + Objects.hashCode(this.__threenum);
		hash = 97 * hash + Objects.hashCode(this.__fournum);
		hash = 97 * hash + Objects.hashCode(this.__allnum);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSreimbursementpackagemmror o = (BaseSreimbursementpackagemmror)obj;
		if(!Objects.equals(this.__reimbursement_package_id, o.getReimbursementPackageId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__payment_amount, o.getPaymentAmount())) return false;
		if(!Objects.equals(this.__strike_a_balance_amount, o.getStrikeABalanceAmount())) return false;
		if(!Objects.equals(this.__is_completed, o.getIsCompleted())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__role_id, o.getRoleId())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		if(!Objects.equals(this.__package_size, o.getPackageSize())) return false;
		if(!Objects.equals(this.__is_online_pay, o.getIsOnlinePay())) return false;
		if(!Objects.equals(this.__pay_status, o.getPayStatus())) return false;
		if(!Objects.equals(this.__make_bill_time, o.getMakeBillTime())) return false;
		if(!Objects.equals(this.__pay_time, o.getPayTime())) return false;
		if(!Objects.equals(this.__zeronum, o.getZeronum())) return false;
		if(!Objects.equals(this.__onenum, o.getOnenum())) return false;
		if(!Objects.equals(this.__twonum, o.getTwonum())) return false;
		if(!Objects.equals(this.__threenum, o.getThreenum())) return false;
		if(!Objects.equals(this.__fournum, o.getFournum())) return false;
		if(!Objects.equals(this.__allnum, o.getAllnum())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getReimbursementPackageId() != null) sb.append(__wrapNumber(count++, "reimbursementPackageId", getReimbursementPackageId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getPaymentAmount() != null) sb.append(__wrapDecimal(count++, "paymentAmount", getPaymentAmount()));
		if(getStrikeABalanceAmount() != null) sb.append(__wrapDecimal(count++, "strikeABalanceAmount", getStrikeABalanceAmount()));
		if(getIsCompleted() != null) sb.append(__wrapBoolean(count++, "isCompleted", getIsCompleted()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getRoleId() != null) sb.append(__wrapNumber(count++, "roleId", getRoleId()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		if(getPackageSize() != null) sb.append(__wrapNumber(count++, "packageSize", getPackageSize()));
		if(getIsOnlinePay() != null) sb.append(__wrapBoolean(count++, "isOnlinePay", getIsOnlinePay()));
		if(getPayStatus() != null) sb.append(__wrapNumber(count++, "payStatus", getPayStatus()));
		if(getMakeBillTime() != null) sb.append(__wrapDate(count++, "makeBillTime", getMakeBillTime()));
		if(getPayTime() != null) sb.append(__wrapDate(count++, "payTime", getPayTime()));
		if(getZeronum() != null) sb.append(__wrapNumber(count++, "zeronum", getZeronum()));
		if(getOnenum() != null) sb.append(__wrapNumber(count++, "onenum", getOnenum()));
		if(getTwonum() != null) sb.append(__wrapNumber(count++, "twonum", getTwonum()));
		if(getThreenum() != null) sb.append(__wrapNumber(count++, "threenum", getThreenum()));
		if(getFournum() != null) sb.append(__wrapNumber(count++, "fournum", getFournum()));
		if(getAllnum() != null) sb.append(__wrapNumber(count++, "allnum", getAllnum()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("reimbursementPackageId")) != null) setReimbursementPackageId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("paymentAmount")) != null) setPaymentAmount(__getDecimal(val));  
		if((val = values.get("strikeABalanceAmount")) != null) setStrikeABalanceAmount(__getDecimal(val));  
		if((val = values.get("isCompleted")) != null) setIsCompleted(__getBoolean(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("roleId")) != null) setRoleId(__getInt(val)); 
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
		if((val = values.get("packageSize")) != null) setPackageSize(__getInt(val)); 
		if((val = values.get("isOnlinePay")) != null) setIsOnlinePay(__getBoolean(val));
		if((val = values.get("payStatus")) != null) setPayStatus(__getInt(val));
		if((val = values.get("makeBillTime")) != null) setMakeBillTime(__getDate(val)); 
		if((val = values.get("payTime")) != null) setPayTime(__getDate(val)); 
		if((val = values.get("zeronum")) != null) setZeronum(__getInt(val));
		if((val = values.get("onenum")) != null) setOnenum(__getInt(val));
		if((val = values.get("twonum")) != null) setTwonum(__getInt(val));
		if((val = values.get("threenum")) != null) setThreenum(__getInt(val));
		if((val = values.get("fournum")) != null) setFournum(__getInt(val));
		if((val = values.get("allnum")) != null) setAllnum(__getInt(val));
	}

	protected java.lang.Integer  __reimbursement_package_id ;
	protected java.lang.Integer  __company_id ;
	protected java.math.BigDecimal  __amount ;
	protected java.math.BigDecimal  __payment_amount ;
	protected java.math.BigDecimal  __strike_a_balance_amount ;
	protected java.lang.Boolean  __is_completed ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __role_id ;
	protected java.lang.Integer  __operator_id ;
	protected java.lang.String  __code ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __update_time ;
	protected java.lang.Integer  __package_size ;
	protected java.lang.Boolean  __is_online_pay ;
	protected java.lang.Integer  __pay_status ;
	protected java.util.Date  __make_bill_time ;
	protected java.util.Date  __pay_time ;
	protected java.lang.Integer  __zeronum ;
	protected java.lang.Integer  __onenum ;
	protected java.lang.Integer  __twonum ;
	protected java.lang.Integer  __threenum ;
	protected java.lang.Integer  __fournum ;
	protected java.lang.Integer  __allnum;
}
