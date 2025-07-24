package pomplatform.stage.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.bean.BaseProjectStageTemplate;

public class BaseProjectStageTemplateWithP extends BaseProjectStageTemplate 
{

	public static BaseProjectStageTemplateWithP newInstance(){
		return new BaseProjectStageTemplateWithP();
	}

	@Override
	public BaseProjectStageTemplateWithP make(){
		BaseProjectStageTemplateWithP b = new BaseProjectStageTemplateWithP();
		return b;
	}

	public List<BaseProjectStageTemplate> getDetailProjectStage() {
		return this.__detail_project_stages;
	}

	public void setDetailProjectStage( List<BaseProjectStageTemplate> value ) {
		this.__detail_project_stages = value;
	}

	public BaseProjectStageTemplate toBase(){
		BaseProjectStageTemplate base = new BaseProjectStageTemplate();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseProjectStageTemplate base){
		base.cloneCopy(this);
	}

	public static List<BaseProjectStageTemplate> getBaseList(List<BaseProjectStageTemplateWithP> beans) {
		List<BaseProjectStageTemplate> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProjectStageTemplateWithP bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseProjectStageTemplateWithP> getBeanList(List<BaseProjectStageTemplate> beans) {
		List<BaseProjectStageTemplateWithP> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProjectStageTemplate bean : beans) {
			BaseProjectStageTemplateWithP val = new BaseProjectStageTemplateWithP();
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
		if((val = values.get("detailProjectStage")) != null) setDetailProjectStage(__getList(val, BaseProjectStageTemplate.newInstance()));
	}

	protected List<BaseProjectStageTemplate> __detail_project_stages ; 
}
