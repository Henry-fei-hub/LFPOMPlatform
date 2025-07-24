package pomplatform.approveProjectStageStorage.dao;

import java.util.*;
import pomplatform.approveProjectStageStorage.bean.BaseApproveProjectStageStorageWithPp;
import com.pomplatform.db.bean.BaseProjectStageStorage;
import com.pomplatform.db.dao.ProjectStageStorage;
import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.dao.ProjectStage;

public class ApproveProjectStageStorageWithPp extends com.pomplatform.db.dao.ApproveProjectStageStorage
{


	public ApproveProjectStageStorageWithPp() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseProjectStageStorage> getDetailProjectStageStorage() {
		return this.__detail_projectstagestorage;
	}

	public void setDetailProjectStageStorage( List<BaseProjectStageStorage> value ) {
		this.__detail_projectstagestorage = value;
	}

	public List<BaseProjectStage> getDetailProjectStage() {
		return this.__detail_projectstage;
	}

	public void setDetailProjectStage( List<BaseProjectStage> value ) {
		this.__detail_projectstage = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate --项目阶段记录表 DAO
		ProjectStageStorage projectstagestorage = new ProjectStageStorage();
		// load the original details.
		projectstagestorage.setConditionProjectId("=", getProjectId());
		List<BaseProjectStageStorage> originalprojectstagestorage = projectstagestorage.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailProjectStageStorage() != null) {
			// need to delete list.
			List<BaseProjectStageStorage> needToDeleteProjectStageStorage = new ArrayList<>();
			// need to add list.
			List<BaseProjectStageStorage> needToAddProjectStageStorage = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseProjectStageStorage __projectstagestorage : getDetailProjectStageStorage() ) {
				// set the relative field.
				__projectstagestorage.setProjectId( getProjectId());
				// set find flag
				boolean foundProjectStageStorage = false;
				// find the original list.
				for(BaseProjectStageStorage __originalprojectstagestorage : originalprojectstagestorage) {
					// if found the original record
					if(__projectstagestorage.compareTo(__originalprojectstagestorage) == 0) {
						// set found flag to true
						foundProjectStageStorage = true;
						// update the record.
						// clear DAO's data
						projectstagestorage.clearCurrentData();
						// set original data into DAO
						projectstagestorage.setDataFromBase(__originalprojectstagestorage);
						// clear DAO modification flag, just like the is loaded from DB
						projectstagestorage.clearModifiedFlags();
						// set current data into DAO
						projectstagestorage.setDataFromBase(__projectstagestorage);
						// execute update
						projectstagestorage.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundProjectStageStorage) needToAddProjectStageStorage.add(__projectstagestorage);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseProjectStageStorage __originalprojectstagestorage : originalprojectstagestorage) {
				boolean foundProjectStageStorage = false;
				for(BaseProjectStageStorage __projectstagestorage : getDetailProjectStageStorage() ) {
					if(__projectstagestorage.compareTo(__originalprojectstagestorage) == 0) {
						foundProjectStageStorage = true;
						break;
				}
				}
				if(!foundProjectStageStorage) needToDeleteProjectStageStorage.add(__originalprojectstagestorage);
			}
			// process need-to-add list
			for(BaseProjectStageStorage __projectstagestorage : needToAddProjectStageStorage ) {
				projectstagestorage.clearCurrentData();
				projectstagestorage.setDataFromBase(__projectstagestorage);
				projectstagestorage.save();
				__projectstagestorage.setProjectStageStorageId(projectstagestorage.getProjectStageStorageId());
			}
			// process need-to-delete list
			for(BaseProjectStageStorage __projectstagestorage : needToDeleteProjectStageStorage ) {
				deleteFromProjectStageStorage(__projectstagestorage, projectstagestorage);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseProjectStageStorage __projectstagestorage : originalprojectstagestorage ) {
				deleteFromProjectStageStorage(__projectstagestorage, projectstagestorage);
			}
		}
		// instantiate  DAO
		ProjectStage projectstage = new ProjectStage();
		// load the original details.
		projectstage.setConditionProjectId("=", getProjectId());
		List<BaseProjectStage> originalprojectstage = projectstage.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailProjectStage() != null) {
			// need to delete list.
			List<BaseProjectStage> needToDeleteProjectStage = new ArrayList<>();
			// need to add list.
			List<BaseProjectStage> needToAddProjectStage = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseProjectStage __projectstage : getDetailProjectStage() ) {
				// set the relative field.
				__projectstage.setProjectId( getProjectId());
				// set find flag
				boolean foundProjectStage = false;
				// find the original list.
				for(BaseProjectStage __originalprojectstage : originalprojectstage) {
					// if found the original record
					if(__projectstage.compareTo(__originalprojectstage) == 0) {
						// set found flag to true
						foundProjectStage = true;
						// update the record.
						// clear DAO's data
						projectstage.clearCurrentData();
						// set original data into DAO
						projectstage.setDataFromBase(__originalprojectstage);
						// clear DAO modification flag, just like the is loaded from DB
						projectstage.clearModifiedFlags();
						// set current data into DAO
						projectstage.setDataFromBase(__projectstage);
						// execute update
						projectstage.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundProjectStage) needToAddProjectStage.add(__projectstage);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseProjectStage __originalprojectstage : originalprojectstage) {
				boolean foundProjectStage = false;
				for(BaseProjectStage __projectstage : getDetailProjectStage() ) {
					if(__projectstage.compareTo(__originalprojectstage) == 0) {
						foundProjectStage = true;
						break;
				}
				}
				if(!foundProjectStage) needToDeleteProjectStage.add(__originalprojectstage);
			}
			// process need-to-add list
			for(BaseProjectStage __projectstage : needToAddProjectStage ) {
				projectstage.clearCurrentData();
				projectstage.setDataFromBase(__projectstage);
				projectstage.save();
				__projectstage.setProjectStageId(projectstage.getProjectStageId());
			}
			// process need-to-delete list
			for(BaseProjectStage __projectstage : needToDeleteProjectStage ) {
				deleteFromProjectStage(__projectstage, projectstage);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseProjectStage __projectstage : originalprojectstage ) {
				deleteFromProjectStage(__projectstage, projectstage);
			}
		}
	}
	
	
	private void deleteStageStoragesAndSaveStagesDetailTables() throws java.sql.SQLException { 
		
		
		
		
		}
	
	
	

	private void deleteFromProjectStageStorage(BaseProjectStageStorage bean, ProjectStageStorage dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setProjectId(null);
		if(__detail_delete_projectstagestorage) dao.delete(); else dao.update();
	}

	private void deleteFromProjectStage(BaseProjectStage bean, ProjectStage dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setProjectId(null);
		if(__detail_delete_projectstage) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		ProjectStageStorage projectstagestorage = new ProjectStageStorage();
		projectstagestorage.setConditionProjectId("=", getProjectId());
		projectstagestorage.conditionalDelete();
		ProjectStage projectstage = new ProjectStage();
		projectstage.setConditionProjectId("=", getProjectId());
		projectstage.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			ProjectStageStorage projectstagestorage = new ProjectStageStorage();
			projectstagestorage.setConditionProjectId("=", getProjectId());
			setDetailProjectStageStorage(projectstagestorage.conditionalLoad());
			ProjectStage projectstage = new ProjectStage();
			projectstage.setConditionProjectId("=", getProjectId());
			setDetailProjectStage(projectstage.conditionalLoad());
		}
		return true;
	}

	public List<BaseApproveProjectStageStorageWithPp> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseApproveProjectStageStorageWithPp> result = BaseApproveProjectStageStorageWithPp.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseApproveProjectStageStorageWithPp generateBaseExt() {
		BaseApproveProjectStageStorageWithPp ____result = new BaseApproveProjectStageStorageWithPp();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseApproveProjectStageStorageWithPp __base) {
		super.setDataFromBase(__base);
		setDetailProjectStageStorage(__base.getDetailProjectStageStorage());
		setDetailProjectStage(__base.getDetailProjectStage());
	}

	public void setDataToBase(BaseApproveProjectStageStorageWithPp __base) {
		super.setDataToBase(__base);
		__base.setDetailProjectStageStorage(getDetailProjectStageStorage());
		__base.setDetailProjectStage(getDetailProjectStage());
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
//		deleteAndSaveDetailTables();
		deleteStageStoragesAndSaveStagesDetailTables();
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

	public boolean isDeleteDetailProjectStageStorage() {
		return this.__detail_delete_projectstagestorage;
	}

	public void setDeleteDetailProjectStageStorage( boolean value ) {
		this.__detail_delete_projectstagestorage = value;
	}

	protected boolean __detail_delete_projectstagestorage = true; 
	protected List<BaseProjectStageStorage> __detail_projectstagestorage ; 
	public boolean isDeleteDetailProjectStage() {
		return this.__detail_delete_projectstage;
	}

	public void setDeleteDetailProjectStage( boolean value ) {
		this.__detail_delete_projectstage = value;
	}

	protected boolean __detail_delete_projectstage = true; 
	protected List<BaseProjectStage> __detail_projectstage ; 
}
