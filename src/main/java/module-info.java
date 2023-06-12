module br.com.fatec.n2_poo_pokemenu {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens br.com.fatec.n2_poo_pokemenu to javafx.fxml;
    exports br.com.fatec.n2_poo_pokemenu;
    exports br.com.fatec.n2_poo_pokemenu.controller;
    opens br.com.fatec.n2_poo_pokemenu.controller to javafx.fxml;
    opens br.com.fatec.n2_poo_pokemenu.model.domain to javafx.base;
}