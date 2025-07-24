package pomplatform.salaryemployeeevaluationrmmor.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.locks.Condition;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.*;
import com.pomplatform.db.dao.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.DES;
import delicacy.common.GenericBase;
import delicacy.common.GenericUploadProcessor;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import pomplatform.department.business.RoleEmployee;

public class UploadInitSystemDataProcess implements GenericUploadProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request, List<FileItem> items) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		@SuppressWarnings("unchecked")
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
		String errorMesg = "";
		BaseCollection bc = new BaseCollection();
		if (items.size() > 0) {
			File file = File.createTempFile("DelicacyUploadFiles", UUID.randomUUID().toString());
			items.get(0).write(file);
			if (BaseHelpUtils.getIntValue(param, "type") == 1) {
				onUpload(file);
			}
			if (BaseHelpUtils.getIntValue(param, "type") == 2) {
//				onUploadHistoryDate(file);
			}
		}
		SystemInitLog silDao = new SystemInitLog();
		silDao.setType(BaseHelpUtils.getIntValue(param, "type"));
		silDao.setFlag(1);
		silDao.save();
		if (BaseHelpUtils.isNullOrEmpty(errorMesg)) {
			return bc.toJSON(0, null);
		} else {
			return bc.toJSON(-1, errorMesg);
		}
	}

	private static void onUpload(File file) throws Exception {
		// 将指定路径的数据读取到workbook中
		Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
		// 获取workbook的sheet数
		int count = workbook.getNumberOfSheets();
		for (int i = 0; i < count; i++) {
			// 遍历每一个sheet
			Sheet sheet = workbook.getSheetAt(i);
			// 获取每个sheet的名称
			String sheetName = BaseHelpUtils.getString(sheet.getSheetName());
			switch (sheetName) {
//				case "字典表":
////					onUploadSystemDictionary(sheet);
//					break;
//				case "角色表":
//					onUploadRoles(sheet);
//					break;
//				case "公司表":
////					onUploadCompanyRecords(sheet);
//					break;
//				case "业务部门表":
////					onUploadPlateRecord(sheet);
//					break;
//				case "部门表":
////					onUploadDepartment(sheet);
//					break;
//				case "职位表":
////					onUploadDuty(sheet);
//					break;
//				case "职员表":
//					onUploadEmployee(sheet);
//					break;
//				case "个人卡号管理":
//					onUploadCardPerson(sheet);
//					break;
//				case "公司卡号管理":
//					onUploadCardCompany(sheet);
//					break;
//				case "报销科目":
//					onUploadSubjectType(sheet);
//					break;
//				case "收款单位":
//					onUploadReceiveUnitManage(sheet);
//					break;
//				case "Sheet1":
//					onUploadEmployeeRoles(sheet);
//					break;
//				case "Sheet2":
//					onUploadEmployeeAnnualLeave(sheet);
//				case "capitals":
//					onUploadCapitals(sheet);
//				case "打卡明细":
//					onUploadCheckDetail(sheet);
//				case "合同文件":
//					onUploadOrSaveContract(sheet);
//				case "报销科目":
//					onUploadSubjectType(sheet);
//					break;
//				case "公司K3代码维护":
//					onUploadCompanyK3(sheet);
//					break;
//			case "员工K3代码维护":
//				onUploadEmployeeK3(sheet);
//				break;
//				case "科目K3代码维护":
//					onUploadSubjectK3(sheet);
//					break;
//				case "收款单位K3代码维护":
//					onUploadCollectionUnit(sheet);
//					break;
//				case "客户K3代码维护":
//					onUploadCustomerK3(sheet);
//					break;
//				case "客户管理":
//					onUploadCustomer(sheet);
//					break;
//				case "年假":
//					onUploadAnnual(sheet);
//					break;
/*				case "人员角色":
					onUploadEmployeeRoles(sheet);
					break;*/
//				case "前期项目":
//					onUploadPreProjects(sheet);
//					break;
				case "立项项目":
					onUploadMainProject(sheet);
					break;
//				case "项目业务类别":
//					onUploadProjectBusinessCategory(sheet);
//					break;
//				case "项目参与专业":
//					onUploadProjectParticipation(sheet);
//					break;
//				case "项目阶段":
//					onuploadProjectStage(sheet);
//					break;
			default:
				break;
			}

		}

	}

	/**
	 * @author liubin
	 * @description //TODO 项目阶段
	 * @date 13:23 2020/2/18
	 * @param
	 * @return
	 **/
	private static void onuploadProjectStage(Sheet sheet) throws SQLException {
		List<BaseProjectStage> lists = new ArrayList<>();
		Integer mainProjectId = 0;
		//初始化行数
		int countRow = 0;
		int countCol = 0;
		MainProjectStage mainProjectStage = new MainProjectStage();
		ProjectStage projectStage = new ProjectStage();
		MainProject mainProject = new MainProject();
		countRow = sheet.getLastRowNum();
		for (int j = 1; j<=countRow; j++){
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)){
				break;
			}
			//初始化每行数据
			String projectCode = null;
			Integer stageId = null;
			BigDecimal stageRate = null;
			String temp1 = null;
			//获取每一行的列数
			countCol = row.getLastCellNum();
			for (int i = 0; i<=countCol + 1; i++){
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)){
					switch (i){
						case 0:
							//项目编号
							cell.setCellType(Cell.CELL_TYPE_STRING);
							projectCode = cell.getStringCellValue();
							break;
						case 1:
							//项目编号
							cell.setCellType(Cell.CELL_TYPE_STRING);
							temp1 = cell.getStringCellValue();
							//替换项目阶段
							mainProjectStage.clear();
							mainProjectStage.setConditionMainStageName("=", temp1);
							BaseMainProjectStage baseMainProjectStage = mainProjectStage.executeQueryOneRow();
							if (null == baseMainProjectStage) {
								stageId = 0;
							} else {
								stageId = baseMainProjectStage.getMainStageId();
							}
							break;
						case 2:
							//比例
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String temp2 = cell.getStringCellValue();
							stageRate = BaseHelpUtils.getBigDecimalValue(temp2);
						default:
							break;

					}
				}
			}

			mainProject.clear();
			mainProject.setConditionProjectCode("=", projectCode);
			if (mainProject.isExist()) {
				BaseMainProject baseMainProject = mainProject.executeQueryOneRow();
				mainProjectId = baseMainProject.getMainProjectId();
				BaseProjectStage baseProjectStage = new BaseProjectStage();
				baseProjectStage.setMainProjectId(mainProjectId);
				baseProjectStage.setProjectStageId(stageId);
				baseProjectStage.setPercent(stageRate);
				baseProjectStage.setStageName(temp1);

				if (BaseHelpUtils.isNullOrEmpty(stageId) || stageId == 0) {
					continue;
				}
				lists.add(baseProjectStage);
			}
			projectStage.clear();
			projectStage.setConditionMainProjectId("=", mainProjectId);
			projectStage.conditionalDelete();
		}

		projectStage.clear();
		projectStage.save(lists);
	}

	/**
	 * @author liubin
	 * @description //TODO 项目参与专业
	 * @date 13:00 2020/2/18
	 * @return
	 **/
	private static void onUploadProjectParticipation(Sheet sheet) throws SQLException {
		Integer mainProjectId = 0;
		List<BaseMainProjectSpecialty> lists = new ArrayList<>();
		//初始化行数
		int countRow = 0;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		PmSpecial pmSpecial = new PmSpecial();
		MainProject mainProject = new MainProject();
		MainProjectSpecialty mainProjectSpecialty = new MainProjectSpecialty();
		for (int j = 1; j<=countRow; j++){
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)){
				break;
			}
			//初始化每行数据
			String projectCode = null;
			Integer projectParticipation = null;
			Integer employeeName = null;
			Boolean isOutscource = null;

			//获取每一行的列数
			countCol = row.getLastCellNum();
			for (int i = 0; i<=countCol + 1; i++){
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)){
					switch (i){
						case 0:
							//项目编号
							cell.setCellType(Cell.CELL_TYPE_STRING);
							projectCode = cell.getStringCellValue();
							break;
						case 1:
							//参与专业
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String temp1 = cell.getStringCellValue();
							//替换项目参与的专业
							pmSpecial.clear();
							pmSpecial.setConditionSpecialName("=", temp1);
							BasePmSpecial basePmSpecial = pmSpecial.executeQueryOneRow();
							if (null == basePmSpecial) {
								projectParticipation = 0;
							} else {
								projectParticipation = basePmSpecial.getPmSpecialId();
							}
							break;
						case 2:
							//人员
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String temp2 = cell.getStringCellValue();
							employeeName = getEmployeeIdByName(temp2);
							break;
						case 3:
							//是否外包
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String temp3 = cell.getStringCellValue();
							switch (temp3) {
								case "是":
									isOutscource = true;
									break;
								case "否":
									isOutscource = false;
									break;
								default:
									isOutscource = false;
									break;
							}
							break;
						default:
							break;
					}
				}
			}

			//处理数据
			mainProject.clear();
			mainProject.setConditionProjectCode("=", projectCode);
			if (mainProject.isExist()) {
				BaseMainProject baseMainProject = mainProject.executeQueryOneRow();
				mainProjectId = baseMainProject.getMainProjectId();

				BaseMainProjectSpecialty baseMainProjectSpecialty = new BaseMainProjectSpecialty();
				baseMainProjectSpecialty.setMainProjectId(mainProjectId);
				baseMainProjectSpecialty.setIsOutsourcing(isOutscource);
				baseMainProjectSpecialty.setSpecialtyId(projectParticipation);
				baseMainProjectSpecialty.setRegistrationSealEmployeeId(employeeName);


				if (BaseHelpUtils.isNullOrEmpty(projectParticipation) || projectParticipation == 0) {
					continue;
				}
				mainProjectSpecialty.clear();
				mainProjectSpecialty.setConditionMainProjectId("=", mainProjectId);
				mainProjectSpecialty.conditionalDelete();

				lists.add(baseMainProjectSpecialty);
			}
		}

		mainProjectSpecialty.clear();
		mainProjectSpecialty.save(lists);
	}

	/**
	 * @author liubin
	 * @description //TODO : 更新项目业务类别
	 * @date 10:59 2020/2/18
	 * @param
	 * @return
	 **/
	private static void onUploadProjectBusinessCategory(Sheet sheet) throws SQLException {
		Integer mainProjectId = 0;
		List<BaseMainProjectBusinessType> lists = new ArrayList<>();
		//初始化行数
		int countRow = 0;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		MainProjectBusinessType mainProjectBusinessType = new MainProjectBusinessType();
		MainProject mainProject = new MainProject();
		for (int j = 1; j<=countRow; j++){
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)){
				break;
			}
			//初始化每行数据
			String projectCode = null;
			Integer projectCategory = null;
			String area = null;
			String outputValue = null;
			//获取每一行的列数
			countCol = row.getLastCellNum();
			String temp1 = "";
			for (int i = 0; i<=countCol + 1; i++){
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)){
					switch (i){
						case 0:
							//项目编号
							cell.setCellType(Cell.CELL_TYPE_STRING);
							projectCode = cell.getStringCellValue();
							break;
						case 1:
							// 业务类别
							cell.setCellType(Cell.CELL_TYPE_STRING);
							temp1 = cell.getStringCellValue();
							//替换业务类别
							ProductionValueCoefficientType productionValueCoefficientType = new ProductionValueCoefficientType();
							productionValueCoefficientType.setConditionCoefficientType("=", temp1);
							BaseProductionValueCoefficientType baseProductionValueCoefficientType = productionValueCoefficientType.executeQueryOneRow();
							if (null == baseProductionValueCoefficientType) {
								projectCategory = 0;
							} else {
								projectCategory = baseProductionValueCoefficientType.getProductionValueCoefficientTypeId();
							}
							break;
						case 2:
							// 面积
							cell.setCellType(Cell.CELL_TYPE_STRING);
							area = cell.getStringCellValue();
							break;
						case 3:
							// 产值
							cell.setCellType(Cell.CELL_TYPE_STRING);
							outputValue = cell.getStringCellValue();
							break;
						default:
							break;
					}
				}
			}

			mainProject.clear();
			mainProject.setConditionProjectCode("=", projectCode);

			if (mainProject.isExist()) {
				BaseMainProject baseMainProject = mainProject.executeQueryOneRow();
				mainProjectId = baseMainProject.getMainProjectId();
				BaseMainProjectBusinessType baseMainProjectBusinessType = new BaseMainProjectBusinessType();
				baseMainProjectBusinessType.setMainProjectId(mainProjectId);
				baseMainProjectBusinessType.setBusinessType(projectCategory);
				baseMainProjectBusinessType.setArea(BaseHelpUtils.getBigDecimalValue(area));
				baseMainProjectBusinessType.setOutputValue(BaseHelpUtils.getBigDecimalValue(outputValue));


				if (BaseHelpUtils.isNullOrEmpty(projectCategory) || projectCategory == 0) {
					continue;
				}

				lists.add(baseMainProjectBusinessType);
				mainProjectBusinessType.clear();
				mainProjectBusinessType.setConditionMainProjectId("=", mainProjectId);
				mainProjectBusinessType.conditionalDelete();
				//更新大项目表的业务类别
				String businessType = baseMainProject.getBusinessType();
				if (BaseHelpUtils.isNullOrEmpty(businessType)) {
					businessType = temp1;
				} else {
					businessType = businessType + "," + temp1;
				}
				baseMainProject.setBusinessType(businessType);



			}
		}

		mainProjectBusinessType.clear();
		mainProjectBusinessType.save(lists);
	}

	/**
	 * @author liubin
	 * @description //TODO 立方的前期项目的数据的导入
	 * @date 9:30 2020/2/17
	 * @param
	 * @return
	 **/
	private static void onUploadPreProjects(Sheet sheet) throws SQLException {
		//初始化行数
		int countRow = 0;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		SystemDictionary systemDictionary = new SystemDictionary();
		com.pomplatform.db.dao.Employee employee = new com.pomplatform.db.dao.Employee();
		PreProject preProject = new PreProject();
		for (int j = 1; j <= countRow; j++) {
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			//初始化每行数据
			//信息编号
			String infoCode = null;
			//项目名称
			String projectName = null;
			//客户名称
			String customerName = null;
			//项目类别
			String projectType = null;
			//项目地址（省）
			String province = null;
			//项目地址（市）
			String city = null;
			//项目地址
			String detailAddress = null;
			//项目状态
			String projectStatus = null;
			//报备人
			String applyEmployeeId = null;
			//登记时间
			Date createTime = null;
			//项目来源渠道
			String projectOrigination = null;
			//比选形式
			String comparisonForm = null;
			//客户联系人
			String contactName = null;
			//客户联系电话
			String contactPhone = null;
			//联系人职位
			String grade = null;
			//获取每一行的列数
			countCol = row.getLastCellNum();
			for (int i = 0; i <= countCol + 1; i++) {
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
						case 0:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							infoCode = cell.getStringCellValue();
							break;
						case 1:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							projectName = cell.getStringCellValue();
							break;
						case 2:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							customerName = cell.getStringCellValue();
							break;
						case 3:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							projectType = cell.getStringCellValue();
							break;
						case 4:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							province = cell.getStringCellValue();
							break;
						case 5:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							city = cell.getStringCellValue();
							break;
						case 6:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							detailAddress = cell.getStringCellValue();
							break;
						case 7:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							projectStatus = cell.getStringCellValue();
							break;
						case 8:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							applyEmployeeId = cell.getStringCellValue();
							break;
						case 9:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String tempDate1 = cell.getStringCellValue();
							if (!BaseHelpUtils.isNullOrEmpty(tempDate1)) {
								createTime = strToDate(tempDate1);
							}
							break;
						case 10:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							projectOrigination = cell.getStringCellValue();
							break;
						case 11:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							comparisonForm = cell.getStringCellValue();
							break;
						case 12:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							contactName = cell.getStringCellValue();
							break;
						case 13:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							contactPhone = cell.getStringCellValue();
							break;
						case 14:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							grade = cell.getStringCellValue();
							break;
						default:
							break;

					}
				}
			}
			//新增前期项目，如果有的话直接更新
			Boolean flag = true;
			preProject.clear();
			preProject.setConditionInfoCode("=", infoCode);
			BasePreProject basePreProject = preProject.executeQueryOneRow();
			if (null == basePreProject) {
				basePreProject = new BasePreProject();
			} else {
				flag = false;
			}
			//替换必选形式
			systemDictionary.clear();
			systemDictionary.setConditionDicTypeId("=", 168);
			systemDictionary.setConditionDicTypeValue("=", comparisonForm);
			BaseSystemDictionary baseSystemDictionary = systemDictionary.executeQueryOneRow();
			if (null != baseSystemDictionary) {
				Integer dicTypeValueId = baseSystemDictionary.getDicTypeValueId();
				basePreProject.setComparisonForm(dicTypeValueId);
			}
			//替换项目类别
			systemDictionary.clear();
			systemDictionary.setConditionDicTypeId("=", 244);
			systemDictionary.setConditionDicTypeValue("=",projectType);
			BaseSystemDictionary temp1 = systemDictionary.executeQueryOneRow();
			if (null != temp1) {
				Integer dicTypeValueId = temp1.getDicTypeValueId();
				basePreProject.setProjectType(dicTypeValueId);
//				basePreProject.setProjectLevel(dicTypeValueId);
			}
			//替换项目报备人
			employee.clear();
			employee.setConditionEmployeeName("=", applyEmployeeId);
			com.pomplatform.db.bean.BaseEmployee baseEmployee = employee.executeQueryOneRow();
			if (null != baseEmployee) {
				Integer employeeId = baseEmployee.getEmployeeId();
				basePreProject.setApplyEmployeeId(employeeId);
			}
			basePreProject.setInfoCode(infoCode);
			basePreProject.setProjectName(projectName);
			basePreProject.setCustomerName(customerName);
			basePreProject.setProvince(province);
			basePreProject.setCity(city);
			basePreProject.setDetailAddress(detailAddress);
			basePreProject.setProjectStatus(projectStatus);
			basePreProject.setCreateTime(createTime);
			basePreProject.setProjectOrigination(projectOrigination);
			basePreProject.setContactName(contactName);
			basePreProject.setContactPhone(contactPhone);
			basePreProject.setGrade(grade);
			if (flag) {
				preProject.setDataFromBase(basePreProject);
				preProject.save();
			} else {
				preProject.setDataFromBase(basePreProject);
				preProject.update();
			}
		}
	}

	/**
	 * @author liubin
	 * @description //TODO 基础模板
	 * @date 9:35 2020/2/17
	 * @param
	 * @return
	 **/
	private static void stand(Sheet sheet) {
		//初始化行数
		int countRow = 0;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		for (int j = 1; j<countRow; j++){
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)){
				break;
			}
			//初始化每行数据

			//获取每一行的列数
			countCol = row.getLastCellNum();
			for (int i = 0; i<=countCol + 1; i++){
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)){
					switch (i){

						default:
							break;

					}
				}
			}
		}
	}

	/**
	 * 更新年假的数据
	 * @param sheet
	 */
	private static void onUploadAnnual(Sheet sheet) throws SQLException {
		//初始化行数
		int countRow = 0;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		for (int j = 1; j<countRow; j++){
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)){
				break;
			}
			String totalAnnualLeave = null;
			String employeeName = null;
			//获取每一行的列数
			countCol = row.getLastCellNum();
			for (int i = 0; i<=countCol + 1; i++){
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)){
					switch (i){
						case 0:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							employeeName = cell.getStringCellValue();
							break;
						case 1:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							totalAnnualLeave = cell.getStringCellValue();
							break;
						default:
							break;

					}
				}
			}

			com.pomplatform.db.dao.Employee employee = new com.pomplatform.db.dao.Employee();
			employee.setConditionEmployeeName("=", employeeName);
			com.pomplatform.db.bean.BaseEmployee baseEmployee = employee.executeQueryOneRow();
			if (!BaseHelpUtils.isNullOrEmpty(baseEmployee)) {
				String employeeNo = baseEmployee.getEmployeeNo();
				AnnualLeave annualLeave = new AnnualLeave();
				annualLeave.setConditionEmployeeNo("=" , employeeNo);
				annualLeave.setConditionYear("=" , 2019);
				BaseAnnualLeave baseAnnualLeave = annualLeave.executeQueryOneRow();
				if (null != baseAnnualLeave){
					annualLeave.clear();
					baseAnnualLeave.setUsageAmountAnnual(BaseHelpUtils.getBigDecimalValue(totalAnnualLeave));
					annualLeave.setDataFromBase(baseAnnualLeave);
					annualLeave.update();
				}
			}
		}
	}

	/**
	 * @author liubin
	 * @date 2019/12/12 11:22
	 * @param [sheet]
	 * @return void
	 * @description:
	 */
	private static void onUploadCustomer(Sheet sheet) throws SQLException {
		int countRow = 0;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		Customer customer = new Customer();
		CustomerContact customerContact = new CustomerContact();
		for (int j = 1; j < countRow; j++) {
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			// 获取每一行的列数
			countCol = row.getLastCellNum();
			String customerName = null;
			String parentCustomerName = null;
			Integer customerId = null;
			Integer parentCustomerId = null;
			String phone = null;
			//省份
			String province = null;
			//市
			String city = null;
			//详细地址
			String companyAddress = null;
			//传真
			String companyFax = null;
			//主要联系人
			String primaryContact = null;
			//座机
			String landline = null;
			//移动电话
			String mobilePhone = null;
			//其他联系人
			String otherContact = null;
			//电话
			String phone1 = null;
			for (int i = 0; i <= countCol + 1; i++) {
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
						case 0:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							customerName = cell.getStringCellValue();
							break;
						case 1:
							//联系电话
							cell.setCellType(Cell.CELL_TYPE_STRING);
							phone = cell.getStringCellValue();
							break;
						case 2:
							//传真
							cell.setCellType(Cell.CELL_TYPE_STRING);
							companyFax = cell.getStringCellValue();
							break;
						case 3:
							//地址（省）
							cell.setCellType(Cell.CELL_TYPE_STRING);
							province = cell.getStringCellValue();
							break;
						case 4:
							//市
							cell.setCellType(Cell.CELL_TYPE_STRING);
							city = cell.getStringCellValue();
							break;
						case 5:
							//详细地址
							cell.setCellType(Cell.CELL_TYPE_STRING);
							companyAddress = cell.getStringCellValue();
							break;
						case 6:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String stringCellValue = cell.getStringCellValue();
							// 父级客户为空则表明是一级客户
							if (BaseHelpUtils.isNullOrEmpty(stringCellValue)) {
								parentCustomerId = 0;
							} else {
								customer.clear();
								customer.setConditionCustomerName("=", stringCellValue);
								if (customer.isExist()) {
									BaseCustomer baseCustomer = customer.executeQueryOneRow();
									Integer customerId1 = baseCustomer.getCustomerId();
									parentCustomerId = customerId1;
								}
							}
							break;
						case 7:
							//主要联系人
							cell.setCellType(Cell.CELL_TYPE_STRING);
							primaryContact = cell.getStringCellValue();
							break;
						case 8:
							//座机
							cell.setCellType(Cell.CELL_TYPE_STRING);
							landline = cell.getStringCellValue();
							break;
						case 9:
							//移动电话
							cell.setCellType(Cell.CELL_TYPE_STRING);
							mobilePhone = cell.getStringCellValue();
							break;
						case 10:
							//其他联系人
							cell.setCellType(Cell.CELL_TYPE_STRING);
							otherContact = cell.getStringCellValue();
							break;
						case 11:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							phone1 = cell.getStringCellValue();
							break;
						default:
							break;
					}
				}
			}
			Boolean flag = false;
			//处理客户的数据
			customer.clear();
			customer.setConditionCustomerName("=", customerName);
			BaseCustomer baseCustomer = customer.executeQueryOneRow();
			if (null == baseCustomer) {
				baseCustomer = new BaseCustomer();
				flag = true;
			} else {
				flag = false;
			}

			baseCustomer.setCustomerName(customerName);
			baseCustomer.setCompanyParentName(parentCustomerName);
			baseCustomer.setParentId(parentCustomerId);
			baseCustomer.setCompanyMobile(phone);
			baseCustomer.setCompanyProvince(province);
			baseCustomer.setCompanyCity(city);
			baseCustomer.setCompanyFax(companyFax);
			baseCustomer.setCompanyAddress(companyAddress);

			customer.clear();
			customer.setDataFromBase(baseCustomer);
			if (flag) {
				customer.save();
				customerId = customer.generateBase().getCustomerId();
			} else {
				customerId = baseCustomer.getCustomerId();
				customer.update();
			}

			//处理联系人的数据
			BaseCustomerContact baseCustomerContact = new BaseCustomerContact();
			customerContact.clear();
			customerContact.setConditionCustomerId("=", customerId);
			customerContact.conditionalDelete();
			//保存主要联系人
			customerContact.clear();
			baseCustomerContact.setCustomerId(customerId);
			baseCustomerContact.setTelephone(mobilePhone);
			baseCustomerContact.setMobile(landline);
			baseCustomerContact.setName(primaryContact);
			baseCustomerContact.setEmployeeType(1);
			customerContact.setDataFromBase(baseCustomerContact);
			customerContact.save();
			//保存其他联系人
			if (!BaseHelpUtils.isNullOrEmpty(otherContact)) {
				customerContact.clear();
				baseCustomerContact.setCustomerId(customerId);
				baseCustomerContact.setTelephone(phone1);
				baseCustomerContact.setEmployeeType(2);
				baseCustomerContact.setName(otherContact);
				customerContact.setDataFromBase(baseCustomerContact);
				customerContact.save();
			}
		}
	}

	/**
	 * @author liubin
	 * @date 2019/12/12 10:44
	 * @param [sheet]
	 * @return void
	 * @description: 客户K3代码维护
	 */
	private static void onUploadCustomerK3(Sheet sheet) throws SQLException {
		int countRow = 0;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		Customer customer = new Customer();
		for (int j = 1; j < countRow; j++) {
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			// 获取每一行的列数
			countCol = row.getLastCellNum();
			for (int i = 0; i <= countCol + 1; i++) {
				Integer customerId = null;
				String K3code = null;
				String K3name = null;
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String stringCellValue = cell.getStringCellValue();
						customer.clear();
						customer.setConditionCustomerName("=", stringCellValue);
						if (customer.isExist()) {
							BaseCustomer baseCustomer = customer.executeQueryOneRow();
							customerId = baseCustomer.getCustomerId();
						}
						break;
					case 1:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						K3code = cell.getStringCellValue();
						break;
					case 2:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						K3name = cell.getStringCellValue();
						break;
					default:
						break;
					}
				}
				K3Code k3Code = new K3Code();
				BaseK3Code baseK3Code = new BaseK3Code();
				baseK3Code.setBusinessId(customerId);
				baseK3Code.setType(9);
				baseK3Code.setK3Code(K3code);
				baseK3Code.setK3Name(K3name);
				k3Code.clear();
				k3Code.setDataFromBase(baseK3Code);
				k3Code.save();
			}
		}
	}

	/**
	 * @author liubin
	 * @date 2019/12/12 10:25
	 * @param [sheet]
	 * @return void
	 * @description: 收款单位K3代码维护
	 */
	private static void onUploadCollectionUnit(Sheet sheet) throws SQLException {
		int countRow = 0;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		Employee employee = new Employee();
		ReceiveUnitManage receiveUnitManage = new ReceiveUnitManage();
		for (int j = 1; j < countRow; j++) {
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			// 获取每一行的列数
			countCol = row.getLastCellNum();
			for (int i = 0; i <= countCol + 1; i++) {
				Integer receiveUnitManageId = null;
				String K3code = null;
				String K3name = null;
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String stringCellValue = cell.getStringCellValue();
						receiveUnitManage.clear();
						receiveUnitManage.setConditionReceiveUnit("=", stringCellValue);
						if (receiveUnitManage.isExist()) {
							BaseReceiveUnitManage baseReceiveUnitManage = receiveUnitManage.executeQueryOneRow();
							receiveUnitManageId = baseReceiveUnitManage.getReceiveUnitManageId();
						}
						break;
					case 1:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						K3code = cell.getStringCellValue();
						break;
					case 2:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						K3name = cell.getStringCellValue();
						break;
					default:
						break;
					}
				}
				K3Code k3Code = new K3Code();
				BaseK3Code baseK3Code = new BaseK3Code();
				baseK3Code.setBusinessId(receiveUnitManageId);
				baseK3Code.setType(8);
				baseK3Code.setK3Code(K3code);
				baseK3Code.setK3Name(K3name);
				k3Code.clear();
				k3Code.setDataFromBase(baseK3Code);
				k3Code.save();
			}
		}
	}

	/**
	 * @author liubin
	 * @date 2019/12/12 9:59
	 * @param [sheet]
	 * @return void
	 * @description: 科目K3代码维护
	 */
	private static void onUploadSubjectK3(Sheet sheet) throws SQLException {
		int countRow = 0;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		Employee employee = new Employee();
		SubjectType subjectType = new SubjectType();
		for (int j = 1; j < countRow; j++) {
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			// 获取每一行的列数
			countCol = row.getLastCellNum();
			for (int i = 0; i <= countCol + 1; i++) {
				Integer departmentType = null;
				Integer subjectTypeId = null;
				String K3code = null;
				String K3name = null;
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String stringCellValue = cell.getStringCellValue();
						switch (stringCellValue) {
						case "事业部":
							departmentType = 2;
							break;
						case "营销部门":
							departmentType = 0;
							break;
						case "职能部门":
							departmentType = 1;
							break;
						default:
							break;
						}
						break;
					case 1:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String stringCellValue1 = cell.getStringCellValue();
						subjectType.clear();
						subjectType.setConditionSubjectName("=", stringCellValue1);
						if (subjectType.isExist()) {
							BaseSubjectType baseSubjectType = subjectType.executeQueryOneRow();
							subjectTypeId = baseSubjectType.getSubjectTypeId();
						} else {
							subjectTypeId = 0;
						}
						break;
					case 2:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						K3code = cell.getStringCellValue();
						break;
					case 3:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						K3name = cell.getStringCellValue();
						break;
					default:
						break;
					}
				}
				K3Code k3Code = new K3Code();
				BaseK3Code baseK3Code = new BaseK3Code();
				baseK3Code.setBusinessId(subjectTypeId);
				baseK3Code.setType(4);
				baseK3Code.setK3Code(K3code);
				baseK3Code.setK3Name(K3name);
				baseK3Code.setDepartmentType(departmentType);
				k3Code.clear();
				k3Code.setDataFromBase(baseK3Code);
				k3Code.save();
			}
		}
	}

	/**
	 * @author liubin
	 * @date 2019/12/12 9:35
	 * @param [sheet]
	 * @return void
	 * @description: 员工K3代码
	 */
	private static void onUploadEmployeeK3(Sheet sheet) throws SQLException {
		int countRow = 0;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		Employee employee = new Employee();
		for (int j = 1; j < countRow; j++) {
			String employeeNo = null;
			Integer employeeId = null;
			String K3code = null;
			String K3name = null;
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			// 获取每一行的列数
			countCol = row.getLastCellNum();
			for (int i = 0; i <= countCol + 1; i++) {
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						employeeNo = cell.getStringCellValue();
						employee.clear();
						employee.setConditionEmployeeNo("=", employeeNo);
						BaseEmployee baseEmployee = employee.executeQueryOneRow();
						if (null != baseEmployee) {
							employeeId = baseEmployee.getEmployeeId();
						}
						break;
					case 2:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						K3code = cell.getStringCellValue();
						break;
					case 3:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						K3name = cell.getStringCellValue();
						break;
					default:
						break;
					}
				}
			}
			K3Code k3Code = new K3Code();
			k3Code.setConditionType("=", 1);
			k3Code.setConditionBusinessId("=", employeeId);
			// 存在则更新
			if (k3Code.isExist()) {
				BaseK3Code baseK3Code = k3Code.executeQueryOneRow();
				baseK3Code.setK3Code(K3code);
				baseK3Code.setK3Name(K3name);
				k3Code.clear();
				k3Code.setDataFromBase(baseK3Code);
				k3Code.update();
			} else {
				BaseK3Code baseK3Code = new BaseK3Code();
				baseK3Code.setBusinessId(employeeId);
				baseK3Code.setType(1);
				baseK3Code.setK3Code(K3code);
				baseK3Code.setK3Name(K3name);
				k3Code.clear();
				k3Code.setDataFromBase(baseK3Code);
				k3Code.save();
			}
		}
	}

	/**
	 * @author liubin
	 * @date 2019/12/11 19:50
	 * @param [sheet]
	 * @return void
	 * @description: 公司K3代码维护
	 */
	private static void onUploadCompanyK3(Sheet sheet) throws SQLException {

	}

	/**
	 * 报销科目表数据的导入
	 *
	 * @param sheet
	 * @throws Exception
	 */
	private static void onUploadSubjectType(Sheet sheet) throws Exception {
		SubjectType dao = new SubjectType();
		BaseSubjectType bean;
		// 初始化行数
		int countRow = 0;

		countRow = sheet.getLastRowNum();
		for (int j = 1; j <= countRow; j++) {
			// 科目名称
			String subjectName = null;
			// 科目名称名称
			String parentName = null;
			Row row = sheet.getRow(j);
			int colNum = 0;
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			bean = new BaseSubjectType();
			if (row != null) {
				Cell cell = row.getCell(colNum++);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					cell.setCellType(Cell.CELL_TYPE_STRING);
					parentName = cell.getStringCellValue();
				}
				cell = row.getCell(colNum++);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					cell.setCellType(Cell.CELL_TYPE_STRING);
					subjectName = cell.getStringCellValue();
				}
			}
			SubjectType subjectType = new SubjectType();
			// parentName为空时则表明是一级报销科目
			if (BaseHelpUtils.isNullOrEmpty(parentName)) {
				subjectType.setConditionSubjectName("=", subjectName);
				subjectType.setConditionParentId("=", 0);
				BaseSubjectType baseSubjectType = subjectType.executeQueryOneRow();
				// 不为空时则证明是更新
				if (!BaseHelpUtils.isNullOrEmpty(baseSubjectType)) {
					baseSubjectType.setSubjectName(subjectName);
					baseSubjectType.setParentId(0);
					subjectType.clear();
					subjectType.setDataFromBase(baseSubjectType);
					subjectType.update();
				} else {
					BaseSubjectType baseSubjectType1 = new BaseSubjectType();
					baseSubjectType1.setSubjectName(subjectName);
					baseSubjectType1.setParentId(0);
					subjectType.setDataFromBase(baseSubjectType1);
					subjectType.save();
				}
			}
			// parentName不为空时则表明是二级报销科目
			else {
				subjectType.clear();
				subjectType.setConditionSubjectName("=", parentName);
				BaseSubjectType parentSubjectType = subjectType.executeQueryOneRow();
				if (BaseHelpUtils.isNullOrEmpty(parentSubjectType)) {
					continue;
				}
				int parentId = BaseHelpUtils.getIntValue(parentSubjectType.getSubjectTypeId());
				subjectType.clear();
				subjectType.setConditionSubjectName("=", subjectName);
				BaseSubjectType baseSubjectType = subjectType.executeQueryOneRow();
				// 不为空则更新
				if (!BaseHelpUtils.isNullOrEmpty(baseSubjectType)) {
					baseSubjectType.setParentId(parentId);
					baseSubjectType.setSubjectName(subjectName);
					subjectType.clear();
					subjectType.setDataFromBase(baseSubjectType);
					subjectType.update();
				} else {
					BaseSubjectType baseSubjectType1 = new BaseSubjectType();
					baseSubjectType1.setParentId(parentId);
					baseSubjectType1.setSubjectName(subjectName);
					subjectType.setDataFromBase(baseSubjectType1);
					subjectType.save();
				}
			}
		}
	}

	/**
	 * @Author: liubin
	 * @Description : 打卡明细
	 * @Date: 15:32 2019/6/4
	 */
	private static void onUploadCheckDetail(Sheet sheet) throws SQLException {
		String employeeNo = null;
		Date employeeTime = null;
		Integer employeeId = null;
		int countRow = 0;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		for (int j = 1; j < countRow; j++) {
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			// 获取每一行的列数
			countCol = row.getLastCellNum();
			for (int i = 0; i <= countCol + 1; i++) {
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						employeeNo = cell.getStringCellValue();
						Employee employee = new Employee();
						employee.setConditionEmployeeNo("=", employeeNo);
						BaseEmployee baseEmployee = employee.executeQueryOneRow();
						if (null != baseEmployee) {
							employeeId = baseEmployee.getEmployeeId();
						}
						break;
					case 2:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String temp = cell.getStringCellValue();
						employeeTime = strToDate(temp);
						break;
					default:
						break;
					}
				}
				EmployeeCheckinoutDetail dao = new EmployeeCheckinoutDetail();
				BaseEmployeeCheckinoutDetail bean = new BaseEmployeeCheckinoutDetail();
				bean.setCheckDate(employeeTime);
				bean.setCheckTime(employeeTime);
				bean.setEmployeeId(employeeId);
				dao.setDataFromBase(bean);
				dao.save();
			}
		}
	}

	/**
	 * 更新人员的年假的封顶天数
	 *
	 * @param sheet
	 */
	private static void onUploadEmployeeAnnualLeave(Sheet sheet) throws SQLException {
		String totalAnnualLeave = null;
		String employeeNo = null;
		Employee employee = new Employee();
		// 初始化行数
		int countRow = 0;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		for (int j = 1; j <= countRow; j++) {
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			// 获取每一行的列数
			countCol = row.getLastCellNum();
			for (int i = 0; i < countCol + 1; i++) {
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						employeeNo = cell.getStringCellValue();
						break;
					case 1:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						totalAnnualLeave = cell.getStringCellValue();
						break;
					default:
						break;
					}
				}
			}
			employee.clear();
			employee.setConditionEmployeeNo("=", employeeNo);
			BaseEmployee baseEmployee = employee.executeQueryOneRow();
			if (null == baseEmployee) {
				continue;
			} else {
				baseEmployee.setWorkYearType(Integer.parseInt(totalAnnualLeave));
			}
			employee.clear();
			employee.setDataFromBase(baseEmployee);
			employee.update();
		}
	}

	/**
	 * 字典表数据的导入
	 *
	 * @param sheet
	 * @throws Exception
	 */
