package pomplatform.sinvoiceitior.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMinvoicettorunusecount extends GenericBase implements BaseFactory<BaseMinvoicettorunusecount>, Comparable<BaseMinvoicettorunusecount> 
{


	public static BaseMinvoicettorunusecount newInstance(){
		return new BaseMinvoicettorunusecount();
	}

	@Override
	public BaseMinvoicettorunusecount make(){
		BaseMinvoicettorunusecount b = new BaseMinvoicettorunusecount();
		return b;
	}

	public final static java.lang.String CS_TICKETING_COMPANY = "ticketing_company" ;
	public final static java.lang.String CS_ALL_VAL = "all_val" ;

	public final static java.lang.String ALL_CAPTIONS = "购票公司,统计数据";

	public java.lang.Integer getTicketingCompany() {
		return this.__ticketing_company;
	}

	public void setTicketingCompany( java.lang.Integer value ) {
		this.__ticketing_company = value;
	}

	public java.lang.String getAllVal() {
		return this.__all_val;
	}

	public void setAllVal( java.lang.String value ) {
		this.__all_val = value;
	}

	public void cloneCopy(BaseMinvoicettorunusecount __bean){
		__bean.setTicketingCompany(getTicketingCompany());
		__bean.setAllVal(getAllVal());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String ticketingCompany = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_54", String.valueOf(getTicketingCompany()));
		sb.append(ticketingCompany == null ? "" : ticketingCompany);
		sb.append(",");
		sb.append(getAllVal() == null ? "" : getAllVal());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMinvoicettorunusecount o) {
		return __ticketing_company == null ? -1 : __ticketing_company.compareTo(o.getTicketingCompany());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__ticketing_company);
		hash = 97 * hash + Objects.hashCode(this.__all_val);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMinvoicettorunusecount o = (BaseMinvoicettorunusecount)obj;
		if(!Objects.equals(this.__ticketing_company, o.getTicketingCompany())) return false;
		if(!Objects.equals(this.__all_val, o.getAllVal())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getTicketingCompany() != null) sb.append(__wrapNumber(count++, "ticketingCompany", getTicketingCompany()));
		if(getAllVal() != null) sb.append(__wrapString(count++, "allVal", getAllVal()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("ticketingCompany")) != null) setTicketingCompany(__getInt(val)); 
		if((val = values.get("allVal")) != null) setAllVal(__getString(val));
	}

	protected java.lang.Integer  __ticketing_company ;
	protected java.lang.String  __all_val ;
}
