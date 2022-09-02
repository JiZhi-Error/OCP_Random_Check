package github.jizhi.ocp.randomcheck.entity

data class ResultBean<T>(
    var data: T? = null,
    var retcode: Int = 0,
    var status: String? = null,
    var wording: String? = null
)
