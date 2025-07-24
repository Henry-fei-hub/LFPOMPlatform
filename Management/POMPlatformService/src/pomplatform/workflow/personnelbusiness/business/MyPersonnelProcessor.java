
package pomplatform.workflow.personnelbusiness.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseAnnualLeave;
import com.pomplatform.db.bean.BaseCompensatoryLeave;
import com.pomplatform.db.bean.BaseEmployeeCheckinout;
import com.pomplatform.db.bean.BaseEmployeeCheckinoutDetail;
import com.pomplatform.db.bean.BaseEmployeeMonthCheck;
import com.pomplatform.db.bean.BaseHolidayManage;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.dao.AnnualLeave;
import com.pomplatform.db.dao.CompensatoryLeave;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.EmployeeCheckinoutDetail;
import com.pomplatform.db.dao.EmployeeMonthCheck;
import com.pomplatform.db.dao.HolidayManage;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.PlateRecord;
import com.pomplatform.db.dao.SystemDictionary;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.common.MapUtils;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.email.ChineseToEnglish;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.servlet.AbstractProcessores;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.bean.BaseSystemProcessAttention;
import delicacy.system.bean.BaseSystemProcessInstanceActivity;
import delicacy.system.bean.BaseSystemProcessPooledTask;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.dao.Employee;
import delicacy.system.dao.SystemProcessAttention;
import delicacy.system.dao.SystemProcessInstanceWithSss;
import delicacy.system.executor.NewCreateWorkFlow;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SelectValueCache;
import delicacy.system.executor.SystemProcessConstants;
import delicacy.system.executor.WorkFlowActivityProcessor;
import delicacy.system.executor.WorkFlowPooledTaskProcessor;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.bean.BaseKeyValue;
import pomplatform.common.utils.StaticUtils;
import pomplatform.employee.bean.BaseEmployeeInfoOfNoSalaryAdjustment;
import pomplatform.employee.bean.BasePositiveEmployeeInfo;
import pomplatform.filemanage.business.FileManageProcessor;
import pomplatform.leavetype.bean.BaseSearchLeaveTypes;
import pomplatform.leavetype.bean.ConditionSearchLeaveTypes;
import pomplatform.leavetype.query.QuerySearchLeaveTypes;
import pomplatform.personnelbusiness.bean.BaseDecryptPersonnelBusiness;
import pomplatform.personnelbusiness.bean.ConditionDecryptPersonnelBusiness;
import pomplatform.personnelbusiness.query.QueryDecryptPersonnelBusiness;
import pomplatform.project.bean.BaseProjectOfProjectManager;
import pomplatform.project.bean.ConditionProjectOfProjectManager;
import pomplatform.project.query.QueryProjectOfProjectManager;
import pomplatform.shift.bean.BaseGetShiftInfoByEmployeeId;
import pomplatform.shift.bean.ConditionGetShiftInfoByEmployeeId;
import pomplatform.shift.business.OnShiftManageProcess;
import pomplatform.shift.query.QueryGetShiftInfoByEmployeeId;
import pomplatform.workflow.bean.BaseGetProcessByTypeAndDepartment;
import pomplatform.workflow.bean.ConditionGetProcessByTypeAndDepartment;
import pomplatform.workflow.personnelbusiness.bean.BaseCheckWorkHandover;
import pomplatform.workflow.personnelbusiness.bean.BaseEmployeeWithEeeee;
import pomplatform.workflow.personnelbusiness.bean.BaseGetProcessComment;
import pomplatform.workflow.personnelbusiness.bean.BaseUsedVacationLeave;
import pomplatform.workflow.personnelbusiness.bean.ConditionCheckWorkHandover;
import pomplatform.workflow.personnelbusiness.bean.ConditionGetProcessComment;
import pomplatform.workflow.personnelbusiness.bean.ConditionUsedVacationLeave;
import pomplatform.workflow.personnelbusiness.dao.EmployeeWithEeeee;
import pomplatform.workflow.personnelbusiness.query.QueryCheckWorkHandover;
import pomplatform.workflow.personnelbusiness.query.QueryGetProcessComment;
import pomplatform.workflow.personnelbusiness.query.QueryUsedVacationLeave;
import pomplatform.workflow.query.QueryGetProcessByTypeAndDepartment;

