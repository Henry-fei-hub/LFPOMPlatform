package pomplatform.purchase.dao;

import java.util.*;
import pomplatform.purchase.bean.BasePurchaseContractWithPp;
import com.pomplatform.db.bean.BasePurchasePayment;
import com.pomplatform.db.dao.PurchasePayment;
import com.pomplatform.db.bean.BasePurchaseProductDetail;
import com.pomplatform.db.dao.PurchaseProductDetail;

public class PurchaseContractWithPp extends com.pomplatform.db.dao.PurchaseContract
{


	public PurchaseContractWithPp() throws java.sql.SQLException { initColumnNames(); }

	public List<BasePurchasePayment> getDetailPurchasePayment() {
		return this.__detail_purchasepayment;
	}

	public void setDetailPurchasePayment( List<BasePurchasePayment> value ) {
		this.__detail_purchasepayment = value;
	}

	public List<BasePurchaseProductDetail> getDetailPurchaseProductDetail() {
		return this.__detail_purchaseproductdetail;
	}

	public void setDetailPurchaseProductDetail( List<BasePurchaseProductDetail> value ) {
		this.__detail_purchaseproductdetail = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate  DAO
		PurchasePayment purchasepayment = new PurchasePayment();
		// load the original details.
		purchasepayment.setConditionPurchaseContractId("=", getPurchaseContractId());
		List<BasePurchasePayment> originalpurchasepayment = purchasepayment.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailPurchasePayment() != null) {
			// need to delete list.
			List<BasePurchasePayment> needToDeletePurchasePayment = new ArrayList<>();
			// need to add list.
			List<BasePurchasePayment> needToAddPurchasePayment = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BasePurchasePayment __purchasepayment : getDetailPurchasePayment() ) {
				// set the relative field.
				__purchasepayment.setPurchaseContractId( getPurchaseContractId());
				// set find flag
				boolean foundPurchasePayment = false;
				// find the original list.
				for(BasePurchasePayment __originalpurchasepayment : originalpurchasepayment) {
					// if found the original record
					if(__purchasepayment.compareTo(__originalpurchasepayment) == 0) {
						// set found flag to true
						foundPurchasePayment = true;
						// update the record.
						// clear DAO's data
						purchasepayment.clearCurrentData();
						// set original data into DAO
						purchasepayment.setDataFromBase(__originalpurchasepayment);
						// clear DAO modification flag, just like the is loaded from DB
						purchasepayment.clearModifiedFlags();
						// set current data into DAO
						purchasepayment.setDataFromBase(__purchasepayment);
						// execute update
						purchasepayment.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundPurchasePayment) needToAddPurchasePayment.add(__purchasepayment);
			}
			// find the records that exists in the original list and not in the current list.
			for(BasePurchasePayment __originalpurchasepayment : originalpurchasepayment) {
				boolean foundPurchasePayment = false;
				for(BasePurchasePayment __purchasepayment : getDetailPurchasePayment() ) {
					if(__purchasepayment.compareTo(__originalpurchasepayment) == 0) {
						foundPurchasePayment = true;
						break;
				}
				}
				if(!foundPurchasePayment) needToDeletePurchasePayment.add(__originalpurchasepayment);
			}
			// process need-to-add list
			for(BasePurchasePayment __purchasepayment : needToAddPurchasePayment ) {
				purchasepayment.clearCurrentData();
				purchasepayment.setDataFromBase(__purchasepayment);
				purchasepayment.save();
				__purchasepayment.setPurchasePaymentId(purchasepayment.getPurchasePaymentId());
			}
			// process need-to-delete list
			for(BasePurchasePayment __purchasepayment : needToDeletePurchasePayment ) {
				deleteFromPurchasePayment(__purchasepayment, purchasepayment);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BasePurchasePayment __purchasepayment : originalpurchasepayment ) {
				deleteFromPurchasePayment(__purchasepayment, purchasepayment);
			}
		}
		// instantiate 采购申请产品详情表 DAO
		PurchaseProductDetail purchaseproductdetail = new PurchaseProductDetail();
		// load the original details.
		purchaseproductdetail.setConditionPurchaseContractId("=", getPurchaseContractId());
		List<BasePurchaseProductDetail> originalpurchaseproductdetail = purchaseproductdetail.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailPurchaseProductDetail() != null) {
			// need to delete list.
			List<BasePurchaseProductDetail> needToDeletePurchaseProductDetail = new ArrayList<>();
			// need to add list.
			List<BasePurchaseProductDetail> needToAddPurchaseProductDetail = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BasePurchaseProductDetail __purchaseproductdetail : getDetailPurchaseProductDetail() ) {
				// set the relative field.
				__purchaseproductdetail.setPurchaseContractId( getPurchaseContractId());
				// set find flag
				boolean foundPurchaseProductDetail = false;
				// find the original list.
				for(BasePurchaseProductDetail __originalpurchaseproductdetail : originalpurchaseproductdetail) {
					// if found the original record
					if(__purchaseproductdetail.compareTo(__originalpurchaseproductdetail) == 0) {
						// set found flag to true
						foundPurchaseProductDetail = true;
						// update the record.
						// clear DAO's data
						purchaseproductdetail.clearCurrentData();
						// set original data into DAO
						purchaseproductdetail.setDataFromBase(__originalpurchaseproductdetail);
						// clear DAO modification flag, just like the is loaded from DB
						purchaseproductdetail.clearModifiedFlags();
						// set current data into DAO
						purchaseproductdetail.setDataFromBase(__purchaseproductdetail);
						// execute update
						purchaseproductdetail.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundPurchaseProductDetail) needToAddPurchaseProductDetail.add(__purchaseproductdetail);
			}
			// find the records that exists in the original list and not in the current list.
			for(BasePurchaseProductDetail __originalpurchaseproductdetail : originalpurchaseproductdetail) {
				boolean foundPurchaseProductDetail = false;
				for(BasePurchaseProductDetail __purchaseproductdetail : getDetailPurchaseProductDetail() ) {
					if(__purchaseproductdetail.compareTo(__originalpurchaseproductdetail) == 0) {
						foundPurchaseProductDetail = true;
						break;
				}
				}
				if(!foundPurchaseProductDetail) needToDeletePurchaseProductDetail.add(__originalpurchaseproductdetail);
			}
			// process need-to-add list
			for(BasePurchaseProductDetail __purchaseproductdetail : needToAddPurchaseProductDetail ) {
				purchaseproductdetail.clearCurrentData();
				purchaseproductdetail.setDataFromBase(__purchaseproductdetail);
				purchaseproductdetail.save();
				__purchaseproductdetail.setPurchaseProductDetailId(purchaseproductdetail.getPurchaseProductDetailId());
			}
			// process need-to-delete list
			for(BasePurchaseProductDetail __purchaseproductdetail : needToDeletePurchaseProductDetail ) {
				deleteFromPurchaseProductDetail(__purchaseproductdetail, purchaseproductdetail);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BasePurchaseProductDetail __purchaseproductdetail : originalpurchaseproductdetail ) {
				deleteFromPurchaseProductDetail(__purchaseproductdetail, purchaseproductdetail);
			}
		}
	}

	private void deleteFromPurchasePayment(BasePurchasePayment bean, PurchasePayment dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setPurchaseContractId(null);
		if(__detail_delete_purchasepayment) dao.delete(); else dao.update();
	}

	private void deleteFromPurchaseProductDetail(BasePurchaseProductDetail bean, PurchaseProductDetail dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setPurchaseContractId(null);
		if(__detail_delete_purchaseproductdetail) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		PurchasePayment purchasepayment = new PurchasePayment();
		purchasepayment.setConditionPurchaseContractId("=", getPurchaseContractId());
		purchasepayment.conditionalDelete();
		PurchaseProductDetail purchaseproductdetail = new PurchaseProductDetail();
		purchaseproductdetail.setConditionPurchaseContractId("=", getPurchaseContractId());
		purchaseproductdetail.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			PurchasePayment purchasepayment = new PurchasePayment();
			purchasepayment.setConditionPurchaseContractId("=", getPurchaseContractId());
			setDetailPurchasePayment(purchasepayment.conditionalLoad());
			PurchaseProductDetail purchaseproductdetail = new PurchaseProductDetail();
			purchaseproductdetail.setConditionPurchaseContractId("=", getPurchaseContractId());
			setDetailPurchaseProductDetail(purchaseproductdetail.conditionalLoad());
		}
		return true;
	}

	public List<BasePurchaseContractWithPp> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BasePurchaseContractWithPp> result = BasePurchaseContractWithPp.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BasePurchaseContractWithPp generateBaseExt() {
		BasePurchaseContractWithPp ____result = new BasePurchaseContractWithPp();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BasePurchaseContractWithPp __base) {
		super.setDataFromBase(__base);
		setDetailPurchasePayment(__base.getDetailPurchasePayment());
		setDetailPurchaseProductDetail(__base.getDetailPurchaseProductDetail());
	}

	public void setDataToBase(BasePurchaseContractWithPp __base) {
		super.setDataToBase(__base);
		__base.setDetailPurchasePayment(getDetailPurchasePayment());
		__base.setDetailPurchaseProductDetail(getDetailPurchaseProductDetail());
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

	public boolean isDeleteDetailPurchasePayment() {
		return this.__detail_delete_purchasepayment;
	}

	public void setDeleteDetailPurchasePayment( boolean value ) {
		this.__detail_delete_purchasepayment = value;
	}

	protected boolean __detail_delete_purchasepayment = true; 
	protected List<BasePurchasePayment> __detail_purchasepayment ; 
	public boolean isDeleteDetailPurchaseProductDetail() {
		return this.__detail_delete_purchaseproductdetail;
	}

	public void setDeleteDetailPurchaseProductDetail( boolean value ) {
		this.__detail_delete_purchaseproductdetail = value;
	}

	protected boolean __detail_delete_purchaseproductdetail = true; 
	protected List<BasePurchaseProductDetail> __detail_purchaseproductdetail ; 
}
