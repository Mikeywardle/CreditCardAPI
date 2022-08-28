package com.PublicSpaientInterview.CreditCardAPI.Data;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * POJO Object to store the details of a credit card account. Uses Project lombok to generate the Getters, setters, builder
 * and constructors. Is annotated to be used in the JPA repository (Using the ID as a primary key)
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CreditCardInfo
{
    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;

    private String name;
    private String cardNumber;
    private double balance;
    private double cardLimit;

    @Override
    public String toString() {
        //Using GSON to parse data to string, this should future-proof this function from future data chages
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        return gson.toJson(this);
    }
}
