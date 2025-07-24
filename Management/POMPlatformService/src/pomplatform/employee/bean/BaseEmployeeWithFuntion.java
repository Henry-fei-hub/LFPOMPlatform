package pomplatform.employee.bean;

import java.util.List;
import java.util.Map;

import delicacy.system.bean.BaseEmployee;

/**
 *
 * @author Peter
 */
public class BaseEmployeeWithFuntion extends BaseEmployee {
    
    @Override
    public void setDataFromMap(Map m){
        Object val;
        super.setDataFromMap(m);
        if((val = m.get("functions")) != null) setFunctions(__getList(val, BaseMemployeeereor.newInstance()));
    }
    
    @Override
    public String toJSONString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toJSONString());
        if(getFunctions() != null){
            sb.append(__wrapList(1, "functions", getFunctions()));
        }
        return sb.toString();
    }
    
    private List<BaseMemployeeereor> __functions = null;

    /**
     * @return the __functions
     */
    public List<BaseMemployeeereor> getFunctions() {
        return __functions;
    }

    /**
     * @param __functions the __functions to set
     */
    public void setFunctions(List<BaseMemployeeereor> __functions) {
        this.__functions = __functions;
    }
}
