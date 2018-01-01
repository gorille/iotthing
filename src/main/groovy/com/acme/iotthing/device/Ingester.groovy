package com.acme.iotthing.device

import com.acme.iotthing.data.Data
import com.acme.iotthing.data.DataRepository
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

/**
 * business class responsible for ingesting the data inside the database
 */
@Component
@Slf4j
class Ingester {

    @Autowired
    private DataRepository repository

    /**
     * Listen to JMS channel to receive data and add to to repository
     * @param data
     */
    @JmsListener(destination='deviceentry')
    void ingestData(Data data) {
        log.info(data.toString())
        repository.save(data)
    }
}
