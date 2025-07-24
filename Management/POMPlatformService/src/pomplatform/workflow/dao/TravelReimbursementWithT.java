package pomplatform.workflow.dao;

import java.util.*;
import pomplatform.workflow.bean.BaseTravelReimbursementWithT;
import com.pomplatform.db.bean.BaseTravelReimbursementDetail;
import com.pomplatform.db.dao.TravelReimbursementDetail;

public class TravelReimbursementWithT extends com.pomplatform.db.dao.TravelReimbursement
{


	public TravelReimbursementWithT() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseTravelReimbursementDetail> getDetailTravelReimbursementDetail() {
		return this.__detail_travelreimbursementdetail;
	}

	public void setDetailTravelReimbursementDetail( List<BaseTravelReimbursementDetail> value ) {
		this.__detail_travelreimbursementdetail = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate  DAO
		TravelReimbursementDetail travelreimbursementdetail = new TravelReimbursementDetail();
		// load the original details.
		travelreimbursementdetail.setConditionTravelReimbursementId("=", getTravelReimbursementId());
		List<BaseTravelReimbursementDetail> originaltravelreimbursementdetail = travelreimbursementdetail.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailTravelReimbursementDetail() != null) {
			// need to delete list.
			List<BaseTravelReimbursementDetail> needToDeleteTravelReimbursementDetail = new ArrayList<>();
			// need to add list.
			List<BaseTravelReimbursementDetail> needToAddTravelReimbursementDetail = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseTravelReimbursementDetail __travelreimbursementdetail : getDetailTravelReimbursementDetail() ) {
				// set the relative field.
				__travelreimbursementdetail.setTravelReimbursementId( getTravelReimbursementId());
				// set find flag
				boolean foundTravelReimbursementDetail = false;
				// find the original list.
				for(BaseTravelReimbursementDetail __originaltravelreimbursementdetail : originaltravelreimbursementdetail) {
					// if found the original record
					if(__travelreimbursementdetail.compareTo(__originaltravelreimbursementdetail) == 0) {
						// set found flag to true
						foundTravelReimbursementDetail = true;
						// update the record.
						// clear DAO's data
						travelreimbursementdetail.clearCurrentData();
						// set original data into DAO
						travelreimbursementdetail.setDataFromBase(__originaltravelreimbursementdetail);
						// clear DAO modification flag, just like the is loaded from DB
						travelreimbursementdetail.clearModifiedFlags();
						// set current data into DAO
						travelreimbursementdetail.setDataFromBase(__travelreimbursementdetail);
						// execute update
						travelreimbursementdetail.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundTravelReimbursementDetail) needToAddTravelReimbursementDetail.add(__travelreimbursementdetail);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseTravelReimbursementDetail __originaltravelreimbursementdetail : originaltravelreimbursementdetail) {
				boolean foundTravelReimbursementDetail = false;
				for(BaseTravelReimbursementDetail __travelreimbursementdetail : getDetailTravelReimbursementDetail() ) {
					if(__travelreimbursementdetail.compareTo(__originaltravelreimbursementdetail) == 0) {
						foundTravelReimbursementDetail = true;
						break;
				}
				}
				if(!foundTravelReimbursementDetail) needToDeleteTravelReimbursementDetail.add(__originaltravelreimbursementdetail);
			}
			// process need-to-add list
			for(BaseTravelReimbursementDetail __travelreimbursementdetail : needToAddTravelReimbursementDetail ) {
				travelreimbursementdetail.setPrimaryKeyFromBase(__travelreimbursementdetail);
				// if the primay key is null, then insert into DB
				if(travelreimbursementdetail.isPrimaryKeyNull()) { travelreimbursementdetail.clearCurrentData(); travelreimbursementdetail.setDataFromBase(__travelreimbursementdetail); travelreimbursementdetail.save(); }
				// otherwise load and update
				else { if(travelreimbursementdetail.load()) { travelreimbursementdetail.setDataFromBase(__travelreimbursementdetail); travelreimbursementdetail.update(); } else { travelreimbursementdetail.clearCurrentData(); travelreimbursementdetail.setDataFromBase(__travelreimbursementdetail); travelreimbursementdetail.save(); } }
			}
			// process need-to-delete list
			for(BaseTravelReimbursementDetail __travelreimbursementdetail : needToDeleteTravelReimbursementDetail ) {
				deleteFromTravelReimbursementDetail(__travelreimbursementdetail, travelreimbursementdetail);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseTravelReimbursementDetail __travelreimbursementdetail : originaltravelreimbursementdetail ) {
				deleteFromTravelReimbursementDetail(__travelreimbursementdetail, travelreimbursementdetail);
			}
		}
	}

	private void deleteFromTravelReimbursementDetail(BaseTravelReimbursementDetail bean, TravelReimbursementDetail dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setTravelReimbursementId(null);
		if(__detail_delete_travelreimbursementdetail) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		TravelReimbursementDetail travelreimbursementdetail = new TravelReimbursementDetail();
		travelreimbursementdetail.setConditionTravelReimbursementId("=", getTravelReimbursementId());
		travelreimbursementdetail.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			TravelReimbursementDetail travelreimbursementdetail = new TravelReimbursementDetail();
			travelreimbursementdetail.setConditionTravelReimbursementId("=", getTravelReimbursementId());
			setDetailTravelReimbursementDetail(travelreimbursementdetail.conditionalLoad());
		}
		return true;
	}

	public List<BaseTravelReimbursementWithT> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseTravelReimbursementWithT> result = BaseTravelReimbursementWithT.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseTravelReimbursementWithT generateBaseExt() {
		BaseTravelReimbursementWithT ____result = new BaseTravelReimbursementWithT();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseTravelReimbursementWithT __base) {
		super.setDataFromBase(__base);
		setDetailTravelReimbursementDetail(__base.getDetailTravelReimbursementDetail());
	}

	public void setDataToBase(BaseTravelReimbursementWithT __base) {
		super.setDataToBase(__base);
		__base.setDetailTravelReimbursementDetail(getDetailTravelReimbursementDetail());
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

	public boolean isDeleteDetailTravelReimbursementDetail() {
		return this.__detail_delete_travelreimbursementdetail;
	}

	public void setDeleteDetailTravelReimbursementDetail( boolean value ) {
		this.__detail_delete_travelreimbursementdetail = value;
	}

	protected boolean __detail_delete_travelreimbursementdetail = true; 
	protected List<BaseTravelReimbursementDetail> __detail_travelreimbursementdetail ; 
}
