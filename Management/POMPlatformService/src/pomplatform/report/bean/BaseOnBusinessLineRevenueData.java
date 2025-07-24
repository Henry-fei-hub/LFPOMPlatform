package pomplatform.report.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnBusinessLineRevenueData extends GenericBase implements BaseFactory<BaseOnBusinessLineRevenueData>, Comparable<BaseOnBusinessLineRevenueData> 
{


	public static BaseOnBusinessLineRevenueData newInstance(){
		return new BaseOnBusinessLineRevenueData();
	}

	@Override
	public BaseOnBusinessLineRevenueData make(){
		BaseOnBusinessLineRevenueData b = new BaseOnBusinessLineRevenueData();
		return b;
	}

	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PLATE_NAME = "plate_name" ;
	public final static java.lang.String CS_PARENT_NAME = "parent_name" ;
	public final static java.lang.String CS_CURRENT_REVENUE_ONE = "current_revenue_one" ;
	public final static java.lang.String CS_CURRENT_REVENUE_TWO = "current_revenue_two" ;
	public final static java.lang.String CS_CURRENT_REVENUE_THREE = "current_revenue_three" ;
	public final static java.lang.String CS_CURRENT_REVENUE_FOUR = "current_revenue_four" ;
	public final static java.lang.String CS_CURRENT_REVENUE_FIVE = "current_revenue_five" ;
	public final static java.lang.String CS_CURRENT_REVENUE_SIX = "current_revenue_six" ;
	public final static java.lang.String CS_CURRENT_REVENUE_SEVEN = "current_revenue_seven" ;
	public final static java.lang.String CS_CURRENT_REVENUE_EIGHT = "current_revenue_eight" ;
	public final static java.lang.String CS_CURRENT_REVENUE_NINE = "current_revenue_nine" ;
	public final static java.lang.String CS_CURRENT_REVENUE_TEN = "current_revenue_ten" ;

	public final static java.lang.String ALL_CAPTIONS = "父级Id,业务部门Id,业务部门,上级部门名称,商业,酒店,办公,轨道交通,医养,公共建筑,综合体,住宅,采买,其他";
	public final static java.lang.String CAPTIONS = "业务部门,商业,酒店,办公,轨道交通,医养,机电,杰拓设计,地产,其他";

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.String getPlateName() {
		return this.__plate_name;
	}

	public void setPlateName( java.lang.String value ) {
		this.__plate_name = value;
	}

	public java.lang.String getParentName() {
		return this.__parent_name;
	}

	public void setParentName( java.lang.String value ) {
		this.__parent_name = value;
	}

	public java.math.BigDecimal getCurrentRevenueOne() {
		return this.__current_revenue_one;
	}

	public void setCurrentRevenueOne( java.math.BigDecimal value ) {
		this.__current_revenue_one = value;
	}

	public java.math.BigDecimal getCurrentRevenueTwo() {
		return this.__current_revenue_two;
	}

	public void setCurrentRevenueTwo( java.math.BigDecimal value ) {
		this.__current_revenue_two = value;
	}

	public java.math.BigDecimal getCurrentRevenueThree() {
		return this.__current_revenue_three;
	}

	public void setCurrentRevenueThree( java.math.BigDecimal value ) {
		this.__current_revenue_three = value;
	}

	public java.math.BigDecimal getCurrentRevenueFour() {
		return this.__current_revenue_four;
	}

	public void setCurrentRevenueFour( java.math.BigDecimal value ) {
		this.__current_revenue_four = value;
	}

	public java.math.BigDecimal getCurrentRevenueFive() {
		return this.__current_revenue_five;
	}

	public void setCurrentRevenueFive( java.math.BigDecimal value ) {
		this.__current_revenue_five = value;
	}

	public java.math.BigDecimal getCurrentRevenueSix() {
		return this.__current_revenue_six;
	}

	public void setCurrentRevenueSix( java.math.BigDecimal value ) {
		this.__current_revenue_six = value;
	}

	public java.math.BigDecimal getCurrentRevenueSeven() {
		return this.__current_revenue_seven;
	}

	public void setCurrentRevenueSeven( java.math.BigDecimal value ) {
		this.__current_revenue_seven = value;
	}

	public java.math.BigDecimal getCurrentRevenueEight() {
		return this.__current_revenue_eight;
	}

	public void setCurrentRevenueEight( java.math.BigDecimal value ) {
		this.__current_revenue_eight = value;
	}

	public java.math.BigDecimal getCurrentRevenueNine() {
		return this.__current_revenue_nine;
	}

	public void setCurrentRevenueNine( java.math.BigDecimal value ) {
		this.__current_revenue_nine = value;
	}

	public java.math.BigDecimal getCurrentRevenueTen() {
		return this.__current_revenue_ten;
	}

	public void setCurrentRevenueTen( java.math.BigDecimal value ) {
		this.__current_revenue_ten = value;
	}

	public void cloneCopy(BaseOnBusinessLineRevenueData __bean){
		__bean.setParentId(getParentId());
		__bean.setPlateId(getPlateId());
		__bean.setPlateName(getPlateName());
		__bean.setParentName(getParentName());
		__bean.setCurrentRevenueOne(getCurrentRevenueOne());
		__bean.setCurrentRevenueTwo(getCurrentRevenueTwo());
		__bean.setCurrentRevenueThree(getCurrentRevenueThree());
		__bean.setCurrentRevenueFour(getCurrentRevenueFour());
		__bean.setCurrentRevenueFive(getCurrentRevenueFive());
		__bean.setCurrentRevenueSix(getCurrentRevenueSix());
		__bean.setCurrentRevenueSeven(getCurrentRevenueSeven());
		__bean.setCurrentRevenueEight(getCurrentRevenueEight());
		__bean.setCurrentRevenueNine(getCurrentRevenueNine());
		__bean.setCurrentRevenueTen(getCurrentRevenueTen());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		/*sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");*/
		sb.append(getPlateName() == null ? "" : getPlateName());
		sb.append(",");
		/*sb.append(getParentName() == null ? "" : getParentName());
		sb.append(",");*/
		sb.append(getCurrentRevenueOne() == null ? "" : getCurrentRevenueOne());
		sb.append(",");
		sb.append(getCurrentRevenueTwo() == null ? "" : getCurrentRevenueTwo());
		sb.append(",");
		sb.append(getCurrentRevenueThree() == null ? "" : getCurrentRevenueThree());
		sb.append(",");
		sb.append(getCurrentRevenueFour() == null ? "" : getCurrentRevenueFour());
		sb.append(",");
		sb.append(getCurrentRevenueFive() == null ? "" : getCurrentRevenueFive());
		sb.append(",");
		sb.append(getCurrentRevenueSix() == null ? "" : getCurrentRevenueSix());
		sb.append(",");
		sb.append(getCurrentRevenueSeven() == null ? "" : getCurrentRevenueSeven());
		sb.append(",");
		sb.append(getCurrentRevenueEight() == null ? "" : getCurrentRevenueEight());
		sb.append(",");
		/*sb.append(getCurrentRevenueNine() == null ? "" : getCurrentRevenueNine());
		sb.append(",");*/
		sb.append(getCurrentRevenueTen() == null ? "" : getCurrentRevenueTen());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnBusinessLineRevenueData o) {
		return __parent_id == null ? -1 : __parent_id.compareTo(o.getParentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_name);
		hash = 97 * hash + Objects.hashCode(this.__parent_name);
		hash = 97 * hash + Objects.hashCode(this.__current_revenue_one);
		hash = 97 * hash + Objects.hashCode(this.__current_revenue_two);
		hash = 97 * hash + Objects.hashCode(this.__current_revenue_three);
		hash = 97 * hash + Objects.hashCode(this.__current_revenue_four);
		hash = 97 * hash + Objects.hashCode(this.__current_revenue_five);
		hash = 97 * hash + Objects.hashCode(this.__current_revenue_six);
		hash = 97 * hash + Objects.hashCode(this.__current_revenue_seven);
		hash = 97 * hash + Objects.hashCode(this.__current_revenue_eight);
		hash = 97 * hash + Objects.hashCode(this.__current_revenue_nine);
		hash = 97 * hash + Objects.hashCode(this.__current_revenue_ten);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnBusinessLineRevenueData o = (BaseOnBusinessLineRevenueData)obj;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__plate_name, o.getPlateName())) return false;
		if(!Objects.equals(this.__parent_name, o.getParentName())) return false;
		if(!Objects.equals(this.__current_revenue_one, o.getCurrentRevenueOne())) return false;
		if(!Objects.equals(this.__current_revenue_two, o.getCurrentRevenueTwo())) return false;
		if(!Objects.equals(this.__current_revenue_three, o.getCurrentRevenueThree())) return false;
		if(!Objects.equals(this.__current_revenue_four, o.getCurrentRevenueFour())) return false;
		if(!Objects.equals(this.__current_revenue_five, o.getCurrentRevenueFive())) return false;
		if(!Objects.equals(this.__current_revenue_six, o.getCurrentRevenueSix())) return false;
		if(!Objects.equals(this.__current_revenue_seven, o.getCurrentRevenueSeven())) return false;
		if(!Objects.equals(this.__current_revenue_eight, o.getCurrentRevenueEight())) return false;
		if(!Objects.equals(this.__current_revenue_nine, o.getCurrentRevenueNine())) return false;
		if(!Objects.equals(this.__current_revenue_ten, o.getCurrentRevenueTen())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getPlateName() != null) sb.append(__wrapString(count++, "plateName", getPlateName()));
		if(getParentName() != null) sb.append(__wrapString(count++, "parentName", getParentName()));
		if(getCurrentRevenueOne() != null) sb.append(__wrapDecimal(count++, "currentRevenueOne", getCurrentRevenueOne()));
		if(getCurrentRevenueTwo() != null) sb.append(__wrapDecimal(count++, "currentRevenueTwo", getCurrentRevenueTwo()));
		if(getCurrentRevenueThree() != null) sb.append(__wrapDecimal(count++, "currentRevenueThree", getCurrentRevenueThree()));
		if(getCurrentRevenueFour() != null) sb.append(__wrapDecimal(count++, "currentRevenueFour", getCurrentRevenueFour()));
		if(getCurrentRevenueFive() != null) sb.append(__wrapDecimal(count++, "currentRevenueFive", getCurrentRevenueFive()));
		if(getCurrentRevenueSix() != null) sb.append(__wrapDecimal(count++, "currentRevenueSix", getCurrentRevenueSix()));
		if(getCurrentRevenueSeven() != null) sb.append(__wrapDecimal(count++, "currentRevenueSeven", getCurrentRevenueSeven()));
		if(getCurrentRevenueEight() != null) sb.append(__wrapDecimal(count++, "currentRevenueEight", getCurrentRevenueEight()));
		if(getCurrentRevenueNine() != null) sb.append(__wrapDecimal(count++, "currentRevenueNine", getCurrentRevenueNine()));
		if(getCurrentRevenueTen() != null) sb.append(__wrapDecimal(count++, "currentRevenueTen", getCurrentRevenueTen()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("plateName")) != null) setPlateName(__getString(val));
		if((val = values.get("parentName")) != null) setParentName(__getString(val));
		if((val = values.get("currentRevenueOne")) != null) setCurrentRevenueOne(__getDecimal(val));  
		if((val = values.get("currentRevenueTwo")) != null) setCurrentRevenueTwo(__getDecimal(val));  
		if((val = values.get("currentRevenueThree")) != null) setCurrentRevenueThree(__getDecimal(val));  
		if((val = values.get("currentRevenueFour")) != null) setCurrentRevenueFour(__getDecimal(val));  
		if((val = values.get("currentRevenueFive")) != null) setCurrentRevenueFive(__getDecimal(val));  
		if((val = values.get("currentRevenueSix")) != null) setCurrentRevenueSix(__getDecimal(val));  
		if((val = values.get("currentRevenueSeven")) != null) setCurrentRevenueSeven(__getDecimal(val));  
		if((val = values.get("currentRevenueEight")) != null) setCurrentRevenueEight(__getDecimal(val));  
		if((val = values.get("currentRevenueNine")) != null) setCurrentRevenueNine(__getDecimal(val));  
		if((val = values.get("currentRevenueTen")) != null) setCurrentRevenueTen(__getDecimal(val));  
	}

	protected java.lang.Integer  __parent_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.String  __plate_name ;
	protected java.lang.String  __parent_name ;
	protected java.math.BigDecimal  __current_revenue_one ;
	protected java.math.BigDecimal  __current_revenue_two ;
	protected java.math.BigDecimal  __current_revenue_three ;
	protected java.math.BigDecimal  __current_revenue_four ;
	protected java.math.BigDecimal  __current_revenue_five ;
	protected java.math.BigDecimal  __current_revenue_six ;
	protected java.math.BigDecimal  __current_revenue_seven ;
	protected java.math.BigDecimal  __current_revenue_eight ;
	protected java.math.BigDecimal  __current_revenue_nine ;
	protected java.math.BigDecimal  __current_revenue_ten ;
}
