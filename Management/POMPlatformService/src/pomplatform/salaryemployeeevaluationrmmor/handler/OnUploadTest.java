package pomplatform.salaryemployeeevaluationrmmor.handler;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.pomplatform.db.bean.BaseArea;
import com.pomplatform.db.bean.BaseCardManage;
import com.pomplatform.db.bean.BaseCompanyRecord;
import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseCustomer;
import com.pomplatform.db.bean.BaseDepartment;
import com.pomplatform.db.bean.BaseDepartmentId;
import com.pomplatform.db.bean.BaseEmployeeRole;
import com.pomplatform.db.bean.BaseInvoice;
import com.pomplatform.db.bean.BaseMainProject;
import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseReceiveUnitManage;
import com.pomplatform.db.bean.BaseRole;
import com.pomplatform.db.bean.BaseSubContract;
import com.pomplatform.db.bean.BaseSubjectType;
import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.dao.Area;
import com.pomplatform.db.dao.CardManage;
import com.pomplatform.db.dao.CompanyRecord;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.Customer;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.DepartmentId;
import com.pomplatform.db.dao.EmployeeRole;
import com.pomplatform.db.dao.Invoice;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.PlateRecord;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ReceiveUnitManage;
import com.pomplatform.db.dao.Role;
import com.pomplatform.db.dao.SubContract;
import com.pomplatform.db.dao.SubjectType;
import com.pomplatform.db.dao.SystemDictionary;

import delicacy.common.BaseHelpUtils;
import delicacy.common.DES;
import delicacy.common.GenericBase;
import delicacy.connection.ThreadConnection;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;

public class OnUploadTest {

	@SuppressWarnings("unused")
	private static void onUpload(File file) throws Exception {

		// 将指定路径的数据读取到workbook中
		Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
		// 获取workbook的sheet数
		int count = workbook.getNumberOfSheets();

		for (int i = 0; i < count; i++) {
			// 获取Sheet
			Sheet sheet = workbook.getSheetAt(i);
			switch (i) {
			case 0:
				onUploadSystemDictionary(sheet);
				break;
			case 1:
				onUploadRoles(sheet);
				break;
			case 2:
				onUploadCompanyRecords(sheet);
				break;
			case 3:
				onUploadPlateRecord(sheet);
				break;
			case 4:
				onUploadDepartment(sheet);
				break;
			case 5:
				onUploadEmployee(sheet);
				break;
			case 6:
				onUploadCardPerson(sheet);
				break;
			case 7:
				onUploadCardCompany(sheet);
				break;
			case 8:
				onUploadSubjectType(sheet);
				break;
			case 9:
				onUploadReceiveUnitManage(sheet);
				break;
			default:
				break;
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
			bean.setDicTypeValue(dicTypeValue);
			bean.setDicIsEnable(dicIsEnable);
			if (!BaseHelpUtils.isNullOrEmpty(dicTypeValue)) {
				beans.add(bean);
			}

		}
		// 排序
		sortIntMethod(beans);

		if (beans.size() > 0) {
			int tmpTypeId = -1;
			int ide = 0;
			for (BaseSystemDictionary sdbean : beans) {
				if (tmpTypeId == sdbean.getDicTypeId()) {
					ide++;
				} else {
					ide = 1;
				}
				sdbean.setDicTypeValueId(ide);
				tmpTypeId = sdbean.getDicTypeId();

			}
		}
		dao.save(beans);

	}

	/**
	 * 角色表数据的导入
	 * 
	 * @param sheet
	 * @throws Exception
	 */
	private static void onUploadRoles(Sheet sheet) throws Exception {

		Role dao = new Role();

		BaseRole bean;

		// SystemDictionary sysDao = new SystemDictionary();
		//
		// BaseSystemDictionary sysBean;

		List<BaseRole> beans = new ArrayList<BaseRole>();

		// 初始化行数
		int countRow = 0;
		// 角色名称
		String roleName = null;
		// // 角色类型值
		// String roleTypeValue = null;
		// // 角色类型
		// int roleType = 0;

		int countCol = 0;

		countRow = sheet.getLastRowNum();
		for (int j = 1; j <= countRow; j++) {

			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			// 获取每一行的列数
			countCol = row.getLastCellNum();

			bean = new BaseRole();
			for (int i = 0; i < countCol + 1; i++) {
				// 创建一个列单元对象
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						roleName = cell.getStringCellValue();
						bean.setRoleName(roleName);
						break;
					// case 1:
					// cell.setCellType(Cell.CELL_TYPE_STRING);
					// roleTypeValue = cell.getStringCellValue();
					// break;
					default:
						break;
					}

				}

			}
			beans.add(bean);
			// 根据roleTypeValue在字典表中查询出roleType
			// sysDao.setConditionDicTypeValue("=", roleTypeValue);
			// sysBean = sysDao.executeQueryOneRow();
			// if (!BaseHelpUtils.isNullOrEmpty(sysBean)) {
			// roleType = sysBean.getDicTypeValueId();
			// bean.setRoleName(roleName);
			// bean.setRoleType(roleType);
			// beans.add(bean);
			// }

		}

