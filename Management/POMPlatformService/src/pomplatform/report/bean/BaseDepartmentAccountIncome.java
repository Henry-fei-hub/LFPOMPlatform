package pomplatform.report.bean;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BaseDepartmentAccountIncome extends GenericBase implements BaseFactory<BaseDepartmentAccountIncome>, Comparable<BaseDepartmentAccountIncome>
{


	public static BaseDepartmentAccountIncome newInstance(){
		return new BaseDepartmentAccountIncome();
	}

	@Override
	public BaseDepartmentAccountIncome make(){
		BaseDepartmentAccountIncome b = new BaseDepartmentAccountIncome();
		return b;
	}

	public final static String CS_DATE_PART = "date_part" ;
	public final static String CS_PLATE_ID = "plate_id" ;
	public final static String CS_BUSINESS_TYPE_ID = "business_type_id" ;
	public final static String CS_INTEGRAL = "integral" ;

	public final static String ALL_CAPTIONS = ",,板块,11绩效奖金),积分";

	public Double getDatePart() {
		return this.__date_part;
	}

	public void setDatePart( Double value ) {
		this.__date_part = value;
	}

	public Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( Integer value ) {
		this.__plate_id = value;
	}

	public Integer getBusinessTypeId() {
		return this.__business_type_id;
	}

	public void setBusinessTypeId( Integer value ) {
		this.__business_type_id = value;
	}

	public java.math.BigDecimal getIntegral() {
		return this.__integral;
	}

	public void setIntegral( java.math.BigDecimal value ) {
		this.__integral = value;
	}

	public void cloneCopy(BaseDepartmentAccountIncome __bean){
		__bean.setDatePart(getDatePart());
		__bean.setDatePart(getDatePart());
		__bean.setPlateId(getPlateId());
		__bean.setBusinessTypeId(getBusinessTypeId());
		__bean.setIntegral(getIntegral());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getDatePart() == null ? "" : getDatePart());
		sb.append(",");
		sb.append(getDatePart() == null ? "" : getDatePart());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getBusinessTypeId() == null ? "" : getBusinessTypeId());
		sb.append(",");
		sb.append(getIntegral() == null ? "" : getIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseDepartmentAccountIncome o) {
		return __date_part == null ? -1 : __date_part.compareTo(o.getDatePart());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__date_part);
		hash = 97 * hash + Objects.hashCode(this.__date_part);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__business_type_id);
		hash = 97 * hash + Objects.hashCode(this.__integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseDepartmentAccountIncome o = (BaseDepartmentAccountIncome)obj;
		if(!Objects.equals(this.__date_part, o.getDatePart())) return false;
		if(!Objects.equals(this.__date_part, o.getDatePart())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__business_type_id, o.getBusinessTypeId())) return false;
		if(!Objects.equals(this.__integral, o.getIntegral())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDatePart() != null) sb.append(__wrapNumber(count++, "datePart", getDatePart()));
		if(getDatePart() != null) sb.append(__wrapNumber(count++, "datePart", getDatePart()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getBusinessTypeId() != null) sb.append(__wrapNumber(count++, "businessTypeId", getBusinessTypeId()));
		if(getIntegral() != null) sb.append(__wrapDecimal(count++, "integral", getIntegral()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getDatePart() != null) res.put("datePart", getDatePart());
		if(getDatePart() != null) res.put("datePart", getDatePart());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getBusinessTypeId() != null) res.put("businessTypeId", getBusinessTypeId());
		if(getIntegral() != null) res.put("integral", getIntegral());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("datePart")) != null) setDatePart(__getDouble(val));
		if((val = values.get("datePart")) != null) setDatePart(__getDouble(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val));
		if((val = values.get("businessTypeId")) != null) setBusinessTypeId(__getInt(val));
		if((val = values.get("integral")) != null) setIntegral(__getDecimal(val));
	}

	protected Double  __date_part ;
	protected Integer  __plate_id ;
	protected Integer  __business_type_id ;
	protected java.math.BigDecimal  __integral ;
}
