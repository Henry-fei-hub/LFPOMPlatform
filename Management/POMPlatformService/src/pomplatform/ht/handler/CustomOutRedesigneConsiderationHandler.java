package pomplatform.ht.handler;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseDesignConsideration;
import com.pomplatform.db.bean.BaseOutDesignConsideration;
import com.pomplatform.db.bean.BaseOutRedesignConsideration;
import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.bean.StaticMethod;
import com.pomplatform.db.dao.DesignConsideration;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.OutDesignConsideration;
import com.pomplatform.db.dao.OutQuotation;
import com.pomplatform.db.dao.OutRedesignConsideration;
import com.pomplatform.db.dao.SystemDictionary;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.ht.bean.BaseMainProject;

public class CustomOutRedesigneConsiderationHandler implements GenericProcessor {

    private static final Logger __logger = Logger.getLogger(CustomOutRedesigneConsiderationHandler.class);
    /**
     * 根据报价单子项信息获取报价单子项信息(精细)
     */
    private static final String GET_OUT_CONSIDERATIONS_LIST = "getOutRedesignConsideration";
    
    /**
     * 统计业务类别的金额
     */
    private static final String GET_TJ_MONEY ="getCountMoney";
    /**
     * 报价单子项(精细)信息保存或更新
     */
    private static final String SAVE_OR_UPDATE_OUT_CONSIDERATIONS= "saveOrUpdateOutRedesignConsideration";
    
    
    /**
     * 将勾选的报价单转到拆分价表中去
     */
    private static final String ADD_CONSIDERATIONS_LIST = "addDesigneConsiderationList";
    /**
     * 删除主报价单的(初步)拆分价
     */
    private static final String DELETE_OUT_CONSIDERATIONS = "deleteOutRedDesignConsideration";
    /**
	 * 检查(初步)拆分价不能大于报价单的总价
	 */
	private static final String CHECK_NOT_SUM_MONEY = "checkSumMoney";
	/**
	 * 判断报价单能否删除
	 */
	private static final String CHECK_IS_OUT_QUOTATION = "checkIsOutQuotation";
	
    
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
        if(!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)){
        	switch (optType) {
    		case GET_TJ_MONEY:
    			return getCountMoney(result,0,0);
    		case GET_OUT_CONSIDERATIONS_LIST:
        		return getOutRedesignConsideration(result);
    		case SAVE_OR_UPDATE_OUT_CONSIDERATIONS:
    			return saveOrUpdateOutDesignConsideration(creteria);
    		case ADD_CONSIDERATIONS_LIST:
    			return addDesigneConsiderationList(result);
    		case DELETE_OUT_CONSIDERATIONS:
    			return deleteOutDesignConsideration(result);
    		case CHECK_NOT_SUM_MONEY:
				return CheckSumMoney(result);
    		case CHECK_IS_OUT_QUOTATION:
    			return checkIsOutQuotation(result);
    		}
        }
    	return null;
    }
	/**
	 * 判断报价单能否删除
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String checkIsOutQuotation(Map<String, Object> result) throws SQLException {
		int outQuotationId=BaseHelpUtils.getIntValue(result, "outQuotationId");
		int status=0;
		String msg="";
		BaseCollection<BaseOutDesignConsideration> bc = new BaseCollection<>();
		OutQuotation oDao=new OutQuotation();
		oDao.setOutQuotationId(outQuotationId);
		if(oDao.load()){
			if(oDao.getDisableType()==1){
				status=-1;
				msg="有报价单子项不能删除";
			}
			
		}
		return bc.toJSON(status, msg);
	}
	/**
	 * 检查(初步)报价单价子项的总金额大于报价单的总价
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String CheckSumMoney(Map<String, Object> result) throws SQLException {
		String infoCode,projectCode;
		infoCode=BaseHelpUtils.getStringValue(result, "infoCode");
		projectCode=BaseHelpUtils.getStringValue(result, "projectCode");
		int outQuotationId=BaseHelpUtils.getIntValue(result, "outQuotationId");
		int outRedesignConsiderationId=BaseHelpUtils.getIntValue(result, "outRedesignConsiderationId");
		//报价单总价
		double sumMoney__=BaseHelpUtils.getDoubleValue(result.get("sumMoney__"));
		//当前追加的金额
		double nowMoney=BaseHelpUtils.getDoubleValue(result.get("nowMoney"));
		//保存数据库中的拆分金额
		double checkNowMoney=CheckSumMoney(outQuotationId,outRedesignConsiderationId,infoCode, projectCode);
		
		BaseCollection<BaseOutRedesignConsideration> bc = new BaseCollection<>();
		System.out.println("========================");
		System.out.println("(初步)拆分价的总金额("+(nowMoney+checkNowMoney)+")大于报价单的总价="+(nowMoney+checkNowMoney));
		//报价单子项金额大于报价单的总金额
		if(StaticMethod.getDouble2Value((nowMoney+checkNowMoney))>StaticMethod.getDouble2Value(sumMoney__)){
			return bc.toJSON(-1, "(初步)拆分价的总金额("+StaticMethod.getDouble2Value((nowMoney+checkNowMoney))+")大于报价单的总价("+StaticMethod.getDouble2Value(sumMoney__)+")");
		}else{
			return bc.toJSON(1, "");
		}
	}
	/**
	 * (初步)报价单的子项总计
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private double CheckSumMoney(int outQuotationId,int outRedesignConsiderationId, String infoCode,String projectCode) throws SQLException {
		double tempSumMoney=0.0;
		OutRedesignConsideration desDao=new OutRedesignConsideration();
		desDao.setConditionOutQuotationId("=",outQuotationId);
		desDao.setConditionInfoCode("=", infoCode);
		desDao.setConditionProjectCode("=", projectCode);
		List<BaseOutRedesignConsideration> baseList=desDao.conditionalLoad();
		if(baseList.size()>0){
			for(BaseOutRedesignConsideration b:baseList){
				//当前的总价数据不能统计
				if(b.getOutRedesignConsiderationId()!=outRedesignConsiderationId){
					double tempMoneySum=0,tempWithTheAmount=0,tempOnSiteTotalMoney=0;
					if(!BaseHelpUtils.isNullOrEmpty(b.getMoneySum())){
						tempMoneySum=b.getMoneySum().doubleValue();
					}if(!BaseHelpUtils.isNullOrEmpty(b.getWithTheAmount())){
						tempWithTheAmount=b.getWithTheAmount().doubleValue();
					}if(!BaseHelpUtils.isNullOrEmpty(b.getOnSiteTotalMoney())){
						tempOnSiteTotalMoney=b.getOnSiteTotalMoney().doubleValue();
					}
					tempSumMoney+=(tempMoneySum+tempWithTheAmount+tempOnSiteTotalMoney);
				}
			}
		}
		return tempSumMoney;
	}
	/**
	 * 删除主报价单的(初步)拆分价
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String deleteOutDesignConsideration(Map<String, Object> result) throws SQLException{
		ThreadConnection.beginTransaction();
		int status=0;
		String msg="";
		BaseCollection<BaseOutRedesignConsideration> bc = new BaseCollection<>();
		String ids = BaseHelpUtils.getStringValue(result, "ids");
		int outQuotationId=BaseHelpUtils.getIntValue(result, "outQuotationId");
		String infoCode=BaseHelpUtils.getStringValue(result, "infoCode");
		if(!BaseHelpUtils.isNullOrEmpty(ids)){
			//解析出ids
			String[] idArray=ids.split(",");
			ids="";
			for(int i=0;i<idArray.length;i++){
				if(!BaseHelpUtils.isNullOrEmpty(idArray[i])){
					if(BaseHelpUtils.isNullOrEmpty(ids)){
						ids=idArray[i];
					}else{
						ids+=","+idArray[i];
					}
				}
			}
			
			OutRedesignConsideration dao = new OutRedesignConsideration();
			//数据被应用了，不能删除
			if(BaseHelpUtils.isNullOrEmpty(ids)){
				status=-1;
				msg="没有选中要删除数据";
			}else{
				dao.delete(" out_redesign_consideration_id in("+ids+") ");
				status++;
				//改变报价单是否可禁用的状态
				OutRedesignConsideration out=new OutRedesignConsideration();
				out.setConditionOutQuotationId("=", outQuotationId);
				List<BaseOutRedesignConsideration> l= out.conditionalLoad();
				isUpdateOutQuotationsStatus(outQuotationId, l.size());
				
	        	//删除了(初步)拆分价要将协同项目改为有报价单状态
	        	if(l.size()<=0){
	        		MainProject mp=new MainProject();
		        	mp.setConditionInfoCode("=", infoCode);
		        	com.pomplatform.db.bean.BaseMainProject baseMp=mp.executeQueryOneRow();
		        	baseMp.setHasOutQuotations(false);
		        	mp.setDataFromBase(baseMp);
		        	mp.conditionalUpdate();
	        	}
			}
		}
		ThreadConnection.commit();
    	return bc.toJSON(status, msg);
	}
	
	/**
	 * 将勾选的报价单转到拆分价表中去
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	
	private String addDesigneConsiderationList(Map<String, Object> result) throws SQLException{
		
		int status = 0;
		String ids = BaseHelpUtils.getStringValue(result, "ids");
		String infoCode=BaseHelpUtils.getStringValue(result, "infoCode");//信息编号
		String projectCode=BaseHelpUtils.getStringValue(result, "projectCode");//项目编号
		double countMoney__=BaseHelpUtils.getDoubleValue(result.get("moneySum"));//报价单的总价
		BaseCollection<BaseDesignConsideration> bc = new BaseCollection<>();
		if(!BaseHelpUtils.isNullOrEmpty(ids)){
			OutDesignConsideration outDao=new OutDesignConsideration();
			List<BaseOutDesignConsideration> outList=outDao.conditionalLoad(" out_design_consideration_id in("+ids+") ");
			List<BaseDesignConsideration> moveList=new ArrayList<>();
			if(outList.size()>0){
				
				//效验报价单的总金额是否提过了
				DesignConsideration d=new DesignConsideration();
				d.setConditionInfoCode("=", infoCode);
				d.setConditionProjectCode("=", projectCode);
				List<BaseDesignConsideration> dList=d.conditionalLoad();
				double tempSumMoney=0,nowMoney=0;
				if(dList.size()>0){
					for(BaseDesignConsideration b:dList){
						double tempMoneySum=0,tempWithTheAmount=0,tempOnSiteTotalMoney=0;
						if(!BaseHelpUtils.isNullOrEmpty(b.getMoneySum())){
							tempMoneySum=b.getMoneySum().doubleValue();
						}if(!BaseHelpUtils.isNullOrEmpty(b.getWithTheAmount())){
							tempWithTheAmount=b.getWithTheAmount().doubleValue();
						}if(!BaseHelpUtils.isNullOrEmpty(b.getOnSiteTotalMoney())){
							tempOnSiteTotalMoney=b.getOnSiteTotalMoney().doubleValue();
						}
						tempSumMoney+=(tempMoneySum+tempWithTheAmount+tempOnSiteTotalMoney);
					}
				}
				
				for(BaseOutDesignConsideration baseOut:outList){
					BaseDesignConsideration base=new BaseDesignConsideration();
					base.setInfoCode(baseOut.getInfoCode());//信息编号 
					base.setProjectCode(baseOut.getProjectCode());//项目编号
					base.setBusinessType(baseOut.getBusinessType());//业务类型
					base.setProjectType(baseOut.getProjectType());//项目类型
					base.setMainDesignAreaName(baseOut.getMainDesignAreaName());//区域 设计范围
					base.setDecorationStatus(baseOut.getDecorationStatus());//精简装状态   0精装    1简装
					base.setDesignArea(baseOut.getDesignArea());//设计面积
					base.setDesignUnitPrice(baseOut.getDesignUnitPrice());//设计单价
					base.setMoneySum(baseOut.getMoneySum());//小计 设计面积总金额
					base.setJobMix(baseOut.getJobMix());//现场配合
					base.setServiceArea(baseOut.getServiceArea());//服务面积
					base.setOnSiteTime(baseOut.getOnSiteTime());//驻场时间(月)
					base.setWithTheAmount(baseOut.getWithTheAmount());//配合金额
					base.setOnSitePrice(baseOut.getOnSitePrice());//驻场价格 (元/月)
					base.setOnSiteTotalMoney(baseOut.getOnSiteTotalMoney());//驻场总金额 (元)
					moveList.add(base);
					
					double tempMoneySum=0,tempWithTheAmount=0,tempOnSiteTotalMoney=0;
					if(!BaseHelpUtils.isNullOrEmpty(baseOut.getMoneySum())){
						tempMoneySum=baseOut.getMoneySum().doubleValue();
					}if(!BaseHelpUtils.isNullOrEmpty(baseOut.getWithTheAmount())){
						tempWithTheAmount=baseOut.getWithTheAmount().doubleValue();
					}if(!BaseHelpUtils.isNullOrEmpty(baseOut.getOnSiteTotalMoney())){
						tempOnSiteTotalMoney=baseOut.getOnSiteTotalMoney().doubleValue();
					}
					nowMoney+=(tempMoneySum+tempWithTheAmount+tempOnSiteTotalMoney);
				}
				//效验判断start
				System.out.println("========================");
				System.out.println("拆分价的总金额("+(nowMoney+tempSumMoney)+")大于报价单的总价="+countMoney__);
				//报价单子项金额大于报价单的总金额
				if((nowMoney+tempSumMoney)>countMoney__){
					return bc.toJSON(-1, "拆分价的总金额("+(nowMoney+tempSumMoney)+")大于报价单的总价("+countMoney__+")");
				}else{
					DesignConsideration desDao=new DesignConsideration();
					desDao.save(moveList);
					status++;
					return bc.toJSON(status, "");
				}
			}
		}
		return bc.toJSON(-1, "没有选中要移动的数据");
	}
	
	
    /**
     * 根据主报价单信息获取报价单子项信息
     * @param result
     * @return
     * @throws SQLException
     */
    private String getOutRedesignConsideration(Map<String, Object> result) throws SQLException{
    	String infoCode=BaseHelpUtils.getStringValue(result,"infoCode");
    	String projectCode=BaseHelpUtils.getStringValue(result,"projectCode");
    	int outQuotationId = BaseHelpUtils.getIntValue(result,"outQuotationId");
    	double moneySum=BaseHelpUtils.getDoubleValue(result.get("moneySum"));
    	OutRedesignConsideration outDao = new OutRedesignConsideration();
    	outDao.setConditionOutQuotationId("=", outQuotationId);
    	outDao.setConditionInfoCode("=", infoCode);
    	outDao.setConditionProjectCode("=", projectCode);
    	List<BaseOutRedesignConsideration> ds = outDao.conditionalLoad(" order by business_type,project_type,out_redesign_consideration_id asc ");
    	BaseCollection<BaseOutRedesignConsideration> bc = new BaseCollection<>();
    	bc.setCollections(ds);
    	return bc.toJSON(-1, getCountMoney(outQuotationId,moneySum));
    }
    
    //
    public String getCountMoney(int id,double moneySum) throws SQLException{
    	return getCountMoney(null,id,moneySum);
    }
    /**
     * 统计业务类别的金额
     * @param result
     * @return
     * @throws SQLException
     */
      
    private String getCountMoney(Map<String, Object> result,int id,double moneySum) throws SQLException{
    	StringBuilder resStr=new StringBuilder();
    	//报价单的id
    	int outQuotationId=0;
    	if(id>0){
    		outQuotationId=id;
    	}else{
    		outQuotationId= BaseHelpUtils.getIntValue(result,"outQuotationId");
    	}
    	Map<Integer,Double> resultMap=new HashMap<>();
    	//有多少个业务类型
    	Map<Integer,Integer> typeMap=new HashMap<>();
    	Map<Integer,BaseOutRedesignConsideration> tempResultMap=new HashMap<>();
    	if(outQuotationId>0){
    		OutRedesignConsideration outDao = new OutRedesignConsideration();
        	outDao.setConditionOutQuotationId("=", outQuotationId);
        	List<BaseOutRedesignConsideration> ds = outDao.conditionalLoad();
        	//计算每一行的金额总价
        	if(ds.size()>0){
        		for(BaseOutRedesignConsideration baseOutDes:ds){
            		//业务类型
            		int businessType=BaseHelpUtils.getIntValue(baseOutDes.getBusinessType());
            		//设计面积*设计单价的金额
            		double designMoney=BaseHelpUtils.getDoubleValue(baseOutDes.getMoneySum());
            		//配合金额
            		double withAmountMoney=BaseHelpUtils.getDoubleValue(baseOutDes.getWithTheAmount());
            		//驻场金额
            		double onSiteTotalMoney=BaseHelpUtils.getDoubleValue(baseOutDes.getOnSiteTotalMoney());
            		//统计金额
            		double tempSunMoney=designMoney+withAmountMoney+onSiteTotalMoney;
            		baseOutDes.setMoneySum(new java.math.BigDecimal(tempSunMoney));
            		tempResultMap.put(baseOutDes.getOutRedesignConsiderationId(), baseOutDes);
            		typeMap.put(baseOutDes.getBusinessType(), baseOutDes.getBusinessType());
            	}
        	}
        	
        	
        	
        	//各个业务类型总金额
        	if(typeMap.size()>0){
        		for (Entry<Integer, Integer> entry : typeMap.entrySet()) {
        			double tempMoney=0;
        			if(tempResultMap.size()>0){
        				for (Entry<Integer, BaseOutRedesignConsideration> entry1 : tempResultMap.entrySet()) {
        					BaseOutRedesignConsideration b=entry1.getValue();
        	             	  if(b.getBusinessType()==entry.getKey()){
        	             		 tempMoney+=BaseHelpUtils.getDoubleValue((b.getMoneySum()).stripTrailingZeros().toPlainString());
                     			 
        	             	  }
        				}
        			}
        			resultMap.put(entry.getKey(), tempMoney);
            	}
        	}
        	double tempSum=0;
        	//遍历resultMap
        	for (Map.Entry<Integer,Double> entry : resultMap.entrySet()) {
  			   String tempValue=getSysYWTypeList(entry.getKey());
  			   resStr.append(BaseHelpUtils.isNullOrEmpty(tempValue)?"0":tempValue);
  			   resStr.append(" : ");
  			   tempSum+=entry.getValue();
  			   resStr.append(StaticMethod.getDouble2Value(entry.getValue()));
  			   resStr.append("元    ");
        	}
        	resStr.append("合计:");
        	resStr.append(StaticMethod.getDouble2Value(tempSum));
        	resStr.append("元    ");
        	resStr.append("剩余:");
        	double sy=StaticMethod.getDouble2Value(moneySum)-StaticMethod.getDouble2Value(tempSum);
        	resStr.append(StaticMethod.getDouble2Value(sy));
        	resStr.append("元    ");
        	System.out.println(resStr);
    	}
    	return BaseHelpUtils.getString(resStr);
    }
    /**
     * 查出所有业务类型系统值
     * @param key
     * @return
     * @throws SQLException
     */
    public static String getSysYWTypeList(int key) throws SQLException{
    	//查出所有业务类型系统值
		SystemDictionary dao  = new SystemDictionary();
    	dao.setConditionDicTypeId("=", 31);
    	dao.setConditionDicTypeValueId("=", key);
    	StringBuilder sb = new StringBuilder("");
    	List<BaseSystemDictionary> dList = dao.conditionalLoad(" order by dic_type_value_id");
    	for(BaseSystemDictionary b:dList){
    		sb.append(b.getDicTypeValue());
    	}
    	return BaseHelpUtils.getString(sb);
    }
    
    /**
     * 更新报价单的能不能删除的状态
     * @param outQuotationId
     * @param num 报价单有没有报价单子项
     * @return
     * @throws SQLException 
     */
    private void isUpdateOutQuotationsStatus(int outQuotationId,int num) throws SQLException{
    	
    	System.out.println(num+"=isUpdateOutQuotationsStatus="+outQuotationId);
    	OutQuotation outDao=new OutQuotation();
    	outDao.setOutQuotationId(outQuotationId);
    	if(outDao.load()){
    		if(num>0){
    			if(outDao.getDisableType()!=1){
    				outDao.setDisableType(1);
        			outDao.update();
        		}
        	}else{
        		outDao.setDisableType(0);
        		outDao.update();
        	}
    	}
    }
    /**
     * 报价单子项信息保存或更新
     * @param json
     * @return
     * @throws Exception
     */
    private String saveOrUpdateOutDesignConsideration(String json) throws Exception{
    	BaseOutRedesignConsideration bean=new BaseOutRedesignConsideration();
        bean.setDataFromJSON(json);
        OutRedesignConsideration dao = new OutRedesignConsideration();
        dao.setDataFromBase(bean);
        int num = 0;
        ThreadConnection.beginTransaction();
        if (dao.isPrimaryKeyNull()) {
        	double tempSumMoney=0,tempDesignArea=0,tempDesignUnitPrice=0;
        	tempDesignArea=BaseHelpUtils.getDoubleValue(dao.getDesignArea());
        	tempDesignUnitPrice=BaseHelpUtils.getDoubleValue(dao.getDesignUnitPrice());
        	if(tempDesignArea>0&&tempDesignUnitPrice>0){
        		tempSumMoney=tempDesignArea*tempDesignUnitPrice;
            	dao.setMoneySum(new BigDecimal(tempSumMoney));
        	}
        	num = dao.save();
        	
        }else if (dao.load()) {
            dao.setDataFromBase(bean);
            double tempSumMoney=0,tempDesignArea=0,tempDesignUnitPrice=0;
            tempDesignArea=BaseHelpUtils.getDoubleValue(dao.getDesignArea());
        	tempDesignUnitPrice=BaseHelpUtils.getDoubleValue(dao.getDesignUnitPrice());
        	if(tempDesignArea>0&&tempDesignUnitPrice>0){
        		tempSumMoney=tempDesignArea*tempDesignUnitPrice;
            	dao.setMoneySum(new BigDecimal(tempSumMoney));
        	}
            num = dao.update();
        }
        ThreadConnection.commit();
        return bean.toOneLineJSON(num, null);
    }
    
}
