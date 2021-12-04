// Jingxian Chai

public class Map<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int count;
    private int size;

    /**
     * constructor for Map class, initialize keys array, values array and count
     * @param length size of the map
     */
    public Map(int length) {
        
        if (length <= 0) {
            length = 1;
        }
        size = length;
        count = 0;
        keys = (Key[]) new Object[size];
        values = (Value[]) new Object[size];
    }

    /**
     * method that check if two given keys are equal
     * @param leftKey first key
     * @param rightKey second key
     * @return if both keys are equal return true else false
     */
    private boolean isEqual(Key leftKey, Key rightKey) {
        if (leftKey == null || rightKey == null) {
            return leftKey == rightKey;
        } else {
            return leftKey.equals(rightKey);
        }
    }

    /**
     * method that find the index of the given key in the key array
     * @param key given key
     * @return if the key exists in the key array return the index else -1 indicate the given key does not exists
     */
    private int getIndex(Key key) {
        for (int i=0; i<count; i++) {
            if (isEqual(keys[i], key)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * method that get the value of the given key
     * @param key given key
     * @return if the key exists in the map, return value else -1 indicate the given key does not exists in map
     */
    public Value get(Key key) {
        int index = getIndex(key);
        return index != -1 ? values[index] : null;
    }

    /**
     * method that find if the map contains the given key
     * @param key given
     * @return if key exists in map return true, else false
     */
    public boolean containsKey(Key key) {
        for (int i=0; i<count; i++) {
            if (isEqual(keys[i], key)) {
                return true;
            }
        } 
        return false;
    }

    /**
     * method that expands key array and value array by doubling the size
     */
    private void expand() {
        Key[] newKeys = (Key[]) new Object[size*2];
        Value[] newValues = (Value[]) new Object[size*2];
        size *= 2;
        System.arraycopy(keys, 0, newKeys, 0, keys.length);
        System.arraycopy(values, 0, newValues, 0, values.length);
        keys = newKeys;
        values = newValues;
    }

    /**
     * method that put the key and the value into map
     * @param key given key
     * @param value given value
     */
    public void put(Key key, Value value) {
        if (count >= size) expand();
        int index = getIndex(key);
        if (index != -1) {
            values[index] = value;
        } else{
            keys[count] = key;
            values[count] = value;
            count += 1;
        }
    }

    /**
     * method that return the current size of the map (size of key array and size of value array) that has element in it
     * @return count
     */
    public int size() {
        return count;
    }
}