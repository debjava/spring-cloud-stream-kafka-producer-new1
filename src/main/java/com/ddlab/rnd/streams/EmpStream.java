package com.ddlab.rnd.streams;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EmpStream {
    
    String OUTPUT = "emp-out";

    @Output(OUTPUT)
    MessageChannel outboundMessage();
}
