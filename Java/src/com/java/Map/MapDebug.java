package com.java.Map;

/**
 * 
 * YouTube Link : 
 *    https://www.youtube.com/watch?v=AVSGJHrrLpE&list=PL3NrzZBjk6m9do1opOKwx_C7d2HRJzpwG&index=3
 *      
 *           
 *           HashMap Internal Working
 *      ----------------------------------------
 *      --) Default bucket size : 16
 *      --) Each Bucket is called Node Which store data in the form of LinkedList.
 *      --) Load Factor : 0.75
 *      --) Initial Capacity : 16
 *     
 *      
 *      As soon as we will try to insert data , The put method perform some operation.
 * 
 *      
 *      
 *               put(Key k ,Value v) method
 *      -----------------------------------------------------
 *      
 *      What put method will do , It will 
 *      
 *      ** ) Try to get HashCode of Key k.
 *      		
 *      		HashCode h = hash(key);
 *      
 *             Question is why HashCode , 
 *                   
 *                   **) HashCode helps to store key at particular index
 *                   **) HashCode helps to  store data from particular index very faster.
 *                   
 *                   index = hash & (n-1)
 *                   
 *                   With the above formula , 
 *                   we will get index value within the range of bucket
 *                   
 *                   **) Basically this Node or LinkedList store 4 information
 *                   
 *                           a) Key  
 *                           b) HashCode
 *                           c) Value
 *                           d) next
 *                           
 *                           Where next refer to next LinkedList.
 *                           This situation will come when HashCode is same and this
 *                           state is called Hash Collision . 
 *                           
 *                     **) When key is null , data will store into the 0th bucket.
 *                     **) If Key Will be same , then the value will be updated with new value.
 *                   
 *      
 *      
 *      
 *      get(Key k) method
 *      -----------------------
 *      
 *      **) For the particular key hasCode will be calculated first.
 *             
 *             hashCode = hash(Key k );
 *             
 *             and then internally it will try to find out index value for that hashCode
 *             
 *             suppose index = 4.
 *             
 *             At 4th index it will firstly match hashCode and then Key to get the
 *             particular value from the LinkedList.
 *             
 *          Why Key Comparison is required
 *         -------------------------------------------
 *         Their can be more than 1 key for which the hashCode can be same. 
 *         In that case both Node will reside at same index with the help of linkedList.
 *         
 *         Thats why key comparison is required.
 *         
 *         
 *      
 *      
 */
public class MapDebug {

	public static void main(String[] args) 
	{
		
	}

}
