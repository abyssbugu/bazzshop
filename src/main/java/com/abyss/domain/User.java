package com.abyss.domain;

/**
 * Created by Abyss on 2018/4/20.
 * description:
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String sex;
    private String description;
    private String address;
    private String hobby;
    private String email;
    private Integer age;
    private Product product;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", hobby='" + hobby + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", product=" + product +
                '}';
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
