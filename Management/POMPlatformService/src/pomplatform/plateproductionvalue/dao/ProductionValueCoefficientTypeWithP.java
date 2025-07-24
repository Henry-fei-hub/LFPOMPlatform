package pomplatform.plateproductionvalue.dao;

import java.util.*;
import pomplatform.plateproductionvalue.bean.BaseProductionValueCoefficientTypeWithP;
import com.pomplatform.db.bean.BaseProductionValueCoefficient;
import com.pomplatform.db.dao.ProductionValueCoefficient;

public class ProductionValueCoefficientTypeWithP extends com.pomplatform.db.dao.ProductionValueCoefficientType
{


	public ProductionValueCoefficientTypeWithP() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseProductionValueCoefficient> getDetailProductionValueCoefficient() {
		return this.__detail_productionvaluecoefficient;
	}

	public void setDetailProductionValueCoefficient( List<BaseProductionValueCoefficient> value ) {
		this.__detail_productionvaluecoefficient = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate  DAO
		ProductionValueCoefficient productionvaluecoefficient = new ProductionValueCoefficient();
		// load the original details.
		productionvaluecoefficient.setConditionProductionValueCoefficientTypeId("=", getProductionValueCoefficientTypeId());
		List<BaseProductionValueCoefficient> originalproductionvaluecoefficient = productionvaluecoefficient.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailProductionValueCoefficient() != null) {
			// need to delete list.
			List<BaseProductionValueCoefficient> needToDeleteProductionValueCoefficient = new ArrayList<>();
			// need to add list.
			List<BaseProductionValueCoefficient> needToAddProductionValueCoefficient = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseProductionValueCoefficient __productionvaluecoefficient : getDetailProductionValueCoefficient() ) {
				// set the relative field.
				__productionvaluecoefficient.setProductionValueCoefficientTypeId( getProductionValueCoefficientTypeId());
				// set find flag
				boolean foundProductionValueCoefficient = false;
				// find the original list.
				for(BaseProductionValueCoefficient __originalproductionvaluecoefficient : originalproductionvaluecoefficient) {
					// if found the original record
					if(__productionvaluecoefficient.compareTo(__originalproductionvaluecoefficient) == 0) {
						// set found flag to true
						foundProductionValueCoefficient = true;
						// update the record.
						// clear DAO's data
						productionvaluecoefficient.clearCurrentData();
						// set original data into DAO
						productionvaluecoefficient.setDataFromBase(__originalproductionvaluecoefficient);
						// clear DAO modification flag, just like the is loaded from DB
						productionvaluecoefficient.clearModifiedFlags();
						// set current data into DAO
						productionvaluecoefficient.setDataFromBase(__productionvaluecoefficient);
						// execute update
						productionvaluecoefficient.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundProductionValueCoefficient) needToAddProductionValueCoefficient.add(__productionvaluecoefficient);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseProductionValueCoefficient __originalproductionvaluecoefficient : originalproductionvaluecoefficient) {
				boolean foundProductionValueCoefficient = false;
				for(BaseProductionValueCoefficient __productionvaluecoefficient : getDetailProductionValueCoefficient() ) {
					if(__productionvaluecoefficient.compareTo(__originalproductionvaluecoefficient) == 0) {
						foundProductionValueCoefficient = true;
						break;
				}
				}
				if(!foundProductionValueCoefficient) needToDeleteProductionValueCoefficient.add(__originalproductionvaluecoefficient);
			}
			// process need-to-delete list
			for(BaseProductionValueCoefficient __productionvaluecoefficient : needToDeleteProductionValueCoefficient ) {
				deleteFromProductionValueCoefficient(__productionvaluecoefficient, productionvaluecoefficient);
			}
			// process need-to-add list
			for(BaseProductionValueCoefficient __productionvaluecoefficient : needToAddProductionValueCoefficient ) {
				productionvaluecoefficient.clearCurrentData();
				productionvaluecoefficient.setDataFromBase(__productionvaluecoefficient);
				productionvaluecoefficient.save();
				__productionvaluecoefficient.setProductionValueCoefficientId(productionvaluecoefficient.getProductionValueCoefficientId());
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseProductionValueCoefficient __productionvaluecoefficient : originalproductionvaluecoefficient ) {
				deleteFromProductionValueCoefficient(__productionvaluecoefficient, productionvaluecoefficient);
			}
		}
	}

	private void deleteFromProductionValueCoefficient(BaseProductionValueCoefficient bean, ProductionValueCoefficient dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setProductionValueCoefficientTypeId(null);
		if(__detail_delete_productionvaluecoefficient) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		ProductionValueCoefficient productionvaluecoefficient = new ProductionValueCoefficient();
		productionvaluecoefficient.setConditionProductionValueCoefficientTypeId("=", getProductionValueCoefficientTypeId());
		productionvaluecoefficient.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			ProductionValueCoefficient productionvaluecoefficient = new ProductionValueCoefficient();
			productionvaluecoefficient.setConditionProductionValueCoefficientTypeId("=", getProductionValueCoefficientTypeId());
			setDetailProductionValueCoefficient(productionvaluecoefficient.conditionalLoad());
		}
		return true;
	}

	public List<BaseProductionValueCoefficientTypeWithP> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseProductionValueCoefficientTypeWithP> result = BaseProductionValueCoefficientTypeWithP.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseProductionValueCoefficientTypeWithP generateBaseExt() {
		BaseProductionValueCoefficientTypeWithP ____result = new BaseProductionValueCoefficientTypeWithP();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseProductionValueCoefficientTypeWithP __base) {
		super.setDataFromBase(__base);
		setDetailProductionValueCoefficient(__base.getDetailProductionValueCoefficient());
	}

	public void setDataToBase(BaseProductionValueCoefficientTypeWithP __base) {
		super.setDataToBase(__base);
		__base.setDetailProductionValueCoefficient(getDetailProductionValueCoefficient());
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

	public boolean isDeleteDetailProductionValueCoefficient() {
		return this.__detail_delete_productionvaluecoefficient;
	}

	public void setDeleteDetailProductionValueCoefficient( boolean value ) {
		this.__detail_delete_productionvaluecoefficient = value;
	}

	protected boolean __detail_delete_productionvaluecoefficient = true; 
	protected List<BaseProductionValueCoefficient> __detail_productionvaluecoefficient ; 
}
