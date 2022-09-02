package github.jizhi.ocp.randomcheck.entity

import com.alibaba.fastjson2.annotation.JSONField

/**
 * @author  JiZhi
 * @date  2022/8/30 13:58
 * @version  V1.0
 **/
data class GroupMemberList(
    var age: String? = null,

    val area: String? = null,

    val card: String? = null,

    @JSONField(name = "card_changeable")
    val cardChangeable: Boolean? = null,

    @JSONField(name = "group_id")
    val groupId: String? = null,

    @JSONField(name = "join_time")
    val joinTime: String? = null,

    @JSONField(name = "last_sent_time")
    val lastSentTime: String? = null,

    val level: String? = null,

    val nickname: String? = null,

    val role: String? = null,

    val sex: String? = null,

    @JSONField(name = "shut_up_timestamp")
    val shutUpTimestamp: String? = null,

    val title: String? = null,

    @JSONField(name = "title_expire_time")
    val titleExpireTime: String? = null,

    val unfriendly: Boolean? = null,

    @JSONField(name = "user_id")
    val userId: String? = null
)
