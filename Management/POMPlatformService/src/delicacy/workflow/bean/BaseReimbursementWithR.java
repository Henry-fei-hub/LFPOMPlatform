package delicacy.workflow.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseReimbursementWithR extends BaseReimbursement 
{

	public static BaseReimbursementWithR newInstance(){
		return new BaseReimbursementWithR();
	}

	@Override
	public BaseReimbursementWithR make(){
		BaseReimbursementWithR b = new BaseReimbursementWithR();
		return b;
	}

	public List<BaseReimbursementDetail> getDetailReimbursementDetail() {
		return this.__detail_reimbursement_details;
	}

	public void setDetailReimbursementDetail( List<BaseReimbursementDetail> value ) {
		this.__detail_reimbursement_details = value;
	}

	public BaseReimbursement toBase(){
		BaseReimbursement base = new BaseReimbursement();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseReimbursement base){
		base.cloneCopy(this);
	}

	public static List<BaseReimbursement> getBaseList(List<BaseReimbursementWithR> beans) {
		List<BaseReimbursement> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseReimbursementWithR bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseReimbursementWithR> getBeanList(List<BaseReimbursement> beans) {
		List<BaseReimbursementWithR> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseReimbursement bean : beans) {
			BaseReimbursementWithR val = new BaseReimbursementWithR();
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
		count = sb.length(); sb.append(__wrapList(count, "detailReimbursementDetail", getDetailReimbursementDetail()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailReimbursementDetail")) != null) setDetailReimbursementDetail(__getList(val, BaseReimbursementDetail.newInstance()));
	}

	protected List<BaseReimbursementDetail> __detail_reimbursement_details ; 
}
