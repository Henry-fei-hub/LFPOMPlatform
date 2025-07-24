package delicacy.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.pomplatform.db.bean.BaseAccountWeightRecord;
import com.pomplatform.db.bean.BaseBusinessStateRecord;
import com.pomplatform.db.bean.BaseColumnDomain;
import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseContractDistribution;
import com.pomplatform.db.bean.BaseCustomer;
import com.pomplatform.db.bean.BaseDepartment;
import com.pomplatform.db.bean.BaseEmployeeAccountRecord;
import com.pomplatform.db.bean.BaseEmployeeContractAttachment;
import com.pomplatform.db.bean.BaseEmployeeDayPlateRecord;
import com.pomplatform.db.bean.BaseEmployeePayment;
import com.pomplatform.db.bean.BaseEmployeePaymentDetail;
import com.pomplatform.db.bean.BaseEmployeeRole;
import com.pomplatform.db.bean.BaseMainProject;
import com.pomplatform.db.bean.BasePlateCostRecord;
import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.bean.BaseProjectNormalReimbursement;
import com.pomplatform.db.bean.BaseProjectSettlement;
import com.pomplatform.db.bean.BaseProjectSettlementDetail;
import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.bean.BaseRevenueRecord;
import com.pomplatform.db.bean.BaseRevenueStatisticalRecord;
import com.pomplatform.db.bean.BaseRevenueYearStatisticalRecord;
import com.pomplatform.db.bean.BaseSalaryFillSendDeduct;
import com.pomplatform.db.bean.BaseSalaryOfBonus;
import com.pomplatform.db.bean.BaseSalaryOfWorkYear;
import com.pomplatform.db.bean.BaseSubContract;
import com.pomplatform.db.bean.BaseSubjectType;
import com.pomplatform.db.bean.BaseTravelReimbursement;
import com.pomplatform.db.dao.AccountWeightRecord;
import com.pomplatform.db.dao.BusinessStateRecord;
import com.pomplatform.db.dao.CardManage;
import com.pomplatform.db.dao.ColumnDomain;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.Customer;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.EmployeeAccountRecord;
import com.pomplatform.db.dao.EmployeeChangePlateDetail;
import com.pomplatform.db.dao.EmployeeChangePlateRecord;
import com.pomplatform.db.dao.EmployeeContractAttachment;
import com.pomplatform.db.dao.EmployeeDayPlateRecord;
import com.pomplatform.db.dao.EmployeeEducationInformation;
import com.pomplatform.db.dao.EmployeePayment;
import com.pomplatform.db.dao.EmployeePaymentDetail;
import com.pomplatform.db.dao.EmployeeRole;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.PlateAccountRecord;
import com.pomplatform.db.dao.PlateCostRecord;
import com.pomplatform.db.dao.PlateRecord;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectEmployee;
import com.pomplatform.db.dao.ProjectManagePerformanceRecord;
import com.pomplatform.db.dao.ProjectNormalReimbursement;
import com.pomplatform.db.dao.ProjectSettlement;
import com.pomplatform.db.dao.ProjectSettlementDetail;
import com.pomplatform.db.dao.ProjectStage;
import com.pomplatform.db.dao.RevenueStatisticalRecord;
import com.pomplatform.db.dao.RevenueYearStatisticalRecord;
import com.pomplatform.db.dao.SalaryFillSendDeduct;
import com.pomplatform.db.dao.SalaryOfBonus;
import com.pomplatform.db.dao.SalaryOfWorkYear;
import com.pomplatform.db.dao.SalaryTotal;
import com.pomplatform.db.dao.SubContract;
import com.pomplatform.db.dao.SubjectType;
import com.pomplatform.db.dao.TravelReimbursement;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.DES;
import delicacy.common.GenericBase;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.otheraccount.UserAccountUtils;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.bean.BaseSystemProcessInstance;
import delicacy.system.dao.Employee;
import delicacy.system.dao.SystemProcessInstance;
import delicacy.system.executor.AddDomainValue;
import message.common.ERPWeixinUtils;
import pomplatform.OnRevenue.bean.BaseAccountWeightOfRevenue;
import pomplatform.OnRevenue.bean.BaseAllSheetDataOfRevenue;
import pomplatform.OnRevenue.bean.BaseContractInfoOfRevenue;
import pomplatform.OnRevenue.bean.BaseSheetStageFinishPercentOfRevenue;
import pomplatform.OnRevenue.bean.ConditionAccountWeightOfRevenue;
import pomplatform.OnRevenue.bean.ConditionAllSheetDataOfRevenue;
import pomplatform.OnRevenue.bean.ConditionContractInfoOfRevenue;
import pomplatform.OnRevenue.bean.ConditionSheetStageFinishPercentOfRevenue;
import pomplatform.OnRevenue.query.QueryAccountWeightOfRevenue;
import pomplatform.OnRevenue.query.QueryAllSheetDataOfRevenue;
import pomplatform.OnRevenue.query.QueryContractInfoOfRevenue;
import pomplatform.OnRevenue.query.QuerySheetStageFinishPercentOfRevenue;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.contract.business.ContractDistributionProcessor;
import pomplatform.revenueStatistical.bean.BaseRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.bean.ConditionRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.handler.CustomRevenueStatisticalOfRevenueHandler;
import pomplatform.stage.handler.UpdateProjectWithStage;

public class SelectExcelImport {
	private static final Logger __logger = Logger.getLogger(SelectExcelImport.class);
    /**
     * 读取xls文件 通过HSSFWorkbook实现
     * @param filePath
     * @throws java.io.IOException
     */
    public static void readXls(String filePath) throws IOException, SQLException {
        BasePlateCostRecord beans ;
        PlateCostRecord daos = new PlateCostRecord();
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd"); 
        // 把一张xls的数据表读到wb里
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(filePath));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int rowNum = 0;
        //定义合同编号和合同总金额的map
        Map<String,String> contractMap = new HashMap<>();
        //定义订单编号和订单金额的map
        Map<String,String> sheetCodeMap = new HashMap<>();
        //定义已有订单的map
        Map<String,String> hasMap = new HashMap<>();
        //定义未有的订单map
        Map<String,String> noMap = new HashMap<>();
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            HSSFSheet sheet = workbook.getSheetAt(m);
            try {
                StringBuilder sBuffer = new StringBuilder();
                rowNum = sheet.getLastRowNum();
                // 初始化列数
                int colNum = 0;
                //合同编号
                String contractCode ="";
                //合同总额
                String contractIntegral="";
                //订单编号
                String sheetCode = "";
                //订单总额
                String sheetIntegral = "";
                for (int i = 1; i<=rowNum; i++) {
                    // 创建一个行对象,并从第二行开始读取
                    HSSFRow row = sheet.getRow(i);
                    colNum = row.getLastCellNum();
                    if (row == null) {
                        break;
                    }
                    beans = new BasePlateCostRecord();
                    daos.clear();
                    for (int j = 0; j < colNum; j++) {
                        // 创建一个列单元对象
                        HSSFCell cell = row.getCell(j);
                        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                        if (j == 1) {// 获取指定列的值
                            if (cell.toString() != null && !cell.toString().equals("")) {
                                try {
                                    String cellOne = cell.toString().trim();
                                    // 创建BigDecimal对象
//                                    BigDecimal bd = new BigDecimal(sn);
                                    System.out.println(cellOne);
//                                    daos.setConditionPlateId("=",BaseHelpUtils.getIntValue(cellOne));
//                                    beans.setPlateId(BaseHelpUtils.getIntValue(cellOne));
                                } catch (Exception e) {
                                    sBuffer.append("第").append(i + 1).append("行，第").append(j + 1).append("列导入失败</br>");
                                }
                            }
                        }
                        if (j == 2) {// 获取指定列的值
                            if (cell.toString() != null && !cell.toString().equals("")) {
                                try {
                                    String cellTwo = cell.toString().trim();
                                    // 创建BigDecimal对象
//                                    BigDecimal bd = new BigDecimal(sn);
                                    System.out.println(cellTwo);
                                    contractCode = BaseHelpUtils.getString(cellTwo);
//                                    bean.setDicTypeValueCn(cnName);
//                                    beans.setContractName(contractName);
                                } catch (Exception e) {
                                    sBuffer.append("第").append(i + 1).append("行，第").append(j + 1).append("列导入失败</br>");
                                }
                            }
                        }
                        if (j == 3) {// 获取指定列的值
                            if (cell.toString() != null && !cell.toString().equals("")) {
                                try {
                                    String cellThree = cell.toString().trim();
                                    // 创建BigDecimal对象
//                                    BigDecimal bd = new BigDecimal(sn);
                                    System.out.println(cellThree);
//                                    beans.setCostIntegral(new BigDecimal(BaseHelpUtils.getDoubleValue(cellThree)));
                                } catch (Exception e) {
                                    sBuffer.append("第").append(i + 1).append("行，第").append(j + 1).append("列导入失败</br>");
                                }
                            }
                        }
                        if (j == 4) {// 获取指定列的值
                            if (cell.toString() != null && !cell.toString().equals("")) {
                                try {
                                    String cellFore = cell.toString().trim();
                                    // 创建BigDecimal对象
//                                    BigDecimal bd = new BigDecimal(sn);
                                    System.out.println(cellFore);
                                    contractIntegral = BaseHelpUtils.getString(cellFore);
//                                    beans.setSalaryIntegral(new BigDecimal(BaseHelpUtils.getDoubleValue(cellFore)));
                                } catch (Exception e) {
                                    sBuffer.append("第").append(i + 1).append("行，第").append(j + 1).append("列导入失败</br>");
                                }
                            }
                        }
                        if (j == 5) {// 获取指定列的值
                            if (cell.toString() != null && !cell.toString().equals("")) {
                                try {
                                    String cellFive = cell.toString().trim();
                                    // 创建BigDecimal对象
//                                    BigDecimal bd = new BigDecimal(sn);
                                    System.out.println(cellFive);
//                                    beans.setSalaryIntegral(new BigDecimal(BaseHelpUtils.getDoubleValue(cellFore)));
                                } catch (Exception e) {
                                    sBuffer.append("第").append(i + 1).append("行，第").append(j + 1).append("列导入失败</br>");
                                }
                            }
                        }
                        if (j == 6) {// 获取指定列的值
                            if (cell.toString() != null && !cell.toString().equals("")) {
                                try {
                                    String cellSex = cell.toString().trim();
                                    // 创建BigDecimal对象
//                                    BigDecimal bd = new BigDecimal(sn);
                                    System.out.println(cellSex);
                                    sheetCode = BaseHelpUtils.getString(cellSex);
//                                    beans.setSalaryIntegral(new BigDecimal(BaseHelpUtils.getDoubleValue(cellFore)));
                                } catch (Exception e) {
                                    sBuffer.append("第").append(i + 1).append("行，第").append(j + 1).append("列导入失败</br>");
                                }
                            }
                        }
                        if (j == 7) {// 获取指定列的值
                            if (cell.toString() != null && !cell.toString().equals("")) {
                                try {
                                    String cellSeven = cell.toString().trim();
                                    // 创建BigDecimal对象
//                                    BigDecimal bd = new BigDecimal(sn);
                                    System.out.println(cellSeven);
                                    sheetIntegral = BaseHelpUtils.getString(cellSeven);
//                                    beans.setSalaryIntegral(new BigDecimal(BaseHelpUtils.getDoubleValue(cellFore)));
                                } catch (Exception e) {
                                    sBuffer.append("第").append(i + 1).append("行，第").append(j + 1).append("列导入失败</br>");
                                }
                            }
                        }
                    }
                    contractMap.put(contractCode,contractIntegral);
                    sheetCodeMap.put(sheetCode,sheetIntegral);
//                    daos.setDataFromBase(beans);
//                    if(daos.countRows()>0){
//                        daos.conditionalUpdate();
//                    }else{
//                        daos.save();
//                    }
                }
                System.out.println("contractMapSize===="+contractMap.size());
                System.out.println("contractMap===="+contractMap.toString());
                System.out.println("sheetCodeMapSize===="+sheetCodeMap.size());
                System.out.println("sheetCodeMap===="+sheetCodeMap.toString());
            } catch (Exception e) {
            }
            
            if (sheet == null) {
                break;
            }
        }
    }
    
    /**
     * 检索哪些未更改密码的设计师，并设置新的随机密码
     * @throws SQLException
     * @throws FileNotFoundException
     */
    public static void checkEmpPassword() throws SQLException, FileNotFoundException{
    	//定义map存放未改密码的人员
    	Map<Integer,String> empMap = new HashMap<>();
    	Employee dao = new Employee();
    	dao.setConditionEmployeeId("<>",0);//过滤超级管理员
    	dao.setConditionPlateId("<>",0);
    	dao.setConditionStatus("=",0);//只检索在职的人员
        List<BaseEmployee> listBean = dao.conditionalLoad("order by "+ BaseEmployee.CS_PLATE_ID+" asc");
        PrintStream ps = new PrintStream("d:/exportHenry/emp.csv");
        ps.printf("%1$s,%2$s,%3$s,%4$s\n","编号","姓名","密码","业务部门");
        PlateRecord plateDao = new PlateRecord();
        BasePlateRecord plateBean;
        for(BaseEmployee e : listBean){
        	//获取人员id
        	int employeeId = BaseHelpUtils.getIntValue(e.getEmployeeId());
        	String employeeName = BaseHelpUtils.getString(e.getEmployeeName());
        	//获取人员编号
        	String employeeNo = BaseHelpUtils.getString(e.getEmployeeNo());
        	//获取人员密码
        	String password = BaseHelpUtils.getString(e.getEmployeePassword());
        	int plateId = BaseHelpUtils.getIntValue(e.getPlateId());
        	if(password.equals(DES.string2MD5(employeeNo))){//只检索未改密码的人员
        		plateDao.clear();
        		plateDao.setConditionPlateId("=",plateId);
        		plateBean = plateDao.executeQueryOneRow();
        		String plateName = BaseHelpUtils.getString(plateBean==null?"":plateBean.getPlateName());
        		char c=(char)(int)(Math.random()*26+97);
            	char d=(char)(int)(Math.random()*26+65);
        		empMap.put(employeeId,employeeNo+c+""+d);
        		ps.printf("%1$s,%2$s,%3$s,%4$s\n",employeeNo,employeeName,employeeNo+c+""+d,plateName);
        		dao.clear();
        		dao.setEmployeeId(employeeId);
        		dao.load();
        		dao.setEmployeePassword(DES.string2MD5(employeeNo+c+""+d));
        		dao.update();
        	}
        }
    	System.out.println("size======"+empMap.size());
    	System.out.println("empMap======"+empMap);
    }
    
    /**
     * 更新新订单编码
     * @throws SQLException
     */
    public static void updateContractCodeOfProject() throws SQLException{
    	Project dao = new Project();
    	List<BaseProject> list = dao.conditionalLoad();
    	for(BaseProject e : list){
    		//获取项目id
    		int projectId = BaseHelpUtils.getIntValue(e.getProjectId());
    		//获取订单编码
    		String contractCode = BaseHelpUtils.getString(e.getContractCode());
        	String str1 = "-";
        	int count = 0;
            int start = 0;
            while (contractCode.indexOf(str1, start) >= 0 && start < contractCode.length()) {
              count++;
              start = contractCode.indexOf(str1, start) + str1.length();
            }
        	if(count >= 3){
        		System.out.println(count);
        		//设置新订单编码
        		String contractCoceNew = contractCode.replaceFirst("-",".");
        		System.out.println("contractCode==="+contractCode+";contractCoceNew==="+contractCoceNew);
        		dao.clear();
        		dao.setProjectId(projectId);
        		dao.load();
        		dao.setContractCode(contractCoceNew);
        		dao.update();
        	}
    	}
    }
    
