package pomplatform.payseqaddinfo.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasePaySeqAddInfo extends GenericBase implements BaseFactory<BasePaySeqAddInfo>, Comparable<BasePaySeqAddInfo> 
{


	public static BasePaySeqAddInfo newInstance(){
		return new BasePaySeqAddInfo();
	}

	@Override
	public BasePaySeqAddInfo make(){
		BasePaySeqAddInfo b = new BasePaySeqAddInfo();
		return b;
	}

	public final static java.lang.String CS_PAYMENT_SEQUENCE_ID = "payment_sequence_id" ;
	public final static java.lang.String CS_BUDGET_MANAGEMENT_ID = "budget_management_id" ;
	public final static java.lang.String CS_BUDGET_ATTACHMENT_ID = "budget_attachment_id" ;
	public final static java.lang.String CS_PAY_AMOUNT = "pay_amount" ;
	public final static java.lang.String CS_PAY_DATE = "pay_date" ;
	public final static java.lang.String CS_PAY_STATUS = "pay_status" ;
	public final static java.lang.String CS_PS_REMARK = "ps_remark" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_RECEIVE_UNIT_MANAGE_ID = "receive_unit_manage_id" ;
	public final static java.lang.String CS_PROCESS_BILL_LIST_ID = "process_bill_list_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_BIND_STATUS = "bind_status" ;
	public final static java.lang.String CS_PAY_TYPE = "pay_type" ;
	public final static java.lang.String CS_IS_LOCK = "is_lock" ;
	public final static java.lang.String CS_REIMBURSEMENT_AMOUNT = "reimbursement_amount" ;
	public final static java.lang.String CS_REVERSE_AMOUNT = "reverse_amount" ;
	public final static java.lang.String CS_APPLY_PAY_DATE = "apply_pay_date" ;
	public final static java.lang.String CS_RETURN_AMOUNT = "return_amount" ;
	public final static java.lang.String CS_PAY_FOR = "pay_for" ;
	public final static java.lang.String CS_PAY_NAME = "pay_name" ;
	public final static java.lang.String CS_REIMBURSEMENT_CODE = "reimbursement_code" ;

	public final static java.lang.String ALL_CAPTIONS = "主键id,预算管理id,预算附件id,付款金额,付款日期,付款状态,付款序列备注,年,月,收款单位编码,流水编码,关联的项目名称,绑定状态 0.未绑定，1.已绑定,付款类型,是否加锁,报销金额,冲账金额,付款申请日期,还款金额,收款方类型 1个人，2公司,收款人名称,报销编号";
	public final static java.lang.String EXPORT_CAPTIONS = "预算编号,附件名称,付款类型,申请付款日期,报销金额,付款金额,冲账金额,还款金额,收款方类型,收款方名称,项目名称,付款状态,付款日期,报销编号,备注,年,月";
	public java.lang.Integer getPaymentSequenceId() {
		return this.__payment_sequence_id;
	}

	public void setPaymentSequenceId( java.lang.Integer value ) {
		this.__payment_sequence_id = value;
	}

	public java.lang.Integer getBudgetManagementId() {
		return this.__budget_management_id;
	}

	public void setBudgetManagementId( java.lang.Integer value ) {
		this.__budget_management_id = value;
	}

	public java.lang.Integer getBudgetAttachmentId() {
		return this.__budget_attachment_id;
	}

	public void setBudgetAttachmentId( java.lang.Integer value ) {
		this.__budget_attachment_id = value;
	}

	public java.math.BigDecimal getPayAmount() {
		return this.__pay_amount;
	}

	public void setPayAmount( java.math.BigDecimal value ) {
		this.__pay_amount = value;
	}

	public java.util.Date getPayDate() {
		return this.__pay_date;
	}

	public void setPayDate( java.util.Date value ) {
		this.__pay_date = value;
	}

	public java.lang.Integer getPayStatus() {
		return this.__pay_status;
	}

	public void setPayStatus( java.lang.Integer value ) {
		this.__pay_status = value;
	}

	public java.lang.String getPsRemark() {
		return this.__ps_remark;
	}

	public void setPsRemark( java.lang.String value ) {
		this.__ps_remark = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.lang.Integer getReceiveUnitManageId() {
		return this.__receive_unit_manage_id;
	}

	public void setReceiveUnitManageId( java.lang.Integer value ) {
		this.__receive_unit_manage_id = value;
	}

	public java.lang.Integer getProcessBillListId() {
		return this.__process_bill_list_id;
	}

	public void setProcessBillListId( java.lang.Integer value ) {
		this.__process_bill_list_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getBindStatus() {
		return this.__bind_status;
	}

	public void setBindStatus( java.lang.Integer value ) {
		this.__bind_status = value;
	}

	public java.lang.Integer getPayType() {
		return this.__pay_type;
	}

	public void setPayType( java.lang.Integer value ) {
		this.__pay_type = value;
	}

	public java.lang.Boolean getIsLock() {
		return this.__is_lock;
	}

	public void setIsLock( java.lang.Boolean value ) {
		this.__is_lock = value;
	}

	public java.math.BigDecimal getReimbursementAmount() {
		return this.__reimbursement_amount;
	}

	public void setReimbursementAmount( java.math.BigDecimal value ) {
		this.__reimbursement_amount = value;
	}

	public java.math.BigDecimal getReverseAmount() {
		return this.__reverse_amount;
	}

	public void setReverseAmount( java.math.BigDecimal value ) {
		this.__reverse_amount = value;
	}

	public java.util.Date getApplyPayDate() {
		return this.__apply_pay_date;
	}

	public void setApplyPayDate( java.util.Date value ) {
		this.__apply_pay_date = value;
	}

	public java.math.BigDecimal getReturnAmount() {
		return this.__return_amount;
	}

	public void setReturnAmount( java.math.BigDecimal value ) {
		this.__return_amount = value;
	}

	public java.lang.Integer getPayFor() {
		return this.__pay_for;
	}

	public void setPayFor( java.lang.Integer value ) {
		this.__pay_for = value;
	}

	public java.lang.String getPayName() {
		return this.__pay_name;
	}

	public void setPayName( java.lang.String value ) {
		this.__pay_name = value;
	}

	public java.lang.String getReimbursementCode() {
		return this.__reimbursement_code;
	}

	public void setReimbursementCode( java.lang.String value ) {
		this.__reimbursement_code = value;
	}

	public void cloneCopy(BasePaySeqAddInfo __bean){
		__bean.setPaymentSequenceId(getPaymentSequenceId());
		__bean.setBudgetManagementId(getBudgetManagementId());
		__bean.setBudgetAttachmentId(getBudgetAttachmentId());
		__bean.setPayAmount(getPayAmount());
		__bean.setPayDate(getPayDate());
		__bean.setPayStatus(getPayStatus());
		__bean.setPsRemark(getPsRemark());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setReceiveUnitManageId(getReceiveUnitManageId());
		__bean.setProcessBillListId(getProcessBillListId());
		__bean.setProjectId(getProjectId());
		__bean.setBindStatus(getBindStatus());
		__bean.setPayType(getPayType());
		__bean.setIsLock(getIsLock());
		__bean.setReimbursementAmount(getReimbursementAmount());
		__bean.setReverseAmount(getReverseAmount());
		__bean.setApplyPayDate(getApplyPayDate());
		__bean.setReturnAmount(getReturnAmount());
		__bean.setPayFor(getPayFor());
		__bean.setPayName(getPayName());
		__bean.setReimbursementCode(getReimbursementCode());
	}

	public java.lang.String toCSVString() {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String budgetManagementId=delicacy.system.executor.SelectValueCache.getSelectValue("budget_management", String.valueOf(getBudgetManagementId()));
		sb.append(getBudgetManagementId() == null ? "" : budgetManagementId);
		sb.append(",");
		String budgetAttachmentId=delicacy.system.executor.SelectValueCache.getSelectValue("budget_attachment", String.valueOf(getBudgetAttachmentId()));
		sb.append(getBudgetAttachmentId() == null ? "" : budgetAttachmentId.replaceAll(",", "，"));
		sb.append(",");
		String payType=delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_193", String.valueOf(getPayType()));
		sb.append(getPayType() == null ? "" : payType);
		sb.append(",");
		sb.append(getApplyPayDate() == null ? "" : sdf.format(getApplyPayDate()));
		sb.append(",");
		sb.append(getReimbursementAmount() == null ? "" : getReimbursementAmount());
		sb.append(",");
		sb.append(getPayAmount() == null ? "" : getPayAmount());
		sb.append(",");
		sb.append(getReverseAmount() == null ? "" : getReverseAmount());
		sb.append(",");
		sb.append(getReturnAmount() == null ? "" : getReturnAmount());
		sb.append(",");
		String payFor=delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_196", String.valueOf(getPayFor()));
		sb.append(getPayFor() == null ? "" : payFor);
		sb.append(",");
		sb.append(getPayName() == null ? "" : getPayName().replaceAll(",", "，"));
		sb.append(",");
		String projectId=delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(getProjectId() == null ? "" : projectId.replaceAll(",", "，"));
		sb.append(",");
		String payStatus=delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_194", String.valueOf(getPayStatus()));
		sb.append(getPayStatus() == null ? "" : payStatus);
		sb.append(",");
		sb.append(getPayDate() == null ? "" : sdf.format(getPayDate()));
		sb.append(",");
		sb.append(getReimbursementCode() == null ? "" : getReimbursementCode());
		sb.append(",");
		sb.append(getPsRemark() == null ? "" : getPsRemark().replaceAll(",", "，"));
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePaySeqAddInfo o) {
		return __payment_sequence_id == null ? -1 : __payment_sequence_id.compareTo(o.getPaymentSequenceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__payment_sequence_id);
		hash = 97 * hash + Objects.hashCode(this.__budget_management_id);
		hash = 97 * hash + Objects.hashCode(this.__budget_attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__pay_amount);
		hash = 97 * hash + Objects.hashCode(this.__pay_date);
		hash = 97 * hash + Objects.hashCode(this.__pay_status);
		hash = 97 * hash + Objects.hashCode(this.__ps_remark);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__receive_unit_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__process_bill_list_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__bind_status);
		hash = 97 * hash + Objects.hashCode(this.__pay_type);
		hash = 97 * hash + Objects.hashCode(this.__is_lock);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_amount);
		hash = 97 * hash + Objects.hashCode(this.__reverse_amount);
		hash = 97 * hash + Objects.hashCode(this.__apply_pay_date);
		hash = 97 * hash + Objects.hashCode(this.__return_amount);
		hash = 97 * hash + Objects.hashCode(this.__pay_for);
		hash = 97 * hash + Objects.hashCode(this.__pay_name);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_code);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePaySeqAddInfo o = (BasePaySeqAddInfo)obj;
		if(!Objects.equals(this.__payment_sequence_id, o.getPaymentSequenceId())) return false;
		if(!Objects.equals(this.__budget_management_id, o.getBudgetManagementId())) return false;
		if(!Objects.equals(this.__budget_attachment_id, o.getBudgetAttachmentId())) return false;
		if(!Objects.equals(this.__pay_amount, o.getPayAmount())) return false;
		if(!Objects.equals(this.__pay_date, o.getPayDate())) return false;
		if(!Objects.equals(this.__pay_status, o.getPayStatus())) return false;
		if(!Objects.equals(this.__ps_remark, o.getPsRemark())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__receive_unit_manage_id, o.getReceiveUnitManageId())) return false;
		if(!Objects.equals(this.__process_bill_list_id, o.getProcessBillListId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__bind_status, o.getBindStatus())) return false;
		if(!Objects.equals(this.__pay_type, o.getPayType())) return false;
		if(!Objects.equals(this.__is_lock, o.getIsLock())) return false;
		if(!Objects.equals(this.__reimbursement_amount, o.getReimbursementAmount())) return false;
		if(!Objects.equals(this.__reverse_amount, o.getReverseAmount())) return false;
		if(!Objects.equals(this.__apply_pay_date, o.getApplyPayDate())) return false;
		if(!Objects.equals(this.__return_amount, o.getReturnAmount())) return false;
		if(!Objects.equals(this.__pay_for, o.getPayFor())) return false;
		if(!Objects.equals(this.__pay_name, o.getPayName())) return false;
		if(!Objects.equals(this.__reimbursement_code, o.getReimbursementCode())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPaymentSequenceId() != null) sb.append(__wrapNumber(count++, "paymentSequenceId", getPaymentSequenceId()));
		if(getBudgetManagementId() != null) sb.append(__wrapNumber(count++, "budgetManagementId", getBudgetManagementId()));
		if(getBudgetAttachmentId() != null) sb.append(__wrapNumber(count++, "budgetAttachmentId", getBudgetAttachmentId()));
		if(getPayAmount() != null) sb.append(__wrapDecimal(count++, "payAmount", getPayAmount()));
		if(getPayDate() != null) sb.append(__wrapDate(count++, "payDate", getPayDate()));
		if(getPayStatus() != null) sb.append(__wrapNumber(count++, "payStatus", getPayStatus()));
		if(getPsRemark() != null) sb.append(__wrapString(count++, "psRemark", getPsRemark()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getReceiveUnitManageId() != null) sb.append(__wrapNumber(count++, "receiveUnitManageId", getReceiveUnitManageId()));
		if(getProcessBillListId() != null) sb.append(__wrapNumber(count++, "processBillListId", getProcessBillListId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getBindStatus() != null) sb.append(__wrapNumber(count++, "bindStatus", getBindStatus()));
		if(getPayType() != null) sb.append(__wrapNumber(count++, "payType", getPayType()));
		if(getIsLock() != null) sb.append(__wrapBoolean(count++, "isLock", getIsLock()));
		if(getReimbursementAmount() != null) sb.append(__wrapDecimal(count++, "reimbursementAmount", getReimbursementAmount()));
		if(getReverseAmount() != null) sb.append(__wrapDecimal(count++, "reverseAmount", getReverseAmount()));
		if(getApplyPayDate() != null) sb.append(__wrapDate(count++, "applyPayDate", getApplyPayDate()));
		if(getReturnAmount() != null) sb.append(__wrapDecimal(count++, "returnAmount", getReturnAmount()));
		if(getPayFor() != null) sb.append(__wrapNumber(count++, "payFor", getPayFor()));
		if(getPayName() != null) sb.append(__wrapString(count++, "payName", getPayName()));
		if(getReimbursementCode() != null) sb.append(__wrapString(count++, "reimbursementCode", getReimbursementCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("paymentSequenceId")) != null) setPaymentSequenceId(__getInt(val)); 
		if((val = values.get("budgetManagementId")) != null) setBudgetManagementId(__getInt(val)); 
		if((val = values.get("budgetAttachmentId")) != null) setBudgetAttachmentId(__getInt(val)); 
		if((val = values.get("payAmount")) != null) setPayAmount(__getDecimal(val));  
		if((val = values.get("payDate")) != null) setPayDate(__getDate(val)); 
		if((val = values.get("payStatus")) != null) setPayStatus(__getInt(val)); 
		if((val = values.get("psRemark")) != null) setPsRemark(__getString(val));
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("receiveUnitManageId")) != null) setReceiveUnitManageId(__getInt(val)); 
		if((val = values.get("processBillListId")) != null) setProcessBillListId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("bindStatus")) != null) setBindStatus(__getInt(val)); 
		if((val = values.get("payType")) != null) setPayType(__getInt(val)); 
		if((val = values.get("isLock")) != null) setIsLock(__getBoolean(val));
		if((val = values.get("reimbursementAmount")) != null) setReimbursementAmount(__getDecimal(val));  
		if((val = values.get("reverseAmount")) != null) setReverseAmount(__getDecimal(val));  
		if((val = values.get("applyPayDate")) != null) setApplyPayDate(__getDate(val)); 
		if((val = values.get("returnAmount")) != null) setReturnAmount(__getDecimal(val));  
		if((val = values.get("payFor")) != null) setPayFor(__getInt(val)); 
		if((val = values.get("payName")) != null) setPayName(__getString(val));
		if((val = values.get("reimbursementCode")) != null) setReimbursementCode(__getString(val));
	}

	protected java.lang.Integer  __payment_sequence_id ;
	protected java.lang.Integer  __budget_management_id ;
	protected java.lang.Integer  __budget_attachment_id ;
	protected java.math.BigDecimal  __pay_amount ;
	protected java.util.Date  __pay_date ;
	protected java.lang.Integer  __pay_status ;
	protected java.lang.String  __ps_remark ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.Integer  __receive_unit_manage_id ;
	protected java.lang.Integer  __process_bill_list_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __bind_status ;
	protected java.lang.Integer  __pay_type ;
	protected java.lang.Boolean  __is_lock ;
	protected java.math.BigDecimal  __reimbursement_amount ;
	protected java.math.BigDecimal  __reverse_amount ;
	protected java.util.Date  __apply_pay_date ;
	protected java.math.BigDecimal  __return_amount ;
	protected java.lang.Integer  __pay_for ;
	protected java.lang.String  __pay_name ;
	protected java.lang.String  __reimbursement_code ;
}
