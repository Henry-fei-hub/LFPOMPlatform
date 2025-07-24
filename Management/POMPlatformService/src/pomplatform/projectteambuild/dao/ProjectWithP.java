package pomplatform.projectteambuild.dao;

import java.math.BigDecimal;
import java.util.*;
import pomplatform.projectteambuild.bean.BaseProjectWithP;
import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.dao.ProjectEmployee;

public class ProjectWithP extends com.pomplatform.db.dao.Project
{


	public ProjectWithP() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseProjectEmployee> getDetailProjectEmployee() {
		return this.__detail_projectemployee;
	}

	public void setDetailProjectEmployee( List<BaseProjectEmployee> value ) {
		this.__detail_projectemployee = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// 实例化  DAO
		ProjectEmployee projectemployee = new ProjectEmployee();
		// 删除数据库中原来明细数据
		projectemployee.setConditionProjectId("=", getProjectId());
		projectemployee.conditionalDelete();
		if(getDetailProjectEmployee() != null) {
			for(BaseProjectEmployee __projectemployee : getDetailProjectEmployee() ) {
				// 赋值关联字段
				__projectemployee.setProjectId(getProjectId());
			}
			// 保存子表数据
			projectemployee.save(getDetailProjectEmployee());
		}
	}

	private void deleteFromProjectEmployee(BaseProjectEmployee bean, ProjectEmployee dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setProjectId(null);
		if(__detail_delete_projectemployee) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		ProjectEmployee projectemployee = new ProjectEmployee();
		projectemployee.setConditionProjectId("=", getProjectId());
		projectemployee.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			ProjectEmployee projectemployee = new ProjectEmployee();
			projectemployee.setConditionProjectId("=", getProjectId());
			setDetailProjectEmployee(projectemployee.conditionalLoad(null));
		}
		return true;
	}

	public List<BaseProjectWithP> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseProjectWithP> result = BaseProjectWithP.getBeanList(conditionalLoad(addtional));
		if(result.size() > 0) {
			ProjectEmployee projectemployee = new ProjectEmployee();
			int varCount = 0;
			Object[] convars = new Object[result.size()];
			for(BaseProjectWithP b : result) convars[varCount++] = b.getProjectId();
			projectemployee.addCondition(BaseProjectEmployee.CS_PROJECT_ID, "IN", convars);
			List<BaseProjectEmployee> projectemployees = projectemployee.conditionalLoad(null);
			for(BaseProjectWithP ii : result){ ii.setDetailProjectEmployee(new ArrayList<BaseProjectEmployee>()); }
			for(BaseProjectEmployee mm : projectemployees){
				for(BaseProjectWithP nn : result){
					if(mm.getProjectId().equals(nn.getProjectId())) { nn.getDetailProjectEmployee().add(mm); break; } 
				}
			}
		}
		return result;
	}

	public BaseProjectWithP generateBaseExt() {
		BaseProjectWithP ____result = new BaseProjectWithP();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseProjectWithP __base) {
		super.setDataFromBase(__base);
		setDetailProjectEmployee(__base.getDetailProjectEmployee());
	}

	public void setDataToBase(BaseProjectWithP __base) {
		super.setDataToBase(__base);
		__base.setDetailProjectEmployee(getDetailProjectEmployee());
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

	public boolean isDeleteDetailProjectEmployee() {
		return this.__detail_delete_projectemployee;
	}

	public void setDeleteDetailProjectEmployee( boolean value ) {
		this.__detail_delete_projectemployee = value;
	}

	protected boolean __detail_delete_projectemployee = false; 
	protected List<BaseProjectEmployee> __detail_projectemployee ; 
}
