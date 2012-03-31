package com.lingona.es4j.sample.etishor.domainmodel.people;

//using System;
//using System.Collections.Generic;
//using System.Linq;
//using System.Text;
/// <summary>
/// Value object representing the name of the person
public class PersonName {
    
    private String value; // { get; private set; }

    public PersonName(String name) {
        this.value = name;
    }

    public String getValue() {
        return value;
    }
}
