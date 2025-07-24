package pomplatform.plateIntegralAccount.handler;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.plateIntegralAccount.bean.BaseQualityFeeMonthlyDetail;
import pomplatform.plateIntegralAccount.bean.ConditionQualityFeeMonthlyDetail;
import pomplatform.plateIntegralAccount.query.QueryCompanyFeeMonthlyDetail;

public class CompanyFeeMonthlyDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CompanyFeeMonthlyDetailHandler.class);

	public static BaseCollection<BaseQualityFeeMonthlyDetail> executeQueryQualityFeeMonthlyDetail(ConditionQualityFeeMonthlyDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryCompanyFeeMonthlyDetail dao = new QueryCompanyFeeMonthlyDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseQualityFeeMonthlyDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionQualityFeeMonthlyDetail c = new ConditionQualityFeeMonthlyDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseQualityFeeMonthlyDetail> result = executeQueryQualityFeeMonthlyDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseQualityFeeMonthlyDetail> result;
		ConditionQualityFeeMonthlyDetail c = new ConditionQualityFeeMonthlyDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCompanyFeeMonthlyDetail dao = new QueryCompanyFeeMonthlyDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseQualityFeeMonthlyDetail.ALL_CAPTIONS);
			for(BaseQualityFeeMonthlyDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


