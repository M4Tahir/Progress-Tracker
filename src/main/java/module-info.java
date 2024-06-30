module dev.mt.progresstracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires eu.hansolo.tilesfx;
    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;

    opens dev.mt.progresstracker to javafx.fxml;
    exports dev.mt.progresstracker;
    exports dev.mt.progresstracker.controllers;
    exports dev.mt.progresstracker.logging;
    exports dev.mt.progresstracker.utils;


}