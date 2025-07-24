package pomplatform.workflow.dao;

import java.util.*;
import pomplatform.workflow.bean.BaseTravelReimbursementWithTt;
import com.pomplatform.db.bean.BaseTravelReimbursementDetail;
import com.pomplatform.db.dao.TravelReimbursementDetail;
import com.pomplatform.db.bean.BaseTravelReimbursementLinkMainProject;
import com.pomplatform.db.dao.TravelReimbursementLinkMainProject;

public class TravelReimbursementWithTt extends com.pomplatform.db.dao.TravelReimbursement
{


	public TravelReimbursementWithTt() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseTravelReimbursementDetail> getDetailTravelReimbursementDetail() {
		return this.__detail_travelreimbursementdetail;
	}

	public void setDetailTravelReimbursementDetail( List<BaseTravelReimbursementDetail> value ) {
		this.__detail_travelreimbursementdetail = value;
	}

	public List<BaseTravelReimbursementLinkMainProject> getDetailTravelReimbursementLinkMainProject() {
		return this.__detail_travelreimbursementlinkmainproject;
	}

	public void setDetailTravelReimbursementLinkMainProject( List<BaseTravelReimbursementLinkMainProject> value ) {
		this.__detail_travelreimbursementlinkmainproject = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate  DAO
		TravelReimbursementDetail travelreimbursementdetail = new TravelReimbursementDetail();
		// load the original detail data.
		travelreimbursementdetail.setConditionTravelReimbursementId("=", getTravelReimbursementId());
		List<BaseTravelReimbursementDetail> originaltravelreimbursementdetail = travelreimbursementdetail.conditionalLoad();
		// if current detail is not empty.
		if(getDetailTravelReimbursementDetail() != null) {
			// need to delete data
			List<BaseTravelReimbursementDetail> needToDeleteTravelReimbursementDetail = new ArrayList<>();
			// need to add data
			List<BaseTravelReimbursementDetail> needToAddTravelReimbursementDetail = new ArrayList<>();
			// find that records need to be modified.
			for(BaseTravelReimbursementDetail __travelreimbursementdetail : getDetailTravelReimbursementDetail() ) {
				// set that related fields.
				__travelreimbursementdetail.setTravelReimbursementId(getTravelReimbursementId());
				// if found then set found flag.
				boolean foundTravelReimbursementDetail = false;
				// search the original detail list.
				for(BaseTravelReimbursementDetail __originaltravelreimbursementdetail : originaltravelreimbursementdetail) {
					// compare the key.
					if(__travelreimbursementdetail.compareTo(__originaltravelreimbursementdetail) == 0) {
						// found the original record.
						foundTravelReimbursementDetail = true;
						//update the record
						// clear DAO's data
						travelreimbursementdetail.clearCurrentData();
						// set original bean data into DAO
						travelreimbursementdetail.setDataFromBase(__originaltravelreimbursementdetail);
						// clear DAO data modification flags, just like the data reloaded from DB.
						travelreimbursementdetail.clearModifiedFlags();
						// set the current data into DAO
						travelreimbursementdetail.setDataFromBase(__travelreimbursementdetail);
						// execute update 
						travelreimbursementdetail.update();
						break;
					}
				}
				// if the data not found in the original list, then add to the need-to-add list.
				if(!foundTravelReimbursementDetail) needToAddTravelReimbursementDetail.add(__travelreimbursementdetail);
			}
			// find the record that in the original list but not in the current list.
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
			// process need-to-add list. insert into DB.
			for(BaseTravelReimbursementDetail __travelreimbursementdetail : needToAddTravelReimbursementDetail ) {
				travelreimbursementdetail.setPrimaryKeyFromBase(__travelreimbursementdetail);
				// if the primay key is null, then insert into DB.
				if(travelreimbursementdetail.isPrimaryKeyNull()) { travelreimbursementdetail.clearCurrentData(); travelreimbursementdetail.setDataFromBase(__travelreimbursementdetail); travelreimbursementdetail.save(); }
				// otherwise, find it and update.
				else { if(travelreimbursementdetail.load()) { travelreimbursementdetail.setDataFromBase(__travelreimbursementdetail); travelreimbursementdetail.update(); } else { travelreimbursementdetail.clearCurrentData(); travelreimbursementdetail.setDataFromBase(__travelreimbursementdetail); travelreimbursementdetail.save(); } }
			}
			// process need-to-delete list.
			for(BaseTravelReimbursementDetail __travelreimbursementdetail : needToDeleteTravelReimbursementDetail ) {
				deleteFromTravelReimbursementDetail(__travelreimbursementdetail, travelreimbursementdetail);
			}
		} else {
			// if current list is empty. then delete all the original details.
			for(BaseTravelReimbursementDetail __travelreimbursementdetail : originaltravelreimbursementdetail ) {
				deleteFromTravelReimbursementDetail(__travelreimbursementdetail, travelreimbursementdetail);
			}
		}
		// instantiate  DAO
		TravelReimbursementLinkMainProject travelreimbursementlinkmainproject = new TravelReimbursementLinkMainProject();
		// load the original detail data.
		travelreimbursementlinkmainproject.setConditionTravelReimbursementId("=", getTravelReimbursementId());
		List<BaseTravelReimbursementLinkMainProject> originaltravelreimbursementlinkmainproject = travelreimbursementlinkmainproject.conditionalLoad();
		// if current detail is not empty.
		if(getDetailTravelReimbursementLinkMainProject() != null) {
			// need to delete data
			List<BaseTravelReimbursementLinkMainProject> needToDeleteTravelReimbursementLinkMainProject = new ArrayList<>();
			// need to add data
			List<BaseTravelReimbursementLinkMainProject> needToAddTravelReimbursementLinkMainProject = new ArrayList<>();
			// find that records need to be modified.
			for(BaseTravelReimbursementLinkMainProject __travelreimbursementlinkmainproject : getDetailTravelReimbursementLinkMainProject() ) {
				// set that related fields.
				__travelreimbursementlinkmainproject.setTravelReimbursementId(getTravelReimbursementId());
				// if found then set found flag.
				boolean foundTravelReimbursementLinkMainProject = false;
				// search the original detail list.
				for(BaseTravelReimbursementLinkMainProject __originaltravelreimbursementlinkmainproject : originaltravelreimbursementlinkmainproject) {
					// compare the key.
					if(Objects.equals(__travelreimbursementlinkmainproject.getTravelReimbursementLinkMainProjectId(), __originaltravelreimbursementlinkmainproject.getTravelReimbursementLinkMainProjectId())) {
						// found the original record.
						foundTravelReimbursementLinkMainProject = true;
						//update the record
						// clear DAO's data
						travelreimbursementlinkmainproject.clearCurrentData();
						// set original bean data into DAO
						travelreimbursementlinkmainproject.setDataFromBase(__originaltravelreimbursementlinkmainproject);
						// clear DAO data modification flags, just like the data reloaded from DB.
						travelreimbursementlinkmainproject.clearModifiedFlags();
						// set the current data into DAO
						travelreimbursementlinkmainproject.setDataFromBase(__travelreimbursementlinkmainproject);
						// execute update 
						travelreimbursementlinkmainproject.update();
						break;
					}
				}
				// if the data not found in the original list, then add to the need-to-add list.
				if(!foundTravelReimbursementLinkMainProject) needToAddTravelReimbursementLinkMainProject.add(__travelreimbursementlinkmainproject);
			}
			// find the record that in the original list but not in the current list.
			for(BaseTravelReimbursementLinkMainProject __originaltravelreimbursementlinkmainproject : originaltravelreimbursementlinkmainproject) {
				boolean foundTravelReimbursementLinkMainProject = false;
				for(BaseTravelReimbursementLinkMainProject __travelreimbursementlinkmainproject : getDetailTravelReimbursementLinkMainProject() ) {
					if(Objects.equals(__travelreimbursementlinkmainproject.getTravelReimbursementLinkMainProjectId(), __originaltravelreimbursementlinkmainproject.getTravelReimbursementLinkMainProjectId())) {
						foundTravelReimbursementLinkMainProject = true;
						break;
				}
				}
				if(!foundTravelReimbursementLinkMainProject) needToDeleteTravelReimbursementLinkMainProject.add(__originaltravelreimbursementlinkmainproject);
			}
			// process need-to-add list. insert into DB.
			for(BaseTravelReimbursementLinkMainProject __travelreimbursementlinkmainproject : needToAddTravelReimbursementLinkMainProject ) {
				travelreimbursementlinkmainproject.setPrimaryKeyFromBase(__travelreimbursementlinkmainproject);
				// if the primay key is null, then insert into DB.
				if(travelreimbursementlinkmainproject.isPrimaryKeyNull()) { travelreimbursementlinkmainproject.clearCurrentData(); travelreimbursementlinkmainproject.setDataFromBase(__travelreimbursementlinkmainproject); travelreimbursementlinkmainproject.save(); }
				// otherwise, find it and update.
				else { if(travelreimbursementlinkmainproject.load()) { travelreimbursementlinkmainproject.setDataFromBase(__travelreimbursementlinkmainproject); travelreimbursementlinkmainproject.update(); } else { travelreimbursementlinkmainproject.clearCurrentData(); travelreimbursementlinkmainproject.setDataFromBase(__travelreimbursementlinkmainproject); travelreimbursementlinkmainproject.save(); } }
			}
			// process need-to-delete list.
			for(BaseTravelReimbursementLinkMainProject __travelreimbursementlinkmainproject : needToDeleteTravelReimbursementLinkMainProject ) {
				deleteFromTravelReimbursementLinkMainProject(__travelreimbursementlinkmainproject, travelreimbursementlinkmainproject);
			}
		} else {
			// if current list is empty. then delete all the original details.
			for(BaseTravelReimbursementLinkMainProject __travelreimbursementlinkmainproject : originaltravelreimbursementlinkmainproject ) {
				deleteFromTravelReimbursementLinkMainProject(__travelreimbursementlinkmainproject, travelreimbursementlinkmainproject);
			}
		}
	}

