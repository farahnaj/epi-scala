val list = List("an", "apple", "apple")

val map = collection.mutable.HashMap[String, Int]()
list.map(word => map.put(word, map.get(word).getOrElse(0) + 1))
map

list.count("apple")