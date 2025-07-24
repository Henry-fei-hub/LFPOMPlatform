package pomplatform.client.workflow.specialDeduction.dao;

import java.util.*;
import pomplatform.client.workflow.specialDeduction.bean.BaseSpecialDeductionRecordWithS;
import com.pomplatform.db.bean.BaseSpecialDeductionDetail;
import com.pomplatform.db.dao.SpecialDeductionDetail;

public class SpecialDeductionRecordWithS extends com.pomplatform.db.dao.SpecialDeductionRecord
{


	public SpecialDeductionRecordWithS() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseSpecialDeductionDetail> getDetailSpecialDeductionDetail() {
		return this.__detail_specialdeductiondetail;
	}

	public void setDetailSpecialDeductionDetail( List<BaseSpecialDeductionDetail> value ) {
		this.__detail_specialdeductiondetail = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate 确认函管理表 DAO
		SpecialDeductionDetail specialdeductiondetail = new SpecialDeductionDetail();
		// load the original details.
		specialdeductiondetail.setConditionParentId("=", getSpecialDeductionRecordId());
		List<BaseSpecialDeductionDetail> originalspecialdeductiondetail = specialdeductiondetail.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailSpecialDeductionDetail() != null) {
			// need to delete list.
			List<BaseSpecialDeductionDetail> needToDeleteSpecialDeductionDetail = new ArrayList<>();
			// need to add list.
			List<BaseSpecialDeductionDetail> needToAddSpecialDeductionDetail = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseSpecialDeductionDetail __specialdeductiondetail : getDetailSpecialDeductionDetail() ) {
				// set the relative field.
				__specialdeductiondetail.setParentId( getSpecialDeductionRecordId());
				// set find flag
				boolean foundSpecialDeductionDetail = false;
				// find the original list.
				for(BaseSpecialDeductionDetail __originalspecialdeductiondetail : originalspecialdeductiondetail) {
					// if found the original record
					if(__specialdeductiondetail.compareTo(__originalspecialdeductiondetail) == 0) {
						// set found flag to true
						foundSpecialDeductionDetail = true;
						// update the record.
						// clear DAO's data
						specialdeductiondetail.clearCurrentData();
						// set original data into DAO
						specialdeductiondetail.setDataFromBase(__originalspecialdeductiondetail);
						// clear DAO modification flag, just like the is loaded from DB
						specialdeductiondetail.clearModifiedFlags();
						// set current data into DAO
						specialdeductiondetail.setDataFromBase(__specialdeductiondetail);
						// execute update
						specialdeductiondetail.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundSpecialDeductionDetail) needToAddSpecialDeductionDetail.add(__specialdeductiondetail);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseSpecialDeductionDetail __originalspecialdeductiondetail : originalspecialdeductiondetail) {
				boolean foundSpecialDeductionDetail = false;
				for(BaseSpecialDeductionDetail __specialdeductiondetail : getDetailSpecialDeductionDetail() ) {
					if(__specialdeductiondetail.compareTo(__originalspecialdeductiondetail) == 0) {
						foundSpecialDeductionDetail = true;
						break;
				}
				}
				if(!foundSpecialDeductionDetail) needToDeleteSpecialDeductionDetail.add(__originalspecialdeductiondetail);
			}
			// process need-to-add list
			for(BaseSpecialDeductionDetail __specialdeductiondetail : needToAddSpecialDeductionDetail ) {
				specialdeductiondetail.clearCurrentData();
				specialdeductiondetail.setDataFromBase(__specialdeductiondetail);
				specialdeductiondetail.save();
				__specialdeductiondetail.setSpecialDeductionDetailId(specialdeductiondetail.getSpecialDeductionDetailId());
			}
			// process need-to-delete list
			for(BaseSpecialDeductionDetail __specialdeductiondetail : needToDeleteSpecialDeductionDetail ) {
				deleteFromSpecialDeductionDetail(__specialdeductiondetail, specialdeductiondetail);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseSpecialDeductionDetail __specialdeductiondetail : originalspecialdeductiondetail ) {
				deleteFromSpecialDeductionDetail(__specialdeductiondetail, specialdeductiondetail);
			}
		}
	}

	private void deleteFromSpecialDeductionDetail(BaseSpecialDeductionDetail bean, SpecialDeductionDetail dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setParentId(null);
		if(__detail_delete_specialdeductiondetail) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		SpecialDeductionDetail specialdeductiondetail = new SpecialDeductionDetail();
		specialdeductiondetail.setConditionParentId("=", getSpecialDeductionRecordId());
		specialdeductiondetail.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			SpecialDeductionDetail specialdeductiondetail = new SpecialDeductionDetail();
			specialdeductiondetail.setConditionParentId("=", getSpecialDeductionRecordId());
			setDetailSpecialDeductionDetail(specialdeductiondetail.conditionalLoad());
		}
		return true;
	}

	public List<BaseSpecialDeductionRecordWithS> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseSpecialDeductionRecordWithS> result = BaseSpecialDeductionRecordWithS.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseSpecialDeductionRecordWithS generateBaseExt() {
		BaseSpecialDeductionRecordWithS ____result = new BaseSpecialDeductionRecordWithS();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseSpecialDeductionRecordWithS __base) {
		super.setDataFromBase(__base);
		setDetailSpecialDeductionDetail(__base.getDetailSpecialDeductionDetail());
	}

	public void setDataToBase(BaseSpecialDeductionRecordWithS __base) {
		super.setDataToBase(__base);
		__base.setDetailSpecialDeductionDetail(getDetailSpecialDeductionDetail());
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

	public boolean isDeleteDetailSpecialDeductionDetail() {
		return this.__detail_delete_specialdeductiondetail;
	}

	public void setDeleteDetailSpecialDeductionDetail( boolean value ) {
		this.__detail_delete_specialdeductiondetail = value;
	}

	protected boolean __detail_delete_specialdeductiondetail = true; 
	protected List<BaseSpecialDeductionDetail> __detail_specialdeductiondetail ; 
}
