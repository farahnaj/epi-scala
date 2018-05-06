//package com.epi.java;
//
//public class RetainBestCache<K, T extends Rankable> {
//
//
//  DataSource<K,T> ds = null;
//  int cacheSize;
//  /* Constructor with a data source (assumed to be slow) and a cache size */
//  public RetainBestCache(DataSource<K,T> ds, int entriesToRetain) {
//    // Implementation here
//    ds = ds;
//    cacheSize = entriesToRetain;
//  }
//
//    /* Gets some data. If possible, retrieves it from cache to be fast. If the data is not cached,
//     * retrieves it from the data source. If the cache is full, attempt to cache the returned data,
//     * evicting the T with lowest rank among the ones that it has available
//     * If there is a tie, the cache may choose any T with lowest rank to evict.
//     */
//
//  private Map<K,T> map = new Hashmap<K,T>();
//  private Set<Holder> treeSet = new TreeSet<Holder>() Ordering.Holder;
//
//  public T get(K key) {
//    // Implementation here
//    if(map.get(key) == null && map.size < cacheSize) {
//      map.put(key, ds.get(key));
//      Holder holder = new Holder(key, map.get(key));
//      treeSet.put(holder);
//    } else if(map.get(key) == null && map.size == cacheSize){
//      Holder smallestHolder = treeSet.first();
//      map.remove(smallestHolder.getKey);
//      map.put(key, ds.get(key));
//    }
//    else {
//      map.get(key);
//    }
//
//
//  }
//
//  public class Holder(K key, V value) {
//
//    compare(Holder holder) {
//
//      if(holder.getValue == this.getValue){
//
//        0
//      }else if(holder.getValue > this.getValue {
//        1
//
//      } else {
//
//        -1
//      }
//    }
//  }
//}
//
///*
// * For reference, here are the Rankable and DataSource interfaces.
// * You do not need to implement them, and should not make assumptions
// * about their implementations.
// */
//
//public interface Rankable {
//  /**
//   * Returns the Rank of this object, using some algorithm and potentially
//   * the internal state of the Rankable.
//   */
//  long getRank();
//}
//
//public interface DataSource<K, T extends Rankable> {
//  T get (K key);
//}
