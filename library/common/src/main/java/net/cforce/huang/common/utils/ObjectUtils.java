package net.cforce.huang.common.utils;

/**
 *
 * Created by huang on 2016/9/23.
 */

public class ObjectUtils {

    private ObjectUtils(){
        throw new AssertionError();
    }

    /**
     * 比较两个object是否相等
     * @param actual
     * @param expected
     * @return
     *      <ul>
     *         <li>如果两个都是null，返回true</li>
     *         <li>return actual.{@link Object#equals(Object)}</li>
     *      </ul>
     */
    public static boolean isEquals(Object actual, Object expected) {
        return actual == expected || (actual == null ? expected == null : actual.equals(expected));
    }

    public static <V> int compare(V v1, V v2) {
        return v1 == null ? (v2 == null ? 0 : -1) : (v2 == null ? 1 : ((Comparable)v1).compareTo(v2));
    }
}