//    /**
//     * 方法有问题，暂无时间修改，不要用
//     * 清楚项目结算相关数据
//     * @param projectId
//     * @throws SQLException 
//     */
//    public static void cleanOnAboutProjectSettlement(int projectId) throws SQLException{
//    	//清除项目结算总表数据
//    	ProjectSettlement projectSettlementDao = new ProjectSettlement();
//    	projectSettlementDao.setConditionProjectId("=",projectId);
//    	projectSettlementDao.conditionalDelete();
//    	//清楚项目结算明细表detail数据
//    	ProjectSettlementDetail projectSettlementDetailDao = new ProjectSettlementDetail();
//    	projectSettlementDetailDao.setConditionProjectId("=",projectId);
//    	projectSettlementDetailDao.conditionalDelete();
//    	//清除项目结算确认函数据表
//    	ProjectAttachment projectAttachmentDao = new ProjectAttachment();
//    	projectAttachmentDao.setConditionProjectId("=",projectId);
//    	projectAttachmentDao.conditionalDelete();
//    	//清除项目结算关联的项目汇总表数据
//    	ProjectReportRecord projectReportRecordDao = new ProjectReportRecord();
//    	projectReportRecordDao.setConditionProjectId("=",projectId);
//    	projectReportRecordDao.conditionalDelete();
//    	//清除项目结算关联的部门结算确认表数据
//    	PlateProjectAccountRecord plateProjectAccountRecordDao = new PlateProjectAccountRecord();
//    	plateProjectAccountRecordDao.setConditionProjectId("=",projectId);
//    	plateProjectAccountRecordDao.conditionalDelete();
//    	//清除项目结算积分回收表数据
//    	ProjectEmployeeIntegralRecord projectEmployeeIntegralRecordDao = new ProjectEmployeeIntegralRecord();
//    	projectEmployeeIntegralRecordDao.setConditionProjectId("=",projectId);
//    	projectEmployeeIntegralRecordDao.conditionalDelete();
//    	//清除项目給成员确认的积分表数据
//    	EmployeeAchieveIntegralReturnRecord employeeAchieveIntegralReturnRecordDao = new EmployeeAchieveIntegralReturnRecord();
//    	employeeAchieveIntegralReturnRecordDao.conditionalDelete();
//    	//清除项目确认阶段表数据
//    	ProjectStageRecord projectStageRecordDao = new ProjectStageRecord();
//    	projectStageRecordDao.setConditionProjectId("=",projectId);
//    	projectStageRecordDao.conditionalDelete();
//    	//更新项目成本结算状态
//    	ProjectCost proejctCostDao = new ProjectCost();
//    	proejctCostDao.setConditionProjectId("=",projectId);
//    	proejctCostDao.setStatus(0);
//    	proejctCostDao.conditionalUpdate();
//    	//更新项目结算人员记录表数据
//    	ProjectEmployee projectEmployeeDao = new ProjectEmployee();
//    	projectEmployeeDao.setConditionProjectId("=",projectId);
//    	projectEmployeeDao.setSettlement(BigDecimal.ZERO);
//    	projectEmployeeDao.setEmployeeAchieveIntegralReturn(BigDecimal.ZERO);
//    	projectEmployeeDao.setRealIntegral(BigDecimal.ZERO);
//    	projectEmployeeDao.setCost(BigDecimal.ZERO);
//    	projectEmployeeDao.conditionalUpdate();
//    	
//    }
    
    //导入会计权重表数据集
    public static void exportAccountWeightData() throws Exception {
    	File file = new File("D:/files/account.xls");
        AccountWeightRecord dao = new AccountWeightRecord();
        BaseAccountWeightRecord bean;
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            for (int i = 1; i < countRow + 1; i++) {
                // 创建一个行对象,并从第二行开始读取
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                bean = new BaseAccountWeightRecord();
                StringBuffer log = new StringBuffer();
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                            case 1:
                                //主键ID
                                int accountWeightRecordId = BaseHelpUtils.getIntValue(cell.toString().trim());
                                log.append("accountWeightRecordId==="+accountWeightRecordId);
                                bean.setAccountWeightRecordId(accountWeightRecordId);
                                break;
                            case 2:
                            	//类型id
                            	int typeId = BaseHelpUtils.getIntValue(cell.toString().trim());
                            	log.append(";typeId==="+typeId);
                            	bean.setTypeId(typeId);
                                break;
                            case 3:
                            	//类型名称
                            	String typeName = BaseHelpUtils.getString(cell.toString().trim());
                            	log.append(";typeName==="+typeName);
                            	bean.setTypeName(typeName);
                                break;
                            case 4:
                            	//权重比例
                            	String percent = BaseHelpUtils.getString(cell.toString().trim());
                            	log.append(";percent==="+percent);
                            	bean.setPercent(new BigDecimal(percent));
                            	break;
                            case 5:
                            	//权重比例
                            	double percentView = BaseHelpUtils.getDoubleValue(cell.toString().trim());
                            	String percentViewStr = String.valueOf((float)(percentView*100))+"%";
                            	log.append(";percentViewNew==="+percentView);
                            	bean.setPercentView(percentViewStr);
                            	break;
                            case 6:
                            	//父级id
                            	int parentId = BaseHelpUtils.getIntValue(cell.toString().trim());
                            	log.append(";parentId==="+parentId);
                            	bean.setParentId(parentId);
                                break;
                            case 7:
                            	//菜单级别
                            	int leave = BaseHelpUtils.getIntValue(cell.toString().trim());
                            	log.append(";leave==="+leave);
                            	bean.setLevel(leave);
                            	break;
                            case 8:
                            	//计算级别
                            	int settlementLeave = BaseHelpUtils.getIntValue(cell.toString().trim());
                            	log.append(";settlementLeave==="+settlementLeave);
                            	bean.setSettlementLevel(settlementLeave);
                            	break;
                            case 9:
                            	//排序
                            	int orderFlag = BaseHelpUtils.getIntValue(cell.toString().trim());
                            	log.append(";orderFlag==="+orderFlag);
                            	bean.setOrderFlag(orderFlag);
                            	break;
                            default:
                                break;
                        }
                    }
                }
                System.out.println("log==="+log.toString());
                dao.clear();
                dao.setDataFromBase(bean);
                dao.save();
            }
        }
    }
    
    
    //导入业态表数据集
    public static void exportBusinessStateData() throws Exception {
    	ThreadConnection.beginTransaction();
    	File file = new File("D:/files/businessState.xls");
    	Contract contractDao = new Contract();//合同表
    	BusinessStateRecord businessStateRecordDao = new BusinessStateRecord();//业态表
    	BaseContract contractBean;
    	BaseBusinessStateRecord businessStateRecordBean;
    	// 把一张xls的数据表读到wb里
    	Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
    	// 获取sheet数
    	int count = workbook.getNumberOfSheets();
    	//初始化行数
    	int countRow;
    	for (int m = 0; m < count; m++) {
    		// 一般一个excel文件会有三个工作表，这里默认读取第一页
    		Sheet sheet = workbook.getSheetAt(m);
    		countRow = sheet.getLastRowNum();
    		// 初始化列数
    		int countCol;
    		for (int i = 1; i < countRow + 1; i++) {
    			// 创建一个行对象,并从第二行开始读取
    			Row row = sheet.getRow(i);
    			if (BaseHelpUtils.isNullOrEmpty(row)) {
    				break;
    			}
    			//获取每一行的列数
    			countCol = row.getLastCellNum();
    			contractBean = new BaseContract();
    			businessStateRecordBean = new BaseBusinessStateRecord();
    			StringBuffer log = new StringBuffer();
    			for (int j = 0; j < countCol; j++) {
    				// 创建一个列单元对象
    				Cell cell = row.getCell(j);
//    				cell.setCellType(Cell.CELL_TYPE_STRING);
//    				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
    					switch (j) {
    					case 1:
    						//合同编码
    						if(BaseHelpUtils.isNullOrEmpty(cell)){
    							contractBean.setContractCode("JB.20161101");
    						}else{
    							String contractCode = BaseHelpUtils.getString(cell.toString());
    							log.append("contractCode==="+contractCode);
    							contractBean.setContractCode(contractCode);
    						}
    						//如果合同编码不为空
    						break;
    					case 2:
    						//业态编码
    						if(BaseHelpUtils.isNullOrEmpty(cell)){
    							businessStateRecordBean.setBusinessCode("JB.20161101.00");
    						}else{
    							String businessCode = BaseHelpUtils.getString(cell.toString());
        						log.append(";businessCode==="+businessCode);
        						businessStateRecordBean.setBusinessCode(businessCode);
    						}
    						break;
    						//如果合同编码不为空
    					case 3:
    						//签约公司
    						if(!BaseHelpUtils.isNullOrEmpty(cell)){
    							int signIngConpany = BaseHelpUtils.getIntValue(cell.toString().trim());
    							contractBean.setSigningCompanyName(signIngConpany);
    						}
    						break;
    					case 4:
    						//客户名称
    						if(!BaseHelpUtils.isNullOrEmpty(cell)){
    							String  customerName = BaseHelpUtils.getString(cell.toString());
    							log.append(";customerName==="+customerName);
    							contractBean.setCustomerName(customerName);
    						}
    						break;
    					case 5:
    						//业态名称，也是合同名称
    						if(!BaseHelpUtils.isNullOrEmpty(cell)){
    							String businessName = BaseHelpUtils.getString(cell.toString());
    							log.append(";businessName==="+businessName);
    							contractBean.setContractName(businessName);
    							businessStateRecordBean.setBusinessName(businessName);
    						}
    						break;
    					case 6:
    						//修改前合同总价
    						if(!BaseHelpUtils.isNullOrEmpty(cell)){
    							double beforeContractTotal = BaseHelpUtils.getDoubleValue(cell.toString().trim());
    							log.append(";beforeContractTotal==="+beforeContractTotal);
    							businessStateRecordBean.setBeforeContractTotal(new BigDecimal(beforeContractTotal));
    						}
    						break;
    					case 7:
    						//业态总金额
    						if(!BaseHelpUtils.isNullOrEmpty(cell)){
    							double businessIntegral = BaseHelpUtils.getDoubleValue(cell.toString().trim());
    							log.append(";businessIntegral==="+businessIntegral);
    							businessStateRecordBean.setBusinessIntegral(new BigDecimal(businessIntegral));
    						}
    						break;
    					case 8:
    						//会计政策
    						if(!BaseHelpUtils.isNullOrEmpty(cell)){
    							int accountWeightRecordId = BaseHelpUtils.getIntValue(cell.toString().trim());
    							log.append(";accountWeightRecordId==="+accountWeightRecordId);
    							businessStateRecordBean.setAccountWeightRecordId(accountWeightRecordId);
    						}
    						break;
    					default:
    						break;
    					}
    				}
//    			}
    			System.out.println("log==="+log.toString());
    			//先根据合同编号，签约公司，客户名称和合同名称去检索该合同是否已经存在，如果存在则不做新增，只检索其合同ID
    			contractDao.clear();
    			if(!contractBean.getContractCode().equals("0")){
    				contractDao.setConditionContractCode("=",contractBean.getContractCode());
    			}else if(contractBean.getContractCode().equals("0") && !BaseHelpUtils.isNullOrEmpty(contractBean.getCustomerName())){
    				contractDao.setConditionSigningCompanyName("=",contractBean.getSigningCompanyName());
    				contractDao.setConditionCustomerName("=",contractBean.getCustomerName());
    			}else{
    				contractDao.setConditionContractName("=", contractBean.getContractName());
    			}
    			BaseContract bean = contractDao.executeQueryOneRow();
    			int contractId = 0;
    			if(!BaseHelpUtils.isNullOrEmpty(bean) && bean.getContractId() > 0){
    				contractId = BaseHelpUtils.getIntValue(bean.getContractId());
    				contractDao.setSigningMoneySum((bean.getSigningMoneySum()==null?BigDecimal.ZERO:bean.getSigningMoneySum()).add((businessStateRecordBean.getBusinessIntegral()==null?BigDecimal.ZERO:businessStateRecordBean.getBusinessIntegral())));
    				contractDao.conditionalUpdate();
    			}else{
    				contractDao.clear();
    				contractDao.setDataFromBase(contractBean);
    				contractDao.save();
    				contractId = contractDao.getContractId();
    			}
    			businessStateRecordBean.setContractId(contractId);
    			businessStateRecordDao.clear();
    			businessStateRecordDao.setDataFromBase(businessStateRecordBean);
    			businessStateRecordDao.save();
    		}
    	}
    	ThreadConnection.commit();
    }
    
    //导入订单数据集
    public static void exportOldSheetData() throws Exception {
    	ThreadConnection.beginTransaction();
    	File file = new File("D:/files/revenueSheet.xls");
    	Project dao = new Project();//订单表
    	BaseProject bean = null;
    	// 把一张xls的数据表读到wb里
    	Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
    	// 获取sheet数
    	int count = workbook.getNumberOfSheets();
    	//初始化行数
    	int countRow;
    	for (int m = 0; m < count; m++) {
    		// 一般一个excel文件会有三个工作表，这里默认读取第一页
    		Sheet sheet = workbook.getSheetAt(m);
    		countRow = sheet.getLastRowNum();
    		// 初始化列数
    		int countCol;
    		for (int i = 1; i < countRow + 1; i++) {
    			// 创建一个行对象,并从第二行开始读取
    			Row row = sheet.getRow(i);
    			if (BaseHelpUtils.isNullOrEmpty(row)) {
    				break;
    			}
    			//获取每一行的列数
    			countCol = row.getLastCellNum();
    			bean = new BaseProject();
    			StringBuffer log = new StringBuffer();
    			for (int j = 0; j < countCol; j++) {
    				// 创建一个列单元对象
    				Cell cell = row.getCell(j);
    				if(cell != null){
    					cell.setCellType(Cell.CELL_TYPE_STRING);
    				}
//    				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
    				switch (j) {
    				case 0:
    					//营收统计板块
    					String ss = cell.toString().trim();
    					int revenuePlateId = BaseHelpUtils.getIntValue(ss);
    					log.append("revenuePlateId==="+revenuePlateId);
    					bean.setRevenuePlateId(revenuePlateId);
    					break;
    				case 1:
    					//主合同编号
    					String projectCode = "";
    					if(!BaseHelpUtils.isNullOrEmpty(cell)){
    						projectCode = BaseHelpUtils.getString(cell.toString());
    					}
    					log.append(";projectCode==="+projectCode);
    					bean.setProjectCode(projectCode);
    					break;
    				case 2:
    					//订单编号
    					if(!BaseHelpUtils.isNullOrEmpty(cell)){
    						String sheetCode = BaseHelpUtils.getString(cell.toString());
        					log.append(";sheetCode==="+sheetCode);
        					bean.setContractCode(sheetCode);
    					}
    					break;
    				case 3:
    					//订单名称
    					if(!BaseHelpUtils.isNullOrEmpty(cell)){
    						String  sheetName = BaseHelpUtils.getString(cell.toString());
    						log.append(";sheetName==="+sheetName);
    						bean.setProjectName(sheetName);
    					}
    					break;
    				case 4:
    					//金额
    					BigDecimal sheetIntegral = BigDecimal.ZERO;
    					if(!BaseHelpUtils.isNullOrEmpty(cell)){
    						sheetIntegral = BaseHelpUtils.getBigDecimalValue(cell.toString());
    						sheetIntegral = sheetIntegral.multiply(new BigDecimal(Double.toString(10000)));
    						sheetIntegral = BaseHelpUtils.format(sheetIntegral,2);
    					}else{
    						sheetIntegral = BigDecimal.ONE;
    					}
    					log.append(";sheetIntegral==="+sheetIntegral);
    					bean.setTotalIntegral(sheetIntegral);
    					bean.setSheetAmount(sheetIntegral);
    					break;
    				default:
    					break;
    				}
    			}
//    			}
    			//获取订单编号
    			String sheetCode = BaseHelpUtils.getString(bean.getContractCode());
    			//检索数据库中是否已有记录
    			dao.clear();
    			dao.setConditionContractCode("=",sheetCode);
    			int num = 0;
    			if(dao.countRows() > 0){
    				num = dao.countRows();
    			}else{
    				dao.setDataFromBase(bean);
    				dao.save();
    			}
    			log.append(";num==="+num);
    			System.out.println("log==="+log.toString());
    		}
    	}
    	ThreadConnection.commit();
    }
    
    //导入订单金额
    public static void exportSheetAmount() throws Exception {
    	ThreadConnection.beginTransaction();
    	File file = new File("D:/files/revenueSheetAmount2.xlsx");
    	Project dao = new Project();//订单表
    	BaseProject bean = null;
    	// 把一张xls的数据表读到wb里
    	Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
    	// 获取sheet数
    	int count = workbook.getNumberOfSheets();
    	//初始化行数
    	int countRow;
    	for (int m = 0; m < count; m++) {
    		// 一般一个excel文件会有三个工作表，这里默认读取第一页
    		Sheet sheet = workbook.getSheetAt(m);
    		countRow = sheet.getLastRowNum();
    		// 初始化列数
    		int countCol;
    		for (int i = 1; i < countRow + 1; i++) {
    			// 创建一个行对象,并从第二行开始读取
    			Row row = sheet.getRow(i);
    			if (BaseHelpUtils.isNullOrEmpty(row)) {
    				break;
    			}
    			//获取每一行的列数
    			countCol = row.getLastCellNum();
    			bean = new BaseProject();
    			StringBuffer log = new StringBuffer();
    			for (int j = 0; j < countCol; j++) {
    				// 创建一个列单元对象
    				Cell cell = row.getCell(j);
    				if(cell != null){
    					cell.setCellType(Cell.CELL_TYPE_STRING);
    				}
//    				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
    				switch (j) {
    				case 0:
    					//订单编号
    					String sheetCode = "";
    					if(!BaseHelpUtils.isNullOrEmpty(cell)){
    						sheetCode = BaseHelpUtils.getString(cell.toString());
    					}
    					log.append(";sheetCode==="+sheetCode);
    					bean.setContractCode(sheetCode);;
    					break;
    				case 1:
    					//金额
    					BigDecimal sheetAmount = BigDecimal.ZERO;
    					if(!BaseHelpUtils.isNullOrEmpty(cell)){
    						sheetAmount = BaseHelpUtils.getBigDecimalValue(cell.toString());
//    						sheetAmount = sheetAmount.multiply(new BigDecimal(Double.toString(10000)));
    						sheetAmount = BaseHelpUtils.format(sheetAmount,2);
    					}
    					log.append(";sheetAmount==="+sheetAmount);
    					bean.setSheetAmount(sheetAmount);;
    					break;
    				default:
    					break;
    				}
    			}
//    			}
    			//获取订单编号
    			String sheetCode = BaseHelpUtils.getString(bean.getContractCode());
    			BigDecimal sheetAmount = bean.getSheetAmount()==null?BigDecimal.ZERO:bean.getSheetAmount();
    			if(sheetAmount.compareTo(BigDecimal.ZERO)>0){
    				//检索数据库中是否已有记录
    			dao.clear();
    			dao.setConditionContractCode("=",sheetCode);
    			dao.setSheetAmount(sheetAmount);
    			dao.conditionalUpdate();
				System.out.println("log==="+log.toString());
    			}
    		}
    	}
    	ThreadConnection.commit();
    }
    
    
  //导入业态表数据集
    public static void exportOldSheetPercentData() throws Exception {
    	ThreadConnection.beginTransaction();
    	File file = new File("D:/files/revenuePercent2.xls");
    	Project dao = new Project();//订单表
    	BaseProject bean = null;
    	RevenueStatisticalRecord reDao = new RevenueStatisticalRecord();
    	BaseRevenueStatisticalRecord reBean = null;
    	RevenueYearStatisticalRecord yearDao = new RevenueYearStatisticalRecord();
    	BaseRevenueYearStatisticalRecord yearBean = null;
    	// 把一张xls的数据表读到wb里
    	Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
    	// 获取sheet数
    	int count = workbook.getNumberOfSheets();
    	//初始化行数
    	int countRow;
    	//设置税率
    	BigDecimal ratePercent = new BigDecimal(1.06);
    	for (int m = 0; m < count; m++) {
    		// 一般一个excel文件会有三个工作表，这里默认读取第一页
    		Sheet sheet = workbook.getSheetAt(m);
    		countRow = sheet.getLastRowNum();
    		// 初始化列数
    		int countCol;
    		for (int i = 1; i < countRow + 1; i++) {
    			// 创建一个行对象,并从第二行开始读取
    			Row row = sheet.getRow(i);
    			if (BaseHelpUtils.isNullOrEmpty(row)) {
    				break;
    			}
    			//获取每一行的列数
    			countCol = row.getLastCellNum();
    			bean = new BaseProject();
    			StringBuffer log = new StringBuffer();
    			StringBuffer __logger = new StringBuffer();
    			int projectId = 0;
    			BigDecimal sheetAmount = BigDecimal.ZERO;
    			int num = 0;
    			String percent1512 = "";
				String percent1 = "";
				String percent2 = "";
				String percent3 = "";
				String percent4 = "";
				String percent5 = "";
				String percent6 = "";
				String percent7 = "";
				String percent8 = "";
				String percent9 = "";
				String percent10 = "";
				String percent11 = "";
				String percent12 = "";
				String percent13 = "";
				BigDecimal bigPercent1512 = BigDecimal.ZERO;
				BigDecimal bigPercent1 = BigDecimal.ZERO;
				BigDecimal bigPercent2 = BigDecimal.ZERO;
				BigDecimal bigPercent3 = BigDecimal.ZERO;
				BigDecimal bigPercent4 = BigDecimal.ZERO;
				BigDecimal bigPercent5 = BigDecimal.ZERO;
				BigDecimal bigPercent6 = BigDecimal.ZERO;
				BigDecimal bigPercent7 = BigDecimal.ZERO;
				BigDecimal bigPercent8 = BigDecimal.ZERO;
				BigDecimal bigPercent9 = BigDecimal.ZERO;
				BigDecimal bigPercent10 = BigDecimal.ZERO;
				BigDecimal bigPercent11 = BigDecimal.ZERO;
				BigDecimal bigPercent12 = BigDecimal.ZERO;
				BigDecimal bigPercent13 = BigDecimal.ZERO;
				
				BigDecimal revenue1512 = BigDecimal.ZERO;
				BigDecimal revenue1 = BigDecimal.ZERO;
				BigDecimal revenue2 = BigDecimal.ZERO;
				BigDecimal revenue3 = BigDecimal.ZERO;
				BigDecimal revenue4 = BigDecimal.ZERO;
				BigDecimal revenue5 = BigDecimal.ZERO;
				BigDecimal revenue6 = BigDecimal.ZERO;
				BigDecimal revenue7 = BigDecimal.ZERO;
				BigDecimal revenue8 = BigDecimal.ZERO;
				BigDecimal revenue9 = BigDecimal.ZERO;
				BigDecimal revenue10 = BigDecimal.ZERO;
				BigDecimal revenue11 = BigDecimal.ZERO;
				BigDecimal revenue12 = BigDecimal.ZERO;
				BigDecimal revenue13 = BigDecimal.ZERO;
    			for (int j = 0; j < countCol; j++) {
    				// 创建一个列单元对象
    				Cell cell = row.getCell(j);
    				if(cell != null){
    					cell.setCellType(Cell.CELL_TYPE_STRING);
    				}
//    				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
    				switch (j) {
    				case 0:
    					//订单编号
    					String sheetCode = BaseHelpUtils.getString(cell.toString().trim());
    					log.append("sheetCode==="+sheetCode);
    					dao.clear();
    					dao.setConditionContractCode("=",sheetCode);
    					num = dao.countRows();
    					if(num == 1){//只有唯一的一条数据才做插入操作
    						bean = dao.executeQueryOneRow();
    						projectId = BaseHelpUtils.getIntValue(bean.getProjectId());
    						sheetAmount = BaseHelpUtils.getBigDecimalValue(bean.getSheetAmount()==null?BigDecimal.ZERO:bean.getSheetAmount());
    					}else if(num > 1){
    						__logger.append(";"+sheetCode+"有重复的单子");
    					}else{
    						__logger.append(";"+sheetCode+"不存在");
    					}
    					log.append(";projectId==="+projectId);
    					log.append(";sheetAmount==="+sheetAmount);
    					break;
    				case 1:
    					//15-12累计完工比
    					if(!BaseHelpUtils.isNullOrEmpty(cell)){
    						percent1512 = BaseHelpUtils.getString(cell.toString().trim());
    					}else{
    						percent1512 = "0";
    					}
    					bigPercent1512 = new BigDecimal(percent1512);
    					bigPercent1512 = bigPercent1512.divide(BigDecimal.ONE, 2,BigDecimal.ROUND_UP);
    					log.append(";15-12percent==="+bigPercent1512);
    					if(num == 1){
    						reDao.clear();
    						reDao.setConditionProjectId("=",projectId);
    						reDao.setConditionYear("=", 2015);
    						reDao.setConditionMonth("=",12);
    						if(reDao.countRows() == 0){
    							reBean = new BaseRevenueStatisticalRecord();
    							reBean.setProjectId(projectId);
    							reBean.setYear(2015);
    							reBean.setMonth(12);
    							reBean.setModifyPercent(bigPercent1512);
    							reBean.setTotalPercent(bigPercent1512);
    							reBean.setTotalTaxRevenue(BaseHelpUtils.format(sheetAmount.multiply(bigPercent1512),2));
    							BigDecimal totalRevenue = sheetAmount.multiply(bigPercent1512).divide(ratePercent,2,BigDecimal.ROUND_DOWN);
    							reBean.setTotalRevenue(totalRevenue);
    							reBean.setCurrentRevenue(totalRevenue);
    							reDao.clear();
    							reDao.setDataFromBase(reBean);
    							reDao.save();
    							revenue1512 = totalRevenue;
    						}
    					}
    					break;
    				case 2:
    					//1月
    					if(!BaseHelpUtils.isNullOrEmpty(cell)){
    						percent1 = BaseHelpUtils.getString(cell.toString().trim());
    						bigPercent1 = new BigDecimal(percent1);
    						bigPercent1 = bigPercent1.divide(BigDecimal.ONE, 2,BigDecimal.ROUND_UP);
    					}else{
    						bigPercent1 = bigPercent1512;
    					}
    					log.append(";percent1==="+bigPercent1);
    					if(num == 1){
    						reDao.clear();
    						reDao.setConditionProjectId("=",projectId);
    						reDao.setConditionYear("=", 2016);
    						reDao.setConditionMonth("=",1);
    						if(reDao.countRows() == 0){
    							
    							reBean = new BaseRevenueStatisticalRecord();
    							reBean.setProjectId(projectId);
    							reBean.setYear(2016);
    							reBean.setMonth(1);
    							reBean.setModifyPercent(bigPercent1);
    							reBean.setTotalPercent(bigPercent1);
    							reBean.setTotalTaxRevenue(BaseHelpUtils.format(sheetAmount.multiply(bigPercent1),2));
    							BigDecimal totalRevenue = sheetAmount.multiply(bigPercent1).divide(ratePercent,2,BigDecimal.ROUND_DOWN);
    							reBean.setTotalRevenue(totalRevenue);
    							reBean.setCurrentRevenue(totalRevenue.subtract(revenue1512));
    							reDao.clear();
    							reDao.setDataFromBase(reBean);
    							reDao.save();
    							revenue1 = totalRevenue.subtract(revenue1512);
    						}
    					}
    					break;
    				case 3:
    					//2月
    					if(!BaseHelpUtils.isNullOrEmpty(cell)){
    						percent2 = BaseHelpUtils.getString(cell.toString().trim());
    						bigPercent2 = new BigDecimal(percent2);
    						bigPercent2 = bigPercent2.divide(BigDecimal.ONE, 2,BigDecimal.ROUND_UP);
    					}else{
    						bigPercent2 = bigPercent1;
    					}
    					log.append(";percent2==="+bigPercent2);
    					if(num == 1){
    						reDao.clear();
    						reDao.setConditionProjectId("=",projectId);
    						reDao.setConditionYear("=", 2016);
    						reDao.setConditionMonth("=",2);
    						if(reDao.countRows() == 0){
    							
    							reBean = new BaseRevenueStatisticalRecord();
    							reBean.setProjectId(projectId);
    							reBean.setYear(2016);
    							reBean.setMonth(2);
    							reBean.setModifyPercent(bigPercent2);
    							reBean.setTotalPercent(bigPercent2);
    							reBean.setTotalTaxRevenue(BaseHelpUtils.format(sheetAmount.multiply(bigPercent2),2));
    							BigDecimal totalRevenue = sheetAmount.multiply(bigPercent2).divide(ratePercent,2,BigDecimal.ROUND_DOWN);
    							reBean.setTotalRevenue(totalRevenue);
    							reBean.setCurrentRevenue(totalRevenue.subtract(revenue1));
    							reDao.clear();
    							reDao.setDataFromBase(reBean);
    							reDao.save();
    							revenue2 = totalRevenue.subtract(revenue1);
    						}
    					}
    					break;
    				case 4:
    					if(!BaseHelpUtils.isNullOrEmpty(cell)){
    						percent3 = BaseHelpUtils.getString(cell.toString().trim());
    						bigPercent3 = new BigDecimal(percent3);
    						bigPercent3 = bigPercent3.divide(BigDecimal.ONE, 2,BigDecimal.ROUND_UP);
    					}else{
    						bigPercent3 = bigPercent2;
    					}
    					log.append(";percent3==="+bigPercent3);
    					if(num == 1){
    						reDao.clear();
    						reDao.setConditionProjectId("=",projectId);
    						reDao.setConditionYear("=", 2016);
    						reDao.setConditionMonth("=",3);
    						if(reDao.countRows() == 0){
    							
    							reBean = new BaseRevenueStatisticalRecord();
    							reBean.setProjectId(projectId);
    							reBean.setYear(2016);
    							reBean.setMonth(3);
    							reBean.setModifyPercent(bigPercent3);
    							reBean.setTotalPercent(bigPercent3);
    							reBean.setTotalTaxRevenue(BaseHelpUtils.format(sheetAmount.multiply(bigPercent3),2));
    							BigDecimal totalRevenue = sheetAmount.multiply(bigPercent3).divide(ratePercent,2,BigDecimal.ROUND_DOWN);
    							reBean.setTotalRevenue(totalRevenue);
    							reBean.setCurrentRevenue(totalRevenue.subtract(revenue2));
    							reDao.clear();
    							reDao.setDataFromBase(reBean);
    							reDao.save();
    							revenue3 = totalRevenue.subtract(revenue2);
    						}
    					}
    					break;
    				case 5:
    					if(!BaseHelpUtils.isNullOrEmpty(cell)){
    						percent4 = BaseHelpUtils.getString(cell.toString().trim());
    						bigPercent4 = new BigDecimal(percent4);
    						bigPercent4 = bigPercent4.divide(BigDecimal.ONE, 2,BigDecimal.ROUND_UP);
    					}else{
    						bigPercent4 = bigPercent3;
    					}
    					log.append(";percent4==="+bigPercent4);
    					if(num == 1){
    						reDao.clear();
    						reDao.setConditionProjectId("=",projectId);
    						reDao.setConditionYear("=", 2016);
    						reDao.setConditionMonth("=",4);
    						if(reDao.countRows() == 0){
    							
    							reBean = new BaseRevenueStatisticalRecord();
    							reBean.setProjectId(projectId);
    							reBean.setYear(2016);
    							reBean.setMonth(4);
    							reBean.setModifyPercent(bigPercent4);
    							reBean.setTotalPercent(bigPercent4);
    							reBean.setTotalTaxRevenue(BaseHelpUtils.format(sheetAmount.multiply(bigPercent4),2));
    							BigDecimal totalRevenue = sheetAmount.multiply(bigPercent4).divide(ratePercent,2,BigDecimal.ROUND_DOWN);
    							reBean.setTotalRevenue(totalRevenue);
    							reBean.setCurrentRevenue(totalRevenue.subtract(revenue3));
    							reDao.clear();
    							reDao.setDataFromBase(reBean);
    							reDao.save();
    							revenue4 = totalRevenue.subtract(revenue3);
    						}
    					}
    					break;
    				case 6:
    					if(!BaseHelpUtils.isNullOrEmpty(cell)){
    						percent5 = BaseHelpUtils.getString(cell.toString().trim());
    						bigPercent5 = new BigDecimal(percent5);
    						bigPercent5 = bigPercent5.divide(BigDecimal.ONE, 2,BigDecimal.ROUND_UP);
    					}else{
    						bigPercent5 = bigPercent4;
    					}
    					log.append(";percent5==="+bigPercent5);
    					if(num == 1){
    						reDao.clear();
    						reDao.setConditionProjectId("=",projectId);
    						reDao.setConditionYear("=", 2016);
    						reDao.setConditionMonth("=",5);
    						if(reDao.countRows() == 0){
    							
    							reBean = new BaseRevenueStatisticalRecord();
    							reBean.setProjectId(projectId);
    							reBean.setYear(2016);
    							reBean.setMonth(5);
    							reBean.setModifyPercent(bigPercent5);
    							reBean.setTotalPercent(bigPercent5);
    							reBean.setTotalTaxRevenue(BaseHelpUtils.format(sheetAmount.multiply(bigPercent5),2));
    							BigDecimal totalRevenue = sheetAmount.multiply(bigPercent5).divide(ratePercent,2,BigDecimal.ROUND_DOWN);
    							reBean.setTotalRevenue(totalRevenue);
    							reBean.setCurrentRevenue(totalRevenue.subtract(revenue4));
    							reDao.clear();
    							reDao.setDataFromBase(reBean);
    							reDao.save();
    							revenue5 = totalRevenue.subtract(revenue4);
    						}
    					}
    					break;
    				case 7:
    					if(!BaseHelpUtils.isNullOrEmpty(cell)){
    						percent6 = BaseHelpUtils.getString(cell.toString().trim());
    						bigPercent6 = new BigDecimal(percent6);
    						bigPercent6 = bigPercent6.divide(BigDecimal.ONE, 2,BigDecimal.ROUND_UP);
    					}else{
    						bigPercent6 = bigPercent5;
    					}
    					log.append(";percent6==="+bigPercent6);
    					if(num == 1){
    						reDao.clear();
    						reDao.setConditionProjectId("=",projectId);
    						reDao.setConditionYear("=", 2016);
    						reDao.setConditionMonth("=",6);
    						if(reDao.countRows() == 0){
    							
    							reBean = new BaseRevenueStatisticalRecord();
    							reBean.setProjectId(projectId);
    							reBean.setYear(2016);
    							reBean.setMonth(6);
    							reBean.setModifyPercent(bigPercent6);
    							reBean.setTotalPercent(bigPercent6);
    							reBean.setTotalTaxRevenue(BaseHelpUtils.format(sheetAmount.multiply(bigPercent6),2));
    							BigDecimal totalRevenue = sheetAmount.multiply(bigPercent6).divide(ratePercent,2,BigDecimal.ROUND_DOWN);
    							reBean.setTotalRevenue(totalRevenue);
    							reBean.setCurrentRevenue(totalRevenue.subtract(revenue5));
    							reDao.clear();
    							reDao.setDataFromBase(reBean);
    							reDao.save();
    							revenue6 = totalRevenue.subtract(revenue5);
    						}
    					}
    					break;
    				case 8:
    					if(!BaseHelpUtils.isNullOrEmpty(cell)){
    						percent7 = BaseHelpUtils.getString(cell.toString().trim());
    						double ss = BaseHelpUtils.getDoubleValue(percent7);
    						bigPercent7 = new BigDecimal(ss);
    						bigPercent7 = bigPercent7.divide(BigDecimal.ONE, 2,BigDecimal.ROUND_UP);
    					}else{
    						bigPercent7 = bigPercent6;
    					}
    					log.append(";percent7==="+bigPercent7);
    					if(num == 1){
    						reDao.clear();
    						reDao.setConditionProjectId("=",projectId);
    						reDao.setConditionYear("=", 2016);
    						reDao.setConditionMonth("=",7);
    						if(reDao.countRows() == 0){
    							
    							reBean = new BaseRevenueStatisticalRecord();
    							reBean.setProjectId(projectId);
    							reBean.setYear(2016);
    							reBean.setMonth(7);
    							reBean.setModifyPercent(bigPercent7);
    							reBean.setTotalPercent(bigPercent7);
    							reBean.setTotalTaxRevenue(BaseHelpUtils.format(sheetAmount.multiply(bigPercent7),2));
    							BigDecimal totalRevenue = sheetAmount.multiply(bigPercent7).divide(ratePercent,2,BigDecimal.ROUND_DOWN);
    							reBean.setTotalRevenue(totalRevenue);
    							reBean.setCurrentRevenue(totalRevenue.subtract(revenue6));
    							reDao.clear();
    							reDao.setDataFromBase(reBean);
    							reDao.save();
    							revenue7 = totalRevenue.subtract(revenue6);
    						}
    					}
    					break;
    				case 9:
    					if(!BaseHelpUtils.isNullOrEmpty(cell)){
    						percent8 = BaseHelpUtils.getString(cell.toString().trim());
    						bigPercent8 = new BigDecimal(percent8);
    						bigPercent8 = bigPercent8.divide(BigDecimal.ONE, 2,BigDecimal.ROUND_UP);
    					}else{
    						bigPercent8 = bigPercent7;
    					}
    					log.append(";percent8==="+bigPercent8);
    					if(num == 1){
    						reDao.clear();
    						reDao.setConditionProjectId("=",projectId);
    						reDao.setConditionYear("=", 2016);
    						reDao.setConditionMonth("=",8);
    						if(reDao.countRows() == 0){
    							
    							reBean = new BaseRevenueStatisticalRecord();
    							reBean.setProjectId(projectId);
    							reBean.setYear(2016);
    							reBean.setMonth(8);
    							reBean.setModifyPercent(bigPercent8);
    							reBean.setTotalPercent(bigPercent8);
    							reBean.setTotalTaxRevenue(BaseHelpUtils.format(sheetAmount.multiply(bigPercent8),2));
    							BigDecimal totalRevenue = sheetAmount.multiply(bigPercent8).divide(ratePercent,2,BigDecimal.ROUND_DOWN);
    							reBean.setTotalRevenue(totalRevenue);
    							reBean.setCurrentRevenue(totalRevenue.subtract(revenue7));
    							reDao.clear();
    							reDao.setDataFromBase(reBean);
    							reDao.save();
    							revenue8 = totalRevenue.subtract(revenue7);
    						}
    					}
    					break;
    				case 10:
    					if(!BaseHelpUtils.isNullOrEmpty(cell)){
    						percent9 = BaseHelpUtils.getString(cell.toString().trim());
    						bigPercent9 = new BigDecimal(percent9);
    						bigPercent9 = bigPercent9.divide(BigDecimal.ONE, 2,BigDecimal.ROUND_UP);
    					}else{
    						bigPercent9 = bigPercent8;
    					}
    					log.append(";percent9==="+bigPercent9);
    					if(num == 1){
    						reDao.clear();
    						reDao.setConditionProjectId("=",projectId);
    						reDao.setConditionYear("=", 2016);
    						reDao.setConditionMonth("=",9);
    						if(reDao.countRows() == 0){
    							
    							reBean = new BaseRevenueStatisticalRecord();
    							reBean.setProjectId(projectId);
    							reBean.setYear(2016);
    							reBean.setMonth(9);
    							reBean.setModifyPercent(bigPercent9);
    							reBean.setTotalPercent(bigPercent9);
    							reBean.setTotalTaxRevenue(BaseHelpUtils.format(sheetAmount.multiply(bigPercent9),2));
    							BigDecimal totalRevenue = sheetAmount.multiply(bigPercent9).divide(ratePercent,2,BigDecimal.ROUND_DOWN);
    							reBean.setTotalRevenue(totalRevenue);
    							reBean.setCurrentRevenue(totalRevenue.subtract(revenue8));
    							reDao.clear();
    							reDao.setDataFromBase(reBean);
    							reDao.save();
    							revenue9 = totalRevenue.subtract(revenue8);
    						}
    					}
    					break;
    				case 11:
    					if(!BaseHelpUtils.isNullOrEmpty(cell)){
    						percent10 = BaseHelpUtils.getString(cell.toString().trim());
    						bigPercent10 = new BigDecimal(percent10);
    						bigPercent10 = bigPercent10.divide(BigDecimal.ONE, 2,BigDecimal.ROUND_UP);
    					}else{
    						bigPercent10 = bigPercent9;
    					}
    					log.append(";percent10==="+bigPercent10);
    					if(num == 1){
    						reDao.clear();
    						reDao.setConditionProjectId("=",projectId);
    						reDao.setConditionYear("=", 2016);
    						reDao.setConditionMonth("=",10);
    						if(reDao.countRows() == 0){
    							
    							reBean = new BaseRevenueStatisticalRecord();
    							reBean.setProjectId(projectId);
    							reBean.setYear(2016);
    							reBean.setMonth(10);
    							reBean.setModifyPercent(bigPercent10);
    							reBean.setTotalPercent(bigPercent10);
    							reBean.setTotalTaxRevenue(BaseHelpUtils.format(sheetAmount.multiply(bigPercent10),2));
    							BigDecimal totalRevenue = sheetAmount.multiply(bigPercent10).divide(ratePercent,2,BigDecimal.ROUND_DOWN);
    							reBean.setTotalRevenue(totalRevenue);
    							reBean.setCurrentRevenue(totalRevenue.subtract(revenue9));
    							reDao.clear();
    							reDao.setDataFromBase(reBean);
    							reDao.save();
    							revenue10 = totalRevenue.subtract(revenue9);
    						}
    					}
    					break;
    				case 12:
    					if(!BaseHelpUtils.isNullOrEmpty(cell)){
    						percent11 = BaseHelpUtils.getString(cell.toString().trim());
    						bigPercent11 = new BigDecimal(percent11);
    						bigPercent11 = bigPercent11.divide(BigDecimal.ONE, 2,BigDecimal.ROUND_UP);
    					}else{
    						bigPercent11 = bigPercent10;
    					}
    					log.append(";percent11==="+bigPercent11);
    					if(num == 1){
    						reDao.clear();
    						reDao.setConditionProjectId("=",projectId);
    						reDao.setConditionYear("=", 2016);
    						reDao.setConditionMonth("=",11);
    						if(reDao.countRows() == 0){
    							
    							reBean = new BaseRevenueStatisticalRecord();
    							reBean.setProjectId(projectId);
    							reBean.setYear(2016);
    							reBean.setMonth(11);
    							reBean.setModifyPercent(bigPercent11);
    							reBean.setTotalPercent(bigPercent11);
    							reBean.setTotalTaxRevenue(BaseHelpUtils.format(sheetAmount.multiply(bigPercent11),2));
    							BigDecimal totalRevenue = sheetAmount.multiply(bigPercent11).divide(ratePercent,2,BigDecimal.ROUND_DOWN);
    							reBean.setTotalRevenue(totalRevenue);
    							reBean.setCurrentRevenue(totalRevenue.subtract(revenue10));
    							reDao.clear();
    							reDao.setDataFromBase(reBean);
    							reDao.save();
    							revenue11 = totalRevenue.subtract(revenue10);
    						}
    					}
    					break;
    				case 13:
    					if(!BaseHelpUtils.isNullOrEmpty(cell)){
    						percent12 = BaseHelpUtils.getString(cell.toString().trim());
    						bigPercent12 = new BigDecimal(percent12);
    						bigPercent12 = bigPercent12.divide(BigDecimal.ONE, 2,BigDecimal.ROUND_UP);
    					}else{
    						bigPercent12 = bigPercent11;
    					}
    					log.append(";percent12==="+bigPercent12);
    					if(num == 1){
    						reDao.clear();
    						reDao.setConditionProjectId("=",projectId);
    						reDao.setConditionYear("=", 2016);
    						reDao.setConditionMonth("=",12);
    						if(reDao.countRows() == 0){
    							
    							reBean = new BaseRevenueStatisticalRecord();
    							reBean.setProjectId(projectId);
    							reBean.setYear(2016);
    							reBean.setMonth(12);
    							reBean.setModifyPercent(bigPercent12);
    							reBean.setTotalPercent(bigPercent12);
    							reBean.setTotalTaxRevenue(BaseHelpUtils.format(sheetAmount.multiply(bigPercent12),2));
    							BigDecimal totalRevenue = sheetAmount.multiply(bigPercent12).divide(ratePercent,2,BigDecimal.ROUND_DOWN);
    							reBean.setTotalRevenue(totalRevenue);
    							reBean.setCurrentRevenue(totalRevenue.subtract(revenue11));
    							reDao.clear();
    							reDao.setDataFromBase(reBean);
    							reDao.save();
    							revenue12 = totalRevenue.subtract(revenue11);
    						}
    					}
    					break;
    				case 14:
    					if(!BaseHelpUtils.isNullOrEmpty(cell)){
    						percent13 = BaseHelpUtils.getString(cell.toString().trim());
    						bigPercent13 = new BigDecimal(percent13);
    						bigPercent13 = bigPercent13.divide(BigDecimal.ONE, 2,BigDecimal.ROUND_UP);
    					}else{
    						bigPercent13 = bigPercent12;
    					}
    					log.append(";percent13==="+bigPercent13);
    					if(num == 1){
    						reDao.clear();
    						reDao.setConditionProjectId("=",projectId);
    						reDao.setConditionYear("=", 2017);
    						reDao.setConditionMonth("=",1);
    						if(reDao.countRows() == 0){
    							
    							reBean = new BaseRevenueStatisticalRecord();
    							reBean.setProjectId(projectId);
    							reBean.setYear(2017);
    							reBean.setMonth(1);
    							reBean.setModifyPercent(bigPercent13);
    							reBean.setTotalPercent(bigPercent13);
    							reBean.setTotalTaxRevenue(BaseHelpUtils.format(sheetAmount.multiply(bigPercent13),2));
    							BigDecimal totalRevenue = sheetAmount.multiply(bigPercent13).divide(ratePercent,2,BigDecimal.ROUND_DOWN);
    							reBean.setTotalRevenue(totalRevenue);
    							reBean.setCurrentRevenue(totalRevenue.subtract(revenue12));
    							reDao.clear();
    							reDao.setDataFromBase(reBean);
    							reDao.save();
    							revenue13 = totalRevenue.subtract(revenue12);
    						}
    					}
    					break;
    				default:
    					break;
    				}
    			}
    			if(projectId > 0){
    				yearDao.clear();
    				yearDao.setConditionProjectId("=",projectId);
    				yearDao.setConditionYear("=",2015);
    				if(yearDao.countRows() == 0){
    					
    					yearDao.clear();
    					yearBean = new BaseRevenueYearStatisticalRecord();
    					yearBean.setProjectId(projectId);
    					yearBean.setYear(2015);
    					yearBean.setDecemberRevenue(revenue1512);
    					yearDao.setDataFromBase(yearBean);
    					yearDao.save();
    				}
    				
    				yearDao.clear();
    				yearDao.setConditionProjectId("=",projectId);
    				yearDao.setConditionYear("=",2016);
    				if(yearDao.countRows() == 0){
    					
    					yearDao.clear();
    					yearBean = new BaseRevenueYearStatisticalRecord();
    					yearBean.setProjectId(projectId);
    					yearBean.setYear(2016);
    					yearBean.setJanuaryRevenue(revenue1);
    					yearBean.setFebruaryRevenue(revenue2);
    					yearBean.setMarchRevenue(revenue3);
    					yearBean.setAprilRevenue(revenue4);
    					yearBean.setMayRevenue(revenue5);
    					yearBean.setJuneRevenue(revenue6);
    					yearBean.setJulyRevenue(revenue7);
    					yearBean.setAugustRevenue(revenue8);
    					yearBean.setSeptemberRevenue(revenue9);
    					yearBean.setOctoberRevenue(revenue10);
    					yearBean.setNovemberRevenue(revenue11);
    					yearBean.setDecemberRevenue(revenue12);
    					yearDao.setDataFromBase(yearBean);
    					yearDao.save();
    				}
    				yearDao.clear();
    				yearDao.setConditionProjectId("=",projectId);
    				yearDao.setConditionYear("=",2017);
    				if(yearDao.countRows() == 0){
    					
    					yearDao.clear();
    					yearBean = new BaseRevenueYearStatisticalRecord();
    					yearBean.setProjectId(projectId);
    					yearBean.setYear(2017);
    					yearBean.setJanuaryRevenue(revenue13);
    					yearDao.setDataFromBase(yearBean);
    					yearDao.save();
    				}
    				
    			}
    			System.out.println("log==="+log.toString());
    		}
    	}
    	ThreadConnection.commit();
    }
    
    //根据导入的数据集更新订单的业态类型
    public static void updateSheetData() throws Exception {
    	File file = new File("D:/files/sheet.xls");
        SubContract dao = new SubContract();
        BaseSubContract bean;
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            for (int i = 1; i < countRow + 1; i++) {
                // 创建一个行对象,并从第二行开始读取
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                bean = new BaseSubContract();
                StringBuffer log = new StringBuffer();
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                            case 1:
                                //订单编号
                                String sheetCode = BaseHelpUtils.getString(cell.toString().trim());
                                log.append("sheetCode==="+sheetCode);
                                bean.setSubContractCode(sheetCode);
                                break;
                            case 2:
                            	//合同编号
                            	String contractCode = BaseHelpUtils.getString(cell.toString().trim());
                                log.append("contractCode==="+contractCode);
                                bean.setSubContractCode(contractCode);
                                break;
                            default:
                                break;
                        }
                    }
                }
                System.out.println("log==="+log.toString());
                dao.clear();
                dao.setDataFromBase(bean);
                dao.save();
            }
        }
    }
    
    //计算营收
    public static void onAccountRevenue() throws Exception{
    	//加载所有的合同数据集(包含合同总金额、合同发票合计数、合同回款合计数)
    	ConditionContractInfoOfRevenue contractCondition = new ConditionContractInfoOfRevenue();
    	contractCondition.setEndDate(new Date());
    	QueryContractInfoOfRevenue contractDao = new QueryContractInfoOfRevenue();
    	BaseCollection<BaseContractInfoOfRevenue> contractResult = contractDao.executeQuery(null, contractCondition);
    	List<BaseContractInfoOfRevenue> contractList = contractResult.getCollections();
    	
    	//定义返回的数据集
    	List<BaseRevenueRecord> revenueList = new ArrayList<>();
    	//定义存放合同营收的实体
    	BaseRevenueRecord contractRevenueBean;
    	//定义存放业态营收的实体
    	BaseRevenueRecord businessRevenueBean;
    	if(!contractList.isEmpty() && !BaseHelpUtils.isNullOrEmpty(contractList)){
    		//统一设定完工比的小数点位，保留四位有效小数点
    		DecimalFormat format = new DecimalFormat("#000000000000.0000");
    		for(BaseContractInfoOfRevenue contractBean : contractList){
    			contractRevenueBean = new BaseRevenueRecord();
    			contractRevenueBean.setDataFromJSON(contractBean.toJSON());
    			
    			//获取合同ID
    			int contractId = BaseHelpUtils.getIntValue(contractBean.getContractId());
    			//获取合同编号
    			String contractCode = BaseHelpUtils.getString(contractBean.getContractCode());
    			//获取合同名称
    			String contractName = BaseHelpUtils.getString(contractBean.getContractName());
    			//获取合同总价
    			BigDecimal contractIntegral = contractBean.getSigningMoneySum()==null?BigDecimal.ZERO:contractBean.getSigningMoneySum();
    			//获取合同的签约公司
    			int signingCompany = BaseHelpUtils.getIntValue(contractBean.getSigningCompanyName());
    			//获取合同是否完工
    			boolean isFinish = contractBean.getIsFinish()==null?false:contractBean.getIsFinish();
    			
    			//将合同相关信息同步合同营收的实体中
    			contractRevenueBean.setParentId(0);
    			contractRevenueBean.setCode(contractCode);
    			contractRevenueBean.setName(contractName);
    			contractRevenueBean.setMoney(contractIntegral);
    			contractRevenueBean.setSigningCompany(signingCompany);
    			revenueList.add(contractRevenueBean);
    			
    			//初始化合同营收
    			BigDecimal contractRevenueIntegral = BigDecimal.ZERO;
    			//初始化合同完工比
    			BigDecimal contractFinishPercent = BigDecimal.ZERO;
    			
    			//根据合同ID加载所有订单数据集
    	    	ConditionAllSheetDataOfRevenue condition = new ConditionAllSheetDataOfRevenue();
    	    	condition.setContractId(contractId);
    	    	QueryAllSheetDataOfRevenue dao = new QueryAllSheetDataOfRevenue();
    	    	BaseCollection<BaseAllSheetDataOfRevenue> result = dao.executeQuery(null, condition);
    	    	List<BaseAllSheetDataOfRevenue> resultList = result.getCollections();
    	    	if(resultList.isEmpty()){
    	    		__logger.info(String.format("合同没有加载到相关的订单数据集：ID:%1$s,合同编号:%2$s\n",contractId+"",contractCode));
    	    	}else{
    	    		//定义一个map，用于存放业态
    	    		Map<Integer,Integer> businessStateMap = new HashMap<>();
    	    		for(BaseAllSheetDataOfRevenue e : resultList){
    	    			//获取业态ID
    	    			int businessStateId = BaseHelpUtils.getIntValue(e.getBusinessStateRecordId());
    	    			//获取业态类型ID
    	    			int accountWeightId = BaseHelpUtils.getIntValue(e.getAccountWeightRecordId());
    	    			businessStateMap.put(businessStateId, accountWeightId);
    	    		}
    	    		//按业态将订单进行归类
    	    		if(businessStateMap.isEmpty()){
    	    			__logger.info(String.format("合同下的订单未与业态进行绑定：ID:%1$s,合同编号:%2$s\n",contractId+"",contractCode));
    	    		}else{
    	    			for(Integer id : businessStateMap.keySet()){
    	    				businessRevenueBean = new BaseRevenueRecord();
    	    				
    	    				//从根据业态ID,从map中获取业态类型ID
    	    				int accountWeightId = businessStateMap.get(id);
    	    				
    	    				//初始化业态总金额
    	    				BigDecimal businessIntegral = BigDecimal.ZERO;
    	    				//初始化业态营收
    	    				BigDecimal businessRevenueIntegral = BigDecimal.ZERO;
    	    				//业态编码
    	    				String businessCode ="";
    	    				//业态名称
    	    				String businessName ="";
    	    				
    	    				//根据业态类型ID,检索业态类型表数据集
    	    				ConditionAccountWeightOfRevenue accountWeightCondition = new ConditionAccountWeightOfRevenue();
    	    				accountWeightCondition.setAccountWeightRecordId(accountWeightId);
    	    				QueryAccountWeightOfRevenue accountWeightDao = new QueryAccountWeightOfRevenue();
    	    				BaseCollection<BaseAccountWeightOfRevenue> accountWeightResult = accountWeightDao.executeQuery(null, accountWeightCondition);
    	    				List<BaseAccountWeightOfRevenue> accountWeightList = accountWeightResult.getCollections();
    	    				if(accountWeightList.isEmpty()){
    	    					__logger.info(String.format("合同绑定的业态未提取到对应业态类型的数据集：合同ID:%1$s,合同编号:%2$s,业态ID:%3$s,业态类型ID:%4$s\n",contractId+"",contractCode,id+"",accountWeightId+""));
    	    				}else{
    	    					for(BaseAllSheetDataOfRevenue e : resultList){
    	    						//获取业态ID
    	    						int businessStateId = BaseHelpUtils.getIntValue(e.getBusinessStateRecordId());
    	    						if(id == businessStateId){
    	    							//设置业态总金额
        	    						businessIntegral = e.getBusinessIntegral()==null?BigDecimal.ZERO:e.getBusinessIntegral();
        	    						//设置业态编码
        	    						businessCode = BaseHelpUtils.getString(e.getBusinessCode());
        	    						//设置业态名称
        	    						businessName = BaseHelpUtils.getString(e.getBusinessName());
    	    							//获取同业态下的订单的ID
    	    							int projectId = BaseHelpUtils.getIntValue(e.getProjectId());
    	    							//获取订单阶段的分配积分、确认积分和完工比
    	    							ConditionSheetStageFinishPercentOfRevenue sheetStageCondition = new ConditionSheetStageFinishPercentOfRevenue();
    	    							sheetStageCondition.setProjectId(projectId);
    	    							QuerySheetStageFinishPercentOfRevenue sheetStageDao = new QuerySheetStageFinishPercentOfRevenue();
    	    							BaseCollection<BaseSheetStageFinishPercentOfRevenue> sheetStageResult = sheetStageDao.executeQuery(null, sheetStageCondition);
    	    							List<BaseSheetStageFinishPercentOfRevenue> sheetStageList = sheetStageResult.getCollections();
    	    							if(sheetStageList.isEmpty()){
    	    								__logger.info(String.format("项目未提取到对应的设计阶段的数据集：项目ID:%1$s\n",projectId+""));
    	    							}else{
    	    								for(BaseSheetStageFinishPercentOfRevenue sheetStageBean : sheetStageList){
    	    									//获取阶段ID
    	    									int stageId = BaseHelpUtils.getIntValue(sheetStageBean.getStageId());
    	    									//获取阶段分配积分
    	    									BigDecimal assignIntegral = sheetStageBean.getAssignIntegral()==null?BigDecimal.ZERO:sheetStageBean.getAssignIntegral();
    	    									//获取阶段确认积分
    	    									BigDecimal sureIntegral = sheetStageBean.getSureIntegral()==null?BigDecimal.ZERO:sheetStageBean.getSureIntegral();
    	    									//获取阶段完工比
    	    									BigDecimal finishPercent = sheetStageBean.getFinishPercent()==null?BigDecimal.ZERO:sheetStageBean.getFinishPercent();
    	    									//根据阶段ID,将阶段分配积分、确认积分、完工比映射到业态类型数据集
    	    									for(BaseAccountWeightOfRevenue accountWeightBean : accountWeightList){
    	    										if(stageId == accountWeightBean.getTypeId()){
    	    											//获取业态类型阶段的权重比例
    	    											BigDecimal percent = accountWeightBean.getPercent()==null?BigDecimal.ZERO:accountWeightBean.getPercent();
    	    											//获取业态类型阶段的会计权重比例值
    	    											BigDecimal finishWeightPercet = accountWeightBean.getFinishWeightPercent()==null?BigDecimal.ZERO:accountWeightBean.getFinishWeightPercent();
    	    											//当阶段的会计权重比例值不等于0时，表示该业态下有多个订单在当前阶段有重复，则需累加
    	    											if(finishWeightPercet.doubleValue() != 0.0){
    	    												accountWeightBean.setAssignIntegral(accountWeightBean.getAssignIntegral().add(assignIntegral));
    	    												accountWeightBean.setSureIntegral(accountWeightBean.getSureIntegral().add(sureIntegral));
    	    												if(accountWeightBean.getAssignIntegral().doubleValue() == 0.0){
    	    													accountWeightBean.setFinishPercent(BigDecimal.ZERO);
    	    												}else{
    	    													if(accountWeightBean.getAssignIntegral().doubleValue() == 0.0){
    	    														accountWeightBean.setFinishPercent(BigDecimal.ZERO);
    	    													}else{
    	    														accountWeightBean.setFinishPercent(new BigDecimal(format.format(accountWeightBean.getSureIntegral().divide(accountWeightBean.getAssignIntegral()))));
    	    													}
    	    												}
    	    												finishWeightPercet = new BigDecimal(format.format(percent.multiply(accountWeightBean.getFinishPercent()).doubleValue()));
    	    												accountWeightBean.setFinishWeightPercent(finishWeightPercet);
    	    											}else{
    	    												accountWeightBean.setAssignIntegral(assignIntegral);
    	    												accountWeightBean.setSureIntegral(sureIntegral);
    	    												accountWeightBean.setFinishPercent(finishPercent);
    	    												//根据业态类型阶段的权重比例和当前阶段完工比计算得到当前阶段会计权重比值，即阶段权重比例(percent)*阶段完工比(finishPercent)
    	    												finishWeightPercet = new BigDecimal(format.format(percent.multiply(finishPercent).doubleValue()));
    	    												accountWeightBean.setFinishWeightPercent(finishWeightPercet);
    	    											}
    	    										}
    	    									}
    	    								}
    	    							}
    	    						}
    	    					}
    	    				}
    	    				
    	    				//业态完工比的计算开始***********************************
    	    				BigDecimal businessFinishPercent = BigDecimal.ZERO;//初始化该业态的完工比
    	    				boolean canFlow = true;//初始化计算流转
    	    				int flag = -1;//初始化计算规则，计算规则从小到大进行提取，当有重复的计算规则值时表示是并行，else表示线行
    	    				//如：计算规则有1、2、3、4、4、5,则当1的完工比为1且存在附件，则往下面流转，累加该业态的完工比
    	    				for(BaseAccountWeightOfRevenue accountWeightBean : accountWeightList){
    	    					//获取计算规则
    	    					int settlementLeave = BaseHelpUtils.getIntValue(accountWeightBean.getSettlementLevel());
    	    					if(canFlow || (!canFlow && settlementLeave == flag)){//表示可流转
    	    						//获取完工比
    	    						BigDecimal finishPercent = accountWeightBean.getFinishPercent()==null?BigDecimal.ZERO:accountWeightBean.getFinishPercent();
    	    						//获取会计权重比
    	    						BigDecimal finishWeightPercent = accountWeightBean.getFinishWeightPercent()==null?BigDecimal.ZERO:accountWeightBean.getFinishWeightPercent();
    	    						//获取是否有附件
    	    						int hasAttachment = BaseHelpUtils.getIntValue(accountWeightBean.getHasAttachment());
    	    						businessFinishPercent = businessFinishPercent.add(finishWeightPercent);
    	    						if(finishPercent.doubleValue() > 1.0 && hasAttachment > 0){//当当前阶段已完工，并上传了附件，则表示可以流转到下一阶段
    	    							canFlow = true;
    	    						}else{
    	    							canFlow = false;
    	    						}
    	    					}else{
    	    						break;
    	    					}
    	    					flag = settlementLeave;
    	    					
    	    				}
    	    				//计算业态的营收值，即业态的完工比*业态的总金额
    	    				businessRevenueIntegral = new BigDecimal(format.format(businessFinishPercent.multiply(businessIntegral)));
    	    				//设置合同的营收，即业态的营收总和
    	    				contractRevenueIntegral = contractRevenueIntegral.add(businessRevenueIntegral);
    	    				//业态完工比的计算结束***********************************
    	    				businessRevenueBean.setContractId(0);
    	    				businessRevenueBean.setParentId(contractId);
    	    				businessRevenueBean.setCode(businessCode);
    	    				businessRevenueBean.setName(businessName);
    	    				businessRevenueBean.setFinishPercent(businessFinishPercent);
    	    				String businessFinishPercentView = String.valueOf((float)(businessFinishPercent.doubleValue()*100))+"%";
    	    				businessRevenueBean.setFinishPercentView(businessFinishPercentView);
    	    				businessRevenueBean.setRevenueMoney(businessRevenueIntegral);
    	    				businessRevenueBean.setBorrowMoney(BigDecimal.ZERO);
    	    				businessRevenueBean.setInvoiceAmount(BigDecimal.ZERO);
    	    				businessRevenueBean.setSigningCompany(signingCompany);
    	    				revenueList.add(businessRevenueBean);
    	    			}
    	    		}
    	    	}
    	    	
    	    	//合同完工比和合同营收开始***********************************
    	    	//设置合同完工比，即合同营收/合同总价
    	    	if(contractIntegral.doubleValue() == 0.0){
    	    		contractFinishPercent = BigDecimal.ZERO;
    	    	}else{
    	    		contractFinishPercent = new BigDecimal(format.format(contractRevenueIntegral.divide(contractIntegral)));
    	    	}
    	    	contractRevenueBean.setFinishPercent(contractFinishPercent);
    	    	String contractFinishPercentView = String.valueOf((float)(contractFinishPercent.doubleValue()*100))+"%";
    	    	contractRevenueBean.setFinishPercentView(contractFinishPercentView);
    	    	contractRevenueBean.setMoney(contractRevenueIntegral);
    	    	System.out.println("revenueList----------"+revenueList);
				//合同完工比和合同营收结束***********************************
    		}
    	}else{
    		__logger.info("********************无合同信息*********************\n");
    	}
    }
    
    
  //根据导入的数据集更新订单的业态类型
    public static void exportSubjectTypeData() throws Exception {
    	File file = new File("D:/files/subjectType.xls");
        SubjectType dao = new SubjectType();
        BaseSubjectType bean;
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            for (int i = 1; i < countRow + 1; i++) {
                // 创建一个行对象,并从第二行开始读取
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                StringBuffer log = new StringBuffer();
                int parentId = 0;
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                            case 1:
                                //父级科目名称
                                String subjectName = BaseHelpUtils.getString(cell.toString().trim());
                                System.out.print("subjectName==="+subjectName);
                                bean = new BaseSubjectType();
                                bean.setSubjectName(subjectName);
                                bean.setParentId(0);
                                dao.clear();
                                dao.setDataFromBase(bean);
                                dao.save();
                                parentId = BaseHelpUtils.getIntValue(dao.getSubjectTypeId());
                                break;
                            case 2:
                            	//子级科目
                            	String childSubjectNames = BaseHelpUtils.getString(cell.toString().trim());
                                System.out.println("childSubjectNames==="+childSubjectNames);
                                if(!BaseHelpUtils.isNullOrEmpty(childSubjectNames)){
                                	String[] childSubjectNameArr = childSubjectNames.split("、");
                                	if(childSubjectNameArr.length > 0){
                                		for(String childSubjectName : childSubjectNameArr){
                                			System.out.print(childSubjectName+";");
                                			bean = new BaseSubjectType();
                                			bean.setSubjectName(childSubjectName);
                                			bean.setParentId(parentId);
                                            dao.clear();
                                            dao.setDataFromBase(bean);
                                            dao.save();
                                		}
                                	}
                                }
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
    }
    
  //根据导入的数据集更新订单的业态类型
    public static void updateEmployeeGrade() throws Exception {
    	File file = new File("D:/files/empGrade.xls");
        Employee dao = new Employee();
        BaseEmployee bean;
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            StringBuffer __logger = new StringBuffer();
            for (int i = 1; i < countRow + 1; i++) {
                // 创建一个行对象,并从第二行开始读取
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                bean = new BaseEmployee();
                StringBuffer log = new StringBuffer();
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if(!BaseHelpUtils.isNullOrEmpty(cell)){
                    	cell.setCellType(Cell.CELL_TYPE_STRING);
                    }
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                            case 1:
                                //职员名称
                                String employeeName = BaseHelpUtils.getString(cell.toString().trim());
                                log.append("employeeName==="+employeeName);
                                bean.setEmployeeName(employeeName);
                                break;
                            case 2:
                            	//职员编号
                            	String employeeNo = BaseHelpUtils.getString(cell.toString().trim());
                                log.append("employeeNo==="+employeeNo);
                                bean.setEmployeeNo(employeeNo);
                                break;
                            case 3:
                            	//职员级别
                            	int gradeId = BaseHelpUtils.getIntValue(cell.toString().trim());
                            	log.append("gradeId==="+gradeId);
                            	bean.setGradeId(gradeId);
                            	break;
                            default:
                                break;
                        }
                    }
                }
                //根据人员姓名和编号查询
                dao.clear();
                dao.setConditionEmployeeName("=",bean.getEmployeeName());
                dao.setConditionEmployeeNo("=",bean.getEmployeeNo());
                log.append("count==="+dao.countRows());
                if(dao.countRows() > 0){
                	dao.setGradeId(bean.getGradeId());
                	dao.conditionalUpdate();
                }
                if(dao.countRows() == 0){
                	__logger.append("employeeName==="+bean.getEmployeeName());
                	__logger.append("employeeNo==="+bean.getEmployeeNo());
                }
                System.out.println("log==="+log.toString());
            }
            System.out.println("__logger==="+__logger.toString());
        }
    }
    
    /**
     * 导出营收统计数据
     * @throws SQLException
     * @throws FileNotFoundException
     * @throws ParseException 
     */
    public static void exportRevenue() throws SQLException, FileNotFoundException, ParseException{
    	ConditionRevenueStatisticalOfRevenue c = new ConditionRevenueStatisticalOfRevenue();
    	int year = 2016;
    	int month = 6;
    	Calendar calendar = Calendar.getInstance();
    	calendar.set(Calendar.YEAR,year);
    	calendar.set(Calendar.MONTH,month);
    	Date endDate = calendar.getTime();
    	endDate = DateUtil.getLastDay(endDate);
    	c.setYear(year);
    	c.setMonth(month);
    	c.setEndDate(endDate);
		BaseCollection<BaseRevenueStatisticalOfRevenue> result = CustomRevenueStatisticalOfRevenueHandler.getResult(c) ;
		BigDecimal totalTaxRevenue = BigDecimal.ZERO;
		BigDecimal totalRevenue = BigDecimal.ZERO;
		BigDecimal currentRevenue = BigDecimal.ZERO;
		PrintStream ps = new PrintStream("d:/exportHenry/revenue.csv");
		ps.printf("%1$s,%2$s,%3$s,%4$s,%5$s,%6$s,%7$s,%8$s,%9$s,%10$s,%11$s\n","订单编号","订单名称","订单金额","税率","订单生成百分比","运营调节百分比","累计百分比","累计含税营收","累计营收","上月累计营收","本月营收");
		for(BaseRevenueStatisticalOfRevenue e : result.getCollections()){
			totalTaxRevenue = totalTaxRevenue.add(e.getTotalTaxRevenue()==null?BigDecimal.ZERO:e.getTotalTaxRevenue());
			totalRevenue = totalRevenue.add(e.getTotalRevenue()==null?BigDecimal.ZERO:e.getTotalRevenue());
			currentRevenue = currentRevenue.add(e.getCurrentRevenue()==null?BigDecimal.ZERO:e.getCurrentRevenue());
			ps.printf("%1$s,%2$s,%3$s,%4$s,%5$s,%6$s,%7$s,%8$s,%9$s,%10$s,%11$s\n",e.getSheetCode(),e.getSheetName(),e.getSheetAmount().toString(),e.getRatePercent(),e.getSheetPercent(),e.getModifyPercent(),e.getTotalPercent(),e.getTotalTaxRevenue(),e.getTotalRevenue(),e.getLastMonthRevenue(),e.getCurrentRevenue());
		}
    }
    
    /**
     * 计算统计营收
     * @throws SQLException
     */
    public static void accountRevenue() throws SQLException{
    	RevenueStatisticalRecord dao = new RevenueStatisticalRecord();
    	RevenueYearStatisticalRecord revenueYearDao = new RevenueYearStatisticalRecord();
    	List<BaseRevenueStatisticalRecord> listBeans = dao.conditionalLoad(" order by project_id,year,month ");
    	if(!listBeans.isEmpty() && listBeans.size() > 0){
    		Project projectDao = new Project();
    		//定义map来存放订单的金额
    		Map<Integer,Object> map = new HashMap<>();
    		List<BaseProject> projectList =  projectDao.conditionalLoad();
    		for(BaseProject e : projectList){
    			map.put(e.getProjectId(),e.getSheetAmount()==null?BigDecimal.ZERO:e.getSheetAmount());
    		}
    		//定义税率
    		BigDecimal ratePercent = new BigDecimal(1.06);
    		//定义上月累计百分比
    		BigDecimal lastTotalRevenue= BigDecimal.ZERO;
    		//定义上月运营调节百分比
    		BigDecimal lastModifyPercent = BigDecimal.ZERO;
    		//初始化项目ID
    		int customProjectId = 0;
    		for(BaseRevenueStatisticalRecord e : listBeans){
    			int projectId = BaseHelpUtils.getIntValue(e.getProjectId());
    			if(projectId != customProjectId){//说明是新的项目开始遍历
    				//初始化
    				lastTotalRevenue = BigDecimal.ZERO;
    				lastModifyPercent = BigDecimal.ZERO;
    				customProjectId = projectId;
    			}
    			//获取订单生成百分比
    			BigDecimal sheetPercent = BaseHelpUtils.getBigDecimalValue(e.getSheetPercent());
    			//获取累计百分比
    			BigDecimal totalPercent = BaseHelpUtils.getBigDecimalValue(e.getTotalPercent());
    			//当本月订单生成百分比<上月运营调节百分比,则将本月运营调节百分比设置为上月运营调节百分比
    			if(sheetPercent.compareTo(lastModifyPercent) < 0){
    				totalPercent = lastModifyPercent;
    				e.setModifyPercent(lastModifyPercent);
    				e.setTotalPercent(lastModifyPercent);
    			}
    			//获取订单金额
    			BigDecimal sheetAmount = BaseHelpUtils.getBigDecimalValue(map.get(projectId));
    			//计算第一次含税累计营收(累计百分比*订单金额)
				BigDecimal totalTaxRevenue = totalPercent.multiply(sheetAmount);
				e.setTotalTaxRevenue(totalTaxRevenue);
				//计算第一次的累计营收(含税累计营收/税率)
				BigDecimal totalRevenue = totalTaxRevenue.divide(ratePercent,2,BigDecimal.ROUND_DOWN);
				e.setTotalRevenue(totalRevenue);
				//计算本月营收(累计营收-上月累计营收)
				BigDecimal currentRevenue = totalRevenue.subtract(lastTotalRevenue);
				e.setCurrentRevenue(currentRevenue);
				//设置上月累计营收
				lastTotalRevenue = totalRevenue;
				lastModifyPercent = totalPercent;
    			//更新表数据
				dao.clear();
				dao.setRevenueStatisticalRecordId(e.getRevenueStatisticalRecordId());
				if(dao.load()){
					e.setOperateTime(new Date());
					dao.setDataFromBase(e);
					dao.update();
				}
				//更新年度营收表数据集
				revenueYearDao.clear();
				revenueYearDao.setConditionProjectId("=",projectId);
				revenueYearDao.setConditionYear("=",e.getYear());
				int month = e.getMonth();
				switch (month) {
				case 1:
					revenueYearDao.setJanuaryRevenue(currentRevenue);
					break;
				case 2:
					revenueYearDao.setFebruaryRevenue(currentRevenue);
					break;
				case 3:
					revenueYearDao.setMarchRevenue(currentRevenue);
					break;
				case 4:
					revenueYearDao.setAprilRevenue(currentRevenue);
					break;
				case 5:
					revenueYearDao.setMayRevenue(currentRevenue);
					break;
				case 6:
					revenueYearDao.setJuneRevenue(currentRevenue);
					break;
				case 7:
					revenueYearDao.setJulyRevenue(currentRevenue);
					break;
				case 8:
					revenueYearDao.setAugustRevenue(currentRevenue);
					break;
				case 9:
					revenueYearDao.setSeptemberRevenue(currentRevenue);
					break;
				case 10:
					revenueYearDao.setOctoberRevenue(currentRevenue);
					break;
				case 11:
					revenueYearDao.setNovemberRevenue(currentRevenue);
					break;
				case 12:
					revenueYearDao.setDecemberRevenue(currentRevenue);
					break;
				default:
					break;
				}
				revenueYearDao.setOperateTime(new Date());
				revenueYearDao.setOperateEmployeeId(-1);
				revenueYearDao.conditionalUpdate();
    		}
    	}
    }
    
    //合同与订单的关联(通过订单编号的合同码与合同订单进行匹配绑定)
    public static void OnContractCompareProject() throws SQLException{
    	//检索订单数据集
    	Project dao = new Project();
    	dao.setConditionContractId("=",0);//只检索未和合同绑定的订单
    	dao.setConditionProjectFlag("=",1);//只检索设计项目的订单
    	List<BaseProject> projectList = dao.conditionalLoad();
    	Contract conDao = new Contract();
    	if(!BaseHelpUtils.isNullOrEmpty(projectList) && projectList.size() > 0){
    		for(BaseProject e : projectList){
    			//获取订单编号
    			String sheetCode = BaseHelpUtils.getString(e.getContractCode());
    			if(!BaseHelpUtils.isNullOrEmpty(sheetCode)){
    				String[] sheetCodeArr = sheetCode.split("\\.");
    				if(sheetCodeArr.length > 1){
    					String contractCode = String.format("%1$s.%2$s", sheetCodeArr[0],sheetCodeArr[1]);
    					System.out.println("contractCode==="+contractCode);
    					//根据合同编号去检索合同表数据集
    					conDao.clear();
    					conDao.setConditionContractCode("=",contractCode);
    					BaseContract bean = conDao.executeQueryOneRow();
    					if(!BaseHelpUtils.isNullOrEmpty(bean)){
    						//获取合同ID
    						int contractId = BaseHelpUtils.getIntValue(bean.getContractId());
    						System.out.println("contractId==="+contractId);
    						dao.clear();
    						e.setContractId(contractId);
    						dao.setDataFromBase(e);
    						dao.update();
    					}
    				}
    			}
    		}
    	}
    }
    
    //根据合同编号删除订单
    public static void deleteSheetBySheetCode() throws Exception {
    	File file = new File("D:/files/deleteSheet.xls");
        Project dao = new Project();
        ProjectSettlement settDao = new ProjectSettlement();
        RevenueStatisticalRecord statistcalDao = new RevenueStatisticalRecord();
        RevenueYearStatisticalRecord yearDao = new RevenueYearStatisticalRecord();
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            StringBuffer __logger = new StringBuffer();
            for (int i = 1; i < countRow + 1; i++) {
                // 创建一个行对象,并从第二行开始读取
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                StringBuffer log = new StringBuffer();
                String sheetCode = "";
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if(!BaseHelpUtils.isNullOrEmpty(cell)){
                    	cell.setCellType(Cell.CELL_TYPE_STRING);
                    }
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                            case 0:
                                //职员名称
                                sheetCode = BaseHelpUtils.getString(cell.toString().trim());
                                log.append("sheetCode==="+sheetCode);
                                break;
                            default:
                                break;
                        }
                    }
                }
                //根据人员姓名和编号查询
                dao.clear();
                dao.setConditionContractCode("=",sheetCode);
                log.append("count==="+dao.countRows());
                if(dao.countRows() > 1){
                	__logger.append("编号("+sheetCode+")存在多条记录");
                }else if(dao.countRows() == 1){
                	BaseProject bean = dao.executeQueryOneRow();
                	//获取项目ID
                	int projectId = bean.getProjectId();
                	//检索该项目是否有结算记录
                	settDao.clear();
                	settDao.setConditionProjectId("=",projectId);
                	if(settDao.countRows() > 0){//说明有结算记录
                		__logger.append("编号("+sheetCode+")存已有结算记录");
                	}else{
                		statistcalDao.clear();
                		statistcalDao.setConditionProjectId("=",projectId);
                		statistcalDao.conditionalDelete();
                		yearDao.clear();
                		yearDao.setConditionProjectId("=",projectId);
                		yearDao.conditionalDelete();
                		dao.clear();
                		dao.setProjectId(projectId);
                		if(dao.load()){
                			dao.delete();
                		}
                	}
                }
                System.out.println("log==="+log.toString());
            }
            System.out.println("__logger==="+__logger.toString());
        }
    }
    
    /**
     * 同步OA职员基础信息
     * @throws SQLException
     */
