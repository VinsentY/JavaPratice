package collection;
 
import java.util.LinkedList;
 
public class MyHashMap implements IHashMap {
    LinkedList<Entry>[] values = new LinkedList[2000];
 
    @Override
    public void put(String key, Object object) {
        // 拿到hashcode
        int hashcode = hashcode(key);
 
        // 找到对应的LinkedList
        LinkedList<Entry> list = values[hashcode];
        // 如果LinkedList是null，则创建一个LinkedList
        if (null == list) {
            list = new LinkedList<>();
            values[hashcode] = list;
        }
 
        // 判断该key是否已经有对应的键值对
        boolean found = false;
        for (Entry entry : list) {
            // 如果已经有了，则替换掉
            if (key.equals(entry.key)) {
                entry.value = object;
                found = true;
                break;
            }
        }
 
        // 如果没有已经存在的键值对，则创建新的键值对
        if (!found) {
            Entry entry = new Entry(key, object);
            list.add(entry);
        }
 
    }
 
    @Override
    public Object get(String key) {
        // 获取hashcode
        int hashcode = hashcode(key);
        // 找到hashcode对应的LinkedList
        LinkedList<Entry> list = values[hashcode];
        if (null == list)
            return null;
 
        Object result = null;
 
        // 挨个比较每个键值对的key，找到匹配的，返回其value
        for (Entry entry : list) {
            if (entry.key.equals(key)) {
                result = entry.value;
                break;
            }
        }
 
        return result;
 
    }
 
    private static int hashcode(String str) {
        // TODO Auto-generated method stub
        if (0 == str.length())
            return 0;
 
        int hashcode = 0;
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            hashcode += cs[i];
        }
        hashcode *= 23;
        // 取绝对值
        hashcode = hashcode < 0 ? 0 - hashcode : hashcode;
        // 落在0-1999之间
        hashcode %= 2000;
 
        return hashcode;
    }
 
    public static void main(String[] args) {
         MyHashMap map =new MyHashMap();
        //
        // map.put("t", "坦克");
        // map.put("adc", "物理");
        // map.put("apc", "魔法");
        // map.put("t", "坦克2");
        //
        // System.out.println(map.get("adc"));
        //
        // System.out.println(map);
         
         System.out.println(map.hashcode("name=hero-2387"));
         System.out.println(map.hashcode("name=hero-5555"));
 
    }
 
    public String toString() {
        LinkedList<Entry> result = new LinkedList();
 
        for (LinkedList<Entry> linkedList : values) {
            if (null == linkedList)
                continue;
            result.addAll(linkedList);
        }
        return result.toString();
    }
 
}