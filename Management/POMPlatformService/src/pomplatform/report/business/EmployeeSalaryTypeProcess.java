package pomplatform.report.business;

import com.pomplatform.db.bean.BaseEmployee;
import com.pomplatform.db.bean.BaseEmployeeSalaryType;
import com.pomplatform.db.bean.BaseFundraisingProjectType;
import com.pomplatform.db.dao.Employee;
import com.pomplatform.db.dao.EmployeeSalaryType;
import com.pomplatform.db.dao.FundraisingProjectType;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericUploadProcessor;
import org.apache.commons.fileupload.FileItem;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * @Author: liubin
 * @Description :导入募投项目
 * @Date: 22:02 2019/7/8
 */
public class EmployeeSalaryTypeProcess implements GenericUploadProcessor {
    @Override
    public String execute(String s, HttpServletRequest httpServletRequest, List<FileItem> items) throws Exception {
        String errorMesg = "";
        for (FileItem fileItem : items) {
            File fullName = File.createTempFile("DelicacyUploadFiles", UUID.randomUUID().toString());
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
     * @Author: liubin
     * @Description :导入募投项目的数据
     * @Date: 22:03 2019/7/8
     */
    private String saveData(File fullName) throws IOException, InvalidFormatException, SQLException {
        Employee employeeDao = new Employee();
        EmployeeSalaryType employeeSalaryTypeDao = new EmployeeSalaryType();
        FundraisingProjectType projectTypeDao = new FundraisingProjectType();
        // 把一张xls的数据表读到wb里
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(fullName));
        // 获取workbook的sheet数
        int count = workbook.getNumberOfSheets();
        for (int i = 0; i < count; i++) {
            String employeeName = "";
            String employeeNo = "";
            String year = "";
            String month = "";
            String fundraisingProjectType = "";
            String fundraisingProjectRate = "";
            //遍历每一个sheet
            Sheet sheet = workbook.getSheetAt(i);
            int countRow = 0;
            int countCol = 0;
            countRow = sheet.getLastRowNum();
            //读取每一行的数据
            for (int ii = 1; ii <= countRow; ii++) {
                Row row = sheet.getRow(ii);
                System.out.println("================ row" + countRow);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                // 获取每一行的列数
                countCol = row.getLastCellNum();
                for (int jj = 0; jj < countCol + 1; jj++) {
                    //创建单元格对象
                    Cell cell = row.getCell(jj);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (jj) {
                            case 0:
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                employeeName = cell.getStringCellValue();
                                break;
                            case 1:
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                employeeNo = cell.getStringCellValue();
                                break;
                            case 2:
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                year = cell.getStringCellValue();
                                break;
                            case 3:
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                month = cell.getStringCellValue();
                                break;
                            case 4:
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                fundraisingProjectType = cell.getStringCellValue();
                                break;
                            case 5:
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                fundraisingProjectRate = cell.getStringCellValue();
                                break;
                            default:
                                break;
                        }
                    }
                }
                //根据项目名称查询，募投项目类型
                projectTypeDao.clear();
                projectTypeDao.setConditionFundraisingProjectTypeName("=", fundraisingProjectType);
                BaseFundraisingProjectType baseFundraisingProjectType = projectTypeDao.executeQueryOneRow();
                if (null == baseFundraisingProjectType) {
                    continue;
                }
                int fundraisingProjectTypeId = BaseHelpUtils.getIntValue(baseFundraisingProjectType.getFundraisingProjectTypeId());
                //查询员工的具体的数据
                employeeDao.clear();
                employeeDao.setConditionEmployeeNo("=", employeeNo);
                BaseEmployee baseEmployee = employeeDao.executeQueryOneRow();
                if (null != baseEmployee) {
                    int employeeId = BaseHelpUtils.getIntValue(baseEmployee.getEmployeeId());
                    int plateId = BaseHelpUtils.getIntValue(baseEmployee.getPlateId());
                    int companyId = BaseHelpUtils.getIntValue(baseEmployee.getCompanyId());


                    //判断如果已经导入则更新
                    employeeSalaryTypeDao.clear();
                    employeeSalaryTypeDao.setConditionEmployeeId("=", employeeId);
                    employeeSalaryTypeDao.setConditionMonth("=", Integer.parseInt(month));
                    employeeSalaryTypeDao.setConditionYear("=", Integer.parseInt(year));
                    BaseEmployeeSalaryType baseEmployeeSalaryType = employeeSalaryTypeDao.executeQueryOneRow();
                    if (null != baseEmployeeSalaryType) {
                        baseEmployeeSalaryType.setEmployeeId(employeeId);
                        baseEmployeeSalaryType.setPlateId(plateId);
                        baseEmployeeSalaryType.setCompanyId(companyId);
                        baseEmployeeSalaryType.setEmployeeName(employeeName);
                        baseEmployeeSalaryType.setEmployeeNo(employeeNo);
                        baseEmployeeSalaryType.setYear(Integer.parseInt(year));
                        baseEmployeeSalaryType.setMonth(Integer.parseInt(month));
                        baseEmployeeSalaryType.setFundraisingProjectType(fundraisingProjectTypeId);
                        baseEmployeeSalaryType.setFundraisingProjectRate(new BigDecimal(fundraisingProjectRate));
                        employeeSalaryTypeDao.clear();
                        employeeSalaryTypeDao.setDataFromBase(baseEmployeeSalaryType);
                        employeeSalaryTypeDao.update();
                    } else {
                        BaseEmployeeSalaryType bean = new BaseEmployeeSalaryType();
                        bean.setEmployeeId(employeeId);
                        bean.setPlateId(plateId);
                        bean.setCompanyId(companyId);
                        bean.setEmployeeName(employeeName);
                        bean.setEmployeeNo(employeeNo);
                        bean.setYear(Integer.parseInt(year));
                        bean.setMonth(Integer.parseInt(month));
                        bean.setFundraisingProjectType(fundraisingProjectTypeId);
                        bean.setFundraisingProjectRate(new BigDecimal(fundraisingProjectRate));
                        employeeSalaryTypeDao.clear();
                        employeeSalaryTypeDao.setDataFromBase(bean);
                        employeeSalaryTypeDao.save();
                    }
                }
            }
        }
        return null;
    }
}
