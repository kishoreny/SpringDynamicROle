package com.exp.dynamicroles.model;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

 
@Entity
@Table(name = "role")
public class Role implements java.io.Serializable {

	 
	private static final long serialVersionUID = 1L;
	private Integer roleId;
	private String roleName;
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);
	private Set<RoleAction> roleActions = new HashSet<RoleAction>(0);

	public Role() {
	}

	public Role(String roleName, Set<UserRole> userRoles,
			Set<RoleAction> roleActions) {
		this.roleName = roleName;
		this.userRoles = userRoles;
		this.roleActions = roleActions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ROLE_ID", unique = true, nullable = false)
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "ROLE_NAME", length = 20)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	public Set<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	public Set<RoleAction> getRoleActions() {
		return this.roleActions;
	}

	public void setRoleActions(Set<RoleAction> roleActions) {
		this.roleActions = roleActions;
	}

}
