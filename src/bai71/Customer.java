package bai71;

import java.util.Date;

public class Customer {
    private String name;
    private boolean member = false;
    private String memberType = "";

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String type) {
        if (type != null) {
            this.memberType = type;
        } else {
            this.memberType = ""; // Ensure it's never null
        }
    }

    @Override
    public String toString() {
        return "Customer[name=" + name + ", member=" + member + ", memberType=" + memberType + "]";
    }
}