//    public static void OnTongBuOAEmpInfo() throws SQLException{
//    	 //获取所有的OA职员数据
//        BEmployee oaDao = new BEmployee();
//        oaDao.setConnection("oabase");
//        //同步OA职员学历信息
//        BEmstudy esDao = new BEmstudy();
//        esDao.setConnection("oabase");
//        BaseBEmstudy esBean = null;
//        EmployeeEducationInformation eeiDao = new EmployeeEducationInformation();
//        BaseEmployeeEducationInformation eeiBean = null;
//        SystemDictionary sdDao = new SystemDictionary();
//        BaseSystemDictionary sdBean = null;
//        //只检索在职和离职的人员
//        oaDao.addCondition(BaseBEmployee.CS_EMPLOYSTATEID,"in",1,2);
//        List<BaseBEmployee> oaList = oaDao.conditionalLoad();
//        if(!BaseHelpUtils.isNullOrEmpty(oaList) && oaList.size() > 0){
//        	Employee dao = new Employee();
//        	BaseEmployee bean = null;
//        	ThreadConnection.beginTransaction();
//        	for(BaseBEmployee e:oaList){
//        		//获取OA职员ID
//        		int oaId = BaseHelpUtils.getIntValue(e.getId());
//        		//根据ID去职员表中检索
//        		dao.clear();
//        		dao.setConditionOaId("=",oaId);
//        		bean = dao.executeQueryOneRow();
//        		if(!BaseHelpUtils.isNullOrEmpty(bean)){
//        			int employeeId = bean.getEmployeeId();
//        			//外语语种
//        			bean.setLanguages(e.getLanguage()==null?bean.getLanguages():e.getLanguage());
//        			//国籍
//        			bean.setCountry(e.getTypeinfo()==null?bean.getCountry():e.getTypeinfo());
//        			//学位
//        			bean.setDegree(e.getDegree()==null?bean.getDegree():e.getDegree());
//        			//学历
//        			bean.setEducation(e.getEducation()==null?bean.getEducation():e.getEducation());
//        			//入职时间
//        			bean.setOnboardDate(e.getDutydate()==null?bean.getOnboardDate():e.getDutydate());
//        			//离职时间
//        			bean.setResignationDate(e.getDimissiondate()==null?bean.getResignationDate():e.getDimissiondate());
//        			//转正日期
//        			bean.setPositiveDate(e.getRemindsdate()==null?bean.getPositiveDate():e.getRemindsdate());
//        			//办公电话
//        			bean.setPhone(e.getTeloffice()==null?bean.getPhone():e.getTeloffice());
//        			//家庭电话
//        			bean.setHomePhone(e.getTelhome()==null?bean.getHomePhone():e.getTelhome());
//        			//籍贯
//        			bean.setBirthplace(e.getNativeplace()==null?bean.getBirthplace():e.getNativeplace());
//        			//政治面貌
////        			bean.setPoliticalFace(e.getPoliticalparty()==null?bean.getPoliticalFace():e.getPoliticalparty());
//        			//婚姻状况
//        			bean.setMarriedStatus(e.getMarriedstateid()==null?bean.getMarriedStatus():e.getMarriedstateid());
//        			//健康状况
//        			bean.setHealth(e.getHealth()==null?bean.getHealth():e.getHealth());
//        			//户口所在地
//        			bean.setAccountLocation(e.getRegisteredaddress()==null?bean.getAccountLocation():e.getRegisteredaddress());
//        			//参加工作时间
//        			bean.setStartWorkDate(e.getStartworkdate()==null?bean.getStartWorkDate():e.getStartworkdate());
//        			//紧急联系人姓名
//        			bean.setEmergencyContactPerson(e.getImqq()==null?bean.getEmergencyContactPerson():e.getImqq());
//        			//紧急联系人电话
//        			bean.setEmergencyContactPhone(e.getImmsn()==null?bean.getEmergencyContactPhone():e.getImmsn());
//        			//社保电脑号
//        			bean.setSocialComputerNumber(e.getInsurance()==null?bean.getSocialComputerNumber():e.getInsurance());
//        			//公积金账号
//        			bean.setFundAccount(e.getTypeofwork()==null?bean.getFundAccount():e.getTypeofwork());
//        			//手机号码
//        			bean.setMobile(e.getTelmobile()==null?bean.getMobile():e.getTelmobile());
//        			//计算年龄=当前系统日期-出生日期
//        			Date dateNow = new Date();
//					int yearNow = DateUtil.getYear(dateNow);  
//			        int monthNow = DateUtil.getMonth(dateNow);  
//			        int dayOfMonthNow = DateUtil.getDay(dateNow);  
//			  
//			        Date birthDate = bean.getBirth();
//			        if(!BaseHelpUtils.isNullOrEmpty(birthDate)){
//			        	int yearBirth = DateUtil.getYear(birthDate);  
//			        	int monthBirth = DateUtil.getMonth(birthDate);  
//			        	int dayOfMonthBirth = DateUtil.getDay(birthDate);  
//			        	int age = yearNow - yearBirth;  
//			        	if (monthNow <= monthBirth) {  
//			        		if (monthNow == monthBirth) {  
//			        			if (dayOfMonthNow < dayOfMonthBirth) age--;  
//			        		}else{  
//			        			age--;  
//			        		}  
//			        	}  
//			        	bean.setAge(age);
//			        }
//			        //试用期=转正日期-入职日期
//			        Date positiveDate = bean.getPositiveDate();
//			        Date onboardDate = bean.getOnboardDate();
//			        if(!BaseHelpUtils.isNullOrEmpty(positiveDate) && !BaseHelpUtils.isNullOrEmpty(onboardDate)){
//			        	int tryTime = DateUtil.getCompareMonths(onboardDate, positiveDate);
//			        	bean.setTryTime(tryTime+"个月");
//			        }
//			        //司龄=离职日期-入职日期
//			        Date resignationDate = bean.getResignationDate();
//			        if(!BaseHelpUtils.isNullOrEmpty(resignationDate) && !BaseHelpUtils.isNullOrEmpty(onboardDate)){
//			        	int resignationYear = DateUtil.getYear(resignationDate);  
//			        	int resignationMonth = DateUtil.getMonth(resignationDate);  
//			        	int resignationDay = DateUtil.getDay(resignationDate); 
//			        	
//			        	int onboardYear = DateUtil.getYear(onboardDate);  
//			        	int onboardMonth = DateUtil.getMonth(onboardDate);  
//			        	int onboardDay = DateUtil.getDay(onboardDate); 
//			        	int years = resignationYear - onboardYear;  
//			        	if (resignationMonth <= onboardMonth) {  
//			        		if (resignationMonth == onboardMonth) {  
//			        			if (resignationDay < onboardDay) years--;  
//			        		}else{  
//			        			years--;  
//			        		}  
//			        	}  
//			        	bean.setForeman(years+"年");
//			        }
//			        
//        			dao.setDataFromBase(bean);
//        			System.out.println("bean========="+bean);
//        			dao.conditionalUpdate();
//        			esDao.clear();
//        	        esDao.setConditionEmployeeid("=",Long.valueOf(oaId));
//        	        esBean = esDao.executeQueryOneRow();
//        	        if(!BaseHelpUtils.isNullOrEmpty(esBean)){
//        	        	//检索职员学历表中是否有数据，如果没有数据，则插入
//        	        	eeiDao.clear();
//        	        	eeiDao.setConditionEmployeeId("=",employeeId);
//        	        	if(eeiDao.countRows() == 0){
//        	        		eeiBean = new BaseEmployeeEducationInformation();
//        	        		eeiBean.setEmployeeId(employeeId);
//        	        		eeiBean.setStartDate(esBean.getStarttime());
//        	        		eeiBean.setEndDate(esBean.getEndtime());
//        	        		eeiBean.setGraduatedSchool(esBean.getSchool());
//        	        		eeiBean.setSpecialty(esBean.getProfession());
//        	        		//加载学位信息
//        	        		sdDao.clear();
//        	        		sdDao.setConditionDicTypeId("=",78);
//        	        		sdDao.setConditionDicTypeValue("=",bean.getDegree());
//        	        		sdBean = sdDao.executeQueryOneRow();
//        	        		if(!BaseHelpUtils.isNullOrEmpty(sdBean)){
//        	        			eeiBean.setDegree(sdBean.getDicTypeValueId());
//        	        		}
//        	        		//加载学历信息
//        	        		sdDao.clear();
//        	        		sdDao.setConditionDicTypeId("=",80);
//        	        		sdDao.setConditionDicTypeValue("=",bean.getEducation());
//        	        		sdBean = sdDao.executeQueryOneRow();
//        	        		if(!BaseHelpUtils.isNullOrEmpty(sdBean)){
//        	        			eeiBean.setEducation(sdBean.getDicTypeValueId());
//        	        		}
//        	        		eeiDao.clear();
//        	        		eeiDao.setDataFromBase(eeiBean);
//        	        		System.out.println("eeiBean====="+eeiBean);
//        	        		eeiDao.save();
//        	        	}
//        	        }
//        		}
//        		ThreadConnection.commit();
//        	}
//        }
//    }
    
    /**
     * 计算职员司龄
     * @throws SQLException 
     */
    public static void accountForman() throws SQLException{
    	Employee dao = new Employee();
    	dao.setConditionEmployeeId(">",0);
    	List<BaseEmployee> list = dao.conditionalLoad();
    	if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
    		for(BaseEmployee bean :list){
    			//获取职员ID
    			int empId = bean.getEmployeeId();
    			//获取在职状态
    			int status = bean.getStatus();
    			//获取入职日期
    			Date onboardDate = bean.getOnboardDate();
    			Date resignationDate = null;
    			if(status == 0){//说明是在在职，则以当前系统时间为准
    				resignationDate = new Date();
    			}else{//以离职日期为准
    				resignationDate = bean.getResignationDate();
    			}
    			if(!BaseHelpUtils.isNullOrEmpty(resignationDate) && !BaseHelpUtils.isNullOrEmpty(onboardDate)){
    				int resignationYear = DateUtil.getYear(resignationDate);  
    				int resignationMonth = DateUtil.getMonth(resignationDate);  
    				int resignationDay = DateUtil.getDay(resignationDate); 
    				
    				int onboardYear = DateUtil.getYear(onboardDate);  
    				int onboardMonth = DateUtil.getMonth(onboardDate);  
    				int onboardDay = DateUtil.getDay(onboardDate); 
    				int years = resignationYear - onboardYear;  
    				if (resignationMonth <= onboardMonth) {  
    					if (resignationMonth == onboardMonth) {  
    						if (resignationDay < onboardDay) years--;  
    					}else{  
    						years--;  
    					}  
    				} 
    				dao.clear();
    				dao.setEmployeeId(empId);
    				if(dao.load()){
    					dao.setForeman(years+"年");
    					dao.update();
    				}
    			}
    		}
        }
    }
    
    //导入职员合同信息
    public static void onExportEmpContract() throws Exception {
    	File file = new File("D:/files/empContract.xlsx");
        Employee dao = new Employee();
        EmployeeContractAttachment conDao = new EmployeeContractAttachment();
        BaseEmployeeContractAttachment conBean = null;
        ThreadConnection.beginTransaction();
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            StringBuilder log = new StringBuilder("未导入员工信息提示<br/>");
            for (int i = 1; i < countRow; i++) {
                // 创建一个行对象,并从第二行开始读取
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                int employeeId  = 0;
                int errorNum = 0;
                String employeeNo = "";//职员编号
                String employeeName = "";//职员名称
                int onboardStatus = -1;//人事状态
                Date startDate = null;//开始日期
                Date endDate = null;//结束日期
                int contractType = -1;//合同类型
                int signType = -1;//签订类型
                int workYearType  =-1;//工龄工资状态
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                            case 1:
                                //职员编号
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	employeeNo = BaseHelpUtils.getString(cell.toString().trim());
                                break;
                            case 2:
                            	//职员名称
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	employeeName = BaseHelpUtils.getString(cell.toString().trim());
                            	break;
                            case 3:
                            	//人事状态
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	onboardStatus = BaseHelpUtils.getIntValue(cell.toString().trim());
                            	break;
                            case 4:
                            	//开始时间
                            	cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                                Date theStartDate = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                                SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
                                startDate = sdf.parse(sdf.format(theStartDate));
                                break;
                            case 5:
                            	//结束时间
                            	cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            	Date theEndDate = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                            	SimpleDateFormat sdfEnd= new SimpleDateFormat("yyyy-MM-dd");
                            	endDate = sdfEnd.parse(sdfEnd.format(theEndDate));
                            	break;
                            case 6:
                            	//合同类型
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	contractType = BaseHelpUtils.getIntValue(cell.toString().trim());
                            	break;
                            case 7:
                            	//签订类型
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	signType = BaseHelpUtils.getIntValue(cell.toString().trim());
                            	break;
                            case 8:
                            	//工龄工资状态
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	workYearType = BaseHelpUtils.getIntValue(cell.toString().trim());
                            	break;
                            default:
                                break;
                        }
                    }
                }
                //根据人员姓名和编号查询
                dao.clear();
                dao.setConditionEmployeeNo("=",employeeNo);
                dao.setConditionEmployeeName("=",employeeName);
                int empNum = dao.countRows();
                if(empNum == 0){
                	errorNum++;
                	log.append(String.format("第%1$d行数据异常, 姓名:%2$s, 员工编号:%3$s 不符<br/>", i+1, employeeName, employeeNo));
                	continue;
                }else if(empNum == 1){
                	BaseEmployee bean = dao.executeQueryOneRow();
                	employeeId = bean.getEmployeeId();
                	//跟新职员表的人事状态和工龄工资状态
                	dao.clear();
                	dao.setEmployeeId(employeeId);
                	if(dao.load()){
                		if(onboardStatus >= 0){
                			dao.setOnboardStatus(onboardStatus);
                		}
                		if(workYearType >= 0){
                			dao.setWorkYearType(workYearType);
                		}
                		dao.update();
                	}
                	//检索职员合同表
                	conDao.clear();
                	conDao.setConditionEmployeeId("=",employeeId);
                	if(conDao.countRows() == 0){//没有数据，则插入
                		conBean = new BaseEmployeeContractAttachment();
                		conBean.setEmployeeId(employeeId);
                		conBean.setContractType(contractType);
                		conBean.setSignType(signType);
                		conBean.setStartDate(startDate);
                		conBean.setEndDate(endDate);
                		conBean.setOperateEmployeeId(0);
                		conBean.setOperateTime(new Date());
                		conDao.clear();
                		conDao.setDataFromBase(conBean);
                		conDao.save();
                	}
                	
                }else if(empNum > 1){
                	log.append(String.format("第%1$d行编号和姓名重复, 姓名:%2$s, 员工编号:%3$s 不符<br/>", i+1, employeeName, employeeNo));
                	continue;
                }
                if (errorNum > 0) {
                	log.append("<br/>总共：").append(errorNum).append("人没有导入").append("<br/>原因：根据员工编号/名称没有匹配到员工");
                }
                System.out.print(log.toString());
            }
        }
        ThreadConnection.commit();
    }
    
    //导入职员工龄工资
    public static void onExportEmpWorkMoney() throws Exception {
    	File file = new File("D:/files/empWorkMoney.xlsx");
        Employee dao = new Employee();
        SalaryOfWorkYear conDao = new SalaryOfWorkYear();
        BaseSalaryOfWorkYear conBean = null;
        ThreadConnection.beginTransaction();
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            StringBuilder log = new StringBuilder("未导入员工信息提示<br/>");
            for (int i = 1; i < countRow; i++) {
                // 创建一个行对象,并从第二行开始读取
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                int employeeId  = 0;
                int errorNum = 0;
                String employeeNo = "";//职员编号
                String employeeName = "";//职员名称
                int year = 0;//年份
                int month = 0;//月份
                int workMoney = 0;
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                            case 1:
                                //职员编号
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	employeeNo = BaseHelpUtils.getString(cell.toString().trim());
                                break;
                            case 2:
                            	//职员名称
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	employeeName = BaseHelpUtils.getString(cell.toString().trim());
                            	break;
                            case 3:
                            	//年份
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	year = BaseHelpUtils.getIntValue(cell.toString().trim());
                            	break;
                            case 4:
                            	//月份
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	month = BaseHelpUtils.getIntValue(cell.toString().trim());
                            	break;
                            case 5:
                            	//工龄工资
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	workMoney = BaseHelpUtils.getIntValue(cell.toString().trim());
                            	break;
                            default:
                                break;
                        }
                    }
                }
                //根据人员姓名和编号查询
                dao.clear();
                dao.setConditionEmployeeNo("=",employeeNo);
                dao.setConditionEmployeeName("=",employeeName);
                int empNum = dao.countRows();
                if(empNum == 0){
                	errorNum++;
                	log.append(String.format("第%1$d行数据异常, 姓名:%2$s, 员工编号:%3$s 不符<br/>", i+1, employeeName, employeeNo));
                	continue;
                }else if(empNum == 1){
                	BaseEmployee bean = dao.executeQueryOneRow();
                	employeeId = bean.getEmployeeId();
                	//检索职员合同表
                	conDao.clear();
                	conDao.setConditionEmployeeId("=",employeeId);
                	conDao.setConditionYear("=",year);
                	conDao.setConditionMonth("=",month);
                	if(conDao.countRows() == 0){//没有数据，则插入
                		conBean = new BaseSalaryOfWorkYear();
                		if(workMoney > 0){
                			conBean.setEmployeeId(employeeId);
                			conBean.setYear(year);
                			conBean.setMonth(month);
                			conBean.setWorkMoney(workMoney+"");
                			conDao.clear();
                			conDao.setDataFromBase(conBean);
                			conDao.save();
                		}
                	}
                	
                }else if(empNum > 1){
                	log.append(String.format("第%1$d行编号和姓名重复, 姓名:%2$s, 员工编号:%3$s 不符<br/>", i+1, employeeName, employeeNo));
                	continue;
                }
                if (errorNum > 0) {
                	log.append("<br/>总共：").append(errorNum).append("人没有导入").append("<br/>原因：根据员工编号/名称没有匹配到员工");
                }
                System.out.print(log.toString());
            }
        }
        ThreadConnection.commit();
    }
    
    
    //导入职员日薪的费用归属
    public static void onExportEmpCostAttribution() throws Exception {
    	File file = new File("C:/Users/PEPE/Desktop/cost.xlsx");
        Employee dao = new Employee();
        EmployeePayment pDao = new EmployeePayment();
        BaseEmployeePayment pBean = new BaseEmployeePayment();
        ThreadConnection.beginTransaction();
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            StringBuilder log = new StringBuilder("未导入员工信息提示<br/>");
            for (int i = 1; i < countRow; i++) {
                // 创建一个行对象,并从第二行开始读取
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                int employeeId  = 0;
                int errorNum = 0;
                String employeeNo = "";//职员编号
                String employeeName = "";//职员名称
                int month = 0;//月份
                int costAttribution = 0;//费用归属
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                            case 1:
                                //职员编号
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	employeeNo = BaseHelpUtils.getString(cell.toString().trim());
                                break;
                            case 2:
                            	//职员名称
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	employeeName = BaseHelpUtils.getString(cell.toString().trim());
                            	break;
                            case 3:
                            	//费用归属
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	costAttribution = BaseHelpUtils.getIntValue(cell.toString().trim());
                            	break;
                            case 4:
                            	//月份
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	if(cell.toString().trim().equals("1月")){
                            		month = 1;
                            	}else if(cell.toString().trim().equals("2月")){
                            		month = 2;
                            	}else if(cell.toString().trim().equals("3月")){
                            		month = 3;
                            	}else if(cell.toString().trim().equals("4月")){
                            		month = 4;
                            	}else if(cell.toString().trim().equals("5月")){
                            		month = 5;
                            	}else if(cell.toString().trim().equals("6月")){
                            		month = 6;
                            	}
                            	break;
                            default:
                                break;
                        }
                    }
                }
                //根据人员姓名和编号查询
                dao.clear();
                dao.setConditionEmployeeNo("=",employeeNo);
                dao.setConditionEmployeeName("=",employeeName);
                int empNum = dao.countRows();
                if(empNum == 0){
                	errorNum++;
                	log.append(String.format("第%1$d行数据异常, 姓名:%2$s, 员工编号:%3$s 不符<br/>", i+1, employeeName, employeeNo));
                	continue;
                }else if(empNum == 1){
                	BaseEmployee bean = dao.executeQueryOneRow();
                	employeeId = bean.getEmployeeId();
                	//检索职员合同表
                	pDao.clear();
                	if(month > 0){
                		pDao.setConditionEmployeeId("=",employeeId);
                		if(pDao.countRows() > 0){//如果有数据则插入 费用归属
                			List<BaseEmployeePayment> list = pDao.conditionalLoad();
                			if(!BaseHelpUtils.isNullOrEmpty(list) && costAttribution > 0){
                				Calendar cal = Calendar.getInstance();
                				for(BaseEmployeePayment e : list){
                					cal.clear();
                					cal.setTime(e.getChangeDate());
                					int paymonth = cal.get(Calendar.MONTH)+1;//获取调薪日期的月份
                					if(month == paymonth){//如果调薪日期的月份和表格中的月份一致，则插入该月费用归属
                						e.setCostAttribution(costAttribution);
                        				pDao.clear();
                        				pDao.setDataFromBase(e);
                        				pDao.update();
                					}
                				}
                			}
                		}
                	}
                	
                }else if(empNum > 1){
                	log.append(String.format("第%1$d行编号和姓名重复, 姓名:%2$s, 员工编号:%3$s 不符<br/>", i+1, employeeName, employeeNo));
                	continue;
                }
                if (errorNum > 0) {
                	log.append("<br/>总共：").append(errorNum).append("人没有导入").append("<br/>原因：根据员工编号/名称没有匹配到员工");
                }
                System.out.print(log.toString());
            }
        }
        ThreadConnection.commit();
    }
    
    //导入应发奖金
    public static void onExportShouldBonus() throws Exception {
    	File file = new File("C:/Users/PEPE/Desktop/yingfacopy.xlsx");
        Employee dao = new Employee();
        SalaryOfBonus pDao = new SalaryOfBonus();
        BaseSalaryOfBonus pBean = new BaseSalaryOfBonus();
        ThreadConnection.beginTransaction();
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            StringBuilder log = new StringBuilder("未导入员工信息提示<br/>");
            for (int i = 1; i < countRow; i++) {
            	 // 创建一个行对象,并从第二行开始读取
                String name = null,no = null;
                Date recordDate = null;
                String date = null;
                BigDecimal shouldBonus = null;
                int errorNum = 0;
                
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                        case 1:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	no = BaseHelpUtils.getString(cell.toString().trim());
                            if (no.length() < 6) {
                                no = String.format("%06d", BaseHelpUtils.getIntValue(no));
                            }
                            break;
                        case 2:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                            name = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 3:
                        	cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            Date theDate = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
                            date = sdf.format(theDate);  
                            recordDate = sdf.parse(date);
                            break;
                        case 4:
                        	cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                        	shouldBonus = BaseHelpUtils.getDecimal(cell.toString().trim(),2);
                            break;
                        default:
                            break;
                        }
                    }
                }
                
                Calendar current = Calendar.getInstance();
                current.setTime(recordDate);
                if(!BaseHelpUtils.isNullOrEmpty(recordDate)){
                	int year = current.get(Calendar.YEAR);
                	int month = current.get(Calendar.MONTH)+1;
                	pBean.setYear(year);
                	pBean.setMonth(month);
                }
                
                //根据人员姓名和编号查询
                dao.clear();
                dao.setConditionEmployeeNo("=",no);
                dao.setConditionEmployeeName("=",name);
                int empNum = dao.countRows();
                if(empNum == 0){
                	errorNum++;
                	log.append(String.format("第%1$d行数据异常, 姓名:%2$s, 员工编号:%3$s 不符<br/>", i+1, name, no));
                	continue;
                }else if(empNum == 1){
                	BaseEmployee bean = dao.executeQueryOneRow();
                	int employeeId = bean.getEmployeeId();
                	//检索职员合同表
                	pDao.clear();
                	pBean.setEmployeeId(employeeId);
                	pBean.setRecordDate(recordDate);
                	pBean.setShouldBonus(shouldBonus+"");
                	pBean.setFlag(1);
                	pDao.setDataFromBase(pBean);
                	pDao.save();
                }else if(empNum > 1){
                	log.append(String.format("第%1$d行编号和姓名重复, 姓名:%2$s, 员工编号:%3$s 不符<br/>", i+1, name, no));
                	continue;
                }
                if (errorNum > 0) {
                	log.append("<br/>总共：").append(errorNum).append("人没有导入").append("<br/>原因：根据员工编号/名称没有匹配到员工");
                }
                System.out.print(log.toString());
            }
        }
        ThreadConnection.commit();
    }
    
    //导入考勤扣款
    public static void onExportDeductTotal() throws Exception {
    	File file = new File("C:/Users/PEPE/Desktop/deductTotal.xlsx");
        Employee dao = new Employee();
        EmployeePaymentDetail pDao = new EmployeePaymentDetail();
        BaseEmployeePaymentDetail pBean = new BaseEmployeePaymentDetail();
        ThreadConnection.beginTransaction();
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            StringBuilder log = new StringBuilder("未导入员工信息提示<br/>");
            for (int i = 1; i < countRow+1; i++) {
            	 // 创建一个行对象,并从第二行开始读取
                String name = null,no = null;
                BigDecimal deductTotal = BigDecimal.ZERO;
                int month = 0;
                
                int errorNum = 0;
                
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                        case 1:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	no = BaseHelpUtils.getString(cell.toString().trim());
                            if (no.length() < 6) {
                                no = String.format("%06d", BaseHelpUtils.getIntValue(no));
                            }
                            break;
                        case 2:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                            name = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 3:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	deductTotal = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                            break;
                        case 4:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	if(cell.toString().trim().equals("1月")){
                        		month = 1;
                        	}else if(cell.toString().trim().equals("2月")){
                        		month = 2;
                        	}else if(cell.toString().trim().equals("3月")){
                        		month = 3;
                        	}else if(cell.toString().trim().equals("4月")){
                        		month = 4;
                        	}else if(cell.toString().trim().equals("5月")){
                        		month = 5;
                        	}else if(cell.toString().trim().equals("6月")){
                        		month = 6;
                        	}
                        	break;
                        default:
                            break;
                        }
                    }
                }
                
                //根据人员姓名和编号查询
                dao.clear();
                dao.setConditionEmployeeNo("=",no);
                dao.setConditionEmployeeName("=",name);
                int empNum = dao.countRows();
                if(empNum == 0){
                	errorNum++;
                	log.append(String.format("第%1$d行数据异常, 姓名:%2$s, 员工编号:%3$s 不符<br/>", i+1, name, no));
                	continue;
                }else if(empNum == 1){
                	 Calendar cal = Calendar.getInstance();
                     if(month > 0){
                     	cal.set(2017,month-1,1);
                     	pBean.setDetailDate(cal.getTime());
                     }
                	BaseEmployee bean = dao.executeQueryOneRow();
                	int employeeId = bean.getEmployeeId();
                	
                	pDao.clear();
                	pBean.setEmployeeId(employeeId);
                	pBean.setDeductTotal(deductTotal);
                	pDao.setDataFromBase(pBean);
                	pDao.save();
                }else if(empNum > 1){
                	log.append(String.format("第%1$d行编号和姓名重复, 姓名:%2$s, 员工编号:%3$s 不符<br/>", i+1, name, no));
                	continue;
                }
                if (errorNum > 0) {
                	log.append("<br/>总共：").append(errorNum).append("人没有导入").append("<br/>原因：根据员工编号/名称没有匹配到员工");
                }
                System.out.print(log.toString());
            }
        }
        ThreadConnection.commit();
    }
    
    //导入兼职人员
    public static void onExportPartTimeEmp() throws Exception {
    	File file = new File("C:/Users/PEPE/Desktop/parttime.xlsx");
        Employee dao = new Employee();
        BaseEmployee bean = new BaseEmployee();
        
        ThreadConnection.beginTransaction();
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            StringBuilder log = new StringBuilder("未导入员工信息提示<br/>");
            for (int i = 1; i < countRow+1; i++) {
            	 // 创建一个行对象,并从第二行开始读取
                String name = null,no = null,card = null,mobile = null;
                String birthplace = null;//籍贯
                String accountLocation = null;//户口所在地
                String householdRegistrationStr = null;//户籍
                int householdRegistration = 0;
                String socialComputerNumber = null;//社保电脑号
                String bankCardNum = null;//银行卡号
                String fundAccount = null;//公积金账号
                String emergencyContactPerson = null,emergencyContactPhone = null;//紧急联系人,紧急联系人电话
                String nowAddress = null,cardAddress = null;
                String country = null;
                String graduatedSchool = null,specialty = null;
                Date startDate = null,endDate = null;
                int education = 0,degree = 0,learningWay = 0;
                String educationStr = null,degreeStr = null, learningWayStr = null;
                
                int gender = 0;
                Date startWorkDate = null,onboardDate = null,positiveDate = null;
                Date contractStartDate = null,contractEndDate = null;
                
                int errorNum = 0;
                SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
                Date theDate = null;
                
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                        case 1:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	no = BaseHelpUtils.getString(cell.toString().trim());
                            if (no.length() < 6) {
                                no = String.format("%06d", BaseHelpUtils.getIntValue(no));
                            }
                            break;
                        case 2:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                            name = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 7:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	card = BaseHelpUtils.getString(cell.toString().trim());
                            break;
                        case 8:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	String sex = BaseHelpUtils.getString(cell.toString().trim());
                        	if(sex.equals("男")){
                        		gender = 1; 
                        	}else if(sex.equals("女")){
                        		gender = 2; 
                        	}
                        	break;
                        case 9:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	country = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 12:
                        	cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                        	theDate = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                            startWorkDate = sdf.parse(sdf.format(theDate));
                            break;
                        case 14:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	birthplace = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 15:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	accountLocation = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 16:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	householdRegistrationStr = BaseHelpUtils.getString(cell.toString().trim());
                        	if(householdRegistrationStr.equals("深户")){
                        		householdRegistration = 0;
                        	}else if(householdRegistrationStr.equals("非深户城镇")){
                        		householdRegistration = 1;
                        	}
                        	break;
                        case 20:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	socialComputerNumber = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 21:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	fundAccount = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 22:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	bankCardNum = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 23:
	                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	                    	theDate = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
	                        onboardDate = sdf.parse(sdf.format(theDate));
                        	break;
                        case 27:
	                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	                    	theDate = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
	                    	positiveDate = sdf.parse(sdf.format(theDate));
                        	break;
                        case 28:
	                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	                    	theDate = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
	                    	contractStartDate = sdf.parse(sdf.format(theDate));
                        	break;
                        case 29:
	                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	                    	theDate = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
	                    	contractEndDate = sdf.parse(sdf.format(theDate));
                        	break;
                        case 30:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	mobile = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 32:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	emergencyContactPerson = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 33:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	emergencyContactPhone = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 34:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	cardAddress = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 35:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	nowAddress = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 36:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	graduatedSchool = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 37:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	specialty = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 38:
                        	cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	                    	theDate = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
	                    	startDate = sdf.parse(sdf.format(theDate));
                        	break;
                        case 39:
                        	cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	                    	theDate = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
	                    	endDate = sdf.parse(sdf.format(theDate));
                        	break;
                        case 40:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	educationStr = BaseHelpUtils.getString(cell.toString().trim());
                        	if(educationStr.equals("本科")){
                        		education = 2;
                        	}else if(educationStr.equals("大专")){
                        		education = 3;
                        	}
                        	break;
                        case 41:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	degreeStr = BaseHelpUtils.getString(cell.toString().trim());
                        	if(degreeStr.equals("学士学位")){
                        		degree = 2;
                        	}else if(degreeStr.equals("无")){
                        		degree = 3;
                        	}
                        	break;
                        case 42:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	learningWayStr = BaseHelpUtils.getString(cell.toString().trim());
                        	if(learningWayStr.equals("全日制")){
                        		learningWay = 0;
                        	}else if(learningWayStr.equals("自考")){
                        		learningWay = 1;
                        	}
                        	break;
                        default:
                            break;
                        }
                    }
                }
                
                dao.clear();
                dao.setConditionEmployeeName("=", name);
                dao.setConditionEmployeeNo("=", no);
                
                bean = dao.executeQueryOneRow();
                
            	//往employees表中插入数据
                if(BaseHelpUtils.isNullOrEmpty(bean)){
                	bean = new BaseEmployee();
                	bean.setFileNumber("0");
                    bean.setPlateId(27);
                    bean.setDepartmentId(102);
                    bean.setCard(card);
                    bean.setGender(gender);
                    bean.setCountry(country);
                    bean.setEducation(education+"");
                    bean.setDegree(degree+"");
                    bean.setStartWorkDate(startWorkDate);
                    bean.setLanguages("英语");
                    bean.setBirthplace(birthplace);
                    bean.setAccountLocation(accountLocation);
                    bean.setHouseholdRegistration(householdRegistration);
                    bean.setNationality("1");
                    bean.setMarriedStatus("0");
                    bean.setSocialComputerNumber(socialComputerNumber);
                    bean.setFundAccount(fundAccount);
                    bean.setBankCardNum(bankCardNum);
                    bean.setOnboardDate(onboardDate);
                    bean.setWorkAddress("深圳");
                    bean.setOnboardStatus(3);
                    bean.setStatus(0);
                    bean.setOwnedCompany("0");
                    bean.setCompanyId(0);
                    bean.setPositiveDate(positiveDate);
                    bean.setContractStartDate(contractStartDate);
                    bean.setContractEndDate(contractEndDate);
                    bean.setMobile(mobile);
                    bean.setEmergencyContactPerson(emergencyContactPerson);
                    bean.setEmergencyContactPhone(emergencyContactPhone);
                    bean.setCardAddress(cardAddress);
                    bean.setNowAddress(nowAddress);
                    bean.setRoleId(15);//普通职员
                    bean.setIsCheck(Boolean.FALSE);//不参与考勤
                    
                    //根据身份证号计算出生日期和年龄
                    if(card.length() == 18){
                    	String birthday = card.substring(6,14);
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
                    		}else{  
                    			age--;  
                    		}  
                    	}
                    	
                    	bean.setAge(age);
                    	bean.setBirth(birthDate);
                    }
                	dao.clear();
                	bean.setEmployeeName(name);
                	bean.setEmployeeNo(no);
                	dao.setDataFromBase(bean);
                	dao.save();
                }
                
                int employeeId = dao.getEmployeeId();
                
                //向员工学历信息表插入数据
                EmployeeEducationInformation edao = new EmployeeEducationInformation();
                edao.clear();
                edao.setEmployeeId(employeeId);
                edao.setGraduatedSchool(graduatedSchool);
                edao.setEducation(education);
                edao.setDegree(degree);
                edao.setStartDate(startDate);
                edao.setEndDate(endDate);
                edao.setLearningWay(learningWay);
                edao.setSpecialty(specialty);
                edao.save();
                
                //往employee_role表中插入数据
                EmployeeRole rdao = new EmployeeRole();
                rdao.setConditionEmployeeId("=", employeeId);
                rdao.setConditionRoleId("=",15);
                BaseEmployeeRole rbean = rdao.executeQueryOneRow();
                if(BaseHelpUtils.isNullOrEmpty(rbean)){
                	rdao.clear();
                	rdao.setEmployeeId(employeeId);
                	rdao.setRoleId(15);
                	rdao.setIsDefault(Boolean.TRUE);
                	rdao.save();
                }
                
                //如果银行卡号不为空，往card_manage表里插入或更新数据
    			if(!BaseHelpUtils.isNullOrEmpty(dao.getBankCardNum())){
    				CardManage cardDao = new CardManage();
					cardDao.clear();
					cardDao.setObjectId(employeeId);
					cardDao.setObjectType(1);//类型:个人
//    					cardDao.setBankId(100);//默认招商银行
					cardDao.setBankAccount(dao.getBankCardNum());
					cardDao.setCardType(1);//卡号类型:银行卡
					cardDao.setCurrencyType(0);//货币类型:人民币
					cardDao.save();
    			}
                
                //向员工合同管理表插入数据
				EmployeeContractAttachment contractDao = new EmployeeContractAttachment();
				contractDao.clear();
				contractDao.setEmployeeId(employeeId);
				contractDao.setAttachmentName("顾问合同");
				contractDao.setContractType(1);
