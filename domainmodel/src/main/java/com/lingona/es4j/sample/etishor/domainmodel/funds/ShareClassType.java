package com.lingona.es4j.sample.etishor.domainmodel.funds;

public class ShareClassType {

    private TypeName name; // { get; private set; }

    public enum TypeName {
        Open,
        Closed
    };

    public ShareClassType(TypeName type) {
        this.name = type;
    }

    public static ShareClassType createFromString(String typeName) {
        TypeName name = (TypeName) Enum.valueOf(TypeName.class, typeName);
        return new ShareClassType(name);
    }

    public boolean isLinkable() {

        return this.name == TypeName.Open;

    }

    public TypeName getName() {
        return name;
    }
}

