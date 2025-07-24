package pomplatform.workflow.purchase.dao;

import java.util.*;
import pomplatform.workflow.purchase.bean.BaseProductInquiryTotalWithP;
import com.pomplatform.db.bean.BaseProductInquiryDetail;
import com.pomplatform.db.dao.ProductInquiryDetail;

public class ProductInquiryTotalWithP extends com.pomplatform.db.dao.ProductInquiryTotal
{


	public ProductInquiryTotalWithP() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseProductInquiryDetail> getDetailProductInquiryDetail() {
		return this.__detail_productinquirydetail;
	}

	public void setDetailProductInquiryDetail( List<BaseProductInquiryDetail> value ) {
		this.__detail_productinquirydetail = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate 产品询价详情表 DAO
		ProductInquiryDetail productinquirydetail = new ProductInquiryDetail();
		// load the original details.
		productinquirydetail.setConditionProductInquiryTotalId("=", getProductInquiryTotalId());
		List<BaseProductInquiryDetail> originalproductinquirydetail = productinquirydetail.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailProductInquiryDetail() != null) {
			// need to delete list.
			List<BaseProductInquiryDetail> needToDeleteProductInquiryDetail = new ArrayList<>();
			// need to add list.
			List<BaseProductInquiryDetail> needToAddProductInquiryDetail = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseProductInquiryDetail __productinquirydetail : getDetailProductInquiryDetail() ) {
				// set the relative field.
				__productinquirydetail.setProductInquiryTotalId( getProductInquiryTotalId());
				// set find flag
				boolean foundProductInquiryDetail = false;
				// find the original list.
				for(BaseProductInquiryDetail __originalproductinquirydetail : originalproductinquirydetail) {
					// if found the original record
					if(__productinquirydetail.compareTo(__originalproductinquirydetail) == 0) {
						// set found flag to true
						foundProductInquiryDetail = true;
						// update the record.
						// clear DAO's data
						productinquirydetail.clearCurrentData();
						// set original data into DAO
						productinquirydetail.setDataFromBase(__originalproductinquirydetail);
						// clear DAO modification flag, just like the is loaded from DB
						productinquirydetail.clearModifiedFlags();
						// set current data into DAO
						productinquirydetail.setDataFromBase(__productinquirydetail);
						// execute update
						productinquirydetail.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundProductInquiryDetail) needToAddProductInquiryDetail.add(__productinquirydetail);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseProductInquiryDetail __originalproductinquirydetail : originalproductinquirydetail) {
				boolean foundProductInquiryDetail = false;
				for(BaseProductInquiryDetail __productinquirydetail : getDetailProductInquiryDetail() ) {
					if(__productinquirydetail.compareTo(__originalproductinquirydetail) == 0) {
						foundProductInquiryDetail = true;
						break;
				}
				}
				if(!foundProductInquiryDetail) needToDeleteProductInquiryDetail.add(__originalproductinquirydetail);
			}
			// process need-to-add list
			for(BaseProductInquiryDetail __productinquirydetail : needToAddProductInquiryDetail ) {
				productinquirydetail.clearCurrentData();
				productinquirydetail.setDataFromBase(__productinquirydetail);
				productinquirydetail.save();
				__productinquirydetail.setProductInquiryDetailId(productinquirydetail.getProductInquiryDetailId());
			}
			// process need-to-delete list
			for(BaseProductInquiryDetail __productinquirydetail : needToDeleteProductInquiryDetail ) {
				deleteFromProductInquiryDetail(__productinquirydetail, productinquirydetail);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseProductInquiryDetail __productinquirydetail : originalproductinquirydetail ) {
				deleteFromProductInquiryDetail(__productinquirydetail, productinquirydetail);
			}
		}
	}

	private void deleteFromProductInquiryDetail(BaseProductInquiryDetail bean, ProductInquiryDetail dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setProductInquiryTotalId(null);
		if(__detail_delete_productinquirydetail) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		ProductInquiryDetail productinquirydetail = new ProductInquiryDetail();
		productinquirydetail.setConditionProductInquiryTotalId("=", getProductInquiryTotalId());
		productinquirydetail.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			ProductInquiryDetail productinquirydetail = new ProductInquiryDetail();
			productinquirydetail.setConditionProductInquiryTotalId("=", getProductInquiryTotalId());
			setDetailProductInquiryDetail(productinquirydetail.conditionalLoad());
		}
		return true;
	}

	public List<BaseProductInquiryTotalWithP> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseProductInquiryTotalWithP> result = BaseProductInquiryTotalWithP.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseProductInquiryTotalWithP generateBaseExt() {
		BaseProductInquiryTotalWithP ____result = new BaseProductInquiryTotalWithP();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseProductInquiryTotalWithP __base) {
		super.setDataFromBase(__base);
		setDetailProductInquiryDetail(__base.getDetailProductInquiryDetail());
	}

	public void setDataToBase(BaseProductInquiryTotalWithP __base) {
		super.setDataToBase(__base);
		__base.setDetailProductInquiryDetail(getDetailProductInquiryDetail());
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

	public boolean isDeleteDetailProductInquiryDetail() {
		return this.__detail_delete_productinquirydetail;
	}

	public void setDeleteDetailProductInquiryDetail( boolean value ) {
		this.__detail_delete_productinquirydetail = value;
	}

	protected boolean __detail_delete_productinquirydetail = true; 
	protected List<BaseProductInquiryDetail> __detail_productinquirydetail ; 
}
