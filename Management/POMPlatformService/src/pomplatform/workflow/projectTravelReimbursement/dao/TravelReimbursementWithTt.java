package pomplatform.workflow.projectTravelReimbursement.dao;

import java.util.*;

import com.pomplatform.db.bean.BaseTravelReimbursementDetail;
import com.pomplatform.db.dao.TravelReimbursementDetail;
import com.pomplatform.db.bean.BaseTravelReimbursementLinkProject;
import com.pomplatform.db.dao.TravelReimbursementLinkProject;

import pomplatform.workflow.projectTravelReimbursement.bean.BaseTravelReimbursementWithTt;

public class TravelReimbursementWithTt extends com.pomplatform.db.dao.TravelReimbursement
{


	public TravelReimbursementWithTt() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseTravelReimbursementDetail> getDetailTravelReimbursementDetail() {
		return this.__detail_travelreimbursementdetail;
	}

	public void setDetailTravelReimbursementDetail( List<BaseTravelReimbursementDetail> value ) {
		this.__detail_travelreimbursementdetail = value;
	}

	public List<BaseTravelReimbursementLinkProject> getDetailTravelReimbursementLinkProject() {
		return this.__detail_travelreimbursementlinkproject;
	}

	public void setDetailTravelReimbursementLinkProject( List<BaseTravelReimbursementLinkProject> value ) {
		this.__detail_travelreimbursementlinkproject = value;
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
		TravelReimbursementLinkProject travelreimbursementlinkproject = new TravelReimbursementLinkProject();
		// load the original details.
		travelreimbursementlinkproject.setConditionTravelReimbursementId("=", getTravelReimbursementId());
		List<BaseTravelReimbursementLinkProject> originaltravelreimbursementlinkproject = travelreimbursementlinkproject.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailTravelReimbursementLinkProject() != null) {
			// need to delete list.
			List<BaseTravelReimbursementLinkProject> needToDeleteTravelReimbursementLinkProject = new ArrayList<>();
			// need to add list.
			List<BaseTravelReimbursementLinkProject> needToAddTravelReimbursementLinkProject = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseTravelReimbursementLinkProject __travelreimbursementlinkproject : getDetailTravelReimbursementLinkProject() ) {
				// set the relative field.
				__travelreimbursementlinkproject.setTravelReimbursementId( getTravelReimbursementId());
				// set find flag
				boolean foundTravelReimbursementLinkProject = false;
				// find the original list.
				for(BaseTravelReimbursementLinkProject __originaltravelreimbursementlinkproject : originaltravelreimbursementlinkproject) {
					// if found the original record
					if(__travelreimbursementlinkproject.compareTo(__originaltravelreimbursementlinkproject) == 0) {
						// set found flag to true
						foundTravelReimbursementLinkProject = true;
						// update the record.
						// clear DAO's data
						travelreimbursementlinkproject.clearCurrentData();
						// set original data into DAO
						travelreimbursementlinkproject.setDataFromBase(__originaltravelreimbursementlinkproject);
						// clear DAO modification flag, just like the is loaded from DB
						travelreimbursementlinkproject.clearModifiedFlags();
						// set current data into DAO
						travelreimbursementlinkproject.setDataFromBase(__travelreimbursementlinkproject);
						// execute update
						travelreimbursementlinkproject.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundTravelReimbursementLinkProject) needToAddTravelReimbursementLinkProject.add(__travelreimbursementlinkproject);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseTravelReimbursementLinkProject __originaltravelreimbursementlinkproject : originaltravelreimbursementlinkproject) {
				boolean foundTravelReimbursementLinkProject = false;
				for(BaseTravelReimbursementLinkProject __travelreimbursementlinkproject : getDetailTravelReimbursementLinkProject() ) {
					if(__travelreimbursementlinkproject.compareTo(__originaltravelreimbursementlinkproject) == 0) {
						foundTravelReimbursementLinkProject = true;
						break;
				}
				}
				if(!foundTravelReimbursementLinkProject) needToDeleteTravelReimbursementLinkProject.add(__originaltravelreimbursementlinkproject);
			}
			// process need-to-add list
			for(BaseTravelReimbursementLinkProject __travelreimbursementlinkproject : needToAddTravelReimbursementLinkProject ) {
				travelreimbursementlinkproject.setPrimaryKeyFromBase(__travelreimbursementlinkproject);
				// if the primay key is null, then insert into DB
				if(travelreimbursementlinkproject.isPrimaryKeyNull()) { travelreimbursementlinkproject.clearCurrentData(); travelreimbursementlinkproject.setDataFromBase(__travelreimbursementlinkproject); travelreimbursementlinkproject.save(); }
				// otherwise load and update
				else { if(travelreimbursementlinkproject.load()) { travelreimbursementlinkproject.setDataFromBase(__travelreimbursementlinkproject); travelreimbursementlinkproject.update(); } else { travelreimbursementlinkproject.clearCurrentData(); travelreimbursementlinkproject.setDataFromBase(__travelreimbursementlinkproject); travelreimbursementlinkproject.save(); } }
			}
			// process need-to-delete list
			for(BaseTravelReimbursementLinkProject __travelreimbursementlinkproject : needToDeleteTravelReimbursementLinkProject ) {
				deleteFromTravelReimbursementLinkProject(__travelreimbursementlinkproject, travelreimbursementlinkproject);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseTravelReimbursementLinkProject __travelreimbursementlinkproject : originaltravelreimbursementlinkproject ) {
				deleteFromTravelReimbursementLinkProject(__travelreimbursementlinkproject, travelreimbursementlinkproject);
			}
		}
	}

	private void deleteFromTravelReimbursementDetail(BaseTravelReimbursementDetail bean, TravelReimbursementDetail dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setTravelReimbursementId(null);
		if(__detail_delete_travelreimbursementdetail) dao.delete(); else dao.update();
	}

	private void deleteFromTravelReimbursementLinkProject(BaseTravelReimbursementLinkProject bean, TravelReimbursementLinkProject dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setTravelReimbursementId(null);
		if(__detail_delete_travelreimbursementlinkproject) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		TravelReimbursementDetail travelreimbursementdetail = new TravelReimbursementDetail();
		travelreimbursementdetail.setConditionTravelReimbursementId("=", getTravelReimbursementId());
		travelreimbursementdetail.conditionalDelete();
		TravelReimbursementLinkProject travelreimbursementlinkproject = new TravelReimbursementLinkProject();
		travelreimbursementlinkproject.setConditionTravelReimbursementId("=", getTravelReimbursementId());
		travelreimbursementlinkproject.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			TravelReimbursementDetail travelreimbursementdetail = new TravelReimbursementDetail();
			travelreimbursementdetail.setConditionTravelReimbursementId("=", getTravelReimbursementId());
			setDetailTravelReimbursementDetail(travelreimbursementdetail.conditionalLoad());
			TravelReimbursementLinkProject travelreimbursementlinkproject = new TravelReimbursementLinkProject();
			travelreimbursementlinkproject.setConditionTravelReimbursementId("=", getTravelReimbursementId());
			setDetailTravelReimbursementLinkProject(travelreimbursementlinkproject.conditionalLoad());
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
		setDetailTravelReimbursementLinkProject(__base.getDetailTravelReimbursementLinkProject());
	}

	public void setDataToBase(BaseTravelReimbursementWithTt __base) {
		super.setDataToBase(__base);
		__base.setDetailTravelReimbursementDetail(getDetailTravelReimbursementDetail());
		__base.setDetailTravelReimbursementLinkProject(getDetailTravelReimbursementLinkProject());
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
	public boolean isDeleteDetailTravelReimbursementLinkProject() {
		return this.__detail_delete_travelreimbursementlinkproject;
	}

	public void setDeleteDetailTravelReimbursementLinkProject( boolean value ) {
		this.__detail_delete_travelreimbursementlinkproject = value;
	}

	protected boolean __detail_delete_travelreimbursementlinkproject = true; 
	protected List<BaseTravelReimbursementLinkProject> __detail_travelreimbursementlinkproject ; 
}
