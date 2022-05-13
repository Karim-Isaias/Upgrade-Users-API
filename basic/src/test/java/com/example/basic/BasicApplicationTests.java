package com.example.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.eclipse.sisu.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.basic.Controllers.ProfilesController;
import com.example.basic.Controllers.ProfilesControllerImpl;
import com.example.basic.Controllers.UsersController;
import com.example.basic.Controllers.UsersControllerImpl;
import com.example.basic.Entities.Profile;
import com.example.basic.Entities.Users;
import com.example.basic.Services.ProfileService;
import com.example.basic.Services.UsersService;
import com.example.basic.Services.UsersServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@SuppressWarnings("rawtypes")
@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class BasicApplicationTests {
	
	private MockMvc mockMvc;
	
	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();
	
	@InjectMocks
	private ProfilesControllerImpl profilesController;
	@InjectMocks
	private UsersControllerImpl usersController;
	
	@Mock
	private ProfileService profileService;
	@Mock
	private UsersService userService;
	
	@MockBean
	private UsersServiceImpl usrSrv;
	
	@BeforeAll
	void setUp() {
		MockitoAnnotations.openMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(usersController).build();
	}
	
	Users user_1 = new Users("user1",1234,"user1",new Profile("profile1"),1,"active","01-01-2022","01-01-2022","true");
	Users user_2 = new Users("user2",1234,"user2",new Profile("profile2"),1,"active","01-01-2022","01-01-2022","true");
	Users user_3 = new Users("user3",1234,"user3",new Profile("profile3"),1,"active","01-01-2022","01-01-2022","true");
	/*
	CompletableFuture<List<Users>> record = new ArrayList<>(Arrays.asList(user_1,user_2,user_3));
	@Test
	void contextLoads() {
	}
	
	@Test
	public void GetAllMappingSucess() throws Exception {
		
		Mockito.when(userService.Getall()).thenReturn( record);
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/client/")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].username", is(user_1.getUsername())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].username", is(user_1.getUsername())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[2].username", is(user_1.getUsername())));
	}
	 */
	
    @Test
    public void allUserTest() throws Exception {

        List<Users> all = new ArrayList<Users>();
        all.add(user_1);
        all.add(user_2);

        given(usrSrv.Getall())
                .willReturn(
                        CompletableFuture.completedFuture(all)
                );
        //when


        String expected = "";

        this.mockMvc.perform(get("http://localhost:9090/api/v1/users/").accept(MediaType.APPLICATION_JSON) )
                .andDo(print())
                .andExpect(content().string(expected))
                .andExpect(status().is2xxSuccessful())
        ;
        //then

    }

}
