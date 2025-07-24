package pomplatform.stagemodel.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetRevenueByContractId extends GenericBase implements BaseFactory<BaseGetRevenueByContractId>, Comparable<BaseGetRevenueByContractId> 
{


	public static BaseGetRevenueByContractId newInstance(){
		return new BaseGetRevenueByContractId();
	}

	@Override
	public BaseGetRevenueByContractId make(){
		BaseGetRevenueByContractId b = new BaseGetRevenueByContractId();
		return b;
	}

	public final static java.lang.String CS_REVENUE = "revenue" ;

	public final static java.lang.String ALL_CAPTIONS = "累积营收";

	public java.math.BigDecimal getRevenue() {
		return this.__revenue;
	}

	public void setRevenue( java.math.BigDecimal value ) {
		this.__revenue = value;
	}

	public void cloneCopy(BaseGetRevenueByContractId __bean){
		__bean.setRevenue(getRevenue());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getRevenue() == null ? "" : getRevenue());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetRevenueByContractId o) {
		return __revenue == null ? -1 : __revenue.compareTo(o.getRevenue());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__revenue);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetRevenueByContractId o = (BaseGetRevenueByContractId)obj;
		if(!Objects.equals(this.__revenue, o.getRevenue())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getRevenue() != null) sb.append(__wrapDecimal(count++, "revenue", getRevenue()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("revenue")) != null) setRevenue(__getDecimal(val));  
	}

	protected java.math.BigDecimal  __revenue ;
}
