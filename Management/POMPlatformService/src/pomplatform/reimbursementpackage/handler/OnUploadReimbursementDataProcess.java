package pomplatform.reimbursementpackage.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.dao.MainProject;
import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.pomplatform.db.bean.BaseNormalReimbursementLinkDepartment;
import com.pomplatform.db.bean.BaseNormalReimbursementLinkProject;
import com.pomplatform.db.bean.BaseSubjectType;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.SubjectType;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericUploadProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

/**
 * 公用的process
 * @author 
 */
public class OnUploadReimbursementDataProcess implements GenericUploadProcessor {
    private static Logger __logger = Logger.getLogger("");
    
    private final static String ON_UPLOAD_LINK_PROJECT = "onUploadLinkProject";
    
    private final static String ON_UPLOAD_LINK_DEPARTMENT = "onUploadLinkDepartment";
    
    @Override
    public String execute(String creteria, HttpServletRequest request, List<FileItem> items) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        String opt_type = BaseHelpUtils.getStringValue(params, "opt_type");
        String errorMesg = "";
        BaseCollection bc = new BaseCollection();
        File fullName = File.createTempFile("DelicacyUploadFiles", UUID.randomUUID().toString());
        if(items.size() > 0){
        	FileItem fileItem = items.get(0);
            fileItem.write(fullName);
            switch (opt_type) {
    		case ON_UPLOAD_LINK_PROJECT:
    			return onUploadLinkProject(fullName, params);
    		case ON_UPLOAD_LINK_DEPARTMENT:
    			return onUploadLinkDepartment(fullName, params);
    		default:
    			break;
    		}
            
        }
        return bc.toJSON(-1, errorMesg);
    }

	/**
	 * 
     * @param file 读取数据的源Excel
     * @return
     * @throws Exception
     */
	private String onUploadLinkProject(File file, Map<String,Object> param) throws Exception {
		int status = 1;
		BaseCollection<BaseNormalReimbursementLinkProject> bc = new BaseCollection<>();
		List<BaseNormalReimbursementLinkProject> rblList = new ArrayList<>();
        BaseNormalReimbursementLinkProject bean;
        String departmentId = BaseHelpUtils.getString(param.get("departmentId"));
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        StringBuilder log = new StringBuilder("错误信息提示<br/>");
        int allerror = 0;
        int allsuccess = 0;
        Date currentDate = new Date();
        MainProject pDao = new MainProject();
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);

            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            for (int i = 1; i < countRow + 1; i++) {
                // 创建一个行对象,并从第二行开始读取
                String subject = null;
                String childSubject = null;
                String remark = null;
                String projectCode = null;
                BigDecimal money = BigDecimal.ZERO;
                BigDecimal inputTax = BigDecimal.ZERO;
                
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                bean = new BaseNormalReimbursementLinkProject();
                for (int j = 0; j < countCol+1; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                    	
                        switch (j) {
                            case 0:
                                cell.setCellType(cell.CELL_TYPE_STRING);
                                subject = BaseHelpUtils.getString(cell.toString().trim());
                                break;
                            case 1:
                                cell.setCellType(cell.CELL_TYPE_STRING);
                                childSubject = BaseHelpUtils.getString(cell.toString().trim());
                                break;
                            case 2:
                                cell.setCellType(cell.CELL_TYPE_STRING);
                                remark = BaseHelpUtils.getString(cell.toString().trim());
                                break;
                            case 3:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	projectCode = BaseHelpUtils.getString(cell.toString().trim());
                                break;
                            case 5:
                            	cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            	money = new BigDecimal(cell.toString().trim());
                            	break;
                            case 6:
                            	cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            	inputTax = new BigDecimal(cell.toString().trim());
                            	break;
                            default:
                                break;
                        }
                    }
                }
                pDao.clear();
                pDao.setConditionProjectCode("=", projectCode);
                if(null == pDao.executeQueryOneRow()){
                    allerror++;
                    log.append(String.format("第%1$d行数据异常, 项目编号:%2$s [没有在ERP系统找到该项目编号的项目]<br/>", i+1, projectCode));
                    continue;
                }
                //加载报销科目和报销选项
                SubjectType subjectTypeDao = new SubjectType();
                //查询报销科目
                subjectTypeDao.setConditionSubjectName("=" , subject);
                subjectTypeDao.setConditionParentId("=", 0);
                String sql = "SELECT subject_type_id FROM subject_departments where subject_type_id IN(select subject_type_id from subject_process_types where process_type_id = 3) and department_id = "+ departmentId;
