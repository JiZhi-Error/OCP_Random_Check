package github.jizhi.retrofit2.converter.fastjson2;

import com.alibaba.fastjson2.JSON;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

import java.io.IOException;



/**
 * @author JiZhi
 * @version V1.0
 * @date 2022/9/2 12:17
 **/
final public class FastJson2RequestBodyConverter<T> implements Converter<T, RequestBody> {

    private static final MediaType MEDIA_TYPE = MediaType.get("application/json; charset=UTF-8");


    @Override
    public RequestBody convert(T value) throws IOException {
        byte[] bytes = JSON.toJSONBytes(value);
        return RequestBody.create(MEDIA_TYPE,bytes);
    }
}
