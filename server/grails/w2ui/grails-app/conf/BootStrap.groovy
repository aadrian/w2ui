import com.w2ui.User

class BootStrap {

    def init = { servletContext ->
        User u1 = new User(fname: 'aaa',lname: 'aaa',email: 'aaa@aaa.com',login: 'aaa',password: 'aaa').save(failOnError: true)
        User u2 = new User(fname: 'bbb',lname: 'bbb',email: 'bbb@bbb.com',login: 'bbb',password: 'bbb').save(failOnError: true)
        User u3 = new User(fname: 'ccc',lname: 'ccc',email: 'ccc@ccc.com',login: 'ccc',password: 'ccc').save(failOnError: true)
        User u4 = new User(fname: 'ddd',lname: 'ddd',email: 'ddd@ddd.com',login: 'ddd',password: 'ddd').save(failOnError: true)
        User u5 = new User(fname: 'eee',lname: 'eee',email: 'eee@eee.com',login: 'eee',password: 'eee').save(failOnError: true)
        User u6 = new User(fname: 'fff',lname: 'fff',email: 'fff@fff.com',login: 'fff',password: 'fff').save(failOnError: true)
        User u7 = new User(fname: 'ggg',lname: 'ggg',email: 'ggg@ggg.com',login: 'ggg',password: 'ggg').save(failOnError: true)
        User u8 = new User(fname: 'hhh',lname: 'hhh',email: 'hhh@hhh.com',login: 'hhh',password: 'hhh').save(failOnError: true)
        User u9 = new User(fname: 'iii',lname: 'iii',email: 'iii@iii.com',login: 'iii',password: 'iii').save(failOnError: true)
    }
    def destroy = {
    }
}
