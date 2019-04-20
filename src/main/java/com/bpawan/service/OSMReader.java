package com.bpawan.service;

import org.openstreetmap.osmosis.core.container.v0_6.*;
import org.openstreetmap.osmosis.core.domain.v0_6.Tag;
import org.openstreetmap.osmosis.core.domain.v0_6.Way;
import org.openstreetmap.osmosis.core.task.v0_6.Sink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OSMReader implements Sink {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void process(EntityContainer entityContainer) {

        if (entityContainer instanceof NodeContainer) {
        } else if (entityContainer instanceof WayContainer) {
            Way myWay = ((WayContainer) entityContainer).getEntity();
            myWay.getMetaTags().forEach((s, o) -> {
                log.info("key: " + s);
                log.info("obj: " + o);
            });
            for (Tag myTag : myWay.getTags()) {
                if ("highway".equalsIgnoreCase(myTag.getKey())) {
                    //log.info("highway id: " + myWay.getId());
                    //log.info("highway value: " + myTag.getValue());
                    break;
                }
            }
        } else if (entityContainer instanceof RelationContainer) {
        } else if (entityContainer instanceof BoundContainer){
            var boundContainer = (BoundContainer) entityContainer;
            var bound = boundContainer.getEntity();

            log.info(bound.toString());


        } else {
            log.info("recieved: " + entityContainer.getClass());
            log.info("Unknown Entity!");
        }
    }

    @Override
    public void initialize(Map<String, Object> map) {
        log.info("initialized with: ");
        map.forEach((s, o) -> {
            log.info("key: " + s);
            log.info("value" + 0);
        });
    }

    @Override
    public void complete() {

    }

    @Override
    public void close() {

    }
}
