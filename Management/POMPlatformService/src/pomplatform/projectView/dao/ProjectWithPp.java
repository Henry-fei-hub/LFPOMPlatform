package pomplatform.projectView.dao;

import java.util.*;
import pomplatform.projectView.bean.BaseProjectWithPp;
import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.dao.ProjectEmployee;
import com.pomplatform.db.bean.BaseProjectCost;
import com.pomplatform.db.dao.ProjectCost;

public class ProjectWithPp extends com.pomplatform.db.dao.Project
{


	public ProjectWithPp() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseProjectEmployee> getDetailProjectEmployee() {
		return this.__detail_projectemployee;
	}

	public void setDetailProjectEmployee( List<BaseProjectEmployee> value ) {
		this.__detail_projectemployee = value;
	}

	public List<BaseProjectCost> getDetailProjectCost() {
		return this.__detail_projectcost;
	}

	public void setDetailProjectCost( List<BaseProjectCost> value ) {
		this.__detail_projectcost = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// 实例化  DAO
		ProjectEmployee projectemployee = new ProjectEmployee();
		// 装入数据库中原来明细数据
		projectemployee.setConditionProjectId("=", getProjectId());
		List<BaseProjectEmployee> originalprojectemployee = projectemployee.conditionalLoad(null);
		// 如果当前明细不为空
		if(getDetailProjectEmployee() != null) {
			// 需要删除的明细数据
			List<BaseProjectEmployee> needToDeleteProjectEmployee = new ArrayList<>();
			// 需要增加的明细数据
			List<BaseProjectEmployee> needToAddProjectEmployee = new ArrayList<>();
			// 找到在原明细中存在的数据并修改该数据，如果在原数据中没有则加到需要添加的列表中
			for(BaseProjectEmployee __projectemployee : getDetailProjectEmployee() ) {
				// 赋值关联字段
				__projectemployee.setProjectId( getProjectId());
				// 设置找到标志
				boolean foundProjectEmployee = false;
				// 在原明细中找
				for(BaseProjectEmployee __originalprojectemployee : originalprojectemployee) {
					// 如果两个对象主键相同
					if(__projectemployee.compareTo(__originalprojectemployee) == 0) {
						// 设置找到标志
						foundProjectEmployee = true;
						// 修改该条数据
						// 清空DAO中当前数据
						projectemployee.clearCurrentData();
						// 把原明细数据装入DAO
						projectemployee.setDataFromBase(__originalprojectemployee);
						// 清空DAO数据修改标志, 就像数据刚从数据库中装入一样
						projectemployee.clearModifiedFlags();
						// 把新的数据装入
						projectemployee.setDataFromBase(__projectemployee);
						// 执行修改
						projectemployee.update();
						break;
					}
				}
				// 如果没找到，则加入需要增加的列表中
				if(!foundProjectEmployee) needToAddProjectEmployee.add(__projectemployee);
			}
			// 找到那些在原明细中有，但当前明细中没有的条目
			for(BaseProjectEmployee __originalprojectemployee : originalprojectemployee) {
				boolean foundProjectEmployee = false;
				for(BaseProjectEmployee __projectemployee : getDetailProjectEmployee() ) {
					if(__projectemployee.compareTo(__originalprojectemployee) == 0) {
						foundProjectEmployee = true;
						break;
				}
				}
				if(!foundProjectEmployee) needToDeleteProjectEmployee.add(__originalprojectemployee);
			}
			// 处理需要增加的明细数据
			for(BaseProjectEmployee __projectemployee : needToAddProjectEmployee ) {
				projectemployee.setPrimaryKeyFromBase(__projectemployee);
				// 如果该条数据主键为空，则插入数据, 注意这种处理方式只对子表主键为自增的有效
				// 如果子表的主键不是自增类型，则需要考虑如何生成主键, 并修改下面的代码
				if(projectemployee.isPrimaryKeyNull()) { projectemployee.clearCurrentData(); projectemployee.setDataFromBase(__projectemployee); projectemployee.save(); }
				// 否则从数据中查询该数据，找到就修改，否则插入
				else { if(projectemployee.load()) { projectemployee.setDataFromBase(__projectemployee); projectemployee.update(); } else { projectemployee.clearCurrentData(); projectemployee.setDataFromBase(__projectemployee); projectemployee.save(); } }
			}
			// 处理需要删除的明细数据
			for(BaseProjectEmployee __projectemployee : needToDeleteProjectEmployee ) {
				deleteFromProjectEmployee(__projectemployee, projectemployee);
			}
		} else {
			// 如果当前明细为空，说明所有原有的明细都需要删除
			for(BaseProjectEmployee __projectemployee : originalprojectemployee ) {
				deleteFromProjectEmployee(__projectemployee, projectemployee);
			}
		}
		// 实例化  DAO
		ProjectCost projectcost = new ProjectCost();
		// 装入数据库中原来明细数据
		projectcost.setConditionProjectId("=", getProjectId());
		List<BaseProjectCost> originalprojectcost = projectcost.conditionalLoad(null);
		// 如果当前明细不为空
		if(getDetailProjectCost() != null) {
			// 需要删除的明细数据
			List<BaseProjectCost> needToDeleteProjectCost = new ArrayList<>();
			// 需要增加的明细数据
			List<BaseProjectCost> needToAddProjectCost = new ArrayList<>();
			// 找到在原明细中存在的数据并修改该数据，如果在原数据中没有则加到需要添加的列表中
			for(BaseProjectCost __projectcost : getDetailProjectCost() ) {
				// 赋值关联字段
				__projectcost.setProjectId( getProjectId());
				// 设置找到标志
				boolean foundProjectCost = false;
				// 在原明细中找
				for(BaseProjectCost __originalprojectcost : originalprojectcost) {
					// 如果两个对象主键相同
					if(__projectcost.compareTo(__originalprojectcost) == 0) {
						// 设置找到标志
						foundProjectCost = true;
						// 修改该条数据
						// 清空DAO中当前数据
						projectcost.clearCurrentData();
						// 把原明细数据装入DAO
						projectcost.setDataFromBase(__originalprojectcost);
						// 清空DAO数据修改标志, 就像数据刚从数据库中装入一样
						projectcost.clearModifiedFlags();
						// 把新的数据装入
						projectcost.setDataFromBase(__projectcost);
						// 执行修改
						projectcost.update();
						break;
					}
				}
				// 如果没找到，则加入需要增加的列表中
				if(!foundProjectCost) needToAddProjectCost.add(__projectcost);
			}
			// 找到那些在原明细中有，但当前明细中没有的条目
			for(BaseProjectCost __originalprojectcost : originalprojectcost) {
				boolean foundProjectCost = false;
				for(BaseProjectCost __projectcost : getDetailProjectCost() ) {
					if(__projectcost.compareTo(__originalprojectcost) == 0) {
						foundProjectCost = true;
						break;
				}
				}
				if(!foundProjectCost) needToDeleteProjectCost.add(__originalprojectcost);
			}
			// 处理需要增加的明细数据
			for(BaseProjectCost __projectcost : needToAddProjectCost ) {
				projectcost.setPrimaryKeyFromBase(__projectcost);
				// 如果该条数据主键为空，则插入数据, 注意这种处理方式只对子表主键为自增的有效
				// 如果子表的主键不是自增类型，则需要考虑如何生成主键, 并修改下面的代码
				if(projectcost.isPrimaryKeyNull()) { projectcost.clearCurrentData(); projectcost.setDataFromBase(__projectcost); projectcost.save(); }
				// 否则从数据中查询该数据，找到就修改，否则插入
				else { if(projectcost.load()) { projectcost.setDataFromBase(__projectcost); projectcost.update(); } else { projectcost.clearCurrentData(); projectcost.setDataFromBase(__projectcost); projectcost.save(); } }
			}
			// 处理需要删除的明细数据
			for(BaseProjectCost __projectcost : needToDeleteProjectCost ) {
				deleteFromProjectCost(__projectcost, projectcost);
			}
		} else {
			// 如果当前明细为空，说明所有原有的明细都需要删除
			for(BaseProjectCost __projectcost : originalprojectcost ) {
				deleteFromProjectCost(__projectcost, projectcost);
			}
		}
	}

