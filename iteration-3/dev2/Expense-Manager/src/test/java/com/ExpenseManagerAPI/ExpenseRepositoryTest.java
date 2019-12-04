package com.ExpenseManagerAPI;

import com.ExpenseManagerAPI.domain.Expense;
import com.ExpenseManagerAPI.repositories.ExpenseRepository;
import com.ExpenseManagerAPI.service.expense.ExpenseService;
import com.ExpenseManagerAPI.service.expense.ExpenseServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest
public class ExpenseRepositoryTest {

    @TestConfiguration
    static class ExpenseServiceImplTestContextConfiguration {

        @Bean
        public ExpenseService expenseService() {
            return new ExpenseServiceImpl();
        }
    }

    @Autowired
    private ExpenseService expenseService;

    @Mock
    private ExpenseRepository expenseRepository;

    @Before
    public void setUp() {
        Expense expense = new Expense();
        expense.setId("1");

        expenseRepository.save(expense);
        Mockito.when(expenseRepository.findById(expense.getId()))
                .thenReturn(expense);
    }

    @Test
    public void whenValidId_thenExpenseShouldBeFound() {
        String id = "1";

        Expense found = expenseRepository.findById(id);

        assertThat(found.getId())
                .isEqualTo(id);
    }

}