//	private static void onUploadSystemDictionary(Sheet sheet) throws Exception {
//
//		SystemDictionary dao = new SystemDictionary();
//
//		BaseSystemDictionary bean;
//
//		List<BaseSystemDictionary> beans = new ArrayList<BaseSystemDictionary>();
//
//		// 初始化行数
//		int countRow = 0;
//		// 列表数据代码
//		int dicTypeId = 0;
//		// 列表数据名称
//		String dicTypeName = null;
//		// 数据值
//		String dicTypeValue = null;
//		// 是否启用
//		boolean dicIsEnable = true;
//		countRow = sheet.getLastRowNum();
//
//		int countCol = 0;
//		for (int j = 1; j <= countRow; j++) {
//
//			Row row = sheet.getRow(j);
//
//			if (BaseHelpUtils.isNullOrEmpty(row)) {
//				break;
//			}
//			// 获取每一行的列数
//			countCol = row.getLastCellNum();
//
//			bean = new BaseSystemDictionary();
//
//			for (int i = 0; i < countCol + 1; i++) {
//				// 创建一个列单元对象
//				Cell cell = row.getCell(i);
//				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
//					switch (i) {
//						case 0:
//							cell.setCellType(Cell.CELL_TYPE_STRING);
//							dicTypeId = Integer.parseInt(cell.getStringCellValue());
//							break;
//						case 1:
//							cell.setCellType(Cell.CELL_TYPE_STRING);
//							dicTypeName = cell.getStringCellValue();
//							break;
//						case 2:
//							cell.setCellType(Cell.CELL_TYPE_STRING);
//							dicTypeValue = cell.getStringCellValue();
//							break;
//						default:
//							break;
//					}
//
//				}
//
//			}
//			bean.setDicTypeId(dicTypeId);
//			bean.setDicTypeName(dicTypeName);
//			bean.setDicTypeValue(dicTypeValue);
//			bean.setDicIsEnable(dicIsEnable);
//			if(!BaseHelpUtils.isNullOrEmpty(dicTypeValue)){
//				beans.add(bean);
//			}
//
//		}
//		// 排序
//		sortIntMethod(beans);
//
//		if (beans.size() > 0) {
//			int tmpTypeId = -1;
//			int ide = 0;
//			for (BaseSystemDictionary sdbean : beans) {
//				if (tmpTypeId == sdbean.getDicTypeId()) {
//					ide++;
//				} else {
//					ide = 1;
//				}
//				sdbean.setDicTypeValueId(ide);
//				tmpTypeId = sdbean.getDicTypeId();
//
//			}
//		}
//		dao.save(beans);
//
//	}

	/**
	 * 人员角色导入
	 *
	 * @param sheet
	 */
	private static void onUploadEmployeeRoles(Sheet sheet) throws SQLException {

		Employee employee = new Employee();
		Department department = new Department();
		Role role = new Role();
		DepartmentRole departmentRole = new DepartmentRole();
		EmployeeRole employeeRole = new EmployeeRole();
		// 初始化行数
		int countRow = 0;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		for (int j = 1; j <= countRow; j++) {
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			String employeeName = null;
			String employeeNo = null;
			String roleName = null;
			String departmentName = null;
			// 获取每一行的列数
			countCol = row.getLastCellNum();
			for (int i = 0; i < countCol + 1; i++) {
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
						case 0:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							employeeNo = cell.getStringCellValue();
							break;
						case 1:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							employeeName = cell.getStringCellValue();
							break;
						case 2:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							roleName = cell.getStringCellValue();
						case 3:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							departmentName = cell.getStringCellValue();
						default:
							break;
					}
				}
			}
			Integer employeeId = null;
			Integer roleId = null;
			Integer departmentId = null;
			employee.clear();
			employee.setConditionEmployeeNo("=", employeeNo);
			BaseEmployee baseEmployee = employee.executeQueryOneRow();
			if (null != baseEmployee) {
				employeeId = baseEmployee.getEmployeeId();
			} else {
				continue;
			}
			employeeRole.clear();
			employeeRole.setConditionEmployeeId("=", employeeId);
			employeeRole.setConditionRoleId("=", 5);
			employeeRole.setConditionDepartmentId("=", 0);
			BaseEmployeeRole baseEmployeeRole = employeeRole.executeQueryOneRow();
			if (null == baseEmployeeRole) {
				employeeRole.clear();
				employeeRole.setRoleId(5);
				employeeRole.setDepartmentId(0);
				employeeRole.setEmployeeId(employeeId);
				employeeRole.setIsDefault(false);
				employeeRole.save();
			}
		}
	}

	/**
	 * 职位表数据导入
	 *
	 * @param sheet
	 */
	private static void onUploadDuty(Sheet sheet) throws SQLException {
		Duty dutyDao = new Duty();
		// 初始化行数
		int countRow = 0;
		// 职位名称
		String dutyName = null;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		for (int j = 1; j <= countRow; j++) {
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			// 获取每一行的列数
			countCol = row.getLastCellNum();
			for (int i = 0; i < countCol + 1; i++) {
				// 创建一个列单元对象
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						dutyName = cell.getStringCellValue();
						break;
					default:
						break;
					}

				}
			}
			// 根据角色名称去判断，如果已存在，则更新，否则则插入
			dutyDao.clear();
			dutyDao.setConditionDutyName("=", dutyName);
			if (!dutyDao.isExist()) {
				dutyDao.setDutyName(dutyName);
				dutyDao.save();
			} else {
				BaseDuty baseDuty = dutyDao.executeQueryOneRow();
				int dutuId = BaseHelpUtils.getIntValue(baseDuty.getDutyId());
				dutyDao.setDutyId(dutuId);
				dutyDao.setDutyName(dutyName);
				dutyDao.update();
			}
		}
	}

	/**
	 * 角色表数据的导入
	 *
	 * @param sheet
	 * @throws Exception
	 */
	private static void onUploadRoles(Sheet sheet) throws Exception {
		Role dao = new Role();
		// 初始化行数
		int countRow = 0;
		// 角色名称
		String roleName = null;
		// 角色类型值
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		for (int j = 1; j <= countRow; j++) {
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			// 获取每一行的列数
			countCol = row.getLastCellNum();
			for (int i = 0; i < countCol + 1; i++) {
				// 创建一个列单元对象
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						roleName = cell.getStringCellValue();
						break;
					default:
						break;
					}

				}

			}
			// 根据角色名称去判断，如果已存在，则更新，否则则插入S
			dao.clear();
			dao.setConditionRoleName("=", roleName);
			if (!dao.isExist()) {
				dao.setRoleName(roleName);
				dao.save();
			} else {
				BaseRole baseRole = dao.executeQueryOneRow();
				int roleId = BaseHelpUtils.getIntValue(baseRole.getRoleId());
				dao.setRoleId(roleId);
				dao.setRoleName(roleName);
				dao.update();
			}
		}

	}

	/**
	 * 公司表数据的导入
	 *
	 * @param sheet
	 * @throws Exception
	 */
	private static void onUploadCompanyRecords(Sheet sheet) throws Exception {
		CompanyRecord dao = new CompanyRecord();
		// 初始化行数
		int countRow = 0;
		// 公司名称
		String companyName = null;
		// 公司编码
		String companyCode = null;
		// 公司简称
		String companyNameSimple = null;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		for (int j = 1; j <= countRow; j++) {
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			// 获取每一行的列数
			countCol = row.getLastCellNum();
			for (int i = 0; i < countCol + 1; i++) {
				// 创建一个列单元对象
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					cell.setCellType(Cell.CELL_TYPE_STRING);
					String cellValue = BaseHelpUtils.getString(cell.getStringCellValue());
					switch (i) {
					case 0:
						companyName = cellValue;
						break;
					case 1:
						companyCode = cellValue;
						break;
					case 2:
						companyNameSimple = cellValue;
						break;
					default:
						break;
					}

				}
			}
			// 根据公司编码查询
			dao.clear();
			dao.setConditionCompanyCode("=", companyCode);
			if (dao.isExist()) {
				dao.setCompanyName(companyName);
				dao.setCompanyNameSimple(companyNameSimple);
				dao.conditionalUpdate();
			} else {
				dao.setCompanyCode(companyCode);
				dao.setCompanyName(companyName);
				dao.setCompanyNameSimple(companyNameSimple);
				dao.save();
			}
		}

	}

	/**
	 * 按照List中的某个Int类型的属性进行排序
	 *
	 * @param list
	 */
	@SuppressWarnings("unchecked")
	public static void sortIntMethod(List list) {
		Collections.sort(list, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				BaseSystemDictionary bean1 = (BaseSystemDictionary) o1;
				BaseSystemDictionary bean2 = (BaseSystemDictionary) o2;
				if (bean1.getDicTypeId() > bean2.getDicTypeId()) {
					return 1;
				} else if (bean1.getDicTypeId() == bean2.getDicTypeId()) {
					return 0;
				} else {
					return -1;
				}
			}
		});

	}

	/**
	 * 业务部门表数据的导入
	 *
	 * @param sheet
	 * @throws Exception
	 */
	private static void onUploadPlateRecord(Sheet sheet) throws Exception {
		PlateRecord dao = new PlateRecord();
		BasePlateRecord bean;
		List<BasePlateRecord> beans = new ArrayList<BasePlateRecord>();
		// 初始化行数
		int countRow = 0;
		// 业务部门编码
		String plateCode = null;
		// 业务部门名称
		String plateName = null;
		// 父级名称
		String partmentName = null;
		// 类型
		String plateType = null;
		String hrCode = null;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		for (int j = 1; j <= countRow; j++) {
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			// 获取每一行的列数
			countCol = row.getLastCellNum();
			for (int i = 0; i < countCol + 1; i++) {
				// 创建一个列单元对象
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						plateCode = cell.getStringCellValue();
						break;
					case 1:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						plateName = cell.getStringCellValue();
						break;
					case 2:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						partmentName = cell.getStringCellValue();
						break;
					case 3:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						plateType = cell.getStringCellValue();
						break;
					case 4:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						hrCode = cell.getStringCellValue();
						break;
					default:
						break;
					}

				}

			}
			// 根据业务部门名称查询该业务部门是否存在
			if (!BaseHelpUtils.isNullOrEmpty(plateName)) {
				PlateRecord plateRecord = new PlateRecord();
				plateRecord.setConditionPlateCode("=", plateCode);
				BasePlateRecord basePlateRecord = plateRecord.executeQueryOneRow();
				plateRecord.clear();
				// 根据父级部门的名称查询父级部门
				plateRecord.setConditionPlateName("=", partmentName);
				Integer parentId = 1;
				BasePlateRecord parentPlateRecord = plateRecord.executeQueryOneRow();
				if (!BaseHelpUtils.isNullOrEmpty(parentPlateRecord)) {
					parentId = parentPlateRecord.getPlateId();
				}

				plateRecord.clear();
				// 该业务部门存在则为更新，不存在则为保存
				if (!BaseHelpUtils.isNullOrEmpty(basePlateRecord)) {
					basePlateRecord.setParentId(parentId);
					basePlateRecord.setPlateCode(plateCode);
					basePlateRecord.setPlateName(plateName);
					basePlateRecord.setHrCode(hrCode);
					if (!BaseHelpUtils.isNullOrEmpty(plateType)) {
						switch (plateType) {
						case "事业部":
							basePlateRecord.setPlateType(1);
							break;
						case "职能部":
							basePlateRecord.setPlateType(2);
							break;
						case "营销部":
							basePlateRecord.setPlateType(3);
							break;
						default:
							break;
						}
					}
					plateRecord.setDataFromBase(basePlateRecord);
					plateRecord.update();
				} else {
					BasePlateRecord basePlateRecord1 = new BasePlateRecord();
					basePlateRecord1.setParentId(parentId);
					basePlateRecord1.setPlateCode(plateCode);
					basePlateRecord1.setPlateName(plateName);
					basePlateRecord1.setHrCode(hrCode);
					if (!BaseHelpUtils.isNullOrEmpty(plateType)) {
						switch (plateType) {
						case "设计部":
							basePlateRecord1.setPlateType(1);
							break;
						case "职能部":
							basePlateRecord1.setPlateType(2);
							break;
						case "营销部":
							basePlateRecord1.setPlateType(3);
							break;
						default:
							break;
						}
					}
					plateRecord.setDataFromBase(basePlateRecord1);
					plateRecord.save();
				}
			}
		}
	}

	/**
	 * 部门表数据的导入
	 *
	 * @param sheet
	 * @throws Exception
	 */
	private static void onUploadDepartment(Sheet sheet) throws Exception {
		// 初始化行数
		int countRow = 0;
		// 部门名称
		String departmentName = null;
		// 父级部门名称
		String parentName = null;
		// 业务部门
		String plateName = null;
		// 获取每一行的列数
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		List<BaseDepartmentId> idsList = new ArrayList<>();
		for (int j = 1; j <= countRow; j++) {
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			// 获取每一行的列数
			countCol = row.getLastCellNum();
			for (int i = 0; i < countCol + 1; i++) {
				// 创建一个列单元对象
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						departmentName = cell.getStringCellValue();
						break;
					case 1:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						parentName = cell.getStringCellValue();
						break;
					case 2:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						plateName = cell.getStringCellValue();
						break;
					default:
						break;
					}
				}
			}
			// 根据业务部门的名称查询业务部门的ID
			Integer plateId = 0;
			PlateRecord plateRecord = new PlateRecord();
			plateRecord.setConditionPlateName("=", plateName);
			BasePlateRecord basePlateRecord = plateRecord.executeQueryOneRow();
			if (!BaseHelpUtils.isNullOrEmpty(basePlateRecord)) {
				plateId = basePlateRecord.getPlateId();
			}
			// 取出部门名称查询是否存在
			Department department = new Department();
			Integer parentDepartmentId = 0;
			department.setConditionDepartmentName("=", parentName);
			BaseDepartment parentDepartment = department.executeQueryOneRow();
			if (!BaseHelpUtils.isNullOrEmpty(parentDepartment)) {
				parentDepartmentId = BaseHelpUtils.getIntValue(parentDepartment.getDepartmentId());
			}
			department.clear();
			department.setConditionDepartmentName("=", departmentName);
			BaseDepartment baseDepartment = department.executeQueryOneRow();
			// 查询不存在是则为插入
			if (BaseHelpUtils.isNullOrEmpty(baseDepartment)) {
				BaseDepartment baseDepartment1 = new BaseDepartment();
				baseDepartment1.setDepartmentName(departmentName);
				baseDepartment1.setParentId(parentDepartmentId);
				baseDepartment1.setPlateId(plateId);
				department.clear();
				department.setDataFromBase(baseDepartment1);
				department.save();
			} else {
				baseDepartment.setDepartmentName(departmentName);
				baseDepartment.setParentId(parentDepartmentId);
				baseDepartment.setPlateId(plateId);
				department.clear();
				department.setDataFromBase(baseDepartment);
				department.update();
			}
			department.clear();
			department.setConditionDepartmentName("=", departmentName);
			BaseDepartment bean = department.executeQueryOneRow();
			department.clear();

			addData(department, bean.getDepartmentId(), idsList);
		}
		if (idsList.size() > 0) {
			DepartmentId idsDao = new DepartmentId();
			idsDao.save(idsList);
		}
	}

	private static void addData(Department dao, int parentId, List<BaseDepartmentId> idsList) throws SQLException {
		BaseDepartmentId bean1 = new BaseDepartmentId();
		bean1.setDepartmentId(parentId);
		bean1.setChildId(parentId);
		idsList.add(bean1);
		dao.clear();
		dao.setConditionParentId("=", parentId);
		if (dao.countRows() > 0) {
			List<BaseDepartment> list = dao.conditionalLoad();
			for (BaseDepartment baseDepartment : list) {
				BaseDepartmentId bean2 = new BaseDepartmentId();
				bean2.setDepartmentId(parentId);
				bean2.setChildId(baseDepartment.getDepartmentId());
				idsList.add(bean2);
				addData(dao, baseDepartment.getDepartmentId(), idsList);
			}
		}
	}

	/**
	 * 人员表数据的导入
	 *
	 * @param sheet
	 * @throws Exception
	 */
	private static void onUploadEmployee(Sheet sheet) throws Exception {
		Employee dao = new Employee();
		BaseEmployee bean;
		List<BaseEmployee> beans = new ArrayList<BaseEmployee>();
		SystemDictionary sdDao = new SystemDictionary();
		List<BaseSystemDictionary> sdList = sdDao.conditionalLoad();
		// 初始化行数
		int countRow = 0;
		// 员工编号
		String employeeNo = null;
		// 员工姓名
		String employeeName = null;
		// 职级
		String gradeId = null;
		// 职务
		String duties = null;
		// 部门名称
		String departmentName = null;
		// 部门ID
		int departmentId = 0;
		// 角色名称
		String roleName = null;
		// 角色id
		int roleId = 0;
		// 密码
		String employeePassword = null;
		// 手机
		String mobile = null;
		// 电话
		String phone = null;
		// qq
		String qq = null;
		// 邮箱
		String email = null;
		// 入职日期
		Date onboardDate = null;
		// 离职日期
		Date resignationDate = null;
		// 状态(0:在职;1:离职;;4:删除)
		String status = null;
		// 性别
		String gender = null;
		// 年龄
		int age = 0;
		// 出生日期
		Date birth = null;
		// 身份证
		String card = null;
		// 家庭地址
		String address = null;
		// 英文名
		String employeeNameEn = null;
		// 学历
		String education = null;
		// 学位
		String degree = null;
		// 民族
		String nationality = null;
		// 婚姻状况
		String marriedStatus = null;
		// 身体状况
		String health = null;
		// 工作地
		String workAddress = null;
		// 注册地
		String registeredAddress = null;
		// 政治面貌
		String politicalFaceName = null;
		// 籍贯
		String birthplace = null;
		// 国籍
		String country = null;
		// 户口所在地
		String accountLocation = null;
		// 外语语种
		String languages = null;
		// 开始工作时间
		Date startWorkDate = null;
		// 社保电脑号
		String socialComputerNumber = null;
		// 公积金账号
		String fundAccount = null;
		// 转正日期
		Date positiveDate = null;
		// 试用期
		String tryTime = null;
		// 合同开始时间
		Date contractStartDate = null;
		// 合同到期结束时间
		Date contractEndDate = null;
		// 紧急联系人
		String emergencyContactPerson = null;
		// 紧急联系人电话
		String emergencyContactPhone = null;
		// 家庭电话
		String homePhone = null;
		// 现住地址
		String nowAddress = null;
		// 试用期工资
		String tryTimePay = null;
		// 转正工资
		String positivePay = null;
		// 银行卡号
		String bankCardNum = null;
		// 档案号
		String fileNumber = null;
		// 户籍
		String householdRegistration = null;
		// 司龄
		String foreman = null;
		// 身份证地址
		String cardAddress = null;
		// 企业邮箱
		String companyEmail = null;
		// 归属公司
		String companyName = null;
		// 归属公司id
		int companyId = 0;
		// 入职职员状态
		String onboardStatus = null;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		Department departmentDao = new Department();
		Role roleDao = new Role();
		CompanyRecord ceDao = new CompanyRecord();
		for (int j = 1; j <= countRow; j++) {
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			bean = new BaseEmployee();
			// 获取每一行的列数
			countCol = row.getLastCellNum();
			for (int i = 0; i < countCol + 1; i++) {
				// 创建一个列单元对象
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						employeeNo = cell.getStringCellValue();
						bean.setEmployeeNo(employeeNo);
						employeePassword = DES.string2MD5(employeeNo);
						bean.setEmployeePassword(employeePassword);
						break;
					case 1:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						employeeName = cell.getStringCellValue();
						bean.setEmployeeName(employeeName);
						break;
					case 2:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						gradeId = cell.getStringCellValue();
						switch (gradeId) {
						case "高级":
							bean.setGradeId(1);
							break;
						case "中级":
							bean.setGradeId(2);
							break;
						default:
							bean.setGradeId(0);
							break;
						}
					case 3:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						duties = cell.getStringCellValue();
						Duty dutyDao = new Duty();
						dutyDao.setConditionDutyName("=", duties);
						BaseDuty baseDuty = dutyDao.executeQueryOneRow();
						if (BaseHelpUtils.isNullOrEmpty(baseDuty)) {
							continue;
						}
						Integer dutyId = baseDuty.getDutyId();
						if (!BaseHelpUtils.isNullOrEmpty(dutyId)) {
							bean.setDutyId(dutyId);
						}
					case 4:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						departmentName = cell.getStringCellValue();
						// 根据部门名称查找部门id
						if (!BaseHelpUtils.isNullOrEmpty(departmentName)) {
							departmentDao.setConditionDepartmentName("=", departmentName);
							if (!BaseHelpUtils.isNullOrEmpty(departmentDao.executeQueryOneRow())) {
								departmentId = departmentDao.getDepartmentId();
								bean.setDepartmentId(departmentId);
								bean.setPlateId(departmentDao.getPlateId());
							}
						}
						break;
					case 5:
						/*
						 * cell.setCellType(Cell.CELL_TYPE_STRING); roleName =
						 * cell.getStringCellValue(); // 根据角色名称查找角色id if
						 * (!BaseHelpUtils.isNullOrEmpty(roleName)) { roleDao.setConditionRoleName("=",
						 * roleName); if (!BaseHelpUtils.isNullOrEmpty(roleDao.executeQueryOneRow())) {
						 * roleId = roleDao.getRoleId(); bean.setRoleId(roleId); }
						 *
						 * }
						 */
						break;
					case 6:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						mobile = cell.getStringCellValue();
						bean.setMobile(mobile);
						break;
					case 7:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						phone = cell.getStringCellValue();
						bean.setPhone(phone);
						break;
					case 8:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						qq = cell.getStringCellValue();
						bean.setQq(qq);
						break;
					case 9:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						email = cell.getStringCellValue();
						bean.setEmail(email);
						break;
					case 10:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String onboardDateValue = cell.getStringCellValue();
						if (!BaseHelpUtils.isNullOrEmpty(onboardDateValue)) {
							onboardDate = strToDate(onboardDateValue);
							bean.setOnboardDate(onboardDate);
						}
						break;
					case 11:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String resignationDateValue = cell.getStringCellValue();
						if (!BaseHelpUtils.isNullOrEmpty(resignationDateValue)) {
							resignationDate = strToDate(resignationDateValue);
							bean.setResignationDate(resignationDate);
						}
						break;
					case 12:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						status = cell.getStringCellValue();
						// 根据状态值查找相对应的状态编码
						if (!BaseHelpUtils.isNullOrEmpty(status)) {
							bean.setStatus(returnSystemValue(11, status, sdList));
						}
						break;
					case 13:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						gender = cell.getStringCellValue();
						// 根据性别查找相对应的状态编码
						if (!BaseHelpUtils.isNullOrEmpty(gender)) {
							bean.setGender(returnSystemValue(12, gender, sdList));
						}
						break;
					case 14:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						age = Integer.parseInt(cell.getStringCellValue());
						bean.setAge(age);
						break;
					case 15:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String birthValue = cell.getStringCellValue();
						if (!BaseHelpUtils.isNullOrEmpty(birthValue)) {
							birth = strToDate(birthValue);
							bean.setBirth(birth);
						}
						break;
					case 16:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						card = cell.getStringCellValue();
						bean.setCard(card);
						break;
					case 17:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						address = cell.getStringCellValue();
						bean.setAddress(address);
						break;
					case 18:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						employeeNameEn = cell.getStringCellValue();
						bean.setEmployeeNameEn(employeeNameEn);
						break;
					case 19:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						education = cell.getStringCellValue();
						bean.setEducation(education);
						break;
					case 20:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						degree = cell.getStringCellValue();
						bean.setDegree(degree);
						break;
					case 21:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						nationality = cell.getStringCellValue();
						bean.setNationality(nationality);
						break;
					case 22:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						marriedStatus = cell.getStringCellValue();
						bean.setMarriedStatus(marriedStatus);
						break;
					case 23:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						health = cell.getStringCellValue();
						bean.setHealth(health);
						break;
					case 24:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						workAddress = cell.getStringCellValue();
						bean.setWorkAddress(workAddress);
						break;
					case 25:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						registeredAddress = cell.getStringCellValue();
						bean.setRegisteredAddress(registeredAddress);
						break;
					case 26:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						politicalFaceName = cell.getStringCellValue();
						// 根据政治面貌查找相对应的状态编码
						if (!BaseHelpUtils.isNullOrEmpty(politicalFaceName)) {
							bean.setPoliticalFace(returnSystemValue(76, politicalFaceName, sdList));
						}
						break;
					case 27:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						birthplace = cell.getStringCellValue();
						bean.setBirthplace(birthplace);
						break;
					case 28:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						country = cell.getStringCellValue();
						bean.setCountry(country);
						break;
					case 29:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						accountLocation = cell.getStringCellValue();
						bean.setAccountLocation(accountLocation);
						break;
					case 30:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						languages = cell.getStringCellValue();
						bean.setLanguages(languages);
						break;
					case 31:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String startWorkDateValue = cell.getStringCellValue();
						if (!BaseHelpUtils.isNullOrEmpty(startWorkDateValue)) {
							startWorkDate = strToDate(startWorkDateValue);
							bean.setStartWorkDate(startWorkDate);
						}
						break;
					case 32:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						socialComputerNumber = cell.getStringCellValue();
						bean.setSocialComputerNumber(socialComputerNumber);
						break;
					case 33:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						fundAccount = cell.getStringCellValue();
						bean.setFundAccount(fundAccount);
						break;
					case 34:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String positiveDateValue = cell.getStringCellValue();
						if (!BaseHelpUtils.isNullOrEmpty(positiveDateValue)) {
							positiveDate = strToDate(positiveDateValue);
							bean.setPositiveDate(positiveDate);
						}
						break;
					case 35:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						tryTime = cell.getStringCellValue();
						bean.setTryTime(tryTime);
						break;
					case 36:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String contractStartDateValue = cell.getStringCellValue();
						if (!BaseHelpUtils.isNullOrEmpty(contractStartDateValue)) {
							contractStartDate = strToDate(contractStartDateValue);
							bean.setContractStartDate(contractStartDate);
						}
						break;
					case 37:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String contractEndDateValue = cell.getStringCellValue();
						if (!BaseHelpUtils.isNullOrEmpty(contractEndDateValue)) {
							contractEndDate = strToDate(contractEndDateValue);
							bean.setContractEndDate(contractEndDate);
						}
						break;
					case 38:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						emergencyContactPerson = cell.getStringCellValue();
						bean.setEmergencyContactPerson(emergencyContactPerson);
						break;
					case 39:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						emergencyContactPhone = cell.getStringCellValue();
						bean.setEmergencyContactPhone(emergencyContactPhone);
						break;
					case 40:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						homePhone = cell.getStringCellValue();
						bean.setHomePhone(homePhone);
						break;
					case 41:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						nowAddress = cell.getStringCellValue();
						bean.setNowAddress(nowAddress);
						break;
					case 42:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						tryTimePay = cell.getStringCellValue();
						bean.setTryTimePay(tryTimePay);
						break;
					case 43:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						positivePay = cell.getStringCellValue();
						bean.setPositivePay(positivePay);
						break;
					case 44:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bankCardNum = cell.getStringCellValue();
						bean.setBankCardNum(bankCardNum);

						break;
					case 45:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						fileNumber = cell.getStringCellValue();
						bean.setFileNumber(fileNumber);
						break;
					case 46:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						householdRegistration = cell.getStringCellValue();
						// 根据户籍查找相对应的状态编码
						if (!BaseHelpUtils.isNullOrEmpty(householdRegistration)) {
							bean.setHouseholdRegistration(returnSystemValue(81, householdRegistration, sdList));
						}
						break;
					case 47:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						foreman = cell.getStringCellValue();
						bean.setForeman(foreman);
						break;
					case 48:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						cardAddress = cell.getStringCellValue();
						bean.setCardAddress(cardAddress);
						break;
					case 49:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						companyEmail = cell.getStringCellValue();
						bean.setCompanyEmail(companyEmail);
						break;
					case 50:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						companyName = cell.getStringCellValue();
						if (!BaseHelpUtils.isNullOrEmpty(companyName)) {
							ceDao.setConditionCompanyName("=", companyName);
							if (!BaseHelpUtils.isNullOrEmpty(ceDao.executeQueryOneRow())) {
								companyId = ceDao.getCompanyRecordId();
								bean.setCompanyId(companyId);
								bean.setOwnedCompany(companyId + "");
							}
						}
						break;
					case 51:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						onboardStatus = cell.getStringCellValue();
						// 根据入职员工状态查找相对应的状态编码
//							if (!BaseHelpUtils.isNullOrEmpty(onboardStatus)) {
//								bean.setOnboardStatus(returnSystemValue(96,onboardStatus, sdList));
//							}
						switch (onboardStatus) {
						case "正式员工":
							bean.setOnboardStatus(2);
							break;
						case "试用期员工":
							bean.setOnboardStatus(1);
							break;
						}
						break;
					default:
						break;
					}
				}
			}
			Employee employee = new Employee();
			employee.setConditionEmployeeNo("=", employeeNo);
			BaseEmployee baseEmployee = employee.executeQueryOneRow();
			// 查询员工是不存在则为插入
			if (!BaseHelpUtils.isNullOrEmpty(baseEmployee)) {
				employee.clear();
				bean.setEmployeeId(baseEmployee.getEmployeeId());
				employee.setDataFromBase(bean);
				employee.update();
			} else {
				employee.setDataFromBase(bean);
				employee.save();
			}
			/*
			 * //更新员工角色表(employee_roles) employee.clear();
			 * employee.setConditionEmployeeNo("=" , employeeNo); BaseEmployee baseEmployee1
			 * = employee.executeQueryOneRow(); if
			 * (!BaseHelpUtils.isNullOrEmpty(baseEmployee1)){ Integer employeeId =
			 * BaseHelpUtils.getIntValue(baseEmployee1.getEmployeeId()); EmployeeRole
			 * employeeRole = new EmployeeRole(); employeeRole.setConditionEmployeeId("=" ,
			 * employeeId); employeeRole.setConditionRoleId("=" ,
			 * baseEmployee1.getRoleId()); BaseEmployeeRole baseEmployeeRole =
			 * employeeRole.executeQueryOneRow(); //不为空则更新 if
			 * (!BaseHelpUtils.isNullOrEmpty(baseEmployeeRole)){ employeeRole.clear();
			 * baseEmployeeRole.setRoleId(baseEmployee1.getRoleId());
			 * baseEmployeeRole.setEmployeeId(employeeId);
			 * employeeRole.setDataFromBase(baseEmployeeRole); employeeRole.update(); }else{
			 * employeeRole.clear(); BaseEmployeeRole baseEmployeeRole1 = new
			 * BaseEmployeeRole(); baseEmployeeRole1.setEmployeeId(employeeId);
			 * baseEmployeeRole1.setRoleId(baseEmployee1.getRoleId());
			 * employeeRole.setDataFromBase(baseEmployeeRole1); employeeRole.save(); } }
			 */
		}
	}

	public static Date strToDate(String strDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;

	}

	private static Integer returnSystemValue(Integer typeId, String valueStr, List<BaseSystemDictionary> list) {
		Integer value = null;
		for (BaseSystemDictionary baseSystemDictionary : list) {
			boolean flag = false;
			if (null != typeId) {
				if (Objects.equals(baseSystemDictionary.getDicTypeId(), typeId)) {
					flag = true;
				} else {
					flag = false;
				}
			}
			if (null != valueStr) {
				if (valueStr.trim().equals(baseSystemDictionary.getDicTypeValue())) {
					flag = true;
				} else {
					flag = false;
				}
			}
			if ((null != typeId || null != valueStr) && flag) {
				value = baseSystemDictionary.getDicTypeValueId();
				break;

			}
		}
		return value;

	}

	/**
	 * 个人卡号数据的导入
	 *
	 * @param sheet
	 * @throws Exception
	 */
	private static void onUploadCardPerson(Sheet sheet) throws Exception {
		CardManage dao = new CardManage();

		BaseCardManage bean;

		List<BaseCardManage> beans = new ArrayList<BaseCardManage>();

		Employee empDao = new Employee();
		List<BaseEmployee> empList = empDao.conditionalLoad();

		SystemDictionary sdDao = new SystemDictionary();
		List<BaseSystemDictionary> sdList = sdDao.conditionalLoad();

		// 初始化行数
		int countRow = 0;
		// 对象名称
		String objectName = null;
		// 开户行
		String bankName = null;
		// 银行账户
		String bankAccount = null;
		// 开户行所在地
		String bankAddress = null;

		int countCol = 0;

		countRow = sheet.getLastRowNum();
		for (int j = 1; j <= countRow; j++) {
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			// 获取每一行的列数
			countCol = row.getLastCellNum();

			bean = new BaseCardManage();
			for (int i = 0; i < countCol + 1; i++) {
				// 创建一个列单元对象
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						objectName = cell.getStringCellValue();
						bean.setObjectId(getEmployeeId(objectName, empList));
						bean.setObjectType(1);
						break;
					case 1:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bankName = cell.getStringCellValue();
						bean.setBankId(returnSystemValue(68, bankName, sdList));
						break;
					case 2:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bankAccount = cell.getStringCellValue();
						bean.setBankAccount(bankAccount);
						break;
					case 3:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bankAddress = cell.getStringCellValue();
						bean.setBankAddress(bankAddress);
						break;
					default:
						break;
					}

				}
			}
			CardManage cardManage = new CardManage();
			cardManage.setConditionBankAccount("=", bankAccount);
			BaseCardManage baseCardManage = cardManage.executeQueryOneRow();
			// 查询不存在则为新增
			if (BaseHelpUtils.isNullOrEmpty(baseCardManage)) {
				cardManage.clear();
				cardManage.setDataFromBase(bean);
				cardManage.save();
			} else {
				bean.setCardManageId(baseCardManage.getCardManageId());
				cardManage.clear();
				cardManage.setDataFromBase(bean);
				cardManage.update();
			}
		}
	}

	/**
	 * 公司卡号数据的导入
	 *
	 * @param sheet
	 * @throws Exception
	 */
	private static void onUploadCardCompany(Sheet sheet) throws Exception {
		CardManage dao = new CardManage();

		BaseCardManage bean;

		List<BaseCardManage> beans = new ArrayList<BaseCardManage>();

		CompanyRecord crDao = new CompanyRecord();
		List<BaseCompanyRecord> crList = crDao.conditionalLoad();

		SystemDictionary sdDao = new SystemDictionary();
		List<BaseSystemDictionary> sdList = sdDao.conditionalLoad();

		// 初始化行数
		int countRow = 0;
		// 对象名称
		String objectName = null;
		// 开户行
		String bankName = null;
		// 银行账户
		String bankAccount = null;
		// 开户行所在地
		String bankAddress = null;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		for (int j = 1; j <= countRow; j++) {
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			// 获取每一行的列数
			countCol = row.getLastCellNum();

			bean = new BaseCardManage();
			for (int i = 0; i < countCol + 1; i++) {
				// 创建一个列单元对象
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						objectName = cell.getStringCellValue();
						bean.setObjectId(getCompanyId(objectName, crList));
						bean.setObjectType(2);
						break;
					case 1:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bankName = cell.getStringCellValue();
						bean.setBankId(returnSystemValue(68, bankName, sdList));
						break;
					case 2:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bankAccount = cell.getStringCellValue();
						bean.setBankAccount(bankAccount);
						break;
					case 3:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bankAddress = cell.getStringCellValue();
						bean.setBankAddress(bankAddress);
						break;
					default:
						break;
					}

				}
			}
			CardManage cardManage = new CardManage();
			cardManage.setConditionBankAccount("=", bankAccount);
			BaseCardManage baseCardManage = cardManage.executeQueryOneRow();
			// 查询不存在则为新增
			if (BaseHelpUtils.isNullOrEmpty(baseCardManage)) {
				cardManage.clear();
				cardManage.setDataFromBase(bean);
				cardManage.save();
			} else {
				bean.setCardManageId(baseCardManage.getCardManageId());
				cardManage.clear();
				cardManage.setDataFromBase(bean);
				cardManage.update();
			}
		}
	}

	private static Integer getEmployeeId(String employeeNo, List<BaseEmployee> list) {
		Integer employeeId = null;
		for (BaseEmployee baseEmployee : list) {
			if (null != employeeNo && employeeNo.equals(baseEmployee.getEmployeeNo())) {
				employeeId = baseEmployee.getEmployeeId();
				break;
			}
		}
		return employeeId;
	}

	private static Integer getCompanyId(String companyName, List<BaseCompanyRecord> list) {
		Integer companyId = null;
		for (BaseCompanyRecord baseCompanyRecord : list) {
			if (null != companyName && companyName.equals(baseCompanyRecord.getCompanyName())) {
				companyId = baseCompanyRecord.getCompanyRecordId();
				break;
			}
		}
		return companyId;
	}

	/**
	 * 收款单位数据的导入
	 *
	 * @param sheet
	 * @throws Exception
	 */
	private static void onUploadReceiveUnitManage(Sheet sheet) throws Exception {

		ReceiveUnitManage dao = new ReceiveUnitManage();

		BaseReceiveUnitManage bean;

		List<BaseReceiveUnitManage> beans = new ArrayList<BaseReceiveUnitManage>();

		Area areaDao = new Area();
		List<BaseArea> areaList = areaDao.conditionalLoad();
		// 初始化行数
		int countRow = 0;
		// 收款单位
		String receiveUnit = null;
		// 银行账号
		String bankAccount = null;
		// 开户行
		String bankName = null;
		// 收款单位所在地
		String receiveUnitAddress = null;
		// 省
		String provinceName = null;
		// 市
		String cityName = null;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		for (int j = 1; j <= countRow; j++) {
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			// 获取每一行的列数
			countCol = row.getLastCellNum();
			bean = new BaseReceiveUnitManage();
			for (int i = 0; i < countCol + 1; i++) {
				// 创建一个列单元对象
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						receiveUnit = cell.getStringCellValue();
						bean.setReceiveUnit(receiveUnit);
						break;
					case 1:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bankAccount = cell.getStringCellValue();
						bean.setBankAccount(bankAccount);
						;
						break;
					case 2:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bankName = cell.getStringCellValue();
						bean.setBankName(bankName);
						break;
					case 3:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						receiveUnitAddress = cell.getStringCellValue();
						bean.setReceiveUnitAddress(receiveUnitAddress);
						break;
					case 4:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						provinceName = cell.getStringCellValue();
						bean.setProvince(getAreaId(provinceName, areaList));
						break;
					case 5:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						cityName = cell.getStringCellValue();
						bean.setCity(getAreaId(cityName, areaList));
						break;
					default:
						break;
					}

				}
			}
			ReceiveUnitManage receiveUnitManage = new ReceiveUnitManage();
			receiveUnitManage.setConditionBankAccount("=", bankAccount);
			BaseReceiveUnitManage baseReceiveUnitManage = receiveUnitManage.executeQueryOneRow();
			// 不为空则更新
			receiveUnitManage.clear();
			if (!BaseHelpUtils.isNullOrEmpty(baseReceiveUnitManage)) {
				bean.setReceiveUnitManageId(baseReceiveUnitManage.getReceiveUnitManageId());
				receiveUnitManage.setDataFromBase(bean);
				receiveUnitManage.update();
			} else {
				receiveUnitManage.setDataFromBase(bean);
				receiveUnitManage.save();
			}
		}
	}

	private static Integer getAreaId(String areaName, List<BaseArea> list) {
		Integer areaId = null;
		for (BaseArea baseArea : list) {
			if (null != areaName && areaName.equals(baseArea.getAreaName())) {
				areaId = baseArea.getAreaId();
				break;
			}
		}
		return areaId;
	}

	/**
	 * 回款数据的导入
	 *
	 * @param sheet
	 */
	private static void onUploadCapitals(Sheet sheet) throws SQLException {
		Capital capital = new Capital();
		BaseCapital bean;
		ArrayList<BaseCapital> beans = new ArrayList<>();
		// 初始化行数
		int countRow = 0;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		for (int j = 1; j <= countRow; j++) {
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			// 获取每一行的列数
			countCol = row.getLastCellNum();
			bean = new BaseCapital();
			for (int i = 0; i < countCol + 1; i++) {
				// 创建一个列单元对象
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String selfName = cell.getStringCellValue();
						switch (selfName) {
						case "汉米敦（上海）工程咨询股份有限公司":
							bean.setSelfName(10);
							break;
						case "汉米敦（北京）国际工程设计有限公司":
							bean.setSelfName(12);
							break;
						case "上海通博工程顾问有限公司":
							bean.setSelfName(11);
							break;
						case "汉米敦（深圳）国际工程咨询有限公司":
							bean.setSelfName(13);
							break;
						case "陕西汉米敦建筑设计有限公司":
							bean.setSelfName(15);
							break;
						}
						break;
					case 1:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setSelfBankName(cell.getStringCellValue());
						break;
					case 2:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setSelfBankAccount(cell.getStringCellValue());
						break;
					case 3:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setOtherName(cell.getStringCellValue());
						break;
					case 4:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setLoanMoney(GenericBase.__getDecimal(cell.getStringCellValue()));
						break;
					case 5:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setHappenDate(GenericBase.__getDate(cell.getStringCellValue()));
						break;
					case 6:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setCreateDate(GenericBase.__getDate(cell.getStringCellValue()));
						break;
					}
				}
			}
			beans.add(bean);
		}

		capital.save(beans);
	}

	/**
	 * 发票管理数据的导入
	 *
	 * @param sheet
	 * @throws Exception
	 */

	/**
	 * 通过合同编号获取合同ID
	 *
	 * @param contractName
	 * @param contractList
	 * @return
	 */
	private static Integer getContractId(String contractCode, List<BaseContract> contractList) {
		Integer contractId = null;
		for (BaseContract baseContract : contractList) {
			if (contractCode != null && contractCode.equals(baseContract.getContractCode())) {
				contractId = baseContract.getContractId();
			}
		}

		return contractId;

	}

	/**
	 * 主项目表数据的导入
	 *
	 * @param sheet
	 * @throws Exception
	 */
	private static void onUploadMainProject(Sheet sheet) throws Exception {

		MainProject dao = new MainProject();
		SystemDictionary sdDao = new SystemDictionary();
		Customer customer = new Customer();
		Department department = new Department();
		Contract contract = new Contract();
		PreProject preProject = new PreProject();
		MainProject mainProject = new MainProject();
		MainProjectEmployee mainProjectEmployee = new MainProjectEmployee();
		com.pomplatform.db.dao.Employee employee = new com.pomplatform.db.dao.Employee();
		// 初始化行数
		int countRow = 0;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		for (int j = 1; j <= countRow; j++) {
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			// 获取每一行的列数
			//信息编号
			String infoCode = null;
			//项目编号
			String projectCode = null;
			//合同编号
			String contractCode = null;
			//项目名称
			String projectName = null;
			//合同名称
			String contractName = null;
			//客户名称***customers_name
			Integer customerName = null;
			//立项依据***system_dictionary_28
			Integer projectBaseOn = null;
			//投标结果***system_dictionary_128
			Integer bidType = null;
			//是否外包
			Boolean outsource = null;
			//拟签约公司****system_dictionary_26
			Integer signCompany = null;
			//设计资质章
			String designQualification = null;
			//主办设计团队****departments
			Integer designTeam = null;
			//项目营销团队
			String projectSalesTeam = null;
			//立项类型
			Integer mainProjectStageId = null;
			//是否修改项目
			Boolean isModifyProject = null;
			//项目秘书
			String projectSecretary = null;
			//运营董事
			String operatingDirector = null;
			//项目经理
			String projectManager = null;
			//项目负责人
			String projectPrincipal = null;
			//签约总金额
			String contractedAmount = null;
			//合同签约状态** 139
			Integer contractSigningStatus = null;
			//合同跟进人
			Integer relevantEmployeesNameId = null;
			//合同相关跟进人
			String relevantEmployeesName = null;
			//合同签订日期
			Date contractDate = null;
			//项目主管领导
			String projectLeader = null;
			String temp1 = "";
			countCol = row.getLastCellNum();
			for (int i = 0; i < countCol + 1; i++) {
				// 创建一个列单元对象
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
						case 0:
							// 信息编号
							cell.setCellType(Cell.CELL_TYPE_STRING);
							infoCode = cell.getStringCellValue();
							break;
						case 1:
							// 项目编号
							cell.setCellType(Cell.CELL_TYPE_STRING);
							projectCode = cell.getStringCellValue();
							break;
						case 2:
							// 合同编号
							cell.setCellType(Cell.CELL_TYPE_STRING);
							contractCode = cell.getStringCellValue();
							break;
						case 3:
							// 项目名称
							cell.setCellType(Cell.CELL_TYPE_STRING);
							projectName = cell.getStringCellValue();
							break;
						case 4:
							// 合同名称
							cell.setCellType(Cell.CELL_TYPE_STRING);
							contractName = cell.getStringCellValue();
							break;
						case 5:
							//客户名称***customers_name
							cell.setCellType(Cell.CELL_TYPE_STRING);
							temp1 = cell.getStringCellValue();
							//替换客户的名称
							customer.clear();
							customer.setConditionCustomerName("=", temp1);
							BaseCustomer baseCustomer = customer.executeQueryOneRow();
							if (null != baseCustomer) {
								customerName = baseCustomer.getCustomerId();
							}
							break;
						case 6:
							// 立项依据***system_dictionary_28
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String temp2 = cell.getStringCellValue();
							//替换立项依据
							projectBaseOn = getSystemDictionaryValue(28, temp2);
							break;
						case 7:
							// 投标结果***system_dictionary_128
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String temp3 = cell.getStringCellValue();
							//替换投标结果
							bidType = getSystemDictionaryValue(128, temp3);
							break;
						case 8:
							//是否有外包
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String temp4 = cell.getStringCellValue();
							switch (temp4) {
								case "有":
									outsource = true;
									break;
								case "无":
									outsource = false;
									break;
							}
							break;
						case 9:
							//拟签约公司****system_dictionary_26
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String temp5 = cell.getStringCellValue();
							//替换签约公司
							signCompany = getSystemDictionaryValue(26, temp5);
							break;
						case 10:
							//设计资质章
							cell.setCellType(Cell.CELL_TYPE_STRING);
							designQualification = cell.getStringCellValue();
							break;
						case 11:
							//主办设计团队****departments
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String temp6 = cell.getStringCellValue();
							//替换主办团队
							department.clear();
							department.setConditionDepartmentName("=", temp6);
							BaseDepartment baseDepartment = department.executeQueryOneRow();
							if (null != baseDepartment) {
								designTeam = baseDepartment.getDepartmentId();
							}
							break;
						case 12:
							//项目营销团队
							cell.setCellType(Cell.CELL_TYPE_STRING);
							projectSalesTeam = cell.getStringCellValue();
							break;
						case 13:
							//立项类型
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String temp14 = cell.getStringCellValue();
							MainProjectStage mainProjectStage = new MainProjectStage();
							mainProjectStage.setConditionMainStageName("=", temp14);
							BaseMainProjectStage baseMainProjectStage = mainProjectStage.executeQueryOneRow();
							if (null != baseMainProjectStage) {
								mainProjectStageId = baseMainProjectStage.getMainProjectStageId();
							}
							break;
						case 14:
							//是否修改项目
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String temp7 = cell.getStringCellValue();
							switch (temp7) {
								case "是":
									isModifyProject = true;
									break;
								case "否":
									isModifyProject = false;
									break;
							}
							break;
						case 15:
							//项目秘书
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String temp8 = cell.getStringCellValue();
							projectSecretary = temp8;
//							projectSecretary = getEmployeeIdByName(temp8);
							break;
						case 16:
							//运营董事
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String temp9 = cell.getStringCellValue();
							operatingDirector = temp9;
//							operatingDirector = getEmployeeIdByName(temp9);
							break;
						case 17:
							//项目经理
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String temp10 = cell.getStringCellValue();
							projectManager = temp10;
//							projectManager = getEmployeeIdByName(temp10);
							break;
						case 18:
							//项目负责人
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String temp11 = cell.getStringCellValue();
							projectPrincipal = temp11;
//							projectPrincipal = getEmployeeIdByName(temp11);
							break;
						case 19:
							//签约总金额
							cell.setCellType(Cell.CELL_TYPE_STRING);
							contractedAmount = cell.getStringCellValue();
							break;
						case 20:
							//合同签约状态** 139
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String temp12 = cell.getStringCellValue();
							contractSigningStatus = getSystemDictionaryValue(139, temp12);
							break;
						case 21:
							//合同跟进人
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String temp13 = cell.getStringCellValue();
							relevantEmployeesName = temp13;
							relevantEmployeesNameId = getEmployeeIdByName(temp13);
							break;
						case 22:
							//合同签订日期
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String tempDate1 = cell.getStringCellValue();
							if (!BaseHelpUtils.isNullOrEmpty(tempDate1)) {
								contractDate = strToDate(tempDate1);
							}
							break;
						case 23:
							//项目主管领导
							cell.setCellType(Cell.CELL_TYPE_STRING);
							projectLeader = cell.getStringCellValue();
						default:
							break;
						}
					}
				}
			//保存或更新项目以及合同的数据
			//处理合同的数据
			contract.clear();
			contract.setConditionContractCode("=", projectCode);