public class MyPersonnelProcessor implements GenericProcessor {


    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(params, "optType");
        switch (optType) {
            case "getLeaveTypes":
                return getLeaveTypes(params);
            case "calculateDaysAndHours":
                return calculateDaysAndHours(params);
            case "calculateTripDays":
                return calculateTripDays(params);
            case "saveUploadFileAddress":
                return saveUploadFileAddress(params);
            case "createEmailByName":
                return createEmailByName(params);
            case "getResignationInfo":
                return getResignationInfo(params);
            case "needToChangeProjectManager":
                return needToChangeProjectManager(params);
            case "onLoadEmployeeEditData":
                return onLoadEmployeeEditData(params);
            case "getWorkhandovers":
                return getWorkhandovers(params);
            case "getWorkHandoverHtml":
                return getWorkhandoverHtml(params);
            case "getTranseferHtml":
                return getTranseferHtml(params);
            case "getCheckInfoStr":
                return getCheckInfoStr(params);
            case "positiveEmployee":
                return positiveEmployee(params);
            case "getRegularEmployeeHtml":
                return getRegularEmployeeHtml(params);
            case "salaryAdjustment":
                return salaryAdjustment(params);
            case "agreeSalaryAdjustment":
                return agreeSalaryAdjustment(params);
            case "agreeSalaryAdjustmentAttention":
                return agreeSalaryAdjustmentAttention(params);
            case "calculateDaysStartDate":
                return calculateDaysStartDate(params);
            case "FillcheckApplyWorkStartDate":
                return FillcheckApplyWorkStartDate(params);
            case "WorkingHoursDate":
                return WorkingHoursDate(params);
            case "canelHoliday":
                return canelHoliday(params);
            default:
                return null;
        }
    }

    /**
     * 我的工时流程校验时间不能选今天之后的时间
     * @param params
     * @return
     */
    private String WorkingHoursDate(Map<String, Object> params) {
        BaseCollection<BaseEmployeeCheckinout> bc = new BaseCollection<>();
        String startDateStr = BaseHelpUtils.getString(params.get("startDate"));
        Date startDate = GenericBase.__getDate(startDateStr);
        Date endDate = new Date();
        if(startDate.compareTo(endDate)>0){
            return bc.toJSON(-1,null);
        }
        return bc.toJSON();
    }

    /**
     * 处理今天的时间，处理到今天8点到晚上11点50的时间，用来打卡申请的时候查看当天的打卡记录
     * @param params
     * @return
     */
    private String FillcheckApplyWorkStartDate(Map<String, Object> params) {
        BaseCollection<BaseEmployeeCheckinout> bc = new BaseCollection<>();
        String startDateStr = BaseHelpUtils.getString(params.get("startDate"));
        Date startDate = GenericBase.__getDate(startDateStr);
//		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++" + startDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date checkEndDate = calendar.getTime();
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 0);
        Date checkStartDate = calendar.getTime();

        BaseEmployeeCheckinout obj = new BaseEmployeeCheckinout();
        obj.setCheckInTime(checkStartDate);
        obj.setCheckOutTime(checkEndDate);
        List<BaseEmployeeCheckinout> list = new ArrayList<>();
        list.add(obj);
        bc.setCollections(list);
        return bc.toJSON();
    }

    /**
     * 记录时修改传入的开始时间，进行修改
     * @param params
     * @return
     */
    private String calculateDaysStartDate(Map<String, Object> params) {
        BaseCollection<BaseEmployeeCheckinout> bc = new BaseCollection<>();
        String startDateStr = BaseHelpUtils.getString(params.get("startDate"));
        Date startDate = GenericBase.__getDate(startDateStr);
//		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++" + startDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date checkEndDate = calendar.getTime();
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        Date checkStartDate = calendar.getTime();

        BaseEmployeeCheckinout obj = new BaseEmployeeCheckinout();
        obj.setCheckInTime(checkStartDate);
        obj.setCheckOutTime(checkEndDate);
        List<BaseEmployeeCheckinout> list = new ArrayList<>();
        list.add(obj);
        bc.setCollections(list);
        return bc.toJSON();
    }

    /**
     * 职员管理 的 职员修改 加载数据
     *
     * @param params
     * @return
     * @throws SQLException
     */
    private String onLoadEmployeeEditData(Map<String, Object> params) throws SQLException {
        EmployeeWithEeeee dao = new EmployeeWithEeeee();
        dao.setEmployeeId(BaseHelpUtils.getIntValue(params, "employeeId"));
        dao.load();

        List<BaseEmployeeWithEeeee> list = new ArrayList<>();
        BaseEmployeeWithEeeee obj = dao.generateBaseExt();
        BaseCollection<BaseEmployeeWithEeeee> bc = new BaseCollection<>();
        list.add(obj);
        bc.setCollections(list);
        return bc.toJSON();
    }

    /**
     * @param @param  params
     * @param @return
     * @param @throws Exception
     * @return String
     * @throws
     * @Title: calculateTripDays
     * @Description: 含有上午下午时段选择计算工作日
     */
    public String calculateTripDays(Map<String, Object> params) throws Exception {
        int status = 1;
        String errorMessage = null;
        BaseCollection<BasePersonnelBusines> bc = new BaseCollection<>();
        int employeeId = BaseHelpUtils.getIntValue(params.get("employeeId"));
        String startDateStr = BaseHelpUtils.getString(params.get("startDate"));
        String endDateStr = BaseHelpUtils.getString(params.get("endDate"));
        int startDateDetail = BaseHelpUtils.getIntValue(params, "startDateDetail");
        int endDateDetail = BaseHelpUtils.getIntValue(params, "endDateDetail");
        if (BaseHelpUtils.isNullOrEmpty(startDateStr) || BaseHelpUtils.isNullOrEmpty(endDateStr)) {
            return bc.toJSON(-1, "请填写开始时间和结束时间");
        }
        //计算上午或下午的日期换算    开始日期的上午  09:00:00  下午 14:00:00
        //结束日期的上午 12:30:00 下午 18:00:00
        int beginHour = 9;
        int beginMin = 0;
        int endHour = 12;
        int endMin = 30;
        if (startDateDetail == 1) {
            beginHour = 14;
            beginMin = 0;
        }
        if (endDateDetail == 1) {
            endHour = 18;
            endMin = 0;
        }

        Date oriStartDate = GenericBase.__getDate(startDateStr);
        Date oriEndDate = GenericBase.__getDate(endDateStr);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		System.out.println("oriStartDate" + sdf.format(oriStartDate));
//		System.out.println("oriEndDate" + sdf.format(oriEndDate));
        Date startDate = createDateWithDateHourAndMinute(oriStartDate, beginHour, beginMin);
        Date endDate = createDateWithDateHourAndMinute(oriEndDate, endHour, endMin);
//		System.out.println("startDate" + sdf.format(startDate));
//		System.out.println("endDate" + sdf.format(endDate));
        BigDecimal days = getWorkDaysBetweenTwoDate(employeeId, startDate, endDate);
        List<BasePersonnelBusines> list = new ArrayList<>();
        BasePersonnelBusines obj = new BasePersonnelBusines();
        obj.setDays(days);
        list.add(obj);
        bc.setCollections(list);
        return bc.toJSON(status, errorMessage);
    }

    public String getLeaveTypes(Map<String, Object> params) throws Exception {
        int employeeId = BaseHelpUtils.getIntValue(params.get("employeeId"));
        int areaId = BaseHelpUtils.getIntValue(params.get("areaId"));
        int parentId = BaseHelpUtils.getIntValue(params.get("parentId"));
        Integer plateType = null;
        Employee eDao = new Employee();
        if (employeeId > 0  && areaId>0) {
            eDao.setConditionEmployeeId("=", employeeId);

        }
        eDao.unsetSelectFlags();
        eDao.setSelectGender(true);
        eDao.setSelectOnboardDate(true);
        //员工性别（用于查找不同性别的员工所适用的不同假期）
        BaseEmployee bean = eDao.executeQueryOneRow();
        Integer gender = bean.getGender();
        ConditionSearchLeaveTypes condition = new ConditionSearchLeaveTypes();
        condition.setAreaId(areaId);
        condition.setGender(gender);
        condition.setParentId(parentId);
        QuerySearchLeaveTypes query = new QuerySearchLeaveTypes();
        BaseCollection<BaseSearchLeaveTypes> bc = query.executeQuery(null, condition);
        List<BaseSearchLeaveTypes> list = bc.getCollections();
        Calendar c = Calendar.getInstance();
        c.setTime(bean.getOnboardDate());
        c.set(Calendar.YEAR, c.get(Calendar.YEAR) + 10);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date startTimeOfThisYear = calendar.getTime();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 1);
        Date endTimeOfThisYear = calendar.getTime();

        Employee dao1 = new Employee();
        dao1.setConditionEmployeeId("=" , employeeId);
        BaseEmployee baseEmployees = dao1.executeQueryOneRow();//查询出一个员工对象实体
        if (!BaseHelpUtils.isNullOrEmpty(baseEmployees)) {
            Integer plateId = baseEmployees.getPlateId();
            PlateRecord plateRecord = new PlateRecord();//创建一个板块对象
            plateRecord.setConditionPlateId("=", plateId);
            BasePlateRecord basePlateRecord = plateRecord.executeQueryOneRow();//根据员工的板块ID查询一个面板对象
            if (!BaseHelpUtils.isNullOrEmpty(basePlateRecord)) {
                plateType = basePlateRecord.getPlateType();
            }


      /*      //先计算出当年加班时间
            PersonnelBusines dao = new PersonnelBusines();
            dao.setConditionIsCompleted("=", true);
//			dao.setConditionProcessType("=", StaticUtils.PROCESS_TYPE_17);
            dao.addCondition(BasePersonnelBusines.CS_PROCESS_TYPE, "in", StaticUtils.PROCESS_TYPE_17, StaticUtils.PROCESS_TYPE_22, StaticUtils.PROCESS_TYPE_23);
            dao.setConditionEmployeeId("=", employeeId);
            dao.addCondition(BasePersonnelBusines.CS_CREATE_TIME, "between", startTimeOfThisYear, endTimeOfThisYear);
            dao.unsetSelectFlags();
            dao.setSelectHours(true);
            List<BasePersonnelBusines> bpbList = dao.conditionalLoad();
            BigDecimal overTimeHours = BigDecimal.ZERO;
            for (BasePersonnelBusines bpb : bpbList) {
                if (null != bpb.getHours()) {
                    overTimeHours = overTimeHours.add(bpb.getHours());
                }
            }

            ConditionQueryLeaveApplyDays condition2 = new ConditionQueryLeaveApplyDays();
            condition2.setStartTime(startTimeOfThisYear);
            condition2.setEndTime(endTimeOfThisYear);
            condition2.setEmployeeId(employeeId);
            condition2.setType(StaticUtils.LEAVE_TYPE_21);
            QueryQueryLeaveApplyDays query2 = new QueryQueryLeaveApplyDays();
            BaseCollection<BaseQueryLeaveApplyDays> collection = query2.executeQuery(null, condition2);
            if (null != collection && null != collection.getCollections() && !collection.getCollections().isEmpty()) {
                BaseQueryLeaveApplyDays bqlad = collection.getCollections().get(0);
                if (null != bqlad.getDays()) {
                    overTimeHours = overTimeHours.subtract(bqlad.getDays().multiply(StaticUtils.TOTAL_HOURS));
                }
                if (null != bqlad.getHours()) {
                    overTimeHours = overTimeHours.subtract(bqlad.getHours());
                }
            }*/
            //计算剩余的调休小时数（但是会有时间不同步的问题， 该地方是以当前时间计算的，但是实际计算请假的时间是选择的开始时间和结束时间为准）
            BigDecimal overTimeHours = getRemainingOvertime(employeeId, new Date());
            for (BaseSearchLeaveTypes obj : list) {
                if (obj.getLeaveTypeId().equals(StaticUtils.LEAVE_TYPE_21) ) {
                    obj.setDays(overTimeHours);
                    obj.setPlateType(plateType);
                }
            }
            bc.setCollections(list);
            return bc.toJSON();
        }
        throw new Exception("数据缺失");
    }


    public String calculateDaysAndHours(Map<String, Object> params) throws Exception {
        BaseCollection<BasePersonnelBusines> bc = new BaseCollection<>();
        BasePersonnelBusines be = new BasePersonnelBusines();
        be.setDataFromMap(params);

        Date startDate = be.getStartDate();
        Date endDate = be.getEndDate();

        if (BaseHelpUtils.isNullOrEmpty(startDate) || BaseHelpUtils.isNullOrEmpty(endDate)) {
            return bc.toJSON(-1, "请填写开始时间和结束时间");
        }

        if (startDate.after(endDate)) {
            return bc.toJSON(-1, "开始时间不能晚于结束时间");
        }
        int employeeId = BaseHelpUtils.getIntValue(params.get("employeeId"));
        int type = BaseHelpUtils.getIntValue(params.get("type"));
        BigDecimal maxDays = BaseHelpUtils.getBigDecimalValue(params.get("maxDays"));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        //获取请假开始时间的年份和月份
        int startDateYear = calendar.get(Calendar.YEAR);
        int startDateMonth = calendar.get(Calendar.MONTH) + 1;
        //获取请假结束时间的年份和月份
        calendar.clear();
        calendar.setTime(endDate);
        int endDateYear = calendar.get(Calendar.YEAR);
        int endDateMonth = calendar.get(Calendar.MONTH) + 1;
        //获取当前时间的年份和月份
        calendar.clear();
        calendar.setTime(new Date());
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        if (type == StaticUtils.LEAVE_TYPE_1) {//产假
            BigDecimal day = getNormalDaysBetweenTwoDate(startDate, endDate);
            Object[] subTypes = BaseHelpUtils.getString(params.get("subType")).split(",");
            Integer[] types = new Integer[subTypes.length + 1];
            int length = subTypes.length;
            for (int i = 0; i < length; i++) {
                types[i] = BaseHelpUtils.getIntValue(subTypes[i]);
            }
            types[length] = type;
            if (day.compareTo(maxDays) > 0) {
                return bc.toJSON(-1, "请假天数超过该假期的最大值：<font style = 'color:red'>" + maxDays + "天</font>");
            } else {
                List<BasePersonnelBusines> list = new ArrayList<>();
                BasePersonnelBusines obj = new BasePersonnelBusines();
                obj.setDays(day);
                list.add(obj);
                bc.setCollections(list);
                return bc.toJSON();
            }
        } else if (type == StaticUtils.LEAVE_TYPE_6) {//产检假
            BigDecimal day = getNormalDaysBetweenTwoDate(startDate, endDate);
            if (day.compareTo(BigDecimal.ONE) > 0) {//产检假控制每次申请最多只能申请1天
                return bc.toJSON(-1, "产检假每次最多只能申请<font style = 'color:red'>1天</font>");
            } else {
                List<BasePersonnelBusines> list = new ArrayList<>();
                BasePersonnelBusines obj = new BasePersonnelBusines();
                obj.setDays(day);
                list.add(obj);
                bc.setCollections(list);
                return bc.toJSON();
            }
        } else if (type == StaticUtils.LEAVE_TYPE_7) {//陪护假
            BigDecimal day = getNormalDaysBetweenTwoDate(startDate, endDate);
            if (day.compareTo(maxDays) > 0) {
                return bc.toJSON(-1, "请假天数超过该假期的最大值：<font style = 'color:red'>" + maxDays + "天</font>");
            }
            List<BasePersonnelBusines> list = new ArrayList<>();
            BasePersonnelBusines obj = new BasePersonnelBusines();
            obj.setDays(day);
            list.add(obj);
            bc.setCollections(list);
            return bc.toJSON();
        } else if (type == StaticUtils.LEAVE_TYPE_8) {//婚假
            BigDecimal day = getNormalDaysBetweenTwoDate(startDate, endDate);
            if (day.compareTo(maxDays) > 0) {
                return bc.toJSON(-1, "请假天数超过该假期的最大值：<font style = 'color:red'>" + maxDays + "天</font>");
            }
            List<BasePersonnelBusines> list = new ArrayList<>();
            BasePersonnelBusines obj = new BasePersonnelBusines();
            obj.setDays(day);
            list.add(obj);
            bc.setCollections(list);
            return bc.toJSON();
        } else if (type == StaticUtils.LEAVE_TYPE_9) {//丧假
            BigDecimal day = getNormalDaysBetweenTwoDate(startDate, endDate);
            if (day.compareTo(maxDays) > 0) {
                return bc.toJSON(-1, "请假天数超过该假期的最大值：<font style = 'color:red'>" + maxDays + "天</font>");
            }
            List<BasePersonnelBusines> list = new ArrayList<>();
            BasePersonnelBusines obj = new BasePersonnelBusines();
            obj.setDays(day);
            list.add(obj);
            bc.setCollections(list);
            return bc.toJSON();
        } else if (type == StaticUtils.LEAVE_TYPE_12) {//计划生育假
            BigDecimal day = getNormalDaysBetweenTwoDate(startDate, endDate);
            if (day.compareTo(maxDays) > 0) {
                return bc.toJSON(-1, "请假天数超过该假期的最大值：<font style = 'color:red'>" + maxDays + "天</font>");
            }
            List<BasePersonnelBusines> list = new ArrayList<>();
            BasePersonnelBusines obj = new BasePersonnelBusines();
            obj.setDays(day);
            list.add(obj);
            bc.setCollections(list);
            return bc.toJSON();
        } else if (type == StaticUtils.LEAVE_TYPE_21) {//调休
            com.pomplatform.db.dao.Employee employee = new com.pomplatform.db.dao.Employee();
            employee.setEmployeeId(employeeId);
            if (!employee.load()) {
                return bc.toJSON(-1, "数据异常: 没有查询到员工的数据");
            }

            if (startDateYear != endDateYear && startDateMonth != endDateMonth) {
                return bc.toJSON(-1, "调休假时间必须在同一个月内");
            }
            com.pomplatform.db.bean.BaseEmployee baseEmployee = employee.generateBase();
            int plateId = BaseHelpUtils.getIntValue(baseEmployee.getPlateId());
            if (plateId == 0) {
                return bc.toJSON(-1, "请假员工没有归属的业务部门!");
            }
            //员工加班的总时长
            BigDecimal overtimeHours = BigDecimal.ZERO;
            //员工的使用的调休假的时间
            BigDecimal userEd = BigDecimal.ZERO;
            //查询员工的加班时长
            EmployeeMonthCheck employeeMonthCheck = new EmployeeMonthCheck();
            List<BaseEmployeeMonthCheck> baseEmployeeMonthChecks = new ArrayList<>();
            //查询员工的使用的调休假的时长
            QueryUsedVacationLeave queryUsedVacationLeave = new QueryUsedVacationLeave();
            ConditionUsedVacationLeave conditionUsedVacationLeave = new ConditionUsedVacationLeave();
            CompensatoryLeave cl = new CompensatoryLeave();
            List<BaseCompensatoryLeave> baseCompensatoryLeaves = new ArrayList<>();
            //如果部门是人力资源部，行政部，财务部,加班时间是不清空的
//            if (plateId == 57 || plateId == 56 || plateId == 58) {
            if (plateId == -999) {
                employeeMonthCheck.clear();
                //查询员工所有的加班时长
                employeeMonthCheck.setConditionEmployeeId("=", employeeId);
                baseEmployeeMonthChecks = employeeMonthCheck.conditionalLoad();
                //查询员工所有的申请的调休假的时间
                conditionUsedVacationLeave.setEmployeeId(employeeId);
                BaseCollection<BaseUsedVacationLeave> baseUsedVacationLeaveBaseCollection = queryUsedVacationLeave.executeQuery(null, conditionUsedVacationLeave);
                if (!BaseHelpUtils.isNullOrEmpty(baseUsedVacationLeaveBaseCollection) && baseUsedVacationLeaveBaseCollection.getCollections().size() != 0) {
                    List<BaseUsedVacationLeave> collections = baseUsedVacationLeaveBaseCollection.getCollections();
                    for (BaseUsedVacationLeave baseUsedVacationLeave : collections) {
                        BigDecimal bigDecimalValue = BaseHelpUtils.getBigDecimalValue(baseUsedVacationLeave.getUsed());
                        userEd = userEd.add(bigDecimalValue);
                    }
                }
            }else{
                if (startDateMonth == 1) {
                    employeeMonthCheck.clear();
                    employeeMonthCheck.setConditionYear("=", startDateYear - 1);
                    employeeMonthCheck.setConditionEmployeeId("=", employeeId);
                    employeeMonthCheck.setConditionMonth("=", 12);
                    List<BaseEmployeeMonthCheck> baseEmployeeMonthChecksTemp1 = employeeMonthCheck.conditionalLoad();
                    if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeMonthChecksTemp1) && baseEmployeeMonthChecksTemp1.size() != 0) {
                        for (BaseEmployeeMonthCheck baseEmployeeMonthCheck : baseEmployeeMonthChecksTemp1) {
                            baseEmployeeMonthChecks.add(baseEmployeeMonthCheck);
                        }
                    }
                    employeeMonthCheck.clear();
                    employeeMonthCheck.setConditionYear("=", startDateYear);
                    employeeMonthCheck.setConditionEmployeeId("=", employeeId);
                    employeeMonthCheck.setConditionMonth("=", 1);
                    List<BaseEmployeeMonthCheck> baseEmployeeMonthChecksTemp2 = employeeMonthCheck.conditionalLoad();
                    if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeMonthChecksTemp2) && baseEmployeeMonthChecksTemp2.size() != 0) {
                        for (BaseEmployeeMonthCheck baseEmployeeMonthCheck : baseEmployeeMonthChecksTemp2) {
                            baseEmployeeMonthChecks.add(baseEmployeeMonthCheck);
                        }
                    }
                } else {
                    employeeMonthCheck.setConditionYear("=", startDateYear);
                    employeeMonthCheck.setConditionEmployeeId("=", employeeId);
                    String month = startDateMonth + "," + (startDateMonth - 1);
                    baseEmployeeMonthChecks = employeeMonthCheck.conditionalLoad("month in (" + month + ")");
                }

                //查询员工请假时间相近的两个月的使用的加班的时长
                if (startDateMonth == 1) {
                    cl.clear();
                    cl.setConditionEmployeeId("=",employeeId);
                    cl.setConditionYear("=",startDateYear - 1);
                    cl.setConditionMonth("=",12);
                    cl.setConditionStatus("=",1);
                    List<BaseCompensatoryLeave> list = cl.conditionalLoad();
                    if(!BaseHelpUtils.isNullOrEmpty(list)){
                        for (BaseCompensatoryLeave b:list){
                            baseCompensatoryLeaves.add(b);
                        }
                    }
                    cl.clear();
                    cl.setConditionEmployeeId("=",employeeId);
                    cl.setConditionYear("=",startDateYear);
                    cl.setConditionMonth("=",startDateMonth);
                    cl.setConditionStatus("=",1);
                    List<BaseCompensatoryLeave> baseList = cl.conditionalLoad();
                    if(!BaseHelpUtils.isNullOrEmpty(baseList)){
                        for (BaseCompensatoryLeave b:baseList){
                            baseCompensatoryLeaves.add(b);
                        }
                    }

                }else{
                    cl.clear();
                    cl.setConditionEmployeeId("=",employeeId);
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
                    cl.setConditionEmployeeId("=",employeeId);
                    cl.setConditionYear("=",startDateYear);
                    cl.setConditionMonth("=",startDateMonth-1);
                    cl.setConditionStatus("=",1);
                    List<BaseCompensatoryLeave> list = cl.conditionalLoad();
                    if(!BaseHelpUtils.isNullOrEmpty(list)){
                        for (BaseCompensatoryLeave b:list){
                            baseCompensatoryLeaves.add(b);
                        }
                    }
                }

                if (!BaseHelpUtils.isNullOrEmpty(baseCompensatoryLeaves) && baseCompensatoryLeaves.size() != 0) {
                    for (BaseCompensatoryLeave baseUsedVacationLeave : baseCompensatoryLeaves) {
                        BigDecimal bigDecimalValue = BaseHelpUtils.getBigDecimalValue(baseUsedVacationLeave.getTotalCompensatoryLeave());
                        userEd = userEd.add(bigDecimalValue);
                    }
                }
            }

            if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeMonthChecks) && baseEmployeeMonthChecks.size() != 0) {
                for (BaseEmployeeMonthCheck baseEmployeeMonthCheck : baseEmployeeMonthChecks) {
                    //平时加班时长
                    BigDecimal nornalOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getNornalOvertimeHours());
                    //周末加班时长
                    BigDecimal weekendOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getWeekendOvertimeHours());
                    //节假日加班时长
                    BigDecimal holidayOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getHolidayOvertimeHours());
                    //计算总的加班的时长
                    overtimeHours = overtimeHours.add(nornalOvertimeHours.add(weekendOvertimeHours).add(holidayOvertimeHours));
                }
            }

            //修改的，要减去原本已申请的调休时间
            if (params.containsKey("subtractDays")) {
                BigDecimal days = new BigDecimal(params.get("subtractDays").toString());
                userEd = userEd.subtract(days.multiply(new BigDecimal("7")));
            }
            if (params.containsKey("subtractHours")) {
                userEd = userEd.subtract(new BigDecimal(params.get("subtractHours").toString()));
            }
            //剩余的调休的时长
            BigDecimal remainingTime = overtimeHours.subtract(userEd);

            BigDecimal times = getWorkHoursBetweenTwoDate(employeeId, startDate, endDate);
            BigDecimal hours = times.divide(new BigDecimal(DateUtil.ONEHOUR_MILLISECONDS), 2, BigDecimal.ROUND_HALF_UP);
            //比较剩余的调休时长是否够
            if (remainingTime.compareTo(hours) == -1) {
                return bc.toJSON(-1, "剩余的调休时长不够本次调休");
            }
            //判断调休假最小的请假单位
            calendar.setTime(startDate);
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) -1);
            calendar.set(Calendar.HOUR_OF_DAY, 22);
            calendar.set(Calendar.MINUTE, 40);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            Date checkStartDate = calendar.getTime();
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
            calendar.set(Calendar.HOUR_OF_DAY, 6);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            Date checkEndDate = calendar.getTime();
            EmployeeCheckinoutDetail checkDao = new EmployeeCheckinoutDetail();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            checkDao.setConditionEmployeeId("=", employeeId);
            List<BaseEmployeeCheckinoutDetail> checkList = null;
            if(null!=checkDao){
                checkList = checkDao.conditionalLoad(BaseEmployeeCheckinoutDetail.CS_CHECK_TIME + " >= '" + format.format(checkStartDate) + "' and " + BaseEmployeeCheckinoutDetail.CS_CHECK_TIME + " <= '" + format.format(checkEndDate) + "'");
            }
            List<BasePersonnelBusines> list = new ArrayList<>();
            BasePersonnelBusines obj = new BasePersonnelBusines();
            //调休开始时间的前一天的打卡时间为23:00到第二天的6点则允许最少调休一个小时
            if (!BaseHelpUtils.isNullOrEmpty(checkList) && checkList.size() != 0) {
                //请假时间最少为3.5小时
                if (hours.compareTo(new BigDecimal("3")) == -1) {
                    calendar.setTime(startDate);
                    int hour = calendar.get(Calendar.HOUR_OF_DAY);
                    int  minute = calendar.get(Calendar.MINUTE);
                    if(hour>9 ){
                        return bc.toJSON(-1, "调休假少于3小时,请从9点开始");
                    }else if (hour==9 && minute>0){
                        return bc.toJSON(-1, "调休假少于3小时,请从9点开始");
                    }
                }

                //请假时间最少为一小时
                if (hours.compareTo(new BigDecimal("0.5")) == -1) {
                    return bc.toJSON(-1, "调休假至少选择0.5小时");
                }
                BigDecimal[] bigDecimals = hours.divideAndRemainder(BigDecimal.ONE);
                if (new BigDecimal("0.5").compareTo(bigDecimals[1]) == -1) {
                    hours = bigDecimals[0].add(BigDecimal.ONE);
                } else if((new BigDecimal("0.5").compareTo(bigDecimals[1]) == 0)) {
                    hours = bigDecimals[0].add(new BigDecimal("0.5"));
                }else if(new BigDecimal("0.5").compareTo(bigDecimals[1]) == 1 && bigDecimals[1].compareTo(BigDecimal.ZERO) == 1){
                    hours = bigDecimals[0].add(new BigDecimal("0.5"));
                }else{
                    hours = bigDecimals[0].add(BigDecimal.ZERO);
                }
                BigDecimal[] bigDecimals1 = hours.divideAndRemainder(new BigDecimal("7"));
                obj.setDays(bigDecimals1[0]);
                obj.setHours(bigDecimals1[1]);
            }
            //前一天没有加班到23点，至少调休3.5小时
            else {
                //请假时间最少为3.5小时
                if (hours.compareTo(new BigDecimal("3")) == -1) {
                    return bc.toJSON(-1, "调休假至少选择3小时");
                }
                BigDecimal[] bigDecimals = hours.divideAndRemainder(BigDecimal.ONE);
                if (new BigDecimal("0.5").compareTo(bigDecimals[1]) == -1) {
                    hours = bigDecimals[0].add(BigDecimal.ONE);
                } else if((new BigDecimal("0.5").compareTo(bigDecimals[1]) == 0)) {
                    hours = bigDecimals[0].add(new BigDecimal("0.5"));
                }else if(new BigDecimal("0.5").compareTo(bigDecimals[1]) == 1 && bigDecimals[1].compareTo(BigDecimal.ZERO) == 1){
                    hours = bigDecimals[0].add(new BigDecimal("0.5"));
                }else{
                    hours = bigDecimals[0].add(BigDecimal.ZERO);
                }
                BigDecimal[] bigDecimals1 = hours.divideAndRemainder(new BigDecimal("7"));
                obj.setDays(bigDecimals1[0]);
                obj.setHours(bigDecimals1[1]);
            }
            list.add(obj);
            bc.setCollections(list);
            return bc.toJSON();
        } else if (type == StaticUtils.LEAVE_TYPE_19 || type == StaticUtils.LEAVE_TYPE_20 ) {//事假、病假
            PersonnelBusines personnelBusines = new PersonnelBusines();
            //获取请假时间最小单位为0.5天
            BigDecimal workDaysBetweenTwoDate = getWorkDaysBetweenTwoDate(employeeId, startDate, endDate);

            List<BasePersonnelBusines> list = new ArrayList<>();
            BasePersonnelBusines obj = new BasePersonnelBusines();
            obj.setDays(workDaysBetweenTwoDate);
            list.add(obj);
            bc.setCollections(list);
            return bc.toJSON();

        } else if (type == StaticUtils.LEAVE_TYPE_22) {//年假
            if (startDateYear != endDateYear) {
                return bc.toJSON(-1, "请假开始时间和结束时间必须在同一年");
            }
            if (startDateMonth <= 3 && endDateMonth > 3) {
                return bc.toJSON(-1, "请假开始时间和结束时间不能跨过三月份");
            }
            //获取年假的请假时间最小单位为0.5天
            BigDecimal workDaysBetweenTwoDate = getWorkDaysBetweenTwoDate(employeeId, startDate, endDate);
            BigDecimal availableAnnualLeave = BigDecimal.ZERO;
            //请假时间在当前时间之前的情况
            if (startDate.compareTo(new Date()) == -1) {
                //请假时间在同一年的情况
                if (currentYear == startDateYear) {
                    //请假时间以及当前时间都在3月之内则可以用两年的年假
                    if (currentMonth <= 3 && startDateMonth <= 3) {
                        availableAnnualLeave = getEmployeeAnnualLeave(startDateYear, employeeId, 1);
                    }
                    //其他情况都是只能使用一年的年假
                    else {
                        availableAnnualLeave = getEmployeeAnnualLeave(startDateYear, employeeId, 2);
                    }
                }
                //请假的年份在当前年份之前---都只能使用一年的年假
                else if (currentYear > startDateYear) {
                    availableAnnualLeave = getEmployeeAnnualLeave(startDateYear, employeeId, 2);
                }
            }//请假时间在当前时间之后的情况---不需要判断当前时间
            else {
                if (startDateMonth <= 3) {
                    availableAnnualLeave = getEmployeeAnnualLeave(startDateYear, employeeId, 1);
                } else {
                    availableAnnualLeave = getEmployeeAnnualLeave(startDateYear, employeeId, 2);
                }
            }
            //在选择请假时间的时候不检验时间是否够，撤销修改才能校验
			/*if (workDaysBetweenTwoDate.compareTo(availableAnnualLeave) == 1) {
				return bc.toJSON(-1, "剩余的年假天数不够本次的请假时长");
			}*/
            List<BasePersonnelBusines> list = new ArrayList<>();
            BasePersonnelBusines obj = new BasePersonnelBusines();
            obj.setDays(workDaysBetweenTwoDate);
            list.add(obj);
            bc.setCollections(list);
            return bc.toJSON();

        } else if (type == StaticUtils.LEAVE_TYPE_23) {//其他假期
            BigDecimal days = getWorkDaysBetweenTwoDate(employeeId, startDate, endDate);
            List<BasePersonnelBusines> list = new ArrayList<>();
            BasePersonnelBusines obj = new BasePersonnelBusines();
            obj.setDays(days);
            list.add(obj);
            bc.setCollections(list);
            return bc.toJSON();
        } else if (type == 0) {
            List<BasePersonnelBusines> list = new ArrayList<>();
            BasePersonnelBusines obj = new BasePersonnelBusines();
            BigDecimal times = getWorkHoursBetweenTwoDate(employeeId, startDate, endDate);
            BigDecimal hours = times.divide(new BigDecimal(DateUtil.ONEHOUR_MILLISECONDS), 2, BigDecimal.ROUND_HALF_UP);
            BigDecimal[] bigDecimals = hours.divideAndRemainder(BigDecimal.ONE);
            if (new BigDecimal("0.5").compareTo(bigDecimals[1]) == -1) {
                hours = bigDecimals[0].add(BigDecimal.ONE);
            } else if((new BigDecimal("0.5").compareTo(bigDecimals[1]) == 0)) {
                hours = bigDecimals[0].add(new BigDecimal("0.5"));
            }else if(new BigDecimal("0.5").compareTo(bigDecimals[1]) == 1 && bigDecimals[1].compareTo(BigDecimal.ZERO) == 1){
                hours = bigDecimals[0].add(new BigDecimal("0.5"));
            }else{
                hours = bigDecimals[0].add(BigDecimal.ZERO);
            }

            BigDecimal[] bigDecimals1 = hours.divideAndRemainder(new BigDecimal("7"));
            obj.setDays(bigDecimals1[0]);
            obj.setHours(bigDecimals1[1]);
            list.add(obj);
            bc.setCollections(list);
            return bc.toJSON();
        }
        return bc.toJSON(-1, "数据有误");
    }

    private BigDecimal getRemainingOvertime(int employeeId, Date startDate) throws SQLException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        //获取请假开始时间的年份和月份
        int startDateYear = calendar.get(Calendar.YEAR);
        int startDateMonth = calendar.get(Calendar.MONTH) + 1;
        Employee employee = new Employee();
        employee.setEmployeeId( employeeId);
        employee.load();
        Integer plateId = employee.getPlateId();
        //员工加班的总时长
        BigDecimal overtimeHours = BigDecimal.ZERO;
        //员工的使用的调休假的时间
        BigDecimal userEd = BigDecimal.ZERO;
        //查询员工的加班时长
        EmployeeMonthCheck employeeMonthCheck = new EmployeeMonthCheck();
        List<BaseEmployeeMonthCheck> baseEmployeeMonthChecks = new ArrayList<>();
        //查询员工的使用的调休假的时长
        QueryUsedVacationLeave queryUsedVacationLeave = new QueryUsedVacationLeave();
        ConditionUsedVacationLeave conditionUsedVacationLeave = new ConditionUsedVacationLeave();
        CompensatoryLeave cl = new CompensatoryLeave();
        List<BaseCompensatoryLeave> baseCompensatoryLeaves = new ArrayList<>();
        //如果部门是人力资源部，行政部，财务部,加班时间是不清空的
