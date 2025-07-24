package pomplatform.upload;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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

import com.pomplatform.db.bean.BaseReplacementTax;
import com.pomplatform.db.bean.BaseSalaryInsteadDeductIll;
import com.pomplatform.db.bean.BaseSalaryTotal;
import com.pomplatform.db.dao.ReplacementTax;
import com.pomplatform.db.dao.SalaryInsteadDeductIll;
import com.pomplatform.db.dao.SalaryTotal;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericUploadProcessor;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import pomplatform.supplierworkflow.handler.OnUploadSupplierInfo;

/** 上传补发个税数据
 * @author 
 */
public class OnUploadReplacementTaxData implements GenericUploadProcessor {

    private static final Logger __logger = Logger.getLogger(OnUploadReplacementTaxData.class);

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
    	ReplacementTax dao = new ReplacementTax();
        BaseReplacementTax bean;
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
			String name = null,no = null;
			Date recordDate = null;
			BigDecimal replacementTax = BigDecimal.ZERO;
			
			Row row = sheet.getRow(i);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
			    break;
			}
			//获取每一行的列数
			countCol = row.getLastCellNum();
			dao.clear();
			bean =new  BaseReplacementTax();
			for (int j = 1; j < countCol+1; j++) {
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
			                String date = sdf.format(theDate);  
			                recordDate = sdf.parse(date);
			                break;
			            case 4:
			            	cell.setCellType(Cell.CELL_TYPE_STRING);
			            	replacementTax = BaseHelpUtils.getBigDecimalValue(cell.toString().trim()).setScale(2, BigDecimal.ROUND_HALF_UP);
			                break;
			            default:
			                break;
			        }
			    }
			}
			//设置录入日期
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(recordDate);
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH) + 1;
			
			BaseEmployee be = findEmployee(name, no, listBeans, log);
			if(be == null){
			    allerror++;
			    log.append(String.format("第%1$d行数据异常, 姓名:%2$s, 员工编号:%3$s 不符<br/>", i+1, name, no));
			    continue;
			}
			allsuccess++;
			//获取人员id
			int employeeId = be.getEmployeeId();
			
			bean.setEmployeeId(employeeId);
			bean.setYear(year);
			bean.setMonth(month);
			bean.setRecordDate(recordDate);
			bean.setReplacementTax(replacementTax+"");
			bean.setOperateTime(new Date());
			
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			dao.setConditionRecordDate("=", recordDate);
			BaseReplacementTax esbean = dao.executeQueryOneRow();
			
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

    public static void main(String[] args) throws SQLException {

		File file=new File("C:\\Users\\Administrator\\Desktop\\222.xlsx");
		try {
//			saveData(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
    }
    
    public static String saveData2(File file) throws Exception {
    	SalaryTotal stDao =new SalaryTotal();
    	BaseSalaryTotal bean;
    	
        
        
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
			String name = null,no = null;
			Date recordDate = null;
			BigDecimal replacementTax = BigDecimal.ZERO;
			
			Row row = sheet.getRow(i);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
			    break;
			}
			//获取每一行的列数
			countCol = row.getLastCellNum();
			stDao.clear();
			stDao.setYear(2019);
			stDao.setMonth(2);
			
			
			bean =new  BaseSalaryTotal();
			
			for (int j = 1; j < countCol+1; j++) {
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
			            	replacementTax = BaseHelpUtils.getBigDecimalValue(cell.toString().trim()).setScale(2, BigDecimal.ROUND_HALF_UP);
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
			stDao.clear();
			stDao.setConditionYear("=",2019);
			stDao.setConditionMonth("=",2);
			stDao.setConditionEmployeeId("=",employeeId);
			bean.setWithholdingTax(replacementTax+"");
			List<BaseSalaryTotal> load = stDao.conditionalLoad();
			if(load.size()>0) {
				stDao.setDataFromBase(bean);
				stDao.conditionalUpdate();
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
    

}
