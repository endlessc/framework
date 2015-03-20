package com.mftour.utils;

import java.math.BigDecimal;

public class MathUtils {

	/**
	 * 保留两位小数，四舍五入
	 * @param d
	 * @return
	 */
	public static Double roundDouble(Double d)
	{
		return (new BigDecimal(d)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	

}
