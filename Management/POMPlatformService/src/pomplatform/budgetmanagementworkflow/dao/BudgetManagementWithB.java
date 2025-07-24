package pomplatform.budgetmanagementworkflow.dao;

import java.util.*;
import pomplatform.budgetmanagementworkflow.bean.BaseBudgetManagementWithB;
import com.pomplatform.db.bean.BaseBudgetManagementDetail;
import com.pomplatform.db.dao.BudgetManagementDetail;

public class BudgetManagementWithB extends com.pomplatform.db.dao.BudgetManagement
{


	public BudgetManagementWithB() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseBudgetManagementDetail> getDetailBudgetManagementDetail() {
		return this.__detail_budgetmanagementdetail;
	}

	public void setDetailBudgetManagementDetail( List<BaseBudgetManagementDetail> value ) {
		this.__detail_budgetmanagementdetail = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate  DAO
		BudgetManagementDetail budgetmanagementdetail = new BudgetManagementDetail();
		// load the original details.
		budgetmanagementdetail.setConditionBudgetManagementId("=", getBudgetManagementId());
		List<BaseBudgetManagementDetail> originalbudgetmanagementdetail = budgetmanagementdetail.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailBudgetManagementDetail() != null) {
			// need to delete list.
			List<BaseBudgetManagementDetail> needToDeleteBudgetManagementDetail = new ArrayList<>();
			// need to add list.
			List<BaseBudgetManagementDetail> needToAddBudgetManagementDetail = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseBudgetManagementDetail __budgetmanagementdetail : getDetailBudgetManagementDetail() ) {
				// set the relative field.
				__budgetmanagementdetail.setBudgetManagementId( getBudgetManagementId());
				// set find flag
				boolean foundBudgetManagementDetail = false;
				// find the original list.
				for(BaseBudgetManagementDetail __originalbudgetmanagementdetail : originalbudgetmanagementdetail) {
					// if found the original record
					if(__budgetmanagementdetail.compareTo(__originalbudgetmanagementdetail) == 0) {
						// set found flag to true
						foundBudgetManagementDetail = true;
						// update the record.
						// clear DAO's data
						budgetmanagementdetail.clearCurrentData();
						// set original data into DAO
						budgetmanagementdetail.setDataFromBase(__originalbudgetmanagementdetail);
						// clear DAO modification flag, just like the is loaded from DB
						budgetmanagementdetail.clearModifiedFlags();
						// set current data into DAO
						budgetmanagementdetail.setDataFromBase(__budgetmanagementdetail);
						// execute update
						budgetmanagementdetail.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundBudgetManagementDetail) needToAddBudgetManagementDetail.add(__budgetmanagementdetail);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseBudgetManagementDetail __originalbudgetmanagementdetail : originalbudgetmanagementdetail) {
				boolean foundBudgetManagementDetail = false;
				for(BaseBudgetManagementDetail __budgetmanagementdetail : getDetailBudgetManagementDetail() ) {
					if(__budgetmanagementdetail.compareTo(__originalbudgetmanagementdetail) == 0) {
						foundBudgetManagementDetail = true;
						break;
				}
				}
				if(!foundBudgetManagementDetail) needToDeleteBudgetManagementDetail.add(__originalbudgetmanagementdetail);
			}
			// process need-to-add list
			for(BaseBudgetManagementDetail __budgetmanagementdetail : needToAddBudgetManagementDetail ) {
				budgetmanagementdetail.clearCurrentData();
				budgetmanagementdetail.setDataFromBase(__budgetmanagementdetail);
				budgetmanagementdetail.save();
				__budgetmanagementdetail.setBudgetManagementDetailId(budgetmanagementdetail.getBudgetManagementDetailId());
			}
			// process need-to-delete list
			for(BaseBudgetManagementDetail __budgetmanagementdetail : needToDeleteBudgetManagementDetail ) {
				deleteFromBudgetManagementDetail(__budgetmanagementdetail, budgetmanagementdetail);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseBudgetManagementDetail __budgetmanagementdetail : originalbudgetmanagementdetail ) {
				deleteFromBudgetManagementDetail(__budgetmanagementdetail, budgetmanagementdetail);
			}
		}
	}

	private void deleteFromBudgetManagementDetail(BaseBudgetManagementDetail bean, BudgetManagementDetail dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setBudgetManagementId(null);
		if(__detail_delete_budgetmanagementdetail) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		BudgetManagementDetail budgetmanagementdetail = new BudgetManagementDetail();
		budgetmanagementdetail.setConditionBudgetManagementId("=", getBudgetManagementId());
		budgetmanagementdetail.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			BudgetManagementDetail budgetmanagementdetail = new BudgetManagementDetail();
			budgetmanagementdetail.setConditionBudgetManagementId("=", getBudgetManagementId());
			setDetailBudgetManagementDetail(budgetmanagementdetail.conditionalLoad());
		}
		return true;
	}

	public List<BaseBudgetManagementWithB> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseBudgetManagementWithB> result = BaseBudgetManagementWithB.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseBudgetManagementWithB generateBaseExt() {
		BaseBudgetManagementWithB ____result = new BaseBudgetManagementWithB();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseBudgetManagementWithB __base) {
		super.setDataFromBase(__base);
		setDetailBudgetManagementDetail(__base.getDetailBudgetManagementDetail());
	}

	public void setDataToBase(BaseBudgetManagementWithB __base) {
		super.setDataToBase(__base);
		__base.setDetailBudgetManagementDetail(getDetailBudgetManagementDetail());
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

	public boolean isDeleteDetailBudgetManagementDetail() {
		return this.__detail_delete_budgetmanagementdetail;
	}

	public void setDeleteDetailBudgetManagementDetail( boolean value ) {
		this.__detail_delete_budgetmanagementdetail = value;
	}

	protected boolean __detail_delete_budgetmanagementdetail = true; 
	protected List<BaseBudgetManagementDetail> __detail_budgetmanagementdetail ; 
}
