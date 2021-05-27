package sharma15;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class List<T extends Agency> implements Iterable<T> { 
	
	LinkedList<Agency> T= new LinkedList<Agency>();
	
      
    public int getSize() {
        return T.size();
    }
    
    public void add(T data) 
    {  
        T.add(data);
    } 

    public void add(T[] array) {
        for (T data : array) {
            add(data);
        }
    }

    public void remove(T data) {
        T.remove(data);
    }
    
    public Agency[] toArray() {
      Agency[] temp = new Agency[T.size()];
      Agency current = T.getFirst();
      Agency next = T.get(2);
      for(int i = 0; i < T.size(); i++) {
        temp[i] = (Agency) current.getClass();
        current = next;
        //next = current.getNext();
      }
      
      return temp;
    }
    public String toString(List<Agency> list) {
    	StringBuilder temp = new StringBuilder();
    	temp.append("[");
    	for(Agency elem : list) {
    		temp.append("Firm name:" + elem.getFirmName() + "\nPosition:" + elem.getPosition() + "\nCircumstances:" + elem.getCircs()
    		+ "\nSalary:" + elem.getSalary());
    		if(elem.getKey()) {
    			temp.append("\nEducation:" + elem.getReqs().getEducation() + "\nExperience:" + elem.getReqs().getYexp());
    		}
    	}
    	temp.append("]");
    	return temp.toString();
    }
    // return Head 
    public Agency getHead() 
    { 
        return T.getFirst(); 
    } 
    
      
    // return Tail 
    public Agency getTail() 
    { 
        return T.getLast(); 
    } 
      

     
    public static<T extends Agency> boolean compareFirmNames(T p1, T p2) {
        
    	if(p1.getFirmName().length() > p2.getFirmName().length()) {
    	return true;
    	}
    	return false;
        
    }
    public static<T extends Agency> boolean compareEducation(T p1, T p2) {
    	if(p1.getReqs() != null && p2.getReqs() != null) {
    		if( p1.getReqs().getEducation().compareTo(p2.getReqs().getEducation()) > 0) {
    			return true;
    		}
    		return false;
    	}
    	return false;
    }
    public static<T extends Agency> boolean compareCircs(T p1, T p2) {
        if(p1.getCircs().compareTo(p2.getCircs()) > 0) {
    	return true;
        }
        return false;
    }
    
    public void sortList() {
    	if(T.getFirst() == null) {
    		return;
    	}
    	T.sort(null);
    	
    	}


	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
    
} 
