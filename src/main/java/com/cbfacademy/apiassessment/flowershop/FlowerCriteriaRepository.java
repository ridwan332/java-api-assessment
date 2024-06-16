package com.cbfacademy.apiassessment.flowershop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class FlowerCriteriaRepository {

  private final EntityManager entityManager;
  
  private final CriteriaBuilder criteriaBuilder;

  /*im generating constractor on for the EntityManager becouse im going to inject it later and also intialise the criteraiabuilder */

  public FlowerCriteriaRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
    this.criteriaBuilder = entityManager.getCriteriaBuilder();
  }

  public Page<FlowerShop>finAllWithfilters(FlowerPage flowerPage, FlowerSearchCriteria flowerSearchCriteria){
    CriteriaQuery<FlowerShop> criteriaQuery = criteriaBuilder.createQuery(FlowerShop.class);
    Root<FlowerShop> flowerRoot = criteriaQuery.from(FlowerShop.class);

    Predicate predicate = getPredicate(flowerSearchCriteria,flowerRoot);
    criteriaQuery.where(predicate);
    setOrder(flowerPage,criteriaQuery,flowerRoot);

    TypedQuery<FlowerShop> typedQuery = entityManager.createQuery(criteriaQuery);
    typedQuery.setFirstResult(flowerPage.getPageNumber() * flowerPage.getPageSize());
    typedQuery.setMaxResults(flowerPage.getPageSize());
    Pageable pageable = getPageable(flowerPage);

    Long flowerCount = getFlowersCount(predicate);

    return new PageImpl<>(typedQuery.getResultList(), pageable, flowerCount);
  }

  


  private Predicate getPredicate(FlowerSearchCriteria flowerSearchCriteria, Root<FlowerShop> flowerRoot) {
    List<Predicate> predicates = new ArrayList<>();

    if(Objects.nonNull(flowerSearchCriteria.getName())){
      predicates.add(criteriaBuilder.like(flowerRoot.get("name"),"%" + flowerSearchCriteria.getName() + "%"));
    }
    if(Objects.nonNull(flowerSearchCriteria.getType())){
      predicates.add(criteriaBuilder.like(flowerRoot.get("type"),"%" + flowerSearchCriteria.getType() + "%"));
  }
  return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
}
private void setOrder(FlowerPage flowerPage, CriteriaQuery<FlowerShop> criteriaQuery, Root<FlowerShop> flowerRoot) {
  if(flowerPage.getSortDirection().equals(Sort.Direction.ASC)){
    criteriaQuery.orderBy(criteriaBuilder.asc(flowerRoot.get(flowerPage.getSortBy())));
  }else{
    criteriaQuery.orderBy(criteriaBuilder.desc(flowerRoot.get(flowerPage.getSortBy())));
  }
}

private Pageable getPageable(FlowerPage flowerPage) {
  Sort sort = Sort.by(flowerPage.getSortDirection() ,flowerPage.getSortBy());
  return PageRequest.of(flowerPage.getPageNumber(),flowerPage.getPageSize(),sort);
}
private Long getFlowersCount(Predicate predicate) {
  CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
  Root<FlowerShop> countRoot = countQuery.from(FlowerShop.class);
  countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
  return entityManager.createQuery(countQuery).getSingleResult();
}


}

