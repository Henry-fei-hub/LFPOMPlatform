package pomplatform.salary.bean;

import java.util.*;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseRepeatAnnualLeave extends GenericBase implements BaseFactory<BaseRepeatAnnualLeave>, Comparable<BaseRepeatAnnualLeave> 
{


	public static BaseRepeatAnnualLeave newInstance(){
		return new BaseRepeatAnnualLeave();
	}

	@Override
	public BaseRepeatAnnualLeave make(){
		BaseRepeatAnnualLeave b = new BaseRepeatAnnualLeave();
		return b;
	}

	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_YEAR = "year" ;
	public final static String CS_NUM = "num" ;
	public final static String CS_ID = "id" ;

	public final static String NAME_EMPLOYEE_ID = "employeeId" ;
	public final static String NAME_YEAR = "year" ;
	public final static String NAME_NUM = "num" ;
	public final static String NAME_ID = "id" ;

	public final static java.lang.String ALL_CAPTIONS = "申请人编码,年份,,";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Long getNum() {
		return this.__num;
	}

	public void setNum( java.lang.Long value ) {
		this.__num = value;
	}

	public java.lang.Integer getId() {
		return this.__id;
	}

	public void setId( java.lang.Integer value ) {
		this.__id = value;
	}

	public static String getKeyColumnName() {
		String name ="";
		return name;
	}

	public void cloneCopy(BaseRepeatAnnualLeave __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setYear(getYear());
		__bean.setNum(getNum());
		__bean.setId(getId());
		__bean.setPageLines(getPageLines());
		__bean.setCurrentPage(getCurrentPage());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getNum() == null ? "" : getNum());
		sb.append(",");
		sb.append(getId() == null ? "" : getId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseRepeatAnnualLeave o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__num);
		hash = 97 * hash + Objects.hashCode(this.__id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseRepeatAnnualLeave o = (BaseRepeatAnnualLeave)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__num, o.getNum())) return false;
		if(!Objects.equals(this.__id, o.getId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		return toJSONString(false);
	}

	@Override
	public java.lang.String toJSONString(boolean outDefault) {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_EMPLOYEE_ID, getEmployeeId()));
		if(getYear() != null || outDefault) sb.append(__wrapNumber(count++, NAME_YEAR, getYear()));
		if(getNum() != null || outDefault) sb.append(__wrapNumber(count++, NAME_NUM, getNum()));
		if(getId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_ID, getId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeId() != null) res.put(NAME_EMPLOYEE_ID, getEmployeeId());
		if(getYear() != null) res.put(NAME_YEAR, getYear());
		if(getNum() != null) res.put(NAME_NUM, getNum());
		if(getId() != null) res.put(NAME_ID, getId());
		if(getCurrentPage() > 0) {
			res.put(NAME_CURRENT_PAGE, getCurrentPage());
			res.put(NAME_PAGE_LINES, getPageLines());
		}
		return res;
	}

	public static List<Map<String, Object>> GenerateMapList(List<BaseRepeatAnnualLeave> ol) {
		List<Map<String, Object>> res = new ArrayList<>();
		for(BaseRepeatAnnualLeave b : ol) res.add(b.toMap());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if(values.containsKey(NAME_CURRENT_PAGE) && (val = values.get(NAME_CURRENT_PAGE)) != null) setCurrentPage(__getInt(val));
		if(values.containsKey(NAME_PAGE_LINES) && (val = values.get(NAME_PAGE_LINES)) != null) setPageLines(__getInt(val));
		if(values.containsKey(NAME_EMPLOYEE_ID) && (val = values.get(NAME_EMPLOYEE_ID)) != null) setEmployeeId(__getInt(val)); 
		if(values.containsKey(NAME_YEAR) && (val = values.get(NAME_YEAR)) != null) setYear(__getInt(val)); 
		if(values.containsKey(NAME_NUM) && (val = values.get(NAME_NUM)) != null) setNum(__getLong(val)); 
		if(values.containsKey(NAME_ID) && (val = values.get(NAME_ID)) != null) setId(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Long  __num ;
	protected java.lang.Integer  __id ;
}
