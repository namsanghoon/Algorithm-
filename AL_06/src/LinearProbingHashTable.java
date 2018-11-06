
public class LinearProbingHashTable  {
	private Entry[] entries; // 키와 값을 가진 객체를 저장하는 배열
	private int size, used, collision = 0; 
	private float loadFactor; 
	private final Entry NIL = new Entry(null, null); // NIL 객체 생성

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

	public Object get(Object key) { // 키 값을 해쉬테이블에서 찾기 위한 메소드
		int h = hash(key); 
		for (int i = 0; i < entries.length; i++) {// 테이블에 들어갈 자리를 탐색
			int j = nextProbe(h, i); 
			Entry entry = entries[j]; // entry 객체를 배열에서 찾음
			if (entry == null) // 없으면 종료
				break;
			if (entry == NIL) // NIL을 만나면 계속 탐색
				continue;
			if (entry.key.equals(key)) // 같은 값을 찾으면 value를 출력
				return entry.value;
		}
		return null; 
	}

	public Object put(Object key, Object value) { // 키 값을 해쉬테이블에 넣는 메소드
		if (used > loadFactor * entries.length)
			rehash();
		int h = hash(key);
		for (int i = 0; i < entries.length; i++) {
			int j = nextProbe(h, i); // 테이블에 들어갈 자리를 탐색
			Entry entry = entries[j]; // 객체를 배열에서 가져와
			if (entry == null) { // 객체가 테이블에 없으면 삽입
				entries[j] = new Entry(key, value);
				++size;
				++used;
				return null; 
			}
			if (entry == NIL) { // NIL을 만나면 계속 탐색
				collision++;//충돌횟수 증가
				continue;
			}
			if (entry.key.equals(key)) { // 같은 값을 찾으면 갱신
				Object oldValue = entry.value;
				entries[j].value = value;
				return oldValue; 
			}

			collision++;//충돌횟수 증가

		}
		return null; 
	}

	public Object remove(Object key) { // 키 값을 해쉬테이블에서 제거하기 위한 함수
		int h = hash(key);
		for (int i = 0; i < entries.length; i++) {
			int j = nextProbe(h, i);
			Entry entry = entries[j];
			if (entry == null) // 테이블에 키 값이 없으면 종료
				break;
			if (entry == NIL) // NIL을 만나면 계속
				continue;
			if (entry.key.equals(key)) { // 같은 값을 찾으면 삭제
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

	private int nextProbe(int h, int i) { // 테이블에 넣을 위치를 찾기 위한 메소드
		return (h + i) % entries.length; 
	}

	private void rehash() { // 테이블 크기를 늘려주는 함수
		Entry[] oldEntries = entries;
		entries = new Entry[2 * oldEntries.length + 1]; // 테이블의 크기를 2배+1로 늘림
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
