package pomplatform.employee.dao;

import java.util.ArrayList;
import java.util.List;

import com.pomplatform.db.bean.BaseEmployeeRole;
import com.pomplatform.db.dao.EmployeeRole;

import delicacy.system.dao.Employee;
import pomplatform.employee.bean.BaseEmployeeWithE;

public class EmployeeWithE extends Employee
{


	public EmployeeWithE() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseEmployeeRole> getDetailEmployeeRole() {
		return this.__detail_employeerole;
	}

	public void setDetailEmployeeRole( List<BaseEmployeeRole> value ) {
		this.__detail_employeerole = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// 实例化  DAO
		EmployeeRole employeerole = new EmployeeRole();
		// 装入数据库中原来明细数据
		employeerole.setConditionEmployeeId("=", getEmployeeId());
		List<BaseEmployeeRole> originalemployeerole = employeerole.conditionalLoad(null);
		// 如果当前明细不为空
		if(getDetailEmployeeRole() != null) {
			// 需要删除的明细数据
			List<BaseEmployeeRole> needToDeleteEmployeeRole = new ArrayList<>();
			// 需要增加的明细数据
			List<BaseEmployeeRole> needToAddEmployeeRole = new ArrayList<>();
			// 找到在原明细中存在的数据并修改该数据，如果在原数据中没有则加到需要添加的列表中
			for(BaseEmployeeRole __employeerole : getDetailEmployeeRole() ) {
				// 赋值关联字段
				__employeerole.setEmployeeId( getEmployeeId());
				// 设置找到标志
				boolean foundEmployeeRole = false;
				// 在原明细中找
				for(BaseEmployeeRole __originalemployeerole : originalemployeerole) {
					// 如果两个对象主键相同
					if(__employeerole.compareTo(__originalemployeerole) == 0) {
						// 设置找到标志
						foundEmployeeRole = true;
						// 修改该条数据
						// 清空DAO中当前数据
						employeerole.clearCurrentData();
						// 把原明细数据装入DAO
						employeerole.setDataFromBase(__originalemployeerole);
						// 清空DAO数据修改标志, 就像数据刚从数据库中装入一样
						employeerole.clearModifiedFlags();
						// 把新的数据装入
						employeerole.setDataFromBase(__employeerole);
						// 执行修改
						employeerole.update();
						break;
					}
				}
				// 如果没找到，则加入需要增加的列表中
				if(!foundEmployeeRole) needToAddEmployeeRole.add(__employeerole);
			}
			// 找到那些在原明细中有，但当前明细中没有的条目
			for(BaseEmployeeRole __originalemployeerole : originalemployeerole) {
				boolean foundEmployeeRole = false;
				for(BaseEmployeeRole __employeerole : getDetailEmployeeRole() ) {
					if(__employeerole.compareTo(__originalemployeerole) == 0) {
						foundEmployeeRole = true;
						break;
				}
				}
				if(!foundEmployeeRole) needToDeleteEmployeeRole.add(__originalemployeerole);
			}
			// 处理需要增加的明细数据
			for(BaseEmployeeRole __employeerole : needToAddEmployeeRole ) {
				employeerole.setPrimaryKeyFromBase(__employeerole);
				// 如果该条数据主键为空，则插入数据, 注意这种处理方式只对子表主键为自增的有效
				// 如果子表的主键不是自增类型，则需要考虑如何生成主键, 并修改下面的代码
				if(employeerole.isPrimaryKeyNull()) { employeerole.clearCurrentData(); employeerole.setDataFromBase(__employeerole); employeerole.save(); }
				// 否则从数据中查询该数据，找到就修改，否则插入
				else { if(employeerole.load()) { employeerole.setDataFromBase(__employeerole); employeerole.update(); } else { employeerole.clearCurrentData(); employeerole.setDataFromBase(__employeerole); employeerole.save(); } }
			}
			// 处理需要删除的明细数据
			for(BaseEmployeeRole __employeerole : needToDeleteEmployeeRole ) {
				deleteFromEmployeeRole(__employeerole, employeerole);
			}
		} else {
			// 如果当前明细为空，说明所有原有的明细都需要删除
			for(BaseEmployeeRole __employeerole : originalemployeerole ) {
				deleteFromEmployeeRole(__employeerole, employeerole);
			}
		}
	}

	private void deleteFromEmployeeRole(BaseEmployeeRole bean, EmployeeRole dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setEmployeeId(null);
		if(__detail_delete_employeerole) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		EmployeeRole employeerole = new EmployeeRole();
		employeerole.setConditionEmployeeId("=", getEmployeeId());
		employeerole.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			EmployeeRole employeerole = new EmployeeRole();
			employeerole.setConditionEmployeeId("=", getEmployeeId());
			setDetailEmployeeRole(employeerole.conditionalLoad(null));
		}
		return true;
	}

	public List<BaseEmployeeWithE> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseEmployeeWithE> result = BaseEmployeeWithE.getBeanList(conditionalLoad(addtional));
		if(result.size() > 0) {
			EmployeeRole employeerole = new EmployeeRole();
			int varCount = 0;
			Object[] convars = new Object[result.size()];
			for(BaseEmployeeWithE b : result) convars[varCount++] = b.getEmployeeId();
			employeerole.addCondition(BaseEmployeeRole.CS_EMPLOYEE_ID, "IN", convars);
			List<BaseEmployeeRole> employeeroles = employeerole.conditionalLoad(null);
			for(BaseEmployeeWithE ii : result){ ii.setDetailEmployeeRole(new ArrayList<BaseEmployeeRole>()); }
			for(BaseEmployeeRole mm : employeeroles){
				for(BaseEmployeeWithE nn : result){
					if(mm.getEmployeeId().equals(nn.getEmployeeId())) { nn.getDetailEmployeeRole().add(mm); break; } 
				}
			}
		}
		return result;
	}

	public BaseEmployeeWithE generateBaseExt() {
		BaseEmployeeWithE ____result = new BaseEmployeeWithE();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseEmployeeWithE __base) {
		super.setDataFromBase(__base);
		setDetailEmployeeRole(__base.getDetailEmployeeRole());
	}

	public void setDataToBase(BaseEmployeeWithE __base) {
		super.setDataToBase(__base);
		__base.setDetailEmployeeRole(getDetailEmployeeRole());
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

	public boolean isDeleteDetailEmployeeRole() {
		return this.__detail_delete_employeerole;
	}

	public void setDeleteDetailEmployeeRole( boolean value ) {
		this.__detail_delete_employeerole = value;
	}

	protected boolean __detail_delete_employeerole = false; 
	protected List<BaseEmployeeRole> __detail_employeerole ; 
}
