package pomplatform.approveProjectStageStorage.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseApproveProjectStageStorage;
import com.pomplatform.db.bean.BaseProjectStageStorage;
import com.pomplatform.db.bean.BaseProjectStage;

public class BaseApproveProjectStageStorageWithPp extends BaseApproveProjectStageStorage 
{

	public static BaseApproveProjectStageStorageWithPp newInstance(){
		return new BaseApproveProjectStageStorageWithPp();
	}

	@Override
	public BaseApproveProjectStageStorageWithPp make(){
		BaseApproveProjectStageStorageWithPp b = new BaseApproveProjectStageStorageWithPp();
		return b;
	}

	public List<BaseProjectStageStorage> getDetailProjectStageStorage() {
		return this.__detail_project_stage_storages;
	}

	public void setDetailProjectStageStorage( List<BaseProjectStageStorage> value ) {
		this.__detail_project_stage_storages = value;
	}

	public List<BaseProjectStage> getDetailProjectStage() {
		return this.__detail_project_stages;
	}

	public void setDetailProjectStage( List<BaseProjectStage> value ) {
		this.__detail_project_stages = value;
	}

	public BaseApproveProjectStageStorage toBase(){
		BaseApproveProjectStageStorage base = new BaseApproveProjectStageStorage();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseApproveProjectStageStorage base){
		base.cloneCopy(this);
	}

	public static List<BaseApproveProjectStageStorage> getBaseList(List<BaseApproveProjectStageStorageWithPp> beans) {
		List<BaseApproveProjectStageStorage> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseApproveProjectStageStorageWithPp bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseApproveProjectStageStorageWithPp> getBeanList(List<BaseApproveProjectStageStorage> beans) {
		List<BaseApproveProjectStageStorageWithPp> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseApproveProjectStageStorage bean : beans) {
			BaseApproveProjectStageStorageWithPp val = new BaseApproveProjectStageStorageWithPp();
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
		count = sb.length(); sb.append(__wrapList(count, "detailProjectStageStorage", getDetailProjectStageStorage()));
		count = sb.length(); sb.append(__wrapList(count, "detailProjectStage", getDetailProjectStage()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailProjectStageStorage")) != null) setDetailProjectStageStorage(__getList(val, BaseProjectStageStorage.newInstance()));
		if((val = values.get("detailProjectStage")) != null) setDetailProjectStage(__getList(val, BaseProjectStage.newInstance()));
	}

	protected List<BaseProjectStageStorage> __detail_project_stage_storages ; 
	protected List<BaseProjectStage> __detail_project_stages ; 
}
