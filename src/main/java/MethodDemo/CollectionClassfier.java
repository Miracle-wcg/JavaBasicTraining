package MethodDemo;

import java.util.*;

/**
 * @author chengangw
 * @date 11/11/2016 4:21 PM
 */
public class CollectionClassfier {
    public static String classify(Set<?> s) {
        return "Set";
    }

    public static String classify(List<?> list) {
        return "List";
    }

    public static String classify(Collection<?> c) {
        return c instanceof Set ? "Set" : c instanceof List ? "List" : "Unknown Collection";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {new HashSet<String>(), new ArrayList<Integer>(), new HashMap<String, String>().values()};
        for (Collection<?> c : collections) {
            System.out.println(classify(c));
        }
    }
}
