package pomplatform.employee.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseResignEmployeeEachYear extends GenericBase implements BaseFactory<BaseResignEmployeeEachYear>, Comparable<BaseResignEmployeeEachYear> 
{


	public static BaseResignEmployeeEachYear newInstance(){
		return new BaseResignEmployeeEachYear();
	}

	@Override
	public BaseResignEmployeeEachYear make(){
		BaseResignEmployeeEachYear b = new BaseResignEmployeeEachYear();
		return b;
	}

	public final static String CS_PARENT_ID = "parent_id" ;
	public final static String CS_YEAR = "year" ;
	public final static String CS_AMOUNT = "amount" ;

	public final static String ALL_CAPTIONS = "业务部门,年份,离职人数";

	public Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( Integer value ) {
		this.__parent_id = value;
	}

	public Double getYear() {
		return this.__year;
	}

	public void setYear( Double value ) {
		this.__year = value;
	}

	public Long getAmount() {
		return this.__amount;
	}

	public void setAmount( Long value ) {
		this.__amount = value;
	}

	public void cloneCopy(BaseResignEmployeeEachYear __bean){
		__bean.setParentId(getParentId());
		__bean.setYear(getYear());
		__bean.setAmount(getAmount());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseResignEmployeeEachYear o) {
		return __parent_id == null ? -1 : __parent_id.compareTo(o.getParentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseResignEmployeeEachYear o = (BaseResignEmployeeEachYear)obj;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getAmount() != null) sb.append(__wrapNumber(count++, "amount", getAmount()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getParentId() != null) res.put("parentId", getParentId());
		if(getYear() != null) res.put("year", getYear());
		if(getAmount() != null) res.put("amount", getAmount());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getDouble(val)); 
		if((val = values.get("amount")) != null) setAmount(__getLong(val)); 
	}

	protected Integer  __parent_id ;
	protected Double  __year ;
	protected Long  __amount ;
}
