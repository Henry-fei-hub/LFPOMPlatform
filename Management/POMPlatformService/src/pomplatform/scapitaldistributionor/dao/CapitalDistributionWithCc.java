package pomplatform.scapitaldistributionor.dao;

import java.util.*;
import pomplatform.scapitaldistributionor.bean.BaseCapitalDistributionWithCc;
import com.pomplatform.db.bean.BaseCapitalDistributionLinkDepartment;
import com.pomplatform.db.dao.CapitalDistributionLinkDepartment;
import com.pomplatform.db.bean.BaseCapitalDistributionLinkSubContract;
import com.pomplatform.db.dao.CapitalDistributionLinkSubContract;

public class CapitalDistributionWithCc extends com.pomplatform.db.dao.CapitalDistribution
{


	public CapitalDistributionWithCc() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseCapitalDistributionLinkDepartment> getDetailCapitalDistributionLinkDepartment() {
		return this.__detail_capitaldistributionlinkdepartment;
	}

	public void setDetailCapitalDistributionLinkDepartment( List<BaseCapitalDistributionLinkDepartment> value ) {
		this.__detail_capitaldistributionlinkdepartment = value;
	}

	public List<BaseCapitalDistributionLinkSubContract> getDetailCapitalDistributionLinkSubContract() {
		return this.__detail_capitaldistributionlinksubcontract;
	}

