package pomplatform.common.utils;

import java.util.List;

import delicacy.common.GenericBase;

public class BaseTree {
	
	public Integer id;//节点id  
    
    public Integer parentId;//节点父id  
      
    public Boolean leafNode = true;//是否为叶子节点，true表示是叶子节点，false表示不是叶子节点  
      
    public GenericBase data;//原有的实体数据
    
    public List<BaseTree> children;//孩子节点  
  
  
    public BaseTree() {  
          
    }  
      
    public BaseTree(Integer id, Integer parentId) {  
        this.id = id;  
        this.parentId = parentId;  
    }  
  
    public Integer getId() {  
        return id;  
    }  
  
    public void setId(Integer id) {  
        this.id = id;  
    }  
  
    public Integer getParentId() {  
        return parentId;  
    }  
  
    public void setParentId(Integer parentId) {  
        this.parentId = parentId;  
    }  
  
    public Boolean isLeafNode() {  
        return leafNode;  
    }  
  
    public void setIsLeafNode(Boolean leafNode) {  
        this.leafNode = leafNode;  
    }  
  
    public GenericBase getData() {
		return data;
	}

	public void setData(GenericBase data) {
		this.data = data;
	}

	public List<BaseTree> getChildren() {  
        return children;  
    }  
  
    public void setChildren(List<BaseTree> children) {  
        this.children = children;  
    }  
}
