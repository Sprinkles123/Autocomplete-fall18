import java.util.*;

public class BinarySearchLibrary {
	
	public static <T>
	    int firstIndexSlow(List<T> list, 
	    		           T target, Comparator<T> comp) {
		int index = Collections.binarySearch(list, target,comp);
		
		if (index < 0) return index;
		
		while (0 <= index && comp.compare(list.get(index),target) == 0) {
			index -= 1;
		}
		return index+1;
	}
	
	/**
	 * Uses binary search to find the index of the first object in parameter
	 * list -- the first object o such that comp.compare(o,target) == 0.
	 * 
	 * This method should not call comparator.compare() more than 1+log n times
	 * @param list is the list of objects being searched
	 * @param target is the object being searched for
	 * @param comp is how comparisons are made
	 * @return index i such that comp.compare(list.get(i),target) == 0
	 * and there is no index < i such that this is true. Return -1
	 * if there is no such object in list.
	 */
	
	public static <T>
    	int firstIndex(List<T> list, 
	               	T target, Comparator<T> comp) {
		int low = -1;
		int high = list.size()-1;
		int med=0;
		
		if (list.size()==0) {return -1;}
		
		while (low+1 != high) {			
			med= ((low+high)/2);
			int compVal = comp.compare(list.get(med),target);
		
			if (compVal>=0 ){high=med;}
			if (compVal<0 ){low=med;}
		}
		if (comp.compare(list.get(high),target)==0)  {return high;}
		return -1;
	}

	/**
	 * Uses binary search to find the index of the last object in parameter
	 * list -- the first object o such that comp.compare(o,target) == 0.
	 * 
	 * This method should not call comparator.compare() more than 1+log n times
	 * @param list is the list of objects being searched
	 * @param target is the object being searched for
	 * @param comp is how comparisons are made
	 * @return index i such that comp.compare(list.get(i),target) == 0
	 * and there is no index > i such that this is true. Return -1
	 * if there is no such object in list.
	 */
	public static <T>
	int lastIndex(List<T> list, 
               	  T target, Comparator<T> comp) {
		int low = 0;
		int high = list.size();
		int med=0;
		
		if (list.size()==0) {return -1;}
	
		while (low != high-1) {
			med= ((low+high)/2);
			int compVal = comp.compare(list.get(med),target);
			
			if  (compVal>0 ){high=med;}
			if (compVal<=0 ){low=med;}
		}
		if (comp.compare(list.get(low),target)==0)  {return low;}		
		return -1;
	}
	
}
