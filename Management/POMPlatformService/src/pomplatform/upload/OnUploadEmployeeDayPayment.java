package pomplatform.upload;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.pomplatform.db.bean.BaseEmployeePayment;
import com.pomplatform.db.dao.EmployeePayment;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericUploadProcessor;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;

/** 上传日薪数据
 * @author 
 */
public class OnUploadEmployeeDayPayment implements GenericUploadProcessor {

    private static final Logger __logger = Logger.getLogger(OnUploadEmployeeDayPayment.class);

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
        EmployeePayment dao = new EmployeePayment();
        BaseEmployeePayment bean;
        //把人员的数据加载出来
        Employee eDao = new Employee();
        eDao.unsetSelectFlags();
        eDao.setSelectEmployeeId(true);
        eDao.setSelectEmployeeName(true);
        eDao.setSelectEmployeeNo(true);
        eDao.setSelectDepartmentId(true);
        eDao.setSelectPlateId(true);
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
                String name = null,no = null ;
                int paymentChangeType = 0;
                Date changeDate = null;
                BigDecimal monthPay = BigDecimal.ZERO,annualPerformance = BigDecimal.ZERO,monthBasicPay = BigDecimal.ZERO;
                BigDecimal basicProportion = BigDecimal.ZERO;
                int costAttribution = 0;
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                dao.clear();
                bean = new BaseEmployeePayment();
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
                            	String str = BaseHelpUtils.getString(cell.toString().trim());
                            	if(str.equals("入职")){
                            		paymentChangeType = 1;
                            	}else if(str.equals("转正")){
                            		paymentChangeType = 2;
                            	}else if(str.equals("调薪")){
                            		paymentChangeType = 3;
                            	}else if(str.equals("调岗")){
                            		paymentChangeType = 4;
                            	}
                                break;
                            case 4:
                            	cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                                Date theDate = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                                SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
                                String date = sdf.format(theDate);  
                                changeDate = sdf.parse(date);
                                break;
                            case 5:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	monthPay = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                break;
                            case 6:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	basicProportion = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                                break;
                            case 7:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	annualPerformance = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                            	break;
                            case 8:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	costAttribution = BaseHelpUtils.getIntValue(cell.toString().trim());
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
                allsuccess++;
                //获取人员id
				int employeeId = be.getEmployeeId();
				dao.clear();
                dao.setConditionEmployeeId("=", employeeId);
                dao.setConditionPaymentChangeType("=", paymentChangeType);
                dao.setConditionChangeDate("=", changeDate);
                BaseEmployeePayment esbean = dao.executeQueryOneRow();
                
                bean.setEmployeeId(employeeId);
                bean.setPaymentChangeType(paymentChangeType);
                bean.setChangeDate(changeDate);
                bean.setMonthPay(monthPay+"");
                bean.setBasicProportionStr(BaseHelpUtils.format(basicProportion.multiply(BigDecimal.valueOf(100)),0)+"%");
                bean.setBasicProportion(basicProportion);
                if(monthPay.compareTo(BigDecimal.ZERO) > 0){//如果月薪不为0，计算月基本工资和月绩效
                	monthBasicPay = BaseHelpUtils.format(monthPay.multiply(basicProportion),2);
                	bean.setMonthBasicPay(monthBasicPay+"");
                	bean.setMonthPerformancePay(monthPay.subtract(monthBasicPay)+"");
                	bean.setTotalPay(monthPay+"");//全薪
                }
                bean.setAnnualPerformance(annualPerformance+"");
				if(costAttribution > 0){
					bean.setCostAttribution(costAttribution);//费用归属
				}
                
                if (!BaseHelpUtils.isNullOrEmpty(esbean)) {//如果该员工该调薪类型已有记录，则更新
                	if(!esbean.getMonthPay().equals(monthPay)){
                		dao.setDataFromBase(esbean);
                		dao.clearModifiedFlags();
                		dao.setDataFromBase(bean);
                		dao.update();
                	}
                } else {//如没有，则插入数据
                	//检索该员工是否还有其他类型的记录，如果有则设置为false
                	dao.clear();
                	dao.setConditionEmployeeId("=",employeeId);
                	dao.setConditionEnabled("=",Boolean.TRUE);
                	if(dao.countRows() > 0){
                		dao.setEnabled(Boolean.FALSE);
                		dao.conditionalUpdate();
                	}
                    dao.clear();
                    bean.setEnabled(Boolean.TRUE);
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
    }

}