//			contract.conditionalDelete();
			BaseContract baseContract = contract.executeQueryOneRow();
			//如果合同为空则保存
			if (null == baseContract) {
				baseContract = new BaseContract();
				baseContract.setContractCode(projectCode);
				baseContract.setContractName(contractName);
				baseContract.setSigningMoneySum(BaseHelpUtils.getBigDecimalValue(contractedAmount));
				baseContract.setContractSigningStatus(contractSigningStatus);
				baseContract.setContractFollower(relevantEmployeesNameId);
				baseContract.setRelevantEmployees(relevantEmployeesNameId.toString());
				baseContract.setRelevantEmployeesName(relevantEmployeesName);
				baseContract.setContractDate(contractDate);
				baseContract.setCustomerId(customerName);
				baseContract.setProjectCode(projectCode);
				baseContract.setSigningCompanyName(signCompany);
//				baseContract.setCustomerName(temp1);
				baseContract.setProjectApprovalTime(new Date());
				contract.setDataFromBase(baseContract);
				contract.save();
			} else {
				baseContract.setContractCode(projectCode);
				baseContract.setContractName(contractName);
				baseContract.setSigningMoneySum(BaseHelpUtils.getBigDecimalValue(contractedAmount));
				baseContract.setContractSigningStatus(contractSigningStatus);
				baseContract.setContractFollower(relevantEmployeesNameId);
				baseContract.setRelevantEmployees(relevantEmployeesNameId.toString());
				baseContract.setRelevantEmployeesName(relevantEmployeesName);
				baseContract.setSigningCompanyName(signCompany);
				baseContract.setCustomerId(customerName);
				baseContract.setContractDate(contractDate);
				baseContract.setProjectCode(projectCode);
//				baseContract.setCustomerName(temp1);
				baseContract.setProjectApprovalTime(new Date());
				contract.setDataFromBase(baseContract);
				contract.update();
			}

			//处理大项目的数据
			Boolean flag = false;
			mainProject.clear();
			mainProject.setConditionProjectCode("=", projectCode);
			BaseMainProject baseMainProject = mainProject.executeQueryOneRow();
			if (null == baseMainProject) {
				baseMainProject = new BaseMainProject();
				flag = true;
			} else {
				flag = false;
			}
			baseMainProject.setInfoCode(infoCode);
			baseMainProject.setProjectCode(projectCode);
			baseMainProject.setProjectName(projectName);
			baseMainProject.setClientId(customerName);
			baseMainProject.setProcessStatus(2);
			baseMainProject.setProjectBaseOn(projectBaseOn);
			baseMainProject.setBidType(bidType);
			baseMainProject.setSignCompany(signCompany);
			baseMainProject.setDesignQualification(designQualification);
			baseMainProject.setDesignTeam(designTeam);
			baseMainProject.setProjectSalesTeam(projectSalesTeam);
			baseMainProject.setMainProjectStageId(mainProjectStageId);
			baseMainProject.setIsModifyProject(isModifyProject);
			baseMainProject.setCustomerName(temp1);

			//复制前期项目的信息带入带大项目中
			preProject.clear();
			preProject.setConditionInfoCode("=", infoCode);
			BasePreProject basePreProject = preProject.executeQueryOneRow();
			if (null != basePreProject) {
				//项目类别
				baseMainProject.setProjectType(basePreProject.getProjectType());
				baseMainProject.setProvince(basePreProject.getProvince());
				baseMainProject.setCity(basePreProject.getCity());
				baseMainProject.setDetailAddress(basePreProject.getDetailAddress());
				baseMainProject.setCustomerAddress(basePreProject.getCustomerAddress());
			}

			mainProject.clear();
			mainProject.setDataFromBase(baseMainProject);

			int mainProjectId = 0;
			if (flag) {
				mainProject.save();
				mainProjectId = mainProject.generateBase().getMainProjectId();
			} else {
				mainProject.update();
				mainProjectId = baseMainProject.getMainProjectId();
			}

			//保存或者更新项目秘书
			saveOrUpdateMaiinProjectEmployees(projectSecretary, mainProjectId, 1);
			//保存或者更新运营董事
			saveOrUpdateMaiinProjectEmployees(operatingDirector, mainProjectId, 2);
			//项目经理
			saveOrUpdateMaiinProjectEmployees(projectManager, mainProjectId, 3);
			//项目主管领导
			saveOrUpdateMaiinProjectEmployees(projectLeader, mainProjectId, 4);
			//项目负责人
			saveOrUpdateMaiinProjectEmployees(projectPrincipal, mainProjectId, 5);
		}
	}

	private static void saveOrUpdateMaiinProjectEmployees(String employeeNames, Integer mainProjectId, Integer relation ) throws SQLException {
		Employee employee = new Employee();
		if (!BaseHelpUtils.isNullOrEmpty(employeeNames)) {
			MainProjectEmployee mainProjectEmployee = new MainProjectEmployee();
			mainProjectEmployee.clear();
			BaseMainProjectEmployee baseMainProjectEmployee1 = new BaseMainProjectEmployee();
			mainProjectEmployee.setConditionMainProjectId("=", mainProjectId);
			mainProjectEmployee.setConditionRelation("=", relation);
			mainProjectEmployee.conditionalDelete();
			String[] split = employeeNames.split("/");
			for (String s : split) {
				employee.clear();
				Integer employeeId = getEmployeeIdByName(s);
				baseMainProjectEmployee1 = new BaseMainProjectEmployee();
				baseMainProjectEmployee1.setRelation(relation);
				baseMainProjectEmployee1.setMainProjectId(mainProjectId);
				baseMainProjectEmployee1.setEmployeeId(employeeId);
				mainProjectEmployee.setDataFromBase(baseMainProjectEmployee1);
				mainProjectEmployee.save();
			}
		}

	}


	private static Integer getEmployeeIdByName(String employeeName) throws SQLException {
		Integer employeeId = null;
		Employee employee = new Employee();
		employee.setConditionEmployeeName("=", employeeName);
		BaseEmployee baseEmployee = employee.executeQueryOneRow();
		if (null != baseEmployee) {
			employeeId = baseEmployee.getEmployeeId();
		}
		return employeeId;
	}

	private static Integer getSystemDictionaryValue(int systemDictypeId, String systemDictypeValueName) throws SQLException {
		Integer systemDictionValue = 0;
		SystemDictionary systemDictionary = new SystemDictionary();
		systemDictionary.setConditionDicTypeId("=", systemDictypeId);
		systemDictionary.setConditionDicTypeValue("=", systemDictypeValueName);
		BaseSystemDictionary baseSystemDictionary = systemDictionary.executeQueryOneRow();
		if (null != baseSystemDictionary) {
			systemDictionValue = baseSystemDictionary.getDicTypeValueId();
		}
		return systemDictionValue;
	}

	/**
	 * 合同表数据的导入
	 *
	 * @param sheet
	 * @throws Exception
	 */
	private static void onUploadContract(Sheet sheet) throws Exception {

		Contract dao = new Contract();

		BaseContract bean;

		List<BaseContract> beans = new ArrayList<BaseContract>();

		SystemDictionary sdDao = new SystemDictionary();
		List<BaseSystemDictionary> sdList = sdDao.conditionalLoad();

		// 初始化行数
		int countRow = 0;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		for (int j = 1; j <= countRow; j++) {
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			// 获取每一行的列数
			countCol = row.getLastCellNum();
			bean = new BaseContract();
			for (int i = 0; i < countCol + 1; i++) {
				// 创建一个列单元对象
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						// 信息编号 info_code
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setInfoCode(cell.getStringCellValue());
						break;
					case 1:
						// 项目编号project_code
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setProjectCode(cell.getStringCellValue());
						break;
					case 2:
						// 合同编号 contract_code
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setContractCode(cell.getStringCellValue());
						break;
					case 3:
						// 合同名称 contract_name
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setContractName(cell.getStringCellValue());
						break;
					case 4:
						// 签约总金额 signing_money_sum
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setSigningMoneySum(GenericBase.__getDecimal(cell.getStringCellValue()));
						;
						break;
					case 5:
						// 总设计面积design_areas
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setDesignAreas(GenericBase.__getDecimal(cell.getStringCellValue()));
						break;
					case 6:
						// 合同单价 contract_price
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setContractPrice(GenericBase.__getDecimal(cell.getStringCellValue()));
						break;
					case 7:
						// 合同签订日期 contract_date
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setContractDate(GenericBase.__getDate(cell.getStringCellValue()));
						break;
					case 8:
						// 合同状态 contract_status
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setContractStatus(returnSystemValue(35, cell.getStringCellValue(), sdList));
						break;
					case 9:
						// 合同类别 contract_type
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setContractType(returnSystemValue(27, cell.getStringCellValue(), sdList));
						break;
					default:
						break;
					}
				}

			}
			beans.add(bean);
		}
		dao.save(beans);

	}

	/**
	 * 订单表和项目表数据的导入
	 *
	 * @param sheet
	 * @throws Exception
	 */
	private static void onUploadSubContractAndProject(Sheet sheet) throws Exception {

		SubContract scDao = new SubContract();
		BaseSubContract scBean;
		List<BaseSubContract> scBeans = new ArrayList<BaseSubContract>();

		Project pDao = new Project();
		BaseProject pBean;
		List<BaseProject> pBeans = new ArrayList<BaseProject>();

		SystemDictionary sdDao = new SystemDictionary();
		List<BaseSystemDictionary> sdList = sdDao.conditionalLoad();

		Employee eDao = new Employee();
		List<BaseEmployee> eList = eDao.conditionalLoad();

		PlateRecord prDao = new PlateRecord();
		List<BasePlateRecord> prList = prDao.conditionalLoad();

		Contract cDao = new Contract();
		List<BaseContract> cList = cDao.conditionalLoad();

		// 初始化行数
		int countRow = 0;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		for (int j = 1; j <= countRow; j++) {
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			// 获取每一行的列数
			countCol = row.getLastCellNum();
			scBean = new BaseSubContract();
			pBean = new BaseProject();
			for (int i = 0; i < countCol + 1; i++) {
				// 创建一个列单元对象
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						// 合同编号 contract_code
						cell.setCellType(Cell.CELL_TYPE_STRING);
						pBean.setContractCode(cell.getStringCellValue());
						scBean.setParentId(getContractId(cell.getStringCellValue(), cList));
						break;
					case 1:
						// 订单名称
						cell.setCellType(Cell.CELL_TYPE_STRING);
						pBean.setProjectName(cell.getStringCellValue());
						scBean.setSubContractName(cell.getStringCellValue());
						break;
					case 2:
						// 项目类别32
						cell.setCellType(Cell.CELL_TYPE_STRING);
						pBean.setProjectType(returnSystemValue(32, cell.getStringCellValue(), sdList));
						scBean.setProjectType(returnSystemValue(32, cell.getStringCellValue(), sdList));
						break;
					case 3:
						// 业务部门 plate_id
						cell.setCellType(Cell.CELL_TYPE_STRING);
						pBean.setPlateId(getPlateId(cell.getStringCellValue(), prList));
						scBean.setDepartmentId(getPlateId(cell.getStringCellValue(), prList));
						break;
					case 4:
						// 业务类别 business_type
						cell.setCellType(Cell.CELL_TYPE_STRING);
						pBean.setBusinessType(returnSystemValue(31, cell.getStringCellValue(), sdList));
						scBean.setBusinessType(returnSystemValue(31, cell.getStringCellValue(), sdList));
						;
						break;
					case 5:
						// 项目等级 project_level
						cell.setCellType(Cell.CELL_TYPE_STRING);
						pBean.setProjectLevel(returnSystemValue(2, cell.getStringCellValue(), sdList));
						break;
					case 6:
						// 事业部负责人 工号 plate_manager_id
						cell.setCellType(Cell.CELL_TYPE_STRING);
						pBean.setPlateManagerId(getEmployeeId(cell.getStringCellValue(), eList));
						;
						break;
					case 7:
						// 部门经理 工号 department_manager_id
						cell.setCellType(Cell.CELL_TYPE_STRING);
						pBean.setDepartmentId(getEmployeeId(cell.getStringCellValue(), eList));
						break;
					case 8:
						// 专业负责人 project_manage_id
						cell.setCellType(Cell.CELL_TYPE_STRING);
						pBean.setProjectManageId(getEmployeeId(cell.getStringCellValue(), eList));
						scBean.setProjectManageId(getEmployeeId(cell.getStringCellValue(), eList));
						break;
					case 9:
						// 项目状态 status
						cell.setCellType(Cell.CELL_TYPE_STRING);
						pBean.setStatus(returnSystemValue(27, cell.getStringCellValue(), sdList));
						break;
					case 10:
						// 订单合同金额 sheet_amount
						cell.setCellType(Cell.CELL_TYPE_STRING);
						pBean.setSheetAmount(GenericBase.__getDecimal(cell.getStringCellValue()));
						scBean.setMoneySum(GenericBase.__getDecimal(cell.getStringCellValue()));
						break;
					case 11:
						// 项目完工百分比 total_finish_percent
						cell.setCellType(Cell.CELL_TYPE_STRING);
						pBean.setTotalFinishPercent(GenericBase.__getDecimal(cell.getStringCellValue()));
						break;
					case 12:
						// 项目总积分 total_integral
						cell.setCellType(Cell.CELL_TYPE_STRING);
						pBean.setTotalIntegral(GenericBase.__getDecimal(cell.getStringCellValue()));
						scBean.setSheetTotalIntegral(GenericBase.__getDecimal(cell.getStringCellValue()));
						break;
					case 13:
						// 预留积分 reserve_integral
						cell.setCellType(Cell.CELL_TYPE_STRING);
						pBean.setReserveIntegral(GenericBase.__getDecimal(cell.getStringCellValue()));
						break;
					case 14:
						// 项目积分 project_integral
						cell.setCellType(Cell.CELL_TYPE_STRING);
						pBean.setProjectIntegral(GenericBase.__getDecimal(cell.getStringCellValue()));
						scBean.setSheetIntegral(GenericBase.__getDecimal(cell.getStringCellValue()));
						break;
					default:
						break;
					}
				}

			}
			pBeans.add(pBean);
			scBeans.add(scBean);
		}
		pDao.save(pBeans);
		scDao.save(scBeans);

	}

	/**
	 * 通过业务部门获取plateId
	 *
	 * @param contractName
	 * @param contractList
	 * @return
	 */
	private static Integer getPlateId(String plateName, List<BasePlateRecord> prList) {
		Integer plateId = null;
		for (BasePlateRecord basePlateRecord : prList) {
			if (plateName != null && plateName.equals(basePlateRecord.getPlateName())) {
				plateId = basePlateRecord.getPlateId();
			}
		}
		return plateId;
	}

	private static void setEmployeeDayPlateRecord(int year, int month, int day) throws ParseException, SQLException {

		Employee dao = new Employee();
		EmployeeDayPlateRecord dayDao = new EmployeeDayPlateRecord();
		/*
		 * Calendar c =Calendar.getInstance(); if(year<=0||month<=0||day<=0) {
		 * 
		 * }else { c.set(year,month-1,day); } Date time = c.getTime();
		 * dao.setConditionOnboardDate(">=", time);
		 *
		 * 
		 */

		String[] str2 = new String[] { "600848", "600897", "601087", "601095", "600797", "600797", "601101", "601100",
				"601090", "601091", "601089", "601094", "601106", "601104", "600987", "600802", "601092", "601093",
				"600708", "600733", "600738", "600931", "601103", "600973" };

		dao.addCondition("employee_no", "in", str2);
		List<BaseEmployee> conditionalLoad = dao.conditionalLoad();

		Calendar c = Calendar.getInstance();
		c.set(2019, 1, 1);
		Date onBoardDate = c.getTime();
		StringBuffer str = new StringBuffer();
		str.append("OnboardDate is null 的人员{");
		for (BaseEmployee baseEmployee : conditionalLoad) {
			// 向员工每月归属业务部门表插入数据
			int plateId = BaseHelpUtils.getIntValue(baseEmployee.getPlateId());
//			Date onBoardDate = baseEmployee.getOnboardDate();
			// 根据入职日期，录入当前月的日归属
			// 获取入职日期
			if (!BaseHelpUtils.isNullOrEmpty(onBoardDate)) {
				Date endDate = DateUtil.getLastDay(onBoardDate);
				int newyear = DateUtil.getYear(onBoardDate);
				int newmonth = DateUtil.getMonth(onBoardDate);
				for (Date recordDate = DateUtil.getFirstDay(onBoardDate); recordDate
						.compareTo(endDate) <= 0; recordDate = DateUtil.getNextDayOfDay(recordDate, 1)) {
					dayDao.clear();
					dayDao.setConditionEmployeeId("=", BaseHelpUtils.getIntValue(baseEmployee.getEmployeeId()));
					dayDao.setConditionRecordDate("=", recordDate);
					if (dayDao.isExist()) {
						continue;
					} else {
						dayDao.clear();
						dayDao.setYear(newyear);
						dayDao.setMonth(newmonth);
						dayDao.setRecordDate(recordDate);
						dayDao.setEmployeeId(BaseHelpUtils.getIntValue(baseEmployee.getEmployeeId()));
						dayDao.setPlateId(BaseHelpUtils.getIntValue(baseEmployee.getPlateId()));
						dayDao.setDepartmentId(BaseHelpUtils.getIntValue(baseEmployee.getDepartmentId()));
						dayDao.setCompanyId(BaseHelpUtils.getIntValue(baseEmployee.getCompanyId()));
						dayDao.setEmployeeNo(baseEmployee.getEmployeeNo());
						dayDao.setEmployeeName(baseEmployee.getEmployeeName());
						dayDao.save();
					}
				}
			} else {
				str.append("(" + baseEmployee.getEmployeeId() + "," + baseEmployee.getEmployeeName() + ")");
			}
		}

		str.append("}");
		System.out.println(str.toString());

	}

	/**
	 * 
	 *
	 * @param sheet
	 * @throws Exception
	 */
	private static void onUploadOrSaveContract(Sheet sheet) throws Exception {

		Contract conDao = new Contract();
		BaseContract pBean = null;

		Employee eDao = new Employee();
		CompanyRecord crDao = new CompanyRecord();

		// 初始化行数
		int countRow = 0;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		for (int j = 1; j <= countRow; j++) {
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			pBean = new BaseContract();

			// 获取每一行的列数
			countCol = row.getLastCellNum();
			for (int i = 0; i < countCol + 1; i++) {
				// 创建一个列单元对象
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						break;
					case 1:
						// 合同编号
						cell.setCellType(Cell.CELL_TYPE_STRING);
						pBean.setContractCode(cell.getStringCellValue());
						break;
					case 2:
						// 合同名称
						cell.setCellType(Cell.CELL_TYPE_STRING);
						pBean.setContractName(cell.getStringCellValue());
						break;
					case 3:
						// 客户名称
						cell.setCellType(Cell.CELL_TYPE_STRING);
						pBean.setCustomerName(cell.getStringCellValue());
						break;
					case 4:
						// 签约总金额
						cell.setCellType(Cell.CELL_TYPE_STRING);
						pBean.setSigningMoneySum(GenericBase.__getDecimal(cell.getStringCellValue()));
						break;
					case 5:
						// 合同签订状态
						cell.setCellType(Cell.CELL_TYPE_STRING);
						pBean.setContractStatus(BaseHelpUtils.getIntValue(cell.getStringCellValue()));
						break;
					case 6:
						// 合同跟进人
						cell.setCellType(Cell.CELL_TYPE_STRING);
						eDao.clear();
						eDao.setConditionEmployeeName("=", cell.getStringCellValue());
						pBean.setContractFollower(eDao.executeQueryOneRow() != null ? 0
								: BaseHelpUtils.getIntValue(eDao.executeQueryOneRow().getEmployeeId()));
						break;
					case 7:
						// 合同签订日期
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String onboardDateValue = cell.getStringCellValue();
						if (!BaseHelpUtils.isNullOrEmpty(onboardDateValue)) {
							pBean.setContractDate(new SimpleDateFormat("yyyy-MM-dd").parse(onboardDateValue));
						}
						break;
					case 8:
						// 我方签约公司
						cell.setCellType(Cell.CELL_TYPE_STRING);
						crDao.clear();
						crDao.setConditionCompanyName("=", cell.getStringCellValue());
						crDao.setConditionIsEnabled("=", true);
						if (crDao.executeQueryOneRow() != null) {
							pBean.setSigningCompanyName(
									BaseHelpUtils.getIntValue(crDao.executeQueryOneRow().getCompanyRecordId()));
						}
						break;
					case 9:
						// 项目地点
						cell.setCellType(Cell.CELL_TYPE_STRING);
						pBean.setProjectAddress(cell.getStringCellValue());
						break;
					default:
						break;
					}
				}
			}

			//
			conDao.clear();
			conDao.setConditionContractCode("=", pBean.getContractCode());
