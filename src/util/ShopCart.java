package util;

import hibernate.po.Product;

import java.util.HashMap;

public class ShopCart {
	
	private HashMap<String,Product> hashmap;

	
    public HashMap<String, Product> getHashmap() {
		return hashmap;
	}

	public void setHashmap(HashMap<String, Product> hashmap) {
		this.hashmap = hashmap;
	}

	public ShopCart ()
    {hashmap= new HashMap(); }
    
    /**
	 * 检查hashmap中是否有了该pid对应的对象方法
	 * @param pid
	 * @return true：有   false：无
	 */
    
     public boolean checkHashMapid(String pid)
     {
    	 boolean b=false;
    	 if(hashmap.containsKey(pid))
    	 {
    		b=true; 
    	 }
    	 return b;
     }
     /**
 	 * 在上面方法返回false情况下添加product
 	 * @param pid
 	 * @param product
 	 */
 	public void addProduct(String pid,Product product){
		hashmap.put(pid, product);
	}
     
     /**
 	 * 根据id删除hashmap中的product
 	 * @param pid
 	 */
     public void removeHashMap(String pid)
     {
    	 hashmap.remove(pid);
     }

     /**
 	 * 修改hashmap中pid对应product的数量
 	 * @param pid
 	 * @param quantity
 	 */
     public void updateProductNumbedr(String pid,String quantity)
     {
    	  hashmap.get(pid).setQuantity(quantity);
     }
     
     /**
 	 * 清除购物车
 	 */
     public void emptyCart()
     {
    	 hashmap.clear();
     }
}
