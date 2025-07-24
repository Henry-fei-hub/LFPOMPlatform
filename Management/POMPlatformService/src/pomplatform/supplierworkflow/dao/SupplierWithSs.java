package pomplatform.supplierworkflow.dao;

import java.util.ArrayList;
import java.util.List;

import com.pomplatform.db.bean.BaseSupplierCooperation;
import com.pomplatform.db.bean.BaseSupplierDetail;
import com.pomplatform.db.dao.SupplierCooperation;
import com.pomplatform.db.dao.SupplierDetail;

import pomplatform.supplierworkflow.bean.BaseSupplierWithSs;

public class SupplierWithSs extends com.pomplatform.db.dao.Supplier
{


	public SupplierWithSs() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseSupplierDetail> getDetailSupplierDetail() {
		return this.__detail_supplierdetail;
	}

	public void setDetailSupplierDetail( List<BaseSupplierDetail> value ) {
		this.__detail_supplierdetail = value;
	}

	public List<BaseSupplierCooperation> getDetailSupplierCooperation() {
		return this.__detail_suppliercooperation;
	}

	public void setDetailSupplierCooperation( List<BaseSupplierCooperation> value ) {
		this.__detail_suppliercooperation = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate  DAO
		SupplierDetail supplierdetail = new SupplierDetail();
		// load the original details.
		supplierdetail.setConditionSupplierId("=", getSupplierId());
		List<BaseSupplierDetail> originalsupplierdetail = supplierdetail.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailSupplierDetail() != null) {
			// need to delete list.
			List<BaseSupplierDetail> needToDeleteSupplierDetail = new ArrayList<>();
			// need to add list.
			List<BaseSupplierDetail> needToAddSupplierDetail = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseSupplierDetail __supplierdetail : getDetailSupplierDetail() ) {
				// set the relative field.
				__supplierdetail.setSupplierId( getSupplierId());
				// set find flag
				boolean foundSupplierDetail = false;
				// find the original list.
				for(BaseSupplierDetail __originalsupplierdetail : originalsupplierdetail) {
					// if found the original record
					if(__supplierdetail.compareTo(__originalsupplierdetail) == 0) {
						// set found flag to true
						foundSupplierDetail = true;
						// update the record.
						// clear DAO's data
						supplierdetail.clearCurrentData();
						// set original data into DAO
						supplierdetail.setDataFromBase(__originalsupplierdetail);
						// clear DAO modification flag, just like the is loaded from DB
						supplierdetail.clearModifiedFlags();
						// set current data into DAO
						supplierdetail.setDataFromBase(__supplierdetail);
						// execute update
						supplierdetail.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundSupplierDetail) needToAddSupplierDetail.add(__supplierdetail);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseSupplierDetail __originalsupplierdetail : originalsupplierdetail) {
				boolean foundSupplierDetail = false;
				for(BaseSupplierDetail __supplierdetail : getDetailSupplierDetail() ) {
					if(__supplierdetail.compareTo(__originalsupplierdetail) == 0) {
						foundSupplierDetail = true;
						break;
				}
				}
				if(!foundSupplierDetail) needToDeleteSupplierDetail.add(__originalsupplierdetail);
			}
			// process need-to-add list
			for(BaseSupplierDetail __supplierdetail : needToAddSupplierDetail ) {
				supplierdetail.clearCurrentData();
				supplierdetail.setDataFromBase(__supplierdetail);
				supplierdetail.save();
				__supplierdetail.setSupplierDetailId(supplierdetail.getSupplierDetailId());
			}
			// process need-to-delete list
			for(BaseSupplierDetail __supplierdetail : needToDeleteSupplierDetail ) {
				deleteFromSupplierDetail(__supplierdetail, supplierdetail);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseSupplierDetail __supplierdetail : originalsupplierdetail ) {
				deleteFromSupplierDetail(__supplierdetail, supplierdetail);
			}
		}
		// instantiate  DAO
		SupplierCooperation suppliercooperation = new SupplierCooperation();
		// load the original details.
		suppliercooperation.setConditionSupplierId("=", getSupplierId());
		List<BaseSupplierCooperation> originalsuppliercooperation = suppliercooperation.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailSupplierCooperation() != null) {
			// need to delete list.
			List<BaseSupplierCooperation> needToDeleteSupplierCooperation = new ArrayList<>();
			// need to add list.
			List<BaseSupplierCooperation> needToAddSupplierCooperation = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseSupplierCooperation __suppliercooperation : getDetailSupplierCooperation() ) {
				// set the relative field.
				__suppliercooperation.setSupplierId( getSupplierId());
				// set find flag
				boolean foundSupplierCooperation = false;
				// find the original list.
				for(BaseSupplierCooperation __originalsuppliercooperation : originalsuppliercooperation) {
					// if found the original record
					if(__suppliercooperation.compareTo(__originalsuppliercooperation) == 0) {
						// set found flag to true
						foundSupplierCooperation = true;
						// update the record.
						// clear DAO's data
						suppliercooperation.clearCurrentData();
						// set original data into DAO
						suppliercooperation.setDataFromBase(__originalsuppliercooperation);
						// clear DAO modification flag, just like the is loaded from DB
						suppliercooperation.clearModifiedFlags();
						// set current data into DAO
						suppliercooperation.setDataFromBase(__suppliercooperation);
						// execute update
						suppliercooperation.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundSupplierCooperation) needToAddSupplierCooperation.add(__suppliercooperation);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseSupplierCooperation __originalsuppliercooperation : originalsuppliercooperation) {
				boolean foundSupplierCooperation = false;
				for(BaseSupplierCooperation __suppliercooperation : getDetailSupplierCooperation() ) {
					if(__suppliercooperation.compareTo(__originalsuppliercooperation) == 0) {
						foundSupplierCooperation = true;
						break;
				}
				}
				if(!foundSupplierCooperation) needToDeleteSupplierCooperation.add(__originalsuppliercooperation);
			}
			// process need-to-add list
			for(BaseSupplierCooperation __suppliercooperation : needToAddSupplierCooperation ) {
				suppliercooperation.clearCurrentData();
				suppliercooperation.setDataFromBase(__suppliercooperation);
				suppliercooperation.save();
				__suppliercooperation.setSupplierCooperationId(suppliercooperation.getSupplierCooperationId());
			}
			// process need-to-delete list
			for(BaseSupplierCooperation __suppliercooperation : needToDeleteSupplierCooperation ) {
				deleteFromSupplierCooperation(__suppliercooperation, suppliercooperation);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseSupplierCooperation __suppliercooperation : originalsuppliercooperation ) {
				deleteFromSupplierCooperation(__suppliercooperation, suppliercooperation);
			}
		}
	}

	private void deleteFromSupplierDetail(BaseSupplierDetail bean, SupplierDetail dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setSupplierId(null);
		if(__detail_delete_supplierdetail) dao.delete(); else dao.update();
	}

	private void deleteFromSupplierCooperation(BaseSupplierCooperation bean, SupplierCooperation dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setSupplierId(null);
		if(__detail_delete_suppliercooperation) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		SupplierDetail supplierdetail = new SupplierDetail();
		supplierdetail.setConditionSupplierId("=", getSupplierId());
		supplierdetail.conditionalDelete();
		SupplierCooperation suppliercooperation = new SupplierCooperation();
		suppliercooperation.setConditionSupplierId("=", getSupplierId());
		suppliercooperation.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			SupplierDetail supplierdetail = new SupplierDetail();
			supplierdetail.setConditionSupplierId("=", getSupplierId());
			setDetailSupplierDetail(supplierdetail.conditionalLoad());
			SupplierCooperation suppliercooperation = new SupplierCooperation();
			suppliercooperation.setConditionSupplierId("=", getSupplierId());
			setDetailSupplierCooperation(suppliercooperation.conditionalLoad());
		}
		return true;
	}

	public List<BaseSupplierWithSs> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseSupplierWithSs> result = BaseSupplierWithSs.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseSupplierWithSs generateBaseExt() {
		BaseSupplierWithSs ____result = new BaseSupplierWithSs();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseSupplierWithSs __base) {
		super.setDataFromBase(__base);
		setDetailSupplierDetail(__base.getDetailSupplierDetail());
		setDetailSupplierCooperation(__base.getDetailSupplierCooperation());
	}

	public void setDataToBase(BaseSupplierWithSs __base) {
		super.setDataToBase(__base);
		__base.setDetailSupplierDetail(getDetailSupplierDetail());
		__base.setDetailSupplierCooperation(getDetailSupplierCooperation());
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

	public boolean isDeleteDetailSupplierDetail() {
		return this.__detail_delete_supplierdetail;
	}

	public void setDeleteDetailSupplierDetail( boolean value ) {
		this.__detail_delete_supplierdetail = value;
	}

	protected boolean __detail_delete_supplierdetail = true; 
	protected List<BaseSupplierDetail> __detail_supplierdetail ; 
	public boolean isDeleteDetailSupplierCooperation() {
		return this.__detail_delete_suppliercooperation;
	}

	public void setDeleteDetailSupplierCooperation( boolean value ) {
		this.__detail_delete_suppliercooperation = value;
	}

	protected boolean __detail_delete_suppliercooperation = true; 
	protected List<BaseSupplierCooperation> __detail_suppliercooperation ; 
}
