import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.Socket

// this fun is intended to listen to a TCP stream, does nothing right now
class TcpHandler() {
    private val socket = Socket("127.0.0.1", 50000)
    val tcpText = BufferedReader(InputStreamReader(socket.getInputStream())).readLine()

}