	private void deleteFromTravelReimbursementDetail(BaseTravelReimbursementDetail bean, TravelReimbursementDetail dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setTravelReimbursementId(null);
		if(__detail_delete_travelreimbursementdetail) dao.delete(); else dao.update();
	}

	private void deleteFromTravelReimbursementLinkMainProject(BaseTravelReimbursementLinkMainProject bean, TravelReimbursementLinkMainProject dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setTravelReimbursementId(null);
		if(__detail_delete_travelreimbursementlinkmainproject) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		TravelReimbursementDetail travelreimbursementdetail = new TravelReimbursementDetail();
		travelreimbursementdetail.setConditionTravelReimbursementId("=", getTravelReimbursementId());
		travelreimbursementdetail.conditionalDelete();
		TravelReimbursementLinkMainProject travelreimbursementlinkmainproject = new TravelReimbursementLinkMainProject();
		travelreimbursementlinkmainproject.setConditionTravelReimbursementId("=", getTravelReimbursementId());
		travelreimbursementlinkmainproject.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			TravelReimbursementDetail travelreimbursementdetail = new TravelReimbursementDetail();
			travelreimbursementdetail.setConditionTravelReimbursementId("=", getTravelReimbursementId());
			setDetailTravelReimbursementDetail(travelreimbursementdetail.conditionalLoad());
			TravelReimbursementLinkMainProject travelreimbursementlinkmainproject = new TravelReimbursementLinkMainProject();
			travelreimbursementlinkmainproject.setConditionTravelReimbursementId("=", getTravelReimbursementId());
			setDetailTravelReimbursementLinkMainProject(travelreimbursementlinkmainproject.conditionalLoad());
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
		setDetailTravelReimbursementLinkMainProject(__base.getDetailTravelReimbursementLinkMainProject());
	}

	public void setDataToBase(BaseTravelReimbursementWithTt __base) {
		super.setDataToBase(__base);
		__base.setDetailTravelReimbursementDetail(getDetailTravelReimbursementDetail());
		__base.setDetailTravelReimbursementLinkMainProject(getDetailTravelReimbursementLinkMainProject());
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
	public boolean isDeleteDetailTravelReimbursementLinkMainProject() {
		return this.__detail_delete_travelreimbursementlinkmainproject;
	}

	public void setDeleteDetailTravelReimbursementLinkMainProject( boolean value ) {
		this.__detail_delete_travelreimbursementlinkmainproject = value;
	}

	protected boolean __detail_delete_travelreimbursementlinkmainproject = true; 
	protected List<BaseTravelReimbursementLinkMainProject> __detail_travelreimbursementlinkmainproject ; 
}
