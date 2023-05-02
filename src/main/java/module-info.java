module br.com.fatec.n2_poo_pokemenu {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens br.com.fatec.n2_poo_pokemenu to javafx.fxml;
    exports br.com.fatec.n2_poo_pokemenu;
}