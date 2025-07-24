package pomplatform.workflow.personnelbusiness.dao;

import java.util.ArrayList;
import java.util.List;

import com.pomplatform.db.bean.BaseEmployeeEducationInformation;
import com.pomplatform.db.bean.BaseEmployeeFamilyInformation;
import com.pomplatform.db.bean.BaseEmployeeRewardExperience;
import com.pomplatform.db.bean.BaseEmployeeTechnicalTitle;
import com.pomplatform.db.bean.BaseEmployeeWorkExperience;
import com.pomplatform.db.dao.EmployeeEducationInformation;
import com.pomplatform.db.dao.EmployeeFamilyInformation;
import com.pomplatform.db.dao.EmployeeRewardExperience;
import com.pomplatform.db.dao.EmployeeTechnicalTitle;
import com.pomplatform.db.dao.EmployeeWorkExperience;

import delicacy.system.dao.Employee;
import pomplatform.workflow.personnelbusiness.bean.BaseEmployeeWithEeeee;

public class EmployeeWithEeeee extends Employee
{


	public EmployeeWithEeeee() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseEmployeeEducationInformation> getDetailEmployeeEducationInformation() {
		return this.__detail_employeeeducationinformation;
	}

	public void setDetailEmployeeEducationInformation( List<BaseEmployeeEducationInformation> value ) {
		this.__detail_employeeeducationinformation = value;
	}

	public List<BaseEmployeeFamilyInformation> getDetailEmployeeFamilyInformation() {
		return this.__detail_employeefamilyinformation;
	}

	public void setDetailEmployeeFamilyInformation( List<BaseEmployeeFamilyInformation> value ) {
		this.__detail_employeefamilyinformation = value;
	}

	public List<BaseEmployeeRewardExperience> getDetailEmployeeRewardExperience() {
		return this.__detail_employeerewardexperience;
	}

	public void setDetailEmployeeRewardExperience( List<BaseEmployeeRewardExperience> value ) {
		this.__detail_employeerewardexperience = value;
	}

	public List<BaseEmployeeWorkExperience> getDetailEmployeeWorkExperience() {
		return this.__detail_employeeworkexperience;
	}

	public void setDetailEmployeeWorkExperience( List<BaseEmployeeWorkExperience> value ) {
		this.__detail_employeeworkexperience = value;
	}

	public List<BaseEmployeeTechnicalTitle> getDetailEmployeeTechnicalTitle() {
		return this.__detail_employeetechnicaltitle;
	}

