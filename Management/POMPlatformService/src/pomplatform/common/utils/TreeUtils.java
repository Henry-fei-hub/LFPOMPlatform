package pomplatform.common.utils;

import java.util.ArrayList;
import java.util.List;

public class TreeUtils {

	/** 
     * 格式化list为树形list 
     * @param list 
     * @return 
     */  
    public static <T extends BaseTree> List<T> formatTree(List<T> list) {  
        List<T> nodeList = new ArrayList<T>();    
        for(T node1 : list){  
        	boolean mark = false; 
            for(T node2 : list){    
                if(node1.getParentId()!=null && node1.getParentId().equals(node2.getId())){   
                    node2.setIsLeafNode(false); 
                    mark = true;
                    if(node2.getChildren() == null) {  
                        node2.setChildren(new ArrayList<BaseTree>());    
                    }  
                    node2.getChildren().add(node1);   
                    break;    
                }    
            } 
            if(!mark){    
                nodeList.add(node1);     
            } 
        }  
        return nodeList;  
    }  
}