//			conDao.setContractCode(pBean.getContractCode());
			BaseContract executeQueryOneRow = conDao.executeQueryOneRow();
			if (!BaseHelpUtils.isNullOrEmpty(executeQueryOneRow)) {
				conDao.setDataFromBase(pBean);
				conDao.setContractId(executeQueryOneRow.getContractId());
				conDao.update();
			} else {
				conDao.setDataFromBase(pBean);
				conDao.save();
			}
		}

	}

	/**
	 * 字典表数据的导入
	 *
	 * @param sheet
	 * @throws Exception
	 */
	private static void onUploadSystemDictionary(Sheet sheet) throws Exception {

		SystemDictionary dao = new SystemDictionary();

		BaseSystemDictionary bean;

		List<BaseSystemDictionary> beans = new ArrayList<BaseSystemDictionary>();

		// 初始化行数
		int countRow = 0;
		// 列表数据代码
		int dicTypeId = 0;
		// 列表数据名称
		String dicTypeName = null;
		// 数据值
		String dicTypeValue = null;
		// 是否启用
		boolean dicIsEnable = true;
		countRow = sheet.getLastRowNum();

		int k = 1;
		int countCol = 0;
		for (int j = 1; j <= countRow; j++) {

			Row row = sheet.getRow(j);

			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			// 获取每一行的列数
			countCol = row.getLastCellNum();

			bean = new BaseSystemDictionary();

			for (int i = 0; i < countCol + 1; i++) {
				// 创建一个列单元对象
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						dicTypeId = Integer.parseInt(cell.getStringCellValue());
						break;
					case 1:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						dicTypeName = cell.getStringCellValue();
						break;
					case 2:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						dicTypeValue = cell.getStringCellValue();
						break;
					default:
						break;
					}

				}

			}
			bean.setDicTypeId(dicTypeId);
			bean.setDicTypeName(dicTypeName);
			bean.setDicTypeValueId(k++);
			bean.setDicTypeValue(dicTypeValue);
			bean.setDicIsEnable(dicIsEnable);
			if (!BaseHelpUtils.isNullOrEmpty(dicTypeValue)) {
				beans.add(bean);
			}

		}
		// 排序
