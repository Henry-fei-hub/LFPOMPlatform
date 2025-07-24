package pomplatform.common.business;

import java.io.StringReader;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.*;
import com.pomplatform.db.dao.*;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import message.common.CheckinWeixinUtils;
import pomplatform.clocks.business.ClockMsgProcess;
import pomplatform.common.utils.StaticUtils;
import pomplatform.domain.bean.BaseSemployeepdror;
import pomplatform.employeenew.business.DefaultLoginProcessor;
import pomplatform.payment.business.OnPaymentManageProcess;
import pomplatform.workflow.personnelbusiness.handler.ResignationApplyWorker;

/**
 * 公用的process
 * @author lxf
 */
public class OnCommonProcess implements GenericProcessor {
    //操作类型
    private static final String OPT_TYPE = "optType";
    
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(param,OPT_TYPE);
        switch (optType) {
		case "onLoadPlateDataList":
			return onLoadPlateDataList(param);
		case "onLoadSystemConfigInfo":
			return onLoadSystemConfigInfo();
			case "saveAndUpdate":
			return saveAndUpdate(param);
            case "deleteData":
			return deleteDate(param);
			case "bankManagerSave":
			return  bankManagerSave(param);
			case "bankManagerUpdate":
			return bankManagerUpdate(param);
			case "addAttachments":
				return addAttachments(param);
		default:
			return null;
		}
    }

	/**
	 *预付款申请 添加附件
	 * @param param
	 * @return
	 * @throws Exception
	 */
	private String addAttachments(Map<String, Object> param) throws Exception{
		int payMoneyManageId =  BaseHelpUtils.getIntValue(param, "payMoneyManageId");
		int attachmentId =  BaseHelpUtils.getIntValue(param, "attachmentId");
		String attachmentName =  BaseHelpUtils.getStringValue(param, "attachmentName");
		BaseCollection bc = new BaseCollection();
		PayMoneyManage manage = new PayMoneyManage();
		System.out.println("=========================开始");
		manage.setConditionPayMoneyManageId("=",payMoneyManageId);
		BasePayMoneyManage dao = manage.executeQueryOneRow();
		if(!BaseHelpUtils.isNullOrEmpty(dao)){
			System.out.println("=========================开始1");
			dao.setAttachmentId(attachmentId);
			dao.setAttachmentName(attachmentName);
			manage.setDataFromBase(dao);
			manage.update();
			return bc.toJSON(1,null);
		}
		return bc.toJSON(-1,null);
	}

	/**
	 * 修改银行
	 * @param param
	 * @return
	 */
	private String bankManagerUpdate(Map<String, Object> param) throws SQLException {
		int bankId = BaseHelpUtils.getIntValue(param.get("bankId"));
		Date createTime = BaseHelpUtils.getDateValue(param.get("createTime"));
		String bankName = BaseHelpUtils.getString(param.get("bankName"));
		int orderNum = BaseHelpUtils.getIntValue(param.get("orderNum"));
		if (!BaseHelpUtils.isNullOrEmpty(bankName)){
			Bank bankDao = new Bank();
			bankDao.setConditionBankName("=" , bankName);
			BaseBank baseBank = bankDao.executeQueryOneRow();
			//没有重复的才允许更新
			if (null == baseBank){
				bankDao.clear();
				BaseBank baseBank1 = new BaseBank();
				baseBank1.setBankId(bankId);
				baseBank1.setBankName(bankName);
				baseBank1.setOrderNum(orderNum);
				baseBank1.setCreateTime(createTime);
				bankDao.setDataFromBase(baseBank1);
				bankDao.update();
			}
		}
		return null;
	}

	/**
	 * 新增银行
	 * @param param
	 * @return
	 */
	private String bankManagerSave(Map<String, Object> param) throws SQLException {
		String bankName = BaseHelpUtils.getString(param.get("bankName"));
		System.out.println("===============================================" + bankName);
		Date createTime = new Date();
		if (!BaseHelpUtils.isNullOrEmpty(bankName)){
			Bank bankDao = new Bank();
			bankDao.setConditionBankName("=" , bankName);
			BaseBank baseBank = bankDao.executeQueryOneRow();
			System.out.println("===============================================" + baseBank);
			if (null == baseBank){
				SerialNumber serialNumber = new SerialNumber();
				serialNumber.setConditionSerialType("=" , 2);
				BaseSerialNumber baseSerialNumber = serialNumber.executeQueryOneRow();
				System.out.println("===============================================" + baseSerialNumber);
				if (null != baseSerialNumber){
					int maxNumber = BaseHelpUtils.getIntValue(baseSerialNumber.getSerialNumber());
					bankDao.clear();
					bankDao.setBankName(bankName);
					bankDao.setCreateTime(createTime);
					bankDao.setOrderNum(maxNumber);
					bankDao.save();
					serialNumber.clear();
					serialNumber.setConditionSerialType("=" , 2);
					serialNumber.setSerialNumber(maxNumber+1);
					serialNumber.conditionalUpdate();
				}
			}
		}
		return null;
	}

	/**
     * 删除下拉值的数据
     * @param param
     * @return
     */
    private String deleteDate(Map<String, Object> param) throws SQLException {
        int status = 1;
        BaseCollection<GenericBase> collection = new BaseCollection<>();
        int dicTypeId = BaseHelpUtils.getIntValue(param.get("dicTypeId"));
        String dicTypeName = BaseHelpUtils.getString(param.get("dicTypeName"));
        int dicTypeValueId = BaseHelpUtils.getIntValue(param.get("dicTypeValueId"));
        String dicTypeValue = BaseHelpUtils.getString(param.get("dicTypeValue"));
        String parentId = BaseHelpUtils.getString(param.get("parentId"));
        SystemDictionary systemDictionary = new SystemDictionary();
        systemDictionary.setConditionDicTypeId("=", dicTypeId);
        systemDictionary.setConditionDicTypeValue("=",dicTypeValue);
        systemDictionary.setConditionDicTypeValueId("=", dicTypeValueId);
        systemDictionary.setConditionDicTypeName("=", dicTypeName);
        systemDictionary.conditionalDelete();
        return collection.toJSON(status,"success");
    }

    /**
	 * 新增或者修改下拉值
	 * @param param
	 * @return
	 */
	private String saveAndUpdate(Map<String, Object> param) throws SQLException {
	    int status = 1;
        BaseCollection<GenericBase> collection = new BaseCollection<>();
        int dicTypeId = BaseHelpUtils.getIntValue(param.get("dicTypeId"));
		String dicTypeName = BaseHelpUtils.getString(param.get("dicTypeName"));
		int dicTypeValueId = BaseHelpUtils.getIntValue(param.get("dicTypeValueId"));
		String dicTypeValue = BaseHelpUtils.getString(param.get("dicTypeValue"));
        int flags = BaseHelpUtils.getIntValue(param.get("flags"));
        if (flags == 9999){//新增
            SystemDictionary systemDictionary = new SystemDictionary();
            systemDictionary.setConditionDicTypeId("=", dicTypeId);
            systemDictionary.setConditionDicTypeValueId("=", dicTypeValueId);
            boolean flag1 = systemDictionary.isExist();
            systemDictionary.clear();
            systemDictionary.setConditionDicTypeId("=", dicTypeId);
            systemDictionary.setConditionDicTypeValue("=",dicTypeValue);
            boolean flag2 = systemDictionary.isExist();
            if (flag2 || flag1){
                status = -1;
                return collection.toJSON(status,"数据已经存在");
            }
            systemDictionary.clear();
            systemDictionary.setDicTypeId(dicTypeId);
            systemDictionary.setDicTypeName(dicTypeName);
            systemDictionary.setDicTypeValueId(dicTypeValueId);
            systemDictionary.setDicTypeValue(dicTypeValue);
            systemDictionary.save();
            return collection.toJSON(status,"success");
        }else{//修改
            SystemDictionary systemDictionary = new SystemDictionary();
            systemDictionary.setConditionDicTypeId("=", dicTypeId);
            systemDictionary.setConditionDicTypeValueId("=",dicTypeValueId);
            systemDictionary.setDicTypeId(dicTypeId);
            systemDictionary.setDicTypeName(dicTypeName);
            systemDictionary.setDicTypeValueId(dicTypeValueId);
            systemDictionary.setDicTypeValue(dicTypeValue);
            systemDictionary.conditionalUpdate();
            return collection.toJSON(status,"success");
        }
	}

	
	public static void main(String[] args) throws SQLException {
		onLoadSystemConfigInfo();
	}
	/**
     * 加载系统配置信息数据集
     * @return
     * @throws SQLException 
     */
    public static String onLoadSystemConfigInfo() throws SQLException{
    	//加载配置表数据集
    	SystemConfig dao = new SystemConfig();
    	dao.setConditionConfigType(">",0);
    	List<BaseSystemConfig> resultList = dao.conditionalLoad(" order by config_type ");
    	if(!BaseHelpUtils.isNullOrEmpty(resultList) && resultList.size() > 0){
    		for(BaseSystemConfig e : resultList){
    			int configType = BaseHelpUtils.getIntValue(e.getConfigType());
    			StaticUtils.configMap.put(configType,e);
    			if(configType == StaticUtils.CONFIG_TYPE_6){
    				ClockMsgProcess.isSendDataByNo = BaseHelpUtils.getBoolean(e.getIsBefore());
    			}else if(configType == StaticUtils.CONFIG_TYPE_7){
    				DefaultLoginProcessor.SUPPER_KEY = BaseHelpUtils.getString(e.getPassword());
    			}else if(configType == StaticUtils.CONFIG_TYPE_9){
    				ResignationApplyWorker.SEND_MOBILE_MSG_START = BaseHelpUtils.getString(e.getUserId());
    				ResignationApplyWorker.SEND_MOBILE_MSG_END = BaseHelpUtils.getString(e.getImagePath());
    			}else if(configType == StaticUtils.CONFIG_TYPE_10){
    				ResignationApplyWorker.SEND_EMAIL_MSG_START =BaseHelpUtils.getString(e.getImagePath());
    				ResignationApplyWorker.SEND_EMAIL_MSG_END = BaseHelpUtils.getString(e.getUserId());
    			}else if(configType == StaticUtils.CONFIG_TYPE_11){//工资表计算累计项时间取值范围配置
    				int start = BaseHelpUtils.getIntValue(e.getUserId());
    				int end = BaseHelpUtils.getIntValue(e.getAccount());
    				if(start>0&&end>0) {
    					SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
    					Calendar ca = Calendar.getInstance();
    					if(start<=end) {
    						ca.setTime(new Date());
    						int year = ca.get(Calendar.YEAR);
    						OnPaymentManageProcess.START_DATE = year+"-"+start;
    						OnPaymentManageProcess.END_DATE = year+"-"+end;
    						OnPaymentManageProcess.IS_STRIDE =true;  
    					}else{
    						ca.setTime(new Date());
    						int year = ca.get(Calendar.YEAR);
    						int lastYear = year-1;
    						OnPaymentManageProcess.START_DATE = lastYear+"-"+start;
    						OnPaymentManageProcess.END_DATE = year+"-"+end;
    						OnPaymentManageProcess.IS_STRIDE =false;  
    					}
    				}
				} else if (configType == StaticUtils.CONFIG_TYPE_1) {
					//修改checkinWeixinUtils文件的配置信息
					CheckinWeixinUtils.AGENTID = BaseHelpUtils.getIntValue(e.getAgentId());
					CheckinWeixinUtils.CORP_SECRET = BaseHelpUtils.getString(e.getCorpSecret());
				}
    		}
    	}
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,"");
    }
    
    /**
     * 加载业务部门下拉数据集
     * @param param
     * @return
     * @throws SQLException
     */
    public String onLoadPlateDataList(Map<String, Object> param) throws SQLException{
    	String plateIds = BaseHelpUtils.getStringValue(param, "plateIds");
    	List<BaseSemployeepdror> bs = new ArrayList<>();
    	if(!BaseHelpUtils.isNullOrEmpty(plateIds)){
    		String[] plateIdArrStr = plateIds.split(",");
    		Integer[] plateIdArr = new Integer[plateIdArrStr.length];
    		int i = 0;
    		for(String plateId :plateIdArrStr){
    			plateIdArr[i] = BaseHelpUtils.getIntValue(plateId);
    			i++;
    		}
    		//检索下拉的数据集
    		PlateRecord dao = new PlateRecord();
    		dao.addCondition(BasePlateRecord.CS_PLATE_ID,"in", (Object[]) plateIdArr);
    		List<BasePlateRecord> resultList = dao.conditionalLoad();
    		if(!resultList.isEmpty() && resultList.size() > 0){
    			BaseSemployeepdror b;
    			for (BasePlateRecord e : resultList) {
                    b=new BaseSemployeepdror();
                    int plateId = BaseHelpUtils.getIntValue(e.getPlateId());
                    String plateName = BaseHelpUtils.getString(e.getPlateName());
                    b.setIdd(plateId);
                    b.setVal(plateName);
                    bs.add(b);
                }
    		}
    	}
        
        BaseCollection<BaseSemployeepdror> bc = new BaseCollection<>();
        bc.setCollections(bs);
        return bc.toJSON();
    }
    
    /**
     * 根据模块获取序列号
     * @param serialType
     * @param year
     * @param month
     * @param day
     * @return
     * @throws SQLException 
     */
    public Integer onGetSerialNumber(int serialType,int year,int month,int day) throws SQLException {
    	int serialNumber = 0;
    	SerialNumber dao = new SerialNumber();
    	if(serialType > 0) {
    		if(year > 0) {
    			dao.setConditionYear("=",year);
    		}
    		if(month > 0) {
    			dao.setConditionMonth("=",month);
    		}
    		if(day > 0) {
    			dao.setConditionDay("=",day);
    		}
    		BaseSerialNumber bean = dao.executeQueryOneRow();
    		if(!BaseHelpUtils.isNullOrEmpty(bean)) {
    			serialNumber = BaseHelpUtils.getIntValue(bean.getSerialNumber());
    		}
    	}
    	//取出数据库记录的序列值，并自增1返回
    	serialNumber++;
    	onSaveOrUpdateSerialNumber(serialType, year, month, day, serialNumber);
    	return serialNumber;
    }
    
    /**
     * 根据模块更新或者插入序列号
     * @param serialType
     * @param year
     * @param month
     * @param day
     * @return
     * @throws SQLException
     */
    public void onSaveOrUpdateSerialNumber(int serialType,int year,int month,int day,int serialNumber) throws SQLException {
    	SerialNumber dao = new SerialNumber();
    	if(serialType > 0) {
    		dao.setConditionSerialType("=",serialType);
    		if(year > 0) {
    			dao.setConditionYear("=",year);
    		}
    		if(month > 0) {
    			dao.setConditionMonth("=",month);
    		}
    		if(day > 0) {
    			dao.setConditionDay("=",day);
    		}
    		Date currentDate = new Date();
    		if(dao.isExist()) {//说明存在，则更新
    			dao.setSerialNumber(serialNumber);
    			dao.setOperateTime(currentDate);
    			dao.conditionalUpdate();
    		}else {//插入
    			dao.setSerialType(serialType);
    			dao.setYear(year);
    			dao.setMonth(month);
    			dao.setDay(day);
    			dao.setSerialNumber(serialNumber);
    			dao.setOperateTime(currentDate);
    			dao.save();
    		}
    	}
    }

}
