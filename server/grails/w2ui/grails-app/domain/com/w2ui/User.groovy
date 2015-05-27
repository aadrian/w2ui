package com.w2ui

class User {
    String fname
    String lname
    String email
    String login
    String password

    Date   dateCreated
    Date   lastUpdated
    static constraints = {
        fname       nullable: true
        lname       nullable: true
        email       nullable: true
        login       nullable: false, blank: false
        password    nullable: false, blank: false

        dateCreated nullable: true
        lastUpdated nullable: true
    }
}
