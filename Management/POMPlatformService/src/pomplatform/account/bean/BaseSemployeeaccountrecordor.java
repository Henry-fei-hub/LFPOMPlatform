package pomplatform.account.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSemployeeaccountrecordor extends GenericBase implements BaseFactory<BaseSemployeeaccountrecordor>, Comparable<BaseSemployeeaccountrecordor> 
{


	public static BaseSemployeeaccountrecordor newInstance(){
		return new BaseSemployeeaccountrecordor();
	}

	@Override
	public BaseSemployeeaccountrecordor make(){
		BaseSemployeeaccountrecordor b = new BaseSemployeeaccountrecordor();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_BUSINESS_TYPE_ID = "business_type_id" ;

	public final static java.lang.String ALL_CAPTIONS = "职员编码,业务部门,日期,10绩效奖金)";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.lang.Integer getBusinessTypeId() {
		return this.__business_type_id;
	}

	public void setBusinessTypeId( java.lang.Integer value ) {
		this.__business_type_id = value;
	}

	public void cloneCopy(BaseSemployeeaccountrecordor __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setPlateId(getPlateId());
		__bean.setRecordDate(getRecordDate());
		__bean.setBusinessTypeId(getBusinessTypeId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getBusinessTypeId() == null ? "" : getBusinessTypeId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSemployeeaccountrecordor o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__business_type_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSemployeeaccountrecordor o = (BaseSemployeeaccountrecordor)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__business_type_id, o.getBusinessTypeId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getBusinessTypeId() != null) sb.append(__wrapNumber(count++, "businessTypeId", getBusinessTypeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("businessTypeId")) != null) setBusinessTypeId(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.util.Date  __record_date ;
	protected java.lang.Integer  __business_type_id ;
}
