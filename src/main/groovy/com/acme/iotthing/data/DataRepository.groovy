package com.acme.iotthing.data

import org.springframework.data.mongodb.repository.MongoRepository


/**
 * Repository for data allowing to request data per device
 */
interface DataRepository extends MongoRepository<Data, String> {

    List<Data> findByDeviceId(String device)
}