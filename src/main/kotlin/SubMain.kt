import com.google.gson.Gson
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject


class SubMain {
    private val gson = Gson()

    // Converts ugly input xml to pretty Json
    private fun xmlToJson(xmlString: String): String {
        val xmlDoc = xmlStringToDoc(xmlString)
        val raceData = getRaceData(xmlDoc)
        val carDataList = getCarDataList(xmlDoc)
        val jsonMasterClass = getJsonMasterClass(raceData, carDataList)
        return gson.toJson(jsonMasterClass)
    }

    // Collects User Inputs into a data class
    private fun inputHandler() : InputDataClass {
        return InputDataClass(
            xmlPath = getXmlPath(),
            tcpIP = getTcpData().first,
            tcpPort = getTcpData().second
        )
    }

    fun startUp() {
        val api = ApiCall()
        val xmlSubject = PublishSubject.create<String>()

        xmlSubject
            .observeOn(Schedulers.computation())
            .map {
                inputHandler().xmlPath
            }.map { xmlString ->
                xmlToJson(xmlString)
            }.map { jsonMasterString ->
                api.postJson(jsonMasterString)
            }.doOnError {
                it.printStackTrace()
            }.retry()

    }
}

// next steps :
// Do I want to upload every X seconds or trigger on xml update? (is it worth the hassle to have a trigger?)
// Do I need more error safe-ing or is the xmlSubject.retry() good enough for the read/write errors?
// Build a basic UI to input xml File Path, Start/Stop of feed, Status visuals/messages
