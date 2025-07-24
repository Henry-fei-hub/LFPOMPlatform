package pomplatform.spaymoneymanagemmcor.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMemployeemoneymanageeeedcieftrcvmmor extends GenericBase implements BaseFactory<BaseMemployeemoneymanageeeedcieftrcvmmor>, Comparable<BaseMemployeemoneymanageeeedcieftrcvmmor> 
{


	public static BaseMemployeemoneymanageeeedcieftrcvmmor newInstance(){
		return new BaseMemployeemoneymanageeeedcieftrcvmmor();
	}

	@Override
	public BaseMemployeemoneymanageeeedcieftrcvmmor make(){
		BaseMemployeemoneymanageeeedcieftrcvmmor b = new BaseMemployeemoneymanageeeedcieftrcvmmor();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_MONEY_MANAGE_ID = "employee_money_manage_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_BORROW_MONEY = "borrow_money" ;
	public final static java.lang.String CS_RETURN_MONEY = "return_money" ;
	public final static java.lang.String CS_BORROW_DATE = "borrow_date" ;
	public final static java.lang.String CS_ANTICIPATED_DATE = "anticipated_date" ;
	public final static java.lang.String CS_RETURN_DATE = "return_date" ;
	public final static java.lang.String CS_TITLE_NAME = "title_name" ;
	public final static java.lang.String CS_REASON = "reason" ;
	public final static java.lang.String CS_FALG = "falg" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_IS_COMPLETED = "is_completed" ;
	public final static java.lang.String CS_BE_PACKED = "be_packed" ;
	public final static java.lang.String CS_VOUCHER_NO = "voucher_no" ;
	public final static java.lang.String CS_POSTING_DATE = "posting_date" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,职员编码,部门编码,借款金额,还款金额,借款日期,预计还款日期,还款日期,主题名称,借款事由,2还款),操作人,操作时间,归属公司,编号,删除状态  0未删除    1已删除,true是),是否被打包,凭证号,入账日期";

	public java.lang.Integer getEmployeeMoneyManageId() {
		return this.__employee_money_manage_id;
	}

	public void setEmployeeMoneyManageId( java.lang.Integer value ) {
		this.__employee_money_manage_id = value;
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

	public java.math.BigDecimal getBorrowMoney() {
		return this.__borrow_money;
	}

	public void setBorrowMoney( java.math.BigDecimal value ) {
		this.__borrow_money = value;
	}

	public java.math.BigDecimal getReturnMoney() {
		return this.__return_money;
	}

	public void setReturnMoney( java.math.BigDecimal value ) {
		this.__return_money = value;
	}

	public java.util.Date getBorrowDate() {
		return this.__borrow_date;
	}

	public void setBorrowDate( java.util.Date value ) {
		this.__borrow_date = value;
	}

	public java.util.Date getAnticipatedDate() {
		return this.__anticipated_date;
	}

	public void setAnticipatedDate( java.util.Date value ) {
		this.__anticipated_date = value;
	}

	public java.util.Date getReturnDate() {
		return this.__return_date;
	}

	public void setReturnDate( java.util.Date value ) {
		this.__return_date = value;
	}

	public java.lang.String getTitleName() {
		return this.__title_name;
	}

	public void setTitleName( java.lang.String value ) {
		this.__title_name = value;
	}

	public java.lang.String getReason() {
		return this.__reason;
	}

	public void setReason( java.lang.String value ) {
		this.__reason = value;
	}

	public java.lang.Integer getFalg() {
		return this.__falg;
	}

	public void setFalg( java.lang.Integer value ) {
		this.__falg = value;
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

	public void cloneCopy(BaseMemployeemoneymanageeeedcieftrcvmmor __bean){
		__bean.setEmployeeMoneyManageId(getEmployeeMoneyManageId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setBorrowMoney(getBorrowMoney());
		__bean.setReturnMoney(getReturnMoney());
		__bean.setBorrowDate(getBorrowDate());
		__bean.setAnticipatedDate(getAnticipatedDate());
		__bean.setReturnDate(getReturnDate());
		__bean.setTitleName(getTitleName());
		__bean.setReason(getReason());
		__bean.setFalg(getFalg());
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
		sb.append(getEmployeeMoneyManageId() == null ? "" : getEmployeeMoneyManageId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getBorrowMoney() == null ? "" : getBorrowMoney());
		sb.append(",");
		sb.append(getReturnMoney() == null ? "" : getReturnMoney());
		sb.append(",");
		sb.append(getBorrowDate() == null ? "" : sdf.format(getBorrowDate()));
		sb.append(",");
		sb.append(getAnticipatedDate() == null ? "" : sdf.format(getAnticipatedDate()));
		sb.append(",");
		sb.append(getReturnDate() == null ? "" : sdf.format(getReturnDate()));
		sb.append(",");
		sb.append(getTitleName() == null ? "" : getTitleName());
		sb.append(",");
		sb.append(getReason() == null ? "" : getReason());
		sb.append(",");
		sb.append(getFalg() == null ? "" : getFalg());
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
	public int compareTo(BaseMemployeemoneymanageeeedcieftrcvmmor o) {
		return __employee_money_manage_id == null ? -1 : __employee_money_manage_id.compareTo(o.getEmployeeMoneyManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_money_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__borrow_money);
		hash = 97 * hash + Objects.hashCode(this.__return_money);
		hash = 97 * hash + Objects.hashCode(this.__borrow_date);
		hash = 97 * hash + Objects.hashCode(this.__anticipated_date);
		hash = 97 * hash + Objects.hashCode(this.__return_date);
		hash = 97 * hash + Objects.hashCode(this.__title_name);
		hash = 97 * hash + Objects.hashCode(this.__reason);
		hash = 97 * hash + Objects.hashCode(this.__falg);
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
		final BaseMemployeemoneymanageeeedcieftrcvmmor o = (BaseMemployeemoneymanageeeedcieftrcvmmor)obj;
		if(!Objects.equals(this.__employee_money_manage_id, o.getEmployeeMoneyManageId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__borrow_money, o.getBorrowMoney())) return false;
		if(!Objects.equals(this.__return_money, o.getReturnMoney())) return false;
		if(!Objects.equals(this.__borrow_date, o.getBorrowDate())) return false;
		if(!Objects.equals(this.__anticipated_date, o.getAnticipatedDate())) return false;
		if(!Objects.equals(this.__return_date, o.getReturnDate())) return false;
		if(!Objects.equals(this.__title_name, o.getTitleName())) return false;
		if(!Objects.equals(this.__reason, o.getReason())) return false;
		if(!Objects.equals(this.__falg, o.getFalg())) return false;
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
		if(getEmployeeMoneyManageId() != null) sb.append(__wrapNumber(count++, "employeeMoneyManageId", getEmployeeMoneyManageId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getBorrowMoney() != null) sb.append(__wrapDecimal(count++, "borrowMoney", getBorrowMoney()));
		if(getReturnMoney() != null) sb.append(__wrapDecimal(count++, "returnMoney", getReturnMoney()));
		if(getBorrowDate() != null) sb.append(__wrapDate(count++, "borrowDate", getBorrowDate()));
		if(getAnticipatedDate() != null) sb.append(__wrapDate(count++, "anticipatedDate", getAnticipatedDate()));
		if(getReturnDate() != null) sb.append(__wrapDate(count++, "returnDate", getReturnDate()));
		if(getTitleName() != null) sb.append(__wrapString(count++, "titleName", getTitleName()));
		if(getReason() != null) sb.append(__wrapString(count++, "reason", getReason()));
		if(getFalg() != null) sb.append(__wrapNumber(count++, "falg", getFalg()));
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
		if((val = values.get("employeeMoneyManageId")) != null) setEmployeeMoneyManageId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("borrowMoney")) != null) setBorrowMoney(__getDecimal(val));  
		if((val = values.get("returnMoney")) != null) setReturnMoney(__getDecimal(val));  
		if((val = values.get("borrowDate")) != null) setBorrowDate(__getDate(val)); 
		if((val = values.get("anticipatedDate")) != null) setAnticipatedDate(__getDate(val)); 
		if((val = values.get("returnDate")) != null) setReturnDate(__getDate(val)); 
		if((val = values.get("titleName")) != null) setTitleName(__getString(val));
		if((val = values.get("reason")) != null) setReason(__getString(val));
		if((val = values.get("falg")) != null) setFalg(__getInt(val)); 
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

	protected java.lang.Integer  __employee_money_manage_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __department_id ;
	protected java.math.BigDecimal  __borrow_money ;
	protected java.math.BigDecimal  __return_money ;
	protected java.util.Date  __borrow_date ;
	protected java.util.Date  __anticipated_date ;
	protected java.util.Date  __return_date ;
	protected java.lang.String  __title_name ;
	protected java.lang.String  __reason ;
	protected java.lang.Integer  __falg ;
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
