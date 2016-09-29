/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.sun.xml.internal.ws.spi.db;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the Setter of a bean property.
 * @author shih-chang.chen@oracle.com
 * @exclude
 */
public abstract class PropertySetterBase implements PropertySetter {
    protected Class type;

    public Class getType() {
        return type;
    }

    static public boolean setterPattern(java.lang.reflect.Method method) {
        return (method.getName().startsWith("set") &&
                method.getName().length() > 3 &&
                method.getReturnType().equals(void.class) &&
                method.getParameterTypes() != null &&
                method.getParameterTypes().length == 1);
    }

    /**
     * Uninitialized map keyed by their classes.
     */
    private static final Map<Class, Object> uninitializedValues = new HashMap<Class, Object>();
    static {
        uninitializedValues.put(byte.class, Byte.valueOf((byte) 0));
        uninitializedValues.put(boolean.class, false);
        uninitializedValues.put(char.class, Character.valueOf((char) 0));
        uninitializedValues.put(float.class, Float.valueOf(0));
        uninitializedValues.put(double.class, Double.valueOf(0));
        uninitializedValues.put(int.class, Integer.valueOf(0));
        uninitializedValues.put(long.class, Long.valueOf(0));
        uninitializedValues.put(short.class, Short.valueOf((short) 0));
    }
    static protected Object uninitializedValue(Class cls) { return uninitializedValues.get(cls); }
}
