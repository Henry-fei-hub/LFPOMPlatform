package pomplatform.contractInfo.handler;

import org.apache.log4j.Logger;
import pomplatform.contractInfo.bean.BaseContractInfo;
import pomplatform.contractInfo.bean.ConditionContractInfo;
import pomplatform.contractInfo.query.QueryContractInfo;
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

public class ContractInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ContractInfoHandler.class);

	public static BaseCollection<BaseContractInfo> executeQueryContractInfo(ConditionContractInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryContractInfo dao = new QueryContractInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseContractInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionContractInfo c = new ConditionContractInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseContractInfo> result = executeQueryContractInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseContractInfo> result;
		ConditionContractInfo c = new ConditionContractInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryContractInfo dao = new QueryContractInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseContractInfo.ALL_CAPTIONS);
			for(BaseContractInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


