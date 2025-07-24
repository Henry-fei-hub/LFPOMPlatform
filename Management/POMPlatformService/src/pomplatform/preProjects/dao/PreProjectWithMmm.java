package pomplatform.preProjects.dao;

import java.util.*;
import pomplatform.preProjects.bean.BasePreProjectWithMmm;
import com.pomplatform.db.bean.BaseMainProjectBusinessType;
import com.pomplatform.db.dao.MainProjectBusinessType;
import com.pomplatform.db.bean.BaseMainProjectSpecialty;
import com.pomplatform.db.dao.MainProjectSpecialty;
import com.pomplatform.db.bean.BaseMainProjectCompetitionUnit;
import com.pomplatform.db.dao.MainProjectCompetitionUnit;

public class PreProjectWithMmm extends com.pomplatform.db.dao.PreProject
{


	public PreProjectWithMmm() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseMainProjectBusinessType> getDetailMainProjectBusinessType() {
		return this.__detail_mainprojectbusinesstype;
	}

	public void setDetailMainProjectBusinessType( List<BaseMainProjectBusinessType> value ) {
		this.__detail_mainprojectbusinesstype = value;
	}

	public List<BaseMainProjectSpecialty> getDetailMainProjectSpecialty() {
		return this.__detail_mainprojectspecialty;
	}

	public void setDetailMainProjectSpecialty( List<BaseMainProjectSpecialty> value ) {
		this.__detail_mainprojectspecialty = value;
	}

	public List<BaseMainProjectCompetitionUnit> getDetailMainProjectCompetitionUnit() {
		return this.__detail_mainprojectcompetitionunit;
	}

