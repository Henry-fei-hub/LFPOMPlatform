package pomplatform.workflow.purchase.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseProductInquiryTotal;
import com.pomplatform.db.bean.BaseProductInquiryDetail;

public class BaseProductInquiryTotalWithP extends BaseProductInquiryTotal 
{

	public static BaseProductInquiryTotalWithP newInstance(){
		return new BaseProductInquiryTotalWithP();
	}

	@Override
	public BaseProductInquiryTotalWithP make(){
		BaseProductInquiryTotalWithP b = new BaseProductInquiryTotalWithP();
		return b;
	}

	public List<BaseProductInquiryDetail> getDetailProductInquiryDetail() {
		return this.__detail_product_inquiry_details;
	}

	public void setDetailProductInquiryDetail( List<BaseProductInquiryDetail> value ) {
		this.__detail_product_inquiry_details = value;
	}

	public BaseProductInquiryTotal toBase(){
		BaseProductInquiryTotal base = new BaseProductInquiryTotal();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseProductInquiryTotal base){
		base.cloneCopy(this);
	}

	public static List<BaseProductInquiryTotal> getBaseList(List<BaseProductInquiryTotalWithP> beans) {
		List<BaseProductInquiryTotal> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProductInquiryTotalWithP bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseProductInquiryTotalWithP> getBeanList(List<BaseProductInquiryTotal> beans) {
		List<BaseProductInquiryTotalWithP> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProductInquiryTotal bean : beans) {
			BaseProductInquiryTotalWithP val = new BaseProductInquiryTotalWithP();
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
		count = sb.length(); sb.append(__wrapList(count, "detailProductInquiryDetail", getDetailProductInquiryDetail()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailProductInquiryDetail")) != null) setDetailProductInquiryDetail(__getList(val, BaseProductInquiryDetail.newInstance()));
	}

	protected List<BaseProductInquiryDetail> __detail_product_inquiry_details ; 
}
