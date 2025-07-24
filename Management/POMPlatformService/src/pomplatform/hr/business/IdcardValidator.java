package pomplatform.hr.business;

import delicacy.common.BaseHelpUtils;

public class IdcardValidator {

	// 每位加权因子
	private int power[] = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };

	/**
	 * 验证所有的身份证的合法性
	 * 
	 * @param idcard
	 * @return
	 */
	public boolean isValidatedAllIdcard(String idcard) {
		return this.isValidate18Idcard(idcard);
	}

	/**
	 * <p>
	 * 判断18位身份证的合法性
	 * </p>
	 * 根据〖中华人民共和国国家标准GB11643-1999〗中有关公民身份号码的规定，公民身份号码是特征组合码，由十七位数字本体码和一位数字校验码组成。
	 * 排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码。
	 * <p>
	 * 顺序码: 表示在同一地址码所标识的区域范围内，对同年、同月、同 日出生的人编定的顺序号，顺序码的奇数分配给男性，偶数分配 给女性。
	 * </p>
	 * <p>
	 * 1.前1、2位数字表示：所在省份的代码； 2.第3、4位数字表示：所在城市的代码； 3.第5、6位数字表示：所在区县的代码；
	 * 4.第7~14位数字表示：出生年、月、日； 5.第15、16位数字表示：所在地的派出所的代码；
	 * 6.第17位数字表示性别：奇数表示男性，偶数表示女性；
	 * 7.第18位数字是校检码：也有的说是个人信息码，一般是随计算机的随机产生，用来检验身份证的正确性。校检码可以是0~9的数字，有时也用x表示。
	 * </p>
	 * <p>
	 * 第十八位数字(校验码)的计算方法为： 1.将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4
	 * 2 1 6 3 7 9 10 5 8 4 2
	 * </p>
	 * <p>
	 * 2.将这17位数字和系数相乘的结果相加。
	 * </p>
	 * <p>
	 * 3.用加出来和除以11，看余数是多少？
	 * </p>
	 * 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3
	 * 2。
	 * <p>
	 * 5.通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。如果余数是10，身份证的最后一位号码就是2。
	 * </p>
	 * 
	 * @param idcard
	 * @return
	 */
	public boolean isValidate18Idcard(String idcard) {
		// 非18位为假
		String replace = idcard.replace("(", "").replace(")", "");
		int idacardLength = replace.length();
		if (!(idacardLength == 18 || idacardLength == 10 || idacardLength == 8)) {
			return false;
		}
		// 获取前17位 内地人士身份证
		if(replace.length() == 18){
			String idcard17 = idcard.substring(0, 17);
			// 获取第18位
			String idcard18Code = idcard.substring(17, 18);
			char c[] = null;
			String checkCode = "";
			// 是否都为数字
			if (isDigital(idcard17)) {
				c = idcard17.toCharArray();
			} else {
				return false;
			}

			if (null != c) {
				int bit[] = new int[idcard17.length()];

				bit = converCharToInt(c);

				int sum17 = 0;

				sum17 = getPowerSum(bit);

				// 将和值与11取模得到余数进行校验码判断
				checkCode = getCheckCodeBySum(sum17);
				if (null == checkCode) {
					return false;
				}
				// 将身份证的第18位与算出来的校码进行匹配，不相等就为假
				if (!idcard18Code.equalsIgnoreCase(checkCode)) {
					return false;
				}
			}
		}else if(replace.length() == 10){ //台湾人士身份证
			String idcard10 = idcard.substring(0, 1);
			String idcard10Code = idcard.substring(1, 10);
			char c[] = null;
			String checkCode = "";
			// 是否都为数字
			if (isDigital(idcard10Code)) {
				c = idcard10Code.toCharArray();
			} else {
				return false;
			}
			if (null != c) {
				int bit[] = new int[idcard10Code.length()];

				bit = converCharToInt(c);

				int sum17 = 0;

				sum17 = getPowerSum(bit);

//				 将和值与11取模得到余数进行校验码判断
				checkCode = getCheckCodeBySum(sum17);
				if (null == checkCode) {
					return false;
				}
				// 校验身份证第一位
				if (!isDigitalss(idcard10)) {
					return false;
				}
			}

		}else if(replace.length() == 8){ //香港、澳门人士身份证
			String idcard8 = idcard.substring(8, 9);
			String idcard1 = idcard.substring(0, 1);
			String idcard8Code = idcard.substring(2, 7);
			char c[] = null;
			String checkCode = "";
			// 是否都为数字
			if (isDigital(idcard8Code)) {
				c = idcard8Code.toCharArray();
			} else {
				return false;
			}
			if (null != c) {
				int bit[] = new int[idcard8Code.length()];

				bit = converCharToInt(c);

				int sum17 = 0;

				sum17 = getPowerSum(bit);

				// 将和值与11取模得到余数进行校验码判断
				checkCode = getCheckCodeBySum(sum17);
				if (null == checkCode) {
					return false;
				}

				// 将身份证的第1位
				if(!idcard1.equals("1") || !idcard1.equals("5") || !idcard1.equals("7")){
					if (!isDigitalsss(idcard1)) {
						return false;
					}
				}

				// 将身份证的第8位
				if (!isDigitals(idcard8)) {
					return false;
				}



			}

		}

		return true;
	}

	/**
	 * 将身份证的每位和对应位的加权因子相乘之后，再得到和值
	 * 
	 * @param bit
	 * @return
	 */
	public int getPowerSum(int[] bit) {
		int sum = 0;
		if (power.length != bit.length) {
			return sum;
		}

		for (int i = 0; i < bit.length; i++) {
			for (int j = 0; j < power.length; j++) {
				if (i == j) {
					sum = sum + bit[i] * power[j];
				}
			}
		}
		return sum;
	}

	/**
	 * 数字验证
	 * 
	 * @param str
	 * @return
	 */
	public boolean isDigital(String str) {
		return str == null || "".equals(str) ? false : str.matches("^[0-9]*$");
	}


	/**
	 * 数字验证
	 *
	 * @param str
	 * @return
	 */
	public boolean isDigitalsss(String str) {
		return str == null || "".equals(str) ? false : str.matches("^[A-Z]*$");
	}


	/**
	 * 数字字母验证
	 *
	 * @param str
	 * @return
	 */
	public boolean isDigitals(String str) {
		return str == null || "".equals(str) ? false : str.matches("^[0-9A-Z]*$");
	}

	/**
	 * 字母验证
	 *
	 * @param str
	 * @return
	 */
	public boolean isDigitalss(String str) {
		return str == null || "".equals(str) ? false : str.matches("^[a-zA-Z]*$");
	}

	/**
	 * 将字符数组转为整型数组
	 * 
	 * @param c
	 * @return
	 * @throws NumberFormatException
	 */
	public int[] converCharToInt(char[] c) throws NumberFormatException {
		int[] a = new int[c.length];
		int k = 0;
		for (char temp : c) {
			a[k++] = Integer.parseInt(String.valueOf(temp));
		}
		return a;
	}

	/**
	 * 将和值与11取模得到余数进行校验码判断
	 * 
	 * @param checkCode
	 * @param sum17
	 * @return 校验位
	 */
	public String getCheckCodeBySum(int sum17) {
		String checkCode = null;
		switch (sum17 % 11) {
		case 10:
			checkCode = "2";
			break;
		case 9:
			checkCode = "3";
			break;
		case 8:
			checkCode = "4";
			break;
		case 7:
			checkCode = "5";
			break;
		case 6:
			checkCode = "6";
			break;
		case 5:
			checkCode = "7";
			break;
		case 4:
			checkCode = "8";
			break;
		case 3:
			checkCode = "9";
			break;
		case 2:
			checkCode = "x";
			break;
		case 1:
			checkCode = "0";
			break;
		case 0:
			checkCode = "1";
			break;
		}
		return checkCode;
	}

	public static void main(String[] args) throws Exception {
		String idcard18 = "A123456(0)";// 18位
		IdcardValidator iv = new IdcardValidator();
		System.out.println(iv.isValidatedAllIdcard(idcard18));

	}
}
