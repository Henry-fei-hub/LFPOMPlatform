package com.pomplatform.client.common;

import com.google.gwt.i18n.client.NumberFormat;

public class CommonFormat {

    /**
     * 将double类型的数值格式化为类似货币的展示类型
     *
     * @param num
     * @return
     */
    public static String doubleFormat(double num) {
        NumberFormat fmt = NumberFormat.getFormat("##,###,###,###,##0.00");
        return fmt.format(Math.floor(num * 100) / 100);
    }

}