//                BaseSubjectType baseSubjectType = subjectTypeDao.executeQueryOneRow(String.format("subject_type_id in ("+ + ")" , sql));
                BaseSubjectType baseSubjectType = subjectTypeDao.executeQueryOneRow("subject_type_id in ("+ sql + ")");
                if (null == baseSubjectType){
                    allerror++;
                    log.append(String.format("第%1$d行数据异常,报销科目:%2$s [没有在ERP系统找到该报销科目]<br/>", i+1, baseSubjectType));
                    continue;
                }
                BaseSubjectType baseSubjectType2 = new BaseSubjectType();
                System.out.println("-----------------------------------------------------------------------------------------------------" + childSubject);
                if (!BaseHelpUtils.isNullOrEmpty(childSubject)){
                    subjectTypeDao.clear();
                    subjectTypeDao.setConditionParentId("=" ,baseSubjectType.getSubjectTypeId());
                    subjectTypeDao.setConditionSubjectName("=", childSubject);
                    baseSubjectType2 = subjectTypeDao.executeQueryOneRow("subject_type_id in ("+ sql + ")");
                    if (null == baseSubjectType2){
                        allerror++;
                        log.append(String.format("第%1$d行数据异常,报销选项:%2$s [没有在ERP系统找到该报销选项]<br/>", i+1, baseSubjectType2));
                        continue;
                    }
                }
                allsuccess++;
                bean.setMainItemId(baseSubjectType.getSubjectTypeId());
                if (!BaseHelpUtils.isNullOrEmpty(childSubject)){
                    bean.setSubItemId(baseSubjectType2.getSubjectTypeId());
                }
                bean.setRemark(remark);
                bean.setProjectId(pDao.getMainProjectId());
