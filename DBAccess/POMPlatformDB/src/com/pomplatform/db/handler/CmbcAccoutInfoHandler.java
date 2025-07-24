package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCmbcAccoutInfo;
import com.pomplatform.db.dao.CmbcAccoutInfo;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CmbcAccoutInfoHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CmbcAccoutInfoHandler.class);

	public static BaseCmbcAccoutInfo getCmbcAccoutInfoById( 
		java.lang.Integer cmbc_accout_info_id
	) throws Exception
	{
		CmbcAccoutInfo dao = new CmbcAccoutInfo();
		dao.setCmbcAccoutInfoId(cmbc_accout_info_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCmbcAccoutInfoExists( com.pomplatform.db.bean.BaseCmbcAccoutInfo bean, String additional ) throws Exception {

		CmbcAccoutInfo dao = new CmbcAccoutInfo();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCmbcAccoutInfo( com.pomplatform.db.bean.BaseCmbcAccoutInfo bean, String additional ) throws Exception {

		CmbcAccoutInfo dao = new CmbcAccoutInfo();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCmbcAccoutInfo> queryCmbcAccoutInfo( com.pomplatform.db.bean.BaseCmbcAccoutInfo bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CmbcAccoutInfo dao = new CmbcAccoutInfo();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCmbcAccoutInfo> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCmbcAccoutInfo> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCmbcAccoutInfo addToCmbcAccoutInfo ( BaseCmbcAccoutInfo cmbcaccoutinfo )  throws Exception {
		return addToCmbcAccoutInfo ( cmbcaccoutinfo , false);
	}

	public static BaseCmbcAccoutInfo addToCmbcAccoutInfo ( BaseCmbcAccoutInfo cmbcaccoutinfo, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CmbcAccoutInfo dao = new CmbcAccoutInfo();
		dao.setDataFromBase(cmbcaccoutinfo);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCmbcAccoutInfo addUpdateCmbcAccoutInfo ( BaseCmbcAccoutInfo cmbcaccoutinfo ) throws Exception {
		return addUpdateCmbcAccoutInfo ( cmbcaccoutinfo , false);
	}

	public static BaseCmbcAccoutInfo addUpdateCmbcAccoutInfo ( BaseCmbcAccoutInfo cmbcaccoutinfo, boolean singleTransaction  ) throws Exception {
		if(cmbcaccoutinfo.getCmbcAccoutInfoId() == null) return addToCmbcAccoutInfo(cmbcaccoutinfo);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CmbcAccoutInfo dao = new CmbcAccoutInfo();
		dao.setDataFromBase(cmbcaccoutinfo);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cmbcaccoutinfo); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCmbcAccoutInfo ( BaseCmbcAccoutInfo bean ) throws Exception {
		CmbcAccoutInfo dao = new CmbcAccoutInfo();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCmbcAccoutInfo updateCmbcAccoutInfo ( BaseCmbcAccoutInfo cmbcaccoutinfo ) throws Exception {
		CmbcAccoutInfo dao = new CmbcAccoutInfo();
		dao.setCmbcAccoutInfoId( cmbcaccoutinfo.getCmbcAccoutInfoId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cmbcaccoutinfo);
			result = dao.update();
		}
		return result == 1 ? cmbcaccoutinfo : null ;
	}

	public static BaseCmbcAccoutInfo updateCmbcAccoutInfoDirect( BaseCmbcAccoutInfo cmbcaccoutinfo ) throws Exception {
		CmbcAccoutInfo dao = new CmbcAccoutInfo();
		int result = 0;
		dao.setDataFromBase(cmbcaccoutinfo);
		result = dao.update();
		return result == 1 ? cmbcaccoutinfo : null ;
	}

	public static int setDeleteConditions(BaseCmbcAccoutInfo bean, CmbcAccoutInfo dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCmbcAccoutInfoId() != null) {
			dao.setConditionCmbcAccoutInfoId("=", bean.getCmbcAccoutInfoId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCcynbr() != null) {
				dao.setConditionCcynbr("=", bean.getCcynbr());
				count++;
			}
			if(bean.getCCcynbr() != null) {
				dao.setConditionCCcynbr("=", bean.getCCcynbr());
				count++;
			}
			if(bean.getAccitm() != null) {
				dao.setConditionAccitm("=", bean.getAccitm());
				count++;
			}
			if(bean.getBbknbr() != null) {
				dao.setConditionBbknbr("=", bean.getBbknbr());
				count++;
			}
			if(bean.getAccnbr() != null) {
				dao.setConditionAccnbr("=", bean.getAccnbr());
				count++;
			}
			if(bean.getAccnam() != null) {
				dao.setConditionAccnam("=", bean.getAccnam());
				count++;
			}
			if(bean.getStscod() != null) {
				dao.setConditionStscod("=", bean.getStscod());
				count++;
			}
			if(bean.getIntcod() != null) {
				dao.setConditionIntcod("=", bean.getIntcod());
				count++;
			}
			if(bean.getCIntrat() != null) {
				dao.setConditionCIntrat("=", bean.getCIntrat());
				count++;
			}
			if(bean.getInttyp() != null) {
				dao.setConditionInttyp("=", bean.getInttyp());
				count++;
			}
			if(bean.getDpstxt() != null) {
				dao.setConditionDpstxt("=", bean.getDpstxt());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCmbcAccoutInfo bean, CmbcAccoutInfo dao){
		int count = 0;
		if(bean.getCmbcAccoutInfoId() != null) {
			dao.setConditionCmbcAccoutInfoId("=", bean.getCmbcAccoutInfoId());
			count++;
		}
		if(bean.getCcynbr() != null) {
			if(bean.getCcynbr().indexOf("%") >= 0)
				dao.setConditionCcynbr("like", bean.getCcynbr());
			else
				dao.setConditionCcynbr("=", bean.getCcynbr());
			count++;
		}
		if(bean.getCCcynbr() != null) {
			if(bean.getCCcynbr().indexOf("%") >= 0)
				dao.setConditionCCcynbr("like", bean.getCCcynbr());
			else
				dao.setConditionCCcynbr("=", bean.getCCcynbr());
			count++;
		}
		if(bean.getAccitm() != null) {
			if(bean.getAccitm().indexOf("%") >= 0)
				dao.setConditionAccitm("like", bean.getAccitm());
			else
				dao.setConditionAccitm("=", bean.getAccitm());
			count++;
		}
		if(bean.getBbknbr() != null) {
			if(bean.getBbknbr().indexOf("%") >= 0)
				dao.setConditionBbknbr("like", bean.getBbknbr());
			else
				dao.setConditionBbknbr("=", bean.getBbknbr());
			count++;
		}
		if(bean.getAccnbr() != null) {
			if(bean.getAccnbr().indexOf("%") >= 0)
				dao.setConditionAccnbr("like", bean.getAccnbr());
			else
				dao.setConditionAccnbr("=", bean.getAccnbr());
			count++;
		}
		if(bean.getAccnam() != null) {
			if(bean.getAccnam().indexOf("%") >= 0)
				dao.setConditionAccnam("like", bean.getAccnam());
			else
				dao.setConditionAccnam("=", bean.getAccnam());
			count++;
		}
		if(bean.getAccblv() != null) {
			dao.setConditionAccblv("=", bean.getAccblv());
			count++;
		}
		if(bean.getOnlblv() != null) {
			dao.setConditionOnlblv("=", bean.getOnlblv());
			count++;
		}
		if(bean.getHldblv() != null) {
			dao.setConditionHldblv("=", bean.getHldblv());
			count++;
		}
		if(bean.getAvlblv() != null) {
			dao.setConditionAvlblv("=", bean.getAvlblv());
			count++;
		}
		if(bean.getLmtovr() != null) {
			dao.setConditionLmtovr("=", bean.getLmtovr());
			count++;
		}
		if(bean.getStscod() != null) {
			if(bean.getStscod().indexOf("%") >= 0)
				dao.setConditionStscod("like", bean.getStscod());
			else
				dao.setConditionStscod("=", bean.getStscod());
			count++;
		}
		if(bean.getIntcod() != null) {
			if(bean.getIntcod().indexOf("%") >= 0)
				dao.setConditionIntcod("like", bean.getIntcod());
			else
				dao.setConditionIntcod("=", bean.getIntcod());
			count++;
		}
		if(bean.getCIntrat() != null) {
			if(bean.getCIntrat().indexOf("%") >= 0)
				dao.setConditionCIntrat("like", bean.getCIntrat());
			else
				dao.setConditionCIntrat("=", bean.getCIntrat());
			count++;
		}
		if(bean.getIntrat() != null) {
			dao.setConditionIntrat("=", bean.getIntrat());
			count++;
		}
		if(bean.getOpndat() != null) {
			dao.setConditionOpndat(">=", bean.getOpndat());
			count++;
		}
		if(bean.getMutdat() != null) {
			dao.setConditionMutdat(">=", bean.getMutdat());
			count++;
		}
		if(bean.getInttyp() != null) {
			if(bean.getInttyp().indexOf("%") >= 0)
				dao.setConditionInttyp("like", bean.getInttyp());
			else
				dao.setConditionInttyp("=", bean.getInttyp());
			count++;
		}
		if(bean.getDpstxt() != null) {
			if(bean.getDpstxt().indexOf("%") >= 0)
				dao.setConditionDpstxt("like", bean.getDpstxt());
			else
				dao.setConditionDpstxt("=", bean.getDpstxt());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getUpdateTime() != null) {
			dao.setConditionUpdateTime(">=", bean.getUpdateTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCmbcAccoutInfo bean = new BaseCmbcAccoutInfo();
		bean.setDataFromJSON(json);
		CmbcAccoutInfo dao = new CmbcAccoutInfo();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCmbcAccoutInfo> rlist = new BaseCollection<>();
		BaseCmbcAccoutInfo bean = new BaseCmbcAccoutInfo();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CmbcAccoutInfo dao = new CmbcAccoutInfo();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCmbcAccoutInfo> result = dao.conditionalLoad(addtion);
		rlist.setCollections(result);
		rlist.setTotalPages(dao.getTotalPages());
		rlist.setCurrentPage(dao.getCurrentPage());
		rlist.setPageLines(dao.getPageLines());
		rlist.setTotalLines(dao.getTotalLines());
		rlist.setRecordNumber(result.size());
		return rlist.toJSON(null);
	}

	@Override
	public String save(String json) throws Exception{
		BaseCmbcAccoutInfo bean = new BaseCmbcAccoutInfo();
		bean.setDataFromJSON(json);
		CmbcAccoutInfo dao = new CmbcAccoutInfo();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCmbcAccoutInfo bean = new BaseCmbcAccoutInfo();
		bean.setDataFromJSON(json);
		CmbcAccoutInfo dao = new CmbcAccoutInfo();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCmbcAccoutInfo bean = new BaseCmbcAccoutInfo();
		bean.setDataFromJSON(json);
		CmbcAccoutInfo dao = new CmbcAccoutInfo();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCmbcAccoutInfo bean = new BaseCmbcAccoutInfo();
		bean.setDataFromJSON(json);
		CmbcAccoutInfo dao = new CmbcAccoutInfo();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


