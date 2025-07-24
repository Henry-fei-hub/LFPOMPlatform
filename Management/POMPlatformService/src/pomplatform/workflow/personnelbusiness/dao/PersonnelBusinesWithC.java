package pomplatform.workflow.personnelbusiness.dao;

import java.util.*;
import pomplatform.workflow.personnelbusiness.bean.BasePersonnelBusinesWithC;
import com.pomplatform.db.bean.BaseCarCostAllocation;
import com.pomplatform.db.dao.CarCostAllocation;

public class PersonnelBusinesWithC extends com.pomplatform.db.dao.PersonnelBusines
{


	public PersonnelBusinesWithC() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseCarCostAllocation> getDetailCarCostAllocation() {
		return this.__detail_carcostallocation;
	}

	public void setDetailCarCostAllocation( List<BaseCarCostAllocation> value ) {
		this.__detail_carcostallocation = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate  DAO
		CarCostAllocation carcostallocation = new CarCostAllocation();
		// load the original details.
		carcostallocation.setConditionPersonnelBusinessId("=", getPersonnelBusinessId());
		List<BaseCarCostAllocation> originalcarcostallocation = carcostallocation.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailCarCostAllocation() != null) {
			// need to delete list.
			List<BaseCarCostAllocation> needToDeleteCarCostAllocation = new ArrayList<>();
			// need to add list.
			List<BaseCarCostAllocation> needToAddCarCostAllocation = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseCarCostAllocation __carcostallocation : getDetailCarCostAllocation() ) {
				// set the relative field.
				__carcostallocation.setPersonnelBusinessId( getPersonnelBusinessId());
				// set find flag
				boolean foundCarCostAllocation = false;
				// find the original list.
				for(BaseCarCostAllocation __originalcarcostallocation : originalcarcostallocation) {
					// if found the original record
					if(__carcostallocation.compareTo(__originalcarcostallocation) == 0) {
						// set found flag to true
						foundCarCostAllocation = true;
						// update the record.
						// clear DAO's data
						carcostallocation.clearCurrentData();
						// set original data into DAO
						carcostallocation.setDataFromBase(__originalcarcostallocation);
						// clear DAO modification flag, just like the is loaded from DB
						carcostallocation.clearModifiedFlags();
						// set current data into DAO
						carcostallocation.setDataFromBase(__carcostallocation);
						// execute update
						carcostallocation.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundCarCostAllocation) needToAddCarCostAllocation.add(__carcostallocation);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseCarCostAllocation __originalcarcostallocation : originalcarcostallocation) {
				boolean foundCarCostAllocation = false;
				for(BaseCarCostAllocation __carcostallocation : getDetailCarCostAllocation() ) {
					if(__carcostallocation.compareTo(__originalcarcostallocation) == 0) {
						foundCarCostAllocation = true;
						break;
				}
				}
				if(!foundCarCostAllocation) needToDeleteCarCostAllocation.add(__originalcarcostallocation);
			}
			// process need-to-add list
			for(BaseCarCostAllocation __carcostallocation : needToAddCarCostAllocation ) {
				carcostallocation.setPrimaryKeyFromBase(__carcostallocation);
				// if the primay key is null, then insert into DB
				if(carcostallocation.isPrimaryKeyNull()) { carcostallocation.clearCurrentData(); carcostallocation.setDataFromBase(__carcostallocation); carcostallocation.save(); }
				// otherwise load and update
				else { if(carcostallocation.load()) { carcostallocation.setDataFromBase(__carcostallocation); carcostallocation.update(); } else { carcostallocation.clearCurrentData(); carcostallocation.setDataFromBase(__carcostallocation); carcostallocation.save(); } }
			}
			// process need-to-delete list
			for(BaseCarCostAllocation __carcostallocation : needToDeleteCarCostAllocation ) {
				deleteFromCarCostAllocation(__carcostallocation, carcostallocation);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseCarCostAllocation __carcostallocation : originalcarcostallocation ) {
				deleteFromCarCostAllocation(__carcostallocation, carcostallocation);
			}
		}
	}

	private void deleteFromCarCostAllocation(BaseCarCostAllocation bean, CarCostAllocation dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setPersonnelBusinessId(null);
		if(__detail_delete_carcostallocation) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		CarCostAllocation carcostallocation = new CarCostAllocation();
		carcostallocation.setConditionPersonnelBusinessId("=", getPersonnelBusinessId());
		carcostallocation.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			CarCostAllocation carcostallocation = new CarCostAllocation();
			carcostallocation.setConditionPersonnelBusinessId("=", getPersonnelBusinessId());
			setDetailCarCostAllocation(carcostallocation.conditionalLoad());
		}
		return true;
	}

	public List<BasePersonnelBusinesWithC> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BasePersonnelBusinesWithC> result = BasePersonnelBusinesWithC.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BasePersonnelBusinesWithC generateBaseExt() {
		BasePersonnelBusinesWithC ____result = new BasePersonnelBusinesWithC();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BasePersonnelBusinesWithC __base) {
		super.setDataFromBase(__base);
		setDetailCarCostAllocation(__base.getDetailCarCostAllocation());
	}

	public void setDataToBase(BasePersonnelBusinesWithC __base) {
		super.setDataToBase(__base);
		__base.setDetailCarCostAllocation(getDetailCarCostAllocation());
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

	public boolean isDeleteDetailCarCostAllocation() {
		return this.__detail_delete_carcostallocation;
	}

	public void setDeleteDetailCarCostAllocation( boolean value ) {
		this.__detail_delete_carcostallocation = value;
	}

	protected boolean __detail_delete_carcostallocation = true; 
	protected List<BaseCarCostAllocation> __detail_carcostallocation ; 
}
