package pomplatform.supplierworkflow.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pomplatform.db.bean.BaseSupplier;
import com.pomplatform.db.bean.BaseSupplierCooperation;
import com.pomplatform.db.bean.BaseSupplierDetail;

public class BaseSupplierWithSs extends BaseSupplier 
{

	public static BaseSupplierWithSs newInstance(){
		return new BaseSupplierWithSs();
	}

	@Override
	public BaseSupplierWithSs make(){
		BaseSupplierWithSs b = new BaseSupplierWithSs();
		return b;
	}

	public List<BaseSupplierDetail> getDetailSupplierDetail() {
		return this.__detail_supplier_detail;
	}

	public void setDetailSupplierDetail( List<BaseSupplierDetail> value ) {
		this.__detail_supplier_detail = value;
	}

	public List<BaseSupplierCooperation> getDetailSupplierCooperation() {
		return this.__detail_supplier_cooperation;
	}

	public void setDetailSupplierCooperation( List<BaseSupplierCooperation> value ) {
		this.__detail_supplier_cooperation = value;
	}

	public BaseSupplier toBase(){
		BaseSupplier base = new BaseSupplier();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseSupplier base){
		base.cloneCopy(this);
	}

	public static List<BaseSupplier> getBaseList(List<BaseSupplierWithSs> beans) {
		List<BaseSupplier> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseSupplierWithSs bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseSupplierWithSs> getBeanList(List<BaseSupplier> beans) {
		List<BaseSupplierWithSs> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseSupplier bean : beans) {
			BaseSupplierWithSs val = new BaseSupplierWithSs();
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
		count = sb.length(); sb.append(__wrapList(count, "detailSupplierDetail", getDetailSupplierDetail()));
		count = sb.length(); sb.append(__wrapList(count, "detailSupplierCooperation", getDetailSupplierCooperation()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailSupplierDetail")) != null) setDetailSupplierDetail(__getList(val, BaseSupplierDetail.newInstance()));
		if((val = values.get("detailSupplierCooperation")) != null) setDetailSupplierCooperation(__getList(val, BaseSupplierCooperation.newInstance()));
	}

	protected List<BaseSupplierDetail> __detail_supplier_detail ; 
	protected List<BaseSupplierCooperation> __detail_supplier_cooperation ; 
}
