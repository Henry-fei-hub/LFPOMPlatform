package pomplatform.report.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeeStructureOverview2 extends GenericBase implements BaseFactory<BaseEmployeeStructureOverview2>, Comparable<BaseEmployeeStructureOverview2> 
{


	public static BaseEmployeeStructureOverview2 newInstance(){
		return new BaseEmployeeStructureOverview2();
	}

	@Override
	public BaseEmployeeStructureOverview2 make(){
		BaseEmployeeStructureOverview2 b = new BaseEmployeeStructureOverview2();
		return b;
	}

	public final static String CS_YEAR = "year" ;
	public final static String CS_EMP_NUM = "emp_num" ;
	public final static String CS_TOTAL_NUM = "total_num" ;
	public final static String CS_PERCENT = "percent" ;

	public final static String ALL_CAPTIONS = ",,,";

	public Double getYear() {
		return this.__year;
	}

	public void setYear( Double value ) {
		this.__year = value;
	}

	public Long getEmpNum() {
		return this.__emp_num;
	}

	public void setEmpNum( Long value ) {
		this.__emp_num = value;
	}

	public Long getTotalNum() {
		return this.__total_num;
	}

	public void setTotalNum( Long value ) {
		this.__total_num = value;
	}

	public java.math.BigDecimal getPercent() {
		return this.__percent;
	}

	public void setPercent( java.math.BigDecimal value ) {
		this.__percent = value;
	}

	public void cloneCopy(BaseEmployeeStructureOverview2 __bean){
		__bean.setYear(getYear());
		__bean.setEmpNum(getEmpNum());
		__bean.setTotalNum(getTotalNum());
		__bean.setPercent(getPercent());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getEmpNum() == null ? "" : getEmpNum());
		sb.append(",");
		sb.append(getTotalNum() == null ? "" : getTotalNum());
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeStructureOverview2 o) {
		return __year == null ? -1 : __year.compareTo(o.getYear());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__emp_num);
		hash = 97 * hash + Objects.hashCode(this.__total_num);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeStructureOverview2 o = (BaseEmployeeStructureOverview2)obj;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__emp_num, o.getEmpNum())) return false;
		if(!Objects.equals(this.__total_num, o.getTotalNum())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getEmpNum() != null) sb.append(__wrapNumber(count++, "empNum", getEmpNum()));
		if(getTotalNum() != null) sb.append(__wrapNumber(count++, "totalNum", getTotalNum()));
		if(getPercent() != null) sb.append(__wrapDecimal(count++, "percent", getPercent()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getYear() != null) res.put("year", getYear());
		if(getEmpNum() != null) res.put("empNum", getEmpNum());
		if(getTotalNum() != null) res.put("totalNum", getTotalNum());
		if(getPercent() != null) res.put("percent", getPercent());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("year")) != null) setYear(__getDouble(val)); 
		if((val = values.get("empNum")) != null) setEmpNum(__getLong(val)); 
		if((val = values.get("totalNum")) != null) setTotalNum(__getLong(val)); 
		if((val = values.get("percent")) != null) setPercent(__getDecimal(val));  
	}

	protected Double  __year ;
	protected Long  __emp_num ;
	protected Long  __total_num ;
	protected java.math.BigDecimal  __percent ;
}
