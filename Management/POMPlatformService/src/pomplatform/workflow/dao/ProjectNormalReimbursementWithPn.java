package pomplatform.workflow.dao;

import java.util.*;
import pomplatform.workflow.bean.BaseProjectNormalReimbursementWithPn;
import com.pomplatform.db.bean.BaseProjectNormalReimbursementDetail;
import com.pomplatform.db.dao.ProjectNormalReimbursementDetail;
import com.pomplatform.db.bean.BaseNormalReimbursementLinkMainProject;
import com.pomplatform.db.dao.NormalReimbursementLinkMainProject;

public class ProjectNormalReimbursementWithPn extends com.pomplatform.db.dao.ProjectNormalReimbursement
{


	public ProjectNormalReimbursementWithPn() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseProjectNormalReimbursementDetail> getDetailProjectNormalReimbursementDetail() {
		return this.__detail_projectnormalreimbursementdetail;
	}

	public void setDetailProjectNormalReimbursementDetail( List<BaseProjectNormalReimbursementDetail> value ) {
		this.__detail_projectnormalreimbursementdetail = value;
	}

	public List<BaseNormalReimbursementLinkMainProject> getDetailNormalReimbursementLinkMainProject() {
		return this.__detail_normalreimbursementlinkmainproject;
	}

	public void setDetailNormalReimbursementLinkMainProject( List<BaseNormalReimbursementLinkMainProject> value ) {
		this.__detail_normalreimbursementlinkmainproject = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate  DAO
		ProjectNormalReimbursementDetail projectnormalreimbursementdetail = new ProjectNormalReimbursementDetail();
		// load the original detail data.
		projectnormalreimbursementdetail.setConditionProjectNormalReimbursementId("=", getProjectNormalReimbursementId());
		List<BaseProjectNormalReimbursementDetail> originalprojectnormalreimbursementdetail = projectnormalreimbursementdetail.conditionalLoad();
		// if current detail is not empty.
		if(getDetailProjectNormalReimbursementDetail() != null) {
			// need to delete data
			List<BaseProjectNormalReimbursementDetail> needToDeleteProjectNormalReimbursementDetail = new ArrayList<>();
			// need to add data
			List<BaseProjectNormalReimbursementDetail> needToAddProjectNormalReimbursementDetail = new ArrayList<>();
			// find that records need to be modified.
			for(BaseProjectNormalReimbursementDetail __projectnormalreimbursementdetail : getDetailProjectNormalReimbursementDetail() ) {
				// set that related fields.
				__projectnormalreimbursementdetail.setProjectNormalReimbursementId(getProjectNormalReimbursementId());
				// if found then set found flag.
				boolean foundProjectNormalReimbursementDetail = false;
				// search the original detail list.
				for(BaseProjectNormalReimbursementDetail __originalprojectnormalreimbursementdetail : originalprojectnormalreimbursementdetail) {
					// compare the key.
					if(Objects.equals(__projectnormalreimbursementdetail.getMainItemId(), __originalprojectnormalreimbursementdetail.getMainItemId())) {
						// found the original record.
						foundProjectNormalReimbursementDetail = true;
						//update the record
						// clear DAO's data
						projectnormalreimbursementdetail.clearCurrentData();
						// set original bean data into DAO
						projectnormalreimbursementdetail.setDataFromBase(__originalprojectnormalreimbursementdetail);
						// clear DAO data modification flags, just like the data reloaded from DB.
						projectnormalreimbursementdetail.clearModifiedFlags();
						// set the current data into DAO
						projectnormalreimbursementdetail.setDataFromBase(__projectnormalreimbursementdetail);
						// execute update 
						projectnormalreimbursementdetail.update();
						break;
					}
				}
				// if the data not found in the original list, then add to the need-to-add list.
				if(!foundProjectNormalReimbursementDetail) needToAddProjectNormalReimbursementDetail.add(__projectnormalreimbursementdetail);
			}
			// find the record that in the original list but not in the current list.
			for(BaseProjectNormalReimbursementDetail __originalprojectnormalreimbursementdetail : originalprojectnormalreimbursementdetail) {
				boolean foundProjectNormalReimbursementDetail = false;
				for(BaseProjectNormalReimbursementDetail __projectnormalreimbursementdetail : getDetailProjectNormalReimbursementDetail() ) {
					if(Objects.equals(__projectnormalreimbursementdetail.getMainItemId(), __originalprojectnormalreimbursementdetail.getMainItemId())) {
						foundProjectNormalReimbursementDetail = true;
						break;
				}
				}
				if(!foundProjectNormalReimbursementDetail) needToDeleteProjectNormalReimbursementDetail.add(__originalprojectnormalreimbursementdetail);
			}
			// process need-to-add list. insert into DB.
			for(BaseProjectNormalReimbursementDetail __projectnormalreimbursementdetail : needToAddProjectNormalReimbursementDetail ) {
				projectnormalreimbursementdetail.setPrimaryKeyFromBase(__projectnormalreimbursementdetail);
				// if the primay key is null, then insert into DB.
				if(projectnormalreimbursementdetail.isPrimaryKeyNull()) { projectnormalreimbursementdetail.clearCurrentData(); projectnormalreimbursementdetail.setDataFromBase(__projectnormalreimbursementdetail); projectnormalreimbursementdetail.save(); }
				// otherwise, find it and update.
				else { if(projectnormalreimbursementdetail.load()) { projectnormalreimbursementdetail.setDataFromBase(__projectnormalreimbursementdetail); projectnormalreimbursementdetail.update(); } else { projectnormalreimbursementdetail.clearCurrentData(); projectnormalreimbursementdetail.setDataFromBase(__projectnormalreimbursementdetail); projectnormalreimbursementdetail.save(); } }
			}
			// process need-to-delete list.
			for(BaseProjectNormalReimbursementDetail __projectnormalreimbursementdetail : needToDeleteProjectNormalReimbursementDetail ) {
				deleteFromProjectNormalReimbursementDetail(__projectnormalreimbursementdetail, projectnormalreimbursementdetail);
			}
		} else {
			// if current list is empty. then delete all the original details.
			for(BaseProjectNormalReimbursementDetail __projectnormalreimbursementdetail : originalprojectnormalreimbursementdetail ) {
				deleteFromProjectNormalReimbursementDetail(__projectnormalreimbursementdetail, projectnormalreimbursementdetail);
			}
		}
		// instantiate  DAO
		NormalReimbursementLinkMainProject normalreimbursementlinkmainproject = new NormalReimbursementLinkMainProject();
		// load the original detail data.
		normalreimbursementlinkmainproject.setConditionProjectNormalReimbursementId("=", getProjectNormalReimbursementId());
		List<BaseNormalReimbursementLinkMainProject> originalnormalreimbursementlinkmainproject = normalreimbursementlinkmainproject.conditionalLoad();
		// if current detail is not empty.
		if(getDetailNormalReimbursementLinkMainProject() != null) {
			// need to delete data
			List<BaseNormalReimbursementLinkMainProject> needToDeleteNormalReimbursementLinkMainProject = new ArrayList<>();
			// need to add data
			List<BaseNormalReimbursementLinkMainProject> needToAddNormalReimbursementLinkMainProject = new ArrayList<>();
			// find that records need to be modified.
			for(BaseNormalReimbursementLinkMainProject __normalreimbursementlinkmainproject : getDetailNormalReimbursementLinkMainProject() ) {
				// set that related fields.
				__normalreimbursementlinkmainproject.setProjectNormalReimbursementId(getProjectNormalReimbursementId());
				// if found then set found flag.
				boolean foundNormalReimbursementLinkMainProject = false;
				// search the original detail list.
				for(BaseNormalReimbursementLinkMainProject __originalnormalreimbursementlinkmainproject : originalnormalreimbursementlinkmainproject) {
					// compare the key.
					if(Objects.equals(__normalreimbursementlinkmainproject.getNormalReimbursementLinkMainProjectId(), __originalnormalreimbursementlinkmainproject.getNormalReimbursementLinkMainProjectId())) {
						// found the original record.
						foundNormalReimbursementLinkMainProject = true;
						//update the record
						// clear DAO's data
						normalreimbursementlinkmainproject.clearCurrentData();
						// set original bean data into DAO
						normalreimbursementlinkmainproject.setDataFromBase(__originalnormalreimbursementlinkmainproject);
						// clear DAO data modification flags, just like the data reloaded from DB.
						normalreimbursementlinkmainproject.clearModifiedFlags();
						// set the current data into DAO
						normalreimbursementlinkmainproject.setDataFromBase(__normalreimbursementlinkmainproject);
						// execute update 
						normalreimbursementlinkmainproject.update();
						break;
					}
				}
				// if the data not found in the original list, then add to the need-to-add list.
				if(!foundNormalReimbursementLinkMainProject) needToAddNormalReimbursementLinkMainProject.add(__normalreimbursementlinkmainproject);
			}
			// find the record that in the original list but not in the current list.
			for(BaseNormalReimbursementLinkMainProject __originalnormalreimbursementlinkmainproject : originalnormalreimbursementlinkmainproject) {
				boolean foundNormalReimbursementLinkMainProject = false;
				for(BaseNormalReimbursementLinkMainProject __normalreimbursementlinkmainproject : getDetailNormalReimbursementLinkMainProject() ) {
					if(Objects.equals(__normalreimbursementlinkmainproject.getNormalReimbursementLinkMainProjectId(), __originalnormalreimbursementlinkmainproject.getNormalReimbursementLinkMainProjectId())) {
						foundNormalReimbursementLinkMainProject = true;
						break;
				}
				}
				if(!foundNormalReimbursementLinkMainProject) needToDeleteNormalReimbursementLinkMainProject.add(__originalnormalreimbursementlinkmainproject);
			}
			// process need-to-add list. insert into DB.
			for(BaseNormalReimbursementLinkMainProject __normalreimbursementlinkmainproject : needToAddNormalReimbursementLinkMainProject ) {
				normalreimbursementlinkmainproject.setPrimaryKeyFromBase(__normalreimbursementlinkmainproject);
				// if the primay key is null, then insert into DB.
				if(normalreimbursementlinkmainproject.isPrimaryKeyNull()) { normalreimbursementlinkmainproject.clearCurrentData(); normalreimbursementlinkmainproject.setDataFromBase(__normalreimbursementlinkmainproject); normalreimbursementlinkmainproject.save(); }
				// otherwise, find it and update.
				else { if(normalreimbursementlinkmainproject.load()) { normalreimbursementlinkmainproject.setDataFromBase(__normalreimbursementlinkmainproject); normalreimbursementlinkmainproject.update(); } else { normalreimbursementlinkmainproject.clearCurrentData(); normalreimbursementlinkmainproject.setDataFromBase(__normalreimbursementlinkmainproject); normalreimbursementlinkmainproject.save(); } }
			}
			// process need-to-delete list.
			for(BaseNormalReimbursementLinkMainProject __normalreimbursementlinkmainproject : needToDeleteNormalReimbursementLinkMainProject ) {
				deleteFromNormalReimbursementLinkMainProject(__normalreimbursementlinkmainproject, normalreimbursementlinkmainproject);
			}
		} else {
			// if current list is empty. then delete all the original details.
			for(BaseNormalReimbursementLinkMainProject __normalreimbursementlinkmainproject : originalnormalreimbursementlinkmainproject ) {
				deleteFromNormalReimbursementLinkMainProject(__normalreimbursementlinkmainproject, normalreimbursementlinkmainproject);
			}
		}
	}

