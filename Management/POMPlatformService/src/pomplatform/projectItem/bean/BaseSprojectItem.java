package pomplatform.projectItem.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSprojectItem extends GenericBase implements BaseFactory<BaseSprojectItem>, Comparable<BaseSprojectItem> 
{


	public static BaseSprojectItem newInstance(){
		return new BaseSprojectItem();
	}

	@Override
	public BaseSprojectItem make(){
		BaseSprojectItem b = new BaseSprojectItem();
		return b;
	}

	public final static java.lang.String CS_IDD = "idd" ;
	public final static java.lang.String CS_VAL = "val" ;

	public final static java.lang.String ALL_CAPTIONS = "id,name";

	public java.lang.Integer getIdd() {
		return this.__idd;
	}

	public void setIdd( java.lang.Integer value ) {
		this.__idd = value;
	}

	public java.lang.String getVal() {
		return this.__val;
	}

	public void setVal( java.lang.String value ) {
		this.__val = value;
	}

	public void cloneCopy(BaseSprojectItem __bean){
		__bean.setIdd(getIdd());
		__bean.setVal(getVal());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getIdd() == null ? "" : getIdd());
		sb.append(",");
		sb.append(getVal() == null ? "" : getVal());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSprojectItem o) {
		return __idd == null ? -1 : __idd.compareTo(o.getIdd());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__idd);
		hash = 97 * hash + Objects.hashCode(this.__val);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSprojectItem o = (BaseSprojectItem)obj;
		if(!Objects.equals(this.__idd, o.getIdd())) return false;
		if(!Objects.equals(this.__val, o.getVal())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getIdd() != null) sb.append(__wrapNumber(count++, "idd", getIdd()));
		if(getVal() != null) sb.append(__wrapString(count++, "val", getVal()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("idd")) != null) setIdd(__getInt(val)); 
		if((val = values.get("val")) != null) setVal(__getString(val));
	}

	protected java.lang.Integer  __idd ;
	protected java.lang.String  __val ;
}
