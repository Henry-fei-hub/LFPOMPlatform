package pomplatform.onprojectquotetemplateworkflow.dao;

import java.util.*;
import pomplatform.onprojectquotetemplateworkflow.bean.BaseProjectQuoteWithP;
import com.pomplatform.db.bean.BaseProjectQuoteDetail;
import com.pomplatform.db.dao.ProjectQuoteDetail;

public class ProjectQuoteWithP extends com.pomplatform.db.dao.ProjectQuote
{


	public ProjectQuoteWithP() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseProjectQuoteDetail> getDetailProjectQuoteDetail() {
		return this.__detail_projectquotedetail;
	}

	public void setDetailProjectQuoteDetail( List<BaseProjectQuoteDetail> value ) {
		this.__detail_projectquotedetail = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate 项目报价详情表 DAO
		ProjectQuoteDetail projectquotedetail = new ProjectQuoteDetail();
		// load the original details.
		projectquotedetail.setConditionProjectQuoteId("=", getProjectQuoteId());
		List<BaseProjectQuoteDetail> originalprojectquotedetail = projectquotedetail.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailProjectQuoteDetail() != null) {
			// need to delete list.
			List<BaseProjectQuoteDetail> needToDeleteProjectQuoteDetail = new ArrayList<>();
			// need to add list.
			List<BaseProjectQuoteDetail> needToAddProjectQuoteDetail = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseProjectQuoteDetail __projectquotedetail : getDetailProjectQuoteDetail() ) {
				// set the relative field.
				__projectquotedetail.setProjectQuoteId( getProjectQuoteId());
				// set find flag
				boolean foundProjectQuoteDetail = false;
				// find the original list.
				for(BaseProjectQuoteDetail __originalprojectquotedetail : originalprojectquotedetail) {
					// if found the original record
					if(__projectquotedetail.compareTo(__originalprojectquotedetail) == 0) {
						// set found flag to true
						foundProjectQuoteDetail = true;
						// update the record.
						// clear DAO's data
						projectquotedetail.clearCurrentData();
						// set original data into DAO
						projectquotedetail.setDataFromBase(__originalprojectquotedetail);
						// clear DAO modification flag, just like the is loaded from DB
						projectquotedetail.clearModifiedFlags();
						// set current data into DAO
						projectquotedetail.setDataFromBase(__projectquotedetail);
						// execute update
						projectquotedetail.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundProjectQuoteDetail) needToAddProjectQuoteDetail.add(__projectquotedetail);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseProjectQuoteDetail __originalprojectquotedetail : originalprojectquotedetail) {
				boolean foundProjectQuoteDetail = false;
				for(BaseProjectQuoteDetail __projectquotedetail : getDetailProjectQuoteDetail() ) {
					if(__projectquotedetail.compareTo(__originalprojectquotedetail) == 0) {
						foundProjectQuoteDetail = true;
						break;
				}
				}
				if(!foundProjectQuoteDetail) needToDeleteProjectQuoteDetail.add(__originalprojectquotedetail);
			}
			// process need-to-add list
			for(BaseProjectQuoteDetail __projectquotedetail : needToAddProjectQuoteDetail ) {
				projectquotedetail.clearCurrentData();
				projectquotedetail.setDataFromBase(__projectquotedetail);
				projectquotedetail.save();
				__projectquotedetail.setProjectQuoteDetailId(projectquotedetail.getProjectQuoteDetailId());
			}
			// process need-to-delete list
			for(BaseProjectQuoteDetail __projectquotedetail : needToDeleteProjectQuoteDetail ) {
				deleteFromProjectQuoteDetail(__projectquotedetail, projectquotedetail);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseProjectQuoteDetail __projectquotedetail : originalprojectquotedetail ) {
				deleteFromProjectQuoteDetail(__projectquotedetail, projectquotedetail);
			}
		}
	}

	private void deleteFromProjectQuoteDetail(BaseProjectQuoteDetail bean, ProjectQuoteDetail dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setProjectQuoteId(null);
		if(__detail_delete_projectquotedetail) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		ProjectQuoteDetail projectquotedetail = new ProjectQuoteDetail();
		projectquotedetail.setConditionProjectQuoteId("=", getProjectQuoteId());
		projectquotedetail.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			ProjectQuoteDetail projectquotedetail = new ProjectQuoteDetail();
			projectquotedetail.setConditionProjectQuoteId("=", getProjectQuoteId());
			setDetailProjectQuoteDetail(projectquotedetail.conditionalLoad());
		}
		return true;
	}

	public List<BaseProjectQuoteWithP> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseProjectQuoteWithP> result = BaseProjectQuoteWithP.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseProjectQuoteWithP generateBaseExt() {
		BaseProjectQuoteWithP ____result = new BaseProjectQuoteWithP();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseProjectQuoteWithP __base) {
		super.setDataFromBase(__base);
		setDetailProjectQuoteDetail(__base.getDetailProjectQuoteDetail());
	}

	public void setDataToBase(BaseProjectQuoteWithP __base) {
		super.setDataToBase(__base);
		__base.setDetailProjectQuoteDetail(getDetailProjectQuoteDetail());
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

	public boolean isDeleteDetailProjectQuoteDetail() {
		return this.__detail_delete_projectquotedetail;
	}

	public void setDeleteDetailProjectQuoteDetail( boolean value ) {
		this.__detail_delete_projectquotedetail = value;
	}

	protected boolean __detail_delete_projectquotedetail = true; 
	protected List<BaseProjectQuoteDetail> __detail_projectquotedetail ; 
}
