package pomplatform.mainProjectInfo.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMsystemprocessinstanceppcmor extends GenericBase implements BaseFactory<BaseMsystemprocessinstanceppcmor>, Comparable<BaseMsystemprocessinstanceppcmor> 
{


	public static BaseMsystemprocessinstanceppcmor newInstance(){
		return new BaseMsystemprocessinstanceppcmor();
	}

	@Override
	public BaseMsystemprocessinstanceppcmor make(){
		BaseMsystemprocessinstanceppcmor b = new BaseMsystemprocessinstanceppcmor();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;

	public final static java.lang.String ALL_CAPTIONS = "主订单编码,流程状态 0 发起中  1";

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public void cloneCopy(BaseMsystemprocessinstanceppcmor __bean){
		__bean.setContractId(getContractId());
		__bean.setProcessStatus(getProcessStatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getProcessStatus() == null ? "" : getProcessStatus());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMsystemprocessinstanceppcmor o) {
		return __contract_id == null ? -1 : __contract_id.compareTo(o.getContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMsystemprocessinstanceppcmor o = (BaseMsystemprocessinstanceppcmor)obj;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getProcessStatus() != null) res.put("processStatus", getProcessStatus());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
	}

	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __process_status ;
}
