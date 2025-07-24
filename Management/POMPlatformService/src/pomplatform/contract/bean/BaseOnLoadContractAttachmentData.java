package pomplatform.contract.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadContractAttachmentData extends GenericBase implements BaseFactory<BaseOnLoadContractAttachmentData>, Comparable<BaseOnLoadContractAttachmentData> 
{


	public static BaseOnLoadContractAttachmentData newInstance(){
		return new BaseOnLoadContractAttachmentData();
	}

	@Override
	public BaseOnLoadContractAttachmentData make(){
		BaseOnLoadContractAttachmentData b = new BaseOnLoadContractAttachmentData();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ATTACHMENT_ID = "contract_attachment_id" ;
	public final static java.lang.String CS_FILE_ID = "file_id" ;
	public final static java.lang.String CS_ATTACHMENT_CODE = "attachment_code" ;
	public final static java.lang.String CS_ATTACHMENT_NAME = "attachment_name" ;
	public final static java.lang.String CS_UPLOAD_EMPLOYEE_ID = "upload_employee_id" ;
	public final static java.lang.String CS_UPLOAD_TIME = "upload_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_IS_LINK = "is_link" ;
	public final static java.lang.String CS_FILE_URL = "file_url" ;
	public final static java.lang.String CS_SIGNING_MONEY_SUM = "signing_money_sum" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,附件编码,附件编码,附件名称,上传人员,上传时间,备注,,文件路径,合同金额,我方签约公司";

	public java.lang.Integer getContractAttachmentId() {
		return this.__contract_attachment_id;
	}

	public void setContractAttachmentId( java.lang.Integer value ) {
		this.__contract_attachment_id = value;
	}

	public java.lang.Integer getFileId() {
		return this.__file_id;
	}

	public void setFileId( java.lang.Integer value ) {
		this.__file_id = value;
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

	public java.lang.Integer getUploadEmployeeId() {
		return this.__upload_employee_id;
	}

	public void setUploadEmployeeId( java.lang.Integer value ) {
		this.__upload_employee_id = value;
	}

	public java.util.Date getUploadTime() {
		return this.__upload_time;
	}

	public void setUploadTime( java.util.Date value ) {
		this.__upload_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Boolean getIsLink() {
		return this.__is_link;
	}

	public void setIsLink( java.lang.Boolean value ) {
		this.__is_link = value;
	}

	public java.lang.String getFileUrl() {
		return this.__file_url;
	}

	public void setFileUrl( java.lang.String value ) {
		this.__file_url = value;
	}

	public java.math.BigDecimal getSigningMoneySum() {
		return this.__signing_money_sum;
	}

	public void setSigningMoneySum( java.math.BigDecimal value ) {
		this.__signing_money_sum = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public void cloneCopy(BaseOnLoadContractAttachmentData __bean){
		__bean.setContractAttachmentId(getContractAttachmentId());
		__bean.setFileId(getFileId());
		__bean.setAttachmentCode(getAttachmentCode());
		__bean.setAttachmentName(getAttachmentName());
		__bean.setUploadEmployeeId(getUploadEmployeeId());
		__bean.setUploadTime(getUploadTime());
		__bean.setRemark(getRemark());
		__bean.setIsLink(getIsLink());
		__bean.setFileUrl(getFileUrl());
		__bean.setSigningMoneySum(getSigningMoneySum());
		__bean.setCompanyId(getCompanyId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractAttachmentId() == null ? "" : getContractAttachmentId());
		sb.append(",");
		sb.append(getFileId() == null ? "" : getFileId());
		sb.append(",");
		sb.append(getAttachmentCode() == null ? "" : getAttachmentCode());
		sb.append(",");
		sb.append(getAttachmentName() == null ? "" : getAttachmentName());
		sb.append(",");
		sb.append(getUploadEmployeeId() == null ? "" : getUploadEmployeeId());
		sb.append(",");
		sb.append(getUploadTime() == null ? "" : sdf.format(getUploadTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getIsLink() == null ? "" : getIsLink());
		sb.append(",");
		sb.append(getFileUrl() == null ? "" : getFileUrl());
		sb.append(",");
		sb.append(getSigningMoneySum() == null ? "" : getSigningMoneySum());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadContractAttachmentData o) {
		return __contract_attachment_id == null ? -1 : __contract_attachment_id.compareTo(o.getContractAttachmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__file_id);
		hash = 97 * hash + Objects.hashCode(this.__attachment_code);
		hash = 97 * hash + Objects.hashCode(this.__attachment_name);
		hash = 97 * hash + Objects.hashCode(this.__upload_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__upload_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__is_link);
		hash = 97 * hash + Objects.hashCode(this.__file_url);
		hash = 97 * hash + Objects.hashCode(this.__signing_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadContractAttachmentData o = (BaseOnLoadContractAttachmentData)obj;
		if(!Objects.equals(this.__contract_attachment_id, o.getContractAttachmentId())) return false;
		if(!Objects.equals(this.__file_id, o.getFileId())) return false;
		if(!Objects.equals(this.__attachment_code, o.getAttachmentCode())) return false;
		if(!Objects.equals(this.__attachment_name, o.getAttachmentName())) return false;
		if(!Objects.equals(this.__upload_employee_id, o.getUploadEmployeeId())) return false;
		if(!Objects.equals(this.__upload_time, o.getUploadTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__is_link, o.getIsLink())) return false;
		if(!Objects.equals(this.__file_url, o.getFileUrl())) return false;
		if(!Objects.equals(this.__signing_money_sum, o.getSigningMoneySum())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractAttachmentId() != null) sb.append(__wrapNumber(count++, "contractAttachmentId", getContractAttachmentId()));
		if(getFileId() != null) sb.append(__wrapNumber(count++, "fileId", getFileId()));
		if(getAttachmentCode() != null) sb.append(__wrapString(count++, "attachmentCode", getAttachmentCode()));
		if(getAttachmentName() != null) sb.append(__wrapString(count++, "attachmentName", getAttachmentName()));
		if(getUploadEmployeeId() != null) sb.append(__wrapNumber(count++, "uploadEmployeeId", getUploadEmployeeId()));
		if(getUploadTime() != null) sb.append(__wrapDate(count++, "uploadTime", getUploadTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getIsLink() != null) sb.append(__wrapBoolean(count++, "isLink", getIsLink()));
		if(getFileUrl() != null) sb.append(__wrapString(count++, "fileUrl", getFileUrl()));
		if(getSigningMoneySum() != null) sb.append(__wrapDecimal(count++, "signingMoneySum", getSigningMoneySum()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractAttachmentId")) != null) setContractAttachmentId(__getInt(val)); 
		if((val = values.get("fileId")) != null) setFileId(__getInt(val)); 
		if((val = values.get("attachmentCode")) != null) setAttachmentCode(__getString(val));
		if((val = values.get("attachmentName")) != null) setAttachmentName(__getString(val));
		if((val = values.get("uploadEmployeeId")) != null) setUploadEmployeeId(__getInt(val)); 
		if((val = values.get("uploadTime")) != null) setUploadTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("isLink")) != null) setIsLink(__getBoolean(val));
		if((val = values.get("fileUrl")) != null) setFileUrl(__getString(val));
		if((val = values.get("signingMoneySum")) != null) setSigningMoneySum(__getDecimal(val));  
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
	}

	protected java.lang.Integer  __contract_attachment_id ;
	protected java.lang.Integer  __file_id ;
	protected java.lang.String  __attachment_code ;
	protected java.lang.String  __attachment_name ;
	protected java.lang.Integer  __upload_employee_id ;
	protected java.util.Date  __upload_time ;
	protected java.lang.String  __remark ;
	protected java.lang.Boolean  __is_link ;
	protected java.lang.String  __file_url ;
	protected java.math.BigDecimal  __signing_money_sum ;
	protected java.lang.Integer  __company_id ;
}
