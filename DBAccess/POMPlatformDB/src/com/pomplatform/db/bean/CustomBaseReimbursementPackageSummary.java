package com.pomplatform.db.bean;

public class CustomBaseReimbursementPackageSummary extends BaseReimbursementPackageSummary {

	public static CustomBaseReimbursementPackageSummary newInstance() {
		return new CustomBaseReimbursementPackageSummary();
	}

	@Override
	public CustomBaseReimbursementPackageSummary make() {
		CustomBaseReimbursementPackageSummary b = new CustomBaseReimbursementPackageSummary();
		return b;
	}

	public final static java.lang.String ALL_CAPTIONS = "户名,账号,实付金额,冲账金额,开户行";


	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPayeeName() == null ? "" : getPayeeName());
		sb.append(",");
		sb.append(getSelfBankAccount() == null ? "" : getSelfBankAccount());
		sb.append(",");
		sb.append(getPaymentAmount() == null ? "" : getPaymentAmount());
		sb.append(",");
		sb.append(getStrikeABalanceAmount() == null ? "" : getStrikeABalanceAmount());
		sb.append(",");
		sb.append(getSelfBankName() == null ? "" : getSelfBankName());
//		sb.append(",");
//		sb.append(getOtherName() == null ? "" : getOtherName());
//		sb.append(",");
//		sb.append(getOtherBankName() == null ? "" : getOtherBankName());
//		sb.append(",");
//		sb.append(getOtherBankAccount() == null ? "" : getOtherBankAccount());
//		sb.append(",");
//		sb.append(getAmount() == null ? "" : getAmount());
//		sb.append(",");
//		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
//		sb.append(",");
//		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
//		sb.append(",");
//		sb.append(getIsCompleted() == null ? "" : getIsCompleted());
		return sb.toString();
	}

}
