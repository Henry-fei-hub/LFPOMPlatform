package pomplatform.meeting.bean;

import com.pomplatform.db.bean.BaseConfree;
import com.pomplatform.db.bean.BaseMeeting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseMeetingWithConfree extends BaseMeeting
{

	public static BaseMeetingWithConfree newInstance(){
		return new BaseMeetingWithConfree();
	}

	@Override
	public BaseMeetingWithConfree make(){
		BaseMeetingWithConfree b = new BaseMeetingWithConfree();
		return b;
	}

	public List<BaseConfree> getDetailConfree() {
		return this.__detail_confrees;
	}

	public void setDetailConfree( List<BaseConfree> value ) {
		this.__detail_confrees = value;
	}

	public BaseMeeting toBase(){
		BaseMeeting base = new BaseMeeting();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseMeeting base){
		base.cloneCopy(this);
	}

	public static List<BaseMeeting> getBaseList(List<BaseMeetingWithConfree> beans) {
		List<BaseMeeting> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseMeetingWithConfree bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseMeetingWithConfree> getBeanList(List<BaseMeeting> beans) {
		List<BaseMeetingWithConfree> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseMeeting bean : beans) {
			BaseMeetingWithConfree val = new BaseMeetingWithConfree();
			val.getDataFromBase(bean);
			result.add(val);
		}
		return result;
	}

	@Override
	public String toJSONString() {

		int count = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		count = sb.length(); sb.append(__wrapList(count, "detailConfree", getDetailConfree()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailConfree")) != null) setDetailConfree(__getList(val, BaseConfree.newInstance()));
	}

	protected List<BaseConfree> __detail_confrees ;
}
