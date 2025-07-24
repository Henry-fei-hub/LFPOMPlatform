package pomplatform.workflow.commonTravelReimbursement.dao;

import java.util.*;

import com.pomplatform.db.bean.BaseTravelReimbursementDetail;
import com.pomplatform.db.dao.TravelReimbursementDetail;
import com.pomplatform.db.bean.BaseTravelReimbursementLinkDepartment;
import com.pomplatform.db.dao.TravelReimbursementLinkDepartment;

import pomplatform.workflow.commonTravelReimbursement.bean.BaseTravelReimbursementWithTt;

public class TravelReimbursementWithTt extends com.pomplatform.db.dao.TravelReimbursement
{


	public TravelReimbursementWithTt() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseTravelReimbursementDetail> getDetailTravelReimbursementDetail() {
		return this.__detail_travelreimbursementdetail;
	}

	public void setDetailTravelReimbursementDetail( List<BaseTravelReimbursementDetail> value ) {
		this.__detail_travelreimbursementdetail = value;
	}

	public List<BaseTravelReimbursementLinkDepartment> getDetailTravelReimbursementLinkDepartment() {
		return this.__detail_travelreimbursementlinkdepartment;
	}

	public void setDetailTravelReimbursementLinkDepartment( List<BaseTravelReimbursementLinkDepartment> value ) {
		this.__detail_travelreimbursementlinkdepartment = value;
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
		// instantiate  DAO
		TravelReimbursementLinkDepartment travelreimbursementlinkdepartment = new TravelReimbursementLinkDepartment();
		// load the original details.
		travelreimbursementlinkdepartment.setConditionTravelReimbursementId("=", getTravelReimbursementId());
		List<BaseTravelReimbursementLinkDepartment> originaltravelreimbursementlinkdepartment = travelreimbursementlinkdepartment.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailTravelReimbursementLinkDepartment() != null) {
			// need to delete list.
			List<BaseTravelReimbursementLinkDepartment> needToDeleteTravelReimbursementLinkDepartment = new ArrayList<>();
			// need to add list.
			List<BaseTravelReimbursementLinkDepartment> needToAddTravelReimbursementLinkDepartment = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseTravelReimbursementLinkDepartment __travelreimbursementlinkdepartment : getDetailTravelReimbursementLinkDepartment() ) {
				// set the relative field.
				__travelreimbursementlinkdepartment.setTravelReimbursementId( getTravelReimbursementId());
				// set find flag
				boolean foundTravelReimbursementLinkDepartment = false;
				// find the original list.
				for(BaseTravelReimbursementLinkDepartment __originaltravelreimbursementlinkdepartment : originaltravelreimbursementlinkdepartment) {
					// if found the original record
					if(__travelreimbursementlinkdepartment.compareTo(__originaltravelreimbursementlinkdepartment) == 0) {
						// set found flag to true
						foundTravelReimbursementLinkDepartment = true;
						// update the record.
						// clear DAO's data
						travelreimbursementlinkdepartment.clearCurrentData();
						// set original data into DAO
						travelreimbursementlinkdepartment.setDataFromBase(__originaltravelreimbursementlinkdepartment);
						// clear DAO modification flag, just like the is loaded from DB
						travelreimbursementlinkdepartment.clearModifiedFlags();
						// set current data into DAO
						travelreimbursementlinkdepartment.setDataFromBase(__travelreimbursementlinkdepartment);
						// execute update
						travelreimbursementlinkdepartment.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundTravelReimbursementLinkDepartment) needToAddTravelReimbursementLinkDepartment.add(__travelreimbursementlinkdepartment);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseTravelReimbursementLinkDepartment __originaltravelreimbursementlinkdepartment : originaltravelreimbursementlinkdepartment) {
				boolean foundTravelReimbursementLinkDepartment = false;
				for(BaseTravelReimbursementLinkDepartment __travelreimbursementlinkdepartment : getDetailTravelReimbursementLinkDepartment() ) {
					if(__travelreimbursementlinkdepartment.compareTo(__originaltravelreimbursementlinkdepartment) == 0) {
						foundTravelReimbursementLinkDepartment = true;
						break;
				}
				}
				if(!foundTravelReimbursementLinkDepartment) needToDeleteTravelReimbursementLinkDepartment.add(__originaltravelreimbursementlinkdepartment);
			}
			// process need-to-add list
			for(BaseTravelReimbursementLinkDepartment __travelreimbursementlinkdepartment : needToAddTravelReimbursementLinkDepartment ) {
				travelreimbursementlinkdepartment.setPrimaryKeyFromBase(__travelreimbursementlinkdepartment);
				// if the primay key is null, then insert into DB
				if(travelreimbursementlinkdepartment.isPrimaryKeyNull()) { travelreimbursementlinkdepartment.clearCurrentData(); travelreimbursementlinkdepartment.setDataFromBase(__travelreimbursementlinkdepartment); travelreimbursementlinkdepartment.save(); }
				// otherwise load and update
				else { if(travelreimbursementlinkdepartment.load()) { travelreimbursementlinkdepartment.setDataFromBase(__travelreimbursementlinkdepartment); travelreimbursementlinkdepartment.update(); } else { travelreimbursementlinkdepartment.clearCurrentData(); travelreimbursementlinkdepartment.setDataFromBase(__travelreimbursementlinkdepartment); travelreimbursementlinkdepartment.save(); } }
			}
			// process need-to-delete list
			for(BaseTravelReimbursementLinkDepartment __travelreimbursementlinkdepartment : needToDeleteTravelReimbursementLinkDepartment ) {
				deleteFromTravelReimbursementLinkDepartment(__travelreimbursementlinkdepartment, travelreimbursementlinkdepartment);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseTravelReimbursementLinkDepartment __travelreimbursementlinkdepartment : originaltravelreimbursementlinkdepartment ) {
				deleteFromTravelReimbursementLinkDepartment(__travelreimbursementlinkdepartment, travelreimbursementlinkdepartment);
			}
		}
	}

	private void deleteFromTravelReimbursementDetail(BaseTravelReimbursementDetail bean, TravelReimbursementDetail dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setTravelReimbursementId(null);
		if(__detail_delete_travelreimbursementdetail) dao.delete(); else dao.update();
	}

	private void deleteFromTravelReimbursementLinkDepartment(BaseTravelReimbursementLinkDepartment bean, TravelReimbursementLinkDepartment dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setTravelReimbursementId(null);
		if(__detail_delete_travelreimbursementlinkdepartment) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		TravelReimbursementDetail travelreimbursementdetail = new TravelReimbursementDetail();
		travelreimbursementdetail.setConditionTravelReimbursementId("=", getTravelReimbursementId());
		travelreimbursementdetail.conditionalDelete();
		TravelReimbursementLinkDepartment travelreimbursementlinkdepartment = new TravelReimbursementLinkDepartment();
		travelreimbursementlinkdepartment.setConditionTravelReimbursementId("=", getTravelReimbursementId());
		travelreimbursementlinkdepartment.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			TravelReimbursementDetail travelreimbursementdetail = new TravelReimbursementDetail();
			travelreimbursementdetail.setConditionTravelReimbursementId("=", getTravelReimbursementId());
			setDetailTravelReimbursementDetail(travelreimbursementdetail.conditionalLoad());
			TravelReimbursementLinkDepartment travelreimbursementlinkdepartment = new TravelReimbursementLinkDepartment();
			travelreimbursementlinkdepartment.setConditionTravelReimbursementId("=", getTravelReimbursementId());
			setDetailTravelReimbursementLinkDepartment(travelreimbursementlinkdepartment.conditionalLoad());
		}
		return true;
	}

	public List<BaseTravelReimbursementWithTt> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseTravelReimbursementWithTt> result = BaseTravelReimbursementWithTt.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseTravelReimbursementWithTt generateBaseExt() {
		BaseTravelReimbursementWithTt ____result = new BaseTravelReimbursementWithTt();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseTravelReimbursementWithTt __base) {
		super.setDataFromBase(__base);
		setDetailTravelReimbursementDetail(__base.getDetailTravelReimbursementDetail());
		setDetailTravelReimbursementLinkDepartment(__base.getDetailTravelReimbursementLinkDepartment());
	}

	public void setDataToBase(BaseTravelReimbursementWithTt __base) {
		super.setDataToBase(__base);
		__base.setDetailTravelReimbursementDetail(getDetailTravelReimbursementDetail());
		__base.setDetailTravelReimbursementLinkDepartment(getDetailTravelReimbursementLinkDepartment());
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
	public boolean isDeleteDetailTravelReimbursementLinkDepartment() {
		return this.__detail_delete_travelreimbursementlinkdepartment;
	}

	public void setDeleteDetailTravelReimbursementLinkDepartment( boolean value ) {
		this.__detail_delete_travelreimbursementlinkdepartment = value;
	}

	protected boolean __detail_delete_travelreimbursementlinkdepartment = true; 
	protected List<BaseTravelReimbursementLinkDepartment> __detail_travelreimbursementlinkdepartment ; 
}
