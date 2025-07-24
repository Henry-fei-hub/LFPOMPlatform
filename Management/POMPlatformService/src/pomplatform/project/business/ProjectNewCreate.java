package pomplatform.project.business;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectEmployee;
import com.pomplatform.db.dao.ProjectLog;

import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.servlet.HttpCookie;
import pomplatform.projectprice.ProjectPriceCalculation;

/**
 *
 * @author guanxgun
 */
public class ProjectNewCreate implements GenericProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		ThreadConnection.beginTransaction();
		BaseProject bp = new BaseProject();
		bp.setDataFromJSON(creteria);

		HttpCookie hc = new HttpCookie(request);
		bp.setRevenuePlateId(bp.getPlateId());//用于营收统计的业务部门ID
//		bp.setPlateId(hc.getPlateId());
		bp.setDepartmentManagerId(hc.getOperatorId());
		bp.setDepartmentId(hc.getDepartmentId());
		ProjectPriceCalculation.calculateProjectPrice(bp);
		Project dao = new Project();
		dao.setDataFromBase(bp);
		dao.save();
		bp = dao.generateBase();
		ProjectEmployee pe = new ProjectEmployee();
		pe.setProjectId(bp.getProjectId());
		pe.setEmployeeId(bp.getProjectManageId());
		pe.setPlanStartDate(bp.getPlanStartDate());
		pe.setPlanEndDate(bp.getPlanEndDate());
		pe.setStatus(1);
		pe.save();
		ProjectLog pl = new ProjectLog();
		pl.setProjectId(bp.getProjectId());
		pl.setOperateId(hc.getOperatorId());
		pl.setOperateTime(new Date());
		pl.setDepartmentId(hc.getDepartmentId());
		pl.setManagerId(hc.getOperatorId());
		pl.setLogType(0);
		pl.setLogContent(String.format("%1$s创建了%2$s项目", hc.getOperatorName(), dao.getProjectName()));
		pl.save();
		ThreadConnection.commit();
		return bp.toOneLineJSON(0, null);
	}

}
