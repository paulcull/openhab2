/**
 * Copyright (c) 2014-2015 openHAB UG (haftungsbeschraenkt) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.webbrick.handler;

import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.ThingStatusDetail;
import org.eclipse.smarthome.core.types.Command;
import org.openhab.binding.webbrick.internal.protocol.WebBrickCommandType;

public class TemperatureSensorHandler extends WebBrickHandler {
    private static final Integer ACTION_TEMPLEVEL = 1;

    private int integrationId;

    public TemperatureSensorHandler(Thing thing) {
        super(thing);
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
    }

    @Override
    public void initialize() {
        Number id = (Number) getThing().getConfiguration().get("integrationId");

        if (id == null) {
            updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.CONFIGURATION_ERROR, "No integrationId");

            return;
        }

        this.integrationId = id.intValue();

        updateStatus(ThingStatus.ONLINE);
    }

    @Override
    public int getIntegrationId() {
        return this.integrationId;
    }

    @Override
    public void handleUpdate(WebBrickCommandType type, String... parameters) {

        if (type == WebBrickCommandType.DEVICE && parameters.length == 1 && ACTION_TEMPLEVEL.equals(parameters[0])) {
        }
    }

}
