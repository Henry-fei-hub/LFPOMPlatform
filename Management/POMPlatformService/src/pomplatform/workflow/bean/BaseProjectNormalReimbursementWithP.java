package pomplatform.workflow.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseProjectNormalReimbursement;
import com.pomplatform.db.bean.BaseProjectNormalReimbursementDetail;

public class BaseProjectNormalReimbursementWithP extends BaseProjectNormalReimbursement 
{

	public static BaseProjectNormalReimbursementWithP newInstance(){
		return new BaseProjectNormalReimbursementWithP();
	}

	@Override
	public BaseProjectNormalReimbursementWithP make(){
		BaseProjectNormalReimbursementWithP b = new BaseProjectNormalReimbursementWithP();
		return b;
	}

	public List<BaseProjectNormalReimbursementDetail> getDetailProjectNormalReimbursementDetail() {
		return this.__detail_project_normal_reimbursement_details;
	}

	public void setDetailProjectNormalReimbursementDetail( List<BaseProjectNormalReimbursementDetail> value ) {
		this.__detail_project_normal_reimbursement_details = value;
	}

	public BaseProjectNormalReimbursement toBase(){
		BaseProjectNormalReimbursement base = new BaseProjectNormalReimbursement();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseProjectNormalReimbursement base){
		base.cloneCopy(this);
	}

	public static List<BaseProjectNormalReimbursement> getBaseList(List<BaseProjectNormalReimbursementWithP> beans) {
		List<BaseProjectNormalReimbursement> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProjectNormalReimbursementWithP bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseProjectNormalReimbursementWithP> getBeanList(List<BaseProjectNormalReimbursement> beans) {
		List<BaseProjectNormalReimbursementWithP> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProjectNormalReimbursement bean : beans) {
			BaseProjectNormalReimbursementWithP val = new BaseProjectNormalReimbursementWithP();
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
		count = sb.length(); sb.append(__wrapList(count, "detailProjectNormalReimbursementDetail", getDetailProjectNormalReimbursementDetail()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailProjectNormalReimbursementDetail")) != null) setDetailProjectNormalReimbursementDetail(__getList(val, BaseProjectNormalReimbursementDetail.newInstance()));
	}

	protected List<BaseProjectNormalReimbursementDetail> __detail_project_normal_reimbursement_details ; 
}
