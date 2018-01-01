package com.acme.iotthing.data

import groovy.transform.ToString


/**
 * POJO containing data
 */
@ToString
class Data {
    String deviceId
    Date createdAt = new Date()
    double value
}
