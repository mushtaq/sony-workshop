import data.AliceData

val words = AliceData.bookText.split("""[\s|:|.|,|"]+""").map(_.toLowerCase)

val stopWords = AliceData.stopWordText.split("\\s+").map(_.toLowerCase).toSet
