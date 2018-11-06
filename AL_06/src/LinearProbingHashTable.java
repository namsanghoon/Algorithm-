
public class LinearProbingHashTable  {
	private Entry[] entries; // Ű�� ���� ���� ��ü�� �����ϴ� �迭
	private int size, used, collision = 0; 
	private float loadFactor; 
	private final Entry NIL = new Entry(null, null); // NIL ��ü ����

	public LinearProbingHashTable(int capacity, float loadFactor) {
		entries = new Entry[capacity];
		this.loadFactor = loadFactor;
	}

	public LinearProbingHashTable(int capacity) {
		this(capacity, 0.75F);
	}

	public LinearProbingHashTable() {
		this(59);
	}

	public Object get(Object key) { // Ű ���� �ؽ����̺��� ã�� ���� �޼ҵ�
		int h = hash(key); 
		for (int i = 0; i < entries.length; i++) {// ���̺� �� �ڸ��� Ž��
			int j = nextProbe(h, i); 
			Entry entry = entries[j]; // entry ��ü�� �迭���� ã��
			if (entry == null) // ������ ����
				break;
			if (entry == NIL) // NIL�� ������ ��� Ž��
				continue;
			if (entry.key.equals(key)) // ���� ���� ã���� value�� ���
				return entry.value;
		}
		return null; 
	}

	public Object put(Object key, Object value) { // Ű ���� �ؽ����̺� �ִ� �޼ҵ�
		if (used > loadFactor * entries.length)
			rehash();
		int h = hash(key);
		for (int i = 0; i < entries.length; i++) {
			int j = nextProbe(h, i); // ���̺� �� �ڸ��� Ž��
			Entry entry = entries[j]; // ��ü�� �迭���� ������
			if (entry == null) { // ��ü�� ���̺� ������ ����
				entries[j] = new Entry(key, value);
				++size;
				++used;
				return null; 
			}
			if (entry == NIL) { // NIL�� ������ ��� Ž��
				collision++;//�浹Ƚ�� ����
				continue;
			}
			if (entry.key.equals(key)) { // ���� ���� ã���� ����
				Object oldValue = entry.value;
				entries[j].value = value;
				return oldValue; 
			}

			collision++;//�浹Ƚ�� ����

		}
		return null; 
	}

	public Object remove(Object key) { // Ű ���� �ؽ����̺��� �����ϱ� ���� �Լ�
		int h = hash(key);
		for (int i = 0; i < entries.length; i++) {
			int j = nextProbe(h, i);
			Entry entry = entries[j];
			if (entry == null) // ���̺� Ű ���� ������ ����
				break;
			if (entry == NIL) // NIL�� ������ ���
				continue;
			if (entry.key.equals(key)) { // ���� ���� ã���� ����
				Object oldValue = entry.value;
				entries[j] = NIL;
				--size;
				return oldValue; // success
			}
		}
		return null; // failure: key not found
	}

	public void collision() {
		System.out.println(collision);
	}

	public int size() { 
		return size;
	}

	private class Entry { 
		Object key, value;

		Entry(Object k, Object v) {
			key = k;
			value = v;
		}
	}

	private int hash(Object key) {
		if (key == null)
			throw new IllegalArgumentException();
		return (key.hashCode() & 0x7FFFFFFF) % entries.length; 
	}

	private int nextProbe(int h, int i) { // ���̺� ���� ��ġ�� ã�� ���� �޼ҵ�
		return (h + i) % entries.length; 
	}

	private void rehash() { // ���̺� ũ�⸦ �÷��ִ� �Լ�
		Entry[] oldEntries = entries;
		entries = new Entry[2 * oldEntries.length + 1]; // ���̺��� ũ�⸦ 2��+1�� �ø�
		for (int k = 0; k < oldEntries.length; k++) {
			Entry entry = oldEntries[k];
			if (entry == null || entry == NIL)
				continue;
			int h = hash(entry.key);
			for (int i = 0; i < entries.length; i++) {
				int j = nextProbe(h, i);
				if (entries[j] == null) {
					entries[j] = entry;
					break;
				}
			}
		}
		used = size;
	}
}
