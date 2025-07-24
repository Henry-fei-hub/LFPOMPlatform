package pomplatform.capatialandinvoice.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseInvoiceReport extends GenericBase implements BaseFactory<BaseInvoiceReport>, Comparable<BaseInvoiceReport> 
{


	public static BaseInvoiceReport newInstance(){
		return new BaseInvoiceReport();
	}

	@Override
	public BaseInvoiceReport make(){
		BaseInvoiceReport b = new BaseInvoiceReport();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PROJECT_MANAGER_ID = "project_manager_id" ;
	public final static java.lang.String CS_ONE = "one" ;
	public final static java.lang.String CS_TWO = "two" ;
	public final static java.lang.String CS_TREE = "tree" ;
	public final static java.lang.String CS_FOUR = "four" ;
	public final static java.lang.String CS_FIVE = "five" ;
	public final static java.lang.String CS_SIX = "six" ;
	public final static java.lang.String CS_TOTAL = "total" ;

	public final static java.lang.String ALL_CAPTIONS = "板块,项目经理编码,,,,,,,";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getProjectManagerId() {
		return this.__project_manager_id;
	}

	public void setProjectManagerId( java.lang.Integer value ) {
		this.__project_manager_id = value;
	}

	public java.math.BigDecimal getOne() {
		return this.__one;
	}

	public void setOne( java.math.BigDecimal value ) {
		this.__one = value;
	}

	public java.math.BigDecimal getTwo() {
		return this.__two;
	}

	public void setTwo( java.math.BigDecimal value ) {
		this.__two = value;
	}

	public java.math.BigDecimal getTree() {
		return this.__tree;
	}

	public void setTree( java.math.BigDecimal value ) {
		this.__tree = value;
	}

	public java.math.BigDecimal getFour() {
		return this.__four;
	}

	public void setFour( java.math.BigDecimal value ) {
		this.__four = value;
	}

	public java.math.BigDecimal getFive() {
		return this.__five;
	}

	public void setFive( java.math.BigDecimal value ) {
		this.__five = value;
	}

	public java.math.BigDecimal getSix() {
		return this.__six;
	}

	public void setSix( java.math.BigDecimal value ) {
		this.__six = value;
	}

	public java.math.BigDecimal getTotal() {
		return this.__total;
	}

	public void setTotal( java.math.BigDecimal value ) {
		this.__total = value;
	}

	public void cloneCopy(BaseInvoiceReport __bean){
		__bean.setPlateId(getPlateId());
		__bean.setProjectManagerId(getProjectManagerId());
		__bean.setOne(getOne());
		__bean.setTwo(getTwo());
		__bean.setTree(getTree());
		__bean.setFour(getFour());
		__bean.setFive(getFive());
		__bean.setSix(getSix());
		__bean.setTotal(getTotal());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getProjectManagerId() == null ? "" : getProjectManagerId());
		sb.append(",");
		sb.append(getOne() == null ? "" : getOne());
		sb.append(",");
		sb.append(getTwo() == null ? "" : getTwo());
		sb.append(",");
		sb.append(getTree() == null ? "" : getTree());
		sb.append(",");
		sb.append(getFour() == null ? "" : getFour());
		sb.append(",");
		sb.append(getFive() == null ? "" : getFive());
		sb.append(",");
		sb.append(getSix() == null ? "" : getSix());
		sb.append(",");
		sb.append(getTotal() == null ? "" : getTotal());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseInvoiceReport o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__project_manager_id);
		hash = 97 * hash + Objects.hashCode(this.__one);
		hash = 97 * hash + Objects.hashCode(this.__two);
		hash = 97 * hash + Objects.hashCode(this.__tree);
		hash = 97 * hash + Objects.hashCode(this.__four);
		hash = 97 * hash + Objects.hashCode(this.__five);
		hash = 97 * hash + Objects.hashCode(this.__six);
		hash = 97 * hash + Objects.hashCode(this.__total);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseInvoiceReport o = (BaseInvoiceReport)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__project_manager_id, o.getProjectManagerId())) return false;
		if(!Objects.equals(this.__one, o.getOne())) return false;
		if(!Objects.equals(this.__two, o.getTwo())) return false;
		if(!Objects.equals(this.__tree, o.getTree())) return false;
		if(!Objects.equals(this.__four, o.getFour())) return false;
		if(!Objects.equals(this.__five, o.getFive())) return false;
		if(!Objects.equals(this.__six, o.getSix())) return false;
		if(!Objects.equals(this.__total, o.getTotal())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getProjectManagerId() != null) sb.append(__wrapNumber(count++, "projectManagerId", getProjectManagerId()));
		if(getOne() != null) sb.append(__wrapDecimal(count++, "one", getOne()));
		if(getTwo() != null) sb.append(__wrapDecimal(count++, "two", getTwo()));
		if(getTree() != null) sb.append(__wrapDecimal(count++, "tree", getTree()));
		if(getFour() != null) sb.append(__wrapDecimal(count++, "four", getFour()));
		if(getFive() != null) sb.append(__wrapDecimal(count++, "five", getFive()));
		if(getSix() != null) sb.append(__wrapDecimal(count++, "six", getSix()));
		if(getTotal() != null) sb.append(__wrapDecimal(count++, "total", getTotal()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("projectManagerId")) != null) setProjectManagerId(__getInt(val)); 
		if((val = values.get("one")) != null) setOne(__getDecimal(val));  
		if((val = values.get("two")) != null) setTwo(__getDecimal(val));  
		if((val = values.get("tree")) != null) setTree(__getDecimal(val));  
		if((val = values.get("four")) != null) setFour(__getDecimal(val));  
		if((val = values.get("five")) != null) setFive(__getDecimal(val));  
		if((val = values.get("six")) != null) setSix(__getDecimal(val));  
		if((val = values.get("total")) != null) setTotal(__getDecimal(val));  
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __project_manager_id ;
	protected java.math.BigDecimal  __one ;
	protected java.math.BigDecimal  __two ;
	protected java.math.BigDecimal  __tree ;
	protected java.math.BigDecimal  __four ;
	protected java.math.BigDecimal  __five ;
	protected java.math.BigDecimal  __six ;
	protected java.math.BigDecimal  __total ;
}
