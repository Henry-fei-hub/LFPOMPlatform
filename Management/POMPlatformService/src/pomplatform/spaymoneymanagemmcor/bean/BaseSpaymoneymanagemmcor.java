package pomplatform.spaymoneymanagemmcor.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSpaymoneymanagemmcor extends GenericBase implements BaseFactory<BaseSpaymoneymanagemmcor>, Comparable<BaseSpaymoneymanagemmcor> 
{


	public static BaseSpaymoneymanagemmcor newInstance(){
		return new BaseSpaymoneymanagemmcor();
	}

	@Override
	public BaseSpaymoneymanagemmcor make(){
		BaseSpaymoneymanagemmcor b = new BaseSpaymoneymanagemmcor();
		return b;
	}

	public final static java.lang.String CS_PAY_MONEY_MANAGE_ID = "pay_money_manage_id" ;
	public final static java.lang.String CS_RECEIVE_UNIT = "receive_unit" ;
	public final static java.lang.String CS_BANK_ACCOUNT = "bank_account" ;
	public final static java.lang.String CS_BANK_NAME = "bank_name" ;
	public final static java.lang.String CS_TITLE_NAME = "title_name" ;
	public final static java.lang.String CS_PAY_AMOUNT = "pay_amount" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_ATTACHMENT_FILE = "attachment_file" ;
	public final static java.lang.String CS_REASON = "reason" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_IS_COMPLETED = "is_completed" ;
	public final static java.lang.String CS_BE_PACKED = "be_packed" ;
	public final static java.lang.String CS_VOUCHER_NO = "voucher_no" ;
	public final static java.lang.String CS_POSTING_DATE = "posting_date" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,收款单位,银行账号,开户行,主题名称,pay_amount,申请人,部门编码,附件,付款原因,操作人,操作时间,归属公司,编号,删除状态  0未删除    1已删除,true是),是否被打包,凭证号,入账日期";

	public java.lang.Integer getPayMoneyManageId() {
		return this.__pay_money_manage_id;
	}

	public void setPayMoneyManageId( java.lang.Integer value ) {
		this.__pay_money_manage_id = value;
	}

	public java.lang.String getReceiveUnit() {
		return this.__receive_unit;
	}

	public void setReceiveUnit( java.lang.String value ) {
		this.__receive_unit = value;
	}

	public java.lang.String getBankAccount() {
		return this.__bank_account;
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	public java.lang.String getBankName() {
		return this.__bank_name;
	}

	public void setBankName( java.lang.String value ) {
		this.__bank_name = value;
	}

	public java.lang.String getTitleName() {
		return this.__title_name;
	}

	public void setTitleName( java.lang.String value ) {
		this.__title_name = value;
	}

	public java.math.BigDecimal getPayAmount() {
		return this.__pay_amount;
	}

	public void setPayAmount( java.math.BigDecimal value ) {
		this.__pay_amount = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.String getAttachmentFile() {
		return this.__attachment_file;
	}

	public void setAttachmentFile( java.lang.String value ) {
		this.__attachment_file = value;
	}

	public java.lang.String getReason() {
		return this.__reason;
	}

	public void setReason( java.lang.String value ) {
		this.__reason = value;
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

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.Boolean getIsCompleted() {
		return this.__is_completed;
	}

	public void setIsCompleted( java.lang.Boolean value ) {
		this.__is_completed = value;
	}

	public java.lang.Boolean getBePacked() {
		return this.__be_packed;
	}

	public void setBePacked( java.lang.Boolean value ) {
		this.__be_packed = value;
	}

	public java.lang.String getVoucherNo() {
		return this.__voucher_no;
	}

	public void setVoucherNo( java.lang.String value ) {
		this.__voucher_no = value;
	}

	public java.util.Date getPostingDate() {
		return this.__posting_date;
	}

	public void setPostingDate( java.util.Date value ) {
		this.__posting_date = value;
	}

	public void cloneCopy(BaseSpaymoneymanagemmcor __bean){
		__bean.setPayMoneyManageId(getPayMoneyManageId());
		__bean.setReceiveUnit(getReceiveUnit());
		__bean.setBankAccount(getBankAccount());
		__bean.setBankName(getBankName());
		__bean.setTitleName(getTitleName());
		__bean.setPayAmount(getPayAmount());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setAttachmentFile(getAttachmentFile());
		__bean.setReason(getReason());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setCompanyId(getCompanyId());
		__bean.setCode(getCode());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setIsCompleted(getIsCompleted());
		__bean.setBePacked(getBePacked());
		__bean.setVoucherNo(getVoucherNo());
		__bean.setPostingDate(getPostingDate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPayMoneyManageId() == null ? "" : getPayMoneyManageId());
		sb.append(",");
		sb.append(getReceiveUnit() == null ? "" : getReceiveUnit());
		sb.append(",");
		sb.append(getBankAccount() == null ? "" : getBankAccount());
		sb.append(",");
		sb.append(getBankName() == null ? "" : getBankName());
		sb.append(",");
		sb.append(getTitleName() == null ? "" : getTitleName());
		sb.append(",");
		sb.append(getPayAmount() == null ? "" : getPayAmount());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getAttachmentFile() == null ? "" : getAttachmentFile());
		sb.append(",");
		sb.append(getReason() == null ? "" : getReason());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		sb.append(getIsCompleted() == null ? "" : getIsCompleted());
		sb.append(",");
		sb.append(getBePacked() == null ? "" : getBePacked());
		sb.append(",");
		sb.append(getVoucherNo() == null ? "" : getVoucherNo());
		sb.append(",");
		sb.append(getPostingDate() == null ? "" : sdf.format(getPostingDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSpaymoneymanagemmcor o) {
		return __pay_money_manage_id == null ? -1 : __pay_money_manage_id.compareTo(o.getPayMoneyManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__pay_money_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__receive_unit);
		hash = 97 * hash + Objects.hashCode(this.__bank_account);
		hash = 97 * hash + Objects.hashCode(this.__bank_name);
		hash = 97 * hash + Objects.hashCode(this.__title_name);
		hash = 97 * hash + Objects.hashCode(this.__pay_amount);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__attachment_file);
		hash = 97 * hash + Objects.hashCode(this.__reason);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__is_completed);
		hash = 97 * hash + Objects.hashCode(this.__be_packed);
		hash = 97 * hash + Objects.hashCode(this.__voucher_no);
		hash = 97 * hash + Objects.hashCode(this.__posting_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSpaymoneymanagemmcor o = (BaseSpaymoneymanagemmcor)obj;
		if(!Objects.equals(this.__pay_money_manage_id, o.getPayMoneyManageId())) return false;
		if(!Objects.equals(this.__receive_unit, o.getReceiveUnit())) return false;
		if(!Objects.equals(this.__bank_account, o.getBankAccount())) return false;
		if(!Objects.equals(this.__bank_name, o.getBankName())) return false;
		if(!Objects.equals(this.__title_name, o.getTitleName())) return false;
		if(!Objects.equals(this.__pay_amount, o.getPayAmount())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__attachment_file, o.getAttachmentFile())) return false;
		if(!Objects.equals(this.__reason, o.getReason())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__is_completed, o.getIsCompleted())) return false;
		if(!Objects.equals(this.__be_packed, o.getBePacked())) return false;
		if(!Objects.equals(this.__voucher_no, o.getVoucherNo())) return false;
		if(!Objects.equals(this.__posting_date, o.getPostingDate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPayMoneyManageId() != null) sb.append(__wrapNumber(count++, "payMoneyManageId", getPayMoneyManageId()));
		if(getReceiveUnit() != null) sb.append(__wrapString(count++, "receiveUnit", getReceiveUnit()));
		if(getBankAccount() != null) sb.append(__wrapString(count++, "bankAccount", getBankAccount()));
		if(getBankName() != null) sb.append(__wrapString(count++, "bankName", getBankName()));
		if(getTitleName() != null) sb.append(__wrapString(count++, "titleName", getTitleName()));
		if(getPayAmount() != null) sb.append(__wrapDecimal(count++, "payAmount", getPayAmount()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getAttachmentFile() != null) sb.append(__wrapString(count++, "attachmentFile", getAttachmentFile()));
		if(getReason() != null) sb.append(__wrapString(count++, "reason", getReason()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getIsCompleted() != null) sb.append(__wrapBoolean(count++, "isCompleted", getIsCompleted()));
		if(getBePacked() != null) sb.append(__wrapBoolean(count++, "bePacked", getBePacked()));
		if(getVoucherNo() != null) sb.append(__wrapString(count++, "voucherNo", getVoucherNo()));
		if(getPostingDate() != null) sb.append(__wrapDate(count++, "postingDate", getPostingDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("payMoneyManageId")) != null) setPayMoneyManageId(__getInt(val)); 
		if((val = values.get("receiveUnit")) != null) setReceiveUnit(__getString(val));
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("bankName")) != null) setBankName(__getString(val));
		if((val = values.get("titleName")) != null) setTitleName(__getString(val));
		if((val = values.get("payAmount")) != null) setPayAmount(__getDecimal(val));  
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("attachmentFile")) != null) setAttachmentFile(__getString(val));
		if((val = values.get("reason")) != null) setReason(__getString(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("isCompleted")) != null) setIsCompleted(__getBoolean(val));
		if((val = values.get("bePacked")) != null) setBePacked(__getBoolean(val));
		if((val = values.get("voucherNo")) != null) setVoucherNo(__getString(val));
		if((val = values.get("postingDate")) != null) setPostingDate(__getDate(val)); 
	}

	protected java.lang.Integer  __pay_money_manage_id ;
	protected java.lang.String  __receive_unit ;
	protected java.lang.String  __bank_account ;
	protected java.lang.String  __bank_name ;
	protected java.lang.String  __title_name ;
	protected java.math.BigDecimal  __pay_amount ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.String  __attachment_file ;
	protected java.lang.String  __reason ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.String  __code ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.Boolean  __is_completed ;
	protected java.lang.Boolean  __be_packed ;
	protected java.lang.String  __voucher_no ;
	protected java.util.Date  __posting_date ;
}
