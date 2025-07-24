package pomplatform.customer.business;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseActivity;
import com.pomplatform.db.bean.BaseAnnoucement;
import com.pomplatform.db.bean.BaseCustomer;
import com.pomplatform.db.bean.BaseCustomerContact;
import com.pomplatform.db.dao.Activity;
import com.pomplatform.db.dao.Annoucement;
import com.pomplatform.db.dao.Customer;
import com.pomplatform.db.dao.CustomerContact;
import com.pomplatform.db.dao.MainProject;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import message.common.ERPWeixinUtils;
import pomplatform.annoucement.handler.OtherAnnoucementProcess;

public class OnCustomerProcess implements GenericProcessor {
    //操作类型
    private static final String OPT_TYPE = "optType";
    //客户相关信息保存
    private static final String ON_CUSTOMER_INFO_SAVE = "onCustomerInfoSave";
    //客户相关信息更新
    private static final String ON_CUSTOMER_INFO_UPDATE = "onCustomerInfoUpdate";
    //客户相关信息删除
    private static final String ON_CUSTOMER_INFO_DELETE = "onCustomerInfoDelete";
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(params,OPT_TYPE);
        if(ON_CUSTOMER_INFO_SAVE.equals(optType)){
        	return onCustomerInfoSave(params);
        }else if(ON_CUSTOMER_INFO_UPDATE.equals(optType)){
        	return onCustomerInfoUpdate(params);
        }else if(ON_CUSTOMER_INFO_DELETE.equals(optType)){
        	return onCustomerInfoDelete(params);
        }
        return null;
    }
    
    /**
     * 客户相关信息删除
     * @param params
     * @return
     * @throws Exception
     */
    @SuppressWarnings({"rawtypes"})
	public String onCustomerInfoDelete(Map<String, Object> params) throws Exception{
    	ThreadConnection.beginTransaction();
    	//保存客户信息
    	Customer dao = new Customer();
    	BaseCustomer bean = new BaseCustomer();
    	bean.setDataFromMap(params);
    	int customerId = bean.getCustomerId();
    	//先判断该客户是否已关联项目，如果已关联项目，则不可删除
    	MainProject mpDao = new MainProject();
    	mpDao.setConditionClientId("=",customerId);
    	if(mpDao.isExist()){//说明有关系项目，则不可删除
    		throw new SQLException("该客户已关联项目,不可删除");
    	}else{
    		//删除客户信息
    		dao.setCustomerId(customerId);
    		if(dao.load()){
    			dao.delete();
    		}
    		//删除客户联系人员信息
    		CustomerContact ccDao = new CustomerContact();
    		ccDao.setConditionCustomerId("=",customerId);
    		if(ccDao.isExist()){
    			ccDao.conditionalDelete();
    		}
    	}
		ThreadConnection.commit();
    	BaseCollection bc = new BaseCollection<>();
    	return bc.toJSON(0, null);
	}
    
    /**
     * 客户相关信息更新
     * @param params
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "rawtypes"})
	public String onCustomerInfoUpdate(Map<String, Object> params) throws Exception{
    	ThreadConnection.beginTransaction();
    	Date currentDate = new Date();
    	//保存客户信息
    	Customer dao = new Customer();
    	BaseCustomer bean = new BaseCustomer();
    	bean.setDataFromMap(params);
    	int customerId = bean.getCustomerId();
    	dao.setCustomerId(customerId);
    	if(dao.load()){
    		dao.setDataFromBase(bean);
    		dao.update();
    	}
    	//获取客户联系人员
		List<BaseCustomerContact> customerContacts = GenericBase.__getList(params.get("customerContacts"),BaseCustomerContact.newInstance());
		CustomerContact ccDao = new CustomerContact();
    	if(!BaseHelpUtils.isNullOrEmpty(customerContacts) && customerContacts.size() > 0){
    		//定义一个map来存放最新的职员Id
    		Map<Integer,Object> idMap = new HashMap<>();
    		for(BaseCustomerContact e : customerContacts){
    			int customerContactId = BaseHelpUtils.getIntValue(e.getCustomerContactId());
    			ccDao.clear();
    			if(customerContactId > 0){//说明原有数据，则只做更新操作
    				ccDao.setCustomerContactId(customerContactId);
    				if(ccDao.load()){
    					ccDao.setDataFromBase(e);
    					ccDao.update();
    				}
    			}else{//做插入操作
    				ccDao.setDataFromBase(e);
    				ccDao.setOperateEmployeeId(bean.getOperateEmployeeId());
    				ccDao.setOperateTime(currentDate);
    				ccDao.setCustomerId(customerId);
    				ccDao.save();
    				customerContactId = ccDao.getCustomerContactId();
    			}
    			idMap.put(customerContactId, customerContactId);
    		}
    		//删除新取消的人员信息
    		if(BaseHelpUtils.isNullOrEmpty(idMap) || idMap.size() == 0){
    			ccDao.clear();
        		ccDao.setConditionCustomerId("=",customerId);
        		ccDao.conditionalDelete();
    		}else{
    			ccDao.clear();
    			ccDao.setConditionCustomerId("=",customerId);
    			List<BaseCustomerContact> list = ccDao.conditionalLoad();
    			if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
    				for(BaseCustomerContact e : list){
    					int customerContactId = BaseHelpUtils.getIntValue(e.getCustomerContactId());
    					if(!idMap.containsKey(customerContactId)){
    						ccDao.clear();
    						ccDao.setCustomerContactId(customerContactId);
    						if(ccDao.load()){
    							ccDao.delete();
    						}
    					}
    				}
    			}
    		}
    	}else{
    		ccDao.clear();
    		ccDao.setConditionCustomerId("=",customerId);
    		ccDao.conditionalDelete();
    	}
		ThreadConnection.commit();
    	BaseCollection bc = new BaseCollection<>();
    	return bc.toJSON(0, null);
	}
    
    /**
     * 客户相关信息保存
     * @param params
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "rawtypes"})
	public String onCustomerInfoSave(Map<String, Object> params) throws Exception{
    	ThreadConnection.beginTransaction();
    	Date currentDate = new Date();
    	//保存客户信息
    	Customer dao = new Customer();
    	BaseCustomer bean = new BaseCustomer();
    	bean.setDataFromMap(params);
    	bean.setCreateTime(currentDate);
    	dao.setDataFromBase(bean);
    	dao.save();
    	int customerId = dao.getCustomerId();
    	//获取客户联系人员
		List<BaseCustomerContact> customerContacts = GenericBase.__getList(params.get("customerContacts"),BaseCustomerContact.newInstance());
    	if(!BaseHelpUtils.isNullOrEmpty(customerContacts) && customerContacts.size() > 0){
    		CustomerContact ccDao = new CustomerContact();
    		for(BaseCustomerContact e : customerContacts){
    			e.setOperateEmployeeId(bean.getOperateEmployeeId());
    			e.setOperateTime(currentDate);
    			e.setCustomerId(customerId);
    		}
    		ccDao.save(customerContacts);
    	}
    	//获取公告信息
    	Map<String,Object> annoucementInfoMap = (Map)params.get("annoucementInfo");
    	if(!BaseHelpUtils.isNullOrEmpty(annoucementInfoMap)){
    		//获取公告标题
    		String annoucementTitle = BaseHelpUtils.getStringValue(annoucementInfoMap, "annoucementTitle");
    		if(!BaseHelpUtils.isNullOrEmpty(annoucementTitle)){
    			Annoucement aDao = new Annoucement();
    			BaseAnnoucement aBean = new BaseAnnoucement();
    			aBean.setDataFromMap(annoucementInfoMap);
    			aBean.setCustomerId(customerId);
    			aBean.setAnnoucementTime(currentDate);
    			aBean.setOperateEmployeeId(bean.getOperateEmployeeId());
    			aBean.setOperateTime(currentDate);
    			aBean.setStatus(2);
    			aDao.setDataFromBase(aBean);
    			aDao.save();
    			//給相关公告人员发出公告
    			String employeeIds = aBean.getAnnoucementEmployeeIds();
    			if (!BaseHelpUtils.isNullOrEmpty(employeeIds)) {
    				OtherAnnoucementProcess process = new OtherAnnoucementProcess();
    				String companyWeixin=  process.getCompanyWeixin(employeeIds);
    				String annoucementContent = aBean.getAnnoucementContent();
    				if (!BaseHelpUtils.isNullOrEmpty(companyWeixin)&&!BaseHelpUtils.isNullOrEmpty(annoucementContent)) {
    					ERPWeixinUtils.sendTextMsgToUser(companyWeixin,annoucementContent);
    				}
    			}
    		}
    	}
    	//获取会议信息
    	Map<String,Object> activityInfoMap = (Map)params.get("activityInfo");
    	if(!BaseHelpUtils.isNullOrEmpty(activityInfoMap)){
    		//获取会议标题
    		String meetTitle = BaseHelpUtils.getStringValue(activityInfoMap, "meetTitle");
    		if(!BaseHelpUtils.isNullOrEmpty(meetTitle)){
    			Activity activityDao = new Activity();
    			BaseActivity activityBean = new BaseActivity();
    			activityBean.setDataFromMap(activityInfoMap);
    			activityBean.setCustomerId(customerId);
    			activityBean.setOperateEmployeeId(bean.getOperateEmployeeId());
    			activityBean.setOperateTime(currentDate);
    			activityDao.setDataFromBase(activityBean);
    			activityDao.save();
    		}
    	}
		ThreadConnection.commit();
    	BaseCollection bc = new BaseCollection<>();
    	return bc.toJSON(0, null);
	}
    
}
