package pomplatform.ProjectStages.dao;

import java.util.*;
import pomplatform.ProjectStages.bean.BaseProjectStageProcessRecordWithP;

import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.bean.BaseProjectStageProcessDetail;
import com.pomplatform.db.dao.ProjectStageProcessDetail;

public class ProjectStageProcessRecordWithP extends com.pomplatform.db.dao.ProjectStageProcessRecord
{


	public ProjectStageProcessRecordWithP() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseProjectStageProcessDetail> getDetailProjectStageProcessDetail() {
		return this.__detail_projectstageprocessdetail;
	}

	public void setDetailProjectStageProcessDetail( List<BaseProjectStageProcessDetail> value ) {
		this.__detail_projectstageprocessdetail = value;
	}
	
	public List<BaseProjectStage> getDetailProjectStageDetail() {
		return this.__detail_projectstagedetail;
	}
	
	public void setDetailProjectStageDetail( List<BaseProjectStage> value ) {
		this.__detail_projectstagedetail = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate  DAO
		ProjectStageProcessDetail projectstageprocessdetail = new ProjectStageProcessDetail();
		// load the original detail data.
		projectstageprocessdetail.setConditionProjectStageProcessRecordId("=", getProjectStageProcessRecordId());
		List<BaseProjectStageProcessDetail> originalprojectstageprocessdetail = projectstageprocessdetail.conditionalLoad();
		// if current detail is not empty.
		if(getDetailProjectStageProcessDetail() != null) {
			// need to delete data
			List<BaseProjectStageProcessDetail> needToDeleteProjectStageProcessDetail = new ArrayList<>();
			// need to add data
			List<BaseProjectStageProcessDetail> needToAddProjectStageProcessDetail = new ArrayList<>();
			// find that records need to be modified.
			for(BaseProjectStageProcessDetail __projectstageprocessdetail : getDetailProjectStageProcessDetail() ) {
				// set that related fields.
				__projectstageprocessdetail.setProjectStageProcessRecordId(getProjectStageProcessRecordId());
				// if found then set found flag.
				boolean foundProjectStageProcessDetail = false;
				// search the original detail list.
				for(BaseProjectStageProcessDetail __originalprojectstageprocessdetail : originalprojectstageprocessdetail) {
					// compare the key.
					if(__projectstageprocessdetail.compareTo(__originalprojectstageprocessdetail) == 0) {
						// found the original record.
						foundProjectStageProcessDetail = true;
						//update the record
						// clear DAO's data
						projectstageprocessdetail.clearCurrentData();
						// set original bean data into DAO
						projectstageprocessdetail.setDataFromBase(__originalprojectstageprocessdetail);
						// clear DAO data modification flags, just like the data reloaded from DB.
						projectstageprocessdetail.clearModifiedFlags();
						// set the current data into DAO
						projectstageprocessdetail.setDataFromBase(__projectstageprocessdetail);
						// execute update 
						projectstageprocessdetail.update();
						break;
					}
				}
				// if the data not found in the original list, then add to the need-to-add list.
				if(!foundProjectStageProcessDetail) needToAddProjectStageProcessDetail.add(__projectstageprocessdetail);
			}
			// find the record that in the original list but not in the current list.
			for(BaseProjectStageProcessDetail __originalprojectstageprocessdetail : originalprojectstageprocessdetail) {
				boolean foundProjectStageProcessDetail = false;
				for(BaseProjectStageProcessDetail __projectstageprocessdetail : getDetailProjectStageProcessDetail() ) {
					if(__projectstageprocessdetail.compareTo(__originalprojectstageprocessdetail) == 0) {
						foundProjectStageProcessDetail = true;
						break;
				}
				}
				if(!foundProjectStageProcessDetail) needToDeleteProjectStageProcessDetail.add(__originalprojectstageprocessdetail);
			}
			// process need-to-delete list.
			for(BaseProjectStageProcessDetail __projectstageprocessdetail : needToDeleteProjectStageProcessDetail ) {
				deleteFromProjectStageProcessDetail(__projectstageprocessdetail, projectstageprocessdetail);
			}
			// process need-to-add list. insert into DB.
			for(BaseProjectStageProcessDetail __projectstageprocessdetail : needToAddProjectStageProcessDetail ) {
				projectstageprocessdetail.clearCurrentData();
				projectstageprocessdetail.setDataFromBase(__projectstageprocessdetail);
				projectstageprocessdetail.save();
				__projectstageprocessdetail.setProjectStageProcessDetailId(projectstageprocessdetail.getProjectStageProcessDetailId());
			}
		} else {
			// if current list is empty. then delete all the original details.
			for(BaseProjectStageProcessDetail __projectstageprocessdetail : originalprojectstageprocessdetail ) {
				deleteFromProjectStageProcessDetail(__projectstageprocessdetail, projectstageprocessdetail);
			}
		}
	}

	private void deleteFromProjectStageProcessDetail(BaseProjectStageProcessDetail bean, ProjectStageProcessDetail dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setProjectStageProcessRecordId(null);
		if(__detail_delete_projectstageprocessdetail) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		ProjectStageProcessDetail projectstageprocessdetail = new ProjectStageProcessDetail();
		projectstageprocessdetail.setConditionProjectStageProcessRecordId("=", getProjectStageProcessRecordId());
		projectstageprocessdetail.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			ProjectStageProcessDetail projectstageprocessdetail = new ProjectStageProcessDetail();
			projectstageprocessdetail.setConditionProjectStageProcessRecordId("=", getProjectStageProcessRecordId());
			setDetailProjectStageProcessDetail(projectstageprocessdetail.conditionalLoad());
		}
		return true;
	}

	public List<BaseProjectStageProcessRecordWithP> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseProjectStageProcessRecordWithP> result = BaseProjectStageProcessRecordWithP.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseProjectStageProcessRecordWithP generateBaseExt() {
		BaseProjectStageProcessRecordWithP ____result = new BaseProjectStageProcessRecordWithP();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseProjectStageProcessRecordWithP __base) {
		super.setDataFromBase(__base);
		setDetailProjectStageProcessDetail(__base.getDetailProjectStageProcessDetail());
	}

	public void setDataToBase(BaseProjectStageProcessRecordWithP __base) {
		super.setDataToBase(__base);
		__base.setDetailProjectStageProcessDetail(getDetailProjectStageProcessDetail());
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

	public boolean isDeleteDetailProjectStageProcessDetail() {
		return this.__detail_delete_projectstageprocessdetail;
	}

	public void setDeleteDetailProjectStageProcessDetail( boolean value ) {
		this.__detail_delete_projectstageprocessdetail = value;
	}

	protected boolean __detail_delete_projectstageprocessdetail = true; 
	protected List<BaseProjectStageProcessDetail> __detail_projectstageprocessdetail ; 
	
	protected List<BaseProjectStage> __detail_projectstagedetail ; 

}
