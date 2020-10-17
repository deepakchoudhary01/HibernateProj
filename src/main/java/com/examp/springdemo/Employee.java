package com.examp.springdemo;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Employee {
		
		@Id
		@Column(name="eid")
		private int id;
		private EmployeeName ename;
		private String email;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public EmployeeName getEname() {
			return ename;
		}
		public void setEname(EmployeeName ename) {
			this.ename = ename;
		}
		@Override
		public String toString() {
			return "Employee [id=" + id + ", ename=" + ename + ", email=" + email + "]";
		}
		
		
		
}
