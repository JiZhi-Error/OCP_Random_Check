package github.jizhi.ocp.randomcheck.service

import github.jizhi.ocp.randomcheck.entity.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    /**
     * 发送私聊消息
     *
     * @param userId     对方 QQ 号
     * @param groupId    主动发起临时会话群号(机器人本身必须是管理员/群主)
     * @param message    要发送的内容
     * @param autoEscape 消息内容是否作为纯文本发送 ( 即不解析 CQ 码 ) , 只在 message 字段是字符串时有效
     * @return /
     */
    @GET("send_private_msg")
    fun sendPrivateMsg(
        @Query("user_id") userId: String,
        @Query("group_id") groupId: String,
        @Query("message") message: String,
        @Query("auto_escape") autoEscape: Boolean = false
    ): Call<ResultBean<SendMsgResult>>


    /**
     * 发送消息
     *
     * @param messageType 消息类型, 支持 private、group , 分别对应私聊、群组, 如不传入, 则根据传入的 *_id 参数判断
     * @param userId      对方 QQ 号 ( 消息类型为 private 时需要 )
     * @param groupId     群号 ( 消息类型为 group 时需要 )
     * @param message     要发送的内容
     * @param autoEscape  消息内容是否作为纯文本发送 ( 即不解析 CQ 码 ) , 只在 message 字段是字符串时有效
     * @return /
     */
    @GET("send_msg")
    fun sendMsg(
        @Query("message_type") messageType: String,
        @Query("user_id") userId: String,
        @Query("group_id") groupId: String,
        @Query("message") message: String,
        @Query("auto_escape") autoEscape: Boolean = true
    ): Call<ResultBean<SendMsgResult>>

    /**
     * 获取群成员列表
     *
     * @param groupId 群号
     * @return /
     */
    @GET("get_group_member_list")
    fun getGroupMemberList(@Query("group_id") groupId: String): Call<ResultBean<List<GroupMemberList>>>


    /**
     * 获取群列表
     *
     * @return /
     */
    @GET("get_group_list")
    fun getGroupList(): Call<ResultBean<List<GroupList>>>


    /**
     * 获取群信息
     *
     * @param groupId 群号
     * @param noCache 是否不使用缓存（使用缓存可能更新不及时, 但响应更快）
     * @return /
     */
    @GET("get_group_info")
    fun getGroupInfo(
        @Query("group_id") groupId: String,
        @Query("no_cache") noCache: Boolean = false
    ): Call<ResultBean<GroupInfo>>

}
