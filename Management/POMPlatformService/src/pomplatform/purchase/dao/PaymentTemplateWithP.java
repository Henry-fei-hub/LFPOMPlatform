package pomplatform.purchase.dao;

import java.util.*;
import pomplatform.purchase.bean.BasePaymentTemplateWithP;
import com.pomplatform.db.bean.BasePaymentTemplateDetail;
import com.pomplatform.db.dao.PaymentTemplateDetail;

public class PaymentTemplateWithP extends com.pomplatform.db.dao.PaymentTemplate
{


	public PaymentTemplateWithP() throws java.sql.SQLException { initColumnNames(); }

	public List<BasePaymentTemplateDetail> getDetailPaymentTemplateDetail() {
		return this.__detail_paymenttemplatedetail;
	}

	public void setDetailPaymentTemplateDetail( List<BasePaymentTemplateDetail> value ) {
		this.__detail_paymenttemplatedetail = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate 付款模板详情表 DAO
		PaymentTemplateDetail paymenttemplatedetail = new PaymentTemplateDetail();
		// load the original details.
		paymenttemplatedetail.setConditionPaymentTemplateId("=", getPaymentTemplateId());
		List<BasePaymentTemplateDetail> originalpaymenttemplatedetail = paymenttemplatedetail.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailPaymentTemplateDetail() != null) {
			// need to delete list.
			List<BasePaymentTemplateDetail> needToDeletePaymentTemplateDetail = new ArrayList<>();
			// need to add list.
			List<BasePaymentTemplateDetail> needToAddPaymentTemplateDetail = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BasePaymentTemplateDetail __paymenttemplatedetail : getDetailPaymentTemplateDetail() ) {
				// set the relative field.
				__paymenttemplatedetail.setPaymentTemplateId( getPaymentTemplateId());
				// set find flag
				boolean foundPaymentTemplateDetail = false;
				// find the original list.
				for(BasePaymentTemplateDetail __originalpaymenttemplatedetail : originalpaymenttemplatedetail) {
					// if found the original record
					if(__paymenttemplatedetail.compareTo(__originalpaymenttemplatedetail) == 0) {
						// set found flag to true
						foundPaymentTemplateDetail = true;
						// update the record.
						// clear DAO's data
						paymenttemplatedetail.clearCurrentData();
						// set original data into DAO
						paymenttemplatedetail.setDataFromBase(__originalpaymenttemplatedetail);
						// clear DAO modification flag, just like the is loaded from DB
						paymenttemplatedetail.clearModifiedFlags();
						// set current data into DAO
						paymenttemplatedetail.setDataFromBase(__paymenttemplatedetail);
						// execute update
						paymenttemplatedetail.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundPaymentTemplateDetail) needToAddPaymentTemplateDetail.add(__paymenttemplatedetail);
			}
			// find the records that exists in the original list and not in the current list.
			for(BasePaymentTemplateDetail __originalpaymenttemplatedetail : originalpaymenttemplatedetail) {
				boolean foundPaymentTemplateDetail = false;
				for(BasePaymentTemplateDetail __paymenttemplatedetail : getDetailPaymentTemplateDetail() ) {
					if(__paymenttemplatedetail.compareTo(__originalpaymenttemplatedetail) == 0) {
						foundPaymentTemplateDetail = true;
						break;
				}
				}
				if(!foundPaymentTemplateDetail) needToDeletePaymentTemplateDetail.add(__originalpaymenttemplatedetail);
			}
			// process need-to-add list
			for(BasePaymentTemplateDetail __paymenttemplatedetail : needToAddPaymentTemplateDetail ) {
				paymenttemplatedetail.clearCurrentData();
				paymenttemplatedetail.setDataFromBase(__paymenttemplatedetail);
				paymenttemplatedetail.save();
				__paymenttemplatedetail.setPaymentTemplateDetailId(paymenttemplatedetail.getPaymentTemplateDetailId());
			}
			// process need-to-delete list
			for(BasePaymentTemplateDetail __paymenttemplatedetail : needToDeletePaymentTemplateDetail ) {
				deleteFromPaymentTemplateDetail(__paymenttemplatedetail, paymenttemplatedetail);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BasePaymentTemplateDetail __paymenttemplatedetail : originalpaymenttemplatedetail ) {
				deleteFromPaymentTemplateDetail(__paymenttemplatedetail, paymenttemplatedetail);
			}
		}
	}

	private void deleteFromPaymentTemplateDetail(BasePaymentTemplateDetail bean, PaymentTemplateDetail dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setPaymentTemplateId(null);
		if(__detail_delete_paymenttemplatedetail) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		PaymentTemplateDetail paymenttemplatedetail = new PaymentTemplateDetail();
		paymenttemplatedetail.setConditionPaymentTemplateId("=", getPaymentTemplateId());
		paymenttemplatedetail.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			PaymentTemplateDetail paymenttemplatedetail = new PaymentTemplateDetail();
			paymenttemplatedetail.setConditionPaymentTemplateId("=", getPaymentTemplateId());
			setDetailPaymentTemplateDetail(paymenttemplatedetail.conditionalLoad());
		}
		return true;
	}

	public List<BasePaymentTemplateWithP> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BasePaymentTemplateWithP> result = BasePaymentTemplateWithP.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BasePaymentTemplateWithP generateBaseExt() {
		BasePaymentTemplateWithP ____result = new BasePaymentTemplateWithP();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BasePaymentTemplateWithP __base) {
		super.setDataFromBase(__base);
		setDetailPaymentTemplateDetail(__base.getDetailPaymentTemplateDetail());
	}

	public void setDataToBase(BasePaymentTemplateWithP __base) {
		super.setDataToBase(__base);
		__base.setDetailPaymentTemplateDetail(getDetailPaymentTemplateDetail());
	}

	@Override
	public int save() throws java.sql.SQLException {

		if(super.save() == 0) return 0;
		deleteAndSaveDetailTables();
		return 1;
	}

	@Override
	public int update() throws java.sql.SQLException {

		super.update();
		deleteAndSaveDetailTables();
		return 1;
	}

	@Override
	public int conditionalUpdate() throws java.sql.SQLException {

		super.conditionalUpdate();
		deleteAndSaveDetailTables();
		return 1;
	}

	@Override
	public int delete() throws java.sql.SQLException {
		super.delete();
		deleteDetailTables();
		return 1;
	}

	@Override
	public int conditionalDelete() throws java.sql.SQLException {
		super.conditionalDelete();
		deleteDetailTables();
		return 1;
	}

	public boolean isDeleteDetailPaymentTemplateDetail() {
		return this.__detail_delete_paymenttemplatedetail;
	}

	public void setDeleteDetailPaymentTemplateDetail( boolean value ) {
		this.__detail_delete_paymenttemplatedetail = value;
	}

	protected boolean __detail_delete_paymenttemplatedetail = true; 
	protected List<BasePaymentTemplateDetail> __detail_paymenttemplatedetail ; 
}
