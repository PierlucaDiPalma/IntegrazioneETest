module com.example.integrazioneetest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.integrazioneetest to javafx.fxml;
    exports com.example.integrazioneetest;
}