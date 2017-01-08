package uchidb;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class ContainersImpl<T, S> implements Containers<T, S> {

	private Map<S, T> storedMap;

	public ContainersImpl() {}
	@Override
	public Set<T> initSet(T[] tArray) {
		Set<T> ret = new HashSet<>();
		for (T t : tArray) {
			ret.add(t);
		}
		return ret;
	}
	@Override
	public List<T> initList(T[] tArray) {
		List<T> ret = new ArrayList<>();
		for (T t : tArray) {
			ret.add(t);
		}
		return ret;
	}
	@Override
	public Map<S, T> initEmptyMap() {
		return new HashMap<S, T>();
	}
	@Override
	public void storeMap(Map<S,T> mapToStoreInClass) {
		storedMap = new HashMap<>(mapToStoreInClass);
	}
	@Override
	public boolean addToMap(S key, T value, boolean overwriteExistingKey) {
		if (storedMap == null) return false;
		if (!overwriteExistingKey) {
			if (storedMap.containsKey(key)) {
				return false;
			}
		}
		storedMap.put(key, value);
		return true;
	}
	@Override
	public T getValueFromMap(S key) {
		return storedMap.get(key);
	}
	@Override
	public T getValueFromMap(S key, T defaultValue) {
		if (storedMap.containsKey(key)) {
			return getValueFromMap(key);
		}
		return defaultValue;
	}
}
	
