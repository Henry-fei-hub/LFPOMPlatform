package pomplatform.stagemodel.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetStageModelByParentId extends GenericBase implements BaseFactory<BaseGetStageModelByParentId>, Comparable<BaseGetStageModelByParentId> 
{


	public static BaseGetStageModelByParentId newInstance(){
		return new BaseGetStageModelByParentId();
	}

	@Override
	public BaseGetStageModelByParentId make(){
		BaseGetStageModelByParentId b = new BaseGetStageModelByParentId();
		return b;
	}

	public final static java.lang.String CS_STAGE_MODEL_ID = "stage_model_id" ;
	public final static java.lang.String CS_STAGE_MODEL_NAME = "stage_model_name" ;
	public final static java.lang.String CS_PERCENT = "percent" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_LEAF_NODE = "leaf_node" ;
	public final static java.lang.String CS_ORDER_NO = "order_no" ;
	public final static java.lang.String CS_NEED_MANAGER_AUDIT = "need_manager_audit" ;
	public final static java.lang.String CS_NEED_DESIGN_DIRECTOR_AUDIT = "need_design_director_audit" ;
	public final static java.lang.String CS_PATH = "path" ;
	public final static java.lang.String CS_DEPTH = "depth" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,名称,阶段百分比,父级,是否为叶子结点,排序,需要项目经理审批,需要设计总监审批,路径,深度,备注";

	public java.lang.Integer getStageModelId() {
		return this.__stage_model_id;
	}

	public void setStageModelId( java.lang.Integer value ) {
		this.__stage_model_id = value;
	}

	public java.lang.String getStageModelName() {
		return this.__stage_model_name;
	}

	public void setStageModelName( java.lang.String value ) {
		this.__stage_model_name = value;
	}

	public java.math.BigDecimal getPercent() {
		return this.__percent;
	}

	public void setPercent( java.math.BigDecimal value ) {
		this.__percent = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Boolean getLeafNode() {
		return this.__leaf_node;
	}

	public void setLeafNode( java.lang.Boolean value ) {
		this.__leaf_node = value;
	}

	public java.lang.Integer getOrderNo() {
		return this.__order_no;
	}

	public void setOrderNo( java.lang.Integer value ) {
		this.__order_no = value;
	}

	public java.lang.Boolean getNeedManagerAudit() {
		return this.__need_manager_audit;
	}

	public void setNeedManagerAudit( java.lang.Boolean value ) {
		this.__need_manager_audit = value;
	}

	public java.lang.Boolean getNeedDesignDirectorAudit() {
		return this.__need_design_director_audit;
	}

	public void setNeedDesignDirectorAudit( java.lang.Boolean value ) {
		this.__need_design_director_audit = value;
	}

	public java.lang.Integer[] getPath() {
		return (Integer[]) this.__path;
	}

	public void setPath( java.lang.Object value ) {
		this.__path = value;
	}

	public java.lang.Integer getDepth() {
		return this.__depth;
	}

	public void setDepth( java.lang.Integer value ) {
		this.__depth = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseGetStageModelByParentId __bean){
		__bean.setStageModelId(getStageModelId());
		__bean.setStageModelName(getStageModelName());
		__bean.setPercent(getPercent());
		__bean.setParentId(getParentId());
		__bean.setLeafNode(getLeafNode());
		__bean.setOrderNo(getOrderNo());
		__bean.setNeedManagerAudit(getNeedManagerAudit());
		__bean.setNeedDesignDirectorAudit(getNeedDesignDirectorAudit());
		__bean.setPath(getPath());
		__bean.setDepth(getDepth());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getStageModelId() == null ? "" : getStageModelId());
		sb.append(",");
		sb.append(getStageModelName() == null ? "" : getStageModelName());
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent());
		sb.append(",");
		String strParentId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts_1", String.valueOf(getParentId()));
		sb.append(strParentId == null ? "" : strParentId);
		sb.append(",");
		sb.append(getLeafNode() == null ? "" : getLeafNode());
		sb.append(",");
		sb.append(getOrderNo() == null ? "" : getOrderNo());
		sb.append(",");
		sb.append(getNeedManagerAudit() == null ? "" : getNeedManagerAudit());
		sb.append(",");
		sb.append(getNeedDesignDirectorAudit() == null ? "" : getNeedDesignDirectorAudit());
		sb.append(",");
		sb.append(getPath() == null ? "" : getPath());
		sb.append(",");
		sb.append(getDepth() == null ? "" : getDepth());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetStageModelByParentId o) {
		return __stage_model_id == null ? -1 : __stage_model_id.compareTo(o.getStageModelId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__stage_model_id);
		hash = 97 * hash + Objects.hashCode(this.__stage_model_name);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__leaf_node);
		hash = 97 * hash + Objects.hashCode(this.__order_no);
		hash = 97 * hash + Objects.hashCode(this.__need_manager_audit);
		hash = 97 * hash + Objects.hashCode(this.__need_design_director_audit);
		hash = 97 * hash + Objects.hashCode(this.__path);
		hash = 97 * hash + Objects.hashCode(this.__depth);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetStageModelByParentId o = (BaseGetStageModelByParentId)obj;
		if(!Objects.equals(this.__stage_model_id, o.getStageModelId())) return false;
		if(!Objects.equals(this.__stage_model_name, o.getStageModelName())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__leaf_node, o.getLeafNode())) return false;
		if(!Objects.equals(this.__order_no, o.getOrderNo())) return false;
		if(!Objects.equals(this.__need_manager_audit, o.getNeedManagerAudit())) return false;
		if(!Objects.equals(this.__need_design_director_audit, o.getNeedDesignDirectorAudit())) return false;
		if(!Objects.equals(this.__path, o.getPath())) return false;
		if(!Objects.equals(this.__depth, o.getDepth())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getStageModelId() != null) sb.append(__wrapNumber(count++, "stageModelId", getStageModelId()));
		if(getStageModelName() != null) sb.append(__wrapString(count++, "stageModelName", getStageModelName()));
		if(getPercent() != null) sb.append(__wrapDecimal(count++, "percent", getPercent()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getLeafNode() != null) sb.append(__wrapBoolean(count++, "leafNode", getLeafNode()));
		if(getOrderNo() != null) sb.append(__wrapNumber(count++, "orderNo", getOrderNo()));
		if(getNeedManagerAudit() != null) sb.append(__wrapBoolean(count++, "needManagerAudit", getNeedManagerAudit()));
		if(getNeedDesignDirectorAudit() != null) sb.append(__wrapBoolean(count++, "needDesignDirectorAudit", getNeedDesignDirectorAudit()));
		if(getPath() != null) sb.append(__wrapString(count++, "path", getPath().toString()));
		if(getDepth() != null) sb.append(__wrapNumber(count++, "depth", getDepth()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("stageModelId")) != null) setStageModelId(__getInt(val)); 
		if((val = values.get("stageModelName")) != null) setStageModelName(__getString(val));
		if((val = values.get("percent")) != null) setPercent(__getDecimal(val));  
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("leafNode")) != null) setLeafNode(__getBoolean(val));
		if((val = values.get("orderNo")) != null) setOrderNo(__getInt(val)); 
		if((val = values.get("needManagerAudit")) != null) setNeedManagerAudit(__getBoolean(val));
		if((val = values.get("needDesignDirectorAudit")) != null) setNeedDesignDirectorAudit(__getBoolean(val));
		if((val = values.get("path")) != null) setPath(__getString(val));
		if((val = values.get("depth")) != null) setDepth(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __stage_model_id ;
	protected java.lang.String  __stage_model_name ;
	protected java.math.BigDecimal  __percent ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Boolean  __leaf_node ;
	protected java.lang.Integer  __order_no ;
	protected java.lang.Boolean  __need_manager_audit ;
	protected java.lang.Boolean  __need_design_director_audit ;
	protected java.lang.Object  __path ;
	protected java.lang.Integer  __depth ;
	protected java.lang.String  __remark ;
}
