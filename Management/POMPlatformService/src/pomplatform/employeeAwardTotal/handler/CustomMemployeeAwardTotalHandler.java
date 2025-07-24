package pomplatform.employeeAwardTotal.handler;

import com.pomplatform.db.bean.BaseEmployeeChangePlateRecord;
import com.pomplatform.db.bean.BaseEmployeeSalaryDetail;
import com.pomplatform.db.bean.BasePlateIntegralAssignRecord;
import com.pomplatform.db.bean.BaseProjectIntegralAssignRecord;
import com.pomplatform.db.dao.EmployeeChangePlateRecord;
import com.pomplatform.db.dao.EmployeeSalaryDetail;
import com.pomplatform.db.dao.PlateIntegralAssignRecord;
import com.pomplatform.db.dao.ProjectIntegralAssignRecord;
import com.pomplatform.db.dao.SystemConfig;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.DES;
import delicacy.common.GenericBase;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.json.ParseException;
import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import pomplatform.common.utils.StaticUtils;
import pomplatform.employeeAwardTotal.bean.BaseMemployeeAwardTotal;
import pomplatform.employeeAwardTotal.bean.ConditionMemployeeAwardTotal;
import static pomplatform.employeeAwardTotal.handler.MemployeeAwardTotalHandler.executeQueryMemployeeAwardTotal;
import pomplatform.employeeAwardTotal.query.QueryMemployeeAwardTotal;

public class CustomMemployeeAwardTotalHandler extends MemployeeAwardTotalHandler {

    private static final Logger __logger = Logger.getLogger(CustomMemployeeAwardTotalHandler.class);

    @Override
    public String find(String creteria) throws Exception {
        ConditionMemployeeAwardTotal c = new ConditionMemployeeAwardTotal();
        c.setDataFromJSON(creteria);
        BaseCollection<BaseMemployeeAwardTotal> result = executeQueryMemployeeAwardTotal(c, c.getKeyValues());
        result = getSalary(result, creteria,1);
        return result.toJSON(null);
    }

