package com.hilquiascamelo.servicesTest;

import com.hilquiascamelo.models.Categoria;
import com.hilquiascamelo.models.Produto;
import com.hilquiascamelo.models.Users;
import com.hilquiascamelo.models.enums.Profile;
import com.hilquiascamelo.models.enums.UserType;
import com.hilquiascamelo.services.BancoSeedService;
import com.hilquiascamelo.services.UserService;
import com.hilquiascamelo.services.execeptions.DataIntegrityException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class UserServiceTest {

    Categoria categoria20 = new Categoria(null, "Snacks");

    Produto produto = new Produto(null,"Napoli", 52.20,new Date(),
            null , 1, 500.00, "Delicious pizza" );

    Produto produto1 = new Produto(null,"Pepperoni", 52.20, new Date(),
            null , 1, 500.00, "Delicious pizza" );

    Produto produto2 = new Produto(null,"Pepperoni Pie with Cheese", 12.50, new Date(),
            null , 1, 100.00, "Delicious and very filling");

    @Autowired
    private BCryptPasswordEncoder pe;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Autowired
    private BancoSeedService bancoSeedService;
    @Bean
    public boolean instantiateDatabase() throws ParseException {

        if (!"create".equals(strategy)) {
            return false;
        }

        bancoSeedService.instantiateTestDatabase();
        return true;
    }
    Users users = null;
    UserService userService = null;
    @BeforeEach
    public void setUp() {
        users = new Users();
    }

    @Test
    Users find() throws Exception {
       Users user = userService.find(1);
       return user ;
    }

    @Test
    void delete() throws NullPointerException{
        assertThrows(java.lang.NullPointerException.class, () -> userService.delete(null),
                "Must return a NullPointerException when null");
    }

    @Test
    void findAll() {
    }

    @Test
    void insert() {
//        Users users = new Users(null, "Hilquias", pe.encode("123"), "hilquiaswpc10@outlook.com", UserType.DIRECTOR, true);
//        users.addProfile(Profile.USER);
    }

    @Test
    void fromDTO() {
    }

    @Test
    void update() {
    }

    @Test
    void testFind() {
    }

    @Test
    void testDelete() {
    }

    @Test
    void testFindAll() {
    }

    @Test
    void testInsert() {
    }

    @Test
    void testFromDTO() {
    }

    @Test
    void testUpdate() {
    }
}