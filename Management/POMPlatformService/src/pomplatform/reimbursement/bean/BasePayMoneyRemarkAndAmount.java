package pomplatform.reimbursement.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasePayMoneyRemarkAndAmount extends GenericBase implements BaseFactory<BasePayMoneyRemarkAndAmount>, Comparable<BasePayMoneyRemarkAndAmount> 
{


	public static BasePayMoneyRemarkAndAmount newInstance(){
		return new BasePayMoneyRemarkAndAmount();
	}

	@Override
	public BasePayMoneyRemarkAndAmount make(){
		BasePayMoneyRemarkAndAmount b = new BasePayMoneyRemarkAndAmount();
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

	public void cloneCopy(BasePayMoneyRemarkAndAmount __bean){
		__bean.setPayMoney(getPayMoney());
		__bean.setRemark(getRemark());
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
	public int compareTo(BasePayMoneyRemarkAndAmount o) {
		return __pay_money == null ? -1 : __pay_money.compareTo(o.getPayMoney());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__pay_money);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePayMoneyRemarkAndAmount o = (BasePayMoneyRemarkAndAmount)obj;
		if(!Objects.equals(this.__pay_money, o.getPayMoney())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPayMoney() != null) sb.append(__wrapDecimal(count++, "payMoney", getPayMoney()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("payMoney")) != null) setPayMoney(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.math.BigDecimal  __pay_money ;
	protected java.lang.String  __remark ;
}
