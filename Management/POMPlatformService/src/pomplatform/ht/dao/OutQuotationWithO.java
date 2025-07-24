package pomplatform.ht.dao;

import java.util.*;
import pomplatform.ht.bean.BaseOutQuotationWithO;
import com.pomplatform.db.bean.BaseOutDesignConsideration;
import com.pomplatform.db.dao.OutDesignConsideration;

public class OutQuotationWithO extends com.pomplatform.db.dao.OutQuotation
{


	public OutQuotationWithO() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseOutDesignConsideration> getDetailOutDesignConsideration() {
		return this.__detail_outdesignconsideration;
	}

	public void setDetailOutDesignConsideration( List<BaseOutDesignConsideration> value ) {
		this.__detail_outdesignconsideration = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate 报价单子项表 DAO
		OutDesignConsideration outdesignconsideration = new OutDesignConsideration();
		// load the original detail data.
		outdesignconsideration.setConditionOutQuotationId("=", getOutQuotationId());
		List<BaseOutDesignConsideration> originaloutdesignconsideration = outdesignconsideration.conditionalLoad();
		// if current detail is not empty.
		if(getDetailOutDesignConsideration() != null) {
			// need to delete data
			List<BaseOutDesignConsideration> needToDeleteOutDesignConsideration = new ArrayList<>();
			// need to add data
			List<BaseOutDesignConsideration> needToAddOutDesignConsideration = new ArrayList<>();
			// find that records need to be modified.
			for(BaseOutDesignConsideration __outdesignconsideration : getDetailOutDesignConsideration() ) {
				// set that related fields.
				__outdesignconsideration.setOutQuotationId(getOutQuotationId());
				// if found then set found flag.
				boolean foundOutDesignConsideration = false;
				// search the original detail list.
				for(BaseOutDesignConsideration __originaloutdesignconsideration : originaloutdesignconsideration) {
					// compare the key.
					if(__outdesignconsideration.compareTo(__originaloutdesignconsideration) == 0) {
						// found the original record.
						foundOutDesignConsideration = true;
						//update the record
						// clear DAO's data
						outdesignconsideration.clearCurrentData();
						// set original bean data into DAO
						outdesignconsideration.setDataFromBase(__originaloutdesignconsideration);
						// clear DAO data modification flags, just like the data reloaded from DB.
						outdesignconsideration.clearModifiedFlags();
						// set the current data into DAO
						outdesignconsideration.setDataFromBase(__outdesignconsideration);
						// execute update 
						outdesignconsideration.update();
						break;
					}
				}
				// if the data not found in the original list, then add to the need-to-add list.
				if(!foundOutDesignConsideration) needToAddOutDesignConsideration.add(__outdesignconsideration);
			}
			// find the record that in the original list but not in the current list.
			for(BaseOutDesignConsideration __originaloutdesignconsideration : originaloutdesignconsideration) {
				boolean foundOutDesignConsideration = false;
				for(BaseOutDesignConsideration __outdesignconsideration : getDetailOutDesignConsideration() ) {
					if(__outdesignconsideration.compareTo(__originaloutdesignconsideration) == 0) {
						foundOutDesignConsideration = true;
						break;
				}
				}
				if(!foundOutDesignConsideration) needToDeleteOutDesignConsideration.add(__originaloutdesignconsideration);
			}
			// process need-to-delete list.
			for(BaseOutDesignConsideration __outdesignconsideration : needToDeleteOutDesignConsideration ) {
				deleteFromOutDesignConsideration(__outdesignconsideration, outdesignconsideration);
			}
			// process need-to-add list. insert into DB.
			for(BaseOutDesignConsideration __outdesignconsideration : needToAddOutDesignConsideration ) {
				outdesignconsideration.clearCurrentData();
				outdesignconsideration.setDataFromBase(__outdesignconsideration);
				outdesignconsideration.save();
				__outdesignconsideration.setOutDesignConsiderationId(outdesignconsideration.getOutDesignConsiderationId());
			}
		} else {
			// if current list is empty. then delete all the original details.
			for(BaseOutDesignConsideration __outdesignconsideration : originaloutdesignconsideration ) {
				deleteFromOutDesignConsideration(__outdesignconsideration, outdesignconsideration);
			}
		}
	}

	private void deleteFromOutDesignConsideration(BaseOutDesignConsideration bean, OutDesignConsideration dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setOutQuotationId(null);
		if(__detail_delete_outdesignconsideration) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		OutDesignConsideration outdesignconsideration = new OutDesignConsideration();
		outdesignconsideration.setConditionOutQuotationId("=", getOutQuotationId());
		outdesignconsideration.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			OutDesignConsideration outdesignconsideration = new OutDesignConsideration();
			outdesignconsideration.setConditionOutQuotationId("=", getOutQuotationId());
			setDetailOutDesignConsideration(outdesignconsideration.conditionalLoad());
		}
		return true;
	}

	public List<BaseOutQuotationWithO> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseOutQuotationWithO> result = BaseOutQuotationWithO.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseOutQuotationWithO generateBaseExt() {
		BaseOutQuotationWithO ____result = new BaseOutQuotationWithO();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseOutQuotationWithO __base) {
		super.setDataFromBase(__base);
		setDetailOutDesignConsideration(__base.getDetailOutDesignConsideration());
	}

	public void setDataToBase(BaseOutQuotationWithO __base) {
		super.setDataToBase(__base);
		__base.setDetailOutDesignConsideration(getDetailOutDesignConsideration());
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

	public boolean isDeleteDetailOutDesignConsideration() {
		return this.__detail_delete_outdesignconsideration;
	}

	public void setDeleteDetailOutDesignConsideration( boolean value ) {
		this.__detail_delete_outdesignconsideration = value;
	}

	protected boolean __detail_delete_outdesignconsideration = true; 
	protected List<BaseOutDesignConsideration> __detail_outdesignconsideration ; 
}
