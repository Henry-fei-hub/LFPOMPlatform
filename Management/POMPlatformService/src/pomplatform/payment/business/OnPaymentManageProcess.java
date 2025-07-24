package pomplatform.payment.business;

import java.io.File;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.SocketTimeoutException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.conn.ConnectTimeoutException;
import org.apache.log4j.Logger;
import org.apache.solr.common.util.Hash;

import com.pomplatform.db.bean.BaseCompanyRecord;
import com.pomplatform.db.bean.BaseDepartment;
import com.pomplatform.db.bean.BaseEmployeeCostRecord;
import com.pomplatform.db.bean.BaseEmployeeDayCheck;
import com.pomplatform.db.bean.BaseEmployeeMonthCheck;
import com.pomplatform.db.bean.BaseEmployeePaymentDetail;
import com.pomplatform.db.bean.BaseEmployeeRole;
import com.pomplatform.db.bean.BaseEmployeeShiftManage;
import com.pomplatform.db.bean.BaseFiveInsuranceOneGold;
import com.pomplatform.db.bean.BaseLaborPaymentEmployee;
import com.pomplatform.db.bean.BasePlateDepartment;
import com.pomplatform.db.bean.BaseSalaryAnnualBonus;
import com.pomplatform.db.bean.BaseSalaryEmployeePerformance;
import com.pomplatform.db.bean.BaseSalaryOfBonus;
import com.pomplatform.db.bean.BaseSalaryOfWorkYear;
import com.pomplatform.db.bean.BaseSalaryTotal;
import com.pomplatform.db.bean.BaseSalaryTotalRecord;
import com.pomplatform.db.bean.BaseSpecialDeductionMonthDetail;
import com.pomplatform.db.dao.CompanyRecord;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.EmployeeCostRecord;
import com.pomplatform.db.dao.EmployeeDayCheck;
import com.pomplatform.db.dao.EmployeeMonthCheck;
import com.pomplatform.db.dao.EmployeePaymentDetail;
import com.pomplatform.db.dao.EmployeeRole;
import com.pomplatform.db.dao.EmployeeShiftManage;
import com.pomplatform.db.dao.FiveInsuranceOneGold;
import com.pomplatform.db.dao.HolidayManage;
import com.pomplatform.db.dao.LaborPaymentEmployee;
import com.pomplatform.db.dao.PlateDepartment;
import com.pomplatform.db.dao.SalaryAnnualBonus;
import com.pomplatform.db.dao.SalaryEmployeePerformance;
import com.pomplatform.db.dao.SalaryFillSendDeduct;
import com.pomplatform.db.dao.SalaryJobSubsidy;
import com.pomplatform.db.dao.SalaryLeaveSubsidy;
import com.pomplatform.db.dao.SalaryOfBonus;
import com.pomplatform.db.dao.SalaryOfWorkYear;
import com.pomplatform.db.dao.SalaryTotal;
import com.pomplatform.db.dao.SalaryTotalRecord;
import com.pomplatform.db.dao.SpecialDeduction;
import com.pomplatform.db.dao.SpecialDeductionMonthDetail;
import com.pomplatform.db.dao.SystemConfig;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.DES;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericProcessor;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.servlet.DelicacyServlet;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import message.common.ERPWeixinUtils;
import message.common.OnTelMobile;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.StaticUtils;
import pomplatform.payment.bean.BaseFiveinsuranceSummaryPlate;
import pomplatform.payment.bean.BaseLoadSalaryTotal;
import pomplatform.payment.bean.BaseLoadSalaryTotal3;
import pomplatform.payment.bean.BaseOnLoadEmpWordDayOfMonth;
import pomplatform.payment.bean.BaseOnLoadSalaryPaymentChange;
import pomplatform.payment.bean.BaseOnLoadSalaryTotalMonthData;
import pomplatform.payment.bean.BaseOnLoadShiftAndDayPayment;
import pomplatform.payment.bean.BaseOnLoadUnitFundAndInsurance;
import pomplatform.payment.bean.BaseOnOtherDeductionData;
import pomplatform.payment.bean.BaseOnReplacementTaxData;
import pomplatform.payment.bean.BaseOnSalaryReportByPlate;
import pomplatform.payment.bean.BaseOnSalaryTotalData;
import pomplatform.payment.bean.BaseQueryLoadSalaryTotal2;
import pomplatform.payment.bean.BaseSearchCostData;
import pomplatform.payment.bean.BaseSendIntegralOfEmpPaymentDetail;
import pomplatform.payment.bean.ConditionFiveinsuranceSummaryPlate;
import pomplatform.payment.bean.ConditionLoadSalaryTotal;
import pomplatform.payment.bean.ConditionLoadSalaryTotal3;
import pomplatform.payment.bean.ConditionOnLoadEmpWordDayOfMonth;
import pomplatform.payment.bean.ConditionOnLoadSalaryPaymentChange;
import pomplatform.payment.bean.ConditionOnLoadSalaryTotalMonthData;
import pomplatform.payment.bean.ConditionOnLoadShiftAndDayPayment;
import pomplatform.payment.bean.ConditionOnLoadUnitFundAndInsurance;
import pomplatform.payment.bean.ConditionOnOtherDeductionData;
import pomplatform.payment.bean.ConditionOnReplacementTaxData;
import pomplatform.payment.bean.ConditionOnSalaryReportByPlate;
import pomplatform.payment.bean.ConditionOnSalaryTotalData;
import pomplatform.payment.bean.ConditionQueryLoadSalaryTotal2;
import pomplatform.payment.bean.ConditionSearchCostData;
import pomplatform.payment.bean.ConditionSendIntegralOfEmpPaymentDetail;
import pomplatform.payment.handler.OnReplacementTaxDataHandler;
import pomplatform.payment.query.QueryFiveinsuranceSummaryPlate;
import pomplatform.payment.query.QueryLoadSalaryTotal;
import pomplatform.payment.query.QueryLoadSalaryTotal3;
import pomplatform.payment.query.QueryOnLoadEmpWordDayOfMonth;
import pomplatform.payment.query.QueryOnLoadSalaryPaymentChange;
import pomplatform.payment.query.QueryOnLoadSalaryTotalMonthData;
import pomplatform.payment.query.QueryOnLoadShiftAndDayPayment;
import pomplatform.payment.query.QueryOnLoadUnitFundAndInsurance;
import pomplatform.payment.query.QueryOnOtherDeductionData;
import pomplatform.payment.query.QueryOnReplacementTaxData;
import pomplatform.payment.query.QueryOnSalaryReportByPlate;
import pomplatform.payment.query.QueryOnSalaryTotalData;
import pomplatform.payment.query.QueryQueryLoadSalaryTotal2;
import pomplatform.payment.query.QuerySearchCostData;
import pomplatform.payment.query.QuerySendIntegralOfEmpPaymentDetail;
import pomplatform.shift.business.ThreadTaskTemplate;
import pomplatform.shift.business.ThreadTaskUtils;
import pomplatform.specialDeduction.bean.BaseMspecialdeductionrecordsor;
import pomplatform.specialDeduction.bean.BaseOnLoadSpecialDeductionYear;
import pomplatform.specialDeduction.bean.BaseSspecialdeductionmonthdetailedpor;
import pomplatform.specialDeduction.bean.ConditionMspecialdeductionrecordsor;
import pomplatform.specialDeduction.bean.ConditionOnLoadSpecialDeductionYear;
import pomplatform.specialDeduction.bean.ConditionSspecialdeductionmonthdetailedpor;
import pomplatform.specialDeduction.query.QueryMspecialdeductionrecordsor;
import pomplatform.specialDeduction.query.QueryOnLoadSpecialDeductionYear;
import pomplatform.specialDeduction.query.QuerySspecialdeductionmonthdetailedpor;

/**
 * 薪酬管理相关
 * @author lxf
 */
public class OnPaymentManageProcess implements GenericProcessor,GenericDownloadProcessor {
	private static final Logger __logger = Logger.getLogger("");
    //操作类型
    private static final String OPT_TYPE = "optType";
    //员工日薪重置
    private static final String ON_RESET_EMP_DAY_PAYMENT = "onResetEmpDayPayment";
    //薪资总表计算
    private static final String ON_SALARY_TOTAL_ACCOUNT = "onSalaryTotalAccount";
    //薪资总表数据下发
    private static final String ON_SALARY_TOTAL_SEND = "onSalaryTotalSend";
    //年终奖修改
    private static final String ON_ANNUAL_BONUS_EDIT = "onAnnualBonusEdit";
    //密码匹配
    private static final String ON_COMPARE_PASSWORD = "onComparePassword";
    //修改工资表员工的公司部门 连带修改 五险一金，员工绩效，奖金
    private static final String ON_EDIT_COMPANY_DEPARTMENT = "onEditCompanyDepartment";
    //薪资总表数据推送
    private static final String ON_SALARY_TOTAL_PUSH = "onSalaryTotalPush";
    //奖金新增保存
    private static final String ON_SALARY_OF_BONUS_SAVE = "onSalaryOfBonusSave";
    //通过角色查找人员
    private static final String ON_FIND_EMP_BY_ROLE = "onFindEmpByRole";
    //日薪推送
    private static final String ON_SEND_EMP_DAY_PAYMENT = "onSendEmpDayPayment";
    //日薪推送(推送个人)
    private static final String ON_SEND_EMP_DAY_PAYMENT_SINGLE = "onSendEmpDayPaymentSingle";
    //月专项扣除统计
    private static final String ON_SPECIAL_DEDUCTION_MONTH_TOTAL_ACCOUNT = "onSpecialDeductionMonthTotalAccount";
    
