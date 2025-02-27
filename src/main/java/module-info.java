module tech.morbit {

    //javaFX stuff
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;
    requires javafx.media;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;



    requires kotlin.stdlib;
    requires jdk.jsobject;
    requires org.json;
    requires jdk.jdi;
    requires java.desktop;
    requires java.sql;
    requires annotations;


    exports tech.morbit.App;
    exports tech.morbit.Character;
    exports tech.morbit.Exception;
    exports tech.morbit.Tools;
    exports tech.morbit.Quality;
    exports tech.morbit.Controller;

    opens tech.morbit.Controller;
    opens tech.morbit.App to javafx.fxml;

}
