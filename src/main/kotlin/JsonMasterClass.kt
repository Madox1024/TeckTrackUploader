data class JsonMasterClass(
    // All Race Data Contained Below for conversion into json via gson.toJson
    val eventName: String,
    val groupName: String,
    val runName: String,
    val trackName: String,
    val runType: String,
    val bestLapBy: String,
    val bestOverallLapTime: String,
    val flagStatus: String,
    val leader: String,
    val trackLength: Int,
    val leaderDiff: Int, // Number of laps leader is ahead of 2nd place
    val laps: Int,
    val raceTime: Int,
    val timeOfDay: Int,
    val carDataList: List<CarData> // list of active cars in race
)

// Organizes all race data to a Json meant to be read by the leader board webpage Javascript
fun getJsonMasterClass(raceData : RaceData, carDataList : List<CarData>) : JsonMasterClass {
    return JsonMasterClass(
        eventName = raceData.eventName,
        groupName = raceData.groupName,
        runName = raceData.runName,
        trackName = raceData.trackName,
        runType = raceData.runType,
        bestLapBy = raceData.bestLapBy,
        bestOverallLapTime = raceData.bestOverallLapTime,
        flagStatus = raceData.flagStatus,
        leader = raceData.leader,
        trackLength = raceData.trackLength,
        leaderDiff = raceData.leaderDiff,
        laps = raceData.laps,
        raceTime = raceData.raceTime,
        timeOfDay = raceData.timeOfDay,
        carDataList = carDataList
    )
}