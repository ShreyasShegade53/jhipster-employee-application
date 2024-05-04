package com.mycompany.emp.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class AddressCriteriaTest {

    @Test
    void newAddressCriteriaHasAllFiltersNullTest() {
        var addressCriteria = new AddressCriteria();
        assertThat(addressCriteria).is(criteriaFiltersAre(filter -> filter == null));
    }

    @Test
    void addressCriteriaFluentMethodsCreatesFiltersTest() {
        var addressCriteria = new AddressCriteria();

        setAllFilters(addressCriteria);

        assertThat(addressCriteria).is(criteriaFiltersAre(filter -> filter != null));
    }

    @Test
    void addressCriteriaCopyCreatesNullFilterTest() {
        var addressCriteria = new AddressCriteria();
        var copy = addressCriteria.copy();

        assertThat(addressCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(filter -> filter == null)),
            criteria -> assertThat(criteria).isEqualTo(addressCriteria)
        );
    }

    @Test
    void addressCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var addressCriteria = new AddressCriteria();
        setAllFilters(addressCriteria);

        var copy = addressCriteria.copy();

        assertThat(addressCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(filter -> filter != null)),
            criteria -> assertThat(criteria).isEqualTo(addressCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var addressCriteria = new AddressCriteria();

        assertThat(addressCriteria).hasToString("AddressCriteria{}");
    }

    private static void setAllFilters(AddressCriteria addressCriteria) {
        addressCriteria.id();
        addressCriteria.line1();
        addressCriteria.line2();
        addressCriteria.country();
        addressCriteria.state();
        addressCriteria.city();
        addressCriteria.pincode();
        addressCriteria.employeeId();
        addressCriteria.distinct();
    }

    private static Condition<AddressCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getLine1()) &&
                condition.apply(criteria.getLine2()) &&
                condition.apply(criteria.getCountry()) &&
                condition.apply(criteria.getState()) &&
                condition.apply(criteria.getCity()) &&
                condition.apply(criteria.getPincode()) &&
                condition.apply(criteria.getEmployeeId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<AddressCriteria> copyFiltersAre(AddressCriteria copy, BiFunction<Object, Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getLine1(), copy.getLine1()) &&
                condition.apply(criteria.getLine2(), copy.getLine2()) &&
                condition.apply(criteria.getCountry(), copy.getCountry()) &&
                condition.apply(criteria.getState(), copy.getState()) &&
                condition.apply(criteria.getCity(), copy.getCity()) &&
                condition.apply(criteria.getPincode(), copy.getPincode()) &&
                condition.apply(criteria.getEmployeeId(), copy.getEmployeeId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
