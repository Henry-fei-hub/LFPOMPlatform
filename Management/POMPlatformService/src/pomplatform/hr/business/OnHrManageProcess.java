package pomplatform.hr.business;

import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCompensatoryLeave;
import com.pomplatform.db.bean.BaseDepartment;
import com.pomplatform.db.bean.BaseEmployeeMonthCheck;
import com.pomplatform.db.bean.BasePlateDepartment;
import com.pomplatform.db.dao.CompensatoryLeave;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.EmployeeMonthCheck;
import com.pomplatform.db.dao.FileNumber;
import com.pomplatform.db.dao.PlateDepartment;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericProcessor;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.otheraccount.UserAccountUtils;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import pomplatform.salary.bean.BaseCalculateAnnualLeaveNew;
import pomplatform.salary.bean.ConditionCalculateAnnualLeaveNew;
import pomplatform.salary.query.QueryCalculateAnnualLeaveNew;

/**
 * Hr相关
 *
 * @author lxf
 */
public class OnHrManageProcess implements GenericProcessor, GenericDownloadProcessor {
    private static final Logger __logger = Logger.getLogger("");
    //操作类型
    private static final String OPT_TYPE = "optType";
    //部门人员转移
    private static final String ON_EMP_OF_DET_CHANGE = "onEmpOfDetChange";
    //职员入职身份证号验证
    private static final String ON_ID_VALIDATE = "onIdValidate";
    //加载部门信息
    private static final String ON_FIND_DEPARTMENT_DATA = "onFindDepartmentData";
    //保存业务部门关联归属部门表数据
    private static final String ON_SAVE_PLATE_LINK_DEP = "onSavePlateLinkDep";
    //获取档案号
    private static final String ON_GET_FILE_NO = "onGetFileNo";

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        @SuppressWarnings("rawtypes")
        JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(param, OPT_TYPE);
        switch (optType) {
            case ON_EMP_OF_DET_CHANGE:
                return onEmpOfDetChange(param);
            case ON_ID_VALIDATE:
                return onIdValidate(param);
            case ON_FIND_DEPARTMENT_DATA:
                return onFindDepartmentData();
            case ON_SAVE_PLATE_LINK_DEP:
                return onSavePlateLinkDep(param);
            case ON_GET_FILE_NO:
                return onGetFileNo();
            case "onLoadEmpYearLeave":
                return onLoadEmpYearLeave(param);//加载员工年假
            default:
                break;
        }
        return null;
    }
    
    @Override
    public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        @SuppressWarnings("rawtypes")
        JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        String optType = BaseHelpUtils.getStringValue(param,OPT_TYPE);
        switch (optType) {
        case "onLoadEmpYearLeave":
             onLoadEmpYearLeaveExport(creteria,downFile,request,response,param);//加载员工年假
             break;
        default:
            break;
        }

    }
    
    /**
     *  加载员工年假:导出
     * @param creteria
     * @param downFile
     * @param request
     * @param response
     * @throws Exception
     */
    public void onLoadEmpYearLeaveExport(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response,Map<String, Object> param) throws Exception {
    	List<BaseCalculateAnnualLeaveNew> list = onLoadEmpYearLeaveList(param);
    	if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0) {
    		String ALL_CAPTIONS = "员工编号,员工姓名,员工部门,当年度年假,当年使用的年假,当年剩余年假,当年带薪病假,当年使用带薪病假,剩余带薪病假,上一年年假,上一年使用年假,上一年剩余年假,上一年带薪病假,上一年使用带薪病假,上一年剩余带薪病假,上年度剩余加班（小时）,本年度加班（小时）,本年度使用调休假,剩余加班（小时）";
    		try(PrintStream ps = new PrintStream(downFile, "GBK")){
    			ps.println(ALL_CAPTIONS);
    			for(BaseCalculateAnnualLeaveNew b : list){
    				ps.println(toCSVStringOfBaseCalculateAnnualLeaveNew(b));
    			}
    		}
    	}
	}
    
    /**
     * 加载员工年假:导出
     * @param e
     * @return
     */
    public String toCSVStringOfBaseCalculateAnnualLeaveNew(BaseCalculateAnnualLeaveNew e) {
		StringBuilder sb = new StringBuilder();
		sb.append(e.getEmployeeNo() == null ? "" : e.getEmployeeNo());
		sb.append(",");
		sb.append(e.getEmployeeName() == null ? "" : e.getEmployeeName());
		sb.append(",");
		sb.append(e.getDepartmentName() == null ? "" : e.getDepartmentName());
		sb.append(",");
		sb.append(e.getCurrentYearTotalAnnualLeave() == null ? "" : e.getCurrentYearTotalAnnualLeave());
		sb.append(",");
		sb.append(e.getCurrentYearUsageAmountAnnual() == null ? "" : e.getCurrentYearUsageAmountAnnual());
		sb.append(",");
		sb.append(e.getCurrentRemainingAmountAnnual() == null ? "" : e.getCurrentRemainingAmountAnnual());
		sb.append(",");
		sb.append(e.getCurrentYearTotalWealfareLeave() == null ? "" : e.getCurrentYearTotalWealfareLeave());
		sb.append(",");
		sb.append(e.getCurrentYearUsageAmountWealfare() == null ? "" : e.getCurrentYearUsageAmountWealfare());
		sb.append(",");
		sb.append(e.getCurrentRemainingAmountWealfare() == null ? "" : e.getCurrentRemainingAmountWealfare());
		sb.append(",");
		sb.append(e.getLastYearTotalAnnualLeave() == null ? "" : e.getLastYearTotalAnnualLeave());
		sb.append(",");
		sb.append(e.getLastYearUsageAmountAnnual() == null ? "" : e.getLastYearUsageAmountAnnual());
		sb.append(",");
		sb.append(e.getLastRemainingAmountAnnual() == null ? "" : e.getLastRemainingAmountAnnual());
		sb.append(",");
		sb.append(e.getLastYearTotalWealfareLeave() == null ? "" : e.getLastYearTotalWealfareLeave());
		sb.append(",");
		sb.append(e.getLastYearUsageAmountWealfare() == null ? "" : e.getLastYearUsageAmountWealfare());
		sb.append(",");
		sb.append(e.getLastRemainingAmountWealfare() == null ? "" : e.getLastRemainingAmountWealfare());
		sb.append(",");
		sb.append(e.getLastRemainingLeave() == null ? "" : e.getLastRemainingLeave());
		sb.append(",");
		sb.append(e.getCurrentYearLeave() == null ? "" : e.getCurrentYearLeave());
		sb.append(",");
		sb.append(e.getCurrentYearUsedtime() == null ? "" : e.getCurrentYearUsedtime());
		sb.append(",");
		sb.append(e.getRemainingOvertime() == null ? "" : e.getRemainingOvertime());
		return sb.toString();
	}
    
    
    /**
     * 加载员工年假
     * @param param
     * @return
     * @throws SQLException
     * @throws ParseException
     */
    private String onLoadEmpYearLeave(Map<String, Object> param) throws SQLException, ParseException {
    	BaseCollection<BaseCalculateAnnualLeaveNew> bc = new BaseCollection<>();
    	List<BaseCalculateAnnualLeaveNew> list = onLoadEmpYearLeaveList(param);
    	if(!BaseHelpUtils.isNullOrEmpty(list)) {
    		bc.setCollections(list);
    	}
        return bc.toJSON(0, null);
    }
    
    /**
     *  加载员工年假
     * @param param
     * @return
     * @throws SQLException
     * @throws ParseException
     */
    private List<BaseCalculateAnnualLeaveNew> onLoadEmpYearLeaveList(Map<String, Object> param) throws SQLException, ParseException {
    	List<BaseCalculateAnnualLeaveNew> list = new ArrayList<>();
    	QueryCalculateAnnualLeaveNew query = new QueryCalculateAnnualLeaveNew();
    	ConditionCalculateAnnualLeaveNew con = new ConditionCalculateAnnualLeaveNew();
    	con.setDataFromMap(param);
    	Date currentDate = new Date();
    	//获取当前年份
    	int year = DateUtil.getYear(currentDate);
    	int month = DateUtil.getMonth(currentDate);
    	con.setYear(year);
        BaseCollection<BaseCalculateAnnualLeaveNew> bc = query.runQuery(null, con);
        if(BaseHelpUtils.isNullOrEmpty(bc)) {
        	return list;
        }
        list = bc.getCollections();
        if(BaseHelpUtils.isNullOrEmpty(list) || list.size() == 0) {
        	return list;
        }
        //加载非职能部门的加班小时和已用调休数
        Map<Integer,BigDecimal> userMap = getCurrentUserd(year, month);
        Map<Integer,BigDecimal> overtimeMap = getCurrentOvertime(year, month);
        for(BaseCalculateAnnualLeaveNew e : list) {
        	int empId = BaseHelpUtils.getIntValue(e.getEmployeeId());
        	int plateId = BaseHelpUtils.getIntValue(e.getPlateId());
        	//获取截止当前年度的加班小时数和调休小时数
        	BigDecimal overtimeHours = BaseHelpUtils.getBigDecimalValue(e.getOvertimeHours());
        	BigDecimal userHours = BaseHelpUtils.getBigDecimalValue(e.getUsed());
        	//设置剩余加班(小时)=截止当前年度的加班小时数-截止当前年度的调休小时数
        	BigDecimal remainingOvertime = overtimeHours.subtract(userHours);
        	//获取当前年度的加班小时数和调休小时数
        	BigDecimal overtimeHours_y = BaseHelpUtils.getBigDecimalValue(e.getOvertimeHoursY());
        	BigDecimal userHours_y = BaseHelpUtils.getBigDecimalValue(e.getUsedY());
        	/**
        	 * 本年度使用调休假(小时):职能部门和事业部计算方式不一样
        	 * 1、职能部门计算规则：当前年度的加班小时-当前年度的已调休小时数
        	 * 2、非职能部门计算规则：只加载当前两个月加班小时数和调休小数数：注：已调休小时数，从单独的已调休表获取
        	 * 
        	 */
        	BigDecimal currentYearLeft = BigDecimal.ZERO;//当前年度剩余
        	BigDecimal lastRemainingLeave = BigDecimal.ZERO;//上年度剩余
//            if (plateId == 57 || plateId == 56 || plateId == 58) {
            if (plateId == -999) {//职能部门
        		currentYearLeft = overtimeHours_y.subtract(userHours_y);
        		//上年度剩余=剩余加班(小时)-当前年度剩余
            	lastRemainingLeave = remainingOvertime.subtract(currentYearLeft);
        	}else {
        		overtimeHours_y = BaseHelpUtils.getBigDecimalValue(overtimeMap.get(empId));
        		userHours_y = BaseHelpUtils.getBigDecimalValue(userMap.get(empId));
        		currentYearLeft = overtimeHours_y.subtract(userHours_y);
        		//非职能部门的，总剩余就是当前年度剩余
        		remainingOvertime = currentYearLeft;
        	}
        	e.setRemainingOvertime(remainingOvertime);//总剩余
        	e.setCurrentYearLeave(overtimeHours_y);//当前年度加班
        	e.setCurrentYearUsedtime(userHours_y);//当前年度已使用调休
        	e.setLastRemainingLeave(lastRemainingLeave);//上年度剩余
        }
        return list;
    }
    

    /**
     * 获取档案号
     *
     * @return
     * @throws SQLException
     * @throws ParseException
     */
    private String onGetFileNo() throws SQLException, ParseException {
        FileNumber fileNumberDao = new FileNumber();
        fileNumberDao.setFileNumberId(1);
        fileNumberDao.load();
        Map<String, Object> params = new HashMap<>();
        if (fileNumberDao.load()) {
            int fileNumberMax = fileNumberDao.getFileNumberMax() + 1;
            fileNumberDao.setFileNumberMax(fileNumberMax);
            fileNumberDao.update();
            params.put("fileNumberMax", fileNumberMax);
        }
        BaseCollection<GenericBase> bc = new BaseCollection<>();
        bc.setUserData(params);
        return bc.toJSON(0, null);
    }

    /**
     * 保存业务部门关联归属部门表数据
     *
     * @param param
     * @return
     * @throws SQLException
     * @throws ParseException
     */
    private String onSavePlateLinkDep(Map<String, Object> param) throws SQLException, ParseException {
        //获取业务部门Id
        int plateId = BaseHelpUtils.getIntValue(param, "plateId");
        //获取部门Id数据集
        String ids = BaseHelpUtils.getStringValue(param, "ids");
        //根据当前业务部门Id去加载已绑定的归属部门
        PlateDepartment dao = new PlateDepartment();
        dao.setConditionPlateId("=", plateId);
        if (BaseHelpUtils.isNullOrEmpty(ids)) {
            dao.conditionalDelete();
        } else {
            List<BasePlateDepartment> list = dao.conditionalLoad();
            boolean isEmpty = BaseHelpUtils.isNullOrEmpty(list);
            List<BasePlateDepartment> saveList = new ArrayList<>();
            BasePlateDepartment bean = null;
            String[] idsArr = ids.split(",");
            Map<Integer, Integer> dataMap = new HashMap<>();
            boolean canSave = true;
            for (String idStr : idsArr) {
                canSave = true;
                int id = BaseHelpUtils.getIntValue(idStr);
                dataMap.put(id, id);
                if (isEmpty) {
                    bean = new BasePlateDepartment();
                    bean.setDepartmentId(id);
                    bean.setPlateId(plateId);
                    saveList.add(bean);
                } else {
                    for (BasePlateDepartment e : list) {
                        if (id == BaseHelpUtils.getIntValue(e.getDepartmentId())) {
                            canSave = false;
                            break;
                        }
                    }
                    if (canSave) {
                        bean = new BasePlateDepartment();
                        bean.setDepartmentId(id);
                        bean.setPlateId(plateId);
                        saveList.add(bean);
                    }
                }
            }

            //如果原数据有，但新数据没有，则做删除
            if (!isEmpty) {
                for (BasePlateDepartment e : list) {
                    int id = BaseHelpUtils.getIntValue(e.getDepartmentId());
                    if (!dataMap.containsKey(id)) {
                        dao.clear();
                        dao.setDataFromBase(e);
                        dao.delete();
                    }
                }
            }
            if (!BaseHelpUtils.isNullOrEmpty(saveList)) {
                dao.clear();
                dao.save(saveList);
            }
        }
        BaseCollection<GenericBase> bc = new BaseCollection<>();
        return bc.toJSON(0, null);
    }

    /**
     * 加载部门信息
     *
     * @param
     * @return
     * @throws SQLException
     * @throws ParseException
     */
    private String onFindDepartmentData() throws SQLException, ParseException {
        List<BaseDepartment> list = new ArrayList<>();
        Department dao = new Department();
        dao.setConditionDeleteFlag("=", 0);//过滤掉删除的部门信息
        dao.setConditionParentId(">", 0);
        list = dao.conditionalLoad();
        BaseCollection<BaseDepartment> bc = new BaseCollection<>();
        bc.setCollections(list);
        return bc.toJSON(0, null);
    }

    /**
     * 职员入职身份证号验证 及取出生日期 和计算年龄
     *
     * @param param
     * @return
     * @throws SQLException
     * @throws ParseException
     */
    private String onIdValidate(Map<String, Object> param) throws SQLException, ParseException {
        String id = BaseHelpUtils.getStringValue(param, "id");
        IdcardValidator validate = new IdcardValidator();
        boolean isOk = validate.isValidatedAllIdcard(id);
        String backMsg = "";
        int status = 0;
        List<BaseEmployee> list = new ArrayList<>();

        //身份证不为空才进行相应的判断校验
        if (!BaseHelpUtils.isNullOrEmpty(id)) {
            if (isOk) {//如果身份证正确，取出生日期 及 计算年龄
                if (id.length() == 18) {
                    String birthday = id.substring(6, 14);
                    Date birthDate = new SimpleDateFormat("yyyyMMdd").parse(birthday);
                    Date currentDate = new Date();
                    GregorianCalendar born = new GregorianCalendar();
                    GregorianCalendar now = new GregorianCalendar();
                    born.setTime(birthDate);
                    now.setTime(currentDate);
                    int bornYear = born.get(Calendar.YEAR);
                    int bornMonth = born.get(Calendar.MONTH);
                    int bornDate = born.get(Calendar.DATE);

                    int nowYear = now.get(Calendar.YEAR);
                    int nowMonth = now.get(Calendar.MONTH);
                    int nowDate = now.get(Calendar.DATE);
                    //计算年龄
                    int age = nowYear - bornYear;
                    if (nowMonth <= bornMonth) {
                        if (nowMonth == bornMonth) {
                            if (nowDate < bornDate) age--;
                        } else {
                            age--;
                        }
                    }
                    BaseEmployee bean = new BaseEmployee();
                    bean.setBirth(birthDate);
                    bean.setAge(age);
                    list.add(bean);
                }
            } else {
                backMsg = "请输入正确的身份证号码";
                status = -1;
            }

        }

        BaseCollection<BaseEmployee> bc = new BaseCollection<>();
        bc.setCollections(list);
        return bc.toJSON(status, backMsg);
    }


    /**
     * 部门人员转移
     *
     * @param param
     * @return
     * @throws SQLException
     */
    @SuppressWarnings("unchecked")
    public String onEmpOfDetChange(Map<String, Object> param) throws SQLException {
        //获取部门ID
        int departmentId = BaseHelpUtils.getIntValue(param, "departmentId");
        int plateId = BaseHelpUtils.getIntValue(param, "plateId");
        if (departmentId == 0) {//说明未选择部门
            throw new SQLException("请选择要归集的部门");
        }
        //获取人员列表
        List<BaseEmployee> employeeList = GenericBase.__getList(param.get("employeeList"), BaseEmployee.newInstance());
        if (BaseHelpUtils.isNullOrEmpty(employeeList) || employeeList.size() == 0) {//说明未选择需转移的人员
            throw new SQLException("请选择要转移的人员");
        }
        Employee dao = new Employee();
        for (BaseEmployee e : employeeList) {
            dao.clear();
            //获取人员ID
            int employeeId = e.getEmployeeId();
            dao.setEmployeeId(employeeId);
            if (dao.load()) {
                dao.setDepartmentId(departmentId);
                dao.setPlateId(plateId);
                dao.update();
                try {
                    UserAccountUtils.updateUserAccount(dao.generateBase(), 1);
                } catch (Exception es) {
                    es.printStackTrace();
                }
            }
        }
        BaseCollection<GenericBase> bc = new BaseCollection<>();
        return bc.toJSON(0, "");
    }
    
    /**
     * 获取非职能部门人员的年度加班小时数：加班有效期只有两个月
     * @param startDateYear
     * @param startDateMonth
     * @return
     * @throws SQLException
     */
    public static Map<Integer,BigDecimal> getCurrentOvertime(Integer startDateYear,Integer startDateMonth) throws SQLException{
		Map<Integer,BigDecimal> leaveMap = new HashMap<>();
		EmployeeMonthCheck employeeMonthCheck = new EmployeeMonthCheck();
		List<BaseEmployeeMonthCheck> checkList = new ArrayList<>();
		if (startDateMonth == 1) {
			employeeMonthCheck.clear();
			employeeMonthCheck.setConditionYear("=", startDateYear - 1);
			employeeMonthCheck.setConditionMonth("=", 12);
			List<BaseEmployeeMonthCheck> baseEmployeeMonthChecksTemp1 = employeeMonthCheck.conditionalLoad();
			if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeMonthChecksTemp1) && baseEmployeeMonthChecksTemp1.size() != 0) {
				for (BaseEmployeeMonthCheck baseEmployeeMonthCheck : baseEmployeeMonthChecksTemp1) {
					checkList.add(baseEmployeeMonthCheck);
				}
			}
			employeeMonthCheck.clear();
			employeeMonthCheck.setConditionYear("=", startDateYear);
			employeeMonthCheck.setConditionMonth("=", 1);
			List<BaseEmployeeMonthCheck> baseEmployeeMonthChecksTemp2 = employeeMonthCheck.conditionalLoad();
			if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeMonthChecksTemp2) && baseEmployeeMonthChecksTemp2.size() != 0) {
				for (BaseEmployeeMonthCheck baseEmployeeMonthCheck : baseEmployeeMonthChecksTemp2) {
					checkList.add(baseEmployeeMonthCheck);
				}
			}
			
		} else {
			employeeMonthCheck.setConditionYear("=", startDateYear);
			String month = startDateMonth + "," + (startDateMonth - 1);
			checkList = employeeMonthCheck.conditionalLoad("month in (" + month + ")");
		}
		//计算每个人的加班小时数
		if(!BaseHelpUtils.isNullOrEmpty(checkList) && checkList.size() > 0) {
			for(BaseEmployeeMonthCheck e : checkList) {
				int empId = BaseHelpUtils.getIntValue(e.getEmployeeId());
				BigDecimal overtimeHours = BaseHelpUtils.getBigDecimalValue(leaveMap.get(empId));
				//平时加班时长
				BigDecimal nornalOvertimeHours = BaseHelpUtils.getBigDecimalValue(e.getNornalOvertimeHours());
				//周末加班时长
				BigDecimal weekendOvertimeHours = BaseHelpUtils.getBigDecimalValue(e.getWeekendOvertimeHours());
				//节假日加班时长
				BigDecimal holidayOvertimeHours = BaseHelpUtils.getBigDecimalValue(e.getHolidayOvertimeHours());
				//计算总的加班的时长
				overtimeHours = overtimeHours.add(nornalOvertimeHours.add(weekendOvertimeHours).add(holidayOvertimeHours));
				leaveMap.put(empId, overtimeHours);
			}
		}
		return leaveMap;
	}
    
    /**
     * 加载非职能部门的已用调休数：有效期只有两个月
     * @param startDateYear
     * @param startDateMonth
     * @return
     * @throws SQLException
     */
    public static Map<Integer,BigDecimal> getCurrentUserd(Integer startDateYear,Integer startDateMonth) throws SQLException{
		Map<Integer,BigDecimal> userMap = new HashMap<>();
		CompensatoryLeave cl = new CompensatoryLeave();
		//查询员工的使用的调休假的时长
		List<BaseCompensatoryLeave> baseCompensatoryLeaves = new ArrayList<>();
		if (startDateMonth == 1) {
			cl.clear();
			cl.setConditionYear("=",startDateYear - 1);
			cl.setConditionMonth("=",12);
			cl.setConditionStatus("=",1);
			List<BaseCompensatoryLeave> listTow = cl.conditionalLoad();
			if(!BaseHelpUtils.isNullOrEmpty(listTow)){
				for (BaseCompensatoryLeave b:listTow){
					baseCompensatoryLeaves.add(b);
				}
			}
			cl.clear();
			cl.setConditionYear("=",startDateYear);
			cl.setConditionMonth("=",startDateMonth);
			cl.setConditionStatus("=",1);
			List<BaseCompensatoryLeave> baseList = cl.conditionalLoad();
			if(!BaseHelpUtils.isNullOrEmpty(baseList)){
				for (BaseCompensatoryLeave b:baseList){
					baseCompensatoryLeaves.add(b);
				}
			}
			
		} else {
			cl.clear();
			cl.setConditionYear("=",startDateYear);
			cl.setConditionMonth("=",startDateMonth);
			cl.setConditionStatus("=",1);
			List<BaseCompensatoryLeave> baseList = cl.conditionalLoad();
			if(!BaseHelpUtils.isNullOrEmpty(baseList)){
				for (BaseCompensatoryLeave b:baseList){
					baseCompensatoryLeaves.add(b);
				}
			}

			cl.clear();
			cl.setConditionYear("=",startDateYear);
			cl.setConditionMonth("=",startDateMonth-1);
			cl.setConditionStatus("=",1);
			List<BaseCompensatoryLeave> listTow = cl.conditionalLoad();
			if(!BaseHelpUtils.isNullOrEmpty(listTow)){
				for (BaseCompensatoryLeave b:listTow){
					baseCompensatoryLeaves.add(b);
				}
			}
		}
		//计算每个人的加班小时数
		if(!BaseHelpUtils.isNullOrEmpty(baseCompensatoryLeaves) && baseCompensatoryLeaves.size() > 0) {
			for(BaseCompensatoryLeave e : baseCompensatoryLeaves) {
				int empId = BaseHelpUtils.getIntValue(e.getEmployeeId());
				BigDecimal userHours = BaseHelpUtils.getBigDecimalValue(userMap.get(empId));
				BigDecimal bigDecimalValue = BaseHelpUtils.getBigDecimalValue(e.getTotalCompensatoryLeave());
				//计算总的加班的时长
				userHours = userHours.add(bigDecimalValue);
				userMap.put(empId, userHours);
			}
		}
		return userMap;
	}
    
    public static void main(String[] args) throws SQLException {
    	getCurrentOvertime(2022, 4);
	}

    @Override
    public String getDownloadFileExtension() {
        return "csv";
    }

}
