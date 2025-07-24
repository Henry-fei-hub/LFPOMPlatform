package pomplatform.subContractInfo.handler;

import org.apache.log4j.Logger;
import pomplatform.subContractInfo.bean.BaseSubContractInfo;
import pomplatform.subContractInfo.bean.ConditionSubContractInfo;
import pomplatform.subContractInfo.query.QuerySubContractInfo;
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

public class SubContractInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SubContractInfoHandler.class);

	public static BaseCollection<BaseSubContractInfo> executeQuerySubContractInfo(ConditionSubContractInfo c, KeyValuePair[] replacements ) throws Exception {
		QuerySubContractInfo dao = new QuerySubContractInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSubContractInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSubContractInfo c = new ConditionSubContractInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSubContractInfo> result = executeQuerySubContractInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSubContractInfo> result;
		ConditionSubContractInfo c = new ConditionSubContractInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySubContractInfo dao = new QuerySubContractInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSubContractInfo.ALL_CAPTIONS);
			for(BaseSubContractInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


