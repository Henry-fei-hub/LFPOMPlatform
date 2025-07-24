package delicacy.workflow.dao;

import java.util.ArrayList;
import java.util.List;

import delicacy.workflow.bean.BaseReimbursementDetail;
import delicacy.workflow.bean.BaseReimbursementWithR;

public class ReimbursementWithR extends delicacy.workflow.dao.Reimbursement
{


	public ReimbursementWithR() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseReimbursementDetail> getDetailReimbursementDetail() {
		return this.__detail_reimbursementdetail;
	}

	public void setDetailReimbursementDetail( List<BaseReimbursementDetail> value ) {
		this.__detail_reimbursementdetail = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// 实例化 报销明细 DAO
		ReimbursementDetail reimbursementdetail = new ReimbursementDetail();
		// 装入数据库中原来明细数据
		reimbursementdetail.setConditionReimbursementId("=", getReimbursementId());
		List<BaseReimbursementDetail> originalreimbursementdetail = reimbursementdetail.conditionalLoad(null);
		// 如果当前明细不为空
		if(getDetailReimbursementDetail() != null) {
			// 需要删除的明细数据
			List<BaseReimbursementDetail> needToDeleteReimbursementDetail = new ArrayList<>();
			// 需要增加的明细数据
			List<BaseReimbursementDetail> needToAddReimbursementDetail = new ArrayList<>();
			// 找到在原明细中存在的数据并修改该数据，如果在原数据中没有则加到需要添加的列表中
			for(BaseReimbursementDetail __reimbursementdetail : getDetailReimbursementDetail() ) {
				// 赋值关联字段
				__reimbursementdetail.setReimbursementId( getReimbursementId());
				// 设置找到标志
				boolean foundReimbursementDetail = false;
				// 在原明细中找
				for(BaseReimbursementDetail __originalreimbursementdetail : originalreimbursementdetail) {
					// 如果两个对象主键相同
					if(__reimbursementdetail.compareTo(__originalreimbursementdetail) == 0) {
						// 设置找到标志
						foundReimbursementDetail = true;
						// 修改该条数据
						// 清空DAO中当前数据
						reimbursementdetail.clearCurrentData();
						// 把原明细数据装入DAO
						reimbursementdetail.setDataFromBase(__originalreimbursementdetail);
						// 清空DAO数据修改标志, 就像数据刚从数据库中装入一样
						reimbursementdetail.clearModifiedFlags();
						// 把新的数据装入
						reimbursementdetail.setDataFromBase(__reimbursementdetail);
						// 执行修改
						reimbursementdetail.update();
						break;
					}
				}
				// 如果没找到，则加入需要增加的列表中
				if(!foundReimbursementDetail) needToAddReimbursementDetail.add(__reimbursementdetail);
			}
			// 找到那些在原明细中有，但当前明细中没有的条目
			for(BaseReimbursementDetail __originalreimbursementdetail : originalreimbursementdetail) {
				boolean foundReimbursementDetail = false;
				for(BaseReimbursementDetail __reimbursementdetail : getDetailReimbursementDetail() ) {
					if(__reimbursementdetail.compareTo(__originalreimbursementdetail) == 0) {
						foundReimbursementDetail = true;
						break;
				}
				}
				if(!foundReimbursementDetail) needToDeleteReimbursementDetail.add(__originalreimbursementdetail);
			}
			// 处理需要增加的明细数据
			for(BaseReimbursementDetail __reimbursementdetail : needToAddReimbursementDetail ) {
				reimbursementdetail.setPrimaryKeyFromBase(__reimbursementdetail);
				// 如果该条数据主键为空，则插入数据, 注意这种处理方式只对子表主键为自增的有效
				// 如果子表的主键不是自增类型，则需要考虑如何生成主键, 并修改下面的代码
				if(reimbursementdetail.isPrimaryKeyNull()) { reimbursementdetail.clearCurrentData(); reimbursementdetail.setDataFromBase(__reimbursementdetail); reimbursementdetail.save(); }
				// 否则从数据中查询该数据，找到就修改，否则插入
				else { if(reimbursementdetail.load()) { reimbursementdetail.setDataFromBase(__reimbursementdetail); reimbursementdetail.update(); } else { reimbursementdetail.clearCurrentData(); reimbursementdetail.setDataFromBase(__reimbursementdetail); reimbursementdetail.save(); } }
			}
			// 处理需要删除的明细数据
			for(BaseReimbursementDetail __reimbursementdetail : needToDeleteReimbursementDetail ) {
				deleteFromReimbursementDetail(__reimbursementdetail, reimbursementdetail);
			}
		} else {
			// 如果当前明细为空，说明所有原有的明细都需要删除
			for(BaseReimbursementDetail __reimbursementdetail : originalreimbursementdetail ) {
				deleteFromReimbursementDetail(__reimbursementdetail, reimbursementdetail);
			}
		}
	}

	private void deleteFromReimbursementDetail(BaseReimbursementDetail bean, ReimbursementDetail dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setReimbursementId(null);
		if(__detail_delete_reimbursementdetail) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		ReimbursementDetail reimbursementdetail = new ReimbursementDetail();
		reimbursementdetail.setConditionReimbursementId("=", getReimbursementId());
		reimbursementdetail.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			ReimbursementDetail reimbursementdetail = new ReimbursementDetail();
			reimbursementdetail.setConditionReimbursementId("=", getReimbursementId());
			setDetailReimbursementDetail(reimbursementdetail.conditionalLoad(null));
		}
		return true;
	}

	public List<BaseReimbursementWithR> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseReimbursementWithR> result = BaseReimbursementWithR.getBeanList(conditionalLoad(addtional));
		if(result.size() > 0) {
			ReimbursementDetail reimbursementdetail = new ReimbursementDetail();
			int varCount = 0;
			Object[] convars = new Object[result.size()];
			for(BaseReimbursementWithR b : result) convars[varCount++] = b.getReimbursementId();
			reimbursementdetail.addCondition(BaseReimbursementDetail.CS_REIMBURSEMENT_ID, "IN", convars);
			List<BaseReimbursementDetail> reimbursementdetails = reimbursementdetail.conditionalLoad(null);
			for(BaseReimbursementWithR ii : result){ ii.setDetailReimbursementDetail(new ArrayList<BaseReimbursementDetail>()); }
			for(BaseReimbursementDetail mm : reimbursementdetails){
				for(BaseReimbursementWithR nn : result){
					if(mm.getReimbursementId().equals(nn.getReimbursementId())) { nn.getDetailReimbursementDetail().add(mm); break; } 
				}
			}
		}
		return result;
	}

	public BaseReimbursementWithR generateBaseExt() {
		BaseReimbursementWithR ____result = new BaseReimbursementWithR();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseReimbursementWithR __base) {
		super.setDataFromBase(__base);
		setDetailReimbursementDetail(__base.getDetailReimbursementDetail());
	}

	public void setDataToBase(BaseReimbursementWithR __base) {
		super.setDataToBase(__base);
		__base.setDetailReimbursementDetail(getDetailReimbursementDetail());
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
		if(getReimbursementId() != null) deleteDetailTables();
		return 1;
	}

	public boolean isDeleteDetailReimbursementDetail() {
		return this.__detail_delete_reimbursementdetail;
	}

	public void setDeleteDetailReimbursementDetail( boolean value ) {
		this.__detail_delete_reimbursementdetail = value;
	}

	protected boolean __detail_delete_reimbursementdetail = false; 
	protected List<BaseReimbursementDetail> __detail_reimbursementdetail ; 
}
