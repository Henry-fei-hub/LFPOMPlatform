package pomplatform.supplierworkflow.dao;

import java.util.*;
import pomplatform.supplierworkflow.bean.BaseReceiveUnitManageWithS;
import com.pomplatform.db.bean.BaseSupplier;
import com.pomplatform.db.dao.Supplier;

public class ReceiveUnitManageWithS extends com.pomplatform.db.dao.ReceiveUnitManage
{


	public ReceiveUnitManageWithS() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseSupplier> getDetailSupplier() {
		return this.__detail_supplier;
	}

	public void setDetailSupplier( List<BaseSupplier> value ) {
		this.__detail_supplier = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate  DAO
		Supplier supplier = new Supplier();
		// load the original details.
		supplier.setConditionReceiveUnitManageId("=", getReceiveUnitManageId());
		List<BaseSupplier> originalsupplier = supplier.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailSupplier() != null) {
			// need to delete list.
			List<BaseSupplier> needToDeleteSupplier = new ArrayList<>();
			// need to add list.
			List<BaseSupplier> needToAddSupplier = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseSupplier __supplier : getDetailSupplier() ) {
				// set the relative field.
				__supplier.setReceiveUnitManageId( getReceiveUnitManageId());
				// set find flag
				boolean foundSupplier = false;
				// find the original list.
				for(BaseSupplier __originalsupplier : originalsupplier) {
					// if found the original record
					if(__supplier.compareTo(__originalsupplier) == 0) {
						// set found flag to true
						foundSupplier = true;
						// update the record.
						// clear DAO's data
						supplier.clearCurrentData();
						// set original data into DAO
						supplier.setDataFromBase(__originalsupplier);
						// clear DAO modification flag, just like the is loaded from DB
						supplier.clearModifiedFlags();
						// set current data into DAO
						supplier.setDataFromBase(__supplier);
						// execute update
						supplier.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundSupplier) needToAddSupplier.add(__supplier);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseSupplier __originalsupplier : originalsupplier) {
				boolean foundSupplier = false;
				for(BaseSupplier __supplier : getDetailSupplier() ) {
					if(__supplier.compareTo(__originalsupplier) == 0) {
						foundSupplier = true;
						break;
				}
				}
				if(!foundSupplier) needToDeleteSupplier.add(__originalsupplier);
			}
			// process need-to-add list
			for(BaseSupplier __supplier : needToAddSupplier ) {
				supplier.clearCurrentData();
				supplier.setDataFromBase(__supplier);
				supplier.save();
				__supplier.setSupplierId(supplier.getSupplierId());
			}
			// process need-to-delete list
			for(BaseSupplier __supplier : needToDeleteSupplier ) {
				deleteFromSupplier(__supplier, supplier);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseSupplier __supplier : originalsupplier ) {
				deleteFromSupplier(__supplier, supplier);
			}
		}
	}

	private void deleteFromSupplier(BaseSupplier bean, Supplier dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setReceiveUnitManageId(null);
		if(__detail_delete_supplier) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		Supplier supplier = new Supplier();
		supplier.setConditionReceiveUnitManageId("=", getReceiveUnitManageId());
		supplier.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			Supplier supplier = new Supplier();
			supplier.setConditionReceiveUnitManageId("=", getReceiveUnitManageId());
			setDetailSupplier(supplier.conditionalLoad());
		}
		return true;
	}

	public List<BaseReceiveUnitManageWithS> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseReceiveUnitManageWithS> result = BaseReceiveUnitManageWithS.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseReceiveUnitManageWithS generateBaseExt() {
		BaseReceiveUnitManageWithS ____result = new BaseReceiveUnitManageWithS();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseReceiveUnitManageWithS __base) {
		super.setDataFromBase(__base);
		setDetailSupplier(__base.getDetailSupplier());
	}

	public void setDataToBase(BaseReceiveUnitManageWithS __base) {
		super.setDataToBase(__base);
		__base.setDetailSupplier(getDetailSupplier());
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

	public boolean isDeleteDetailSupplier() {
		return this.__detail_delete_supplier;
	}

	public void setDeleteDetailSupplier( boolean value ) {
		this.__detail_delete_supplier = value;
	}

	protected boolean __detail_delete_supplier = true; 
	protected List<BaseSupplier> __detail_supplier ; 
}
