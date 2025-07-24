package pomplatform.payment.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSendIntegralOfEmpPaymentDetail extends GenericBase implements BaseFactory<BaseSendIntegralOfEmpPaymentDetail>, Comparable<BaseSendIntegralOfEmpPaymentDetail> 
{


	public static BaseSendIntegralOfEmpPaymentDetail newInstance(){
		return new BaseSendIntegralOfEmpPaymentDetail();
	}

	@Override
	public BaseSendIntegralOfEmpPaymentDetail make(){
		BaseSendIntegralOfEmpPaymentDetail b = new BaseSendIntegralOfEmpPaymentDetail();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_PAYMENT_DETAIL_ID = "employee_payment_detail_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PLATE_TYPE = "plate_type" ;
	public final static java.lang.String CS_DETAIL_DATE = "detail_date" ;
	public final static java.lang.String CS_DAY_PAY = "day_pay" ;
	public final static java.lang.String CS_DAY_ATTENDANCE_DEDUCTION = "day_attendance_deduction" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,职员编码,业务部门,部门类型,日期,日工资,日考勤扣款工资,考勤备注";

	public java.lang.Integer getEmployeePaymentDetailId() {
		return this.__employee_payment_detail_id;
	}

	public void setEmployeePaymentDetailId( java.lang.Integer value ) {
		this.__employee_payment_detail_id = value;
	}

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

	public java.lang.Integer getPlateType() {
		return this.__plate_type;
	}

	public void setPlateType( java.lang.Integer value ) {
		this.__plate_type = value;
	}

	public java.util.Date getDetailDate() {
		return this.__detail_date;
	}

	public void setDetailDate( java.util.Date value ) {
		this.__detail_date = value;
	}

	public java.math.BigDecimal getDayPay() {
		return this.__day_pay;
	}

	public void setDayPay( java.math.BigDecimal value ) {
		this.__day_pay = value;
	}

	public java.math.BigDecimal getDayAttendanceDeduction() {
		return this.__day_attendance_deduction;
	}

	public void setDayAttendanceDeduction( java.math.BigDecimal value ) {
		this.__day_attendance_deduction = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}
	
	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public void cloneCopy(BaseSendIntegralOfEmpPaymentDetail __bean){
		__bean.setEmployeePaymentDetailId(getEmployeePaymentDetailId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setPlateId(getPlateId());
		__bean.setPlateType(getPlateType());
		__bean.setDetailDate(getDetailDate());
		__bean.setDayPay(getDayPay());
		__bean.setDayAttendanceDeduction(getDayAttendanceDeduction());
		__bean.setRemark(getRemark());
		__bean.setDepartmentId(getDepartmentId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeePaymentDetailId() == null ? "" : getEmployeePaymentDetailId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getPlateType() == null ? "" : getPlateType());
		sb.append(",");
		sb.append(getDetailDate() == null ? "" : sdf.format(getDetailDate()));
		sb.append(",");
		sb.append(getDayPay() == null ? "" : getDayPay());
		sb.append(",");
		sb.append(getDayAttendanceDeduction() == null ? "" : getDayAttendanceDeduction());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSendIntegralOfEmpPaymentDetail o) {
		return __employee_payment_detail_id == null ? -1 : __employee_payment_detail_id.compareTo(o.getEmployeePaymentDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_payment_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_type);
		hash = 97 * hash + Objects.hashCode(this.__detail_date);
		hash = 97 * hash + Objects.hashCode(this.__day_pay);
		hash = 97 * hash + Objects.hashCode(this.__day_attendance_deduction);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSendIntegralOfEmpPaymentDetail o = (BaseSendIntegralOfEmpPaymentDetail)obj;
		if(!Objects.equals(this.__employee_payment_detail_id, o.getEmployeePaymentDetailId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__plate_type, o.getPlateType())) return false;
		if(!Objects.equals(this.__detail_date, o.getDetailDate())) return false;
		if(!Objects.equals(this.__day_pay, o.getDayPay())) return false;
		if(!Objects.equals(this.__day_attendance_deduction, o.getDayAttendanceDeduction())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeePaymentDetailId() != null) sb.append(__wrapNumber(count++, "employeePaymentDetailId", getEmployeePaymentDetailId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getPlateType() != null) sb.append(__wrapNumber(count++, "plateType", getPlateType()));
		if(getDetailDate() != null) sb.append(__wrapDate(count++, "detailDate", getDetailDate()));
		if(getDayPay() != null) sb.append(__wrapDecimal(count++, "dayPay", getDayPay()));
		if(getDayAttendanceDeduction() != null) sb.append(__wrapDecimal(count++, "dayAttendanceDeduction", getDayAttendanceDeduction()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeePaymentDetailId")) != null) setEmployeePaymentDetailId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("plateType")) != null) setPlateType(__getInt(val)); 
		if((val = values.get("detailDate")) != null) setDetailDate(__getDate(val)); 
		if((val = values.get("dayPay")) != null) setDayPay(__getDecimal(val));  
		if((val = values.get("dayAttendanceDeduction")) != null) setDayAttendanceDeduction(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val));
	}

	protected java.lang.Integer  __employee_payment_detail_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __plate_type ;
	protected java.util.Date  __detail_date ;
	protected java.math.BigDecimal  __day_pay ;
	protected java.math.BigDecimal  __day_attendance_deduction ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __department_id ;
}
