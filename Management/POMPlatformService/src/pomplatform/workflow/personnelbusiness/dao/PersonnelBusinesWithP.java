package pomplatform.workflow.personnelbusiness.dao;

import java.util.*;
import pomplatform.workflow.personnelbusiness.bean.BasePersonnelBusinesWithP;
import com.pomplatform.db.bean.BasePersonnelBusinessLinkEquipment;
import com.pomplatform.db.dao.PersonnelBusinessLinkEquipment;

public class PersonnelBusinesWithP extends com.pomplatform.db.dao.PersonnelBusines
{


	public PersonnelBusinesWithP() throws java.sql.SQLException { initColumnNames(); }

	public List<BasePersonnelBusinessLinkEquipment> getDetailPersonnelBusinessLinkEquipment() {
		return this.__detail_personnelbusinesslinkequipment;
	}

	public void setDetailPersonnelBusinessLinkEquipment( List<BasePersonnelBusinessLinkEquipment> value ) {
		this.__detail_personnelbusinesslinkequipment = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate  DAO
		PersonnelBusinessLinkEquipment personnelbusinesslinkequipment = new PersonnelBusinessLinkEquipment();
		// load the original details.
		personnelbusinesslinkequipment.setConditionParentId("=", getPersonnelBusinessId());
		personnelbusinesslinkequipment.setConditionProcessType("=", getProcessType());
		List<BasePersonnelBusinessLinkEquipment> originalpersonnelbusinesslinkequipment = personnelbusinesslinkequipment.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailPersonnelBusinessLinkEquipment() != null) {
			// need to delete list.
			List<BasePersonnelBusinessLinkEquipment> needToDeletePersonnelBusinessLinkEquipment = new ArrayList<>();
			// need to add list.
			List<BasePersonnelBusinessLinkEquipment> needToAddPersonnelBusinessLinkEquipment = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BasePersonnelBusinessLinkEquipment __personnelbusinesslinkequipment : getDetailPersonnelBusinessLinkEquipment() ) {
				// set the relative field.
				__personnelbusinesslinkequipment.setParentId( getPersonnelBusinessId());
				__personnelbusinesslinkequipment.setProcessType( getProcessType());
				// set find flag
				boolean foundPersonnelBusinessLinkEquipment = false;
				// find the original list.
				for(BasePersonnelBusinessLinkEquipment __originalpersonnelbusinesslinkequipment : originalpersonnelbusinesslinkequipment) {
					// if found the original record
					if(__personnelbusinesslinkequipment.compareTo(__originalpersonnelbusinesslinkequipment) == 0) {
						// set found flag to true
						foundPersonnelBusinessLinkEquipment = true;
						// update the record.
						// clear DAO's data
						personnelbusinesslinkequipment.clearCurrentData();
						// set original data into DAO
						personnelbusinesslinkequipment.setDataFromBase(__originalpersonnelbusinesslinkequipment);
						// clear DAO modification flag, just like the is loaded from DB
						personnelbusinesslinkequipment.clearModifiedFlags();
						// set current data into DAO
						personnelbusinesslinkequipment.setDataFromBase(__personnelbusinesslinkequipment);
						// execute update
						personnelbusinesslinkequipment.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundPersonnelBusinessLinkEquipment) needToAddPersonnelBusinessLinkEquipment.add(__personnelbusinesslinkequipment);
			}
			// find the records that exists in the original list and not in the current list.
			for(BasePersonnelBusinessLinkEquipment __originalpersonnelbusinesslinkequipment : originalpersonnelbusinesslinkequipment) {
				boolean foundPersonnelBusinessLinkEquipment = false;
				for(BasePersonnelBusinessLinkEquipment __personnelbusinesslinkequipment : getDetailPersonnelBusinessLinkEquipment() ) {
					if(__personnelbusinesslinkequipment.compareTo(__originalpersonnelbusinesslinkequipment) == 0) {
						foundPersonnelBusinessLinkEquipment = true;
						break;
				}
				}
				if(!foundPersonnelBusinessLinkEquipment) needToDeletePersonnelBusinessLinkEquipment.add(__originalpersonnelbusinesslinkequipment);
			}
			// process need-to-add list
			for(BasePersonnelBusinessLinkEquipment __personnelbusinesslinkequipment : needToAddPersonnelBusinessLinkEquipment ) {
				personnelbusinesslinkequipment.setPrimaryKeyFromBase(__personnelbusinesslinkequipment);
				// if the primay key is null, then insert into DB
				if(personnelbusinesslinkequipment.isPrimaryKeyNull()) { personnelbusinesslinkequipment.clearCurrentData(); personnelbusinesslinkequipment.setDataFromBase(__personnelbusinesslinkequipment); personnelbusinesslinkequipment.save(); }
				// otherwise load and update
				else { if(personnelbusinesslinkequipment.load()) { personnelbusinesslinkequipment.setDataFromBase(__personnelbusinesslinkequipment); personnelbusinesslinkequipment.update(); } else { personnelbusinesslinkequipment.clearCurrentData(); personnelbusinesslinkequipment.setDataFromBase(__personnelbusinesslinkequipment); personnelbusinesslinkequipment.save(); } }
			}
			// process need-to-delete list
			for(BasePersonnelBusinessLinkEquipment __personnelbusinesslinkequipment : needToDeletePersonnelBusinessLinkEquipment ) {
				deleteFromPersonnelBusinessLinkEquipment(__personnelbusinesslinkequipment, personnelbusinesslinkequipment);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BasePersonnelBusinessLinkEquipment __personnelbusinesslinkequipment : originalpersonnelbusinesslinkequipment ) {
				deleteFromPersonnelBusinessLinkEquipment(__personnelbusinesslinkequipment, personnelbusinesslinkequipment);
			}
		}
	}

	private void deleteFromPersonnelBusinessLinkEquipment(BasePersonnelBusinessLinkEquipment bean, PersonnelBusinessLinkEquipment dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setParentId(null);
		dao.setProcessType(null);
		if(__detail_delete_personnelbusinesslinkequipment) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		PersonnelBusinessLinkEquipment personnelbusinesslinkequipment = new PersonnelBusinessLinkEquipment();
		personnelbusinesslinkequipment.setConditionParentId("=", getPersonnelBusinessId());
		personnelbusinesslinkequipment.setConditionProcessType("=", getProcessType());
		personnelbusinesslinkequipment.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			PersonnelBusinessLinkEquipment personnelbusinesslinkequipment = new PersonnelBusinessLinkEquipment();
			personnelbusinesslinkequipment.setConditionParentId("=", getPersonnelBusinessId());
			personnelbusinesslinkequipment.setConditionProcessType("=", getProcessType());
			setDetailPersonnelBusinessLinkEquipment(personnelbusinesslinkequipment.conditionalLoad());
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
		setDetailPersonnelBusinessLinkEquipment(__base.getDetailPersonnelBusinessLinkEquipment());
	}

	public void setDataToBase(BasePersonnelBusinesWithP __base) {
		super.setDataToBase(__base);
		__base.setDetailPersonnelBusinessLinkEquipment(getDetailPersonnelBusinessLinkEquipment());
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

	public boolean isDeleteDetailPersonnelBusinessLinkEquipment() {
		return this.__detail_delete_personnelbusinesslinkequipment;
	}

	public void setDeleteDetailPersonnelBusinessLinkEquipment( boolean value ) {
		this.__detail_delete_personnelbusinesslinkequipment = value;
	}

	protected boolean __detail_delete_personnelbusinesslinkequipment = true; 
	protected List<BasePersonnelBusinessLinkEquipment> __detail_personnelbusinesslinkequipment ; 
}
