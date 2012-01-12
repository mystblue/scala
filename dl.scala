import java.io.File
import java.net.URL

import org.apache.commons.io.FileUtils

object HelloWorld {
  def main(args: Array[String]) {
    FileUtils.copyURLToFile(new URL("http://www.google.co.jp"), new File("test.html"))
  }
}
