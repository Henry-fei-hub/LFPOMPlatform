package pomplatform.mobile.approvalcount.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMyApprovalProcessDetail extends GenericBase implements BaseFactory<BaseMyApprovalProcessDetail>, Comparable<BaseMyApprovalProcessDetail> 
{


	public static BaseMyApprovalProcessDetail newInstance(){
		return new BaseMyApprovalProcessDetail();
	}

	@Override
	public BaseMyApprovalProcessDetail make(){
		BaseMyApprovalProcessDetail b = new BaseMyApprovalProcessDetail();
		return b;
	}

	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_PROCESS_TYPE_NAME = "process_type_name" ;
	public final static java.lang.String CS_NEED_DEAL = "need_deal" ;

	public final static java.lang.String ALL_CAPTIONS = "流程类型,流程类型名称,";

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.String getProcessTypeName() {
		return this.__process_type_name;
	}

	public void setProcessTypeName( java.lang.String value ) {
		this.__process_type_name = value;
	}

	public java.lang.Long getNeedDeal() {
		return this.__need_deal;
	}

	public void setNeedDeal( java.lang.Long value ) {
		this.__need_deal = value;
	}

	public void cloneCopy(BaseMyApprovalProcessDetail __bean){
		__bean.setProcessType(getProcessType());
		__bean.setProcessTypeName(getProcessTypeName());
		__bean.setNeedDeal(getNeedDeal());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getProcessTypeName() == null ? "" : getProcessTypeName());
		sb.append(",");
		sb.append(getNeedDeal() == null ? "" : getNeedDeal());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMyApprovalProcessDetail o) {
		return __process_type == null ? -1 : __process_type.compareTo(o.getProcessType());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__process_type_name);
		hash = 97 * hash + Objects.hashCode(this.__need_deal);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMyApprovalProcessDetail o = (BaseMyApprovalProcessDetail)obj;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__process_type_name, o.getProcessTypeName())) return false;
		if(!Objects.equals(this.__need_deal, o.getNeedDeal())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getProcessTypeName() != null) sb.append(__wrapString(count++, "processTypeName", getProcessTypeName()));
		if(getNeedDeal() != null) sb.append(__wrapNumber(count++, "needDeal", getNeedDeal()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("processTypeName")) != null) setProcessTypeName(__getString(val));
		if((val = values.get("needDeal")) != null) setNeedDeal(__getLong(val)); 
	}

	protected java.lang.Integer  __process_type ;
	protected java.lang.String  __process_type_name ;
	protected java.lang.Long  __need_deal ;
}
