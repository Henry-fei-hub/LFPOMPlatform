package pomplatform.stage.dao;

import java.util.*;
import pomplatform.stage.bean.BaseProjectStageStorageWithP;
import com.pomplatform.db.bean.BaseProjectStageStorage;
import com.pomplatform.db.dao.ProjectStage;
import com.pomplatform.db.dao.ProjectStageStorage;

public class ProjectStageStorageWithP extends com.pomplatform.db.dao.Project
{


	public ProjectStageStorageWithP() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseProjectStageStorage> getDetailProjectStage() {
		return this.__detail_projectstage;
	}

	public void setDetailProjectStage( List<BaseProjectStageStorage> value ) {
		this.__detail_projectstage = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// 实例化  DAO
		ProjectStageStorage projectstage = new ProjectStageStorage();
        ProjectStage projectStageDao =new ProjectStage();
        
        //1 删除project_stages 的数据 (不删除已经确认的阶段)
/*        projectStageDao.setConditionProjectId("=", getProjectId());
        projectStageDao.conditionalDelete();*/
		
        //2 新增数据到 project_stage_storages
		projectstage.setConditionProjectId("=", getProjectId());
		projectstage.conditionalDelete();
		if(getDetailProjectStage() != null) {
			for(BaseProjectStageStorage __projectstage : getDetailProjectStage() ) {
				// 赋值关联字段
				__projectstage.setProjectId(getProjectId());
			}
			// 保存子表数据
			projectstage.save(getDetailProjectStage());
		}
	}
	

	private void deleteFromProjectStage(BaseProjectStageStorage bean, ProjectStageStorage dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setProjectId(null);
		if(__detail_delete_projectstage) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		ProjectStageStorage projectstage = new ProjectStageStorage();
		projectstage.setConditionProjectId("=", getProjectId());
		projectstage.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			ProjectStageStorage projectstage = new ProjectStageStorage();
			projectstage.setConditionProjectId("=", getProjectId());
			setDetailProjectStage(projectstage.conditionalLoad(null));
		}
		return true;
	}

	public List<BaseProjectStageStorageWithP> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseProjectStageStorageWithP> result = BaseProjectStageStorageWithP.getBeanList(conditionalLoad(addtional));
		if(result.size() > 0) {
			ProjectStageStorage projectstage = new ProjectStageStorage();
			int varCount = 0;
			Object[] convars = new Object[result.size()];
			for(BaseProjectStageStorageWithP b : result) convars[varCount++] = b.getProjectId();
			projectstage.addCondition(BaseProjectStageStorage.CS_PROJECT_ID, "IN", convars);
			List<BaseProjectStageStorage> projectstages = projectstage.conditionalLoad(null);
			for(BaseProjectStageStorageWithP ii : result){ ii.setDetailProjectStage(new ArrayList<BaseProjectStageStorage>()); }
			for(BaseProjectStageStorage mm : projectstages){
				for(BaseProjectStageStorageWithP nn : result){
					if(mm.getProjectId().equals(nn.getProjectId())) { nn.getDetailProjectStage().add(mm); break; } 
				}
			}
		}
		return result;
	}

	public BaseProjectStageStorageWithP generateBaseExt() {
		BaseProjectStageStorageWithP ____result = new BaseProjectStageStorageWithP();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseProjectStageStorageWithP __base) {
		super.setDataFromBase(__base);
		setDetailProjectStage(__base.getDetailProjectStage());
	}

	public void setDataToBase(BaseProjectStageStorageWithP __base) {
		super.setDataToBase(__base);
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

	public boolean isDeleteDetailProjectStage() {
		return this.__detail_delete_projectstage;
	}

	public void setDeleteDetailProjectStage( boolean value ) {
		this.__detail_delete_projectstage = value;
	}

	protected boolean __detail_delete_projectstage = false; 
	protected List<BaseProjectStageStorage> __detail_projectstage ; 
}
