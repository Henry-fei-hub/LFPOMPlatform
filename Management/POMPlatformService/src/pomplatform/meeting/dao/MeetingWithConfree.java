package pomplatform.meeting.dao;

import com.pomplatform.db.bean.BaseConfree;
import com.pomplatform.db.dao.Confree;
import com.pomplatform.db.dao.Meeting;
import pomplatform.meeting.bean.BaseMeetingWithConfree;

import java.util.ArrayList;
import java.util.List;

public class MeetingWithConfree extends Meeting
{
	public MeetingWithConfree() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseConfree> getDetailConfree() {
		return this.__detail_confree;
	}

	public void setDetailConfree( List<BaseConfree> value ) {
		this.__detail_confree = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate  DAO
		Confree confree = new Confree();
		// load the original details.
		confree.setConditionMeetingRelevanceId("=", getMeetingRelevanceId());
		List<BaseConfree> originalconfree = confree.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailConfree() != null) {
			// need to delete list.
			List<BaseConfree> needToDeleteConfree = new ArrayList<>();
			// need to add list.
			List<BaseConfree> needToAddConfree = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseConfree __confree : getDetailConfree() ) {
				// set the relative field.
				__confree.setMeetingRelevanceId( getMeetingRelevanceId());
				// set find flag
				boolean foundConfree = false;
				// find the original list.
				for(BaseConfree __originalconfree : originalconfree) {
					// if found the original record
					if(__confree.compareTo(__originalconfree) == 0) {
						// set found flag to true
						foundConfree = true;
						// update the record.
						// clear DAO's data
						confree.clearCurrentData();
						// set original data into DAO
						confree.setDataFromBase(__originalconfree);
						// clear DAO modification flag, just like the is loaded from DB
						confree.clearModifiedFlags();
						// set current data into DAO
						confree.setDataFromBase(__confree);
						// execute update
						confree.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundConfree) needToAddConfree.add(__confree);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseConfree __originalconfree : originalconfree) {
				boolean foundConfree = false;
				for(BaseConfree __confree : getDetailConfree() ) {
					if(__confree.compareTo(__originalconfree) == 0) {
						foundConfree = true;
						break;
					}
				}
				if(!foundConfree) needToDeleteConfree.add(__originalconfree);
			}
			// process need-to-delete list
			for(BaseConfree __confree : needToDeleteConfree ) {
				deleteFromConfree(__confree, confree);
			}
			// process need-to-add list
			for(BaseConfree __confree : needToAddConfree ) {
				confree.clearCurrentData();
				confree.setDataFromBase(__confree);
				confree.save();
				__confree.setConfereeId(confree.getConfereeId());
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseConfree __confree : originalconfree ) {
				deleteFromConfree(__confree, confree);
			}
		}
	}

	private void deleteFromConfree(BaseConfree bean, Confree dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setMeetingRelevanceId(null);
		if(__detail_delete_confree) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		Confree confree = new Confree();
		confree.setConditionMeetingRelevanceId("=", getMeetingRelevanceId());
		confree.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			Confree confree = new Confree();
			confree.setConditionMeetingRelevanceId("=", getMeetingRelevanceId());
			setDetailConfree(confree.conditionalLoad());
		}
		return true;
	}

	public List<BaseMeetingWithConfree> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseMeetingWithConfree> result = BaseMeetingWithConfree.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseMeetingWithConfree generateBaseExt() {
		BaseMeetingWithConfree ____result = new BaseMeetingWithConfree();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseMeetingWithConfree __base) {
		super.setDataFromBase(__base);
		setDetailConfree(__base.getDetailConfree());
	}

	public void setDataToBase(BaseMeetingWithConfree __base) {
		super.setDataToBase(__base);
		__base.setDetailConfree(getDetailConfree());
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

	public boolean isDeleteDetailConfree() {
		return this.__detail_delete_confree;
	}

	public void setDeleteDetailConfree( boolean value ) {
		this.__detail_delete_confree = value;
	}

	protected boolean __detail_delete_confree = true;
	protected List<BaseConfree> __detail_confree ;
}
