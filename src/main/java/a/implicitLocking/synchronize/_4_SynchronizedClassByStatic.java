package a.implicitLocking.synchronize;

import java.time.Instant;

class _4_SynchronizedClassByStatic {
	static class Bathroom {
		static synchronized void enter() {
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

		static synchronized void exit() {
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

	public static void main(String[] args) throws InterruptedException {
		demoTwoThreadsExecuting2MethodsOnSameObject();
	}

	private static void demoTwoThreadsExecuting2MethodsOnSameObject() throws InterruptedException {
		Thread t1 = new Thread(() -> Bathroom.enter(), "Bob");
		Thread t2 = new Thread(() -> Bathroom.exit(), "Alice");
		t1.start();
		t2.start();
	}
}
