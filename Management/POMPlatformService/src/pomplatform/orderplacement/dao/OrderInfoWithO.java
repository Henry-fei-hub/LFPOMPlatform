package pomplatform.orderplacement.dao;

import java.util.*;

import com.pomplatform.db.bean.BaseOrderInfoChild;
import pomplatform.orderplacement.bean.BaseOrderInfoWithO;
import com.pomplatform.db.dao.OrderInfoChild;

public class OrderInfoWithO extends com.pomplatform.db.dao.OrderInfo
{


	public OrderInfoWithO() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseOrderInfoChild> getDetailOrderInfoChild() {
		return this.__detail_orderinfochild;
	}

	public void setDetailOrderInfoChild( List<BaseOrderInfoChild> value ) {
		this.__detail_orderinfochild = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate  DAO
		OrderInfoChild orderinfochild = new OrderInfoChild();
		// load the original detail data.
		orderinfochild.setConditionOrderInfoId("=", getOrderInfoId());
		List<BaseOrderInfoChild> originalorderinfochild = orderinfochild.conditionalLoad();
		// if current detail is not empty.
		if(getDetailOrderInfoChild() != null) {
			// need to delete data
			List<BaseOrderInfoChild> needToDeleteOrderInfoChild = new ArrayList<>();
			// need to add data
			List<BaseOrderInfoChild> needToAddOrderInfoChild = new ArrayList<>();
			// find that records need to be modified.
			for(BaseOrderInfoChild __orderinfochild : getDetailOrderInfoChild() ) {
				// set that related fields.
				__orderinfochild.setOrderInfoId(getOrderInfoId());
				// if found then set found flag.
				boolean foundOrderInfoChild = false;
				// search the original detail list.
				for(BaseOrderInfoChild __originalorderinfochild : originalorderinfochild) {
					// compare the key.
					if(__orderinfochild.compareTo(__originalorderinfochild) == 0) {
						// found the original record.
						foundOrderInfoChild = true;
						//update the record
						// clear DAO's data
						orderinfochild.clearCurrentData();
						// set original bean data into DAO
						orderinfochild.setDataFromBase(__originalorderinfochild);
						// clear DAO data modification flags, just like the data reloaded from DB.
						orderinfochild.clearModifiedFlags();
						// set the current data into DAO
						orderinfochild.setDataFromBase(__orderinfochild);
						// execute update 
						orderinfochild.update();
						break;
					}
				}
				// if the data not found in the original list, then add to the need-to-add list.
				if(!foundOrderInfoChild) needToAddOrderInfoChild.add(__orderinfochild);
			}
			// find the record that in the original list but not in the current list.
			for(BaseOrderInfoChild __originalorderinfochild : originalorderinfochild) {
				boolean foundOrderInfoChild = false;
				for(BaseOrderInfoChild __orderinfochild : getDetailOrderInfoChild() ) {
					if(__orderinfochild.compareTo(__originalorderinfochild) == 0) {
						foundOrderInfoChild = true;
						break;
				}
				}
				if(!foundOrderInfoChild) needToDeleteOrderInfoChild.add(__originalorderinfochild);
			}
			// process need-to-delete list.
			for(BaseOrderInfoChild __orderinfochild : needToDeleteOrderInfoChild ) {
				deleteFromOrderInfoChild(__orderinfochild, orderinfochild);
			}
			// process need-to-add list. insert into DB.
			for(BaseOrderInfoChild __orderinfochild : needToAddOrderInfoChild ) {
				orderinfochild.clearCurrentData();
				orderinfochild.setDataFromBase(__orderinfochild);
				orderinfochild.save();
				__orderinfochild.setOrderInfoChildId(orderinfochild.getOrderInfoChildId());
			}
		} else {
			// if current list is empty. then delete all the original details.
			for(BaseOrderInfoChild __orderinfochild : originalorderinfochild ) {
				deleteFromOrderInfoChild(__orderinfochild, orderinfochild);
			}
		}
	}

	private void deleteFromOrderInfoChild(BaseOrderInfoChild bean, OrderInfoChild dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setOrderInfoId(null);
		if(__detail_delete_orderinfochild) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		OrderInfoChild orderinfochild = new OrderInfoChild();
		orderinfochild.setConditionOrderInfoId("=", getOrderInfoId());
		orderinfochild.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			OrderInfoChild orderinfochild = new OrderInfoChild();
			orderinfochild.setConditionOrderInfoId("=", getOrderInfoId());
			setDetailOrderInfoChild(orderinfochild.conditionalLoad());
		}
		return true;
	}

	public List<BaseOrderInfoWithO> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseOrderInfoWithO> result = BaseOrderInfoWithO.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseOrderInfoWithO generateBaseExt() {
		BaseOrderInfoWithO ____result = new BaseOrderInfoWithO();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseOrderInfoWithO __base) {
		super.setDataFromBase(__base);
		setDetailOrderInfoChild(__base.getDetailOrderInfoChild());
	}

	public void setDataToBase(BaseOrderInfoWithO __base) {
		super.setDataToBase(__base);
		__base.setDetailOrderInfoChild(getDetailOrderInfoChild());
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

	public boolean isDeleteDetailOrderInfoChild() {
		return this.__detail_delete_orderinfochild;
	}

	public void setDeleteDetailOrderInfoChild( boolean value ) {
		this.__detail_delete_orderinfochild = value;
	}

	protected boolean __detail_delete_orderinfochild = true; 
	protected List<BaseOrderInfoChild> __detail_orderinfochild ; 
}