//				contractDao.setSignType(0);//新签
				contractDao.setStartDate(dao.getContractStartDate());
				contractDao.setEndDate(dao.getContractEndDate());
//				contractDao.setAttachmentUrl(dao.getLaborAttachments());
//				contractDao.setOperateEmployeeId(applyEmployeeId);
				contractDao.setOperateTime(new Date());
				contractDao.save();
                
                if (errorNum > 0) {
                	log.append("<br/>总共：").append(errorNum).append("人没有导入").append("<br/>原因：根据员工编号/名称没有匹配到员工");
                }
                System.out.print(log.toString());
            }
        }
        ThreadConnection.commit();
    }
    
    /**
     * 职员没有归属业务部门计算
     * @param recordDate
     * @throws SQLException
     */
    public static void onEmpDayPlate(Date recordDate) throws SQLException{
    	Employee dao = new Employee();
    	Object[] obj = new Object[2];
    	obj[0] = 1;
    	obj[1] = 2;
    	dao.addCondition(BaseEmployee.CS_ONBOARD_STATUS,"in",obj);
    	String sql = "(status = 0 and onboard_date <= '"+recordDate+"') or (status != 0 and resignation_date = '"+recordDate+"')";
    	List<BaseEmployee> list = dao.conditionalLoad(sql);
    	if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
    		EmployeeDayPlateRecord eDao = new EmployeeDayPlateRecord();
    		int year = DateUtil.getYear(recordDate);
    		int month = DateUtil.getMonth(recordDate);
    		ThreadConnection.beginTransaction();
    		for(BaseEmployee e : list){
    			eDao.clear();
    			eDao.setEmployeeId(e.getEmployeeId());
    			eDao.setEmployeeNo(e.getEmployeeNo());
    			eDao.setEmployeeName(e.getEmployeeName());
    			eDao.setPlateId(e.getPlateId());
    			eDao.setCompanyId(e.getCompanyId());
    			eDao.setDepartmentId(e.getDepartmentId());
    			eDao.setRecordDate(recordDate);
    			eDao.setYear(year);
    			eDao.setMonth(month);
    			eDao.save();
    		}
    		ThreadConnection.commit();
    	}
    }
    
    /**
     * 同步项目阶段成员
     * @throws SQLException 
     */
    public static void onCompareProjectStageEmp() throws SQLException{
    	//先检索项目阶段表数据集，将项目成员的阶段Id全部更新为该项目的第一个阶段的Id
    	ProjectStage psDao = new ProjectStage();
    	List<BaseProjectStage> psList = psDao.conditionalLoad(" order by project_id, project_stage_id asc");
    	if(!BaseHelpUtils.isNullOrEmpty(psList) && psList.size() > 0){
    		ProjectEmployee peDao = new ProjectEmployee();
    		ProjectSettlement pssDao = new ProjectSettlement();
    		List<BaseProjectSettlement> pssList = null;
    		ProjectSettlementDetail psdDao = new ProjectSettlementDetail();
    		List<BaseProjectSettlementDetail> psdList = null;
    		for(BaseProjectStage psBean : psList){
    			//获取项目Id和阶段Id
    			int projectId = BaseHelpUtils.getIntValue(psBean.getProjectId());
    			int stageId = BaseHelpUtils.getIntValue(psBean.getStageId());
    			//根据该项目Id去检索看该项目是否有设定成员
    			peDao.clear();
    			peDao.setConditionProjectId("=",projectId);
    			if(!peDao.isExist()){//说明没进行团队组建过则结束循环
    				continue;
    			}
    			//根据项目Id去检索看该项目是否已经有结算记录了
    			pssDao.clear();
    			pssDao.setConditionProjectId("=",projectId);
    			if(!pssDao.isExist()){//说明还未进行结算
    				//如果还未进行结算，则把项目成员表中未绑定阶段的数据全部绑定到该阶段上
    				peDao.clear();
        			peDao.setConditionProjectId("=",projectId);
        			peDao.setConditionStageId("=",-1);
        			if(peDao.isExist()){
        				peDao.setStageId(stageId);
        				peDao.conditionalUpdate();
        			}
        			continue;
    			}
    			//根据项目Id和阶段Id去检索结算总表的数据集
    			pssDao.clear();
    			pssDao.setConditionProjectId("=",projectId);
    			pssDao.setConditionStageId("=",stageId);
    			pssList = pssDao.conditionalLoad();
    			if(!BaseHelpUtils.isNullOrEmpty(pssList) && pssList.size() > 0){
    				//定义map来存放该项目在该阶段上每个成员的预分配积分(即成员在该阶段上的确认积分)
    				Map<Integer,BigDecimal> sureMap = new HashMap<>();
    				for(BaseProjectSettlement pssBean : pssList){
    					//获取结算总表Id
    					int settlementId = BaseHelpUtils.getIntValue(pssBean.getSettlementId());
    					psdDao.clear();
    					psdDao.setConditionSettlementId("=",settlementId);
    					psdList = psdDao.conditionalLoad();
    					if(!BaseHelpUtils.isNullOrEmpty(psdList) && psdList.size() > 0){
    						for(BaseProjectSettlementDetail psdBean : psdList){
    							//获取成员Id
    							int employeeId = BaseHelpUtils.getIntValue(psdBean.getEmployeeId());
    							//获取确认积分
    							BigDecimal sureIntegral = BaseHelpUtils.getBigDecimalValue(psdBean.getRealAmount());
    							sureMap.put(employeeId,BaseHelpUtils.getBigDecimalValue(sureMap.get(employeeId)).add(sureIntegral));
    						}
    					}
    				}
    				if(!BaseHelpUtils.isNullOrEmpty(sureMap) && sureMap.size() > 0){
    					for(Integer employeeId : sureMap.keySet()){
    						//获取该成员已累计确认的积分
    						BigDecimal sureIntegral = BaseHelpUtils.getBigDecimalValue(sureMap.get(employeeId));
    						peDao.clear();
    						peDao.setConditionProjectId("=",projectId);
    						peDao.setConditionStageId("=",-1);
    						peDao.setConditionEmployeeId("=",employeeId);
    						if(peDao.isExist()){
    							peDao.setStageId(stageId);
    							peDao.setPlanIntegral(sureIntegral);
    							peDao.conditionalUpdate();
    						}else{
    							peDao.setProjectId(projectId);
    							peDao.setStageId(stageId);
    							peDao.setEmployeeId(employeeId);
    							peDao.setPlanIntegral(sureIntegral);
    							peDao.save();
    						}
    					}
    				}
    			}
    		}
    	}
    }
    
    //合同状态导入
    public static void onExportContractStatus() throws Exception {
    	File file = new File("C:/Users/Administrator/Desktop/contractStatus.xlsx");
        Contract dao = new Contract();
        ThreadConnection.beginTransaction();
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            StringBuilder log = new StringBuilder("未导入合同信息提示<br/>");
            for (int i = 1; i < countRow+1; i++) {
            	 // 创建一个行对象,并从第二行开始读取
                String contractCode = null;
                int constractStatus = 0;
                int errorNum = 0;
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                        case 0:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	contractCode = BaseHelpUtils.getString(cell.toString().trim());
                            break;
                        case 1:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                            constractStatus = BaseHelpUtils.getIntValue(cell.toString().trim());
                        	break;
                        default:
                            break;
                        }
                    }
                }
                
                //根据人员姓名和编号查询
                System.out.println("contractCode==="+contractCode+";constractStatus=========="+constractStatus);
                dao.clear();
                dao.setConditionContractCode("=",contractCode);
                int num = dao.countRows();
                if(num == 0){
                	errorNum++;
                	log.append(String.format("第%1$d行数据异常,合同编号:%2$s 不符<br/>", i+1, contractCode));
                	continue;
                }else{
                	dao.setContractStatus(constractStatus); 
                	dao.conditionalUpdate();
                }
                if (errorNum > 0) {
                	log.append("<br/>总共：").append(errorNum).append("条没有导入").append("<br/>原因：根据合同编号没有匹配到员工");
                }
                System.out.print(log.toString());
            }
        }
        ThreadConnection.commit();
    }
    
    //合同导入
    public static void onExportContracts() throws Exception {
    	File file = new File("C:/Users/Administrator/Desktop/contracts.xlsx");
        Contract dao = new Contract();
        ThreadConnection.beginTransaction();
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            StringBuilder log = new StringBuilder("未导入合同信息提示<br/>");
            for (int i = 1; i < countRow+1; i++) {
            	 // 创建一个行对象,并从第二行开始读取
                String contractCode = null;
                int constractStatus = 0;
                BigDecimal amount = BigDecimal.ZERO;
                String name = null;
                int errorNum = 0;
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                        case 0:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	contractCode = BaseHelpUtils.getString(cell.toString().trim());
                            break;
                        case 1:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                            constractStatus = BaseHelpUtils.getIntValue(cell.toString().trim());
                        	break;
                        case 2:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	amount = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                        	amount = amount.multiply(BigDecimal.valueOf(10000));
                        	break;
                        case 3:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	name = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        default:
                            break;
                        }
                    }
                }
                
                //根据人员姓名和编号查询
                System.out.println("contractCode==="+contractCode+";constractStatus=========="+constractStatus);
                dao.clear();
                dao.setConditionContractCode("=",contractCode);
                int num = dao.countRows();
                if(num > 0){
                	errorNum++;
                	log.append(String.format("第%1$d行数据异常,合同编号:%2$s 已存在<br/>", i+1, contractCode));
                	continue;
                }else{
                	dao.setContractStatus(constractStatus); 
                	dao.setContractCode(contractCode);
                	dao.setContractName(name);
                	dao.setSigningMoneySum(amount);
                	dao.save();
                }
                if (errorNum > 0) {
                	log.append("<br/>总共：").append(errorNum).append("条没有导入").append("<br/>原因：根据合同编号已存在");
                }
                System.out.print(log.toString());
            }
        }
        ThreadConnection.commit();
    }
    
    public static void captureJavascript() throws Exception {  
    	//http://hq.sinajs.cn/rn=1509434397273&list=sz300668,sz300668_i,bk_new_qtxy
    	Map<String,Object> resultMap = new HashMap<>();
        String strURL = "http://hq.sinajs.cn/?rn=1509434397273&list=sz300668";  
        URL url = new URL(strURL);  
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();  
        InputStreamReader input = new InputStreamReader(httpConn.getInputStream(), "gb2312");  
        BufferedReader bufReader = new BufferedReader(input);  
        String line = "";  
        StringBuilder contentBuf = new StringBuilder();  
        while ((line = bufReader.readLine()) != null) {  
            contentBuf.append(line);  
        }  
        System.out.println("captureJavascript()的结果：\n" + contentBuf.toString()); 
        if(!BaseHelpUtils.isNullOrEmpty(contentBuf)){
        	int len = contentBuf.toString().length();
        	//字符串截取
        	String valueStr = contentBuf.toString().substring(contentBuf.indexOf("=")+2,len-2);
        	System.out.println("valueStr="+valueStr);
        	String[] valueArr = valueStr.split(",");
        	int size = valueArr.length;
        	if(size >= 10){
        		resultMap.put("companyName",valueArr[0]);//公司名称
        		resultMap.put("todayOpenPrice",valueArr[1]);//今日开盘价
        		resultMap.put("yesterdayClosePrice",valueArr[2]);//昨日收盘价
        		resultMap.put("currentPrice",valueArr[3]);//当前价格
        		resultMap.put("todayMaxPrice",valueArr[4]);//今日最高价
        		resultMap.put("todayMinPrice",valueArr[5]);//今日最低价
        		resultMap.put("buyPrice",valueArr[6]);//竞买价
        		resultMap.put("sellPrice",valueArr[7]);//竞卖价
        		resultMap.put("volumeNum",valueArr[8]);//成交量
        		resultMap.put("volumeMoney",valueArr[9]);//成交额
        	}
        	System.out.println("resultMap==="+resultMap);
        }
    }  
    
    //导入募投项目
    public static void onExportVoteProject() throws Exception {
    	File file = new File("C:/Users/PEPE/Desktop/2017年9月募投项目.xlsx");
        SalaryTotal dao = new SalaryTotal();
        ThreadConnection.beginTransaction();
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            StringBuilder log = new StringBuilder("未导入员工信息提示<br/>");
            for (int i = 1; i < countRow+1; i++) {
            	 // 创建一个行对象,并从第二行开始读取
                String name = null,no = null;
                int year = 0,month = 0;
                String voteProject = null,votePercent = null;
                int errorNum = 0;
                
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                        case 1:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	no = BaseHelpUtils.getString(cell.toString().trim());
                            if (no.length() < 6) {
                                no = String.format("%06d", BaseHelpUtils.getIntValue(no));
                            }
                            break;
                        case 2:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                            name = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 5:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	voteProject = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 6:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	votePercent = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        default:
                            break;
                        }
                    }
                }
                
                //根据人员姓名和编号查询
                dao.clear();
                dao.setConditionEmployeeNo("=",no);
                dao.setConditionEmployeeName("=",name);
                dao.setConditionYear("=", 2017);
                dao.setConditionMonth("=", 9);
                int empNum = dao.countRows();
                if(empNum == 0){
                	errorNum++;
                	log.append(String.format("第%1$d行数据异常, 姓名:%2$s, 员工编号:%3$s 不符<br/>", i+1, name, no));
                	continue;
                }else if(empNum == 1){
                	dao.setVoteProject(voteProject);
                	dao.setVotePercent(votePercent);
                	dao.conditionalUpdate();
                }else if(empNum > 1){
                	log.append(String.format("第%1$d行编号和姓名重复, 姓名:%2$s, 员工编号:%3$s 不符<br/>", i+1, name, no));
                	continue;
                }
                if (errorNum > 0) {
                	log.append("<br/>总共：").append(errorNum).append("人没有导入").append("<br/>原因：根据员工编号/名称没有匹配到员工");
                }
                System.out.print(log.toString());
            }
        }
        ThreadConnection.commit();
    }
    
    //删除重复的项目成员
    public static void deleteProjectEmp() throws SQLException{
    	ProjectStage psDao = new ProjectStage();
    	List<BaseProjectStage> psList = psDao.conditionalLoad(" order by project_id, project_stage_id asc");
    	if(!BaseHelpUtils.isNullOrEmpty(psList) && psList.size() > 0){
    		ProjectEmployee eDao = new ProjectEmployee();
    		List<BaseProjectEmployee> eList = null;
    		Map<Integer,Integer> map = null;
    		int i = 0;
    		StringBuffer log = new StringBuffer("成员重复项目:");
    		for(BaseProjectStage e : psList){
    			//获取项目id 和 阶段id 
    			int projectId = e.getProjectId();
    			int stageId = e.getStageId();
    			//通过项目id和阶段id查看成员
    			eDao.clear();
    			eDao.setConditionProjectId("=", projectId);
    			eDao.setConditionStageId("=", stageId);
    			eList = eDao.conditionalLoad();
    			if(!BaseHelpUtils.isNullOrEmpty(eList) && eList.size() > 0){//如果该项目该阶段有成员
    				map = new HashMap<>();
    				for(BaseProjectEmployee emp : eList){
    					int employeeId = emp.getEmployeeId();
    					int projectEmployeeId = emp.getProjectEmployeeId();
    					if(map.containsKey(employeeId)){//如果该成员在这个阶段已经存在一条数据,删除这条数据
    						eDao.clear();
    						eDao.setProjectEmployeeId(projectEmployeeId);
    						if(eDao.load()){
    							eDao.delete();
    							i++;
    							log.append(projectId+",");
    						}
    						continue;
    					}
    					map.put(employeeId, stageId);
    				}
    			}
    		}
    		__logger.info("dd------------------"+i);
    		__logger.info("dd------------------"+log);
    	}
    }
    
    //导入合同信息,计算、保存提成
    public static void onExportContractData() throws Exception {
    	File file = new File("C:/Users/PEPE/Desktop/contracts.xlsx");
        Contract dao = new Contract();
        ThreadConnection.beginTransaction();
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        int okNum = 0;
        List<String> list = new ArrayList<>();
        
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            StringBuilder log = new StringBuilder("未导入信息提示<br/>");
            for (int i = 1; i < countRow+1; i++) {
            	 // 创建一个行对象,并从第二行开始读取
                int contractId = 0,businessType = 0,plateId = 0;
                Date sendingDate = null,contractDate = null;
                Date theDate = null;
                BigDecimal amount = BigDecimal.ZERO;
                SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
                int errorNum = 0;
                
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                        case 1:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	contractId = BaseHelpUtils.getIntValue(cell.toString().trim());
                            break;
                        case 2:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	businessType = BaseHelpUtils.getIntValue(cell.toString().trim());
                        	break;
                        case 3: 
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	plateId = BaseHelpUtils.getIntValue(cell.toString().trim());
                        	break;
                        case 7:
                        	cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	                    	theDate = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
	                    	sendingDate = sdf.parse(sdf.format(theDate));  
                        	break;
                        case 8:
                        	cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	                    	theDate = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
	                    	contractDate = sdf.parse(sdf.format(theDate));
                        	break;
                        case 9:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	amount = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                        	break;
                        default:
                            break;
                        }
                    }
                }
                //用于计算提成的map
                Map<String, Object> params = new HashMap<>();
                //用于保存提成的list
                Map<String, Object> saveList = new HashMap<>();
                //details的list
                List<BaseContractDistribution> blist = new ArrayList<>();
                BaseContractDistribution bbean = new BaseContractDistribution();
                //根据人员姓名和编号查询
                dao.clear();
                dao.setContractId(contractId);
                if(dao.load()){
                	dao.setBusinessType(businessType+"");
                	dao.setContractSigningStatus(2);//已签订
                	dao.setSendingDate(sendingDate);
                	dao.setContractDate(contractDate);
                	dao.update();
                	okNum++;
                	params.put("optType", "calculateAmount");
        			params.put("plateId", plateId);
        			params.put("contractId", contractId);
        			params.put("businessType", businessType);
        			params.put("signMoney", dao.getSigningMoneySum());
        			//计算提成
        			ContractDistributionProcessor c = new ContractDistributionProcessor();
//        			list.add(contractId+"-"+c.calculateAmount(params));
        			//保存提成
        			if(amount.compareTo(BigDecimal.ZERO) != 0){
        				String str = "{\"details\":[ {\"contractId\":"+contractId+",\"businessType\":"+businessType+",\"plateId\":"+plateId+",\"amount\":\""+amount+"\",\"operator\":0} ], \"optType\":\"saveContractDistribution\", \"contractId\":\""+contractId+"\", \"businessType\":\""+businessType+"\", \"operator\":\"0\" }";
        				c.execute(str, null);
        			}
                }
                if (errorNum > 0) {
                	log.append("<br/>总共：").append(errorNum).append("份合同没有导入").append("<br/>原因：根据合同编号没有匹配合同");
                }
            }
