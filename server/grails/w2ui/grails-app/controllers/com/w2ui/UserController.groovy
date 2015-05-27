package com.w2ui

class UserController {
    // We don't scaffold the controller
    // static scaffold = User
    def index() { }

    def list() {
        // params:
        //params.cmd
        //params.limit
        //params.offset

        def users = User.list()
        render(contentType: "application/json"){
            status = "success"
            total = User.count()
            records = array {
                for(u in users) {
                    user(recid:u.id,fname:u.fname,lname:u.lname,email:u.email,login:u.login,password:u.password)
                }
            }
        }
    }

    def edit() {
        // params:
        //params.cmd
        //params.recid

        def recid = params.recid as long
        def u = User.findById(recid)
        if(u!=null) {
            render(contentType: "application/json"){
                status = "success"
                record(recid:u.id,fname:u.fname,lname:u.lname,email:u.email,login:u.login,password:u.password)
            }
        }
    }

    def w2ui() {
        def cmd = params.cmd

        println "Executing command:'"+cmd+"'"
        println "   with params:"+params
        switch (cmd){
            case 'get-records':
                // get parameters
                params.limit
                params.offset
                // convert parameters to a Grails required Form
                def users = User.list()
                render(contentType: "application/json"){
                    status = "success"
                    total = User.count()
                    records = array {
                        for(u in users) {
                            user(recid:u.id,fname:u.fname,lname:u.lname,email:u.email,login:u.login,password:u.password)
                        }
                    }
                }
                break;
            case 'delete-records':
                def selected = params.list("selected[]")
                println "Selected 4 delete:"+selected
                for(int i=0;i<selected.size();i++) {
                    def user = User.findById(selected.get(i) as Long)
                    if(user!=null) {
                        user.delete()
                    }
                    else {
                        handleError("User with ID:"+selected.get(i)+" can't be deleted!")
                        return
                    }
                }
                render(contentType: "application/json"){
                    status = "success"
                    message = ""
                }
                break;
            case 'get-record':
                def recid = params.recid as long
                def u = User.findById(recid)
                if(u!=null) {
                    render(contentType: "application/json"){
                        status = "success"
                        record(recid:u.id,fname:u.fname,lname:u.lname,email:u.email,login:u.login,password:u.password)
                    }
                } else {
                    handleError("User with ID:"+recid+" can't be found!")
                }
                break;
            case 'save-record':
                def recid = params.recid as long
                def userFields = ["fname":String, "lname":String, "email":String, "login":String, "password":String]
                // we have a new user
                if(recid == 0) {
                    // we have a new object
                    fetchParamMap(params,userFields)
                } else {
                    // the object already exists, so we update it
                    fetchParamMap(params,userFields)
                }
                render(contentType: "application/json"){
                    status = "success"
                    message = ""
                }
                break;
            default:
                handleError("Command '"+cmd+"' is not recognized!")
                break;

        }
    }

    def private handleError(String msg) {
        render(contentType: "application/json"){
            status = "error"
            message = msg
        }
    }

    def private fetchParamMap(Map params,Map fields){
        def result = [:]
        return result;
    }
}
