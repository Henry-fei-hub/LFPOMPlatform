package pomplatform.salaryemployeeevaluationrmmor.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
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

import com.pomplatform.db.bean.BaseSalaryEmployeeEvaluation;
import com.pomplatform.db.dao.SalaryEmployeeEvaluation;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericUploadProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;

/**
 * 公用的process
 * @author 
 */
public class OnUploadEmployeeEvaluationProcess implements GenericUploadProcessor {
    private static Logger __logger = Logger.getLogger("");
    
    @Override
    public String execute(String creteria, HttpServletRequest request, List<FileItem> items) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        String errorMesg = "";
        BaseCollection bc = new BaseCollection();
        for (FileItem fileItem : items) {
            File fullName = File.createTempFile("DelicacyUploadFiles", UUID.randomUUID().toString());
            fileItem.write(fullName);
        	errorMesg = onUploadBonus(fullName,param);
            fullName.delete();
        }
        if (BaseHelpUtils.isNullOrEmpty(errorMesg)) {
            return bc.toJSON(0, null);
        } else {
            return bc.toJSON(-1, errorMesg);
        }
    }


	/**
	 * 
     * @param file 读取数据的源Excel
     * @return
     * @throws Exception
     */
	private String onUploadBonus(File file,Map<String,Object> param) throws Exception {
		SalaryEmployeeEvaluation dao = new SalaryEmployeeEvaluation();
        BaseSalaryEmployeeEvaluation bean;
        
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
        Date currentDate = new Date();
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
                String grade = null;
                Integer year = null ;
                Integer month = null ;
                
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                dao.clear();
                bean = new BaseSalaryEmployeeEvaluation();
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
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                        		year = BaseHelpUtils.getIntValue(cell.toString().trim());
                                break;
                            case 3:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                        		month = BaseHelpUtils.getIntValue(cell.toString().trim());
                                break;
                            case 4:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	grade = BaseHelpUtils.getString(cell.toString().trim().toUpperCase());
                            	break;
                            default:
                                break;
                        }
                    }
                }
//                System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
//                System.out.println(no + "-" + name + "-" + year + "-" +month + "-" + grade);
                BaseEmployee be = findEmployee(name, no, listBeans, log);
                if(be == null){
                    allerror++;
                    log.append(String.format("第%1$d行数据异常, 姓名:%2$s, 员工编号:%3$s 不s符<br/>", i+1, name, no));
                    continue;
                }
                allsuccess++;
				int employeeId = be.getEmployeeId();
				
				if(null != year && null != month && year > 0 && month > 0){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String sdStr = null;
					sdStr = year + "-" + month + "-15";
					Date happenDate = sdf.parse(sdStr);
					bean.setHappenDate(happenDate);
				}
				
				bean.setEmployeeId(employeeId);
				bean.setYear(year);
				bean.setMonth(month);
				bean.setGrade(grade);
				bean.setOperateEmployeeId(0);
				bean.setOperateTime(currentDate);
				dao.clear();
                dao.setConditionEmployeeId("=", bean.getEmployeeId());
                dao.setConditionYear("=", bean.getYear());
                dao.setConditionMonth("=", bean.getMonth());
                BaseSalaryEmployeeEvaluation esbean = dao.executeQueryOneRow();
                //先根据职员ID去检索数据，如果有则更新薪资，如果没有则插入
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
            if (!Objects.equals(no, be.getEmployeeNo())) {
//                log.append(String.format("姓名:%1$s, EXCEL员工号:%2$s 数据库员工号: %3$s 不符<br/>", name, no, be.getEmployeeNo()));
                continue;
            }
            return be;
        }
        return null;
    }
    
}
