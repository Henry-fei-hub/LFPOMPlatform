package pomplatform.business.dao;

import java.util.*;
import pomplatform.business.bean.BaseSystemProcessWithS;
import delicacy.system.bean.BaseSystemProcessDepartment;
import delicacy.system.dao.SystemProcessDepartment;

public class SystemProcessWithS extends delicacy.system.dao.SystemProcess
{


	public SystemProcessWithS() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseSystemProcessDepartment> getDetailSystemProcessDepartment() {
		return this.__detail_systemprocessdepartment;
	}

	public void setDetailSystemProcessDepartment( List<BaseSystemProcessDepartment> value ) {
		this.__detail_systemprocessdepartment = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate  DAO
		SystemProcessDepartment systemprocessdepartment = new SystemProcessDepartment();
		// load the original detail data.
		systemprocessdepartment.setConditionProcessId("=", getProcessId());
		List<BaseSystemProcessDepartment> originalsystemprocessdepartment = systemprocessdepartment.conditionalLoad();
		// if current detail is not empty.
		if(getDetailSystemProcessDepartment() != null) {
			// need to delete data
			List<BaseSystemProcessDepartment> needToDeleteSystemProcessDepartment = new ArrayList<>();
			// need to add data
			List<BaseSystemProcessDepartment> needToAddSystemProcessDepartment = new ArrayList<>();
			// find that records need to be modified.
			for(BaseSystemProcessDepartment __systemprocessdepartment : getDetailSystemProcessDepartment() ) {
				// set that related fields.
				__systemprocessdepartment.setProcessId(getProcessId());
				// if found then set found flag.
				boolean foundSystemProcessDepartment = false;
				// search the original detail list.
				for(BaseSystemProcessDepartment __originalsystemprocessdepartment : originalsystemprocessdepartment) {
					// compare the key.
					if(__systemprocessdepartment.compareTo(__originalsystemprocessdepartment) == 0) {
						// found the original record.
						foundSystemProcessDepartment = true;
						//update the record
						// clear DAO's data
						systemprocessdepartment.clearCurrentData();
						// set original bean data into DAO
						systemprocessdepartment.setDataFromBase(__originalsystemprocessdepartment);
						// clear DAO data modification flags, just like the data reloaded from DB.
						systemprocessdepartment.clearModifiedFlags();
						// set the current data into DAO
						systemprocessdepartment.setDataFromBase(__systemprocessdepartment);
						// execute update 
						systemprocessdepartment.update();
						break;
					}
				}
				// if the data not found in the original list, then add to the need-to-add list.
				if(!foundSystemProcessDepartment) needToAddSystemProcessDepartment.add(__systemprocessdepartment);
			}
			// find the record that in the original list but not in the current list.
			for(BaseSystemProcessDepartment __originalsystemprocessdepartment : originalsystemprocessdepartment) {
				boolean foundSystemProcessDepartment = false;
				for(BaseSystemProcessDepartment __systemprocessdepartment : getDetailSystemProcessDepartment() ) {
					if(__systemprocessdepartment.compareTo(__originalsystemprocessdepartment) == 0) {
						foundSystemProcessDepartment = true;
						break;
				}
				}
				if(!foundSystemProcessDepartment) needToDeleteSystemProcessDepartment.add(__originalsystemprocessdepartment);
			}
			// process need-to-add list. insert into DB.
			for(BaseSystemProcessDepartment __systemprocessdepartment : needToAddSystemProcessDepartment ) {
				systemprocessdepartment.clearCurrentData();
				systemprocessdepartment.setDataFromBase(__systemprocessdepartment);
				systemprocessdepartment.save();
				__systemprocessdepartment.setProcessDepartmentId(systemprocessdepartment.getProcessDepartmentId());
			}
			// process need-to-delete list.
			for(BaseSystemProcessDepartment __systemprocessdepartment : needToDeleteSystemProcessDepartment ) {
				deleteFromSystemProcessDepartment(__systemprocessdepartment, systemprocessdepartment);
			}
		} else {
			// if current list is empty. then delete all the original details.
			for(BaseSystemProcessDepartment __systemprocessdepartment : originalsystemprocessdepartment ) {
				deleteFromSystemProcessDepartment(__systemprocessdepartment, systemprocessdepartment);
			}
		}
	}

	private void deleteFromSystemProcessDepartment(BaseSystemProcessDepartment bean, SystemProcessDepartment dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setProcessId(null);
		if(__detail_delete_systemprocessdepartment) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		SystemProcessDepartment systemprocessdepartment = new SystemProcessDepartment();
		systemprocessdepartment.setConditionProcessId("=", getProcessId());
		systemprocessdepartment.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			SystemProcessDepartment systemprocessdepartment = new SystemProcessDepartment();
			systemprocessdepartment.setConditionProcessId("=", getProcessId());
			setDetailSystemProcessDepartment(systemprocessdepartment.conditionalLoad());
		}
		return true;
	}

	public List<BaseSystemProcessWithS> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseSystemProcessWithS> result = BaseSystemProcessWithS.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseSystemProcessWithS generateBaseExt() {
		BaseSystemProcessWithS ____result = new BaseSystemProcessWithS();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseSystemProcessWithS __base) {
		super.setDataFromBase(__base);
		setDetailSystemProcessDepartment(__base.getDetailSystemProcessDepartment());
	}

	public void setDataToBase(BaseSystemProcessWithS __base) {
		super.setDataToBase(__base);
		__base.setDetailSystemProcessDepartment(getDetailSystemProcessDepartment());
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

	public boolean isDeleteDetailSystemProcessDepartment() {
		return this.__detail_delete_systemprocessdepartment;
	}

	public void setDeleteDetailSystemProcessDepartment( boolean value ) {
		this.__detail_delete_systemprocessdepartment = value;
	}

	protected boolean __detail_delete_systemprocessdepartment = true; 
	protected List<BaseSystemProcessDepartment> __detail_systemprocessdepartment ; 
}