//		sortIntMethod(beans);
//
//		if (beans.size() > 0) {
//			int tmpTypeId = -1;
//			int ide = 0;
//			for (BaseSystemDictionary sdbean : beans) {
//				if (tmpTypeId == sdbean.getDicTypeId()) {
//					ide++;
//				} else {
//					ide = 1;
//				}
//				sdbean.setDicTypeValueId(ide);
//				tmpTypeId = sdbean.getDicTypeId();
//
//			}
//		}
		dao.save(beans);

	}

	/**
	 * @Author:
	 * @Description :
	 * @Date: 15:32 2019/6/4
	 */
	private static void onUploadStageTemplates(Sheet sheet) throws SQLException {

		MainProjectStage dao = new MainProjectStage();

		int num = 7;
		int countRow = 0;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		for (int j = 1; j < countRow; j++) {
			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			num += 1;
			// 获取每一行的列数
			BigDecimal percent = BigDecimal.ZERO;
			String name = "";
			String code = "";
			countCol = row.getLastCellNum();
			for (int i = 0; i <= countCol + 1; i++) {
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						code = cell.getStringCellValue();
						break;
					case 1:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						name = cell.getStringCellValue();
						break;
					case 2:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						percent = BaseHelpUtils.getBigDecimalValue(cell.getStringCellValue())
								.multiply(new BigDecimal(100));
						break;
					default:
						break;
					}
				}

			}
			BaseMainProjectStage bean = new BaseMainProjectStage();
			bean.setMainStageName(name);
			bean.setMainStageCode(code);
			bean.setPercent(percent);
			dao.setDataFromBase(bean);
			dao.save();
		}
	}

	public static void main(String[] args) {
		File file = new File("C:/Users/Administrator/Desktop/库博项目案例（10个）(1)(1).xlsx");
		try {
			onUpload(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * try {
		 * 
		 * 
		 * 
		 * File file = new File("C:\\Users\\Administrator\\Desktop\\财务数据导入模板.xlsx"); //
		 * 将指定路径的数据读取到workbook中 Workbook workbook = WorkbookFactory.create(new
		 * FileInputStream(file)); // 获取workbook的sheet数 int count =
		 * workbook.getNumberOfSheets(); Sheet sheet = workbook.getSheetAt(0);
		 * onUploadStageTemplates(sheet);
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */
	}

}
