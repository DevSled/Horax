package com.horax.timeManagement.infra.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserEntity {

	@Id
	private String id;
	@Column(length = 50, nullable = false)
	private String username;
	@Column(length = 70, nullable = false)
	private String email;
	@Column(length = 70, nullable = false)
	private String password;
//	@ManyToOne
//	@JoinColumn(name = "role_id")
//	private RoleEntity role;
//
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//	private Set<PortfolioEntity> portfolios = new HashSet<>();
//	@OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
//	private Set<TagEntity> tags = new HashSet<>();

	UserEntity() {
	}

	public UserEntity(String id, String username, String emailAddress, String password) {
		this.id = id;
		this.username = username;
		this.email = emailAddress;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null || getClass() != object.getClass())
			return false;

		UserEntity receivedEntity = (UserEntity) object;
		return (receivedEntity.id.equals(this.id) && receivedEntity.username.equals(this.username)
				&& receivedEntity.email.equals(this.email) && receivedEntity.password.equals(this.password));
	}
}
