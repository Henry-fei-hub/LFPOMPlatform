package pomplatform.salaryexceptions.dao;

import java.util.*;
import pomplatform.salaryexceptions.bean.BasePersonnelBusinesWithS;
import com.pomplatform.db.bean.BaseSalaryException;
import com.pomplatform.db.dao.SalaryException;

public class PersonnelBusinesWithS extends com.pomplatform.db.dao.PersonnelBusines
{


	public PersonnelBusinesWithS() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseSalaryException> getDetailSalaryException() {
		return this.__detail_salaryexception;
	}

	public void setDetailSalaryException( List<BaseSalaryException> value ) {
		this.__detail_salaryexception = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate 工资异常申请表 DAO
		SalaryException salaryexception = new SalaryException();
		// load the original details.
		salaryexception.setConditionPersonnelBusinessId("=", getPersonnelBusinessId());
		List<BaseSalaryException> originalsalaryexception = salaryexception.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailSalaryException() != null) {
			// need to delete list.
			List<BaseSalaryException> needToDeleteSalaryException = new ArrayList<>();
			// need to add list.
			List<BaseSalaryException> needToAddSalaryException = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseSalaryException __salaryexception : getDetailSalaryException() ) {
				// set the relative field.
				__salaryexception.setPersonnelBusinessId( getPersonnelBusinessId());
				// set find flag
				boolean foundSalaryException = false;
				// find the original list.
				for(BaseSalaryException __originalsalaryexception : originalsalaryexception) {
					// if found the original record
					if(__salaryexception.compareTo(__originalsalaryexception) == 0) {
						// set found flag to true
						foundSalaryException = true;
						// update the record.
						// clear DAO's data
						salaryexception.clearCurrentData();
						// set original data into DAO
						salaryexception.setDataFromBase(__originalsalaryexception);
						// clear DAO modification flag, just like the is loaded from DB
						salaryexception.clearModifiedFlags();
						// set current data into DAO
						salaryexception.setDataFromBase(__salaryexception);
						// execute update
						salaryexception.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundSalaryException) needToAddSalaryException.add(__salaryexception);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseSalaryException __originalsalaryexception : originalsalaryexception) {
				boolean foundSalaryException = false;
				for(BaseSalaryException __salaryexception : getDetailSalaryException() ) {
					if(__salaryexception.compareTo(__originalsalaryexception) == 0) {
						foundSalaryException = true;
						break;
				}
				}
				if(!foundSalaryException) needToDeleteSalaryException.add(__originalsalaryexception);
			}
			// process need-to-add list
			for(BaseSalaryException __salaryexception : needToAddSalaryException ) {
				salaryexception.clearCurrentData();
				salaryexception.setDataFromBase(__salaryexception);
				salaryexception.save();
				__salaryexception.setSalaryExceptionId(salaryexception.getSalaryExceptionId());
			}
			// process need-to-delete list
			for(BaseSalaryException __salaryexception : needToDeleteSalaryException ) {
				deleteFromSalaryException(__salaryexception, salaryexception);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseSalaryException __salaryexception : originalsalaryexception ) {
				deleteFromSalaryException(__salaryexception, salaryexception);
			}
		}
	}

	private void deleteFromSalaryException(BaseSalaryException bean, SalaryException dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setPersonnelBusinessId(null);
		if(__detail_delete_salaryexception) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		SalaryException salaryexception = new SalaryException();
		salaryexception.setConditionPersonnelBusinessId("=", getPersonnelBusinessId());
		salaryexception.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			SalaryException salaryexception = new SalaryException();
			salaryexception.setConditionPersonnelBusinessId("=", getPersonnelBusinessId());
			setDetailSalaryException(salaryexception.conditionalLoad());
		}
		return true;
	}

	public List<BasePersonnelBusinesWithS> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BasePersonnelBusinesWithS> result = BasePersonnelBusinesWithS.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BasePersonnelBusinesWithS generateBaseExt() {
		BasePersonnelBusinesWithS ____result = new BasePersonnelBusinesWithS();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BasePersonnelBusinesWithS __base) {
		super.setDataFromBase(__base);
		setDetailSalaryException(__base.getDetailSalaryException());
	}

	public void setDataToBase(BasePersonnelBusinesWithS __base) {
		super.setDataToBase(__base);
		__base.setDetailSalaryException(getDetailSalaryException());
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

	public boolean isDeleteDetailSalaryException() {
		return this.__detail_delete_salaryexception;
	}

	public void setDeleteDetailSalaryException( boolean value ) {
		this.__detail_delete_salaryexception = value;
	}

	protected boolean __detail_delete_salaryexception = true; 
	protected List<BaseSalaryException> __detail_salaryexception ; 
}
