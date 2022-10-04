package com.autumn.core;

import org.jetbrains.annotations.NotNull;

/**
 * 'coordinate' use scenario and business identity determine <br/>
 * like 'X' and 'Y' in math <br/>
 *
 * implements must be override {@link Object#hashCode()} and {@link Object#equals(Object)} <br/>
 *
 * you can use {@link Coordinate#equals(Object)} compare coordinate
 *
 * @author momo
 * @since 2022/9/19 22:08
 */
public interface Coordinate {

    /**
     * scenario may be is {@link Enum} implements {@link Scenario}
     * @see Scenario
     * @return scenario
     */
    @NotNull
    Scenario getScenario();

    /**
     * business identity
     * @see BusinessIdentity
     * @return businessIdentity
     */
    @NotNull
    BusinessIdentity getBusinessIdentity();
}
