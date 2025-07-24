package pomplatform.upload;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.pomplatform.db.bean.BaseSalaryJobSubsidy;
import com.pomplatform.db.dao.SalaryJobSubsidy;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericUploadProcessor;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;

/** 上传岗位补贴数据
 * @author 
 */
public class OnUploadJobSubsidysData implements GenericUploadProcessor {

    private static final Logger __logger = Logger.getLogger(OnUploadJobSubsidysData.class);

    @Override
    public String execute(String creteria, HttpServletRequest request, List<FileItem> items) throws Exception {
        String errorMesg = "";
        for (FileItem fileItem : items) {
        	File fullName = File.createTempFile("DelicacyUploadFiles",UUID.randomUUID().toString());
            fileItem.write(fullName);
            errorMesg = saveData(fullName);
            fullName.delete();
        }
        BaseCollection bc = new BaseCollection();
        if (BaseHelpUtils.isNullOrEmpty(errorMesg)) {
            return bc.toJSON(0, null);
        } else {
            return bc.toJSON(-1, errorMesg);
        }
    }

    /**
     * @param file 读取数据的源Excel
     * @throws java.lang.Exception
     */
    public static String saveData(File file) throws Exception {
    	SalaryJobSubsidy dao = new SalaryJobSubsidy();
    	BaseSalaryJobSubsidy bean;
        //把人员的数据加载出来
        Employee eDao = new Employee();
        eDao.unsetSelectFlags();
        eDao.setSelectEmployeeId(true);
        eDao.setSelectEmployeeName(true);
        eDao.setSelectEmployeeNo(true);
        List<BaseEmployee> listBeans = eDao.conditionalLoad("order by "+BaseEmployee.CS_EMPLOYEE_NO+" asc");
        
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        StringBuilder log = new StringBuilder("未导入员工信息提示<br/>");
        int allerror = 0;
        int allsuccess = 0;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);

            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            for (int i = 1; i < countRow+1; i++) {
                // 创建一个行对象,并从第二行开始读取
                String name = null,no = null ,year = null, month = null,date=null;
                //里程补贴,考勤补发/扣,工资补发/扣,离职工资结算,绩效补发/扣,工地补助,转正核算,合计
                BigDecimal mileageSubsidy=BigDecimal.ZERO;
                BigDecimal attentionSubsidy=BigDecimal.ZERO;
                BigDecimal salarySubsidy=BigDecimal.ZERO;
                BigDecimal leaveSubsidy=BigDecimal.ZERO;
                BigDecimal performanceSubsidy=BigDecimal.ZERO;
                BigDecimal workSiteSubsidy=BigDecimal.ZERO;
                BigDecimal positiveAccount=BigDecimal.ZERO;
                BigDecimal totalAmount=BigDecimal.ZERO;
                
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                if(countCol!=10) {
                     log.append("模板不正确，请使用正确的岗位补贴模板<br/>");
                     break;
                }
                
                dao.clear();
                bean = new BaseSalaryJobSubsidy();
                for (int j = 0; j < countCol+1; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                    	
                        switch (j) {
                        	case 0:
                        		cell.setCellType(Cell.CELL_TYPE_STRING);
                        		no = BaseHelpUtils.getString(cell.toString().trim());
                                if (no.length() < 6) {
                                    no = String.format("%06d", BaseHelpUtils.getIntValue(no));
                                }
                             	 break;
                            case 1:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	name = BaseHelpUtils.getString(cell.toString().trim());
                                 break;
                            case 2:
                            	//获取日期
            	                Date theDate = cell.getDateCellValue();
                            	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
                            	DateFormat format2 = new SimpleDateFormat("yyyy");
                            	DateFormat format3 = new SimpleDateFormat("MM");
                                year = format2.format(theDate);
                                month = format3.format(theDate);
                				bean.setRecordDate(theDate);
                				bean.setYear(BaseHelpUtils.getIntValue(year));
                				bean.setMonth(BaseHelpUtils.getIntValue(month));
                            	break;
                            case 3:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	mileageSubsidy = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                            	mileageSubsidy =mileageSubsidy.setScale(2, BigDecimal.ROUND_HALF_UP);
                            	bean.setMileageSubsidy(mileageSubsidy.toString());
                                break;
                            case 4:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	attentionSubsidy = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                            	attentionSubsidy =attentionSubsidy.setScale(2, BigDecimal.ROUND_HALF_UP);
                            	bean.setAttentionSubsidy(attentionSubsidy.toString());
                                break;
                            case 5:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	salarySubsidy = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                            	salarySubsidy =salarySubsidy.setScale(2, BigDecimal.ROUND_HALF_UP);
                            	bean.setSalarySubsidy(salarySubsidy.toString());
                                break;
                            case 6:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	leaveSubsidy = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                            	leaveSubsidy =leaveSubsidy.setScale(2, BigDecimal.ROUND_HALF_UP);
                            	bean.setLeaveSubsidy(leaveSubsidy.toString());
                            	break;
                            case 7:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	performanceSubsidy = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                            	performanceSubsidy =performanceSubsidy.setScale(2, BigDecimal.ROUND_HALF_UP);
                            	bean.setPerformanceSubsidy(performanceSubsidy.toString());
                            	break;
                            case 8:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	workSiteSubsidy = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                            	workSiteSubsidy =workSiteSubsidy.setScale(2, BigDecimal.ROUND_HALF_UP);
                            	bean.setWorkSiteSubsidy(workSiteSubsidy.toString());
                            	break;
                            case 9:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	positiveAccount = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                            	positiveAccount =positiveAccount.setScale(2, BigDecimal.ROUND_HALF_UP);
                            	bean.setPositiveAccount(positiveAccount.toString());
                            	break;
                            default:
                                break;
                        }
                    }
                }
                
