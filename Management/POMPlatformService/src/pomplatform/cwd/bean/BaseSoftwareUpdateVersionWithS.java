package pomplatform.cwd.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseSoftwareUpdateVersion;
import com.pomplatform.db.bean.BaseSoftwareUpdateFile;

public class BaseSoftwareUpdateVersionWithS extends BaseSoftwareUpdateVersion 
{

	public static BaseSoftwareUpdateVersionWithS newInstance(){
		return new BaseSoftwareUpdateVersionWithS();
	}

	@Override
	public BaseSoftwareUpdateVersionWithS make(){
		BaseSoftwareUpdateVersionWithS b = new BaseSoftwareUpdateVersionWithS();
		return b;
	}

	public List<BaseSoftwareUpdateFile> getDetailSoftwareUpdateFile() {
		return this.__detail_software_update_files;
	}

	public void setDetailSoftwareUpdateFile( List<BaseSoftwareUpdateFile> value ) {
		this.__detail_software_update_files = value;
	}

	public BaseSoftwareUpdateVersion toBase(){
		BaseSoftwareUpdateVersion base = new BaseSoftwareUpdateVersion();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseSoftwareUpdateVersion base){
		base.cloneCopy(this);
	}

	public static List<BaseSoftwareUpdateVersion> getBaseList(List<BaseSoftwareUpdateVersionWithS> beans) {
		List<BaseSoftwareUpdateVersion> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseSoftwareUpdateVersionWithS bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseSoftwareUpdateVersionWithS> getBeanList(List<BaseSoftwareUpdateVersion> beans) {
		List<BaseSoftwareUpdateVersionWithS> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseSoftwareUpdateVersion bean : beans) {
			BaseSoftwareUpdateVersionWithS val = new BaseSoftwareUpdateVersionWithS();
			val.getDataFromBase(bean);
			result.add(val);
		}
		return result;
	}

	@Override
	public java.lang.String toJSONString() {

		int count = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		count = sb.length(); sb.append(__wrapList(count, "detailSoftwareUpdateFile", getDetailSoftwareUpdateFile()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailSoftwareUpdateFile")) != null) setDetailSoftwareUpdateFile(__getList(val, BaseSoftwareUpdateFile.newInstance()));
	}

	protected List<BaseSoftwareUpdateFile> __detail_software_update_files ; 
}
