package com.buseni.calcappadmin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	MockMvc mvc;

	@Test
	public void projectsWhenNoTokenThenUnauthorized(){

	}
	@Test
	public void projectsWhenNoScopesThenForbidden() throws Exception {
		this.mvc.perform(get("/api/projects")
		.with(jwt()))
		.andExpect(status().isForbidden());

	}
	@Test
	public void projectsWhenWrongScopesThenForbidden() throws Exception {
		this.mvc.perform(get("/api/projects")
		.with(jwt().authorities(new SimpleGrantedAuthority("SCOPE_users"))))
		.andExpect(status().isForbidden());

	}

	@Test
	public void projectsWhenGoodScopesThenForbidden() throws Exception {
		this.mvc.perform(get("/api/projects")
						.with(jwt().jwt(j -> j
						.claim("userId", "1233")
						.claim("scope","projects"))))
						.andExpect(status().isOk());

	}

}