//        if (plateId == 57 || plateId == 56 || plateId == 58) {
        if (plateId == -999) {
            employeeMonthCheck.clear();
            //查询员工所有的加班时长
            employeeMonthCheck.setConditionEmployeeId("=", employeeId);
            baseEmployeeMonthChecks = employeeMonthCheck.conditionalLoad();
            //查询员工所有的申请的调休假的时间
            conditionUsedVacationLeave.setEmployeeId(employeeId);
            BaseCollection<BaseUsedVacationLeave> baseUsedVacationLeaveBaseCollection = queryUsedVacationLeave.executeQuery(null, conditionUsedVacationLeave);
            if (!BaseHelpUtils.isNullOrEmpty(baseUsedVacationLeaveBaseCollection) && baseUsedVacationLeaveBaseCollection.getCollections().size() != 0) {
                List<BaseUsedVacationLeave> collections = baseUsedVacationLeaveBaseCollection.getCollections();
                for (BaseUsedVacationLeave baseUsedVacationLeave : collections) {
                    BigDecimal bigDecimalValue = BaseHelpUtils.getBigDecimalValue(baseUsedVacationLeave.getUsed());
                    userEd = userEd.add(bigDecimalValue);
                }
            }
        }else{
            if (startDateMonth == 1) {
                employeeMonthCheck.clear();
                employeeMonthCheck.setConditionYear("=", startDateYear - 1);
                employeeMonthCheck.setConditionEmployeeId("=", employeeId);
                employeeMonthCheck.setConditionMonth("=", 12);
                List<BaseEmployeeMonthCheck> baseEmployeeMonthChecksTemp1 = employeeMonthCheck.conditionalLoad();
                if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeMonthChecksTemp1) && baseEmployeeMonthChecksTemp1.size() != 0) {
                    for (BaseEmployeeMonthCheck baseEmployeeMonthCheck : baseEmployeeMonthChecksTemp1) {
                        baseEmployeeMonthChecks.add(baseEmployeeMonthCheck);
                    }
                }
                employeeMonthCheck.clear();
                employeeMonthCheck.setConditionYear("=", startDateYear);
                employeeMonthCheck.setConditionEmployeeId("=", employeeId);
                employeeMonthCheck.setConditionMonth("=", 1);
                List<BaseEmployeeMonthCheck> baseEmployeeMonthChecksTemp2 = employeeMonthCheck.conditionalLoad();
                if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeMonthChecksTemp2) && baseEmployeeMonthChecksTemp2.size() != 0) {
                    for (BaseEmployeeMonthCheck baseEmployeeMonthCheck : baseEmployeeMonthChecksTemp2) {
                        baseEmployeeMonthChecks.add(baseEmployeeMonthCheck);
                    }
                }
            } else {
                employeeMonthCheck.setConditionYear("=", startDateYear);
                employeeMonthCheck.setConditionEmployeeId("=", employeeId);
                String month = startDateMonth + "," + (startDateMonth - 1);
                baseEmployeeMonthChecks = employeeMonthCheck.conditionalLoad("month in (" + month + ")");
            }

            //查询员工请假时间相近的两个月的使用的加班的时长
            if (startDateMonth == 1) {
                cl.clear();
                cl.setConditionEmployeeId("=",employeeId);
                cl.setConditionYear("=",startDateYear - 1);
                cl.setConditionMonth("=",12);
                cl.setConditionStatus("=",1);
                List<BaseCompensatoryLeave> list = cl.conditionalLoad();
                if(!BaseHelpUtils.isNullOrEmpty(list)){
                    for (BaseCompensatoryLeave b:list){
                        baseCompensatoryLeaves.add(b);
                    }
                }
                cl.clear();
                cl.setConditionEmployeeId("=",employeeId);
                cl.setConditionYear("=",startDateYear);
                cl.setConditionMonth("=",startDateMonth);
                cl.setConditionStatus("=",1);
                List<BaseCompensatoryLeave> baseList = cl.conditionalLoad();
                if(!BaseHelpUtils.isNullOrEmpty(baseList)){
                    for (BaseCompensatoryLeave b:baseList){
                        baseCompensatoryLeaves.add(b);
                    }
                }

            }else{
                cl.clear();
                cl.setConditionEmployeeId("=",employeeId);
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
                cl.setConditionEmployeeId("=",employeeId);
                cl.setConditionYear("=",startDateYear);
                cl.setConditionMonth("=",startDateMonth-1);
                cl.setConditionStatus("=",1);
                List<BaseCompensatoryLeave> list = cl.conditionalLoad();
                if(!BaseHelpUtils.isNullOrEmpty(list)){
                    for (BaseCompensatoryLeave b:list){
                        baseCompensatoryLeaves.add(b);
                    }
                }
            }

            if (!BaseHelpUtils.isNullOrEmpty(baseCompensatoryLeaves) && baseCompensatoryLeaves.size() != 0) {
                for (BaseCompensatoryLeave baseUsedVacationLeave : baseCompensatoryLeaves) {
                    BigDecimal bigDecimalValue = BaseHelpUtils.getBigDecimalValue(baseUsedVacationLeave.getTotalCompensatoryLeave());
                    userEd = userEd.add(bigDecimalValue);
                }
            }
        }


        if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeMonthChecks) && baseEmployeeMonthChecks.size() != 0) {
            for (BaseEmployeeMonthCheck baseEmployeeMonthCheck : baseEmployeeMonthChecks) {
                //平时加班时长
                BigDecimal nornalOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getNornalOvertimeHours());
                //周末加班时长
                BigDecimal weekendOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getWeekendOvertimeHours());
                //节假日加班时长
                BigDecimal holidayOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getHolidayOvertimeHours());
                //计算总的加班的时长
                overtimeHours = overtimeHours.add(nornalOvertimeHours.add(weekendOvertimeHours).add(holidayOvertimeHours));
            }
        }

        BigDecimal subtract = overtimeHours.subtract(userEd);
        return subtract;
    }

    /**
     * @author liubin
     * @date 2019/12/16 16:11
     * @param
     * @return
     * @description: 计算员工剩余的可用年假!
     */
    public BigDecimal getEmployeeAnnualLeave(int startDateYear, int employeeId, int type) throws SQLException {
        BigDecimal annualLeaveDay = BigDecimal.ZERO;
        AnnualLeave annualLeave = new AnnualLeave();
        annualLeave.setConditionEmployeeId("=", employeeId);
        List<BaseAnnualLeave> baseAnnualLeaves = new ArrayList<>();
        //查询两年的年假
        if (type == 1) {
            String year = startDateYear + "," + (startDateYear - 1);
            baseAnnualLeaves = annualLeave.conditionalLoad("year in (" + year + ")");
        }//查询一年的年假
        else if (type == 2) {
            annualLeave.setConditionYear("=", startDateYear);
            baseAnnualLeaves = annualLeave.conditionalLoad();
        }
        if (!BaseHelpUtils.isNullOrEmpty(baseAnnualLeaves) && baseAnnualLeaves.size() != 0) {
            for (BaseAnnualLeave baseAnnualLeaf : baseAnnualLeaves) {
                BigDecimal totalAnnualLeave = BaseHelpUtils.getBigDecimalValue(baseAnnualLeaf.getTotalAnnualLeave());
                BigDecimal usageAmountAnnual = BaseHelpUtils.getBigDecimalValue(baseAnnualLeaf.getUsageAmountAnnual());
                BigDecimal subtract = totalAnnualLeave.subtract(usageAmountAnnual);
                annualLeaveDay = annualLeaveDay.add(subtract);
            }
        }
        return annualLeaveDay;
    }

    /**
     * 计算并返回两个时间之间相隔的自然日天数，最小单位：0.5天
     *
     * @param startDate
     * @param endDate
     * @return
     * @throws Exception
     */
    public BigDecimal getNormalDaysBetweenTwoDate(Date startDate, Date endDate) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endDate);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long time = calendar.getTime().getTime();
        calendar.setTime(startDate);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        time -= calendar.getTime().getTime();
        if (time < 0) {
            throw new Exception("开始时间必须早于结束时间");
        }
        double startDays = 0;//记录开始日期算多少天（0、0.5、1）
        double endDays = 0;//记录结束日期算多少天（0、0.5、1）
        String[] startArr = StaticUtils.WORK_START.split(":");
        String[] midArr = StaticUtils.REST_START.split(":");
        String[] endArr = StaticUtils.WORK_END.split(":");
        Date tempStartDate = createDateWithDateHourAndMinute(startDate, BaseHelpUtils.getIntValue(startArr[0]), BaseHelpUtils.getIntValue(startArr[1]));
        Date tempMidDate = createDateWithDateHourAndMinute(startDate, BaseHelpUtils.getIntValue(midArr[0]), BaseHelpUtils.getIntValue(midArr[1]));
        Date tempEndDate = createDateWithDateHourAndMinute(startDate, BaseHelpUtils.getIntValue(endArr[0]), BaseHelpUtils.getIntValue(endArr[1]));
        if (startDate.getTime() <= tempMidDate.getTime()) {
            startDays = 1;
        } else if (startDate.getTime() >= tempMidDate.getTime() && startDate.getTime() <= tempEndDate.getTime()) {
            startDays = 0.5;
        }
        tempStartDate = createDateWithDateHourAndMinute(endDate, BaseHelpUtils.getIntValue(startArr[0]), BaseHelpUtils.getIntValue(startArr[1]));
        tempMidDate = createDateWithDateHourAndMinute(endDate, BaseHelpUtils.getIntValue(midArr[0]), BaseHelpUtils.getIntValue(midArr[1]));
        if (endDate.getTime() <= tempStartDate.getTime()) {
            endDays = 1;
        } else if (endDate.getTime() > tempStartDate.getTime() && endDate.getTime() <= tempMidDate.getTime()) {
            endDays = 0.5;
        }
        //总的请假天数（自然日） = 两个时间相隔的天数 + 开始的天数 - 结束的天数
        double tempDay = time / DateUtil.ONEDAY_MILLISECONDS + startDays - endDays;
        return new BigDecimal(tempDay);
    }

    /**
     * 计算一个时间段里面，某个员工的工作日天数（最小单位0.5天）
     *
     * @param employeeId
     * @param startDate
     * @param endDate
     * @return
     * @throws Exception
     */
    public BigDecimal getWorkDaysBetweenTwoDate(Integer employeeId, Date startDate, Date endDate) throws Exception {
        if (!BaseHelpUtils.isNullOrZero(employeeId) && null != startDate && null != endDate) {
            double days = 0;
            ConditionGetShiftInfoByEmployeeId condition = new ConditionGetShiftInfoByEmployeeId();
            condition.setEmployeeId(employeeId);
            condition.setStartDate(startDate);
            condition.setEndDate(endDate);
            QueryGetShiftInfoByEmployeeId query = new QueryGetShiftInfoByEmployeeId();
            //找出该员工在这段时间之内的排班记录
            BaseCollection<BaseGetShiftInfoByEmployeeId> bc = query.executeQuery(null, condition);
            List<BaseGetShiftInfoByEmployeeId> list = bc.getCollections();
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            Map<String, BaseGetShiftInfoByEmployeeId> map = new HashMap<>();
            for (BaseGetShiftInfoByEmployeeId obj : list) {
                map.put(s.format(obj.getRecordDate()), obj);
                System.out.println(s.format(obj.getRecordDate()) + "  星期" + obj.getWeekDay() + " 上班时间：" + obj.getSignInTime() + " 下班时间：" + obj.getSignOffTime());
            }
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //找出这段时间之内的假期信息
            HolidayManage holidayDao = new HolidayManage();
            StringBuilder sb = new StringBuilder();
            sb.append("(").append(BaseHolidayManage.CS_START_TIME).append(" between '").append(format.format(startDate)).append("' and '").append(format.format(endDate)).append("')")
                    .append(" or (").append(BaseHolidayManage.CS_END_TIME).append(" between '").append(format.format(startDate)).append("' and '").append(format.format(endDate)).append("')");
            List<BaseHolidayManage> holidayList = holidayDao.conditionalLoad(sb.toString());
            String[] restStartArr = StaticUtils.REST_START.split(":");
            String[] restEndArr = StaticUtils.REST_END.split(":");
            //先找出请假日期中的holiday，然后计算这段时间内算多少请假日
            for (BaseHolidayManage obj : holidayList) {
                Date startHoliday = obj.getStartTime();
                Date endHoliday = obj.getEndTime();
                if (null != startHoliday && null != endHoliday) {
                    boolean canBreak = false;
                    Date todayHolidayStart = startHoliday;
                    for (; ; ) {
                        String key = s.format(startHoliday);
                        boolean isSameDay = key.equals(s.format(endHoliday));
                        Date todayHolidayEnd = null;
                        if (isSameDay) {
                            todayHolidayEnd = endHoliday;
                        }
                        if (map.containsKey(key)) {
                            BaseGetShiftInfoByEmployeeId bean = map.get(key);
                            if (null != bean && null != bean.getSignInTime() && null != bean.getSignOffTime()) {
                                Date todayStartTemp = createDateWithDateHourAndMinute(startHoliday, 0, 0);
                                Date restStartTemp = createDateWithDateHourAndMinute(startHoliday, BaseHelpUtils.getIntValue(restStartArr[0]), BaseHelpUtils.getIntValue(restStartArr[1]));
                                Date restEndTemp = createDateWithDateHourAndMinute(startHoliday, BaseHelpUtils.getIntValue(restEndArr[0]), BaseHelpUtils.getIntValue(restEndArr[1]));
                                Date todayEndTemp = DateUtil.getNextDayOfDay(todayStartTemp, 1);
                                Date signInTime = OnShiftManageProcess.getNormalDate(bean.getSignInTime(), startHoliday, 0);
                                Date signOffTime = OnShiftManageProcess.getNormalDate(bean.getSignOffTime(), startHoliday, 0);
                                //如果计算出来的签到时间晚于签退时间，则签退时间应该在原有的基础上天数+1；确保签到时间永远都在签退时间之前
                                if (signInTime.after(signOffTime)) {
                                    signOffTime = OnShiftManageProcess.getNormalDate(bean.getSignOffTime(), DateUtil.getNextDayOfDay(startHoliday, 1), 0);
                                }
                                if (signInTime.getTime() >= todayStartTemp.getTime() && signOffTime.getTime() <= restStartTemp.getTime()) {
                                    //签到签退都在上午
                                    if (null != todayHolidayStart && null != todayHolidayEnd && !(todayHolidayStart.getTime() <= signInTime.getTime() && todayHolidayEnd.getTime() >= signOffTime.getTime())) {
                                        days += 0.5;
                                    } else if (null == todayHolidayStart && null != todayHolidayEnd && todayHolidayEnd.getTime() < signOffTime.getTime()) {
                                        days += 0.5;
                                    } else if (null != todayHolidayStart && null == todayHolidayEnd && todayHolidayStart.getTime() > signInTime.getTime()) {
                                        days += 0.5;
                                    }
                                } else if (signInTime.getTime() > restStartTemp.getTime() && signOffTime.getTime() < todayEndTemp.getTime()) {
                                    //签到签退都在下午
                                    if (null != todayHolidayStart && null != todayHolidayEnd && !(todayHolidayStart.getTime() <= signInTime.getTime() && todayHolidayEnd.getTime() >= signOffTime.getTime())) {
                                        days += 0.5;
                                    } else if (null == todayHolidayStart && null != todayHolidayEnd && todayHolidayEnd.getTime() < signOffTime.getTime()) {
                                        days += 0.5;
                                    } else if (null != todayHolidayStart && null == todayHolidayEnd && todayHolidayStart.getTime() > signInTime.getTime()) {
                                        days += 0.5;
                                    }
                                } else if (signInTime.getTime() >= todayStartTemp.getTime() && signInTime.getTime() <= restStartTemp.getTime() && signOffTime.getTime() > restStartTemp.getTime()) {
                                    //签到在上午，签退在下午
                                    if (null == todayHolidayStart && null != todayHolidayEnd && todayHolidayEnd.getTime() < signOffTime.getTime()) {
                                        if (todayHolidayEnd.getTime() > restStartTemp.getTime()) {
                                            days += 0.5;
                                        } else {
                                            days += 1;
                                        }
                                    } else if (null != todayHolidayStart && null == todayHolidayEnd && todayHolidayStart.getTime() > signInTime.getTime()) {
                                        if (todayHolidayStart.getTime() > restStartTemp.getTime()) {
                                            days += 1;
                                        } else {
                                            days += 0.5;
                                        }
//                                    } else if (null != todayHolidayStart && null != todayHolidayEnd) {
//                                        if (todayHolidayStart.getTime() <= signInTime.getTime() && todayHolidayEnd.getTime() >= restStartTemp.getTime()) {
//                                            days += 0.5;
//                                        }
//                                        if (todayHolidayStart.getTime() <= restEndTemp.getTime() && todayHolidayEnd.getTime() >= signOffTime.getTime()) {
//                                            days += 0.5;
//                                        }
                                    }
                                }
                            }
                            map.remove(key);
                        }
                        if (s.format(startHoliday).equals(s.format(endHoliday))) {
                            canBreak = true;
                        }
                        if (canBreak) {
                            break;
                        }
                        startHoliday = DateUtil.getNextDayOfDay(startHoliday, 1);
                        if (s.format(startHoliday).equals(s.format(endHoliday))) {
                            canBreak = true;
                        }
                    }
                }
            }
            for (String key : map.keySet()) {
                BaseGetShiftInfoByEmployeeId bean = map.get(key);
                if (null != bean && null != bean.getSignInTime() && null != bean.getSignOffTime()) {
                    String[] arr = key.split("-");
                    Calendar c = Calendar.getInstance();
                    c.set(BaseHelpUtils.getIntValue(arr[0]), BaseHelpUtils.getIntValue(arr[1]) - 1, BaseHelpUtils.getIntValue(arr[2]));
                    Date date = c.getTime();
                    Date signTime = OnShiftManageProcess.getNormalDate(bean.getSignInTime(), date, 0);
                    Date startTemp = createDateWithDateHourAndMinute(date, 0, 0);
                    Date endTemp = createDateWithDateHourAndMinute(date, BaseHelpUtils.getIntValue(restStartArr[0]), BaseHelpUtils.getIntValue(restStartArr[1]));
                    if (signTime.getTime() >= startTemp.getTime() && signTime.getTime() <= endTemp.getTime()) {
                        //上午有排班，则请假天数+0.5；没有则请假天数不变
                        days += 0.5;
                    }
                    startTemp = endTemp;
                    endTemp = DateUtil.getNextDayOfDay(startTemp, 1);
                    signTime = OnShiftManageProcess.getNormalDate(bean.getSignOffTime(), date, 0);
                    if (signTime.getTime() > startTemp.getTime() && signTime.getTime() < endTemp.getTime()) {
                        //下午有排班，则请假天数+0.5；没有则请假天数不变
                        days += 0.5;
                    }
                    //判断上下午选择的日期计算  进行天数的校正
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH");
                    String startDateStr = sdf.format(startDate);
                    String startKey = startDateStr.split("_")[0];
                    String endDateStr = sdf.format(endDate);
                    String endKey = endDateStr.split("_")[0];
                    if (key.equals(startKey)) {
                        int tmpHour = Integer.parseInt(startDateStr.split("_")[1]);
                        if (tmpHour > 12) {
                            days -= 0.5;
                        }
                    }
                    if (key.equals(endKey)) {
                        int tmpHour = Integer.parseInt(endDateStr.split("_")[1]);
                        if (tmpHour <= 12) {
                            days -= 0.5;
                        }
                    }
                }
            }
            return new BigDecimal(days);
        }
        return BigDecimal.ZERO;
    }

    /**
     * 计算请假的时长精确到毫秒
     * @param employeeId
     * @param startDate
     * @param endDate
     * @return
     * @throws Exception
     */
    public BigDecimal getWorkHoursBetweenTwoDate(Integer employeeId, Date startDate, Date endDate) throws Exception {
        if (!BaseHelpUtils.isNullOrZero(employeeId) && null != startDate && null != endDate) {
            if (startDate.after(endDate)) {
                throw new Exception("开始时间不能晚于结束时间");
            }
            long time = 0;
            ConditionGetShiftInfoByEmployeeId condition = new ConditionGetShiftInfoByEmployeeId();
            condition.setEmployeeId(employeeId);
            condition.setStartDate(startDate);
            condition.setEndDate(endDate);
            QueryGetShiftInfoByEmployeeId query = new QueryGetShiftInfoByEmployeeId();
            BaseCollection<BaseGetShiftInfoByEmployeeId> bc = query.executeQuery(null, condition);
            List<BaseGetShiftInfoByEmployeeId> list = bc.getCollections();
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            Map<String, BaseGetShiftInfoByEmployeeId> map = new HashMap<>();
            for (BaseGetShiftInfoByEmployeeId obj : list) {
                map.put(s.format(obj.getRecordDate()), obj);
                System.out.println(s.format(obj.getRecordDate()) + "  星期" + obj.getWeekDay() + " 上班时间：" + obj.getSignInTime() + " 下班时间：" + obj.getSignOffTime());
            }
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            HolidayManage holidayDao = new HolidayManage();
            StringBuilder sb = new StringBuilder();
            sb.append("(").append(BaseHolidayManage.CS_START_TIME).append(" between '").append(format.format(startDate)).append("' and '").append(format.format(endDate)).append("')")
                    .append(" or (").append(BaseHolidayManage.CS_END_TIME).append(" between '").append(format.format(startDate)).append("' and '").append(format.format(endDate)).append("')");
            List<BaseHolidayManage> holidayList = holidayDao.conditionalLoad(sb.toString());
            //先找出请假日期中的holiday，然后计算这段时间内算多少请假日
            for (BaseHolidayManage obj : holidayList) {
                Date startHoliday = obj.getStartTime();
                Date endHoliday = obj.getEndTime();
                if (null != startHoliday && null != endHoliday) {
                    boolean canBreak = false;
                    Date todayHolidayStart = startHoliday;
                    for (; ; ) {
                        String key = s.format(startHoliday);
                        boolean isSameDay = key.equals(s.format(endHoliday));
                        Date todayHolidayEnd = null;
                        if (isSameDay) {
                            todayHolidayEnd = endHoliday;
                        }
                        if (map.containsKey(key)) {
                            BaseGetShiftInfoByEmployeeId bean = map.get(key);
                            if (null != bean && null != bean.getSignInTime() && null != bean.getSignOffTime()) {
                                Date signIn = OnShiftManageProcess.getNormalDate(bean.getSignInTime(), startHoliday, 0);
                                Date signOff = OnShiftManageProcess.getNormalDate(bean.getSignOffTime(), startHoliday, 0);
                                if ((null == todayHolidayStart && null == todayHolidayEnd)//整天放假，则这天的工作时间为0
                                        || (null != todayHolidayStart && null != todayHolidayEnd && todayHolidayStart.getTime() <= signIn.getTime() && todayHolidayEnd.getTime() >= signOff.getTime())
                                        || (null == todayHolidayStart && null != todayHolidayEnd && todayHolidayEnd.getTime() >= signOff.getTime())
                                        || (null != todayHolidayStart && todayHolidayStart.getTime() <= signIn.getTime() && null == todayHolidayEnd)) {

                                } else if (null == todayHolidayStart && null != todayHolidayEnd && todayHolidayEnd.getTime() < signOff.getTime()) {
                                    //只需要计算todayHolidayEnd~signOff之间的时间
                                    time += calculateTime(todayHolidayEnd, signOff);
                                } else if (null != todayHolidayStart && todayHolidayStart.getTime() > signIn.getTime() && null == todayHolidayEnd) {
                                    //计算signIn~todayHolidayStart之间的时间
                                    time += calculateTime(signIn, todayHolidayStart);
                                } else if (null != todayHolidayStart && null != todayHolidayEnd && todayHolidayStart.getTime() <= signIn.getTime() && todayHolidayEnd.getTime() < signOff.getTime()) {
                                    //计算todayHolidayEnd~signOff之间的时间
                                    time += calculateTime(todayHolidayEnd, signOff);
                                } else if (null != todayHolidayStart && null != todayHolidayEnd && todayHolidayStart.getTime() > signIn.getTime() && todayHolidayEnd.getTime() >= signOff.getTime()) {
                                    //计算signIn~todayHolidayStart之间的时间
                                    time += calculateTime(signIn, todayHolidayStart);
                                } else if (null != todayHolidayStart && null != todayHolidayEnd && todayHolidayStart.getTime() > signIn.getTime() && todayHolidayEnd.getTime() < signOff.getTime()) {
                                    //计算signIn~todayHolidayStart之间的时间 + todayHolidayEnd~signOff之间的时间
                                    time += calculateTime(signIn, todayHolidayStart);
                                    time += calculateTime(todayHolidayEnd, signOff);
                                }
                            }
                            map.remove(key);
                        }
                        if (s.format(startHoliday).equals(s.format(endHoliday))) {
                            canBreak = true;
                        }
                        if (canBreak) {
                            break;
                        }
                        startHoliday = DateUtil.getNextDayOfDay(startHoliday, 1);
                        if (s.format(startHoliday).equals(s.format(endHoliday))) {
                            canBreak = true;
                        }
                    }
                }
            }
            if (map.size() > 1) {
                //请假起止时间不是同一天
                for (String key : map.keySet()) {
                    BaseGetShiftInfoByEmployeeId bean = map.get(key);
                    if (null != bean && null != bean.getSignInTime() && null != bean.getSignOffTime() && null != bean.getRecordDate()) {
                        Date date = bean.getRecordDate();
                        Date signInTime = OnShiftManageProcess.getNormalDate(bean.getSignInTime(), date, 0);
                        Date signOffTime = OnShiftManageProcess.getNormalDate(bean.getSignOffTime(), date, 0);
                        if (s.format(signInTime).equals(s.format(startDate))) {
                            if (startDate.getTime() <= signInTime.getTime()) {
                                // 开始时间	签到时间	签退时间
                                time += calculateTime(signInTime, signOffTime);
                            } else if (startDate.getTime() > signInTime.getTime() && startDate.getTime() <= signOffTime.getTime()) {
                                // 签到时间	开始时间	签退时间
                                time += calculateTime(startDate, signOffTime);
                            }
                        } else if (s.format(signInTime).equals(s.format(endDate))) {
                            if (endDate.getTime() >= signInTime.getTime() && endDate.getTime() <= signOffTime.getTime()) {
                                // 签到时间	结束时间	签退时间
                                time += calculateTime(signInTime, endDate);
                            } else if (endDate.getTime() > signOffTime.getTime()) {
                                // 签到时间	签退时间	结束时间
                                time += calculateTime(signInTime, signOffTime);
                            }
                        } else {
                            //起止日期中包含的其他日期，则直接根据这天的签到时间和签退时间来计算工作时长
                            time += calculateTime(signInTime, signOffTime);
                        }
                    }
                }
            } else if (map.size() == 1) {
                //请假起止时间是同一天
                for (String key : map.keySet()) {
                    BaseGetShiftInfoByEmployeeId bean = map.get(key);
                    if (null != bean && null != bean.getSignInTime() && null != bean.getSignOffTime() && null != bean.getRecordDate()) {
                        Date date = bean.getRecordDate();
                        Date signInTime = OnShiftManageProcess.getNormalDate(bean.getSignInTime(), date, 0);
                        Date signOffTime = OnShiftManageProcess.getNormalDate(bean.getSignOffTime(), date, 0);
                        if (startDate.getTime() <= signInTime.getTime() && endDate.getTime() >= signInTime.getTime() && endDate.getTime() <= signOffTime.getTime()) {
                            // 开始时间	签到时间	结束时间	签退时间
                            time += calculateTime(signInTime, endDate);
                        } else if (startDate.getTime() <= signInTime.getTime() && endDate.getTime() >= signOffTime.getTime()) {
                            // 开始时间	签到时间	签退时间	结束时间
                            time += calculateTime(signInTime, signOffTime);
                        } else if (startDate.getTime() >= signInTime.getTime() && endDate.getTime() <= signOffTime.getTime()) {
                            // 签到时间	开始时间	结束时间	签退时间
                            time += calculateTime(startDate, endDate);
                        } else if (startDate.getTime() >= signInTime.getTime() && startDate.getTime() <= signOffTime.getTime() && endDate.getTime() >= signOffTime.getTime()) {
                            // 签到时间	开始时间	签退时间	结束时间
                            time += calculateTime(startDate, signOffTime);
                        }
                    }
                }
            }
            BigDecimal bigDecimal = new BigDecimal(time + "").setScale(2, BigDecimal.ROUND_HALF_DOWN);
            return bigDecimal;
        }
        return BigDecimal.ZERO;
    }

    /**
     * 用date、小时数和分钟数来创建一个具体的时间（某年某月某日某时某分0秒0毫秒）
     *
     * @param date
     * @param hour   24小时制
     * @param minute
     * @return
     */
    private Date createDateWithDateHourAndMinute(Date date, int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 计算同一天之内，两个时间点之间的工作时长
     *
     * @param start
     * @param end
     * @return
     */
    private long calculateTime(Date start, Date end) throws Exception {
        if (null != start && null != end) {
            if (start.after(end)) {
                throw new Exception("开始时间不能晚于结束时间");
            }
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            if (s.format(start).equals(s.format(end))) {
                Date restStart = OnShiftManageProcess.getNormalDate(StaticUtils.REST_START, start, 0);
                Date restEnd = OnShiftManageProcess.getNormalDate(StaticUtils.REST_END, start, 0);
                long time = 0;
                if ((start.getTime() <= restStart.getTime() && end.getTime() <= restStart.getTime())
                        || (start.getTime() >= restEnd.getTime() && end.getTime() >= restEnd.getTime())) {
                    //这两个时间点之间，不包括休息时间
                    time = end.getTime() - start.getTime();
                } else if (start.getTime() <= restStart.getTime() && end.getTime() > restStart.getTime() && end.getTime() < restEnd.getTime()) {
                    //开始时间		休息开始时间		结束时间			休息结束时间
                    time = restStart.getTime() - start.getTime();
                } else if (start.getTime() <= restStart.getTime() && end.getTime() >= restEnd.getTime()) {
                    //开始时间		休息开始时间		休息结束时间		结束时间
                    time = restStart.getTime() - start.getTime() + end.getTime() - restEnd.getTime();
                } else if (start.getTime() > restStart.getTime() && start.getTime() < restEnd.getTime() && end.getTime() >= restEnd.getTime()) {
                    //休息开始时间		开始时间			休息结束时间		结束时间
                    time = end.getTime() - restEnd.getTime();
                }
                return time;
            }
        }
        return 0;
    }

    /**
     * 根据ID保存附件的路径(病假上传证明时使用)
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String saveUploadFileAddress(Map<String, Object> params) throws Exception {
        BaseCollection<GenericBase> bc = new BaseCollection<>();
        int id = BaseHelpUtils.getIntValue(params.get("id"));
        int fileId = BaseHelpUtils.getIntValue(params.get("fileId"));
        String fileUrl = BaseHelpUtils.getString(params.get("fileUrl"));
        String fileName = BaseHelpUtils.getString(params.get("fileName"));
        if (id > 0 && !BaseHelpUtils.isNullOrEmpty(fileUrl)) {
            PersonnelBusines dao = new PersonnelBusines();
            dao.setPersonnelBusinessId(id);
            if (dao.load()) {
                dao.setAttachment(fileUrl);
                dao.setAttachmentName(fileName);
                dao.setAttachmentId(fileId);
                ColumnChangedData attachmentIdData = dao.getColumnChangedData(BasePersonnelBusines.CS_ATTACHMENT_ID);
                //修改附件的引用次数
                ThreadConnection.beginTransaction();
                FileManageProcessor.upadteTimesByColumnChangedData(attachmentIdData);
                dao.update();
                ThreadConnection.commit();
                return bc.toJSON();
            }
        }
        return bc.toJSON(-1, "参数错误");
    }

    /**
     * 获取员工离职信息
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String getResignationInfo(Map<String, Object> params) throws Exception {
        BaseCollection<BasePersonnelBusines> bc = new BaseCollection<>();
        int id = BaseHelpUtils.getIntValue(params.get("personnelBusinessId"));
        if (id > 0) {
            PersonnelBusines dao = new PersonnelBusines();
            dao.setPersonnelBusinessId(id);
            if (dao.load()) {
                List<BasePersonnelBusines> list = new ArrayList<>();
                list.add(dao.generateBase());
                bc.setCollections(list);
                return bc.toJSON();
            }
        }
        return bc.toJSON(-1, "参数错误");
    }

    /**
     * 找出员工（专业负责人）管理的订单
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String needToChangeProjectManager(Map<String, Object> params) throws Exception {
        BaseCollection<BaseProjectOfProjectManager> bc = new BaseCollection<>();
        int id = BaseHelpUtils.getIntValue(params.get("employeeId"));
        if (id > 0) {
            ConditionProjectOfProjectManager condition = new ConditionProjectOfProjectManager();
            condition.setProjectManageId(id);
            QueryProjectOfProjectManager query = new QueryProjectOfProjectManager();
            bc = query.executeQuery(null, condition);
            return bc.toJSON();
        }
        return bc.toJSON(-1, "参数错误");
    }

    /**
     * 入职申请 通过名字生成企业邮箱
     *
     * @param params
     */
    public String createEmailByName(Map<String, Object> params) {
        String employeeName = BaseHelpUtils.getStringValue(params, "employeeName");
        char[] t1 = null;
        t1 = employeeName.toCharArray();
        String name = null, firstName = null, lastName = null;
        if (employeeName.length() == 2) {//如果姓名为两个字，则姓名都为全拼
            name = ChineseToEnglish.getPingYin(employeeName) + "@jaid.cn";
        } else {//如果名字不为两个字，则姓全拼加上名字首字母
            firstName = ChineseToEnglish.getPingYin(java.lang.Character.toString(t1[0]));
            String str = "";
            for (int i = 1; i < employeeName.length(); i++) {
                if (!BaseHelpUtils.isNullOrEmpty(t1[i])) {
                    str = str + java.lang.Character.toString(t1[i]);
                }
                lastName = ChineseToEnglish.getPinYinHeadChar(str);
                name = firstName + lastName + "@jaid.cn";
            }
        }
        BaseCollection bc = new BaseCollection<>();
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        bc.setUserData(map);
        return bc.toJSON();
    }

    /**
     * 获取工作交接
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String getWorkhandovers(Map<String, Object> params) throws Exception {
        int type = BaseHelpUtils.getIntValue(params.get("type"));
        int businessId = BaseHelpUtils.getIntValue(params.get("businessId"));
        ConditionCheckWorkHandover condition = new ConditionCheckWorkHandover();
        condition.setType(type);
        condition.setLinkId(businessId);
        QueryCheckWorkHandover query = new QueryCheckWorkHandover();
        return query.executeQuery(null, condition).toJSON();
    }

    /**
     * 转岗单打印
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String getTranseferHtml(Map<String, Object> params) throws Exception {
        BaseCollection<BaseKeyValue> collection = new BaseCollection<>();
        int type = BaseHelpUtils.getIntValue(params.get("type"));

        BasePersonnelBusines tmpBean = new BasePersonnelBusines();
        tmpBean.setDataFromMap(params);
        PersonnelBusines dao = new PersonnelBusines();
        dao.setPrimaryKeyFromBase(tmpBean);
        if (dao.load()) {
            int businessId = dao.getPersonnelBusinessId();
            Integer companyId = dao.getCompanyId();
            ConditionCheckWorkHandover condition = new ConditionCheckWorkHandover();
            condition.setType(type);
            condition.setLinkId(businessId);
            QueryCheckWorkHandover query = new QueryCheckWorkHandover();
            BaseCollection<BaseCheckWorkHandover> bc = query.executeQuery(null, condition);
            List<BaseCheckWorkHandover> workList = bc.getCollections();
            ConditionGetProcessComment condition2 = new ConditionGetProcessComment();
            condition2.setBusinessId(businessId);
            condition2.setProcessType(dao.getProcessType());
            QueryGetProcessComment query2 = new QueryGetProcessComment();
            BaseCollection<BaseGetProcessComment> bc2 = query2.executeQuery(null, condition2);
            List<BaseGetProcessComment> list = bc2.getCollections();
            Employee eDao = new Employee();
            eDao.setEmployeeId(dao.getEmployeeId());
            eDao.load();
            String employeeNo = eDao.getEmployeeNo();
            String employeeName = eDao.getEmployeeName();
            String fromDepartmentName = SelectValueCache.getSelectValue("departments", eDao.getDepartmentId().toString());
            String toDepartmentName = SelectValueCache.getSelectValue("departments", dao.getParentId().toString());
            String transferDateStr = "";

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
            if (null != dao.getEndDate()) {
                transferDateStr = sdf.format(dao.getEndDate());
            } else {
                transferDateStr = sdf.format(dao.getStartDate());
            }
            StringBuilder sb = new StringBuilder("<style>");
            sb.append(" 		*{")
                    .append("		font-family:'微软雅黑';")
                    .append("} ")
                    .append("		th{")
                    .append("			font-weight:normal;")
                    .append("		}")
                    .append("		td{")
                    .append("			text-align:center;")
                    .append("		}")
                    .append("	</style>")
                    .append("    <div style='width: 750px;'>")
                    .append("		<!--表格1内容star--> ")
                    .append("		<center style='height:1090px;position: relative;'>")
                    .append("			<!--表头star-->")
                    .append("<!-- 			<div style='height:43px; border-bottom: 1px solid #000;'>")
                    .append("	<img src = 'logo.png' style='float:left; height:40px;'/>")
                    .append("	<font style='text-align:right;width:750px;position: absolute; top: 20px; left:0px;font-size:14px;color:#e3e3e3;margin-right:10px;'>版/修(4/0)　　文件编号：J&A/QR62F-ARH　</font>")
                    .append("</div> -->")
                    .append("			<!--表头over-->")
                    .append(getTop(companyId))
                    .append("				<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:0px;'>")
                    .append("							<caption style='font-size: 22px;font-weight: bold;'>")
                    .append("							   员工调动申请单")
                    .append("							   <p style='font-size:14px;text-align:right;margin: 5px 0;'>填表日期：<span type='text' style='border-bottom:1px solid #333;'>")
                    .append(sdf.format(dao.getCreateTime()))
                    .append("</span></p>")
                    .append("							</caption>")
                    .append("							<tr style='font-size:15px;'>")
                    .append("								<td width='125' height='40'>原工号</td>")
                    .append("<td width='250' height='40'>")
                    .append(employeeNo)
                    .append("</td><td width='125' height='40'>姓名</td>")
                    .append("<td width='250' height='40'>")
                    .append(employeeName)
                    .append("</td><td width='125' height='40'>原部门</td>")
                    .append("<td width='250' height='40'>")
                    .append(fromDepartmentName)
                    .append("</td></tr>")
                    .append("							<tr style='font-size:15px;'>")
                    .append("								<td widtd='125' height='40'>调入部门</td>")
                    .append("<td width='250' height='40' colspan='2'>")
                    .append(toDepartmentName)
                    .append("</td>								<td width='125' height='40'>新工号</td>")
                    .append("								<td width='250' height='40' colspan='2'></td>")
                    .append("							</tr>	")
                    .append("							<tr style='font-size:15px;'>")
                    .append("								<td widtd='125' height='40'>调动时间</td>")
                    .append("<td width='250' height='40' colspan='2'>")
                    .append(transferDateStr)
                    .append("</td>								<td width='125' height='40'>调动岗位</td>")
                    .append("<td width='250' height='40' colspan='2'>")
                    .append(BaseHelpUtils.getString(SelectValueCache.getSelectValue("duties", BaseHelpUtils.getString(dao.getDutyId()))))
                    .append("</td></tr>")
                    .append("<tr style='font-size:15px;'><td widtd='125' height='40'>调动原因</td><td colspan='5'>")
                    .append(dao.getReason())
                    .append("</td></tr>")
                    .append("				</table>")
                    .append("				<!--一、工作移交（含待办事项）star-->")
                    .append("				<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px;'>")
                    .append("							<tr>")
                    .append("								<th colspan='3' height='40' style='font-weight:700;font-size:19px;'>一、工 作 移 交（含待办事项）</th>")
                    .append("							</tr>")
                    .append("							<tr style='font-size:15px;font-weight:700;'>")
                    .append("								<th width='150' height='40' style='font-weight:700'>名称</th>")
                    .append("								<th width='300' height='40' style='font-weight:700'>主要内容</th>")
                    .append("								<th width='300' height='40' style='font-weight:700'>接手人</th>")
                    .append("</tr>");
//				.append("							<tr style='font-size:15px;'>")
//				.append("								<td width='150' height='40'></td>")
//				.append("								<td width='300' height='40'></td>")
//				.append("								<td width='300' height='40'></td>")
//				.append("							</tr>" )
//				.append("							<tr style='font-size:15px;'>")
//				.append("								<td width='150' height='40'></td>")
//				.append("								<td width='300' height='40'></td>")
//				.append("								<td width='300' height='40'></td>")
//				.append("							</tr>" );
            for (BaseCheckWorkHandover obj : workList) {
                sb.append("<tr style='font-size:15px;'>");
                sb.append("<td width='300' height='42'>").append(null == obj.getName() ? "" : obj.getName()).append("</td>");
                sb.append("<td width='350' height='42'>").append(null == obj.getContent() ? "" : obj.getContent()).append("</td>");
                sb.append("<td width='100' height='42'>").append(obj.getEmployeeName()).append("</td>");
                sb.append("</tr>");
            }
            sb.append("				</table>")
                    .append("				<!--一、工作移交（含待办事项）over-->")
                    .append("				<!--三、资料及办公用具移交star-->")
                    .append("				<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px;'>")
                    .append("							<tr>")
                    .append("								<th colspan='5' height='40' style='font-weight:700;font-size:19px;'>二、其他</th>")
                    .append("							</tr>						");
            for (BaseGetProcessComment obj : list) {
                if (null == obj.getBackViewName()) {
                    continue;
                }
                if (obj.getBackViewName().equals("原部门分管领导")) {
                    sb.append("<tr style='font-size:15px;'>")
                            .append("<td width='150' height='60' >转出部门意见</td>")
                            .append("<td width='600' height='60' colspan='4' style='position:relative;font-size: 13px;text-align:left;padding:0 3px;'>")
                            .append(BaseHelpUtils.isNullOrEmpty(obj.getProcessComment()) ? "同意" : obj.getProcessComment())
                            .append("<span style='position:absolute;bottom:5px;right:100px;font-size:15px;'>")
                            .append(obj.getEmployeeName())
                            .append("  ")
                            .append(null == obj.getOperateTime() ? "" : sdf.format(obj.getOperateTime()))
                            .append("</span></td></tr>");
                    list.remove(obj);
                    break;
                }
            }
            for (BaseGetProcessComment obj : list) {
                if (null == obj.getBackViewName()) {
                    continue;
                }
                if (obj.getBackViewName().equals("新部门分管领导")) {
                    sb.append("<tr style='font-size:15px;'>")
                            .append("<td width='150' height='60' >转入部门意见</td>")
                            .append("<td width='600' height='60' colspan='4' style='position:relative;font-size: 13px;text-align:left;padding:0 3px;'>")
                            .append(BaseHelpUtils.isNullOrEmpty(obj.getProcessComment()) ? "同意" : obj.getProcessComment())
                            .append("<span style='position:absolute;bottom:5px;right:100px;font-size:15px;'>")
                            .append(obj.getEmployeeName())
                            .append("  ")
                            .append(null == obj.getOperateTime() ? "" : sdf.format(obj.getOperateTime()))
                            .append("</span></td></tr>");
                    list.remove(obj);
                    break;
                }
            }
            for (BaseGetProcessComment obj : list) {
                if (null == obj.getBackViewName()) {
                    continue;
                }
                if (obj.getBackViewName().equals("人资总监") || obj.getBackViewName().equals("人资部总监")) {
                    sb.append("<tr style='font-size:15px;'>")
                            .append("<td width='150' height='60' >人资部审批</td>")
                            .append("<td width='600' height='60' colspan='4' style='position:relative;font-size: 13px;text-align:left;padding:0 3px;'>")
                            .append(BaseHelpUtils.isNullOrEmpty(obj.getProcessComment()) ? "同意" : obj.getProcessComment())
                            .append("<span style='position:absolute;bottom:5px;right:100px;font-size:15px;'>")
                            .append(obj.getEmployeeName())
                            .append("  ")
                            .append(null == obj.getOperateTime() ? "" : sdf.format(obj.getOperateTime()))
                            .append("</span></td></tr>");
                    list.remove(obj);
                    break;
                }
            }
            for (BaseGetProcessComment obj : list) {
                if (null == obj.getBackViewName()) {
                    continue;
                }
                if (obj.getBackViewName().equals("运营专员")) {
                    sb.append("<tr style='font-size:15px;'>")
                            .append("<td width='150' height='60' >运营审批</td>")
                            .append("<td width='600' height='60' colspan='4' style='position:relative;font-size: 13px;text-align:left;padding:0 3px;'>")
                            .append(BaseHelpUtils.isNullOrEmpty(obj.getProcessComment()) ? "同意" : obj.getProcessComment())
                            .append("<span style='position:absolute;bottom:5px;right:100px;font-size:15px;'>")
                            .append(obj.getEmployeeName())
                            .append("  ")
                            .append(null == obj.getOperateTime() ? "" : sdf.format(obj.getOperateTime()))
                            .append("</span></td></tr>");
                    list.remove(obj);
                    break;
                }
            }

//				sb.append("							<tr style='font-size:15px;'>")
//				.append("								<td width='150' height='40' >转出部门意见</td>")
//				.append("								<td width='600' height='40' colspan='4' style='position:relative;font-size: 13px;text-align:left;padding:0 3px;'>")
//				.append("									<span style='position:absolute;bottom:5px;right:100px;font-size:12px;'>（签字及日期）</span>")
//				.append("								</td>")
//				.append("							</tr>" )
//				.append("							<tr style='font-size:15px;'>")
//				.append("								<td width='150' height='40' >转入部门意见</td>")
//				.append("								<td width='600' height='40' colspan='4' style='position:relative;font-size: 13px;text-align:left;padding:0 3px;'>")
//				.append("									<span style='position:absolute;bottom:5px;right:100px;font-size:12px;'>（签字及日期）</span>")
//				.append("								</td>")
//				.append("							</tr>" )
//				.append("							<tr style='font-size:15px;'>")
//				.append("								<td width='150' height='40' >人资部审批</td>")
//				.append("								<td width='600' height='40' colspan='4' style='position:relative;font-size: 13px;text-align:left;padding:0 3px;'>")
//				.append("									<span style='position:absolute;bottom:5px;right:100px;font-size:12px;'>（签字及日期）</span>")
//				.append("								</td>")
//				.append("							</tr>")
            sb.append("							<tr style='font-size:15px;'>")
                    .append("								<td width='150' height='60' >本人签字</td>")
                    .append("								<td width='600' height='60' colspan='4' style='position:relative;font-size: 13px;text-align:left;padding:0 3px;'><span style='position:absolute;bottom:5px;right:100px;font-size:12px;'>（签字及日期）</span></td>")
                    .append("							</tr>")
                    .append("				</table>")
                    .append("				<p style='font-size:14px;text-align:left;margin-top:8px;padding-left:15px;'>说明：转出及转入部门需部门经理、总监/总经理审批。</p>")
                    .append("				<!--三、资料及办公用具移交over-->")
                    .append("			<!--表尾star-->")
                    .append("			<div style='position:absolute; bottom:0px; left:0px;width:750px; height:15px; font-size:12px;color:#e3e3e3;'>　　　　保密等级：机密　　　　　　　　　　　　存档期限：5年　　　　　　　　　　　　第 1 页 共 1 页</div> ")
                    .append("			<!--表尾over-->")
                    .append("		</center>")
                    .append("		<!--表格1内容over-->")
                    .append("    </div>");
            BaseKeyValue bean = new BaseKeyValue();
            bean.setKey("htmlStr");
            bean.setValue(sb.toString());
            List<BaseKeyValue> tempList = new ArrayList<>();
            tempList.add(bean);
            collection.setCollections(tempList);
            return collection.toJSON();
        }
        return collection.toJSON(-1, "数据缺失");
    }

    /**
     * 生成离职工作交接单的Html页面代码
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String getWorkhandoverHtml(Map<String, Object> params) throws Exception {
        BaseCollection<BaseKeyValue> collection = new BaseCollection<>();
        int type = BaseHelpUtils.getIntValue(params.get("type"));
        int businessId = BaseHelpUtils.getIntValue(params.get("businessId"));
        String employeeName = BaseHelpUtils.getString(params.get("employeeName"));
        String duty = BaseHelpUtils.getString(params.get("duty"));
        String department = BaseHelpUtils.getString(params.get("department"));
        String operator = BaseHelpUtils.getString(params.get("operator"));
        String unit = BaseHelpUtils.getString(params.get("unit"));
        PersonnelBusines dao = new PersonnelBusines();
        dao.setPersonnelBusinessId(businessId);
        if (dao.load()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Integer companyId = dao.getCompanyId();
            ConditionCheckWorkHandover condition = new ConditionCheckWorkHandover();
            condition.setType(type);
            condition.setLinkId(businessId);
            QueryCheckWorkHandover query = new QueryCheckWorkHandover();
            BaseCollection<BaseCheckWorkHandover> bc = query.executeQuery(null, condition);
            List<BaseCheckWorkHandover> workList = bc.getCollections();
            ConditionGetProcessComment condition2 = new ConditionGetProcessComment();
            condition2.setBusinessId(businessId);
            condition2.setProcessType(dao.getProcessType());
            QueryGetProcessComment query2 = new QueryGetProcessComment();
            BaseCollection<BaseGetProcessComment> bc2 = query2.executeQuery(null, condition2);
            List<BaseGetProcessComment> list = bc2.getCollections();
            StringBuilder sb = new StringBuilder();
            sb.append("<style> *{font-family:'微软雅黑';} th{font-weight:normal;} td{text-align:center;} </style>");
            sb.append("<div style='width: 750px;'>");
            //页眉
            sb.append(getTop(companyId));
            //表头信息
            sb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:23px;'>");
            sb.append("<caption style='font-size: 22px;font-weight: bold;'>离职员工工作交接单");
            sb.append("<p style='font-size:14px;text-align:right;'>填表日期：<span type='text' style='border-bottom:1px solid #333;'>　").append(dateFormat.format(dao.getCreateTime())).append("　</span></p>");
            sb.append("</caption>");
            //员工基本信息
            sb.append("<tr style='font-size:15px;'>");
            sb.append("<td width='125' height='42'>工号</td>");
            sb.append("<td width='250' height='42'>").append(dao.getEmployeeNo()).append("</td>");
            sb.append("<td width='125' height='42'>姓名</td>");
            sb.append("<td width='250' height='42'>").append(employeeName).append("</td>").append("</tr>");
            sb.append("<tr style='font-size:15px;'>");
            sb.append("<td widtd='125' height='42'>所在部门</td>");
            sb.append("<td width='250' height='42'>").append(null == department ? "" : department).append("</td>");
            sb.append("<td width='125' height='42'>职位</td>");
            sb.append("<td width='250' height='42'>").append(null == duty ? "" : duty).append("</td>").append("</tr>");
            sb.append("<tr style='font-size:15px;'>");
            sb.append("<td width='125' height='42'>离职原因</td>");
            sb.append("<td colspan='3' width='250' style='text-align:left; padding: 0 5px;'>").append(null == dao.getReason() ? "" : dao.getReason()).append("</td>").append("</tr>").append("</table>");
            //工作移交（含待办事项）
            sb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px;'>");
            sb.append("<tr><th colspan='3' height='42' style='font-weight:700;font-size:19px;'>一、工作移交（含待办事项）</th></tr>");
            sb.append("<tr style='font-size:15px;font-weight:700;'>");
            sb.append("<th width='300' height='42' style='font-weight:700'>名称</th>");
            sb.append("<th width='350' height='42' style='font-weight:700'>主要内容</th>");
            sb.append("<th width='100' height='42' style='font-weight:700'>接手人</th>");
            sb.append("</tr>");
            for (BaseCheckWorkHandover obj : workList) {
                sb.append("<tr style='font-size:15px;'>");
                sb.append("<td width='300' height='42'>").append(null == obj.getName() ? "" : obj.getName()).append("</td>");
                sb.append("<td width='350' height='42'>").append(null == obj.getContent() ? "" : obj.getContent()).append("</td>");
                sb.append("<td width='100' height='42'>").append(null == obj.getEmployeeName() ? "" : obj.getEmployeeName()).append("</td>");
                sb.append("</tr>");
            }
            sb.append("</table>");
            if (workList.size() <= 6) {
                sb.append(getTabel2(list, dao, operator));
                sb.append(getTabel3(dao));
            } else if (workList.size() <= 11) {
                sb.append(getTabel2(list, dao, operator));
            }
            //页脚
            sb.append(getBottom());
            //页眉
            sb.append(getTop(companyId));
            if (workList.size() > 6) {
                sb.append("<div style='margin-top:30px;'></div>");
                sb.append(getTabel3(dao));
                sb.append("<table border='1' cellpadding='0' cellspacing='0' width='750' style ='margin-top:-2px;'>");
            } else {
                sb.append("<table border='1' cellpadding='0' cellspacing='0' width='750' style ='margin-top:30px;'>");
            }
            sb.append("<tr><th colspan='4' height='42' style='font-weight:700;font-size:19px;'>四、其&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;他</th></tr>");
            sb.append("<tr style='font-size:15px;font-weight:700;'>");
            sb.append("<th width='100' height='42' style='font-weight:700'>名称</th>");
            sb.append("<th width='470' height='42' style='font-weight:700'>主要内容</th>");
            sb.append("<th width='90' height='42' style='font-weight:700'>经办人</th>");
            sb.append("<th width='90' height='42' style='font-weight:700'>审批时间</th></tr>");
            for (BaseGetProcessComment obj : list) {
                if (null != obj.getBackViewName() && obj.getBackViewName().equals("部门助理")) {
                    sb.append("<tr style='font-size:15px;'>");
                    sb.append("<td width='100' height='126' style='line-height: 30px;padding:0 5px;'>离职考勤</td>");
                    sb.append("<td width='470' height='126' style='text-align:left;line-height: 30px;padding:0 3px;'>");
                    sb.append("1、当月考勤情况：");
                    sb.append(dao.getTransportation()).append("</br>");
                    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
                    sb.append("终止工资日期：").append(format.format(dao.getEndDate())).append("</td>");
                    sb.append("<td width='90' height='126'>").append(null == obj.getEmployeeName() ? "" : obj.getEmployeeName()).append("</td>");
                    sb.append("<td width='90' height='126'>").append(dateFormat.format(obj.getOperateTime())).append("</td></tr>");
                    sb.append("<tr style='font-size:15px;'>");
                    sb.append("<td width='100' height='84' style='line-height: 30px;padding:0 5px;'>社保/公积金</td>");
                    sb.append("<td width='470' height='84' style='text-align:left;line-height: 30px;padding-left: 5px;'>社保/公积金停缴月份：").append(unit).append("</td>");
                    sb.append("<td width='90' height='84'>").append(null == operator ? "" : operator).append("</td>");
                    sb.append("<td width='90' height='84'>").append(dateFormat.format(obj.getOperateTime())).append("</td></tr>");
                    list.remove(obj);
                    break;
                }
            }
            for (BaseGetProcessComment obj : list) {
                if (null != obj.getBackViewName() && obj.getBackViewName().equals("财务经理")) {
                    sb.append("<tr style='font-size:15px;'>");
                    sb.append("<td width='100' height='84' style='line-height: 30px;padding:0 5px;'>财务审批</td>");
                    sb.append("<td width='470' height='84' style='text-align:left;line-height: 30px;padding-left: 3px;'>").append("1、借款情况：").append(null == dao.getContactPerson() ? "" : dao.getContactPerson()).append("</br>2、其他：").append(null == obj.getProcessComment() ? "" : obj.getProcessComment()).append("</td>");
                    sb.append("<td width='90' height='84' >").append(null == obj.getEmployeeName() ? "" : obj.getEmployeeName()).append("</td>");
                    sb.append("<td width='90' height='84' >").append(dateFormat.format(obj.getOperateTime())).append("</td>");
                    sb.append("</tr>");
                    list.remove(obj);
                    break;
                }
            }
            for (BaseGetProcessComment obj : list) {
                if (null != obj.getBackViewName() && obj.getBackViewName().equals("运营专员")) {
                    sb.append("<tr style='font-size:15px;'>");
                    sb.append("<td width='100' height='84' style='line-height: 30px;padding:0 5px;'>离职奖金</td>");
                    sb.append("<td width='470' height='84' style='text-align:left;line-height: 30px;padding-left: 3px;'>").append("1、离职奖金：").append(null == dao.getFee() ? "0" : dao.getFee()).append("</br>2、其他：").append(null == obj.getProcessComment() ? "" : obj.getProcessComment()).append("</td>");
                    sb.append("<td width='90' height='84' >").append(null == obj.getEmployeeName() ? "" : obj.getEmployeeName()).append("</td>");
                    sb.append("<td width='90' height='84' >").append(dateFormat.format(obj.getOperateTime())).append("</td>");
                    sb.append("</tr>");
                    list.remove(obj);
                    for (BaseGetProcessComment tempObj : list) {
                        if (null != tempObj.getBackViewName() && tempObj.getBackViewName().equals("部门负责人")) {
                            sb.append("<tr style='font-size:15px;'>");
                            sb.append("<td width='100' height='84' style='line-height: 30px;padding:0 5px;'>部门审批</td>");
                            sb.append("<td width='470' height='84' style='text-align:left;line-height: 30px;padding-left: 3px;'>").append("1、审批意见：").append(null == tempObj.getProcessComment() ? "" : tempObj.getProcessComment()).append("</td>");
                            sb.append("<td width='90' height='84' >").append(null == tempObj.getEmployeeName() ? "" : tempObj.getEmployeeName()).append("</td>");
                            sb.append("<td width='90' height='84' >").append(dateFormat.format(tempObj.getOperateTime())).append("</td>");
                            sb.append("</tr>");
                            list.remove(tempObj);
                            break;
                        }
                    }
                    break;
                }
            }
            for (BaseGetProcessComment obj : list) {
                if (null != obj.getBackViewName() && obj.getBackViewName().equals("部门经理")) {
                    sb.append("<tr style='font-size:15px;'>");
                    sb.append("<td width='100' height='84' style='line-height: 30px;padding:0 5px;'>部门主管审批</td>");
                    SystemDictionary dicDao = new SystemDictionary();
                    dicDao.setConditionDicTypeId("=", 99);
                    dicDao.setConditionDicTypeValueId("=", dao.getTargetProvince());
                    BaseSystemDictionary dicBean = dicDao.executeQueryOneRow();
                    sb.append("<td width='470' height='84' style='text-align:left;line-height: 30px;padding-left: 3px;'>").append("1、当月绩效情况：").append(null == dicBean.getDicTypeValue() ? "" : dicBean.getDicTypeValue()).append("</br>2、其他：").append(null == obj.getProcessComment() ? "" : obj.getProcessComment()).append("</td>");
                    sb.append("<td width='90' height='84' >").append(null == obj.getEmployeeName() ? "" : obj.getEmployeeName()).append("</td>");
                    sb.append("<td width='90' height='84' >").append(dateFormat.format(obj.getOperateTime())).append("</td>");
                    sb.append("</tr>");
                    list.remove(obj);
                    break;
                }
            }
            for (BaseGetProcessComment obj : list) {
                if (null != obj.getBackViewName() && obj.getBackViewName().equals("部门分管领导")) {
                    sb.append("<tr style='font-size:15px;'>");
                    sb.append("<td width='100' height='84' style='line-height: 30px;padding:0 5px;'>分管领导审批</td>");
                    sb.append("<td width='470' height='84' style='text-align:left;line-height: 30px;padding-left: 3px;'>").append("1、离职补偿：").append(null == dao.getSeverance() ? 0 : dao.getSeverance()).append("</br>2、审批意见：").append(null == obj.getProcessComment() ? "" : obj.getProcessComment()).append("</td>");
                    sb.append("<td width='90' height='84' >").append(null == obj.getEmployeeName() ? "" : obj.getEmployeeName()).append("</td>");
                    sb.append("<td width='90' height='84' >").append(dateFormat.format(obj.getOperateTime())).append("</td>");
                    sb.append("</tr>");
                    list.remove(obj);
                    break;
                }
            }
            for (BaseGetProcessComment obj : list) {
                if (null != obj.getBackViewName() && obj.getBackViewName().equals("部门")) {
                    sb.append("<tr style='font-size:15px;'>");
                    sb.append("<td width='100' height='84' style='line-height: 30px;padding:0 5px;'>部门审批</td>");
                    sb.append("<td width='470' height='84' style='text-align:left;line-height: 30px;padding-left: 3px;'>").append("1、审批意见：").append(null == obj.getProcessComment() ? "" : obj.getProcessComment()).append("</td>");
                    sb.append("<td width='90' height='84' >").append(null == obj.getEmployeeName() ? "" : obj.getEmployeeName()).append("</td>");
                    sb.append("<td width='90' height='84' >").append(dateFormat.format(obj.getOperateTime())).append("</td>");
                    sb.append("</tr>");
                    list.remove(obj);
                    break;
                }
            }
            for (BaseGetProcessComment obj : list) {
                if (null != obj.getBackViewName() && obj.getBackViewName().equals("人资总监")) {
                    sb.append("<tr style='font-size:15px;'>");
                    sb.append("<td width='100' height='84' style='line-height: 30px;padding:0 5px;'>人资部审批</td>");
                    sb.append("<td width='470' height='84' style='text-align:left;line-height: 30px;padding-left: 3px;'>").append("1、审批意见：").append(null == obj.getProcessComment() ? "" : obj.getProcessComment()).append("</td>");
                    sb.append("<td width='90' height='84' >").append(null == obj.getEmployeeName() ? "" : obj.getEmployeeName()).append("</td>");
                    sb.append("<td width='90' height='84' >").append(dateFormat.format(obj.getOperateTime())).append("</td>");
                    sb.append("</tr>");
                    break;
                }
            }
            sb.append("</table>");
            sb.append("<p style='position:absolute;left:0;bottom:12px;font-weight:700;font-size:15px;text-align:left;margin-top:20px;padding-left:15px;'>以上离职手续已办理完毕，本人确认签名<span style='border-bottom:1px solid #000;padding:0 15px;'>　　　　　　　</span>。</p>");
            sb.append("<div style='position:absolute; bottom:0px; left:85px;width:665px; height:15px; font-size:12px;color:#e3e3e3;'>　保密等级：机密　　　　　　　　　　　　存档期限：5年　　　　　　　　　　　　第 2 页 共 1 页</div>");
            sb.append("</div>");
            sb.append("</div>");
            BaseKeyValue bean = new BaseKeyValue();
            bean.setKey("htmlStr");
            bean.setValue(sb.toString());
            List<BaseKeyValue> tempList = new ArrayList<>();
            tempList.add(bean);
            collection.setCollections(tempList);
            return collection.toJSON();
        }
        return collection.toJSON(-1, "数据缺失");
    }

    //页眉
    public String getTop(Integer companyId) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div style='height:1097px;position: relative;'>");
        sb.append("<div style='height:43px; border-bottom: 1px solid #000;'>");
        if (companyId == StaticUtils.SIGN_COMPANY_1) {//深圳市博普森机电顾问有限公司
            sb.append("<img src = '/images/companyLogo/BPS.png' style='float:left; height:42px;'/>");
        } else if (companyId == StaticUtils.SIGN_COMPANY_2) {//姜峰设计（深圳）有限公司
            sb.append("<img src = '/images/companyLogo/JF.png' style='float:left; height:42px;'/>");
        } else {
            sb.append("<img src = '/images/companyLogo/JA.png' style='float:left; height:42px;'/>");
        }
        sb.append("<font style='text-align:right;width:750px;position: absolute; top: 20px; left:0px;font-size:14px;color:#e3e3e3;margin-right:10px;'>版/修(4/0)　　文件编号：J&A/QR62F-ARH　</font>");
        sb.append("</div>");
        return sb.toString();
    }

    //页脚
    public String getBottom() {
        StringBuilder sb = new StringBuilder();
        sb.append("<div style='position:absolute; bottom:0px; left:85px;width:665px; height:15px; font-size:12px;color:#e3e3e3;'>　保密等级：机密　　　　　　　　　　　　存档期限：5年　　　　　　　　　　　　第 1 页 共 1 页</div>");
        sb.append("</div>");
        return sb.toString();
    }

    //资料及办公用具移交
    public String getTabel2(List<BaseGetProcessComment> list, PersonnelBusines dao, String operator) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px;' width='750'>");
        sb.append("<tr><th colspan='5' height='42' style='font-weight:700;font-size:19px;'>二、资料及办公用具移交</th></tr>");
        sb.append("<tr style='font-size:15px;font-weight:700;'>");
        sb.append("<th width='150' height='42' style='font-weight:700'>名称</th>");
        sb.append("<th width='450' height='42' style='font-weight:700'>内容</th>");
        sb.append("<th width='150' height='42' style='font-weight:700'>接手人</th>");
        sb.append("</tr>");
        for (BaseGetProcessComment obj : list) {
            if (null != obj.getBackViewName() && obj.getBackViewName().equals("运维工程师")) {
                sb.append("<tr style='font-size:15px;'>");
                sb.append("<td width='150' height='42' >办公电脑等设备</td>");
                sb.append("<td width='450' height='42' >").append(null == dao.getEquivalentNumber() ? "" : dao.getEquivalentNumber()).append("</td>");
                sb.append("<td width='150' height='42' >").append(obj.getEmployeeName()).append("</td>");
                sb.append("</tr>");
                list.remove(obj);
                break;
            }
        }
        for (BaseGetProcessComment obj : list) {
            if (null != obj.getBackViewName() && obj.getBackViewName().equals("行政经理")) {
                sb.append("<tr style='font-size:15px;'>");
                sb.append("<td width='150' height='42' >桌椅、拖柜等</td>");
                sb.append("<td width='450' height='42' >").append("拖柜钥匙").append(null == dao.getCompanyProvince() ? "0" : dao.getCompanyProvince()).append("支，储物柜钥匙").append(null == dao.getNumberOfBaby() ? "0" : dao.getNumberOfBaby()).append("支</td>");
                sb.append("<td width='150' height='42' >").append(null == obj.getEmployeeName() ? "" : obj.getEmployeeName()).append("</td>");
                sb.append("</tr>");
                list.remove(obj);
                break;
            }
        }
        sb.append("<tr style='font-size:15px;'>");
        sb.append("<td width='150' height='42' >工卡</td>");
        sb.append("<td width='450' height='42' >吊绳、卡套、工作牌</td>");
        sb.append("<td width='150' height='42' >").append(null == operator ? "" : operator).append("</td>");
        sb.append("</tr>");
        sb.append("</table>");
        return sb.toString();
    }

    //离职调查
    public String getTabel3(PersonnelBusines dao) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px;' width='750'>");
        sb.append("<tr><th colspan='5' height='42' style='font-weight:700;font-size:19px;'>三、离职调查</th></tr>");
        sb.append("<tr style='font-size:15px;'>");
        sb.append("<td width='300' height='84' >您认为公司哪些方面需要改善</td>");
        sb.append("<td width='450' height='84' >").append(null == dao.getSubTypeStr() ? "" : dao.getSubTypeStr()).append("</td>");
        sb.append("</tr>");
        sb.append("<tr style='font-size:15px;'>");
        sb.append("<td width='300' height='42' >您离职后的计划</td>");
        sb.append("<td width='450' height='42' >").append(null == dao.getPlan() ? "" : dao.getPlan()).append("</td>");
        sb.append("</tr>");
        sb.append("<tr style='font-size:15px;'>");
        sb.append("<td width='300' height='42' >您对公司有什么建议</td>");
        sb.append("<td width='450' height='42' >").append(null == dao.getRemark() ? "" : dao.getRemark()).append("</td>");
        sb.append("</tr>");
        sb.append("</table>");
        return sb.toString();
    }

    /**
     * 获取员工当月的考勤信息
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String getCheckInfoStr(Map<String, Object> params) throws Exception {
        BaseCollection<BaseEmployeeMonthCheck> bc = new BaseCollection<>();
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(BaseHelpUtils.getLongValue(params.get("date"))));
        EmployeeMonthCheck checkDao = new EmployeeMonthCheck();
        checkDao.setConditionEmployeeId("=", BaseHelpUtils.getIntValue(params.get("employeeId")));
        checkDao.setConditionYear("=", c.get(Calendar.YEAR));
        checkDao.setConditionMonth("=", c.get(Calendar.MONTH) + 1);
        BaseEmployeeMonthCheck checkBean = checkDao.executeQueryOneRow();
        StringBuilder sb = new StringBuilder();
        if (null != checkBean) {
            if (null != checkBean.getLateLeave5m() && checkBean.getLateLeave5m().intValue() > 0) {
                sb.append("5分钟内迟到").append(checkBean.getLateLeave5m()).append("次");
            }
            if (null != checkBean.getLateLeave10m() && checkBean.getLateLeave10m().intValue() > 0) {
                if (sb.length() > 0) {
                    sb.append("，");
                }
                sb.append("10分钟内迟到").append(checkBean.getLateLeave10m()).append("次");
            }
            if (null != checkBean.getLateLeave30m() && checkBean.getLateLeave30m().intValue() > 0) {
                if (sb.length() > 0) {
                    sb.append("，");
                }
                sb.append("半小时内迟到").append(checkBean.getLateLeave30m()).append("次");
            }
            if (null != checkBean.getLateLeave() && checkBean.getLateLeave().intValue() > 0) {
                if (sb.length() > 0) {
                    sb.append("，");
                }
                sb.append("扣款迟到").append(checkBean.getLateLeave()).append("次");
            }
            if (checkBean.getThingLeaveHours().compareTo(BigDecimal.ZERO) > 0 || checkBean.getThingLeaveDays().compareTo(BigDecimal.ZERO) > 0) {
                if (sb.length() > 0) {
                    sb.append("，");
                }
                sb.append("事假");
                if (checkBean.getThingLeaveDays().compareTo(BigDecimal.ZERO) > 0) {
                    sb.append(checkBean.getThingLeaveDays()).append("天");
                }
                if (checkBean.getThingLeaveHours().compareTo(BigDecimal.ZERO) > 0) {
                    sb.append(checkBean.getThingLeaveHours()).append("小时");
                }
            }
            if (checkBean.getIllLeaveHours().compareTo(BigDecimal.ZERO) > 0 || checkBean.getIllLeaveDays().compareTo(BigDecimal.ZERO) > 0) {
                if (sb.length() > 0) {
                    sb.append("，");
                }
                sb.append("病假");
                if (checkBean.getIllLeaveDays().compareTo(BigDecimal.ZERO) > 0) {
                    sb.append(checkBean.getIllLeaveDays()).append("天");
                }
                if (checkBean.getIllLeaveHours().compareTo(BigDecimal.ZERO) > 0) {
                    sb.append(checkBean.getIllLeaveHours()).append("小时");
                }
            }
            if (sb.length() == 0) {
                sb.append("正常");
            }
            checkBean.setRemark(sb.toString());
        } else {
            return bc.toJSON(-1, "找不到该员工离职月份的考勤信息");
        }
        List<BaseEmployeeMonthCheck> list = new ArrayList<>();
        list.add(checkBean);
        bc.setCollections(list);
        return bc.toJSON();
    }

    @SuppressWarnings("unchecked")
    public String positiveEmployee(Map<String, Object> params) throws Exception {
        //获取转正人员数据集
        List<BasePositiveEmployeeInfo> list = GenericBase.__getList(params.get("employeeList"), BasePositiveEmployeeInfo.newInstance());
        if (BaseHelpUtils.isNullOrEmpty(list) || list.size() == 0) {
            throw new SQLException("操作异常：未获取到转正人员数据集");
        }
        //获取发起人
        int drafter = BaseHelpUtils.getIntValue(params.get("drafter"));
        NewCreateWorkFlow createWorkFlow = new NewCreateWorkFlow();
        AccountManageProcess accountProcess = new AccountManageProcess();
        Department dDao = new Department();
        Employee eDao = new Employee();
        for (BasePositiveEmployeeInfo obj : list) {
            Map<String, Integer> processInfoMap = new HashMap<>();
            Map<String, Object> map = new HashMap<>();
            //获取人员id
            int employeeId = BaseHelpUtils.getIntValue(obj.getEmployeeId());
            //获取职员名称
            String empName = BaseHelpUtils.getString(obj.getEmployeeName());
            eDao.clear();
            eDao.setEmployeeId(employeeId);
            if (!eDao.load()) {
                throw new SQLException(String.format("操作异常：未加载到职员(%1$s)的职员信息", empName));
            }
            //获取部门id
            int departmentId = BaseHelpUtils.getIntValue(obj.getDepartmentId());
            dDao.clear();
            dDao.setDepartmentId(departmentId);
            if (!dDao.load()) {
                throw new SQLException(String.format("操作异常：未加载到职员(%1$s)的所在部门的部门信息", empName));
            }
            //获取部门名称
            String depName = BaseHelpUtils.getString(dDao.getDepartmentName());
            ConditionGetProcessByTypeAndDepartment condition = new ConditionGetProcessByTypeAndDepartment();
            condition.setProcessTypeId(StaticUtils.PROCESS_TYPE_29);
            condition.setDepartmentId(departmentId);
            QueryGetProcessByTypeAndDepartment query = new QueryGetProcessByTypeAndDepartment();
            BaseCollection<BaseGetProcessByTypeAndDepartment> collection = query.executeQuery(null, condition);
            if (BaseHelpUtils.isNullOrEmpty(collection) || collection.getCollections().isEmpty()) {
                throw new SQLException(String.format("操作异常：职员(%1$s)所在部门(%2$s)未绑定流程", empName, depName));
            }
            processInfoMap.put("processId", collection.getCollections().get(0).getProcessId());
            map.put("processDefinition", processInfoMap);
            Map<String, Object> userData = new HashMap<>();
            //修改转正申请 不需要加载薪资信息
			/*ConditionOnLoadEmployeePayment employeePaymentCondition = new ConditionOnLoadEmployeePayment();
			employeePaymentCondition.setEmployeeId(employeeId);
			employeePaymentCondition.setEnabled(true);
			QueryOnLoadEmployeePayment employeePaymentQuery = new QueryOnLoadEmployeePayment();
			BaseCollection<BaseOnLoadEmployeePayment> employeePaymentCollection = employeePaymentQuery.executeQuery(null, employeePaymentCondition);
			if (BaseHelpUtils.isNullOrEmpty(employeePaymentCollection) || employeePaymentCollection.getCollections().isEmpty()) {
				throw new SQLException(String.format("操作异常：未加载到职员(%1$s)的薪酬信息", empName));
			}
			BaseOnLoadEmployeePayment payBean = employeePaymentCollection.getCollections().get(0);*/
            userData.put("employeeId", employeeId);
            userData.put("employeeNo", obj.getEmployeeNo());
            userData.put("companyId", obj.getCompanyId());
            userData.put("departmentId", obj.getDepartmentId());
            userData.put("startDate", obj.getOnboardDate().getTime());
            userData.put("type", StaticUtils.POSITIVE_TYPE_1);
            userData.put("endDate", obj.getPositiveDate().getTime());
            userData.put("dutyId", obj.getDutyId());
            userData.put("targetProvince", obj.getGradeId());
			/*userData.put("originalPay", obj.getTryTimePay());
			if (BaseHelpUtils.getBigDecimalValue(obj.getPositivePay()).compareTo(BigDecimal.ZERO) == 0) {
				userData.put("totalPay", obj.getPositivePay());
			} else {
				userData.put("totalPay", BaseHelpUtils.getBigDecimalValue(obj.getPositivePay()).add(BaseHelpUtils.getBigDecimalValue(payBean.getForemanPay())));
			}
			userData.put("monthPay", obj.getPositivePay());*/
            userData.put("annualPerformance", obj.getAnnualPerformance());
			/*userData.put("foremanPay", payBean.getForemanPay());
			userData.put("otherSubsidy", payBean.getOtherSubsidy());
			userData.put("costAttribution", payBean.getCostAttribution());*/
            userData.put("drafter", drafter);
            userData.put("fee", BaseHelpUtils.getDoubleValue(accountProcess.getBenefitsOfEmployee(employeeId, null).get(employeeId)));
            map.put("userData", userData);
            createWorkFlow.execute(MapUtils.toJSON(map), drafter, true);
        }
        BaseCollection<GenericBase> bc = new BaseCollection<>();
        return bc.toJSON(0, "");
    }

    public String getRegularEmployeeHtml(Map<String, Object> params) throws Exception {
        StringBuilder sb = new StringBuilder();
        int businessId = BaseHelpUtils.getIntValue(params.get("businessId"));
        int processType = BaseHelpUtils.getIntValue(params.get("processType"));
        String employeeName = BaseHelpUtils.getString(params.get("employeeName"));
        String duty = BaseHelpUtils.getString(params.get("duty"));
        String grade = BaseHelpUtils.getString(params.get("grade"));
        ConditionDecryptPersonnelBusiness condition = new ConditionDecryptPersonnelBusiness();
        condition.setPersonnelBusinessId(businessId);
        QueryDecryptPersonnelBusiness query = new QueryDecryptPersonnelBusiness();
        BaseCollection<BaseDecryptPersonnelBusiness> bc = query.executeQuery(null, condition);
        if (null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()) {
            BaseDecryptPersonnelBusiness bean = bc.getCollections().get(0);
            Employee employeeDao = new Employee();
            employeeDao.setEmployeeId(bean.getEmployeeId());
            employeeDao.unsetSelectFlags();
            employeeDao.setSelectPlateId(true);
            if (employeeDao.load()) {
                PlateRecord plateRecordDao = new PlateRecord();
                plateRecordDao.setConditionPlateId("=", employeeDao.getPlateId());
                BasePlateRecord plateBean = plateRecordDao.executeQueryOneRow();
                String plateName = plateBean.getPlateName();
                ConditionGetProcessComment condition2 = new ConditionGetProcessComment();
                condition2.setBusinessId(businessId);
                condition2.setProcessType(processType);
                QueryGetProcessComment query2 = new QueryGetProcessComment();
                BaseCollection<BaseGetProcessComment> bc2 = query2.executeQuery(null, condition2);
                List<BaseGetProcessComment> list = bc2.getCollections();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
                sb.append("	<meta charset='UTF-8'>");
                sb.append("	<style>");
                sb.append(" 		*{");
                sb.append("		font-family:'微软雅黑';");
                sb.append("} ");
                sb.append("		th{");
                sb.append("			font-weight:normal;");
                sb.append("		}");
                sb.append("		td{");
                sb.append("			text-align:center;");
                sb.append("		}");
                sb.append("	</style>");
                sb.append("    <body style='width: 750px;'>");
                sb.append("		<!--表格1内容star--> ");
                sb.append("		<div style='height:1097px;position: relative; width:750px;'>  	");
                sb.append("			<!--表头star-->");
                sb.append("			<div style='height:43px; border-bottom: 1px solid #000;'>");
                if (bean.getCompanyId() == StaticUtils.SIGN_COMPANY_1) {//深圳市博普森机电顾问有限公司
                    sb.append("<img src = '/images/companyLogo/BPS.png' style='float:left; height:42px;'/>");
                } else if (bean.getCompanyId() == StaticUtils.SIGN_COMPANY_2) {//姜峰设计（深圳）有限公司
                    sb.append("<img src = '/images/companyLogo/JF.png' style='float:left; height:42px;'/>");
                } else {
                    sb.append("<img src = '/images/companyLogo/JA.png' style='float:left; height:42px;'/>");
                }
                sb.append("				<font style='text-align:right;width:750px;position: absolute; top: 20px; left:0px;font-size:14px;color:#e3e3e3;margin-right:10px;'>版/修(4/0)　　文件编号：J&A/QR62P-ARH　</font>");
                sb.append("			</div>");
                sb.append("			<!--表头over-->");
                sb.append("				<table border='0' cellpadding='0' cellspacing='0' style ='margin-top:100px; margin-left:200px;'>");
                sb.append("							<caption style='font-size:45px;font-weight: bold;margin-bottom:280px;'>");
                sb.append("							   员工转正申请表");
                sb.append("							</caption>	");
                sb.append("");
                sb.append("							<tr style='font-size:16px;'>");
                sb.append("								<td width='100' height='60' valign='bottom'>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>");
                sb.append("								<td width='250' height='60' style='border-bottom:1px solid #333;' valign='bottom'>" + employeeName + "</td>");
                sb.append("							</tr>");
                sb.append("							<tr style='font-size:16px;'>");
                sb.append("								<td widtd='100' height='60' valign='bottom'>入职时间：</td>");
                sb.append("								<td width='250' height='60' style='border-bottom:1px solid #333;' valign='bottom'>" + dateFormat.format(bean.getStartDate()) + "</td>");
                sb.append("							</tr>");
                sb.append("							<tr style='font-size:16px;'>");
                sb.append("								<td widtd='100' height='60' valign='bottom'>部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门：</td>");
                sb.append("								<td width='250' height='60' style='border-bottom:1px solid #333;' valign='bottom'>" + plateName + "</td>");
                sb.append("							</tr>																									");
                sb.append("				</table>							");
                sb.append("			<!--表尾star-->");
                sb.append("			<div style='position:absolute; bottom:0px; left:0px;width:750px; height:15px; font-size:12px;color:#e3e3e3;'>　　　　　　　保密等级：机密　　　　　　　　　　　　存档期限：5年　　　　　　　　　　　　第 1 页 共 3 页</div>");
                sb.append("			<!--表尾over-->	");
                sb.append("		</div>");
                sb.append("		<!--表格1内容over-->     	");
                sb.append("		<!--表格2内容star--> ");
                sb.append("		<div style='height:1097px;position: relative; width:750px;'>  	");
                sb.append("			<!--表头star-->");
                sb.append("			<div style='height:43px; border-bottom: 1px solid #000;'>");
                if (bean.getCompanyId() == StaticUtils.SIGN_COMPANY_1) {//深圳市博普森机电顾问有限公司
                    sb.append("<img src = '/images/companyLogo/BPS.png' style='float:left; height:42px;'/>");
                } else if (bean.getCompanyId() == StaticUtils.SIGN_COMPANY_2) {//姜峰设计（深圳）有限公司
                    sb.append("<img src = '/images/companyLogo/JF.png' style='float:left; height:42px;'/>");
                } else {
                    sb.append("<img src = '/images/companyLogo/JA.png' style='float:left; height:42px;'/>");
                }
                sb.append("				<font style='text-align:right;width:750px;position: absolute; top: 20px; left:0px;font-size:14px;color:#e3e3e3;margin-right:10px;'>版/修(4/0)　　文件编号：J&A/QR62P-ARH　</font>");
                sb.append("			</div>");
                sb.append("			<!--表头over-->");
                sb.append("				<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:23px;'>");
                sb.append("							<caption style='font-size: 22px;font-weight: bold;margin-bottom: 23px;'>");
                sb.append("							   试用期工作总结");
                sb.append("							</caption>	");
                sb.append("");
                sb.append("							<tr style='font-size:15px;'>");
                sb.append("								<td width='125' height='42'>姓名</td>");
                sb.append("								<td width='250' height='42'>" + employeeName + "</td>");
                sb.append("								<td width='125' height='42'>入职时间</td>");
                sb.append("								<td width='250' height='42'>" + dateFormat.format(bean.getStartDate()) + "</td>");
                sb.append("							</tr>");
                sb.append("							<tr style='font-size:15px;'>");
                sb.append("								<td widtd='125' height='42'>部门</td>");
                sb.append("								<td width='250' height='42'>" + plateName + "</td>");
                sb.append("								<td width='125' height='42'>职务</td>");
                sb.append("								<td width='250' height='42'>" + duty + "</td>");
                sb.append("							</tr>																									");
                sb.append("				</table>");
                sb.append("				<!--一、自我鉴定star-->");
                sb.append("				<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px;' height='800'>			");
                sb.append("							<tr style='font-size:15px;' >");
                sb.append("								<td width='122' height='400' colspan='1' >");
                sb.append("									<span>工作总结</span>");
                sb.append("								</td>");
                sb.append("								<td width='625' height='420' colspan='3' style='text-align:left;'>");
                sb.append(bean.getRemark().replaceAll("\r\n", "<br/>").replaceAll("\r", "<br/>").replaceAll("\n", "<br/>"));
                sb.append("								</td>");
                sb.append("							</tr>");
                sb.append("							<tr style='font-size:15px;' >");
                sb.append("								<td width='122' height='420' colspan='1' >");
                sb.append("									<span>自我鉴定</span>");
                sb.append("								</td>");
                sb.append("								<td width='625' height='400' colspan='3' style='text-align:left;'>");
                sb.append(bean.getReason().replaceAll("\r\n", "<br/>").replaceAll("\r", "<br/>").replaceAll("\n", "<br/>"));
                sb.append("								</td>");
                sb.append("							</tr>																																																				");
                sb.append("				</table>");
                sb.append("				<!--一、自我鉴定over-->								");
                sb.append("			<!--表尾star-->");
                sb.append("			<div style='position:absolute; bottom:0px; left:0px;width:750px; height:15px; font-size:12px;color:#e3e3e3;'>　　　　　　　保密等级：机密　　　　　　　　　　　　存档期限：5年　　　　　　　　　　　　第 2 页 共 3 页</div>");
                sb.append("			<!--表尾over-->	");
                sb.append("		</div>");
                sb.append("		<!--表格2内容over--> ");
                sb.append("		<!--表格3内容star--> ");
                sb.append("		<div style='height:1097px;position: relative; width:750px;'>  	");
                sb.append("			<!--表头star-->");
                sb.append("			<div style='height:53px; border-bottom: 1px solid #000;'>");
                if (bean.getCompanyId() == StaticUtils.SIGN_COMPANY_1) {//深圳市博普森机电顾问有限公司
                    sb.append("<img src = '/images/companyLogo/BPS.png' style='float:left; height:42px;'/>");
                } else if (bean.getCompanyId() == StaticUtils.SIGN_COMPANY_2) {//姜峰设计（深圳）有限公司
                    sb.append("<img src = '/images/companyLogo/JF.png' style='float:left; height:42px;'/>");
                } else {
                    sb.append("<img src = '/images/companyLogo/JA.png' style='float:left; height:42px;'/>");
                }
                sb.append("				<font style='text-align:right;width:750px;position: absolute; top: 20px; left:0px;font-size:14px;color:#e3e3e3;margin-right:10px;'>版/修(4/0)　　文件编号：J&A/QR62P-ARH　</font>");
                sb.append("			</div>");
                sb.append("			<!--表头over-->");
                sb.append("				<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:23px; width:750px;'>");
                sb.append("							<caption style='font-size: 22px;font-weight: bold;margin-bottom: 23px;'>");
                sb.append("							   转正审批");
                sb.append("							</caption>	");
                sb.append("");
                sb.append("							<tr style='font-size:15px;'>");
                sb.append("								<td width='13%' height='90'>姓名</td>");
                sb.append("								<td width='20%' height='90'>" + employeeName + "</td>");
                sb.append("								<td widtd='13%' height='90'>部门</td>");
                sb.append("								<td width='20%' height='90'>" + plateName + "</td>");
                sb.append("								<td width='13%' height='90'>职务</td>");
                sb.append("								<td width='20%' height='90'>" + duty + "</td>");
                sb.append("								");
                sb.append("							</tr>");
                sb.append("							<tr style='font-size:15px;'>");
                sb.append("								<td width='13%' height='90'>入职时间</td>");
                sb.append("								<td width='20%' height='90'>" + dateFormat.format(bean.getStartDate()) + "</td>");
                sb.append("								<td width='13%' height='90'>转正时间</td>");
                sb.append("								<td width='20%' height='90'>" + dateFormat.format(bean.getEndDate()) + "</td>");
                sb.append("								<td width='13%' height='90'>试用期期限</td>");
                sb.append("								<td width='20%' height='90'>" + DateUtil.generateDaysBetween(bean.getEndDate(), bean.getStartDate()) / 30 + "个月</td>");
                sb.append("							</tr>	");
                sb.append("							<tr style='font-size:15px;'>");
                sb.append("								<td width='13%' height='90'>试用期薪资</td>");
                sb.append("								<td width='20%' height='90'>" + bean.getOriginalPay() + "</td>");
                sb.append("								<td width='13%' height='90'>转正薪资</td>");
                sb.append("								<td width='20%' height='90'>" + bean.getTotalPay() + "</td>");
                sb.append("								<td width='13%' height='90'>职级</td>");
                sb.append("								<td width='20%' height='90'>" + grade + "</td>");
                sb.append("							</tr>																								");
                sb.append("				</table>");
                sb.append("				<!--一、自我鉴定star-->");
                sb.append("				<!--部门负责人审批start-->");
                sb.append("				<table border='1' cellpadding='0' cellspacing='0' style ='margin-top:-2px; width:750px;'>																					");
                sb.append("					<tr style='font-size:15px;font-weight:bold;'>								");
                sb.append("						<td width='33%' height='50'>事项</td>");
                sb.append("						<td width='33%' height='50'>审批意见</td>");
                sb.append("						<td width='13%' height='50'>经办人</td>");
                sb.append("						<td width='20%' height='50'>审批时间</td>");
                sb.append("					</tr>");
                for (BaseGetProcessComment obj : list) {
                    if (null != obj.getBackViewName() && obj.getBackViewName().equals("部门负责人")) {
                        sb.append("<tr style='font-size:15px;'>");
                        sb.append("						<td width='33%' height='130'>部门负责人审批</td>");
                        sb.append("						<td width='33%' height='130'>");
                        if (null != obj.getProcessComment() && obj.getProcessComment().trim().length() > 0) {
                            sb.append(obj.getProcessComment().replaceAll("\r\n", "<br/>").replaceAll("\r", "<br/>").replaceAll("\n", "<br/>"));
                        } else {
                            sb.append("同意");
                        }
                        sb.append("</td>");
                        sb.append("						<td width='13%' height='130'>" + obj.getEmployeeName() + "</td>");
                        sb.append("						<td width='20%' height='130'>" + dateFormat.format(obj.getOperateTime()) + "</td>");
                        sb.append("</tr>");
                        list.remove(obj);
                        break;
                    }
                }
                for (BaseGetProcessComment obj : list) {
                    if (null != obj.getBackViewName() && obj.getBackViewName().equals("部门主管领导")) {
                        sb.append("<tr style='font-size:15px;'>");
                        sb.append("						<td width='33%' height='130'>部门主管领导审批</td>");
                        sb.append("						<td width='33%' height='130'>");
                        if (null != obj.getProcessComment() && obj.getProcessComment().trim().length() > 0) {
                            sb.append(obj.getProcessComment().replaceAll("\r\n", "<br/>").replaceAll("\r", "<br/>").replaceAll("\n", "<br/>"));
                        } else {
                            sb.append("同意");
                        }
                        sb.append("</td>");
                        sb.append("						<td width='13%' height='130'>" + obj.getEmployeeName() + "</td>");
                        sb.append("						<td width='20%' height='130'>" + dateFormat.format(obj.getOperateTime()) + "</td>");
                        sb.append("</tr>");
                        list.remove(obj);
                        break;
                    }
                }
                for (BaseGetProcessComment obj : list) {
                    if (null != obj.getBackViewName() && obj.getBackViewName().equals("部门分管领导")) {
                        sb.append("<tr style='font-size:15px;'>");
                        sb.append("						<td width='33%' height='130'>部门分管领导审批</td>");
                        sb.append("						<td width='33%' height='130'>");
                        if (null != obj.getProcessComment() && obj.getProcessComment().trim().length() > 0) {
                            sb.append(obj.getProcessComment().replaceAll("\r\n", "<br/>").replaceAll("\r", "<br/>").replaceAll("\n", "<br/>"));
                        } else {
                            sb.append("同意");
                        }
                        sb.append("</td>");
                        sb.append("						<td width='13%' height='130'>" + obj.getEmployeeName() + "</td>");
                        sb.append("						<td width='20%' height='130'>" + dateFormat.format(obj.getOperateTime()) + "</td>");
                        sb.append("</tr>");
                        list.remove(obj);
                        break;
                    }
                }
                for (BaseGetProcessComment obj : list) {
                    if (null != obj.getBackViewName() && obj.getBackViewName().equals("人资部")) {
                        sb.append("<tr style='font-size:15px;'>");
                        sb.append("						<td width='33%' height='130'>人资部审批</td>");
                        sb.append("						<td width='33%' height='130'>");
                        if (null != obj.getProcessComment() && obj.getProcessComment().trim().length() > 0) {
                            sb.append(obj.getProcessComment().replaceAll("\r\n", "<br/>").replaceAll("\r", "<br/>").replaceAll("\n", "<br/>"));
                        } else {
                            sb.append("同意");
                        }
                        sb.append("</td>");
                        sb.append("						<td width='13%' height='130'>" + obj.getEmployeeName() + "</td>");
                        sb.append("						<td width='20%' height='130'>" + dateFormat.format(obj.getOperateTime()) + "</td>");
                        sb.append("</tr>");
                        list.remove(obj);
                        break;
                    }
                }
                sb.append("				</table>");
                sb.append("				<p style='font-weight:700;font-size:15px;text-align:left;margin-top:30px;padding-left:15px;'>员工本人签字：</p>	");
                sb.append("			<!--表尾star-->");
                sb.append("			<div style='position:absolute; bottom:0px; left:0px;width:750px; height:15px; font-size:12px;color:#e3e3e3;'>　　　　　　　保密等级：机密　　　　　　　　　　　　存档期限：5年　　　　　　　　　　　　第 3 页 共 3 页</div>");
                sb.append("			<!--表尾over-->	");
                sb.append("		</div>");
                sb.append("	</body>");
            }

        }
        BaseCollection<GenericBase> returnCollection = new BaseCollection<>();
        Map<String, String> map = new HashMap<>();
        map.put("html", sb.toString());
        returnCollection.setUserData(map);
        return returnCollection.toJSON();
    }

    public String salaryAdjustment(Map<String, Object> params) throws Exception {
        List<BaseEmployeeInfoOfNoSalaryAdjustment> list = GenericBase.__getList(
                params.get("list"), BaseEmployeeInfoOfNoSalaryAdjustment.newInstance());
        int drafter = BaseHelpUtils.getIntValue(params.get("drafter"));
        if (null != list && !list.isEmpty()) {
            NewCreateWorkFlow createWorkFlow = new NewCreateWorkFlow();
            Map map = new HashMap<>();
            Map<String, Integer> processInfoMap = new HashMap<>();
            for (BaseEmployeeInfoOfNoSalaryAdjustment obj : list) {
                ConditionGetProcessByTypeAndDepartment condition = new ConditionGetProcessByTypeAndDepartment();
                condition.setProcessTypeId(StaticUtils.PROCESS_TYPE_30);
                condition.setDepartmentId(obj.getDepartmentId());
                QueryGetProcessByTypeAndDepartment query = new QueryGetProcessByTypeAndDepartment();
                BaseCollection<BaseGetProcessByTypeAndDepartment> collection = query.executeQuery(null, condition);
                if (null != collection && null != collection.getCollections() && !collection.getCollections().isEmpty()) {
                    processInfoMap.put("processId", collection.getCollections().get(0).getProcessId());
                    map.put("processDefinition", processInfoMap);
                    Map userData = new HashMap<>();
                    Integer employeeId = obj.getEmployeeId();
                    userData.put("employeeId", employeeId);
                    userData.put("employeeNo", obj.getEmployeeNo());
                    userData.put("companyId", obj.getCompanyId());
                    userData.put("departmentId", obj.getDepartmentId());
                    userData.put("startDate", obj.getOnboardDate().getTime());
                    userData.put("type", obj.getType());
                    userData.put("endDate", obj.getChangeDate().getTime());
                    userData.put("targetProvince", obj.getPlateId());
                    userData.put("originalPay", obj.getOriginalPay());
                    userData.put("monthPay", obj.getMonthPay());
                    userData.put("severance", obj.getChangePay());
                    userData.put("subType", obj.getPercent());
                    userData.put("drafter", drafter);
                    userData.put("fee", obj.getFee());
                    userData.put("remark", obj.getRemark());
                    map.put("userData", userData);
                    createWorkFlow.execute(MapUtils.toJSON(map), drafter, true);
                }
            }
        }
        return null;
    }

    public String agreeSalaryAdjustment(Map<String, Object> params) throws Exception {
        List<Map> list = (List<Map>) params.get("list");
        Integer operator = BaseHelpUtils.getIntValue(params.get("operator"));
        WorkFlowActivityProcessor activityProcessor = new WorkFlowActivityProcessor();
        WorkFlowPooledTaskProcessor taskProcessor = new WorkFlowPooledTaskProcessor();
        for (Map map : list) {
            if (BaseHelpUtils.getIntValue(map.get("typeFlag")) == StaticUtils.ACTIVITY_TYPE_FLAG_POOL) {
                taskProcessor.execute(MapUtils.toJSON(map), operator);
            } else {
                activityProcessor.execute(MapUtils.toJSON(map), operator);
            }
        }
        return null;
    }

    public String agreeSalaryAdjustmentAttention(Map<String, Object> params) throws Exception {
        List<Map> list = (List<Map>) params.get("list");
        Integer operator = BaseHelpUtils.getIntValue(params.get("operator"));
        for (Map map : list) {
            BaseSystemProcessAttention bspa = new BaseSystemProcessAttention();
            bspa.setDataFromMap(map);
            SystemProcessAttention spa = new SystemProcessAttention();
            spa.setPrimaryKeyFromBase(bspa);
            spa.load();
            spa.setDataFromBase(bspa);
            spa.setEmployeeId(operator);
            spa.setStatus(SystemProcessConstants.ATTENTION_STATUS_DONE);
            spa.update();
        }
        return null;
    }

    /**
     * 销假
     * @param params
     * @return
     */
    private String canelHoliday(Map<String, Object> params) throws Exception{
        ThreadConnection.beginTransaction();
        boolean resetProcessInstanceActivityId = false;
        boolean addNewInstanceActivities = false;
        int processStatusCanel = 7;
        BaseCollection<BaseEmployeeCheckinout> bc = new BaseCollection<>();
        BasePersonnelBusines bean = new BasePersonnelBusines();
        boolean completed = false;
        Map map = (Map<String, Object>) params.get("userData");
        bean.setDataFromMap(map);
//        WORKFLOWPROCESSORS.put("Leave_apply", "pomplatform.workflow.personnelbusiness.handler.LeaveApplyWorker");
        int employeeId = Integer.parseInt(map.get("employeeId")+"");

        PersonnelBusines dao = new PersonnelBusines();
        dao.setPrimaryKeyFromBase(bean);

        int type = BaseHelpUtils.getIntValue(bean.getType());
        if (type == StaticUtils.LEAVE_TYPE_22) {
            deleteAnnualLeave(bean);
        }
        if(type ==StaticUtils.LEAVE_TYPE_21){
            Integer personnelBusinessId = bean.getPersonnelBusinessId();
            CompensatoryLeave cl = new CompensatoryLeave();
            cl.setConditionBusinessId("=",personnelBusinessId);
            List<BaseCompensatoryLeave> list = cl.conditionalLoad();
            if(!BaseHelpUtils.isNullOrEmpty(list)){
                for (BaseCompensatoryLeave b:list){
                    b.setStatus(2);
                    cl.clear();
                    cl.setDataFromBase(b);
                    cl.update();
                }
            }
        }

        delicacy.system.bean.BaseSystemProcessInstanceActivity currentInstanceActivity = new delicacy.system.bean.BaseSystemProcessInstanceActivity();
        currentInstanceActivity.setDataFromMap(map);
        int processIntanceActivityId = BaseHelpUtils.getIntValue(currentInstanceActivity.getProcessInstanceActivityId());
        if(processIntanceActivityId > 0) {
            delicacy.system.dao.SystemProcessInstanceActivity activityDao = new delicacy.system.dao.SystemProcessInstanceActivity();
            activityDao.setProcessInstanceActivityId(processIntanceActivityId);
            if(!activityDao.load()) {
                throw new Exception("加载当前流程节点失败");
            }
            Integer status = activityDao.getStatus();
            if(status == null || status != SystemProcessConstants.ACTIVITY_STATUS_ACTIVE) {
                throw new SQLException("操作失败，该节点不是活动状态！");
            }
        }
        ProcessInformation pi = ProcessUtil.getAllInformation(currentInstanceActivity.getProcessInstanceId());
        SystemProcessDefinition definition = pi.getProcessDefinition();
        ProcessInstance instance = pi.getProcessInstance();
        ProcessUtil.findCurrentInstanceActivity(instance, currentInstanceActivity);
        if (!Objects.equals(currentInstanceActivity.getEmployeeId(), employeeId)) {
            throw new Exception("您不是本节点的审批人，无法审批");
        }
        currentInstanceActivity.setProcessComment(BaseHelpUtils.getStringValue(params, "processComment"));
        int approvalment = BaseHelpUtils.getIntValue(params, "approvalment");
        int additionalEmployee = BaseHelpUtils.getIntValue(params, "additionalApprovalment");

        String executeClassName = AbstractProcessores
                .getWorkflowProcessorClass(definition.getProcessType().getProcessExecuteName());
        if (executeClassName == null) {
            throw new SQLException("process execute class not found");
        }
        GenericWorkflowProcessor gwp = (GenericWorkflowProcessor) Class.forName(executeClassName).newInstance();
        if(map != null && !map.isEmpty()){
            map.put("approvalment",approvalment);
        }
        instance.setProcessStatus(processStatusCanel);
        instance.setCompleteTime(new Date());
        for (BaseSystemProcessInstanceActivity a : instance.getActivities()) {
            if (Objects.equals(a.getActivityId(), currentInstanceActivity.getActivityId())) {
                a.setEmployeeId(employeeId);
                a.setProcessComment(currentInstanceActivity.getProcessComment());
                a.setStatus(SystemProcessConstants.ACTIVITY_STATUS_REJECT);
                a.setOperateTime(new Date());
                ProcessUtil.passPooledTaskAndAttentions(instance, a.getActivityId(),
                        currentInstanceActivity.getProcessComment());
            }
        }
        completed = true;
        if (!completed) {
            instance.setProcessStatus(SystemProcessConstants.PROCESS_STATUS_WORKING);
        } else {
            if (approvalment == 0 || approvalment == 3) {//同意和转交存在自动跳过节点的情况，所以流程都有可能跑完
                instance.setProcessStatus(SystemProcessConstants.PROCESS_STATUS_COMPLETED);
            } else if (approvalment == 1) {
                instance.setProcessStatus(processStatusCanel);
            }
            instance.setCompleteTime(new Date());
        }
        SystemProcessInstanceWithSss spiws = new SystemProcessInstanceWithSss();
        spiws.setPrimaryKeyFromBase(instance);
        spiws.load();
        spiws.setDataFromBase(instance);
        spiws.setDetailSystemProcessInstanceActivity(ProcessInstanceActivity.toBaseList(instance.getActivities()));
        spiws.setDetailSystemProcessAttention(instance.getAttentions());
        spiws.setDetailSystemProcessPooledTask(instance.getTasks());
        spiws.update();
        //如果需要重新设置任务池和知会节点所关联的流程实例节点ID
        if (resetProcessInstanceActivityId) {
            List<ProcessInstanceActivity> piaList = instance.getActivities();
            int currentActivityId = BaseHelpUtils.getIntValue(currentInstanceActivity.getActivityId());
            for (ProcessInstanceActivity piaBean : piaList) {
                if (BaseHelpUtils.getIntValue(piaBean.getActivityId()) <= currentActivityId) {
                    continue;
                }
                List<BaseSystemProcessPooledTask> taskList = piaBean.getTasks();
                List<BaseSystemProcessAttention> attentionList = piaBean.getAttentions();
                boolean needToResetInstanceActivityId = false;
                if (null != taskList && !taskList.isEmpty() && BaseHelpUtils.getIntValue(taskList.get(0).getInstanceActivityId()) != -1) {
                    needToResetInstanceActivityId = true;
                }
                if (!needToResetInstanceActivityId && null != attentionList && !attentionList.isEmpty() && BaseHelpUtils.getIntValue(attentionList.get(0).getInstanceActivityId()) != -1) {
                    needToResetInstanceActivityId = true;
                }
                if (needToResetInstanceActivityId) {
                    continue;
                }
                Integer newInstanceActivityId = null;
                delicacy.system.dao.SystemProcessInstanceActivity spiaDao = new delicacy.system.dao.SystemProcessInstanceActivity();
                spiaDao.setConditionActivityId("=", piaBean.getActivityId());
                spiaDao.setConditionProcessInstanceId("=", currentInstanceActivity.getProcessInstanceId());
                spiaDao.unsetSelectFlags();
                spiaDao.setSelectProcessInstanceActivityId(true);
                BaseSystemProcessInstanceActivity spiaBean = spiaDao.executeQueryOneRow();
                if (null != spiaBean) {
                    newInstanceActivityId = spiaBean.getProcessInstanceActivityId();
                }
                if (null == newInstanceActivityId) {
                    continue;
                }
                if (null != taskList && !taskList.isEmpty()) {
                    delicacy.system.dao.SystemProcessPooledTask spptDao = new delicacy.system.dao.SystemProcessPooledTask();
                    spptDao.setConditionActivityId("=", piaBean.getActivityId());
                    spptDao.setConditionInstanceActivityId("=", -1);
                    spptDao.setInstanceActivityId(newInstanceActivityId);
                    spptDao.conditionalUpdate();
                }
                if (null != attentionList && !attentionList.isEmpty()) {
                    SystemProcessAttention spaDao = new SystemProcessAttention();
                    spaDao.setConditionActivityId("=", piaBean.getActivityId());
                    spaDao.setConditionInstanceActivityId("=", -1);
                    spaDao.setInstanceActivityId(newInstanceActivityId);
                    spaDao.conditionalUpdate();
                }
            }
        }

        if (currentInstanceActivity.getActivityType() != null) {
            ProcessInstanceActivity currentActivity = new ProcessInstanceActivity();
            currentInstanceActivity.cloneCopy(currentActivity);
            currentActivity.setProcessComment(currentInstanceActivity.getProcessComment());
            instance.setCurrentActivity(currentActivity);
            //1、如果流程根据业务数据，重新生成了新的流程节点，则说明前面已经执行过此方法了，此处直接跳过
            //2、如果是回退给申请人，也不执行该方法
            if (!addNewInstanceActivities && approvalment != 2) {
                gwp.executeActivity(pi, params, employeeId, false, completed);
            }
        }
        ThreadConnection.commit();


        return bc.toJSON();
    }

    private void deleteAnnualLeave(BasePersonnelBusines bean) throws SQLException {
        //获取请假的开始时间和结束时间
        Date startDate = bean.getStartDate();
        Date endDate = bean.getEndDate();
        //获取请假的天数
        BigDecimal days = BaseHelpUtils.getBigDecimalValue(bean.getDays());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        //获取请假开始时间的年份和月份
        int startDateYear = calendar.get(Calendar.YEAR);
        AnnualLeave annualLeave = new AnnualLeave();
        //初始化当年的年假的数据
        BigDecimal currentTotalDay = BigDecimal.ZERO;
        BigDecimal currentUserDay = BigDecimal.ZERO;
        BigDecimal currentRemainingDay = BigDecimal.ZERO;
        //初始化上一年年假的数据
        BigDecimal lastTotalDay = BigDecimal.ZERO;
        BigDecimal lastUserDay = BigDecimal.ZERO;
        BigDecimal lastRemainingDay = BigDecimal.ZERO;
        annualLeave.clear();
        annualLeave.setConditionYear("=", startDateYear);
        annualLeave.setConditionEmployeeId("=", bean.getEmployeeId());
        if (annualLeave.isExist()) {
            BaseAnnualLeave baseAnnualLeave = annualLeave.executeQueryOneRow();
            currentTotalDay = BaseHelpUtils.getBigDecimalValue(baseAnnualLeave.getTotalAnnualLeave());
            currentUserDay = BaseHelpUtils.getBigDecimalValue(baseAnnualLeave.getUsageAmountAnnual());
            //今年剩余的年假
            currentRemainingDay = currentTotalDay.subtract(currentUserDay);
        }
        //上一年度的年假信息
        annualLeave.clear();
        annualLeave.setConditionYear("=", startDateYear - 1);
        annualLeave.setConditionEmployeeId("=", bean.getEmployeeId());
        if (annualLeave.isExist()) {
            BaseAnnualLeave baseAnnualLeave = annualLeave.executeQueryOneRow();
            lastTotalDay = BaseHelpUtils.getBigDecimalValue(baseAnnualLeave.getTotalAnnualLeave());
            lastUserDay = BaseHelpUtils.getBigDecimalValue(baseAnnualLeave.getUsageAmountAnnual());
            //上一年剩余的年假
            lastRemainingDay = lastTotalDay.subtract(lastUserDay);
        }
        //回退的规则都是优先退回请假当年的数据让后再回退上一年的数据
        //当年使用的年假够本次退回的---- 直接退回到当年
        if (currentUserDay.compareTo(days) == 1) {
            currentUserDay = currentUserDay.subtract(days);
        }
        //当年的已用请假时间不够本次退回---- 则先退回当年的数据然后再退回上一年的数据
        else {
            BigDecimal subtract = days.subtract(currentUserDay);
            lastUserDay = lastUserDay.subtract(subtract);
            currentUserDay = BigDecimal.ZERO;
        }
        annualLeave.clear();
        //更新当年的年假
        annualLeave.setConditionEmployeeId("=", bean.getEmployeeId());
        annualLeave.setConditionYear("=", startDateYear);
        annualLeave.setUsageAmountAnnual(currentUserDay);
        annualLeave.conditionalUpdate();
        //更新上一年的年假
        annualLeave.clear();
        annualLeave.setConditionEmployeeId("=", bean.getEmployeeId());
        annualLeave.setConditionYear("=", startDateYear - 1);
        annualLeave.setUsageAmountAnnual(lastUserDay);
        annualLeave.conditionalUpdate();
    }


    public static void main(String[] args) throws Exception {

        HashMap<String, Object> params = new HashMap<>();
        params.put("employeeId","422");
        params.put("type", 22);
        Calendar c = Calendar.getInstance();
        c.set(2021, 1, 11, 9, 00, 0);
        c.set(Calendar.MILLISECOND, 0);
        Long startDate = c.getTimeInMillis();
        c.set(2021, 1, 17, 18, 00, 0);
        c.set(Calendar.MILLISECOND, 0);
        Long endDate = c.getTimeInMillis();
        params.put("startDate", startDate);
        params.put("endDate", endDate);
        MyPersonnelProcessor MY = new MyPersonnelProcessor();
        String s = MY.calculateDaysAndHours(params);
        System.out.println(s);
//			System.out.println(str);
//			MyPersonnelProcessor a = new MyPersonnelProcessor();
//			Calendar c = Calendar.getInstance();
//			c.set(2017, 4, 15, 9, 0, 0);
//			Date startDate = c.getTime();
//			c.set(2017, 4, 22, 14, 0, 0);
//			Date endDate = c.getTime();
////			System.out.println(a.getWorkDaysBetweenTwoDate(463, startDate, endDate));
////			System.out.println(a.getWorkHoursBetweenTwoDate(463, startDate, endDate));
//			
////			String param = "{\"employeeId\":\"389\",\"employeeNo\":\"JA884002\",\"departmentId\":66,\"companyProvince\":19,\"type\":1,\"subType\":\"6,11,16,17,22\",\"endDate\":1527760800000,\"subTypeStr\":\"基础产假,生育奖励假,晚育假,难产假,多胞胎假\",\"optType\":\"calculateDaysAndHours\",\"startDate\":1492045200000}";
////			a.execute(param, null);
//			BigDecimal days = a.getWorkDaysBetweenTwoDate(10, startDate, endDate);
//			System.out.println(days);
//			String creteria = "{\"drafter\":\"534\",\"employeeId\":\"534\",\"employeeNo\":\"JA885022\",\"type\":\"20\",\"reason\":\"1\",\"departmentId\":49,\"companyProvince\":\"24\",\"startDate\":1518328800000,\"endDate\":1518343200000,\"optType\":\"calculateDaysAndHours\",\"maxDays\":0}";
//			a.execute(creteria, null);
//		}catch(Exception e ){
//////			e.printStackTrace();
//////		}
    }
}
