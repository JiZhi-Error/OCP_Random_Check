package github.jizhi.ocp.randomcheck.entity

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author JiZhi
 * @version V1.0
 * @date 2021/11/26 15:21
 **/
data class GroupInfo(
    @JsonProperty("group_create_time")
    private var groupCreateTime: String? = null,

    @JsonProperty("group_id")
    private var groupId: String? = null,

    @JsonProperty("group_level")
    private var groupLevel: String? = null,

    @JsonProperty("group_memo")
    private var groupMemo: String? = null,

    @JsonProperty("group_name")
    private var groupName: String? = null,

    @JsonProperty("max_member_count")
    private var maxMemberCount: String? = null,

    @JsonProperty("member_count")
    private var memberCount: String? = null
)
