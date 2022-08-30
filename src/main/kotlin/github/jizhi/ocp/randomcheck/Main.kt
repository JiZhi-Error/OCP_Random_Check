import okhttp3.OkHttpClient
import okhttp3.Request

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    val build = Request.Builder().url("https://www.baidu.com").build()
    println(OkHttpClient.Builder().build().newCall(build).execute().body()!!.string())
}
