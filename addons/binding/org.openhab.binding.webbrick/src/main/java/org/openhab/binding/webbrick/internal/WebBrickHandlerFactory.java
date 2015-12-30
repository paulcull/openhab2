/**
 * Copyright (c) 2014 openHAB UG (haftungsbeschraenkt) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.webbrick.internal;

import static org.openhab.binding.webbrick.WebBrickBindingConstants.*;

import java.util.Set;

import org.eclipse.smarthome.core.thing.Bridge;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;
import org.openhab.binding.webbrick.handler.DimmerHandler;
import org.openhab.binding.webbrick.handler.IPBridgeHandler;
import org.openhab.binding.webbrick.handler.OccupancySensorHandler;
import org.openhab.binding.webbrick.handler.SwitchHandler;
import org.openhab.binding.webbrick.handler.TemperatureSensorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableSet;

/**
 * The {@link WebBrickHandlerFactory} is responsible for creating things and thing
 * handlers.
 *
 * @author paulcull - Initial contribution
 */
public class WebBrickHandlerFactory extends BaseThingHandlerFactory {

    private Logger logger = LoggerFactory.getLogger(WebBrickHandlerFactory.class);

    private final static Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = ImmutableSet.of(THING_TYPE_WEBBRICKBRIDGE,
            THING_TYPE_DIMMER, THING_TYPE_SWITCH, THING_TYPE_OCCUPANCYSENSOR, THING_TYPE_TEMPERATURE);

    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        return SUPPORTED_THING_TYPES_UIDS.contains(thingTypeUID);
    }

    @Override
    protected ThingHandler createHandler(Thing thing) {

        this.logger.info("...Starting WebBrickHandlerFactory...Thing Handler");

        ThingTypeUID thingTypeUID = thing.getThingTypeUID();

        if (thingTypeUID.equals(THING_TYPE_WEBBRICKBRIDGE)) {
            return new IPBridgeHandler((Bridge) thing);
        } else if (thingTypeUID.equals(THING_TYPE_DIMMER)) {
            return new DimmerHandler(thing);
        } else if (thingTypeUID.equals(THING_TYPE_SWITCH)) {
            return new SwitchHandler(thing);
        } else if (thingTypeUID.equals(THING_TYPE_TEMPERATURE)) {
            return new TemperatureSensorHandler(thing);
        } else if (thingTypeUID.equals(THING_TYPE_OCCUPANCYSENSOR)) {
            return new OccupancySensorHandler(thing);
        }

        return null;
    }
}
