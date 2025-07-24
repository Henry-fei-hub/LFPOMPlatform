package pomplatform.project.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadProjectStage extends GenericBase implements BaseFactory<BaseOnLoadProjectStage>, Comparable<BaseOnLoadProjectStage> 
{


	public static BaseOnLoadProjectStage newInstance(){
		return new BaseOnLoadProjectStage();
	}

	@Override
	public BaseOnLoadProjectStage make(){
		BaseOnLoadProjectStage b = new BaseOnLoadProjectStage();
		return b;
	}

	public final static java.lang.String CS_STAGE_ID = "stage_id" ;

	public final static java.lang.String ALL_CAPTIONS = "阶段id";

	public java.lang.Integer getStageId() {
		return this.__stage_id;
	}

	public void setStageId( java.lang.Integer value ) {
		this.__stage_id = value;
	}

	public void cloneCopy(BaseOnLoadProjectStage __bean){
		__bean.setStageId(getStageId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getStageId() == null ? "" : getStageId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadProjectStage o) {
		return __stage_id == null ? -1 : __stage_id.compareTo(o.getStageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__stage_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadProjectStage o = (BaseOnLoadProjectStage)obj;
		if(!Objects.equals(this.__stage_id, o.getStageId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getStageId() != null) sb.append(__wrapNumber(count++, "stageId", getStageId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getStageId() != null) res.put("stageId", getStageId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("stageId")) != null) setStageId(__getInt(val)); 
	}

	protected java.lang.Integer  __stage_id ;
}
