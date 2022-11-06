package com.autumn.context.support;

import com.autumn.core.BusinessIdentity;
import com.autumn.core.Coordinate;
import com.autumn.core.Scenario;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * default {@link Coordinate} implements
 * @author momo
 * @since 2022/10/1 08:32
 */
public class AutumnCoordinate implements Coordinate {

    /**
     * scenario
     */
    private final Scenario scenario;
    /**
     * bizCode
     */
    private final BusinessIdentity businessIdentity;

    public AutumnCoordinate(Scenario scenario, BusinessIdentity businessIdentity) {
        this.scenario = scenario;
        this.businessIdentity = businessIdentity;
    }

    @Override
    public @NotNull Scenario getScenario() {
        return scenario;
    }

    @Override
    public @NotNull BusinessIdentity getBusinessIdentity() {
        return businessIdentity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutumnCoordinate that = (AutumnCoordinate) o;
        return Objects.equals(scenario, that.scenario) && Objects.equals(businessIdentity, that.businessIdentity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scenario, businessIdentity);
    }

    @Override
    public String toString() {
        return "AutumnCoordinate{" +
                "scenario=" + scenario.getCode() +
                ", businessIdentity=" + businessIdentity.getIdentity() +
                '}';
    }
}
