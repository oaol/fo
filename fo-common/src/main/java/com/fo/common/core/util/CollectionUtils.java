package com.fo.common.core.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * Utility methods related to Collection
 * from org.assertj.core.util.Lists
 * @author bryce
 * @Date Mar 10, 2019
 */
public class CollectionUtils {

    /**
     * Creates a <em>mutable</em> {@link ArrayList} containing the given elements.
     * 
     * @param <T> the generic type of the {@code ArrayList} to create.
     * @param elements the elements to store in the {@code ArrayList}.
     * @return the created {@code ArrayList}, of {@code null} if the given array of elements is {@code null}.
     */
    @SafeVarargs
    public static <T> ArrayList<T> newArrayList(T... elements) {
      if (elements == null) {
        return null;
      }
      ArrayList<T> list = newArrayList();
      java.util.Collections.addAll(list, elements);
      return list;
    }

    /**
     * Creates a <em>mutable</em> {@link ArrayList} containing the given elements.
     * 
     * @param <T> the generic type of the {@code ArrayList} to create.
     * @param elements the elements to store in the {@code ArrayList}.
     * @return the created {@code ArrayList}, or {@code null} if the given {@code Iterable} is {@code null}.
     */
    public static <T> ArrayList<T> newArrayList(Iterable<? extends T> elements) {
      if (elements == null) {
        return null;
      }
      ArrayList<T> list = newArrayList();
      for (T e : elements) {
        list.add(e);
      }
      return list;
    }

    /**
     * Creates a <em>mutable</em> {@link ArrayList} containing the given elements.
     * 
     * @param <T> the generic type of the {@code ArrayList} to create.
     * @param elements the elements to store in the {@code ArrayList}.
     * @return the created {@code ArrayList}, or {@code null} if the given {@code Iterator} is {@code null}.
     */
    public static <T> ArrayList<T> newArrayList(Iterator<? extends T> elements) {
      if (elements == null) {
        return null;
      }
      ArrayList<T> list = newArrayList();
      while (elements.hasNext()) {
        list.add(elements.next());
      }
      return list;
    }

    /**
     * Creates a <em>mutable</em> {@link ArrayList}.
     * 
     * @param <T> the generic type of the {@code ArrayList} to create.
     * @return the created {@code ArrayList}, of {@code null} if the given array of elements is {@code null}.
     */
    public static <T> ArrayList<T> newArrayList() {
      return new ArrayList<>();
    }

    /**
     * @param <T> the generic type of the {@code List}.
     * @return an empty, <em>immutable</em> {@code List}.
     */
    public static <T> List<T> emptyList() {
      return Collections.emptyList();
    }

}
