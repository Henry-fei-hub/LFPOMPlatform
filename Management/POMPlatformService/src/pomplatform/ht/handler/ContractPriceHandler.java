package pomplatform.ht.handler;

import org.apache.log4j.Logger;
import pomplatform.ht.bean.BaseContractPrice;
import pomplatform.ht.bean.ConditionContractPrice;
import pomplatform.ht.query.QueryContractPrice;
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

public class ContractPriceHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ContractPriceHandler.class);

	public static BaseCollection<BaseContractPrice> executeQueryContractPrice(ConditionContractPrice c, KeyValuePair[] replacements ) throws Exception {
		QueryContractPrice dao = new QueryContractPrice();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseContractPrice> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionContractPrice c = new ConditionContractPrice();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseContractPrice> result = executeQueryContractPrice(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseContractPrice> result;
		ConditionContractPrice c = new ConditionContractPrice();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryContractPrice dao = new QueryContractPrice();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseContractPrice.ALL_CAPTIONS);
			for(BaseContractPrice b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


