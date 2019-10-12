package buffer;

import java.util.concurrent.ConcurrentLinkedQueue;

import model.SystemResponseTimeEvent;

/**
 * It represents a buffer in which SystemResponseTimeEvent items are stored.
 * 
 * To be used only for experiment.
 * 
 * The buffer is implemented through ConcurrentLinkedQueue, that is a queue that orders
 * elements FIFO (First In First Out).
 */
public class SystemResponseTimeBuffer implements Buffer<SystemResponseTimeEvent> {
	
	private ConcurrentLinkedQueue<SystemResponseTimeEvent> systemResponseTime2EventList;
	
	/**
	 * It creates a new instance of SystemResponseCpuTimeBuffer.
	 */
	public SystemResponseTimeBuffer() {
		this.systemResponseTime2EventList = new ConcurrentLinkedQueue<SystemResponseTimeEvent>();
	
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addItem(SystemResponseTimeEvent item) {
		systemResponseTime2EventList.offer(item);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public SystemResponseTimeEvent readItem() {
		return systemResponseTime2EventList.poll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear() {
		systemResponseTime2EventList.clear();
	}
	
	
	public boolean isEmpty() {
		return systemResponseTime2EventList.isEmpty();
	}
}