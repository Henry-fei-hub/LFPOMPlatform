package pomplatform.purchase.dao;

import java.util.*;
import pomplatform.purchase.bean.BaseProductWithP;
import com.pomplatform.db.bean.BaseProductAttribute;
import com.pomplatform.db.dao.ProductAttribute;

public class ProductWithP extends com.pomplatform.db.dao.Product
{


	public ProductWithP() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseProductAttribute> getDetailProductAttribute() {
		return this.__detail_productattribute;
	}

	public void setDetailProductAttribute( List<BaseProductAttribute> value ) {
		this.__detail_productattribute = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate 产品属性表 DAO
		ProductAttribute productattribute = new ProductAttribute();
		// load the original details.
		productattribute.setConditionProductId("=", getProductId());
		List<BaseProductAttribute> originalproductattribute = productattribute.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailProductAttribute() != null) {
			// need to delete list.
			List<BaseProductAttribute> needToDeleteProductAttribute = new ArrayList<>();
			// need to add list.
			List<BaseProductAttribute> needToAddProductAttribute = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseProductAttribute __productattribute : getDetailProductAttribute() ) {
				// set the relative field.
				__productattribute.setProductId( getProductId());
				// set find flag
				boolean foundProductAttribute = false;
				// find the original list.
				for(BaseProductAttribute __originalproductattribute : originalproductattribute) {
					// if found the original record
					if(__productattribute.compareTo(__originalproductattribute) == 0) {
						// set found flag to true
						foundProductAttribute = true;
						// update the record.
						// clear DAO's data
						productattribute.clearCurrentData();
						// set original data into DAO
						productattribute.setDataFromBase(__originalproductattribute);
						// clear DAO modification flag, just like the is loaded from DB
						productattribute.clearModifiedFlags();
						// set current data into DAO
						productattribute.setDataFromBase(__productattribute);
						// execute update
						productattribute.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundProductAttribute) needToAddProductAttribute.add(__productattribute);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseProductAttribute __originalproductattribute : originalproductattribute) {
				boolean foundProductAttribute = false;
				for(BaseProductAttribute __productattribute : getDetailProductAttribute() ) {
					if(__productattribute.compareTo(__originalproductattribute) == 0) {
						foundProductAttribute = true;
						break;
				}
				}
				if(!foundProductAttribute) needToDeleteProductAttribute.add(__originalproductattribute);
			}
			// process need-to-add list
			for(BaseProductAttribute __productattribute : needToAddProductAttribute ) {
				productattribute.clearCurrentData();
				productattribute.setDataFromBase(__productattribute);
				productattribute.save();
				__productattribute.setProductAttributeId(productattribute.getProductAttributeId());
			}
			// process need-to-delete list
			for(BaseProductAttribute __productattribute : needToDeleteProductAttribute ) {
				deleteFromProductAttribute(__productattribute, productattribute);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseProductAttribute __productattribute : originalproductattribute ) {
				deleteFromProductAttribute(__productattribute, productattribute);
			}
		}
	}

	private void deleteFromProductAttribute(BaseProductAttribute bean, ProductAttribute dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setProductId(null);
		if(__detail_delete_productattribute) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		ProductAttribute productattribute = new ProductAttribute();
		productattribute.setConditionProductId("=", getProductId());
		productattribute.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			ProductAttribute productattribute = new ProductAttribute();
			productattribute.setConditionProductId("=", getProductId());
			setDetailProductAttribute(productattribute.conditionalLoad());
		}
		return true;
	}

	public List<BaseProductWithP> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseProductWithP> result = BaseProductWithP.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseProductWithP generateBaseExt() {
		BaseProductWithP ____result = new BaseProductWithP();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseProductWithP __base) {
		super.setDataFromBase(__base);
		setDetailProductAttribute(__base.getDetailProductAttribute());
	}

	public void setDataToBase(BaseProductWithP __base) {
		super.setDataToBase(__base);
		__base.setDetailProductAttribute(getDetailProductAttribute());
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

	public boolean isDeleteDetailProductAttribute() {
		return this.__detail_delete_productattribute;
	}

	public void setDeleteDetailProductAttribute( boolean value ) {
		this.__detail_delete_productattribute = value;
	}

	protected boolean __detail_delete_productattribute = true; 
	protected List<BaseProductAttribute> __detail_productattribute ; 
}
