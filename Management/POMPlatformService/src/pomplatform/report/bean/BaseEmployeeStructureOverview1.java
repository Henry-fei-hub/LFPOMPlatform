package pomplatform.report.bean;

import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeeStructureOverview1 extends GenericBase implements BaseFactory<BaseEmployeeStructureOverview1>, Comparable<BaseEmployeeStructureOverview1> 
{


	public static BaseEmployeeStructureOverview1 newInstance(){
		return new BaseEmployeeStructureOverview1();
	}

	@Override
	public BaseEmployeeStructureOverview1 make(){
		BaseEmployeeStructureOverview1 b = new BaseEmployeeStructureOverview1();
		return b;
	}

	public final static String CS_A = "a" ;
	public final static String CS_B = "b" ;
	public final static String CS_A_1 = "a_1" ;
	public final static String CS_ROUND = "round" ;

	public final static String ALL_CAPTIONS = "职级,,人数,round";

	public Integer getA() {
		return this.__a;
	}

	public void setA( Integer value ) {
		this.__a = value;
	}

	public String getB() {
		return this.__b;
	}

	public void setB( String value ) {
		this.__b = value;
	}

	public Integer getA1() {
		return this.__a_1;
	}

	public void setA1( Integer value ) {
		this.__a_1 = value;
	}

	public java.math.BigDecimal getRound() {
		return this.__round;
	}

	public void setRound( java.math.BigDecimal value ) {
		this.__round = value;
	}

	public void cloneCopy(BaseEmployeeStructureOverview1 __bean){
		__bean.setA(getA());
		__bean.setB(getB());
		__bean.setA1(getA1());
		__bean.setRound(getRound());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		if(BaseHelpUtils.isNullOrEmpty(getB())){
			return sb.toString();
		}
		sb.append("");
//		sb.append(",");
		sb.append(getB() == null ? "" : "职级("+getB()+")");
		sb.append(",");
		sb.append(getA1() == null ? "" : getA1());
		sb.append(",");
		sb.append(getRound() == null ? "" : getRound().multiply(new BigDecimal(100))+"%");
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeStructureOverview1 o) {
		return __a == null ? -1 : __a.compareTo(o.getA());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__a);
		hash = 97 * hash + Objects.hashCode(this.__b);
		hash = 97 * hash + Objects.hashCode(this.__a_1);
		hash = 97 * hash + Objects.hashCode(this.__round);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeStructureOverview1 o = (BaseEmployeeStructureOverview1)obj;
		if(!Objects.equals(this.__a, o.getA())) return false;
		if(!Objects.equals(this.__b, o.getB())) return false;
		if(!Objects.equals(this.__a_1, o.getA1())) return false;
		if(!Objects.equals(this.__round, o.getRound())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getA() != null) sb.append(__wrapNumber(count++, "a", getA()));
		if(getB() != null) sb.append(__wrapString(count++, "b", getB()));
		if(getA1() != null) sb.append(__wrapNumber(count++, "a1", getA1()));
		if(getRound() != null) sb.append(__wrapDecimal(count++, "round", getRound()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getA() != null) res.put("a", getA());
		if(getB() != null) res.put("b", getB());
		if(getA1() != null) res.put("a1", getA1());
		if(getRound() != null) res.put("round", getRound());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("a")) != null) setA(__getInt(val)); 
		if((val = values.get("b")) != null) setB(__getString(val));
		if((val = values.get("a1")) != null) setA1(__getInt(val));
		if((val = values.get("round")) != null) setRound(__getDecimal(val));  
	}

	protected Integer  __a ;
	protected String  __b ;
	protected Integer  __a_1 ;
	protected java.math.BigDecimal  __round ;
}
