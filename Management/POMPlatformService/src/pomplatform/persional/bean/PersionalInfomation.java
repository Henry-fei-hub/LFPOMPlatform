package pomplatform.persional.bean;

import java.util.Map;

/**
 *
 * @author guanxgun
 */
public class PersionalInfomation extends BaseSemployeeeor {

    @Override
    public java.lang.String toJSONString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toJSONString());
        if (getCurrentProjectNum() > 0) {
            sb.append(__wrapNumber(1, "currentProjectNum", getCurrentProjectNum()));
        }
        if (getCompletedProjectNum() > 0) {
            sb.append(__wrapNumber(1, "completedProjectNum", getCompletedProjectNum()));
        }
        if (getArchivedMoney() > 0) {
            sb.append(__wrapNumber(1, "archivedMoney", getArchivedMoney()));
        }
        if (getPromisedMoney() > 0) {
            sb.append(__wrapNumber(1, "promisedMoney", getPromisedMoney()));
        }
        return sb.toString();
    }

    @Override
    public void setDataFromMap(Map<String, Object> values) {
        super.setDataFromMap(values);
        Object val;
        if ((val = values.get("currentProjectNum")) != null) {
            setCurrentProjectNum(__getInt(val));
        }
        if ((val = values.get("completedProjectNum")) != null) {
            setCompletedProjectNum(__getInt(val));
        }
        if ((val = values.get("archivedMoney")) != null) {
            setArchivedMoney(__getInt(val));
        }
        if ((val = values.get("promisedMoney")) != null) {
            setPromisedMoney(__getInt(val));
        }
    }

    private int currentProjectNum = 0;
    private int completedProjectNum = 0;
    private int archivedMoney = 0;
    private int promisedMoney = 0;

    /**
     * @return the currentProjectNum
     */
    public int getCurrentProjectNum() {
        return currentProjectNum;
    }

    /**
     * @param currentProjectNum the currentProjectNum to set
     */
    public void setCurrentProjectNum(int currentProjectNum) {
        this.currentProjectNum = currentProjectNum;
    }

    /**
     * @return the completedProjectNum
     */
    public int getCompletedProjectNum() {
        return completedProjectNum;
    }

    /**
     * @param completedProjectNum the completedProjectNum to set
     */
    public void setCompletedProjectNum(int completedProjectNum) {
        this.completedProjectNum = completedProjectNum;
    }

    /**
     * @return the archivedMoney
     */
    public int getArchivedMoney() {
        return archivedMoney;
    }

    /**
     * @param archivedMoney the archivedMoney to set
     */
    public void setArchivedMoney(int archivedMoney) {
        this.archivedMoney = archivedMoney;
    }

    /**
     * @return the promisedMoney
     */
    public int getPromisedMoney() {
        return promisedMoney;
    }

    /**
     * @param promisedMoney the promisedMoney to set
     */
    public void setPromisedMoney(int promisedMoney) {
        this.promisedMoney = promisedMoney;
    }
}
