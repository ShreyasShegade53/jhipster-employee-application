package com.mycompany.emp.service;

import com.mycompany.emp.domain.*; // for static metamodels
import com.mycompany.emp.domain.Address;
import com.mycompany.emp.repository.AddressRepository;
import com.mycompany.emp.service.criteria.AddressCriteria;
import com.mycompany.emp.service.dto.AddressDTO;
import com.mycompany.emp.service.mapper.AddressMapper;
import jakarta.persistence.criteria.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Address} entities in the database.
 * The main input is a {@link AddressCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link Page} of {@link AddressDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class AddressQueryService extends QueryService<Address> {

    private final Logger log = LoggerFactory.getLogger(AddressQueryService.class);

    private final AddressRepository addressRepository;

    private final AddressMapper addressMapper;

    public AddressQueryService(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    /**
     * Return a {@link Page} of {@link AddressDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<AddressDTO> findByCriteria(AddressCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Address> specification = createSpecification(criteria);
        return addressRepository.findAll(specification, page).map(addressMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(AddressCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Address> specification = createSpecification(criteria);
        return addressRepository.count(specification);
    }

    /**
     * Function to convert {@link AddressCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Address> createSpecification(AddressCriteria criteria) {
        Specification<Address> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Address_.id));
            }
            if (criteria.getLine1() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLine1(), Address_.line1));
            }
            if (criteria.getLine2() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLine2(), Address_.line2));
            }
            if (criteria.getCountry() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCountry(), Address_.country));
            }
            if (criteria.getState() != null) {
                specification = specification.and(buildStringSpecification(criteria.getState(), Address_.state));
            }
            if (criteria.getCity() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCity(), Address_.city));
            }
            if (criteria.getPincode() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getPincode(), Address_.pincode));
            }
            if (criteria.getEmployeeId() != null) {
                specification = specification.and(
                    buildSpecification(criteria.getEmployeeId(), root -> root.join(Address_.employee, JoinType.LEFT).get(Employee_.id))
                );
            }
        }
        return specification;
    }
}
