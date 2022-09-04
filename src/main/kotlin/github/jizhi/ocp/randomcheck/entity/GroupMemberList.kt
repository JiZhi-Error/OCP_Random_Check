package github.jizhi.ocp.randomcheck.entity

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author  JiZhi
 * @date  2022/8/30 13:58
 * @version  V1.0
 **/
data class GroupMemberList(
    @JsonProperty("age")
    var age: String? = null,

    @JsonProperty("area")
    var area: String? = null,

    @JsonProperty("card")
    var card: String? = null,

    @JsonProperty("card_changeable")
    var cardChangeable: Boolean? = null,

    @JsonProperty("group_id")
    var groupId: String? = null,

    @JsonProperty("join_time")
    var joinTime: String? = null,

    @JsonProperty("last_sent_time")
    var lastSentTime: String? = null,

    @JsonProperty("level")
    var level: String? = null,

    @JsonProperty("nickname")
    var nickname: String? = null,

    @JsonProperty("role")
    var role: String? = null,

    @JsonProperty("sex")
    var sex: String? = null,

    @JsonProperty("shut_up_timestamp")
    var shutUpTimestamp: String? = null,

    @JsonProperty("title")
    var title: String? = null,

    @JsonProperty("title_expire_time")
    var titleExpireTime: String? = null,

    @JsonProperty("unfriendly")
    var unfriendly: Boolean? = null,

    @JsonProperty("user_id")
    var userId: String? = null
)
