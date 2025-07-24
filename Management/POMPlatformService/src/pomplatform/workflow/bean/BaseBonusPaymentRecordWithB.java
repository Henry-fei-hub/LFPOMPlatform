package pomplatform.workflow.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseBonusPaymentRecord;
import com.pomplatform.db.bean.BaseBonusPaymentDetail;

public class BaseBonusPaymentRecordWithB extends BaseBonusPaymentRecord 
{

	public static BaseBonusPaymentRecordWithB newInstance(){
		return new BaseBonusPaymentRecordWithB();
	}

	@Override
	public BaseBonusPaymentRecordWithB make(){
		BaseBonusPaymentRecordWithB b = new BaseBonusPaymentRecordWithB();
		return b;
	}

	public List<BaseBonusPaymentDetail> getDetailBonusPaymentDetail() {
		return this.__detail_bonus_payment_details;
	}

	public void setDetailBonusPaymentDetail( List<BaseBonusPaymentDetail> value ) {
		this.__detail_bonus_payment_details = value;
	}

	public BaseBonusPaymentRecord toBase(){
		BaseBonusPaymentRecord base = new BaseBonusPaymentRecord();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseBonusPaymentRecord base){
		base.cloneCopy(this);
	}

	public static List<BaseBonusPaymentRecord> getBaseList(List<BaseBonusPaymentRecordWithB> beans) {
		List<BaseBonusPaymentRecord> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseBonusPaymentRecordWithB bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseBonusPaymentRecordWithB> getBeanList(List<BaseBonusPaymentRecord> beans) {
		List<BaseBonusPaymentRecordWithB> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseBonusPaymentRecord bean : beans) {
			BaseBonusPaymentRecordWithB val = new BaseBonusPaymentRecordWithB();
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
		count = sb.length(); sb.append(__wrapList(count, "detailBonusPaymentDetail", getDetailBonusPaymentDetail()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailBonusPaymentDetail")) != null) setDetailBonusPaymentDetail(__getList(val, BaseBonusPaymentDetail.newInstance()));
	}

	protected List<BaseBonusPaymentDetail> __detail_bonus_payment_details ; 
}
