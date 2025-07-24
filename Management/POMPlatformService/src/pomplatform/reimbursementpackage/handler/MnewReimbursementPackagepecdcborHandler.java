package pomplatform.reimbursementpackage.handler;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.reimbursementpackage.bean.BaseMnewReimbursementPackagepecdcbor;
import pomplatform.reimbursementpackage.bean.ConditionMnewReimbursementPackagepecdcbor;
import pomplatform.reimbursementpackage.query.QueryMnewReimbursementPackagepecdcbor;

public class MnewReimbursementPackagepecdcborHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MnewReimbursementPackagepecdcborHandler.class);

	static class ProcessInstanceIdComparator implements Comparator {  
        public int compare(Object object1, Object object2) {// 实现接口中的方法  
        	BaseMnewReimbursementPackagepecdcbor p1 = (BaseMnewReimbursementPackagepecdcbor) object1; // 强制转换  
        	BaseMnewReimbursementPackagepecdcbor p2 = (BaseMnewReimbursementPackagepecdcbor) object2;  
            return new Double(p1.getProcessInstanceId()).compareTo(new Double(p2.getProcessInstanceId()));  
        }  
    } 
	
	public static BaseCollection<BaseMnewReimbursementPackagepecdcbor> executeQueryMnewReimbursementPackagepecdcbor(ConditionMnewReimbursementPackagepecdcbor c, KeyValuePair[] replacements ) throws Exception {
		QueryMnewReimbursementPackagepecdcbor dao = new QueryMnewReimbursementPackagepecdcbor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMnewReimbursementPackagepecdcbor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMnewReimbursementPackagepecdcbor c = new ConditionMnewReimbursementPackagepecdcbor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMnewReimbursementPackagepecdcbor> result = executeQueryMnewReimbursementPackagepecdcbor(c, c.getKeyValues());
		List<BaseMnewReimbursementPackagepecdcbor> list = result.getCollections();
		Collections.sort(list, new ProcessInstanceIdComparator());
		//去重
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).getCode().equals(list.get(i + 1).getCode())) {
				list.remove(i);
				i--;
			}
		}
		result.setCollections(list);
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMnewReimbursementPackagepecdcbor> result;
		ConditionMnewReimbursementPackagepecdcbor c = new ConditionMnewReimbursementPackagepecdcbor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMnewReimbursementPackagepecdcbor dao = new QueryMnewReimbursementPackagepecdcbor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMnewReimbursementPackagepecdcbor.ALL_CAPTIONS);
			for(BaseMnewReimbursementPackagepecdcbor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


