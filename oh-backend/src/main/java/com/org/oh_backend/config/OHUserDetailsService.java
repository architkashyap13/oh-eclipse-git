package com.org.oh_backend.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.org.oh_backend.Model.OHUser;
import com.org.oh_backend.Model.OHUserProfile;
import com.org.oh_backend.Service.OHUserService;

public class OHUserDetailsService implements UserDetailsService {

	@Autowired
	private OHUserService userService;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		OHUser user = userService.findByUserName(userName);
		System.out.println("User : " + user);
		if (user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				user.getStatus().equals("Active"), true, true, true, getGrantedAuthorities(user));
	}

	private List<GrantedAuthority> getGrantedAuthorities(OHUser user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (OHUserProfile userProfile : user.getUserProfiles()) {
			System.out.println("UserProfile : " + userProfile);
			authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
		}
		System.out.print("authorities :" + authorities);
		return authorities;
	}

	// @Override
	// public UserDetails loadUserByUsername(String userName)
	// throws UsernameNotFoundException {
	// UserInfo activeUserInfo = userInfoDAO.getActiveUser(userName);
	// GrantedAuthority authority = new
	// SimpleGrantedAuthority(activeUserInfo.getRole());
	// UserDetails userDetails = (UserDetails)new
	// User(activeUserInfo.getUserName(),
	// activeUserInfo.getPassword(), Arrays.asList(authority));
	// return userDetails;
	// }
}