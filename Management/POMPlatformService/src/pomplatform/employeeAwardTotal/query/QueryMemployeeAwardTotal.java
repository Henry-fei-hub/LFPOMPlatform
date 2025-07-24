package pomplatform.employeeAwardTotal.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employeeAwardTotal.bean.BaseMemployeeAwardTotal;
import pomplatform.employeeAwardTotal.bean.ConditionMemployeeAwardTotal;

public class QueryMemployeeAwardTotal extends AbstractQuery<BaseMemployeeAwardTotal, ConditionMemployeeAwardTotal> {

    private static final Logger __logger = Logger.getLogger(QueryMemployeeAwardTotal.class);

    public QueryMemployeeAwardTotal() throws java.sql.SQLException {
        setParameterNumber(6);
        setConnection(ThreadConnection.getConnection());
        setOrderByFields("abc.photo");
    }

    @Override
    public BaseCollection<BaseMemployeeAwardTotal> executeQuery(KeyValuePair[] replacements, ConditionMemployeeAwardTotal condition) throws java.sql.SQLException {
        return executeQuery(replacements,
                condition.getStartMonth(),
                condition.getEndMonth(),
                condition.getEmployeeId(),
                condition.getPlateId(),
                condition.getDepartmentId(),
                condition.getEmployeeName()
        );
    }

    @Override
    public BaseMemployeeAwardTotal generateBase(Object[] __data) throws java.sql.SQLException {
        BaseMemployeeAwardTotal __base = new BaseMemployeeAwardTotal();
        int count = 0;
        Object val;
        if ((val = __data[count++]) != null) {
            __base.setPhoto(GenericBase.__getString(val));
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
            __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date) args[0]));
        }
        if (args[1] != null) {
            __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date) args[1]));
        }
        if (args[2] != null) {
            __statement.setInt(count++, GenericBase.__getInt(args[2]));
        }
        if (args[3] != null) {
            __statement.setInt(count++, GenericBase.__getInt(args[3]));
        }
        if (args[4] != null) {
            __statement.setInt(count++, GenericBase.__getInt(args[4]));
        }
        if (args[5] != null) {
            __statement.setString(count++, GenericBase.__getString(args[5]));
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

    private final static String __SQLText = "select abc.photo,abc.employee_id,abc.employee_name,abc.department_id,abc.plan_integral,abc.sure_integral,abc.project_cost,abc.achieve_integral,0.0 as achieve_award,abc.base_salary from (select concat(s.image_path,case when c.photo is null then 'photo_view.png' else c.photo end) as photo,a.employee_id, c.employee_name,c.department_id,sum(case when b.plan_amount is null then 0 else b.plan_amount end) as plan_integral,sum(case when b.real_amount is null then 0 else b.real_amount end) as sure_integral,sum(case when b.project_cost is null then 0 else b.project_cost end) as project_cost,sum(case when b.final_amount is null then 0 else b.final_amount end) as achieve_integral,0.0 as base_salary from employee_change_plate_records a LEFT JOIN project_settlement_details b on a.employee_id = b.employee_id AND a.year = extract(year from b.settlement_date) and a.month = extract(month from b.settlement_date) LEFT JOIN employees c on a.employee_id = c.employee_id LEFT JOIN system_config s on s.system_config_id = 1 WHERE  a.change_plate_date >= ? and a.change_plate_date < ? and a.employee_id = ? and  a.plate_id = ? and c.department_id in(select child_id from department_ids where department_id = ?) and c.employee_name like ? GROUP BY a.employee_id,s.image_path,c.photo,c.employee_name,c.department_id ) as abc";
    private final static String RESULTSETFIELDLIST = "photo,employee_id,employee_name,department_id,plan_integral,sure_integral,project_cost,achieve_integral,achieve_award,base_salary";
    private final static String[] fieldNames = { "start_month", "end_month", "employee_id", "plate_id", "department_id", "employee_name"};
}
