package pomplatform.upload;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

import com.pomplatform.db.bean.BaseSalaryFillSendDeduct;
import com.pomplatform.db.dao.SalaryFillSendDeduct;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericUploadProcessor;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import pomplatform.payment.bean.BaseOnFillSendDeductData;

/** 上传补扣补发数据
 * @author 
 */
public class OnUploadFillSendDeductData implements GenericUploadProcessor {

    private static final Logger __logger = Logger.getLogger(OnUploadFillSendDeductData.class);

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
    	SalaryFillSendDeduct dao = new SalaryFillSendDeduct();
        BaseSalaryFillSendDeduct bean;
        //把人员的数据加载出来
        Employee eDao = new Employee();
        eDao.unsetSelectFlags();
        eDao.setSelectEmployeeId(true);
        eDao.setSelectEmployeeName(true);
        eDao.setSelectEmployeeNo(true);
/*        eDao.setSelectCompanyId(true);
        eDao.setSelectDepartmentId(true);
        eDao.setSelectPlateId(true);*/
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
                //填平五险一金	多扣个税	填平个税   合计
                BigDecimal fillFiveInsuranceOneGolds=BigDecimal.ZERO;
                BigDecimal moreDeductTax=BigDecimal.ZERO;
                BigDecimal fillTax=BigDecimal.ZERO;
                BigDecimal totalAmount=BigDecimal.ZERO;
                
                
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                if(countCol!=6) {
                    log.append("模板不正确，请使用正确的补扣补发模板<br/>");
                    break;
                }
                dao.clear();
                bean = new BaseSalaryFillSendDeduct();
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
//                            	date = BaseHelpUtils.getString(cell.toString().trim());
                            	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
                            	DateFormat format2 = new SimpleDateFormat("yyyy");
                            	DateFormat format3 = new SimpleDateFormat("MM");
//                            	Date date2 = format.parse(date);
                                year = format2.format(theDate);
                                month = format3.format(theDate);
                				bean.setRecordDate(theDate);
                				bean.setYear(BaseHelpUtils.getIntValue(year));
                				bean.setMonth(BaseHelpUtils.getIntValue(month));
                            	break;
                            case 3:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	fillFiveInsuranceOneGolds = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                            	fillFiveInsuranceOneGolds =fillFiveInsuranceOneGolds.setScale(2, BigDecimal.ROUND_HALF_UP);
                            	bean.setFillFiveInsuranceOneGolds(fillFiveInsuranceOneGolds.toString());
                                break;
                            case 4:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	moreDeductTax = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                            	moreDeductTax =moreDeductTax.setScale(2, BigDecimal.ROUND_HALF_UP);
                            	bean.setMoreDeductTax(moreDeductTax.toString());
                                break;
                            case 5:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	fillTax = BaseHelpUtils.getBigDecimalValue(cell.toString().trim());
                            	fillTax =fillTax.setScale(2, BigDecimal.ROUND_HALF_UP);
                            	bean.setFillTax(fillTax.toString());
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
                BaseSalaryFillSendDeduct esbean = dao.executeQueryOneRow();
                
                //查看是否已有该条记录，如果有取要计算的数据出来计算，没有用默认的0计算
                //先根据职员ID去检索数据，如果有则更新薪资，如果没有则插入
                if (esbean != null) {
                	if(fillFiveInsuranceOneGolds.compareTo(BigDecimal.ZERO) == 0){
                		fillFiveInsuranceOneGolds = BigDecimal.valueOf(BaseHelpUtils.getIntValue(esbean.getFillFiveInsuranceOneGolds()));
                		fillFiveInsuranceOneGolds =fillFiveInsuranceOneGolds.setScale(2, BigDecimal.ROUND_HALF_UP);
                    }
                    if(moreDeductTax.compareTo(BigDecimal.ZERO) == 0){
                    	moreDeductTax = BigDecimal.valueOf(BaseHelpUtils.getIntValue(esbean.getMoreDeductTax()));
                    	moreDeductTax =moreDeductTax.setScale(2, BigDecimal.ROUND_HALF_UP);
                    }
                    
                    if(fillTax.compareTo(BigDecimal.ZERO) == 0){
                    	fillTax =BigDecimal.valueOf(BaseHelpUtils.getIntValue( esbean.getFillTax()));
                    	fillTax =fillTax.setScale(2, BigDecimal.ROUND_HALF_UP);
                    }
                    //合计
                    totalAmount= fillFiveInsuranceOneGolds.add(moreDeductTax).add(fillTax);
                    totalAmount =totalAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
                    bean.setTotalAmount(totalAmount.toString());
                    bean.setSalaryFillSendDeductId(esbean.getSalaryFillSendDeductId());
                    dao.setDataFromBase(bean);  
                    dao.update();
                } else {
                    //合计
                    totalAmount= fillFiveInsuranceOneGolds.add(moreDeductTax).add(fillTax);
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
    		OnUploadFillSendDeductData a = new OnUploadFillSendDeductData();
    		a.saveData(new File("C:\\Users\\Administrator\\Desktop\\reissueBuckle.xlsx"));
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }

}
