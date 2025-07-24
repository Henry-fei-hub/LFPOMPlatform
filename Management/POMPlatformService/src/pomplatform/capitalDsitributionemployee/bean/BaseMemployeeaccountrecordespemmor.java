package pomplatform.capitalDsitributionemployee.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMemployeeaccountrecordespemmor extends GenericBase implements BaseFactory<BaseMemployeeaccountrecordespemmor>, Comparable<BaseMemployeeaccountrecordespemmor> 
{


	public static BaseMemployeeaccountrecordespemmor newInstance(){
		return new BaseMemployeeaccountrecordespemmor();
	}

	@Override
	public BaseMemployeeaccountrecordespemmor make(){
		BaseMemployeeaccountrecordespemmor b = new BaseMemployeeaccountrecordespemmor();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_BUSINESS_TYPE_ID = "business_type_id" ;
	public final static java.lang.String CS_DIC_TYPE_VALUE = "dic_type_value" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_INTEGRAL = "integral" ;

	public final static java.lang.String ALL_CAPTIONS = "职员编码,10绩效奖金),数据值,类型,积分";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getBusinessTypeId() {
		return this.__business_type_id;
	}

	public void setBusinessTypeId( java.lang.Integer value ) {
		this.__business_type_id = value;
	}

	public java.lang.String getDicTypeValue() {
		return this.__dic_type_value;
	}

	public void setDicTypeValue( java.lang.String value ) {
		this.__dic_type_value = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.math.BigDecimal getIntegral() {
		return this.__integral;
	}

	public void setIntegral( java.math.BigDecimal value ) {
		this.__integral = value;
	}

	public void cloneCopy(BaseMemployeeaccountrecordespemmor __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setBusinessTypeId(getBusinessTypeId());
		__bean.setDicTypeValue(getDicTypeValue());
		__bean.setType(getType());
		__bean.setIntegral(getIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getBusinessTypeId() == null ? "" : getBusinessTypeId());
		sb.append(",");
		sb.append(getDicTypeValue() == null ? "" : getDicTypeValue());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		sb.append(",");
		sb.append(getIntegral() == null ? "" : getIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMemployeeaccountrecordespemmor o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__business_type_id);
		hash = 97 * hash + Objects.hashCode(this.__dic_type_value);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMemployeeaccountrecordespemmor o = (BaseMemployeeaccountrecordespemmor)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__business_type_id, o.getBusinessTypeId())) return false;
		if(!Objects.equals(this.__dic_type_value, o.getDicTypeValue())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__integral, o.getIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getBusinessTypeId() != null) sb.append(__wrapNumber(count++, "businessTypeId", getBusinessTypeId()));
		if(getDicTypeValue() != null) sb.append(__wrapString(count++, "dicTypeValue", getDicTypeValue()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getIntegral() != null) sb.append(__wrapDecimal(count++, "integral", getIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("businessTypeId")) != null) setBusinessTypeId(__getInt(val)); 
		if((val = values.get("dicTypeValue")) != null) setDicTypeValue(__getString(val));
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("integral")) != null) setIntegral(__getDecimal(val));  
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __business_type_id ;
	protected java.lang.String  __dic_type_value ;
	protected java.lang.Integer  __type ;
	protected java.math.BigDecimal  __integral ;
}
