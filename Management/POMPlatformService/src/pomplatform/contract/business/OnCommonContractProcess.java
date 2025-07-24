package pomplatform.contract.business;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.file.db.dao.FileManage;
import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseContractAttachment;
import com.pomplatform.db.bean.BaseContractLinkAttachment;
import com.pomplatform.db.dao.ContractAttachment;
import com.pomplatform.db.dao.ContractLinkAttachment;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class OnCommonContractProcess implements GenericProcessor {

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(params, "optType");
		switch (optType) {
		case "onSaveContractAttachment":
			return onSaveContractAttachment(params);
		case "onBindContractAttachment":
			return onBindContractAttachment(params);
		default:
			return null;
		}
    }
    
    /**
     * 合同文件绑定合同
     * @param params
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked"})
	public String onBindContractAttachment(Map<String, Object> params) throws Exception{
    	//获取绑定人
    	int operateEmployeeId = BaseHelpUtils.getIntValue(params, "operateEmployeeId");
    	//获取文件Id
    	int fileId = BaseHelpUtils.getIntValue(params, "fileId");
    	if(fileId <= 0){
    		throw new SQLException("保存异常：获取文件ID失败");
    	}
    	int contractAttachmentId = BaseHelpUtils.getIntValue(params, "contractAttachmentId");
    	if(contractAttachmentId <= 0){
    		throw new SQLException("保存异常：获取文件主键ID失败");
    	}
    	ThreadConnection.beginTransaction();
    	List<BaseContract> contractList = GenericBase.__getList(params.get("contractDatas"),BaseContract.newInstance());
    	ContractLinkAttachment linkDao = new ContractLinkAttachment();
    	linkDao.setConditionFileId("=",fileId);
    	linkDao.setConditionContractAttachmentId("=",contractAttachmentId);
    	List<BaseContractLinkAttachment> oldList = linkDao.conditionalLoad();
    	if(BaseHelpUtils.isNullOrEmpty(contractList) || contractList.size() == 0){
    		if(linkDao.isExist()){
    			linkDao.conditionalDelete();
    		}
    	}else{
    		//获取备注
    		String remark = BaseHelpUtils.getStringValue(params, "remark");
    		Date currentDate = new Date();
    		Map<Integer,Integer> cMap = new HashMap<>();
    		for(BaseContract e : contractList){
    			//获取合同Id
    			int contractId = BaseHelpUtils.getIntValue(e.getContractId());
    			cMap.put(contractId, contractId);
    			//先判断该合同是否已绑定，如果未绑定，则插入数据
    			linkDao.clear();
    			linkDao.setConditionFileId("=",fileId);
    			linkDao.setConditionContractAttachmentId("=",contractAttachmentId);
    			linkDao.setConditionContractId("=",contractId);
    			if(!linkDao.isExist()){
    				linkDao.setContractAttachmentId(contractAttachmentId);
    				linkDao.setFileId(fileId);
    				linkDao.setContractId(contractId);
    				linkDao.setOperateEmployeeId(operateEmployeeId);
    				linkDao.setOperateTime(currentDate);
    				linkDao.setRemark(remark);
    				linkDao.save();
    			}
    		}
    		//遍历原数据库保存的数据，并遍历，如果数据库中存在，但返回的contractList不存在，在删除库中数据
    		if(!BaseHelpUtils.isNullOrEmpty(oldList) && oldList.size() > 0){
    			for(BaseContractLinkAttachment e : oldList){
    				//获取合同Id
    				int contractId = BaseHelpUtils.getIntValue(e.getContractId());
    				if(!cMap.containsKey(contractId)){
    					linkDao.clear();
    					linkDao.setConditionFileId("=",fileId);
    					linkDao.setConditionContractAttachmentId("=",contractAttachmentId);
    					linkDao.setConditionContractId("=",contractId);
    					linkDao.conditionalDelete();
    				}
    			}
    		}
    	}
    	ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,null);
    }
    
    /**
     * 合同文件上传保存
     * @return
     * @throws Exception 
     */
    public String onSaveContractAttachment(Map<String, Object> params) throws Exception{
    	//获取申请人
    	int uploadEmployeeId = BaseHelpUtils.getIntValue(params, "uploadEmployeeId");
    	//获取文件Id
    	int fileId = BaseHelpUtils.getIntValue(params, "fileId");
    	if(fileId <= 0){
    		throw new SQLException("保存异常：获取文件ID失败");
    	}
    	//获取合同文件名称
    	String attachmentName = BaseHelpUtils.getStringValue(params, "attachmentName");
    	if(BaseHelpUtils.isNullOrEmpty(attachmentName)){
    		throw new SQLException("保存异常：获取文件名称失败");
    	}
    	ThreadConnection.beginTransaction();
    	FileManage fileDao = new FileManage();
    	fileDao.setFileId(fileId);
    	if(fileDao.load()){
    		fileDao.setCitationTimes(fileDao.getCitationTimes()+1);
    		fileDao.update();
    	}else{
    		throw new SQLException("保存异常：加载文件失败");
    	}
    	ContractAttachment dao = new ContractAttachment();
    	BaseContractAttachment bean = new BaseContractAttachment();
    	bean.setDataFromMap(params);
    	//设置合同编码
    	Date currentDate = new Date();
    	int year = DateUtil.getYear(currentDate);
    	dao.setConditionYear("=",year);
    	int flag = 0;
    	List<BaseContractAttachment> list = dao.conditionalLoad("order by flag desc");
    	if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
    		BaseContractAttachment be = list.get(0);
    		flag = BaseHelpUtils.getIntValue(be.getFlag());
    	}
    	String flagStr = (flag+1)+"";
    	while(flagStr.length() < 4){
    		flagStr = "0"+flagStr;
    	}
    	bean.setAttachmentCode(String.format("FJ%1$s-%2$s",year,flagStr));
    	bean.setYear(year);
    	bean.setFlag(flag+1);
    	bean.setUploadTime(currentDate);
    	dao.clear();
    	dao.setDataFromBase(bean);
    	dao.save();
    	//获取合同Id，如果有合同Id，则需要和合同绑定
    	int contractId =BaseHelpUtils.getIntValue(params,"contractId");
    	if(contractId > 0){
    		int contractAttachmentId = dao.getContractAttachmentId();
    		ContractLinkAttachment linkDao = new ContractLinkAttachment();
    		linkDao.setContractAttachmentId(contractAttachmentId);
    		linkDao.setFileId(fileId);
    		linkDao.setContractId(contractId);
    		linkDao.setOperateEmployeeId(uploadEmployeeId);
    		linkDao.setOperateTime(currentDate);
    		linkDao.setRemark(bean.getRemark());
    		linkDao.save();
    	}
    	ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,null);
    }
    
    
}
