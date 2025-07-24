package pomplatform.employee.business;

import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.dao.SystemLog;

import delicacy.common.BaseCollection;
import delicacy.common.DES;
import delicacy.common.GenericProcessor;
import delicacy.servlet.DelicacyServlet;
import delicacy.servlet.HttpCookie;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import pomplatform.employee.bean.BaseEmployeeWithFuntion;
import pomplatform.employee.bean.BaseMemployeeereor;
import pomplatform.employee.bean.ConditionMemployeeereor;
import pomplatform.employee.query.QueryMemployeeereor;

/**
 *
 * @author Peter
 */
public class LoginProcessor implements GenericProcessor {

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        HttpCookie hc = new HttpCookie(request);
        // 解密从前台传来的数据
        DES des = new DES(DelicacyServlet.PUBLIC_KEY);
        creteria = des.DEC(creteria);
        // 把数据放到BaseEmployee对象中
        BaseEmployee be = new BaseEmployee();
        be.setDataFromJSON(creteria);
        // 根据登录名employee_no查询员工信息
        Employee dao = new Employee();
        dao.setConditionEmployeeNo("=", be.getEmployeeNo());
        BaseEmployee bed = dao.executeQueryOneRow();
        // 如果查不到
        if (bed == null) {
            throw new SQLException("无此用户！");
        }
        // 验证密码 
        if (!bed.getEmployeePassword().equals(DES.string2MD5(be.getEmployeePassword()))) {
            throw new SQLException("密码错误！");
        }
        // 查询员工所能操作的功能列表
        ConditionMemployeeereor c = new ConditionMemployeeereor();
        c.setEmployeeId(bed.getEmployeeId());
        QueryMemployeeereor qdao = new QueryMemployeeereor();
        BaseCollection<BaseMemployeeereor> fs = qdao.executeQuery(null, c);
        // 构造返回数据结构
        BaseEmployeeWithFuntion bewf = new BaseEmployeeWithFuntion();
        bed.cloneCopy(bewf);
        bewf.setFunctions(fs.getCollections());
        SystemLog sl = new SystemLog();
        sl.setLogTime(new Date());
        sl.setOperator(bed.getEmployeeId());
        sl.setOperatorName(bed.getEmployeeName());
        sl.setFromHost(request.getRemoteAddr());
        sl.setLogContent(String.format("%1$s 登入系统", bed.getEmployeeName()));
        sl.save();
        return bewf.toOneLineJSON(0, null);
    }

}
