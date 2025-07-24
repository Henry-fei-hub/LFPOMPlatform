package pomplatform.plateIntegralSendRecord.business;

import java.io.StringReader;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BasePlateIntegralSend;
import com.pomplatform.db.dao.PlateAccountRecord;
import com.pomplatform.db.dao.PlateIntegralSend;
import com.pomplatform.db.handler.PlateIntegralSendHandler;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.account.business.AccountManageProcess;

public class PlateIntegralSendProcessor implements GenericProcessor {

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        String optType = BaseHelpUtils.getString(param.get("optType"));
        switch(optType){
        case "saveOrUpdate":
        	return saveOrUpdate(creteria);
        case "delete":
        	return delete(creteria);
    	default :
    		return null;
        }
        
    }
    
    public String saveOrUpdate(String creteria) throws Exception{
    	ThreadConnection.beginTransaction();
        BasePlateIntegralSend bean = new BasePlateIntegralSend();
		bean.setDataFromJSON(creteria);
		PlateIntegralSend dao = new PlateIntegralSend();
		dao.setPrimaryKeyFromBase(bean);
		int num = 0;
		PlateAccountRecord parDao = new PlateAccountRecord();
		//先保存或者修改公司补贴数据
		if(dao.isPrimaryKeyNull()) {
			dao.setDataFromBase(bean); 
			num = dao.save(); 
			bean = dao.generateBase(); 
		}else if(dao.load()) {
			dao.setDataFromBase(bean);
			num = dao.update(); 
			bean = dao.generateBase(); 
		}
		//然后根据业务ID和业务类型查找部门积分记录表，看是否有记录，有则修改，无则新增
		parDao.setConditionBusinessTypeId("=", AccountManageProcess.PLATE_BT_COMPANY_SUBSIDY);
		parDao.setConditionBusinessId("=", bean.getPlateIntegralSendId());
		if(parDao.countRows()>0){
			parDao.setIntegral(bean.getSendIntegral());
			parDao.setPlateId(bean.getPlateId());
			parDao.setRecordDate(bean.getSendDate());
			parDao.setRemark(bean.getRemark());
			parDao.conditionalUpdate();
		}else{
			parDao.setPlateId(bean.getPlateId());
			parDao.setBusinessId(bean.getPlateIntegralSendId());
			parDao.setBusinessTypeId(AccountManageProcess.PLATE_BT_COMPANY_SUBSIDY);
			parDao.setIntegral(bean.getSendIntegral());
			parDao.setRecordDate(bean.getSendDate());
			parDao.setOperateEmployeeId(bean.getEmployeeId());
			parDao.setOperateTime(new Date());
			parDao.setRemark(bean.getRemark());
			parDao.save();
		}
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
    }
    
    public String delete(String creteria) throws Exception{
    	ThreadConnection.beginTransaction();
    	BasePlateIntegralSend bean = new BasePlateIntegralSend();
		bean.setDataFromJSON(creteria);
		PlateIntegralSend dao = new PlateIntegralSend();
		PlateIntegralSendHandler.setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		if(num == 1){
			PlateAccountRecord parDao = new PlateAccountRecord();
			parDao.setConditionBusinessTypeId("=", AccountManageProcess.PLATE_BT_COMPANY_SUBSIDY);
			parDao.setConditionBusinessId("=", bean.getPlateIntegralSendId());
			parDao.conditionalDelete();
		}
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
    }
}
