package pomplatform.contractMessage.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadContractMessageRecord extends GenericBase implements BaseFactory<BaseOnLoadContractMessageRecord>, Comparable<BaseOnLoadContractMessageRecord> 
{


	public static BaseOnLoadContractMessageRecord newInstance(){
		return new BaseOnLoadContractMessageRecord();
	}

	@Override
	public BaseOnLoadContractMessageRecord make(){
		BaseOnLoadContractMessageRecord b = new BaseOnLoadContractMessageRecord();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_MESSAGE_ID = "contract_message_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_MSG_COUNT = "msg_count" ;
	public final static java.lang.String CS_MSG_STATUS = "msg_status" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "id,合同id,主订单编号,主订单名称,业务id,消息推送次数,消息状态   0 无意义 ，1 需要进行消息推送   2 已完成，不需要进行消息推送   3 已失效,操作人id,创建时间,备注";

	public java.lang.Integer getContractMessageId() {
		return this.__contract_message_id;
	}

	public void setContractMessageId( java.lang.Integer value ) {
		this.__contract_message_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public java.lang.Integer getMsgCount() {
		return this.__msg_count;
	}

	public void setMsgCount( java.lang.Integer value ) {
		this.__msg_count = value;
	}

	public java.lang.Integer getMsgStatus() {
		return this.__msg_status;
	}

	public void setMsgStatus( java.lang.Integer value ) {
		this.__msg_status = value;
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

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseOnLoadContractMessageRecord __bean){
		__bean.setContractMessageId(getContractMessageId());
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setBusinessId(getBusinessId());
		__bean.setMsgCount(getMsgCount());
		__bean.setMsgStatus(getMsgStatus());
		__bean.setOperator(getOperator());
		__bean.setCreateTime(getCreateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractMessageId() == null ? "" : getContractMessageId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getMsgCount() == null ? "" : getMsgCount());
		sb.append(",");
		sb.append(getMsgStatus() == null ? "" : getMsgStatus());
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadContractMessageRecord o) {
		return __contract_message_id == null ? -1 : __contract_message_id.compareTo(o.getContractMessageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_message_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__msg_count);
		hash = 97 * hash + Objects.hashCode(this.__msg_status);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadContractMessageRecord o = (BaseOnLoadContractMessageRecord)obj;
		if(!Objects.equals(this.__contract_message_id, o.getContractMessageId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__msg_count, o.getMsgCount())) return false;
		if(!Objects.equals(this.__msg_status, o.getMsgStatus())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractMessageId() != null) sb.append(__wrapNumber(count++, "contractMessageId", getContractMessageId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getMsgCount() != null) sb.append(__wrapNumber(count++, "msgCount", getMsgCount()));
		if(getMsgStatus() != null) sb.append(__wrapNumber(count++, "msgStatus", getMsgStatus()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getContractMessageId() != null) res.put("contractMessageId", getContractMessageId());
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getContractCode() != null) res.put("contractCode", getContractCode());
		if(getContractName() != null) res.put("contractName", getContractName());
		if(getBusinessId() != null) res.put("businessId", getBusinessId());
		if(getMsgCount() != null) res.put("msgCount", getMsgCount());
		if(getMsgStatus() != null) res.put("msgStatus", getMsgStatus());
		if(getOperator() != null) res.put("operator", getOperator());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractMessageId")) != null) setContractMessageId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("msgCount")) != null) setMsgCount(__getInt(val)); 
		if((val = values.get("msgStatus")) != null) setMsgStatus(__getInt(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __contract_message_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.Integer  __msg_count ;
	protected java.lang.Integer  __msg_status ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __remark ;
}
