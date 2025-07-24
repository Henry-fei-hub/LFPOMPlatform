package pomplatform.employee.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.common.DES;
import delicacy.connection.ThreadConnection;
import pomplatform.employee.bean.BaseEmployeeWithE;
import pomplatform.employee.dao.EmployeeWithE;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.date.util.TimeSpanCalculator;

public class EmployeeWithEHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(EmployeeWithEHandler.class);

	public static BaseEmployeeWithE getEmployeeWithEById( java.lang.Integer employee_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseEmployeeWithE result;
			EmployeeWithE dao = new EmployeeWithE();
			dao.setEmployeeId(employee_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get EmployeeWithE By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isEmployeeWithEExists( pomplatform.employee.bean.BaseEmployeeWithE bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			EmployeeWithE dao = new EmployeeWithE();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query EmployeeWithE List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countEmployeeWithE( pomplatform.employee.bean.BaseEmployeeWithE bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			EmployeeWithE dao = new EmployeeWithE();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query EmployeeWithE List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseEmployeeWithE> queryEmployeeWithE( BaseEmployeeWithE bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			EmployeeWithE dao = new EmployeeWithE();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseEmployeeWithE> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseEmployeeWithE> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query EmployeeWithE List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseEmployeeWithE addToEmployeeWithE ( BaseEmployeeWithE employeewithe ) {
		return addToEmployeeWithE ( employeewithe , false);
	}

	public static BaseEmployeeWithE addToEmployeeWithE ( BaseEmployeeWithE employeewithe, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			EmployeeWithE dao = new EmployeeWithE();
			dao.setDataFromBase(employeewithe);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to EmployeeWithE time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseEmployeeWithE addUpdateEmployeeWithE ( BaseEmployeeWithE employeewithe ) {
		return addUpdateEmployeeWithE ( employeewithe , false);
	}

	public static BaseEmployeeWithE addUpdateEmployeeWithE ( BaseEmployeeWithE employeewithe, boolean singleTransaction  ) {
		if(employeewithe.getEmployeeId() == null) return addToEmployeeWithE(employeewithe);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			EmployeeWithE dao = new EmployeeWithE();
			dao.setDataFromBase(employeewithe);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(employeewithe); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to EmployeeWithE time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseEmployeeWithE deleteEmployeeWithE ( BaseEmployeeWithE bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			EmployeeWithE dao = new EmployeeWithE();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete EmployeeWithE time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseEmployeeWithE updateEmployeeWithE ( BaseEmployeeWithE employeewithe ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			EmployeeWithE dao = new EmployeeWithE();
			dao.setEmployeeId( employeewithe.getEmployeeId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(employeewithe);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update EmployeeWithE time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? employeewithe : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseEmployeeWithE updateEmployeeWithEDirect( BaseEmployeeWithE employeewithe ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			EmployeeWithE dao = new EmployeeWithE();
			int result = 0;
			dao.setDataFromBase(employeewithe);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update EmployeeWithE time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? employeewithe : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseEmployeeWithE bean, EmployeeWithE dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeNo() != null) {
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
				count++;
			}
			if(bean.getEmployeeName() != null) {
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getEmployeePassword() != null) {
				dao.setConditionEmployeePassword("=", bean.getEmployeePassword());
				count++;
			}
			if(bean.getMobile() != null) {
				dao.setConditionMobile("=", bean.getMobile());
				count++;
			}
			if(bean.getEmail() != null) {
				dao.setConditionEmail("=", bean.getEmail());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getUsableStatus() != null) {
				dao.setConditionUsableStatus("=", bean.getUsableStatus());
				count++;
			}
			if(bean.getIsDepartment() != null) {
				dao.setConditionIsDepartment("=", bean.getIsDepartment());
				count++;
			}
			if(bean.getLocked() != null) {
				dao.setConditionLocked("=", bean.getLocked());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeWithE bean, EmployeeWithE dao){
		int count = 0;
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getEmployeeNo() != null) {
			if(bean.getEmployeeNo().indexOf("%") >= 0)
				dao.setConditionEmployeeNo("like", bean.getEmployeeNo());
			else
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
			count++;
		}
		if(bean.getEmployeeName() != null) {
			if(bean.getEmployeeName().indexOf("%") >= 0)
				dao.setConditionEmployeeName("like", bean.getEmployeeName());
			else
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getEmployeePassword() != null) {
			if(bean.getEmployeePassword().indexOf("%") >= 0)
				dao.setConditionEmployeePassword("like", bean.getEmployeePassword());
			else
				dao.setConditionEmployeePassword("=", bean.getEmployeePassword());
			count++;
		}
		if(bean.getMobile() != null) {
			if(bean.getMobile().indexOf("%") >= 0)
				dao.setConditionMobile("like", bean.getMobile());
			else
				dao.setConditionMobile("=", bean.getMobile());
			count++;
		}
		if(bean.getEmail() != null) {
			if(bean.getEmail().indexOf("%") >= 0)
				dao.setConditionEmail("like", bean.getEmail());
			else
				dao.setConditionEmail("=", bean.getEmail());
			count++;
		}
		if(bean.getOnboardDate() != null) {
			dao.setConditionOnboardDate(">=", bean.getOnboardDate());
			count++;
		}
		if(bean.getResignationDate() != null) {
			dao.setConditionResignationDate(">=", bean.getResignationDate());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getUsableStatus() != null) {
			dao.setConditionUsableStatus("=", bean.getUsableStatus());
			count++;
		}
		if(bean.getIsDepartment() != null) {
			dao.setConditionIsDepartment("=", bean.getIsDepartment());
			count++;
		}
		if(bean.getLocked() != null) {
			dao.setConditionLocked("=", bean.getLocked());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeWithE bean = new BaseEmployeeWithE();
		bean.setDataFromJSON(json);
		EmployeeWithE dao = new EmployeeWithE();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeWithE> rlist = new BaseCollection<>();
		BaseEmployeeWithE bean = new BaseEmployeeWithE();
		bean.setDataFromJSON(json);
		EmployeeWithE dao = new EmployeeWithE();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeWithE> result = dao.conditionalLoadExt(addtion);
		rlist.setCollections(result);
		rlist.setTotalPages(dao.getTotalPages());
		rlist.setCurrentPage(dao.getCurrentPage());
		rlist.setPageLines(dao.getPageLines());
		rlist.setTotalLines(dao.getTotalLines());
		rlist.setRecordNumber(result.size());
		return rlist.toJSON(null);
	}

	@Override
	public String save(String json) throws Exception{
		BaseEmployeeWithE bean = new BaseEmployeeWithE();
		bean.setDataFromJSON(json);
		EmployeeWithE dao = new EmployeeWithE();
                //设置员工的初始化密码，初始密码为其账号
                String pwd = DES.string2MD5(bean.getEmployeeNo());
                bean.setEmployeePassword(pwd);
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeWithE bean = new BaseEmployeeWithE();
		bean.setDataFromJSON(json);
		int num = 0;
		EmployeeWithE dao = new EmployeeWithE();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeWithE bean = new BaseEmployeeWithE();
		bean.setDataFromJSON(json);
		EmployeeWithE dao = new EmployeeWithE();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeWithE bean = new BaseEmployeeWithE();
		bean.setDataFromJSON(json);
		EmployeeWithE dao = new EmployeeWithE();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

}


