import java.io.BufferedWriter;
import java.io.FileWriter;

public class DoubleHashingHashTable {
	private Entry[] entries;
	String[] data = new String[12];
	int[] index = new int[12];
	private int size, collision,count = 0;
	String delete = "DELETE";
	
	private float loadFactor;
	private final Entry NIL = new Entry(null, null);
	private final Entry DELETE = new Entry(delete, delete);

	public DoubleHashingHashTable(int capacity, float loadFactor) {
		entries = new Entry[capacity];
		this.loadFactor = loadFactor;
	}

	public DoubleHashingHashTable(int capacity) {
		this(capacity, 0.75F);
	}

	public DoubleHashingHashTable() {
		this(59);
	}

	public Object get(Object key) {
		int h = hash(key);
		int d = hash2(key);
		
		for (int i = 0; i < entries.length; i++) {
			int j = nextProbe(h, d, i);
			Entry entry = entries[j];
			if (entry == null)
				break;
			if (entry == DELETE)
				continue;
			if (entry.key.equals(key)) {
				data[count] =  (String)entry.key;
				index[count] = j;
				count++;		
				System.out.println("데이터 "+ entry.value + "데이터 테이블 index " + j);
				break;
			}
		}
		return "key not found"; // failure: key not found
	}

	public Object put(Object key, Object value) {

		int h = hash(key);
		int d = hash2(key);
		for (int i = 0; i < entries.length; i++) {
			int j = nextProbe(h, d, i);
			Entry entry = entries[j];
			if (entry == null) {
				entries[j] = new Entry(key, value);
				++size;

				return null;
			}
			if (entry == DELETE) {
				collision++;
				continue;
			}
			if (entry.key.equals(key)) {
				Object oldValue = entry.value;
				entries[j].value = value;
				return oldValue;
			}

			collision++;

		}
		return null;
	}

	public Object remove(Object key) {
		int h = hash(key);
		int d = hash2(key); // 이중해싱을 위한 hash2 설정
		for (int i = 0; i < entries.length; i++) {
			int j = nextProbe(h, d, i);
			Entry entry = entries[j];
			if (entry == null)
				break;
			if (entry == DELETE)
				continue;
			if (entry.key.equals(key)) {
				Object oldValue = entry.value;
				entries[j] = DELETE;
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

	private int hash2(Object key) {
		if (key == null)
			throw new IllegalArgumentException();
		return (1 + (key.hashCode() & 0x7FFFFFFF)) % 31;
	}

	private int nextProbe(int h, int d, int i) {
		return (h + d * i) % entries.length; // 이중해싱
	}
	
	public void print() {
		for (int i = 0; i < entries.length; i++) {
			if(entries[i] != null)
				System.out.println(entries[i].key);
			else
				System.out.println("null");

		}
	}
	public void wirteFile() {
		String fileName = "Double_output.txt";
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
			for (int i = 0; i < data.length; i++) {
				fw.write("데이터 : "+data[i]+" 테이블 인덱스 "+index[i]);
				fw.newLine();
				fw.flush();
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

}