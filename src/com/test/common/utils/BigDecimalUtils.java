package com.test.common.utils;

import java.math.BigDecimal;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company: 宝能汽车销售有限公司
 * @Author: gjf
 * @CreateDate: 2021/5/8 16:29
 * @UpdateDate: 2021/5/8 16:29
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public abstract class BigDecimalUtils {

    /**
     *
     * @param bigDecimal
     * @return
     */
    public static BigDecimal getBigDecimal(BigDecimal bigDecimal) {
        if(null == bigDecimal) {
            bigDecimal = BigDecimal.ZERO;
        }
        return bigDecimal;
    }
}
