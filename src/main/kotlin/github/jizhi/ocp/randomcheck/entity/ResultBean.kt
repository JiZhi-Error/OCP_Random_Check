package github.jizhi.ocp.randomcheck.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class ResultBean<T>(
    @JsonProperty("data")
    var `data`: T? = null,

    @JsonProperty("retcode")
    var retcode: Int = 0,

    @JsonProperty("status")
    var status: String? = null,

    @JsonProperty("wording")
    var wording: String? = null
)
