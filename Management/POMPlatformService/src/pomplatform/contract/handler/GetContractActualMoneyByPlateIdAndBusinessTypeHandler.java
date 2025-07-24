package pomplatform.contract.handler;

import org.apache.log4j.Logger;
import pomplatform.contract.bean.BaseGetContractActualMoneyByPlateIdAndBusinessType;
import pomplatform.contract.bean.ConditionGetContractActualMoneyByPlateIdAndBusinessType;
import pomplatform.contract.query.QueryGetContractActualMoneyByPlateIdAndBusinessType;
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

public class GetContractActualMoneyByPlateIdAndBusinessTypeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GetContractActualMoneyByPlateIdAndBusinessTypeHandler.class);

	public static BaseCollection<BaseGetContractActualMoneyByPlateIdAndBusinessType> executeQueryGetContractActualMoneyByPlateIdAndBusinessType(ConditionGetContractActualMoneyByPlateIdAndBusinessType c, KeyValuePair[] replacements ) throws Exception {
		QueryGetContractActualMoneyByPlateIdAndBusinessType dao = new QueryGetContractActualMoneyByPlateIdAndBusinessType();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGetContractActualMoneyByPlateIdAndBusinessType> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGetContractActualMoneyByPlateIdAndBusinessType c = new ConditionGetContractActualMoneyByPlateIdAndBusinessType();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGetContractActualMoneyByPlateIdAndBusinessType> result = executeQueryGetContractActualMoneyByPlateIdAndBusinessType(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGetContractActualMoneyByPlateIdAndBusinessType> result;
		ConditionGetContractActualMoneyByPlateIdAndBusinessType c = new ConditionGetContractActualMoneyByPlateIdAndBusinessType();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGetContractActualMoneyByPlateIdAndBusinessType dao = new QueryGetContractActualMoneyByPlateIdAndBusinessType();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGetContractActualMoneyByPlateIdAndBusinessType.ALL_CAPTIONS);
			for(BaseGetContractActualMoneyByPlateIdAndBusinessType b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


