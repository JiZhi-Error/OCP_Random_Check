package github.jizhi.ocp.randomcheck

import com.fasterxml.jackson.module.kotlin.jsonMapper
import github.jizhi.ocp.randomcheck.entity.Member
import github.jizhi.ocp.randomcheck.entity.RandomList
import github.jizhi.ocp.randomcheck.service.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.io.File
import kotlin.random.Random
import kotlin.system.exitProcess

/**
 * @author JiZhi
 * @version V1.0
 * @date 2022/9/4 12:23
 */
object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        if (args.size < 6) {
            println("参数不对，重搞")
            exitProcess(-1)
        }

        val url = args[0]
        val authorize = args[1]
        val title = args[2]
        val groupNumber = args[3]
        val randomNum = args[4]
        val administratorName = args[5]
        val isDebug = args.size == 7

        val retrofit = Retrofit.Builder().client(OkHttpClient().newBuilder().addInterceptor {
            it.proceed(
                it.request().newBuilder().addHeader("Authorization", "Bearer $authorize").build()
            )
        }.build()).baseUrl("http://$url").addConverterFactory(JacksonConverterFactory.create()).build()

        val apiService = retrofit.create(ApiService::class.java)

        val whiteList = getWhiteList(title)
        whiteList.title = title
        // 去除过期的白名单
        val filter = whiteList.list.filter {
            if (it.time == -1L) {
                true
            } else {
                val now = System.currentTimeMillis()
                now - it.time <= 604800000L
            }
        }
//    whiteList.list = filter
        whiteList.list = filter as ArrayList<Member>

        val resultBeanCall = apiService.getGroupMemberList(groupNumber).execute()

        val resultBean = resultBeanCall.body()


        val whiteListQQ = filter.map { its -> its.qq }

        val memberLists = resultBean!!.data!!.filter {
            !whiteListQQ.contains(it.userId)
        }

        val randomNumbers = ArrayList<Int>()
        while (randomNumbers.size < randomNum.toInt()) {
            val nextInt = Random.nextInt(memberLists.size)
            if (randomNumbers.contains(nextInt)) {
                continue
            } else {
                randomNumbers.add(nextInt)
            }
        }

        val msg = StringBuilder()
        randomNumbers.forEach {
            val member = memberLists[it]
            val qq = member.userId!!
            whiteList.list.add(Member(qq, System.currentTimeMillis()))
            msg.append("[CQ:at,qq=")
            msg.append(qq)
            msg.append("] ")

        }
        msg.append(
            "\n${createRandomStr1(4)}今日份随机抽查${createRandomStr1(4)}以上小伙伴把${createRandomStr1(4)}查找手机界面截图发给 “${administratorName}” 哦${
                createRandomStr1(4)
            }，我${createRandomStr1(4)}只是工具人${createRandomStr1(4)}"
        )

        val group = apiService.sendMsg("group", "", groupNumber, msg.toString(), isDebug).execute()

        setWhiteList(whiteList)

        print(group)

    }


    fun getWhiteList(title: String): RandomList {
        val file = File(title)
        return if (file.exists()) {
            jsonMapper().readValue(file, RandomList::class.java)
        } else {
            RandomList()
        }
    }

    fun setWhiteList(randomList: RandomList) {
        val file = File(randomList.title)
        jsonMapper().writeValue(file, randomList)
    }


    /**
     * 1.生成的字符串每个位置都有可能是str中的一个字母或数字，需要导入的包是import java.util.Random;
     *
     * @param length
     * @return
     */
    fun createRandomStr1(length: Int): String {
        val str = "！@#￥%……&*!@#$%^&*().,~`-*/+abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        val random = java.util.Random()
        val stringBuffer = StringBuffer()
        for (i in 0 until length) {
            val number = random.nextInt(str.length)
            stringBuffer.append(str[number])
        }
        return stringBuffer.toString()
    }

}
