
public class Barrier {
	private int totalNum;
	private int out;
	private int in;
	
	public Barrier(int num) {
		in = 0;
		out = num;
		totalNum = num;
	}
	
	public void enterBarrier() {
		synchronized (this) {
			while (out < totalNum) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (in == totalNum) {
				in = 0;
				notifyAll();
			}
			in++;
		}
		
		synchronized (this) {
			while (in < totalNum) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (out == totalNum) {
				out = 0;
				notifyAll();
			}
			out++;
		}
	}
	
	public static void main(String[] args) {
		int n = 5;
		Barrier b = new Barrier(n);
		for (int i = 0; i < n; i++) {
			Worker w = new Worker(b, i);
			Thread t = new Thread(w);
			t.start();
		}
	}
	
}

class Worker implements Runnable {
	private Barrier barrier;
	private int id;
	public Worker(Barrier b, int i) {
		barrier = b;
		id = i;
	}
	
	@Override
	public void run() {
		while (true) {
			barrier.enterBarrier();
			System.out.println("Out barrier in thread " + id);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
