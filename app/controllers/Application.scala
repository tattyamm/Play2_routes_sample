package daemon

import org.apache.commons.daemon.Daemon
import org.apache.commons.daemon.DaemonContext
import play.core.server.NettyServer
import play.core.StaticApplication
import java.io.File

class Application extends Daemon {

  var nettyServer: NettyServer = _
  var applicationPath: File = _

  override def init(dc: DaemonContext) {
    // DaemonContextのargumentsからパラメータを受け取ればよい。commons-cliを使ってもよいね。
    applicationPath = new File(dc.getArguments()(0))
  }

  override def start {
    // NettyServerに渡しているパラメータはもっとかっこ良くできるけど、とりあえず版
    nettyServer = new NettyServer(
      new StaticApplication(applicationPath),
      Option(System.getProperty("http.port")).map(Integer.parseInt(_)).getOrElse(9000),
      Option(System.getProperty("http.address")).getOrElse("0.0.0.0"))
  }

  override def stop {
    if (nettyServer != null) nettyServer.stop()
  }

  override def destroy {
    nettyServer = null
  }

}