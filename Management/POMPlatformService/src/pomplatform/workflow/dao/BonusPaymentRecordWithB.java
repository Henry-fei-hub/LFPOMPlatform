package pomplatform.workflow.dao;

import java.util.*;
import pomplatform.workflow.bean.BaseBonusPaymentRecordWithB;
import com.pomplatform.db.bean.BaseBonusPaymentDetail;
import com.pomplatform.db.dao.BonusPaymentDetail;

public class BonusPaymentRecordWithB extends com.pomplatform.db.dao.BonusPaymentRecord
{


	public BonusPaymentRecordWithB() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseBonusPaymentDetail> getDetailBonusPaymentDetail() {
		return this.__detail_bonuspaymentdetail;
	}

	public void setDetailBonusPaymentDetail( List<BaseBonusPaymentDetail> value ) {
		this.__detail_bonuspaymentdetail = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate  DAO
		BonusPaymentDetail bonuspaymentdetail = new BonusPaymentDetail();
		// load the original details.
		bonuspaymentdetail.setConditionBonusPaymentRecordId("=", getBonusPaymentRecordId());
		List<BaseBonusPaymentDetail> originalbonuspaymentdetail = bonuspaymentdetail.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailBonusPaymentDetail() != null) {
			// need to delete list.
			List<BaseBonusPaymentDetail> needToDeleteBonusPaymentDetail = new ArrayList<>();
			// need to add list.
			List<BaseBonusPaymentDetail> needToAddBonusPaymentDetail = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseBonusPaymentDetail __bonuspaymentdetail : getDetailBonusPaymentDetail() ) {
				// set the relative field.
				__bonuspaymentdetail.setBonusPaymentRecordId( getBonusPaymentRecordId());
				// set find flag
				boolean foundBonusPaymentDetail = false;
				// find the original list.
				for(BaseBonusPaymentDetail __originalbonuspaymentdetail : originalbonuspaymentdetail) {
					// if found the original record
					if(__bonuspaymentdetail.compareTo(__originalbonuspaymentdetail) == 0) {
						// set found flag to true
						foundBonusPaymentDetail = true;
						// update the record.
						// clear DAO's data
						bonuspaymentdetail.clearCurrentData();
						// set original data into DAO
						bonuspaymentdetail.setDataFromBase(__originalbonuspaymentdetail);
						// clear DAO modification flag, just like the is loaded from DB
						bonuspaymentdetail.clearModifiedFlags();
						// set current data into DAO
						bonuspaymentdetail.setDataFromBase(__bonuspaymentdetail);
						// execute update
						bonuspaymentdetail.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundBonusPaymentDetail) needToAddBonusPaymentDetail.add(__bonuspaymentdetail);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseBonusPaymentDetail __originalbonuspaymentdetail : originalbonuspaymentdetail) {
				boolean foundBonusPaymentDetail = false;
				for(BaseBonusPaymentDetail __bonuspaymentdetail : getDetailBonusPaymentDetail() ) {
					if(__bonuspaymentdetail.compareTo(__originalbonuspaymentdetail) == 0) {
						foundBonusPaymentDetail = true;
						break;
				}
				}
				if(!foundBonusPaymentDetail) needToDeleteBonusPaymentDetail.add(__originalbonuspaymentdetail);
			}
			// process need-to-add list
			for(BaseBonusPaymentDetail __bonuspaymentdetail : needToAddBonusPaymentDetail ) {
				bonuspaymentdetail.clearCurrentData();
				bonuspaymentdetail.setDataFromBase(__bonuspaymentdetail);
				bonuspaymentdetail.save();
				__bonuspaymentdetail.setBonusPaymentDetailId(bonuspaymentdetail.getBonusPaymentDetailId());
			}
			// process need-to-delete list
			for(BaseBonusPaymentDetail __bonuspaymentdetail : needToDeleteBonusPaymentDetail ) {
				deleteFromBonusPaymentDetail(__bonuspaymentdetail, bonuspaymentdetail);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseBonusPaymentDetail __bonuspaymentdetail : originalbonuspaymentdetail ) {
				deleteFromBonusPaymentDetail(__bonuspaymentdetail, bonuspaymentdetail);
			}
		}
	}

	private void deleteFromBonusPaymentDetail(BaseBonusPaymentDetail bean, BonusPaymentDetail dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setBonusPaymentRecordId(null);
		if(__detail_delete_bonuspaymentdetail) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		BonusPaymentDetail bonuspaymentdetail = new BonusPaymentDetail();
		bonuspaymentdetail.setConditionBonusPaymentRecordId("=", getBonusPaymentRecordId());
		bonuspaymentdetail.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			BonusPaymentDetail bonuspaymentdetail = new BonusPaymentDetail();
			bonuspaymentdetail.setConditionBonusPaymentRecordId("=", getBonusPaymentRecordId());
			setDetailBonusPaymentDetail(bonuspaymentdetail.conditionalLoad());
		}
		return true;
	}

	public List<BaseBonusPaymentRecordWithB> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseBonusPaymentRecordWithB> result = BaseBonusPaymentRecordWithB.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseBonusPaymentRecordWithB generateBaseExt() {
		BaseBonusPaymentRecordWithB ____result = new BaseBonusPaymentRecordWithB();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseBonusPaymentRecordWithB __base) {
		super.setDataFromBase(__base);
		setDetailBonusPaymentDetail(__base.getDetailBonusPaymentDetail());
	}

	public void setDataToBase(BaseBonusPaymentRecordWithB __base) {
		super.setDataToBase(__base);
		__base.setDetailBonusPaymentDetail(getDetailBonusPaymentDetail());
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

	public boolean isDeleteDetailBonusPaymentDetail() {
		return this.__detail_delete_bonuspaymentdetail;
	}

	public void setDeleteDetailBonusPaymentDetail( boolean value ) {
		this.__detail_delete_bonuspaymentdetail = value;
	}

	protected boolean __detail_delete_bonuspaymentdetail = true; 
	protected List<BaseBonusPaymentDetail> __detail_bonuspaymentdetail ; 
}
