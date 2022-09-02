package github.jizhi.ocp.randomcheck.entity

import com.alibaba.fastjson2.annotation.JSONField

/**
 * @author  JiZhi
 * @date  2022/9/2 11:51
 * @version  V1.0
 **/
data class SendMsgResult (
    @JSONField(name = "message_id")
    private var messageId: String? = null
)
