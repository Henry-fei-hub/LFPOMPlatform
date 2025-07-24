package pomplatform.contractincome.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetContractStageByInvoice extends GenericBase implements BaseFactory<BaseGetContractStageByInvoice>, Comparable<BaseGetContractStageByInvoice> 
{


	public static BaseGetContractStageByInvoice newInstance(){
		return new BaseGetContractStageByInvoice();
	}

	@Override
	public BaseGetContractStageByInvoice make(){
		BaseGetContractStageByInvoice b = new BaseGetContractStageByInvoice();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_RECEIVABLE_ID = "contract_receivable_id" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_RECEIVABLE_NAME = "receivable_name" ;

	public final static java.lang.String ALL_CAPTIONS = "合同阶段id,收款阶段id的父节点,阶段名称";

	public java.lang.Integer getContractReceivableId() {
		return this.__contract_receivable_id;
	}

	public void setContractReceivableId( java.lang.Integer value ) {
		this.__contract_receivable_id = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.String getReceivableName() {
		return this.__receivable_name;
	}

	public void setReceivableName( java.lang.String value ) {
		this.__receivable_name = value;
	}

	public void cloneCopy(BaseGetContractStageByInvoice __bean){
		__bean.setContractReceivableId(getContractReceivableId());
		__bean.setParentId(getParentId());
		__bean.setReceivableName(getReceivableName());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractReceivableId() == null ? "" : getContractReceivableId());
		sb.append(",");
		String strParentId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts_1", String.valueOf(getParentId()));
		sb.append(strParentId == null ? "" : strParentId);
		sb.append(",");
		sb.append(getReceivableName() == null ? "" : getReceivableName());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetContractStageByInvoice o) {
		return __contract_receivable_id == null ? -1 : __contract_receivable_id.compareTo(o.getContractReceivableId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_receivable_id);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__receivable_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetContractStageByInvoice o = (BaseGetContractStageByInvoice)obj;
		if(!Objects.equals(this.__contract_receivable_id, o.getContractReceivableId())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__receivable_name, o.getReceivableName())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractReceivableId() != null) sb.append(__wrapNumber(count++, "contractReceivableId", getContractReceivableId()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getReceivableName() != null) sb.append(__wrapString(count++, "receivableName", getReceivableName()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getContractReceivableId() != null) res.put("contractReceivableId", getContractReceivableId());
		if(getParentId() != null) res.put("parentId", getParentId());
		if(getReceivableName() != null) res.put("receivableName", getReceivableName());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractReceivableId")) != null) setContractReceivableId(__getInt(val)); 
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("receivableName")) != null) setReceivableName(__getString(val));
	}

	protected java.lang.Integer  __contract_receivable_id ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.String  __receivable_name ;
}
