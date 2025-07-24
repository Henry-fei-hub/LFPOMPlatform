package pomplatform.client.workflow.specialDeduction.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseSpecialDeductionRecord;
import com.pomplatform.db.bean.BaseSpecialDeductionDetail;

public class BaseSpecialDeductionRecordWithS extends BaseSpecialDeductionRecord 
{

	public static BaseSpecialDeductionRecordWithS newInstance(){
		return new BaseSpecialDeductionRecordWithS();
	}

	@Override
	public BaseSpecialDeductionRecordWithS make(){
		BaseSpecialDeductionRecordWithS b = new BaseSpecialDeductionRecordWithS();
		return b;
	}

	public List<BaseSpecialDeductionDetail> getDetailSpecialDeductionDetail() {
		return this.__detail_special_deduction_details;
	}

	public void setDetailSpecialDeductionDetail( List<BaseSpecialDeductionDetail> value ) {
		this.__detail_special_deduction_details = value;
	}

	public BaseSpecialDeductionRecord toBase(){
		BaseSpecialDeductionRecord base = new BaseSpecialDeductionRecord();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseSpecialDeductionRecord base){
		base.cloneCopy(this);
	}

	public static List<BaseSpecialDeductionRecord> getBaseList(List<BaseSpecialDeductionRecordWithS> beans) {
		List<BaseSpecialDeductionRecord> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseSpecialDeductionRecordWithS bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseSpecialDeductionRecordWithS> getBeanList(List<BaseSpecialDeductionRecord> beans) {
		List<BaseSpecialDeductionRecordWithS> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseSpecialDeductionRecord bean : beans) {
			BaseSpecialDeductionRecordWithS val = new BaseSpecialDeductionRecordWithS();
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
		count = sb.length(); sb.append(__wrapList(count, "detailSpecialDeductionDetail", getDetailSpecialDeductionDetail()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailSpecialDeductionDetail")) != null) setDetailSpecialDeductionDetail(__getList(val, BaseSpecialDeductionDetail.newInstance()));
	}

	protected List<BaseSpecialDeductionDetail> __detail_special_deduction_details ; 
}
