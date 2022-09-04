package github.jizhi.ocp.randomcheck.entity

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author  JiZhi
 * @date  2022/9/2 11:51
 * @version  V1.0
 **/
data class SendMsgResult(
    @JsonProperty("message_id")
    private var messageId: String? = null
)
