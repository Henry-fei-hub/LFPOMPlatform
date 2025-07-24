package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCmbcPayDetail;
import com.pomplatform.db.dao.CmbcPayDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CmbcPayDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CmbcPayDetailHandler.class);

	public static BaseCmbcPayDetail getCmbcPayDetailById( 
		java.lang.Integer cmbc_pay_detail_id
	) throws Exception
	{
		CmbcPayDetail dao = new CmbcPayDetail();
		dao.setCmbcPayDetailId(cmbc_pay_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCmbcPayDetailExists( com.pomplatform.db.bean.BaseCmbcPayDetail bean, String additional ) throws Exception {

		CmbcPayDetail dao = new CmbcPayDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCmbcPayDetail( com.pomplatform.db.bean.BaseCmbcPayDetail bean, String additional ) throws Exception {

		CmbcPayDetail dao = new CmbcPayDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCmbcPayDetail> queryCmbcPayDetail( com.pomplatform.db.bean.BaseCmbcPayDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CmbcPayDetail dao = new CmbcPayDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCmbcPayDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCmbcPayDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCmbcPayDetail addToCmbcPayDetail ( BaseCmbcPayDetail cmbcpaydetail )  throws Exception {
		return addToCmbcPayDetail ( cmbcpaydetail , false);
	}

	public static BaseCmbcPayDetail addToCmbcPayDetail ( BaseCmbcPayDetail cmbcpaydetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CmbcPayDetail dao = new CmbcPayDetail();
		dao.setDataFromBase(cmbcpaydetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCmbcPayDetail addUpdateCmbcPayDetail ( BaseCmbcPayDetail cmbcpaydetail ) throws Exception {
		return addUpdateCmbcPayDetail ( cmbcpaydetail , false);
	}

	public static BaseCmbcPayDetail addUpdateCmbcPayDetail ( BaseCmbcPayDetail cmbcpaydetail, boolean singleTransaction  ) throws Exception {
		if(cmbcpaydetail.getCmbcPayDetailId() == null) return addToCmbcPayDetail(cmbcpaydetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CmbcPayDetail dao = new CmbcPayDetail();
		dao.setDataFromBase(cmbcpaydetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cmbcpaydetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCmbcPayDetail ( BaseCmbcPayDetail bean ) throws Exception {
		CmbcPayDetail dao = new CmbcPayDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCmbcPayDetail updateCmbcPayDetail ( BaseCmbcPayDetail cmbcpaydetail ) throws Exception {
		CmbcPayDetail dao = new CmbcPayDetail();
		dao.setCmbcPayDetailId( cmbcpaydetail.getCmbcPayDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cmbcpaydetail);
			result = dao.update();
		}
		return result == 1 ? cmbcpaydetail : null ;
	}

	public static BaseCmbcPayDetail updateCmbcPayDetailDirect( BaseCmbcPayDetail cmbcpaydetail ) throws Exception {
		CmbcPayDetail dao = new CmbcPayDetail();
		int result = 0;
		dao.setDataFromBase(cmbcpaydetail);
		result = dao.update();
		return result == 1 ? cmbcpaydetail : null ;
	}

	public static int setDeleteConditions(BaseCmbcPayDetail bean, CmbcPayDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCmbcPayDetailId() != null) {
			dao.setConditionCmbcPayDetailId("=", bean.getCmbcPayDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getType() != null) {
				dao.setConditionType("=", bean.getType());
				count++;
			}
			if(bean.getYurref() != null) {
				dao.setConditionYurref("=", bean.getYurref());
				count++;
			}
			if(bean.getDbtacc() != null) {
				dao.setConditionDbtacc("=", bean.getDbtacc());
				count++;
			}
			if(bean.getDbtbbk() != null) {
				dao.setConditionDbtbbk("=", bean.getDbtbbk());
				count++;
			}
			if(bean.getCcynbr() != null) {
				dao.setConditionCcynbr("=", bean.getCcynbr());
				count++;
			}
			if(bean.getStlchn() != null) {
				dao.setConditionStlchn("=", bean.getStlchn());
				count++;
			}
			if(bean.getNusage() != null) {
				dao.setConditionNusage("=", bean.getNusage());
				count++;
			}
			if(bean.getBusnar() != null) {
				dao.setConditionBusnar("=", bean.getBusnar());
				count++;
			}
			if(bean.getCrtacc() != null) {
				dao.setConditionCrtacc("=", bean.getCrtacc());
				count++;
			}
			if(bean.getCrtnam() != null) {
				dao.setConditionCrtnam("=", bean.getCrtnam());
				count++;
			}
			if(bean.getBrdnbr() != null) {
				dao.setConditionBrdnbr("=", bean.getBrdnbr());
				count++;
			}
			if(bean.getBnkflg() != null) {
				dao.setConditionBnkflg("=", bean.getBnkflg());
				count++;
			}
			if(bean.getCrtbnk() != null) {
				dao.setConditionCrtbnk("=", bean.getCrtbnk());
				count++;
			}
			if(bean.getCtycod() != null) {
				dao.setConditionCtycod("=", bean.getCtycod());
				count++;
			}
			if(bean.getCrtpvc() != null) {
				dao.setConditionCrtpvc("=", bean.getCrtpvc());
				count++;
			}
			if(bean.getCrtcty() != null) {
				dao.setConditionCrtcty("=", bean.getCrtcty());
				count++;
			}
			if(bean.getProvince() != null) {
				dao.setConditionProvince("=", bean.getProvince());
				count++;
			}
			if(bean.getCity() != null) {
				dao.setConditionCity("=", bean.getCity());
				count++;
			}
			if(bean.getTotalNum() != null) {
				dao.setConditionTotalNum("=", bean.getTotalNum());
				count++;
			}
			if(bean.getCrtbbk() != null) {
				dao.setConditionCrtbbk("=", bean.getCrtbbk());
				count++;
			}
			if(bean.getReimbursementPackageSummaryId() != null) {
				dao.setConditionReimbursementPackageSummaryId("=", bean.getReimbursementPackageSummaryId());
				count++;
			}
			if(bean.getReimbursementPackageId() != null) {
				dao.setConditionReimbursementPackageId("=", bean.getReimbursementPackageId());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getErrorMsg() != null) {
				dao.setConditionErrorMsg("=", bean.getErrorMsg());
				count++;
			}
			if(bean.getBuscod() != null) {
				dao.setConditionBuscod("=", bean.getBuscod());
				count++;
			}
			if(bean.getBusmod() != null) {
				dao.setConditionBusmod("=", bean.getBusmod());
				count++;
			}
			if(bean.getEaccty() != null) {
				dao.setConditionEaccty("=", bean.getEaccty());
				count++;
			}
			if(bean.getTrstyp() != null) {
				dao.setConditionTrstyp("=", bean.getTrstyp());
				count++;
			}
			if(bean.getTrstypName() != null) {
				dao.setConditionTrstypName("=", bean.getTrstypName());
				count++;
			}
			if(bean.getCmbcPaymentId() != null) {
				dao.setConditionCmbcPaymentId("=", bean.getCmbcPaymentId());
				count++;
			}
			if(bean.getObjectId() != null) {
				dao.setConditionObjectId("=", bean.getObjectId());
				count++;
			}
			if(bean.getObjectType() != null) {
				dao.setConditionObjectType("=", bean.getObjectType());
				count++;
			}
			if(bean.getWithdrawFlag() != null) {
				dao.setConditionWithdrawFlag("=", bean.getWithdrawFlag());
				count++;
			}
			if(bean.getWithdrawOriginId() != null) {
				dao.setConditionWithdrawOriginId("=", bean.getWithdrawOriginId());
				count++;
			}
			if(bean.getWithdrawStatus() != null) {
				dao.setConditionWithdrawStatus("=", bean.getWithdrawStatus());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCmbcPayDetail bean, CmbcPayDetail dao){
		int count = 0;
		if(bean.getCmbcPayDetailId() != null) {
			dao.setConditionCmbcPayDetailId("=", bean.getCmbcPayDetailId());
			count++;
		}
		if(bean.getType() != null) {
			dao.setConditionType("=", bean.getType());
			count++;
		}
		if(bean.getYurref() != null) {
			if(bean.getYurref().indexOf("%") >= 0)
				dao.setConditionYurref("like", bean.getYurref());
			else
				dao.setConditionYurref("=", bean.getYurref());
			count++;
		}
		if(bean.getEptdat() != null) {
			dao.setConditionEptdat(">=", bean.getEptdat());
			count++;
		}
		if(bean.getDbtacc() != null) {
			if(bean.getDbtacc().indexOf("%") >= 0)
				dao.setConditionDbtacc("like", bean.getDbtacc());
			else
				dao.setConditionDbtacc("=", bean.getDbtacc());
			count++;
		}
		if(bean.getDbtbbk() != null) {
			if(bean.getDbtbbk().indexOf("%") >= 0)
				dao.setConditionDbtbbk("like", bean.getDbtbbk());
			else
				dao.setConditionDbtbbk("=", bean.getDbtbbk());
			count++;
		}
		if(bean.getTrsamt() != null) {
			dao.setConditionTrsamt("=", bean.getTrsamt());
			count++;
		}
		if(bean.getCcynbr() != null) {
			if(bean.getCcynbr().indexOf("%") >= 0)
				dao.setConditionCcynbr("like", bean.getCcynbr());
			else
				dao.setConditionCcynbr("=", bean.getCcynbr());
			count++;
		}
		if(bean.getStlchn() != null) {
			if(bean.getStlchn().indexOf("%") >= 0)
				dao.setConditionStlchn("like", bean.getStlchn());
			else
				dao.setConditionStlchn("=", bean.getStlchn());
			count++;
		}
		if(bean.getNusage() != null) {
			if(bean.getNusage().indexOf("%") >= 0)
				dao.setConditionNusage("like", bean.getNusage());
			else
				dao.setConditionNusage("=", bean.getNusage());
			count++;
		}
		if(bean.getBusnar() != null) {
			if(bean.getBusnar().indexOf("%") >= 0)
				dao.setConditionBusnar("like", bean.getBusnar());
			else
				dao.setConditionBusnar("=", bean.getBusnar());
			count++;
		}
		if(bean.getCrtacc() != null) {
			if(bean.getCrtacc().indexOf("%") >= 0)
				dao.setConditionCrtacc("like", bean.getCrtacc());
			else
				dao.setConditionCrtacc("=", bean.getCrtacc());
			count++;
		}
		if(bean.getCrtnam() != null) {
			if(bean.getCrtnam().indexOf("%") >= 0)
				dao.setConditionCrtnam("like", bean.getCrtnam());
			else
				dao.setConditionCrtnam("=", bean.getCrtnam());
			count++;
		}
		if(bean.getBrdnbr() != null) {
			if(bean.getBrdnbr().indexOf("%") >= 0)
				dao.setConditionBrdnbr("like", bean.getBrdnbr());
			else
				dao.setConditionBrdnbr("=", bean.getBrdnbr());
			count++;
		}
		if(bean.getBnkflg() != null) {
			if(bean.getBnkflg().indexOf("%") >= 0)
				dao.setConditionBnkflg("like", bean.getBnkflg());
			else
				dao.setConditionBnkflg("=", bean.getBnkflg());
			count++;
		}
		if(bean.getCrtbnk() != null) {
			if(bean.getCrtbnk().indexOf("%") >= 0)
				dao.setConditionCrtbnk("like", bean.getCrtbnk());
			else
				dao.setConditionCrtbnk("=", bean.getCrtbnk());
			count++;
		}
		if(bean.getCtycod() != null) {
			if(bean.getCtycod().indexOf("%") >= 0)
				dao.setConditionCtycod("like", bean.getCtycod());
			else
				dao.setConditionCtycod("=", bean.getCtycod());
			count++;
		}
		if(bean.getCrtpvc() != null) {
			if(bean.getCrtpvc().indexOf("%") >= 0)
				dao.setConditionCrtpvc("like", bean.getCrtpvc());
			else
				dao.setConditionCrtpvc("=", bean.getCrtpvc());
			count++;
		}
		if(bean.getCrtcty() != null) {
			if(bean.getCrtcty().indexOf("%") >= 0)
				dao.setConditionCrtcty("like", bean.getCrtcty());
			else
				dao.setConditionCrtcty("=", bean.getCrtcty());
			count++;
		}
		if(bean.getProvince() != null) {
			dao.setConditionProvince("=", bean.getProvince());
			count++;
		}
		if(bean.getCity() != null) {
			dao.setConditionCity("=", bean.getCity());
			count++;
		}
		if(bean.getTotalAmount() != null) {
			dao.setConditionTotalAmount("=", bean.getTotalAmount());
			count++;
		}
		if(bean.getTotalNum() != null) {
			dao.setConditionTotalNum("=", bean.getTotalNum());
			count++;
		}
		if(bean.getCrtbbk() != null) {
			if(bean.getCrtbbk().indexOf("%") >= 0)
				dao.setConditionCrtbbk("like", bean.getCrtbbk());
			else
				dao.setConditionCrtbbk("=", bean.getCrtbbk());
			count++;
		}
		if(bean.getReimbursementPackageSummaryId() != null) {
			dao.setConditionReimbursementPackageSummaryId("=", bean.getReimbursementPackageSummaryId());
			count++;
		}
		if(bean.getReimbursementPackageId() != null) {
			dao.setConditionReimbursementPackageId("=", bean.getReimbursementPackageId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getErrorMsg() != null) {
			if(bean.getErrorMsg().indexOf("%") >= 0)
				dao.setConditionErrorMsg("like", bean.getErrorMsg());
			else
				dao.setConditionErrorMsg("=", bean.getErrorMsg());
			count++;
		}
		if(bean.getBuscod() != null) {
			if(bean.getBuscod().indexOf("%") >= 0)
				dao.setConditionBuscod("like", bean.getBuscod());
			else
				dao.setConditionBuscod("=", bean.getBuscod());
			count++;
		}
		if(bean.getBusmod() != null) {
			if(bean.getBusmod().indexOf("%") >= 0)
				dao.setConditionBusmod("like", bean.getBusmod());
			else
				dao.setConditionBusmod("=", bean.getBusmod());
			count++;
		}
		if(bean.getEaccty() != null) {
			if(bean.getEaccty().indexOf("%") >= 0)
				dao.setConditionEaccty("like", bean.getEaccty());
			else
				dao.setConditionEaccty("=", bean.getEaccty());
			count++;
		}
		if(bean.getTrstyp() != null) {
			if(bean.getTrstyp().indexOf("%") >= 0)
				dao.setConditionTrstyp("like", bean.getTrstyp());
			else
				dao.setConditionTrstyp("=", bean.getTrstyp());
			count++;
		}
		if(bean.getTrstypName() != null) {
			if(bean.getTrstypName().indexOf("%") >= 0)
				dao.setConditionTrstypName("like", bean.getTrstypName());
			else
				dao.setConditionTrstypName("=", bean.getTrstypName());
			count++;
		}
		if(bean.getCmbcPaymentId() != null) {
			dao.setConditionCmbcPaymentId("=", bean.getCmbcPaymentId());
			count++;
		}
		if(bean.getObjectId() != null) {
			dao.setConditionObjectId("=", bean.getObjectId());
			count++;
		}
		if(bean.getObjectType() != null) {
			dao.setConditionObjectType("=", bean.getObjectType());
			count++;
		}
		if(bean.getOprdat() != null) {
			dao.setConditionOprdat(">=", bean.getOprdat());
			count++;
		}
		if(bean.getWithdrawFlag() != null) {
			dao.setConditionWithdrawFlag("=", bean.getWithdrawFlag());
			count++;
		}
		if(bean.getWithdrawOriginId() != null) {
			dao.setConditionWithdrawOriginId("=", bean.getWithdrawOriginId());
			count++;
		}
		if(bean.getWithdrawStatus() != null) {
			dao.setConditionWithdrawStatus("=", bean.getWithdrawStatus());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCmbcPayDetail bean = new BaseCmbcPayDetail();
		bean.setDataFromJSON(json);
		CmbcPayDetail dao = new CmbcPayDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCmbcPayDetail> rlist = new BaseCollection<>();
		BaseCmbcPayDetail bean = new BaseCmbcPayDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CmbcPayDetail dao = new CmbcPayDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCmbcPayDetail> result = dao.conditionalLoad(addtion);
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
		BaseCmbcPayDetail bean = new BaseCmbcPayDetail();
		bean.setDataFromJSON(json);
		CmbcPayDetail dao = new CmbcPayDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCmbcPayDetail bean = new BaseCmbcPayDetail();
		bean.setDataFromJSON(json);
		CmbcPayDetail dao = new CmbcPayDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCmbcPayDetail bean = new BaseCmbcPayDetail();
		bean.setDataFromJSON(json);
		CmbcPayDetail dao = new CmbcPayDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCmbcPayDetail bean = new BaseCmbcPayDetail();
		bean.setDataFromJSON(json);
		CmbcPayDetail dao = new CmbcPayDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