//            for(String obj : list){
//    			System.out.println(obj.split("-")[0]);
//    		}
//    		System.out.println("**********************************************************************");
//    		for(String obj : list){
//    			System.out.println(obj.split("-")[1]);
//    		}
    		System.out.print(log.toString());
    		System.out.println("---------------------------------成功导入合同数："+okNum);
        }
        ThreadConnection.commit();
    }
    
    //生成员工每日归属部门  
    public static void generateEmpDayPlate() throws SQLException{
    	EmployeeDayPlateRecord pdao = new EmployeeDayPlateRecord();
    	BaseEmployeeDayPlateRecord bean = null;
    	Employee dao = new Employee();
    	Object[] aa = {1,2,4};//试用期，正式员工，离职员工
    	dao.addCondition(BaseEmployee.CS_ONBOARD_STATUS, "in", aa);
    	List<BaseEmployee> ebean = dao.conditionalLoad();
    	int year = 2017;
    	if(!BaseHelpUtils.isNullOrEmpty(ebean)){
    		for(BaseEmployee e : ebean){
    			Date onboardDate = e.getOnboardDate();
    			if(!BaseHelpUtils.isNullOrEmpty(onboardDate)){
    				Date resignationDate = e.getResignationDate();
    				int status = e.getStatus(); 
    				int onboardYear = onboardDate.getYear()+1900;
    				int employeeId = e.getEmployeeId();
    				if(onboardYear == 2017){
    					if(BaseHelpUtils.isNullOrEmpty(resignationDate) && status == 0){//如果离职日期为空，则部门记录生成到今天
    						for(Date date = onboardDate;date.before(new Date());date = DateUtil.getNextDayOfDay(date, 1)){
    							int month = date.getMonth()+1;
    							pdao.clear();
    							pdao.setConditionEmployeeId("=",employeeId);
    							pdao.setConditionRecordDate("=", date);
    							bean = pdao.executeQueryOneRow();
    							if(!BaseHelpUtils.isNullOrEmpty(bean)){
    								continue;
    							}else{
    								bean = new BaseEmployeeDayPlateRecord();
    								bean.setEmployeeId(employeeId);
    								bean.setEmployeeNo(e.getEmployeeNo());
    								bean.setEmployeeName(e.getEmployeeName());
    								bean.setCompanyId(e.getCompanyId());
    								bean.setPlateId(e.getPlateId());
    								bean.setDepartmentId(e.getDepartmentId());
    								bean.setRecordDate(date);
    								bean.setYear(year);
    								bean.setMonth(month);
    								pdao.clear();
    								pdao.setDataFromBase(bean);
    								pdao.save();
    							}
    						}
    					}else if(!BaseHelpUtils.isNullOrEmpty(resignationDate) && status == 1){
    						for(Date date = onboardDate;date.before(resignationDate);date = DateUtil.getNextDayOfDay(date, 1)){
    							int month = date.getMonth()+1;
    							pdao.clear();
    							pdao.setConditionEmployeeId("=",employeeId);
    							pdao.setConditionRecordDate("=", date);
    							bean = pdao.executeQueryOneRow();
    							if(!BaseHelpUtils.isNullOrEmpty(bean)){
    								continue;
    							}else{
    								bean = new BaseEmployeeDayPlateRecord();
    								bean.setEmployeeId(employeeId);
    								bean.setEmployeeNo(e.getEmployeeNo());
    								bean.setEmployeeName(e.getEmployeeName());
    								bean.setCompanyId(e.getCompanyId());
    								bean.setPlateId(e.getPlateId());
    								bean.setDepartmentId(e.getDepartmentId());
    								bean.setRecordDate(date);
    								bean.setYear(year);
    								bean.setMonth(month);
    								pdao.clear();
    								pdao.setDataFromBase(bean);
    								pdao.save();
    							}
    						}
    					}
    				}else if(onboardYear != 2017){
    					if(BaseHelpUtils.isNullOrEmpty(resignationDate) && status == 0){//如果离职日期为空，则部门记录生成到今天
    						for(Date date = DateUtil.getDateOfString("2017-1-1");date.before(new Date());date = DateUtil.getNextDayOfDay(date, 1)){
    							int month = date.getMonth()+1;
    							pdao.clear();
    							pdao.setConditionEmployeeId("=",employeeId);
    							pdao.setConditionRecordDate("=", date);
    							bean = pdao.executeQueryOneRow();
    							if(!BaseHelpUtils.isNullOrEmpty(bean)){
    								continue;
    							}else{
    								bean = new BaseEmployeeDayPlateRecord();
    								bean.setEmployeeId(employeeId);
    								bean.setEmployeeNo(e.getEmployeeNo());
    								bean.setEmployeeName(e.getEmployeeName());
    								bean.setCompanyId(e.getCompanyId());
    								bean.setPlateId(e.getPlateId());
    								bean.setDepartmentId(e.getDepartmentId());
    								bean.setRecordDate(date);
    								bean.setYear(year);
    								bean.setMonth(month);
    								pdao.clear();
    								pdao.setDataFromBase(bean);
    								pdao.save();
    							}
    						}
    					}else if(!BaseHelpUtils.isNullOrEmpty(resignationDate) && status == 1){
    						for(Date date = DateUtil.getDateOfString("2017-1-1");date.before(resignationDate);date = DateUtil.getNextDayOfDay(date, 1)){
    							int month = date.getMonth()+1;
    							pdao.clear();
    							pdao.setConditionEmployeeId("=",employeeId);
    							pdao.setConditionRecordDate("=", date);
    							bean = pdao.executeQueryOneRow();
    							if(!BaseHelpUtils.isNullOrEmpty(bean)){
    								continue;
    							}else{
    								bean = new BaseEmployeeDayPlateRecord();
    								bean.setEmployeeId(employeeId);
    								bean.setEmployeeNo(e.getEmployeeNo());
    								bean.setEmployeeName(e.getEmployeeName());
    								bean.setCompanyId(e.getCompanyId());
    								bean.setPlateId(e.getPlateId());
    								bean.setDepartmentId(e.getDepartmentId());
    								bean.setRecordDate(date);
    								bean.setYear(year);
    								bean.setMonth(month);
    								pdao.clear();
    								pdao.setDataFromBase(bean);
    								pdao.save();
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    }
    
    /**
     * 更新订单归属业务部门
     * @throws Exception
     */
    public static void onUpdateProjectPlate() throws Exception {
    	File file = new File("C:/Users/Administrator/Desktop/updatePlate.xlsx");
        Project dao = new Project();
        ThreadConnection.beginTransaction();
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            StringBuilder log = new StringBuilder("未检索到订单信息提示<br/>");
            for (int i = 1; i < countRow+1; i++) {
            	 // 创建一个行对象,并从第二行开始读取
                String sheetCode = null,plateName = null;
                int errorNum = 0;
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                        case 0:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	sheetCode = BaseHelpUtils.getString(cell.toString().trim());
                            break;
                        case 1:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                            plateName = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        default:
                            break;
                        }
                    }
                }
                if (BaseHelpUtils.isNullOrEmpty(sheetCode) || BaseHelpUtils.isNullOrEmpty(plateName)) {
                    break;
                }
                //根据人员姓名和编号查询
                dao.clear();
                dao.setConditionContractCode("=",sheetCode);
                int empNum = dao.countRows();
                if(empNum == 0){
                	errorNum++;
                	log.append(String.format("第%1$d行数据异常, 订单编号:%2$s不符<br/>", i+1,sheetCode));
                	continue;
                }else if(empNum == 1){
                	dao.setPlateId(53);
                	dao.setRevenuePlateId(53);
//                	if(plateName.equals("深圳酒店部")){
//                	}else if(plateName.equals("上海酒店部")){
//                		dao.setPlateId(46);
//                		dao.setRevenuePlateId(46);
//                	}else if(plateName.equals("武汉酒店部")){
//                		dao.setPlateId(47);
//                		dao.setRevenuePlateId(47);
//                	}
                	dao.conditionalUpdate();
                }else if(empNum > 1){
                	log.append(String.format("第%1$d行订单编号(%2$s)重复<br/>", i+1,sheetCode));
                	continue;
                }
                if (errorNum > 0) {
                	log.append("<br/>总共：").append(errorNum).append("个订单没有更新").append("<br/>原因：订单编号不匹配");
                }
                System.out.print(log.toString());
            }
        }
        ThreadConnection.commit();
    }
    
    /**
     * 更新人员归属板块
     * @throws Exception
     */
    public static void onUpdateEmpPlate() throws Exception {
    	File file = new File("C:/Users/Administrator/Desktop/updateEmpPlate.xlsx");
        Employee dao = new Employee();
        EmployeeDayPlateRecord dayDao = new EmployeeDayPlateRecord();
        EmployeeChangePlateRecord monthDao = new EmployeeChangePlateRecord();
        EmployeeChangePlateDetail detailDao = new EmployeeChangePlateDetail();
        Department depDao = new Department();
        PlateRecord plateDao = new PlateRecord();
        ThreadConnection.beginTransaction();
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        String empCode = "";
        Date date = new Date();
        date.setMonth(0);
        date.setDate(1);
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            StringBuilder log = new StringBuilder("未检索到订单信息提示<br/>");
            for (int i = 1; i < countRow+1; i++) {
            	 // 创建一个行对象,并从第二行开始读取
                String employeeNo = null,plateName = null;
                int errorNum = 0;
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                        case 0:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	employeeNo = BaseHelpUtils.getString(cell.toString().trim());
                            break;
                        case 1:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                            plateName = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        default:
                            break;
                        }
                    }
                }
                if (BaseHelpUtils.isNullOrEmpty(employeeNo) || BaseHelpUtils.isNullOrEmpty(plateName)) {
                    break;
                }
                //根据人员姓名和编号查询
                dao.clear();
                dao.setConditionEmployeeNo("=",employeeNo);
                dayDao.clear();
                monthDao.clear();
                int empNum = dao.countRows();
                if(empNum == 0){
                	errorNum++;
                	log.append(String.format("第%1$d行数据异常, 职员编号:%2$s不符<br/>", i+1,employeeNo));
                	continue;
                }else if(empNum == 1){
                	BaseEmployee bean = dao.executeQueryOneRow();
                	int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
//                	detailDao.clear();
//                	detailDao.setConditionEmployeeId("=",employeeId);
//                	if(detailDao.countRows() > 0){
//                		if(!BaseHelpUtils.isNullOrEmpty(empCode)){
//                			empCode += ",";
//                		}
//                		empCode += employeeNo;
//                		continue;
//                	}
                	depDao.clear();
                	depDao.setConditionDepartmentName("=",plateName);
                	BaseDepartment depBean = depDao.executeQueryOneRow();
                	plateDao.clear();
                	plateDao.setConditionPlateName("=",plateName);
                	BasePlateRecord plateBean = plateDao.executeQueryOneRow();
                	if(BaseHelpUtils.isNullOrEmpty(depBean) || BaseHelpUtils.isNullOrEmpty(plateBean)){
                		if(!BaseHelpUtils.isNullOrEmpty(empCode)){
                			empCode += ",";
                		}
                		empCode += employeeNo;
                		continue;
                	}
                	dayDao.setConditionEmployeeId("=",employeeId);
                	dayDao.setConditionRecordDate(">=",date);
                	monthDao.setConditionEmployeeId("=",employeeId);
                	monthDao.setConditionYear("=", 2018);
                	monthDao.setConditionMonth(">=",1);
                	dao.setPlateId(plateBean.getPlateId());
                	dao.setDepartmentId(depBean.getDepartmentId());
                	dayDao.setPlateId(plateBean.getPlateId());
                	dayDao.setDepartmentId(depBean.getDepartmentId());
                	monthDao.setPlateId(plateBean.getPlateId());
                	monthDao.setDepartmentId(depBean.getDepartmentId());
                	dao.update();
                	dayDao.conditionalUpdate();
                	monthDao.conditionalUpdate();
                	UserAccountUtils.updateUserAccount(dao.generateBase(), 1);
                }else if(empNum > 1){
                	log.append(String.format("第%1$d行订单编号(%2$s)重复<br/>", i+1,employeeNo));
                	continue;
                }
                if (errorNum > 0) {
                	log.append("<br/>总共：").append(errorNum).append("人没有更新").append("<br/>原因：订单编号不匹配");
                }
                System.out.print(log.toString());
                System.out.print("未处理人员："+empCode);
            }
        }
        ThreadConnection.commit();
    }
    
    public static void onExportCustomerInfo() throws SQLException, InvalidFormatException, FileNotFoundException, IOException{
    	File file = new File("C:/Users/Administrator/Desktop/onCustomerInfo.xlsx");
        Customer dao = new Customer();
        BaseCustomer bean = null;
        ThreadConnection.beginTransaction();
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        String empCode = "";
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            StringBuilder log = new StringBuilder("未检索到客户信息提示<br/>");
            for (int i = 1; i < countRow+1; i++) {
            	 // 创建一个行对象,并从第二行开始读取
                String parentCustomerName = null,childCustomerName = null;
                int customerLevel = 0;
                int errorNum = 0;
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                        case 0:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	parentCustomerName = BaseHelpUtils.getString(cell.toString().trim());
                            break;
                        case 1:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	childCustomerName = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 2:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	customerLevel = BaseHelpUtils.getIntValue(cell.toString().trim());
                        	break;
                        default:
                            break;
                        }
                    }
                }
                if (BaseHelpUtils.isNullOrEmpty(parentCustomerName)) {
                    break;
                }
                dao.clear();
                //根据父级集团名称去查询，如果不存在，则保存
                dao.setConditionCustomerName("=",parentCustomerName);
                int empNum = dao.countRows();
                int customerId = 0;
                int customerType = 2;
                if(empNum == 0){//说明没有保存
                	bean = new BaseCustomer();
                	bean.setCustomerName(parentCustomerName);
                	bean.setCustomerType(customerType);
                	if(customerLevel > 0){
                		bean.setCustomerLevel(customerLevel);
                	}
                	dao.setDataFromBase(bean);
                	dao.save();
                	customerId = dao.getCustomerId();
                }else if(empNum == 1){
                	bean = dao.executeQueryOneRow();
                	customerId = bean.getCustomerId();
                }else if(empNum > 1){
                	errorNum++;
                	log.append(String.format("第%1$d行客户名称(%2$s)重复<br/>", i+1,parentCustomerName));
                	continue;
                }
                if(customerId > 0){
                	if(!BaseHelpUtils.isNullOrEmpty(childCustomerName)){
                		dao.clear();
                		dao.setConditionCustomerName("=",childCustomerName);
                		if(!dao.isExist()){
                			bean = new BaseCustomer();
                			bean.setCustomerName(childCustomerName);
                			bean.setParentId(customerId);
                			bean.setCustomerType(customerType);
                			if(customerLevel > 0){
                        		bean.setCustomerLevel(customerLevel);
                        	}
                			dao.setDataFromBase(bean);
                			dao.save();
                		}else{
                			bean = dao.executeQueryOneRow();
                			bean.setParentId(customerId);
                			bean.setCustomerType(customerType);
                			if(customerLevel > 0){
                        		bean.setCustomerLevel(customerLevel);
                        	}
                			dao.setDataFromBase(bean);
                			dao.update();
                		}
                	}
                }
                if (errorNum > 0) {
                	log.append("<br/>总共：").append(errorNum).append("人没有更新").append("<br/>原因：订单编号不匹配");
                }
                System.out.print(log.toString());
                System.out.print("未处理人员："+empCode);
            }
        }
        ThreadConnection.commit();
    }
    
    
    public static void onExportDeductMoney() throws SQLException, InvalidFormatException, FileNotFoundException, IOException{
    	File file = new File("C:/Users/Administrator/Desktop/onDeductData.xlsx");
        Employee dao = new Employee();
        BaseEmployee bean = null;
        PlateRecord pDao = new PlateRecord();
        BasePlateRecord pBean = null;
        ProjectManagePerformanceRecord pmfrDao = new ProjectManagePerformanceRecord();
        ThreadConnection.beginTransaction();
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        String remark = "2018年3月份项目绩效扣款线下统计，手动导入";
        String businessName = "2018年3月份项目绩效扣款";
        Date currentDate = new Date();
        int totalBusinessId = 2;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            StringBuilder log = new StringBuilder("未检索到信息提示<br/>");
            for (int i = 1; i < countRow+1; i++) {
            	 // 创建一个行对象,并从第二行开始读取
                String code = null,objName = null;
                BigDecimal deductMoney = BigDecimal.ZERO;
                int objType = 0;
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                        case 0:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	objType = BaseHelpUtils.getIntValue(cell.toString().trim());
                            break;
                        case 1:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	code = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 2:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	objName = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 3:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	deductMoney = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                        	break;
                        default:
                            break;
                        }
                    }
                }
                if (objType == 0 || deductMoney.compareTo(BigDecimal.ZERO) == 0) {
                    break;
                }
                if(objType == 1){//扣人员
                	dao.clear();
                	dao.setConditionEmployeeNo("=",code);
                	dao.setConditionEmployeeName("=",objName);
                	if(dao.countRows() == 1){
                		bean = dao.executeQueryOneRow();
                		//获取职员Id
                		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
                		//插入明细表数据
                		pmfrDao.clear();
        				pmfrDao.setProjectManagePerformanceTotalId(totalBusinessId);
        				pmfrDao.setObjectId(employeeId);
        				pmfrDao.setObjectNo(code);
        				pmfrDao.setObjectName(objName);
        				pmfrDao.setObjectType(1);//1：人员；2：部门
        				pmfrDao.setPerformanceMoney(deductMoney);
        				pmfrDao.setPerformanceStatus(1);//1：扣款；2：回款
        				pmfrDao.setBusinessType(3);
        				pmfrDao.setBusinessName(businessName);
        				pmfrDao.setRecordDate(currentDate);
        				pmfrDao.setRecordTime(currentDate);
        				pmfrDao.setRemark(remark);
        				pmfrDao.save();
        				int businessId = pmfrDao.getProjectManagePerformanceRecordId();
        				//插入个人账户
        				AccountManageProcess.onSaveEmployeeAccount(employeeId, businessId,AccountManageProcess.EMP_BT_PROJECT_PERFORMANCE_PAY,deductMoney, currentDate, remark, -1);
                	}else{
                		log.append(String.format("<br/>人员扣除异常：编号(%1$s),姓名:(%2$s)",code,objName));
                	}
                }else if(objType == 2){//扣部门
                	pDao.clear();
                	pDao.setConditionPlateName("=",objName);
                	if(pDao.countRows() == 1){
                		pBean = pDao.executeQueryOneRow();
                		int plateId = BaseHelpUtils.getIntValue(pBean.getPlateId());
                		pmfrDao.clear();
    					pmfrDao.setProjectManagePerformanceTotalId(totalBusinessId);
    					pmfrDao.setObjectId(plateId);
    					pmfrDao.setObjectNo(pBean.getPlateCode());
    					pmfrDao.setObjectName(objName);
    					pmfrDao.setObjectType(2);//1：人员；2：部门
    					pmfrDao.setPerformanceMoney(deductMoney);
    					pmfrDao.setPerformanceStatus(1);//1：扣款；2：回款
    					pmfrDao.setBusinessType(3);
    					pmfrDao.setBusinessName(businessName);
    					pmfrDao.setRecordDate(currentDate);
    					pmfrDao.setRecordTime(currentDate);
    					pmfrDao.setRemark(remark);
    					pmfrDao.save();
    					int businessId = pmfrDao.getProjectManagePerformanceRecordId();
    					//插入部门账户
    					AccountManageProcess.onSavePlateAccount(plateId, businessId,AccountManageProcess.PLATE_BT_PROJECT_PERFORMANCE_PAY,deductMoney,currentDate, remark, -1);
                	}else{
                		log.append(String.format("<br/>部门扣除异常：名称(%1$s)",objName));
                	}
                }
                System.out.print(log.toString());
