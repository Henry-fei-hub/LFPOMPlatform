package pomplatform.workflow.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseTravelReimbursement;
import com.pomplatform.db.bean.BaseTravelReimbursementDetail;
import com.pomplatform.db.bean.BaseTravelReimbursementLinkMainProject;

public class BaseTravelReimbursementWithTt extends BaseTravelReimbursement 
{

	public static BaseTravelReimbursementWithTt newInstance(){
		return new BaseTravelReimbursementWithTt();
	}

	@Override
	public BaseTravelReimbursementWithTt make(){
		BaseTravelReimbursementWithTt b = new BaseTravelReimbursementWithTt();
		return b;
	}

	public List<BaseTravelReimbursementDetail> getDetailTravelReimbursementDetail() {
		return this.__detail_travel_reimbursement_details;
	}

	public void setDetailTravelReimbursementDetail( List<BaseTravelReimbursementDetail> value ) {
		this.__detail_travel_reimbursement_details = value;
	}

	public List<BaseTravelReimbursementLinkMainProject> getDetailTravelReimbursementLinkMainProject() {
		return this.__detail_travel_reimbursement_link_main_projects;
	}

	public void setDetailTravelReimbursementLinkMainProject( List<BaseTravelReimbursementLinkMainProject> value ) {
		this.__detail_travel_reimbursement_link_main_projects = value;
	}

	public BaseTravelReimbursement toBase(){
		BaseTravelReimbursement base = new BaseTravelReimbursement();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseTravelReimbursement base){
		base.cloneCopy(this);
	}

	public static List<BaseTravelReimbursement> getBaseList(List<BaseTravelReimbursementWithTt> beans) {
		List<BaseTravelReimbursement> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseTravelReimbursementWithTt bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseTravelReimbursementWithTt> getBeanList(List<BaseTravelReimbursement> beans) {
		List<BaseTravelReimbursementWithTt> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseTravelReimbursement bean : beans) {
			BaseTravelReimbursementWithTt val = new BaseTravelReimbursementWithTt();
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
		count = sb.length(); sb.append(__wrapList(count, "detailTravelReimbursementLinkMainProject", getDetailTravelReimbursementLinkMainProject()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailTravelReimbursementDetail")) != null) setDetailTravelReimbursementDetail(__getList(val, BaseTravelReimbursementDetail.newInstance()));
		if((val = values.get("detailTravelReimbursementLinkMainProject")) != null) setDetailTravelReimbursementLinkMainProject(__getList(val, BaseTravelReimbursementLinkMainProject.newInstance()));
	}

	protected List<BaseTravelReimbursementDetail> __detail_travel_reimbursement_details ; 
	protected List<BaseTravelReimbursementLinkMainProject> __detail_travel_reimbursement_link_main_projects ; 
}