	public void setDetailMainProjectCompetitionUnit( List<BaseMainProjectCompetitionUnit> value ) {
		this.__detail_mainprojectcompetitionunit = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate 前期项目的业务类别子表 DAO
		MainProjectBusinessType mainprojectbusinesstype = new MainProjectBusinessType();
		// load the original detail data.
		mainprojectbusinesstype.setConditionMainProjectId("=", getPreProjectId());
		List<BaseMainProjectBusinessType> originalmainprojectbusinesstype = mainprojectbusinesstype.conditionalLoad();
		// if current detail is not empty.
		if(getDetailMainProjectBusinessType() != null) {
			// need to delete data
			List<BaseMainProjectBusinessType> needToDeleteMainProjectBusinessType = new ArrayList<>();
			// need to add data
			List<BaseMainProjectBusinessType> needToAddMainProjectBusinessType = new ArrayList<>();
			// find that records need to be modified.
			for(BaseMainProjectBusinessType __mainprojectbusinesstype : getDetailMainProjectBusinessType() ) {
				// set that related fields.
				__mainprojectbusinesstype.setMainProjectId(getPreProjectId());
				// if found then set found flag.
				boolean foundMainProjectBusinessType = false;
				// search the original detail list.
				for(BaseMainProjectBusinessType __originalmainprojectbusinesstype : originalmainprojectbusinesstype) {
					// compare the key.
					if(__mainprojectbusinesstype.compareTo(__originalmainprojectbusinesstype) == 0) {
						// found the original record.
						foundMainProjectBusinessType = true;
						//update the record
						// clear DAO's data
						mainprojectbusinesstype.clearCurrentData();
						// set original bean data into DAO
						mainprojectbusinesstype.setDataFromBase(__originalmainprojectbusinesstype);
						// clear DAO data modification flags, just like the data reloaded from DB.
						mainprojectbusinesstype.clearModifiedFlags();
						// set the current data into DAO
						mainprojectbusinesstype.setDataFromBase(__mainprojectbusinesstype);
						// execute update 
						mainprojectbusinesstype.update();
						break;
					}
				}
				// if the data not found in the original list, then add to the need-to-add list.
				if(!foundMainProjectBusinessType) needToAddMainProjectBusinessType.add(__mainprojectbusinesstype);
			}
			// find the record that in the original list but not in the current list.
			for(BaseMainProjectBusinessType __originalmainprojectbusinesstype : originalmainprojectbusinesstype) {
				boolean foundMainProjectBusinessType = false;
				for(BaseMainProjectBusinessType __mainprojectbusinesstype : getDetailMainProjectBusinessType() ) {
					if(__mainprojectbusinesstype.compareTo(__originalmainprojectbusinesstype) == 0) {
						foundMainProjectBusinessType = true;
						break;
				}
				}
				if(!foundMainProjectBusinessType) needToDeleteMainProjectBusinessType.add(__originalmainprojectbusinesstype);
			}
			// process need-to-add list. insert into DB.
			for(BaseMainProjectBusinessType __mainprojectbusinesstype : needToAddMainProjectBusinessType ) {
				mainprojectbusinesstype.clearCurrentData();
				mainprojectbusinesstype.setDataFromBase(__mainprojectbusinesstype);
				mainprojectbusinesstype.save();
				__mainprojectbusinesstype.setMainProjectBusinessTypeId(mainprojectbusinesstype.getMainProjectBusinessTypeId());
			}
			// process need-to-delete list.
			for(BaseMainProjectBusinessType __mainprojectbusinesstype : needToDeleteMainProjectBusinessType ) {
				deleteFromMainProjectBusinessType(__mainprojectbusinesstype, mainprojectbusinesstype);
			}
		} else {
			// if current list is empty. then delete all the original details.
//			for(BaseMainProjectBusinessType __mainprojectbusinesstype : originalmainprojectbusinesstype ) {
//				deleteFromMainProjectBusinessType(__mainprojectbusinesstype, mainprojectbusinesstype);
//			}
		}
		// instantiate 前期项目的专业子表 DAO
		MainProjectSpecialty mainprojectspecialty = new MainProjectSpecialty();
		// load the original detail data.
		mainprojectspecialty.setConditionMainProjectId("=", getPreProjectId());
		List<BaseMainProjectSpecialty> originalmainprojectspecialty = mainprojectspecialty.conditionalLoad();
		// if current detail is not empty.
		if(getDetailMainProjectSpecialty() != null) {
			// need to delete data
			List<BaseMainProjectSpecialty> needToDeleteMainProjectSpecialty = new ArrayList<>();
			// need to add data
			List<BaseMainProjectSpecialty> needToAddMainProjectSpecialty = new ArrayList<>();
			// find that records need to be modified.
			for(BaseMainProjectSpecialty __mainprojectspecialty : getDetailMainProjectSpecialty() ) {
				// set that related fields.
				__mainprojectspecialty.setMainProjectId(getPreProjectId());
				// if found then set found flag.
				boolean foundMainProjectSpecialty = false;
				// search the original detail list.
				for(BaseMainProjectSpecialty __originalmainprojectspecialty : originalmainprojectspecialty) {
					// compare the key.
					if(__mainprojectspecialty.compareTo(__originalmainprojectspecialty) == 0) {
						// found the original record.
						foundMainProjectSpecialty = true;
						//update the record
						// clear DAO's data
						mainprojectspecialty.clearCurrentData();
						// set original bean data into DAO
						mainprojectspecialty.setDataFromBase(__originalmainprojectspecialty);
						// clear DAO data modification flags, just like the data reloaded from DB.
						mainprojectspecialty.clearModifiedFlags();
						// set the current data into DAO
						mainprojectspecialty.setDataFromBase(__mainprojectspecialty);
						// execute update 
						mainprojectspecialty.update();
						break;
					}
				}
				// if the data not found in the original list, then add to the need-to-add list.
				if(!foundMainProjectSpecialty) needToAddMainProjectSpecialty.add(__mainprojectspecialty);
			}
			// find the record that in the original list but not in the current list.
			for(BaseMainProjectSpecialty __originalmainprojectspecialty : originalmainprojectspecialty) {
				boolean foundMainProjectSpecialty = false;
				for(BaseMainProjectSpecialty __mainprojectspecialty : getDetailMainProjectSpecialty() ) {
					if(__mainprojectspecialty.compareTo(__originalmainprojectspecialty) == 0) {
						foundMainProjectSpecialty = true;
						break;
				}
				}
				if(!foundMainProjectSpecialty) needToDeleteMainProjectSpecialty.add(__originalmainprojectspecialty);
			}
			// process need-to-add list. insert into DB.
			for(BaseMainProjectSpecialty __mainprojectspecialty : needToAddMainProjectSpecialty ) {
				mainprojectspecialty.clearCurrentData();
				mainprojectspecialty.setDataFromBase(__mainprojectspecialty);
				mainprojectspecialty.save();
				__mainprojectspecialty.setMainProjectSpecialtyId(mainprojectspecialty.getMainProjectSpecialtyId());
			}
			// process need-to-delete list.
			for(BaseMainProjectSpecialty __mainprojectspecialty : needToDeleteMainProjectSpecialty ) {
				deleteFromMainProjectSpecialty(__mainprojectspecialty, mainprojectspecialty);
			}
		} else {
			// if current list is empty. then delete all the original details.
//			for(BaseMainProjectSpecialty __mainprojectspecialty : originalmainprojectspecialty ) {
//				deleteFromMainProjectSpecialty(__mainprojectspecialty, mainprojectspecialty);
//			}
		}
		// instantiate 前期项目的竞争单位子表 DAO
		MainProjectCompetitionUnit mainprojectcompetitionunit = new MainProjectCompetitionUnit();
		// load the original detail data.
		mainprojectcompetitionunit.setConditionMainProjectId("=", getPreProjectId());
		List<BaseMainProjectCompetitionUnit> originalmainprojectcompetitionunit = mainprojectcompetitionunit.conditionalLoad();
		// if current detail is not empty.
		if(getDetailMainProjectCompetitionUnit() != null) {
			// need to delete data
			List<BaseMainProjectCompetitionUnit> needToDeleteMainProjectCompetitionUnit = new ArrayList<>();
			// need to add data
			List<BaseMainProjectCompetitionUnit> needToAddMainProjectCompetitionUnit = new ArrayList<>();
			// find that records need to be modified.
			for(BaseMainProjectCompetitionUnit __mainprojectcompetitionunit : getDetailMainProjectCompetitionUnit() ) {
				// set that related fields.
				__mainprojectcompetitionunit.setMainProjectId(getPreProjectId());
				// if found then set found flag.
				boolean foundMainProjectCompetitionUnit = false;
				// search the original detail list.
				for(BaseMainProjectCompetitionUnit __originalmainprojectcompetitionunit : originalmainprojectcompetitionunit) {
					// compare the key.
					if(__mainprojectcompetitionunit.compareTo(__originalmainprojectcompetitionunit) == 0) {
						// found the original record.
						foundMainProjectCompetitionUnit = true;
						//update the record
						// clear DAO's data
						mainprojectcompetitionunit.clearCurrentData();
						// set original bean data into DAO
						mainprojectcompetitionunit.setDataFromBase(__originalmainprojectcompetitionunit);
						// clear DAO data modification flags, just like the data reloaded from DB.
						mainprojectcompetitionunit.clearModifiedFlags();
						// set the current data into DAO
						mainprojectcompetitionunit.setDataFromBase(__mainprojectcompetitionunit);
						// execute update 
						mainprojectcompetitionunit.update();
						break;
					}
				}
				// if the data not found in the original list, then add to the need-to-add list.
				if(!foundMainProjectCompetitionUnit) needToAddMainProjectCompetitionUnit.add(__mainprojectcompetitionunit);
			}
			// find the record that in the original list but not in the current list.
			for(BaseMainProjectCompetitionUnit __originalmainprojectcompetitionunit : originalmainprojectcompetitionunit) {
				boolean foundMainProjectCompetitionUnit = false;
				for(BaseMainProjectCompetitionUnit __mainprojectcompetitionunit : getDetailMainProjectCompetitionUnit() ) {
					if(__mainprojectcompetitionunit.compareTo(__originalmainprojectcompetitionunit) == 0) {
						foundMainProjectCompetitionUnit = true;
						break;
				}
				}
				if(!foundMainProjectCompetitionUnit) needToDeleteMainProjectCompetitionUnit.add(__originalmainprojectcompetitionunit);
			}
			// process need-to-add list. insert into DB.
			for(BaseMainProjectCompetitionUnit __mainprojectcompetitionunit : needToAddMainProjectCompetitionUnit ) {
				mainprojectcompetitionunit.clearCurrentData();
				mainprojectcompetitionunit.setDataFromBase(__mainprojectcompetitionunit);
				mainprojectcompetitionunit.save();
				__mainprojectcompetitionunit.setMainProjectCompetitionUnitId(mainprojectcompetitionunit.getMainProjectCompetitionUnitId());
			}
			// process need-to-delete list.
			for(BaseMainProjectCompetitionUnit __mainprojectcompetitionunit : needToDeleteMainProjectCompetitionUnit ) {
				deleteFromMainProjectCompetitionUnit(__mainprojectcompetitionunit, mainprojectcompetitionunit);
			}
		} else {
			// if current list is empty. then delete all the original details.
//			for(BaseMainProjectCompetitionUnit __mainprojectcompetitionunit : originalmainprojectcompetitionunit ) {
//				deleteFromMainProjectCompetitionUnit(__mainprojectcompetitionunit, mainprojectcompetitionunit);
//			}
		}
	}

