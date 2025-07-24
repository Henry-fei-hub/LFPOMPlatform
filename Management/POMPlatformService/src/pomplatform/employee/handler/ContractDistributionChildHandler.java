package pomplatform.employee.handler;

import org.apache.log4j.Logger;
import pomplatform.employee.bean.BaseContractDistributionChild;
import pomplatform.employee.bean.ConditionContractDistributionChild;
import pomplatform.employee.query.QueryContractDistributionChild;
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

public class ContractDistributionChildHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ContractDistributionChildHandler.class);

	public static BaseCollection<BaseContractDistributionChild> executeQueryContractDistributionChild(ConditionContractDistributionChild c, KeyValuePair[] replacements ) throws Exception {
		QueryContractDistributionChild dao = new QueryContractDistributionChild();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseContractDistributionChild> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionContractDistributionChild c = new ConditionContractDistributionChild();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseContractDistributionChild> result = executeQueryContractDistributionChild(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseContractDistributionChild> result;
		ConditionContractDistributionChild c = new ConditionContractDistributionChild();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryContractDistributionChild dao = new QueryContractDistributionChild();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseContractDistributionChild.ALL_CAPTIONS);
			for(BaseContractDistributionChild b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


