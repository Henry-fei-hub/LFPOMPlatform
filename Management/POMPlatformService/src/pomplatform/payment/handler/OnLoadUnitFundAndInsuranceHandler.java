package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseOnLoadUnitFundAndInsurance;
import pomplatform.payment.bean.ConditionOnLoadUnitFundAndInsurance;
import pomplatform.payment.query.QueryOnLoadUnitFundAndInsurance;
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

public class OnLoadUnitFundAndInsuranceHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadUnitFundAndInsuranceHandler.class);

	public static BaseCollection<BaseOnLoadUnitFundAndInsurance> executeQueryOnLoadUnitFundAndInsurance(ConditionOnLoadUnitFundAndInsurance c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadUnitFundAndInsurance dao = new QueryOnLoadUnitFundAndInsurance();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadUnitFundAndInsurance> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadUnitFundAndInsurance c = new ConditionOnLoadUnitFundAndInsurance();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadUnitFundAndInsurance> result = executeQueryOnLoadUnitFundAndInsurance(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadUnitFundAndInsurance> result;
		ConditionOnLoadUnitFundAndInsurance c = new ConditionOnLoadUnitFundAndInsurance();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadUnitFundAndInsurance dao = new QueryOnLoadUnitFundAndInsurance();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadUnitFundAndInsurance.ALL_CAPTIONS);
			for(BaseOnLoadUnitFundAndInsurance b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


