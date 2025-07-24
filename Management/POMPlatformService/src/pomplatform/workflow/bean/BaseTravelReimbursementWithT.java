package pomplatform.workflow.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseTravelReimbursement;
import com.pomplatform.db.bean.BaseTravelReimbursementDetail;

public class BaseTravelReimbursementWithT extends BaseTravelReimbursement 
{

	public static BaseTravelReimbursementWithT newInstance(){
		return new BaseTravelReimbursementWithT();
	}

	@Override
	public BaseTravelReimbursementWithT make(){
		BaseTravelReimbursementWithT b = new BaseTravelReimbursementWithT();
		return b;
	}

	public List<BaseTravelReimbursementDetail> getDetailTravelReimbursementDetail() {
		return this.__detail_travel_reimbursement_details;
	}

	public void setDetailTravelReimbursementDetail( List<BaseTravelReimbursementDetail> value ) {
		this.__detail_travel_reimbursement_details = value;
	}

	public BaseTravelReimbursement toBase(){
		BaseTravelReimbursement base = new BaseTravelReimbursement();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseTravelReimbursement base){
		base.cloneCopy(this);
	}

	public static List<BaseTravelReimbursement> getBaseList(List<BaseTravelReimbursementWithT> beans) {
		List<BaseTravelReimbursement> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseTravelReimbursementWithT bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseTravelReimbursementWithT> getBeanList(List<BaseTravelReimbursement> beans) {
		List<BaseTravelReimbursementWithT> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseTravelReimbursement bean : beans) {
			BaseTravelReimbursementWithT val = new BaseTravelReimbursementWithT();
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
		count = sb.length(); sb.append(__wrapList(count, "detailTravelReimbursementDetail", getDetailTravelReimbursementDetail()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailTravelReimbursementDetail")) != null) setDetailTravelReimbursementDetail(__getList(val, BaseTravelReimbursementDetail.newInstance()));
	}

	protected List<BaseTravelReimbursementDetail> __detail_travel_reimbursement_details ; 
}
