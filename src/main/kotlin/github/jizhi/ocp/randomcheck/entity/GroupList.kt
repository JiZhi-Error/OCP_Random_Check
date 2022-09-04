package github.jizhi.ocp.randomcheck.entity

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author  JiZhi
 * @date  2022/9/2 11:49
 * @version  V1.0
 **/
data class GroupList(
    @JsonProperty("group_create_time")
    var groupCreateTime: String? = null,

    @JsonProperty("group_id")
    var groupId: String? = null,

    @JsonProperty("group_level")
    var groupLevel: String? = null,

    @JsonProperty("group_name")
    var groupName: String? = null,

    @JsonProperty("max_member_count")
    var maxMemberCount: String? = null,

    @JsonProperty("member_count")
    var memberCount: String? = null,
)
