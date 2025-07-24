package pomplatform.OnRevenue.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseBusinessStateRecord;
import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseProjectAttachment;
import com.pomplatform.db.bean.BaseRevenueYearRecord;
import com.pomplatform.db.dao.BusinessStateRecord;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.ProjectAttachment;
import com.pomplatform.db.dao.RevenueRecord;
import com.pomplatform.db.dao.RevenueYearRecord;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.OnRevenue.bean.BaseOnBusinessStateOfRevenue;
import pomplatform.OnRevenue.bean.BaseOnFinishPercentOfRevenue;
import pomplatform.OnRevenue.bean.BaseOnSheetAttachmentOfRevenue;
import pomplatform.OnRevenue.bean.ConditionOnBusinessStateOfRevenue;
import pomplatform.OnRevenue.bean.ConditionOnFinishPercentOfRevenue;
import pomplatform.OnRevenue.bean.ConditionOnSheetAttachmentOfRevenue;
import pomplatform.OnRevenue.query.QueryOnBusinessStateOfRevenue;
import pomplatform.OnRevenue.query.QueryOnFinishPercentOfRevenue;
import pomplatform.OnRevenue.query.QueryOnSheetAttachmentOfRevenue;
import pomplatform.project.business.ProjectAccount;

/**
 * 计算公司账户项目信息
 * @author lxf
 */
