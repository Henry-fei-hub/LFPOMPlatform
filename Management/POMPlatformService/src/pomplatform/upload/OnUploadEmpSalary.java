package pomplatform.upload;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
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

import com.pomplatform.db.bean.BaseEmployeeSalaryDetail;
import com.pomplatform.db.dao.EmployeeSalaryDetail;
import com.pomplatform.db.dao.SystemConfig;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.DES;
import delicacy.common.GenericUploadProcessor;
import delicacy.servlet.DelicacyServlet;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.StaticUtils;

/**
 * @author lxf
 */
public class OnUploadEmpSalary implements GenericUploadProcessor {

    private static final Logger __logger = Logger.getLogger(OnUploadEmpSalary.class);

    @SuppressWarnings("rawtypes")
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
        EmployeeSalaryDetail dao = new EmployeeSalaryDetail();
        BaseEmployeeSalaryDetail bean;
        //把人员的数据加载出来
        Employee eDao = new Employee();
        eDao.unsetSelectFlags();
        eDao.setSelectEmployeeId(true);
        eDao.setSelectEmployeeName(true);
        eDao.setSelectEmployeeNo(true);
        List<BaseEmployee> listBeans = eDao.conditionalLoad("order by "+BaseEmployee.CS_EMPLOYEE_NO+" asc");
        //检索系统表中的加密的秘钥
        SystemConfig sc = new SystemConfig();
        sc.setSystemConfigId(StaticUtils.SYSTEM_KEY);
        sc.load();
        String keyValue = sc.getImagePath() == null ? DelicacyServlet.PUBLIC_KEY : sc.getImagePath();
        DES des = new DES(keyValue);
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
//        PrintStream ps = new PrintStream("d:/salary/errorline.csv");
        StringBuilder log = new StringBuilder("未导入员工信息提示<br/>");
        int allerror = 0;
        int allsuccess = 0;
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);

            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            for (int i = 1; i < countRow + 1; i++) {
                // 创建一个行对象,并从第二行开始读取
                String name = null;
                String no = null;
                String year = null, month = null;
                String salary = null;
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();

                dao.clear();
                bean = new BaseEmployeeSalaryDetail();
                for (int j = 0; j < countCol; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                            case 1:
                                name = BaseHelpUtils.getString(cell.toString().trim());
                            case 2:
                                no = BaseHelpUtils.getString(cell.toString().trim());
                                break;
                            case 3:
                                year = BaseHelpUtils.getString(cell.toString().trim());
                                break;
                            case 4:
                                month = BaseHelpUtils.getString(cell.toString().trim());
                                break;
                            case 5:
                                double d = BaseHelpUtils.getDoubleValue(cell.toString().trim());
                                salary = String.format("%1$.2f", d);
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
//                    log.append(String.format("第%1$d行数据异常, 姓名:%2$s, 员工号:%3$s 没找到<br/>", i+1, name, no));
//                    ps.printf("%1$s,%2$s,%3$s,%4$s,%5$s\n", name,no,year,month,salary);
                    continue;
                }
                allsuccess++;
                //获取人员id
				int employeeId = be.getEmployeeId();
				//获取日期
				Date recordDate = calendar.getTime();
                bean.setEmployeeId(employeeId);
                bean.setSalaryYear(BaseHelpUtils.getIntValue(year));
                bean.setSalaryMonth(BaseHelpUtils.getIntValue(month));
                bean.setEntryDate(recordDate);
                bean.setBasicSalary(des.ENC(salary));

                dao.setConditionEmployeeId("=", bean.getEmployeeId());
                dao.setConditionSalaryYear("=", BaseHelpUtils.getIntValue(year));
                dao.setConditionSalaryMonth("=", BaseHelpUtils.getIntValue(month));
                
                BaseEmployeeSalaryDetail esbean = dao.executeQueryOneRow();
                //先根据职员ID、年份、月份去检索数据，如果有则更新薪资，如果没有则插入
                if (esbean != null) {
                    dao.setDataFromBase(esbean);
                    dao.clearModifiedFlags();
                    dao.setDataFromBase(bean);
                    dao.update();
                    int businessId = esbean.getEmployeeSalaryDetailId();
    				AccountManageProcess.onUpdateEmployeeAccount(employeeId, businessId, AccountManageProcess.EMP_BT_EMPLOYEE_COST, new BigDecimal(salary), recordDate,"",-1);
                } else {
                    dao.clear();
                    dao.setDataFromBase(bean);
                    dao.save();
                    //获取主键ID，即业务ID
    				int businessId = dao.getEmployeeSalaryDetailId();
    				//个人账户插入个人账户表
    				AccountManageProcess.onSaveEmployeeAccount(employeeId, businessId, AccountManageProcess.EMP_BT_EMPLOYEE_COST, new BigDecimal(salary), recordDate,"",-1);
                }
            }
        }
        __logger.info("<br/>导入人工成本数据成功条数 =" + allsuccess);
//        ps.close();
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
    	EmployeeSalaryDetail dao = new EmployeeSalaryDetail();
    	List<BaseEmployeeSalaryDetail> list = dao.conditionalLoad();
    	for(BaseEmployeeSalaryDetail e : list){
    		int year = BaseHelpUtils.getIntValue(e.getSalaryYear());
    		int month = BaseHelpUtils.getIntValue(e.getSalaryMonth());
    		Calendar calendar = Calendar.getInstance();
        	calendar.setTime(new Date());
        	calendar.set(Calendar.YEAR, year);
        	calendar.set(Calendar.MONTH,month-1);
        	calendar.set(Calendar.DATE, 1);
        	e.setEntryDate(calendar.getTime());
        	dao.clear();
        	dao.setDataFromBase(e);
        	dao.update();
    	}
//        try {
//            saveData(new File("D:/files/empSalary.xls"));
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    	int year = 2016;
//    	int month = 5;
//    	Calendar calendar = Calendar.getInstance();
//    	calendar.setTime(new Date());
//    	calendar.set(Calendar.YEAR, year);
//    	calendar.set(Calendar.MONTH,month-1);
//    	calendar.set(Calendar.DATE, 1);
//    	System.out.println(calendar.getTime());
    }

}
