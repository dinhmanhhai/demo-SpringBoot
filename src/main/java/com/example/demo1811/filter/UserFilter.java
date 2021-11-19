package com.example.demo1811.filter;

import com.example.demo1811.entity.UserTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component()
public class UserFilter {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory
            .getLogger(UserTest.class);

    public Specification<UserTest> filter(Integer id, Map<String, String> sort) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("id"), id));
            if (sort != null && !sort.isEmpty()) {
                List<Order> orderList = new ArrayList<>();
                Set<String> keySet = sort.keySet();
                for (String key : keySet) {
                    String orderType = sort.get(key);
                    switch (key) {
                        case "name":
                            if (orderType.equals("asc")) {
                                orderList.add(criteriaBuilder.asc(root.get("name")));
                            } else {
                                orderList.add(criteriaBuilder.desc(root.get("name")));
                            }
                            break;
                        case "url":
                            if (orderType.equals("asc")) {
                                orderList.add(criteriaBuilder.asc(root.get("url")));
                            } else {
                                orderList.add(criteriaBuilder.desc(root.get("url")));
                            }
                            break;
                        case "method":
                            if (orderType.equals("asc")) {
                                orderList.add(criteriaBuilder.asc(root.get("method")));
                            } else {
                                orderList.add(criteriaBuilder.desc(root.get("method")));
                            }
                            break;
                        case "status":
                            if (orderType.equals("asc")) {
                                orderList.add(criteriaBuilder.asc(root.get("status")));
                            } else {
                                orderList.add(criteriaBuilder.desc(root.get("status")));
                            }
                            break;
                        default:
                            if (orderType.equals("asc")) {
                                orderList.add(criteriaBuilder.asc(root.get(key)));
                            } else {
                                orderList.add(criteriaBuilder.desc(root.get(key)));
                            }
                    }
                }
                criteriaQuery.orderBy(orderList);
            }
            criteriaQuery.distinct(true);
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
