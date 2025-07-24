package pomplatform.orderplacement.bean;

import com.pomplatform.db.bean.BaseOrderInfo;
import com.pomplatform.db.bean.BaseOrderInfoChild;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class BaseOrderInfoWithO extends BaseOrderInfo 
{

	public static BaseOrderInfoWithO newInstance(){
		return new BaseOrderInfoWithO();
	}

	@Override
	public BaseOrderInfoWithO make(){
		BaseOrderInfoWithO b = new BaseOrderInfoWithO();
		return b;
	}

	public List<BaseOrderInfoChild> getDetailOrderInfoChild() {
		return this.__detail_order_info_child;
	}

	public void setDetailOrderInfoChild( List<BaseOrderInfoChild> value ) {
		this.__detail_order_info_child = value;
	}

	public BaseOrderInfo toBase(){
		BaseOrderInfo base = new BaseOrderInfo();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseOrderInfo base){
		base.cloneCopy(this);
	}

	public static List<BaseOrderInfo> getBaseList(List<BaseOrderInfoWithO> beans) {
		List<BaseOrderInfo> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseOrderInfoWithO bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseOrderInfoWithO> getBeanList(List<BaseOrderInfo> beans) {
		List<BaseOrderInfoWithO> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseOrderInfo bean : beans) {
			BaseOrderInfoWithO val = new BaseOrderInfoWithO();
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
		count = sb.length(); sb.append(__wrapList(count, "detailOrderInfoChild", getDetailOrderInfoChild()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailOrderInfoChild")) != null) setDetailOrderInfoChild(__getList(val, BaseOrderInfoChild.newInstance()));
	}

	protected List<BaseOrderInfoChild> __detail_order_info_child ; 
}