	public static  String START_DATE ="12-11";
	public static  String END_DATE = "";
	public static  boolean IS_STRIDE =false;
    
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(param,OPT_TYPE);
        switch (optType) {
		case ON_RESET_EMP_DAY_PAYMENT:
			return onResetEmpDayPaymentThread(param);
		case ON_SALARY_TOTAL_ACCOUNT:
			return onSalaryTotalAccount(param);
		case ON_SALARY_TOTAL_SEND:
			return onSalaryTotalSend(param);
		case ON_ANNUAL_BONUS_EDIT:
			return onAnnualBonusEdit(param);
		case ON_COMPARE_PASSWORD:
			return onComparePassword(param);
		case ON_EDIT_COMPANY_DEPARTMENT:
			return onEditCompanyDepartment(param);
		case ON_SALARY_TOTAL_PUSH:
			return onSalaryTotalPush(param);
		case ON_SALARY_OF_BONUS_SAVE:
			return onSalaryOfBonusSave(param);
		case ON_FIND_EMP_BY_ROLE:
			return onFindEmpByRole(param);
		case ON_SEND_EMP_DAY_PAYMENT:
			return onSendEmpDayPaymentThread(param);
		case ON_SEND_EMP_DAY_PAYMENT_SINGLE:
			return onSendEmpDayPayment(param);
		case ON_SPECIAL_DEDUCTION_MONTH_TOTAL_ACCOUNT:
			return onSpecialDeductionMonthTotalAccount(param);
		default:
			break;
		}
        return null;
    }
    
	@SuppressWarnings("unused")
	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	@SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        String optType = BaseHelpUtils.getStringValue(param,OPT_TYPE);
        
	}
	
	/**
	 * 通过角色查找人员
	 * @param param
	 * @return
	 * @throws SQLException 
	 */
	private String onFindEmpByRole(Map<String, Object> param) throws SQLException {
		//定义制表人
		String formPerson = "";
		//审批人
		String auditPerson ="";
		//批准人(总经理)
		String adminPerson ="";
		//人资行政副经理
		String hrPerson = "";
		//人资分管领导
		String operatePerson = "";
		//薪酬专员
		String payPerson = "";
		//获取业务部门id数据集
		String plateIds = BaseHelpUtils.getStringValue(param, "plateIds");
		if(BaseHelpUtils.isNullOrEmpty(plateIds)){
			throw new SQLException("操作异常：没有需要打印的数据集");
		}
		String[] plateIdArr = plateIds.split(",");
		int len = plateIdArr.length;
    	Object[] idArr = new Object[len];
    	int i = 0;
    	for(String id : plateIdArr){
    		idArr[i] = BaseHelpUtils.getIntValue(id);
    		i++;
    	}
    	Department dao = new Department();
    	dao.setConditionParentId("=",1);
    	dao.addCondition(BaseDepartment.CS_PLATE_ID,"in",idArr);//通过业务部门获取归属部门
    	List<BaseDepartment> list = dao.conditionalLoad();
    	int deLen = list.size();
    	Object[] deArr = new Object[deLen];
    	if(!BaseHelpUtils.isNullOrEmpty(list) && deLen > 0){
    		int j = 0;
    		for(BaseDepartment e : list){
    			deArr[j] = e.getDepartmentId();
    			j++;
    		}
    	}
    	Employee eDao = new Employee();
    	EmployeeRole emDao = new EmployeeRole();
    	List<BaseEmployeeRole> emList = null;
    	if(!BaseHelpUtils.isNullOrEmpty(deArr) && deArr.length > 0){
    		//检索审批人
    		emDao.setConditionRoleId("=",60);//部门分管领导
    		emDao.addCondition(BaseEmployeeRole.CS_DEPARTMENT_ID,"in",deArr);//通过归属部门获取角色
    		emList = emDao.conditionalLoad();
    		if(!BaseHelpUtils.isNullOrEmpty(emList) && emList.size() > 0){
    			Map<Integer,Integer> map = new HashMap<>();
    			for(BaseEmployeeRole e : emList){
    				int empId = e.getEmployeeId();
    				map.put(empId, empId);
    			}
    			if(!BaseHelpUtils.isNullOrEmpty(map) && map.size() > 0){
    				for(Integer empId : map.keySet()){
    					eDao.clear();
    					eDao.setEmployeeId(empId);
    					if(eDao.load()){
    						String empName = eDao.getEmployeeName();
    						if(!BaseHelpUtils.isNullOrEmpty(auditPerson)){
    							auditPerson += "，";
    						}
    						auditPerson += empName;
    					}
    				}
    			}
    		}
    	}
    	emDao.clear();
    	//获取制表人
    	emDao.setConditionDepartmentId("=",78);
    	emDao.setConditionRoleId("=",7);
    	emList = emDao.conditionalLoad();
    	if(!BaseHelpUtils.isNullOrEmpty(emList) && emList.size() > 0){
    		int empId = emList.get(0).getEmployeeId();
    		eDao.clear();
    		eDao.setEmployeeId(empId);
    		if(eDao.load()){
				String empName = eDao.getEmployeeName();
				if(!BaseHelpUtils.isNullOrEmpty(formPerson)){
					formPerson += ",";
				}
				formPerson += empName;
			}
    	}
    	//获取批准人
    	emDao.clear();
    	emDao.setConditionDepartmentId("=",1);
    	emDao.setConditionRoleId("=",27);
    	emList = emDao.conditionalLoad();
    	if(!BaseHelpUtils.isNullOrEmpty(emList) && emList.size() > 0){
    		int empId = emList.get(0).getEmployeeId();
    		eDao.clear();
    		eDao.setEmployeeId(empId);
    		if(eDao.load()){
				String empName = eDao.getEmployeeName();
				if(!BaseHelpUtils.isNullOrEmpty(adminPerson)){
					adminPerson += ",";
				}
				adminPerson += empName;
			}
    	}
    	//人资行政副经理
    	emDao.clear();
    	emDao.setConditionDepartmentId("=", 7);
    	emDao.setConditionRoleId("=", 22);
    	emList = emDao.conditionalLoad();
    	if(!BaseHelpUtils.isNullOrEmpty(emList) && emList.size() > 0){
    		int empId = emList.get(0).getEmployeeId();
    		eDao.clear();
    		eDao.setEmployeeId(empId);
    		if(eDao.load()){
				String empName = eDao.getEmployeeName();
				if(!BaseHelpUtils.isNullOrEmpty(hrPerson)){
					hrPerson += ",";
				}
				hrPerson += empName;
			}
    	}
    	//人资分管领导
    	emDao.clear();
    	emDao.setConditionDepartmentId("=", 7);
    	emDao.setConditionRoleId("=", 60);
    	emList = emDao.conditionalLoad();
    	if(!BaseHelpUtils.isNullOrEmpty(emList) && emList.size() > 0){
    		int empId = emList.get(0).getEmployeeId();
    		eDao.clear();
    		eDao.setEmployeeId(empId);
    		if(eDao.load()){
				String empName = eDao.getEmployeeName();
				if(!BaseHelpUtils.isNullOrEmpty(operatePerson)){
					operatePerson += ",";
				}
				operatePerson += empName;
			}
    	}
    	//薪酬专员
    	emDao.clear();
    	emDao.setConditionDepartmentId("=", 78);
    	emDao.setConditionRoleId("=", 7);
    	emList = emDao.conditionalLoad();
    	if(!BaseHelpUtils.isNullOrEmpty(emList) && emList.size() > 0){
    		int empId = emList.get(0).getEmployeeId();
    		eDao.clear();
    		eDao.setEmployeeId(empId);
    		if(eDao.load()){
				String empName = eDao.getEmployeeName();
				if(!BaseHelpUtils.isNullOrEmpty(payPerson)){
					payPerson += ",";
				}
				payPerson += empName;
			}
    	}
    	Map<String,String> backMap = new HashMap<>();
    	backMap.put("auditPerson", auditPerson);
    	backMap.put("formPerson", formPerson);
    	backMap.put("adminPerson", adminPerson);
    	backMap.put("hrPerson", hrPerson);
    	backMap.put("operatePerson", operatePerson);
    	backMap.put("payPerson", payPerson);
		BaseCollection<BaseEmployeeRole> bc = new BaseCollection<>();
		bc.setUserData(backMap);
		return bc.toJSON(0, "");
	}
	
	
	/**
	 * 奖金 新增保存
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	private String onSalaryOfBonusSave(Map<String, Object> param) throws SQLException {
		int employeeId = BaseHelpUtils.getIntValue(param.get("employeeId"));
		Date recordDate = GenericBase.__getDate(param.get("recordDate"));
		Calendar cal = Calendar.getInstance();
		cal.setTime(recordDate);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		
		Employee dao = new Employee();
		dao.setConditionEmployeeId("=", employeeId);
		BaseEmployee bean = dao.executeQueryOneRow();
		
		SalaryOfBonus bdao = new SalaryOfBonus();
		if(!BaseHelpUtils.isNullOrEmpty(bean)){
			param.put("year", year);
			param.put("month", month);
			param.put("companyId", bean.getCompanyId());
			param.put("departmentId", bean.getDepartmentId());
			param.put("plateId", bean.getPlateId());
			
			bdao.clear();
			BaseSalaryOfBonus bbean  = new BaseSalaryOfBonus();
			bbean.setDataFromMap(param);
			bdao.setDataFromBase(bbean);
			if(!bdao.isPrimaryKeyNull()){//主键id不为空的话则更新,为空插入数据
				bdao.update();
			}else{
				bdao.save();
			}
		}
		
		return null;
	}
	
	
	/**
	 * 薪资总表数据推送
	 * @param param
	 * @return
	 * @throws Exception 
	 */
	public String onSalaryTotalPush(Map<String, Object> param) throws Exception{
    	ThreadConnection.beginTransaction();
    	//获取年月份
    	int year = BaseHelpUtils.getIntValue(param, "year");
    	int month = BaseHelpUtils.getIntValue(param, "month");
    	if(year == 0 || month == 0){
    		throw new SQLException("操作异常:年月份不可为空");
    	}
    	//默认为预提
    	commonSalaryTotalPush(year, month, 1);
    	ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0, "");
    }
	
	/**
	 * 推送的公用方法
	 * @param year
	 * @param month
	 * @param type;1:预提;2:已审;3:调整
	 * @throws Exception 
	 */
	public void commonSalaryTotalPush(int year,int month,int type) throws Exception{
    	if(year == 0 || month == 0 || type == 0){
    		throw new SQLException("操作异常:年月份不可为空");
    	}
    	//工资薪酬记录表
		SalaryTotalRecord strDao = new SalaryTotalRecord();
		BaseSalaryTotalRecord strBean = null;
		//获取公司列表数据集
		CompanyRecord crDao = new CompanyRecord();
		crDao.setConditionIsEnabled("=",Boolean.TRUE);
		List<BaseCompanyRecord> crList = crDao.conditionalLoad();
    	if(type == 3){//工资调整
    		if(!BaseHelpUtils.isNullOrEmpty(crList) && crList.size() > 0){
    			strDao.clear();
				strDao.setConditionYear("=",year);
				strDao.setConditionMonth("=",month);
				strDao.setConditionType("=",type);
				if(strDao.countRows() > 0){
					strDao.conditionalDelete();
				}
    			for(BaseCompanyRecord crBean : crList){
    				//获取公司ID
    				int companyId = BaseHelpUtils.getIntValue(crBean.getCompanyRecordId());
    				//获取该公司下的各事业部的调整数据集
    				ConditionOnLoadSalaryPaymentChange condition = new ConditionOnLoadSalaryPaymentChange();
    				condition.setCompanyId(companyId);
    				condition.setYear(year);
    				condition.setMonth(month);
    				QueryOnLoadSalaryPaymentChange dao = new QueryOnLoadSalaryPaymentChange();
    				BaseCollection<BaseOnLoadSalaryPaymentChange> result = dao.executeQuery(null, condition);
    				if(!BaseHelpUtils.isNullOrEmpty(result)){
    					List<BaseOnLoadSalaryPaymentChange> list = result.getCollections();
    					if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
    						for(BaseOnLoadSalaryPaymentChange e : list){
    							strBean = new BaseSalaryTotalRecord();
    							strBean.setDataFromJSON(e.toJSON());
    							strBean.setCompanyId(companyId);
    							strBean.setType(type);
    							strBean.setYear(year);
    							strBean.setMonth(month);
    							strDao.clear();
    							strDao.setDataFromBase(strBean);
    							strDao.save();
    						}
    					}
    				}
    			}
    		}
    	}else{//预提和已审
    		if(!BaseHelpUtils.isNullOrEmpty(crList) && crList.size() > 0){
    			//加载五险一金的5项保险数据
    			ConditionFiveinsuranceSummaryPlate fiveCon = new ConditionFiveinsuranceSummaryPlate();
    			fiveCon.setYear(year);
    			fiveCon.setStartMonth(month);
    			fiveCon.setEndMonth(month);
    			QueryFiveinsuranceSummaryPlate fiveDao = new QueryFiveinsuranceSummaryPlate();
    			//工资表数据集
    			ConditionOnSalaryReportByPlate condition = new ConditionOnSalaryReportByPlate();
    			condition.setYear(year);
    			condition.setMonth(month);
    			QueryOnSalaryReportByPlate dao = new QueryOnSalaryReportByPlate();
    			for(BaseCompanyRecord crBean : crList){
    				//获取公司ID
    				int companyId = BaseHelpUtils.getIntValue(crBean.getCompanyRecordId());
    				//加载该公司下的业务部门的5项保险数据
    				fiveCon.setCompanyId(companyId);
    				BaseCollection<BaseFiveinsuranceSummaryPlate> fiveResult = fiveDao.executeQuery(null,fiveCon);
    				//定义map来存放该公司下的每个业务部门的数据集
    				Map<Integer,BaseFiveinsuranceSummaryPlate> fiveMap = new HashMap<>();
    				if(!BaseHelpUtils.isNullOrEmpty(fiveResult)){
    					List<BaseFiveinsuranceSummaryPlate> fiveList = fiveResult.getCollections();
    					if(!BaseHelpUtils.isNullOrEmpty(fiveList) && fiveList.size() > 0){
    						for(BaseFiveinsuranceSummaryPlate e : fiveList){
    							//获取业务部门
    							int plateId = BaseHelpUtils.getIntValue(e.getPlateId());
    							fiveMap.put(plateId,e);
    						}
    					}
    				}
    				//根据公司ID、年份和月份加载工资总表数据，并保存至工资薪酬记录表中
    				condition.setCompanyId(companyId);
    				BaseCollection<BaseOnSalaryReportByPlate> result = dao.executeQuery(null, condition);
    				if(!BaseHelpUtils.isNullOrEmpty(result)){
    					List<BaseOnSalaryReportByPlate> resultList = result.getCollections();
    					if(!BaseHelpUtils.isNullOrEmpty(resultList) && resultList.size() > 0){
    						for(BaseOnSalaryReportByPlate e : resultList){
    							//获取业务部门
    							int plateId = BaseHelpUtils.getIntValue(e.getPlateId());
    							strBean = new BaseSalaryTotalRecord();
    							strBean.setDataFromJSON(e.toJSON());
    							strBean.setCompanyId(companyId);
    							strBean.setType(type);
    							strBean.setYear(year);
    							strBean.setMonth(month);
    							//设置五险一金的5项代扣社保数据
    							BaseFiveinsuranceSummaryPlate fiveBean = fiveMap.get(plateId);
    							BigDecimal personalPension = BigDecimal.ZERO;
    							BigDecimal personalMedicalInsurance = BigDecimal.ZERO;
    							BigDecimal personalUnemploymentInsurance = BigDecimal.ZERO;
    							BigDecimal personalLargeMedicalInsurance = BigDecimal.ZERO;
    							BigDecimal personalHeating = BigDecimal.ZERO;
    							if(!BaseHelpUtils.isNullOrEmpty(fiveBean)){
    								personalPension = fiveBean.getPersonalPension()==null?BigDecimal.ZERO:fiveBean.getPersonalPension();
    								personalMedicalInsurance = fiveBean.getPersonalMedicalInsurance()==null?BigDecimal.ZERO:fiveBean.getPersonalMedicalInsurance();
    								personalUnemploymentInsurance = fiveBean.getPersonalUnemploymentInsurance()==null?BigDecimal.ZERO:fiveBean.getPersonalUnemploymentInsurance();
    								personalLargeMedicalInsurance = fiveBean.getPersonalLargeMedicalInsurance()==null?BigDecimal.ZERO:fiveBean.getPersonalLargeMedicalInsurance();
    								personalHeating = fiveBean.getPersonalHeating()==null?BigDecimal.ZERO:fiveBean.getPersonalHeating();
    								personalLargeMedicalInsurance = personalLargeMedicalInsurance.add(fiveBean.getPersonalSeriousIllInsurance()==null?BigDecimal.ZERO:fiveBean.getPersonalSeriousIllInsurance());
    							}
    							strBean.setPersonalPension(personalPension);
    							strBean.setPersonalMedicalInsurance(personalMedicalInsurance);
    							strBean.setPersonalUnemploymentInsurance(personalUnemploymentInsurance);
    							strBean.setPersonalLargeMedicalInsurance(personalLargeMedicalInsurance);
    							strBean.setPersonalHeating(personalHeating);
    							//先查询工资薪酬记录表是否已有数据，如果已有数据，则做更新操作 
    							strDao.clear();
    							strDao.setConditionCompanyId("=",companyId);
    							strDao.setConditionYear("=",year);
    							strDao.setConditionMonth("=",month);
    							strDao.setConditionType("=",type);
    							strDao.setConditionPlateId("=",plateId);
    							strDao.setDataFromBase(strBean);
    							if(strDao.countRows() > 0){//说明已有数据存在，则做更新处理
    								strDao.conditionalUpdate();
    							}else{//没有数据,则做插入
    								strDao.save();
    							}
    						}
    					}
    				}else{
    					strDao.clear();
    					strDao.setConditionCompanyId("=",companyId);
    					strDao.setConditionYear("=",year);
    					strDao.setConditionMonth("=",month);
    					strDao.setConditionType("=",type);
    					if(strDao.countRows() > 0){
    						strDao.conditionalDelete();
    					}
    				}
    			}
    		}
    		
    	}
    }
	
	/**
     * 修改工资表员工的公司部门 连带修改 五险一金，员工绩效，奖金
     * @param param
     * @return
     * @throws SQLException 
     */
	private String onEditCompanyDepartment(Map<String, Object> param) throws SQLException {
		int year = BaseHelpUtils.getIntValue(param.get("year"));
		int month = BaseHelpUtils.getIntValue(param.get("month"));
		int companyId = BaseHelpUtils.getIntValue(param.get("companyId"));
		int departmentId = BaseHelpUtils.getIntValue(param.get("departmentId"));
		int plateId = BaseHelpUtils.getIntValue(param.get("plateId"));
		int employeeId = BaseHelpUtils.getIntValue(param.get("employeeId"));
		
		//五险一金表
		FiveInsuranceOneGold fdao = new FiveInsuranceOneGold();
		fdao.setConditionEmployeeId("=", employeeId);
		fdao.setConditionYear("=", year);
		fdao.setConditionMonth("=", month);
		BaseFiveInsuranceOneGold fbean = fdao.executeQueryOneRow();
		if(!BaseHelpUtils.isNullOrEmpty(fbean)){
			fbean.setCompanyId(companyId);
			fbean.setDepartmentId(departmentId);
			fbean.setPlateId(plateId);
			fdao.clear();
			fdao.setDataFromBase(fbean);
			fdao.update();
		}
		
		//员工绩效表
		SalaryEmployeePerformance pdao = new SalaryEmployeePerformance();
		pdao.setConditionEmployeeId("=", employeeId);
		pdao.setConditionYear("=", year);
		pdao.setConditionMonth("=", month);
		BaseSalaryEmployeePerformance pbean = pdao.executeQueryOneRow();
		if(!BaseHelpUtils.isNullOrEmpty(pbean)){
			pbean.setCompanyId(companyId);
			pbean.setDepartmentId(departmentId);
			pbean.setPlateId(plateId);
			pdao.clear();
			pdao.setDataFromBase(pbean);
			pdao.update();
		}
		
		//奖金表
		SalaryOfBonus bdao = new SalaryOfBonus();
		bdao.setConditionEmployeeId("=", employeeId);
		bdao.setConditionYear("=", year);
		bdao.setConditionMonth("=", month);
		List<BaseSalaryOfBonus> list = bdao.conditionalLoad();
		if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
			for(BaseSalaryOfBonus e : list){
				e.setCompanyId(companyId);
				e.setDepartmentId(departmentId);
				e.setPlateId(plateId);
				bdao.clear();
				bdao.setDataFromBase(e);
				bdao.update();
			}
		}
		return null;
	}
	
	
	/**
	 * 密码匹配
	 * @param param
	 * @return
	 * @throws SQLException 
	 * @throws UnsupportedEncodingException 
	 */
	public String onComparePassword(Map<String, Object> param) throws SQLException, UnsupportedEncodingException{
		int result = -1;
		//获取密码
		String password = BaseHelpUtils.getStringValue(param, "password");
		if(!BaseHelpUtils.isNullOrEmpty(password)){
			//对旧的秘钥进行加密
            DES des = new DES(DelicacyServlet.PUBLIC_KEY);
            String keyValue = des.ENC(password);
            //更新系统表中的秘钥值
            SystemConfig dao = new SystemConfig();
            dao.setSystemConfigId(StaticUtils.SYSTEM_KEY2);
            //获取老的秘钥
            if(dao.load()){
                if(keyValue.equals(BaseHelpUtils.getString(dao.getImagePath()))){
                	result = 0;
                }
            }
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(result,"");
	}
	
	/**
	 * 年终奖修改
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	private String onAnnualBonusEdit(Map<String, Object> param) throws SQLException {
		SalaryAnnualBonus dao = new SalaryAnnualBonus();
		if(!BaseHelpUtils.isNullOrEmpty(param) && param.size() > 0){
			BigDecimal yearServiceNum = BigDecimal.ZERO;
			String yearTestLevel = null;
			BigDecimal testNum = BigDecimal.ZERO;
			BigDecimal yearPerformanceBonus = BigDecimal.ZERO;
			BigDecimal programBonus = BigDecimal.ZERO;
			BigDecimal transferAccountMoney = BigDecimal.ZERO;
			BigDecimal totalPay = BigDecimal.ZERO;
			BigDecimal depositDeduct = BigDecimal.ZERO;
			BigDecimal salaryDiffDeduct = BigDecimal.ZERO;
			BigDecimal reimbursementDeduct = BigDecimal.ZERO;
			BigDecimal otherDeduct = BigDecimal.ZERO;
			BigDecimal alreadyBonus = BigDecimal.ZERO;
			BigDecimal insteadDeduct = BigDecimal.ZERO;
			BigDecimal oneToThreeRest = BigDecimal.ZERO;
			BigDecimal housingSubsidy = BigDecimal.ZERO;
			BigDecimal deductPerformanceBonus = BigDecimal.ZERO;
			//年度服务系数
			yearServiceNum = BaseHelpUtils.getBigDecimalValue(param.get("yearServiceNum"));
			//年度考核等级
			yearTestLevel = BaseHelpUtils.getString(param.get("yearTestLevel"));
			//考核系数
			testNum = BaseHelpUtils.getBigDecimalValue(param.get("testNum"));
			//应发年度绩效工资
			yearPerformanceBonus = BaseHelpUtils.getBigDecimalValue(param.get("yearPerformanceBonus"));
			//应发项目奖金
			if(!BaseHelpUtils.isNullOrEmpty(param.get("programBonus"))){
				programBonus = BaseHelpUtils.getBigDecimalValue(param.get("programBonus"));
			}
			//调户押金返还
			transferAccountMoney = BaseHelpUtils.getBigDecimalValue(param.get("transferAccountMoney"));
			//调户押金扣除(减)
			depositDeduct = BaseHelpUtils.getBigDecimalValue(param.get("depositDeduct"));
			//补/扣工资差额
			salaryDiffDeduct = BaseHelpUtils.getBigDecimalValue(param.get("salaryDiffDeduct"));
			//报销扣款
			reimbursementDeduct = BaseHelpUtils.getBigDecimalValue(param.get("reimbursementDeduct"));
			//其他扣款
			otherDeduct = BaseHelpUtils.getBigDecimalValue(param.get("otherDeduct"));
			//已发奖金
			alreadyBonus = BaseHelpUtils.getBigDecimalValue(param.get("alreadyBonus"));
			//代扣款项
			insteadDeduct = BaseHelpUtils.getBigDecimalValue(param.get("insteadDeduct"));
			//1-3季度剩余奖金
			oneToThreeRest = BaseHelpUtils.getBigDecimalValue(param.get("oneToThreeRest"));
			//住房补贴
			housingSubsidy = BaseHelpUtils.getBigDecimalValue(param.get("housingSubsidy"));
			//年度绩效扣款
			deductPerformanceBonus = BaseHelpUtils.getBigDecimalValue(param.get("deductPerformanceBonus"));
			//13薪
			BigDecimal thirteenBonus = totalPay.multiply(yearServiceNum).multiply(testNum);
			//应发合计=应发13薪奖金+应发年度绩效工资+应发项目奖金+补/扣工资差额+调户押金返还-调户押金扣除-报销扣款-其他扣款
			/*BigDecimal shouldTotal = thirteenBonus.add(yearPerformanceBonus).add(programBonus).add(salaryDiffDeduct).add(transferAccountMoney)
			.subtract(depositDeduct).subtract(reimbursementDeduct).subtract(otherDeduct);*/
			
			//应发合计=1-3季度剩余奖金+本次应发奖金+年度绩效工资+住房补贴+调户押金返还+汇率工资差额-年度绩效扣款-调户押金扣除-报销扣款-其他扣款--New
			BigDecimal shouldTotal = oneToThreeRest.add(programBonus).add(yearPerformanceBonus).add(housingSubsidy).add(transferAccountMoney).add(salaryDiffDeduct)
					.subtract(deductPerformanceBonus).subtract(depositDeduct).subtract(reimbursementDeduct).subtract(otherDeduct);
			//应纳税所得=应发合计+已发奖金
			BigDecimal shouldTaxAchieve = shouldTotal.add(alreadyBonus);
			//全薪
			if(!BaseHelpUtils.isNullOrEmpty(param.get("totalPay"))){
				totalPay = BaseHelpUtils.getBigDecimalValue(param.get("totalPay"));
			}
			//应纳个税
//			BigDecimal shouldTax = BaseHelpUtils.getBigDecimalValue(param.get("shouldTax"));
		  /*应纳税所得/12，小于等于3000时，0.03
			应纳税所得/12，小于等于12000时，0.1-210
			应纳税所得/12，小于等于25000时，0.2-1410
			应纳税所得/12，小于等于35000时，0.25-2660
			应纳税所得/12，小于等于55000时，0.3-4410
			应纳税所得/12，小于等于80000时，0.35-7160
			应纳税所得/12，大于80000时，0.45-15160*/
			BigDecimal shouldTax = BigDecimal.ZERO;
			BigDecimal forCompare = shouldTaxAchieve.divide(new BigDecimal("12"),2);  //  应纳税所得 /12 
			if(forCompare.compareTo(new BigDecimal("80000")) > 0){ //forCompare>80000时 ，shouldTaxAchieve*0.45-13505
				shouldTax = shouldTaxAchieve.multiply(new BigDecimal("0.45")).subtract(new BigDecimal("15160"));
			}else if(forCompare.compareTo(new BigDecimal("55000")) > 0){//forCompare>55000时 ，shouldTaxAchieve*0.35-5505
				shouldTax = shouldTaxAchieve.multiply(new BigDecimal("0.35")).subtract(new BigDecimal("7160"));
			}else if(forCompare.compareTo(new BigDecimal("35000")) > 0){//forCompare>35000时 ，shouldTaxAchieve*0.3-2755
				shouldTax = shouldTaxAchieve.multiply(new BigDecimal("0.3")).subtract(new BigDecimal("4410"));
			}else if(forCompare.compareTo(new BigDecimal("25000")) > 0){//forCompare>9000时 ，shouldTaxAchieve*0.25-1005
				shouldTax = shouldTaxAchieve.multiply(new BigDecimal("0.25")).subtract(new BigDecimal("2660"));
			}else if(forCompare.compareTo(new BigDecimal("12000")) > 0){//forCompare>4500时 ，shouldTaxAchieve*0.2-555
				shouldTax = shouldTaxAchieve.multiply(new BigDecimal("0.2")).subtract(new BigDecimal("1410"));
			}else if(forCompare.compareTo(new BigDecimal("3000")) > 0){//forCompare>1500时 ，shouldTaxAchieve*0.1-105
				shouldTax = shouldTaxAchieve.multiply(new BigDecimal("0.1")).subtract(new BigDecimal("210"));
			}else if(forCompare.compareTo(new BigDecimal("3000")) <= 0){//forCompare<=1500时 ，shouldTaxAchieve*0.03
				shouldTax = shouldTaxAchieve.multiply(new BigDecimal("0.03"));
			}
			//实发奖金
			BigDecimal factBonus = BaseHelpUtils.getDecimal(shouldTotal.subtract(shouldTax).subtract(insteadDeduct),2);
			shouldTax = BaseHelpUtils.getDecimal(shouldTax,2);
			
			
			
			int employeeId = BaseHelpUtils.getIntValue(param.get("employeeId"));
			int year = BaseHelpUtils.getIntValue(param.get("year"));
			dao.setConditionEmployeeId("=", employeeId);
			dao.setConditionYear("=", year);
			BaseSalaryAnnualBonus bean = dao.executeQueryOneRow();
			if(!BaseHelpUtils.isNullOrEmpty(bean)){
				dao.setDataFromBase(bean);
				dao.clearModifiedFlags();
				dao.setYearServiceNum(yearServiceNum);
				dao.setYearTestLevel(yearTestLevel);
				dao.setTestNum(testNum);
				dao.setThirteenBonus(BaseHelpUtils.getString(thirteenBonus));
				dao.setYearPerformanceBonus(BaseHelpUtils.getString(yearPerformanceBonus));
				dao.setProgramBonus(BaseHelpUtils.getString(programBonus));
				dao.setTransferAccountMoney(BaseHelpUtils.getString(transferAccountMoney));
				dao.setDepositDeduct(BaseHelpUtils.getString(depositDeduct));
				dao.setShouldTotal(BaseHelpUtils.getString(shouldTotal));
				dao.setShouldTax(BaseHelpUtils.getString(shouldTax));
				dao.setFactBonus(BaseHelpUtils.getString(factBonus));
				dao.setSalaryDiffDeduct(BaseHelpUtils.getString(salaryDiffDeduct));
				dao.setReimbursementDeduct(BaseHelpUtils.getString(reimbursementDeduct));
				dao.setOtherDeduct(BaseHelpUtils.getString(otherDeduct));
				dao.setAlreadyBonus(BaseHelpUtils.getString(alreadyBonus));
				dao.setShouldTaxAchieve(BaseHelpUtils.getString(shouldTaxAchieve));
				dao.setInsteadDeduct(insteadDeduct+"");
				dao.setCompanyId(BaseHelpUtils.getIntValue(param, "companyId"));
				dao.setPlateId(BaseHelpUtils.getIntValue(param, "plateId"));
				dao.setDepartmentId(BaseHelpUtils.getIntValue(param, "departmentId"));
				dao.setRemark(BaseHelpUtils.getStringValue(param, "remark"));
				dao.update();
			}
		}
		
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0,"");
	}
    
	
    /**
     * 薪资总表数据下发
     * @return
     * @throws Exception 
     * @throws SocketTimeoutException 
     * @throws ConnectTimeoutException 
     */
    public String onSalaryTotalSend(Map<String, Object> param) throws ConnectTimeoutException, SocketTimeoutException, Exception{
    	ThreadConnection.beginTransaction();
    	//获取年月份
    	int year = BaseHelpUtils.getIntValue(param, "year");
    	int month = BaseHelpUtils.getIntValue(param, "month");
    	if(year == 0 || month == 0){
    		throw new SQLException("操作异常:年月份不可为空");
    	}
    	Calendar ca = Calendar.getInstance();
    	ca.set(year, month-1, 1);
    	Date startDate = ca.getTime();
    	Date endDate = DateUtil.getLastDay(startDate);
    	//更新薪资总表数据为已下发
    	SalaryTotal stDao = new SalaryTotal();
    	stDao.setConditionYear("=",year);
    	stDao.setConditionMonth("=",month);
    	stDao.setConditionIsSended("=", Boolean.FALSE);
    	List<BaseSalaryTotal> list = stDao.conditionalLoad();
    	if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
    		stDao.setIsSended(Boolean.TRUE);
    		stDao.conditionalUpdate();
    		//推送工资短信
    		sendMsgToEmp(year, month);
    	}
    	
    	QuerySearchCostData sQuery = new QuerySearchCostData();
    	ConditionSearchCostData sCondition = new ConditionSearchCostData();
    	BaseCollection<BaseSearchCostData> sList = null;
    	
    	//查找未下发的补发补扣，岗位补贴、离职补偿数据集,并推送到账户
    	sCondition.setYear(year);
    	sCondition.setMonth(month);
    	sList = sQuery.executeQuery(null, sCondition);
    	if(!BaseHelpUtils.isNullOrEmpty(sList) && sList.getCollections().size() > 0){
    		Department ddao = new Department();
    		for(BaseSearchCostData e : sList.getCollections()){
    			int departmentId = e.getDepartmentId();
				int type = e.getType();
				int employeeId = e.getEmployeeId();
				Date date = e.getRecordDate();
				BigDecimal totalAmount = e.getTotalAmount();
				int plateType = e.getPlateType();
				int businessId = e.getBusinessId();
				String memo = "";
				if(type == 1){
					memo = "补发补扣";
				}else if(type == 2){
					memo = "岗位补贴";
				}else if(type == 3){
					memo = "离职补偿";
				}
				String remark = String.format("人工成本(%1$s)",memo);
				if(totalAmount.compareTo(BigDecimal.ZERO) != 0){
					if(plateType == 1 || plateType == 3){//事业部和营销部入个人账户
						AccountManageProcess.onSaveEmployeeAccount(employeeId,businessId , AccountManageProcess.EMP_BT_EMPLOYEE_COST,totalAmount,date, remark, -1);
					}
//					else if(plateType == 3){//营销部入个人所属部门
//						ddao.clear(); 
//						ddao.setDepartmentId(departmentId);
//						if(ddao.load()){
//							AccountManageProcess.onSavePlateAccount(ddao.getPlateId(), businessId, AccountManageProcess.PLATE_BT_EMPLOYEE_COST, totalAmount, date, remark, -1);
//						}
//					}
				}
			}
    	}
    	
    	//更新补发补扣数据为已下发
    	SalaryFillSendDeduct sfsdDao = new SalaryFillSendDeduct();
    	sfsdDao.setConditionYear("=",year);
    	sfsdDao.setConditionMonth("=",month);
    	sfsdDao.setConditionIsSended("=", Boolean.FALSE);
    	if(sfsdDao.countRows() > 0){
    		sfsdDao.setIsSended(Boolean.TRUE);
    		sfsdDao.conditionalUpdate();
    	}
    	//更新岗位补贴数据为已下发
    	SalaryJobSubsidy sjsDao = new SalaryJobSubsidy();
    	sjsDao.setConditionYear("=",year);
    	sjsDao.setConditionMonth("=",month);
    	sjsDao.setConditionIsSended("=", Boolean.FALSE);
    	if(sjsDao.countRows() > 0){
    		sjsDao.setIsSended(Boolean.TRUE);
    		sjsDao.conditionalUpdate();
    	}
    	//更新绩效工资数据为已下发
    	SalaryEmployeePerformance sepDao = new SalaryEmployeePerformance();
    	sepDao.setConditionYear("=",year);
    	sepDao.setConditionMonth("=",month);
    	sepDao.setConditionIsSended("=", Boolean.FALSE);
    	if(sepDao.countRows() > 0){
    		sepDao.setIsSended(Boolean.TRUE);
    		sepDao.conditionalUpdate();
    	}
    	//更新应发奖金、已发奖金、其他奖金数据为已下发
    	SalaryOfBonus sobDao = new SalaryOfBonus();
    	sobDao.setConditionIsSended("=", Boolean.FALSE);
    	sobDao.addCondition(BaseSalaryOfBonus.CS_RECORD_DATE, "between", startDate,endDate);
    	if(sobDao.countRows() > 0){
    		sobDao.setIsSended(Boolean.TRUE);
    		sobDao.conditionalUpdate();
    	}
    	//更新离职补偿数据为已下发
    	SalaryLeaveSubsidy slsDao = new SalaryLeaveSubsidy();
    	slsDao.setConditionYear("=",year);
    	slsDao.setConditionMonth("=",month);
    	slsDao.setConditionIsSended("=", Boolean.FALSE);
    	if(slsDao.countRows() > 0){
    		slsDao.setIsSended(Boolean.TRUE);
    		slsDao.conditionalUpdate();
    	}
    	ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0, "");
    }
    
    /**
     * 推送工资短信给员工
     * @param year
     * @param month
     * @throws Exception 
     * @throws SocketTimeoutException 
     * @throws ConnectTimeoutException 
     */
    public  void sendMsgToEmp(int year,int month) throws ConnectTimeoutException, SocketTimeoutException, Exception {
    	QueryOnSalaryTotalData salaryTotalMonthDao = new QueryOnSalaryTotalData();
    	ConditionOnSalaryTotalData condition = new ConditionOnSalaryTotalData();
    	condition.setYear(year);
    	condition.setMonth(month);
//    	condition.setEmployeeId(2415);
    	BaseCollection<BaseOnSalaryTotalData> result = salaryTotalMonthDao.executeQuery(null, condition);
    	if(!BaseHelpUtils.isNullOrEmpty(result)){
    		List<BaseOnSalaryTotalData> list = result.getCollections();
    		//推送短信给职员
    		String splitChar = ";";
    		String content = "";
    		for(BaseOnSalaryTotalData e : list) {
    			content = String.format("%1$s年%2$s月工资明细：\r\n", year,month);
    			//获取职员id
    			int employeeId = BaseHelpUtils.getIntValue(e.getEmployeeId());
    			//获取姓名
    			String employeeName = BaseHelpUtils.getString(e.getEmployeeName());
    			content = String.format("%1$s姓名：%2$s",content,employeeName);
    			//获取基本工资
    			BigDecimal monthBasicPay = BaseHelpUtils.getBigDecimalValue(e.getMonthBasicPay());
    			if(monthBasicPay.compareTo(BigDecimal.ZERO) != 0) {
    				content = String.format("%1$s%2$s基本工资：%3$s",content,splitChar,monthBasicPay);
    			}
    			//获取工龄工资
    			BigDecimal workMoney = BaseHelpUtils.getBigDecimalValue(e.getWorkMoney());
    			if(workMoney.compareTo(BigDecimal.ZERO) != 0) {
    				content = String.format("%1$s%2$s工龄工资：%3$s",content,splitChar,workMoney);
    			}
    			//获取补发补扣
    			BigDecimal fillSendDeduct = BaseHelpUtils.getBigDecimalValue(e.getFillSendDeduct());
    			if(fillSendDeduct.compareTo(BigDecimal.ZERO) != 0) {
    				content = String.format("%1$s%2$s补发补扣：%3$s",content,splitChar,fillSendDeduct);
    			}
    			//获取岗位补贴
    			BigDecimal jobSubsidy = BaseHelpUtils.getBigDecimalValue(e.getJobSubsidy());
    			if(jobSubsidy.compareTo(BigDecimal.ZERO) != 0) {
    				content = String.format("%1$s%2$s岗位补贴：%3$s",content,splitChar,jobSubsidy);
    			}
    			//获取考勤扣款
    			BigDecimal attendanceDeduct = BaseHelpUtils.getBigDecimalValue(e.getAttendanceDeduct());
    			if(attendanceDeduct.compareTo(BigDecimal.ZERO) != 0) {
    				content = String.format("%1$s%2$s考勤扣款：%3$s",content,splitChar,attendanceDeduct);
    			}
    			//获取绩效工资
    			BigDecimal performancePay = BaseHelpUtils.getBigDecimalValue(e.getPerformancePay());
    			if(performancePay.compareTo(BigDecimal.ZERO) != 0) {
    				content = String.format("%1$s%2$s绩效工资：%3$s",content,splitChar,performancePay);
    			}
    			//获取应发工资
    			BigDecimal shouldSalary = BaseHelpUtils.getBigDecimalValue(e.getShouldSalary());
    			if(shouldSalary.compareTo(BigDecimal.ZERO) != 0) {
    				content = String.format("%1$s%2$s应发工资：%3$s",content,splitChar,shouldSalary);
    			}
    			//获取应发奖金
    			BigDecimal shouldBonus = BaseHelpUtils.getBigDecimalValue(e.getShouldBonus());
    			if(shouldBonus.compareTo(BigDecimal.ZERO) != 0) {
    				content = String.format("%1$s%2$s应发奖金：%3$s",content,splitChar,shouldBonus);
    			}
    			//获取应发合计
    			BigDecimal shouldTotal = BaseHelpUtils.getBigDecimalValue(e.getShouldTotal());
    			if(shouldTotal.compareTo(BigDecimal.ZERO) != 0) {
    				content = String.format("%1$s%2$s应发合计：%3$s",content,splitChar,shouldTotal);
    			}
    			//获取已发奖金
    			BigDecimal alreadyBonus = BaseHelpUtils.getBigDecimalValue(e.getAlreadyBonus());
    			if(alreadyBonus.compareTo(BigDecimal.ZERO) != 0) {
    				content = String.format("%1$s%2$s已发奖金：%3$s",content,splitChar,alreadyBonus);
    			}
    			//获取其他奖金
    			BigDecimal otherBonus = BaseHelpUtils.getBigDecimalValue(e.getOtherBonus());
    			if(otherBonus.compareTo(BigDecimal.ZERO) != 0) {
    				content = String.format("%1$s%2$s其他奖金：%3$s",content,splitChar,otherBonus);
    			}
    			//获取应纳税所得
//    			BigDecimal shouldTaxAchieve = BaseHelpUtils.getBigDecimalValue(e.getShouldTaxAchieve());
//    			if(shouldTaxAchieve.compareTo(BigDecimal.ZERO) != 0) {
//    				content = String.format("%1$s%2$s应纳税所得：%3$s",content,splitChar,shouldTaxAchieve);
//    			}
    			//获取个税总额  (累计应纳税额)
//    			BigDecimal taxTotal = BaseHelpUtils.getBigDecimalValue(e.getTaxTotal());
//    			if(taxTotal.compareTo(BigDecimal.ZERO) != 0) {
//    				content = String.format("%1$s%2$s个税总额：%3$s",content,splitChar,taxTotal);
//    			}
    			//获取已扣个税
    			BigDecimal deductTax = BaseHelpUtils.getBigDecimalValue(e.getDeductTax());
    			if(deductTax.compareTo(BigDecimal.ZERO) != 0) {
    				content = String.format("%1$s%2$s已扣个税：%3$s",content,splitChar,deductTax);
    			}
    			//获取应纳个税  (累计应补(退)税额)
    			BigDecimal shouldTax = BaseHelpUtils.getBigDecimalValue(e.getShouldTax());
    			if(shouldTax.compareTo(BigDecimal.ZERO) != 0) {
    				content = String.format("%1$s%2$s累计应补(退)税额：%3$s",content,splitChar,shouldTax);
    			}
    			//获取社保
    			BigDecimal totalInsurance = BaseHelpUtils.getBigDecimalValue(e.getTotalInsurance());
    			if(totalInsurance.compareTo(BigDecimal.ZERO) != 0) {
    				content = String.format("%1$s%2$s社保：%3$s",content,splitChar,totalInsurance);
    			}
    			//获取公积金
    			BigDecimal totalFund = BaseHelpUtils.getBigDecimalValue(e.getTotalFund());
    			if(totalFund.compareTo(BigDecimal.ZERO) != 0) {
    				content = String.format("%1$s%2$s公积金：%3$s",content,splitChar,totalFund);
    			}
    			//获取专项附加扣除
    			BigDecimal specialAdditionalDuduct = BaseHelpUtils.getBigDecimalValue(e.getSpecialAdditionalDuduct());
    			if(specialAdditionalDuduct.compareTo(BigDecimal.ZERO) != 0) {
    				content = String.format("%1$s%2$s专项附加扣除：%3$s",content,splitChar,specialAdditionalDuduct);
    			}
    			//获取离职补偿不扣税
    			BigDecimal leaveNoDeductTax = BaseHelpUtils.getBigDecimalValue(e.getLeaveNoDeductTax());
    			if(leaveNoDeductTax.compareTo(BigDecimal.ZERO) != 0) {
    				content = String.format("%1$s%2$s离职补偿不扣税：%3$s",content,splitChar,leaveNoDeductTax);
    			}
    			//获取离职补偿扣税
    			BigDecimal leaveDeductTax = BaseHelpUtils.getBigDecimalValue(e.getLeaveDeductTax());
    			if(leaveDeductTax.compareTo(BigDecimal.ZERO) != 0) {
    				content = String.format("%1$s%2$s离职补偿扣税：%3$s",content,splitChar,leaveDeductTax);
    			}
    			//获取代扣款项
    			BigDecimal insteadDeduct = BaseHelpUtils.getBigDecimalValue(e.getInsteadDeduct());
    			if(insteadDeduct.compareTo(BigDecimal.ZERO) != 0) {
    				content = String.format("%1$s%2$s代扣款项：%3$s",content,splitChar,insteadDeduct);
    			}
    			//获取重疾险
    			BigDecimal insteadDeductIll = BaseHelpUtils.getBigDecimalValue(e.getInsteadDeductIll());
    			if(insteadDeductIll.compareTo(BigDecimal.ZERO) != 0) {
    				content = String.format("%1$s%2$s重疾险：%3$s",content,splitChar,insteadDeductIll);
    			}
    			//获取暂扣奖金
    			BigDecimal suspendBonus = BaseHelpUtils.getBigDecimalValue(e.getSuspendBonus());
    			if(suspendBonus.compareTo(BigDecimal.ZERO) != 0) {
    				content = String.format("%1$s%2$s暂扣奖金：%3$s",content,splitChar,suspendBonus);
    			}
    			//获取应补退税
    			BigDecimal replacementTax = BaseHelpUtils.getBigDecimalValue(e.getReplacementTax());
    			content = String.format("%1$s%2$s应补退税：%3$s",content,splitChar,replacementTax);
    			//获取实付工资
    			BigDecimal factSalary = BaseHelpUtils.getBigDecimalValue(e.getFactSalary());
    			content = String.format("%1$s%2$s实付工资：%3$s",content,splitChar,factSalary);
    			content = String.format("%1$s。如有疑问请联系人资部陈彩。",content);
    			//获取离职日期
    			Date resignationDate = e.getResignationDate();
    			//如果离职日期不为空，说明离职，则手机短信通知，否则在职，企业微信通知
    			if(!BaseHelpUtils.isNullOrEmpty(resignationDate)) {
    				OnTelMobile.onTelMobileSendMeg(employeeId, content);
    			}else {
    				ERPWeixinUtils.sendWXMsgToUser(employeeId,content);
    			}
    		}
    	}
    }
    
    /**
     * 薪资总表计算
     * @param param
     * @return
     * @throws SQLException
     * @throws ParseException 
     * @throws  
     */
    public static String onSalaryTotalAccount(Map<String, Object> param) throws SQLException, ParseException, InterruptedException{
    	
    	Calendar cal =Calendar.getInstance();
    	
    	//获取年月份
    	int year = BaseHelpUtils.getIntValue(param, "year");
    	int month = BaseHelpUtils.getIntValue(param, "month");
    	int _employeeId = BaseHelpUtils.getIntValue(param, "employeeId");
    	
    	if(year == 0 || month == 0){
    		throw new SQLException("操作异常:年月份不可为空");
    	}
    	//检索判断当前年月的数据是否已发放，如果已经发放则不可再进行计算
    	SalaryTotal stDao = new SalaryTotal();
    	stDao.setConditionYear("=",year);
    	stDao.setConditionMonth("=",month);
    	stDao.setConditionIsSended("=",true);
    	if(stDao.countRows() > 0){//说明当前年月份的数据已发放，不可以再进行计算
    		throw new SQLException("当前年月数据已发放，不可再进行计算");
    	}
    	//加载劳务报酬人员数据集
    	Map<Integer,Integer> laborMap = new HashMap<>();
    	LaborPaymentEmployee lpeDao = new LaborPaymentEmployee();
    	lpeDao.setConditionYear("=",year);
    	lpeDao.setConditionMonth("=",month);
    	List<BaseLaborPaymentEmployee> lpeList = lpeDao.conditionalLoad();
    	if(!BaseHelpUtils.isNullOrEmpty(lpeList) && lpeList.size() > 0) {
    		for(BaseLaborPaymentEmployee e : lpeList) {
    			//获取人员id
    			int empId = BaseHelpUtils.getIntValue(e.getEmployeeId());
    			laborMap.put(empId, empId);
    		}
    	}
    	//加载薪资总表数据集
    	QueryOnLoadSalaryTotalMonthData salaryTotalMonthDao = new QueryOnLoadSalaryTotalMonthData();
    	ConditionOnLoadSalaryTotalMonthData condition = new ConditionOnLoadSalaryTotalMonthData();
    	condition.setYear(year);
    	condition.setMonth(month);
    	if(_employeeId>0) {
    		condition.setEmployeeId(_employeeId);
    	}
    	BaseCollection<BaseOnLoadSalaryTotalMonthData> result = salaryTotalMonthDao.executeQuery(null, condition);
    	if(!BaseHelpUtils.isNullOrEmpty(result)){
    		//加载上一个月的募投项目和募投比例
    		stDao.clear();
    		stDao.unsetSelectFlags();
    		if(month == 1){
    			stDao.setConditionYear("=",year-1);
    			stDao.setConditionMonth("=",12);
    		}else{
    			stDao.setConditionYear("=",year);
    			stDao.setConditionMonth("=",month-1);
    		}
    		
    		stDao.setSelectVoteProject(true);
        	stDao.setSelectVotePercent(true);
        	stDao.setSelectEmployeeId(true);
        	List<BaseSalaryTotal> lastList = stDao.conditionalLoad();
        	//定义map来存在每一个人在上一个月的募投项目和募投比例
        	Map<Integer,BaseSalaryTotal> map = new HashMap<>();
        	if(!BaseHelpUtils.isNullOrEmpty(lastList) && lastList.size() > 0){
        		for(BaseSalaryTotal e : lastList){
        			map.put(e.getEmployeeId(),e);
        		}
        	}
    		BaseSalaryTotal stBean =null;
    		List<BaseOnLoadSalaryTotalMonthData> list = result.getCollections();
    		PlateDepartment pdDao = new PlateDepartment();
    		
			int _year =year;
			int _month =month;
			String[] split = START_DATE.split("-");
			if(split.length>=2) {
				int intValue = BaseHelpUtils.getIntValue(split[0]);
				if(month==intValue) {
					 _year =year+1;
	    			 _month =1;
				}else {
					 _month+=1;
				}
			} else {
				throw new SQLException("系统配置时间范围 START_DATE加载失败");
			}
    		
    		for(BaseOnLoadSalaryTotalMonthData e : list){
    			int departmentId = BaseHelpUtils.getIntValue(e.getDepartmentId());
    			//根据当前员工归属的部门去查找关联的业务部门Id
				pdDao.clear();
				pdDao.setConditionDepartmentId("=",departmentId);
				BasePlateDepartment pdBean = pdDao.executeQueryOneRow();
    			stBean = new BaseSalaryTotal();
    			stBean.setYear(year);
    			stBean.setMonth(month);
    			stBean.setEmployeeNo(e.getEmployeeNo());
    			stBean.setEmployeeName(e.getEmployeeName());
    			stBean.setBankAccount(e.getBankAccount());
    			stBean.setPlateId(pdBean==null?e.getPlateId():pdBean.getPlateId());
    			stBean.setDepartmentId(e.getDepartmentId());
    			stBean.setCompanyId(e.getCompanyId());
    			stBean.setCostAttribution(e.getCostAttribution());
    			//职员ID
    			int employeeId = e.getEmployeeId();
    			stBean.setEmployeeId(employeeId);
    			
    			//计算当前员工当前年度的专项扣除总和
    			SpecialDeductionMonthDetail sdmdDao =new SpecialDeductionMonthDetail();
    			sdmdDao.setConditionEmployeeId("=", employeeId);
    			sdmdDao.setConditionYear("=", year+"");
    			sdmdDao.setConditionMonth("=", month+"");
    			BaseSpecialDeductionMonthDetail baseSpecialDeductionMonthDetail = sdmdDao.executeQueryOneRow();
    			BigDecimal specialDeductionSum =BigDecimal.ZERO;
    			if(!BaseHelpUtils.isNullOrEmpty(baseSpecialDeductionMonthDetail)) {
    				specialDeductionSum=BaseHelpUtils.getBigDecimalValue(baseSpecialDeductionMonthDetail.getAmount());
    			}
    			//当月未发的其他扣除
    			BigDecimal otherDedution = BigDecimal.ZERO;
    			QueryOnOtherDeductionData  queryOnOtherDeductionData  =new QueryOnOtherDeductionData();
    			ConditionOnOtherDeductionData conditionOnOtherDeductionData =new ConditionOnOtherDeductionData();
    			conditionOnOtherDeductionData.setYear(year);
    			conditionOnOtherDeductionData.setMonth(month);
    			conditionOnOtherDeductionData.setEmployeeId(employeeId);
    			conditionOnOtherDeductionData.setIsSended(false);
    			BaseCollection<BaseOnOtherDeductionData> OnOtherDeductionData = queryOnOtherDeductionData.executeQuery(null, conditionOnOtherDeductionData);
    			if(null!=OnOtherDeductionData&&OnOtherDeductionData.getCollections().size()>0) {
    				List<BaseOnOtherDeductionData> collections = OnOtherDeductionData.getCollections();
    				for (BaseOnOtherDeductionData baseOnOtherDeductionData : collections) {
    					otherDedution=otherDedution.add(BaseHelpUtils.getBigDecimalValue(baseOnOtherDeductionData.getOtherDeduction()));
					}
    			}
    			
    			//获取该员工在上一个月的募投项目和比例
    			BaseSalaryTotal lastBean = map.get(employeeId);
    			if(!BaseHelpUtils.isNullOrEmpty(lastBean)){
    				stBean.setVoteProject(lastBean.getVoteProject());
    				stBean.setVotePercent(lastBean.getVotePercent());
    			}
    			//基本工资
    			BigDecimal monthBasicPay = BaseHelpUtils.getBigDecimalValue(e.getMonthBasicPay());
    			stBean.setMonthBasicPay(monthBasicPay.setScale(2)+"");
    			//工龄工资
    			BigDecimal workMoney = BaseHelpUtils.getBigDecimalValue(e.getWorkMoney());
    			stBean.setWorkMoney(workMoney.setScale(2)+"");
    			//补发补扣
    			BigDecimal fillSendDeduct = BaseHelpUtils.getBigDecimalValue(e.getFillSendDeduct());
    			stBean.setFillSendDeduct(fillSendDeduct.setScale(2)+"");
    			//岗位补贴
    			BigDecimal jobSubsidy = BaseHelpUtils.getBigDecimalValue(e.getJobSubsidy());
    			stBean.setJobSubsidy(jobSubsidy.setScale(2)+"");
    			//考勤扣款
    			BigDecimal attendanceDeduct = BaseHelpUtils.getBigDecimalValue(e.getAttendanceDeduct());
    			stBean.setAttendanceDeduct(attendanceDeduct.setScale(2)+"");
    			//绩效工资
    			BigDecimal performancePay = BaseHelpUtils.getBigDecimalValue(e.getPerformancePay());
    			stBean.setPerformancePay(performancePay+"");
    			//应发工资=基本工资+工龄工资+补发补扣+岗位补贴+扣病事假迟到+绩效工资
    			BigDecimal shouldSalary = monthBasicPay.add(workMoney).add(fillSendDeduct).add(jobSubsidy).add(attendanceDeduct).add(performancePay);
    			stBean.setShouldSalary(shouldSalary.setScale(2)+"");
    			//应发奖金
    			BigDecimal shouldBonus = BaseHelpUtils.getBigDecimalValue(e.getShouldBonus());
    			stBean.setShouldBonus(shouldBonus.setScale(2)+"");
    			//应发合计=应发工资+应发奖金
    			BigDecimal shouldTotal = shouldSalary.add(shouldBonus);
    			stBean.setShouldTotal(shouldTotal.setScale(2)+"");
    			//已发奖金
    			BigDecimal alreadyBonus = BaseHelpUtils.getBigDecimalValue(e.getAlreadyBonus());
    			stBean.setAlreadyBonus(alreadyBonus.setScale(2)+"");
    			//其他奖金
    			BigDecimal otherBonus = BaseHelpUtils.getBigDecimalValue(e.getOtherBonus());
    			stBean.setOtherBonus(otherBonus.setScale(2)+"");
    			/**
    			 * 个税起征点-工资薪资:个税起征点=5000
    			 * 个税起征点-劳务报酬:个税起征点根据应发合计数计算，应发合计<=4000,起征点=800;应发合计>4000,起征点=应发合计*20%
    			 */
    			BigDecimal taxBegin = BigDecimal.ZERO;
    			if(laborMap.containsKey(employeeId)) {//说明是按劳务报酬来算
    				stBean.setSalaryTypeName("劳务报酬");
    				if(shouldTotal.compareTo(new BigDecimal(4000)) > 0) {
    					taxBegin = shouldTotal.multiply(new BigDecimal("0.2")).divide(BigDecimal.ONE, 2,BigDecimal.ROUND_HALF_UP);
    				}else {
    					taxBegin = new BigDecimal(800);
    				}
    			}else {
    				taxBegin = new BigDecimal(5000);
    				stBean.setSalaryTypeName("工资薪金");
    			}
    			stBean.setTaxBegin(taxBegin);
    			//个人社保
    			BigDecimal totalInsurance = e.getTotalInsurance()==null?BigDecimal.ZERO:(e.getTotalInsurance().divide(BigDecimal.ONE, 2,BigDecimal.ROUND_HALF_UP));
    			stBean.setTotalInsurance(totalInsurance.setScale(2)+"");
    			//养老保险（个人）
    			stBean.setPersonalPension(e.getPersonalPension());
    			//医疗保险（个人）
    			stBean.setPersonalMedicalInsurance(e.getPersonalMedicalInsurance());
    			//大额医疗保险（个人）
    			stBean.setPersonalLargeMedicalInsurance(e.getPersonalLargeMedicalInsurance());
    			//失业保险（个人）
    			stBean.setPersonalUnemploymentInsurance(e.getPersonalUnemploymentInsurance());
    			//采暖（个人）
    			stBean.setPersonalHeating(e.getPersonalHeating());
    			//大病医疗保险（个人）
    			stBean.setPersonalSeriousIllInsurance(e.getPersonalSeriousIllInsurance());
    			//个人公积金   
    			BigDecimal totalFund = BaseHelpUtils.getBigDecimalValue(e.getTotalFund());
    			stBean.setTotalFund(totalFund.setScale(2)+"");
    			//单位社保
    			BigDecimal unitTotalInsurance = e.getUnitTotalInsurance()==null?BigDecimal.ZERO:(e.getUnitTotalInsurance().divide(BigDecimal.ONE, 2,BigDecimal.ROUND_HALF_UP));
    			stBean.setUnitTotalInsurance(unitTotalInsurance.setScale(2)+"");
    			//单位公积金
    			BigDecimal unitTotalFund = BaseHelpUtils.getBigDecimalValue(e.getUnitTotalFund());
    			stBean.setUnitTotalFund(unitTotalFund.setScale(2)+"");
    			//离职补偿不扣税
    			BigDecimal leaveNoDeductTax = BaseHelpUtils.getBigDecimalValue(e.getLeaveNoDeductTax());
    			stBean.setLeaveNoDeductTax(leaveNoDeductTax.setScale(2)+"");
    			//离职补偿扣税
    			BigDecimal leaveDeductTax = BaseHelpUtils.getBigDecimalValue(e.getLeaveDeductTax());
    			stBean.setLeaveDeductTax(leaveDeductTax.setScale(2)+"");
    			//代扣重疾
    			BigDecimal insteadDeductIll = BaseHelpUtils.getBigDecimalValue(e.getInsteadDeductIll());
    			stBean.setInsteadDeductIll(insteadDeductIll.setScale(2)+"");
    			//专项附加扣除总和
    			stBean.setSpecialAdditionalDuduct(specialDeductionSum);
    			//应纳税所得=应发合计+已发奖金+其他奖金+离职补偿扣税-个税起征点-个人社保-个人公积金-重疾险-其他扣除
    			BigDecimal shouldTaxAchieve = shouldTotal.add(alreadyBonus).add(otherBonus).add(leaveDeductTax).subtract(taxBegin)
    					.subtract(totalInsurance).subtract(totalFund).subtract(insteadDeductIll).subtract(specialDeductionSum).subtract(otherDedution);
    			
    			//2019-05-08  彩姐姐说最小值可为负数
//    			if(shouldTaxAchieve.compareTo(BigDecimal.ZERO) < 0){
//    				shouldTaxAchieve = BigDecimal.ZERO;
//    			}
    			stBean.setShouldTaxAchieve(shouldTaxAchieve.setScale(2)+"");
    			
    			//已扣个税 保存到暂扣奖金项
    			BigDecimal deductTax = BaseHelpUtils.getBigDecimalValue(e.getDeductTax());
//    			stBean.setDeductTax(deductTax.setScale(2)+"");
    			stBean.setSuspendBonus(deductTax.setScale(2)+"");
    			
    			/***************开始计算相关的各个累计项****************/
    			//IS_STRIDE为跨年   并且 当前月为1月份则取上一年度12月份的累计预扣个税
    			
    			QueryOnSalaryTotalData qlsDao = new QueryOnSalaryTotalData();
    	    	ConditionOnSalaryTotalData qlsCondition= new ConditionOnSalaryTotalData();
    	    	
    			if(IS_STRIDE==true&&month==1) {
    				qlsCondition.setYear( year-1);
    				qlsCondition.setMonth( 12);
    			}else { //其余情况则统一求同一年度的上一月份的累计预扣个税
    				qlsCondition.setYear(year);
    				qlsCondition.setMonth(month-1);
    			}

    			//各个专项累计数
				BigDecimal specialDeductionSum1 =BigDecimal.ZERO;
				BigDecimal specialDeductionSum2 =BigDecimal.ZERO;
				BigDecimal specialDeductionSum3 =BigDecimal.ZERO;
				BigDecimal specialDeductionSum4 =BigDecimal.ZERO;
				BigDecimal specialDeductionSum5 =BigDecimal.ZERO;
				BigDecimal specialDeductionSum6 =BigDecimal.ZERO;
				//上个月的累计专项扣除
				BigDecimal specialSum =BigDecimal.ZERO;
				//上个月的累计预扣个税
    			BigDecimal lastTaxTotalSum = BigDecimal.ZERO;
    			//上个月的累计个税起征点
    			BigDecimal lastIndividualIncomeTaxSum = BigDecimal.ZERO;
    			//上个月的累计社保公积金
    			BigDecimal lastInsuranceFundSum = BigDecimal.ZERO;
    			//上个月的累计应纳税所得
    			BigDecimal lastShouldTaxAchieveSum = BigDecimal.ZERO;
    			//上个月的累计已预缴税额
    			BigDecimal lastwithholdingTaxSum = BigDecimal.ZERO;
    			//当月未发的补发个税
    			BigDecimal replacementTax = BigDecimal.ZERO;
    			//累计预扣个税
    			BigDecimal taxTotal = BigDecimal.ZERO;
    			//预扣个税
    			BigDecimal withholdingTax  = BigDecimal.ZERO;
    			//上月的累计已预缴税额
//    			BigDecimal lastTaxTotal  = BigDecimal.ZERO;
    			
    			//查询补发个税
    			QueryOnReplacementTaxData  queryOnReplacementTaxData  =new QueryOnReplacementTaxData();
    			ConditionOnReplacementTaxData conditionOnReplacementTaxData =new ConditionOnReplacementTaxData();
    			conditionOnReplacementTaxData.setYear(year);
    			conditionOnReplacementTaxData.setMonth(month);
    			conditionOnReplacementTaxData.setEmployeeId(employeeId);
    			conditionOnReplacementTaxData.setIsSended(false);
    			BaseCollection<BaseOnReplacementTaxData> onReplacementTaxData = queryOnReplacementTaxData.executeQuery(conditionOnReplacementTaxData.getKeyValues(), conditionOnReplacementTaxData);
    			if(null!=onReplacementTaxData&&onReplacementTaxData.getCollections().size()>0) {
    				List<BaseOnReplacementTaxData> collections = onReplacementTaxData.getCollections();
    				for (BaseOnReplacementTaxData baseOnReplacementTaxData : collections) {
    					replacementTax=replacementTax.add(BaseHelpUtils.getBigDecimalValue(baseOnReplacementTaxData.getReplacementTax()));
					}
    			}
    			
    				if(month!=BaseHelpUtils.getIntValue(split[0])) {
    					qlsCondition.setEmployeeId(e.getEmployeeId());
    					BaseCollection<BaseOnSalaryTotalData> collection = qlsDao.executeQuery(qlsCondition.getKeyValues(), qlsCondition);
    					if(null!= collection &&collection.getCollections().size()>0) {
    						BaseOnSalaryTotalData baseSalaryTotal = collection.getCollections().get(0);
    						//上月的累计应纳税额
	    					lastTaxTotalSum=BaseHelpUtils.getBigDecimalValue(baseSalaryTotal.getTaxTotal());
	    					//上月的累计专项附加扣除
//	    					specialSum=BaseHelpUtils.getBigDecimalValue(baseSalaryTotal.getSpecialDuductSum());
	    					//上月的累计个税起征点
	    					lastIndividualIncomeTaxSum=BaseHelpUtils.getBigDecimalValue(baseSalaryTotal.getIndividualIncomeTaxSum());
	    					//上月的累计社保公积金
	    					lastInsuranceFundSum=BaseHelpUtils.getBigDecimalValue(baseSalaryTotal.getInsuranceFundSum());
	    					//上月的累计应纳税所得
	    					lastShouldTaxAchieveSum=BaseHelpUtils.getBigDecimalValue(baseSalaryTotal.getShouldTaxAchieveSum());
	    					//上月的累计已预缴税额
	    					lastwithholdingTaxSum=BaseHelpUtils.getBigDecimalValue(baseSalaryTotal.getWithholdingTax());
	    					//上月的各个专项累计数
//	    					specialDeductionSum1 =BaseHelpUtils.getBigDecimalValue(baseSalaryTotal.getSpecialDuduct1());
//	    					specialDeductionSum2 =BaseHelpUtils.getBigDecimalValue(baseSalaryTotal.getSpecialDuduct2());
//	    					specialDeductionSum3 =BaseHelpUtils.getBigDecimalValue(baseSalaryTotal.getSpecialDuduct3());
//	    					specialDeductionSum4 =BaseHelpUtils.getBigDecimalValue(baseSalaryTotal.getSpecialDuduct4());
//	    					specialDeductionSum5 =BaseHelpUtils.getBigDecimalValue(baseSalaryTotal.getSpecialDuduct5());
//	    					specialDeductionSum6 =BaseHelpUtils.getBigDecimalValue(baseSalaryTotal.getSpecialDuduct6());
	    				}
	    			}
    			
    			/**
					累计预扣个税公式如下：		
					累计应纳税所得<=36000，累计应纳税所得*3%		
					36000<累计应纳税所得<=144000，累计应纳税所得*10%-2520		
					144000<累计应纳税所得<=300000，累计应纳税所得*20%-16920		
					300000<累计应纳税所得<=420000，累计应纳税所得*25%-31920		
					420000<累计应纳税所得<=660000，累计应纳税所得*30%-52920		
					660000<累计应纳税所得<=960000，累计应纳税所得*35%-85920		
					960000<累计应纳税所得，累计应纳税所得*45%-181920	
					
				 * 预扣个税=累计预扣个税-上月累计预扣个税-已扣个税
    			 * 
    			 * 个税总额计算-劳务报酬
    			 * 应纳税所得<20000,个税总额=应纳税所得*20%；50000>应纳税所得>=20000,个税总额=应纳税所得*30%-2000；应纳税所得>=50000,个税总额=应纳税所得*40%-7000
    			 * 
    			 */
    			if(laborMap.containsKey(employeeId)) {//说明是按劳务报酬来算
    				if(shouldTaxAchieve.compareTo(new BigDecimal(20000)) < 0) {
    					taxTotal = shouldTaxAchieve.multiply(BigDecimal.valueOf(0.2)).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
    				}else if(shouldTaxAchieve.compareTo(new BigDecimal(50000)) < 0) {
    					taxTotal = (shouldTaxAchieve.multiply(BigDecimal.valueOf(0.3)).subtract(BigDecimal.valueOf(2000))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
    				}else if(shouldTaxAchieve.compareTo(new BigDecimal(50000)) >= 0){
    					taxTotal = (shouldTaxAchieve.multiply(BigDecimal.valueOf(0.4)).subtract(BigDecimal.valueOf(7000))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
    				}
    			}else {
    				//累计应纳税所得=本月应纳税+上月累计应纳税所得
    				BigDecimal shouldTaxAchieveSum = shouldTaxAchieve.add(lastShouldTaxAchieveSum);
    				//累计预扣个税
    				if(shouldTaxAchieveSum.compareTo(BigDecimal.valueOf(36000)) <= 0){
    					taxTotal = shouldTaxAchieveSum.multiply(BigDecimal.valueOf(0.03)).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
    				}else if(shouldTaxAchieveSum.compareTo(BigDecimal.valueOf(144000)) <= 0){
    					taxTotal = (shouldTaxAchieveSum.multiply(BigDecimal.valueOf(0.1)).subtract(BigDecimal.valueOf(2520))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
    				}else if(shouldTaxAchieveSum.compareTo(BigDecimal.valueOf(300000)) <= 0){
    					taxTotal = (shouldTaxAchieveSum.multiply(BigDecimal.valueOf(0.2)).subtract(BigDecimal.valueOf(16920))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
    				}else if(shouldTaxAchieveSum.compareTo(BigDecimal.valueOf(420000)) <= 0){
    					taxTotal = (shouldTaxAchieveSum.multiply(BigDecimal.valueOf(0.25)).subtract(BigDecimal.valueOf(31920))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
    				}else if(shouldTaxAchieveSum.compareTo(BigDecimal.valueOf(660000)) <= 0){
    					taxTotal = (shouldTaxAchieveSum.multiply(BigDecimal.valueOf(0.3)).subtract(BigDecimal.valueOf(52920))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
    				}else if(shouldTaxAchieveSum.compareTo(BigDecimal.valueOf(960000)) <= 0){
    					taxTotal = (shouldTaxAchieveSum.multiply(BigDecimal.valueOf(0.35)).subtract(BigDecimal.valueOf(85920))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
    				}else if(shouldTaxAchieveSum.compareTo(BigDecimal.valueOf(960000)) > 0){
    					taxTotal = (shouldTaxAchieveSum.multiply(BigDecimal.valueOf(0.45)).subtract(BigDecimal.valueOf(181920))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
    				}
//    				withholdingTax =taxTotal.subtract(lastTaxTotalSum).subtract(deductTax);	
    				withholdingTax =taxTotal.subtract(lastTaxTotalSum);	
    			}
    			
    			//应纳个税=个税总额-已扣个税
//    			BigDecimal shouldTax = taxTotal.subtract(deductTax);
//    			stBean.setShouldTax(shouldTax+"");
    			
    			//累计已预缴纳税
    			stBean.setWithholdingTax(lastTaxTotalSum.setScale(2)+"");
    			
    			//当月未发的补发个税
    			stBean.setReplacementTax(replacementTax.setScale(2)+"");
    			
    			//当月未发的其他扣除
    			stBean.setOtherDeduction(otherDedution.setScale(2)+"");
    			
    			//累计预扣个税
    			if(taxTotal.compareTo(BigDecimal.ZERO)<=0) {
    				taxTotal=BigDecimal.ZERO;
    			}
    			stBean.setTaxTotal(taxTotal.setScale(2)+"");
    			
    			//累计应补(退)税额 可以为负数
    			if(withholdingTax.compareTo(BigDecimal.ZERO)<=0) {
    				withholdingTax=BigDecimal.ZERO;
    			}
    			stBean.setShouldTax(withholdingTax.setScale(2)+"");
    			
    			//代扣款项
    			BigDecimal insteadDeduct = BaseHelpUtils.getBigDecimalValue(e.getInsteadDeduct());
    			stBean.setInsteadDeduct(insteadDeduct.setScale(2)+"");
    			//实付工资=应发合计-应纳个税-个人社保-个人公积金+离职补偿（扣税和不扣税）+代扣款项-重疾险+暂扣奖金
    			BigDecimal factSalary = shouldTotal.subtract(withholdingTax).subtract(totalInsurance).subtract(totalFund).add(leaveNoDeductTax).add(leaveDeductTax).add(insteadDeduct).subtract(insteadDeductIll).add(replacementTax).add(BaseHelpUtils.getBigDecimalValue(stBean.getSuspendBonus()));
    			stBean.setFactSalary(factSalary.setScale(2)+"");
    		
    			//----累计纳税起征点 5000
    			stBean.setIndividualIncomeTaxSum((new BigDecimal(5000).add(lastIndividualIncomeTaxSum))+"");
    				
    			//----累计应纳税所得 
    			stBean.setShouldTaxAchieveSum((shouldTaxAchieve.add(lastShouldTaxAchieveSum)).setScale(2)+"");
    			
    			
				/*
				 * 专项扣除累计项计算规则
				 * 1.如果该员工，入职于当年度的1月1日之前，则累计项从1月份起
				 * 2.如果该员工，入职于当年度的1月1日之后，则累计项从入职月份起 
				 */
    			//入职时间
    			Date onboardDate = BaseHelpUtils.getDateValue(e.getOnboardDate());  
    			//1月1日
				cal.clear();
    			cal.set(Calendar.YEAR, _year);
    			cal.set(Calendar.MONTH, 0);
    			cal.roll(Calendar.DAY_OF_MONTH, 0);
    			Date yearStartDate = cal.getTime();
    			//12月31日
    			cal.clear();
    			cal.set(Calendar.YEAR, _year);
    			cal.set(Calendar.MONTH, 11);
    			cal.roll(Calendar.DAY_OF_MONTH, -1);
    			Date yearEndDate = cal.getTime();
    			//入职时间在本年度的1月1日之前的   计算值num从1月开始   否则从入职月开始. 
    			//并且根据_month计算当前的计算值是多少?
    			int num = 0;
				if(onboardDate.after(yearStartDate)) {
					num = DateUtil.getMonth(onboardDate);
				}
				num=_month-num;
				if(num<=0) {
					num=1;
				}
				
		    	//获取当年年度当月有效的流程通过的所有的专项扣除项
		    	QueryOnLoadSpecialDeductionYear sdy = new QueryOnLoadSpecialDeductionYear();
		    	ConditionOnLoadSpecialDeductionYear sdyCondition = new ConditionOnLoadSpecialDeductionYear();
		    	sdyCondition.setYear(_year+"");
		    	sdyCondition.setMonth(_month);
		    	sdyCondition.setEmployeeId(employeeId);
		    	sdyCondition.setIsEnable(true);
		    	KeyValuePair kv = new KeyValuePair();
		    	kv.setKey("EXTRACT ( MONTH FROM sdd.end_date ) <?");
		    	kv.setValue("1=?");
		    	KeyValuePair[] kvs = {kv};
		    	BaseCollection<BaseOnLoadSpecialDeductionYear> sdyQuery = sdy.executeQuery(kvs, sdyCondition);
		    	
		    	//获取当年年度当月之前的流程通过的所有的专项扣除项
		    	ConditionOnLoadSpecialDeductionYear sdyCondition2 = new ConditionOnLoadSpecialDeductionYear();
		    	sdyCondition2.setYear(_year+"");
		    	sdyCondition2.setEndMonth(_month);
		    	sdyCondition2.setEmployeeId(employeeId);
		    	sdyCondition2.setIsEnable(true);
		    	kv.setKey("EXTRACT ( MONTH FROM sdd.start_date ) <=? AND EXTRACT ( MONTH FROM sdd.end_date ) >=?");
		    	kv.setValue("1=? and 1=?");
		    	KeyValuePair[] kvs2 = {kv};
		    	BaseCollection<BaseOnLoadSpecialDeductionYear> sdyQuery2 = sdy.executeQuery(kvs2, sdyCondition2);
				
		    	//判断当年1月1日至当月最后一天申请得专项扣除有哪几项。
	    		boolean bool_1 =false;
	    		boolean bool_2 =false;
	    		boolean bool_3 =false;
	    		boolean bool_4 =false;
	    		boolean bool_5 =false;
	    		boolean bool_6 =false;
		    	if(!BaseHelpUtils.isNullOrEmpty(sdyQuery)&&sdyQuery.getCollections().size()>0) {
		    		List<BaseOnLoadSpecialDeductionYear> collections = sdyQuery.getCollections();
		    		for (BaseOnLoadSpecialDeductionYear baseOnLoadSpecialDeduction : collections) {
		    			//申请金额
		    			BigDecimal amount = baseOnLoadSpecialDeduction.getAmount();
		    			//专项类型
		    			Integer specialDeductionTypeId = baseOnLoadSpecialDeduction.getSpecialDeductionTypeId();
		    			if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_1) {
        					specialDeductionSum1=amount.multiply(new BigDecimal(num));
        					bool_1=true;
        				}else if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_2) {
        					specialDeductionSum2=amount.multiply(new BigDecimal(num));
        					bool_2=true;
        				}else if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_3) {
        					specialDeductionSum3=amount.multiply(new BigDecimal(num));
        					bool_3=true;
        				}else if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_4) {
        					specialDeductionSum4=amount.multiply(new BigDecimal(num));
        					bool_4=true;
        				}else if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_5) {
        					specialDeductionSum5=amount.multiply(new BigDecimal(num));
        					bool_5=true;
        				}else if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_6) {
        					specialDeductionSum6=amount.multiply(new BigDecimal(num));
        					bool_6=true;
        				}
					}
		    		//累计总和
		    		specialSum=specialDeductionSum1.add(specialDeductionSum2).add(specialDeductionSum3).add(specialDeductionSum4).add(specialDeductionSum5).add(specialDeductionSum6);
		    		
		    	}
		    	
		    	if(!BaseHelpUtils.isNullOrEmpty(sdyQuery2)&&sdyQuery2.getCollections().size()>0) {
		    		List<BaseOnLoadSpecialDeductionYear> collections2 = sdyQuery2.getCollections();
		    		for (BaseOnLoadSpecialDeductionYear baseOnLoadSpecialDeductionYear : collections2) {
		    			//专项类型
		    			Integer specialDeductionTypeId = baseOnLoadSpecialDeductionYear.getSpecialDeductionTypeId();
		    			
		    			if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_1&&bool_1==true) {
		    				continue;
		    			}else if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_2&&bool_2==true) {
		    				continue;
		    			}else if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_3&&bool_3==true) {
		    				continue;
		    			}else if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_4&&bool_4==true) {
		    				continue;
		    			}else if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_5&&bool_5==true) {
		    				continue;
		    			}else if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_6&&bool_6==true) {
		    				continue;
		    			}
		    			//申请金额
		    			BigDecimal amount = baseOnLoadSpecialDeductionYear.getAmount();
		    			//结束月份
		    			int endDateMonth = DateUtil.getMonth(BaseHelpUtils.getDateValue(baseOnLoadSpecialDeductionYear.getEndDate()));
		    			int num2 =0;
		    			if(onboardDate.after(yearStartDate)) {
		    				num2 = DateUtil.getMonth(onboardDate);
		    			}
		    			num2 =endDateMonth-num2+1;
		    			//增加非本月的累计金额
		    			BigDecimal multiply = amount.multiply(new BigDecimal(num2));
		    			
		    			if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_1) {
		    				bool_1=true;
		    				specialDeductionSum1=multiply;
		    			}else if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_2) {
		    				bool_2=true;
		    				specialDeductionSum2=multiply;
		    			}else if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_3) {
		    				bool_3=true;
		    				specialDeductionSum3=multiply;
		    			}else if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_4) {
		    				bool_4=true;
		    				specialDeductionSum4=multiply;
		    			}else if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_5) {
		    				bool_5=true;
		    				specialDeductionSum5=multiply;
		    			}else if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_6) {
		    				bool_6=true;
		    				specialDeductionSum6=multiply;
		    			}
		    			specialSum=specialSum.add(multiply);
		    		}
		    	}
		    	
    			stBean.setSpecialDuduct1(specialDeductionSum1.setScale(2));
    			stBean.setSpecialDuduct2(specialDeductionSum2.setScale(2));
    			stBean.setSpecialDuduct3(specialDeductionSum3.setScale(2));
    			stBean.setSpecialDuduct4(specialDeductionSum4.setScale(2));
    			stBean.setSpecialDuduct5(specialDeductionSum5.setScale(2));
    			stBean.setSpecialDuduct6(specialDeductionSum6.setScale(2));
    			stBean.setSpecialDuductSum(specialSum.setScale(2));
    			
    			//----累计社保公积金（个人的）
    			stBean.setInsuranceFundSum((totalFund.add(totalInsurance).add(lastInsuranceFundSum)).setScale(2)+"");
    			
    			/***************结束计算****************/
    			
    			stDao.clear();
    			stDao.setConditionEmployeeId("=",employeeId);
    			stDao.setConditionYear("=",year);
    			stDao.setConditionMonth("=",month);
    			stDao.setDataFromBase(stBean);
    			if(stDao.countRows()>0){//说明已存在
    				stDao.conditionalUpdate();
    			}else{
    				stDao.save();
    			}
    		}
    	}
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0, "");
    }
    
    

    
    
    /**
     * 员工日薪推送
     * @param params
     * @return
     * @throws Exception
     */
    public static String onSendEmpDayPaymentThread(Map<String, Object> params) throws Exception{
		int operator = BaseHelpUtils.getIntValue(params, "operator");
		return ThreadTaskTemplate.runThreadTask(params, ThreadTaskUtils.TASK_TYPE_TWO, 
				operator, ThreadTaskUtils.OPERATION_TYPE_ONE);
	}
    
    /**
     * 员工日薪推送
     * @param param
     * @return
     * @throws SQLException 
     * @throws ParseException 
     */
    public static String onSendEmpDayPayment(Map<String, Object> param) throws SQLException, ParseException{
    	//获取employeeId:如果=0则推送所有的，如果>0则推送个人的
    	int employeeId = BaseHelpUtils.getIntValue(param, "employeeId");
    	int plateType = BaseHelpUtils.getIntValue(param.get("plateType"));
    	Date startDate = null;
    	Date endDate = null;
    	//获取开始日期和结束日期
    	String startDateStr = BaseHelpUtils.getStringValue(param, "startDate");
    	String endDateStr = BaseHelpUtils.getStringValue(param, "endDate");
    	if(BaseHelpUtils.isNullOrEmpty(startDateStr) || BaseHelpUtils.isNullOrEmpty(endDateStr)){
    		throw new SQLException("操作失败,开始日期和结束日期不可为空");
    	}
    	startDate = new Date(Long.valueOf(startDateStr));
    	endDate = new Date(Long.valueOf(endDateStr));
/*    	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
    	startDate = sdf.parse("2019-02-01");
    	endDate = sdf.parse("2019-02-28");*/
    	
    	EmployeePaymentDetail dao = new EmployeePaymentDetail();
    	ConditionSendIntegralOfEmpPaymentDetail condition = new ConditionSendIntegralOfEmpPaymentDetail();
    	QuerySendIntegralOfEmpPaymentDetail q = new QuerySendIntegralOfEmpPaymentDetail();
    	BaseCollection<BaseSendIntegralOfEmpPaymentDetail> result = null;
    	
    	//部门
    	Department ddao = new Department();
    	int departmentId = 0;
    	//推送个人,将日薪表中的数据进行加锁
    	if(employeeId > 0){
    		dao.setConditionEmployeeId("=", employeeId);
    		dao.setConditionIsLocked("=",Boolean.FALSE);
        	dao.addCondition(BaseEmployeePaymentDetail.CS_DETAIL_DATE,"between",startDate,endDate);
        	List<BaseEmployeePaymentDetail> list = dao.conditionalLoad();
        	if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
	    		for(BaseEmployeePaymentDetail obj : list){//循环查看该员工每天的部门类型，账户插入人工成本
	    			condition.setEmployeeId(obj.getEmployeeId());
	    			condition.setDetailDate(obj.getDetailDate());
	    			result = q.executeQuery(null, condition);
	    			int businessId = obj.getEmployeePaymentDetailId();
	    			BigDecimal integral = obj.getDayPay().add(obj.getDayAttendanceDeduction());
	    			Date detailDate = obj.getDetailDate();
	    			String remark = "";
	    			for(BaseSendIntegralOfEmpPaymentDetail a : result.getCollections()){
	    				departmentId = a.getDepartmentId();
	    				if(a.getPlateType() == 1 || a.getPlateType() == 3){//事业部和营销中心部门的人员的成本入个人账户
	    					remark = String.format("人工成本(%1$s)", DateUtil.formatDateString(detailDate));
    	    				AccountManageProcess.onSaveEmployeeAccount(a.getEmployeeId(),businessId , AccountManageProcess.EMP_BT_EMPLOYEE_COST,integral,detailDate, remark, -1);
    	    			}
	    			}
	    		}
	    		dao.setIsLocked(Boolean.TRUE);
	    		dao.conditionalUpdate();
        	}
        	
    	}
    	//按部门推送，1为事业部，3为营销部
    	else{
    		condition.setPlateType(plateType);
    		condition.setStartDate(startDate);
    		condition.setEndDate(endDate);
    		//查找出这段时间里该部门类型的人
    		result = q.executeQuery(null, condition);
    		int length = result.getCollections().size();
    		int i = 0;
    		Object[] arr = new Object[length];
    		
    		EmployeeCostRecord ecdao=new EmployeeCostRecord();
    		List<BaseEmployeeCostRecord> elist=ecdao.conditionalLoad();
    		Map<Integer,Object> emap=new HashMap<>();
    		for (BaseEmployeeCostRecord baseEmployeeCostRecord : elist) {
    			int  employeeIds=baseEmployeeCostRecord.getEmployeeId();
    			emap.put(employeeIds, employeeIds);
    		}
    		
    		for(BaseSendIntegralOfEmpPaymentDetail e : result.getCollections()){
    			departmentId = e.getDepartmentId();
    			arr[i] = e.getEmployeePaymentDetailId();
	    		int businessId = e.getEmployeePaymentDetailId();
	    		BigDecimal dayPay = BaseHelpUtils.isNullOrEmpty(e.getDayPay()) ? BigDecimal.ZERO : e.getDayPay();
	    		BigDecimal dayAttendanceDeduction = BaseHelpUtils.isNullOrEmpty(e.getDayAttendanceDeduction()) ? BigDecimal.ZERO : e.getDayAttendanceDeduction();
	    		BigDecimal integral = dayPay.add(dayAttendanceDeduction);
	    		Date detailDate = e.getDetailDate();
	    		String remark = "";
	    		int empId = e.getEmployeeId();
	    		
	    		if(emap.containsKey(empId)) {
	    			continue;
	    		}
	    		
    			if(plateType == 1 || plateType == 3){//事业部和营销中心部门的人员的成本入个人账户
    				remark = String.format("人工成本(%1$s)", DateUtil.formatDateString(detailDate));
					AccountManageProcess.onSaveEmployeeAccount(empId,businessId , AccountManageProcess.EMP_BT_EMPLOYEE_COST,integral, detailDate, remark, -1);
    			}
//    			else if(plateType == 3){//营销部入营销中心部门账户
//    				ddao.clear();
//        			ddao.setDepartmentId(departmentId);
//        			if(ddao.load()){
//        				int plateID = ddao.getPlateId();
//        				remark = String.format("%1$s(%2$s)人工成本",SelectValueCache.getSelectValue("employees", String.valueOf(empId)) ,DateUtil.formatDateString(detailDate));
//        				AccountManageProcess.onSavePlateAccount(plateID,businessId, AccountManageProcess.PLATE_BT_EMPLOYEE_COST, integral, detailDate, remark, -1);
//        			}
//    			}
            	i++;
    		}
    		if(!BaseHelpUtils.isNullOrEmpty(arr) && arr.length > 0){
    			dao.addCondition(BaseEmployeePaymentDetail.CS_EMPLOYEE_PAYMENT_DETAIL_ID, "in", arr);
    			dao.setIsLocked(Boolean.TRUE);
    			dao.conditionalUpdate();
    		}
    		
    	}
    	
    	ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,"");
    }
    
    /**
     * 员工日薪重置
     * @param params
     * @return
     * @throws Exception
     */
    public static String onResetEmpDayPaymentThread(Map<String, Object> params) throws Exception{
		int operator = BaseHelpUtils.getIntValue(params, "operator");
		return ThreadTaskTemplate.runThreadTask(params, ThreadTaskUtils.TASK_TYPE_THREE, 
				operator, ThreadTaskUtils.OPERATION_TYPE_ONE);
	}
    
    /**
     * 员工日薪重置
     * @param param
     * @return
     * @throws SQLException 
     * @throws ParseException 
     */
    public String onResetEmpDayPayment(Map<String, Object> param) throws SQLException, ParseException{
    	//获取职员ID
    	int employeeId = BaseHelpUtils.getIntValue(param,"employeeId");
    	Date startDate = null;
    	Date endDate = null;
    	//获取开始日期和结束日期
    	String startDateStr = BaseHelpUtils.getStringValue(param, "startDate");
    	String endDateStr = BaseHelpUtils.getStringValue(param, "endDate");
    	if(BaseHelpUtils.isNullOrEmpty(startDateStr) || BaseHelpUtils.isNullOrEmpty(endDateStr)){
    		throw new SQLException("操作失败,开始日期和结束日期不可为空");
    	}
    	startDate = new Date(Long.valueOf(startDateStr));
    	endDate = new Date(Long.valueOf(endDateStr));
    	onSalaryDayAccount(employeeId, startDate,endDate);
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,"");
    }
    
    /**
     * 病假扣款比例规则:3年以下 40%,3-5年 30%,5-8年 20%,8年以上不需要扣
     * @param onboardDate
     * @return
     */
    public BigDecimal getIllPercent(Date onboardDate){
    	BigDecimal illPercent = BigDecimal.ZERO;
    	if(!BaseHelpUtils.isNullOrEmpty(onboardDate)){
    		//初始化该职员的入职年限为0
    		BigDecimal onboardYears = BigDecimal.ZERO;
    		onboardYears = DateUtil.generateYearsBetween(new Date(),onboardDate);
    		BigDecimal threeYears = BigDecimal.valueOf(3);
    		BigDecimal fiveYears = BigDecimal.valueOf(5);
    		BigDecimal eightYears = BigDecimal.valueOf(8);
    		if(onboardYears.compareTo(threeYears) < 0){
    			illPercent = BigDecimal.valueOf(0.4);
    		}else if(onboardYears.compareTo(threeYears) >= 0 && onboardYears.compareTo(fiveYears) < 0){
    			illPercent = BigDecimal.valueOf(0.3);
    		}else if(onboardYears.compareTo(fiveYears) >= 0 && onboardYears.compareTo(eightYears) < 0){
    			illPercent = BigDecimal.valueOf(0.2);
    		}
    	}
    	return illPercent;
    }
    
    
    /**
     * 
     * @param empId
     * @param currentDate
     * @throws SQLException
     * @throws ParseException
     */
    public void onSalaryDayAccount(int empId,Date startDate,Date endDate) throws SQLException, ParseException{
    	//判断开始日期和结束日期是否是同一个月的，如果不同月，则返回异常
    	if(DateUtil.getYear(startDate) != DateUtil.getYear(endDate)){
    		throw new SQLException("操作异常:开始日期和结束日期需相同的年份");
    	}
    	if(DateUtil.getMonth(startDate) != DateUtil.getMonth(endDate)){
    		throw new SQLException("操作异常:开始日期和结束日期需相同的月份");
    	}
    	//获取当前日期的年月份
		int year = DateUtil.getYear(startDate);
		int month = DateUtil.getMonth(startDate);
		
		QueryOnLoadUnitFundAndInsurance unitDao = new QueryOnLoadUnitFundAndInsurance();
		ConditionOnLoadUnitFundAndInsurance unitCon = new ConditionOnLoadUnitFundAndInsurance();
		
		//获取当前月的总天数
		BigDecimal monthTotalDay = BaseHelpUtils.getBigDecimalValue(DateUtil.getDayOfMonth(startDate));
		BigDecimal illPercent = BigDecimal.ZERO;
		BaseEmployeePaymentDetail payBean = null;
		EmployeePaymentDetail payDao = new EmployeePaymentDetail();
		BigDecimal minusOne = BigDecimal.valueOf(-1);
    	Employee eDao = new Employee();
    	eDao.unsetSelectFlags();
    	eDao.setSelectEmployeeId(true);
    	eDao.setSelectOnboardDate(true);
    	eDao.setSelectIsCheck(true);
    	eDao.setSelectIsLongSickLeave(true);
    	//如果empId>0,则说明是计算个人的，如果=0说明是计算所有的
		eDao.setConditionEmployeeId(">",0);
		String sql = "";
		if(empId > 0){
			eDao.setConditionEmployeeId("=",empId);
		}else{
			/**
			 * 检索需要算日薪的所有人员
			 * 目前是在职且入职日期<=结束日期or目前是离职状态且是本月离职的
			 */
			sql = "(status=0 and date_trunc('month',onboard_date)<='"+endDate+"') or (status=1 and EXTRACT(YEAR from resignation_date) ='"+year+"' and EXTRACT(MONTH from resignation_date) = "+month+")";
		}
		List<BaseEmployee> eList = eDao.conditionalLoad(sql);
    	if(!BaseHelpUtils.isNullOrEmpty(eList) && eList.size() > 0){
    		//加载所有人员的工作日
    		ConditionOnLoadEmpWordDayOfMonth con = new ConditionOnLoadEmpWordDayOfMonth();
    		con.setYear(year);
    		con.setMonth(month);
    		if(empId > 0 ){
    			con.setEmployeeId(empId);
    		}
    		QueryOnLoadEmpWordDayOfMonth conDao = new QueryOnLoadEmpWordDayOfMonth();
    		BaseCollection<BaseOnLoadEmpWordDayOfMonth> conResult = conDao.executeQuery(null, con);
    		//定义map用于存放每个员工在当前月的工作日
    		Map<Integer,BigDecimal> workDayMap = new HashMap<>();
    		if(!BaseHelpUtils.isNullOrEmpty(conResult) && conResult.getCollections().size() > 0){
    			for(BaseOnLoadEmpWordDayOfMonth e : conResult.getCollections()){
    				BigDecimal monthWorkDay = BaseHelpUtils.getBigDecimalValue(e.getCount());
    				workDayMap.put(e.getEmployeeId(),monthWorkDay);
    			}
    		}
			
    		//加载所有人员的工龄工资
    		SalaryOfWorkYear workDao = new SalaryOfWorkYear();
    		workDao.setConditionYear("=",year);
    		workDao.setConditionMonth("=",month);
    		if(empId > 0 ){
    			workDao.setConditionEmployeeId("=",empId);
    		}
    		List<BaseSalaryOfWorkYear> workList = workDao.conditionalLoad();
    		//定义map来存放每个月的工龄工资
    		Map<Integer,BigDecimal> workMoneyMap = new HashMap<>();
    		if(!BaseHelpUtils.isNullOrEmpty(workList) && workList.size() > 0){
    			for(BaseSalaryOfWorkYear e : workList){
    				workMoneyMap.put(e.getEmployeeId(),BaseHelpUtils.getBigDecimalValue(e.getWorkMoney()));
    			}
    		}
    		//加载所有人员的五险一金
    		FiveInsuranceOneGold fiveDao = new FiveInsuranceOneGold();
    		fiveDao.unsetSelectFlags();
    		fiveDao.setSelectEmployeeId(true);
    		fiveDao.setSelectUnitTotalFund(true);
    		fiveDao.setSelectUnitTotalInsurance(true);
    		fiveDao.setConditionYear("=",year);
    		fiveDao.setConditionMonth("=",month);
    		if(empId > 0 ){
    			fiveDao.setConditionEmployeeId("=",empId);
    		}
    		List<BaseFiveInsuranceOneGold> fiveList = fiveDao.conditionalLoad();
    		//定义map来存放每个月的单位公积金
    		Map<Integer,BigDecimal> unitFundMap = new HashMap<>();
    		//定义map来存放每个月的单位社保
    		Map<Integer,BigDecimal> unitInsuranceMap = new HashMap<>();
    		if(!BaseHelpUtils.isNullOrEmpty(fiveList) && fiveList.size() > 0){
    			for(BaseFiveInsuranceOneGold e : fiveList){
    				unitFundMap.put(e.getEmployeeId(),BaseHelpUtils.getBigDecimalValue(e.getUnitTotalFund()));
    				unitInsuranceMap.put(e.getEmployeeId(),BaseHelpUtils.getBigDecimalValue(e.getUnitTotalInsurance()));
    			}
    		}
    		//定义职员排班表
    		EmployeeShiftManage shiftDao = new EmployeeShiftManage();
    		shiftDao.unsetSelectFlags();
    		shiftDao.setSelectShiftManageId(true);
    		//定义日薪表
    		EmployeePaymentDetail paymentDao = new EmployeePaymentDetail();
    		//定义一个map来存放员工的工作日，当工作日累加到本月的工作日数表示是最后一天的工作日，则更新总数和累计数据的差额
        	Map<Integer,BigDecimal> accMap = new HashMap<>();
        	OnPaymentManageProcess process = new OnPaymentManageProcess();
        	//月薪加载查询定义
        	ConditionOnLoadShiftAndDayPayment condition = new ConditionOnLoadShiftAndDayPayment();
        	QueryOnLoadShiftAndDayPayment dao = new QueryOnLoadShiftAndDayPayment();
        	//定义考勤详情表查询
        	EmployeeDayCheck checkDao = new EmployeeDayCheck();
        	HolidayManage holidayDao = new HolidayManage();
    		for(BaseEmployee e : eList){
    			//获取职员Id
    			int employeeId = e.getEmployeeId();
				//获取入职日期
				Date onboardDate = e.getOnboardDate();
				//获取是否是长病假，如果是长病假，则按0.4来计算
    			boolean isLongSickLeave = BaseHelpUtils.getBoolean(e.getIsLongSickLeave());
				if(isLongSickLeave){
					illPercent = BigDecimal.valueOf(0.4);
				}else{
					illPercent = process.getIllPercent(onboardDate);
				}
				//获取当前人员在这个月的工作日
				BigDecimal monthWorkDay = BaseHelpUtils.getBigDecimalValue(workDayMap.get(employeeId));
				//计算当前人员在这一个月的日薪数据
				for (Date currentDate = startDate; currentDate.compareTo(endDate) <= 0; currentDate = DateUtil.getNextDayOfDay(currentDate, 1)) {
					//如果这一天数据已加锁，则不需做任何操作
					paymentDao.clear();
					paymentDao.setConditionEmployeeId("=",employeeId);
					paymentDao.setConditionDetailDate("=",currentDate);
					paymentDao.setConditionIsLocked("=",true);
					if(paymentDao.isExist()){//说明已加锁
						continue;
					}
					shiftDao.clear();
					shiftDao.setConditionEmployeeId("=",employeeId);
					shiftDao.setConditionRecordDate("=",currentDate);
					BaseEmployeeShiftManage shiftBean = shiftDao.executeQueryOneRow();
					int shiftManageId = 0;
					if(!BaseHelpUtils.isNullOrEmpty(shiftBean)){
						//获取当前人员在当前日的排班
						shiftManageId = BaseHelpUtils.getIntValue(shiftBean.getShiftManageId());
					}
					Calendar cal = Calendar.getInstance();
					cal.setTime(currentDate);
					
					//如果当前班次<=2，则说明非工作日
					if(shiftManageId <= 2){//非工作日
						//如果是非工作日，则删除日薪表中这一天的数据集
						paymentDao.clear();
						paymentDao.setConditionEmployeeId("=",employeeId);
						paymentDao.setConditionDetailDate("=",currentDate);
						if(paymentDao.isExist()){
							paymentDao.conditionalDelete();
						}
					}else{//工作日
						//如果当前天是排了工作日班，则检测这一天是否是节假日
						holidayDao.clear();
						holidayDao.setConditionRecordDate("=",currentDate);
						holidayDao.setConditionIsWorkDay("=",false);
						if(holidayDao.isExist()){
							paymentDao.clear();
							paymentDao.setConditionEmployeeId("=",employeeId);
							paymentDao.setConditionDetailDate("=",currentDate);
							if(paymentDao.isExist()){
								paymentDao.conditionalDelete();
							}
							
							continue;
						}
						
						BigDecimal workNum = BaseHelpUtils.getBigDecimalValue(accMap.get(employeeId)).add(BigDecimal.ONE);
						accMap.put(employeeId,workNum);
						payBean = new BaseEmployeePaymentDetail();
						payBean.setDetailDate(currentDate);
						//获取当期日期是星期几
						int detailWeek = DateUtil.getDayOfWeek(currentDate);
						payBean.setEmployeeId(employeeId);
						payBean.setDetailWeek(detailWeek);
						payBean.setRemark("");
						payBean.setMonthTotalDay(monthTotalDay);
						payBean.setMonthWorkDay(monthWorkDay);
						payBean.setIllPercent(illPercent);
						payBean.setIllPercentStr(illPercent+"%");
						payBean.setDayWorkTime(StaticUtils.TOTAL_HOURS);
						BigDecimal unitTotalFund = BigDecimal.ZERO;
						BigDecimal unitTotalInsurance = BigDecimal.ZERO;
						//加载当前人员的月薪数据
						condition.setEmployeeId(employeeId);
						//如果当期人员的入职日期大于当前计算日期，则以当前人员的入职日期取检索月薪数据
						if(onboardDate.after(currentDate)){
							condition.setRecordDate(onboardDate);
						}else{
							condition.setRecordDate(currentDate);
						}
						BaseCollection<BaseOnLoadShiftAndDayPayment> result = dao.executeQuery(null, condition);
						if(!BaseHelpUtils.isNullOrEmpty(result) && result.getCollections().size() > 0){
							BaseOnLoadShiftAndDayPayment monthPayBean = result.getCollections().get(0);
							if(BaseHelpUtils.isNullOrEmpty(monthPayBean)){
								continue;
							}
							//获取基本比例
							BigDecimal basicProportion = monthPayBean.getBasicProportion()==null?BigDecimal.ZERO:monthPayBean.getBasicProportion();
							payBean.setBasicProportion(basicProportion);
							payBean.setBasicProportionStr(basicProportion+"%");
							//获取基本工资
							BigDecimal monthBasicPay = monthPayBean.getMonthBasicPay()==null?BigDecimal.ZERO:monthPayBean.getMonthBasicPay();
							//获取绩效工资
							BigDecimal monthPerformancePay = monthPayBean.getMonthPerformancePay()==null?BigDecimal.ZERO:monthPayBean.getMonthPerformancePay();
							//获取工龄工资
							BigDecimal foremanPay = BaseHelpUtils.getBigDecimalValue(workMoneyMap.get(employeeId));
							//获取月单位公积金合计
							unitTotalFund = BaseHelpUtils.getBigDecimalValue(unitFundMap.get(employeeId));
							//获取月单位社保合计
							unitTotalInsurance = BaseHelpUtils.getBigDecimalValue(unitInsuranceMap.get(employeeId));
							//设置日基本工资=基本工资/月工作日
							BigDecimal dayOfMonthBasicPay = BigDecimal.ZERO;
							//设置日绩效工资=绩效工资/月工作日
							BigDecimal dayOfMonthPerformancePay = BigDecimal.ZERO;
							//设置日工龄工资=工龄工资/月工作日
							BigDecimal dayOfForemanPay = BigDecimal.ZERO;
							BigDecimal dayOfUitTotalFund = BigDecimal.ZERO;
							BigDecimal dayOfUnitTotalInsurance = BigDecimal.ZERO;
							if(monthWorkDay.compareTo(workNum) == 0){//说明是最后一个工作日
								//获取薪资调整的日期，判断如果是在当前计算月调整的薪资，则最后一天不进行取整
								Date changeDate = monthPayBean.getChangeDate();
								int changeYear = DateUtil.getYear(changeDate);
								int changeMonth = DateUtil.getMonth(changeDate);
								int accountYear = DateUtil.getYear(currentDate);
								int accountMonth = DateUtil.getMonth(currentDate);
								//删除当前工作日的数据
								payDao.clear();
								payDao.setConditionEmployeeId("=",employeeId);
								payDao.setConditionDetailDate("=",currentDate);
								payDao.conditionalDelete();
								//获取累计数据
								unitCon.setYear(year);
								unitCon.setMonth(month);
								unitCon.setEmployeeId(employeeId);
								BaseCollection<BaseOnLoadUnitFundAndInsurance> unitResult = unitDao.executeQuery(null,unitCon);
								//如果是最后一个工作日，则用总数据-累计的数据，得到当前工作日的数据集
								if(!BaseHelpUtils.isNullOrEmpty(unitResult) && unitResult.getCollections().size()>0){
									List<BaseOnLoadUnitFundAndInsurance> unitList = unitResult.getCollections();
									BaseOnLoadUnitFundAndInsurance ee = unitList.get(0);
									if(changeYear != accountYear || changeMonth != accountMonth){//说明不是当前计算月调动的薪资，则不需取整
										BigDecimal monthBasicPayMonth = ee.getMonthBasicPay()==null?BigDecimal.ZERO:ee.getMonthBasicPay();
										dayOfMonthBasicPay = monthBasicPay.subtract(monthBasicPayMonth);
										
										BigDecimal monthPerformancePayMonth = ee.getMonthPerformancePay()==null?BigDecimal.ZERO:ee.getMonthPerformancePay();
										dayOfMonthPerformancePay = monthPerformancePay.subtract(monthPerformancePayMonth);
										
										BigDecimal foremanPayMonth = ee.getForemanPay()==null?BigDecimal.ZERO:ee.getForemanPay();
										dayOfForemanPay = foremanPay.subtract(foremanPayMonth);
									}else{
										dayOfMonthBasicPay = monthWorkDay.compareTo(BigDecimal.ZERO)==0?BigDecimal.ZERO:monthBasicPay.divide(monthWorkDay,2,BigDecimal.ROUND_DOWN);
										dayOfMonthPerformancePay = monthWorkDay.compareTo(BigDecimal.ZERO)==0?BigDecimal.ZERO:monthPerformancePay.divide(monthWorkDay,2,BigDecimal.ROUND_DOWN);
										dayOfForemanPay = monthWorkDay.compareTo(BigDecimal.ZERO)==0?BigDecimal.ZERO:foremanPay.divide(monthWorkDay,2,BigDecimal.ROUND_DOWN);
									}
									
									BigDecimal unitTotalFundMonth = ee.getUnitTotalFund()==null?BigDecimal.ZERO:ee.getUnitTotalFund();
									dayOfUitTotalFund = unitTotalFund.subtract(unitTotalFundMonth);
									
									BigDecimal unitTotalInsuranceMonth = ee.getUnitTotalInsurance()==null?BigDecimal.ZERO:ee.getUnitTotalInsurance();
									dayOfUnitTotalInsurance = unitTotalInsurance.subtract(unitTotalInsuranceMonth);
								}
								
							}else{
								dayOfMonthBasicPay = monthWorkDay.compareTo(BigDecimal.ZERO)==0?BigDecimal.ZERO:monthBasicPay.divide(monthWorkDay,2,BigDecimal.ROUND_DOWN);
								dayOfMonthPerformancePay = monthWorkDay.compareTo(BigDecimal.ZERO)==0?BigDecimal.ZERO:monthPerformancePay.divide(monthWorkDay,2,BigDecimal.ROUND_DOWN);
								dayOfForemanPay = monthWorkDay.compareTo(BigDecimal.ZERO)==0?BigDecimal.ZERO:foremanPay.divide(monthWorkDay,2,BigDecimal.ROUND_DOWN);
								dayOfUitTotalFund = monthWorkDay.compareTo(BigDecimal.ZERO)==0?BigDecimal.ZERO:unitTotalFund.divide(monthWorkDay,2,BigDecimal.ROUND_DOWN);
								dayOfUnitTotalInsurance = monthWorkDay.compareTo(BigDecimal.ZERO)==0?BigDecimal.ZERO:unitTotalInsurance.divide(monthWorkDay,2,BigDecimal.ROUND_DOWN);
							}
							//加载当前人员在这一天的考勤数据
							checkDao.clear();
							checkDao.setConditionEmployeeId("=",employeeId);
							checkDao.setConditionRecordDate("=",currentDate);
							BaseEmployeeDayCheck checkBean = checkDao.executeQueryOneRow();
							//检索该员工是否有绩效
							//如果该员工在这一个月内事假和病假累计>15天，则正月都无绩效
							boolean has = checkCanHasPerformance(employeeId, currentDate);
							if(!has){
								dayOfMonthPerformancePay = BigDecimal.ZERO;
							}
							//获取迟到/早退10分钟次数
							int lateLeave10m = checkBean==null?0:checkBean.getLateLeave10m()==null?0:checkBean.getLateLeave10m();
							payBean.setLateLeave10m(lateLeave10m);
							//获取迟到/早退30分钟次数
							int lateLeave30m = checkBean==null?0:checkBean.getLateLeave30m()==null?0:checkBean.getLateLeave30m();
							payBean.setLateLeave30m(lateLeave30m);
							//获取迟到/早退扣款次数
							int lateLeave = checkBean==null?0:checkBean.getLateLeave()==null?0:checkBean.getLateLeave();
							payBean.setLateLeave(lateLeave);
							//获取事假天数
							BigDecimal thingLeaveDays = checkBean==null?BigDecimal.ZERO:checkBean.getThingLeaveDays()==null?BigDecimal.ZERO:checkBean.getThingLeaveDays();
							//如果有旷工，则记事假一天，且不记绩效
							BigDecimal absenceDays = checkBean==null?BigDecimal.ZERO:checkBean.getAbsenceDays()==null?BigDecimal.ZERO:checkBean.getAbsenceDays();
							if(absenceDays.compareTo(BigDecimal.ONE) == 0){//说明旷工，则记事假一天
								thingLeaveDays = thingLeaveDays.add(absenceDays);
								dayOfMonthPerformancePay = BigDecimal.ZERO;
							}
							//设置日全薪=日基本工资+日绩效工资+日工龄工资
							BigDecimal totalPay = dayOfMonthBasicPay.add(dayOfMonthPerformancePay).add(dayOfForemanPay);
							payBean.setAllSalary(totalPay);
							//设置日工资=全薪+社保+公积金
							BigDecimal dayPay = totalPay.add(dayOfUitTotalFund).add(dayOfUnitTotalInsurance);
							payBean.setDayPay(dayPay);
							//设置考勤扣款的日薪=日基本工资+日工龄工资
							BigDecimal deductPayment = dayOfMonthBasicPay.add(dayOfForemanPay);
							payBean.setThingLeaveDays(thingLeaveDays);
							payBean.setMonthBasicPay(dayOfMonthBasicPay);
							payBean.setMonthPerformancePay(dayOfMonthPerformancePay);
							payBean.setDayForemanPay(dayOfForemanPay);
							payBean.setUnitTotalFund(dayOfUitTotalFund);
							payBean.setUnitTotalInsurance(dayOfUnitTotalInsurance);
							//获取事假小时数
							BigDecimal thingLeaveHours = checkBean==null?BigDecimal.ZERO:checkBean.getThingLeaveHours()==null?BigDecimal.ZERO:checkBean.getThingLeaveHours();
							payBean.setThingLeaveHours(thingLeaveHours);
							//获取病假天数
							BigDecimal illLeaveDays = checkBean==null?BigDecimal.ZERO:checkBean.getIllLeaveDays()==null?BigDecimal.ZERO:checkBean.getIllLeaveDays();
							payBean.setIllLeaveDays(illLeaveDays);
							//获取病假小时数
							BigDecimal illLeaveHours = checkBean==null?BigDecimal.ZERO:checkBean.getIllLeaveHours()==null?BigDecimal.ZERO:checkBean.getIllLeaveHours();
							payBean.setIllLeaveHours(illLeaveHours);
							//设置10元/次迟到=迟到或早退10分钟次数*10;
							BigDecimal lateLeave10mMoney = BigDecimal.valueOf(lateLeave10m).multiply(BigDecimal.TEN).multiply(minusOne);
							//40元/次迟到=迟到或早退30分钟次数*40;
							BigDecimal lateLeave30mMoney = BigDecimal.valueOf(lateLeave30m).multiply(BigDecimal.valueOf(40)).multiply(minusOne);
							//扣款迟到=当前日考勤扣款工资的一半*迟到或早退扣款次数
							BigDecimal lateLeaveMoney = deductPayment.multiply(BigDecimal.valueOf(0.5)).multiply(BigDecimal.valueOf(lateLeave)).multiply(minusOne);
							//设置迟到、早退扣款小计=设置10元/次迟到+40元/次迟到+扣款迟到
							BigDecimal lateLeaveTotal = lateLeave10mMoney.add(lateLeave30mMoney).add(lateLeaveMoney);
							payBean.setLateLeaveTotal(lateLeaveTotal);
							//设置事假小计=事假天数*日考勤扣款工资+日考勤扣款工资/7.5*事假小时数
							BigDecimal thingTotal = BaseHelpUtils.format(thingLeaveDays.multiply(deductPayment).add(deductPayment.multiply(thingLeaveHours).divide(StaticUtils.TOTAL_HOURS,2,BigDecimal.ROUND_DOWN)), 2).multiply(minusOne);
							payBean.setThingTotal(thingTotal);
							//设置病假小计=(病假天数*日考勤扣款工资+日考勤扣款工资/7.5*病假小时数)*
							BigDecimal illTotal = BaseHelpUtils.format(illLeaveDays.multiply(deductPayment).add(deductPayment.multiply(illLeaveHours).divide(StaticUtils.TOTAL_HOURS,2,BigDecimal.ROUND_DOWN)).multiply(illPercent), 2).multiply(minusOne);
							payBean.setIllTotal(illTotal);
							//设置日考勤扣款工资=迟到、早退扣款小计+事假小计+病假小计
							BigDecimal dayAttendanceDeduction = lateLeaveTotal.add(thingTotal).add(illTotal);
							payBean.setDayAttendanceDeduction(dayAttendanceDeduction);
							payBean.setDeductTotal(dayAttendanceDeduction);
							payDao.clear();
							payDao.setConditionEmployeeId("=",employeeId);
							payDao.setConditionDetailDate("=",currentDate);
							BaseEmployeePaymentDetail be = payDao.executeQueryOneRow();
							payDao.setDataFromBase(payBean);
							if(!BaseHelpUtils.isNullOrEmpty(be)){
								payDao.conditionalUpdate();
							}else{
								payDao.save();
							}
						}
						
					}
    			}
    		}
    	}
    	
    }
    
    /**
     * 检索该员工是否有绩效
     * 如果该员工在这一个月内事假和病假累计>15天，则正月都无绩效
     * @param employeeId
     * @param recordDate
     * @return
     * @throws ParseException 
     * @throws SQLException 
     */
    public boolean checkCanHasPerformance(int employeeId,Date recordDate) throws ParseException, SQLException{
    	boolean has = true;
    	//获取年份和月份
    	int year = DateUtil.getYear(recordDate);
    	int month = DateUtil.getMonth(recordDate);
    	EmployeeMonthCheck dao = new EmployeeMonthCheck();
    	dao.unsetSelectFlags();
    	dao.setSelectThingLeaveDays(true);
    	dao.setSelectThingLeaveHours(true);
    	dao.setSelectIllLeaveDays(true);
    	dao.setSelectIllLeaveHours(true);
    	dao.setConditionEmployeeId("=",employeeId);
    	dao.setConditionYear("=",year);
    	dao.setConditionMonth("=",month);
    	BaseEmployeeMonthCheck bean = dao.executeQueryOneRow();
    	if(!BaseHelpUtils.isNullOrEmpty(bean)){
    		BigDecimal thingLeaveDays = BaseHelpUtils.getBigDecimalValue(bean.getThingLeaveDays());
    		BigDecimal thingLeaveHours = BaseHelpUtils.getBigDecimalValue(bean.getThingLeaveHours());
    		BigDecimal illLeaveDays = BaseHelpUtils.getBigDecimalValue(bean.getIllLeaveDays());
    		BigDecimal illLeaveHours = BaseHelpUtils.getBigDecimalValue(bean.getIllLeaveHours());
    		//设置该员工累记得事假和病假小时数，如果一个月内>15天，则这一个月都不记绩效
			BigDecimal totalLeave = BigDecimal.ZERO;
			if(thingLeaveDays.compareTo(BigDecimal.ZERO) > 0){
				totalLeave = totalLeave.add(BigDecimal.valueOf(7.5).multiply(thingLeaveDays));
			}
			if(thingLeaveHours.compareTo(BigDecimal.ZERO) > 0){
				totalLeave = totalLeave.add(thingLeaveHours);
			}
			if(illLeaveDays.compareTo(BigDecimal.ZERO) > 0){
				totalLeave = totalLeave.add(BigDecimal.valueOf(7.5).multiply(illLeaveDays));
			}
			if(illLeaveHours.compareTo(BigDecimal.ZERO) > 0){
				totalLeave = totalLeave.add(illLeaveHours);
			}
			if(totalLeave.compareTo(BigDecimal.valueOf(7.5).multiply(BigDecimal.valueOf(15)))>0){
				has = false;
			}
    	}
    	return has;
    }
    
    
    /**
     * 月专项扣除统计  onSpecialDeductionMonthTotalAccount
     * @return
     * @throws ParseException 
     * @throws SQLException 
     */
    public static  String onSpecialDeductionMonthTotalAccount(Map<String, Object> param) throws ParseException, SQLException{
    	//获取年月份
    	int year = BaseHelpUtils.getIntValue(param, "year");
    	int month = BaseHelpUtils.getIntValue(param, "month");
    	int appleEmployeeId = BaseHelpUtils.getIntValue(param, "employeeId");
    	if(year == 0 || month == 0){
    		throw new SQLException("操作异常:年月份不可为空");
    	}
    	
    	SpecialDeductionMonthDetail sdmdDao =new SpecialDeductionMonthDetail();
    	BaseSpecialDeductionMonthDetail baseSpecialDeductionMonthDetail =new BaseSpecialDeductionMonthDetail();
    	Employee eDao =new Employee();
    	
    	//加载当前年份的专项扣除数据集
//    	QueryOnLoadSpecialDeductionYear sdy = new QueryOnLoadSpecialDeductionYear();
//    	ConditionOnLoadSpecialDeductionYear condition1 = new ConditionOnLoadSpecialDeductionYear();
//    	condition1.setYear(BaseHelpUtils.getString(new SimpleDateFormat("yyyy").format(new Date())));
//     	KeyValuePair kv = new KeyValuePair();
//    	kv.setKey("EXTRACT ( MONTH FROM sdd.start_date ) <=? AND EXTRACT ( MONTH FROM sdd.end_date ) >=? AND EXTRACT ( MONTH FROM sdd.end_date ) <?");
//    	kv.setValue("1=? and 1=? and 1=? ");
//    	KeyValuePair[] kvs = {kv};
    	
    	//获取当年年度当月有效的流程通过的所有的专项扣除项
    	QueryOnLoadSpecialDeductionYear sdy = new QueryOnLoadSpecialDeductionYear();
    	ConditionOnLoadSpecialDeductionYear sdyCondition = new ConditionOnLoadSpecialDeductionYear();
    	sdyCondition.setYear(year+"");
    	sdyCondition.setMonth(month);
    	sdyCondition.setIsEnable(true);
    	KeyValuePair kv = new KeyValuePair();
    	kv.setKey("EXTRACT ( MONTH FROM sdd.end_date ) <?");
    	kv.setValue("1=?");
    	KeyValuePair[] kvs = {kv};
//    	BaseCollection<BaseOnLoadSpecialDeductionYear> sdyQuery = sdy.executeQuery(kvs, sdyCondition);
    	
    	//加载薪资总表数据集  
    	QueryOnLoadSalaryTotalMonthData salaryTotalMonthDao = new QueryOnLoadSalaryTotalMonthData();
    	ConditionOnLoadSalaryTotalMonthData condition = new ConditionOnLoadSalaryTotalMonthData();
    	condition.setYear(year);
    	condition.setMonth(month);
    	if(appleEmployeeId>0) {
    		condition.setEmployeeId(appleEmployeeId);
    	}
    	BaseCollection<BaseOnLoadSalaryTotalMonthData> result = salaryTotalMonthDao.executeQuery(null, condition);
    	List<BaseOnLoadSalaryTotalMonthData> list = result.getCollections();
    	
    	if(!BaseHelpUtils.isNullOrEmpty(result)&&list.size()>0){
    		for (BaseOnLoadSalaryTotalMonthData baseOnLoadSalaryTotalMonthData : list) {
    			Integer employeeId = baseOnLoadSalaryTotalMonthData.getEmployeeId();
    			eDao.clear();
    			eDao.setConditionEmployeeId("=", employeeId);
    			BaseEmployee baseEmployee = eDao.executeQueryOneRow();
    			if(!BaseHelpUtils.isNullOrEmpty(baseEmployee)) {
    				//计算当前员工当前年度的专项扣除总和
    				sdyCondition.setEmployeeId(employeeId);
    				//该员工的专项扣除总和
    				BigDecimal specialDeductionSum =BigDecimal.ZERO;
    				BaseCollection<BaseOnLoadSpecialDeductionYear> sdyQuery = sdy.executeQuery(kvs, sdyCondition);
    				if(!BaseHelpUtils.isNullOrEmpty(sdyQuery)&&sdyQuery.getCollections().size()>0) {
    					List<BaseOnLoadSpecialDeductionYear> collections = sdyQuery.getCollections();
    					sdmdDao.clear();
    					sdmdDao.setConditionEmployeeId("=",employeeId);
    					sdmdDao.setConditionYear("=",year+"");
    					sdmdDao.setConditionMonth("=",month+"");
    					sdmdDao.conditionalDelete();
    					
    					
    					sdmdDao.clear();
    					sdmdDao.setEmployeeId(employeeId);
    					sdmdDao.setEmployeeNo(baseEmployee.getEmployeeNo());
    					sdmdDao.setYear(year+"");
    					sdmdDao.setMonth(month+"");
    					sdmdDao.setPlateId(baseEmployee.getPlateId());
    					sdmdDao.setDepartmentId(baseEmployee.getDepartmentId());
    					for (BaseOnLoadSpecialDeductionYear baseOnLoadSpecialDeductionYear : collections) {
    						BigDecimal amount = BaseHelpUtils.isNullOrEmpty(baseOnLoadSpecialDeductionYear.getAmount())?BigDecimal.ZERO:BaseHelpUtils.getBigDecimalValue(baseOnLoadSpecialDeductionYear.getAmount());
    						int typeId = BaseHelpUtils.getIntValue(baseOnLoadSpecialDeductionYear.getSpecialDeductionTypeId());
    						if(typeId==StaticUtils.SPECIAL_DEDUCTION_1) {
    							sdmdDao.setSpecialDuduct1(amount);
    						}else if(typeId==StaticUtils.SPECIAL_DEDUCTION_2) {
    							sdmdDao.setSpecialDuduct2(amount);
    						}else if(typeId==StaticUtils.SPECIAL_DEDUCTION_3) {
    							sdmdDao.setSpecialDuduct3(amount);
    						}else if(typeId==StaticUtils.SPECIAL_DEDUCTION_4) {
    							sdmdDao.setSpecialDuduct4(amount);
    						}else if(typeId==StaticUtils.SPECIAL_DEDUCTION_5) {
    							sdmdDao.setSpecialDuduct5(amount);
    						}else if(typeId==StaticUtils.SPECIAL_DEDUCTION_6) {
    							sdmdDao.setSpecialDuduct6(amount);
    						}
    						specialDeductionSum =specialDeductionSum.add(amount);
    					}
    					sdmdDao.setAmount(specialDeductionSum);
						sdmdDao.save();
    				}
    			}
			}
    	}
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0, "");
    }

	@Override
	public String getDownloadFileExtension() { 
		return "csv";
	}
	
	
	public static void test() throws SQLException {
		Calendar cal = Calendar.getInstance();
		cal.set(2019, 0, 1);
		Date yearstartdate = cal.getTime(); //2019-01-01
		cal.clear();
		cal.set(2018, 11, 31); //2018-12-31
		Date yearenddate = cal.getTime();
		
		QueryOnSalaryTotalData query =new QueryOnSalaryTotalData();
		ConditionOnSalaryTotalData condition =new  ConditionOnSalaryTotalData();
		condition.setYear(2019);
		condition.setMonth(4);
		BaseCollection<BaseOnSalaryTotalData> collection = query.executeQuery(null, condition);
		List<BaseOnSalaryTotalData> collections = collection.getCollections();
		
    	//加载当前年份的专项扣除数据集
    	QueryOnLoadSpecialDeductionYear sdy = new QueryOnLoadSpecialDeductionYear();
    	ConditionOnLoadSpecialDeductionYear condition1 = new ConditionOnLoadSpecialDeductionYear();
    	condition1.setYear(BaseHelpUtils.getString(new SimpleDateFormat("yyyy").format(new Date())));
     	KeyValuePair kv = new KeyValuePair();
    	kv.setKey("EXTRACT ( MONTH FROM sdd.start_date ) <=? AND EXTRACT ( MONTH FROM sdd.end_date ) >=? AND EXTRACT ( MONTH FROM sdd.end_date ) <?");
    	kv.setValue("1=? and 1=? and 1=? ");
    	KeyValuePair[] kvs = {kv};
    	
		Employee dao =new Employee();
		SpecialDeductionMonthDetail sdm =new SpecialDeductionMonthDetail();
		
		for (BaseOnSalaryTotalData baseOnSalaryTotalData : collections) {
			BigDecimal specialAdditionalDuduct = baseOnSalaryTotalData.getSpecialAdditionalDuduct();
			BigDecimal specialDuductSum = baseOnSalaryTotalData.getSpecialDuductSum();
			if(specialAdditionalDuduct.compareTo(BigDecimal.ZERO)==0 && specialDuductSum.compareTo(BigDecimal.ZERO)==0 ) {
				continue;
			}
			Integer employeeId = baseOnSalaryTotalData.getEmployeeId();
			//获取员工的入职时间
			dao.clear();
			dao.setConditionEmployeeId("=",employeeId);
			BaseEmployee executeQueryOneRow = dao.executeQueryOneRow();
			Date onboardDate = executeQueryOneRow.getOnboardDate();
			cal.clear();
			cal.setTime(onboardDate);
			//入职月份
			int month_rz = cal.get(Calendar.MONTH)+1;
			
			//累计金额
			BigDecimal sum =BigDecimal.ZERO;
			
			//该员工申请的专项扣除
			condition1.setEmployeeId(employeeId);
			BaseCollection<BaseOnLoadSpecialDeductionYear> executeQuery = sdy.executeQuery(kvs, condition1);
			List<BaseOnLoadSpecialDeductionYear> list = executeQuery.getCollections();
			if(list.size()>0) {
	    		boolean bool_1 =false;
	    		boolean bool_2 =false;
	    		boolean bool_3 =false;
	    		boolean bool_4 =false;
	    		boolean bool_5 =false;
	    		boolean bool_6 =false;
	    		
				for (BaseOnLoadSpecialDeductionYear baseOnLoadSpecialDeductionYear : list) {
					//申请金额
					BigDecimal amount = baseOnLoadSpecialDeductionYear.getAmount();
					
					//该专项扣除开始时间
					Date startDate = baseOnLoadSpecialDeductionYear.getStartDate();
					cal.clear();
					cal.set(2019, 3, 30);
					//开始月份
					if(startDate.after(cal.getTime())) {
						continue;
					}
					
					Integer specialDeductionTypeId = baseOnLoadSpecialDeductionYear.getSpecialDeductionTypeId();
					if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_1&&bool_1==true) {
    					continue;
    				}else if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_1&&bool_1==false) {
    					bool_1=true;
    				}
    				if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_2&&bool_2==true) {
    					continue;
    				}else if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_2&&bool_2==false){
    					bool_2=true;
    				}
    				if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_3&&bool_3==true) {
    					continue;
    				}else if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_3&&bool_3==false){
    					bool_3=true;
    				}
    				if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_4&&bool_4==true) {
    					continue;
    				}else if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_4&&bool_4==false){
    					bool_4=true;
    				}
    				if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_5&&bool_5==true) {
    					continue;
    				}else if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_5&&bool_5==false){
    					bool_5=true;
    				}
    				if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_6&&bool_6==true) {
    					continue;
    				}else if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_6&&bool_6==false){
    					bool_6=true;
    				}
					
					//该专项扣除的申请时间
					Date createDate = baseOnLoadSpecialDeductionYear.getCreateDate();
					cal.clear();
					cal.setTime(createDate);
					//申请月份
					int month_sq = cal.get(Calendar.MONTH)+1;
					//1.申请时间为12，入职时间 12月之前
					//2.申请时间为12之后，入职时间12月之前
					//3.申请时间为12之后，入职时间12月之后，入职当月申请
					//4.申请时间为12之后，入职时间12月之后，入职当月之后申请
					if(onboardDate.before(yearstartdate)&&createDate.after(yearenddate)) {//入职时间小于1月1日 并且 申请时间大于12月31日
						sdm.clear();
						sdm.setConditionYear("=",2018+"");
						sdm.setConditionMonth("=",12+"");
						sdm.setConditionEmployeeId("=", employeeId);
						BaseSpecialDeductionMonthDetail row12 = sdm.executeQueryOneRow();
						if(BaseHelpUtils.isNullOrEmpty(row12)) {
							sum= sum.add(amount);
						}
						
						for (int i =1 ; i < 4; i++) {
							sdm.clear();
							sdm.setConditionYear("=",2019+"");
							sdm.setConditionMonth("=",i+"");
							sdm.setConditionEmployeeId("=", employeeId);
							BaseSpecialDeductionMonthDetail row = sdm.executeQueryOneRow();
							if(BaseHelpUtils.isNullOrEmpty(row)) {
								sum= sum.add(amount);
							}
						}
					}else if(onboardDate.after(yearenddate)&&month_sq>month_rz){//入职时间大于12月31日 并且   申请时间不等于入职时间
						for (int i =month_sq ; i < 4; i++) {
							sdm.clear();
							sdm.setConditionYear("=",2019+"");
							sdm.setConditionMonth("=",i+"");
							sdm.setConditionEmployeeId("=", employeeId);
							BaseSpecialDeductionMonthDetail row = sdm.executeQueryOneRow();
							if(BaseHelpUtils.isNullOrEmpty(row)) {
								sum= sum.add(amount);
							}
						}
					}
				}
			}
			
			sdm.clear();
			sdm.setConditionYear("=",2019+"");
			sdm.setConditionMonth("=",4+"");
			sdm.setConditionEmployeeId("=", employeeId);
			BaseSpecialDeductionMonthDetail row4 = sdm.executeQueryOneRow();
			if(!BaseHelpUtils.isNullOrEmpty(row4)) {
				BigDecimal decimal = row4.getAmount().add(sum);
				row4.setAmount(decimal);
				sdm.clear();
				sdm.setDataFromBase(row4);
				sdm.update();
			}
		}
	}
	
	
	public static void main(String[] args) throws ConnectTimeoutException, SocketTimeoutException, Exception {
		Map<String,Object> map =new HashMap<>(); 
		map.put("year", 2019);
		map.put("month", 5);
//		map.put("employeeId", 112);
		map.put("employeeId", 2294);
		onSalaryTotalAccount(map);
		}
	
	
	

}