package github.jizhi.retrofit2.converter.fastjson2;

import com.alibaba.fastjson2.JSON;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.Converter;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author JiZhi
 * @version V1.0
 * @date 2022/9/2 12:17
 **/
final public class FastJson2ResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Type type;


    public FastJson2ResponseBodyConverter(Type type) {
        this.type = type;
    }

    @Override
    public T convert(@NotNull ResponseBody value) throws IOException {
        try {
            return JSON.parseObject(value.charStream(), type);
        } finally {
            value.close();
        }
    }
}
