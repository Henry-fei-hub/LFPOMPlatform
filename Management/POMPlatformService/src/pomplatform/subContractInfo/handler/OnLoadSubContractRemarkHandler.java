package pomplatform.subContractInfo.handler;

import org.apache.log4j.Logger;
import pomplatform.subContractInfo.bean.BaseOnLoadSubContractRemark;
import pomplatform.subContractInfo.bean.ConditionOnLoadSubContractRemark;
import pomplatform.subContractInfo.query.QueryOnLoadSubContractRemark;
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

public class OnLoadSubContractRemarkHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadSubContractRemarkHandler.class);

	public static BaseCollection<BaseOnLoadSubContractRemark> executeQueryOnLoadSubContractRemark(ConditionOnLoadSubContractRemark c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadSubContractRemark dao = new QueryOnLoadSubContractRemark();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadSubContractRemark> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadSubContractRemark c = new ConditionOnLoadSubContractRemark();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadSubContractRemark> result = executeQueryOnLoadSubContractRemark(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadSubContractRemark> result;
		ConditionOnLoadSubContractRemark c = new ConditionOnLoadSubContractRemark();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadSubContractRemark dao = new QueryOnLoadSubContractRemark();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadSubContractRemark.ALL_CAPTIONS);
			for(BaseOnLoadSubContractRemark b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


