package pomplatform.supplierworkflow.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.pomplatform.db.bean.BaseSupplier;
import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.dao.Supplier;
import com.pomplatform.db.dao.SystemDictionary;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericUploadProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class OnUploadSupplierInfo  implements GenericUploadProcessor {
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
			errorMesg = UploadSupplierInfo(fullName,param);
			fullName.delete();
		}
		if (BaseHelpUtils.isNullOrEmpty(errorMesg)) {
			return bc.toJSON(0, null);
		} else {
			return bc.toJSON(-1, errorMesg);
		}
	}


	private String UploadSupplierInfo(File file,Map<String,Object> param) throws Exception {
		Supplier dao=new Supplier();
		dao.unsetSelectFlags();
		dao.setSelectSupplierType(true);
		dao.setSelectSupplierName(true);
		dao.setSelectSupplierContact(true);
		dao.setSelectSupplierPhone(true);
		dao.setSelectSupplierEmail(true);
		dao.setSelectTeamSize(true);
		dao.setSelectAreasExpertise(true);
		BaseSupplier bean;

		SystemDictionary  sDao=new SystemDictionary();
		BaseSystemDictionary  sbean=new BaseSystemDictionary();

		// 把一张xls的数据表读到wb里
		Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
		// 获取sheet数
		int count = workbook.getNumberOfSheets();
		//初始化行数
		int countRow;
		StringBuilder log = new StringBuilder("导入供应商信息提示<br/>");
		StringBuilder errType = new StringBuilder();
		StringBuilder errName = new StringBuilder();
		int err = 0;
		for (int m = 0; m < count; m++) {
			// 一般一个excel文件会有三个工作表，这里默认读取第一页
			Sheet sheet = workbook.getSheetAt(m);
			countRow = sheet.getLastRowNum();
			// 初始化列数
			int countCol;
			for (int i = 1; i < countRow + 1; i++) {
				// 创建一个行对象,并从第二行开始读取
				Integer teamSize=null,areasExpertise=null;
				String supplierName=null,supplierContact=null,supplierPhone=null,supplierEmail=null,supplierType=null;

				Row row = sheet.getRow(i);
				if (BaseHelpUtils.isNullOrEmpty(row)) {
					break;
				}
				//获取每一行的列数
				countCol = row.getLastCellNum();
				bean= new BaseSupplier();
				for (int j = 0; j < countCol+1; j++) {
					// 创建一个列单元对象
					Cell cell = row.getCell(j);
					if (!BaseHelpUtils.isNullOrEmpty(cell)) {
						switch (j) {
						case 0:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							supplierType = BaseHelpUtils.getString((cell.toString().trim()));
							break;
						case 1:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							supplierName = BaseHelpUtils.getString((cell.toString().trim()));
							break;
						case 2:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							supplierContact = BaseHelpUtils.getString((cell.toString().trim()));
							break;
						case 3:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							supplierPhone = BaseHelpUtils.getString((cell.toString().trim()));
							break;
						case 4:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							supplierEmail = BaseHelpUtils.getString((cell.toString().trim()));
							break;
						case 5:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							teamSize = BaseHelpUtils.getIntValue((cell.toString().trim()));
							break;
						case 6:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							areasExpertise = BaseHelpUtils.getIntValue((cell.toString().trim()));
							break;
						}
					}
				}
				dao.setConditionSupplierName("=", supplierName);
				if(!dao.isExist()) {
					sDao.clear();
					sDao.setConditionDicTypeId("=", 229);
					sDao.setConditionDicTypeValue("=", supplierType);
					sbean=sDao.executeQueryOneRow();
					int supplierTypes=BaseHelpUtils.getIntValue(sbean.getDicTypeValueId());
					if(!BaseHelpUtils.isNullOrEmpty(supplierTypes)&&supplierTypes>0) {
						bean.setSupplierType(supplierTypes);
						bean.setSupplierName(supplierName);
						bean.setSupplierContact(supplierContact);
						bean.setSupplierPhone(supplierPhone);
						bean.setSupplierEmail(supplierEmail);
						bean.setTeamSize(teamSize);
						bean.setAreasExpertise(areasExpertise);
						bean.setIsUse(1);
						dao.clear();
						dao.setDataFromBase(bean);
						dao.save();
					}else {
						err++;
						if(errType.length()>0) {
							errType.append(",");
						}
						errType.append(supplierType);
					}
				}else {
					err++;
					if(errName.length()>0) {
						errName.append(",");
					}
					errName.append(supplierName);
				}
			}
		}
		 if (err > 0) {
			 log.append("<br/>总共：").append(err).append("条数据未导入成功");
			 if(errType.length()>0) {
				 log.append("<br/>其中供应商类型【"+errType+"】匹配失败");
			 }
			 if(errName.length()>0) {
				 log.append("<br/>其中供应商【"+errName+"】已存在");
			 }
	            System.out.print(log.toString());
	            return log.toString();
	        } else {
	            return null;
	        }
	}
	
	
	public static void main(String[] args) {
		OnUploadSupplierInfo a=new OnUploadSupplierInfo();
		File file=new File("D:\\supplierInfo.xlsx");
		try {
			a.UploadSupplierInfo(file,new HashMap<>());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
