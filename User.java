public class User extends Admin{

private String name;
private String email;
private int age;
private int memberID;

public String getName() {
    return name;
}


public String getEmail() {
    return email;
}


public int getAge() {
    return age;
}


public int getMemberID() {
    return memberID;
}


public void setName( String name) {
    this.name = name;
}


public void setEmail(String email) {
    this.email = email;
}


public void setAge(int age) {
    this.age = age;
}


public void setMemberID(int memberID) {
    this.memberID = memberID;
}


}
