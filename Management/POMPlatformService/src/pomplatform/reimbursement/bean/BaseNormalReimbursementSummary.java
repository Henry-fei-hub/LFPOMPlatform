package pomplatform.reimbursement.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseNormalReimbursementSummary extends GenericBase implements BaseFactory<BaseNormalReimbursementSummary>, Comparable<BaseNormalReimbursementSummary> 
{


	public static BaseNormalReimbursementSummary newInstance(){
		return new BaseNormalReimbursementSummary();
	}

	@Override
	public BaseNormalReimbursementSummary make(){
		BaseNormalReimbursementSummary b = new BaseNormalReimbursementSummary();
		return b;
	}

	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "备注";

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseNormalReimbursementSummary __bean){
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseNormalReimbursementSummary o) {
		return __remark == null ? -1 : __remark.compareTo(o.getRemark());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseNormalReimbursementSummary o = (BaseNormalReimbursementSummary)obj;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.String  __remark ;
}
