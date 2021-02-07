fun main() {
    try {
        SubMain().startUp()
    } catch (
        e: Exception
    ) {
        println("Fatal Error Occurred")
        e.printStackTrace()
    }
}