package com.ddlab.rnd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.ddlab.rnd.entity.Employee;
import com.ddlab.rnd.streams.EmpStream;

@Service
public class PublisherService {

    @Autowired
    private EmpStream empStream;

    public void sendEmpInfo(final Employee emp) {

        MessageChannel messageChannel = empStream.outboundMessage();
        boolean sent = messageChannel.send(MessageBuilder.withPayload(emp)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());

        System.out.println("Message sent successfully ..."+sent);
    }

}
