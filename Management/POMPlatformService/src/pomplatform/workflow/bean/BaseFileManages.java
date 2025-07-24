package pomplatform.workflow.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseFileManages extends GenericBase implements BaseFactory<BaseFileManages>, Comparable<BaseFileManages> 
{


	public static BaseFileManages newInstance(){
		return new BaseFileManages();
	}

	@Override
	public BaseFileManages make(){
		BaseFileManages b = new BaseFileManages();
		return b;
	}

	public final static String CS_FILE_URL = "file_url" ;

	public final static String ALL_CAPTIONS = "文件路径";

	public String getFileUrl() {
		return this.__file_url;
	}

	public void setFileUrl( String value ) {
		this.__file_url = value;
	}

	public void cloneCopy(BaseFileManages __bean){
		__bean.setFileUrl(getFileUrl());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFileUrl() == null ? "" : getFileUrl());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFileManages o) {
		return __file_url == null ? -1 : __file_url.compareTo(o.getFileUrl());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__file_url);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFileManages o = (BaseFileManages)obj;
		if(!Objects.equals(this.__file_url, o.getFileUrl())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFileUrl() != null) sb.append(__wrapString(count++, "fileUrl", getFileUrl()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getFileUrl() != null) res.put("fileUrl", getFileUrl());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("fileUrl")) != null) setFileUrl(__getString(val));
	}

	protected String  __file_url ;
}
