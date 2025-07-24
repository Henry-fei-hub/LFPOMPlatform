package pomplatform.report.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseReportEmployeeWorkYears extends GenericBase implements BaseFactory<BaseReportEmployeeWorkYears>, Comparable<BaseReportEmployeeWorkYears> 
{


	public static BaseReportEmployeeWorkYears newInstance(){
		return new BaseReportEmployeeWorkYears();
	}

	@Override
	public BaseReportEmployeeWorkYears make(){
		BaseReportEmployeeWorkYears b = new BaseReportEmployeeWorkYears();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_ONE_INNER = "one_inner" ;
	public final static java.lang.String CS_ONE_INNER_PERCENT = "one_inner_percent" ;
	public final static java.lang.String CS_THREE_INNER = "three_inner" ;
	public final static java.lang.String CS_THREE_INNER_PERCENT = "three_inner_percent" ;
	public final static java.lang.String CS_FIVE_INNER = "five_inner" ;
	public final static java.lang.String CS_FIVE_INNER_PERCENT = "five_inner_percent" ;
	public final static java.lang.String CS_TEN_INNER = "ten_inner" ;
	public final static java.lang.String CS_TEN_INNER_PERCENT = "ten_inner_percent" ;
	public final static java.lang.String CS_TEN_ADD = "ten_add" ;
	public final static java.lang.String CS_TEN_ADD_PERCENT = "ten_add_percent" ;
	public final static java.lang.String CS_TOTAL = "total" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,1年以下人数,1年以下占比,1~3年人数,1~3年占比,3~5人数,3~5占比,5~10人数,5~10占比,10年及以上人数,10年及以上占比,人数合计";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getOneInner() {
		return this.__one_inner;
	}

	public void setOneInner( java.lang.Integer value ) {
		this.__one_inner = value;
	}

	public java.lang.String getOneInnerPercent() {
		return this.__one_inner_percent;
	}

	public void setOneInnerPercent( java.lang.String value ) {
		this.__one_inner_percent = value;
	}

	public java.lang.Integer getThreeInner() {
		return this.__three_inner;
	}

	public void setThreeInner( java.lang.Integer value ) {
		this.__three_inner = value;
	}

	public java.lang.String getThreeInnerPercent() {
		return this.__three_inner_percent;
	}

	public void setThreeInnerPercent( java.lang.String value ) {
		this.__three_inner_percent = value;
	}

	public java.lang.Integer getFiveInner() {
		return this.__five_inner;
	}

	public void setFiveInner( java.lang.Integer value ) {
		this.__five_inner = value;
	}

	public java.lang.String getFiveInnerPercent() {
		return this.__five_inner_percent;
	}

	public void setFiveInnerPercent( java.lang.String value ) {
		this.__five_inner_percent = value;
	}

	public java.lang.Integer getTenInner() {
		return this.__ten_inner;
	}

	public void setTenInner( java.lang.Integer value ) {
		this.__ten_inner = value;
	}

	public java.lang.String getTenInnerPercent() {
		return this.__ten_inner_percent;
	}

	public void setTenInnerPercent( java.lang.String value ) {
		this.__ten_inner_percent = value;
	}

	public java.lang.Integer getTenAdd() {
		return this.__ten_add;
	}

	public void setTenAdd( java.lang.Integer value ) {
		this.__ten_add = value;
	}

	public java.lang.String getTenAddPercent() {
		return this.__ten_add_percent;
	}

	public void setTenAddPercent( java.lang.String value ) {
		this.__ten_add_percent = value;
	}

	public java.lang.Integer getTotal() {
		return this.__total;
	}

	public void setTotal( java.lang.Integer value ) {
		this.__total = value;
	}

	public void cloneCopy(BaseReportEmployeeWorkYears __bean){
		__bean.setPlateId(getPlateId());
		__bean.setOneInner(getOneInner());
		__bean.setOneInnerPercent(getOneInnerPercent());
		__bean.setThreeInner(getThreeInner());
		__bean.setThreeInnerPercent(getThreeInnerPercent());
		__bean.setFiveInner(getFiveInner());
		__bean.setFiveInnerPercent(getFiveInnerPercent());
		__bean.setTenInner(getTenInner());
		__bean.setTenInnerPercent(getTenInnerPercent());
		__bean.setTenAdd(getTenAdd());
		__bean.setTenAddPercent(getTenAddPercent());
		__bean.setTotal(getTotal());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getOneInner() == null ? "" : getOneInner());
		sb.append(",");
		sb.append(getOneInnerPercent() == null ? "" : getOneInnerPercent());
		sb.append(",");
		sb.append(getThreeInner() == null ? "" : getThreeInner());
		sb.append(",");
		sb.append(getThreeInnerPercent() == null ? "" : getThreeInnerPercent());
		sb.append(",");
		sb.append(getFiveInner() == null ? "" : getFiveInner());
		sb.append(",");
		sb.append(getFiveInnerPercent() == null ? "" : getFiveInnerPercent());
		sb.append(",");
		sb.append(getTenInner() == null ? "" : getTenInner());
		sb.append(",");
		sb.append(getTenInnerPercent() == null ? "" : getTenInnerPercent());
		sb.append(",");
		sb.append(getTenAdd() == null ? "" : getTenAdd());
		sb.append(",");
		sb.append(getTenAddPercent() == null ? "" : getTenAddPercent());
		sb.append(",");
		sb.append(getTotal() == null ? "" : getTotal());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReportEmployeeWorkYears o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__one_inner);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_percent);
		hash = 97 * hash + Objects.hashCode(this.__three_inner);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_percent);
		hash = 97 * hash + Objects.hashCode(this.__five_inner);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_percent);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_percent);
		hash = 97 * hash + Objects.hashCode(this.__ten_add);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_percent);
		hash = 97 * hash + Objects.hashCode(this.__total);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReportEmployeeWorkYears o = (BaseReportEmployeeWorkYears)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__one_inner, o.getOneInner())) return false;
		if(!Objects.equals(this.__one_inner_percent, o.getOneInnerPercent())) return false;
		if(!Objects.equals(this.__three_inner, o.getThreeInner())) return false;
		if(!Objects.equals(this.__three_inner_percent, o.getThreeInnerPercent())) return false;
		if(!Objects.equals(this.__five_inner, o.getFiveInner())) return false;
		if(!Objects.equals(this.__five_inner_percent, o.getFiveInnerPercent())) return false;
		if(!Objects.equals(this.__ten_inner, o.getTenInner())) return false;
		if(!Objects.equals(this.__ten_inner_percent, o.getTenInnerPercent())) return false;
		if(!Objects.equals(this.__ten_add, o.getTenAdd())) return false;
		if(!Objects.equals(this.__ten_add_percent, o.getTenAddPercent())) return false;
		if(!Objects.equals(this.__total, o.getTotal())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getOneInner() != null) sb.append(__wrapNumber(count++, "oneInner", getOneInner()));
		if(getOneInnerPercent() != null) sb.append(__wrapString(count++, "oneInnerPercent", getOneInnerPercent()));
		if(getThreeInner() != null) sb.append(__wrapNumber(count++, "threeInner", getThreeInner()));
		if(getThreeInnerPercent() != null) sb.append(__wrapString(count++, "threeInnerPercent", getThreeInnerPercent()));
		if(getFiveInner() != null) sb.append(__wrapNumber(count++, "fiveInner", getFiveInner()));
		if(getFiveInnerPercent() != null) sb.append(__wrapString(count++, "fiveInnerPercent", getFiveInnerPercent()));
		if(getTenInner() != null) sb.append(__wrapNumber(count++, "tenInner", getTenInner()));
		if(getTenInnerPercent() != null) sb.append(__wrapString(count++, "tenInnerPercent", getTenInnerPercent()));
		if(getTenAdd() != null) sb.append(__wrapNumber(count++, "tenAdd", getTenAdd()));
		if(getTenAddPercent() != null) sb.append(__wrapString(count++, "tenAddPercent", getTenAddPercent()));
		if(getTotal() != null) sb.append(__wrapNumber(count++, "total", getTotal()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("oneInner")) != null) setOneInner(__getInt(val)); 
		if((val = values.get("oneInnerPercent")) != null) setOneInnerPercent(__getString(val));
		if((val = values.get("threeInner")) != null) setThreeInner(__getInt(val)); 
		if((val = values.get("threeInnerPercent")) != null) setThreeInnerPercent(__getString(val));
		if((val = values.get("fiveInner")) != null) setFiveInner(__getInt(val)); 
		if((val = values.get("fiveInnerPercent")) != null) setFiveInnerPercent(__getString(val));
		if((val = values.get("tenInner")) != null) setTenInner(__getInt(val)); 
		if((val = values.get("tenInnerPercent")) != null) setTenInnerPercent(__getString(val));
		if((val = values.get("tenAdd")) != null) setTenAdd(__getInt(val)); 
		if((val = values.get("tenAddPercent")) != null) setTenAddPercent(__getString(val));
		if((val = values.get("total")) != null) setTotal(__getInt(val)); 
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __one_inner ;
	protected java.lang.String  __one_inner_percent ;
	protected java.lang.Integer  __three_inner ;
	protected java.lang.String  __three_inner_percent ;
	protected java.lang.Integer  __five_inner ;
	protected java.lang.String  __five_inner_percent ;
	protected java.lang.Integer  __ten_inner ;
	protected java.lang.String  __ten_inner_percent ;
	protected java.lang.Integer  __ten_add ;
	protected java.lang.String  __ten_add_percent ;
	protected java.lang.Integer  __total ;
}
