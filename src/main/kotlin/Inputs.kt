
// These funs are here as a place holder until I can get a IU working with user inputs

data class InputDataClass(
    val xmlPath : String,
    val tcpIP : String,
    val tcpPort : String
)

fun getXmlPath() : String {
    return "C:\\Test Folder\\current.xml\\"
}

fun getTcpData() : Pair<String, String> {
    return Pair(
        "Tcp IP Address ( default to 127.0.0.1 )",
        "Tcp Port ( default to 50000 )"
    )
}