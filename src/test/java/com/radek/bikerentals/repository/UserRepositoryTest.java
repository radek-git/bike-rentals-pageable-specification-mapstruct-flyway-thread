package com.radek.bikerentals.repository;

import com.radek.bikerentals.entity.User;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.PersistenceException;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldSaveUserInDB() {
        //given
        User user = new User("Jan", "Nowak", "jnowak", "dupa", "11111111111", new BigDecimal("10.50"));


        //when
        testEntityManager.persistAndFlush(user);


        //then
        Optional<User> testUser = userRepository.findById(user.getId());
        assertEquals(true, testUser.isPresent());
        assertEquals("Jan", testUser.get().getName());
        assertEquals("Nowak", testUser.get().getSurname());
        assertEquals("jnowak", testUser.get().getUsername());
        assertEquals("dupa", testUser.get().getPassword());
        assertEquals("10.50", testUser.get().getBalance().toString());
    }


    @Test
    public void shouldFindUserByUsername() {
        //given
        User user = new User("Jan", "Nowak", "jnowak", "dupa", "11111111111",
                new BigDecimal("10.50"));

        //when
        testEntityManager.persistAndFlush(user);

        //then
        Optional<User> testUser = userRepository.findByUsername("jnowak");
        assertEquals(true, testUser.isPresent());
        assertEquals("Jan", testUser.get().getName());
        assertEquals("Nowak", testUser.get().getSurname());
        assertEquals("jnowak", testUser.get().getUsername());
        assertEquals("dupa", testUser.get().getPassword());
        assertEquals("10.50", testUser.get().getBalance().toString());

    }


    //ten sposób do JUnit4 włącznie
    @Test(expected = PersistenceException.class)
    public void shouldThrowExceptionWhenSaveUserWithTheSamePesel() {
        User user1 = new User("Jan", "Nowak", "jnowak", "dupa", "11111111111",
                new BigDecimal("10.50"));

        User user2 = new User("Jana", "Nowaka", "jnowaka", "dupa", "11111111111",
                new BigDecimal("10.50"));


        testEntityManager.persistAndFlush(user1);
        testEntityManager.persistAndFlush(user2);
    }


    //zgodnie z JUnit5
    @Test
    public void shouldThrowExceptionWhenSaveUserWithTheSamePesel1() {
        User user1 = new User("Jan", "Nowak", "jnowak", "dupa", "11111111111",
                new BigDecimal("10.50"));

        User user2 = new User("Jana", "Nowaka", "jnowaka", "dupa", "11111111111",
                new BigDecimal("10.50"));


        testEntityManager.persistAndFlush(user1);

        assertThrows(PersistenceException.class, () -> {
            testEntityManager.persistAndFlush(user2);
        });

    }


    @Test
    public void shouldThrowExceptionWhenSaveUsersWithTheSameUsername () {
        User user1 = new User("Jan", "Nowak", "jnowak", "dupa", "11111111111",
                new BigDecimal("10.50"));

        User user2 = new User("Jana", "Nowaka", "jnowak", "dupa", "21111111111",
                new BigDecimal("10.50"));

        testEntityManager.persistAndFlush(user1);
        assertThrows(PersistenceException.class, () -> {
            testEntityManager.persistAndFlush(user2);
        });

    }






}
