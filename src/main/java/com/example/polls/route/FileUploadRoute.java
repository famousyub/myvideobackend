package com.example.polls.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileUploadRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("sql:select * from video where is_write = false order by created_date?onConsume=update video set is_write = true where id = :#id")
                .log("${body}")
                .to("bean:converterVideoExecute?method=generateThumbnail")
                .to("bean:converterVideoExecute?method=scaleVideo");
    }
}
