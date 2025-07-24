package pomplatform.costallocation.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCarCostAllocationEachMonth extends GenericBase implements BaseFactory<BaseCarCostAllocationEachMonth>, Comparable<BaseCarCostAllocationEachMonth> 
{


	public static BaseCarCostAllocationEachMonth newInstance(){
		return new BaseCarCostAllocationEachMonth();
	}

	@Override
	public BaseCarCostAllocationEachMonth make(){
		BaseCarCostAllocationEachMonth b = new BaseCarCostAllocationEachMonth();
		return b;
	}

	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_START_DATE_DETAIL = "start_date_detail" ;
	public final static java.lang.String CS_ID = "id" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_COST = "cost" ;

	public final static java.lang.String ALL_CAPTIONS = "年份,月份,费用类型,部门或者项目编码,编号,费用承担主体,成本";

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.lang.Integer getStartDateDetail() {
		return this.__start_date_detail;
	}

	public void setStartDateDetail( java.lang.Integer value ) {
		this.__start_date_detail = value;
	}

	public java.lang.Integer getId() {
		return this.__id;
	}

	public void setId( java.lang.Integer value ) {
		this.__id = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.String getName() {
		return this.__name;
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.math.BigDecimal getCost() {
		return this.__cost;
	}

	public void setCost( java.math.BigDecimal value ) {
		this.__cost = value;
	}

	public void cloneCopy(BaseCarCostAllocationEachMonth __bean){
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setStartDateDetail(getStartDateDetail());
		__bean.setId(getId());
		__bean.setCode(getCode());
		__bean.setName(getName());
		__bean.setCost(getCost());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strYear = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_18", String.valueOf(getYear()));
		sb.append(strYear == null ? "" : strYear);
		sb.append(",");
		String strMonth = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_19", String.valueOf(getMonth()));
		sb.append(strMonth == null ? "" : strMonth);
		sb.append(",");
		sb.append(getStartDateDetail() == null ? "" : getStartDateDetail());
		sb.append(",");
		sb.append(getId() == null ? "" : getId());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		sb.append(getCost() == null ? "" : getCost());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCarCostAllocationEachMonth o) {
		return __year == null ? -1 : __year.compareTo(o.getYear());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__start_date_detail);
		hash = 97 * hash + Objects.hashCode(this.__id);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__cost);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCarCostAllocationEachMonth o = (BaseCarCostAllocationEachMonth)obj;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__start_date_detail, o.getStartDateDetail())) return false;
		if(!Objects.equals(this.__id, o.getId())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__cost, o.getCost())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getStartDateDetail() != null) sb.append(__wrapNumber(count++, "startDateDetail", getStartDateDetail()));
		if(getId() != null) sb.append(__wrapNumber(count++, "id", getId()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getCost() != null) sb.append(__wrapDecimal(count++, "cost", getCost()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("startDateDetail")) != null) setStartDateDetail(__getInt(val)); 
		if((val = values.get("id")) != null) setId(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("cost")) != null) setCost(__getDecimal(val));  
	}

	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.Integer  __start_date_detail ;
	protected java.lang.Integer  __id ;
	protected java.lang.String  __code ;
	protected java.lang.String  __name ;
	protected java.math.BigDecimal  __cost ;
}
