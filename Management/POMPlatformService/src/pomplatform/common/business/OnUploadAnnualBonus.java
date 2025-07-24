package pomplatform.common.business;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.pomplatform.db.bean.BaseEmployeeMonthCheck;
import com.pomplatform.db.bean.BasePlateDepartment;
import com.pomplatform.db.bean.BaseSalaryAnnualBonus;
import com.pomplatform.db.bean.BaseSalaryEmployeeEvaluationGrade;
import com.pomplatform.db.dao.EmployeeMonthCheck;
import com.pomplatform.db.dao.PlateDepartment;
import com.pomplatform.db.dao.SalaryAnnualBonus;
import com.pomplatform.db.dao.SalaryEmployeeEvaluationGrade;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericUploadProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import pomplatform.payment.bean.BaseOnLoadEmployeePayment;
import pomplatform.payment.bean.ConditionOnLoadEmployeePayment;
import pomplatform.payment.query.QueryOnLoadEmployeePayment;

/**
 * 
 * @author 
 */
public class OnUploadAnnualBonus implements GenericUploadProcessor {
    @SuppressWarnings("unchecked")
	@Override
    public String execute(String creteria, HttpServletRequest request, List<FileItem> items) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        String errorMesg = "";
        @SuppressWarnings("rawtypes")
		BaseCollection<GenericBase> bc = new BaseCollection();
        for (FileItem fileItem : items) {
            File fullName = File.createTempFile("DelicacyUploadFiles", UUID.randomUUID().toString());;
            fileItem.write(fullName);
        	errorMesg = UploadAnnualBonus(fullName,param);
            fullName.delete();
        }
        if (BaseHelpUtils.isNullOrEmpty(errorMesg)) {
            return bc.toJSON(0, null);
        } else {
            return bc.toJSON(-1, errorMesg);
        }
    }


    public static void main(String[] args) throws Exception{
    	OnUploadAnnualBonus a = new OnUploadAnnualBonus();
    	File file=new File("D:\\eee.xlsx");
    	a.UploadAnnualBonus(file, null);
	}
    
 
    
    
	/**
	 * 
     * @param file 读取数据的源Excel
     * @return
     * @throws Exception
     */
	private String UploadAnnualBonus(File file,Map<String,Object> param) throws Exception {
		SalaryAnnualBonus dao = new SalaryAnnualBonus();
        BaseSalaryAnnualBonus bean;
        //把人员的数据加载出来
        Employee eDao = new Employee();
        eDao.unsetSelectFlags();
        eDao.setSelectEmployeeId(true);
        eDao.setSelectEmployeeName(true);
        eDao.setSelectEmployeeNo(true);
        eDao.setSelectCard(true);
        eDao.setSelectCompanyId(true);
        eDao.setSelectPlateId(true);
        eDao.setSelectDepartmentId(true);
        eDao.setConditionEmployeeId(">", 0);
        PlateDepartment pdDao = new PlateDepartment();
        List<BaseEmployee> listBeans = eDao.conditionalLoad("order by "+BaseEmployee.CS_EMPLOYEE_NO+" asc");
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        StringBuilder log = new StringBuilder("未导入员工信息提示<br/>");
        int allerror = 0;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);

            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            for (int i = 1; i < countRow + 1; i++) {
                // 创建一个行对象,并从第二行开始读取
                String name = null,no = null,yearTestLevel = null;
                int year = 0;
                BigDecimal yearPerformanceBonus = BigDecimal.ZERO,programBonus = BigDecimal.ZERO,transferAccountMoney = BigDecimal.ZERO,depositDeduct = BigDecimal.ZERO;
                BigDecimal salaryDiffDeduct = BigDecimal.ZERO,reimbursementDeduct = BigDecimal.ZERO,otherDeduct = BigDecimal.ZERO,alreadyBonus = BigDecimal.ZERO;
                
                BigDecimal oneToThreeRest=BigDecimal.ZERO,housingSubsidy=BigDecimal.ZERO,deductPerformanceBonus=BigDecimal.ZERO,insteadDeduct=BigDecimal.ZERO;
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                bean = new BaseSalaryAnnualBonus();
                for (int j = 0; j < countCol+1; j++) {
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
                            	year = BaseHelpUtils.getIntValue(cell.toString().trim());
                                break;
                            case 4:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	HSSFDataFormatter dataFormatter = new HSSFDataFormatter();
                            	oneToThreeRest = BaseHelpUtils.getBigDecimalValue(dataFormatter.formatCellValue(cell)).setScale(2, BigDecimal.ROUND_HALF_UP);//1-3季度剩余奖金
                            	break;
                            case 5:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	HSSFDataFormatter dataFormatters = new HSSFDataFormatter();
                            	programBonus = BaseHelpUtils.getBigDecimalValue(dataFormatters.formatCellValue(cell)).setScale(2, BigDecimal.ROUND_HALF_UP);//本次应发奖金
                            	break;
                            case 6:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	yearPerformanceBonus = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());//年度绩效工资
                            	break;
                            case 7:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	housingSubsidy = BaseHelpUtils.getBigDecimalValue(cell.toString().trim()); //住房补贴
                            	break;
                            case 8:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	transferAccountMoney = BaseHelpUtils.getBigDecimalValue(cell.toString().trim()); //调户押金返还
                            	break;
                            case 9:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	salaryDiffDeduct = BaseHelpUtils.getBigDecimalValue(cell.toString().trim()); //汇率工资差额
                            	break;
                            case 10:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	deductPerformanceBonus = BaseHelpUtils.getBigDecimalValue(cell.toString().trim()); //年度绩效扣款
                            	break;
                            case 11:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	depositDeduct = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());//调户押金扣除
                            	break;
                            case 12:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	reimbursementDeduct = BaseHelpUtils.getBigDecimalValue(cell.toString().trim()); //报销扣款
                            	break;
                            case 13:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	otherDeduct = BaseHelpUtils.getBigDecimalValue(cell.toString().trim()); //其他扣款
                            	break;
                            case 14:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	alreadyBonus = BaseHelpUtils.getBigDecimalValue(cell.toString().trim()); //已发奖金
                            	break;
                            case 15:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	insteadDeduct = BaseHelpUtils.getBigDecimalValue(cell.toString().trim()); //代扣款项
                            	break;
                            default:
                                break;
                        }
                    }
                }
                
                BaseEmployee be = findEmployee(name, no, listBeans, log);
                if(be == null){
                    allerror++;
                    log.append(String.format("第%1$d行数据异常, 姓名:%2$s, 员工编号:%3$s 不符<br/>", i+1, name, no));
                    continue;
                }
				int employeeId = be.getEmployeeId();
				int departmentId = BaseHelpUtils.getIntValue(be.getDepartmentId());
				bean.setEmployeeId(employeeId);
				bean.setEmployeeNo(no);
				bean.setEmployeeName(name);
				bean.setBankAccount(be.getBankCardNum());
				bean.setYear(year);
				bean.setCompanyId(be.getCompanyId());
				bean.setDepartmentId(departmentId);
				//根据当前员工归属的部门去查找关联的业务部门Id
				pdDao.clear();
				pdDao.setConditionDepartmentId("=",departmentId);
				BasePlateDepartment pdBean = pdDao.executeQueryOneRow();
				bean.setPlateId(pdBean==null?be.getPlateId():pdBean.getPlateId());
				//获取员工可用的全薪 
				QueryOnLoadEmployeePayment q = new QueryOnLoadEmployeePayment();
				ConditionOnLoadEmployeePayment condition = new ConditionOnLoadEmployeePayment();
				condition.setEmployeeId(employeeId);
				condition.setEnabled(Boolean.TRUE);
				BaseCollection<BaseOnLoadEmployeePayment> result = q.executeQuery(null, condition);
				BigDecimal totalPay = BigDecimal.ZERO;
				if(!BaseHelpUtils.isNullOrEmpty(result)){
					List<BaseOnLoadEmployeePayment> payList = result.getCollections();
					if(!BaseHelpUtils.isNullOrEmpty(payList) && payList.size() > 0){
						for(BaseOnLoadEmployeePayment e : payList){
							totalPay = BaseHelpUtils.getBigDecimalValue(e.getTotalPay());
						}
					}
				}
				bean.setTotalPay(BaseHelpUtils.getString(totalPay));
				
				//根据员工id和年份获取该年工作日和实际出勤工作
				EmployeeMonthCheck dayDao = new EmployeeMonthCheck();
				dayDao.setConditionEmployeeId("=", employeeId);
				dayDao.setConditionYear("=", year);
				List<BaseEmployeeMonthCheck> dayList = dayDao.conditionalLoad();
				BigDecimal shouldDay = BigDecimal.ZERO,factDay = BigDecimal.ZERO;
				for(BaseEmployeeMonthCheck e : dayList){
					if(!BaseHelpUtils.isNullOrEmpty(e.getShouldDays())){
						shouldDay = shouldDay.add(e.getShouldDays());
					}
					if(!BaseHelpUtils.isNullOrEmpty(e.getFactDays())){
						factDay = factDay.add(e.getFactDays());
					}
				}
				bean.setYearShouldWorkDay(shouldDay);
				bean.setYearFactWorkDay(factDay);
				
				//年度服务系数  
				BigDecimal yearServiceNum = shouldDay.compareTo(BigDecimal.ZERO)==0?BigDecimal.ONE:factDay.divide(shouldDay,2);
				bean.setYearServiceNum(yearServiceNum);
				//年度考核等级
				bean.setYearTestLevel(yearTestLevel);
				
				//根据年度考核等级和年份获取相应 考核系数
				SalaryEmployeeEvaluationGrade gradeDao = new SalaryEmployeeEvaluationGrade();
				gradeDao.setConditionYear("=", year);
				gradeDao.setConditionFlag("=", 2);//2为年度绩效
				gradeDao.setConditionGrade("=",yearTestLevel);//等级
				BaseSalaryEmployeeEvaluationGrade gradeBean = gradeDao.executeQueryOneRow();
				BigDecimal testNum = BigDecimal.ZERO;
				if(!BaseHelpUtils.isNullOrEmpty(gradeBean)){
					testNum = gradeBean.getProportion();
					bean.setTestNum(testNum);//0.8
				}
				
				//计算应发13薪奖金
				BigDecimal thirteenBonus = BaseHelpUtils.format(totalPay.multiply(yearServiceNum).multiply(testNum), 2);
				bean.setThirteenBonus(thirteenBonus+"");
				
				//应发年度绩效工资
				bean.setYearPerformanceBonus(yearPerformanceBonus+"");
				//应发项目奖金
				bean.setProgramBonus(programBonus+"");
				//调户押金返还
				bean.setTransferAccountMoney(transferAccountMoney+"");
				//调户押金扣除(减)
				bean.setDepositDeduct(depositDeduct+"");
				//补/扣工资差额
				bean.setSalaryDiffDeduct(salaryDiffDeduct+"");
				//报销扣款
				bean.setReimbursementDeduct(reimbursementDeduct+"");
				//其他扣款
				bean.setOtherDeduct(otherDeduct+"");
				//已发奖金
				bean.setAlreadyBonus(alreadyBonus+"");
				//1-3季度剩余奖金
				bean.setOneToThreeRest(oneToThreeRest+"");
				//住房补贴
				bean.setHousingSubsidy(housingSubsidy+"");
                //年度绩效扣款
				bean.setDeductPerformanceBonus(deductPerformanceBonus+"");
				//应发合计=应发13薪奖金+应发年度绩效工资+应发项目奖金+补/扣工资差额+调户押金返还-调户押金扣除-报销扣款-其他扣款---Old
				/*BigDecimal shouldTotal = thirteenBonus.add(yearPerformanceBonus).add(programBonus).add(salaryDiffDeduct).add(transferAccountMoney)
				.subtract(depositDeduct).subtract(reimbursementDeduct).subtract(otherDeduct);*/
				
				//应发合计=1-3季度剩余奖金+本次应发奖金+年度绩效工资+住房补贴+调户押金返还+汇率工资差额-年度绩效扣款-调户押金扣除-报销扣款-其他扣款--New
				BigDecimal shouldTotal = oneToThreeRest.add(programBonus).add(yearPerformanceBonus).add(housingSubsidy).add(transferAccountMoney).add(salaryDiffDeduct)
						.subtract(deductPerformanceBonus).subtract(depositDeduct).subtract(reimbursementDeduct).subtract(otherDeduct);
				
				bean.setShouldTotal(shouldTotal+"");
				//应纳税所得=应发合计+已发奖金
				BigDecimal shouldTaxAchieve = shouldTotal.add(alreadyBonus);
				bean.setShouldTaxAchieve(shouldTaxAchieve+"");
				//应纳个税
				BigDecimal shouldTax = BigDecimal.ZERO;
				BigDecimal forCompare = shouldTaxAchieve.divide(new BigDecimal("12"),2);  //  应纳税所得 /12 
				/*if(forCompare.compareTo(new BigDecimal("80000")) > 0){ //forCompare>80000时 ，shouldTaxAchieve*0.45-13505
					shouldTax = shouldTaxAchieve.multiply(new BigDecimal("0.45")).subtract(new BigDecimal("13505"));
				}else if(forCompare.compareTo(new BigDecimal("55000")) > 0){//forCompare>55000时 ，shouldTaxAchieve*0.35-5505
					shouldTax = shouldTaxAchieve.multiply(new BigDecimal("0.35")).subtract(new BigDecimal("5505"));
				}else if(forCompare.compareTo(new BigDecimal("35000")) > 0){//forCompare>35000时 ，shouldTaxAchieve*0.3-2755
					shouldTax = shouldTaxAchieve.multiply(new BigDecimal("0.3")).subtract(new BigDecimal("2755"));
				}else if(forCompare.compareTo(new BigDecimal("9000")) > 0){//forCompare>9000时 ，shouldTaxAchieve*0.25-1005
					shouldTax = shouldTaxAchieve.multiply(new BigDecimal("0.25")).subtract(new BigDecimal("1005"));
				}else if(forCompare.compareTo(new BigDecimal("4500")) > 0){//forCompare>4500时 ，shouldTaxAchieve*0.2-555
					shouldTax = shouldTaxAchieve.multiply(new BigDecimal("0.2")).subtract(new BigDecimal("555"));
				}else if(forCompare.compareTo(new BigDecimal("1500")) > 0){//forCompare>1500时 ，shouldTaxAchieve*0.1-105
					shouldTax = shouldTaxAchieve.multiply(new BigDecimal("0.1")).subtract(new BigDecimal("105"));
				}else if(forCompare.compareTo(new BigDecimal("1500")) <= 0){//forCompare<=1500时 ，shouldTaxAchieve*0.03
					shouldTax = shouldTaxAchieve.multiply(new BigDecimal("0.03"));
				}*/
				
			  /*应纳税所得/12，小于等于3000时，0.03
				应纳税所得/12，小于等于12000时，0.1-210
				应纳税所得/12，小于等于25000时，0.2-1410
				应纳税所得/12，小于等于35000时，0.25-2660
				应纳税所得/12，小于等于55000时，0.3-4410
				应纳税所得/12，小于等于80000时，0.35-7160
				应纳税所得/12，大于80000时，0.45-15160*/
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
				shouldTax = BaseHelpUtils.getDecimal(shouldTax,2);
				bean.setShouldTax(shouldTax+"");
				
				//代扣款项
				bean.setInsteadDeduct(BaseHelpUtils.getDecimal(insteadDeduct,2)+"");
				//实发奖金
				bean.setFactBonus(BaseHelpUtils.getDecimal(shouldTotal.subtract(shouldTax).subtract(insteadDeduct),2)+"");
				
				bean.setOperateEmployeeId(BaseHelpUtils.getIntValue(param.get("operateEmployeeId")));
				bean.setOperateTime(BaseHelpUtils.getDateValue(param.get("operateTime")));
				
                dao.setConditionEmployeeId("=", bean.getEmployeeId());
                dao.setConditionYear("=", year);
                dao.setConditionPersonnelBusinessId("=", 0);
                BaseSalaryAnnualBonus esbean = dao.executeQueryOneRow();
                //先根据职员ID和年份去检索数据，如果有则更新薪资，如果没有则插入
                if (!BaseHelpUtils.isNullOrEmpty(esbean)) {
                    dao.setDataFromBase(esbean);
                    dao.clearModifiedFlags();
                    dao.setDataFromBase(bean);
                    dao.update();
                } else {
                    dao.clear();
                    dao.setDataFromBase(bean);
                    dao.save();
                }
            }
        }
        if (allerror > 0) {
            log.append("<br/>总共：").append(allerror).append("人没有导入").append("<br/>原因：根据员工编号/名称没有匹配到员工");
            System.out.print(log.toString());
            return log.toString();
        } else {
            return null;
        }
	}

	/**
     * 根据编号和名称去匹配人员
     * @param name
     * @param no
     * @param bes
     * @param log
     * @return 
     */
    public static BaseEmployee findEmployee(String name, String no, List<BaseEmployee> bes, StringBuilder log) {
        for (BaseEmployee be : bes) {
            if (!Objects.equals(name, be.getEmployeeName())) {
                continue;
            }
            if (!Objects.equals(no, be.getEmployeeNo())) {
                continue;
            }
            return be;
        }
        return null;
    }
    
}
