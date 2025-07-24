package pomplatform.sinvoiceitior.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class CustomBaseIddStrVal extends GenericBase implements BaseFactory<CustomBaseIddStrVal>, Comparable<CustomBaseIddStrVal> {

    public static CustomBaseIddStrVal newInstance() {
        return new CustomBaseIddStrVal();
    }

    @Override
    public CustomBaseIddStrVal make() {
        CustomBaseIddStrVal b = new CustomBaseIddStrVal();
        return b;
    }

    public final static java.lang.String CS_IDD = "idd";
    public final static java.lang.String CS_VAL = "val";

    public final static java.lang.String ALL_CAPTIONS = ",";

    public java.lang.String getIdd() {
        return this.__idd;
    }

    public void setIdd(java.lang.String value) {
        this.__idd = value;
    }

    public java.lang.String getVal() {
        return this.__val;
    }

    public void setVal(java.lang.String value) {
        this.__val = value;
    }

    public void cloneCopy(CustomBaseIddStrVal __bean) {
        __bean.setIdd(getIdd());
        __bean.setVal(getVal());
    }

    public java.lang.String toCSVString() {

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
        StringBuilder sb = new StringBuilder();
        sb.append(getIdd() == null ? "" : getIdd());
        sb.append(",");
        sb.append(getVal() == null ? "" : getVal());
        return sb.toString();
    }

    @Override
    public int compareTo(CustomBaseIddStrVal o) {
        return __idd == null ? -1 : __idd.compareTo(o.getIdd());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.__idd);
        hash = 97 * hash + Objects.hashCode(this.__val);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CustomBaseIddStrVal o = (CustomBaseIddStrVal) obj;
        if (!Objects.equals(this.__idd, o.getIdd())) {
            return false;
        }
        if (!Objects.equals(this.__val, o.getVal())) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toJSONString() {

        StringBuilder sb = new StringBuilder();
        int count = 0;
        if (getIdd() != null) {
            sb.append(__wrapString(count++, "idd", getIdd()));
        }
        if (getVal() != null) {
            sb.append(__wrapString(count++, "val", getVal()));
        }
        return sb.toString();
    }

    @Override
    public void setDataFromMap(Map<String, Object> values) {
        Object val;
        if ((val = values.get("idd")) != null) {
            setIdd(__getString(val));
        }
        if ((val = values.get("val")) != null) {
            setVal(__getString(val));
        }
    }

    protected java.lang.String __idd;
    protected java.lang.String __val;
}
