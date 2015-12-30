/**
 * Copyright (c) 2014-2015 openHAB UG (haftungsbeschraenkt) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.webbrick.config;

/**
 * Configuration settings for an {@link org.openhab.binding.webbrick.handler.IPBridgeHandler}.
 *
 * @author paulcull - Initial contribution
 */
public class WebBrickBridgeConfig {
    private String ipAddress;

    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

}
