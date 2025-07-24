package pomplatform.employeenew.business;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import delicacy.common.DES;
import delicacy.common.GenericProcessor;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;

/**
 *
 * @author Peter
 */
public class ModifyUserPwdBiz implements GenericProcessor {
    
    private static Logger __logger = Logger.getLogger(ModifyUserPwdBiz.class);

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        BaseEmployee be = new BaseEmployee();
        be.setDataFromJSON(creteria);
        __logger.debug(be.toString());
        Employee dao = new Employee();
        dao.setConditionEmployeeNo("=", be.getEmployeeNo());
        BaseEmployee bed = dao.executeQueryOneRow();
        // 如果查不到
        if(bed == null){
            throw new SQLException("无此用户！");
        }
        if(!bed.getEmployeePassword().equals(DES.string2MD5(be.getEmail()))){
            throw new SQLException("原密码错误！");
        }
//        dao.setDataFromBase(bed);
//        dao.clearModifiedFlags();
        dao.setEmployeePassword(DES.string2MD5(be.getEmployeePassword()));
        dao.update();
        return dao.generateBase().toOneLineJSON(0, null);
    }
    
}
