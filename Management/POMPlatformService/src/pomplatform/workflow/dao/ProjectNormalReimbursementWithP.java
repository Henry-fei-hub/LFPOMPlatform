package pomplatform.workflow.dao;

import java.util.*;
import pomplatform.workflow.bean.BaseProjectNormalReimbursementWithP;
import com.pomplatform.db.bean.BaseProjectNormalReimbursementDetail;
import com.pomplatform.db.dao.ProjectNormalReimbursementDetail;

public class ProjectNormalReimbursementWithP extends com.pomplatform.db.dao.ProjectNormalReimbursement
{


	public ProjectNormalReimbursementWithP() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseProjectNormalReimbursementDetail> getDetailProjectNormalReimbursementDetail() {
		return this.__detail_projectnormalreimbursementdetail;
	}

	public void setDetailProjectNormalReimbursementDetail( List<BaseProjectNormalReimbursementDetail> value ) {
		this.__detail_projectnormalreimbursementdetail = value;
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
	}

	private void deleteFromProjectNormalReimbursementDetail(BaseProjectNormalReimbursementDetail bean, ProjectNormalReimbursementDetail dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setProjectNormalReimbursementId(null);
		if(__detail_delete_projectnormalreimbursementdetail) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		ProjectNormalReimbursementDetail projectnormalreimbursementdetail = new ProjectNormalReimbursementDetail();
		projectnormalreimbursementdetail.setConditionProjectNormalReimbursementId("=", getProjectNormalReimbursementId());
		projectnormalreimbursementdetail.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			ProjectNormalReimbursementDetail projectnormalreimbursementdetail = new ProjectNormalReimbursementDetail();
			projectnormalreimbursementdetail.setConditionProjectNormalReimbursementId("=", getProjectNormalReimbursementId());
			setDetailProjectNormalReimbursementDetail(projectnormalreimbursementdetail.conditionalLoad());
		}
		return true;
	}

	public List<BaseProjectNormalReimbursementWithP> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseProjectNormalReimbursementWithP> result = BaseProjectNormalReimbursementWithP.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseProjectNormalReimbursementWithP generateBaseExt() {
		BaseProjectNormalReimbursementWithP ____result = new BaseProjectNormalReimbursementWithP();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseProjectNormalReimbursementWithP __base) {
		super.setDataFromBase(__base);
		setDetailProjectNormalReimbursementDetail(__base.getDetailProjectNormalReimbursementDetail());
	}

	public void setDataToBase(BaseProjectNormalReimbursementWithP __base) {
		super.setDataToBase(__base);
		__base.setDetailProjectNormalReimbursementDetail(getDetailProjectNormalReimbursementDetail());
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
}
