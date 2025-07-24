package pomplatform.common.business;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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

import com.pomplatform.db.bean.BaseCustomerResource;
import com.pomplatform.db.dao.CustomerResource;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericUploadProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

/**
 * 导入公用的process
 * @author 
 */
public class OnCommonImportProcess implements GenericUploadProcessor {
    private static Logger __logger = Logger.getLogger("");
  //操作类型
    private static final String OPT_TYPE = "optType";
    //加载业务部门下拉数据集
    private static final String ON_UPLOAD_CUSTOMER_RESCOURCES = "onUploadCustomerRescources";
	@Override
    public String execute(String creteria, HttpServletRequest request, List<FileItem> items) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(param,OPT_TYPE);
        String errorMesg = "";
        BaseCollection<GenericBase>bc = new BaseCollection<>();
        for (FileItem fileItem : items) {
        	File file = File.createTempFile("DelicacyUploadFiles",UUID.randomUUID().toString());
            fileItem.write(file);
            if(ON_UPLOAD_CUSTOMER_RESCOURCES.equals(optType)){
            	errorMesg = onUploadCustomerRescources(file);
            }
            file.delete();
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
	private String onUploadCustomerRescources(File file) throws Exception {
		CustomerResource dao = new CustomerResource();
        BaseCustomerResource bean;
        List<BaseCustomerResource> list = new ArrayList<>();
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
            for (int i = 1; i < countRow+1; i++) {
                // 创建一个行对象,并从第二行开始读取
                Date recordDate = null;
                String date = null;
                Row row = sheet.getRow(i);
                if (BaseHelpUtils.isNullOrEmpty(row)) {
                    break;
                }
                //获取每一行的列数
                countCol = row.getLastCellNum();
                dao.clear();
                bean = new BaseCustomerResource();
                list.add(bean);
                for (int j = 0; j < countCol+1; j++) {
                    // 创建一个列单元对象
                    Cell cell = row.getCell(j);
                    if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                        switch (j) {
                            case 1:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	String companyName = BaseHelpUtils.getString(cell.toString().trim());
                            	bean.setCompanyName(companyName);
                                break;
                            case 2:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                                String companyAdress = BaseHelpUtils.getString(cell.toString().trim());
                                bean.setCompanyAddress(companyAdress);
                            	break;
                            case 3:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	String customeName = BaseHelpUtils.getString(cell.toString().trim());
                            	bean.setName(customeName);
                            	break;
                            case 4:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	String grade = BaseHelpUtils.getString(cell.toString().trim());
                            	bean.setGrade(grade);
                            	break;
                            case 5:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	String telephone = BaseHelpUtils.getString(cell.toString().trim());
                            	bean.setTelephone(telephone);
                            	break;
                            case 6:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	String email = BaseHelpUtils.getString(cell.toString().trim());
                            	bean.setEmail(email);
                            	break;
                            case 7:
                            	cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                                Date theDate = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                                SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
                                date = sdf.format(theDate);  
                                recordDate = sdf.parse(date);
                                bean.setBirthDate(recordDate);
                                break;
                            case 8:
                            	cell.setCellType(Cell.CELL_TYPE_STRING);
                            	int gender = BaseHelpUtils.getIntValue(cell.toString().trim());
                            	bean.setGender(gender);
                            	break;
                            default:
                                break;
                        }
                    }
                }
            }
            if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
            	dao.save(list);
            }
        }
        return null;
	}

}
