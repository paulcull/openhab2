/**
 * Copyright (c) 2014 openHAB UG (haftungsbeschraenkt) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.webbrick;

import org.eclipse.smarthome.core.thing.ThingTypeUID;

/**
 * The {@link WebBrickBinding} class defines common constants, which are
 * used across the whole binding.
 *
 * @author paulcull - Initial contribution
 */
public class WebBrickBindingConstants {

    public static final String BINDING_ID = "webbrick";

    // Bridge Type UIDs
    public final static ThingTypeUID THING_TYPE_WEBBRICKBRIDGE = new ThingTypeUID(BINDING_ID, "webbrickbridge");

    // List of all Thing Type UIDs
    public final static ThingTypeUID THING_TYPE_DIMMER = new ThingTypeUID(BINDING_ID, "dimmer");
    public final static ThingTypeUID THING_TYPE_SWITCH = new ThingTypeUID(BINDING_ID, "switch");
    public final static ThingTypeUID THING_TYPE_OCCUPANCYSENSOR = new ThingTypeUID(BINDING_ID, "occupancysensor");
    public final static ThingTypeUID THING_TYPE_TEMPERATURE = new ThingTypeUID(BINDING_ID, "temperature");

    // List of all Channel ids
    public final static String CHANNEL_LIGHTLEVEL = "lightlevel";
    public final static String CHANNEL_SWITCH = "switchstatus";
    public final static String CHANNEL_OCCUPANCYSTATUS = "occupancystatus";
    public final static String CHANNEL_TEMPERATURE = "temperature";

}