    @Override
    public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
        BaseCollection<BaseMemployeeAwardTotal> result;
        ConditionMemployeeAwardTotal c = new ConditionMemployeeAwardTotal();
        c.setDataFromJSON(creteria);
        QueryMemployeeAwardTotal dao = new QueryMemployeeAwardTotal();
        dao.setCurrentPage(c.getCurrentPage());
        dao.setPageLines(c.getPageLines());
        result = dao.executeQuery(c.getKeyValues(), c);
        if (result.getTotalLines() > GenericBase.MAX_EXPORT_LINES) {
            throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
        }
        result = dao.executeQuery(c.getKeyValues(), c);
        result = getSalary(result, creteria,2);
        try (PrintStream ps = new PrintStream(downFile, "GBK")) {
            ps.println(BaseMemployeeAwardTotal.ALL_CAPTIONS);
            for (BaseMemployeeAwardTotal b : result.getCollections()) {
                ps.println(b.toCSVString());
            }
        }
    }

    /**
     * 
     * @param result
     * @param creteria
     * @param flag:1:查询;2:导出
     * @return
     * @throws ParseException
     * @throws SQLException
     * @throws UnsupportedEncodingException 
     */
    public BaseCollection<BaseMemployeeAwardTotal> getSalary(BaseCollection<BaseMemployeeAwardTotal> result, String creteria,int flag) throws ParseException, SQLException, UnsupportedEncodingException {
        List<BaseMemployeeAwardTotal> listBeans = result.getCollections();
        if (!BaseHelpUtils.isNullOrEmpty(listBeans) && listBeans.size() > 0) {
            //获取年份和月份
            JSON parser = new JSON(new StringReader(creteria));
            Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
            String years = "0";
            String startMonth = "0";
            String endMonth = "0";
            int plateId = 0;
            if (!BaseHelpUtils.isNullOrEmpty(param) && param.size() > 0) {
                years = BaseHelpUtils.getStringValue(param, "yearsValue");
                startMonth = BaseHelpUtils.getStringValue(param, "startMonthValue");
                endMonth = BaseHelpUtils.getStringValue(param, "endMonthValue");
                plateId = BaseHelpUtils.getIntValue(param.get("plateId"));
            }
            Object[] arr = new Object[listBeans.size()];
            if(plateId > 0){//plateId>0,则查看的是某个业务部门的数据，这时候，要根据该业务部门每个人拥有哪些员工，来统计该业务部门的人工成本
                int listBeansSize = listBeans.size();
                for(int i = 0;i<listBeansSize;i++){
                    arr[i] = listBeans.get(i).getEmployeeId();
                }
            }
            List<BaseEmployeeChangePlateRecord> changePlateRecordList = new ArrayList<>();
            Map<String,BigDecimal> changePlateRecordMap = new HashMap();//plateId>0时使用，用于存放某个业务部门在查询的时间段中，每个月所拥有的员工；其中key值为：员工ID+","+年份+","+月份
            //先获取所有成员的人工成本的数据
            EmployeeSalaryDetail dao = new EmployeeSalaryDetail();
            dao.unsetSelectFlags();
            dao.setSelectEmployeeId(true);
            dao.setSelectSalaryYear(true);
            dao.setSelectSalaryMonth(true);
            dao.setSelectBasicSalary(true);
            dao.setSelectEmployeeSalaryDetailId(true);
            ProjectIntegralAssignRecord projectRecordDao = new ProjectIntegralAssignRecord();
            List<BaseProjectIntegralAssignRecord> projectRecordList = new ArrayList<>();
            PlateIntegralAssignRecord plateRecordDao = new PlateIntegralAssignRecord();
            List<BasePlateIntegralAssignRecord> plateRecordList = new ArrayList<>();
            Map<Integer,BigDecimal> assignIntegralMap = new HashMap();
            if(plateId > 0){//获取该业务部门某年某月拥有的哪些员工
                dao.addCondition(BaseEmployeeSalaryDetail.CS_EMPLOYEE_ID, "in", arr);
                EmployeeChangePlateRecord changePlateRecordDao = new EmployeeChangePlateRecord();
                changePlateRecordDao.addCondition(BaseEmployeeChangePlateRecord.CS_EMPLOYEE_ID, "in", arr);
                changePlateRecordList = changePlateRecordDao.conditionalLoad(BaseEmployeeChangePlateRecord.CS_CHANGE_PLATE_DATE+" >='"+BaseHelpUtils.getStringValue(param, "startMonth")+"' and "+BaseEmployeeChangePlateRecord.CS_CHANGE_PLATE_DATE+" <'"+BaseHelpUtils.getStringValue(param, "endMonth")+"'");
                if(changePlateRecordList.size() > 0){
                    for(BaseEmployeeChangePlateRecord obj : changePlateRecordList){
                        if(obj.getPlateId().equals(plateId)){
                            changePlateRecordMap.put(obj.getEmployeeId()+","+obj.getYear()+","+obj.getMonth(), new BigDecimal(0));
                        }
                    }
                }
                projectRecordDao.addCondition(BaseProjectIntegralAssignRecord.CS_EMPLOYEE_ID, "in", arr);
                projectRecordDao.setConditionPlateId("=", plateId);
                plateRecordDao.addCondition(BasePlateIntegralAssignRecord.CS_EMPLOYEE_ID, "in", arr);
                plateRecordDao.setConditionPlateId("=", plateId);
            }
            projectRecordList = projectRecordDao.conditionalLoad(BaseProjectIntegralAssignRecord.CS_ASSIGN_DATE+" >='"+BaseHelpUtils.getStringValue(param, "startMonth")+"' and "+BaseProjectIntegralAssignRecord.CS_ASSIGN_DATE+" <'"+BaseHelpUtils.getStringValue(param, "endMonth")+"'");
            if(projectRecordList.size() > 0){
                for(BaseProjectIntegralAssignRecord obj : projectRecordList){
                    if(assignIntegralMap.containsKey(obj.getEmployeeId())){
                        assignIntegralMap.put(obj.getEmployeeId(), assignIntegralMap.get(obj.getEmployeeId()).add(new BigDecimal(BaseHelpUtils.getDoubleValue(obj.getAssignIntegral()))));
                    }else{
                        assignIntegralMap.put(obj.getEmployeeId(), new BigDecimal(BaseHelpUtils.getDoubleValue(obj.getAssignIntegral())));
                    }
                }
            }
            plateRecordList = plateRecordDao.conditionalLoad(BasePlateIntegralAssignRecord.CS_ASSIGN_DATE+" >='"+BaseHelpUtils.getStringValue(param, "startMonth")+"' and "+BasePlateIntegralAssignRecord.CS_ASSIGN_DATE+" <'"+BaseHelpUtils.getStringValue(param, "endMonth")+"'");
            if(plateRecordList.size() > 0){
                for(BasePlateIntegralAssignRecord obj : plateRecordList){
                    if(assignIntegralMap.containsKey(obj.getEmployeeId())){
                        assignIntegralMap.put(obj.getEmployeeId(), assignIntegralMap.get(obj.getEmployeeId()).add(new BigDecimal(BaseHelpUtils.getDoubleValue(obj.getAssignIntegral()))));
                    }else{
                        assignIntegralMap.put(obj.getEmployeeId(), new BigDecimal(BaseHelpUtils.getDoubleValue(obj.getAssignIntegral())));
                    }
                }
            }
            dao.setConditionSalaryYear("=", BaseHelpUtils.getIntValue(years));
            StringBuilder sql = new StringBuilder();
            sql.append("cast(").append(BaseEmployeeSalaryDetail.CS_SALARY_MONTH).append(" as int) >= '").append(startMonth).append("' and cast(").append(BaseEmployeeSalaryDetail.CS_SALARY_MONTH).append(" as int) <= '").append(endMonth).append("'");
            List<BaseEmployeeSalaryDetail> resultBeans = dao.conditionalLoad(sql.toString());
            //获取加密的秘钥
            SystemConfig scDao = new SystemConfig();
            scDao.setSystemConfigId(StaticUtils.SYSTEM_KEY);
            scDao.load();
            String key = scDao.getImagePath();
            DES des = new DES(key);
            for (BaseMemployeeAwardTotal bean : listBeans) {
                double baseSalary = 0;
                if (!BaseHelpUtils.isNullOrEmpty(resultBeans) && resultBeans.size() > 0) {
                    for (BaseEmployeeSalaryDetail e : resultBeans) {
                        if (Objects.equals(e.getEmployeeId(), bean.getEmployeeId())) {
                            if (plateId > 0 && changePlateRecordMap.containsKey(e.getEmployeeId()+","+e.getSalaryYear()+","+e.getSalaryMonth())) {
                                baseSalary += Double.parseDouble(des.DEC(e.getBasicSalary()));
                            } else if (plateId == 0) {
                                baseSalary += Double.parseDouble(des.DEC(e.getBasicSalary()));
                            }
                        }
                    }
                }
                if(flag == 1){//只有查询时设置人工成本，导出时不导出人工成本
                	bean.setBaseSalary(new BigDecimal(baseSalary));
                }
                if(assignIntegralMap.containsKey(bean.getEmployeeId())){
                    bean.setAchieveAward(new BigDecimal(BaseHelpUtils.getDoubleValue(bean.getAchieveIntegral())-BaseHelpUtils.getDoubleValue(baseSalary)+BaseHelpUtils.getDoubleValue(assignIntegralMap.get(bean.getEmployeeId()))));
                }else{
                    bean.setAchieveAward(new BigDecimal(BaseHelpUtils.getDoubleValue(bean.getAchieveIntegral())-BaseHelpUtils.getDoubleValue(baseSalary)));
                }
                
            }
            result.setCollections(listBeans);
        }
        return result;
    }

}
