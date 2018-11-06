package com.lch.spring.boot.springbootlesson8.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * <p></p>
 *
 * @author lichanghong     create by   2018/9/7 14:23
 **/
@Entity
public class Customer  implements Serializable {

    private static final long serialVersionUID = 3616224483716428870L;
    private Long id;
    private String name;
    private Address address;
    private Collection<Order> orders;
    private Set<PhoneNumber> phones;
    //无参构造函数
    public Customer() {
    }
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    @OneToMany
    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }
    @ManyToMany
    public Set<PhoneNumber> getPhones() {
        return phones;
    }

    public void setPhones(Set<PhoneNumber> phones) {
        this.phones = phones;
    }

    public void addPhone(PhoneNumber phone){
        this.getPhones().add(phone);
    }
}
