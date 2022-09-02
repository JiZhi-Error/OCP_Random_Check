package github.jizhi.retrofit2.converter.fastjson2;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * @author JiZhi
 * @version V1.0
 * @date 2022/9/2 12:18
 **/
public class FastJson2ConverterFactory extends Converter.Factory{

    public static FastJson2ConverterFactory create(){
        return new FastJson2ConverterFactory();
    }
    private FastJson2ConverterFactory() {
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new FastJson2ResponseBodyConverter<>(type);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new FastJson2RequestBodyConverter<>();
    }
}
