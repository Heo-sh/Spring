package context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class Context_4_fileupload {
	
	//root.xml에 적을 경우...길다
	//org.springframework.web.multipart.commons
	
	//객체를 만들고 WeblInitializer에 등록해야한다.
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding("utf-8");
		
		//최대 업로드 용량을 약 10mb로 지정
		multipartResolver.setMaxUploadSize(10485760); //1024 * 1024 * 10
		return multipartResolver;
	}
}
