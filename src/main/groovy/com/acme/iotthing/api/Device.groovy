package com.acme.iotthing.api

import com.acme.iotthing.data.Data
import com.acme.iotthing.data.DataRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class Device {

    @Autowired
    DataRepository dataRepository

    /**
     * get a list of device data for a particular device
     * @param device
     * @return
     */
    @RequestMapping(path = '/device', method = RequestMethod.GET)
    List<Data> deviceData( @RequestParam(name="device", required = true) String device) {
        dataRepository.findByDeviceId(device)
    }
}