	public void setDetailEmployeeTechnicalTitle( List<BaseEmployeeTechnicalTitle> value ) {
		this.__detail_employeetechnicaltitle = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate 职员学历信息表 DAO
		EmployeeEducationInformation employeeeducationinformation = new EmployeeEducationInformation();
		// load the original details.
		employeeeducationinformation.setConditionEmployeeId("=", getEmployeeId());
		List<BaseEmployeeEducationInformation> originalemployeeeducationinformation = employeeeducationinformation.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailEmployeeEducationInformation() != null) {
			// need to delete list.
			List<BaseEmployeeEducationInformation> needToDeleteEmployeeEducationInformation = new ArrayList<>();
			// need to add list.
			List<BaseEmployeeEducationInformation> needToAddEmployeeEducationInformation = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseEmployeeEducationInformation __employeeeducationinformation : getDetailEmployeeEducationInformation() ) {
				// set the relative field.
				__employeeeducationinformation.setEmployeeId( getEmployeeId());
				// set find flag
				boolean foundEmployeeEducationInformation = false;
				// find the original list.
				for(BaseEmployeeEducationInformation __originalemployeeeducationinformation : originalemployeeeducationinformation) {
					// if found the original record
					if(__employeeeducationinformation.compareTo(__originalemployeeeducationinformation) == 0) {
						// set found flag to true
						foundEmployeeEducationInformation = true;
						// update the record.
						// clear DAO's data
						employeeeducationinformation.clearCurrentData();
						// set original data into DAO
						employeeeducationinformation.setDataFromBase(__originalemployeeeducationinformation);
						// clear DAO modification flag, just like the is loaded from DB
						employeeeducationinformation.clearModifiedFlags();
						// set current data into DAO
						employeeeducationinformation.setDataFromBase(__employeeeducationinformation);
						// execute update
						employeeeducationinformation.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundEmployeeEducationInformation) needToAddEmployeeEducationInformation.add(__employeeeducationinformation);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseEmployeeEducationInformation __originalemployeeeducationinformation : originalemployeeeducationinformation) {
				boolean foundEmployeeEducationInformation = false;
				for(BaseEmployeeEducationInformation __employeeeducationinformation : getDetailEmployeeEducationInformation() ) {
					if(__employeeeducationinformation.compareTo(__originalemployeeeducationinformation) == 0) {
						foundEmployeeEducationInformation = true;
						break;
				}
				}
				if(!foundEmployeeEducationInformation) needToDeleteEmployeeEducationInformation.add(__originalemployeeeducationinformation);
			}
			// process need-to-add list
			for(BaseEmployeeEducationInformation __employeeeducationinformation : needToAddEmployeeEducationInformation ) {
				employeeeducationinformation.setPrimaryKeyFromBase(__employeeeducationinformation);
				// if the primay key is null, then insert into DB
				if(employeeeducationinformation.isPrimaryKeyNull()) { employeeeducationinformation.clearCurrentData(); employeeeducationinformation.setDataFromBase(__employeeeducationinformation); employeeeducationinformation.save(); }
				// otherwise load and update
				else { if(employeeeducationinformation.load()) { employeeeducationinformation.setDataFromBase(__employeeeducationinformation); employeeeducationinformation.update(); } else { employeeeducationinformation.clearCurrentData(); employeeeducationinformation.setDataFromBase(__employeeeducationinformation); employeeeducationinformation.save(); } }
			}
			// process need-to-delete list
			for(BaseEmployeeEducationInformation __employeeeducationinformation : needToDeleteEmployeeEducationInformation ) {
				deleteFromEmployeeEducationInformation(__employeeeducationinformation, employeeeducationinformation);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseEmployeeEducationInformation __employeeeducationinformation : originalemployeeeducationinformation ) {
				deleteFromEmployeeEducationInformation(__employeeeducationinformation, employeeeducationinformation);
			}
		}
		// instantiate 职员家庭成员表 DAO
		EmployeeFamilyInformation employeefamilyinformation = new EmployeeFamilyInformation();
		// load the original details.
		employeefamilyinformation.setConditionEmployeeId("=", getEmployeeId());
		List<BaseEmployeeFamilyInformation> originalemployeefamilyinformation = employeefamilyinformation.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailEmployeeFamilyInformation() != null) {
			// need to delete list.
			List<BaseEmployeeFamilyInformation> needToDeleteEmployeeFamilyInformation = new ArrayList<>();
			// need to add list.
			List<BaseEmployeeFamilyInformation> needToAddEmployeeFamilyInformation = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseEmployeeFamilyInformation __employeefamilyinformation : getDetailEmployeeFamilyInformation() ) {
				// set the relative field.
				__employeefamilyinformation.setEmployeeId( getEmployeeId());
				// set find flag
				boolean foundEmployeeFamilyInformation = false;
				// find the original list.
				for(BaseEmployeeFamilyInformation __originalemployeefamilyinformation : originalemployeefamilyinformation) {
					// if found the original record
					if(__employeefamilyinformation.compareTo(__originalemployeefamilyinformation) == 0) {
						// set found flag to true
						foundEmployeeFamilyInformation = true;
						// update the record.
						// clear DAO's data
						employeefamilyinformation.clearCurrentData();
						// set original data into DAO
						employeefamilyinformation.setDataFromBase(__originalemployeefamilyinformation);
						// clear DAO modification flag, just like the is loaded from DB
						employeefamilyinformation.clearModifiedFlags();
						// set current data into DAO
						employeefamilyinformation.setDataFromBase(__employeefamilyinformation);
						// execute update
						employeefamilyinformation.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundEmployeeFamilyInformation) needToAddEmployeeFamilyInformation.add(__employeefamilyinformation);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseEmployeeFamilyInformation __originalemployeefamilyinformation : originalemployeefamilyinformation) {
				boolean foundEmployeeFamilyInformation = false;
				for(BaseEmployeeFamilyInformation __employeefamilyinformation : getDetailEmployeeFamilyInformation() ) {
					if(__employeefamilyinformation.compareTo(__originalemployeefamilyinformation) == 0) {
						foundEmployeeFamilyInformation = true;
						break;
				}
				}
				if(!foundEmployeeFamilyInformation) needToDeleteEmployeeFamilyInformation.add(__originalemployeefamilyinformation);
			}
			// process need-to-add list
			for(BaseEmployeeFamilyInformation __employeefamilyinformation : needToAddEmployeeFamilyInformation ) {
				employeefamilyinformation.setPrimaryKeyFromBase(__employeefamilyinformation);
				// if the primay key is null, then insert into DB
				if(employeefamilyinformation.isPrimaryKeyNull()) { employeefamilyinformation.clearCurrentData(); employeefamilyinformation.setDataFromBase(__employeefamilyinformation); employeefamilyinformation.save(); }
				// otherwise load and update
				else { if(employeefamilyinformation.load()) { employeefamilyinformation.setDataFromBase(__employeefamilyinformation); employeefamilyinformation.update(); } else { employeefamilyinformation.clearCurrentData(); employeefamilyinformation.setDataFromBase(__employeefamilyinformation); employeefamilyinformation.save(); } }
			}
			// process need-to-delete list
			for(BaseEmployeeFamilyInformation __employeefamilyinformation : needToDeleteEmployeeFamilyInformation ) {
				deleteFromEmployeeFamilyInformation(__employeefamilyinformation, employeefamilyinformation);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseEmployeeFamilyInformation __employeefamilyinformation : originalemployeefamilyinformation ) {
				deleteFromEmployeeFamilyInformation(__employeefamilyinformation, employeefamilyinformation);
			}
		}
		// instantiate 职员奖惩经历表 DAO
		EmployeeRewardExperience employeerewardexperience = new EmployeeRewardExperience();
		// load the original details.
		employeerewardexperience.setConditionEmployeeId("=", getEmployeeId());
		List<BaseEmployeeRewardExperience> originalemployeerewardexperience = employeerewardexperience.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailEmployeeRewardExperience() != null) {
			// need to delete list.
			List<BaseEmployeeRewardExperience> needToDeleteEmployeeRewardExperience = new ArrayList<>();
			// need to add list.
			List<BaseEmployeeRewardExperience> needToAddEmployeeRewardExperience = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseEmployeeRewardExperience __employeerewardexperience : getDetailEmployeeRewardExperience() ) {
				// set the relative field.
				__employeerewardexperience.setEmployeeId( getEmployeeId());
				// set find flag
				boolean foundEmployeeRewardExperience = false;
				// find the original list.
				for(BaseEmployeeRewardExperience __originalemployeerewardexperience : originalemployeerewardexperience) {
					// if found the original record
					if(__employeerewardexperience.compareTo(__originalemployeerewardexperience) == 0) {
						// set found flag to true
						foundEmployeeRewardExperience = true;
						// update the record.
						// clear DAO's data
						employeerewardexperience.clearCurrentData();
						// set original data into DAO
						employeerewardexperience.setDataFromBase(__originalemployeerewardexperience);
						// clear DAO modification flag, just like the is loaded from DB
						employeerewardexperience.clearModifiedFlags();
						// set current data into DAO
						employeerewardexperience.setDataFromBase(__employeerewardexperience);
						// execute update
						employeerewardexperience.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundEmployeeRewardExperience) needToAddEmployeeRewardExperience.add(__employeerewardexperience);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseEmployeeRewardExperience __originalemployeerewardexperience : originalemployeerewardexperience) {
				boolean foundEmployeeRewardExperience = false;
				for(BaseEmployeeRewardExperience __employeerewardexperience : getDetailEmployeeRewardExperience() ) {
					if(__employeerewardexperience.compareTo(__originalemployeerewardexperience) == 0) {
						foundEmployeeRewardExperience = true;
						break;
				}
				}
				if(!foundEmployeeRewardExperience) needToDeleteEmployeeRewardExperience.add(__originalemployeerewardexperience);
			}
			// process need-to-add list
			for(BaseEmployeeRewardExperience __employeerewardexperience : needToAddEmployeeRewardExperience ) {
				employeerewardexperience.setPrimaryKeyFromBase(__employeerewardexperience);
				// if the primay key is null, then insert into DB
				if(employeerewardexperience.isPrimaryKeyNull()) { employeerewardexperience.clearCurrentData(); employeerewardexperience.setDataFromBase(__employeerewardexperience); employeerewardexperience.save(); }
				// otherwise load and update
				else { if(employeerewardexperience.load()) { employeerewardexperience.setDataFromBase(__employeerewardexperience); employeerewardexperience.update(); } else { employeerewardexperience.clearCurrentData(); employeerewardexperience.setDataFromBase(__employeerewardexperience); employeerewardexperience.save(); } }
			}
			// process need-to-delete list
			for(BaseEmployeeRewardExperience __employeerewardexperience : needToDeleteEmployeeRewardExperience ) {
				deleteFromEmployeeRewardExperience(__employeerewardexperience, employeerewardexperience);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseEmployeeRewardExperience __employeerewardexperience : originalemployeerewardexperience ) {
				deleteFromEmployeeRewardExperience(__employeerewardexperience, employeerewardexperience);
			}
		}
		// instantiate 职员工作经历表 DAO
		EmployeeWorkExperience employeeworkexperience = new EmployeeWorkExperience();
		// load the original details.
		employeeworkexperience.setConditionEmployeeId("=", getEmployeeId());
		List<BaseEmployeeWorkExperience> originalemployeeworkexperience = employeeworkexperience.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailEmployeeWorkExperience() != null) {
			// need to delete list.
			List<BaseEmployeeWorkExperience> needToDeleteEmployeeWorkExperience = new ArrayList<>();
			// need to add list.
			List<BaseEmployeeWorkExperience> needToAddEmployeeWorkExperience = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseEmployeeWorkExperience __employeeworkexperience : getDetailEmployeeWorkExperience() ) {
				// set the relative field.
				__employeeworkexperience.setEmployeeId( getEmployeeId());
				// set find flag
				boolean foundEmployeeWorkExperience = false;
				// find the original list.
				for(BaseEmployeeWorkExperience __originalemployeeworkexperience : originalemployeeworkexperience) {
					// if found the original record
					if(__employeeworkexperience.compareTo(__originalemployeeworkexperience) == 0) {
						// set found flag to true
						foundEmployeeWorkExperience = true;
						// update the record.
						// clear DAO's data
						employeeworkexperience.clearCurrentData();
						// set original data into DAO
						employeeworkexperience.setDataFromBase(__originalemployeeworkexperience);
						// clear DAO modification flag, just like the is loaded from DB
						employeeworkexperience.clearModifiedFlags();
						// set current data into DAO
						employeeworkexperience.setDataFromBase(__employeeworkexperience);
						// execute update
						employeeworkexperience.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundEmployeeWorkExperience) needToAddEmployeeWorkExperience.add(__employeeworkexperience);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseEmployeeWorkExperience __originalemployeeworkexperience : originalemployeeworkexperience) {
				boolean foundEmployeeWorkExperience = false;
				for(BaseEmployeeWorkExperience __employeeworkexperience : getDetailEmployeeWorkExperience() ) {
					if(__employeeworkexperience.compareTo(__originalemployeeworkexperience) == 0) {
						foundEmployeeWorkExperience = true;
						break;
				}
				}
				if(!foundEmployeeWorkExperience) needToDeleteEmployeeWorkExperience.add(__originalemployeeworkexperience);
			}
			// process need-to-add list
			for(BaseEmployeeWorkExperience __employeeworkexperience : needToAddEmployeeWorkExperience ) {
				employeeworkexperience.setPrimaryKeyFromBase(__employeeworkexperience);
				// if the primay key is null, then insert into DB
				if(employeeworkexperience.isPrimaryKeyNull()) { employeeworkexperience.clearCurrentData(); employeeworkexperience.setDataFromBase(__employeeworkexperience); employeeworkexperience.save(); }
				// otherwise load and update
				else { if(employeeworkexperience.load()) { employeeworkexperience.setDataFromBase(__employeeworkexperience); employeeworkexperience.update(); } else { employeeworkexperience.clearCurrentData(); employeeworkexperience.setDataFromBase(__employeeworkexperience); employeeworkexperience.save(); } }
			}
			// process need-to-delete list
			for(BaseEmployeeWorkExperience __employeeworkexperience : needToDeleteEmployeeWorkExperience ) {
				deleteFromEmployeeWorkExperience(__employeeworkexperience, employeeworkexperience);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseEmployeeWorkExperience __employeeworkexperience : originalemployeeworkexperience ) {
				deleteFromEmployeeWorkExperience(__employeeworkexperience, employeeworkexperience);
			}
		}
		// instantiate 职员技术职称表 DAO
		EmployeeTechnicalTitle employeetechnicaltitle = new EmployeeTechnicalTitle();
		// load the original details.
		employeetechnicaltitle.setConditionEmployeeId("=", getEmployeeId());
		List<BaseEmployeeTechnicalTitle> originalemployeetechnicaltitle = employeetechnicaltitle.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailEmployeeTechnicalTitle() != null) {
			// need to delete list.
			List<BaseEmployeeTechnicalTitle> needToDeleteEmployeeTechnicalTitle = new ArrayList<>();
			// need to add list.
			List<BaseEmployeeTechnicalTitle> needToAddEmployeeTechnicalTitle = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseEmployeeTechnicalTitle __employeetechnicaltitle : getDetailEmployeeTechnicalTitle() ) {
				// set the relative field.
				__employeetechnicaltitle.setEmployeeId( getEmployeeId());
				// set find flag
				boolean foundEmployeeTechnicalTitle = false;
				// find the original list.
				for(BaseEmployeeTechnicalTitle __originalemployeetechnicaltitle : originalemployeetechnicaltitle) {
					// if found the original record
					if(__employeetechnicaltitle.compareTo(__originalemployeetechnicaltitle) == 0) {
						// set found flag to true
						foundEmployeeTechnicalTitle = true;
						// update the record.
						// clear DAO's data
						employeetechnicaltitle.clearCurrentData();
						// set original data into DAO
						employeetechnicaltitle.setDataFromBase(__originalemployeetechnicaltitle);
						// clear DAO modification flag, just like the is loaded from DB
						employeetechnicaltitle.clearModifiedFlags();
						// set current data into DAO
						employeetechnicaltitle.setDataFromBase(__employeetechnicaltitle);
						// execute update
						employeetechnicaltitle.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundEmployeeTechnicalTitle) needToAddEmployeeTechnicalTitle.add(__employeetechnicaltitle);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseEmployeeTechnicalTitle __originalemployeetechnicaltitle : originalemployeetechnicaltitle) {
				boolean foundEmployeeTechnicalTitle = false;
				for(BaseEmployeeTechnicalTitle __employeetechnicaltitle : getDetailEmployeeTechnicalTitle() ) {
					if(__employeetechnicaltitle.compareTo(__originalemployeetechnicaltitle) == 0) {
						foundEmployeeTechnicalTitle = true;
						break;
				}
				}
				if(!foundEmployeeTechnicalTitle) needToDeleteEmployeeTechnicalTitle.add(__originalemployeetechnicaltitle);
			}
			// process need-to-add list
			for(BaseEmployeeTechnicalTitle __employeetechnicaltitle : needToAddEmployeeTechnicalTitle ) {
				employeetechnicaltitle.setPrimaryKeyFromBase(__employeetechnicaltitle);
				// if the primay key is null, then insert into DB
				if(employeetechnicaltitle.isPrimaryKeyNull()) { employeetechnicaltitle.clearCurrentData(); employeetechnicaltitle.setDataFromBase(__employeetechnicaltitle); employeetechnicaltitle.save(); }
				// otherwise load and update
				else { if(employeetechnicaltitle.load()) { employeetechnicaltitle.setDataFromBase(__employeetechnicaltitle); employeetechnicaltitle.update(); } else { employeetechnicaltitle.clearCurrentData(); employeetechnicaltitle.setDataFromBase(__employeetechnicaltitle); employeetechnicaltitle.save(); } }
			}
			// process need-to-delete list
			for(BaseEmployeeTechnicalTitle __employeetechnicaltitle : needToDeleteEmployeeTechnicalTitle ) {
				deleteFromEmployeeTechnicalTitle(__employeetechnicaltitle, employeetechnicaltitle);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseEmployeeTechnicalTitle __employeetechnicaltitle : originalemployeetechnicaltitle ) {
				deleteFromEmployeeTechnicalTitle(__employeetechnicaltitle, employeetechnicaltitle);
			}
		}
	}

	private void deleteFromEmployeeEducationInformation(BaseEmployeeEducationInformation bean, EmployeeEducationInformation dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setEmployeeId(null);
		if(__detail_delete_employeeeducationinformation) dao.delete(); else dao.update();
	}

	private void deleteFromEmployeeFamilyInformation(BaseEmployeeFamilyInformation bean, EmployeeFamilyInformation dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setEmployeeId(null);
		if(__detail_delete_employeefamilyinformation) dao.delete(); else dao.update();
	}

	private void deleteFromEmployeeRewardExperience(BaseEmployeeRewardExperience bean, EmployeeRewardExperience dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setEmployeeId(null);
		if(__detail_delete_employeerewardexperience) dao.delete(); else dao.update();
	}

	private void deleteFromEmployeeWorkExperience(BaseEmployeeWorkExperience bean, EmployeeWorkExperience dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setEmployeeId(null);
		if(__detail_delete_employeeworkexperience) dao.delete(); else dao.update();
	}

	private void deleteFromEmployeeTechnicalTitle(BaseEmployeeTechnicalTitle bean, EmployeeTechnicalTitle dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setEmployeeId(null);
		if(__detail_delete_employeetechnicaltitle) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		EmployeeEducationInformation employeeeducationinformation = new EmployeeEducationInformation();
		employeeeducationinformation.setConditionEmployeeId("=", getEmployeeId());
		employeeeducationinformation.conditionalDelete();
		EmployeeFamilyInformation employeefamilyinformation = new EmployeeFamilyInformation();
		employeefamilyinformation.setConditionEmployeeId("=", getEmployeeId());
		employeefamilyinformation.conditionalDelete();
		EmployeeRewardExperience employeerewardexperience = new EmployeeRewardExperience();
		employeerewardexperience.setConditionEmployeeId("=", getEmployeeId());
		employeerewardexperience.conditionalDelete();
		EmployeeWorkExperience employeeworkexperience = new EmployeeWorkExperience();
		employeeworkexperience.setConditionEmployeeId("=", getEmployeeId());
		employeeworkexperience.conditionalDelete();
		EmployeeTechnicalTitle employeetechnicaltitle = new EmployeeTechnicalTitle();
		employeetechnicaltitle.setConditionEmployeeId("=", getEmployeeId());
		employeetechnicaltitle.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			EmployeeEducationInformation employeeeducationinformation = new EmployeeEducationInformation();
			employeeeducationinformation.setConditionEmployeeId("=", getEmployeeId());
			setDetailEmployeeEducationInformation(employeeeducationinformation.conditionalLoad());
			EmployeeFamilyInformation employeefamilyinformation = new EmployeeFamilyInformation();
			employeefamilyinformation.setConditionEmployeeId("=", getEmployeeId());
			setDetailEmployeeFamilyInformation(employeefamilyinformation.conditionalLoad());
			EmployeeRewardExperience employeerewardexperience = new EmployeeRewardExperience();
			employeerewardexperience.setConditionEmployeeId("=", getEmployeeId());
			setDetailEmployeeRewardExperience(employeerewardexperience.conditionalLoad());
			EmployeeWorkExperience employeeworkexperience = new EmployeeWorkExperience();
			employeeworkexperience.setConditionEmployeeId("=", getEmployeeId());
			setDetailEmployeeWorkExperience(employeeworkexperience.conditionalLoad());
			EmployeeTechnicalTitle employeetechnicaltitle = new EmployeeTechnicalTitle();
			employeetechnicaltitle.setConditionEmployeeId("=", getEmployeeId());
			setDetailEmployeeTechnicalTitle(employeetechnicaltitle.conditionalLoad());
		}
		return true;
	}

	public List<BaseEmployeeWithEeeee> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseEmployeeWithEeeee> result = BaseEmployeeWithEeeee.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseEmployeeWithEeeee generateBaseExt() {
		BaseEmployeeWithEeeee ____result = new BaseEmployeeWithEeeee();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseEmployeeWithEeeee __base) {
		super.setDataFromBase(__base);
		setDetailEmployeeEducationInformation(__base.getDetailEmployeeEducationInformation());
		setDetailEmployeeFamilyInformation(__base.getDetailEmployeeFamilyInformation());
		setDetailEmployeeRewardExperience(__base.getDetailEmployeeRewardExperience());
		setDetailEmployeeWorkExperience(__base.getDetailEmployeeWorkExperience());
		setDetailEmployeeTechnicalTitle(__base.getDetailEmployeeTechnicalTitle());
	}

	public void setDataToBase(BaseEmployeeWithEeeee __base) {
		super.setDataToBase(__base);
		__base.setDetailEmployeeEducationInformation(getDetailEmployeeEducationInformation());
		__base.setDetailEmployeeFamilyInformation(getDetailEmployeeFamilyInformation());
		__base.setDetailEmployeeRewardExperience(getDetailEmployeeRewardExperience());
		__base.setDetailEmployeeWorkExperience(getDetailEmployeeWorkExperience());
		__base.setDetailEmployeeTechnicalTitle(getDetailEmployeeTechnicalTitle());
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

	public boolean isDeleteDetailEmployeeEducationInformation() {
		return this.__detail_delete_employeeeducationinformation;
	}

	public void setDeleteDetailEmployeeEducationInformation( boolean value ) {
		this.__detail_delete_employeeeducationinformation = value;
	}

	protected boolean __detail_delete_employeeeducationinformation = true; 
	protected List<BaseEmployeeEducationInformation> __detail_employeeeducationinformation ; 
	public boolean isDeleteDetailEmployeeFamilyInformation() {
		return this.__detail_delete_employeefamilyinformation;
	}

	public void setDeleteDetailEmployeeFamilyInformation( boolean value ) {
		this.__detail_delete_employeefamilyinformation = value;
	}

	protected boolean __detail_delete_employeefamilyinformation = true; 
	protected List<BaseEmployeeFamilyInformation> __detail_employeefamilyinformation ; 
	public boolean isDeleteDetailEmployeeRewardExperience() {
		return this.__detail_delete_employeerewardexperience;
	}

	public void setDeleteDetailEmployeeRewardExperience( boolean value ) {
		this.__detail_delete_employeerewardexperience = value;
	}

	protected boolean __detail_delete_employeerewardexperience = true; 
	protected List<BaseEmployeeRewardExperience> __detail_employeerewardexperience ; 
	public boolean isDeleteDetailEmployeeWorkExperience() {
		return this.__detail_delete_employeeworkexperience;
	}

	public void setDeleteDetailEmployeeWorkExperience( boolean value ) {
		this.__detail_delete_employeeworkexperience = value;
	}

	protected boolean __detail_delete_employeeworkexperience = true; 
	protected List<BaseEmployeeWorkExperience> __detail_employeeworkexperience ; 
	public boolean isDeleteDetailEmployeeTechnicalTitle() {
		return this.__detail_delete_employeetechnicaltitle;
	}

	public void setDeleteDetailEmployeeTechnicalTitle( boolean value ) {
		this.__detail_delete_employeetechnicaltitle = value;
	}

	protected boolean __detail_delete_employeetechnicaltitle = true; 
	protected List<BaseEmployeeTechnicalTitle> __detail_employeetechnicaltitle ; 
}
