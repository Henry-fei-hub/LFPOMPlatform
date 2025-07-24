package pomplatform.project.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetRunningReimbursementAmountByProject extends GenericBase implements BaseFactory<BaseGetRunningReimbursementAmountByProject>, Comparable<BaseGetRunningReimbursementAmountByProject> 
{


	public static BaseGetRunningReimbursementAmountByProject newInstance(){
		return new BaseGetRunningReimbursementAmountByProject();
	}

	@Override
	public BaseGetRunningReimbursementAmountByProject make(){
		BaseGetRunningReimbursementAmountByProject b = new BaseGetRunningReimbursementAmountByProject();
		return b;
	}

	public final static java.lang.String CS_AMOUNT = "amount" ;

	public final static java.lang.String ALL_CAPTIONS = "";

	public java.lang.Long getAmount() {
		return this.__amount;
	}

	public void setAmount( java.lang.Long value ) {
		this.__amount = value;
	}

	public void cloneCopy(BaseGetRunningReimbursementAmountByProject __bean){
		__bean.setAmount(getAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getAmount() == null ? "" : getAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetRunningReimbursementAmountByProject o) {
		return __amount == null ? -1 : __amount.compareTo(o.getAmount());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetRunningReimbursementAmountByProject o = (BaseGetRunningReimbursementAmountByProject)obj;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getAmount() != null) sb.append(__wrapNumber(count++, "amount", getAmount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("amount")) != null) setAmount(__getLong(val)); 
	}

	protected java.lang.Long  __amount ;
}
