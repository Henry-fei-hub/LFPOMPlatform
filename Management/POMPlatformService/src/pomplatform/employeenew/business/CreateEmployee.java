package pomplatform.employeenew.business;

import javax.servlet.http.HttpServletRequest;

import delicacy.common.DES;
import delicacy.common.GenericProcessor;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;

/**
 *
 * @author guanxgun
 */
public class CreateEmployee implements GenericProcessor {

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        BaseEmployee be = new BaseEmployee();
        be.setDataFromJSON(creteria);
        be.setEmployeePassword(DES.string2MD5(be.getEmployeeNo()));
        Employee e = new Employee();
        e.setDataFromBase(be);
        e.save();
        be = e.generateBase();
        return be.toOneLineJSON(0, null);
    }
    
}
