package pomplatform.workflow.contractstatus.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseContractWithoutSureIntegral extends GenericBase implements BaseFactory<BaseContractWithoutSureIntegral>, Comparable<BaseContractWithoutSureIntegral> 
{


	public static BaseContractWithoutSureIntegral newInstance(){
		return new BaseContractWithoutSureIntegral();
	}

	@Override
	public BaseContractWithoutSureIntegral make(){
		BaseContractWithoutSureIntegral b = new BaseContractWithoutSureIntegral();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;

	public final static java.lang.String ALL_CAPTIONS = "合同ID";

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public void cloneCopy(BaseContractWithoutSureIntegral __bean){
		__bean.setContractId(getContractId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strContractId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractId()));
		sb.append(strContractId == null ? "" : strContractId);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractWithoutSureIntegral o) {
		return __contract_id == null ? -1 : __contract_id.compareTo(o.getContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractWithoutSureIntegral o = (BaseContractWithoutSureIntegral)obj;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getContractId() != null) res.put("contractId", getContractId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
	}

	protected java.lang.Integer  __contract_id ;
}
