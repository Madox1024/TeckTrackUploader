import com.github.kittinunf.fuel.Fuel

// Currently the only use for this is posting to the API server
class ApiCall {
    fun postJson(json: String) {
        Fuel.post("http://localhost:7000/upload")
            .body(json)
    }
}