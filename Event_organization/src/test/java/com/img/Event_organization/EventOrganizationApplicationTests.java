package com.img.Event_organization;

import com.img.Event_organization.entity.Player;
import com.img.Event_organization.exception.AlreadyTeamFilledException;
import com.img.Event_organization.exception.CollegeNotAllowedException;
import com.img.Event_organization.exception.InvalidEmailException;
import com.img.Event_organization.exception.InvalidMobileNumberException;
import com.img.Event_organization.repository.PlayerRepository;
import com.img.Event_organization.service.PlayerService;
import com.img.Event_organization.service.PlayerServiceImp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventOrganizationApplicationTests {
    @InjectMocks
    private PlayerServiceImp playerService;

    private Player player;
    private Player player1;
    @Mock
    private PlayerRepository playerRepository;

    @BeforeEach
    public void init() {
        player = new Player("Srinivas", 25, "Gvp", "9999999999", "srinivas@gmail.com", 10);
    }


    @AfterEach
    public void drop() {
        playerRepository.deleteAll();
    }

    @Test
    public void add() throws InvalidMobileNumberException, InvalidEmailException, AlreadyTeamFilledException, CollegeNotAllowedException {
        when(playerRepository.save(player)).thenReturn(player);
        player1 = playerService.registerPlayer(player);
        assertNotNull(player1);
        assertEquals("Srinivas", player1.getPlayer_name());
    }

}
