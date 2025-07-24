package pomplatform.workflow.projectNormalReimbursement.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseProjectNormalReimbursement;
import com.pomplatform.db.bean.BaseProjectNormalReimbursementDetail;
import com.pomplatform.db.bean.BaseNormalReimbursementLinkProject;

public class BaseProjectNormalReimbursementWithPn extends BaseProjectNormalReimbursement 
{

	public static BaseProjectNormalReimbursementWithPn newInstance(){
		return new BaseProjectNormalReimbursementWithPn();
	}

	@Override
	public BaseProjectNormalReimbursementWithPn make(){
		BaseProjectNormalReimbursementWithPn b = new BaseProjectNormalReimbursementWithPn();
		return b;
	}

	public List<BaseProjectNormalReimbursementDetail> getDetailProjectNormalReimbursementDetail() {
		return this.__detail_project_normal_reimbursement_details;
	}

	public void setDetailProjectNormalReimbursementDetail( List<BaseProjectNormalReimbursementDetail> value ) {
		this.__detail_project_normal_reimbursement_details = value;
	}

	public List<BaseNormalReimbursementLinkProject> getDetailNormalReimbursementLinkProject() {
		return this.__detail_normal_reimbursement_link_projects;
	}

	public void setDetailNormalReimbursementLinkProject( List<BaseNormalReimbursementLinkProject> value ) {
		this.__detail_normal_reimbursement_link_projects = value;
	}

	public BaseProjectNormalReimbursement toBase(){
		BaseProjectNormalReimbursement base = new BaseProjectNormalReimbursement();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseProjectNormalReimbursement base){
		base.cloneCopy(this);
	}

	public static List<BaseProjectNormalReimbursement> getBaseList(List<BaseProjectNormalReimbursementWithPn> beans) {
		List<BaseProjectNormalReimbursement> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProjectNormalReimbursementWithPn bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseProjectNormalReimbursementWithPn> getBeanList(List<BaseProjectNormalReimbursement> beans) {
		List<BaseProjectNormalReimbursementWithPn> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProjectNormalReimbursement bean : beans) {
			BaseProjectNormalReimbursementWithPn val = new BaseProjectNormalReimbursementWithPn();
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
		count = sb.length(); sb.append(__wrapList(count, "detailNormalReimbursementLinkProject", getDetailNormalReimbursementLinkProject()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailProjectNormalReimbursementDetail")) != null) setDetailProjectNormalReimbursementDetail(__getList(val, BaseProjectNormalReimbursementDetail.newInstance()));
		if((val = values.get("detailNormalReimbursementLinkProject")) != null) setDetailNormalReimbursementLinkProject(__getList(val, BaseNormalReimbursementLinkProject.newInstance()));
	}

	protected List<BaseProjectNormalReimbursementDetail> __detail_project_normal_reimbursement_details ; 
	protected List<BaseNormalReimbursementLinkProject> __detail_normal_reimbursement_link_projects ; 
}
