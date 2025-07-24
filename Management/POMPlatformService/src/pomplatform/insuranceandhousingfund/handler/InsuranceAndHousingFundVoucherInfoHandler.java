package pomplatform.insuranceandhousingfund.handler;

import org.apache.log4j.Logger;
import pomplatform.insuranceandhousingfund.bean.BaseInsuranceAndHousingFundVoucherInfo;
import pomplatform.insuranceandhousingfund.bean.ConditionInsuranceAndHousingFundVoucherInfo;
import pomplatform.insuranceandhousingfund.query.QueryInsuranceAndHousingFundVoucherInfo;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class InsuranceAndHousingFundVoucherInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(InsuranceAndHousingFundVoucherInfoHandler.class);

	public static BaseCollection<BaseInsuranceAndHousingFundVoucherInfo> executeQueryInsuranceAndHousingFundVoucherInfo(ConditionInsuranceAndHousingFundVoucherInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryInsuranceAndHousingFundVoucherInfo dao = new QueryInsuranceAndHousingFundVoucherInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseInsuranceAndHousingFundVoucherInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionInsuranceAndHousingFundVoucherInfo c = new ConditionInsuranceAndHousingFundVoucherInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseInsuranceAndHousingFundVoucherInfo> result = executeQueryInsuranceAndHousingFundVoucherInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseInsuranceAndHousingFundVoucherInfo> result;
		ConditionInsuranceAndHousingFundVoucherInfo c = new ConditionInsuranceAndHousingFundVoucherInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryInsuranceAndHousingFundVoucherInfo dao = new QueryInsuranceAndHousingFundVoucherInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseInsuranceAndHousingFundVoucherInfo.ALL_CAPTIONS);
			for(BaseInsuranceAndHousingFundVoucherInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


