package pomplatform.employeenew.business;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import delicacy.common.GenericProcessor;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;

/**
 * 职员离职设置
 *
 * @author lxf
 */
public class EmployeeSetLeave implements GenericProcessor {

    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        BaseEmployee bean = new BaseEmployee();
        bean.setDataFromJSON(creteria);
        Employee dao = new Employee();
        dao.setDataFromBase(bean);
        dao.update();
        return bean.toOneLineJSON(0, null);
    }

}
