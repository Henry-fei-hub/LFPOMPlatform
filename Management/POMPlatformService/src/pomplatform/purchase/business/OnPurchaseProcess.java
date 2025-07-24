package pomplatform.purchase.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseSupplier;
import com.pomplatform.db.bean.BaseSupplierApprais;
import com.pomplatform.db.bean.BaseSupplierAppraiseDetail;
import com.pomplatform.db.bean.BaseSupplierContact;
import com.pomplatform.db.dao.Supplier;
import com.pomplatform.db.dao.SupplierApprais;
import com.pomplatform.db.dao.SupplierAppraiseDetail;
import com.pomplatform.db.dao.SupplierContact;
import com.pomplatform.db.dao.SupplierInfoChangeRecord;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.executor.SelectValueCache;

public class OnPurchaseProcess implements GenericProcessor {
    //操作类型
    private static final String OPT_TYPE = "optType";
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(params,OPT_TYPE);
        switch (optType) {
        //供应商相关信息保存
		case "onPurchaseInfoSave":
			return onPurchaseInfoSave(params);
		//供应商相关信息更新
		case "onPurchaseInfoUpdate":
			return onPurchaseInfoUpdate(params);
		//供应商评价保存
		case "onSaveSupplierAppraise":
			return onSaveSupplierAppraise(params);
		default:
			break;
		}
        return null;
    }
    
    /**
     * 供应商评价保存
     * @param params
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public String onSaveSupplierAppraise(Map<String, Object> params) throws Exception{
    	ThreadConnection.beginTransaction();
    	BaseSupplierApprais saBean = new BaseSupplierApprais();
    	saBean.setDataFromMap(params);
    	//获取供应商id
    	int supplierId = BaseHelpUtils.getIntValue(saBean.getSupplierId());
    	if(supplierId == 0) {
    		throw new SQLException("操作异常：获取供应商编码失败");
    	}
    	//获取主题
    	String title = BaseHelpUtils.getString(saBean.getTitle());
    	if(BaseHelpUtils.isNullOrEmpty(title)) {
    		throw new SQLException("操作异常：主题为空");
    	}
    	//获取累计得分
    	BigDecimal score = BaseHelpUtils.getBigDecimalValue(saBean.getScore());
    	if(score.compareTo(BigDecimal.ZERO) == 0) {
    		throw new SQLException("操作异常：获取累计积分失败");
    	}
    	//获取事由
    	String reason = BaseHelpUtils.getString(saBean.getReason());
    	if(BaseHelpUtils.isNullOrEmpty(reason)) {
    		throw new SQLException("操作异常：获取事由失败");
    	}
    	//获取评分类型数据集
    	List<BaseSupplierAppraiseDetail> list = GenericBase.__getList(params.get("appraiseScore"), BaseSupplierAppraiseDetail.newInstance());
    	if(BaseHelpUtils.isNullOrEmpty(list) || list.size() == 0) {
    		throw new SQLException("操作异常：获取评分类型数据集失败");
    	}
    	//获取创建人
    	int createEmployeeId = BaseHelpUtils.getIntValue(params, "createEmployeeId");
    	Date currentDate = new Date();
    	//插入供应商评价总表
    	SupplierApprais saDao = new SupplierApprais();
    	saBean.setCreateTime(currentDate);
    	saBean.setCreateEmployeeId(createEmployeeId);
    	saDao.setDataFromBase(saBean);
    	saDao.save();
    	//获取住建id
    	int supplierAppraiseId = saDao.getSupplierAppraiseId();
    	//插入供应商评价详情表
    	SupplierAppraiseDetail sadDao = new SupplierAppraiseDetail();
    	BaseSupplierAppraiseDetail sadBean = null;
    	for(BaseSupplierAppraiseDetail e : list) {
    		//获取评分级别
    		int scoreType = BaseHelpUtils.getIntValue(e.getScoreType());
    		if(scoreType == 0) {
    			//获取评分类型
    			int appraiseType = BaseHelpUtils.getIntValue(e.getAppraiseType());
    			//获取名称
    			String appraiseTypeName = SelectValueCache.getSelectValue("system_dictionary_190", appraiseType+"");
    			throw new SQLException(String.format("操作异常：评分类型(%1$s)没有设定评分级别", appraiseTypeName));
    		}
    		sadBean = e;
    		sadBean.setSupplierId(supplierId);
    		sadBean.setSupplierAppraiseId(supplierAppraiseId);
    		sadBean.setCreateEmployeeId(createEmployeeId);
    		sadBean.setCreateTime(currentDate);
    		sadDao.clear();
    		sadDao.setDataFromBase(sadBean);
    		sadDao.save();
    	}
    	
		ThreadConnection.commit();
    	BaseCollection bc = new BaseCollection<>();
    	return bc.toJSON(0, null);
	}
    
    /**
     * 供应商相关信息更新
     * @param params
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "rawtypes"})
	public String onPurchaseInfoUpdate(Map<String, Object> params) throws Exception{
    	ThreadConnection.beginTransaction();
    	Date currentDate = new Date();
    	//保存供应商信息
    	Supplier dao = new Supplier();
    	BaseSupplier bean = new BaseSupplier();
    	bean.setDataFromMap(params);
    	int supplierId = bean.getSupplierId();
    	dao.setSupplierId(supplierId);
    	if(dao.load()){
    		dao.setDataFromBase(bean);
    		//记录变更的内容记录
    		String changeContent = dao.getObjectChangedInformation();
    		if(!BaseHelpUtils.isNullOrEmpty(changeContent)) {
    			SupplierInfoChangeRecord changeDao = new SupplierInfoChangeRecord();
    			changeDao.setChangeEmployeeId(dao.getCreateEmployeeId());
    			changeDao.setChangeDate(currentDate);
    			changeDao.setChangeTime(currentDate);
    			changeDao.setChangeContent(changeContent);
    			changeDao.setRemark(changeContent);
    			changeDao.setSupplierId(supplierId);
    			changeDao.save();
    		}
    		dao.update();
    	}
    	//获取相关联系人员
		List<BaseSupplierContact> supplierContacts = GenericBase.__getList(params.get("supplierContacts"),BaseSupplierContact.newInstance());
		SupplierContact ccDao = new SupplierContact();
    	if(!BaseHelpUtils.isNullOrEmpty(supplierContacts) && supplierContacts.size() > 0){
    		//定义一个map来存放最新的职员Id
    		Map<Integer,Object> idMap = new HashMap<>();
    		for(BaseSupplierContact e : supplierContacts){
    			int supplierContactId = BaseHelpUtils.getIntValue(e.getSupplierContactId());
    			ccDao.clear();
    			if(supplierContactId > 0){//说明原有数据，则只做更新操作
    				ccDao.setSupplierContactId(supplierContactId);
    				if(ccDao.load()){
    					ccDao.setDataFromBase(e);
    					ccDao.update();
    				}
    			}else{//做插入操作
    				ccDao.setDataFromBase(e);
    				ccDao.setCreateEmployeeId(bean.getCreateEmployeeId());
    				ccDao.setCreateTime(currentDate);
    				ccDao.setSupplierId(supplierId);
    				ccDao.save();
    				supplierContactId = ccDao.getSupplierContactId();
    			}
    			idMap.put(supplierContactId, supplierContactId);
    		}
    		//删除新取消的人员信息
    		if(BaseHelpUtils.isNullOrEmpty(idMap) || idMap.size() == 0){
    			ccDao.clear();
        		ccDao.setConditionSupplierId("=",supplierId);
        		ccDao.conditionalDelete();
    		}else{
    			ccDao.clear();
    			ccDao.setConditionSupplierId("=",supplierId);
    			List<BaseSupplierContact> list = ccDao.conditionalLoad();
    			if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
    				for(BaseSupplierContact e : list){
    					int supplierContactId = BaseHelpUtils.getIntValue(e.getSupplierContactId());
    					if(!idMap.containsKey(supplierContactId)){
    						ccDao.clear();
    						ccDao.setSupplierContactId(supplierContactId);
    						if(ccDao.load()){
    							ccDao.delete();
    						}
    					}
    				}
    			}
    		}
    	}else{
    		ccDao.clear();
    		ccDao.setConditionSupplierId("=",supplierId);
    		ccDao.conditionalDelete();
    	}
		ThreadConnection.commit();
    	BaseCollection bc = new BaseCollection<>();
    	return bc.toJSON(0, null);
	}
    
    /**
     * 供应商相关信息保存
     * @param params
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "rawtypes"})
	public String onPurchaseInfoSave(Map<String, Object> params) throws Exception{
    	ThreadConnection.beginTransaction();
    	Date currentDate = new Date();
    	//保存供应商信息
    	Supplier dao = new Supplier();
    	BaseSupplier bean = new BaseSupplier();
    	bean.setDataFromMap(params);
    	bean.setCreateTime(currentDate);
    	dao.setDataFromBase(bean);
    	dao.save();
    	int supplierId = dao.getSupplierId();
    	//获取供应商相关联系人员
		List<BaseSupplierContact> supplierContacts = GenericBase.__getList(params.get("supplierContacts"),BaseSupplierContact.newInstance());
    	if(!BaseHelpUtils.isNullOrEmpty(supplierContacts) && supplierContacts.size() > 0){
    		SupplierContact ccDao = new SupplierContact();
    		for(BaseSupplierContact e : supplierContacts){
    			e.setSupplierId(supplierId);
    			e.setCreateEmployeeId(bean.getCreateEmployeeId());
    			e.setCreateTime(currentDate);
    		}
    		ccDao.save(supplierContacts);
    	}
		ThreadConnection.commit();
    	BaseCollection bc = new BaseCollection<>();
    	return bc.toJSON(0, null);
	}
    
}
