package pomplatform.personnelbusiness.dao;

import java.util.*;
import pomplatform.personnelbusiness.bean.BasePersonnelBusinesWithP;
import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.dao.ProjectEmployee;

public class PersonnelBusinesWithP extends com.pomplatform.db.dao.PersonnelBusines
{


	public PersonnelBusinesWithP() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseProjectEmployee> getDetailProjectEmployee() {
		return this.__detail_projectemployee;
	}

	public void setDetailProjectEmployee( List<BaseProjectEmployee> value ) {
		this.__detail_projectemployee = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate 项目成员 DAO
		ProjectEmployee projectemployee = new ProjectEmployee();
		// load the original detail data.
		projectemployee.setConditionBusinessId("=", getPersonnelBusinessId());
		List<BaseProjectEmployee> originalprojectemployee = projectemployee.conditionalLoad();
		// if current detail is not empty.
		if(getDetailProjectEmployee() != null) {
			// need to delete data
			List<BaseProjectEmployee> needToDeleteProjectEmployee = new ArrayList<>();
			// need to add data
			List<BaseProjectEmployee> needToAddProjectEmployee = new ArrayList<>();
			// find that records need to be modified.
			for(BaseProjectEmployee __projectemployee : getDetailProjectEmployee() ) {
				// set that related fields.
				__projectemployee.setBusinessId(getPersonnelBusinessId());
				// if found then set found flag.
				boolean foundProjectEmployee = false;
				// search the original detail list.
				for(BaseProjectEmployee __originalprojectemployee : originalprojectemployee) {
					// compare the key.
					if(__projectemployee.compareTo(__originalprojectemployee) == 0) {
						// found the original record.
						foundProjectEmployee = true;
						//update the record
						// clear DAO's data
						projectemployee.clearCurrentData();
						// set original bean data into DAO
						projectemployee.setDataFromBase(__originalprojectemployee);
						// clear DAO data modification flags, just like the data reloaded from DB.
						projectemployee.clearModifiedFlags();
						// set the current data into DAO
						projectemployee.setDataFromBase(__projectemployee);
						// execute update 
						projectemployee.update();
						break;
					}
				}
				// if the data not found in the original list, then add to the need-to-add list.
				if(!foundProjectEmployee) needToAddProjectEmployee.add(__projectemployee);
			}
			// find the record that in the original list but not in the current list.
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
			// process need-to-delete list.
			for(BaseProjectEmployee __projectemployee : needToDeleteProjectEmployee ) {
				deleteFromProjectEmployee(__projectemployee, projectemployee);
			}
			// process need-to-add list. insert into DB.
			for(BaseProjectEmployee __projectemployee : needToAddProjectEmployee ) {
				projectemployee.clearCurrentData();
				projectemployee.setDataFromBase(__projectemployee);
				projectemployee.save();
				__projectemployee.setProjectEmployeeId(projectemployee.getProjectEmployeeId());
			}
		} else {
			// if current list is empty. then delete all the original details.
			for(BaseProjectEmployee __projectemployee : originalprojectemployee ) {
				deleteFromProjectEmployee(__projectemployee, projectemployee);
			}
		}
	}

	private void deleteFromProjectEmployee(BaseProjectEmployee bean, ProjectEmployee dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setBusinessId(null);
		if(__detail_delete_projectemployee) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		ProjectEmployee projectemployee = new ProjectEmployee();
		projectemployee.setConditionBusinessId("=", getPersonnelBusinessId());
		projectemployee.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			ProjectEmployee projectemployee = new ProjectEmployee();
			projectemployee.setConditionBusinessId("=", getPersonnelBusinessId());
			setDetailProjectEmployee(projectemployee.conditionalLoad());
		}
		return true;
	}

	public List<BasePersonnelBusinesWithP> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BasePersonnelBusinesWithP> result = BasePersonnelBusinesWithP.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BasePersonnelBusinesWithP generateBaseExt() {
		BasePersonnelBusinesWithP ____result = new BasePersonnelBusinesWithP();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BasePersonnelBusinesWithP __base) {
		super.setDataFromBase(__base);
		setDetailProjectEmployee(__base.getDetailProjectEmployee());
	}

	public void setDataToBase(BasePersonnelBusinesWithP __base) {
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

	@Override
	public int conditionalDelete() throws java.sql.SQLException {
		super.conditionalDelete();
		deleteDetailTables();
		return 1;
	}

	public boolean isDeleteDetailProjectEmployee() {
		return this.__detail_delete_projectemployee;
	}

	public void setDeleteDetailProjectEmployee( boolean value ) {
		this.__detail_delete_projectemployee = value;
	}

	protected boolean __detail_delete_projectemployee = true; 
	protected List<BaseProjectEmployee> __detail_projectemployee ; 
}
