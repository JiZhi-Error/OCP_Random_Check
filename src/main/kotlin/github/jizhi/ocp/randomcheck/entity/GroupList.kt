package github.jizhi.ocp.randomcheck.entity

/**
 * @author  JiZhi
 * @date  2022/9/2 11:49
 * @version  V1.0
 **/
data class GroupList(
//    @JSONField(name = "group_create_time")
    private var groupCreateTime: String? = null,

//    @JSONField(name = "group_id")
    private val groupId: String? = null,
//
//    @JSONField(name = "group_level")
    private val groupLevel: String? = null,

//    @JSONField(name = "group_memo")
    private val groupMemo: String? = null,

//    @JSONField(name = "group_name")
    private val groupName: String? = null,

//    @JSONField(name = "max_member_count")
    private val maxMemberCount: String? = null,

//    @JSONField(name = "member_count")
    private val memberCount: String? = null
)
