package pomplatform.soutdesignconsiderationoor.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseOutDesignConsideration;
import com.pomplatform.db.bean.BaseOutDesignConsideration;

public class BaseOutDesignConsiderationWithO extends BaseOutDesignConsideration 
{

	public static BaseOutDesignConsiderationWithO newInstance(){
		return new BaseOutDesignConsiderationWithO();
	}

	@Override
	public BaseOutDesignConsiderationWithO make(){
		BaseOutDesignConsiderationWithO b = new BaseOutDesignConsiderationWithO();
		return b;
	}

	public List<BaseOutDesignConsideration> getDetailOutDesignConsideration() {
		return this.__detail_out_design_considerations;
	}

	public void setDetailOutDesignConsideration( List<BaseOutDesignConsideration> value ) {
		this.__detail_out_design_considerations = value;
	}

	public BaseOutDesignConsideration toBase(){
		BaseOutDesignConsideration base = new BaseOutDesignConsideration();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseOutDesignConsideration base){
		base.cloneCopy(this);
	}

	public static List<BaseOutDesignConsideration> getBaseList(List<BaseOutDesignConsiderationWithO> beans) {
		List<BaseOutDesignConsideration> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseOutDesignConsiderationWithO bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseOutDesignConsiderationWithO> getBeanList(List<BaseOutDesignConsideration> beans) {
		List<BaseOutDesignConsiderationWithO> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseOutDesignConsideration bean : beans) {
			BaseOutDesignConsiderationWithO val = new BaseOutDesignConsiderationWithO();
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
		count = sb.length(); sb.append(__wrapList(count, "detailOutDesignConsideration", getDetailOutDesignConsideration()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailOutDesignConsideration")) != null) setDetailOutDesignConsideration(__getList(val, BaseOutDesignConsideration.newInstance()));
	}

	protected List<BaseOutDesignConsideration> __detail_out_design_considerations ; 
}
