package pomplatform.stage.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectStage;

public class BaseProjectWithP extends BaseProject 
{

	public static BaseProjectWithP newInstance(){
		return new BaseProjectWithP();
	}

	@Override
	public BaseProjectWithP make(){
		BaseProjectWithP b = new BaseProjectWithP();
		return b;
	}

	public List<BaseProjectStage> getDetailProjectStage() {
		return this.__detail_project_stages;
	}

	public void setDetailProjectStage( List<BaseProjectStage> value ) {
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

	public static List<BaseProject> getBaseList(List<BaseProjectWithP> beans) {
		List<BaseProject> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProjectWithP bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseProjectWithP> getBeanList(List<BaseProject> beans) {
		List<BaseProjectWithP> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProject bean : beans) {
			BaseProjectWithP val = new BaseProjectWithP();
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
		if((val = values.get("detailProjectStage")) != null) setDetailProjectStage(__getList(val, BaseProjectStage.newInstance()));
	}

	protected List<BaseProjectStage> __detail_project_stages ; 
}
