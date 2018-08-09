package c.visibility;

class _1_UnderstandingHappensBeforeLink {

	static class NoSyncNoVolatile_NoHappensBefore {
		int r;
		void increment() { r++; }
		void print() { System.out.print("| " + r); }

		static void demo() throws InterruptedException {
			NoSyncNoVolatile_NoHappensBefore inst = new NoSyncNoVolatile_NoHappensBefore();
			Runnable r1 = inst::increment;
			Runnable r2 = inst::print;

			Thread t1 = new Thread(r1);
			Thread t2 = new Thread(r2);

			t1.start(); t2.start();
			t1.join(); t2.join();

			inst.print();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		NoSyncNoVolatile_NoHappensBefore.demo();
	}
}
