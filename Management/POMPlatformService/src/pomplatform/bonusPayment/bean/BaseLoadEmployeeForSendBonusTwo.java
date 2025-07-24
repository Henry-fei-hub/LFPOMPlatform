package pomplatform.bonusPayment.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseLoadEmployeeForSendBonusTwo extends GenericBase implements BaseFactory<BaseLoadEmployeeForSendBonusTwo>, Comparable<BaseLoadEmployeeForSendBonusTwo> 
{


	public static BaseLoadEmployeeForSendBonusTwo newInstance(){
		return new BaseLoadEmployeeForSendBonusTwo();
	}

	@Override
	public BaseLoadEmployeeForSendBonusTwo make(){
		BaseLoadEmployeeForSendBonusTwo b = new BaseLoadEmployeeForSendBonusTwo();
		return b;
	}

	public final static java.lang.String CS_BONUS_PAYMENT_RECORD_ID = "bonus_payment_record_id" ;
	public final static java.lang.String CS_BONUS_PAYMENT_DETAIL_ID = "bonus_payment_detail_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_PAY_INTEGRAL = "pay_integral" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_PLATE_TYPE = "plate_type" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,主键编码,员工编码,员工编号,员工姓名,发放积分,业务部门,在职状态";

	public java.lang.Integer getBonusPaymentRecordId() {
		return this.__bonus_payment_record_id;
	}

	public void setBonusPaymentRecordId( java.lang.Integer value ) {
		this.__bonus_payment_record_id = value;
	}

	public java.lang.Integer getBonusPaymentDetailId() {
		return this.__bonus_payment_detail_id;
	}

	public void setBonusPaymentDetailId( java.lang.Integer value ) {
		this.__bonus_payment_detail_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.math.BigDecimal getPayIntegral() {
		return this.__pay_integral;
	}

	public void setPayIntegral( java.math.BigDecimal value ) {
		this.__pay_integral = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}
	
	public java.lang.Integer getPlateType() {
		return this.__plate_type;
	}

	public void setPlateType( java.lang.Integer value ) {
		this.__plate_type = value;
	}

	public void cloneCopy(BaseLoadEmployeeForSendBonusTwo __bean){
		__bean.setBonusPaymentRecordId(getBonusPaymentRecordId());
		__bean.setBonusPaymentDetailId(getBonusPaymentDetailId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setPayIntegral(getPayIntegral());
		__bean.setPlateId(getPlateId());
		__bean.setStatus(getStatus());
		__bean.setPlateType(getPlateType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getBonusPaymentRecordId() == null ? "" : getBonusPaymentRecordId());
		sb.append(",");
		sb.append(getBonusPaymentDetailId() == null ? "" : getBonusPaymentDetailId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getPayIntegral() == null ? "" : getPayIntegral());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_61", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseLoadEmployeeForSendBonusTwo o) {
		return __bonus_payment_record_id == null ? -1 : __bonus_payment_record_id.compareTo(o.getBonusPaymentRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__bonus_payment_record_id);
		hash = 97 * hash + Objects.hashCode(this.__bonus_payment_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__pay_integral);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__plate_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseLoadEmployeeForSendBonusTwo o = (BaseLoadEmployeeForSendBonusTwo)obj;
		if(!Objects.equals(this.__bonus_payment_record_id, o.getBonusPaymentRecordId())) return false;
		if(!Objects.equals(this.__bonus_payment_detail_id, o.getBonusPaymentDetailId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__pay_integral, o.getPayIntegral())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__plate_type, o.getPlateType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getBonusPaymentRecordId() != null) sb.append(__wrapNumber(count++, "bonusPaymentRecordId", getBonusPaymentRecordId()));
		if(getBonusPaymentDetailId() != null) sb.append(__wrapNumber(count++, "bonusPaymentDetailId", getBonusPaymentDetailId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getPayIntegral() != null) sb.append(__wrapDecimal(count++, "payIntegral", getPayIntegral()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getPlateType() != null) sb.append(__wrapNumber(count++, "plateType", getPlateType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("bonusPaymentRecordId")) != null) setBonusPaymentRecordId(__getInt(val)); 
		if((val = values.get("bonusPaymentDetailId")) != null) setBonusPaymentDetailId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("payIntegral")) != null) setPayIntegral(__getDecimal(val));  
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("plateType")) != null) setPlateType(__getInt(val)); 
	}

	protected java.lang.Integer  __bonus_payment_record_id ;
	protected java.lang.Integer  __bonus_payment_detail_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.math.BigDecimal  __pay_integral ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __plate_type ;
}
