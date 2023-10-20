module co.edu.upb.oasis.moduloadministrador {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;


    opens co.edu.upb.oasis to javafx.fxml;
    exports co.edu.upb.oasis;
}