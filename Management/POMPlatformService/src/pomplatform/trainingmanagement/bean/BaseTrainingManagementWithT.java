package pomplatform.trainingmanagement.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseTrainingManagement;
import com.pomplatform.db.bean.BaseTrainingManagementDetail;

public class BaseTrainingManagementWithT extends BaseTrainingManagement 
{

	public static BaseTrainingManagementWithT newInstance(){
		return new BaseTrainingManagementWithT();
	}

	@Override
	public BaseTrainingManagementWithT make(){
		BaseTrainingManagementWithT b = new BaseTrainingManagementWithT();
		return b;
	}

	public List<BaseTrainingManagementDetail> getDetailTrainingManagementDetail() {
		return this.__detail_training_management_details;
	}

	public void setDetailTrainingManagementDetail( List<BaseTrainingManagementDetail> value ) {
		this.__detail_training_management_details = value;
	}

	public BaseTrainingManagement toBase(){
		BaseTrainingManagement base = new BaseTrainingManagement();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseTrainingManagement base){
		base.cloneCopy(this);
	}

	public static List<BaseTrainingManagement> getBaseList(List<BaseTrainingManagementWithT> beans) {
		List<BaseTrainingManagement> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseTrainingManagementWithT bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseTrainingManagementWithT> getBeanList(List<BaseTrainingManagement> beans) {
		List<BaseTrainingManagementWithT> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseTrainingManagement bean : beans) {
			BaseTrainingManagementWithT val = new BaseTrainingManagementWithT();
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
		count = sb.length(); sb.append(__wrapList(count, "detailTrainingManagementDetail", getDetailTrainingManagementDetail()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailTrainingManagementDetail")) != null) setDetailTrainingManagementDetail(__getList(val, BaseTrainingManagementDetail.newInstance()));
	}

	protected List<BaseTrainingManagementDetail> __detail_training_management_details ; 
}
