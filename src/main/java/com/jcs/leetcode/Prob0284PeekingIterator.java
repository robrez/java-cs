package com.jcs.leetcode;

import java.util.Iterator;

/**
 * Given an Iterator class interface with methods: next() and hasNext(), design
 * and implement a PeekingIterator that support the peek() operation -- it
 * essentially peek() at the element that will be returned by the next call to
 * next().
 *
 * Here is an example. Assume that the iterator is initialized to the beginning
 * of the list: [1, 2, 3].
 *
 * Call next() gets you 1, the first element in the list.
 *
 * Now you call peek() and it returns 2, the next element. Calling next() after
 * that still return 2.
 *
 * You call next() the final time and it returns 3, the last element. Calling
 * hasNext() after that should return false.
 *
 * @author rob
 */
public class Prob0284PeekingIterator {

    public static class PeekingIterator implements Iterator<Integer> {

        private final Iterator<Integer> it;
        private Integer peek;

        public PeekingIterator(Iterator<Integer> iterator) {
            this.it = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (peek == null) {
                peek = it.next();
            }
            return peek;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer result = peek;
            peek = null;
            if (result == null) {
                return it.next();
            }
            return result;
        }

        @Override
        public boolean hasNext() {
            if (peek == null) {
                return it.hasNext();
            }
            return true;
        }
    }
}