	public void setDetailCapitalDistributionLinkSubContract( List<BaseCapitalDistributionLinkSubContract> value ) {
		this.__detail_capitaldistributionlinksubcontract = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate  DAO
		CapitalDistributionLinkDepartment capitaldistributionlinkdepartment = new CapitalDistributionLinkDepartment();
		// load the original details.
		capitaldistributionlinkdepartment.setConditionCapitalDistributionId("=", getCapitalDistributionId());
		List<BaseCapitalDistributionLinkDepartment> originalcapitaldistributionlinkdepartment = capitaldistributionlinkdepartment.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailCapitalDistributionLinkDepartment() != null) {
			// need to delete list.
			List<BaseCapitalDistributionLinkDepartment> needToDeleteCapitalDistributionLinkDepartment = new ArrayList<>();
			// need to add list.
			List<BaseCapitalDistributionLinkDepartment> needToAddCapitalDistributionLinkDepartment = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseCapitalDistributionLinkDepartment __capitaldistributionlinkdepartment : getDetailCapitalDistributionLinkDepartment() ) {
				// set the relative field.
				__capitaldistributionlinkdepartment.setCapitalDistributionId( getCapitalDistributionId());
				// set find flag
				boolean foundCapitalDistributionLinkDepartment = false;
				// find the original list.
				for(BaseCapitalDistributionLinkDepartment __originalcapitaldistributionlinkdepartment : originalcapitaldistributionlinkdepartment) {
					// if found the original record
					if(__capitaldistributionlinkdepartment.compareTo(__originalcapitaldistributionlinkdepartment) == 0) {
						// set found flag to true
						foundCapitalDistributionLinkDepartment = true;
						// update the record.
						// clear DAO's data
						capitaldistributionlinkdepartment.clearCurrentData();
						// set original data into DAO
						capitaldistributionlinkdepartment.setDataFromBase(__originalcapitaldistributionlinkdepartment);
						// clear DAO modification flag, just like the is loaded from DB
						capitaldistributionlinkdepartment.clearModifiedFlags();
						// set current data into DAO
						capitaldistributionlinkdepartment.setDataFromBase(__capitaldistributionlinkdepartment);
						// execute update
						capitaldistributionlinkdepartment.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundCapitalDistributionLinkDepartment) needToAddCapitalDistributionLinkDepartment.add(__capitaldistributionlinkdepartment);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseCapitalDistributionLinkDepartment __originalcapitaldistributionlinkdepartment : originalcapitaldistributionlinkdepartment) {
				boolean foundCapitalDistributionLinkDepartment = false;
				for(BaseCapitalDistributionLinkDepartment __capitaldistributionlinkdepartment : getDetailCapitalDistributionLinkDepartment() ) {
					if(__capitaldistributionlinkdepartment.compareTo(__originalcapitaldistributionlinkdepartment) == 0) {
						foundCapitalDistributionLinkDepartment = true;
						break;
				}
				}
				if(!foundCapitalDistributionLinkDepartment) needToDeleteCapitalDistributionLinkDepartment.add(__originalcapitaldistributionlinkdepartment);
			}
			// process need-to-add list
			for(BaseCapitalDistributionLinkDepartment __capitaldistributionlinkdepartment : needToAddCapitalDistributionLinkDepartment ) {
				capitaldistributionlinkdepartment.setPrimaryKeyFromBase(__capitaldistributionlinkdepartment);
				// if the primay key is null, then insert into DB
				if(capitaldistributionlinkdepartment.isPrimaryKeyNull()) { capitaldistributionlinkdepartment.clearCurrentData(); capitaldistributionlinkdepartment.setDataFromBase(__capitaldistributionlinkdepartment); capitaldistributionlinkdepartment.save(); }
				// otherwise load and update
				else { if(capitaldistributionlinkdepartment.load()) { capitaldistributionlinkdepartment.setDataFromBase(__capitaldistributionlinkdepartment); capitaldistributionlinkdepartment.update(); } else { capitaldistributionlinkdepartment.clearCurrentData(); capitaldistributionlinkdepartment.setDataFromBase(__capitaldistributionlinkdepartment); capitaldistributionlinkdepartment.save(); } }
			}
			// process need-to-delete list
			for(BaseCapitalDistributionLinkDepartment __capitaldistributionlinkdepartment : needToDeleteCapitalDistributionLinkDepartment ) {
				deleteFromCapitalDistributionLinkDepartment(__capitaldistributionlinkdepartment, capitaldistributionlinkdepartment);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseCapitalDistributionLinkDepartment __capitaldistributionlinkdepartment : originalcapitaldistributionlinkdepartment ) {
				deleteFromCapitalDistributionLinkDepartment(__capitaldistributionlinkdepartment, capitaldistributionlinkdepartment);
			}
		}
		// instantiate  DAO
		CapitalDistributionLinkSubContract capitaldistributionlinksubcontract = new CapitalDistributionLinkSubContract();
		// load the original details.
		capitaldistributionlinksubcontract.setConditionCapitalDistributionId("=", getCapitalDistributionId());
		List<BaseCapitalDistributionLinkSubContract> originalcapitaldistributionlinksubcontract = capitaldistributionlinksubcontract.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailCapitalDistributionLinkSubContract() != null) {
			// need to delete list.
			List<BaseCapitalDistributionLinkSubContract> needToDeleteCapitalDistributionLinkSubContract = new ArrayList<>();
			// need to add list.
			List<BaseCapitalDistributionLinkSubContract> needToAddCapitalDistributionLinkSubContract = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseCapitalDistributionLinkSubContract __capitaldistributionlinksubcontract : getDetailCapitalDistributionLinkSubContract() ) {
				// set the relative field.
				__capitaldistributionlinksubcontract.setCapitalDistributionId( getCapitalDistributionId());
				// set find flag
				boolean foundCapitalDistributionLinkSubContract = false;
				// find the original list.
				for(BaseCapitalDistributionLinkSubContract __originalcapitaldistributionlinksubcontract : originalcapitaldistributionlinksubcontract) {
					// if found the original record
					if(__capitaldistributionlinksubcontract.compareTo(__originalcapitaldistributionlinksubcontract) == 0) {
						// set found flag to true
						foundCapitalDistributionLinkSubContract = true;
						// update the record.
						// clear DAO's data
						capitaldistributionlinksubcontract.clearCurrentData();
						// set original data into DAO
						capitaldistributionlinksubcontract.setDataFromBase(__originalcapitaldistributionlinksubcontract);
						// clear DAO modification flag, just like the is loaded from DB
						capitaldistributionlinksubcontract.clearModifiedFlags();
						// set current data into DAO
						capitaldistributionlinksubcontract.setDataFromBase(__capitaldistributionlinksubcontract);
						// execute update
						capitaldistributionlinksubcontract.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundCapitalDistributionLinkSubContract) needToAddCapitalDistributionLinkSubContract.add(__capitaldistributionlinksubcontract);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseCapitalDistributionLinkSubContract __originalcapitaldistributionlinksubcontract : originalcapitaldistributionlinksubcontract) {
				boolean foundCapitalDistributionLinkSubContract = false;
				for(BaseCapitalDistributionLinkSubContract __capitaldistributionlinksubcontract : getDetailCapitalDistributionLinkSubContract() ) {
					if(__capitaldistributionlinksubcontract.compareTo(__originalcapitaldistributionlinksubcontract) == 0) {
						foundCapitalDistributionLinkSubContract = true;
						break;
				}
				}
				if(!foundCapitalDistributionLinkSubContract) needToDeleteCapitalDistributionLinkSubContract.add(__originalcapitaldistributionlinksubcontract);
			}
			// process need-to-add list
			for(BaseCapitalDistributionLinkSubContract __capitaldistributionlinksubcontract : needToAddCapitalDistributionLinkSubContract ) {
				capitaldistributionlinksubcontract.setPrimaryKeyFromBase(__capitaldistributionlinksubcontract);
				// if the primay key is null, then insert into DB
				if(capitaldistributionlinksubcontract.isPrimaryKeyNull()) { capitaldistributionlinksubcontract.clearCurrentData(); capitaldistributionlinksubcontract.setDataFromBase(__capitaldistributionlinksubcontract); capitaldistributionlinksubcontract.save(); }
				// otherwise load and update
				else { if(capitaldistributionlinksubcontract.load()) { capitaldistributionlinksubcontract.setDataFromBase(__capitaldistributionlinksubcontract); capitaldistributionlinksubcontract.update(); } else { capitaldistributionlinksubcontract.clearCurrentData(); capitaldistributionlinksubcontract.setDataFromBase(__capitaldistributionlinksubcontract); capitaldistributionlinksubcontract.save(); } }
			}
			// process need-to-delete list
			for(BaseCapitalDistributionLinkSubContract __capitaldistributionlinksubcontract : needToDeleteCapitalDistributionLinkSubContract ) {
				deleteFromCapitalDistributionLinkSubContract(__capitaldistributionlinksubcontract, capitaldistributionlinksubcontract);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseCapitalDistributionLinkSubContract __capitaldistributionlinksubcontract : originalcapitaldistributionlinksubcontract ) {
				deleteFromCapitalDistributionLinkSubContract(__capitaldistributionlinksubcontract, capitaldistributionlinksubcontract);
			}
		}
	}

	private void deleteFromCapitalDistributionLinkDepartment(BaseCapitalDistributionLinkDepartment bean, CapitalDistributionLinkDepartment dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setCapitalDistributionId(null);
		if(__detail_delete_capitaldistributionlinkdepartment) dao.delete(); else dao.update();
	}

	private void deleteFromCapitalDistributionLinkSubContract(BaseCapitalDistributionLinkSubContract bean, CapitalDistributionLinkSubContract dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setCapitalDistributionId(null);
		if(__detail_delete_capitaldistributionlinksubcontract) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		CapitalDistributionLinkDepartment capitaldistributionlinkdepartment = new CapitalDistributionLinkDepartment();
		capitaldistributionlinkdepartment.setConditionCapitalDistributionId("=", getCapitalDistributionId());
		capitaldistributionlinkdepartment.conditionalDelete();
		CapitalDistributionLinkSubContract capitaldistributionlinksubcontract = new CapitalDistributionLinkSubContract();
		capitaldistributionlinksubcontract.setConditionCapitalDistributionId("=", getCapitalDistributionId());
		capitaldistributionlinksubcontract.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			CapitalDistributionLinkDepartment capitaldistributionlinkdepartment = new CapitalDistributionLinkDepartment();
			capitaldistributionlinkdepartment.setConditionCapitalDistributionId("=", getCapitalDistributionId());
			setDetailCapitalDistributionLinkDepartment(capitaldistributionlinkdepartment.conditionalLoad());
			CapitalDistributionLinkSubContract capitaldistributionlinksubcontract = new CapitalDistributionLinkSubContract();
			capitaldistributionlinksubcontract.setConditionCapitalDistributionId("=", getCapitalDistributionId());
			setDetailCapitalDistributionLinkSubContract(capitaldistributionlinksubcontract.conditionalLoad());
		}
		return true;
	}

	public List<BaseCapitalDistributionWithCc> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseCapitalDistributionWithCc> result = BaseCapitalDistributionWithCc.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseCapitalDistributionWithCc generateBaseExt() {
		BaseCapitalDistributionWithCc ____result = new BaseCapitalDistributionWithCc();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseCapitalDistributionWithCc __base) {
		super.setDataFromBase(__base);
		setDetailCapitalDistributionLinkDepartment(__base.getDetailCapitalDistributionLinkDepartment());
		setDetailCapitalDistributionLinkSubContract(__base.getDetailCapitalDistributionLinkSubContract());
	}

	public void setDataToBase(BaseCapitalDistributionWithCc __base) {
		super.setDataToBase(__base);
		__base.setDetailCapitalDistributionLinkDepartment(getDetailCapitalDistributionLinkDepartment());
		__base.setDetailCapitalDistributionLinkSubContract(getDetailCapitalDistributionLinkSubContract());
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

	public boolean isDeleteDetailCapitalDistributionLinkDepartment() {
		return this.__detail_delete_capitaldistributionlinkdepartment;
	}

	public void setDeleteDetailCapitalDistributionLinkDepartment( boolean value ) {
		this.__detail_delete_capitaldistributionlinkdepartment = value;
	}

	protected boolean __detail_delete_capitaldistributionlinkdepartment = true; 
	protected List<BaseCapitalDistributionLinkDepartment> __detail_capitaldistributionlinkdepartment ; 
	public boolean isDeleteDetailCapitalDistributionLinkSubContract() {
		return this.__detail_delete_capitaldistributionlinksubcontract;
	}

	public void setDeleteDetailCapitalDistributionLinkSubContract( boolean value ) {
		this.__detail_delete_capitaldistributionlinksubcontract = value;
	}

	protected boolean __detail_delete_capitaldistributionlinksubcontract = true; 
	protected List<BaseCapitalDistributionLinkSubContract> __detail_capitaldistributionlinksubcontract ; 
}
