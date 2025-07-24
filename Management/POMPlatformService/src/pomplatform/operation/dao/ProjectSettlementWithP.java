package pomplatform.operation.dao;

import java.util.*;
import pomplatform.operation.bean.BaseProjectSettlementWithP;
import com.pomplatform.db.bean.BaseProjectSettlementDetail;
import com.pomplatform.db.dao.ProjectSettlementDetail;

public class ProjectSettlementWithP extends com.pomplatform.db.dao.ProjectSettlement
{


	public ProjectSettlementWithP() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseProjectSettlementDetail> getDetailProjectSettlementDetail() {
		return this.__detail_projectsettlementdetail;
	}

	public void setDetailProjectSettlementDetail( List<BaseProjectSettlementDetail> value ) {
		this.__detail_projectsettlementdetail = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// 实例化  DAO
		ProjectSettlementDetail projectsettlementdetail = new ProjectSettlementDetail();
		// 装入数据库中原来明细数据
		projectsettlementdetail.setConditionSettlementId("=", getSettlementId());
		List<BaseProjectSettlementDetail> originalprojectsettlementdetail = projectsettlementdetail.conditionalLoad(null);
		// 如果当前明细不为空
		if(getDetailProjectSettlementDetail() != null) {
			// 需要删除的明细数据
			List<BaseProjectSettlementDetail> needToDeleteProjectSettlementDetail = new ArrayList<>();
			// 需要增加的明细数据
			List<BaseProjectSettlementDetail> needToAddProjectSettlementDetail = new ArrayList<>();
			// 找到在原明细中存在的数据并修改该数据，如果在原数据中没有则加到需要添加的列表中
			for(BaseProjectSettlementDetail __projectsettlementdetail : getDetailProjectSettlementDetail() ) {
				// 赋值关联字段
				__projectsettlementdetail.setSettlementId( getSettlementId());
				// 设置找到标志
				boolean foundProjectSettlementDetail = false;
				// 在原明细中找
				for(BaseProjectSettlementDetail __originalprojectsettlementdetail : originalprojectsettlementdetail) {
					// 如果两个对象主键相同
					if(__projectsettlementdetail.compareTo(__originalprojectsettlementdetail) == 0) {
						// 设置找到标志
						foundProjectSettlementDetail = true;
						// 修改该条数据
						// 清空DAO中当前数据
						projectsettlementdetail.clearCurrentData();
						// 把原明细数据装入DAO
						projectsettlementdetail.setDataFromBase(__originalprojectsettlementdetail);
						// 清空DAO数据修改标志, 就像数据刚从数据库中装入一样
						projectsettlementdetail.clearModifiedFlags();
						// 把新的数据装入
						projectsettlementdetail.setDataFromBase(__projectsettlementdetail);
						// 执行修改
						projectsettlementdetail.update();
						break;
					}
				}
				// 如果没找到，则加入需要增加的列表中
				if(!foundProjectSettlementDetail) needToAddProjectSettlementDetail.add(__projectsettlementdetail);
			}
			// 找到那些在原明细中有，但当前明细中没有的条目
			for(BaseProjectSettlementDetail __originalprojectsettlementdetail : originalprojectsettlementdetail) {
				boolean foundProjectSettlementDetail = false;
				for(BaseProjectSettlementDetail __projectsettlementdetail : getDetailProjectSettlementDetail() ) {
					if(__projectsettlementdetail.compareTo(__originalprojectsettlementdetail) == 0) {
						foundProjectSettlementDetail = true;
						break;
				}
				}
				if(!foundProjectSettlementDetail) needToDeleteProjectSettlementDetail.add(__originalprojectsettlementdetail);
			}
			// 处理需要增加的明细数据
			for(BaseProjectSettlementDetail __projectsettlementdetail : needToAddProjectSettlementDetail ) {
				projectsettlementdetail.setPrimaryKeyFromBase(__projectsettlementdetail);
				// 如果该条数据主键为空，则插入数据, 注意这种处理方式只对子表主键为自增的有效
				// 如果子表的主键不是自增类型，则需要考虑如何生成主键, 并修改下面的代码
				if(projectsettlementdetail.isPrimaryKeyNull()) { projectsettlementdetail.clearCurrentData(); projectsettlementdetail.setDataFromBase(__projectsettlementdetail); projectsettlementdetail.save(); }
				// 否则从数据中查询该数据，找到就修改，否则插入
				else { if(projectsettlementdetail.load()) { projectsettlementdetail.setDataFromBase(__projectsettlementdetail); projectsettlementdetail.update(); } else { projectsettlementdetail.clearCurrentData(); projectsettlementdetail.setDataFromBase(__projectsettlementdetail); projectsettlementdetail.save(); } }
			}
			// 处理需要删除的明细数据
			for(BaseProjectSettlementDetail __projectsettlementdetail : needToDeleteProjectSettlementDetail ) {
				deleteFromProjectSettlementDetail(__projectsettlementdetail, projectsettlementdetail);
			}
		} else {
			// 如果当前明细为空，说明所有原有的明细都需要删除
			for(BaseProjectSettlementDetail __projectsettlementdetail : originalprojectsettlementdetail ) {
				deleteFromProjectSettlementDetail(__projectsettlementdetail, projectsettlementdetail);
			}
		}
	}

