package pomplatform.workflow.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnPayMoneyManageBusiness extends GenericBase implements BaseFactory<BaseOnPayMoneyManageBusiness>, Comparable<BaseOnPayMoneyManageBusiness> 
{


	public static BaseOnPayMoneyManageBusiness newInstance(){
		return new BaseOnPayMoneyManageBusiness();
	}

	@Override
	public BaseOnPayMoneyManageBusiness make(){
		BaseOnPayMoneyManageBusiness b = new BaseOnPayMoneyManageBusiness();
		return b;
	}

	public final static java.lang.String CS_IDD = "idd" ;
	public final static java.lang.String CS_VAL = "val" ;
	public final static java.lang.String CS_BANK_ACCOUNT = "bank_account" ;
	public final static java.lang.String CS_BANK_NAME = "bank_name" ;

	public final static java.lang.String ALL_CAPTIONS = "idd,val,银行账号,开户行";

	public java.lang.String getIdd() {
		return this.__idd;
	}

	public void setIdd( java.lang.String value ) {
		this.__idd = value;
	}

	public java.lang.String getVal() {
		return this.__val;
	}

	public void setVal( java.lang.String value ) {
		this.__val = value;
	}

	public java.lang.String getBankAccount() {
		return this.__bank_account;
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	public java.lang.String getBankName() {
		return this.__bank_name;
	}

	public void setBankName( java.lang.String value ) {
		this.__bank_name = value;
	}

	public void cloneCopy(BaseOnPayMoneyManageBusiness __bean){
		__bean.setIdd(getIdd());
		__bean.setVal(getVal());
		__bean.setBankAccount(getBankAccount());
		__bean.setBankName(getBankName());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getIdd() == null ? "" : getIdd());
		sb.append(",");
		sb.append(getVal() == null ? "" : getVal());
		sb.append(",");
		sb.append(getBankAccount() == null ? "" : getBankAccount());
		sb.append(",");
		sb.append(getBankName() == null ? "" : getBankName());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnPayMoneyManageBusiness o) {
		return __idd == null ? -1 : __idd.compareTo(o.getIdd());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__idd);
		hash = 97 * hash + Objects.hashCode(this.__val);
		hash = 97 * hash + Objects.hashCode(this.__bank_account);
		hash = 97 * hash + Objects.hashCode(this.__bank_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnPayMoneyManageBusiness o = (BaseOnPayMoneyManageBusiness)obj;
		if(!Objects.equals(this.__idd, o.getIdd())) return false;
		if(!Objects.equals(this.__val, o.getVal())) return false;
		if(!Objects.equals(this.__bank_account, o.getBankAccount())) return false;
		if(!Objects.equals(this.__bank_name, o.getBankName())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getIdd() != null) sb.append(__wrapString(count++, "idd", getIdd()));
		if(getVal() != null) sb.append(__wrapString(count++, "val", getVal()));
		if(getBankAccount() != null) sb.append(__wrapString(count++, "bankAccount", getBankAccount()));
		if(getBankName() != null) sb.append(__wrapString(count++, "bankName", getBankName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("idd")) != null) setIdd(__getString(val));
		if((val = values.get("val")) != null) setVal(__getString(val));
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("bankName")) != null) setBankName(__getString(val));
	}

	protected java.lang.String  __idd ;
	protected java.lang.String  __val ;
	protected java.lang.String  __bank_account ;
	protected java.lang.String  __bank_name ;
}