		dao.save(beans);

	}

	/**
	 * 公司表数据的导入
	 * 
	 * @param sheet
	 * @throws Exception
	 */
	private static void onUploadCompanyRecords(Sheet sheet) throws Exception {

		CompanyRecord dao = new CompanyRecord();

		BaseCompanyRecord bean;

		List<BaseCompanyRecord> beans = new ArrayList<BaseCompanyRecord>();

		// 初始化行数
		int countRow = 0;
		// 公司名称
		String companyName = null;
		// 列表数据名称
		String companyCode = null;
		int countCol = 0;
		countRow = sheet.getLastRowNum();
		for (int j = 1; j <= countRow; j++) {

			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			// 获取每一行的列数
			countCol = row.getLastCellNum();
			bean = new BaseCompanyRecord();
			for (int i = 0; i < countCol + 1; i++) {
				// 创建一个列单元对象
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						companyName = cell.getStringCellValue();
						break;
					case 1:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						companyCode = cell.getStringCellValue();
						break;
					default:
						break;
					}

				}

			}
			bean.setCompanyName(companyName);
			bean.setCompanyCode(companyCode);
			beans.add(bean);
		}

		dao.save(beans);

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

		int plateId = 1;

		int countCol = 0;

		countRow = sheet.getLastRowNum();
		for (int j = 1; j <= countRow; j++) {

			Row row = sheet.getRow(j);
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			bean = new BasePlateRecord();
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
					default:
						break;
					}

				}

			}

			bean.setPlateId(plateId++);
			bean.setPlateCode(plateCode);
			bean.setPlateName(plateName);

			beans.add(bean);
		}

		dao.save(beans);

	}

	/**
	 * 部门表数据的导入
	 * 
	 * @param sheet
	 * @throws Exception
	 */
	private static void onUploadDepartment(Sheet sheet) throws Exception {

		Department dao = new Department();

		BaseDepartment bean;

		List<BaseDepartment> beans = new ArrayList<BaseDepartment>();

		PlateRecord prdao = new PlateRecord();

		BasePlateRecord prbean;

		Map<String, String> map = new HashMap<String, String>();

		// 初始化行数
		int countRow = 0;
		// 部门名称
		String departmentName = null;
		// 父级部门名称
		String parentName = null;
		// 业务部门
		String plateName = null;

		countRow = sheet.getLastRowNum();
		for (int j = 1; j <= countRow; j++) {

			Row row = sheet.getRow(j);
			int colNum = 0;
			if (BaseHelpUtils.isNullOrEmpty(row)) {
				break;
			}
			bean = new BaseDepartment();
			if (row != null) {
				departmentName = row.getCell(colNum++).getStringCellValue();
				parentName = row.getCell(colNum++).getStringCellValue();
				plateName = row.getCell(colNum++).getStringCellValue();
				bean.setDepartmentName(departmentName);
				bean.setAbbreviation(departmentName);
				map.put(departmentName, parentName);
				// 根据业务部门名称或取业务部门id
				prdao.setConditionPlateName("=", plateName);
				prbean = prdao.executeQueryOneRow();
				if (prbean != null) {
					bean.setPlateId(prbean.getPlateId());
				}

			}
			beans.add(bean);
		}

		dao.save(beans);

		// 根据map中的父级部门名称查询出相对应的父级部门的id并更新
		beans.clear();
		beans = dao.conditionalLoad();
		for (BaseDepartment bsbean : beans) {
			parentName = map.get(bsbean.getDepartmentName());
			dao.clear();
			if (null != parentName) {
				dao.setConditionDepartmentName("=", parentName);
				bean = dao.executeQueryOneRow();
				if (bean != null) {
					dao.clear();
					dao.setConditionDepartmentId("=", bsbean.getDepartmentId());
					dao.setParentId(bean.getDepartmentId());
					dao.conditionalUpdate();
					bsbean.setParentId(bean.getParentId());
				}
			}

		}
		List<BaseDepartmentId> idsList = new ArrayList<>();
		for (BaseDepartment baseDepartment : beans) {
			addData(dao, baseDepartment.getDepartmentId(), idsList);
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
					case 3:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						roleName = cell.getStringCellValue();
						// 根据角色名称查找角色id
						if (!BaseHelpUtils.isNullOrEmpty(roleName)) {
							roleDao.setConditionRoleName("=", roleName);
							if (!BaseHelpUtils.isNullOrEmpty(roleDao.executeQueryOneRow())) {
								roleId = roleDao.getRoleId();
								bean.setRoleId(roleId);
							}

						}
						break;
					case 4:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						mobile = cell.getStringCellValue();
						bean.setMobile(mobile);
						break;
					case 5:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						phone = cell.getStringCellValue();
						bean.setPhone(phone);
						break;
					case 6:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						qq = cell.getStringCellValue();
						bean.setQq(qq);
						break;
					case 7:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						email = cell.getStringCellValue();
						bean.setEmail(email);
						break;
					case 8:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String onboardDateValue = cell.getStringCellValue();
						if (!BaseHelpUtils.isNullOrEmpty(onboardDateValue)) {
							onboardDate = strToDate(onboardDateValue);
							bean.setOnboardDate(onboardDate);
						}
						break;
					case 9:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String resignationDateValue = cell.getStringCellValue();
						if (!BaseHelpUtils.isNullOrEmpty(resignationDateValue)) {
							resignationDate = strToDate(resignationDateValue);
							bean.setResignationDate(resignationDate);
						}
						break;
					case 10:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						status = cell.getStringCellValue();
						// 根据状态值查找相对应的状态编码
						if (!BaseHelpUtils.isNullOrEmpty(status)) {
							bean.setStatus(returnSystemValue(11, status, sdList));
						}
						break;
					case 11:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						gender = cell.getStringCellValue();
						// 根据性别查找相对应的状态编码
						if (!BaseHelpUtils.isNullOrEmpty(gender)) {
							bean.setGender(returnSystemValue(12, gender, sdList));
						}
						break;
					case 12:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						age = Integer.parseInt(cell.getStringCellValue());
						bean.setAge(age);
						break;
					case 13:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String birthValue = cell.getStringCellValue();
						if (!BaseHelpUtils.isNullOrEmpty(birthValue)) {
							birth = strToDate(birthValue);
							bean.setBirth(birth);
						}
						break;
					case 14:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						card = cell.getStringCellValue();
						bean.setCard(card);
						break;
					case 15:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						address = cell.getStringCellValue();
						bean.setAddress(address);
						break;
					case 16:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						employeeNameEn = cell.getStringCellValue();
						bean.setEmployeeNameEn(employeeNameEn);
						break;
					case 17:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						education = cell.getStringCellValue();
						bean.setEducation(education);
						break;
					case 18:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						degree = cell.getStringCellValue();
						bean.setDegree(degree);
						break;
					case 19:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						nationality = cell.getStringCellValue();
						bean.setNationality(nationality);
						break;
					case 20:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						marriedStatus = cell.getStringCellValue();
						bean.setMarriedStatus(marriedStatus);
						break;
					case 21:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						health = cell.getStringCellValue();
						bean.setHealth(health);
						break;
					case 22:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						workAddress = cell.getStringCellValue();
						bean.setWorkAddress(workAddress);
						break;
					case 23:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						registeredAddress = cell.getStringCellValue();
						bean.setRegisteredAddress(registeredAddress);
						break;
					case 24:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						politicalFaceName = cell.getStringCellValue();
						// 根据政治面貌查找相对应的状态编码
						if (!BaseHelpUtils.isNullOrEmpty(politicalFaceName)) {
							bean.setPoliticalFace(returnSystemValue(76, politicalFaceName, sdList));
						}
						break;
					case 25:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						birthplace = cell.getStringCellValue();
						bean.setBirthplace(birthplace);
						break;
					case 26:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						country = cell.getStringCellValue();
						bean.setCountry(country);
						break;
					case 27:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						accountLocation = cell.getStringCellValue();
						bean.setAccountLocation(accountLocation);
						break;
					case 28:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						languages = cell.getStringCellValue();
						bean.setLanguages(languages);
						break;
					case 29:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String startWorkDateValue = cell.getStringCellValue();
						if (!BaseHelpUtils.isNullOrEmpty(startWorkDateValue)) {
							startWorkDate = strToDate(startWorkDateValue);
							bean.setStartWorkDate(startWorkDate);
						}
						break;
					case 30:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						socialComputerNumber = cell.getStringCellValue();
						bean.setSocialComputerNumber(socialComputerNumber);
						break;
					case 31:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						fundAccount = cell.getStringCellValue();
						bean.setFundAccount(fundAccount);
						break;
					case 32:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String positiveDateValue = cell.getStringCellValue();
						if (!BaseHelpUtils.isNullOrEmpty(positiveDateValue)) {
							positiveDate = strToDate(positiveDateValue);
							bean.setPositiveDate(positiveDate);
						}
						break;
					case 33:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						tryTime = cell.getStringCellValue();
						bean.setTryTime(tryTime);
						break;
					case 34:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String contractStartDateValue = cell.getStringCellValue();
						if (!BaseHelpUtils.isNullOrEmpty(contractStartDateValue)) {
							contractStartDate = strToDate(contractStartDateValue);
							bean.setContractStartDate(contractStartDate);
						}
						break;
					case 35:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String contractEndDateValue = cell.getStringCellValue();
						if (!BaseHelpUtils.isNullOrEmpty(contractEndDateValue)) {
							contractEndDate = strToDate(contractEndDateValue);
							bean.setContractEndDate(contractEndDate);
						}
						break;
					case 36:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						emergencyContactPerson = cell.getStringCellValue();
						bean.setEmergencyContactPerson(emergencyContactPerson);
						break;
					case 37:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						emergencyContactPhone = cell.getStringCellValue();
						bean.setEmergencyContactPhone(emergencyContactPhone);
						break;
					case 38:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						homePhone = cell.getStringCellValue();
						bean.setHomePhone(homePhone);
						break;
					case 39:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						nowAddress = cell.getStringCellValue();
						bean.setNowAddress(nowAddress);
						break;
					case 40:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						tryTimePay = cell.getStringCellValue();
						bean.setTryTimePay(tryTimePay);
						break;
					case 41:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						positivePay = cell.getStringCellValue();
						bean.setPositivePay(positivePay);
						break;
					case 42:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bankCardNum = cell.getStringCellValue();
						bean.setBankCardNum(bankCardNum);

						break;
					case 43:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						fileNumber = cell.getStringCellValue();
						bean.setFileNumber(fileNumber);
						break;
					case 44:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						householdRegistration = cell.getStringCellValue();
						// 根据户籍查找相对应的状态编码
						if (!BaseHelpUtils.isNullOrEmpty(householdRegistration)) {
							bean.setHouseholdRegistration(returnSystemValue(81, householdRegistration, sdList));
						}
						break;
					case 45:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						foreman = cell.getStringCellValue();
						bean.setForeman(foreman);
						break;
					case 46:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						cardAddress = cell.getStringCellValue();
						bean.setCardAddress(cardAddress);
						break;
					case 47:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						companyEmail = cell.getStringCellValue();
						bean.setCompanyEmail(companyEmail);
						break;
					case 48:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						companyName = cell.getStringCellValue();
						if (!BaseHelpUtils.isNullOrEmpty(companyName)) {
							ceDao.setConditionCompanyName("=", companyName);
							if (!BaseHelpUtils.isNullOrEmpty(ceDao.executeQueryOneRow())) {
								companyId = ceDao.getCompanyRecordId();
								bean.setCompanyId(companyId);
							}
						}
						break;
					case 49:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						onboardStatus = cell.getStringCellValue();
						// 根据入职员工状态查找相对应的状态编码
						if (!BaseHelpUtils.isNullOrEmpty(onboardStatus)) {
							bean.setOnboardStatus(returnSystemValue(96, onboardStatus, sdList));
						}
						break;
					default:
						break;
					}
				}
			}
			beans.add(bean);

		}

		dao.save(beans);
		dao.clear();
		List<BaseEmployee> emList = dao.conditionalLoad();
		List<BaseEmployeeRole> erList = new ArrayList<>();
		// 往角色关联表插入数据
		for (BaseEmployee baseEmployee : emList) {
			BaseEmployeeRole erBean = new BaseEmployeeRole();
			erBean.setEmployeeId(baseEmployee.getEmployeeId());
			erBean.setRoleId(baseEmployee.getRoleId());
			erList.add(erBean);
		}

		if (erList.size() > 0) {
			EmployeeRole erDao = new EmployeeRole();
			erDao.save(erList);
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
			beans.add(bean);
		}
		dao.save(beans);

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
			beans.add(bean);
		}
		dao.save(beans);

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
	 * 报销科目表数据的导入
	 * 
	 * @param sheet
	 * @throws Exception
	 */
	private static void onUploadSubjectType(Sheet sheet) throws Exception {

		SubjectType dao = new SubjectType();
		BaseSubjectType bean;
		List<BaseSubjectType> beans = new ArrayList<BaseSubjectType>();
		Map<String, String> map = new HashMap<String, String>();
		// 初始化行数
		int countRow = 0;
		// 科目名称
		String subjectName = null;
		// 科目名称名称
		String parentName = null;
		countRow = sheet.getLastRowNum();
		for (int j = 1; j <= countRow; j++) {
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
					bean.setSubjectName(subjectName);
				}
				map.put(subjectName, parentName);

			}
			beans.add(bean);
		}

		dao.save(beans);

		// 根据map中的父级科目名称查询出相对应的父级科目的id并更新
		beans.clear();
		beans = dao.conditionalLoad();
		for (BaseSubjectType bsbean : beans) {
			parentName = map.get(bsbean.getSubjectName());
			dao.clear();
			if (null != parentName) {
				dao.setConditionSubjectName("=", parentName);
				bean = dao.executeQueryOneRow();
				if (bean != null) {
					dao.clear();
					dao.setConditionSubjectTypeId("=", bsbean.getSubjectTypeId());
					dao.setParentId(bean.getSubjectTypeId());
					dao.conditionalUpdate();
				}
			}

		}

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
			beans.add(bean);
		}

		dao.save(beans);

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

	private static void onUploadHistoryDate(File file) throws Exception {

		// 将指定路径的数据读取到workbook中
		Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
		// 获取workbook的sheet数
		int count = workbook.getNumberOfSheets();

		for (int i = 0; i < count; i++) {
			// 获取Sheet
			Sheet sheet = workbook.getSheetAt(i);
			switch (i) {
			case 0:
				onUploadInvoice(sheet);
				break;
			case 1:
				onUploadMainProject(sheet);
				break;
			case 2:
				onUploadContract(sheet);
				break;
			case 3:
				onUploadSubContractAndProject(sheet);
				break;
			default:
				break;
			}

		}

	}

	/**
	 * 发票管理数据的导入
	 * 
	 * @param sheet
	 * @throws Exception
	 */
	private static void onUploadInvoice(Sheet sheet) throws Exception {

		Invoice dao = new Invoice();

		BaseInvoice bean;

		List<BaseInvoice> beans = new ArrayList<BaseInvoice>();

		Contract contractDao = new Contract();
		List<BaseContract> contractList = contractDao.conditionalLoad();

		CompanyRecord crDao = new CompanyRecord();
		List<BaseCompanyRecord> crList = crDao.conditionalLoad();

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

			bean = new BaseInvoice();
			for (int i = 0; i < countCol + 1; i++) {
				// 创建一个列单元对象
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setContractId(getContractId(cell.getStringCellValue(), contractList));
						break;
					case 1:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setTicketingCompany(getCompanyId(cell.getStringCellValue(), crList));
						break;
					case 2:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setInvoiceType(returnSystemValue(52, cell.getStringCellValue(), sdList));
						break;
					case 3:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setInvoiceCode(cell.getStringCellValue());
						break;
					case 4:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setInvoiceNumber(cell.getStringCellValue());
						break;
					case 5:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setInvalidRemark(cell.getStringCellValue());
						break;
					case 6:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String customer = BaseHelpUtils.getString(cell.getStringCellValue());
						Customer customerDao = new Customer();
						customerDao.setConditionCustomerName("=", customer);
						BaseCustomer customerBean = customerDao.executeQueryOneRow();
						Integer customerId = null;
						if(null == customerBean) {
							customerDao.clear();
							customerDao.setCustomerName(customer);
							customerDao.save();
							customerId = customerDao.getCustomerId();
						}else {
							customerId = customerBean.getCustomerId();
						}
						bean.setCustomerId(customerId);
						break;
					case 7:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setInvoiceAmount(GenericBase.__getDecimal(cell.getStringCellValue()));
						break;
					case 8:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setTaxRate(GenericBase.__getDecimal(cell.getStringCellValue()));
						break;
					case 9:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setNoTaxAmount(GenericBase.__getDecimal(cell.getStringCellValue()));
						break;
					case 10:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setOutputTax(GenericBase.__getDecimal(cell.getStringCellValue()));
						break;
					case 11:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setInvoiceDate(GenericBase.__getDate(cell.getStringCellValue()));
						break;
					case 12:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setSign(returnSystemValue(53, cell.getStringCellValue(), sdList));
						break;
					case 13:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setPrimaryInvoiceCode(cell.getStringCellValue());
						break;
					case 14:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setPrimaryInvoiceNumber(cell.getStringCellValue());
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

		BaseMainProject bean;

		List<BaseMainProject> beans = new ArrayList<BaseMainProject>();

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
			bean = new BaseMainProject();
			for (int i = 0; i < countCol + 1; i++) {
				// 创建一个列单元对象
				Cell cell = row.getCell(i);
				if (!BaseHelpUtils.isNullOrEmpty(cell)) {
					switch (i) {
					case 0:
						// 项目编号project_code
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setProjectCode(cell.getStringCellValue());
						break;
					case 1:
						// 项目名称 project_name
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setProjectName(cell.getStringCellValue());
						break;
					case 2:
						// 信息编号 info_code
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setInfoCode(cell.getStringCellValue());
						break;
					case 3:
						// 业务类别 business_type
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setBusinessType(cell.getStringCellValue());
						break;
					case 4:
						// 立项依据 project_base_on
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setProjectBaseOn(returnSystemValue(28, cell.getStringCellValue(), sdList));
						;
						break;
					case 5:
						// 正式立项时间 project_approval_time
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setProjectApprovalTime(GenericBase.__getDate(cell.getStringCellValue()));
						break;
					case 6:
						// 投标类型 bid_class_type
						cell.setCellType(Cell.CELL_TYPE_STRING);
						bean.setBidClassType(returnSystemValue(129, cell.getStringCellValue(), sdList));
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

	public static void main(String[] args) {

		// try {
		// File file = new File("D:\\基础数据.xlsx");
		// onUpload(file);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
//		date.setTime(43019*24*60*60*1000);
//		System.out.println(sdf.format(date));
		Calendar  cld =   Calendar.getInstance() ;
		cld .set(1900,1,1);
		cld.add(Calendar.DAY_OF_YEAR , 43019);
		cld.getTime();
	
		 System.out.println(sdf.format(cld.getTime()));

	}
}
