package a.implicitLocking.synchronize;

import java.time.Instant;

class _2_UnderstandingSynchronized {

	static class Bathroom {
		void enter() {
			synchronized (this) {
				String name = Thread.currentThread().getName();
				Instant enteryTime = Instant.now();
				System.out.println(name + " enterd the bathroom at: " + enteryTime);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println("Seriously!!! In washroom too. No one is safe.");
				}

				System.out.println(name + " done at: " + Instant.now());
			}
		}

		void exit() {
			synchronized (this) {
				String name = Thread.currentThread().getName();
				Instant enteryTime = Instant.now();
				System.out.println(name + ": door is knocked at: " + enteryTime);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println("Seriously!!! In washroom too. No one is safe.");
				}

				System.out.println(name + " left at: " + Instant.now());
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		demoTwoThreadsExecuting2MethodsOnSameObject();
		// demoMultipleMethodsSynchronization();
	}

	static void demoTwoThreadsExecuting2MethodsOnSameObject() throws InterruptedException {
		final Bathroom floor8Bathroom1 = new Bathroom();
		Thread t1 = new Thread(() -> floor8Bathroom1.enter(), "Bob");
		Thread t2 = new Thread(() -> floor8Bathroom1.exit(), "Alice");
		t1.start();
		t2.start();
	}

	static void demoMultipleMethodsSynchronization() throws InterruptedException {
		final Bathroom floor8Bathroom1 = new Bathroom();
		final Bathroom floor8Bathroom2 = new Bathroom();
		Thread t1 = new Thread(() -> floor8Bathroom1.enter(), "Bob");
		Thread t2 = new Thread(() -> floor8Bathroom2.exit(), "Alice");
		t1.start();
		t2.start();
	}

}
