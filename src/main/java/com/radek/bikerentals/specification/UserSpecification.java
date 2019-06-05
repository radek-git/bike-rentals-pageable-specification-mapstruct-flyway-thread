package com.radek.bikerentals.specification;

import com.radek.bikerentals.entity.User;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({
        @Spec(path = "name", spec = Equal.class),
        @Spec(path = "surname", spec = Equal.class),
        @Spec(path = "username", spec = Equal.class)
})
public interface UserSpecification extends Specification<User> {
}