                //设置录入日期
                Calendar calendar = Calendar.getInstance();
            	calendar.setTime(new Date());
            	calendar.set(Calendar.YEAR, BaseHelpUtils.getIntValue(year));
            	calendar.set(Calendar.MONTH,BaseHelpUtils.getIntValue(month)-1);
            	calendar.set(Calendar.DATE, 1);
                BaseEmployee be = findEmployee(name, no, listBeans, log);
                if(be == null){
                    allerror++;
                    log.append(String.format("第%1$d行数据异常, 姓名:%2$s, 员工编号:%3$s 不符<br/>", i+1, name, no));
                    continue;
                }
                allsuccess++;
                //获取人员id
				int employeeId = be.getEmployeeId();
				//获取日期
				Date recordDate = calendar.getTime();
                bean.setEmployeeId(employeeId);
                bean.setOperateTime(recordDate);
                dao.setConditionEmployeeId("=", bean.getEmployeeId());
                dao.setConditionYear("=", BaseHelpUtils.getIntValue(year));
                dao.setConditionMonth("=", BaseHelpUtils.getIntValue(month));
                BaseSalaryJobSubsidy esbean = dao.executeQueryOneRow();
                
                //查看是否已有该条记录，如果有取要计算的数据出来计算，没有用默认的0计算
                //先根据职员ID去检索数据，如果有则更新薪资，如果没有则插入
                if (esbean != null) {
                	if(mileageSubsidy.compareTo(BigDecimal.ZERO) == 0){
                		mileageSubsidy = BigDecimal.valueOf(BaseHelpUtils.getIntValue(esbean.getMileageSubsidy()));
                		mileageSubsidy =mileageSubsidy.setScale(2, BigDecimal.ROUND_HALF_UP);
                    }
                    if(attentionSubsidy.compareTo(BigDecimal.ZERO) == 0){
                    	attentionSubsidy = BigDecimal.valueOf(BaseHelpUtils.getIntValue(esbean.getAttentionSubsidy()));
                    	attentionSubsidy =attentionSubsidy.setScale(2, BigDecimal.ROUND_HALF_UP);
                    }
                    
                    if(salarySubsidy.compareTo(BigDecimal.ZERO) == 0){
                    	salarySubsidy =BigDecimal.valueOf(BaseHelpUtils.getIntValue( esbean.getSalarySubsidy()));
                    	salarySubsidy =salarySubsidy.setScale(2, BigDecimal.ROUND_HALF_UP);
                    }
                    if(leaveSubsidy.compareTo(BigDecimal.ZERO) == 0){
                    	leaveSubsidy = BigDecimal.valueOf(BaseHelpUtils.getIntValue(esbean.getLeaveSubsidy()));
                    	leaveSubsidy =leaveSubsidy.setScale(2, BigDecimal.ROUND_HALF_UP);
                    }
                    if(performanceSubsidy.compareTo(BigDecimal.ZERO) == 0){
                    	performanceSubsidy = BigDecimal.valueOf(BaseHelpUtils.getIntValue(esbean.getPerformanceSubsidy()));
                    	performanceSubsidy =performanceSubsidy.setScale(2, BigDecimal.ROUND_HALF_UP);
                    }
                    
                    if(workSiteSubsidy.compareTo(BigDecimal.ZERO) == 0){
                    	workSiteSubsidy =BigDecimal.valueOf(BaseHelpUtils.getIntValue( esbean.getWorkSiteSubsidy()));
                    	workSiteSubsidy =workSiteSubsidy.setScale(2, BigDecimal.ROUND_HALF_UP);
                    }
                    if(positiveAccount.compareTo(BigDecimal.ZERO) == 0){
                    	positiveAccount =BigDecimal.valueOf(BaseHelpUtils.getIntValue( esbean.getPositiveAccount()));
                    	positiveAccount =positiveAccount.setScale(2, BigDecimal.ROUND_HALF_UP);
                    }
                    //合计
                    totalAmount= mileageSubsidy.add(attentionSubsidy).add(salarySubsidy).add(leaveSubsidy).add(performanceSubsidy).add(workSiteSubsidy).add(positiveAccount);
                    totalAmount =totalAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
                    bean.setTotalAmount(totalAmount.toString());
                    bean.setSalaryJobSubsidyId(esbean.getSalaryJobSubsidyId());
                    dao.setDataFromBase(bean);  
                    dao.update();
                } else {
                    //合计
                    totalAmount= mileageSubsidy.add(attentionSubsidy).add(salarySubsidy).add(leaveSubsidy).add(performanceSubsidy).add(workSiteSubsidy).add(positiveAccount);
                    totalAmount =totalAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
                    bean.setTotalAmount(totalAmount.toString());
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
//                log.append(String.format("姓名:%1$s, EXCEL员工号:%2$s 数据库员工号: %3$s 不符<br/>", name, no, be.getEmployeeNo()));
                continue;
            }
            return be;
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
    	try{
    		OnUploadJobSubsidysData a = new OnUploadJobSubsidysData();
    		a.saveData(new File("C:\\Users\\Administrator\\Desktop\\postAllowance.xlsx"));
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }

}
