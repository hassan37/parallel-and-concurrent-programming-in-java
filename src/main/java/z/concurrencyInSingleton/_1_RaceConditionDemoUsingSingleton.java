package z.concurrencyInSingleton;

/**
 * Accessing data concurrently may lead to issues! It means that two
 * <b>different</b> threads are trying to <b>read</b> and <b>write</b> the
 * <b>same</b> variable at the <b>same</b> time. This is called a <b>race
 * condition</b><br />
 * 
 * <b>Note</b>: '<b>same</b>' time does not mean same thing on a single core and
 * on a multi-core CPU'
 * 
 * @see https://en.wikipedia.org/wiki/Race_condition#Computing
 *
 */
public class _1_RaceConditionDemoUsingSingleton {

	static class ReceConditionedSingleton {
		static ReceConditionedSingleton INST;

		static ReceConditionedSingleton getInstance() {
			if (null == INST)
				INST = new ReceConditionedSingleton();
			return INST;
		}
	}

	static class SyncReceCondSing {
		static SyncReceCondSing INST;

		static synchronized SyncReceCondSing getInstance() {
			if (null == INST)
				INST = new SyncReceCondSing();
			return INST;
		}
	}

}
