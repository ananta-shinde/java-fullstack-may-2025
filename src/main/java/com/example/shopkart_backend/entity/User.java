package com.example.shopkart_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "users")
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private String id;
   @Column(nullable = false)
   private String name;
   @Column(nullable = false,unique = true)
   private String email;
   @Column(nullable = false)
   private String password;
   @CreationTimestamp
   private LocalDateTime created_at;
   @UpdateTimestamp
   private LocalDateTime update_at;

   private boolean isActive = true;

   public boolean isActive() {
      return isActive;
   }

   public void setActive(boolean active) {
      isActive = active;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public LocalDateTime getCreated_at() {
      return created_at;
   }

   public void setCreated_at(LocalDateTime created_at) {
      this.created_at = created_at;
   }

   public LocalDateTime getUpdate_at() {
      return update_at;
   }

   public void setUpdate_at(LocalDateTime update_at) {
      this.update_at = update_at;
   }
}
