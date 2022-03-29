package com.example.football.util;

import java.nio.file.Path;

public class Paths {
    private static final String PATH_OF_FILES = Path.of("src","main","resources","files").toString();

    public static final Path JSON_TOWNS = Path.of(PATH_OF_FILES,"json","towns.json").toAbsolutePath();
    public static final Path JSON_TEAMS = Path.of(PATH_OF_FILES,"json","teams.json").toAbsolutePath();
    public static final Path XML_PLAYERS = Path.of(PATH_OF_FILES,"xml","players.xml").toAbsolutePath();
    public static final Path XML_STATS = Path.of(PATH_OF_FILES,"xml","stats.xml").toAbsolutePath();
}
