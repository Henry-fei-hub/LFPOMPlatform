package pomplatform.companyarea.dao;

import java.util.*;
import pomplatform.companyarea.bean.BaseCompanyAreaWithCa;
import com.pomplatform.db.bean.BaseCompanyRecord;
import com.pomplatform.db.dao.CompanyRecord;
import com.pomplatform.db.bean.BaseArea;
import com.pomplatform.db.dao.Area;

public class CompanyAreaWithCa extends com.pomplatform.db.dao.CompanyArea
{


	public CompanyAreaWithCa() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseCompanyRecord> getDetailCompanyRecord() {
		return this.__detail_companyrecord;
	}

	public void setDetailCompanyRecord( List<BaseCompanyRecord> value ) {
		this.__detail_companyrecord = value;
	}

	public List<BaseArea> getDetailArea() {
		return this.__detail_area;
	}

	public void setDetailArea( List<BaseArea> value ) {
		this.__detail_area = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate 公司表 DAO
		CompanyRecord companyrecord = new CompanyRecord();
		// load the original details.
		companyrecord.setConditionCompanyRecordId("=", getCompanyId());
		List<BaseCompanyRecord> originalcompanyrecord = companyrecord.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailCompanyRecord() != null) {
			// need to delete list.
			List<BaseCompanyRecord> needToDeleteCompanyRecord = new ArrayList<>();
			// need to add list.
			List<BaseCompanyRecord> needToAddCompanyRecord = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseCompanyRecord __companyrecord : getDetailCompanyRecord() ) {
				// set the relative field.
				__companyrecord.setCompanyRecordId( getCompanyId());
				// set find flag
				boolean foundCompanyRecord = false;
				// find the original list.
				for(BaseCompanyRecord __originalcompanyrecord : originalcompanyrecord) {
					// if found the original record
					if(__companyrecord.compareTo(__originalcompanyrecord) == 0) {
						// set found flag to true
						foundCompanyRecord = true;
						// update the record.
						// clear DAO's data
						companyrecord.clearCurrentData();
						// set original data into DAO
						companyrecord.setDataFromBase(__originalcompanyrecord);
						// clear DAO modification flag, just like the is loaded from DB
						companyrecord.clearModifiedFlags();
						// set current data into DAO
						companyrecord.setDataFromBase(__companyrecord);
						// execute update
						companyrecord.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundCompanyRecord) needToAddCompanyRecord.add(__companyrecord);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseCompanyRecord __originalcompanyrecord : originalcompanyrecord) {
				boolean foundCompanyRecord = false;
				for(BaseCompanyRecord __companyrecord : getDetailCompanyRecord() ) {
					if(__companyrecord.compareTo(__originalcompanyrecord) == 0) {
						foundCompanyRecord = true;
						break;
				}
				}
				if(!foundCompanyRecord) needToDeleteCompanyRecord.add(__originalcompanyrecord);
			}
			// process need-to-add list
			for(BaseCompanyRecord __companyrecord : needToAddCompanyRecord ) {
				companyrecord.clearCurrentData();
				companyrecord.setDataFromBase(__companyrecord);
				companyrecord.save();
				__companyrecord.setCompanyRecordId(companyrecord.getCompanyRecordId());
			}
			// process need-to-delete list
			for(BaseCompanyRecord __companyrecord : needToDeleteCompanyRecord ) {
				deleteFromCompanyRecord(__companyrecord, companyrecord);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseCompanyRecord __companyrecord : originalcompanyrecord ) {
				deleteFromCompanyRecord(__companyrecord, companyrecord);
			}
		}
		// instantiate  DAO
		Area area = new Area();
		// load the original details.
		area.setConditionAreaId("=", getAreaId());
		List<BaseArea> originalarea = area.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailArea() != null) {
			// need to delete list.
			List<BaseArea> needToDeleteArea = new ArrayList<>();
			// need to add list.
			List<BaseArea> needToAddArea = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseArea __area : getDetailArea() ) {
				// set the relative field.
				__area.setAreaId( getAreaId());
				// set find flag
				boolean foundArea = false;
				// find the original list.
				for(BaseArea __originalarea : originalarea) {
					// if found the original record
					if(__area.compareTo(__originalarea) == 0) {
						// set found flag to true
						foundArea = true;
						// update the record.
						// clear DAO's data
						area.clearCurrentData();
						// set original data into DAO
						area.setDataFromBase(__originalarea);
						// clear DAO modification flag, just like the is loaded from DB
						area.clearModifiedFlags();
						// set current data into DAO
						area.setDataFromBase(__area);
						// execute update
						area.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundArea) needToAddArea.add(__area);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseArea __originalarea : originalarea) {
				boolean foundArea = false;
				for(BaseArea __area : getDetailArea() ) {
					if(__area.compareTo(__originalarea) == 0) {
						foundArea = true;
						break;
				}
				}
				if(!foundArea) needToDeleteArea.add(__originalarea);
			}
			// process need-to-add list
			for(BaseArea __area : needToAddArea ) {
				area.clearCurrentData();
				area.setDataFromBase(__area);
				area.save();
				__area.setAreaId(area.getAreaId());
			}
			// process need-to-delete list
			for(BaseArea __area : needToDeleteArea ) {
				deleteFromArea(__area, area);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseArea __area : originalarea ) {
				deleteFromArea(__area, area);
			}
		}
	}

	private void deleteFromCompanyRecord(BaseCompanyRecord bean, CompanyRecord dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setCompanyRecordId(null);
		if(__detail_delete_companyrecord) dao.delete(); else dao.update();
	}

	private void deleteFromArea(BaseArea bean, Area dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setAreaId(null);
		if(__detail_delete_area) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		CompanyRecord companyrecord = new CompanyRecord();
		companyrecord.setConditionCompanyRecordId("=", getCompanyId());
		companyrecord.conditionalDelete();
		Area area = new Area();
		area.setConditionAreaId("=", getAreaId());
		area.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			CompanyRecord companyrecord = new CompanyRecord();
			companyrecord.setConditionCompanyRecordId("=", getCompanyId());
			setDetailCompanyRecord(companyrecord.conditionalLoad());
			Area area = new Area();
			area.setConditionAreaId("=", getAreaId());
			setDetailArea(area.conditionalLoad());
		}
		return true;
	}

	public List<BaseCompanyAreaWithCa> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseCompanyAreaWithCa> result = BaseCompanyAreaWithCa.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseCompanyAreaWithCa generateBaseExt() {
		BaseCompanyAreaWithCa ____result = new BaseCompanyAreaWithCa();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseCompanyAreaWithCa __base) {
		super.setDataFromBase(__base);
		setDetailCompanyRecord(__base.getDetailCompanyRecord());
		setDetailArea(__base.getDetailArea());
	}

	public void setDataToBase(BaseCompanyAreaWithCa __base) {
		super.setDataToBase(__base);
		__base.setDetailCompanyRecord(getDetailCompanyRecord());
		__base.setDetailArea(getDetailArea());
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

	public boolean isDeleteDetailCompanyRecord() {
		return this.__detail_delete_companyrecord;
	}

	public void setDeleteDetailCompanyRecord( boolean value ) {
		this.__detail_delete_companyrecord = value;
	}

	protected boolean __detail_delete_companyrecord = true; 
	protected List<BaseCompanyRecord> __detail_companyrecord ; 
	public boolean isDeleteDetailArea() {
		return this.__detail_delete_area;
	}

	public void setDeleteDetailArea( boolean value ) {
		this.__detail_delete_area = value;
	}

	protected boolean __detail_delete_area = true; 
	protected List<BaseArea> __detail_area ; 
}
