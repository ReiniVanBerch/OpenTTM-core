module tech.morbit {

    requires jdk.jsobject;
    requires org.json;
    requires jdk.jdi;
    requires java.desktop;
    requires java.sql;


    exports tech.morbit.App;
    exports tech.morbit.Character;
    exports tech.morbit.Exception;
    exports tech.morbit.Tools;
    exports tech.morbit.Quality;
    exports tech.morbit.Tag;
    exports tech.morbit.Functional;
}
