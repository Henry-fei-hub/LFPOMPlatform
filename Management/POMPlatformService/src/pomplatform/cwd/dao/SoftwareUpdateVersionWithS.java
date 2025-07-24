package pomplatform.cwd.dao;

import java.util.*;
import pomplatform.cwd.bean.BaseSoftwareUpdateVersionWithS;
import com.pomplatform.db.bean.BaseSoftwareUpdateFile;
import com.pomplatform.db.dao.SoftwareUpdateFile;

public class SoftwareUpdateVersionWithS extends com.pomplatform.db.dao.SoftwareUpdateVersion
{


	public SoftwareUpdateVersionWithS() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseSoftwareUpdateFile> getDetailSoftwareUpdateFile() {
		return this.__detail_softwareupdatefile;
	}

	public void setDetailSoftwareUpdateFile( List<BaseSoftwareUpdateFile> value ) {
		this.__detail_softwareupdatefile = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate  DAO
		SoftwareUpdateFile softwareupdatefile = new SoftwareUpdateFile();
		// load the original details.
		softwareupdatefile.setConditionSoftwareUpdateVersionId("=", getSoftwareUpdateVersionId());
		List<BaseSoftwareUpdateFile> originalsoftwareupdatefile = softwareupdatefile.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailSoftwareUpdateFile() != null) {
			// need to delete list.
			List<BaseSoftwareUpdateFile> needToDeleteSoftwareUpdateFile = new ArrayList<>();
			// need to add list.
			List<BaseSoftwareUpdateFile> needToAddSoftwareUpdateFile = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseSoftwareUpdateFile __softwareupdatefile : getDetailSoftwareUpdateFile() ) {
				// set the relative field.
				__softwareupdatefile.setSoftwareUpdateVersionId( getSoftwareUpdateVersionId());
				// set find flag
				boolean foundSoftwareUpdateFile = false;
				// find the original list.
				for(BaseSoftwareUpdateFile __originalsoftwareupdatefile : originalsoftwareupdatefile) {
					// if found the original record
					if(__softwareupdatefile.compareTo(__originalsoftwareupdatefile) == 0) {
						// set found flag to true
						foundSoftwareUpdateFile = true;
						// update the record.
						// clear DAO's data
						softwareupdatefile.clearCurrentData();
						// set original data into DAO
						softwareupdatefile.setDataFromBase(__originalsoftwareupdatefile);
						// clear DAO modification flag, just like the is loaded from DB
						softwareupdatefile.clearModifiedFlags();
						// set current data into DAO
						softwareupdatefile.setDataFromBase(__softwareupdatefile);
						// execute update
						softwareupdatefile.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundSoftwareUpdateFile) needToAddSoftwareUpdateFile.add(__softwareupdatefile);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseSoftwareUpdateFile __originalsoftwareupdatefile : originalsoftwareupdatefile) {
				boolean foundSoftwareUpdateFile = false;
				for(BaseSoftwareUpdateFile __softwareupdatefile : getDetailSoftwareUpdateFile() ) {
					if(__softwareupdatefile.compareTo(__originalsoftwareupdatefile) == 0) {
						foundSoftwareUpdateFile = true;
						break;
				}
				}
				if(!foundSoftwareUpdateFile) needToDeleteSoftwareUpdateFile.add(__originalsoftwareupdatefile);
			}
			// process need-to-add list
			for(BaseSoftwareUpdateFile __softwareupdatefile : needToAddSoftwareUpdateFile ) {
				softwareupdatefile.clearCurrentData();
				softwareupdatefile.setDataFromBase(__softwareupdatefile);
				softwareupdatefile.save();
				__softwareupdatefile.setSoftwareUpdateFileId(softwareupdatefile.getSoftwareUpdateFileId());
			}
			// process need-to-delete list
			for(BaseSoftwareUpdateFile __softwareupdatefile : needToDeleteSoftwareUpdateFile ) {
				deleteFromSoftwareUpdateFile(__softwareupdatefile, softwareupdatefile);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseSoftwareUpdateFile __softwareupdatefile : originalsoftwareupdatefile ) {
				deleteFromSoftwareUpdateFile(__softwareupdatefile, softwareupdatefile);
			}
		}
	}

	private void deleteFromSoftwareUpdateFile(BaseSoftwareUpdateFile bean, SoftwareUpdateFile dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setSoftwareUpdateVersionId(null);
		if(__detail_delete_softwareupdatefile) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		SoftwareUpdateFile softwareupdatefile = new SoftwareUpdateFile();
		softwareupdatefile.setConditionSoftwareUpdateVersionId("=", getSoftwareUpdateVersionId());
		softwareupdatefile.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			SoftwareUpdateFile softwareupdatefile = new SoftwareUpdateFile();
			softwareupdatefile.setConditionSoftwareUpdateVersionId("=", getSoftwareUpdateVersionId());
			setDetailSoftwareUpdateFile(softwareupdatefile.conditionalLoad());
		}
		return true;
	}

	public List<BaseSoftwareUpdateVersionWithS> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseSoftwareUpdateVersionWithS> result = BaseSoftwareUpdateVersionWithS.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseSoftwareUpdateVersionWithS generateBaseExt() {
		BaseSoftwareUpdateVersionWithS ____result = new BaseSoftwareUpdateVersionWithS();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseSoftwareUpdateVersionWithS __base) {
		super.setDataFromBase(__base);
		setDetailSoftwareUpdateFile(__base.getDetailSoftwareUpdateFile());
	}

	public void setDataToBase(BaseSoftwareUpdateVersionWithS __base) {
		super.setDataToBase(__base);
		__base.setDetailSoftwareUpdateFile(getDetailSoftwareUpdateFile());
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

	public boolean isDeleteDetailSoftwareUpdateFile() {
		return this.__detail_delete_softwareupdatefile;
	}

	public void setDeleteDetailSoftwareUpdateFile( boolean value ) {
		this.__detail_delete_softwareupdatefile = value;
	}

	protected boolean __detail_delete_softwareupdatefile = true; 
	protected List<BaseSoftwareUpdateFile> __detail_softwareupdatefile ; 
}
