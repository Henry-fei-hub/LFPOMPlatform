package pomplatform.report.bean;

import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeeStructureOverview extends GenericBase implements BaseFactory<BaseEmployeeStructureOverview>, Comparable<BaseEmployeeStructureOverview> 
{


	public static BaseEmployeeStructureOverview newInstance(){
		return new BaseEmployeeStructureOverview();
	}

	@Override
	public BaseEmployeeStructureOverview make(){
		BaseEmployeeStructureOverview b = new BaseEmployeeStructureOverview();
		return b;
	}

	public final static String CS_A = "a" ;
	public final static String CS_A_1 = "a_1" ;
	public final static String CS_ROUND = "round" ;

	public final static String ALL_CAPTIONS = "维度,人数,比例";

	public Integer getA() {
		return this.__a;
	}

	public void setA( Integer value ) {
		this.__a = value;
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

	public void cloneCopy(BaseEmployeeStructureOverview __bean){
		__bean.setA(getA());
		__bean.setA1(getA1());
		__bean.setRound(getRound());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		Map<String,Object> map = new HashMap<>();
		map.put("0","总人数");

		map.put("1","男");
		map.put("2","女");

		map.put("3","中共党员");
		map.put("4","团员");
		map.put("5","群众");
		map.put("6","其他");

		map.put("7","0-25岁");
		map.put("8","26-30岁");
		map.put("9","31-40岁");
		map.put("10","51-60岁");
		map.put("11",">60岁");
//		map.put("12","其他岁");

		map.put("13","工龄0-4年");
		map.put("14","工龄5-10年");
		map.put("15","工龄11年以上");
//		map.put("16","其他工龄");

		map.put("17","司龄0-4年");
		map.put("18","司龄5-10年");
		map.put("19","司龄11年以上");
//		map.put("20","其他司龄");

		map.put("20","博士");
		map.put("21","硕士");
		map.put("22","本科");
		map.put("23","大专及其他");
		sb.append(getA() == null ? "" : map.get(BaseHelpUtils.getString(getA())));
		sb.append(",");
		sb.append(getA1() == null ? "" : getA1());
		sb.append(",");
		sb.append(getRound() == null ? "" : getRound().multiply(new BigDecimal(100))+"%");
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeStructureOverview o) {
		return __a == null ? -1 : __a.compareTo(o.getA());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__a);
		hash = 97 * hash + Objects.hashCode(this.__a_1);
		hash = 97 * hash + Objects.hashCode(this.__round);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeStructureOverview o = (BaseEmployeeStructureOverview)obj;
		if(!Objects.equals(this.__a, o.getA())) return false;
		if(!Objects.equals(this.__a_1, o.getA1())) return false;
		if(!Objects.equals(this.__round, o.getRound())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getA() != null) sb.append(__wrapNumber(count++, "a", getA()));
		if(getA1() != null) sb.append(__wrapNumber(count++, "a1", getA1()));
		if(getRound() != null) sb.append(__wrapDecimal(count++, "round", getRound()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getA() != null) res.put("a", getA());
		if(getA1() != null) res.put("a1", getA1());
		if(getRound() != null) res.put("round", getRound());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("a")) != null) setA(__getInt(val)); 
		if((val = values.get("a1")) != null) setA1(__getInt(val)); 
		if((val = values.get("round")) != null) setRound(__getDecimal(val));  
	}

	protected Integer  __a ;
	protected Integer  __a_1 ;
	protected java.math.BigDecimal  __round ;
}
