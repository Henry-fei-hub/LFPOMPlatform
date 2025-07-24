package pomplatform.payment.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCurrentMonthSalaryType extends GenericBase implements BaseFactory<BaseCurrentMonthSalaryType>, Comparable<BaseCurrentMonthSalaryType> 
{


	public static BaseCurrentMonthSalaryType newInstance(){
		return new BaseCurrentMonthSalaryType();
	}

	@Override
	public BaseCurrentMonthSalaryType make(){
		BaseCurrentMonthSalaryType b = new BaseCurrentMonthSalaryType();
		return b;
	}

	public final static java.lang.String CS_FUNDRAISING_PROJECT_TYPE = "fundraising_project_type" ;

	public final static java.lang.String ALL_CAPTIONS = "募投项目类型";

	public java.lang.Integer getFundraisingProjectType() {
		return this.__fundraising_project_type;
	}

	public void setFundraisingProjectType( java.lang.Integer value ) {
		this.__fundraising_project_type = value;
	}

	public void cloneCopy(BaseCurrentMonthSalaryType __bean){
		__bean.setFundraisingProjectType(getFundraisingProjectType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFundraisingProjectType() == null ? "" : getFundraisingProjectType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCurrentMonthSalaryType o) {
		return __fundraising_project_type == null ? -1 : __fundraising_project_type.compareTo(o.getFundraisingProjectType());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__fundraising_project_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCurrentMonthSalaryType o = (BaseCurrentMonthSalaryType)obj;
		if(!Objects.equals(this.__fundraising_project_type, o.getFundraisingProjectType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFundraisingProjectType() != null) sb.append(__wrapNumber(count++, "fundraisingProjectType", getFundraisingProjectType()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getFundraisingProjectType() != null) res.put("fundraisingProjectType", getFundraisingProjectType());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("fundraisingProjectType")) != null) setFundraisingProjectType(__getInt(val)); 
	}

	protected java.lang.Integer  __fundraising_project_type ;
}
