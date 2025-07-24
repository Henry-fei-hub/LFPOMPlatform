package pomplatform.oa.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseScheckinfoseor extends GenericBase implements BaseFactory<BaseScheckinfoseor>, Comparable<BaseScheckinfoseor> 
{


	public static BaseScheckinfoseor newInstance(){
		return new BaseScheckinfoseor();
	}

	@Override
	public BaseScheckinfoseor make(){
		BaseScheckinfoseor b = new BaseScheckinfoseor();
		return b;
	}

	public final static java.lang.String CS_USERID = "userId" ;
	public final static java.lang.String CS_CHECKDATE = "checkdate" ;
	public final static java.lang.String CS_CHECKIN = "checkin" ;
	public final static java.lang.String CS_CHECKOUT = "checkout" ;

	public final static java.lang.String ALL_CAPTIONS = "userId,,,";

	public java.lang.String getUserid() {
		return this.__userid;
	}

	public void setUserid( java.lang.String value ) {
		this.__userid = value;
	}

	public java.util.Date getCheckdate() {
		return this.__checkdate;
	}

	public void setCheckdate( java.util.Date value ) {
		this.__checkdate = value;
	}

	public java.util.Date getCheckin() {
		return this.__checkin;
	}

	public void setCheckin( java.util.Date value ) {
		this.__checkin = value;
	}

	public java.util.Date getCheckout() {
		return this.__checkout;
	}

	public void setCheckout( java.util.Date value ) {
		this.__checkout = value;
	}

	public void cloneCopy(BaseScheckinfoseor __bean){
		__bean.setUserid(getUserid());
		__bean.setCheckdate(getCheckdate());
		__bean.setCheckin(getCheckin());
		__bean.setCheckout(getCheckout());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getUserid() == null ? "" : getUserid());
		sb.append(",");
		sb.append(getCheckdate() == null ? "" : sdf.format(getCheckdate()));
		sb.append(",");
		sb.append(getCheckin() == null ? "" : sdf.format(getCheckin()));
		sb.append(",");
		sb.append(getCheckout() == null ? "" : sdf.format(getCheckout()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseScheckinfoseor o) {
		return __userid == null ? -1 : __userid.compareTo(o.getUserid());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__userid);
		hash = 97 * hash + Objects.hashCode(this.__checkdate);
		hash = 97 * hash + Objects.hashCode(this.__checkin);
		hash = 97 * hash + Objects.hashCode(this.__checkout);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseScheckinfoseor o = (BaseScheckinfoseor)obj;
		if(!Objects.equals(this.__userid, o.getUserid())) return false;
		if(!Objects.equals(this.__checkdate, o.getCheckdate())) return false;
		if(!Objects.equals(this.__checkin, o.getCheckin())) return false;
		if(!Objects.equals(this.__checkout, o.getCheckout())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getUserid() != null) sb.append(__wrapString(count++, "userid", getUserid()));
		if(getCheckdate() != null) sb.append(__wrapDate(count++, "checkdate", getCheckdate()));
		if(getCheckin() != null) sb.append(__wrapDate(count++, "checkin", getCheckin()));
		if(getCheckout() != null) sb.append(__wrapDate(count++, "checkout", getCheckout()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("userid")) != null) setUserid(__getString(val));
		if((val = values.get("checkdate")) != null) setCheckdate(__getDate(val)); 
		if((val = values.get("checkin")) != null) setCheckin(__getDate(val)); 
		if((val = values.get("checkout")) != null) setCheckout(__getDate(val)); 
	}

	protected java.lang.String  __userid ;
	protected java.util.Date  __checkdate ;
	protected java.util.Date  __checkin ;
	protected java.util.Date  __checkout ;
}