//                BigDecimal totalDeduct = new BigDecimal("5000");
                //插入品质基金账户
//                AccountManageProcess.onSaveOrUpdateAccount(AccountManageProcess.ACCOUNT_QUALITY_ACCOUNT,0, totalBusinessId, AccountManageProcess.project_performance_achieve,totalDeduct,remark,-1);
    			
            }
        }
        ThreadConnection.commit();
    }
    
    
    /**
     * 更新霍普离职员工状态
     * @throws SQLException
     * @throws InvalidFormatException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void onHpUpdateEmployeeStatus() throws SQLException, InvalidFormatException, FileNotFoundException, IOException{
    	File file = new File("C:/Users/Administrator/Desktop/onUpdateEmpStatus.xlsx");
        Employee dao = new Employee();
        ThreadConnection.beginTransaction();
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            StringBuilder log = new StringBuilder("未检索到信息提示<br/>");
            for (int i = 1; i < countRow+1; i++) {
            	 // 创建一个行对象,并从第二行开始读取
                String employeeName = null,employeeNo = null;
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                        case 0:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	employeeName = BaseHelpUtils.getString(cell.toString().trim());
                            break;
                        case 1:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	employeeNo = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        default:
                            break;
                        }
                    }
                }
                if(!BaseHelpUtils.isNullOrEmpty(employeeName) && !BaseHelpUtils.isNullOrEmpty(employeeNo)){
                	dao.clear();
                	dao.setConditionEmployeeName("=",employeeName);
                	dao.setConditionEmployeeNo("=",employeeNo);
                	int num = dao.countRows();
                	if(num == 0){
                		log.append(String.format("职员%1$s(%2$s)未加载到信息<br/>",employeeName,employeeNo));
                	}else if(num > 1){
                		log.append(String.format("职员%1$s(%2$s)加载多条信息<br/>",employeeName,employeeNo));
                	}else{
                		dao.setStatus(1);
                		dao.conditionalUpdate();
                	}
                }
                System.out.print(log.toString());
            }
        }
        ThreadConnection.commit();
    }
    
    /**
     * 更新霍普的员工编号和密码
     * @throws SQLException
     * @throws InvalidFormatException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void onHpUpdateEmpNoAndPwd() throws SQLException, InvalidFormatException, FileNotFoundException, IOException{
    	File file = new File("C:/Users/Administrator/Desktop/onUpdateEmpNo.xlsx");
        Employee dao = new Employee();
        ThreadConnection.beginTransaction();
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            StringBuilder log = new StringBuilder("未检索到信息提示<br/>");
            for (int i = 1; i < countRow+1; i++) {
            	 // 创建一个行对象,并从第二行开始读取
                String employeeName = null,employeeNo = null;
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                        case 0:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	employeeName = BaseHelpUtils.getString(cell.toString().trim());
                            break;
                        case 1:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	employeeNo = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        default:
                            break;
                        }
                    }
                }
                if(!BaseHelpUtils.isNullOrEmpty(employeeName) && !BaseHelpUtils.isNullOrEmpty(employeeNo)){
                	dao.clear();
                	dao.setConditionEmployeeName("=",employeeName);
                	int num = dao.countRows();
                	if(num == 0){
                		log.append(String.format("职员%1$s未加载到信息<br/>",employeeName));
                	}else if(num > 1){
                		log.append(String.format("职员%1$s加载多条信息<br/>",employeeName));
                	}else{
                		dao.setEmployeeNo(employeeNo);
                		dao.setEmployeePassword(DES.string2MD5(employeeNo));
                		dao.conditionalUpdate();
                	}
                }
                System.out.print(log.toString());
            }
        }
        ThreadConnection.commit();
    }
    
    
    public static void onHpUpdateFillTax() throws SQLException, InvalidFormatException, FileNotFoundException, IOException{
    	File file = new File("C:/Users/Administrator/Desktop/onUpdateFillTax.xlsx");
        Employee dao = new Employee();
        BaseEmployee bean = null;
        BaseSalaryFillSendDeduct sBean = null;
        SalaryFillSendDeduct sDao = new SalaryFillSendDeduct();
        ThreadConnection.beginTransaction();
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        Calendar ca = Calendar.getInstance();
        ca.set(2018,4,1);
        //初始化行数
        int countRow;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            StringBuilder log = new StringBuilder("未检索到信息提示<br/>");
            for (int i = 1; i < countRow+1; i++) {
            	 // 创建一个行对象,并从第二行开始读取
                String employeeName = null,employeeNo = null,remark = null;
                BigDecimal fillTax = BigDecimal.ZERO;
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                        case 0:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	employeeName = BaseHelpUtils.getString(cell.toString().trim());
                            break;
                        case 1:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	employeeNo = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 2:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	fillTax = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                        	break;
                        case 3:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	remark = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        default:
                            break;
                        }
                    }
                }
                if(!BaseHelpUtils.isNullOrEmpty(employeeName) && !BaseHelpUtils.isNullOrEmpty(employeeNo)){
                	dao.clear();
                	dao.setConditionEmployeeName("=",employeeName);
                	dao.setConditionEmployeeNo("=",employeeNo);
                	int num = dao.countRows();
                	if(num == 0){
                		log.append(String.format("职员%1$s未加载到信息<br/>",employeeName));
                	}else if(num > 1){
                		log.append(String.format("职员%1$s加载多条信息<br/>",employeeName));
                	}else{
                		bean = dao.executeQueryOneRow();
                		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
                		if(employeeId > 0){
                			sDao.clear();
                			sDao.setConditionYear("=",2018);
                			sDao.setConditionMonth("=",5);
                			sDao.setConditionEmployeeId("=",employeeId);
                			if(sDao.isExist()){
                				sDao.setFillTax(fillTax+"");
                				sDao.setTotalAmount(fillTax+"");
                				sDao.setRemark(remark);
                				sDao.conditionalUpdate();
                			}else{
                				sBean = new BaseSalaryFillSendDeduct();
                				sBean.setEmployeeId(employeeId);
                				sBean.setYear(2018);
                				sBean.setMonth(5);
                				sBean.setRecordDate(ca.getTime());
                				sBean.setOperateEmployeeId(0);
                				sBean.setOperateTime(new Date());
                				sBean.setFillTax(fillTax+"");
                				sBean.setRemark(remark);
                				sBean.setTotalAmount(fillTax+"");
                				sDao.clear();
                				sDao.setDataFromBase(sBean);
                				sDao.save();
                			}
                		}
                	}
                }
                System.out.print(log.toString());
            }
        }
        ThreadConnection.commit();
    }
    
    /**
     * 
     * @throws SQLException
     * @throws ParseException
     */
    public static void onDuductDayOfPlate() throws SQLException, ParseException {
    	ThreadConnection.beginTransaction();
    	Employee edao = new Employee();
    	edao.setConditionEmployeeId("=", 2373);
    	List<BaseEmployee> list = edao.conditionalLoad();
    	if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0) {
    		EmployeeDayPlateRecord dao = new EmployeeDayPlateRecord();
    		BaseEmployeeDayPlateRecord bean = null;
    		for(BaseEmployee e : list) {
    			//获取入职日期
    			Date onboardDate = e.getOnboardDate();
    			if(!BaseHelpUtils.isNullOrEmpty(onboardDate)) {
    				int employeeId = BaseHelpUtils.getIntValue(e.getEmployeeId());
    				Date startDate = onboardDate;
    				Date endDate = null;
    				Date rg = e.getResignationDate();
    				if(!BaseHelpUtils.isNullOrEmpty(rg)) {
    					endDate = rg;
    				}else {
    					endDate = new Date();
    				}
    				for(Date recordDate = startDate; recordDate.compareTo(endDate) <= 0; recordDate = DateUtil.getNextDayOfDay(recordDate, 1)) {
    					int year = DateUtil.getYear(recordDate);
    					int month = DateUtil.getMonth(recordDate);
    					dao.clear();
    					dao.setConditionEmployeeId("=",employeeId);
    					dao.setConditionRecordDate("=",recordDate);
    					if(dao.isExist()) {
    						continue;
    					}else {
    						bean = new BaseEmployeeDayPlateRecord();
    						bean.setYear(year);
    						bean.setMonth(month);
    						bean.setRecordDate(recordDate);
    						bean.setEmployeeId(employeeId);
    						bean.setPlateId(e.getPlateId());
    						bean.setDepartmentId(e.getDepartmentId());
    						bean.setCompanyId(e.getCompanyId());
    						bean.setEmployeeNo(e.getEmployeeNo());
    						bean.setEmployeeName(e.getEmployeeName());
    						dao.clear();
    						dao.setDataFromBase(bean);
    						dao.save();
    					}
    				}
    			}
    		}
    	}
    	
    	ThreadConnection.commit();
    }
    
    
    public static void onExportPreProjectCost() throws SQLException, InvalidFormatException, FileNotFoundException, IOException{
    	File file = new File("C:/Users/Administrator/Desktop/onPreProjectCost.xlsx");
    	PlateCostRecord costDao = new PlateCostRecord();
    	PlateAccountRecord accountDao = new PlateAccountRecord();
    	ProjectNormalReimbursement npDao = new ProjectNormalReimbursement();
    	TravelReimbursement tpDao = new TravelReimbursement();
    	SystemProcessInstance insDao = new SystemProcessInstance();
    	PlateRecord prDao = new PlateRecord();
        ThreadConnection.beginTransaction();
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);
            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            StringBuilder log = new StringBuilder("异常信息提示<br/>");
            BigDecimal totalAmount = BigDecimal.ZERO;
            for (int i = 1; i < countRow+1; i++) {
            	 // 创建一个行对象,并从第二行开始读取
                String typeName = null,code = null,plateName = null;
                BigDecimal amount = BigDecimal.ZERO;
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                        case 0:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	typeName = BaseHelpUtils.getString(cell.toString().trim());
                            break;
                        case 1:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	code = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 2:
                        	cell.setCellType(Cell.CELL_TYPE_STRING);
                        	plateName = BaseHelpUtils.getString(cell.toString().trim());
                        	break;
                        case 3:
                        	cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                        	amount = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                        	amount = amount.setScale(2,BigDecimal.ROUND_DOWN);
                        	break;
                        default:
                            break;
                        }
                    }
                }
                totalAmount = totalAmount.add(amount);
                if(!BaseHelpUtils.isNullOrEmpty(typeName) && !BaseHelpUtils.isNullOrEmpty(code) && !BaseHelpUtils.isNullOrEmpty(plateName) && amount.compareTo(BigDecimal.ZERO) > 0){
                	int projectBusinessId = 0;
                	int processType = 0;
                	String remark = "";
                	int employeeId = -1;
                	if(typeName.equals("前期项目差旅报销")) {
                		tpDao.clear();
                		tpDao.setConditionCode("=",code);
                		BaseTravelReimbursement tpBean = tpDao.executeQueryOneRow();
                		if(BaseHelpUtils.isNullOrEmpty(tpBean)) {
                			log.append(String.format("报销编号(%1$s)未加载到信息</br>",code));
                			continue;
                		}
                		//获取业务id
                		projectBusinessId = BaseHelpUtils.getIntValue(tpBean.getTravelReimbursementId());
                		processType = 9;
                		remark = BaseHelpUtils.getString(tpBean.getRemark());
                		employeeId = BaseHelpUtils.getIntValue(tpBean.getApplicant());
                	}else if(typeName.equals("前期项目日常报销")) {
                		npDao.clear();
                		npDao.setConditionCode("=",code);
                		BaseProjectNormalReimbursement npBean = npDao.executeQueryOneRow();
                		if(BaseHelpUtils.isNullOrEmpty(npBean)) {
                			log.append(String.format("报销编号(%1$s)未加载到信息</br>",code));
                			continue;
                		}
                		//获取业务id
                		projectBusinessId = BaseHelpUtils.getIntValue(npBean.getProjectNormalReimbursementId());
                		processType = 8;
                		remark = BaseHelpUtils.getString(npBean.getRemark());
                		employeeId = BaseHelpUtils.getIntValue(npBean.getEmployeeId());
                	}
                	
                	//获取processInstanceId
            		insDao.clear();
            		insDao.setConditionBusinessId("=",projectBusinessId);
            		insDao.setConditionProcessType("=",processType);
            		BaseSystemProcessInstance insBean = insDao.executeQueryOneRow();
            		if(BaseHelpUtils.isNullOrEmpty(insBean)) {
            			log.append(String.format("报销编号(%1$s)未加载到流程信息</br>",code));
            			continue;
            		}
            		int processInstanceId = BaseHelpUtils.getIntValue(insBean.getProcessInstanceId());
            		//获取流程完成时间
            		Date finishTime = insBean.getCompleteTime();
            		if(BaseHelpUtils.isNullOrEmpty(finishTime)) {
            			log.append(String.format("报销编号(%1$s)完成时间为空</br>",code));
            			continue;
            		}
            		//获取processId
            		int processId = BaseHelpUtils.getIntValue(insBean.getProcessId());
            		//检索成本业务表中是否存在
            		costDao.clear();
            		costDao.setConditionProcessInstanceId("=",processInstanceId);
            		costDao.setConditionProcessId("=",processId);
            		costDao.setConditionProcessType("=",processType);
            		costDao.setConditionBusinessId("=",projectBusinessId);
            		costDao.setConditionCostIntegral("=",amount);
            		if(costDao.isExist()) {
            			log.append(String.format("报销编号(%1$s)在成本业务表中已存在</br>",code));
            			continue;
            		}
            		//获取业务部门id
            		prDao.clear();
            		prDao.setConditionPlateName("=",plateName);
            		BasePlateRecord prBean = prDao.executeQueryOneRow();
            		if(BaseHelpUtils.isNullOrEmpty(prBean)) {
            			log.append(String.format("报销编号(%1$s)未加载到业务部门信息</br>",code));
            			continue;
            		}
            		int plateId = BaseHelpUtils.getIntValue(prBean.getPlateId());
            		//获取年份和月份
            		int year = DateUtil.getYear(finishTime);
            		int month = DateUtil.getMonth(finishTime);
            		costDao.clear();
            		costDao.setPlateId(plateId);
            		costDao.setCostIntegral(amount.setScale(2, BigDecimal.ROUND_DOWN));
            		costDao.setSalaryIntegral(new BigDecimal("0"));
            		costDao.setIsSettlement(false);
					//获取当前的年月
            		costDao.setYear(year);
            		costDao.setMonth(month);
            		costDao.setCostDate(finishTime);
            		costDao.setProcessType(processType);
            		costDao.setBusinessId(projectBusinessId);
            		costDao.setProcessId(processId);
            		costDao.setProcessInstanceId(processInstanceId);
            		costDao.setRemark(remark);
            		costDao.save();
					//同时更新数据到部门积分汇总表中
            		accountDao.clear();
            		accountDao.setBusinessTypeId(AccountManageProcess.PLATE_BT_PLATE_COST);
            		accountDao.setBusinessId(costDao.getPlateCostRecordId());
            		accountDao.setPlateId(plateId);
            		accountDao.setIntegral(amount);
            		accountDao.setRecordDate(finishTime);
            		accountDao.setOperateEmployeeId(employeeId);
            		accountDao.setOperateTime(finishTime);
            		accountDao.setRemark(remark);
            		accountDao.save();
            		
                }
                System.out.print(log.toString());
            }
        }
        ThreadConnection.commit();
    }
    
    //日薪推送
    public static String onSendEmpDayPayment() throws SQLException, ParseException{
    	String ids = "1152,1638,2316,355,1613,1762,98,1847,74,1971,2425";
//    	String ids = "1638";
    	String[] idArr = ids.split(",");
    	EmployeePaymentDetail dao = new EmployeePaymentDetail();
    	EmployeeAccountRecord aDao = new EmployeeAccountRecord();
    	ThreadConnection.beginTransaction();
    	for(String id : idArr) {
    		int employeeId = BaseHelpUtils.getIntValue(id);
    		//推送个人,将日薪表中的数据进行加锁
    		if(employeeId > 0){
    			dao.setConditionEmployeeId("=", employeeId);
    			List<BaseEmployeePaymentDetail> list = dao.conditionalLoad("order by detail_date");
    			if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
    				Map<String,String> monthMap = new HashMap<>();
    				for(BaseEmployeePaymentDetail obj : list){//循环查看该员工每天的部门类型，账户插入人工成本
    					Date detailDate = obj.getDetailDate();
    					String dateStr = DateUtil.getChinaDateString(detailDate);
    					System.out.println("dateStr==="+dateStr);
    					//根据日期去账户表中查询，如果已经存在，则不做插入操作
    					aDao.setConditionEmployeeId("=",employeeId);
    					aDao.setConditionRecordDate("=",detailDate);
    					//获取年月份
    					int year = DateUtil.getYear(detailDate);
    					int month = DateUtil.getMonth(detailDate);
    					String str = String.format("%1$s-%2$s", year,month);
    					if(aDao.isExist()) {
    						monthMap.put(str, str);
    						continue;
    					}
    					if(monthMap.containsKey(str)) {
    						continue;
    					}
    					int businessId = obj.getEmployeePaymentDetailId();
    					BigDecimal integral = obj.getDayPay().add(obj.getDayAttendanceDeduction());
    					if(integral.compareTo(BigDecimal.ZERO) == 0) {
    						continue;
    					}
    					String remark = "";
    					remark = String.format("手动导入,人工成本(%1$s)", DateUtil.formatDateString(detailDate));
    						AccountManageProcess.onSaveEmployeeAccount(employeeId,businessId , AccountManageProcess.EMP_BT_EMPLOYEE_COST,integral,detailDate, remark, -1);
    				}
    			}
    			
    		}
    	}
    	
    	
    	ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,"");
    }
    
    //账户有数据，但日归属没有，则添加日归属
    public static String onSetEmpDayPlate() throws SQLException, ParseException{
    	String ids = "1152,1638,2316,355,1613,1762,98,1847,74,1971,2425";
    	EmployeeAccountRecord aDao = new EmployeeAccountRecord();
    	EmployeeDayPlateRecord pDao = new EmployeeDayPlateRecord();
    	Employee eDao = new Employee();
    	List<BaseEmployee> eList = eDao.conditionalLoad("employee_id in("+ids+")");
    	ThreadConnection.beginTransaction();
    	for(BaseEmployee e : eList) {
    		int employeeId = BaseHelpUtils.getIntValue(e.getEmployeeId());
    		aDao.clear();
    		aDao.setConditionEmployeeId("=",employeeId);
    		List<BaseEmployeeAccountRecord> aList = aDao.conditionalLoad();
    		if(!BaseHelpUtils.isNullOrEmpty(aList) && aList.size() > 0) {
    			for(BaseEmployeeAccountRecord a : aList) {
    				//获取日期
    				Date recordDate = a.getRecordDate();
    				pDao.clear();
    				pDao.setConditionEmployeeId("=",employeeId);
    				pDao.setConditionRecordDate("=",recordDate);
    				if(pDao.isExist()) {
    					continue;
    				}
    				//获取年份月份
    				int year = DateUtil.getYear(recordDate);
    				int month = DateUtil.getMonth(recordDate);
    				pDao.setEmployeeId(employeeId);
    				pDao.setRecordDate(recordDate);
    				pDao.setPlateId(e.getPlateId());
    				pDao.setDepartmentId(e.getDepartmentId());
    				pDao.setCompanyId(e.getCompanyId());
    				pDao.setYear(year);
    				pDao.setMonth(month);
    				pDao.setEmployeeName(e.getEmployeeName());
    				pDao.setEmployeeNo(e.getEmployeeNo());
    				pDao.setOnboardStatus(e.getOnboardStatus());
    				pDao.save();
    			}
    		}
    			
    	}
    	
    	
    	ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,"");
    }
    
    public static void onAccount(BigDecimal totalAmount) {
    	BigDecimal startAmount = BigDecimal.ZERO;
    	int totalNum = 10;
    	BigDecimal sumAmount = BigDecimal.ZERO;
    	BigDecimal currentAmount = BigDecimal.ZERO;
    	BigDecimal current = BigDecimal.ZERO;
    	int k = 9;
    	BigDecimal mul = new BigDecimal(1.96);
    	for(int j = 1;j<=totalNum;j++) {
    		for(int i = k;i < 1000;i++) {
    			k++;
    			current = startAmount.add(new BigDecimal(k));
    			currentAmount = BaseHelpUtils.format((startAmount.add(new BigDecimal(k))).multiply(mul), 2);
    			sumAmount = sumAmount.add(current);
    			if(currentAmount.compareTo(sumAmount.add(new BigDecimal(9))) >= 0) {
    				System.out.println("当前投的额度==="+k+";当前赢利==="+currentAmount+";当前纯赢利==="+currentAmount.subtract(sumAmount));
//    				System.out.println("当前赢利==="+currentAmount);
//    				System.out.println("当前纯赢利==="+currentAmount.subtract(sumAmount));
    				break;
    			}else {
    				sumAmount = sumAmount.subtract(current);
    			}
//    			System.out.println("sumAmount==="+sumAmount);
    		}
    		
//    		System.out.println("sumAmount=="+sumAmount);
    		if(sumAmount.compareTo(totalAmount) > 0) {
    			break;
    		}
    	}
    	
    }
    
    /**
     * 更新员工日归属的部门
     * @param totalAmount
     * @throws SQLException 
     */
    public static void onUpdateDepartment() throws SQLException {
    	EmployeeDayPlateRecord dao = new EmployeeDayPlateRecord();
    	dao.setConditionYear("=",2018);
    	dao.setConditionMonth("=",2);
    	List<BaseEmployeeDayPlateRecord> list = dao.conditionalLoad();
    	Department dDao = new Department();
    	for(BaseEmployeeDayPlateRecord e : list) {
    		//获取部门和业务部门
    		int plateId = BaseHelpUtils.getIntValue(e.getPlateId());
    		int departmentId = BaseHelpUtils.getIntValue(e.getDepartmentId());
    		dDao.clear();
    		dDao.setDepartmentId(departmentId);
    		if(dDao.load()) {
    			//获取部门删除标识
    			int deleteFlag = BaseHelpUtils.getIntValue(dDao.getDeleteFlag());
    			if(deleteFlag == 1) {
    				dDao.clear();
    				dDao.setConditionPlateId("=",plateId);
    				dDao.setConditionDeleteFlag("=",0);
    				if(dDao.countRows() == 1) {
    					BaseDepartment dBean = dDao.executeQueryOneRow();
    					int depId = BaseHelpUtils.getIntValue(dBean.getDepartmentId());
    					//获取日归属主键id
    					dao.clear();
    					dao.setDataFromBase(e);;
    					if(!dao.isPrimaryKeyNull()) {
    						dao.setDepartmentId(depId);
    						dao.update();
    					}
    				}
    			}
    		}
    	}
    }
    
    /**
     * 企业微信推送新年祝福语
     * @throws Exception
     */
    public static void onSendWeiXinMsg() throws Exception {
    	String msg = "新年的钟声即将敲响，在这辞旧迎新的美好时刻，感谢您一年以来的辛勤付出，J&A祝您和家人身体健康、阖家幸福、“猪”事顺利！";
    	//加载公司所有在职员工
    	Employee dao = new Employee();
    	dao.unsetSelectFlags();
    	dao.setSelectEmployeeId(true);
    	dao.setConditionEmployeeId(">",0);
    	dao.setConditionStatus("=",0);
    	List<BaseEmployee> list = dao.conditionalLoad();
    	System.out.println(list.size());
    	for(BaseEmployee e : list) {
    		int employeeId = BaseHelpUtils.getIntValue(e.getEmployeeId());
    		//推送微信信息
			ERPWeixinUtils.sendWXMsgToUser(employeeId,msg);
    	}
    }
    
    public static void updateProjectStage() throws SQLException {
    	ProjectStage sDao = new ProjectStage();
    	List<BaseProjectStage> list = sDao.conditionalLoad("contract_id is null and main_project_id > 0");
    	MainProject pDao = new MainProject();
    	Contract cDao = new Contract();
    	for(BaseProjectStage e : list) {
    		int id = BaseHelpUtils.getIntValue(e.getProjectStageId());
    		int mainProjectId = BaseHelpUtils.getIntValue(e.getMainProjectId());
    		pDao.clear();
    		pDao.unsetSelectFlags();
    		pDao.setSelectProjectCode(true);
    		pDao.setMainProjectId(mainProjectId);
    		if(!pDao.load()) {
    			continue;
    		}
    		String projectCode = BaseHelpUtils.getString(pDao.getProjectCode());
    		cDao.clear();
    		cDao.unsetSelectFlags();
    		cDao.setSelectContractId(true);
    		cDao.setConditionProjectCode("=", projectCode);
    		BaseContract cBean = cDao.executeQueryOneRow();
    		if(!BaseHelpUtils.isNullOrEmpty(cBean)) {
    			int contractId = BaseHelpUtils.getIntValue(cBean.getContractId());
    			if(contractId <= 0) {
    				continue;
    			}
    			sDao.clear();
    			sDao.setProjectStageId(id);
    			if(sDao.load()) {
    				sDao.setContractId(contractId);
    				sDao.setStatus(1);
    				sDao.setRemark("2021-07-06刷数据");
    				sDao.update();
    			}
    		}
    		
    	}
    }
    
    public static void checkSelect() throws SQLException {
    	ColumnDomain dao = new ColumnDomain();
    	List<BaseColumnDomain> list = dao.conditionalLoad();
    	AddDomainValue dd = new AddDomainValue();
    	for(BaseColumnDomain bcd : list) {
    		try (java.sql.Statement stmt = ThreadConnection.getConnection().getConnection().createStatement()) {
    			boolean hasCondition = bcd.getConditionColumn() != null && bcd.getConditionColumn().trim().length() > 0;
    			boolean hasAdditional = bcd.getAdditionalCondition() != null && bcd.getAdditionalCondition().trim().length() > 0;
    			StringBuilder sb = new StringBuilder();
    			sb.append("select ");
    			sb.append(bcd.getKeyColumn());
    			sb.append(",");
    			sb.append(bcd.getValueColumn());
    			if (hasCondition) {
    				sb.append(",");
    				sb.append(bcd.getConditionColumn());
    			}
    			sb.append(" from ");
    			System.out.println("bcd.getTableName()========"+bcd.getTableName());
    			sb.append(bcd.getTableName());
    			if (hasAdditional) {
    				sb.append(" where ");
    				sb.append(bcd.getAdditionalCondition());
    			}
    			String sqlString = sb.toString();
    			__logger.info(sqlString);
    			try (java.sql.ResultSet rs = stmt.executeQuery(sqlString)) {
    				while (rs.next()) {
//    					BaseDomainValue __bean = new BaseDomainValue();
//    					__bean.setTableName(bcd.getSelectId());
//    					__bean.setKeyColumn(rs.getString(1));
//    					__bean.setValueColumn(rs.getString(2));
//    					if (hasCondition) {
//    						__bean.setConditionColumn(rs.getString(3));
//    					}
//    					values.add(__bean);
    				}
    			}
    		}
    	}
    }
    
    public static void main(String[] args) throws Exception {
    	checkSelect();
    }
    
}