public class OnAboutRevenue implements GenericProcessor {
    private static Logger __logger = Logger.getLogger("");
    //操作类型
    private static final String OPT_TYPE = "optType";
    //加载业态表信息
    private static final String ON_LOAD_BUSINESS_STATE = "onLoadBusinessState";
    //加载拥有附件的订单信息
    private static final String ON_LOAD_SHEET_ATTACHMENT = "onLoadSheetAttachment";
    //加载订单完工比信息
    private static final String ON_LOAD_SHEET_FINISH_PERCENT = "onLoadSheetFinishPercent";
    //完工比确认
    private static final String ON_SAVE_FINISH_PERCENT = "onSaveFinishPercent";
    //标示字段:1:计算记录;2:月末计算
    private static final int ACCOUNT_FLAG_RECORD = 1;
    private static final int ACCOUNT_FLAG_FINAL = 2;
    //标示字段:1:累计营收;2:营收
    private static final int REVENUE_FLAG_ADD = 1;
    private static final int REVENUE_FLAG_SUBTRACT = 2;

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(param,OPT_TYPE);
        if(ON_LOAD_BUSINESS_STATE.equals(optType)){
        	return OnLoadBusinessState(param);
        }else if(ON_LOAD_SHEET_ATTACHMENT.equals(optType)){
        	return OnLoadSheetAttachment(param);
        }else if(ON_LOAD_SHEET_FINISH_PERCENT.equals(optType)){
        	return OnLoadSheetFinishPercent(param);
        }else if(ON_SAVE_FINISH_PERCENT.equals(optType)){
        	return OnSaveFinishPercent(param);
        }
        return null;
    }
    
    /**
     * 加载业态表信息
     * @return
     * @throws SQLException 
     */
    public String OnLoadBusinessState(Map<String, Object> param) throws SQLException{
    	//获取结束年月份
        String endDateStr = BaseHelpUtils.getStringValue(param, "endDate");
        Date endDate = new Date(Long.valueOf(endDateStr));
        //获取月份
        int month = BaseHelpUtils.getIntValue(param,"month");
        //获取合同编号
        String contractCode = BaseHelpUtils.getStringValue(param, "contractCode");
        ConditionOnBusinessStateOfRevenue condition = new ConditionOnBusinessStateOfRevenue();
        //获取签约公司
        if(!BaseHelpUtils.isNullOrEmpty(param.get("signingCompany"))){
        	int signingCompany = BaseHelpUtils.getIntValue(param,"signingCompany");
        	condition.setSigningCompany(signingCompany);
        }
        condition.setMonth(month);
        condition.setEndDate(endDate);
        if(!BaseHelpUtils.isNullOrEmpty(contractCode)){
        	condition.setContractCode(contractCode);
        }
        QueryOnBusinessStateOfRevenue dao = new QueryOnBusinessStateOfRevenue();
        BaseCollection<BaseOnBusinessStateOfRevenue> result = dao.executeQuery(null, condition);
        return result.toJSON(null);
    }
    /**
     * 加载拥有附件的订单信息
     * @return
     * @throws SQLException 
     */
    public String OnLoadSheetAttachment(Map<String, Object> param) throws SQLException{
    	//获取合同编号
    	String contractCode = BaseHelpUtils.getStringValue(param,"contractCode");
    	//获取是否加载所有的附件
    	boolean loadAll = (boolean)param.get("loadAll");
    	ConditionOnSheetAttachmentOfRevenue condition = new ConditionOnSheetAttachmentOfRevenue();
    	if(!BaseHelpUtils.isNullOrEmpty(contractCode)){
    		condition.setContractCode(contractCode);
    	}
    	if(!loadAll){
    		condition.setIsHandle(false);
    	}
    	QueryOnSheetAttachmentOfRevenue dao = new QueryOnSheetAttachmentOfRevenue();
    	BaseCollection<BaseOnSheetAttachmentOfRevenue> result = dao.executeQuery(null, condition);
    	return result.toJSON(null);
    }
    /**
     * 加载订单完工比信息
     * @return
     * @throws SQLException 
     */
    public String OnLoadSheetFinishPercent(Map<String, Object> param) throws SQLException{
    	//获取合同编号
    	String contractCode = BaseHelpUtils.getStringValue(param,"contractCode");
    	ConditionOnFinishPercentOfRevenue condition = new ConditionOnFinishPercentOfRevenue();
    	if(!BaseHelpUtils.isNullOrEmpty(contractCode)){
    		condition.setContractCode(contractCode);
    	}
    	QueryOnFinishPercentOfRevenue dao = new QueryOnFinishPercentOfRevenue();
    	BaseCollection<BaseOnFinishPercentOfRevenue> result = dao.executeQuery(null, condition);
    	return result.toJSON(null);
    }
    
    /**
     * 完工比计算
     * @param param
     * @throws SQLException
     */
    public String OnSaveFinishPercent(Map<String, Object> param) throws SQLException{
    	ThreadConnection.beginTransaction();
    	//获取结算日期
    	String accountDateStr = BaseHelpUtils.getString(param.get("accountDate"));
    	Date accountDate = new Date(Long.valueOf(accountDateStr));
    	//获取月份
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(accountDate);
    	int year = calendar.get(Calendar.YEAR);
    	//获取月份
    	int month = calendar.get(Calendar.MONTH)+1;
    	//获取完工比
    	double finishPercentDouble = BaseHelpUtils.getDoubleValue(param.get("finishPercent"));
    	BigDecimal finishPercent = BigDecimal.valueOf(finishPercentDouble);
    	//设置显示的完工比
    	String finishPercentView = String.valueOf((float)(finishPercentDouble*100))+"%";
    	//获取明细完工比
    	double finishPercentDetailDouble = BaseHelpUtils.getDoubleValue(param.get("finishPercentDetail"));
    	BigDecimal finishPercentDetail = BigDecimal.valueOf(finishPercentDetailDouble);
    	//设置显示的明细完工比
    	String finishPercentDetailView = String.valueOf((float)(finishPercentDetailDouble*100))+"%";
    	//获取合同编号
    	String contractCode = BaseHelpUtils.getStringValue(param, "contractCode");
    	//获取业态编号
    	String businessCode = BaseHelpUtils.getStringValue(param, "businessCode");
    	//获取业态名称
    	String businessName = BaseHelpUtils.getStringValue(param, "businessName");
    	//获取业态总金额
    	double businessIntegralDouble = BaseHelpUtils.getDoubleValue(param.get("businessIntegral"));
    	BigDecimal businessIntegral = BigDecimal.valueOf(businessIntegralDouble);
    	//获取签约公司
    	int signingCompany = BaseHelpUtils.getIntValue(param, "signingCompany");
    	//获取操作人
    	int operateEmployeeId = BaseHelpUtils.getIntValue(param, "operateEmployeeId");
    	//获取处理附件的id集合
    	String ids = BaseHelpUtils.getStringValue(param, "ids");
    	if(!BaseHelpUtils.isNullOrEmpty(ids)){
			String[] arr = ids.split(",");
			Integer[] obj = new Integer[arr.length];
			int j = 0;
			for(String id : arr){
				obj[j] = BaseHelpUtils.getIntValue(id);
				j++;
			}
			//更新附件表的状态为已处理
			ProjectAttachment projectAttachmentDao = new ProjectAttachment();
			projectAttachmentDao.addCondition(BaseProjectAttachment.CS_PROJECT_ATTACHMENT_ID,"in", (Object[]) obj);
			projectAttachmentDao.setIsHandle(Boolean.TRUE);
			projectAttachmentDao.conditionalUpdate();
		}
    	
    	//根据合同编号去业态表中检索数据，获取合同的总金额，即该合同下的每个业态的总金额的累加和
    	BusinessStateRecord businessDao = new BusinessStateRecord();
    	businessDao.setConditionBusinessCode("like", "%"+contractCode+"%");
    	List<BaseBusinessStateRecord> businessList = businessDao.conditionalLoad();
    	//初始化合同总金额
    	BigDecimal contractIntegral = BigDecimal.ZERO;
    	if(!businessList.isEmpty()){
    		for(BaseBusinessStateRecord e : businessList){
    			contractIntegral = contractIntegral.add(e.getBusinessIntegral()==null?BigDecimal.ZERO:e.getBusinessIntegral());
    		}
    	}
    	//先根据合同编号到合同表中去检索，看是否已存在，如果存在，则加载其合同ID,否则插入
    	Contract dao = new Contract();
    	dao.setConditionContractCode("=",contractCode);
    	BaseContract bean = dao.executeQueryOneRow();
    	//初始化合同ID
    	int contractId = 0;
    	if(BaseHelpUtils.isNullOrEmpty(bean)){//空合同，则需插入
    		dao.setContractCode(contractCode);
    		dao.setContractName(businessName);
    		dao.setIsSystemAdd(Boolean.FALSE);
    		dao.setSigningCompanyName(signingCompany);
    		dao.setSigningMoneySum(contractIntegral);
    		dao.save();
    		contractId = dao.getContractId();
    	}else{
    		contractId = BaseHelpUtils.getIntValue(bean.getContractId());
    	}
    	//更新业态表的合同ID
    	businessDao.setContractId(contractId);
    	businessDao.conditionalUpdate();
    	//先根据当前业态编号和当前月更新营收表中当前业态的结算记录，并设置当前插入的数据为月末计算记录
    	RevenueRecord revenueDao = new RevenueRecord();
    	revenueDao.setConditionCode("=",businessCode);
    	revenueDao.setConditionMonth("=",month);
    	revenueDao.setFlag(ACCOUNT_FLAG_RECORD);
    	revenueDao.conditionalUpdate();
    	//设置业态的营收
    	BigDecimal revenueMoney = finishPercentDetail.multiply(businessIntegral);
    	//往营收表插入新的数据集
    	revenueDao.clear();
    	revenueDao.setFlag(ACCOUNT_FLAG_FINAL);//设置为月末计算标示
    	revenueDao.setCode(businessCode);
    	revenueDao.setName(businessName);
    	revenueDao.setMonth(month);
    	revenueDao.setRevenueMoney(revenueMoney);
    	revenueDao.setAccountDate(accountDate);
    	revenueDao.setMoney(businessIntegral);
    	revenueDao.setFinishPercent(finishPercent);
    	revenueDao.setFinishPercentView(finishPercentView);
    	revenueDao.setFinishPercentDetail(finishPercentDetail);
    	revenueDao.setFinishPercentDetailView(finishPercentDetailView);
    	revenueDao.setParentId(contractId);
    	revenueDao.setSigningCompany(signingCompany);
    	revenueDao.setOperateEmployeeId(operateEmployeeId);
    	revenueDao.setOperateTime(new Date());
    	revenueDao.save();
    	//先根据合同ID和年份判断营收月统计表中是否存在记录，如果存在，则进行更新，如果不存在，则进行插入
    	RevenueYearRecord revenueYearDao = new RevenueYearRecord();
    	revenueYearDao.setConditionYearRevenue("=",year);
    	revenueYearDao.setConditionContractId("=",contractId);
    	BaseRevenueYearRecord revenueYearBean;
    	if(revenueYearDao.countRows() > 0){//已存在数据
    		//更新业态的累计营收开始**********************
    		revenueYearDao.clear();
    		revenueYearBean = new BaseRevenueYearRecord();
    		revenueYearDao.setConditionYearRevenue("=",year);
    		revenueYearDao.setConditionCode("=",businessCode);
    		revenueYearDao.setConditionFlag("=", REVENUE_FLAG_ADD);
    		//设置月累计营收
    		onSetRevenue(month, revenueMoney, revenueYearBean);
    		revenueYearDao.setDataFromBase(revenueYearBean);
    		revenueYearDao.conditionalUpdate();
    		//设置合计营收
    		onSetTotalRevenue(revenueYearBean, REVENUE_FLAG_ADD, year, businessCode);
    		revenueYearDao.setDataFromBase(revenueYearBean);
    		revenueYearDao.conditionalUpdate();
    		//更新业态的累计营收结束**********************
    		
    		//更新业态的营收开始*************************
    		revenueYearDao.clear();
    		revenueYearBean = new BaseRevenueYearRecord();
    		revenueYearDao.setConditionYearRevenue("=",year);
    		revenueYearDao.setConditionCode("=",businessCode);
    		revenueYearDao.setConditionFlag("=", REVENUE_FLAG_SUBTRACT);
    		//设置月累计营收
    		onSetRevenueMonth(year,month,businessCode,revenueMoney, revenueYearBean);
    		revenueYearDao.setDataFromBase(revenueYearBean);
    		revenueYearDao.conditionalUpdate();
    		//设置合计营收
    		onSetTotalRevenue(revenueYearBean, REVENUE_FLAG_SUBTRACT, year, businessCode);//更新累计营收
    		revenueYearDao.setDataFromBase(revenueYearBean);
    		revenueYearDao.conditionalUpdate();
    		//更新业态的营收结束*************************
    		
    		//更新合同的累计营收开始**********************
    		onUpdateOrSaveContractRevenue(contractId, year, REVENUE_FLAG_ADD, true, contractCode, businessName, contractIntegral, signingCompany, operateEmployeeId);;//更新累计营收
    		onUpdateOrSaveContractRevenue(contractId, year, REVENUE_FLAG_SUBTRACT, true, contractCode, businessName, contractIntegral, signingCompany, operateEmployeeId);;//更新每月营收
    		//更新合同的累计营收结束**********************
    		
    	}else{
    		//插入业态累计营收开始***********************
    		
    		revenueYearDao.clear();
    		revenueYearBean = new BaseRevenueYearRecord();
    		revenueYearBean.setParentId(contractId);
    		revenueYearBean.setFlag(REVENUE_FLAG_ADD);
    		revenueYearBean.setYearRevenue(year);
    		revenueYearBean.setCode(businessCode);
    		revenueYearBean.setName(businessName);
    		revenueYearBean.setMoney(businessIntegral);
    		revenueYearBean.setSigningCompany(signingCompany);
    		//设置月累计营收
    		onSetRevenue(month, revenueMoney, revenueYearBean);
    		revenueYearBean.setTotalRevenue(revenueMoney);
    		revenueYearBean.setOperateEmployeeId(operateEmployeeId);
    		revenueYearBean.setOperateTime(new Date());
    		revenueYearDao.setDataFromBase(revenueYearBean);
    		revenueYearDao.save();
    		//插入业态累计营收结束***********************
    		
    		//插入业态每月营收开始***********************
    		revenueYearDao.clear();
    		revenueYearBean = new BaseRevenueYearRecord();
    		revenueYearBean.setParentId(contractId);
    		revenueYearBean.setFlag(REVENUE_FLAG_SUBTRACT);
    		revenueYearBean.setYearRevenue(year);
    		revenueYearBean.setCode(businessCode);
    		revenueYearBean.setName(businessName);
    		revenueYearBean.setMoney(businessIntegral);
    		revenueYearBean.setSigningCompany(signingCompany);
    		//设置月累计营收
    		onSetRevenue(month, revenueMoney, revenueYearBean);
    		switch (month) {
    		case 1://如果是一月，则需检索上一年的12月份的累计营收
    			RevenueYearRecord daos = new RevenueYearRecord();
    			daos.setConditionYearRevenue("=",year-1);
    			daos.setConditionFlag("=",REVENUE_FLAG_ADD);
    			daos.setConditionCode("=",businessCode);
    			BaseRevenueYearRecord base = daos.executeQueryOneRow();
    			//初始化上一年的12月的累计营收值
    			BigDecimal decemberRevenue = BigDecimal.ZERO;
    			if(!BaseHelpUtils.isNullOrEmpty(base)){
    				decemberRevenue = base.getDecemberRevenue()==null?BigDecimal.ZERO:base.getDecemberRevenue();
    			}
    			revenueYearBean.setTotalRevenue(revenueMoney.subtract(decemberRevenue));
    			break;
			default:
				revenueYearBean.setTotalRevenue(revenueMoney);
				break;
			}
    		revenueYearBean.setOperateEmployeeId(operateEmployeeId);
    		revenueYearBean.setOperateTime(new Date());
    		revenueYearDao.setDataFromBase(revenueYearBean);
    		revenueYearDao.save();
    		
    		//插入业态每月营收结束***********************
    		
    		//插入合同的累计营收开始**********************
    		onUpdateOrSaveContractRevenue(contractId, year, REVENUE_FLAG_ADD, false, contractCode, businessName, contractIntegral, signingCompany, operateEmployeeId);;//插入累计营收
    		onUpdateOrSaveContractRevenue(contractId, year, REVENUE_FLAG_SUBTRACT, false, contractCode, businessName, contractIntegral, signingCompany, operateEmployeeId);;//插入每月营收
    		//插入合同的累计营收结束**********************
    	}
    	
    	ThreadConnection.commit();
    	return null;
    }
    
    /**
     * 合同营收的更新
     * @param contractId
     * @param year
     * @param flag
     * @throws SQLException
     */
    public void onUpdateOrSaveContractRevenue(int contractId,int year,int flag,boolean is_update,String contractCode,String contractName,BigDecimal money,int signintCompany,int operateEmployeeId) throws SQLException{
    	List<BaseRevenueYearRecord> revenueYearList;
    	//初始化每个月的营收和合计
    	BigDecimal januaryRevenue = BigDecimal.ZERO;
    	BigDecimal februaryRevenue = BigDecimal.ZERO;
    	BigDecimal marchRevenue = BigDecimal.ZERO;
    	BigDecimal aprilRevenue = BigDecimal.ZERO;
    	BigDecimal mayRevenue = BigDecimal.ZERO;
    	BigDecimal juneRevenue = BigDecimal.ZERO;
    	BigDecimal julyRevenue = BigDecimal.ZERO;
    	BigDecimal augustRevenue = BigDecimal.ZERO;
    	BigDecimal septemberRevenue = BigDecimal.ZERO;
    	BigDecimal octoberRevenue = BigDecimal.ZERO;
    	BigDecimal novemberRevenue = BigDecimal.ZERO;
    	BigDecimal decemberRevenue = BigDecimal.ZERO;
    	//合计
    	BigDecimal totalRevenue = BigDecimal.ZERO;
    	BaseRevenueYearRecord revenueYearBean;
    	//更新合同的累计营收，即该合同下的业态的营收的累加和
    	RevenueYearRecord revenueYearDao = new RevenueYearRecord();
    	revenueYearDao.setConditionParentId("=",contractId);
    	revenueYearDao.setConditionYearRevenue("=",year);
    	revenueYearDao.setConditionFlag("=",flag);
    	revenueYearList = revenueYearDao.conditionalLoad();
    	if(!revenueYearList.isEmpty()){
    		for(BaseRevenueYearRecord bean : revenueYearList){
    			januaryRevenue = januaryRevenue.add(bean.getJanuaryRevenue()==null?BigDecimal.ZERO:bean.getJanuaryRevenue());
    			februaryRevenue = februaryRevenue.add(bean.getFebruaryRevenue()==null?BigDecimal.ZERO:bean.getFebruaryRevenue());
    			marchRevenue = marchRevenue.add(bean.getMarchRevenue()==null?BigDecimal.ZERO:bean.getMarchRevenue());
    			aprilRevenue = aprilRevenue.add(bean.getAprilRevenue()==null?BigDecimal.ZERO:bean.getAprilRevenue());
    			mayRevenue = mayRevenue.add(bean.getMayRevenue()==null?BigDecimal.ZERO:bean.getMayRevenue());
    			juneRevenue = juneRevenue.add(bean.getJuneRevenue()==null?BigDecimal.ZERO:bean.getJuneRevenue());
    			julyRevenue = julyRevenue.add(bean.getJulyRevenue()==null?BigDecimal.ZERO:bean.getJulyRevenue());
    			augustRevenue = augustRevenue.add(bean.getAugustRevenue()==null?BigDecimal.ZERO:bean.getAugustRevenue());
    			septemberRevenue = septemberRevenue.add(bean.getSeptemberRevenue()==null?BigDecimal.ZERO:bean.getSeptemberRevenue());
    			octoberRevenue = octoberRevenue.add(bean.getOctoberRevenue()==null?BigDecimal.ZERO:bean.getOctoberRevenue());
    			novemberRevenue = novemberRevenue.add(bean.getNovemberRevenue()==null?BigDecimal.ZERO:bean.getNovemberRevenue());
    			decemberRevenue = decemberRevenue.add(bean.getDecemberRevenue()==null?BigDecimal.ZERO:bean.getDecemberRevenue());
    			totalRevenue = totalRevenue.add(bean.getTotalRevenue()==null?BigDecimal.ZERO:bean.getTotalRevenue());
    		}
    		//更新
    		revenueYearDao.clear();
    		revenueYearBean = new BaseRevenueYearRecord();
    		revenueYearBean.setJanuaryRevenue(januaryRevenue);
    		revenueYearBean.setFebruaryRevenue(februaryRevenue);
    		revenueYearBean.setMarchRevenue(marchRevenue);
    		revenueYearBean.setAprilRevenue(aprilRevenue);
    		revenueYearBean.setMayRevenue(mayRevenue);
    		revenueYearBean.setJuneRevenue(juneRevenue);
    		revenueYearBean.setJulyRevenue(julyRevenue);
    		revenueYearBean.setSeptemberRevenue(septemberRevenue);
    		revenueYearBean.setOctoberRevenue(octoberRevenue);
    		revenueYearBean.setNovemberRevenue(novemberRevenue);
    		revenueYearBean.setDecemberRevenue(decemberRevenue);
    		revenueYearBean.setTotalRevenue(totalRevenue);
    		if(is_update){//更新
    			revenueYearDao.setConditionContractId("=",contractId);
    			revenueYearDao.setConditionYearRevenue("=",year);
    			revenueYearDao.setConditionFlag("=",flag);
    			revenueYearDao.setDataFromBase(revenueYearBean);
    			revenueYearDao.conditionalUpdate();
    		}else{//插入
    			revenueYearBean.setYearRevenue(year);
    			revenueYearBean.setFlag(flag);
    			revenueYearBean.setContractId(contractId);
    			revenueYearBean.setCode(contractCode);
    			revenueYearBean.setName(contractName);
    			revenueYearBean.setMoney(money);
    			revenueYearBean.setSigningCompany(signintCompany);
    			revenueYearBean.setOperateEmployeeId(operateEmployeeId);
    			revenueYearBean.setOperateTime(new Date());
    			revenueYearDao.setDataFromBase(revenueYearBean);
    			revenueYearDao.save();
    		}
    	}
    }
    
    /**
     * 设置营收合计
     * @param revenueYearDao
     * @throws SQLException
     */
    public void onSetTotalRevenue(BaseRevenueYearRecord revenueYearBean,int flag,int year,String businessCode) throws SQLException{
    	RevenueYearRecord revenueYearDao = new RevenueYearRecord();
    	revenueYearDao.setConditionYearRevenue("=",year);
		revenueYearDao.setConditionFlag("=",flag);
		revenueYearDao.setConditionCode("=",businessCode);
    	BaseRevenueYearRecord bean = revenueYearDao.executeQueryOneRow();
    	if(!BaseHelpUtils.isNullOrEmpty(bean)){
    		BigDecimal januaryRevenue = bean.getJanuaryRevenue()==null?BigDecimal.ZERO:bean.getJanuaryRevenue();
    		BigDecimal februaryRevenue = bean.getFebruaryRevenue()==null?BigDecimal.ZERO:bean.getFebruaryRevenue();
    		BigDecimal marchRevenue = bean.getMarchRevenue()==null?BigDecimal.ZERO:bean.getMarchRevenue();
    		BigDecimal aprilRevenue = bean.getAprilRevenue()==null?BigDecimal.ZERO:bean.getAprilRevenue();
    		BigDecimal mayRevenue = bean.getMayRevenue()==null?BigDecimal.ZERO:bean.getMayRevenue();
    		BigDecimal juneRevenue = bean.getJuneRevenue()==null?BigDecimal.ZERO:bean.getJuneRevenue();
    		BigDecimal julyRevenue = bean.getJulyRevenue()==null?BigDecimal.ZERO:bean.getJulyRevenue();
    		BigDecimal augustRevenue = bean.getAugustRevenue()==null?BigDecimal.ZERO:bean.getAugustRevenue();
    		BigDecimal septemberRevenue = bean.getSeptemberRevenue()==null?BigDecimal.ZERO:bean.getSeptemberRevenue();
    		BigDecimal octoberRevenue = bean.getOctoberRevenue()==null?BigDecimal.ZERO:bean.getOctoberRevenue();
    		BigDecimal novemberRevenue = bean.getNovemberRevenue()==null?BigDecimal.ZERO:bean.getNovemberRevenue();
    		BigDecimal decemberRevenue = bean.getDecemberRevenue()==null?BigDecimal.ZERO:bean.getDecemberRevenue();
    		//合计
    		BigDecimal totalRevenue = januaryRevenue.add(februaryRevenue).add(marchRevenue).add(aprilRevenue).add(mayRevenue).add(juneRevenue).add(julyRevenue).add(augustRevenue).add(septemberRevenue).add(octoberRevenue).add(novemberRevenue).add(decemberRevenue);
    		revenueYearBean.setTotalRevenue(totalRevenue);
    	}
    }
    
    
    /**
     * 设置营收
     * @param month
     * @param revenueMoney
     * @param revenueYearDao
     */
    public void onSetRevenue(int month,BigDecimal revenueMoney,BaseRevenueYearRecord revenueYearBean){
    	switch (month) {
		case 1:
			revenueYearBean.setJanuaryRevenue(revenueMoney);
			break;
		case 2:
			revenueYearBean.setFebruaryRevenue(revenueMoney);
			break;
		case 3:
			revenueYearBean.setMarchRevenue(revenueMoney);
			break;
		case 4:
			revenueYearBean.setAprilRevenue(revenueMoney);
			break;
		case 5:
			revenueYearBean.setMayRevenue(revenueMoney);
			break;
		case 6:
			revenueYearBean.setJuneRevenue(revenueMoney);
			break;
		case 7:
			revenueYearBean.setJulyRevenue(revenueMoney);
			break;
		case 8:
			revenueYearBean.setAugustRevenue(revenueMoney);
			break;
		case 9:
			revenueYearBean.setSeptemberRevenue(revenueMoney);
			break;
		case 10:
			revenueYearBean.setOctoberRevenue(revenueMoney);
			break;
		case 11:
			revenueYearBean.setNovemberRevenue(revenueMoney);
			break;
		case 12:
			revenueYearBean.setDecemberRevenue(revenueMoney);
			break;
		default:
			break;
		}
    }
    
    /**
     * 设置营收
     * @param month
     * @param revenueMoney
     * @param revenueYearDao
     * @throws SQLException 
     */
    public void onSetRevenueMonth(int year,int month,String businessCode,BigDecimal revenueMoney,BaseRevenueYearRecord revenueYearBean) throws SQLException{
    	RevenueYearRecord revenueYearDao = new RevenueYearRecord();
    	revenueYearDao.setConditionYearRevenue("=",year);
		revenueYearDao.setConditionFlag("=",REVENUE_FLAG_SUBTRACT);
		revenueYearDao.setConditionCode("=",businessCode);
    	BaseRevenueYearRecord bean = revenueYearDao.executeQueryOneRow();
    	if(!BaseHelpUtils.isNullOrEmpty(bean)){
    		switch (month) {
    		case 1://如果是一月，则需检索上一年的12月份的累计营收
    			RevenueYearRecord dao = new RevenueYearRecord();
    			dao.setConditionYearRevenue("=",year-1);
    			dao.setConditionFlag("=",REVENUE_FLAG_ADD);
    			dao.setConditionCode("=",businessCode);
    			BaseRevenueYearRecord base = dao.executeQueryOneRow();
    			//初始化上一年的12月的累计营收值
    			BigDecimal decemberRevenue = BigDecimal.ZERO;
    			if(!BaseHelpUtils.isNullOrEmpty(base)){
    				decemberRevenue = base.getDecemberRevenue()==null?BigDecimal.ZERO:base.getDecemberRevenue();
    			}
    			revenueYearBean.setJanuaryRevenue(revenueMoney.subtract(decemberRevenue));
    			break;
    		case 2:
    			revenueYearBean.setFebruaryRevenue(revenueMoney.subtract(bean.getJanuaryRevenue()==null?BigDecimal.ZERO:bean.getJanuaryRevenue()));
    			break;
    		case 3:
    			revenueYearBean.setMarchRevenue(revenueMoney.subtract(bean.getFebruaryRevenue()==null?BigDecimal.ZERO:bean.getFebruaryRevenue()));
    			break;
    		case 4:
    			revenueYearBean.setAprilRevenue(revenueMoney.subtract(bean.getMarchRevenue()==null?BigDecimal.ZERO:bean.getMarchRevenue()));
    			break;
    		case 5:
    			revenueYearBean.setMayRevenue(revenueMoney.subtract(bean.getAprilRevenue()==null?BigDecimal.ZERO:bean.getAprilRevenue()));
    			break;
    		case 6:
    			revenueYearBean.setJuneRevenue(revenueMoney.subtract(bean.getMayRevenue()==null?BigDecimal.ZERO:bean.getMayRevenue()));
    			break;
    		case 7:
    			revenueYearBean.setJulyRevenue(revenueMoney.subtract(bean.getJuneRevenue()==null?BigDecimal.ZERO:bean.getJuneRevenue()));
    			break;
    		case 8:
    			revenueYearBean.setAugustRevenue(revenueMoney.subtract(bean.getJulyRevenue()==null?BigDecimal.ZERO:bean.getJulyRevenue()));
    			break;
    		case 9:
    			revenueYearBean.setSeptemberRevenue(revenueMoney.subtract(bean.getAugustRevenue()==null?BigDecimal.ZERO:bean.getAugustRevenue()));
    			break;
    		case 10:
    			revenueYearBean.setOctoberRevenue(revenueMoney.subtract(bean.getSeptemberRevenue()==null?BigDecimal.ZERO:bean.getSeptemberRevenue()));
    			break;
    		case 11:
    			revenueYearBean.setNovemberRevenue(revenueMoney.subtract(bean.getOctoberRevenue()==null?BigDecimal.ZERO:bean.getOctoberRevenue()));
    			break;
    		case 12:
    			revenueYearBean.setDecemberRevenue(revenueMoney.subtract(bean.getNovemberRevenue()==null?BigDecimal.ZERO:bean.getNovemberRevenue()));
    			break;
    		default:
    			break;
    		}
    	}
    }
    
    public static void main(String[] args) throws SQLException {
    	Map<Integer,Integer> newIsHandleMap = new HashMap<>();
    	newIsHandleMap.put(1, 1);
    	newIsHandleMap.put(2, 2);
    	newIsHandleMap.put(3, 3);
    	newIsHandleMap.put(4, 4);
    	String ids="";
		int len = newIsHandleMap.size();
		int i = 1;
		for(Integer id : newIsHandleMap.keySet()){
			ids += id;
			if(i < len){
				ids += ",";
			}
			i++;
		}
		System.out.println(ids);
		
		if(!BaseHelpUtils.isNullOrEmpty(ids)){
			String[] s = ids.split(",");
			System.out.println(s.length);
			Object[] obj = new Object[s.length];
			int j = 0;
			for(String str : s){
				obj[j] = str;
				j++;
			}
		}
	}
}
