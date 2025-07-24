package pomplatform.projectSettlement.dao;

import java.util.*;
import pomplatform.projectSettlement.bean.BaseProjectSettlementWithP;
import com.pomplatform.db.bean.BaseProjectSettlementDetail;
import com.pomplatform.db.dao.ProjectSettlementDetail;

public class ProjectSettlementWithP extends com.pomplatform.db.dao.ProjectSettlement
{


	public ProjectSettlementWithP() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseProjectSettlementDetail> getDetailProjectSettlementDetail() {
		return this.__detail_projectsettlementdetail;
	}

	public void setDetailProjectSettlementDetail( List<BaseProjectSettlementDetail> value ) {
		this.__detail_projectsettlementdetail = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate  DAO
		ProjectSettlementDetail projectsettlementdetail = new ProjectSettlementDetail();
		// load the original detail data.
		projectsettlementdetail.setConditionSettlementId("=", getSettlementId());
		List<BaseProjectSettlementDetail> originalprojectsettlementdetail = projectsettlementdetail.conditionalLoad();
		// if current detail is not empty.
		if(getDetailProjectSettlementDetail() != null) {
			// need to delete data
			List<BaseProjectSettlementDetail> needToDeleteProjectSettlementDetail = new ArrayList<>();
			// need to add data
			List<BaseProjectSettlementDetail> needToAddProjectSettlementDetail = new ArrayList<>();
			// find that records need to be modified.
			for(BaseProjectSettlementDetail __projectsettlementdetail : getDetailProjectSettlementDetail() ) {
				// set that related fields.
				__projectsettlementdetail.setSettlementId(getSettlementId());
				// if found then set found flag.
				boolean foundProjectSettlementDetail = false;
				// search the original detail list.
				for(BaseProjectSettlementDetail __originalprojectsettlementdetail : originalprojectsettlementdetail) {
					// compare the key.
					if(__projectsettlementdetail.compareTo(__originalprojectsettlementdetail) == 0) {
						// found the original record.
						foundProjectSettlementDetail = true;
						//update the record
						// clear DAO's data
						projectsettlementdetail.clearCurrentData();
						// set original bean data into DAO
						projectsettlementdetail.setDataFromBase(__originalprojectsettlementdetail);
						// clear DAO data modification flags, just like the data reloaded from DB.
						projectsettlementdetail.clearModifiedFlags();
						// set the current data into DAO
						projectsettlementdetail.setDataFromBase(__projectsettlementdetail);
						// execute update 
						projectsettlementdetail.update();
						break;
					}
				}
				// if the data not found in the original list, then add to the need-to-add list.
				if(!foundProjectSettlementDetail) needToAddProjectSettlementDetail.add(__projectsettlementdetail);
			}
			// find the record that in the original list but not in the current list.
			for(BaseProjectSettlementDetail __originalprojectsettlementdetail : originalprojectsettlementdetail) {
				boolean foundProjectSettlementDetail = false;
				for(BaseProjectSettlementDetail __projectsettlementdetail : getDetailProjectSettlementDetail() ) {
					if(__projectsettlementdetail.compareTo(__originalprojectsettlementdetail) == 0) {
						foundProjectSettlementDetail = true;
						break;
				}
				}
				if(!foundProjectSettlementDetail) needToDeleteProjectSettlementDetail.add(__originalprojectsettlementdetail);
			}
			// process need-to-delete list.
			for(BaseProjectSettlementDetail __projectsettlementdetail : needToDeleteProjectSettlementDetail ) {
				deleteFromProjectSettlementDetail(__projectsettlementdetail, projectsettlementdetail);
			}
			// process need-to-add list. insert into DB.
			for(BaseProjectSettlementDetail __projectsettlementdetail : needToAddProjectSettlementDetail ) {
				projectsettlementdetail.clearCurrentData();
				projectsettlementdetail.setDataFromBase(__projectsettlementdetail);
				projectsettlementdetail.save();
				__projectsettlementdetail.setSettlementDetailId(projectsettlementdetail.getSettlementDetailId());
			}
		} else {
			// if current list is empty. then delete all the original details.
			for(BaseProjectSettlementDetail __projectsettlementdetail : originalprojectsettlementdetail ) {
				deleteFromProjectSettlementDetail(__projectsettlementdetail, projectsettlementdetail);
			}
		}
	}

	private void deleteFromProjectSettlementDetail(BaseProjectSettlementDetail bean, ProjectSettlementDetail dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setSettlementId(null);
		if(__detail_delete_projectsettlementdetail) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		ProjectSettlementDetail projectsettlementdetail = new ProjectSettlementDetail();
		projectsettlementdetail.setConditionSettlementId("=", getSettlementId());
		projectsettlementdetail.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			ProjectSettlementDetail projectsettlementdetail = new ProjectSettlementDetail();
			projectsettlementdetail.setConditionSettlementId("=", getSettlementId());
			setDetailProjectSettlementDetail(projectsettlementdetail.conditionalLoad());
		}
		return true;
	}

	public List<BaseProjectSettlementWithP> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseProjectSettlementWithP> result = BaseProjectSettlementWithP.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseProjectSettlementWithP generateBaseExt() {
		BaseProjectSettlementWithP ____result = new BaseProjectSettlementWithP();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseProjectSettlementWithP __base) {
		super.setDataFromBase(__base);
		setDetailProjectSettlementDetail(__base.getDetailProjectSettlementDetail());
	}

	public void setDataToBase(BaseProjectSettlementWithP __base) {
		super.setDataToBase(__base);
		__base.setDetailProjectSettlementDetail(getDetailProjectSettlementDetail());
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

	public boolean isDeleteDetailProjectSettlementDetail() {
		return this.__detail_delete_projectsettlementdetail;
	}

	public void setDeleteDetailProjectSettlementDetail( boolean value ) {
		this.__detail_delete_projectsettlementdetail = value;
	}

	protected boolean __detail_delete_projectsettlementdetail = true; 
	protected List<BaseProjectSettlementDetail> __detail_projectsettlementdetail ; 
}
