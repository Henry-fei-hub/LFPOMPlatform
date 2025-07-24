package pomplatform.stage.dao;

import java.util.*;

import pomplatform.stage.bean.BaseProjectStageTemplateWithP;
import pomplatform.stage.bean.BaseProjectWithP;
import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.bean.BaseProjectStageTemplate;
import com.pomplatform.db.dao.ProjectStage;
import com.pomplatform.db.dao.ProjectStageTemplate;

import delicacy.common.BaseHelpUtils;

public class ProjectStageTemplateWithP extends com.pomplatform.db.dao.ProjectStageTemplate
{


	public ProjectStageTemplateWithP() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseProjectStageTemplate> getDetailProjectStage() {
		return this.__detail_projectstage;
	}

	public void setDetailProjectStage( List<BaseProjectStageTemplate> value ) {
		this.__detail_projectstage = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// 实例化  DAO
		ProjectStageTemplate projectStageTemplate = new ProjectStageTemplate();
		
		Integer projectTemplateId = getProjectTemplateId();
		int intValue = BaseHelpUtils.getIntValue(projectTemplateId);
		projectStageTemplate.setConditionProjectTemplateId("=",intValue);
		projectStageTemplate.conditionalDelete();
		
		projectStageTemplate.save(getDetailProjectStage());
	}
	private void SaveDetailTables() throws java.sql.SQLException {
		// 实例化  DAO
		ProjectStageTemplate projectStageTemplate = new ProjectStageTemplate();
		
		projectStageTemplate.save(getDetailProjectStage());
	}

/*	private void deleteFromProjectStage(BaseProjectStage bean, ProjectStage dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setProjectId(null);
		if(__detail_delete_projectstage) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		ProjectStage projectstage = new ProjectStage();
		projectstage.setConditionProjectId("=", getProjectId());
		projectstage.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			ProjectStage projectstage = new ProjectStage();
			projectstage.setConditionProjectId("=", getProjectId());
			setDetailProjectStage(projectstage.conditionalLoad(null));
		}
		return true;
	}

	public List<BaseProjectWithP> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseProjectWithP> result = BaseProjectWithP.getBeanList(conditionalLoad(addtional));
		if(result.size() > 0) {
			ProjectStage projectstage = new ProjectStage();
			int varCount = 0;
			Object[] convars = new Object[result.size()];
			for(BaseProjectWithP b : result) convars[varCount++] = b.getProjectId();
			projectstage.addCondition(BaseProjectStage.CS_PROJECT_ID, "IN", convars);
			List<BaseProjectStage> projectstages = projectstage.conditionalLoad(null);
			for(BaseProjectWithP ii : result){ ii.setDetailProjectStage(new ArrayList<BaseProjectStage>()); }
			for(BaseProjectStage mm : projectstages){
				for(BaseProjectWithP nn : result){
					if(mm.getProjectId().equals(nn.getProjectId())) { nn.getDetailProjectStage().add(mm); break; } 
				}
			}
		}
		return result;
	}*/

	public BaseProjectStageTemplateWithP generateBaseExt() {
		BaseProjectStageTemplateWithP ____result = new BaseProjectStageTemplateWithP();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseProjectStageTemplateWithP __base) {
		super.setDataFromBase(__base);
		setDetailProjectStage(__base.getDetailProjectStage());
	}

	public void setDataToBase(BaseProjectStageTemplateWithP __base) {
		super.setDataToBase(__base);
		__base.setDetailProjectStage(getDetailProjectStage());
	}

	@Override
	public int save() throws java.sql.SQLException {

//		if(super.save() == 0) return 0;
		SaveDetailTables();
		return 1;
	}

	@Override
	public int update() throws java.sql.SQLException {

//		super.update();
		deleteAndSaveDetailTables();
		return 1;
	}

/*	@Override
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
	}*/

	public boolean isDeleteDetailProjectStage() {
		return this.__detail_delete_projectstage;
	}

	public void setDeleteDetailProjectStage( boolean value ) {
		this.__detail_delete_projectstage = value;
	}

	protected boolean __detail_delete_projectstage = false; 
	protected List<BaseProjectStageTemplate> __detail_projectstage ; 
}
