package com.acme.iotthing.device

import com.acme.iotthing.data.Data
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jms.core.JmsTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

/**
 * pseudo data generator (emulates a device)
 * sends data through JMS for demo purpose
 */
@Component
class Publisher {

    @Autowired
    JmsTemplate jmsTemplate

    @Scheduled(fixedDelay = 10000l)
    void publishMessage() {
        jmsTemplate.convertAndSend('deviceentry', new Data(
                                                                            deviceId: 'my device',
                                                                            value: Math.random()
                                                                        ))
    }
}
