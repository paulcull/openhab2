/**
 * Copyright (c) 2014-2015 openHAB UG (haftungsbeschraenkt) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.webbrick.handler;

import static org.openhab.binding.webbrick.WebBrickBindingConstants.CHANNEL_OCCUPANCYSTATUS;

import org.eclipse.smarthome.core.library.types.OnOffType;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.ThingStatusDetail;
import org.eclipse.smarthome.core.types.Command;
import org.openhab.binding.webbrick.internal.protocol.WebBrickCommandType;

public class OccupancySensorHandler extends WebBrickHandler {
    private static final String OCCUPIED_STATE_UPDATE = "2";
    private static final String STATE_OCCUPIED = "3";
    private static final String STATE_UNOCCUPIED = "4";

    private int integrationId;

    public OccupancySensorHandler(Thing thing) {
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
        if (type == WebBrickCommandType.DEVICE && parameters.length == 2
                && OCCUPIED_STATE_UPDATE.equals(parameters[0])) {
            if (STATE_OCCUPIED.equals(parameters[1])) {
                updateState(CHANNEL_OCCUPANCYSTATUS, OnOffType.ON);
            } else if (STATE_UNOCCUPIED.equals(parameters[1])) {
                updateState(CHANNEL_OCCUPANCYSTATUS, OnOffType.OFF);
            }
        }
    }

}
