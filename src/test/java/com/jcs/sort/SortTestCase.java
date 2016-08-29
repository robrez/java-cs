package com.jcs.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;

/**
 * Re-usable test cases for sort algorithms
 *
 * @author rob
 * @param <T>
 */
public final class SortTestCase<T> {

    private final T[] input;
    private final T[] expect;

    private SortTestCase(T[] input, T[] expect) {
        this.input = input;
        this.expect = expect;
    }

    public static <T> SortTestCase<T> create(Class<T> clz, T[] input, T[] expected) {
        return new SortTestCase<>(input, expected);
    }

    public static SortTestCase<String> create(String input, String expected, String split) {
        return new SortTestCase<>(input.split(split), expected.split(split));
    }

    public static SortTestCase<String> create(String input, String expected) {
        return create(input, expected, ",");
    }

    public T[] getInput() {
        if (input == null) {
            return null;
        }
        return Arrays.copyOf(input, input.length);
    }

    public void assertArrayEquals(T[] items) {
        Assert.assertArrayEquals(items, expect);
    }

    public static List<SortTestCase<Integer>> integerSuite() {
        List<SortTestCase<Integer>> list = new ArrayList<>();
        list.add(SortTestCase.create(Integer.class,
                new Integer[]{20, null, 40, -20, 5, 10, 100, -100, null},
                new Integer[]{-100, -20, 5, 10, 20, 40, 100, null, null}));

        list.add(SortTestCase.create(Integer.class,
                new Integer[]{-10, -8, -6, -4, -3, -2, 0, 0, 2, 4, 6, 8},
                new Integer[]{-10, -8, -6, -4, -3, -2, 0, 0, 2, 4, 6, 8}));

        list.add(SortTestCase.create(Integer.class,
                new Integer[]{null, null, null, null},
                new Integer[]{null, null, null, null}));

        list.add(SortTestCase.create(Integer.class,
                new Integer[]{1, 10, null, 12, null, 4, 16, 20, 33, 5},
                new Integer[]{1, 4, 5, 10, 12, 16, 20, 33, null, null}));

        list.add(SortTestCase.create(Integer.class,
                new Integer[]{null, 5, null, null},
                new Integer[]{5, null, null, null}));

        list.add(SortTestCase.create(Integer.class,
                new Integer[]{1, 5, 1, 1, 6, 4},
                new Integer[]{1, 1, 1, 4, 5, 6}));

        return list;
    }

    public static List<SortTestCase<String>> stringSuite() {
        List<SortTestCase<String>> list = new ArrayList<>();
        list.add(SortTestCase.create(
                "e,k,t,o,f,d,b,s,x,h,u,v,z,j,y,p,a,r,c,w,l,q,g,i,n,m",
                "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z"));

        list.add(SortTestCase.create(
                "y,a,p,c,d,k,l,q,b,m,e,i,o,z,t,w,j,f,n,v,s,h,g,u,r,x",
                "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z"));

        list.add(SortTestCase.create(
                "t,w,h,d,r,m,b,a,c,s,x,u,y,z,l,j,p,n,g,e,f,k,v,i,q,o",
                "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z"));

        return list;
    }

}
