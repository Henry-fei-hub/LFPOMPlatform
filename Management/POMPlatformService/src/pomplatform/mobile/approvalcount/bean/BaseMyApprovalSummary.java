package pomplatform.mobile.approvalcount.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMyApprovalSummary extends GenericBase implements BaseFactory<BaseMyApprovalSummary>, Comparable<BaseMyApprovalSummary> 
{


	public static BaseMyApprovalSummary newInstance(){
		return new BaseMyApprovalSummary();
	}

	@Override
	public BaseMyApprovalSummary make(){
		BaseMyApprovalSummary b = new BaseMyApprovalSummary();
		return b;
	}

	public final static java.lang.String CS_NEED_DEAL = "need_deal" ;
	public final static java.lang.String CS_TYPE = "type" ;

	public final static java.lang.String ALL_CAPTIONS = ",";

	public java.math.BigDecimal getNeedDeal() {
		return this.__need_deal;
	}

	public void setNeedDeal( java.math.BigDecimal value ) {
		this.__need_deal = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public void cloneCopy(BaseMyApprovalSummary __bean){
		__bean.setNeedDeal(getNeedDeal());
		__bean.setType(getType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getNeedDeal() == null ? "" : getNeedDeal());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMyApprovalSummary o) {
		return __need_deal == null ? -1 : __need_deal.compareTo(o.getNeedDeal());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__need_deal);
		hash = 97 * hash + Objects.hashCode(this.__type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMyApprovalSummary o = (BaseMyApprovalSummary)obj;
		if(!Objects.equals(this.__need_deal, o.getNeedDeal())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getNeedDeal() != null) sb.append(__wrapDecimal(count++, "needDeal", getNeedDeal()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("needDeal")) != null) setNeedDeal(__getDecimal(val));  
		if((val = values.get("type")) != null) setType(__getInt(val)); 
	}

	protected java.math.BigDecimal  __need_deal ;
	protected java.lang.Integer  __type ;
}
