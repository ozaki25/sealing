package com.example.sealing.service;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.sealing.entity.Player;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleServiceTest {
    @Autowired
    private SampleService service;
    @Autowired
    private PlayerService playerService;

    @Before
    public void seetup() {
        for(Player p : playerService.findAll()) playerService.delete(p.getId());
        Player p1 = new Player("ozaki", "ozaki", "password");
        Player p2 = new Player("fujita", "fujita", "password");
        playerService.save(p1);
        playerService.save(p2);
    }

    @Test
    @WithUserDetails("ozaki")
    public void ozakiでログインしている場合ozakiが返る() throws Exception {
        assertThat(service.getUsername(), is("ozaki"));
    }

    @Test
    @WithUserDetails("fujita")
    public void fujitaでログインしている場合fujitaが返る() throws Exception {
        assertThat(service.getUsername(), is("fujita"));
    }

    @Test
    public void ログインしていない場合anonymousが返る() throws Exception {
        assertThat(service.getUsername(), is("anonymous"));
    }
}
