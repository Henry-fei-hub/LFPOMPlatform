package pomplatform.projectSettlement.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetCountProjectSettlementCountByProjectId extends GenericBase implements BaseFactory<BaseGetCountProjectSettlementCountByProjectId>, Comparable<BaseGetCountProjectSettlementCountByProjectId> 
{


	public static BaseGetCountProjectSettlementCountByProjectId newInstance(){
		return new BaseGetCountProjectSettlementCountByProjectId();
	}

	@Override
	public BaseGetCountProjectSettlementCountByProjectId make(){
		BaseGetCountProjectSettlementCountByProjectId b = new BaseGetCountProjectSettlementCountByProjectId();
		return b;
	}

	public final static java.lang.String CS_SETTLEMENT_ID = "settlement_id" ;

	public final static java.lang.String ALL_CAPTIONS = "结算代码";

	public java.lang.Integer getSettlementId() {
		return this.__settlement_id;
	}

	public void setSettlementId( java.lang.Integer value ) {
		this.__settlement_id = value;
	}

	public void cloneCopy(BaseGetCountProjectSettlementCountByProjectId __bean){
		__bean.setSettlementId(getSettlementId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSettlementId() == null ? "" : getSettlementId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetCountProjectSettlementCountByProjectId o) {
		return __settlement_id == null ? -1 : __settlement_id.compareTo(o.getSettlementId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__settlement_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetCountProjectSettlementCountByProjectId o = (BaseGetCountProjectSettlementCountByProjectId)obj;
		if(!Objects.equals(this.__settlement_id, o.getSettlementId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSettlementId() != null) sb.append(__wrapNumber(count++, "settlementId", getSettlementId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSettlementId() != null) res.put("settlementId", getSettlementId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("settlementId")) != null) setSettlementId(__getInt(val)); 
	}

	protected java.lang.Integer  __settlement_id ;
}