	private void deleteFromProjectEmployee(BaseProjectEmployee bean, ProjectEmployee dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setProjectId(null);
		if(__detail_delete_projectemployee) dao.delete(); else dao.update();
	}

	private void deleteFromProjectCost(BaseProjectCost bean, ProjectCost dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setProjectId(null);
		if(__detail_delete_projectcost) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		ProjectEmployee projectemployee = new ProjectEmployee();
		projectemployee.setConditionProjectId("=", getProjectId());
		projectemployee.conditionalDelete();
		ProjectCost projectcost = new ProjectCost();
		projectcost.setConditionProjectId("=", getProjectId());
		projectcost.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			ProjectEmployee projectemployee = new ProjectEmployee();
			projectemployee.setConditionProjectId("=", getProjectId());
			setDetailProjectEmployee(projectemployee.conditionalLoad(null));
			ProjectCost projectcost = new ProjectCost();
			projectcost.setConditionProjectId("=", getProjectId());
			setDetailProjectCost(projectcost.conditionalLoad(null));
		}
		return true;
	}

	public List<BaseProjectWithPp> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseProjectWithPp> result = BaseProjectWithPp.getBeanList(conditionalLoad(addtional));
		if(result.size() > 0) {
			ProjectEmployee projectemployee = new ProjectEmployee();
			int varCount = 0;
			Object[] convars = new Object[result.size()];
			for(BaseProjectWithPp b : result) convars[varCount++] = b.getProjectId();
			projectemployee.addCondition(BaseProjectEmployee.CS_PROJECT_ID, "IN", convars);
			List<BaseProjectEmployee> projectemployees = projectemployee.conditionalLoad(null);
			for(BaseProjectWithPp ii : result){ ii.setDetailProjectEmployee(new ArrayList<BaseProjectEmployee>()); }
			for(BaseProjectEmployee mm : projectemployees){
				for(BaseProjectWithPp nn : result){
					if(mm.getProjectId().equals(nn.getProjectId())) { nn.getDetailProjectEmployee().add(mm); break; } 
				}
			}
			ProjectCost projectcost = new ProjectCost();
			projectcost.addCondition(BaseProjectCost.CS_PROJECT_ID, "IN", convars);
			List<BaseProjectCost> projectcosts = projectcost.conditionalLoad(null);
			for(BaseProjectWithPp ii : result){ ii.setDetailProjectCost(new ArrayList<BaseProjectCost>()); }
			for(BaseProjectCost mm : projectcosts){
				for(BaseProjectWithPp nn : result){
					if(mm.getProjectId().equals(nn.getProjectId())) { nn.getDetailProjectCost().add(mm); break; } 
				}
			}
		}
		return result;
	}

	public BaseProjectWithPp generateBaseExt() {
		BaseProjectWithPp ____result = new BaseProjectWithPp();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseProjectWithPp __base) {
		super.setDataFromBase(__base);
		setDetailProjectEmployee(__base.getDetailProjectEmployee());
		setDetailProjectCost(__base.getDetailProjectCost());
	}

	public void setDataToBase(BaseProjectWithPp __base) {
		super.setDataToBase(__base);
		__base.setDetailProjectEmployee(getDetailProjectEmployee());
		__base.setDetailProjectCost(getDetailProjectCost());
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
	public boolean isDeleteDetailProjectCost() {
		return this.__detail_delete_projectcost;
	}

	public void setDeleteDetailProjectCost( boolean value ) {
		this.__detail_delete_projectcost = value;
	}

	protected boolean __detail_delete_projectcost = false; 
	protected List<BaseProjectCost> __detail_projectcost ; 
}
