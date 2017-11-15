package com.example.sealing.service;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.example.sealing.cinfig.ReplacementCsvDataSetLoader;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners({
    DependencyInjectionTestExecutionListener.class,
    TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class })
@DbUnitConfiguration(dataSetLoader = ReplacementCsvDataSetLoader.class)
@Transactional
public class PlayerServiceTest {
    private final String PATH = "/fixtures/PlayerService";

    @Autowired
    private PlayerService playerService;

    @Test
    @DatabaseSetup(PATH + "/setup/")
    @ExpectedDatabase(value=PATH + "/expected/", assertionMode=DatabaseAssertionMode.NON_STRICT)
    public void playerが4件保存される場合4件取得できること() throws Exception {
        assertThat(playerService.findAll().size(), is(4));
    }

}
