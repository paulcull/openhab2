/**
 * Copyright (c) 2014 openHAB UG (haftungsbeschraenkt) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.webbrick.handler;

import org.eclipse.smarthome.core.thing.Bridge;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.ThingStatusDetail;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.openhab.binding.webbrick.internal.protocol.WebBrickCommand;
import org.openhab.binding.webbrick.internal.protocol.WebBrickCommandType;
import org.openhab.binding.webbrick.internal.protocol.WebBrickOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link WebBrickHandler} is responsible for handling commands, which are
 * sent to one of the channels.
 *
 * @author paulcull - Initial contribution
 */
public abstract class WebBrickHandler extends BaseThingHandler {

    private Logger logger = LoggerFactory.getLogger(WebBrickHandler.class);

    public WebBrickHandler(Thing thing) {
        super(thing);
    }

    public abstract int getIntegrationId();

    public abstract void handleUpdate(WebBrickCommandType type, String... parameters);

    protected IPBridgeHandler getBridgeHandler() {
        Bridge bridge = getBridge();

        return bridge == null ? null : (IPBridgeHandler) bridge.getHandler();
    }

    private void sendCommand(WebBrickCommand command) {
        IPBridgeHandler bridgeHandler = getBridgeHandler();

        if (bridgeHandler == null) {
            this.logger.info("Not sending command, no bridge associated");
            updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.HANDLER_MISSING_ERROR, "No bridge associated");
        } else {
            bridgeHandler.sendCommand(command);
        }
    }

    protected void output(Object... parameters) {
        sendCommand(new WebBrickCommand(WebBrickOperation.EXECUTE, WebBrickCommandType.OUTPUT, getIntegrationId(),
                parameters));
    }

    protected void device(Object... parameters) {
        sendCommand(new WebBrickCommand(WebBrickOperation.EXECUTE, WebBrickCommandType.DEVICE, getIntegrationId(),
                parameters));
    }

    protected void queryOutput(Object... parameters) {
        sendCommand(new WebBrickCommand(WebBrickOperation.QUERY, WebBrickCommandType.OUTPUT, getIntegrationId(),
                parameters));
    }

    protected void queryDevice(Object... parameters) {
        sendCommand(new WebBrickCommand(WebBrickOperation.QUERY, WebBrickCommandType.DEVICE, getIntegrationId(),
                parameters));
    }

}
