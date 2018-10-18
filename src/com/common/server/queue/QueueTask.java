/*
 * Equilibrha 2018. Backend V2.0.0
 * 
 * Patron Singleton for Queue of Task 
 * 
 */

package com.common.server.queue;

import java.io.Serializable;
import java.util.Comparator;
import java.util.PriorityQueue;

public class QueueTask implements Serializable {
	
	private static final long serialVersionUID = -7604766932017737115L;
	
	//Queue Static comparator by opriority
	private static Comparator<Task> comparator = new ComparatorQueue();
	
	//queue Priority
	private static PriorityQueue<Task> queue = new PriorityQueue<Task>(1, comparator);   //new LinkedList<Task>();
		
	//instance
	private static QueueTask queueInstance = null;
	
	//get instance
	public static  QueueTask getInstance() {
		//thread safe
		if (queueInstance == null) {
			 synchronized (QueueTask.class){
			        if (queueInstance == null) {
			        	queueInstance = new QueueTask();
			        }
		     }
		}
		return queueInstance;
	}
	
	// ------- functional Methods ------------
	public void add(Task value) {
		synchronized (queue) {
			queue.add(value);
		}
	}
	
	public static void printQueue() {
		for(Task s : queue) { 
			  System.out.println(s.get_argumentJson()); 
			}
	}
	
	public void remove(Task value) {
		synchronized (queue) {
			queue.remove(value);
		}
	}
	
	public Task poll() {
		Task data = queue.poll();
		return data;
	}

	public int getTotalSize() {
		return queue.size();
	}
	
	//subclass comparator the task
	public static class ComparatorQueue implements Comparator<Task>
	{
	    @Override
	    public int compare(Task x, Task y)
	    {
	        if (x.get_Priority() < y.get_Priority())
	        {
	            return -1;
	        }
	        if (x.get_Priority() > y.get_Priority())
	        {
	            return 1;
	        }
	        return 0;
	    }
	}
}
