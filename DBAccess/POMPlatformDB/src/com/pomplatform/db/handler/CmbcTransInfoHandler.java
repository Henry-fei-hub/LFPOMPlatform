package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCmbcTransInfo;
import com.pomplatform.db.dao.CmbcTransInfo;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CmbcTransInfoHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CmbcTransInfoHandler.class);

	public static BaseCmbcTransInfo getCmbcTransInfoById( 
		java.lang.Integer cmbc_trans_info_id
	) throws Exception
	{
		CmbcTransInfo dao = new CmbcTransInfo();
		dao.setCmbcTransInfoId(cmbc_trans_info_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCmbcTransInfoExists( com.pomplatform.db.bean.BaseCmbcTransInfo bean, String additional ) throws Exception {

		CmbcTransInfo dao = new CmbcTransInfo();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCmbcTransInfo( com.pomplatform.db.bean.BaseCmbcTransInfo bean, String additional ) throws Exception {

		CmbcTransInfo dao = new CmbcTransInfo();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCmbcTransInfo> queryCmbcTransInfo( com.pomplatform.db.bean.BaseCmbcTransInfo bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CmbcTransInfo dao = new CmbcTransInfo();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCmbcTransInfo> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCmbcTransInfo> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCmbcTransInfo addToCmbcTransInfo ( BaseCmbcTransInfo cmbctransinfo )  throws Exception {
		return addToCmbcTransInfo ( cmbctransinfo , false);
	}

	public static BaseCmbcTransInfo addToCmbcTransInfo ( BaseCmbcTransInfo cmbctransinfo, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CmbcTransInfo dao = new CmbcTransInfo();
		dao.setDataFromBase(cmbctransinfo);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCmbcTransInfo addUpdateCmbcTransInfo ( BaseCmbcTransInfo cmbctransinfo ) throws Exception {
		return addUpdateCmbcTransInfo ( cmbctransinfo , false);
	}

	public static BaseCmbcTransInfo addUpdateCmbcTransInfo ( BaseCmbcTransInfo cmbctransinfo, boolean singleTransaction  ) throws Exception {
		if(cmbctransinfo.getCmbcTransInfoId() == null) return addToCmbcTransInfo(cmbctransinfo);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CmbcTransInfo dao = new CmbcTransInfo();
		dao.setDataFromBase(cmbctransinfo);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cmbctransinfo); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCmbcTransInfo ( BaseCmbcTransInfo bean ) throws Exception {
		CmbcTransInfo dao = new CmbcTransInfo();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCmbcTransInfo updateCmbcTransInfo ( BaseCmbcTransInfo cmbctransinfo ) throws Exception {
		CmbcTransInfo dao = new CmbcTransInfo();
		dao.setCmbcTransInfoId( cmbctransinfo.getCmbcTransInfoId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cmbctransinfo);
			result = dao.update();
		}
		return result == 1 ? cmbctransinfo : null ;
	}

	public static BaseCmbcTransInfo updateCmbcTransInfoDirect( BaseCmbcTransInfo cmbctransinfo ) throws Exception {
		CmbcTransInfo dao = new CmbcTransInfo();
		int result = 0;
		dao.setDataFromBase(cmbctransinfo);
		result = dao.update();
		return result == 1 ? cmbctransinfo : null ;
	}

	public static int setDeleteConditions(BaseCmbcTransInfo bean, CmbcTransInfo dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCmbcTransInfoId() != null) {
			dao.setConditionCmbcTransInfoId("=", bean.getCmbcTransInfoId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getBankAccount() != null) {
				dao.setConditionBankAccount("=", bean.getBankAccount());
				count++;
			}
			if(bean.getEtydat() != null) {
				dao.setConditionEtydat("=", bean.getEtydat());
				count++;
			}
			if(bean.getEtytim() != null) {
				dao.setConditionEtytim("=", bean.getEtytim());
				count++;
			}
			if(bean.getTrscod() != null) {
				dao.setConditionTrscod("=", bean.getTrscod());
				count++;
			}
			if(bean.getNaryur() != null) {
				dao.setConditionNaryur("=", bean.getNaryur());
				count++;
			}
			if(bean.getAmtcdr() != null) {
				dao.setConditionAmtcdr("=", bean.getAmtcdr());
				count++;
			}
			if(bean.getRefnbr() != null) {
				dao.setConditionRefnbr("=", bean.getRefnbr());
				count++;
			}
			if(bean.getReqnbr() != null) {
				dao.setConditionReqnbr("=", bean.getReqnbr());
				count++;
			}
			if(bean.getBusnam() != null) {
				dao.setConditionBusnam("=", bean.getBusnam());
				count++;
			}
			if(bean.getNusage() != null) {
				dao.setConditionNusage("=", bean.getNusage());
				count++;
			}
			if(bean.getYurref() != null) {
				dao.setConditionYurref("=", bean.getYurref());
				count++;
			}
			if(bean.getBusnar() != null) {
				dao.setConditionBusnar("=", bean.getBusnar());
				count++;
			}
			if(bean.getOtrnar() != null) {
				dao.setConditionOtrnar("=", bean.getOtrnar());
				count++;
			}
			if(bean.getCRpybbk() != null) {
				dao.setConditionCRpybbk("=", bean.getCRpybbk());
				count++;
			}
			if(bean.getRpynam() != null) {
				dao.setConditionRpynam("=", bean.getRpynam());
				count++;
			}
			if(bean.getRpyacc() != null) {
				dao.setConditionRpyacc("=", bean.getRpyacc());
				count++;
			}
			if(bean.getRpybbn() != null) {
				dao.setConditionRpybbn("=", bean.getRpybbn());
				count++;
			}
			if(bean.getRpybnk() != null) {
				dao.setConditionRpybnk("=", bean.getRpybnk());
				count++;
			}
			if(bean.getRpyadr() != null) {
				dao.setConditionRpyadr("=", bean.getRpyadr());
				count++;
			}
			if(bean.getCGsbbbk() != null) {
				dao.setConditionCGsbbbk("=", bean.getCGsbbbk());
				count++;
			}
			if(bean.getGsbacc() != null) {
				dao.setConditionGsbacc("=", bean.getGsbacc());
				count++;
			}
			if(bean.getGsbnam() != null) {
				dao.setConditionGsbnam("=", bean.getGsbnam());
				count++;
			}
			if(bean.getInfflg() != null) {
				dao.setConditionInfflg("=", bean.getInfflg());
				count++;
			}
			if(bean.getAthflg() != null) {
				dao.setConditionAthflg("=", bean.getAthflg());
				count++;
			}
			if(bean.getChknbr() != null) {
				dao.setConditionChknbr("=", bean.getChknbr());
				count++;
			}
			if(bean.getRsvflg() != null) {
				dao.setConditionRsvflg("=", bean.getRsvflg());
				count++;
			}
			if(bean.getNarext() != null) {
				dao.setConditionNarext("=", bean.getNarext());
				count++;
			}
			if(bean.getTrsanl() != null) {
				dao.setConditionTrsanl("=", bean.getTrsanl());
				count++;
			}
			if(bean.getRefsub() != null) {
				dao.setConditionRefsub("=", bean.getRefsub());
				count++;
			}
			if(bean.getFrmcod() != null) {
				dao.setConditionFrmcod("=", bean.getFrmcod());
				count++;
			}
			if(bean.getTransType() != null) {
				dao.setConditionTransType("=", bean.getTransType());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCmbcTransInfo bean, CmbcTransInfo dao){
		int count = 0;
		if(bean.getCmbcTransInfoId() != null) {
			dao.setConditionCmbcTransInfoId("=", bean.getCmbcTransInfoId());
			count++;
		}
		if(bean.getBankAccount() != null) {
			if(bean.getBankAccount().indexOf("%") >= 0)
				dao.setConditionBankAccount("like", bean.getBankAccount());
			else
				dao.setConditionBankAccount("=", bean.getBankAccount());
			count++;
		}
		if(bean.getEtydat() != null) {
			if(bean.getEtydat().indexOf("%") >= 0)
				dao.setConditionEtydat("like", bean.getEtydat());
			else
				dao.setConditionEtydat("=", bean.getEtydat());
			count++;
		}
		if(bean.getEtytim() != null) {
			if(bean.getEtytim().indexOf("%") >= 0)
				dao.setConditionEtytim("like", bean.getEtytim());
			else
				dao.setConditionEtytim("=", bean.getEtytim());
			count++;
		}
		if(bean.getTransDate() != null) {
			dao.setConditionTransDate(">=", bean.getTransDate());
			count++;
		}
		if(bean.getVltdat() != null) {
			dao.setConditionVltdat(">=", bean.getVltdat());
			count++;
		}
		if(bean.getTrscod() != null) {
			if(bean.getTrscod().indexOf("%") >= 0)
				dao.setConditionTrscod("like", bean.getTrscod());
			else
				dao.setConditionTrscod("=", bean.getTrscod());
			count++;
		}
		if(bean.getNaryur() != null) {
			if(bean.getNaryur().indexOf("%") >= 0)
				dao.setConditionNaryur("like", bean.getNaryur());
			else
				dao.setConditionNaryur("=", bean.getNaryur());
			count++;
		}
		if(bean.getTrsamtd() != null) {
			dao.setConditionTrsamtd("=", bean.getTrsamtd());
			count++;
		}
		if(bean.getTrsamtc() != null) {
			dao.setConditionTrsamtc("=", bean.getTrsamtc());
			count++;
		}
		if(bean.getAmtcdr() != null) {
			if(bean.getAmtcdr().indexOf("%") >= 0)
				dao.setConditionAmtcdr("like", bean.getAmtcdr());
			else
				dao.setConditionAmtcdr("=", bean.getAmtcdr());
			count++;
		}
		if(bean.getTrsblv() != null) {
			dao.setConditionTrsblv("=", bean.getTrsblv());
			count++;
		}
		if(bean.getRefnbr() != null) {
			if(bean.getRefnbr().indexOf("%") >= 0)
				dao.setConditionRefnbr("like", bean.getRefnbr());
			else
				dao.setConditionRefnbr("=", bean.getRefnbr());
			count++;
		}
		if(bean.getReqnbr() != null) {
			if(bean.getReqnbr().indexOf("%") >= 0)
				dao.setConditionReqnbr("like", bean.getReqnbr());
			else
				dao.setConditionReqnbr("=", bean.getReqnbr());
			count++;
		}
		if(bean.getBusnam() != null) {
			if(bean.getBusnam().indexOf("%") >= 0)
				dao.setConditionBusnam("like", bean.getBusnam());
			else
				dao.setConditionBusnam("=", bean.getBusnam());
			count++;
		}
		if(bean.getNusage() != null) {
			if(bean.getNusage().indexOf("%") >= 0)
				dao.setConditionNusage("like", bean.getNusage());
			else
				dao.setConditionNusage("=", bean.getNusage());
			count++;
		}
		if(bean.getYurref() != null) {
			if(bean.getYurref().indexOf("%") >= 0)
				dao.setConditionYurref("like", bean.getYurref());
			else
				dao.setConditionYurref("=", bean.getYurref());
			count++;
		}
		if(bean.getBusnar() != null) {
			if(bean.getBusnar().indexOf("%") >= 0)
				dao.setConditionBusnar("like", bean.getBusnar());
			else
				dao.setConditionBusnar("=", bean.getBusnar());
			count++;
		}
		if(bean.getOtrnar() != null) {
			if(bean.getOtrnar().indexOf("%") >= 0)
				dao.setConditionOtrnar("like", bean.getOtrnar());
			else
				dao.setConditionOtrnar("=", bean.getOtrnar());
			count++;
		}
		if(bean.getCRpybbk() != null) {
			if(bean.getCRpybbk().indexOf("%") >= 0)
				dao.setConditionCRpybbk("like", bean.getCRpybbk());
			else
				dao.setConditionCRpybbk("=", bean.getCRpybbk());
			count++;
		}
		if(bean.getRpynam() != null) {
			if(bean.getRpynam().indexOf("%") >= 0)
				dao.setConditionRpynam("like", bean.getRpynam());
			else
				dao.setConditionRpynam("=", bean.getRpynam());
			count++;
		}
		if(bean.getRpyacc() != null) {
			if(bean.getRpyacc().indexOf("%") >= 0)
				dao.setConditionRpyacc("like", bean.getRpyacc());
			else
				dao.setConditionRpyacc("=", bean.getRpyacc());
			count++;
		}
		if(bean.getRpybbn() != null) {
			if(bean.getRpybbn().indexOf("%") >= 0)
				dao.setConditionRpybbn("like", bean.getRpybbn());
			else
				dao.setConditionRpybbn("=", bean.getRpybbn());
			count++;
		}
		if(bean.getRpybnk() != null) {
			if(bean.getRpybnk().indexOf("%") >= 0)
				dao.setConditionRpybnk("like", bean.getRpybnk());
			else
				dao.setConditionRpybnk("=", bean.getRpybnk());
			count++;
		}
		if(bean.getRpyadr() != null) {
			if(bean.getRpyadr().indexOf("%") >= 0)
				dao.setConditionRpyadr("like", bean.getRpyadr());
			else
				dao.setConditionRpyadr("=", bean.getRpyadr());
			count++;
		}
		if(bean.getCGsbbbk() != null) {
			if(bean.getCGsbbbk().indexOf("%") >= 0)
				dao.setConditionCGsbbbk("like", bean.getCGsbbbk());
			else
				dao.setConditionCGsbbbk("=", bean.getCGsbbbk());
			count++;
		}
		if(bean.getGsbacc() != null) {
			if(bean.getGsbacc().indexOf("%") >= 0)
				dao.setConditionGsbacc("like", bean.getGsbacc());
			else
				dao.setConditionGsbacc("=", bean.getGsbacc());
			count++;
		}
		if(bean.getGsbnam() != null) {
			if(bean.getGsbnam().indexOf("%") >= 0)
				dao.setConditionGsbnam("like", bean.getGsbnam());
			else
				dao.setConditionGsbnam("=", bean.getGsbnam());
			count++;
		}
		if(bean.getInfflg() != null) {
			dao.setConditionInfflg("=", bean.getInfflg());
			count++;
		}
		if(bean.getAthflg() != null) {
			if(bean.getAthflg().indexOf("%") >= 0)
				dao.setConditionAthflg("like", bean.getAthflg());
			else
				dao.setConditionAthflg("=", bean.getAthflg());
			count++;
		}
		if(bean.getChknbr() != null) {
			if(bean.getChknbr().indexOf("%") >= 0)
				dao.setConditionChknbr("like", bean.getChknbr());
			else
				dao.setConditionChknbr("=", bean.getChknbr());
			count++;
		}
		if(bean.getRsvflg() != null) {
			if(bean.getRsvflg().indexOf("%") >= 0)
				dao.setConditionRsvflg("like", bean.getRsvflg());
			else
				dao.setConditionRsvflg("=", bean.getRsvflg());
			count++;
		}
		if(bean.getNarext() != null) {
			if(bean.getNarext().indexOf("%") >= 0)
				dao.setConditionNarext("like", bean.getNarext());
			else
				dao.setConditionNarext("=", bean.getNarext());
			count++;
		}
		if(bean.getTrsanl() != null) {
			if(bean.getTrsanl().indexOf("%") >= 0)
				dao.setConditionTrsanl("like", bean.getTrsanl());
			else
				dao.setConditionTrsanl("=", bean.getTrsanl());
			count++;
		}
		if(bean.getRefsub() != null) {
			if(bean.getRefsub().indexOf("%") >= 0)
				dao.setConditionRefsub("like", bean.getRefsub());
			else
				dao.setConditionRefsub("=", bean.getRefsub());
			count++;
		}
		if(bean.getFrmcod() != null) {
			if(bean.getFrmcod().indexOf("%") >= 0)
				dao.setConditionFrmcod("like", bean.getFrmcod());
			else
				dao.setConditionFrmcod("=", bean.getFrmcod());
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
		if(bean.getTransType() != null) {
			dao.setConditionTransType("=", bean.getTransType());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCmbcTransInfo bean = new BaseCmbcTransInfo();
		bean.setDataFromJSON(json);
		CmbcTransInfo dao = new CmbcTransInfo();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCmbcTransInfo> rlist = new BaseCollection<>();
		BaseCmbcTransInfo bean = new BaseCmbcTransInfo();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CmbcTransInfo dao = new CmbcTransInfo();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCmbcTransInfo> result = dao.conditionalLoad(addtion);
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
		BaseCmbcTransInfo bean = new BaseCmbcTransInfo();
		bean.setDataFromJSON(json);
		CmbcTransInfo dao = new CmbcTransInfo();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCmbcTransInfo bean = new BaseCmbcTransInfo();
		bean.setDataFromJSON(json);
		CmbcTransInfo dao = new CmbcTransInfo();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCmbcTransInfo bean = new BaseCmbcTransInfo();
		bean.setDataFromJSON(json);
		CmbcTransInfo dao = new CmbcTransInfo();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCmbcTransInfo bean = new BaseCmbcTransInfo();
		bean.setDataFromJSON(json);
		CmbcTransInfo dao = new CmbcTransInfo();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


