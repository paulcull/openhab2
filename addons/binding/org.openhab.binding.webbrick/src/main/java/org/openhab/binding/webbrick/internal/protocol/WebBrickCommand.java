/**
 * Copyright (c) 2014-2015 openHAB UG (haftungsbeschraenkt) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.webbrick.internal.protocol;

/**
 * Command to a WebBrick access point.
 *
 * @author paulcull - Initial contribution
 *
 */
public class WebBrickCommand {
    private final WebBrickOperation operation;
    private final WebBrickCommandType type;
    private final int integrationId;
    private final Object[] parameters;

    public WebBrickCommand(WebBrickOperation operation, WebBrickCommandType type, int integrationId,
            Object... parameters) {
        this.operation = operation;
        this.type = type;
        this.integrationId = integrationId;
        this.parameters = parameters;
    }

    public WebBrickCommandType getType() {
        return this.type;
    }

    public int getIntegrationId() {
        return this.integrationId;
    }

    public Object[] getParameters() {
        return this.parameters;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder().append(this.operation).append(this.type);

        if (integrationId >= 0) {
            builder.append(',').append(this.integrationId);
        }

        if (parameters != null) {
            for (Object parameter : parameters) {
                builder.append(',').append(parameter);
            }
        }

        return builder.toString();
    }
}
