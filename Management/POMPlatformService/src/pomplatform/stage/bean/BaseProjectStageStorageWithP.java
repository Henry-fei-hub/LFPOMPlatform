package pomplatform.stage.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.bean.BaseProjectStageStorage;

public class BaseProjectStageStorageWithP extends BaseProject 
{

	public static BaseProjectStageStorageWithP newInstance(){
		return new BaseProjectStageStorageWithP();
	}

	@Override
	public BaseProjectStageStorageWithP make(){
		BaseProjectStageStorageWithP b = new BaseProjectStageStorageWithP();
		return b;
	}

	public List<BaseProjectStageStorage> getDetailProjectStage() {
		return this.__detail_project_stages;
	}

	public void setDetailProjectStage( List<BaseProjectStageStorage> value ) {
		this.__detail_project_stages = value;
	}

	public BaseProject toBase(){
		BaseProject base = new BaseProject();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseProject base){
		base.cloneCopy(this);
	}

	public static List<BaseProject> getBaseList(List<BaseProjectStageStorageWithP> beans) {
		List<BaseProject> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProjectStageStorageWithP bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseProjectStageStorageWithP> getBeanList(List<BaseProject> beans) {
		List<BaseProjectStageStorageWithP> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProject bean : beans) {
			BaseProjectStageStorageWithP val = new BaseProjectStageStorageWithP();
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
		count = sb.length(); sb.append(__wrapList(count, "detailProjectStage", getDetailProjectStage()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailProjectStage")) != null) 
			setDetailProjectStage(__getList(val, BaseProjectStageStorage.newInstance()));
	}

	protected List<BaseProjectStageStorage> __detail_project_stages ; 
}
