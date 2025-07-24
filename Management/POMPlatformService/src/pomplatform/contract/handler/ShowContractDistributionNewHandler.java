package pomplatform.contract.handler;


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
import pomplatform.contract.bean.BaseShowContractDistributionNew;
import pomplatform.contract.bean.ConditionShowContractDistributionNew;
import pomplatform.contract.query.QueryShowContractDistributionNew;

public class ShowContractDistributionNewHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ShowContractDistributionNewHandler.class);

	public static BaseCollection<BaseShowContractDistributionNew> executeQueryShowContractDistributionNew(ConditionShowContractDistributionNew c, KeyValuePair[] replacements ) throws Exception {
		QueryShowContractDistributionNew dao = new QueryShowContractDistributionNew();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseShowContractDistributionNew> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionShowContractDistributionNew c = new ConditionShowContractDistributionNew();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseShowContractDistributionNew> result = executeQueryShowContractDistributionNew(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseShowContractDistributionNew> result;
		ConditionShowContractDistributionNew c = new ConditionShowContractDistributionNew();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryShowContractDistributionNew dao = new QueryShowContractDistributionNew();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseShowContractDistributionNew.ALL_CAPTIONS);
			for(BaseShowContractDistributionNew b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


