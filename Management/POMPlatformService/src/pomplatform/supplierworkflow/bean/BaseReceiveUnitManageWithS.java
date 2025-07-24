package pomplatform.supplierworkflow.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseReceiveUnitManage;
import com.pomplatform.db.bean.BaseSupplier;

public class BaseReceiveUnitManageWithS extends BaseReceiveUnitManage 
{

	public static BaseReceiveUnitManageWithS newInstance(){
		return new BaseReceiveUnitManageWithS();
	}

	@Override
	public BaseReceiveUnitManageWithS make(){
		BaseReceiveUnitManageWithS b = new BaseReceiveUnitManageWithS();
		return b;
	}

	public List<BaseSupplier> getDetailSupplier() {
		return this.__detail_supplier;
	}

	public void setDetailSupplier( List<BaseSupplier> value ) {
		this.__detail_supplier = value;
	}

	public BaseReceiveUnitManage toBase(){
		BaseReceiveUnitManage base = new BaseReceiveUnitManage();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseReceiveUnitManage base){
		base.cloneCopy(this);
	}

	public static List<BaseReceiveUnitManage> getBaseList(List<BaseReceiveUnitManageWithS> beans) {
		List<BaseReceiveUnitManage> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseReceiveUnitManageWithS bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseReceiveUnitManageWithS> getBeanList(List<BaseReceiveUnitManage> beans) {
		List<BaseReceiveUnitManageWithS> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseReceiveUnitManage bean : beans) {
			BaseReceiveUnitManageWithS val = new BaseReceiveUnitManageWithS();
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
		count = sb.length(); sb.append(__wrapList(count, "detailSupplier", getDetailSupplier()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailSupplier")) != null) setDetailSupplier(__getList(val, BaseSupplier.newInstance()));
	}

	protected List<BaseSupplier> __detail_supplier ; 
}
