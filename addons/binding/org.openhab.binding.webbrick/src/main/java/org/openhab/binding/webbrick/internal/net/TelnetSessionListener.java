/**
 * Copyright (c) 2014 openHAB UG (haftungsbeschraenkt) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.webbrick.internal.net;

import java.io.IOException;

/**
 * Listener for telnet session events.
 *
 * @author paulcull - Initial contribution
 */
public interface TelnetSessionListener {

    void inputAvailable();

    void error(IOException exception);
}
