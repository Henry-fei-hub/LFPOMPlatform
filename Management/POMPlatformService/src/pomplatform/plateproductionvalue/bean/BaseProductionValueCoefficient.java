package pomplatform.plateproductionvalue.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseProductionValueCoefficient extends GenericBase implements BaseFactory<BaseProductionValueCoefficient>, Comparable<BaseProductionValueCoefficient> 
{


	public static BaseProductionValueCoefficient newInstance(){
		return new BaseProductionValueCoefficient();
	}

	@Override
	public BaseProductionValueCoefficient make(){
		BaseProductionValueCoefficient b = new BaseProductionValueCoefficient();
		return b;
	}

	public final static String CS_PRODUCTION_VALUE_COEFFICIENT_ID = "production_value_coefficient_id" ;
	public final static String CS_PRODUCTION_VALUE_COEFFICIENT_TYPE_ID = "production_value_coefficient_type_id" ;
	public final static String CS_PRODUCTION_MIN = "production_min" ;
	public final static String CS_PRODUCTION_MAX = "production_max" ;
	public final static String CS_INTERVAL_LINES = "interval_lines" ;
	public final static String CS_INTERVAL_RANGE = "interval_range" ;
	public final static String CS_COEFFICIENT = "coefficient" ;
	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_OPERATION_TIME = "operation_time" ;
	public final static String CS_CREATE_TIME = "create_time" ;

	public final static String ALL_CAPTIONS = "主键,类型,产值最小值,产值最大值,区间额度,区间范围,系数,操作人id,操作时间,创建时间";

	public Integer getProductionValueCoefficientId() {
		return this.__production_value_coefficient_id;
	}

	public void setProductionValueCoefficientId( Integer value ) {
		this.__production_value_coefficient_id = value;
	}

	public Integer getProductionValueCoefficientTypeId() {
		return this.__production_value_coefficient_type_id;
	}

	public void setProductionValueCoefficientTypeId( Integer value ) {
		this.__production_value_coefficient_type_id = value;
	}

	public java.math.BigDecimal getProductionMin() {
		return this.__production_min;
	}

	public void setProductionMin( java.math.BigDecimal value ) {
		this.__production_min = value;
	}

	public java.math.BigDecimal getProductionMax() {
		return this.__production_max;
	}

	public void setProductionMax( java.math.BigDecimal value ) {
		this.__production_max = value;
	}

	public java.math.BigDecimal getIntervalLines() {
		return this.__interval_lines;
	}

	public void setIntervalLines( java.math.BigDecimal value ) {
		this.__interval_lines = value;
	}

	public String getIntervalRange() {
		return this.__interval_range;
	}

	public void setIntervalRange( String value ) {
		this.__interval_range = value;
	}

	public java.math.BigDecimal getCoefficient() {
		return this.__coefficient;
	}

	public void setCoefficient( java.math.BigDecimal value ) {
		this.__coefficient = value;
	}

	public Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getOperationTime() {
		return this.__operation_time;
	}

	public void setOperationTime( java.util.Date value ) {
		this.__operation_time = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BaseProductionValueCoefficient __bean){
		__bean.setProductionValueCoefficientId(getProductionValueCoefficientId());
		__bean.setProductionValueCoefficientTypeId(getProductionValueCoefficientTypeId());
		__bean.setProductionMin(getProductionMin());
		__bean.setProductionMax(getProductionMax());
		__bean.setIntervalLines(getIntervalLines());
		__bean.setIntervalRange(getIntervalRange());
		__bean.setCoefficient(getCoefficient());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setOperationTime(getOperationTime());
		__bean.setCreateTime(getCreateTime());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProductionValueCoefficientId() == null ? "" : getProductionValueCoefficientId());
		sb.append(",");
		sb.append(getProductionValueCoefficientTypeId() == null ? "" : getProductionValueCoefficientTypeId());
		sb.append(",");
		sb.append(getProductionMin() == null ? "" : getProductionMin());
		sb.append(",");
		sb.append(getProductionMax() == null ? "" : getProductionMax());
		sb.append(",");
		sb.append(getIntervalLines() == null ? "" : getIntervalLines());
		sb.append(",");
		sb.append(getIntervalRange() == null ? "" : getIntervalRange());
		sb.append(",");
		sb.append(getCoefficient() == null ? "" : getCoefficient());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getOperationTime() == null ? "" : sdf.format(getOperationTime()));
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProductionValueCoefficient o) {
		return __production_value_coefficient_id == null ? -1 : __production_value_coefficient_id.compareTo(o.getProductionValueCoefficientId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__production_value_coefficient_id);
		hash = 97 * hash + Objects.hashCode(this.__production_value_coefficient_type_id);
		hash = 97 * hash + Objects.hashCode(this.__production_min);
		hash = 97 * hash + Objects.hashCode(this.__production_max);
		hash = 97 * hash + Objects.hashCode(this.__interval_lines);
		hash = 97 * hash + Objects.hashCode(this.__interval_range);
		hash = 97 * hash + Objects.hashCode(this.__coefficient);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operation_time);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProductionValueCoefficient o = (BaseProductionValueCoefficient)obj;
		if(!Objects.equals(this.__production_value_coefficient_id, o.getProductionValueCoefficientId())) return false;
		if(!Objects.equals(this.__production_value_coefficient_type_id, o.getProductionValueCoefficientTypeId())) return false;
		if(!Objects.equals(this.__production_min, o.getProductionMin())) return false;
		if(!Objects.equals(this.__production_max, o.getProductionMax())) return false;
		if(!Objects.equals(this.__interval_lines, o.getIntervalLines())) return false;
		if(!Objects.equals(this.__interval_range, o.getIntervalRange())) return false;
		if(!Objects.equals(this.__coefficient, o.getCoefficient())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__operation_time, o.getOperationTime())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProductionValueCoefficientId() != null) sb.append(__wrapNumber(count++, "productionValueCoefficientId", getProductionValueCoefficientId()));
		if(getProductionValueCoefficientTypeId() != null) sb.append(__wrapNumber(count++, "productionValueCoefficientTypeId", getProductionValueCoefficientTypeId()));
		if(getProductionMin() != null) sb.append(__wrapDecimal(count++, "productionMin", getProductionMin()));
		if(getProductionMax() != null) sb.append(__wrapDecimal(count++, "productionMax", getProductionMax()));
		if(getIntervalLines() != null) sb.append(__wrapDecimal(count++, "intervalLines", getIntervalLines()));
		if(getIntervalRange() != null) sb.append(__wrapString(count++, "intervalRange", getIntervalRange()));
		if(getCoefficient() != null) sb.append(__wrapDecimal(count++, "coefficient", getCoefficient()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getOperationTime() != null) sb.append(__wrapDate(count++, "operationTime", getOperationTime()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProductionValueCoefficientId() != null) res.put("productionValueCoefficientId", getProductionValueCoefficientId());
		if(getProductionValueCoefficientTypeId() != null) res.put("productionValueCoefficientTypeId", getProductionValueCoefficientTypeId());
		if(getProductionMin() != null) res.put("productionMin", getProductionMin());
		if(getProductionMax() != null) res.put("productionMax", getProductionMax());
		if(getIntervalLines() != null) res.put("intervalLines", getIntervalLines());
		if(getIntervalRange() != null) res.put("intervalRange", getIntervalRange());
		if(getCoefficient() != null) res.put("coefficient", getCoefficient());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getOperationTime() != null) res.put("operationTime", getOperationTime());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("productionValueCoefficientId")) != null) setProductionValueCoefficientId(__getInt(val)); 
		if((val = values.get("productionValueCoefficientTypeId")) != null) setProductionValueCoefficientTypeId(__getInt(val)); 
		if((val = values.get("productionMin")) != null) setProductionMin(__getDecimal(val));  
		if((val = values.get("productionMax")) != null) setProductionMax(__getDecimal(val));  
		if((val = values.get("intervalLines")) != null) setIntervalLines(__getDecimal(val));  
		if((val = values.get("intervalRange")) != null) setIntervalRange(__getString(val));
		if((val = values.get("coefficient")) != null) setCoefficient(__getDecimal(val));  
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("operationTime")) != null) setOperationTime(__getDate(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected Integer  __production_value_coefficient_id ;
	protected Integer  __production_value_coefficient_type_id ;
	protected java.math.BigDecimal  __production_min ;
	protected java.math.BigDecimal  __production_max ;
	protected java.math.BigDecimal  __interval_lines ;
	protected String  __interval_range ;
	protected java.math.BigDecimal  __coefficient ;
	protected Integer  __employee_id ;
	protected java.util.Date  __operation_time ;
	protected java.util.Date  __create_time ;
}
