package b.explicitLocking.producerconsumer;

import java.util.Arrays;

class _1_BasicProducerConsumer {
	static int[] buffer;
	static int count;

	static boolean isEmpty(int[] buffer) {
		return count == 0;
	}

	static boolean isFull(int[] buffer) {
		return count == buffer.length;
	}

	static class Producer {
		void produce() {
			while (isFull(buffer)) {
			}

			buffer[count++] = 1;
		}
	}

	static class Consumer {
		void consume() {
			while (isEmpty(buffer)) {
			}

			buffer[--count] = 0;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		buffer = new int[10];
		count = 0;

		Producer p = new Producer();
		Consumer c = new Consumer();

		Runnable pr = () -> {
			for (int i = 0; i < 50; i++)
				p.produce();
			System.out.println("Producer Done.");
		};
		Runnable cr = () -> {
			for (int i = 0; i < 50; i++)
				c.consume();
			System.out.println("Consumer Done.");
		};

		Thread pt = new Thread(pr);
		Thread ct = new Thread(cr);

		ct.start();
		pt.start();

		ct.join();
		pt.join();

		System.out.println("Count: " + count + " | Buffer: " + Arrays.toString(buffer));
	}
}