	private void deleteFromProjectNormalReimbursementDetail(BaseProjectNormalReimbursementDetail bean, ProjectNormalReimbursementDetail dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setProjectNormalReimbursementId(null);
		if(__detail_delete_projectnormalreimbursementdetail) dao.delete(); else dao.update();
	}

	private void deleteFromNormalReimbursementLinkMainProject(BaseNormalReimbursementLinkMainProject bean, NormalReimbursementLinkMainProject dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setProjectNormalReimbursementId(null);
		if(__detail_delete_normalreimbursementlinkmainproject) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		ProjectNormalReimbursementDetail projectnormalreimbursementdetail = new ProjectNormalReimbursementDetail();
		projectnormalreimbursementdetail.setConditionProjectNormalReimbursementId("=", getProjectNormalReimbursementId());
		projectnormalreimbursementdetail.conditionalDelete();
		NormalReimbursementLinkMainProject normalreimbursementlinkmainproject = new NormalReimbursementLinkMainProject();
		normalreimbursementlinkmainproject.setConditionProjectNormalReimbursementId("=", getProjectNormalReimbursementId());
		normalreimbursementlinkmainproject.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			ProjectNormalReimbursementDetail projectnormalreimbursementdetail = new ProjectNormalReimbursementDetail();
			projectnormalreimbursementdetail.setConditionProjectNormalReimbursementId("=", getProjectNormalReimbursementId());
			setDetailProjectNormalReimbursementDetail(projectnormalreimbursementdetail.conditionalLoad());
			NormalReimbursementLinkMainProject normalreimbursementlinkmainproject = new NormalReimbursementLinkMainProject();
			normalreimbursementlinkmainproject.setConditionProjectNormalReimbursementId("=", getProjectNormalReimbursementId());
			setDetailNormalReimbursementLinkMainProject(normalreimbursementlinkmainproject.conditionalLoad());
		}
		return true;
	}

	public List<BaseProjectNormalReimbursementWithPn> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseProjectNormalReimbursementWithPn> result = BaseProjectNormalReimbursementWithPn.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseProjectNormalReimbursementWithPn generateBaseExt() {
		BaseProjectNormalReimbursementWithPn ____result = new BaseProjectNormalReimbursementWithPn();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseProjectNormalReimbursementWithPn __base) {
		super.setDataFromBase(__base);
		setDetailProjectNormalReimbursementDetail(__base.getDetailProjectNormalReimbursementDetail());
		setDetailNormalReimbursementLinkMainProject(__base.getDetailNormalReimbursementLinkMainProject());
	}

	public void setDataToBase(BaseProjectNormalReimbursementWithPn __base) {
		super.setDataToBase(__base);
		__base.setDetailProjectNormalReimbursementDetail(getDetailProjectNormalReimbursementDetail());
		__base.setDetailNormalReimbursementLinkMainProject(getDetailNormalReimbursementLinkMainProject());
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

	public boolean isDeleteDetailProjectNormalReimbursementDetail() {
		return this.__detail_delete_projectnormalreimbursementdetail;
	}

	public void setDeleteDetailProjectNormalReimbursementDetail( boolean value ) {
		this.__detail_delete_projectnormalreimbursementdetail = value;
	}

	protected boolean __detail_delete_projectnormalreimbursementdetail = true; 
	protected List<BaseProjectNormalReimbursementDetail> __detail_projectnormalreimbursementdetail ; 
	public boolean isDeleteDetailNormalReimbursementLinkMainProject() {
		return this.__detail_delete_normalreimbursementlinkmainproject;
	}

	public void setDeleteDetailNormalReimbursementLinkMainProject( boolean value ) {
		this.__detail_delete_normalreimbursementlinkmainproject = value;
	}

	protected boolean __detail_delete_normalreimbursementlinkmainproject = true; 
	protected List<BaseNormalReimbursementLinkMainProject> __detail_normalreimbursementlinkmainproject ; 
}
