package pomplatform.workflow.commonNormalReimbursement.dao;

import java.util.ArrayList;
import java.util.List;

import com.pomplatform.db.bean.BaseNormalReimbursementLinkDepartment;
import com.pomplatform.db.bean.BaseProjectNormalReimbursementDetail;
import com.pomplatform.db.dao.NormalReimbursementLinkDepartment;
import com.pomplatform.db.dao.ProjectNormalReimbursementDetail;

import pomplatform.workflow.commonNormalReimbursement.bean.BaseProjectNormalReimbursementWithPn;

public class ProjectNormalReimbursementWithPn extends com.pomplatform.db.dao.ProjectNormalReimbursement
{


	public ProjectNormalReimbursementWithPn() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseProjectNormalReimbursementDetail> getDetailProjectNormalReimbursementDetail() {
		return this.__detail_projectnormalreimbursementdetail;
	}

	public void setDetailProjectNormalReimbursementDetail( List<BaseProjectNormalReimbursementDetail> value ) {
		this.__detail_projectnormalreimbursementdetail = value;
	}

	public List<BaseNormalReimbursementLinkDepartment> getDetailNormalReimbursementLinkDepartment() {
		return this.__detail_normalreimbursementlinkdepartment;
	}

	public void setDetailNormalReimbursementLinkDepartment( List<BaseNormalReimbursementLinkDepartment> value ) {
		this.__detail_normalreimbursementlinkdepartment = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate  DAO
		ProjectNormalReimbursementDetail projectnormalreimbursementdetail = new ProjectNormalReimbursementDetail();
		// load the original details.
		projectnormalreimbursementdetail.setConditionProjectNormalReimbursementId("=", getProjectNormalReimbursementId());
		List<BaseProjectNormalReimbursementDetail> originalprojectnormalreimbursementdetail = projectnormalreimbursementdetail.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailProjectNormalReimbursementDetail() != null) {
			// need to delete list.
			List<BaseProjectNormalReimbursementDetail> needToDeleteProjectNormalReimbursementDetail = new ArrayList<>();
			// need to add list.
			List<BaseProjectNormalReimbursementDetail> needToAddProjectNormalReimbursementDetail = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseProjectNormalReimbursementDetail __projectnormalreimbursementdetail : getDetailProjectNormalReimbursementDetail() ) {
				// set the relative field.
				__projectnormalreimbursementdetail.setProjectNormalReimbursementId( getProjectNormalReimbursementId());
				// set find flag
				boolean foundProjectNormalReimbursementDetail = false;
				// find the original list.
				for(BaseProjectNormalReimbursementDetail __originalprojectnormalreimbursementdetail : originalprojectnormalreimbursementdetail) {
					// if found the original record
					if(__projectnormalreimbursementdetail.compareTo(__originalprojectnormalreimbursementdetail) == 0) {
						// set found flag to true
						foundProjectNormalReimbursementDetail = true;
						// update the record.
						// clear DAO's data
						projectnormalreimbursementdetail.clearCurrentData();
						// set original data into DAO
						projectnormalreimbursementdetail.setDataFromBase(__originalprojectnormalreimbursementdetail);
						// clear DAO modification flag, just like the is loaded from DB
						projectnormalreimbursementdetail.clearModifiedFlags();
						// set current data into DAO
						projectnormalreimbursementdetail.setDataFromBase(__projectnormalreimbursementdetail);
						// execute update
						projectnormalreimbursementdetail.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundProjectNormalReimbursementDetail) needToAddProjectNormalReimbursementDetail.add(__projectnormalreimbursementdetail);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseProjectNormalReimbursementDetail __originalprojectnormalreimbursementdetail : originalprojectnormalreimbursementdetail) {
				boolean foundProjectNormalReimbursementDetail = false;
				for(BaseProjectNormalReimbursementDetail __projectnormalreimbursementdetail : getDetailProjectNormalReimbursementDetail() ) {
					if(__projectnormalreimbursementdetail.compareTo(__originalprojectnormalreimbursementdetail) == 0) {
						foundProjectNormalReimbursementDetail = true;
						break;
				}
				}
				if(!foundProjectNormalReimbursementDetail) needToDeleteProjectNormalReimbursementDetail.add(__originalprojectnormalreimbursementdetail);
			}
			// process need-to-add list
			for(BaseProjectNormalReimbursementDetail __projectnormalreimbursementdetail : needToAddProjectNormalReimbursementDetail ) {
				projectnormalreimbursementdetail.setPrimaryKeyFromBase(__projectnormalreimbursementdetail);
				// if the primay key is null, then insert into DB
				if(projectnormalreimbursementdetail.isPrimaryKeyNull()) { projectnormalreimbursementdetail.clearCurrentData(); projectnormalreimbursementdetail.setDataFromBase(__projectnormalreimbursementdetail); projectnormalreimbursementdetail.save(); }
				// otherwise load and update
				else { if(projectnormalreimbursementdetail.load()) { projectnormalreimbursementdetail.setDataFromBase(__projectnormalreimbursementdetail); projectnormalreimbursementdetail.update(); } else { projectnormalreimbursementdetail.clearCurrentData(); projectnormalreimbursementdetail.setDataFromBase(__projectnormalreimbursementdetail); projectnormalreimbursementdetail.save(); } }
			}
			// process need-to-delete list
			for(BaseProjectNormalReimbursementDetail __projectnormalreimbursementdetail : needToDeleteProjectNormalReimbursementDetail ) {
				deleteFromProjectNormalReimbursementDetail(__projectnormalreimbursementdetail, projectnormalreimbursementdetail);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseProjectNormalReimbursementDetail __projectnormalreimbursementdetail : originalprojectnormalreimbursementdetail ) {
				deleteFromProjectNormalReimbursementDetail(__projectnormalreimbursementdetail, projectnormalreimbursementdetail);
			}
		}
		// instantiate  DAO
		NormalReimbursementLinkDepartment normalreimbursementlinkdepartment = new NormalReimbursementLinkDepartment();
		// load the original details.
		normalreimbursementlinkdepartment.setConditionProjectNormalReimbursementId("=", getProjectNormalReimbursementId());
		List<BaseNormalReimbursementLinkDepartment> originalnormalreimbursementlinkdepartment = normalreimbursementlinkdepartment.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailNormalReimbursementLinkDepartment() != null) {
			// need to delete list.
			List<BaseNormalReimbursementLinkDepartment> needToDeleteNormalReimbursementLinkDepartment = new ArrayList<>();
			// need to add list.
			List<BaseNormalReimbursementLinkDepartment> needToAddNormalReimbursementLinkDepartment = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseNormalReimbursementLinkDepartment __normalreimbursementlinkdepartment : getDetailNormalReimbursementLinkDepartment() ) {
				// set the relative field.
				__normalreimbursementlinkdepartment.setProjectNormalReimbursementId( getProjectNormalReimbursementId());
				// set find flag
				boolean foundNormalReimbursementLinkDepartment = false;
				// find the original list.
				for(BaseNormalReimbursementLinkDepartment __originalnormalreimbursementlinkdepartment : originalnormalreimbursementlinkdepartment) {
					// if found the original record
					if(__normalreimbursementlinkdepartment.compareTo(__originalnormalreimbursementlinkdepartment) == 0) {
						// set found flag to true
						foundNormalReimbursementLinkDepartment = true;
						// update the record.
						// clear DAO's data
						normalreimbursementlinkdepartment.clearCurrentData();
						// set original data into DAO
						normalreimbursementlinkdepartment.setDataFromBase(__originalnormalreimbursementlinkdepartment);
						// clear DAO modification flag, just like the is loaded from DB
						normalreimbursementlinkdepartment.clearModifiedFlags();
						// set current data into DAO
						normalreimbursementlinkdepartment.setDataFromBase(__normalreimbursementlinkdepartment);
						// execute update
						normalreimbursementlinkdepartment.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundNormalReimbursementLinkDepartment) needToAddNormalReimbursementLinkDepartment.add(__normalreimbursementlinkdepartment);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseNormalReimbursementLinkDepartment __originalnormalreimbursementlinkdepartment : originalnormalreimbursementlinkdepartment) {
				boolean foundNormalReimbursementLinkDepartment = false;
				for(BaseNormalReimbursementLinkDepartment __normalreimbursementlinkdepartment : getDetailNormalReimbursementLinkDepartment() ) {
					if(__normalreimbursementlinkdepartment.compareTo(__originalnormalreimbursementlinkdepartment) == 0) {
						foundNormalReimbursementLinkDepartment = true;
						break;
				}
				}
				if(!foundNormalReimbursementLinkDepartment) needToDeleteNormalReimbursementLinkDepartment.add(__originalnormalreimbursementlinkdepartment);
			}
			// process need-to-add list
			for(BaseNormalReimbursementLinkDepartment __normalreimbursementlinkdepartment : needToAddNormalReimbursementLinkDepartment ) {
				normalreimbursementlinkdepartment.setPrimaryKeyFromBase(__normalreimbursementlinkdepartment);
				// if the primay key is null, then insert into DB
				if(normalreimbursementlinkdepartment.isPrimaryKeyNull()) { normalreimbursementlinkdepartment.clearCurrentData(); normalreimbursementlinkdepartment.setDataFromBase(__normalreimbursementlinkdepartment); normalreimbursementlinkdepartment.save(); }
				// otherwise load and update
				else { if(normalreimbursementlinkdepartment.load()) { normalreimbursementlinkdepartment.setDataFromBase(__normalreimbursementlinkdepartment); normalreimbursementlinkdepartment.update(); } else { normalreimbursementlinkdepartment.clearCurrentData(); normalreimbursementlinkdepartment.setDataFromBase(__normalreimbursementlinkdepartment); normalreimbursementlinkdepartment.save(); } }
			}
			// process need-to-delete list
			for(BaseNormalReimbursementLinkDepartment __normalreimbursementlinkdepartment : needToDeleteNormalReimbursementLinkDepartment ) {
				deleteFromNormalReimbursementLinkDepartment(__normalreimbursementlinkdepartment, normalreimbursementlinkdepartment);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseNormalReimbursementLinkDepartment __normalreimbursementlinkdepartment : originalnormalreimbursementlinkdepartment ) {
				deleteFromNormalReimbursementLinkDepartment(__normalreimbursementlinkdepartment, normalreimbursementlinkdepartment);
			}
		}
	}

	private void deleteFromProjectNormalReimbursementDetail(BaseProjectNormalReimbursementDetail bean, ProjectNormalReimbursementDetail dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setProjectNormalReimbursementId(null);
		if(__detail_delete_projectnormalreimbursementdetail) dao.delete(); else dao.update();
	}

	private void deleteFromNormalReimbursementLinkDepartment(BaseNormalReimbursementLinkDepartment bean, NormalReimbursementLinkDepartment dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setProjectNormalReimbursementId(null);
		if(__detail_delete_normalreimbursementlinkdepartment) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		ProjectNormalReimbursementDetail projectnormalreimbursementdetail = new ProjectNormalReimbursementDetail();
		projectnormalreimbursementdetail.setConditionProjectNormalReimbursementId("=", getProjectNormalReimbursementId());
		projectnormalreimbursementdetail.conditionalDelete();
		NormalReimbursementLinkDepartment normalreimbursementlinkdepartment = new NormalReimbursementLinkDepartment();
		normalreimbursementlinkdepartment.setConditionProjectNormalReimbursementId("=", getProjectNormalReimbursementId());
		normalreimbursementlinkdepartment.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			ProjectNormalReimbursementDetail projectnormalreimbursementdetail = new ProjectNormalReimbursementDetail();
			projectnormalreimbursementdetail.setConditionProjectNormalReimbursementId("=", getProjectNormalReimbursementId());
			setDetailProjectNormalReimbursementDetail(projectnormalreimbursementdetail.conditionalLoad());
			NormalReimbursementLinkDepartment normalreimbursementlinkdepartment = new NormalReimbursementLinkDepartment();
			normalreimbursementlinkdepartment.setConditionProjectNormalReimbursementId("=", getProjectNormalReimbursementId());
			setDetailNormalReimbursementLinkDepartment(normalreimbursementlinkdepartment.conditionalLoad());
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
		setDetailNormalReimbursementLinkDepartment(__base.getDetailNormalReimbursementLinkDepartment());
	}

	public void setDataToBase(BaseProjectNormalReimbursementWithPn __base) {
		super.setDataToBase(__base);
		__base.setDetailProjectNormalReimbursementDetail(getDetailProjectNormalReimbursementDetail());
		__base.setDetailNormalReimbursementLinkDepartment(getDetailNormalReimbursementLinkDepartment());
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
	public boolean isDeleteDetailNormalReimbursementLinkDepartment() {
		return this.__detail_delete_normalreimbursementlinkdepartment;
	}

	public void setDeleteDetailNormalReimbursementLinkDepartment( boolean value ) {
		this.__detail_delete_normalreimbursementlinkdepartment = value;
	}

	protected boolean __detail_delete_normalreimbursementlinkdepartment = true; 
	protected List<BaseNormalReimbursementLinkDepartment> __detail_normalreimbursementlinkdepartment ; 
}
