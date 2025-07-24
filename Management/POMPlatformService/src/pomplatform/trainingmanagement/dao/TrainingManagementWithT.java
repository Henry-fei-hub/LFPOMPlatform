package pomplatform.trainingmanagement.dao;

import java.util.*;
import pomplatform.trainingmanagement.bean.BaseTrainingManagementWithT;
import com.pomplatform.db.bean.BaseTrainingManagementDetail;
import com.pomplatform.db.dao.TrainingManagementDetail;

public class TrainingManagementWithT extends com.pomplatform.db.dao.TrainingManagement
{


	public TrainingManagementWithT() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseTrainingManagementDetail> getDetailTrainingManagementDetail() {
		return this.__detail_trainingmanagementdetail;
	}

	public void setDetailTrainingManagementDetail( List<BaseTrainingManagementDetail> value ) {
		this.__detail_trainingmanagementdetail = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate  DAO
		TrainingManagementDetail trainingmanagementdetail = new TrainingManagementDetail();
		// load the original details.
		trainingmanagementdetail.setConditionTrainingManagementId("=", getTrainingManagementId());
		List<BaseTrainingManagementDetail> originaltrainingmanagementdetail = trainingmanagementdetail.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailTrainingManagementDetail() != null) {
			// need to delete list.
			List<BaseTrainingManagementDetail> needToDeleteTrainingManagementDetail = new ArrayList<>();
			// need to add list.
			List<BaseTrainingManagementDetail> needToAddTrainingManagementDetail = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseTrainingManagementDetail __trainingmanagementdetail : getDetailTrainingManagementDetail() ) {
				// set the relative field.
				__trainingmanagementdetail.setTrainingManagementId( getTrainingManagementId());
				// set find flag
				boolean foundTrainingManagementDetail = false;
				// find the original list.
				for(BaseTrainingManagementDetail __originaltrainingmanagementdetail : originaltrainingmanagementdetail) {
					// if found the original record
					if(__trainingmanagementdetail.compareTo(__originaltrainingmanagementdetail) == 0) {
						// set found flag to true
						foundTrainingManagementDetail = true;
						// update the record.
						// clear DAO's data
						trainingmanagementdetail.clearCurrentData();
						// set original data into DAO
						trainingmanagementdetail.setDataFromBase(__originaltrainingmanagementdetail);
						// clear DAO modification flag, just like the is loaded from DB
						trainingmanagementdetail.clearModifiedFlags();
						// set current data into DAO
						trainingmanagementdetail.setDataFromBase(__trainingmanagementdetail);
						// execute update
						trainingmanagementdetail.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundTrainingManagementDetail) needToAddTrainingManagementDetail.add(__trainingmanagementdetail);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseTrainingManagementDetail __originaltrainingmanagementdetail : originaltrainingmanagementdetail) {
				boolean foundTrainingManagementDetail = false;
				for(BaseTrainingManagementDetail __trainingmanagementdetail : getDetailTrainingManagementDetail() ) {
					if(__trainingmanagementdetail.compareTo(__originaltrainingmanagementdetail) == 0) {
						foundTrainingManagementDetail = true;
						break;
				}
				}
				if(!foundTrainingManagementDetail) needToDeleteTrainingManagementDetail.add(__originaltrainingmanagementdetail);
			}
			// process need-to-add list
			for(BaseTrainingManagementDetail __trainingmanagementdetail : needToAddTrainingManagementDetail ) {
				trainingmanagementdetail.clearCurrentData();
				trainingmanagementdetail.setDataFromBase(__trainingmanagementdetail);
				trainingmanagementdetail.save();
			}
			// process need-to-delete list
			for(BaseTrainingManagementDetail __trainingmanagementdetail : needToDeleteTrainingManagementDetail ) {
				deleteFromTrainingManagementDetail(__trainingmanagementdetail, trainingmanagementdetail);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseTrainingManagementDetail __trainingmanagementdetail : originaltrainingmanagementdetail ) {
				deleteFromTrainingManagementDetail(__trainingmanagementdetail, trainingmanagementdetail);
			}
		}
	}

	private void deleteFromTrainingManagementDetail(BaseTrainingManagementDetail bean, TrainingManagementDetail dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setTrainingManagementId(null);
		if(__detail_delete_trainingmanagementdetail) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		TrainingManagementDetail trainingmanagementdetail = new TrainingManagementDetail();
		trainingmanagementdetail.setConditionTrainingManagementId("=", getTrainingManagementId());
		trainingmanagementdetail.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			TrainingManagementDetail trainingmanagementdetail = new TrainingManagementDetail();
			trainingmanagementdetail.setConditionTrainingManagementId("=", getTrainingManagementId());
			setDetailTrainingManagementDetail(trainingmanagementdetail.conditionalLoad());
		}
		return true;
	}

	public List<BaseTrainingManagementWithT> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseTrainingManagementWithT> result = BaseTrainingManagementWithT.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseTrainingManagementWithT generateBaseExt() {
		BaseTrainingManagementWithT ____result = new BaseTrainingManagementWithT();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseTrainingManagementWithT __base) {
		super.setDataFromBase(__base);
		setDetailTrainingManagementDetail(__base.getDetailTrainingManagementDetail());
	}

	public void setDataToBase(BaseTrainingManagementWithT __base) {
		super.setDataToBase(__base);
		__base.setDetailTrainingManagementDetail(getDetailTrainingManagementDetail());
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

	public boolean isDeleteDetailTrainingManagementDetail() {
		return this.__detail_delete_trainingmanagementdetail;
	}

	public void setDeleteDetailTrainingManagementDetail( boolean value ) {
		this.__detail_delete_trainingmanagementdetail = value;
	}

	protected boolean __detail_delete_trainingmanagementdetail = true; 
	protected List<BaseTrainingManagementDetail> __detail_trainingmanagementdetail ; 
}
