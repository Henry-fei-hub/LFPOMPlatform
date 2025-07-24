package pomplatform.attachment.handler;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseAttachmentManage;
import com.pomplatform.db.dao.AttachmentManage;
import com.pomplatform.db.dao.AttachmentManageEmployee;
import com.pomplatform.db.dao.EmployeeRole;

import pomplatform.attachment.bean.BaseSattachmentmanageaaaor;
import pomplatform.attachment.bean.ConditionSattachmentmanageaaaor;
import pomplatform.attachment.query.QuerySattachmentmanageaaaor;
import pomplatform.common.utils.StaticUtils;
import delicacy.common.KeyValuePair;
import delicacy.system.dao.Employee;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class SattachmentmanageaaaorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SattachmentmanageaaaorHandler.class);

	public static BaseCollection<BaseSattachmentmanageaaaor> executeQuerySattachmentmanageaaaor(ConditionSattachmentmanageaaaor c, KeyValuePair[] replacements ) throws Exception {
		QuerySattachmentmanageaaaor dao = new QuerySattachmentmanageaaaor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSattachmentmanageaaaor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSattachmentmanageaaaor c = new ConditionSattachmentmanageaaaor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSattachmentmanageaaaor> result = executeQuerySattachmentmanageaaaor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSattachmentmanageaaaor> result;
		ConditionSattachmentmanageaaaor c = new ConditionSattachmentmanageaaaor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySattachmentmanageaaaor dao = new QuerySattachmentmanageaaaor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSattachmentmanageaaaor.ALL_CAPTIONS);
			for(BaseSattachmentmanageaaaor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}
	
	public static void main(String[] args) throws SQLException {
		AttachmentManage amDao = new AttachmentManage();
		AttachmentManageEmployee ameDao = new AttachmentManageEmployee();
		EmployeeRole erDao = new EmployeeRole();
		Employee eDao = new Employee();
		List<BaseAttachmentManage> amList = amDao.conditionalLoad(BaseAttachmentManage.CS_DEPARTMENT_ID + " isnull ");
		for (BaseAttachmentManage baseAttachmentManage : amList) {
			amDao.clear();
			amDao.setPrimaryKeyFromBase(baseAttachmentManage);
			eDao.clear();
			if(null == baseAttachmentManage.getProjectManageId()){
				eDao.setEmployeeId(baseAttachmentManage.getOperateEmployeeId());
			}else{
				eDao.setEmployeeId(baseAttachmentManage.getProjectManageId());
			}
			if(eDao.load() && amDao.load()){
				if(null == baseAttachmentManage.getProjectManageId()){
					amDao.setProjectManageId(amDao.getOperateEmployeeId());
					baseAttachmentManage.setProjectManageId(amDao.getOperateEmployeeId());
				}
				amDao.setDepartmentId(eDao.getDepartmentId());//修改部门
				//找出部门的分管领导
				erDao.setConditionRoleId("=", StaticUtils.ROLE_DEPARTMENT_CHARGE_LEADER);
				erDao.setConditionDepartmentId("=", eDao.getDepartmentId());
				if(null != erDao.executeQueryOneRow()){
					amDao.setSuperProjectManageId(erDao.getEmployeeId());
					ameDao.setConditionEmployeeId("=", erDao.getEmployeeId());
					ameDao.setConditionEmployeeType("=", 1);
					ameDao.setConditionAttachmentManageId("=", baseAttachmentManage.getAttachmentManageId());
					if(ameDao.countRows() <= 0){//不存在则插入
						ameDao.clear();
						ameDao.setAttachmentManageId(baseAttachmentManage.getAttachmentManageId());
						ameDao.setEmployeeId(erDao.getEmployeeId());
						ameDao.setOperator(0);
						ameDao.setEmployeeType(1);
						ameDao.save();
					}
				}
				amDao.update();
			}
		}
	}
	
}


