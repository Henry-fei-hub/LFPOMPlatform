package pomplatform.reimbursement.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseBorrowMoneyRemarkAndAmount extends GenericBase implements BaseFactory<BaseBorrowMoneyRemarkAndAmount>, Comparable<BaseBorrowMoneyRemarkAndAmount> 
{


	public static BaseBorrowMoneyRemarkAndAmount newInstance(){
		return new BaseBorrowMoneyRemarkAndAmount();
	}

	@Override
	public BaseBorrowMoneyRemarkAndAmount make(){
		BaseBorrowMoneyRemarkAndAmount b = new BaseBorrowMoneyRemarkAndAmount();
		return b;
	}

	public final static java.lang.String CS_PAY_MONEY = "pay_money" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "付款金额,备注";

	public java.math.BigDecimal getPayMoney() {
		return this.__pay_money;
	}

	public void setPayMoney( java.math.BigDecimal value ) {
		this.__pay_money = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getEmployeeOrCompanyId() {
		return __employee_or_company_id;
	}

	public void setEmployeeOrCompanyId(java.lang.Integer __employee_or_company_id) {
		this.__employee_or_company_id = __employee_or_company_id;
	}

	public void cloneCopy(BaseBorrowMoneyRemarkAndAmount __bean){
		__bean.setPayMoney(getPayMoney());
		__bean.setRemark(getRemark());
		__bean.setEmployeeOrCompanyId(getEmployeeOrCompanyId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPayMoney() == null ? "" : getPayMoney());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseBorrowMoneyRemarkAndAmount o) {
		return __pay_money == null ? -1 : __pay_money.compareTo(o.getPayMoney());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__pay_money);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__employee_or_company_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseBorrowMoneyRemarkAndAmount o = (BaseBorrowMoneyRemarkAndAmount)obj;
		if(!Objects.equals(this.__pay_money, o.getPayMoney())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__employee_or_company_id, o.getEmployeeOrCompanyId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPayMoney() != null) sb.append(__wrapDecimal(count++, "payMoney", getPayMoney()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getEmployeeOrCompanyId() != null) sb.append(__wrapNumber(count++, "employeeOrCompanyId", getEmployeeOrCompanyId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("payMoney")) != null) setPayMoney(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("employeeOrCompanyId")) != null) setEmployeeOrCompanyId(__getInt(val));
	}

	protected java.math.BigDecimal  __pay_money ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer __employee_or_company_id;
}
