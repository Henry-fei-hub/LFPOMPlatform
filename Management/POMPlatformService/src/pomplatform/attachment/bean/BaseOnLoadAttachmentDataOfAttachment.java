package pomplatform.attachment.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadAttachmentDataOfAttachment extends GenericBase implements BaseFactory<BaseOnLoadAttachmentDataOfAttachment>, Comparable<BaseOnLoadAttachmentDataOfAttachment>
{


	public static BaseOnLoadAttachmentDataOfAttachment newInstance(){
		return new BaseOnLoadAttachmentDataOfAttachment();
	}

	@Override
	public BaseOnLoadAttachmentDataOfAttachment make(){
		BaseOnLoadAttachmentDataOfAttachment b = new BaseOnLoadAttachmentDataOfAttachment();
		return b;
	}

	public final static java.lang.String CS_ATTACHMENT_MANAGE_ID = "attachment_manage_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_ATTACHMENT_CODE = "attachment_code" ;
	public final static java.lang.String CS_ATTACHMENT_NAME = "attachment_name" ;
	public final static java.lang.String CS_ATTACHMENT_ADDRESS = "attachment_address" ;
	public final static java.lang.String CS_PERFESSION_REMARK = "perfession_remark" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_RETURN_AMOUNT = "return_amount" ;
	public final static java.lang.String CS_PAYMENT_SURE = "payment_sure" ;
	public final static java.lang.String CS_PAYMENT_GRADE_DESCRIPTION = "payment_grade_description" ;
	public final static java.lang.String CS_SERIAL_NUMBER = "serial_number" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;

	public final static java.lang.String ALL_CAPTIONS = "编号,附件路径,专业备注,金额,回款金额,绑定发票金额,收款确认,收款阶段描述,操作人,操作时间,备注,有无凭证";

	public java.lang.Integer getAttachmentManageId() {
		return this.__attachment_manage_id;
	}

	public void setAttachmentManageId( java.lang.Integer value ) {
		this.__attachment_manage_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getAttachmentCode() {
		return this.__attachment_code;
	}

	public void setAttachmentCode( java.lang.String value ) {
		this.__attachment_code = value;
	}

	public java.lang.String getAttachmentName() {
		return this.__attachment_name;
	}

	public void setAttachmentName( java.lang.String value ) {
		this.__attachment_name = value;
	}

	public java.lang.String getAttachmentAddress() {
		return this.__attachment_address;
	}

	public void setAttachmentAddress( java.lang.String value ) {
		this.__attachment_address = value;
	}

	public java.lang.String getPerfessionRemark() {
		return this.__perfession_remark;
	}

	public void setPerfessionRemark( java.lang.String value ) {
		this.__perfession_remark = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.math.BigDecimal getReturnAmount() {
		return this.__return_amount;
	}

	public void setReturnAmount( java.math.BigDecimal value ) {
		this.__return_amount = value;
	}

	public java.lang.Boolean getPaymentSure() {
		return this.__payment_sure;
	}

	public void setPaymentSure( java.lang.Boolean value ) {
		this.__payment_sure = value;
	}

	public java.lang.String getPaymentGradeDescription() {
		return this.__payment_grade_description;
	}

	public void setPaymentGradeDescription( java.lang.String value ) {
		this.__payment_grade_description = value;
	}

	public java.lang.Integer getSerialNumber() {
		return this.__serial_number;
	}

	public void setSerialNumber( java.lang.Integer value ) {
		this.__serial_number = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.math.BigDecimal getInvoiceAmount() {
		return this.__invoice_amount;
	}

	public void setInvoiceAmount( java.math.BigDecimal value ) {
		this.__invoice_amount = value;
	}

	public java.lang.Boolean getHaveVoucher() {
		return this.__have_voucher;
	}

	public void setHaveVoucher( java.lang.Boolean value ) {
		this.__have_voucher = value;
	}

	public java.lang.Boolean getConfirmationLetter() {
		return this.__confirmation_letter;
	}

	public void setConfirmationLetter( java.lang.Boolean value ) {
		this.__confirmation_letter = value;
	}

	public void cloneCopy(BaseOnLoadAttachmentDataOfAttachment __bean){
		__bean.setAttachmentManageId(getAttachmentManageId());
		__bean.setContractId(getContractId());
		__bean.setAttachmentCode(getAttachmentCode());
		__bean.setAttachmentName(getAttachmentName());
		__bean.setAttachmentAddress(getAttachmentAddress());
		__bean.setPerfessionRemark(getPerfessionRemark());
		__bean.setAmount(getAmount());
		__bean.setReturnAmount(getReturnAmount());
		__bean.setPaymentSure(getPaymentSure());
		__bean.setPaymentGradeDescription(getPaymentGradeDescription());
		__bean.setSerialNumber(getSerialNumber());
		__bean.setRecordDate(getRecordDate());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setContractName(getContractName());
		__bean.setInvoiceAmount(getInvoiceAmount());
		__bean.setHaveVoucher(getHaveVoucher());
		__bean.setConfirmationLetter(getConfirmationLetter());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getAttachmentManageId() == null ? "" : getAttachmentManageId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getAttachmentCode() == null ? "" : getAttachmentCode());
		sb.append(",");
		sb.append(getAttachmentName() == null ? "" : getAttachmentName());
		sb.append(",");
		sb.append(getAttachmentAddress() == null ? "" : getAttachmentAddress());
		sb.append(",");
		sb.append(getPerfessionRemark() == null ? "" : getPerfessionRemark());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getReturnAmount() == null ? "" : getReturnAmount());
		sb.append(",");
		sb.append(getPaymentSure() == null ? "" : getPaymentSure());
		sb.append(",");
		sb.append(getPaymentGradeDescription() == null ? "" : getPaymentGradeDescription());
		sb.append(",");
		sb.append(getSerialNumber() == null ? "" : getSerialNumber());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getInvoiceAmount() == null ? "" : getInvoiceAmount());
		sb.append(",");
		sb.append(getHaveVoucher() == null ? "" : getHaveVoucher());
		sb.append(",");
		sb.append(getConfirmationLetter() == null ? "" : getConfirmationLetter());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadAttachmentDataOfAttachment o) {
		return __attachment_manage_id == null ? -1 : __attachment_manage_id.compareTo(o.getAttachmentManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__attachment_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__attachment_code);
		hash = 97 * hash + Objects.hashCode(this.__attachment_name);
		hash = 97 * hash + Objects.hashCode(this.__attachment_address);
		hash = 97 * hash + Objects.hashCode(this.__perfession_remark);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__return_amount);
		hash = 97 * hash + Objects.hashCode(this.__payment_sure);
		hash = 97 * hash + Objects.hashCode(this.__payment_grade_description);
		hash = 97 * hash + Objects.hashCode(this.__serial_number);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__invoice_amount);
		hash = 97 * hash + Objects.hashCode(this.__have_voucher);
		hash = 97 * hash + Objects.hashCode(this.__confirmation_letter);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadAttachmentDataOfAttachment o = (BaseOnLoadAttachmentDataOfAttachment)obj;
		if(!Objects.equals(this.__attachment_manage_id, o.getAttachmentManageId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__attachment_code, o.getAttachmentCode())) return false;
		if(!Objects.equals(this.__attachment_name, o.getAttachmentName())) return false;
		if(!Objects.equals(this.__attachment_address, o.getAttachmentAddress())) return false;
		if(!Objects.equals(this.__perfession_remark, o.getPerfessionRemark())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__return_amount, o.getReturnAmount())) return false;
		if(!Objects.equals(this.__payment_sure, o.getPaymentSure())) return false;
		if(!Objects.equals(this.__payment_grade_description, o.getPaymentGradeDescription())) return false;
		if(!Objects.equals(this.__serial_number, o.getSerialNumber())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__invoice_amount, o.getInvoiceAmount())) return false;
		if(!Objects.equals(this.__have_voucher, o.getHaveVoucher())) return false;
		if(!Objects.equals(this.__confirmation_letter, o.getConfirmationLetter())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getAttachmentManageId() != null) sb.append(__wrapNumber(count++, "attachmentManageId", getAttachmentManageId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getAttachmentCode() != null) sb.append(__wrapString(count++, "attachmentCode", getAttachmentCode()));
		if(getAttachmentName() != null) sb.append(__wrapString(count++, "attachmentName", getAttachmentName()));
		if(getAttachmentAddress() != null) sb.append(__wrapString(count++, "attachmentAddress", getAttachmentAddress()));
		if(getPerfessionRemark() != null) sb.append(__wrapString(count++, "perfessionRemark", getPerfessionRemark()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getReturnAmount() != null) sb.append(__wrapDecimal(count++, "returnAmount", getReturnAmount()));
		if(getPaymentSure() != null) sb.append(__wrapBoolean(count++, "paymentSure", getPaymentSure()));
		if(getPaymentGradeDescription() != null) sb.append(__wrapString(count++, "paymentGradeDescription", getPaymentGradeDescription()));
		if(getSerialNumber() != null) sb.append(__wrapNumber(count++, "serialNumber", getSerialNumber()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getInvoiceAmount() != null) sb.append(__wrapDecimal(count++, "invoiceAmount", getInvoiceAmount()));
		if(getHaveVoucher() != null) sb.append(__wrapBoolean(count++, "haveVoucher", getHaveVoucher()));
		if(getConfirmationLetter() != null) sb.append(__wrapBoolean(count++, "confirmationLetter", getConfirmationLetter()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getAttachmentManageId() != null) res.put("attachmentManageId", getAttachmentManageId());
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getAttachmentCode() != null) res.put("attachmentCode", getAttachmentCode());
		if(getAttachmentName() != null) res.put("attachmentName", getAttachmentName());
		if(getAttachmentAddress() != null) res.put("attachmentAddress", getAttachmentAddress());
		if(getPerfessionRemark() != null) res.put("perfessionRemark", getPerfessionRemark());
		if(getAmount() != null) res.put("amount", getAmount());
		if(getReturnAmount() != null) res.put("returnAmount", getReturnAmount());
		if(getPaymentSure() != null) res.put("paymentSure", getPaymentSure());
		if(getPaymentGradeDescription() != null) res.put("paymentGradeDescription", getPaymentGradeDescription());
		if(getSerialNumber() != null) res.put("serialNumber", getSerialNumber());
		if(getRecordDate() != null) res.put("recordDate", getRecordDate());
		if(getOperateEmployeeId() != null) res.put("operateEmployeeId", getOperateEmployeeId());
		if(getOperateTime() != null) res.put("operateTime", getOperateTime());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getDeleteFlag() != null) res.put("deleteFlag", getDeleteFlag());
		if(getContractName() != null) res.put("contractName", getContractName());
		if(getInvoiceAmount() != null) res.put("invoiceAmount", getInvoiceAmount());
		if(getHaveVoucher() != null) res.put("haveVoucher", getHaveVoucher());
		if(getConfirmationLetter() != null) res.put("confirmationLetter", getConfirmationLetter());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("attachmentManageId")) != null) setAttachmentManageId(__getInt(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val));
		if((val = values.get("attachmentCode")) != null) setAttachmentCode(__getString(val));
		if((val = values.get("attachmentName")) != null) setAttachmentName(__getString(val));
		if((val = values.get("attachmentAddress")) != null) setAttachmentAddress(__getString(val));
		if((val = values.get("perfessionRemark")) != null) setPerfessionRemark(__getString(val));
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));
		if((val = values.get("returnAmount")) != null) setReturnAmount(__getDecimal(val));
		if((val = values.get("paymentSure")) != null) setPaymentSure(__getBoolean(val));
		if((val = values.get("paymentGradeDescription")) != null) setPaymentGradeDescription(__getString(val));
		if((val = values.get("serialNumber")) != null) setSerialNumber(__getInt(val));
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val));
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("invoiceAmount")) != null) setInvoiceAmount(__getDecimal(val));
		if((val = values.get("haveVoucher")) != null) setHaveVoucher(__getBoolean(val));
		if((val = values.get("confirmationLetter")) != null) setConfirmationLetter(__getBoolean(val));
	}

	protected java.lang.Integer  __attachment_manage_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __attachment_code ;
	protected java.lang.String  __attachment_name ;
	protected java.lang.String  __attachment_address ;
	protected java.lang.String  __perfession_remark ;
	protected java.math.BigDecimal  __amount ;
	protected java.math.BigDecimal  __return_amount ;
	protected java.lang.Boolean  __payment_sure ;
	protected java.lang.String  __payment_grade_description ;
	protected java.lang.Integer  __serial_number ;
	protected java.util.Date  __record_date ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.String  __contract_name ;
	protected java.math.BigDecimal  __invoice_amount ;
	protected java.lang.Boolean  __have_voucher ;
	protected java.lang.Boolean  __confirmation_letter ;
}