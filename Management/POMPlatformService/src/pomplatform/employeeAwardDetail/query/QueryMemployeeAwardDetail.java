package pomplatform.employeeAwardDetail.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employeeAwardDetail.bean.BaseMemployeeAwardDetail;
import pomplatform.employeeAwardDetail.bean.ConditionMemployeeAwardDetail;

public class QueryMemployeeAwardDetail extends AbstractQuery<BaseMemployeeAwardDetail, ConditionMemployeeAwardDetail> {

    private static final Logger __logger = Logger.getLogger(QueryMemployeeAwardDetail.class);

    public QueryMemployeeAwardDetail() throws java.sql.SQLException {
        setParameterNumber(7);
        setConnection(ThreadConnection.getConnection());
        setOrderByFields("abc.photo");
    }

    @Override
    public BaseCollection<BaseMemployeeAwardDetail> executeQuery(KeyValuePair[] replacements, ConditionMemployeeAwardDetail condition) throws java.sql.SQLException {
        return executeQuery(replacements,
                condition.getYears(),
                condition.getMonths(),
                condition.getProjectId(),
                condition.getEmployeeId(),
                condition.getPlateId(),
                condition.getPlateId(),
                condition.getEmployeeName()
        );
    }

    @Override
    public BaseMemployeeAwardDetail generateBase(Object[] __data) throws java.sql.SQLException {
        BaseMemployeeAwardDetail __base = new BaseMemployeeAwardDetail();
        int count = 0;
        Object val;
        if ((val = __data[count++]) != null) {
            __base.setPhoto(GenericBase.__getString(val));
        }
        if ((val = __data[count++]) != null) {
            __base.setProjectId(GenericBase.__getInt(val));
        }
        if ((val = __data[count++]) != null) {
            __base.setEmployeeId(GenericBase.__getInt(val));
        }
        if ((val = __data[count++]) != null) {
            __base.setEmployeeName(GenericBase.__getString(val));
        }
        if ((val = __data[count++]) != null) {
            __base.setDepartmentId(GenericBase.__getInt(val));
        }
        if ((val = __data[count++]) != null) {
            __base.setPlateId(GenericBase.__getInt(val));
        }
        if ((val = __data[count++]) != null) {
            __base.setYears(GenericBase.__getInt(val));
        }
        if ((val = __data[count++]) != null) {
            __base.setMonths(GenericBase.__getInt(val));
        }
        if ((val = __data[count++]) != null) {
            __base.setPlanIntegral(GenericBase.__getDecimal(val));
        }
        if ((val = __data[count++]) != null) {
            __base.setSureIntegral(GenericBase.__getDecimal(val));
        }
        if ((val = __data[count++]) != null) {
            __base.setProjectCost(GenericBase.__getDecimal(val));
        }
        if ((val = __data[count++]) != null) {
            __base.setAchieveIntegral(GenericBase.__getDecimal(val));
        }
        if ((val = __data[count++]) != null) {
            __base.setAchieveAward(GenericBase.__getDecimal(val));
        }
        if ((val = __data[count++]) != null) {
            __base.setBaseSalary(GenericBase.__getDecimal(val));
        }
        return __base;
    }

    @Override
    public int setStatementParameters(int count, java.lang.Object... args) throws java.sql.SQLException {

        int index = 0;
        for (int ii = 0; ii < args.length; ii++) {
            if (args[ii] == null) {
                continue;
            }
            index++;
            __logger.info(String.format("%1$s = [%2$s]", fieldNames[ii], args[ii]));
        }
        if (index > 0) {
            __logger.info("=================================================");
        }
        if (args[0] != null) {
            __statement.setInt(count++, (java.lang.Integer) args[0]);
        }
        if (args[1] != null) {
            __statement.setInt(count++, (java.lang.Integer) args[1]);
        }
        if (args[2] != null) {
            __statement.setInt(count++, (java.lang.Integer) args[2]);
        }
        if (args[3] != null) {
            __statement.setShort(count++, (java.lang.Short) args[3]);
        }
        if (args[4] != null) {
            __statement.setInt(count++, (java.lang.Integer) args[4]);
        }
        if (args[5] != null) {
            __statement.setInt(count++, (java.lang.Integer) args[5]);
        }
        if (args[6] != null) {
            __statement.setString(count++, (java.lang.String) args[6]);
        }
        return count;
    }

    @Override
    public String getSQLText() {
        __logger.info(__SQLText);
        return __SQLText;
    }

    @Override
    public String getFieldList() {
        return RESULTSETFIELDLIST;
    }

    private final static String __SQLText = "select abc.photo,abc.project_id,abc.employee_id,abc.employee_name,abc.department_id,abc.plate_id,abc.years,abc.months,abc.plan_integral,abc.sure_integral,abc.project_cost,abc.achieve_integral,abc.achieve_award,abc.base_salary from (select a.project_id, extract(year from a.settlement_date) as years ,extract(month from a.settlement_date) as months,a.employee_id,c.employee_name,c.department_id,c.plate_id ,concat(s.image_path,case when c.photo is null then 'photo_view.png' else c.photo end) as photo ,(select sum(plan_integral) from project_employees where employee_id = a.employee_id and project_id = a.project_id group by employee_id) as plan_integral ,sum(a.real_amount) as sure_integral,sum(a.project_cost) as project_cost,sum(a.final_amount) as achieve_integral,0.0 as achieve_award,0.0 as base_salary from project_settlement_details a left join employees c on a.employee_id = c.employee_id left join system_config s on s.system_config_id = 1 group by years,months,a.employee_id,a.project_id,c.employee_name,c.department_id,c.plate_id,c.photo,s.image_path) as abc where abc.years = ? and abc.months = ? and abc.project_id = ? and abc.employee_id = ? and abc.plate_id = ? and abc.department_id = ? and abc.employee_name like ? order by abc.project_id desc";
    private final static String RESULTSETFIELDLIST = "photo,project_id,employee_id,employee_name,department_id,plate_id,years,months,plan_integral,sure_integral,project_cost,achieve_integral,achieve_award,base_salary";
    private final static String[] fieldNames = {"years", "months", "project_id", "employee_id", "plate_id", "plate_id", "employee_name"};
}