	private void deleteFromProjectSettlementDetail(BaseProjectSettlementDetail bean, ProjectSettlementDetail dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setSettlementId(null);
		if(__detail_delete_projectsettlementdetail) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		ProjectSettlementDetail projectsettlementdetail = new ProjectSettlementDetail();
		projectsettlementdetail.setConditionSettlementId("=", getSettlementId());
		projectsettlementdetail.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			ProjectSettlementDetail projectsettlementdetail = new ProjectSettlementDetail();
			projectsettlementdetail.setConditionSettlementId("=", getSettlementId());
			setDetailProjectSettlementDetail(projectsettlementdetail.conditionalLoad(null));
		}
		return true;
	}

	public List<BaseProjectSettlementWithP> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseProjectSettlementWithP> result = BaseProjectSettlementWithP.getBeanList(conditionalLoad(addtional));
		if(result.size() > 0) {
			ProjectSettlementDetail projectsettlementdetail = new ProjectSettlementDetail();
			int varCount = 0;
			Object[] convars = new Object[result.size()];
			for(BaseProjectSettlementWithP b : result) convars[varCount++] = b.getSettlementId();
			projectsettlementdetail.addCondition(BaseProjectSettlementDetail.CS_SETTLEMENT_ID, "IN", convars);
			List<BaseProjectSettlementDetail> projectsettlementdetails = projectsettlementdetail.conditionalLoad(null);
			for(BaseProjectSettlementWithP ii : result){ ii.setDetailProjectSettlementDetail(new ArrayList<BaseProjectSettlementDetail>()); }
			for(BaseProjectSettlementDetail mm : projectsettlementdetails){
				for(BaseProjectSettlementWithP nn : result){
					if(mm.getSettlementId().equals(nn.getSettlementId())) { nn.getDetailProjectSettlementDetail().add(mm); break; } 
				}
			}
		}
		return result;
	}

	public BaseProjectSettlementWithP generateBaseExt() {
		BaseProjectSettlementWithP ____result = new BaseProjectSettlementWithP();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseProjectSettlementWithP __base) {
		super.setDataFromBase(__base);
		setDetailProjectSettlementDetail(__base.getDetailProjectSettlementDetail());
	}

	public void setDataToBase(BaseProjectSettlementWithP __base) {
		super.setDataToBase(__base);
		__base.setDetailProjectSettlementDetail(getDetailProjectSettlementDetail());
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

	public boolean isDeleteDetailProjectSettlementDetail() {
		return this.__detail_delete_projectsettlementdetail;
	}

	public void setDeleteDetailProjectSettlementDetail( boolean value ) {
		this.__detail_delete_projectsettlementdetail = value;
	}

	protected boolean __detail_delete_projectsettlementdetail = false; 
	protected List<BaseProjectSettlementDetail> __detail_projectsettlementdetail ; 
}
