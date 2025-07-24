package pomplatform.workflow.personnelbusiness.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseFillcheckApplyTimes extends GenericBase implements BaseFactory<BaseFillcheckApplyTimes>, Comparable<BaseFillcheckApplyTimes> 
{


	public static BaseFillcheckApplyTimes newInstance(){
		return new BaseFillcheckApplyTimes();
	}

	@Override
	public BaseFillcheckApplyTimes make(){
		BaseFillcheckApplyTimes b = new BaseFillcheckApplyTimes();
		return b;
	}

	public final static java.lang.String CS_SUM = "sum" ;

	public final static java.lang.String ALL_CAPTIONS = "总数";

	public java.lang.Long getSum() {
		return this.__sum;
	}

	public void setSum( java.lang.Long value ) {
		this.__sum = value;
	}

	public void cloneCopy(BaseFillcheckApplyTimes __bean){
		__bean.setSum(getSum());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSum() == null ? "" : getSum());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFillcheckApplyTimes o) {
		return __sum == null ? -1 : __sum.compareTo(o.getSum());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__sum);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFillcheckApplyTimes o = (BaseFillcheckApplyTimes)obj;
		if(!Objects.equals(this.__sum, o.getSum())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSum() != null) sb.append(__wrapNumber(count++, "sum", getSum()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("sum")) != null) setSum(__getLong(val)); 
	}

	protected java.lang.Long  __sum ;
}
