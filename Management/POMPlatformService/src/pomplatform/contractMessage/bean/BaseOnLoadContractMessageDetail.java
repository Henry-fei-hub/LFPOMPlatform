package pomplatform.contractMessage.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadContractMessageDetail extends GenericBase implements BaseFactory<BaseOnLoadContractMessageDetail>, Comparable<BaseOnLoadContractMessageDetail> 
{


	public static BaseOnLoadContractMessageDetail newInstance(){
		return new BaseOnLoadContractMessageDetail();
	}

	@Override
	public BaseOnLoadContractMessageDetail make(){
		BaseOnLoadContractMessageDetail b = new BaseOnLoadContractMessageDetail();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_MESSAGE_DETAIL_ID = "contract_message_detail_id" ;
	public final static java.lang.String CS_CONTRACT_MESSAGE_ID = "contract_message_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "id,id,合同id,操作人id,创建时间,消息推送人员";

	public java.lang.Integer getContractMessageDetailId() {
		return this.__contract_message_detail_id;
	}

	public void setContractMessageDetailId( java.lang.Integer value ) {
		this.__contract_message_detail_id = value;
	}

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

	public void cloneCopy(BaseOnLoadContractMessageDetail __bean){
		__bean.setContractMessageDetailId(getContractMessageDetailId());
		__bean.setContractMessageId(getContractMessageId());
		__bean.setContractId(getContractId());
		__bean.setOperator(getOperator());
		__bean.setCreateTime(getCreateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractMessageDetailId() == null ? "" : getContractMessageDetailId());
		sb.append(",");
		sb.append(getContractMessageId() == null ? "" : getContractMessageId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadContractMessageDetail o) {
		return __contract_message_detail_id == null ? -1 : __contract_message_detail_id.compareTo(o.getContractMessageDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_message_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_message_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadContractMessageDetail o = (BaseOnLoadContractMessageDetail)obj;
		if(!Objects.equals(this.__contract_message_detail_id, o.getContractMessageDetailId())) return false;
		if(!Objects.equals(this.__contract_message_id, o.getContractMessageId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractMessageDetailId() != null) sb.append(__wrapNumber(count++, "contractMessageDetailId", getContractMessageDetailId()));
		if(getContractMessageId() != null) sb.append(__wrapNumber(count++, "contractMessageId", getContractMessageId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getContractMessageDetailId() != null) res.put("contractMessageDetailId", getContractMessageDetailId());
		if(getContractMessageId() != null) res.put("contractMessageId", getContractMessageId());
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getOperator() != null) res.put("operator", getOperator());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractMessageDetailId")) != null) setContractMessageDetailId(__getInt(val)); 
		if((val = values.get("contractMessageId")) != null) setContractMessageId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __contract_message_detail_id ;
	protected java.lang.Integer  __contract_message_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __remark ;
}
