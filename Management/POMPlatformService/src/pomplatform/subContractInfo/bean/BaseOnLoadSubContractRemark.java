package pomplatform.subContractInfo.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadSubContractRemark extends GenericBase implements BaseFactory<BaseOnLoadSubContractRemark>, Comparable<BaseOnLoadSubContractRemark> 
{


	public static BaseOnLoadSubContractRemark newInstance(){
		return new BaseOnLoadSubContractRemark();
	}

	@Override
	public BaseOnLoadSubContractRemark make(){
		BaseOnLoadSubContractRemark b = new BaseOnLoadSubContractRemark();
		return b;
	}

	public final static String CS_CONTRACT_ID = "contract_id" ;
	public final static String CS_SUB_CONTRACT_REMARKS = "sub_contract_remarks" ;
	public final static String CS_ATTACHMENT_ID = "attachment_id" ;
	public final static String CS_ATTACHMENT_NAME = "attachment_name" ;
	public final static String CS_ATTACHMENT = "attachment" ;
	public final static String CS_REMARK = "remark" ;

	public final static String ALL_CAPTIONS = "主订单编码,,,,,备注";

	public Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( Integer value ) {
		this.__contract_id = value;
	}

	public String getSubContractRemarks() {
		return this.__sub_contract_remarks;
	}

	public void setSubContractRemarks( String value ) {
		this.__sub_contract_remarks = value;
	}

	public Integer getAttachmentId() {
		return this.__attachment_id;
	}

	public void setAttachmentId( Integer value ) {
		this.__attachment_id = value;
	}

	public String getAttachmentName() {
		return this.__attachment_name;
	}

	public void setAttachmentName( String value ) {
		this.__attachment_name = value;
	}

	public String getAttachment() {
		return this.__attachment;
	}

	public void setAttachment( String value ) {
		this.__attachment = value;
	}

	public String getRemark() {
		return this.__remark;
	}

	public void setRemark( String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseOnLoadSubContractRemark __bean){
		__bean.setContractId(getContractId());
		__bean.setSubContractRemarks(getSubContractRemarks());
		__bean.setAttachmentId(getAttachmentId());
		__bean.setAttachmentName(getAttachmentName());
		__bean.setAttachment(getAttachment());
		__bean.setRemark(getRemark());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getSubContractRemarks() == null ? "" : getSubContractRemarks());
		sb.append(",");
		sb.append(getAttachmentId() == null ? "" : getAttachmentId());
		sb.append(",");
		sb.append(getAttachmentName() == null ? "" : getAttachmentName());
		sb.append(",");
		sb.append(getAttachment() == null ? "" : getAttachment());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadSubContractRemark o) {
		return __contract_id == null ? -1 : __contract_id.compareTo(o.getContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__sub_contract_remarks);
		hash = 97 * hash + Objects.hashCode(this.__attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__attachment_name);
		hash = 97 * hash + Objects.hashCode(this.__attachment);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadSubContractRemark o = (BaseOnLoadSubContractRemark)obj;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__sub_contract_remarks, o.getSubContractRemarks())) return false;
		if(!Objects.equals(this.__attachment_id, o.getAttachmentId())) return false;
		if(!Objects.equals(this.__attachment_name, o.getAttachmentName())) return false;
		if(!Objects.equals(this.__attachment, o.getAttachment())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getSubContractRemarks() != null) sb.append(__wrapString(count++, "subContractRemarks", getSubContractRemarks()));
		if(getAttachmentId() != null) sb.append(__wrapNumber(count++, "attachmentId", getAttachmentId()));
		if(getAttachmentName() != null) sb.append(__wrapString(count++, "attachmentName", getAttachmentName()));
		if(getAttachment() != null) sb.append(__wrapString(count++, "attachment", getAttachment()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getSubContractRemarks() != null) res.put("subContractRemarks", getSubContractRemarks());
		if(getAttachmentId() != null) res.put("attachmentId", getAttachmentId());
		if(getAttachmentName() != null) res.put("attachmentName", getAttachmentName());
		if(getAttachment() != null) res.put("attachment", getAttachment());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("subContractRemarks")) != null) setSubContractRemarks(__getString(val));
		if((val = values.get("attachmentId")) != null) setAttachmentId(__getInt(val)); 
		if((val = values.get("attachmentName")) != null) setAttachmentName(__getString(val));
		if((val = values.get("attachment")) != null) setAttachment(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected Integer  __contract_id ;
	protected String  __sub_contract_remarks ;
	protected Integer  __attachment_id ;
	protected String  __attachment_name ;
	protected String  __attachment ;
	protected String  __remark ;
}
