package pomplatform.ht.handler;

import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.math.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.helpers.HeaderFooterHelper;

import com.pomplatform.db.bean.BaseContactSplitConfig;
import com.pomplatform.db.bean.BaseDesignConsideration;
import com.pomplatform.db.bean.BaseOutDesignConsideration;
import com.pomplatform.db.bean.StaticMethod;
import com.pomplatform.db.dao.ContactSplitConfig;
import com.pomplatform.db.dao.DesignConsideration;
import com.pomplatform.db.dao.OutDesignConsideration;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
public class CustomContractClassifty implements GenericProcessor, GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CustomContractClassifty.class);
	
	/**
	 * 设置转成拆分价
	 */
	private static final String SET_SPLIT_PRICE = "setSplitPrice";
	/**
	 * 根据合同分类情况筛选出对应的比例
	 */
	private static final String GET_CONTRACT_CLASSIFTY_LIST = "getContractClassiftyList";
	
	
	private static final String ADD_CONTRACT_CLASSIFTY = "updateContractClassifty";
 
	@SuppressWarnings("unchecked")
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String optType = BaseHelpUtils.getStringValue(result, "opt_type");
		if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)) {
			switch (optType) {
			case GET_CONTRACT_CLASSIFTY_LIST:
				return getContractClassiftyList(result);
			case SET_SPLIT_PRICE:
				return setSplitPrice(result);
			case ADD_CONTRACT_CLASSIFTY:
				return updateContractClassifty(result,creteria);
			}
		}
		return null;
	}
	/**
	 * 添加自定义的拆分比例
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String updateContractClassifty(Map<String, Object> result,String creteria) throws Exception {
		ContactSplitConfig ccf=new ContactSplitConfig();
		BaseContactSplitConfig baseCcf=new BaseContactSplitConfig();
		baseCcf.setDataFromJSON(creteria);
		//效验百分比不能超过100
//		double count;
//		count=BaseHelpUtils.getDoubleValue(baseCcf.getProgramme())+
//				BaseHelpUtils.getDoubleValue(baseCcf.getDeepen())+
//				BaseHelpUtils.getDoubleValue(baseCcf.getElectromechanical())+
//				BaseHelpUtils.getDoubleValue(baseCcf.getLighting())+
//				BaseHelpUtils.getDoubleValue(baseCcf.getService());
//		
//		if(count!=100.00){
//			throw new Exception("自定义百分比必须为100%");
//		}
		 
		
		ccf.setPrimaryKeyFromBase(baseCcf);
		int res=-1;
		if(ccf.load()){
			ccf.setDataFromBase(baseCcf);
			res=ccf.update();
		}
		BaseCollection<BaseContactSplitConfig> bc = new BaseCollection<>();
		return bc.toJSON(res, "");
	}
	 
  /**
   * 设置转成拆分价
   * @param result
   * @return
 * @throws Exception 
   */
	 private String setSplitPrice(Map<String, Object> result) throws Exception {
		 
		int res=-1;
		String errorStr="";
		//合同分类情况id
		int contractSplitConfigId = BaseHelpUtils.getIntValue(result, "contractSplitConfigId");
		
		//是否无方案 true 说明无方案
		boolean isProgramme=BaseHelpUtils.getBoolean(result.get("programme"));
		//是否无深化 true 说明无深化
		boolean isDeepen=BaseHelpUtils.getBoolean(result.get("deepen"));
		
		//1 机电  2灯光      ——————> 2选1 选择了那种类型
		int electromechanicalAndLighting=BaseHelpUtils.getIntValue(result, "electromechanicalAndLighting");
		int outDesignConsiderationId=BaseHelpUtils.getIntValue(result,"outDesignConsiderationId");
		int employeeId=BaseHelpUtils.getIntValue(result,"employeeId");
		//拆分价的总金额
		double splitPrice=BaseHelpUtils.getDoubleValue(result.get("splitPrice"));
		List<BaseDesignConsideration> saveList = new ArrayList<>();
		ContactSplitConfig csc=new ContactSplitConfig();
		csc.setConditionContactSplitConfigId("=", contractSplitConfigId);
		BaseContactSplitConfig baseContractSpiltConfig=csc.executeQueryOneRow();
		
		ThreadConnection.beginTransaction();
		
		if(BaseHelpUtils.isNullOrEmpty(baseContractSpiltConfig)){
			res=-1;
			errorStr="没有选中合同分类情况";
		}else{
			if(outDesignConsiderationId==0){
				res=-1;
				errorStr="没有选中需要拆分的报价单项";
			}else{
				OutDesignConsideration outDao = new OutDesignConsideration();
				outDao.setConditionOutDesignConsiderationId("=", outDesignConsiderationId);
				BaseOutDesignConsideration baseOut=outDao.executeQueryOneRow();
				if(BaseHelpUtils.isNullOrEmpty(baseOut)){
					res=-1;
					errorStr="没有检索到拆分报价单项";
				}else{
					BaseDesignConsideration base=new BaseDesignConsideration();
					base.setInfoCode(baseOut.getInfoCode());// 信息编号
					base.setProjectCode(baseOut.getProjectCode());// 项目编号
					base.setBusinessType(baseOut.getBusinessType());// 业务类型
					base.setProjectType(baseOut.getProjectType());// 项目类型
					base.setMainDesignAreaName(baseOut.getMainDesignAreaName());// 区域
																				// 设计范围
					base.setDecorationStatus(baseOut.getDecorationStatus());// 精简装状态
																			// 0装饰
																			// 1简装
					base.setDesignArea(baseOut.getDesignArea());// 设计面积
					base.setDesignUnitPrice(baseOut.getDesignUnitPrice());// 设计单价
					base.setMoneySum(baseOut.getMoneySum());// 小计 设计面积总金额
					base.setJobMix(baseOut.getJobMix());// 现场配合
					base.setServiceArea(baseOut.getServiceArea());// 服务面积
					base.setOnSiteTime(baseOut.getOnSiteTime());// 驻场时间(月)
					base.setWithTheAmount(baseOut.getWithTheAmount());// 配合金额
					base.setOnSitePrice(baseOut.getOnSitePrice());// 驻场价格 (元/月)
					base.setOnSiteTotalMoney(baseOut.getOnSiteTotalMoney());// 驻场总金额
					base.setOutQuotationId(baseOut.getOutQuotationId());// 报价单id
					base.setInteriorPrice(baseOut.getInteriorPrice());
					base.setInteriorMoneySum(baseOut.getInteriorMoneySum());
					base.setRemark(baseOut.getRemark());
					base.setOptionType(baseOut.getOptionType());// 类型 1专项 2子项
					base.setEmployeeId(employeeId);// 操作人
					base.setSplitPrice(StaticMethod.formatComma4BigDecimal(splitPrice));//拆分价
					base.setOutDesignConsiderationId(BaseHelpUtils.getIntValue(outDesignConsiderationId));
					DesignConsideration desDao = new DesignConsideration();
					desDao.setDataFromBase(base);
					desDao.save();
					/**
					 * 根据合同分类情况拆分报价单
					 */
					int designConsiderationId=desDao.getDesignConsiderationId();//刚添加的拆分的报价单id
					if(contractSplitConfigId==1){
						if(isProgramme){
							int[] temp={2,4,17,13};//项目类别
							double[] tempProportion={
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getDeepen())/100+BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getProgramme())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getElectromechanical())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getLighting())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getService())/100
									};//项目类型占比 
							double tempMoneySum=0;
							int len=temp.length;
							for(int i=0;i<len;i++){
								BaseDesignConsideration b=new BaseDesignConsideration();
								b=base;
								
								b.setProjectType(temp[i]);// 项目类型
								b.setParentId(designConsiderationId);
								if((i+1)<len){
									//计算拆分价占比
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(splitPrice*tempProportion[i])));
									tempMoneySum+=BaseHelpUtils.getDoubleValue(b.getSplitPrice());
								}else{
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(splitPrice-tempMoneySum));
								}
								DesignConsideration de=new DesignConsideration();
								de.setDataFromBase(b);
								de.save();
							}
						}else if(isDeepen){
							int[] temp={1,4,17,13};//项目类别
							double[] tempProportion={
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getProgramme())/100+BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getDeepen())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getElectromechanical())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getLighting())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getService())/100
									};//项目类型占比 
							double tempMoneySum=0;
							int len=temp.length;
							for(int i=0;i<len;i++){
								BaseDesignConsideration b=new BaseDesignConsideration();
								b=base;
								
								b.setProjectType(temp[i]);// 项目类型
								b.setParentId(designConsiderationId);
								if((i+1)<len){
									//计算拆分价占比
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(splitPrice*tempProportion[i])));
									tempMoneySum+=BaseHelpUtils.getDoubleValue(b.getSplitPrice());
								}else{
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(splitPrice-tempMoneySum));
								}
								DesignConsideration de=new DesignConsideration();
								de.setDataFromBase(b);
								de.save();
							}
						}
						else{
							int[] temp={1,2,4,17,13};//项目类别
							double[] tempProportion={
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getProgramme())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getDeepen())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getElectromechanical())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getLighting())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getService())/100
									};//项目类型占比 
							double tempMoneySum=0;
							int len=temp.length;
							for(int i=0;i<len;i++){
								BaseDesignConsideration b=new BaseDesignConsideration();
								b=base;
								
								b.setProjectType(temp[i]);// 项目类型
								b.setParentId(designConsiderationId);
								if((i+1)<len){
									//计算拆分价占比
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(splitPrice*tempProportion[i])));
									tempMoneySum+=BaseHelpUtils.getDoubleValue(b.getSplitPrice());
								}else{
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(splitPrice-tempMoneySum));
								}
								DesignConsideration de=new DesignConsideration();
								de.setDataFromBase(b);
								de.save();
							}
						}
					}else if(contractSplitConfigId==2){
						if(isProgramme){
							int[] temp={2,4,17,13};//项目类别
							double[] tempProportion={
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getDeepen())/100+BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getProgramme())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getElectromechanical())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getLighting())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getService())/100
									};//项目类型占比 
							double tempMoneySum=0;
							int len=3;
							for(int i=0;i<len;i++){
								BaseDesignConsideration b=new BaseDesignConsideration();
								b=base;
								//判断项目类别
								if(i==0){
									b.setProjectType(temp[i]);
								}else if(i==2){
									b.setProjectType(temp[i+1]);
								}else{
									if(electromechanicalAndLighting==1){//机电普通配合
										b.setProjectType(temp[i]);
									}else{//灯光普通配合
										b.setProjectType(temp[i+1]);
									}
								}
								
								b.setParentId(designConsiderationId);
								//计算拆分价占比
								if(i==0){
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(splitPrice*tempProportion[i])));
									tempMoneySum+=BaseHelpUtils.getDoubleValue(b.getSplitPrice());
								}else if(i==1){
									if(electromechanicalAndLighting==1){//机电普通配合
										b.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(splitPrice*tempProportion[i])));
									}else{//灯光普通配合
										b.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(splitPrice*tempProportion[i+1])));
									}
									tempMoneySum+=BaseHelpUtils.getDoubleValue(b.getSplitPrice());
								}else{
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(splitPrice-tempMoneySum));
								}
								 
								DesignConsideration de=new DesignConsideration();
								de.setDataFromBase(b);
								de.save();
							}
						}else if(isDeepen){
							int[] temp={1,4,17,13};//项目类别
							double[] tempProportion={
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getProgramme())/100+BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getDeepen())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getElectromechanical())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getLighting())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getService())/100
									};//项目类型占比 
							double tempMoneySum=0;
							int len=3;
							for(int i=0;i<len;i++){
								BaseDesignConsideration b=new BaseDesignConsideration();
								b=base;
								//判断项目类别
								if(i==0){
									b.setProjectType(temp[i]);
								}else if(i==2){
									b.setProjectType(temp[i+1]);
								}else{
									if(electromechanicalAndLighting==1){//机电普通配合
										b.setProjectType(temp[i]);
									}else{//灯光普通配合
										b.setProjectType(temp[i+1]);
									}
								}
								
								b.setParentId(designConsiderationId);
								//计算拆分价占比
								if(i==0){
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(splitPrice*tempProportion[i])));
									tempMoneySum+=BaseHelpUtils.getDoubleValue(b.getSplitPrice());
								}else if(i==1){
									if(electromechanicalAndLighting==1){//机电普通配合
										b.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(splitPrice*tempProportion[i])));
									}else{//灯光普通配合
										b.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(splitPrice*tempProportion[i+1])));
									}
									tempMoneySum+=BaseHelpUtils.getDoubleValue(b.getSplitPrice());
								}else{
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(splitPrice-tempMoneySum));
								}
								 
								DesignConsideration de=new DesignConsideration();
								de.setDataFromBase(b);
								de.save();
							}
						}
						else{
							int[] temp={1,2,4,17,13};//项目类别
							double[] tempProportion={
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getProgramme())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getDeepen())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getElectromechanical())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getLighting())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getService())/100
									};//项目类型占比 
							double tempMoneySum=0;
							int len=4;
							for(int i=0;i<len;i++){
								BaseDesignConsideration b=new BaseDesignConsideration();
								b=base;
								//判断项目类别
								if(i==0||i==1){
									b.setProjectType(temp[i]);
								}else if(i==3){
									b.setProjectType(temp[4]);
								}else{
									if(electromechanicalAndLighting==1){//机电普通配合
										b.setProjectType(temp[2]);
									}else{//灯光普通配合
										b.setProjectType(temp[3]);
									}
								}
								
								b.setParentId(designConsiderationId);
								//计算拆分价占比
								if(i==0||i==1){
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(splitPrice*tempProportion[i])));
									tempMoneySum+=BaseHelpUtils.getDoubleValue(b.getSplitPrice());
								}else if(i==2){
									if(electromechanicalAndLighting==1){//机电普通配合
										b.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(splitPrice*tempProportion[2])));
									}else{//灯光普通配合
										b.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(splitPrice*tempProportion[3])));
									}
									tempMoneySum+=BaseHelpUtils.getDoubleValue(b.getSplitPrice());
								}else{
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(splitPrice-tempMoneySum));
								}
								 
								DesignConsideration de=new DesignConsideration();
								de.setDataFromBase(b);
								de.save();
							}
						}
					}else if(contractSplitConfigId==3){
						if(isProgramme){
							int[] temp={2,13};//项目类别
							double[] tempProportion={
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getDeepen())/100+BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getProgramme())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getService())/100
									};//项目类型占比 
							double tempMoneySum=0;
							int len=temp.length;
							for(int i=0;i<len;i++){
								BaseDesignConsideration b=new BaseDesignConsideration();
								b=base;
								
								b.setProjectType(temp[i]);// 项目类型
								b.setParentId(designConsiderationId);
								if((i+1)<len){
									//计算拆分价占比
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(splitPrice*tempProportion[i])));
									tempMoneySum+=BaseHelpUtils.getDoubleValue(b.getSplitPrice());
								}else{
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(splitPrice-tempMoneySum));
								}
								DesignConsideration de=new DesignConsideration();
								de.setDataFromBase(b);
								de.save();
							}
						}else if(isDeepen){
							int[] temp={1,13};//项目类别
							double[] tempProportion={
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getProgramme())/100+BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getDeepen())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getService())/100
									};//项目类型占比 
							double tempMoneySum=0;
							int len=temp.length;
							for(int i=0;i<len;i++){
								BaseDesignConsideration b=new BaseDesignConsideration();
								b=base;
								
								b.setProjectType(temp[i]);// 项目类型
								b.setParentId(designConsiderationId);
								if((i+1)<len){
									//计算拆分价占比
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(splitPrice*tempProportion[i])));
									tempMoneySum+=BaseHelpUtils.getDoubleValue(b.getSplitPrice());
								}else{
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(splitPrice-tempMoneySum));
								}
								DesignConsideration de=new DesignConsideration();
								de.setDataFromBase(b);
								de.save();
							}
						}
						else{
							int[] temp={1,2,13};//项目类别
							double[] tempProportion={
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getProgramme())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getDeepen())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getService())/100
									};//项目类型占比 
							double tempMoneySum=0;
							int len=temp.length;
							for(int i=0;i<len;i++){
								BaseDesignConsideration b=new BaseDesignConsideration();
								b=base;
								
								b.setProjectType(temp[i]);// 项目类型
								b.setParentId(designConsiderationId);
								if((i+1)<len){
									//计算拆分价占比
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(splitPrice*tempProportion[i])));
									tempMoneySum+=BaseHelpUtils.getDoubleValue(b.getSplitPrice());
								}else{
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(splitPrice-tempMoneySum));
								}
								DesignConsideration de=new DesignConsideration();
								de.setDataFromBase(b);
								de.save();
							}
						}
					}else if(contractSplitConfigId==4){
						if(isProgramme){
							int[] temp={2,4,17};//项目类别
							double[] tempProportion={
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getDeepen())/100+BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getProgramme())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getElectromechanical())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getLighting())/100
									};//项目类型占比 
							double tempMoneySum=0;
							int len=temp.length;
							for(int i=0;i<len;i++){
								BaseDesignConsideration b=new BaseDesignConsideration();
								b=base;
								
								b.setProjectType(temp[i]);// 项目类型
								b.setParentId(designConsiderationId);
								if((i+1)<len){
									//计算拆分价占比
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(splitPrice*tempProportion[i])));
									tempMoneySum+=BaseHelpUtils.getDoubleValue(b.getSplitPrice());
								}else{
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(splitPrice-tempMoneySum));
								}
								DesignConsideration de=new DesignConsideration();
								de.setDataFromBase(b);
								de.save();
							}
						}else if(isDeepen){
							int[] temp={1,4,17};//项目类别
							double[] tempProportion={
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getProgramme())/100+BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getDeepen())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getElectromechanical())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getLighting())/100
									};//项目类型占比 
							double tempMoneySum=0;
							int len=temp.length;
							for(int i=0;i<len;i++){
								BaseDesignConsideration b=new BaseDesignConsideration();
								b=base;
								
								b.setProjectType(temp[i]);// 项目类型
								b.setParentId(designConsiderationId);
								if((i+1)<len){
									//计算拆分价占比
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(splitPrice*tempProportion[i])));
									tempMoneySum+=BaseHelpUtils.getDoubleValue(b.getSplitPrice());
								}else{
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(splitPrice-tempMoneySum));
								}
								DesignConsideration de=new DesignConsideration();
								de.setDataFromBase(b);
								de.save();
							}
						}
						else{
							int[] temp={1,2,4,17};//项目类别
							double[] tempProportion={
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getProgramme())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getDeepen())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getElectromechanical())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getLighting())/100
									};//项目类型占比 
							double tempMoneySum=0;
							int len=temp.length;
							for(int i=0;i<len;i++){
								BaseDesignConsideration b=new BaseDesignConsideration();
								b=base;
								
								b.setProjectType(temp[i]);// 项目类型
								b.setParentId(designConsiderationId);
								if((i+1)<len){
									//计算拆分价占比
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(splitPrice*tempProportion[i])));
									tempMoneySum+=BaseHelpUtils.getDoubleValue(b.getSplitPrice());
								}else{
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(splitPrice-tempMoneySum));
								}
								DesignConsideration de=new DesignConsideration();
								de.setDataFromBase(b);
								de.save();
							}
						}
					}else if(contractSplitConfigId==5){
						if(isProgramme){
							int[] temp={2,4,17};//项目类别
							double[] tempProportion={
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getDeepen())/100+BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getProgramme())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getElectromechanical())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getLighting())/100
									};//项目类型占比 
							double tempMoneySum=0;
							int len=2;
							for(int i=0;i<len;i++){
								BaseDesignConsideration b=new BaseDesignConsideration();
								b=base;
								//判断项目类别
								if(i==0){
									b.setProjectType(temp[i]);
								}else{
									if(electromechanicalAndLighting==1){//机电普通配合
										b.setProjectType(temp[i]);
									}else{//灯光普通配合
										b.setProjectType(temp[i+1]);
									}
								}
								
								b.setParentId(designConsiderationId);
								//计算拆分价占比
								if(i==0){
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(splitPrice*tempProportion[i])));
									tempMoneySum+=BaseHelpUtils.getDoubleValue(b.getSplitPrice());
								}else{
									if(electromechanicalAndLighting==1){//机电普通配合
										b.setSplitPrice(StaticMethod.formatComma4BigDecimal(splitPrice-tempMoneySum));
									}else{//灯光普通配合
										b.setSplitPrice(StaticMethod.formatComma4BigDecimal(splitPrice-tempMoneySum));
									}
								}
								 
								DesignConsideration de=new DesignConsideration();
								de.setDataFromBase(b);
								de.save();
							}
						}else if(isDeepen){
							int[] temp={1,4,17};//项目类别
							double[] tempProportion={
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getProgramme())/100+BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getDeepen())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getElectromechanical())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getLighting())/100
									};//项目类型占比 
							double tempMoneySum=0;
							int len=2;
							for(int i=0;i<len;i++){
								BaseDesignConsideration b=new BaseDesignConsideration();
								b=base;
								//判断项目类别
								if(i==0){
									b.setProjectType(temp[i]);
								}else{
									if(electromechanicalAndLighting==1){//机电普通配合
										b.setProjectType(temp[i]);
									}else{//灯光普通配合
										b.setProjectType(temp[i+1]);
									}
								}
								
								b.setParentId(designConsiderationId);
								//计算拆分价占比
								if(i==0){
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(splitPrice*tempProportion[i])));
									tempMoneySum+=BaseHelpUtils.getDoubleValue(b.getSplitPrice());
								}else{
									if(electromechanicalAndLighting==1){//机电普通配合
										b.setSplitPrice(StaticMethod.formatComma4BigDecimal(splitPrice-tempMoneySum));
									}else{//灯光普通配合
										b.setSplitPrice(StaticMethod.formatComma4BigDecimal(splitPrice-tempMoneySum));
									}
								}
								 
								DesignConsideration de=new DesignConsideration();
								de.setDataFromBase(b);
								de.save();
							}
						}
						else{
							int[] temp={1,2,4,17};//项目类别
							double[] tempProportion={
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getProgramme())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getDeepen())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getElectromechanical())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getLighting())/100
									};//项目类型占比 
							double tempMoneySum=0;
							int len=3;
							for(int i=0;i<len;i++){
								BaseDesignConsideration b=new BaseDesignConsideration();
								b=base;
								//判断项目类别
								if(i==0||i==1){
									b.setProjectType(temp[i]);
								}else{
									if(electromechanicalAndLighting==1){//机电普通配合
										b.setProjectType(temp[2]);
									}else{//灯光普通配合
										b.setProjectType(temp[3]);
									}
								}
								
								b.setParentId(designConsiderationId);
								//计算拆分价占比
								if(i==0||i==1){
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(splitPrice*tempProportion[i])));
									tempMoneySum+=BaseHelpUtils.getDoubleValue(b.getSplitPrice());
								}else{
									if(electromechanicalAndLighting==1){//机电普通配合
										b.setSplitPrice(StaticMethod.formatComma4BigDecimal(splitPrice-tempMoneySum));
									}else{//灯光普通配合
										b.setSplitPrice(StaticMethod.formatComma4BigDecimal(splitPrice-tempMoneySum));
									}
								}
								 
								DesignConsideration de=new DesignConsideration();
								de.setDataFromBase(b);
								de.save();
							}
						}
					}else if(contractSplitConfigId==6){
						if(isProgramme){
							BaseDesignConsideration b=new BaseDesignConsideration();
							b=base;
							b.setProjectType(2);// 项目类型
							b.setParentId(designConsiderationId);
							b.setSplitPrice(StaticMethod.formatComma4BigDecimal(splitPrice));
							DesignConsideration de=new DesignConsideration();
							de.setDataFromBase(b);
							de.save();
						}else if(isDeepen){
							BaseDesignConsideration b=new BaseDesignConsideration();
							b=base;
							b.setProjectType(1);// 项目类型
							b.setParentId(designConsiderationId);
							b.setSplitPrice(StaticMethod.formatComma4BigDecimal(splitPrice));
							DesignConsideration de=new DesignConsideration();
							de.setDataFromBase(b);
							de.save();
						}
						else{
							int[] temp={1,2};//项目类别
							double[] tempProportion={
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getProgramme())/100,
									BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getDeepen())/100
									};//项目类型占比 
							double tempMoneySum=0;
							int len=temp.length;
							for(int i=0;i<len;i++){
								BaseDesignConsideration b=new BaseDesignConsideration();
								b=base;
								
								b.setProjectType(temp[i]);// 项目类型
								b.setParentId(designConsiderationId);
								if((i+1)<len){
									//计算拆分价占比
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(splitPrice*tempProportion[i])));
									tempMoneySum+=BaseHelpUtils.getDoubleValue(b.getSplitPrice());
								}else{
									b.setSplitPrice(StaticMethod.formatComma4BigDecimal(splitPrice-tempMoneySum));
								}
								DesignConsideration de=new DesignConsideration();
								de.setDataFromBase(b);
								de.save();
							}
						}
					}else if(contractSplitConfigId==7){
						double programme= BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getProgramme());
						double deepen=BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getDeepen());
						double electromechanical=BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getElectromechanical());
						double lighting=BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getLighting());
						double service=BaseHelpUtils.getDoubleValue(baseContractSpiltConfig.getService());
						int len=0;
						double count=0.0;
						if(programme>0){
							len+=1;
							count+=programme;
						}
						if(deepen>0){
							len+=1;
							count+=deepen;
						}
						if(electromechanical>0){
							len+=1;
							count+=electromechanical;
						}
						if(lighting>0){
							len+=1;
							count+=lighting;
						}
						if(service>0){
							len+=1;
							count+=service;
						}
						if(count!=100.00){
							throw new Exception("自定义百分比必须为100%");
						}
						//{1,2,4,17,13};//项目类别
						double tempMoneySum=0;
						if(len>0){
							for(int i=0;i<len;i++){
								if(programme>0){
									tempMoneySum=save(base,1, designConsiderationId, len, i, tempMoneySum, splitPrice, programme);
									programme=0;
								}else if(deepen>0){
									tempMoneySum=save(base,2, designConsiderationId, len, i, tempMoneySum, splitPrice, deepen);
									deepen=0;
								}else if(electromechanical>0){
									tempMoneySum=save(base,4, designConsiderationId, len, i, tempMoneySum, splitPrice, electromechanical);
									electromechanical=0;
								}else if(lighting>0){
									tempMoneySum=save(base,17, designConsiderationId, len, i, tempMoneySum, splitPrice, lighting);
									lighting=0;
								}else if(service>0){
									tempMoneySum=save(base, 13, designConsiderationId, len, i, tempMoneySum, splitPrice, service);
									service=0;
								}
							}
						}
					}else{
						throw new Exception("系统没有定义该情况的处理方案");
					}
					res=1;
				}
			}
		}
		ThreadConnection.commit();
		
		BaseCollection<BaseDesignConsideration> bc = new BaseCollection<>();
		bc.setCollections(saveList);
		return bc.toJSON(res, errorStr);
	 }
	 private static double save(BaseDesignConsideration base,int parojectType,int designConsiderationId,int len,int i,double tempMoneySum,double splitPrice,double tempProportion) throws SQLException{
		 	BaseDesignConsideration b=new BaseDesignConsideration();
			b=base;
			
			b.setProjectType(parojectType);// 项目类型
			b.setParentId(designConsiderationId);
			if((i+1)<len){
				//计算拆分价占比
				b.setSplitPrice(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(splitPrice*tempProportion/100)));
				tempMoneySum+=BaseHelpUtils.getDoubleValue(b.getSplitPrice());
			}else{
				b.setSplitPrice(StaticMethod.formatComma4BigDecimal(splitPrice-tempMoneySum));
			}
			DesignConsideration de=new DesignConsideration();
			de.setDataFromBase(b);
			de.save();
			return tempMoneySum;
	 }
	 
	 
	/**
	 * 根据合同分类情况筛选出对应的比例
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String getContractClassiftyList(Map<String, Object> result) throws SQLException {
		//合同分类情况id
		int contractSplitConfigId = BaseHelpUtils.getIntValue(result, "contractSplitConfigId");
		//1 机电  2灯光      ——————> 2选1 选择了那种类型
		//int electromechanicalAndLighting=BaseHelpUtils.getIntValue(result, "electromechanicalAndLighting");
		ContactSplitConfig csc=new ContactSplitConfig();
		if(contractSplitConfigId>0){
			csc.setConditionContactSplitConfigId("=", contractSplitConfigId);
		}
		List<BaseContactSplitConfig> resList=csc.conditionalLoad(" order by contact_split_config_id");
		BaseCollection<BaseContactSplitConfig> bc = new BaseCollection<>();
		bc.setCollections(resList);
		return bc.toJSON(1, "");
	}



	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
	}



	@Override
	public String getDownloadFileExtension() {
		// TODO Auto-generated method stub
		return null;
	}
	 
}
