package pomplatform.attachmentManageMeeting.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseAttachmentManageMeetingTor extends GenericBase implements BaseFactory<BaseAttachmentManageMeetingTor>, Comparable<BaseAttachmentManageMeetingTor> 
{


	public static BaseAttachmentManageMeetingTor newInstance(){
		return new BaseAttachmentManageMeetingTor();
	}

	@Override
	public BaseAttachmentManageMeetingTor make(){
		BaseAttachmentManageMeetingTor b = new BaseAttachmentManageMeetingTor();
		return b;
	}

	public final static java.lang.String CS_ATTACHMENT_MANAGE_MEETING_ID = "attachment_manage_meeting_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_EXPECT_RETURN_DATE = "expect_return_date" ;
	public final static java.lang.String CS_NEED_RETURN_AMOUNT = "need_return_amount" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_PUBLISH_DATE = "publish_date" ;
	public final static java.lang.String CS_SUBMIT_DATE = "submit_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_METTING_STATUS = "metting_status" ;
	public final static java.lang.String CS_OPERATOR_STATUS = "operator_status" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_WORK_NUM = "work_num" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_ATTACHMENT_MANAGE_ID = "attachment_manage_id" ;
	public final static java.lang.String CS_PROJECT_MANAGE_ID = "project_manage_id" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
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
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_SUPER_PROJECT_MANAGE_ID = "super_project_manage_id" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_HAVE_VOUCHER = "have_voucher" ;
	public final static java.lang.String CS_INVOICE_AMOUNT = "invoice_amount" ;
	public final static java.lang.String CS_EMPLOYEE_NAME_STR = "employee_name_str" ;

	public final static java.lang.String ALL_CAPTIONS = "attachment_manage_meeting_id,合同编码,预期回款时间,需回款金额（金额-回款金额）,备注,发布日期,提交日期,终止日期,1新建 2发布 3定稿,1 待提交 2已提交  3未答复,年份,第几周,操作人,创建时间,确认函主键,项目负责人,start_date,主订单名称,主订单编号,编号,附件名称,附件路径,专业备注,金额,回款金额,收款确认,收款阶段描述,序列号(生成编号的序号),记录日期,操作人,操作时间,0/1 是/否删除,部门,大项目负责人,流程主表编码,是否有凭证,开票金额(如 100),";

	public java.lang.Integer getAttachmentManageMeetingId() {
		return this.__attachment_manage_meeting_id;
	}

	public void setAttachmentManageMeetingId( java.lang.Integer value ) {
		this.__attachment_manage_meeting_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.util.Date getExpectReturnDate() {
		return this.__expect_return_date;
	}

	public void setExpectReturnDate( java.util.Date value ) {
		this.__expect_return_date = value;
	}

	public java.math.BigDecimal getNeedReturnAmount() {
		return this.__need_return_amount;
	}

	public void setNeedReturnAmount( java.math.BigDecimal value ) {
		this.__need_return_amount = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.util.Date getPublishDate() {
		return this.__publish_date;
	}

	public void setPublishDate( java.util.Date value ) {
		this.__publish_date = value;
	}

	public java.util.Date getSubmitDate() {
		return this.__submit_date;
	}

	public void setSubmitDate( java.util.Date value ) {
		this.__submit_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.lang.Integer getMettingStatus() {
		return this.__metting_status;
	}

	public void setMettingStatus( java.lang.Integer value ) {
		this.__metting_status = value;
	}

	public java.lang.Integer getOperatorStatus() {
		return this.__operator_status;
	}

	public void setOperatorStatus( java.lang.Integer value ) {
		this.__operator_status = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getWorkNum() {
		return this.__work_num;
	}

	public void setWorkNum( java.lang.Integer value ) {
		this.__work_num = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getAttachmentManageId() {
		return this.__attachment_manage_id;
	}

	public void setAttachmentManageId( java.lang.Integer value ) {
		this.__attachment_manage_id = value;
	}

	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
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

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getSuperProjectManageId() {
		return this.__super_project_manage_id;
	}

	public void setSuperProjectManageId( java.lang.Integer value ) {
		this.__super_project_manage_id = value;
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.lang.Boolean getHaveVoucher() {
		return this.__have_voucher;
	}

	public void setHaveVoucher( java.lang.Boolean value ) {
		this.__have_voucher = value;
	}

	public java.math.BigDecimal getInvoiceAmount() {
		return this.__invoice_amount;
	}

	public void setInvoiceAmount( java.math.BigDecimal value ) {
		this.__invoice_amount = value;
	}

	public java.lang.String getEmployeeNameStr() {
		return this.__employee_name_str;
	}

	public void setEmployeeNameStr( java.lang.String value ) {
		this.__employee_name_str = value;
	}

	public void cloneCopy(BaseAttachmentManageMeetingTor __bean){
		__bean.setAttachmentManageMeetingId(getAttachmentManageMeetingId());
		__bean.setContractId(getContractId());
		__bean.setExpectReturnDate(getExpectReturnDate());
		__bean.setNeedReturnAmount(getNeedReturnAmount());
		__bean.setRemark(getRemark());
		__bean.setPublishDate(getPublishDate());
		__bean.setSubmitDate(getSubmitDate());
		__bean.setEndDate(getEndDate());
		__bean.setMettingStatus(getMettingStatus());
		__bean.setOperatorStatus(getOperatorStatus());
		__bean.setYear(getYear());
		__bean.setWorkNum(getWorkNum());
		__bean.setOperator(getOperator());
		__bean.setCreateTime(getCreateTime());
		__bean.setAttachmentManageId(getAttachmentManageId());
		__bean.setProjectManageId(getProjectManageId());
		__bean.setStartDate(getStartDate());
		__bean.setContractName(getContractName());
		__bean.setContractCode(getContractCode());
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
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setSuperProjectManageId(getSuperProjectManageId());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setHaveVoucher(getHaveVoucher());
		__bean.setInvoiceAmount(getInvoiceAmount());
		__bean.setEmployeeNameStr(getEmployeeNameStr());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getAttachmentManageMeetingId() == null ? "" : getAttachmentManageMeetingId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getExpectReturnDate() == null ? "" : sdf.format(getExpectReturnDate()));
		sb.append(",");
		sb.append(getNeedReturnAmount() == null ? "" : getNeedReturnAmount());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getPublishDate() == null ? "" : sdf.format(getPublishDate()));
		sb.append(",");
		sb.append(getSubmitDate() == null ? "" : sdf.format(getSubmitDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getMettingStatus() == null ? "" : getMettingStatus());
		sb.append(",");
		sb.append(getOperatorStatus() == null ? "" : getOperatorStatus());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getWorkNum() == null ? "" : getWorkNum());
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getAttachmentManageId() == null ? "" : getAttachmentManageId());
		sb.append(",");
		sb.append(getProjectManageId() == null ? "" : getProjectManageId());
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
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
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getSuperProjectManageId() == null ? "" : getSuperProjectManageId());
		sb.append(",");
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		sb.append(getHaveVoucher() == null ? "" : getHaveVoucher());
		sb.append(",");
		sb.append(getInvoiceAmount() == null ? "" : getInvoiceAmount());
		sb.append(",");
		sb.append(getEmployeeNameStr() == null ? "" : getEmployeeNameStr());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAttachmentManageMeetingTor o) {
		return __attachment_manage_meeting_id == null ? -1 : __attachment_manage_meeting_id.compareTo(o.getAttachmentManageMeetingId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__attachment_manage_meeting_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__expect_return_date);
		hash = 97 * hash + Objects.hashCode(this.__need_return_amount);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__publish_date);
		hash = 97 * hash + Objects.hashCode(this.__submit_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__metting_status);
		hash = 97 * hash + Objects.hashCode(this.__operator_status);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__work_num);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__attachment_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__project_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
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
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__super_project_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__have_voucher);
		hash = 97 * hash + Objects.hashCode(this.__invoice_amount);
		hash = 97 * hash + Objects.hashCode(this.__employee_name_str);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAttachmentManageMeetingTor o = (BaseAttachmentManageMeetingTor)obj;
		if(!Objects.equals(this.__attachment_manage_meeting_id, o.getAttachmentManageMeetingId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__expect_return_date, o.getExpectReturnDate())) return false;
		if(!Objects.equals(this.__need_return_amount, o.getNeedReturnAmount())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__publish_date, o.getPublishDate())) return false;
		if(!Objects.equals(this.__submit_date, o.getSubmitDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__metting_status, o.getMettingStatus())) return false;
		if(!Objects.equals(this.__operator_status, o.getOperatorStatus())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__work_num, o.getWorkNum())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__attachment_manage_id, o.getAttachmentManageId())) return false;
		if(!Objects.equals(this.__project_manage_id, o.getProjectManageId())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
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
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__super_project_manage_id, o.getSuperProjectManageId())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__have_voucher, o.getHaveVoucher())) return false;
		if(!Objects.equals(this.__invoice_amount, o.getInvoiceAmount())) return false;
		if(!Objects.equals(this.__employee_name_str, o.getEmployeeNameStr())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getAttachmentManageMeetingId() != null) sb.append(__wrapNumber(count++, "attachmentManageMeetingId", getAttachmentManageMeetingId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getExpectReturnDate() != null) sb.append(__wrapDate(count++, "expectReturnDate", getExpectReturnDate()));
		if(getNeedReturnAmount() != null) sb.append(__wrapDecimal(count++, "needReturnAmount", getNeedReturnAmount()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getPublishDate() != null) sb.append(__wrapDate(count++, "publishDate", getPublishDate()));
		if(getSubmitDate() != null) sb.append(__wrapDate(count++, "submitDate", getSubmitDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getMettingStatus() != null) sb.append(__wrapNumber(count++, "mettingStatus", getMettingStatus()));
		if(getOperatorStatus() != null) sb.append(__wrapNumber(count++, "operatorStatus", getOperatorStatus()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getWorkNum() != null) sb.append(__wrapNumber(count++, "workNum", getWorkNum()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getAttachmentManageId() != null) sb.append(__wrapNumber(count++, "attachmentManageId", getAttachmentManageId()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(count++, "projectManageId", getProjectManageId()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
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
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getSuperProjectManageId() != null) sb.append(__wrapNumber(count++, "superProjectManageId", getSuperProjectManageId()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getHaveVoucher() != null) sb.append(__wrapBoolean(count++, "haveVoucher", getHaveVoucher()));
		if(getInvoiceAmount() != null) sb.append(__wrapDecimal(count++, "invoiceAmount", getInvoiceAmount()));
		if(getEmployeeNameStr() != null) sb.append(__wrapString(count++, "employeeNameStr", getEmployeeNameStr()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("attachmentManageMeetingId")) != null) setAttachmentManageMeetingId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("expectReturnDate")) != null) setExpectReturnDate(__getDate(val)); 
		if((val = values.get("needReturnAmount")) != null) setNeedReturnAmount(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("publishDate")) != null) setPublishDate(__getDate(val)); 
		if((val = values.get("submitDate")) != null) setSubmitDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("mettingStatus")) != null) setMettingStatus(__getInt(val)); 
		if((val = values.get("operatorStatus")) != null) setOperatorStatus(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("workNum")) != null) setWorkNum(__getInt(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("attachmentManageId")) != null) setAttachmentManageId(__getInt(val)); 
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
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
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("superProjectManageId")) != null) setSuperProjectManageId(__getInt(val)); 
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("haveVoucher")) != null) setHaveVoucher(__getBoolean(val));
		if((val = values.get("invoiceAmount")) != null) setInvoiceAmount(__getDecimal(val));  
		if((val = values.get("employeeNameStr")) != null) setEmployeeNameStr(__getString(val));
	}

	protected java.lang.Integer  __attachment_manage_meeting_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.util.Date  __expect_return_date ;
	protected java.math.BigDecimal  __need_return_amount ;
	protected java.lang.String  __remark ;
	protected java.util.Date  __publish_date ;
	protected java.util.Date  __submit_date ;
	protected java.util.Date  __end_date ;
	protected java.lang.Integer  __metting_status ;
	protected java.lang.Integer  __operator_status ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __work_num ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __attachment_manage_id ;
	protected java.lang.Integer  __project_manage_id ;
	protected java.util.Date  __start_date ;
	protected java.lang.String  __contract_name ;
	protected java.lang.String  __contract_code ;
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
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __super_project_manage_id ;
	protected java.lang.Integer  __personnel_business_id ;
	protected java.lang.Boolean  __have_voucher ;
	protected java.math.BigDecimal  __invoice_amount ;
	protected java.lang.String  __employee_name_str ;
}
