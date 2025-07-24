package pomplatform.contractMessage.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMcontractmor extends GenericBase implements BaseFactory<BaseMcontractmor>, Comparable<BaseMcontractmor> 
{


	public static BaseMcontractmor newInstance(){
		return new BaseMcontractmor();
	}

	@Override
	public BaseMcontractmor make(){
		BaseMcontractmor b = new BaseMcontractmor();
		return b;
	}

	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_CONTRACT_MESSAGE_ID = "contract_message_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,id,主订单编号,主订单名称,合同id";

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.Integer getContractMessageId() {
		return this.__contract_message_id;
	}

	public void setContractMessageId( java.lang.Integer value ) {
		this.__contract_message_id = value;
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

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public void cloneCopy(BaseMcontractmor __bean){
		__bean.setMainProjectId(getMainProjectId());
		__bean.setContractMessageId(getContractMessageId());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setContractId(getContractId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getContractMessageId() == null ? "" : getContractMessageId());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMcontractmor o) {
		return __main_project_id == null ? -1 : __main_project_id.compareTo(o.getMainProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_message_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMcontractmor o = (BaseMcontractmor)obj;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__contract_message_id, o.getContractMessageId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getContractMessageId() != null) sb.append(__wrapNumber(count++, "contractMessageId", getContractMessageId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMainProjectId() != null) res.put("mainProjectId", getMainProjectId());
		if(getContractMessageId() != null) res.put("contractMessageId", getContractMessageId());
		if(getContractCode() != null) res.put("contractCode", getContractCode());
		if(getContractName() != null) res.put("contractName", getContractName());
		if(getContractId() != null) res.put("contractId", getContractId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("contractMessageId")) != null) setContractMessageId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
	}

	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Integer  __contract_message_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.lang.Integer  __contract_id ;
}
