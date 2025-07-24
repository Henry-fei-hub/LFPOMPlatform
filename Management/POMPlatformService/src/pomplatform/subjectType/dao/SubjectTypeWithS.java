package pomplatform.subjectType.dao;

import java.util.*;
import pomplatform.subjectType.bean.BaseSubjectTypeWithS;
import com.pomplatform.db.bean.BaseSubjectDepartment;
import com.pomplatform.db.dao.SubjectDepartment;

public class SubjectTypeWithS extends com.pomplatform.db.dao.SubjectType
{


	public SubjectTypeWithS() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseSubjectDepartment> getDetailSubjectDepartment() {
		return this.__detail_subjectdepartment;
	}

	public void setDetailSubjectDepartment( List<BaseSubjectDepartment> value ) {
		this.__detail_subjectdepartment = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate  DAO
		SubjectDepartment subjectdepartment = new SubjectDepartment();
		// load the original detail data.
		subjectdepartment.setConditionSubjectTypeId("=", getSubjectTypeId());
		List<BaseSubjectDepartment> originalsubjectdepartment = subjectdepartment.conditionalLoad();
		// if current detail is not empty.
		if(getDetailSubjectDepartment() != null) {
			// need to delete data
			List<BaseSubjectDepartment> needToDeleteSubjectDepartment = new ArrayList<>();
			// need to add data
			List<BaseSubjectDepartment> needToAddSubjectDepartment = new ArrayList<>();
			// find that records need to be modified.
			for(BaseSubjectDepartment __subjectdepartment : getDetailSubjectDepartment() ) {
				// set that related fields.
				__subjectdepartment.setSubjectTypeId(getSubjectTypeId());
				// if found then set found flag.
				boolean foundSubjectDepartment = false;
				// search the original detail list.
				for(BaseSubjectDepartment __originalsubjectdepartment : originalsubjectdepartment) {
					// compare the key.
					if(Objects.equals(__subjectdepartment.getDepartmentId(), __originalsubjectdepartment.getDepartmentId())) {
						// found the original record.
						foundSubjectDepartment = true;
						//update the record
						// clear DAO's data
						subjectdepartment.clearCurrentData();
						// set original bean data into DAO
						subjectdepartment.setDataFromBase(__originalsubjectdepartment);
						// clear DAO data modification flags, just like the data reloaded from DB.
						subjectdepartment.clearModifiedFlags();
						// set the current data into DAO
						subjectdepartment.setDataFromBase(__subjectdepartment);
						// execute update 
						subjectdepartment.update();
						break;
					}
				}
				// if the data not found in the original list, then add to the need-to-add list.
				if(!foundSubjectDepartment) needToAddSubjectDepartment.add(__subjectdepartment);
			}
			// find the record that in the original list but not in the current list.
			for(BaseSubjectDepartment __originalsubjectdepartment : originalsubjectdepartment) {
				boolean foundSubjectDepartment = false;
				for(BaseSubjectDepartment __subjectdepartment : getDetailSubjectDepartment() ) {
					if(Objects.equals(__subjectdepartment.getDepartmentId(), __originalsubjectdepartment.getDepartmentId())) {
						foundSubjectDepartment = true;
						break;
				}
				}
				if(!foundSubjectDepartment) needToDeleteSubjectDepartment.add(__originalsubjectdepartment);
			}
			// process need-to-add list. insert into DB.
			for(BaseSubjectDepartment __subjectdepartment : needToAddSubjectDepartment ) {
				subjectdepartment.setPrimaryKeyFromBase(__subjectdepartment);
				// if the primay key is null, then insert into DB.
				if(subjectdepartment.isPrimaryKeyNull()) { subjectdepartment.clearCurrentData(); subjectdepartment.setDataFromBase(__subjectdepartment); subjectdepartment.save(); }
				// otherwise, find it and update.
				else { if(subjectdepartment.load()) { subjectdepartment.setDataFromBase(__subjectdepartment); subjectdepartment.update(); } else { subjectdepartment.clearCurrentData(); subjectdepartment.setDataFromBase(__subjectdepartment); subjectdepartment.save(); } }
			}
			// process need-to-delete list.
			for(BaseSubjectDepartment __subjectdepartment : needToDeleteSubjectDepartment ) {
				deleteFromSubjectDepartment(__subjectdepartment, subjectdepartment);
			}
		} else {
			// if current list is empty. then delete all the original details.
			for(BaseSubjectDepartment __subjectdepartment : originalsubjectdepartment ) {
				deleteFromSubjectDepartment(__subjectdepartment, subjectdepartment);
			}
		}
	}

	private void deleteFromSubjectDepartment(BaseSubjectDepartment bean, SubjectDepartment dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setSubjectTypeId(null);
		if(__detail_delete_subjectdepartment) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		SubjectDepartment subjectdepartment = new SubjectDepartment();
		subjectdepartment.setConditionSubjectTypeId("=", getSubjectTypeId());
		subjectdepartment.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			SubjectDepartment subjectdepartment = new SubjectDepartment();
			subjectdepartment.setConditionSubjectTypeId("=", getSubjectTypeId());
			setDetailSubjectDepartment(subjectdepartment.conditionalLoad());
		}
		return true;
	}

	public List<BaseSubjectTypeWithS> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseSubjectTypeWithS> result = BaseSubjectTypeWithS.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseSubjectTypeWithS generateBaseExt() {
		BaseSubjectTypeWithS ____result = new BaseSubjectTypeWithS();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseSubjectTypeWithS __base) {
		super.setDataFromBase(__base);
		setDetailSubjectDepartment(__base.getDetailSubjectDepartment());
	}

	public void setDataToBase(BaseSubjectTypeWithS __base) {
		super.setDataToBase(__base);
		__base.setDetailSubjectDepartment(getDetailSubjectDepartment());
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

	public boolean isDeleteDetailSubjectDepartment() {
		return this.__detail_delete_subjectdepartment;
	}

	public void setDeleteDetailSubjectDepartment( boolean value ) {
		this.__detail_delete_subjectdepartment = value;
	}

	protected boolean __detail_delete_subjectdepartment = true; 
	protected List<BaseSubjectDepartment> __detail_subjectdepartment ; 
}
