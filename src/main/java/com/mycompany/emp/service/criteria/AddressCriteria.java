package com.mycompany.emp.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.mycompany.emp.domain.Address} entity. This class is used
 * in {@link com.mycompany.emp.web.rest.AddressResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /addresses?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class AddressCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter line1;

    private StringFilter line2;

    private StringFilter country;

    private StringFilter state;

    private StringFilter city;

    private IntegerFilter pincode;

    private LongFilter employeeId;

    private Boolean distinct;

    public AddressCriteria() {}

    public AddressCriteria(AddressCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.line1 = other.optionalLine1().map(StringFilter::copy).orElse(null);
        this.line2 = other.optionalLine2().map(StringFilter::copy).orElse(null);
        this.country = other.optionalCountry().map(StringFilter::copy).orElse(null);
        this.state = other.optionalState().map(StringFilter::copy).orElse(null);
        this.city = other.optionalCity().map(StringFilter::copy).orElse(null);
        this.pincode = other.optionalPincode().map(IntegerFilter::copy).orElse(null);
        this.employeeId = other.optionalEmployeeId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public AddressCriteria copy() {
        return new AddressCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public Optional<LongFilter> optionalId() {
        return Optional.ofNullable(id);
    }

    public LongFilter id() {
        if (id == null) {
            setId(new LongFilter());
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getLine1() {
        return line1;
    }

    public Optional<StringFilter> optionalLine1() {
        return Optional.ofNullable(line1);
    }

    public StringFilter line1() {
        if (line1 == null) {
            setLine1(new StringFilter());
        }
        return line1;
    }

    public void setLine1(StringFilter line1) {
        this.line1 = line1;
    }

    public StringFilter getLine2() {
        return line2;
    }

    public Optional<StringFilter> optionalLine2() {
        return Optional.ofNullable(line2);
    }

    public StringFilter line2() {
        if (line2 == null) {
            setLine2(new StringFilter());
        }
        return line2;
    }

    public void setLine2(StringFilter line2) {
        this.line2 = line2;
    }

    public StringFilter getCountry() {
        return country;
    }

    public Optional<StringFilter> optionalCountry() {
        return Optional.ofNullable(country);
    }

    public StringFilter country() {
        if (country == null) {
            setCountry(new StringFilter());
        }
        return country;
    }

    public void setCountry(StringFilter country) {
        this.country = country;
    }

    public StringFilter getState() {
        return state;
    }

    public Optional<StringFilter> optionalState() {
        return Optional.ofNullable(state);
    }

    public StringFilter state() {
        if (state == null) {
            setState(new StringFilter());
        }
        return state;
    }

    public void setState(StringFilter state) {
        this.state = state;
    }

    public StringFilter getCity() {
        return city;
    }

    public Optional<StringFilter> optionalCity() {
        return Optional.ofNullable(city);
    }

    public StringFilter city() {
        if (city == null) {
            setCity(new StringFilter());
        }
        return city;
    }

    public void setCity(StringFilter city) {
        this.city = city;
    }

    public IntegerFilter getPincode() {
        return pincode;
    }

    public Optional<IntegerFilter> optionalPincode() {
        return Optional.ofNullable(pincode);
    }

    public IntegerFilter pincode() {
        if (pincode == null) {
            setPincode(new IntegerFilter());
        }
        return pincode;
    }

    public void setPincode(IntegerFilter pincode) {
        this.pincode = pincode;
    }

    public LongFilter getEmployeeId() {
        return employeeId;
    }

    public Optional<LongFilter> optionalEmployeeId() {
        return Optional.ofNullable(employeeId);
    }

    public LongFilter employeeId() {
        if (employeeId == null) {
            setEmployeeId(new LongFilter());
        }
        return employeeId;
    }

    public void setEmployeeId(LongFilter employeeId) {
        this.employeeId = employeeId;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public Optional<Boolean> optionalDistinct() {
        return Optional.ofNullable(distinct);
    }

    public Boolean distinct() {
        if (distinct == null) {
            setDistinct(true);
        }
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final AddressCriteria that = (AddressCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(line1, that.line1) &&
            Objects.equals(line2, that.line2) &&
            Objects.equals(country, that.country) &&
            Objects.equals(state, that.state) &&
            Objects.equals(city, that.city) &&
            Objects.equals(pincode, that.pincode) &&
            Objects.equals(employeeId, that.employeeId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, line1, line2, country, state, city, pincode, employeeId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AddressCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalLine1().map(f -> "line1=" + f + ", ").orElse("") +
            optionalLine2().map(f -> "line2=" + f + ", ").orElse("") +
            optionalCountry().map(f -> "country=" + f + ", ").orElse("") +
            optionalState().map(f -> "state=" + f + ", ").orElse("") +
            optionalCity().map(f -> "city=" + f + ", ").orElse("") +
            optionalPincode().map(f -> "pincode=" + f + ", ").orElse("") +
            optionalEmployeeId().map(f -> "employeeId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
