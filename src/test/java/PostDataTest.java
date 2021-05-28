import com.mysql.cj.protocol.Resultset;
import com.steve.self_facebook.DOA.PostDatabase;
import com.steve.self_facebook.DOA.UserDatabase;
import com.steve.self_facebook.model.Post;
import com.steve.self_facebook.model.User;
import com.steve.self_facebook.utilities.ConnectionManager;
import com.steve.self_facebook.utilities.Encryption;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.sql.*;

public class PostDataTest {

    private Connection connection;
    UserDatabase userDatabase = null;

    public Connection getConnection() {
        connection = ConnectionManager.getConnection();
        return connection;
    }

    private User user1;
    private User user2;
    private Post post;
    PostDatabase postDatabase = null;

    public User getUser1() {
        user1 =new User();
        user1.setFirstname("Olorode");
        user1.setLastname("Emmanuel");
        user1.setEmail("emmanuel@gmail.com");
        String encr =  Encryption.encryptPassword("1234567890");
        user1.setPassword(encr);
        user1.setDob("2021-05-19 00:00:00");
        user1.setGender("Female");
        return user1;
    }

    public User getUser2() {
        user2 = new User();
        user2.setFirstname("Folarin");
        user2.setLastname("Oluwamayowa");
        user2.setEmail("damola@gmail.com");
        String encr =  Encryption.encryptPassword("1234567890");
        user2.setPassword(encr);
        user2.setPassword("123456");
        user2.setDob("2018-04-19 00:00:00");
        user2.setGender("Male");
        return user2;
    }

    public Post getPost() {
        post = new Post();
        post.setBody("For testing");
        post.setName("Tosin");
        post.setImageName("dsf");
        post.setTitle("Testing");
        return post;
    }

    @Test
    public void createPostTest(){

        boolean b = postDatabase.createPost(1,post);
        assertTrue(b);
    }
//    @Test
//    public void getPosts(){
//        postDatabase = new PostDatabase(getConnection());
//        assertNotNull(postDatabase.getPosts());
//
//    }


    @Test
    public void getAllComments() {
        postDatabase = new PostDatabase(getConnection());
        assertNotNull(postDatabase.getAllComments(1));

    }
    @Test
    public void makeComment(){
        postDatabase = new PostDatabase(getConnection());

        int uderId= 1;
        int postID  = 4;
        String comment = "Hello Unit Testing";
        assertTrue(postDatabase.makeComment(1,4,comment));

    }


    //Ensure the right postId and userID
    @Test
    public void testDeletePost() throws SQLException {
        postDatabase = new PostDatabase(getConnection());
        assertTrue(PostDatabase.deletePost(11, 1));

    }
}
