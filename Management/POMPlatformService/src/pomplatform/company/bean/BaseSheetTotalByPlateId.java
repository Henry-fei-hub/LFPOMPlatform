package pomplatform.company.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSheetTotalByPlateId extends GenericBase implements BaseFactory<BaseSheetTotalByPlateId>, Comparable<BaseSheetTotalByPlateId> 
{


	public static BaseSheetTotalByPlateId newInstance(){
		return new BaseSheetTotalByPlateId();
	}

	@Override
	public BaseSheetTotalByPlateId make(){
		BaseSheetTotalByPlateId b = new BaseSheetTotalByPlateId();
		return b;
	}

	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_SHEET_TOTAL_INTEGRAL = "sheet_total_integral" ;
	public final static java.lang.String CS_COMPLAINT_INTEGRAL = "complaint_integral" ;
	public final static java.lang.String CS_SHEET_INTEGRAL = "sheet_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "承接部门,订单总积分,投诉保证金,订单积分";

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.math.BigDecimal getSheetTotalIntegral() {
		return this.__sheet_total_integral;
	}

	public void setSheetTotalIntegral( java.math.BigDecimal value ) {
		this.__sheet_total_integral = value;
	}

	public java.math.BigDecimal getComplaintIntegral() {
		return this.__complaint_integral;
	}

	public void setComplaintIntegral( java.math.BigDecimal value ) {
		this.__complaint_integral = value;
	}

	public java.math.BigDecimal getSheetIntegral() {
		return this.__sheet_integral;
	}

	public void setSheetIntegral( java.math.BigDecimal value ) {
		this.__sheet_integral = value;
	}

	public void cloneCopy(BaseSheetTotalByPlateId __bean){
		__bean.setDepartmentId(getDepartmentId());
		__bean.setSheetTotalIntegral(getSheetTotalIntegral());
		__bean.setComplaintIntegral(getComplaintIntegral());
		__bean.setSheetIntegral(getSheetIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getSheetTotalIntegral() == null ? "" : getSheetTotalIntegral());
		sb.append(",");
		sb.append(getComplaintIntegral() == null ? "" : getComplaintIntegral());
		sb.append(",");
		sb.append(getSheetIntegral() == null ? "" : getSheetIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSheetTotalByPlateId o) {
		return __department_id == null ? -1 : __department_id.compareTo(o.getDepartmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__sheet_total_integral);
		hash = 97 * hash + Objects.hashCode(this.__complaint_integral);
		hash = 97 * hash + Objects.hashCode(this.__sheet_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSheetTotalByPlateId o = (BaseSheetTotalByPlateId)obj;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__sheet_total_integral, o.getSheetTotalIntegral())) return false;
		if(!Objects.equals(this.__complaint_integral, o.getComplaintIntegral())) return false;
		if(!Objects.equals(this.__sheet_integral, o.getSheetIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getSheetTotalIntegral() != null) sb.append(__wrapDecimal(count++, "sheetTotalIntegral", getSheetTotalIntegral()));
		if(getComplaintIntegral() != null) sb.append(__wrapDecimal(count++, "complaintIntegral", getComplaintIntegral()));
		if(getSheetIntegral() != null) sb.append(__wrapDecimal(count++, "sheetIntegral", getSheetIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("sheetTotalIntegral")) != null) setSheetTotalIntegral(__getDecimal(val));  
		if((val = values.get("complaintIntegral")) != null) setComplaintIntegral(__getDecimal(val));  
		if((val = values.get("sheetIntegral")) != null) setSheetIntegral(__getDecimal(val));  
	}

	protected java.lang.Integer  __department_id ;
	protected java.math.BigDecimal  __sheet_total_integral ;
	protected java.math.BigDecimal  __complaint_integral ;
	protected java.math.BigDecimal  __sheet_integral ;
}
