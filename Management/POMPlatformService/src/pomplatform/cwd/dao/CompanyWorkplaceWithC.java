package pomplatform.cwd.dao;

import java.util.ArrayList;
import java.util.List;

import com.pomplatform.db.bean.BaseCompanyWorkplaceServer;
import com.pomplatform.db.dao.CompanyWorkplace;
import com.pomplatform.db.dao.CompanyWorkplaceServer;

import pomplatform.cwd.bean.BaseCompanyWorkplaceWithC;

public class CompanyWorkplaceWithC extends CompanyWorkplace
{


	public CompanyWorkplaceWithC() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseCompanyWorkplaceServer> getDetailCompanyWorkplaceServer() {
		return this.__detail_companyworkplaceserver;
	}

	public void setDetailCompanyWorkplaceServer( List<BaseCompanyWorkplaceServer> value ) {
		this.__detail_companyworkplaceserver = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// instantiate 工作场所服务器配置表 DAO
		CompanyWorkplaceServer companyworkplaceserver = new CompanyWorkplaceServer();
		// load the original details.
		companyworkplaceserver.setConditionWorkplaceId("=", getCompanyWorkplaceId());
		List<BaseCompanyWorkplaceServer> originalcompanyworkplaceserver = companyworkplaceserver.conditionalLoad(null);
		// if current detail is not empty.
		if(getDetailCompanyWorkplaceServer() != null) {
			// need to delete list.
			List<BaseCompanyWorkplaceServer> needToDeleteCompanyWorkplaceServer = new ArrayList<>();
			// need to add list.
			List<BaseCompanyWorkplaceServer> needToAddCompanyWorkplaceServer = new ArrayList<>();
			// find the record that exists in the original list and update.
			for(BaseCompanyWorkplaceServer __companyworkplaceserver : getDetailCompanyWorkplaceServer() ) {
				// set the relative field.
				__companyworkplaceserver.setWorkplaceId( getCompanyWorkplaceId());
				// set find flag
				boolean foundCompanyWorkplaceServer = false;
				// find the original list.
				for(BaseCompanyWorkplaceServer __originalcompanyworkplaceserver : originalcompanyworkplaceserver) {
					// if found the original record
					if(__companyworkplaceserver.compareTo(__originalcompanyworkplaceserver) == 0) {
						// set found flag to true
						foundCompanyWorkplaceServer = true;
						// update the record.
						// clear DAO's data
						companyworkplaceserver.clearCurrentData();
						// set original data into DAO
						companyworkplaceserver.setDataFromBase(__originalcompanyworkplaceserver);
						// clear DAO modification flag, just like the is loaded from DB
						companyworkplaceserver.clearModifiedFlags();
						// set current data into DAO
						companyworkplaceserver.setDataFromBase(__companyworkplaceserver);
						// execute update
						companyworkplaceserver.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if(!foundCompanyWorkplaceServer) needToAddCompanyWorkplaceServer.add(__companyworkplaceserver);
			}
			// find the records that exists in the original list and not in the current list.
			for(BaseCompanyWorkplaceServer __originalcompanyworkplaceserver : originalcompanyworkplaceserver) {
				boolean foundCompanyWorkplaceServer = false;
				for(BaseCompanyWorkplaceServer __companyworkplaceserver : getDetailCompanyWorkplaceServer() ) {
					if(__companyworkplaceserver.compareTo(__originalcompanyworkplaceserver) == 0) {
						foundCompanyWorkplaceServer = true;
						break;
				}
				}
				if(!foundCompanyWorkplaceServer) needToDeleteCompanyWorkplaceServer.add(__originalcompanyworkplaceserver);
			}
			// process need-to-add list
			for(BaseCompanyWorkplaceServer __companyworkplaceserver : needToAddCompanyWorkplaceServer ) {
				companyworkplaceserver.clearCurrentData();
				companyworkplaceserver.setDataFromBase(__companyworkplaceserver);
				companyworkplaceserver.save();
				__companyworkplaceserver.setWorkplaceServerId(companyworkplaceserver.getWorkplaceServerId());
			}
			// process need-to-delete list
			for(BaseCompanyWorkplaceServer __companyworkplaceserver : needToDeleteCompanyWorkplaceServer ) {
				deleteFromCompanyWorkplaceServer(__companyworkplaceserver, companyworkplaceserver);
			}
		} else {
			// if current list is empty, then delete all original list.
			for(BaseCompanyWorkplaceServer __companyworkplaceserver : originalcompanyworkplaceserver ) {
				deleteFromCompanyWorkplaceServer(__companyworkplaceserver, companyworkplaceserver);
			}
		}
	}

	private void deleteFromCompanyWorkplaceServer(BaseCompanyWorkplaceServer bean, CompanyWorkplaceServer dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setWorkplaceId(null);
		if(__detail_delete_companyworkplaceserver) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		CompanyWorkplaceServer companyworkplaceserver = new CompanyWorkplaceServer();
		companyworkplaceserver.setConditionWorkplaceId("=", getCompanyWorkplaceId());
		companyworkplaceserver.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			CompanyWorkplaceServer companyworkplaceserver = new CompanyWorkplaceServer();
			companyworkplaceserver.setConditionWorkplaceId("=", getCompanyWorkplaceId());
			setDetailCompanyWorkplaceServer(companyworkplaceserver.conditionalLoad());
		}
		return true;
	}

	public List<BaseCompanyWorkplaceWithC> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseCompanyWorkplaceWithC> result = BaseCompanyWorkplaceWithC.getBeanList(conditionalLoad(addtional));
		return result;
	}

	public BaseCompanyWorkplaceWithC generateBaseExt() {
		BaseCompanyWorkplaceWithC ____result = new BaseCompanyWorkplaceWithC();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseCompanyWorkplaceWithC __base) {
		super.setDataFromBase(__base);
		setDetailCompanyWorkplaceServer(__base.getDetailCompanyWorkplaceServer());
	}

	public void setDataToBase(BaseCompanyWorkplaceWithC __base) {
		super.setDataToBase(__base);
		__base.setDetailCompanyWorkplaceServer(getDetailCompanyWorkplaceServer());
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

	public boolean isDeleteDetailCompanyWorkplaceServer() {
		return this.__detail_delete_companyworkplaceserver;
	}

	public void setDeleteDetailCompanyWorkplaceServer( boolean value ) {
		this.__detail_delete_companyworkplaceserver = value;
	}

	protected boolean __detail_delete_companyworkplaceserver = true; 
	protected List<BaseCompanyWorkplaceServer> __detail_companyworkplaceserver ; 
}
