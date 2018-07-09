package a.implicitLocking.synchronize;

import java.time.Instant;

class _1_ThreadsEnteringBathroomAsync {
	static class Bathroom {
		void enter() {
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

		void exit() {
			System.out.println(Thread.currentThread().getName() + " left bathroom at: " + Instant.now());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		demoTwoThreadsExecuting2MethodsOnSameObject();
	}

	private static void demoTwoThreadsExecuting2MethodsOnSameObject() throws InterruptedException {
		final Bathroom floor8Bathroom1 = new Bathroom();
		Thread t1 = new Thread(() -> floor8Bathroom1.enter(), "Bob");
		Thread t2 = new Thread(() -> floor8Bathroom1.exit(), "Alice");
		t1.start();
		t2.start();
	}

}
