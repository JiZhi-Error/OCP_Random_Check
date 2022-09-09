package github.jizhi.ocp.randomcheck.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class RandomList(
    @JsonProperty("title")
    var title: String = "",

    @JsonProperty("list")
    var list: ArrayList<Member> = ArrayList()
)

data class Member(
    @JsonProperty("qq")
    var qq: String = "",

    @JsonProperty("time")
    var time: Long = 0
)
