package pomplatform.costallocation.dao;

import java.util.*;
import pomplatform.costallocation.bean.BaseResetCostWithC;
import com.pomplatform.db.bean.BaseCostAllocation;
import com.pomplatform.db.dao.CostAllocation;

public class ResetCostWithC extends com.pomplatform.db.dao.ResetCost
{


	public ResetCostWithC() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseCostAllocation> getDetailCostAllocation() {
		return this.__detail_costallocation;
	}

	public void setDetailCostAllocation( List<BaseCostAllocation> value ) {
		this.__detail_costallocation = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate  DAO
		CostAllocation costallocation = new CostAllocation();
		// load the original details.
		costallocation.setConditionResetCostId("=", getResetCostId());
		List<BaseCostAllocation> originalcostallocation = costallocation.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailCostAllocation() != null) {
			// need to delete list.
			List<BaseCostAllocation> needToDeleteCostAllocation = new ArrayList<>();
			// need to add list.
			List<BaseCostAllocation> needToAddCostAllocation = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseCostAllocation __costallocation : getDetailCostAllocation() ) {
				// set the relative field.
				__costallocation.setResetCostId( getResetCostId());
				// set find flag
				boolean foundCostAllocation = false;
				// find the original list.
				for(BaseCostAllocation __originalcostallocation : originalcostallocation) {
					// if found the original record
					if(__costallocation.compareTo(__originalcostallocation) == 0) {
						// set found flag to true
						foundCostAllocation = true;
						// update the record.
						// clear DAO's data
						costallocation.clearCurrentData();
						// set original data into DAO
						costallocation.setDataFromBase(__originalcostallocation);
						// clear DAO modification flag, just like the is loaded from DB
						costallocation.clearModifiedFlags();
						// set current data into DAO
						costallocation.setDataFromBase(__costallocation);
						// execute update
						costallocation.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundCostAllocation) needToAddCostAllocation.add(__costallocation);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseCostAllocation __originalcostallocation : originalcostallocation) {
				boolean foundCostAllocation = false;
				for(BaseCostAllocation __costallocation : getDetailCostAllocation() ) {
					if(__costallocation.compareTo(__originalcostallocation) == 0) {
						foundCostAllocation = true;
						break;
				}
				}
				if(!foundCostAllocation) needToDeleteCostAllocation.add(__originalcostallocation);
			}
			// process need-to-add list
			for(BaseCostAllocation __costallocation : needToAddCostAllocation ) {
				costallocation.setPrimaryKeyFromBase(__costallocation);
				// if the primay key is null, then insert into DB
				if(costallocation.isPrimaryKeyNull()) { costallocation.clearCurrentData(); costallocation.setDataFromBase(__costallocation); costallocation.save(); }
				// otherwise load and update
				else { if(costallocation.load()) { costallocation.setDataFromBase(__costallocation); costallocation.update(); } else { costallocation.clearCurrentData(); costallocation.setDataFromBase(__costallocation); costallocation.save(); } }
			}
			// process need-to-delete list
			for(BaseCostAllocation __costallocation : needToDeleteCostAllocation ) {
				deleteFromCostAllocation(__costallocation, costallocation);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseCostAllocation __costallocation : originalcostallocation ) {
				deleteFromCostAllocation(__costallocation, costallocation);
			}
		}
	}

	private void deleteFromCostAllocation(BaseCostAllocation bean, CostAllocation dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setResetCostId(null);
		if(__detail_delete_costallocation) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		CostAllocation costallocation = new CostAllocation();
		costallocation.setConditionResetCostId("=", getResetCostId());
		costallocation.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			CostAllocation costallocation = new CostAllocation();
			costallocation.setConditionResetCostId("=", getResetCostId());
			setDetailCostAllocation(costallocation.conditionalLoad());
		}
		return true;
	}

	public List<BaseResetCostWithC> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseResetCostWithC> result = BaseResetCostWithC.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseResetCostWithC generateBaseExt() {
		BaseResetCostWithC ____result = new BaseResetCostWithC();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseResetCostWithC __base) {
		super.setDataFromBase(__base);
		setDetailCostAllocation(__base.getDetailCostAllocation());
	}

	public void setDataToBase(BaseResetCostWithC __base) {
		super.setDataToBase(__base);
		__base.setDetailCostAllocation(getDetailCostAllocation());
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

	public boolean isDeleteDetailCostAllocation() {
		return this.__detail_delete_costallocation;
	}

	public void setDeleteDetailCostAllocation( boolean value ) {
		this.__detail_delete_costallocation = value;
	}

	protected boolean __detail_delete_costallocation = true; 
	protected List<BaseCostAllocation> __detail_costallocation ; 
}
