package pomplatform.purchase.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BasePurchaseContract;
import com.pomplatform.db.bean.BasePurchasePayment;
import com.pomplatform.db.bean.BasePurchaseProductDetail;

public class BasePurchaseContractWithPp extends BasePurchaseContract 
{

	public static BasePurchaseContractWithPp newInstance(){
		return new BasePurchaseContractWithPp();
	}

	@Override
	public BasePurchaseContractWithPp make(){
		BasePurchaseContractWithPp b = new BasePurchaseContractWithPp();
		return b;
	}

	public List<BasePurchasePayment> getDetailPurchasePayment() {
		return this.__detail_purchase_payments;
	}

	public void setDetailPurchasePayment( List<BasePurchasePayment> value ) {
		this.__detail_purchase_payments = value;
	}

	public List<BasePurchaseProductDetail> getDetailPurchaseProductDetail() {
		return this.__detail_purchase_product_details;
	}

	public void setDetailPurchaseProductDetail( List<BasePurchaseProductDetail> value ) {
		this.__detail_purchase_product_details = value;
	}

	public BasePurchaseContract toBase(){
		BasePurchaseContract base = new BasePurchaseContract();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BasePurchaseContract base){
		base.cloneCopy(this);
	}

	public static List<BasePurchaseContract> getBaseList(List<BasePurchaseContractWithPp> beans) {
		List<BasePurchaseContract> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BasePurchaseContractWithPp bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BasePurchaseContractWithPp> getBeanList(List<BasePurchaseContract> beans) {
		List<BasePurchaseContractWithPp> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BasePurchaseContract bean : beans) {
			BasePurchaseContractWithPp val = new BasePurchaseContractWithPp();
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
		count = sb.length(); sb.append(__wrapList(count, "detailPurchasePayment", getDetailPurchasePayment()));
		count = sb.length(); sb.append(__wrapList(count, "detailPurchaseProductDetail", getDetailPurchaseProductDetail()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailPurchasePayment")) != null) setDetailPurchasePayment(__getList(val, BasePurchasePayment.newInstance()));
		if((val = values.get("detailPurchaseProductDetail")) != null) setDetailPurchaseProductDetail(__getList(val, BasePurchaseProductDetail.newInstance()));
	}

	protected List<BasePurchasePayment> __detail_purchase_payments ; 
	protected List<BasePurchaseProductDetail> __detail_purchase_product_details ; 
}
