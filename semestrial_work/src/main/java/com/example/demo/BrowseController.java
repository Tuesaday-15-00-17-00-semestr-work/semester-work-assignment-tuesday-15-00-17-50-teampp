package com.example.demo;

import com.example.demo.book.Book;
import com.example.demo.book.BooksDat;
import com.example.demo.book.GlobalId;
import com.example.demo.transactions.TransactionsDat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class BrowseController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField title;

    @FXML
    private Label author;
    @FXML
    private Label isbn;
    @FXML
    private Label available;
    @FXML
    private Label bought;

    String t, a;
    String value;
    /*
    private ValueToPass valueToPass;

    public BrowseController(ValueToPass valueToPass) {
        this.valueToPass = valueToPass;
    }
    */
    public void find(ActionEvent event) throws IOException {
        t = title.getText();

        BooksDat dat = new BooksDat();
        ArrayList<String> book = new ArrayList<>();
        book = dat.findBookByTitle(t);

        if(book.isEmpty()){
            bought.setText("No Book Found");
        }
        else {
            bought.setText("Book Found");
            author.setText(book.get(0));
            isbn.setText(book.get(1));
            available.setText(book.get(2));
        }
    }

    public void buy (ActionEvent event) throws IOException, SQLException {
        t = title.getText();

        BooksDat dat = new BooksDat();
        ArrayList<String> book = new ArrayList<>();
        book = dat.findBookByTitle(t);

        if(book.get(0) != null) {
            if(Integer.parseInt(book.get(2)) > 0) {
                int book_id = dat.FindId(t);
                int user_id = GlobalId.getInstance().getGlobalId();
                TransactionsDat transactionsDat = new TransactionsDat();
                transactionsDat.insertTransaction(book_id, user_id, "Bought");
                bought.setText("Successfully bought!");
                dat.Decrease(book_id);
            }
            else{
                bought.setText("Not available!");
            }
        }

    }

    public void back(ActionEvent event) throws IOException {
        if(GlobalData.getInstance().getGlobalValue() == "1"){
            back_admin(event);
        }
        else{
            back_user(event);
        }

    }

    public void back_admin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/BookActionsAdmin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void back_user(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/BookActionsUser.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
