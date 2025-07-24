package pomplatform.test;

import java.io.FileReader;
import java.io.LineNumberReader;

import com.pomplatform.db.dao.CmbcCode;

import delicacy.servlet.Processors;
import delicacy.system.executor.NewCreateWorkFlow;

/**
 *
 * @author guanxgun
 */
public class TestMain {

	public static void main(String[] args) {
		try {
			// String s =
			// "{\"processDefinition\":{\"processId\":20},\"userData\":{\"applyEmployeeId\":\"459\",\"employeeId\":\"459\",\"reimbursementTime\":1484302546532,\"applyTime\":1484302546533,\"currency\":0,\"departmentId\":\"71\",\"reimbursementName\":\"111\",\"companyId\":0,\"remark\":\"1111\",\"amount\":2222,\"detailProjectNormalReimbursementDetail\":[{\"mainItemId\":1,\"amount\":2222}],\"detailNormalReimbursementLinkDepartment\":[{\"departmentId\":\"71\",\"amount\":2222}]}}";
			// Processors p = new Processors();
			// p.initTables();
			// NewCreateWorkFlow n = new NewCreateWorkFlow();
			// n.execute(s, 459);
			CmbcCode dao = new CmbcCode();
			LineNumberReader lnr = new LineNumberReader(new FileReader("D:\\cmbc.txt"));
			int lineNumber = 1;
			String content = null;
			while ((content = lnr.readLine()) != null) {
				if (lineNumber >= 3 && lineNumber <= 51) {
					saveDAO(dao, "cmbc_branch", content, "\t", false);
				}
				if (lineNumber >= 69 && lineNumber <= 81) {
					saveDAO(dao, "cmbc_curreny", content, "\t", false);
				}
				if (lineNumber >= 85 && lineNumber <= 109) {
					saveDAO(dao, "business_code", content, "\t", true);
				}
				if (lineNumber >= 114 && lineNumber <= 121) {
					saveDAO(dao, "request_status", content, "\t", true);
				}
				if (lineNumber >= 125 && lineNumber <= 132) {
					saveDAO(dao, "process_result", content, "\t", true);
				}
				if (lineNumber >= 137 && lineNumber <= 148) {
					saveDAO(dao, "voucher_type", content, "\t", true);
				}
				if (lineNumber >= 152 && lineNumber <= 199) {
					saveDAO(dao, "trans_analysis_code", content, "\t", true);
				}
				if (lineNumber >= 206 && lineNumber <= 219) {
					saveDAO(dao, "trans_code", content, "\t", true);
				}
				if (lineNumber >= 224 && lineNumber <= 226) {
					saveDAO(dao, "value_rate_type", content, "\t", true);
				}
				if (lineNumber >= 230 && lineNumber <= 233) {
					saveDAO(dao, "value_type", content, "\t", true);
				}
				if (lineNumber >= 237 && lineNumber <= 254) {
					saveDAO(dao, "loan_usage", content, "\t", true);
				}
				if (lineNumber >= 258 && lineNumber <= 300) {
					saveDAO(dao, "credit_business_type", content, "\t", true);
				}
				if (lineNumber >= 304 && lineNumber <= 310) {
					saveDAO(dao, "credit_value_status", content, "\t", true);
				}
				if (lineNumber >= 314 && lineNumber <= 588) {
					saveDAO(dao, "trans_code", content, "=", true);
				}
				if (lineNumber >= 592 && lineNumber <= 596) {
					saveDAO(dao, "消息类型", content, "\t", true);
				}
				if (lineNumber >= 604 && lineNumber <= 1025) {
					saveDAO(dao, "城市代码", content, "\t", true);
				}
				if (lineNumber >= 1029 && lineNumber <= 1030) {
					saveDAO(dao, "记账方向代码", content, "\t", true);
				}
				if (lineNumber >= 1034 && lineNumber <= 1037) {
					saveDAO(dao, "交易类型", content, "\t", true);
				}
				if (lineNumber >= 1040 && lineNumber <= 1042) {
					saveDAO(dao, "协议状态", content, "=", true);
				}
				if (lineNumber >= 1044 && lineNumber <= 1045) {
					saveDAO(dao, "冻结状态", content, "=", true);
				}
				if (lineNumber >= 1047 && lineNumber <= 1050) {
					saveDAO(dao, "协议执行状态", content, "=", true);
				}
				if (lineNumber >= 1052 && lineNumber <= 1053) {
					saveDAO(dao, "支付管理类型", content, "=", true);
				}
				if (lineNumber >= 1055 && lineNumber <= 1058) {
					saveDAO(dao, "支付额度使用类型", content, "=", true);
				}
				if (lineNumber >= 1060 && lineNumber <= 1062) {
					saveDAO(dao, "收入转账间隔", content, "=", true);
				}
				if (lineNumber >= 1064 && lineNumber <= 1065) {
					saveDAO(dao, "现金回流方式", content, "=", true);
				}
				if (lineNumber >= 1067 && lineNumber <= 1068) {
					saveDAO(dao, "利率方向", content, "=", true);
				}
				if (lineNumber >= 1070 && lineNumber <= 1072) {
					saveDAO(dao, "帐户类型", content, "=", true);
				}
				if (lineNumber >= 1074 && lineNumber <= 1076) {
					saveDAO(dao, "收支标志", content, "=", true);
				}
				if (lineNumber >= 1078 && lineNumber <= 1079) {
					saveDAO(dao, "维护方", content, "=", true);
				}
				if (lineNumber >= 1081 && lineNumber <= 1082) {
					saveDAO(dao, "划拨方向", content, "=", true);
				}
				if (lineNumber >= 1084 && lineNumber <= 1085) {
					saveDAO(dao, "上存(下借)结息方式", content, "=", true);
				}
				if (lineNumber >= 1088 && lineNumber <= 1094) {
					saveDAO(dao, "交易种类", content, "\t", true);
				}
				if (lineNumber >= 1097 && lineNumber <= 1109) {
					saveDAO(dao, "利率类型码", content, "=", true);
				}
				if (lineNumber >= 1114 && lineNumber != 1138 && lineNumber <= 1168) {
					saveDAO(dao, "业务类别", content, "=", true);
				}
				if (lineNumber >= 1170 && lineNumber <= 1177) {
					saveDAO(dao, "担保方式", content, "=", true);
				}
				if (lineNumber >= 1179 && lineNumber <= 1186) {
					saveDAO(dao, "申请状态", content, "=", true);
				}
				if (lineNumber >= 1202 && lineNumber <= 1253) {
					saveDAO(dao, "代发代扣交易类型", content, "=", true);
				}
				if (lineNumber >= 1256 && lineNumber <= 1359) {
					saveDAO(dao, "定期业务编码", content, ":", true);
				}
				if (lineNumber >= 1362 && lineNumber <= 1395) {
					saveDAO(dao, "国际业务货币代码表", content, "\t", false);
				}
				if (lineNumber >= 1398 && lineNumber <= 1653) {
					saveDAO(dao, "招行分行", content, "=", true);
				}
				if (lineNumber >= 1656 && lineNumber <= 1695) {
					saveDAO(dao, "信用管理产品类别", content, "=", true);
				}
				lineNumber++;
			}
			lnr.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static void saveDAO(CmbcCode dao, String name, String content, String spilter, boolean val)
			throws Exception {
		dao.clear();
		String[] ccs = content.split(spilter);
		dao.setCodeName(name);
		if (val) {
			dao.setCodeId(ccs[0].trim());
			dao.setCodeValue(ccs[1].trim());
		} else {
			dao.setCodeId(ccs[1].trim());
			dao.setCodeValue(ccs[0].trim());
		}
		if(ccs.length > 2) dao.setCodeRemark(ccs[2]);
		dao.save();
	}

}
