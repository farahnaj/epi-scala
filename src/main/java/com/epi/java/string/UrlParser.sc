val delimiter: Char = '/'
val remover: String = ".."
val protocolSplit = "://"

def removeNotNeededPaths(url: String): String = {
  val stack = new java.util.Stack[String]()
  val ps = splitProtocol(url).toArray
  val protocol = ps.apply(0)
  val path = ps.apply(1).split(delimiter).toList

  path.foreach(s => {
    if(!stack.empty && s.equals(remover)) {
      stack.pop()
    } else {
      stack.push(s + "/")
    }
  })
  returnFinalPath(protocol, stack)
}

def splitProtocol(url: String): List[String] = {
  url.split(protocolSplit).toList
}

def returnFinalPath(protocol: String, stack: java.util.Stack[String]): String = {
  val sb = new StringBuilder
  stack.forEach(s => sb.append(s))
  protocol + protocolSplit + sb.toString()
}

val url = "http://abc/fox/../nbc/"
val expected = "http://abc/nbc/"
val actual = removeNotNeededPaths(url)

val url2 = "http://abc/fox/../../nbc/"
val expected2 = "http://nbc/"
val actual2 = removeNotNeededPaths(url2)

val url3 = "http://abc/fox/../../nbc/.."
val expected3 = "http://"
val actual3 = removeNotNeededPaths(url3)











