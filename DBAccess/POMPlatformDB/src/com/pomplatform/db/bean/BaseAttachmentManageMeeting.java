package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseAttachmentManageMeeting extends GenericBase implements BaseFactory<BaseAttachmentManageMeeting>, Comparable<BaseAttachmentManageMeeting> 
{


	public static BaseAttachmentManageMeeting newInstance(){
		return new BaseAttachmentManageMeeting();
	}

	@Override
	public BaseAttachmentManageMeeting make(){
		BaseAttachmentManageMeeting b = new BaseAttachmentManageMeeting();
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

	public final static java.lang.String ALL_CAPTIONS = ",合同编码,预期回款时间,需回款金额（金额-回款金额）,备注,发布日期,提交日期,终止日期,1新建 2发布 3定稿,1 待提交 2已提交  3未答复,,,操作人,创建时间,确认函编码,项目负责人,";

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

	public void cloneCopy(BaseAttachmentManageMeeting __bean){
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
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAttachmentManageMeeting o) {
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
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAttachmentManageMeeting o = (BaseAttachmentManageMeeting)obj;
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
}
