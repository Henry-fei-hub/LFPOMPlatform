package pomplatform.project.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSprojectpricechangedrecordgroupor extends GenericBase implements BaseFactory<BaseSprojectpricechangedrecordgroupor>, Comparable<BaseSprojectpricechangedrecordgroupor> 
{


	public static BaseSprojectpricechangedrecordgroupor newInstance(){
		return new BaseSprojectpricechangedrecordgroupor();
	}

	@Override
	public BaseSprojectpricechangedrecordgroupor make(){
		BaseSprojectpricechangedrecordgroupor b = new BaseSprojectpricechangedrecordgroupor();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;

	public final static java.lang.String ALL_CAPTIONS = "项目编码";

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public void cloneCopy(BaseSprojectpricechangedrecordgroupor __bean){
		__bean.setProjectId(getProjectId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectId() == null ? "" : getProjectId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSprojectpricechangedrecordgroupor o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSprojectpricechangedrecordgroupor o = (BaseSprojectpricechangedrecordgroupor)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
	}

	protected java.lang.Integer  __project_id ;
}