	private void deleteFromMainProjectBusinessType(BaseMainProjectBusinessType bean, MainProjectBusinessType dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setMainProjectId(null);
		if(__detail_delete_mainprojectbusinesstype) dao.delete(); else dao.update();
	}

	private void deleteFromMainProjectSpecialty(BaseMainProjectSpecialty bean, MainProjectSpecialty dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setMainProjectId(null);
		if(__detail_delete_mainprojectspecialty) dao.delete(); else dao.update();
	}

	private void deleteFromMainProjectCompetitionUnit(BaseMainProjectCompetitionUnit bean, MainProjectCompetitionUnit dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setMainProjectId(null);
		if(__detail_delete_mainprojectcompetitionunit) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		MainProjectBusinessType mainprojectbusinesstype = new MainProjectBusinessType();
		mainprojectbusinesstype.setConditionMainProjectId("=", getPreProjectId());
		mainprojectbusinesstype.conditionalDelete();
		MainProjectSpecialty mainprojectspecialty = new MainProjectSpecialty();
		mainprojectspecialty.setConditionMainProjectId("=", getPreProjectId());
		mainprojectspecialty.conditionalDelete();
		MainProjectCompetitionUnit mainprojectcompetitionunit = new MainProjectCompetitionUnit();
		mainprojectcompetitionunit.setConditionMainProjectId("=", getPreProjectId());
		mainprojectcompetitionunit.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			MainProjectBusinessType mainprojectbusinesstype = new MainProjectBusinessType();
			mainprojectbusinesstype.setConditionMainProjectId("=", getPreProjectId());
			setDetailMainProjectBusinessType(mainprojectbusinesstype.conditionalLoad());
			MainProjectSpecialty mainprojectspecialty = new MainProjectSpecialty();
			mainprojectspecialty.setConditionMainProjectId("=", getPreProjectId());
			setDetailMainProjectSpecialty(mainprojectspecialty.conditionalLoad());
			MainProjectCompetitionUnit mainprojectcompetitionunit = new MainProjectCompetitionUnit();
			mainprojectcompetitionunit.setConditionMainProjectId("=", getPreProjectId());
			setDetailMainProjectCompetitionUnit(mainprojectcompetitionunit.conditionalLoad());
		}
		return true;
	}

	public List<BasePreProjectWithMmm> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BasePreProjectWithMmm> result = BasePreProjectWithMmm.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BasePreProjectWithMmm generateBaseExt() {
		BasePreProjectWithMmm ____result = new BasePreProjectWithMmm();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BasePreProjectWithMmm __base) {
		super.setDataFromBase(__base);
		setDetailMainProjectBusinessType(__base.getDetailMainProjectBusinessType());
		setDetailMainProjectSpecialty(__base.getDetailMainProjectSpecialty());
		setDetailMainProjectCompetitionUnit(__base.getDetailMainProjectCompetitionUnit());
	}

	public void setDataToBase(BasePreProjectWithMmm __base) {
		super.setDataToBase(__base);
		__base.setDetailMainProjectBusinessType(getDetailMainProjectBusinessType());
		__base.setDetailMainProjectSpecialty(getDetailMainProjectSpecialty());
		__base.setDetailMainProjectCompetitionUnit(getDetailMainProjectCompetitionUnit());
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

	public boolean isDeleteDetailMainProjectBusinessType() {
		return this.__detail_delete_mainprojectbusinesstype;
	}

	public void setDeleteDetailMainProjectBusinessType( boolean value ) {
		this.__detail_delete_mainprojectbusinesstype = value;
	}

	protected boolean __detail_delete_mainprojectbusinesstype = true; 
	protected List<BaseMainProjectBusinessType> __detail_mainprojectbusinesstype ; 
	public boolean isDeleteDetailMainProjectSpecialty() {
		return this.__detail_delete_mainprojectspecialty;
	}

	public void setDeleteDetailMainProjectSpecialty( boolean value ) {
		this.__detail_delete_mainprojectspecialty = value;
	}

	protected boolean __detail_delete_mainprojectspecialty = true; 
	protected List<BaseMainProjectSpecialty> __detail_mainprojectspecialty ; 
	public boolean isDeleteDetailMainProjectCompetitionUnit() {
		return this.__detail_delete_mainprojectcompetitionunit;
	}

	public void setDeleteDetailMainProjectCompetitionUnit( boolean value ) {
		this.__detail_delete_mainprojectcompetitionunit = value;
	}

	protected boolean __detail_delete_mainprojectcompetitionunit = true; 
	protected List<BaseMainProjectCompetitionUnit> __detail_mainprojectcompetitionunit ; 
}