//                bean.setPlateId(pDao.getPlateId());
                bean.setContractCode(pDao.getProjectCode());
                bean.setAmount(money);
                bean.setInputTax(inputTax);
                bean.setFinalAmount(money.subtract(inputTax));
                bean.setInputTax(BigDecimal.ZERO);
                
				rblList.add(bean);
				
            }
        }
        if (allerror > 0) {
        	status = 2;
            log.append("<br/>总共：").append(allerror).append("条没有导入").append("<br/>原因：根据项目编号没有匹配到ERP系统的项目");
        } 
        bc.setCollections(rblList);
        return bc.toJSON(status, log.toString());
	}

	
	private String onUploadLinkDepartment(File file, Map<String,Object> param) throws Exception {
		int status = 1;
		BaseCollection<BaseNormalReimbursementLinkDepartment> bc = new BaseCollection<>();
		List<BaseNormalReimbursementLinkDepartment> rblList = new ArrayList<>();
        BaseNormalReimbursementLinkDepartment bean;
        String departmentId = BaseHelpUtils.getString(param.get("departmentId"));
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets();
        //初始化行数
        int countRow;
        StringBuilder log = new StringBuilder("错误信息提示<br/>");
        int allerror = 0;
        int allsuccess = 0;
        Date currentDate = new Date();
        Department dDao = new Department(); 
        for (int m = 0; m < count; m++) {
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(m);

            countRow = sheet.getLastRowNum();
            // 初始化列数
            int countCol;
            for (int i = 1; i < countRow + 1; i++) {
                // 创建一个行对象,并从第二行开始读取
                String subject = null;
                String childSubject = null;
                String remark = null;
                String departmentName = null;
                BigDecimal money = BigDecimal.ZERO;
                BigDecimal inputTax = BigDecimal.ZERO;
                
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                bean = new BaseNormalReimbursementLinkDepartment();
                for (int j = 0; j < countCol+1; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                    	
                        switch (j) {
                            case 0:
                                cell.setCellType(cell.CELL_TYPE_STRING);
                                subject = BaseHelpUtils.getString(cell.toString().trim());
                                break;
                            case 1:
                                cell.setCellType(cell.CELL_TYPE_STRING);
                                childSubject = BaseHelpUtils.getString(cell.toString().trim());
                                break;
                            case 2:
                                cell.setCellType(cell.CELL_TYPE_STRING);
                                remark = BaseHelpUtils.getString(cell.toString().trim());
                                break;
                            case 3:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	departmentName = BaseHelpUtils.getString(cell.toString().trim());
                                break;
                            case 4:
                            	cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            	money = new BigDecimal(cell.toString().trim());
                            	break;
                            case 5:
                            	cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            	inputTax = new BigDecimal(cell.toString().trim());
                            	break;
                            default:
                                break;
                        }
                    }
                }
                dDao.clear();
                dDao.setConditionDepartmentName("=", departmentName);
                if(null == dDao.executeQueryOneRow()){
                    allerror++;
                    log.append(String.format("第%1$d行数据异常, 项目:%2$s [没有在ERP系统找到该部门名称的部门]<br/>", i+1, departmentName));
                    continue;
                }
                //加载报销科目和报销选项
                SubjectType subjectTypeDao = new SubjectType();
                //查询报销科目
                subjectTypeDao.setConditionSubjectName("=" , subject);
                subjectTypeDao.setConditionParentId("=", 0);
                String sql = "SELECT subject_type_id FROM subject_departments where subject_type_id IN(select subject_type_id from subject_process_types where process_type_id = 3) and department_id = "+ departmentId;
//                BaseSubjectType baseSubjectType = subjectTypeDao.executeQueryOneRow(String.format("subject_type_id in ("+ + ")" , sql));
                BaseSubjectType baseSubjectType = subjectTypeDao.executeQueryOneRow("subject_type_id in ("+ sql + ")");
                if (null == baseSubjectType){
                    allerror++;
                    log.append(String.format("第%1$d行数据异常,报销科目:%2$s [没有在ERP系统找到该报销科目]<br/>", i+1, baseSubjectType));
                    continue;
                }
                BaseSubjectType baseSubjectType2 = new BaseSubjectType();
                System.out.println("-----------------------------------------------------------------------------------------------------" + childSubject);
                if (!BaseHelpUtils.isNullOrEmpty(childSubject)){
                    subjectTypeDao.clear();
                    subjectTypeDao.setConditionParentId("=" ,baseSubjectType.getSubjectTypeId());
                    subjectTypeDao.setConditionSubjectName("=", childSubject);
                    baseSubjectType2 = subjectTypeDao.executeQueryOneRow("subject_type_id in ("+ sql + ")");
                    if (null == baseSubjectType2){
                        allerror++;
                        log.append(String.format("第%1$d行数据异常,报销选项:%2$s [没有在ERP系统找到该报销选项]<br/>", i+1, baseSubjectType2));
                        continue;
                    }
                }
                allsuccess++;
                bean.setMainItemId(baseSubjectType.getSubjectTypeId());
                if (!BaseHelpUtils.isNullOrEmpty(childSubject)){
                    bean.setSubItemId(baseSubjectType2.getSubjectTypeId());
                }
                bean.setRemark(remark);
                bean.setAmount(money);
                bean.setDepartmentId(dDao.getDepartmentId());
                bean.setInputTax(inputTax);
                bean.setFinalAmount(money.subtract(inputTax));
                bean.setInputTax(BigDecimal.ZERO);
                
				rblList.add(bean);
				
            }
        }
        if (allerror > 0) {
        	status = 2;
            log.append("<br/>总共：").append(allerror).append("条没有导入").append("<br/>原因：根据部门没有匹配到ERP部门");
        } 
        bc.setCollections(rblList);
        return bc.toJSON(status, log.toString());
	}
}
