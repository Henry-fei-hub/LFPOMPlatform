package pomplatform.stagemodel.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseContractStageAudit extends GenericBase implements BaseFactory<BaseContractStageAudit>, Comparable<BaseContractStageAudit> 
{


	public static BaseContractStageAudit newInstance(){
		return new BaseContractStageAudit();
	}

	@Override
	public BaseContractStageAudit make(){
		BaseContractStageAudit b = new BaseContractStageAudit();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_STAGE_MODEL_ID = "contract_stage_model_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_STAGE_MODEL_NAME = "stage_model_name" ;
	public final static java.lang.String CS_LOCKED = "locked" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,合同,合同编号,合同名称,节点名称,是否锁定";

	public java.lang.Integer getContractStageModelId() {
		return this.__contract_stage_model_id;
	}

	public void setContractStageModelId( java.lang.Integer value ) {
		this.__contract_stage_model_id = value;
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

	public java.lang.String getStageModelName() {
		return this.__stage_model_name;
	}

	public void setStageModelName( java.lang.String value ) {
		this.__stage_model_name = value;
	}

	public java.lang.Boolean getLocked() {
		return this.__locked;
	}

	public void setLocked( java.lang.Boolean value ) {
		this.__locked = value;
	}

	public void cloneCopy(BaseContractStageAudit __bean){
		__bean.setContractStageModelId(getContractStageModelId());
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setStageModelName(getStageModelName());
		__bean.setLocked(getLocked());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractStageModelId() == null ? "" : getContractStageModelId());
		sb.append(",");
		String strContractId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractId()));
		sb.append(strContractId == null ? "" : strContractId);
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getStageModelName() == null ? "" : getStageModelName());
		sb.append(",");
		sb.append(getLocked() == null ? "" : getLocked());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractStageAudit o) {
		return __contract_stage_model_id == null ? -1 : __contract_stage_model_id.compareTo(o.getContractStageModelId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_stage_model_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__stage_model_name);
		hash = 97 * hash + Objects.hashCode(this.__locked);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractStageAudit o = (BaseContractStageAudit)obj;
		if(!Objects.equals(this.__contract_stage_model_id, o.getContractStageModelId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__stage_model_name, o.getStageModelName())) return false;
		if(!Objects.equals(this.__locked, o.getLocked())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractStageModelId() != null) sb.append(__wrapNumber(count++, "contractStageModelId", getContractStageModelId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getStageModelName() != null) sb.append(__wrapString(count++, "stageModelName", getStageModelName()));
		if(getLocked() != null) sb.append(__wrapBoolean(count++, "locked", getLocked()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractStageModelId")) != null) setContractStageModelId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("stageModelName")) != null) setStageModelName(__getString(val));
		if((val = values.get("locked")) != null) setLocked(__getBoolean(val));
	}

	protected java.lang.Integer  __contract_stage_model_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.lang.String  __stage_model_name ;
	protected java.lang.Boolean  __locked ;
}
