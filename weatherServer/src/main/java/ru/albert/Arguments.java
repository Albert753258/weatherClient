package ru.albert;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;


@Parameters(separators = " ")
class Arguments {

    @Parameter(names = {"--port", "-p"})
    public int port;
}
