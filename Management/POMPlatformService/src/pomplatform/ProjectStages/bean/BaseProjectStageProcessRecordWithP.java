package pomplatform.ProjectStages.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseProjectStageProcessRecord;
import com.pomplatform.db.bean.BaseProjectStageProcessDetail;

public class BaseProjectStageProcessRecordWithP extends BaseProjectStageProcessRecord 
{

	public static BaseProjectStageProcessRecordWithP newInstance(){
		return new BaseProjectStageProcessRecordWithP();
	}

	@Override
	public BaseProjectStageProcessRecordWithP make(){
		BaseProjectStageProcessRecordWithP b = new BaseProjectStageProcessRecordWithP();
		return b;
	}

	public List<BaseProjectStageProcessDetail> getDetailProjectStageProcessDetail() {
		return this.__detail_project_stage_process_details;
	}

	public void setDetailProjectStageProcessDetail( List<BaseProjectStageProcessDetail> value ) {
		this.__detail_project_stage_process_details = value;
	}

	public BaseProjectStageProcessRecord toBase(){
		BaseProjectStageProcessRecord base = new BaseProjectStageProcessRecord();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseProjectStageProcessRecord base){
		base.cloneCopy(this);
	}

	public static List<BaseProjectStageProcessRecord> getBaseList(List<BaseProjectStageProcessRecordWithP> beans) {
		List<BaseProjectStageProcessRecord> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProjectStageProcessRecordWithP bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseProjectStageProcessRecordWithP> getBeanList(List<BaseProjectStageProcessRecord> beans) {
		List<BaseProjectStageProcessRecordWithP> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProjectStageProcessRecord bean : beans) {
			BaseProjectStageProcessRecordWithP val = new BaseProjectStageProcessRecordWithP();
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
		count = sb.length(); sb.append(__wrapList(count, "detailProjectStageProcessDetail", getDetailProjectStageProcessDetail()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailProjectStageProcessDetail")) != null) setDetailProjectStageProcessDetail(__getList(val, BaseProjectStageProcessDetail.newInstance()));
	}

	protected List<BaseProjectStageProcessDetail> __detail_project_stage_process_details ; 
}
